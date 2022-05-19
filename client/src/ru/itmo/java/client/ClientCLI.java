package ru.itmo.java.client;


import ru.itmo.java.message.Constants;
import ru.itmo.java.message.tracker.ClientInfo;
import ru.itmo.java.message.tracker.FileInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ClientCLI {
    private final String LIST_CMD = "list";
    private final String UPLOAD_CMD = "upload";
    private final String SOURCES_CMD = "sources";
    private final String DOWNLOAD_CMD = "download";
    private final String INFO_CMD = "info";
    private final String EXIT_CMD = "exit";
    private final Path workDir;
    private Scanner scanner;
    private TrackerCommunication trackerCommunication;
    private ClientState clientState;
    private ClientServer clientServer;
    private ClientUpdater clientUpdater;
    private DownloadServer downloadServer;

    public ClientCLI() {
        workDir = Paths.get(System.getProperty("user.dir"));
        System.out.println("WorkDir: " + workDir);

        scanner = new Scanner(System.in);
        initClientState();
        initTrackerCommunication();
        initClientServer();
        clientUpdater = new ClientUpdater(trackerCommunication, clientState, clientServer.getServerPort());
        downloadServer = new DownloadServer(trackerCommunication, clientState);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down client...");
            shutdown();
        }));
    }

    public static void main(String[] args) {
        System.out.println("Start client cli");
        new ClientCLI().run();
    }

    private void run() {
        System.out.println("Ready to work!");
        help();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if (command.equals(EXIT_CMD)) {
                System.exit(0);
            }
            execute(command.split("\\s+"));
        }
    }

    private void execute(String[] args) {
        String command = args[0];
        switch (command) {
            case LIST_CMD -> execListCmd();
            case UPLOAD_CMD -> execUploadCmd(args);
            case SOURCES_CMD -> execSourcesCmd(args);
            case DOWNLOAD_CMD -> execDownloadCmd(args);
            case INFO_CMD -> execInfoCmd();
            default -> help();
        }
    }

    private void execListCmd() {
        List<FileInfo> filesInfo = trackerCommunication.commandList();
        printFilesInfo(filesInfo);
    }

    private void execUploadCmd(String[] args) {
        Path filePath = readPath(args);
        if (filePath == null) {
            return;
        }
        FileInformation fileInformation = new FileInformation(-1, getFileName(filePath), getFileSize(filePath));
        long id = trackerCommunication.commandUpload(fileInformation);
        fileInformation.setId(id);
        FileState fileState = new FileState(fileInformation, filePath, new FilePartsInfo(fileInformation.getSize()));
        clientState.addNewFile(id, fileState);
        printUploadInfo(fileInformation);
    }

    private void execSourcesCmd(String[] args) {
        Long id = readId(args);
        if (id == null) {
            return;
        }
        List<ClientInfo> clientsInfo = trackerCommunication.commandSources(id);
        printClientsInfo(clientsInfo, id);
    }

    private void execDownloadCmd(String[] args) {
        Long id = readId(args);
        if (id == null) {
            return;
        }
        List<FileInfo> filesInfo = trackerCommunication.commandList();
        FileInfo fileInfo = getFileInfo(filesInfo, id);
        if (fileInfo == null) {
            System.out.println("This id: " + id + " does not exist on the tracker.");
            printFilesInfo(filesInfo);
            return;
        }

        FileState fileState;
        try {
            fileState = createFileStateForEmptyFile(fileInfo, id);
        } catch (IOException e) {
            System.out.println("Failed to create file for download");
            e.printStackTrace();
            return;
        }

        System.out.println("Start download: " + id + "_" + fileInfo.getName());
        downloadServer.downloadNewFile(fileState);
    }

    private void execInfoCmd() {
        printClientState();
    }

    private FileInfo getFileInfo(List<FileInfo> filesInfo, long id) {
        for (FileInfo fileInfo: filesInfo) {
            if (fileInfo.getId() == id) {
                return fileInfo;
            }
        }
        return null;
    }

    private FileState createFileStateForEmptyFile(FileInfo fileInfo, long id) throws IOException {
        FileInformation fileInformation = new FileInformation(id, fileInfo.getName(), fileInfo.getSize());
        FilePartsInfo filePartsInfo = new FilePartsInfo(fileInfo.getSize(), new HashSet<>());
        return clientState.addNewDownloadFile(id, fileInformation, filePartsInfo);
    }

    private void printFilesInfo(List<FileInfo> filesInfo) {
        String leftAlignFormat = "| %-52s | %-8d | %-20d |%n";

        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
        System.out.format("| Name                                                 | ID       | Bytes                |%n");
        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
        for (FileInfo fileInfo : filesInfo) {
            System.out.format(leftAlignFormat, fileInfo.getName(), fileInfo.getId(), fileInfo.getSize());
        }
        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
    }

    private void printClientsInfo(List<ClientInfo> clientsInfo, long id) {
        if (clientsInfo == null) {
            System.out.println("The file by id " + id + " number is not on the tracker.");
            return;
        }

        String leftAlignFormat = "| %-18s | %-8d |%n";

        System.out.println("ID: " + id);
        System.out.format("+-------------------------------+%n");
        System.out.format("| IP                 | PORT     |%n");
        System.out.format("+--------------------+----------+%n");

        for (ClientInfo clientInfo : clientsInfo) {
            System.out.format(leftAlignFormat, clientInfo.getIp(), clientInfo.getPort());
        }
        System.out.format("+--------------------+----------+%n");
    }

    private void printClientState() {
        String leftAlignFormat = "| %-52s | %-8d | %-20.2f |%n";

        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
        System.out.format("| Name                                                 | ID       | Loading percentage   |%n");
        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
        for (Map.Entry<Long, FileState> entry: clientState.getFiles().entrySet()) {
            FileState fileState = entry.getValue();
            System.out.format(leftAlignFormat, fileState.getFileName(), entry.getKey(), fileState.getPercentageDownloaded());
        }
        System.out.format("+------------------------------------------------------+----------+----------------------+%n");
    }

    private void printUploadInfo(FileInformation fileInformation) {
        System.out.println("The file information has been successfully added to the server");
        System.out.println("File Info:");
        System.out.println("Id: " + fileInformation.getId());
        System.out.println("Name:" + fileInformation.getName());
        System.out.println("Size: " + fileInformation.getSize());
    }

    private Long readId(String[] args) {
        if (args.length == 2) {
            try {
                long id = Long.parseLong(args[1]);
                return id;
            } catch (NumberFormatException ignored) {
            }
        }

        help();
        return null;
    }

    private Path readPath(String[] args) {
        if (args.length == 2) {
            Path file = Paths.get(args[1]);
            if (Files.exists(file) && Files.isRegularFile(file)) {
                return file;
            }
        }

        help();
        return null;
    }

    private long getFileSize(Path filePath) {
        try {
            return Files.size(filePath);
        } catch (IOException e) {
            System.out.println("Can't read the file size");
            e.printStackTrace();
        }
        return -1;
    }

    private String getFileName(Path filePath) {
        return filePath.getFileName().toString();
    }

    private void help() {
        System.out.println("Commands:");
        System.out.println(LIST_CMD);
        System.out.println(UPLOAD_CMD + " <file_name>");
        System.out.println(SOURCES_CMD + " <file_id>");
        System.out.println(DOWNLOAD_CMD + " <file_id>");
        System.out.println(INFO_CMD);
    }

    private void initClientState() {
        try {
            clientState = new ClientState(workDir);
        } catch (IOException e) {
            System.out.println("Failed to initialize directories for client state");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initTrackerCommunication(){
        try {
            System.out.println("\nTrying to connect to the tracker");
            Socket socket = new Socket(Constants.TRACKER_IP, Constants.PORT);
            trackerCommunication = new TrackerCommunication(socket);
            System.out.println("Successfully connected to the tracker");
        } catch (IOException e) {
            System.out.println("Failed to connect to the tracker. Check if the tracker is running.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initClientServer(){
        try {
            System.out.println("\nTrying to create ClientServer");
            ServerSocket serverSocket = new ServerSocket(0);
            clientServer = new ClientServer(clientState, serverSocket);
            System.out.println("Successfully created ClientServer");
        } catch (IOException e) {
            System.err.println("Could not start client_server socket");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void shutdown() {
        try {
            clientUpdater.close();
        } catch (Exception e) {
            System.out.println("clientUpdater.close();");
        }
        try {
            clientServer.close();
        } catch (Exception e) {
            System.out.println("clientServer.close();");
        }

        try {
            trackerCommunication.close();
        } catch (IOException e) {
            System.out.println("Failed to close the connection to the tracker.");
            e.printStackTrace();
        }
        clientState.close();
        scanner.close();
    }
}
