package ru.itmo.java.tracker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String ip;
    private int port;
    private long lastUpdated;

    public Client(String ip) {
        this.ip = getCorrectIp(ip);
        this.port = -1;
        this.lastUpdated = System.currentTimeMillis();
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.lastUpdated = System.currentTimeMillis();
    }

    private String getCorrectIp(String ip) {
        if (ip.startsWith("/")) {
            return ip.substring(1);
        }
        return ip;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public void updateTime() {
        lastUpdated = System.currentTimeMillis();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(ip);
        dataOutputStream.writeInt(port);
    }

    public static void writeClients(DataOutputStream dataOutputStream, List<Client> clients) throws IOException {
        dataOutputStream.writeLong(clients.size());
        for (Client client: clients) {
            client.write(dataOutputStream);
        }
    }

    public static List<Client> readClients(DataInputStream dataInputStream) throws IOException {
        long clientsNum = dataInputStream.readLong();
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < clientsNum; i++) {
            String ip = dataInputStream.readUTF();
            int port = dataInputStream.readInt();
            clients.add(new Client(ip, port));
        }
        return clients;
    }
}
