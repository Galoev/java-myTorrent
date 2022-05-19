package ru.itmo.java.tracker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientsController {
    private final long timeOut = 5 * 60 * 1000;
    private Map<Long, List<Client>> clients;

    public ClientsController() {
        clients = new HashMap<>();
    }

    public ClientsController(Map<Long, List<Client>> clients) {
        this.clients = clients;
    }

    public synchronized void addNewSource(long id, Client client) {
        List<Client> curClients = clients.getOrDefault(id, new ArrayList<>());
        curClients.add(client);
        clients.put(id, curClients);
    }

    public synchronized List<Client> getSources(long id) {
        List<Client> curClients = clients.get(id);
        if (curClients == null) {
            return null;
        }
        List<Client> result = new ArrayList<>();
        for (Client client : curClients) {
            if ((client.getLastUpdatedTime() + timeOut) >= System.currentTimeMillis()) {
                result.add(client);
            }
        }
        clients.put(id, result);
        return result;
    }

    public synchronized void updateClient(List<Long> ids, Client client) {
        for (Long id: ids) {
            List<Client> curClients = clients.getOrDefault(id, new ArrayList<>());
            int client_id = curClients.indexOf(client);
            if (client_id != -1) {
                curClients.get(client_id).updateTime();
            } else {
                curClients.add(client);
            }
        }
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeLong(clients.size());
        for (Map.Entry<Long, List<Client>> curClients: clients.entrySet()) {
            dataOutputStream.writeLong(curClients.getKey());
            Client.writeClients(dataOutputStream, curClients.getValue());
        }
    }


    public static ClientsController readClientsController(DataInputStream dataInputStream) throws IOException {
        Map<Long, List<Client>> clients = new HashMap<>();
        long clientsNum = dataInputStream.readLong();
        for (int i = 0; i < clientsNum; i++) {
            long fileId = dataInputStream.readLong();
            clients.put(fileId, Client.readClients(dataInputStream));
        }
        return new ClientsController(clients);
    }
}
