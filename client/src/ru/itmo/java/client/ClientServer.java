package ru.itmo.java.client;

import com.google.protobuf.ByteString;
import ru.itmo.java.message.WriteTask;
import ru.itmo.java.message.tracker.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientServer implements AutoCloseable {
    private final ExecutorService workerPool = Executors.newCachedThreadPool();
    ServerSocket serverSocket;
    ClientState clientState;

    public ClientServer(ClientState clientState, ServerSocket serverSocket) {
        this.clientState = clientState;
        this.serverSocket = serverSocket;
        workerPool.submit(this::run);
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                workerPool.submit(new ClientToClientWorker(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientToClientWorker implements Runnable {
        private final Socket socket;
        private final ExecutorService writePool = Executors.newSingleThreadExecutor();

        private ClientToClientWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket = this.socket){
                while (true) {
                    BaseRequest baseRequest = BaseRequest.parseDelimitedFrom(socket.getInputStream());
                    switch (baseRequest.getRequestCase()) {
                        case STATREQUEST -> handle(baseRequest.getStatRequest());
                        case GETREQUEST -> handle(baseRequest.getGetRequest());
                        case REQUEST_NOT_SET -> System.err.println("Bad request");
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while receiving a request from a client");
            }
        }

        private void handle(StatRequest statRequest) {
            StatResponse.Builder statResponse = StatResponse.newBuilder();

            long id = statRequest.getId();
            FileState fileState = clientState.getFileState(id);
            if (fileState != null) {
                FilePartsInfo partsInfo = fileState.getFilePartsInfo();
                statResponse.setNumParts(partsInfo.getNumCompleteParts())
                        .addAllCompleteParts(partsInfo.getParts())
                        .build();
            } else {
                statResponse.setNumParts(0).build();
            }

            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setStatResponse(statResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream())
            );
        }

        private void handle(GetRequest getRequest) {
            GetResponse.Builder getResponse = GetResponse.newBuilder();

            long id = getRequest.getId();
            long partId = getRequest.getPartId();

            FileState fileState = clientState.getFileState(id);
            if (fileState != null) {
                try {
                    ByteString partContent = fileState.getPartContent(partId);
                    getResponse.setContent(partContent).setCorrectRequestId(true).build();
                } catch (IOException e) {
                    System.out.println("Error while reading a part from a file");
                    getResponse.setCorrectRequestId(false).build();
                }
            } else {
                getResponse.setCorrectRequestId(false).build();
            }

            executeWriteTask(() -> BaseResponse.newBuilder()
                    .setGetResponse(getResponse)
                    .build()
                    .writeDelimitedTo(socket.getOutputStream()));
        }

        private void executeWriteTask(WriteTask task) {
            writePool.submit(() -> {
                try {
                    task.run();
                } catch (IOException e) {}
            });
        }
    }

    public int getServerPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void close() {
        workerPool.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("An error occurred while closing the socket server");
            e.printStackTrace();
        }
    }
}
