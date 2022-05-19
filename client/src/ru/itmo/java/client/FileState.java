package ru.itmo.java.client;

import com.google.protobuf.ByteString;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class FileState {
    FileInformation fileInformation;
    Path filePath;
    FilePartsInfo filePartsInfo;

    public FileState(FileInformation fileInformation, Path filePath, FilePartsInfo filePartsInfo) {
        this.fileInformation = fileInformation;
        this.filePath = filePath;
        this.filePartsInfo = filePartsInfo;
    }

    public long getFileId() {
        return fileInformation.getId();
    }

    public long getPartsCount() {
        return filePartsInfo.getNumCompleteParts();
    }

    public FilePartsInfo getFilePartsInfo() {
        return filePartsInfo;
    }

    public long getNumAllParts() {
        return filePartsInfo.getNumAllParts();
    }

    public long getNumCompleteParts() {
        return filePartsInfo.getNumCompleteParts();
    }

    public Set<Long> getPartsForDownload() {
        return filePartsInfo.getPartsForDownload();
    }

    public String getFileName() {
        return filePath.getFileName().toString();
    }

    public float getPercentageDownloaded() {
        return (float) (filePartsInfo.getNumCompleteParts() / filePartsInfo.getNumAllParts() * 100.0);
    }

    public ByteString getPartContent(long partId) throws IllegalArgumentException, IOException {
        if (filePartsInfo.checkPartId(partId)) {
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath.toString(), "r")) {
                randomAccessFile.seek(FilePartsInfo.PART_SIZE * partId);
                byte[] buffer = new byte[(int) filePartsInfo.getPartSize(partId)];
                randomAccessFile.read(buffer, 0, (int) filePartsInfo.getPartSize(partId));
                return ByteString.copyFrom(buffer);
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean writePartContent(long partId, byte[] content) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath.toString(), "rw")) {
            randomAccessFile.seek(partId * FilePartsInfo.PART_SIZE);
            randomAccessFile.write(content, 0, content.length);
            filePartsInfo.addCompletePart(partId);
            return true;
        } catch (IOException ignored) {}
        return false;
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        fileInformation.write(dataOutputStream);
        dataOutputStream.writeUTF(filePath.toAbsolutePath().toString());
        filePartsInfo.write(dataOutputStream);
    }

    public static FileState readFileState(DataInputStream dataInputStream) throws IOException {
        FileInformation fileInformation = FileInformation.readFileInformation(dataInputStream);
        String filePath = dataInputStream.readUTF();
        FilePartsInfo filePartsInfo = FilePartsInfo.readFilePartsInfo(dataInputStream, fileInformation.getSize());
        return new FileState(fileInformation, Paths.get(filePath), filePartsInfo);
    }

}
