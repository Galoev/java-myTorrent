package ru.itmo.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

public class FilePartsInfo {
    public static final long PART_SIZE = 10 * 1024 * 1024;
    private final long size;
    private final long numAllParts;
    private final Set<Long> completeParts;
    private final Set<Long> allParts;

    public FilePartsInfo(long size) {
        this.size = size;
        this.numAllParts = (size + PART_SIZE - 1) / PART_SIZE;
        this.completeParts = new HashSet<>();
        this.allParts = new HashSet<>();
        for(long i = 0; i < numAllParts; i++) {
            completeParts.add(i);
            allParts.add(i);
        }
    }

    public FilePartsInfo(long size, Set<Long> completeParts) {
        this.size = size;
        this.numAllParts = (size + PART_SIZE - 1) / PART_SIZE;
        this.completeParts = completeParts;
        this.allParts = new HashSet<>();
        for(long i = 0; i < numAllParts; i++) {
            allParts.add(i);
        }
    }

    public Set<Long> getParts() {
        return completeParts;
    }

    public boolean checkPartId(long partId) {
        return completeParts.contains(partId);
    }

    public long getNumAllParts() {
        return numAllParts;
    }

    public long getNumCompleteParts() {
        return completeParts.size();
    }

    public Set<Long> getPartsForDownload() {
        Set<Long> partsForDownload = new HashSet<>(allParts);
        partsForDownload.removeAll(completeParts);
        return partsForDownload;
    }

    public long getPartSize(long partNum) {
        if (partNum < (numAllParts - 1) ) {
            return PART_SIZE;
        } else if (size % PART_SIZE == 0) {
            return PART_SIZE;
        }
        return size % PART_SIZE;
    }

    public void addCompletePart(long partId) {
        completeParts.add(partId);
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeLong(completeParts.size());
        for (Long partId : completeParts) {
            dataOutputStream.writeLong(partId);
        }
    }

    public static FilePartsInfo readFilePartsInfo(DataInputStream dataInputStream, long size) throws IOException {
        long numCompleteParts = dataInputStream.readLong();
        Set<Long> completeParts = new HashSet<>();
        for (int i = 0; i < numCompleteParts; i++) {
            completeParts.add(dataInputStream.readLong());
        }
        return new FilePartsInfo(size, completeParts);
    }
}
