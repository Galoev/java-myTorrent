package ru.itmo.java.client;

import ru.itmo.java.message.tracker.*;

import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadServer implements AutoCloseable{
    private final int CPU_CORE_COUNT = Runtime.getRuntime().availableProcessors();
    private final ExecutorService workerPool = Executors.newFixedThreadPool(CPU_CORE_COUNT);
    private final TrackerCommunication trackerCommunication;
    private final ClientState clientState;
    private final List<FileState> filesState;
    private final long DELAY_BEFORE_REDOWNLOAD = 5000;

    public DownloadServer(TrackerCommunication trackerCommunication, ClientState clientState) {
        this.trackerCommunication = trackerCommunication;
        this.clientState = clientState;
        filesState = clientState.getNotDownloadedFiles();
        for (FileState fileState : filesState) {
            downloadNewFile(fileState);
        }
    }

    public void downloadNewFile(FileState fileState) {
        workerPool.submit(new DownloadWorker(fileState));
    }

    private List<ClientInfo> getSources(long id) {
        return trackerCommunication.commandSources(id);
    }

    private Set<Long> commandStat(Socket socket, long fileId) {
        StatRequest statRequest = StatRequest.newBuilder().setId(fileId).build();
        try {
            BaseRequest.newBuilder().setStatRequest(statRequest).build().writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            return null;
        }

        try {
            StatResponse statResponse = BaseResponse.parseDelimitedFrom(socket.getInputStream()).getStatResponse();
            return new HashSet<>(statResponse.getCompletePartsList());
        } catch (IOException e) {
            return  null;
        }
    }

    private byte[] commandGet(Socket socket, long fileId, long partId) {
        GetRequest getRequest = GetRequest.newBuilder().setId(fileId).setPartId(partId).build();
        try {
            BaseRequest.newBuilder().setGetRequest(getRequest).build().writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            return null;
        }

        try {
            GetResponse getResponse = BaseResponse.parseDelimitedFrom(socket.getInputStream()).getGetResponse();
            if (getResponse.getCorrectRequestId()) {
                return getResponse.getContent().toByteArray();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    private class DownloadWorker implements Runnable {
        private final FileState fileState;

        private DownloadWorker(FileState fileState) {
            this.fileState = fileState;
        }

        @Override
        public void run() {
            Set<Long> partsIdForDownload = fileState.getPartsForDownload();
            Map<Long, List<ClientInfo>> partsByClients = getSourcesByPartId(fileState.getFileId(), partsIdForDownload);
            for (Map.Entry<Long, List<ClientInfo>> partByClients : partsByClients.entrySet()) {
                downloadPart(fileState.getFileId(), partByClients.getKey(), partByClients.getValue());
            }

            partsIdForDownload = fileState.getPartsForDownload();
            if (partsIdForDownload.size() != 0) {
                String percentageDownloaded = fileState.getPercentageDownloaded() + "%";
                System.out.println("File: " + fileState.getFileName() + " partially downloaded: " + percentageDownloaded);
                sleepBeforeRedownload();
                downloadNewFile(fileState);
            } else {
                System.out.println("File: " + fileState.getFileName() + " fully downloaded");
            }
        }

        private void downloadPart(long fileId, long partId, List<ClientInfo> clientsInfo) {
            for (ClientInfo clientInfo: clientsInfo) {
                try(Socket socket = new Socket(clientInfo.getIp(), (int) clientInfo.getPort())) {
                    byte[] content = commandGet(socket, fileId, partId);
                    if (content == null) {
                        continue;
                    }
                    clientState.writePartContent(fileId, partId, content);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        private Map<Long, List<ClientInfo>> getSourcesByPartId(long fileId, Set<Long> partsIdForDownload) {
            Map<Long, List<ClientInfo>> partsByClients = new HashMap<>();

            List<ClientInfo> sources = getSources(fileId);
            for (ClientInfo client: sources) {
                try (Socket socket = new Socket(client.getIp(), (int) client.getPort())) {
                    Set<Long> parts = commandStat(socket, fileId);
                    parts = getIntersection(parts, partsIdForDownload);
                    if (parts == null) {
                        continue;
                    }
                    for (Long part: parts) {
                        List<ClientInfo> cur_clients = partsByClients.getOrDefault(part, new ArrayList<>());
                        cur_clients.add(client);
                        partsByClients.put(part, cur_clients);
                    }
                } catch (IOException ignored) {}
            }

            return partsByClients;
        }

        private void sleepBeforeRedownload() {
            try {
                Thread.sleep(DELAY_BEFORE_REDOWNLOAD);
            } catch (InterruptedException ignored) {}
        }

        private Set<Long> getIntersection(Set<Long> set1, Set<Long> set2) {
            Set<Long> result = new HashSet<>(set1);
            result.retainAll(set2);
            return result;
        }
    }

    @Override
    public void close() {
        workerPool.shutdown();
    }
}
