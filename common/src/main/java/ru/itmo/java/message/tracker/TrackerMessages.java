// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

public final class TrackerMessages {
  private TrackerMessages() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_BaseRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_BaseRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_BaseResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_BaseResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_ListRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_ListRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_ListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_ListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_FileInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_FileInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_UploadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_UploadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_UploadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_UploadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_SourcesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_SourcesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_SourcesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_ClientInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_ClientInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_UpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_UpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_UpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_UpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_StatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_StatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_StatResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_StatResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_tracker_GetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_tracker_GetResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025TrackerMessages.proto\022\034ru.itmo.java.me" +
      "ssage.tracker\"\260\003\n\013BaseRequest\022@\n\013listReq" +
      "uest\030\001 \001(\0132).ru.itmo.java.message.tracke" +
      "r.ListRequestH\000\022D\n\ruploadRequest\030\002 \001(\0132+" +
      ".ru.itmo.java.message.tracker.UploadRequ" +
      "estH\000\022F\n\016sourcesRequest\030\003 \001(\0132,.ru.itmo." +
      "java.message.tracker.SourcesRequestH\000\022D\n" +
      "\rupdateRequest\030\004 \001(\0132+.ru.itmo.java.mess" +
      "age.tracker.UpdateRequestH\000\022@\n\013statReque" +
      "st\030\005 \001(\0132).ru.itmo.java.message.tracker." +
      "StatRequestH\000\022>\n\ngetRequest\030\006 \001(\0132(.ru.i" +
      "tmo.java.message.tracker.GetRequestH\000B\t\n" +
      "\007request\"\276\003\n\014BaseResponse\022B\n\014listRespons" +
      "e\030\001 \001(\0132*.ru.itmo.java.message.tracker.L" +
      "istResponseH\000\022F\n\016uploadResponse\030\002 \001(\0132,." +
      "ru.itmo.java.message.tracker.UploadRespo" +
      "nseH\000\022H\n\017sourcesResponse\030\003 \001(\0132-.ru.itmo" +
      ".java.message.tracker.SourcesResponseH\000\022" +
      "F\n\016updateResponse\030\004 \001(\0132,.ru.itmo.java.m" +
      "essage.tracker.UpdateResponseH\000\022B\n\014statR" +
      "esponse\030\005 \001(\0132*.ru.itmo.java.message.tra" +
      "cker.StatResponseH\000\022@\n\013getResponse\030\006 \001(\013" +
      "2).ru.itmo.java.message.tracker.GetRespo" +
      "nseH\000B\n\n\010response\"\r\n\013ListRequest\"T\n\014List" +
      "Response\022\r\n\005count\030\001 \001(\003\0225\n\005files\030\002 \003(\0132&" +
      ".ru.itmo.java.message.tracker.FileInfo\"2" +
      "\n\010FileInfo\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\014\n\004" +
      "size\030\003 \001(\003\"+\n\rUploadRequest\022\014\n\004name\030\001 \001(" +
      "\t\022\014\n\004size\030\002 \001(\003\"8\n\016UploadResponse\022\n\n\002id\030" +
      "\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\014\n\004size\030\003 \001(\003\"\034\n\016Sou" +
      "rcesRequest\022\n\n\002id\030\001 \001(\003\"t\n\017SourcesRespon" +
      "se\022\014\n\004size\030\001 \001(\003\0229\n\007clients\030\002 \003(\0132(.ru.i" +
      "tmo.java.message.tracker.ClientInfo\022\030\n\020c" +
      "orrectRequestId\030\003 \001(\010\"&\n\nClientInfo\022\n\n\002i" +
      "p\030\001 \001(\t\022\014\n\004port\030\002 \001(\003\">\n\rUpdateRequest\022\022" +
      "\n\nclientPort\030\001 \001(\005\022\r\n\005count\030\002 \001(\003\022\n\n\002id\030" +
      "\003 \003(\003\" \n\016UpdateResponse\022\016\n\006status\030\001 \001(\010\"" +
      "\031\n\013StatRequest\022\n\n\002id\030\001 \001(\003\"7\n\014StatRespon" +
      "se\022\020\n\010numParts\030\001 \001(\003\022\025\n\rcompleteParts\030\002 " +
      "\003(\003\"(\n\nGetRequest\022\n\n\002id\030\001 \001(\003\022\016\n\006partId\030" +
      "\002 \001(\003\"8\n\013GetResponse\022\017\n\007content\030\001 \001(\014\022\030\n" +
      "\020correctRequestId\030\002 \001(\010B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ru_itmo_java_message_tracker_BaseRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ru_itmo_java_message_tracker_BaseRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_BaseRequest_descriptor,
        new java.lang.String[] { "ListRequest", "UploadRequest", "SourcesRequest", "UpdateRequest", "StatRequest", "GetRequest", "Request", });
    internal_static_ru_itmo_java_message_tracker_BaseResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ru_itmo_java_message_tracker_BaseResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_BaseResponse_descriptor,
        new java.lang.String[] { "ListResponse", "UploadResponse", "SourcesResponse", "UpdateResponse", "StatResponse", "GetResponse", "Response", });
    internal_static_ru_itmo_java_message_tracker_ListRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ru_itmo_java_message_tracker_ListRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_ListRequest_descriptor,
        new java.lang.String[] { });
    internal_static_ru_itmo_java_message_tracker_ListResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ru_itmo_java_message_tracker_ListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_ListResponse_descriptor,
        new java.lang.String[] { "Count", "Files", });
    internal_static_ru_itmo_java_message_tracker_FileInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ru_itmo_java_message_tracker_FileInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_FileInfo_descriptor,
        new java.lang.String[] { "Id", "Name", "Size", });
    internal_static_ru_itmo_java_message_tracker_UploadRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ru_itmo_java_message_tracker_UploadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_UploadRequest_descriptor,
        new java.lang.String[] { "Name", "Size", });
    internal_static_ru_itmo_java_message_tracker_UploadResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ru_itmo_java_message_tracker_UploadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_UploadResponse_descriptor,
        new java.lang.String[] { "Id", "Name", "Size", });
    internal_static_ru_itmo_java_message_tracker_SourcesRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ru_itmo_java_message_tracker_SourcesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_SourcesRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ru_itmo_java_message_tracker_SourcesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor,
        new java.lang.String[] { "Size", "Clients", "CorrectRequestId", });
    internal_static_ru_itmo_java_message_tracker_ClientInfo_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ru_itmo_java_message_tracker_ClientInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_ClientInfo_descriptor,
        new java.lang.String[] { "Ip", "Port", });
    internal_static_ru_itmo_java_message_tracker_UpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ru_itmo_java_message_tracker_UpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_UpdateRequest_descriptor,
        new java.lang.String[] { "ClientPort", "Count", "Id", });
    internal_static_ru_itmo_java_message_tracker_UpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ru_itmo_java_message_tracker_UpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_UpdateResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_ru_itmo_java_message_tracker_StatRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ru_itmo_java_message_tracker_StatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_StatRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ru_itmo_java_message_tracker_StatResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_ru_itmo_java_message_tracker_StatResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_StatResponse_descriptor,
        new java.lang.String[] { "NumParts", "CompleteParts", });
    internal_static_ru_itmo_java_message_tracker_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_ru_itmo_java_message_tracker_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_GetRequest_descriptor,
        new java.lang.String[] { "Id", "PartId", });
    internal_static_ru_itmo_java_message_tracker_GetResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_ru_itmo_java_message_tracker_GetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_tracker_GetResponse_descriptor,
        new java.lang.String[] { "Content", "CorrectRequestId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}