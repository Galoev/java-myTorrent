// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

public interface BaseRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.tracker.BaseRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ru.itmo.java.message.tracker.ListRequest listRequest = 1;</code>
   * @return Whether the listRequest field is set.
   */
  boolean hasListRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.ListRequest listRequest = 1;</code>
   * @return The listRequest.
   */
  ru.itmo.java.message.tracker.ListRequest getListRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.ListRequest listRequest = 1;</code>
   */
  ru.itmo.java.message.tracker.ListRequestOrBuilder getListRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.UploadRequest uploadRequest = 2;</code>
   * @return Whether the uploadRequest field is set.
   */
  boolean hasUploadRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.UploadRequest uploadRequest = 2;</code>
   * @return The uploadRequest.
   */
  ru.itmo.java.message.tracker.UploadRequest getUploadRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.UploadRequest uploadRequest = 2;</code>
   */
  ru.itmo.java.message.tracker.UploadRequestOrBuilder getUploadRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.SourcesRequest sourcesRequest = 3;</code>
   * @return Whether the sourcesRequest field is set.
   */
  boolean hasSourcesRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.SourcesRequest sourcesRequest = 3;</code>
   * @return The sourcesRequest.
   */
  ru.itmo.java.message.tracker.SourcesRequest getSourcesRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.SourcesRequest sourcesRequest = 3;</code>
   */
  ru.itmo.java.message.tracker.SourcesRequestOrBuilder getSourcesRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.UpdateRequest updateRequest = 4;</code>
   * @return Whether the updateRequest field is set.
   */
  boolean hasUpdateRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.UpdateRequest updateRequest = 4;</code>
   * @return The updateRequest.
   */
  ru.itmo.java.message.tracker.UpdateRequest getUpdateRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.UpdateRequest updateRequest = 4;</code>
   */
  ru.itmo.java.message.tracker.UpdateRequestOrBuilder getUpdateRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.StatRequest statRequest = 5;</code>
   * @return Whether the statRequest field is set.
   */
  boolean hasStatRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.StatRequest statRequest = 5;</code>
   * @return The statRequest.
   */
  ru.itmo.java.message.tracker.StatRequest getStatRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.StatRequest statRequest = 5;</code>
   */
  ru.itmo.java.message.tracker.StatRequestOrBuilder getStatRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.GetRequest getRequest = 6;</code>
   * @return Whether the getRequest field is set.
   */
  boolean hasGetRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.GetRequest getRequest = 6;</code>
   * @return The getRequest.
   */
  ru.itmo.java.message.tracker.GetRequest getGetRequest();
  /**
   * <code>.ru.itmo.java.message.tracker.GetRequest getRequest = 6;</code>
   */
  ru.itmo.java.message.tracker.GetRequestOrBuilder getGetRequestOrBuilder();

  public ru.itmo.java.message.tracker.BaseRequest.RequestCase getRequestCase();
}
