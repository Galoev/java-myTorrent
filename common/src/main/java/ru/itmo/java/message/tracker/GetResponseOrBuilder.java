// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

public interface GetResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.tracker.GetResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes content = 1;</code>
   * @return The content.
   */
  com.google.protobuf.ByteString getContent();

  /**
   * <code>bool correctRequestId = 2;</code>
   * @return The correctRequestId.
   */
  boolean getCorrectRequestId();
}