// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrackerMessages.proto

package ru.itmo.java.message.tracker;

/**
 * Protobuf type {@code ru.itmo.java.message.tracker.SourcesResponse}
 */
public final class SourcesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.tracker.SourcesResponse)
    SourcesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SourcesResponse.newBuilder() to construct.
  private SourcesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SourcesResponse() {
    clients_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SourcesResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SourcesResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            size_ = input.readInt64();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              clients_ = new java.util.ArrayList<ru.itmo.java.message.tracker.ClientInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            clients_.add(
                input.readMessage(ru.itmo.java.message.tracker.ClientInfo.parser(), extensionRegistry));
            break;
          }
          case 24: {

            correctRequestId_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        clients_ = java.util.Collections.unmodifiableList(clients_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.itmo.java.message.tracker.TrackerMessages.internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.tracker.TrackerMessages.internal_static_ru_itmo_java_message_tracker_SourcesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.tracker.SourcesResponse.class, ru.itmo.java.message.tracker.SourcesResponse.Builder.class);
  }

  public static final int SIZE_FIELD_NUMBER = 1;
  private long size_;
  /**
   * <code>int64 size = 1;</code>
   * @return The size.
   */
  @java.lang.Override
  public long getSize() {
    return size_;
  }

  public static final int CLIENTS_FIELD_NUMBER = 2;
  private java.util.List<ru.itmo.java.message.tracker.ClientInfo> clients_;
  /**
   * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
   */
  @java.lang.Override
  public java.util.List<ru.itmo.java.message.tracker.ClientInfo> getClientsList() {
    return clients_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends ru.itmo.java.message.tracker.ClientInfoOrBuilder> 
      getClientsOrBuilderList() {
    return clients_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
   */
  @java.lang.Override
  public int getClientsCount() {
    return clients_.size();
  }
  /**
   * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.tracker.ClientInfo getClients(int index) {
    return clients_.get(index);
  }
  /**
   * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.tracker.ClientInfoOrBuilder getClientsOrBuilder(
      int index) {
    return clients_.get(index);
  }

  public static final int CORRECTREQUESTID_FIELD_NUMBER = 3;
  private boolean correctRequestId_;
  /**
   * <code>bool correctRequestId = 3;</code>
   * @return The correctRequestId.
   */
  @java.lang.Override
  public boolean getCorrectRequestId() {
    return correctRequestId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (size_ != 0L) {
      output.writeInt64(1, size_);
    }
    for (int i = 0; i < clients_.size(); i++) {
      output.writeMessage(2, clients_.get(i));
    }
    if (correctRequestId_ != false) {
      output.writeBool(3, correctRequestId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (size_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, size_);
    }
    for (int i = 0; i < clients_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, clients_.get(i));
    }
    if (correctRequestId_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, correctRequestId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.itmo.java.message.tracker.SourcesResponse)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.tracker.SourcesResponse other = (ru.itmo.java.message.tracker.SourcesResponse) obj;

    if (getSize()
        != other.getSize()) return false;
    if (!getClientsList()
        .equals(other.getClientsList())) return false;
    if (getCorrectRequestId()
        != other.getCorrectRequestId()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SIZE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSize());
    if (getClientsCount() > 0) {
      hash = (37 * hash) + CLIENTS_FIELD_NUMBER;
      hash = (53 * hash) + getClientsList().hashCode();
    }
    hash = (37 * hash) + CORRECTREQUESTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getCorrectRequestId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.tracker.SourcesResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.itmo.java.message.tracker.SourcesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ru.itmo.java.message.tracker.SourcesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.tracker.SourcesResponse)
      ru.itmo.java.message.tracker.SourcesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.tracker.TrackerMessages.internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.tracker.TrackerMessages.internal_static_ru_itmo_java_message_tracker_SourcesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.tracker.SourcesResponse.class, ru.itmo.java.message.tracker.SourcesResponse.Builder.class);
    }

    // Construct using ru.itmo.java.message.tracker.SourcesResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getClientsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      size_ = 0L;

      if (clientsBuilder_ == null) {
        clients_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        clientsBuilder_.clear();
      }
      correctRequestId_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.tracker.TrackerMessages.internal_static_ru_itmo_java_message_tracker_SourcesResponse_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.tracker.SourcesResponse getDefaultInstanceForType() {
      return ru.itmo.java.message.tracker.SourcesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.tracker.SourcesResponse build() {
      ru.itmo.java.message.tracker.SourcesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.tracker.SourcesResponse buildPartial() {
      ru.itmo.java.message.tracker.SourcesResponse result = new ru.itmo.java.message.tracker.SourcesResponse(this);
      int from_bitField0_ = bitField0_;
      result.size_ = size_;
      if (clientsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          clients_ = java.util.Collections.unmodifiableList(clients_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.clients_ = clients_;
      } else {
        result.clients_ = clientsBuilder_.build();
      }
      result.correctRequestId_ = correctRequestId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.itmo.java.message.tracker.SourcesResponse) {
        return mergeFrom((ru.itmo.java.message.tracker.SourcesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.tracker.SourcesResponse other) {
      if (other == ru.itmo.java.message.tracker.SourcesResponse.getDefaultInstance()) return this;
      if (other.getSize() != 0L) {
        setSize(other.getSize());
      }
      if (clientsBuilder_ == null) {
        if (!other.clients_.isEmpty()) {
          if (clients_.isEmpty()) {
            clients_ = other.clients_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureClientsIsMutable();
            clients_.addAll(other.clients_);
          }
          onChanged();
        }
      } else {
        if (!other.clients_.isEmpty()) {
          if (clientsBuilder_.isEmpty()) {
            clientsBuilder_.dispose();
            clientsBuilder_ = null;
            clients_ = other.clients_;
            bitField0_ = (bitField0_ & ~0x00000001);
            clientsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getClientsFieldBuilder() : null;
          } else {
            clientsBuilder_.addAllMessages(other.clients_);
          }
        }
      }
      if (other.getCorrectRequestId() != false) {
        setCorrectRequestId(other.getCorrectRequestId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.itmo.java.message.tracker.SourcesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.tracker.SourcesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long size_ ;
    /**
     * <code>int64 size = 1;</code>
     * @return The size.
     */
    @java.lang.Override
    public long getSize() {
      return size_;
    }
    /**
     * <code>int64 size = 1;</code>
     * @param value The size to set.
     * @return This builder for chaining.
     */
    public Builder setSize(long value) {
      
      size_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 size = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSize() {
      
      size_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<ru.itmo.java.message.tracker.ClientInfo> clients_ =
      java.util.Collections.emptyList();
    private void ensureClientsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        clients_ = new java.util.ArrayList<ru.itmo.java.message.tracker.ClientInfo>(clients_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.tracker.ClientInfo, ru.itmo.java.message.tracker.ClientInfo.Builder, ru.itmo.java.message.tracker.ClientInfoOrBuilder> clientsBuilder_;

    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public java.util.List<ru.itmo.java.message.tracker.ClientInfo> getClientsList() {
      if (clientsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(clients_);
      } else {
        return clientsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public int getClientsCount() {
      if (clientsBuilder_ == null) {
        return clients_.size();
      } else {
        return clientsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public ru.itmo.java.message.tracker.ClientInfo getClients(int index) {
      if (clientsBuilder_ == null) {
        return clients_.get(index);
      } else {
        return clientsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder setClients(
        int index, ru.itmo.java.message.tracker.ClientInfo value) {
      if (clientsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientsIsMutable();
        clients_.set(index, value);
        onChanged();
      } else {
        clientsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder setClients(
        int index, ru.itmo.java.message.tracker.ClientInfo.Builder builderForValue) {
      if (clientsBuilder_ == null) {
        ensureClientsIsMutable();
        clients_.set(index, builderForValue.build());
        onChanged();
      } else {
        clientsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder addClients(ru.itmo.java.message.tracker.ClientInfo value) {
      if (clientsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientsIsMutable();
        clients_.add(value);
        onChanged();
      } else {
        clientsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder addClients(
        int index, ru.itmo.java.message.tracker.ClientInfo value) {
      if (clientsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientsIsMutable();
        clients_.add(index, value);
        onChanged();
      } else {
        clientsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder addClients(
        ru.itmo.java.message.tracker.ClientInfo.Builder builderForValue) {
      if (clientsBuilder_ == null) {
        ensureClientsIsMutable();
        clients_.add(builderForValue.build());
        onChanged();
      } else {
        clientsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder addClients(
        int index, ru.itmo.java.message.tracker.ClientInfo.Builder builderForValue) {
      if (clientsBuilder_ == null) {
        ensureClientsIsMutable();
        clients_.add(index, builderForValue.build());
        onChanged();
      } else {
        clientsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder addAllClients(
        java.lang.Iterable<? extends ru.itmo.java.message.tracker.ClientInfo> values) {
      if (clientsBuilder_ == null) {
        ensureClientsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, clients_);
        onChanged();
      } else {
        clientsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder clearClients() {
      if (clientsBuilder_ == null) {
        clients_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        clientsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public Builder removeClients(int index) {
      if (clientsBuilder_ == null) {
        ensureClientsIsMutable();
        clients_.remove(index);
        onChanged();
      } else {
        clientsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public ru.itmo.java.message.tracker.ClientInfo.Builder getClientsBuilder(
        int index) {
      return getClientsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public ru.itmo.java.message.tracker.ClientInfoOrBuilder getClientsOrBuilder(
        int index) {
      if (clientsBuilder_ == null) {
        return clients_.get(index);  } else {
        return clientsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public java.util.List<? extends ru.itmo.java.message.tracker.ClientInfoOrBuilder> 
         getClientsOrBuilderList() {
      if (clientsBuilder_ != null) {
        return clientsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(clients_);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public ru.itmo.java.message.tracker.ClientInfo.Builder addClientsBuilder() {
      return getClientsFieldBuilder().addBuilder(
          ru.itmo.java.message.tracker.ClientInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public ru.itmo.java.message.tracker.ClientInfo.Builder addClientsBuilder(
        int index) {
      return getClientsFieldBuilder().addBuilder(
          index, ru.itmo.java.message.tracker.ClientInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.tracker.ClientInfo clients = 2;</code>
     */
    public java.util.List<ru.itmo.java.message.tracker.ClientInfo.Builder> 
         getClientsBuilderList() {
      return getClientsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.tracker.ClientInfo, ru.itmo.java.message.tracker.ClientInfo.Builder, ru.itmo.java.message.tracker.ClientInfoOrBuilder> 
        getClientsFieldBuilder() {
      if (clientsBuilder_ == null) {
        clientsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ru.itmo.java.message.tracker.ClientInfo, ru.itmo.java.message.tracker.ClientInfo.Builder, ru.itmo.java.message.tracker.ClientInfoOrBuilder>(
                clients_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        clients_ = null;
      }
      return clientsBuilder_;
    }

    private boolean correctRequestId_ ;
    /**
     * <code>bool correctRequestId = 3;</code>
     * @return The correctRequestId.
     */
    @java.lang.Override
    public boolean getCorrectRequestId() {
      return correctRequestId_;
    }
    /**
     * <code>bool correctRequestId = 3;</code>
     * @param value The correctRequestId to set.
     * @return This builder for chaining.
     */
    public Builder setCorrectRequestId(boolean value) {
      
      correctRequestId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool correctRequestId = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCorrectRequestId() {
      
      correctRequestId_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.tracker.SourcesResponse)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.tracker.SourcesResponse)
  private static final ru.itmo.java.message.tracker.SourcesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.tracker.SourcesResponse();
  }

  public static ru.itmo.java.message.tracker.SourcesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SourcesResponse>
      PARSER = new com.google.protobuf.AbstractParser<SourcesResponse>() {
    @java.lang.Override
    public SourcesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SourcesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SourcesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SourcesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.tracker.SourcesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

