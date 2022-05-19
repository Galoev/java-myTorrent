package ru.itmo.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FileInformation {
    private long id;
    private String name;
    private long size;

    public FileInformation(long id, String name, long size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeLong(id);
        dataOutputStream.writeUTF(name);
        dataOutputStream.writeLong(size);
    }

    public static FileInformation readFileInformation(DataInputStream dataInputStream) throws IOException {
        return new FileInformation(dataInputStream.readLong(), dataInputStream.readUTF(), dataInputStream.readLong());
    }
}
