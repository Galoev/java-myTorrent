// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

public interface ListResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.tracker.ListResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 count = 1;</code>
   * @return The count.
   */
  long getCount();

  /**
   * <code>repeated .ru.itmo.java.message.tracker.FileInfo files = 2;</code>
   */
  java.util.List<ru.itmo.java.message.tracker.FileInfo> 
      getFilesList();
  /**
   * <code>repeated .ru.itmo.java.message.tracker.FileInfo files = 2;</code>
   */
  ru.itmo.java.message.tracker.FileInfo getFiles(int index);
  /**
   * <code>repeated .ru.itmo.java.message.tracker.FileInfo files = 2;</code>
   */
  int getFilesCount();
  /**
   * <code>repeated .ru.itmo.java.message.tracker.FileInfo files = 2;</code>
   */
  java.util.List<? extends ru.itmo.java.message.tracker.FileInfoOrBuilder> 
      getFilesOrBuilderList();
  /**
   * <code>repeated .ru.itmo.java.message.tracker.FileInfo files = 2;</code>
   */
  ru.itmo.java.message.tracker.FileInfoOrBuilder getFilesOrBuilder(
      int index);
}
