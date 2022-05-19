package ru.itmo.java.client;

import ru.itmo.java.message.tracker.*;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class TrackerCommunication implements AutoCloseable {
    Socket socket;

    public TrackerCommunication(Socket socket) throws IOException {
        this.socket = socket;
    }

    public synchronized List<FileInfo> commandList() {
        ListRequest listRequest = ListRequest.newBuilder().build();
        BaseRequest baseRequest = BaseRequest.newBuilder().setListRequest(listRequest).build();
        sendBaseRequest(baseRequest);

        BaseResponse baseResponse = getBaseResponse();
        ListResponse listResponse = baseResponse.getListResponse();

        return listResponse.getFilesList();
    }

    public synchronized long commandUpload(FileInformation fileInformation) {
        UploadRequest uploadRequest = UploadRequest.newBuilder()
                .setName(fileInformation.getName())
                .setSize(fileInformation.getSize())
                .build();
        BaseRequest baseRequest = BaseRequest.newBuilder().setUploadRequest(uploadRequest).build();
        sendBaseRequest(baseRequest);

        BaseResponse baseResponse = getBaseResponse();
        UploadResponse uploadResponse = baseResponse.getUploadResponse();
        return uploadResponse.getId();
    }

    public synchronized List<ClientInfo> commandSources(long id) {
        SourcesRequest sourcesRequest = SourcesRequest.newBuilder().setId(id).build();
        BaseRequest baseRequest = BaseRequest.newBuilder().setSourcesRequest(sourcesRequest).build();
        sendBaseRequest(baseRequest);

        BaseResponse baseResponse = getBaseResponse();
        SourcesResponse sourcesResponse = baseResponse.getSourcesResponse();
        if (!sourcesResponse.getCorrectRequestId()) {
            return null;
        }
        return sourcesResponse.getClientsList();
    }

    public synchronized boolean commandUpdate(List<Long> availableFiles, int port) {
        UpdateRequest updateRequest = UpdateRequest.newBuilder()
                .setClientPort(port)
                .setCount(availableFiles.size())
                .addAllId(availableFiles)
                .build();
        BaseRequest baseRequest = BaseRequest.newBuilder().setUpdateRequest(updateRequest).build();
        sendBaseRequest(baseRequest);

        BaseResponse baseResponse = getBaseResponse();
        UpdateResponse updateResponse = baseResponse.getUpdateResponse();
        return updateResponse.getStatus();
    }

    public void sendBaseRequest(BaseRequest baseRequest) {
        try {
            baseRequest.writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("An error occurred while sending the request");
            e.printStackTrace();
        }
    }

    public BaseResponse getBaseResponse() {
        BaseResponse baseResponse = null;
        try {
            baseResponse = BaseResponse.parseDelimitedFrom(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("An error occurred while receiving a response");
            e.printStackTrace();
        }

        return baseResponse;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
