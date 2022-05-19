package ru.itmo.java.client;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientUpdater implements AutoCloseable{
    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
    private final TrackerCommunication trackerCommunication;
    private final ClientState clientState;
    private final int port;
    private final long periodInMinutes = 1;

    public ClientUpdater(TrackerCommunication trackerCommunication, ClientState clientState, int port) {
        this.trackerCommunication = trackerCommunication;
        this.clientState = clientState;
        this.port = port;
        scheduledExecutorService.scheduleAtFixedRate(this::update, 0, periodInMinutes, TimeUnit.MINUTES);
    }

    public void update() {
        List<Long> availableFiles = clientState.getAvailableFiles();
        if (!trackerCommunication.commandUpdate(availableFiles, port)) {
            System.out.println("FAILED update state in tracker");
        }
    }

    @Override
    public void close() {
        scheduledExecutorService.shutdown();
    }
}
