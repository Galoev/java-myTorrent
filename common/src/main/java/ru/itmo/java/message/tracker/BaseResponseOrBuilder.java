// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

public interface BaseResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.tracker.BaseResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ru.itmo.java.message.tracker.ListResponse listResponse = 1;</code>
   * @return Whether the listResponse field is set.
   */
  boolean hasListResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.ListResponse listResponse = 1;</code>
   * @return The listResponse.
   */
  ru.itmo.java.message.tracker.ListResponse getListResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.ListResponse listResponse = 1;</code>
   */
  ru.itmo.java.message.tracker.ListResponseOrBuilder getListResponseOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.UploadResponse uploadResponse = 2;</code>
   * @return Whether the uploadResponse field is set.
   */
  boolean hasUploadResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.UploadResponse uploadResponse = 2;</code>
   * @return The uploadResponse.
   */
  ru.itmo.java.message.tracker.UploadResponse getUploadResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.UploadResponse uploadResponse = 2;</code>
   */
  ru.itmo.java.message.tracker.UploadResponseOrBuilder getUploadResponseOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.SourcesResponse sourcesResponse = 3;</code>
   * @return Whether the sourcesResponse field is set.
   */
  boolean hasSourcesResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.SourcesResponse sourcesResponse = 3;</code>
   * @return The sourcesResponse.
   */
  ru.itmo.java.message.tracker.SourcesResponse getSourcesResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.SourcesResponse sourcesResponse = 3;</code>
   */
  ru.itmo.java.message.tracker.SourcesResponseOrBuilder getSourcesResponseOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.UpdateResponse updateResponse = 4;</code>
   * @return Whether the updateResponse field is set.
   */
  boolean hasUpdateResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.UpdateResponse updateResponse = 4;</code>
   * @return The updateResponse.
   */
  ru.itmo.java.message.tracker.UpdateResponse getUpdateResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.UpdateResponse updateResponse = 4;</code>
   */
  ru.itmo.java.message.tracker.UpdateResponseOrBuilder getUpdateResponseOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.StatResponse statResponse = 5;</code>
   * @return Whether the statResponse field is set.
   */
  boolean hasStatResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.StatResponse statResponse = 5;</code>
   * @return The statResponse.
   */
  ru.itmo.java.message.tracker.StatResponse getStatResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.StatResponse statResponse = 5;</code>
   */
  ru.itmo.java.message.tracker.StatResponseOrBuilder getStatResponseOrBuilder();

  /**
   * <code>.ru.itmo.java.message.tracker.GetResponse getResponse = 6;</code>
   * @return Whether the getResponse field is set.
   */
  boolean hasGetResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.GetResponse getResponse = 6;</code>
   * @return The getResponse.
   */
  ru.itmo.java.message.tracker.GetResponse getGetResponse();
  /**
   * <code>.ru.itmo.java.message.tracker.GetResponse getResponse = 6;</code>
   */
  ru.itmo.java.message.tracker.GetResponseOrBuilder getGetResponseOrBuilder();

  public ru.itmo.java.message.tracker.BaseResponse.ResponseCase getResponseCase();
}