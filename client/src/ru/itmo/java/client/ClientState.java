package ru.itmo.java.client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ClientState implements AutoCloseable{
    private final String DOWNLOADS_DIR_NAME = "downloads";
    private final String STATE_FILE_NAME = "client_state.txt";
    private final Path downloadsDir;
    private final Path stateFilePath;
    private Map<Long, FileState> files;

    public ClientState(Path workDir) throws IOException {
        this.downloadsDir = Files.createDirectories(workDir.resolve(DOWNLOADS_DIR_NAME));
        this.stateFilePath = downloadsDir.resolve(STATE_FILE_NAME);
        initFiles();
    }

    public void addNewFile(long id, FileState fileState) {
        files.put(id, fileState);
    }

    public FileState addNewDownloadFile(long id, FileInformation fileInformation, FilePartsInfo filePartsInfo) throws IOException {
        String fileName = id + "_" + fileInformation.getName();
        Path filePath = downloadsDir.resolve(fileName);
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath.toString(), "rw")) {
            randomAccessFile.setLength(fileInformation.getSize());
        }
        FileState fileState = new FileState(fileInformation, filePath, filePartsInfo);
        addNewFile(id, fileState);
        return fileState;
    }

    public FileState getFileState(long id) {
        return files.getOrDefault(id, null);
    }

    public Map<Long, FileState> getFiles() {
        return files;
    }

    public List<Long> getAvailableFiles() {
        return files.values()
                .stream()
                .filter(fileState -> fileState.getPartsCount() > 0)
                .map(FileState::getFileId)
                .collect(Collectors.toList());
    }

    public List<FileState> getNotDownloadedFiles() {
        List<FileState> filesForDownload = new ArrayList<>();
        for (FileState fileState: files.values()) {
            if (fileState.getNumCompleteParts() != fileState.getNumAllParts()) {
                filesForDownload.add(fileState);
            }
        }
        return filesForDownload;
    }

    public boolean writePartContent(long fileId, long partId, byte[] content) {
        FileState fileState = files.get(fileId);
        return fileState.writePartContent(partId, content);
    }

    private void initFiles() {
        if (Files.exists(stateFilePath) && Files.isRegularFile(stateFilePath)) {
            try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(stateFilePath))) {
                files = new ConcurrentHashMap<>();
                long filesCount = dataInputStream.readLong();

                for (long i = 0; i < filesCount; i++) {
                    long fileId = dataInputStream.readLong();
                    files.put(fileId, FileState.readFileState(dataInputStream));
                }
                System.out.println("The state was initialized from a file:" + stateFilePath);
            } catch (IOException e) {
                System.out.println("Can't read the state file. Therefore, an empty client state will be initialized.");
                files = new ConcurrentHashMap<>();
            }
        } else {
            System.out.println("Couldn't find the state file: " + stateFilePath + ", so the state will be initialized empty.");
            files = new ConcurrentHashMap<>();
        }
    }

    private void save() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(stateFilePath))) {
            dataOutputStream.writeLong(files.size());
            for (Map.Entry<Long, FileState> file : files.entrySet()) {
                dataOutputStream.writeLong(file.getKey());
                file.getValue().write(dataOutputStream);
            }
        } catch (IOException e) {
            System.out.println("Unable to save state. The state will not be saved.");
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        save();
    }
}
