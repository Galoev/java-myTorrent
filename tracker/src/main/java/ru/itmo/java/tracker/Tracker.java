package ru.itmo.java.tracker;

import ru.itmo.java.message.Constants;
import ru.itmo.java.message.WriteTask;
import ru.itmo.java.message.tracker.*;
import ru.itmo.java.message.tracker.FileInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tracker {
    private final String STATE_FILE_NAME = "tracker_state.txt";
    private final ExecutorService workerPool = Executors.newCachedThreadPool();
    private ClientsController clientsController;
    private List<FileInfo> files;
    private Path stateFilePath;
    private long lastId = 0;

    public static void main(String[] args) {
        System.out.println("Start tracker server");
        new Tracker().run();
    }

    public Tracker() {
        init();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down tracker...");
            shutdown();
        }));
    }

    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(Constants.PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                workerPool.submit(new ClientWorker(socket));
            }
        } catch (IOException e) {
            System.err.println("Could not start server socket on port " + Constants.PORT);
            e.printStackTrace();
        }
    }

    private class ClientWorker implements Runnable {
        private final Socket socket;
        private final ExecutorService writePool = Executors.newSingleThreadExecutor();
        private Client client;

        private ClientWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String ipAndPort = null;
            try (Socket socket = this.socket){
                System.out.print("Client connected. ");
                ipAndPort= "IP: " + socket.getInetAddress().getHostAddress() + " PORT: " + socket.getPort();
                System.out.println(ipAndPort);
                client = new Client(socket.getInetAddress().toString());

                while (true) {
                    BaseRequest baseRequest = BaseRequest.parseDelimitedFrom(socket.getInputStream());
                    switch (baseRequest.getRequestCase()) {
                        case LISTREQUEST -> handle(baseRequest.getListRequest());
                        case UPLOADREQUEST -> handle(baseRequest.getUploadRequest());
                        case SOURCESREQUEST -> handle(baseRequest.getSourcesRequest());
                        case UPDATEREQUEST -> handle(baseRequest.getUpdateRequest());
                        case REQUEST_NOT_SET -> System.err.println("Bad request");
                    }
                }
            } catch (IOException e) {
                System.out.print("Client disconnected. ");
                System.out.println(ipAndPort);
            }
        }

        private void handle(ListRequest listRequest) {
            ListResponse listResponse;

            synchronized (files) {
                listResponse = ListResponse.newBuilder()
                        .setCount(files.size())
                        .addAllFiles(files)
                        .build();
            }

            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setListResponse(listResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream())
            );
        }

        private void handle(UploadRequest uploadRequest) {
            UploadResponse uploadResponse;

            synchronized (files) {
                FileInfo fileInfo = FileInfo.newBuilder()
                        .setId(lastId)
                        .setName(uploadRequest.getName())
                        .setSize(uploadRequest.getSize())
                        .build();

                clientsController.addNewSource(lastId, client);
                files.add(fileInfo);

                uploadResponse = UploadResponse.newBuilder()
                        .setId(lastId)
                        .setName(uploadRequest.getName())
                        .setSize(uploadRequest.getSize())
                        .build();

                lastId++;
            }

            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setUploadResponse(uploadResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream())
            );
        }

        private void handle(SourcesRequest sourcesRequest) {
            SourcesResponse.Builder sourcesResponse = SourcesResponse.newBuilder();
            List<Client> clients = clientsController.getSources(sourcesRequest.getId());
            if (clients == null) {
                sourcesResponse.setCorrectRequestId(false);
            } else {
                sourcesResponse.setSize(clients.size());
                sourcesResponse.setCorrectRequestId(true);
                List<ClientInfo> curClients = new ArrayList<>();
                for (int i = 0; i < clients.size(); i++) {
                    ClientInfo clientInfo = ClientInfo.newBuilder()
                            .setIp(clients.get(i).getIp())
                            .setPort(clients.get(i).getPort())
                            .build();
                    curClients.add(clientInfo);
                }
                sourcesResponse.addAllClients(curClients);
            }
            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setSourcesResponse(sourcesResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream())
            );
        }

        private void handle(UpdateRequest updateRequest) {
            client.setPort(updateRequest.getClientPort());
            clientsController.updateClient(updateRequest.getIdList(), client);
            UpdateResponse updateResponse = UpdateResponse.newBuilder().setStatus(true).build();
            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setUpdateResponse(updateResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream())
            );
        }

        private void executeWriteTask(WriteTask task) {
            writePool.submit(() -> {
                try {
                    task.run();
                } catch (IOException e) {}
            });
        }
    }

    private void init() {
        stateFilePath = Paths.get(System.getProperty("user.dir")).resolve(STATE_FILE_NAME);
        if (Files.exists(stateFilePath) && Files.isRegularFile(stateFilePath)) {
            try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(stateFilePath))) {
                lastId = dataInputStream.readLong();
                files = new ArrayList<>();
                long filesCount = dataInputStream.readLong();
                for (long i = 0; i < filesCount; i++) {
                    files.add(readFileInfo(dataInputStream));
                }
                clientsController = ClientsController.readClientsController(dataInputStream);
            } catch (IOException e) {
                System.out.println("Unable to read status file. Therefore, an empty state will be initialized.");
                files = new ArrayList<>();
                clientsController = new ClientsController();
            }
        } else {
            System.out.println("Unable to read status file. Therefore, an empty state will be initialized.");
            files = new ArrayList<>();
            clientsController = new ClientsController();
        }
    }

    private void save() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(stateFilePath))) {
            dataOutputStream.writeLong(lastId);
            dataOutputStream.writeLong(files.size());
            writeFilesInfo(dataOutputStream);
            clientsController.write(dataOutputStream);
        } catch (IOException e) {
            System.out.println("Unable to save tracker state. The state will not be saved.");
            e.printStackTrace();
        }
    }

    private FileInfo readFileInfo(DataInputStream dataInputStream) throws IOException {
        long id = dataInputStream.readLong();
        String name = dataInputStream.readUTF();
        long size = dataInputStream.readLong();
        return FileInfo.newBuilder().setId(id).setName(name).setSize(size).build();
    }

    private void writeFilesInfo(DataOutputStream dataOutputStream) throws IOException {
        for (FileInfo fileInfo : files) {
            dataOutputStream.writeLong(fileInfo.getId());
            dataOutputStream.writeUTF(fileInfo.getName());
            dataOutputStream.writeLong(fileInfo.getSize());
        }
    }

    private void shutdown() {
        workerPool.shutdown();
        save();
    }
}
