/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/container/v1/cluster_service.proto

// Protobuf Java Version: 3.25.8
package com.google.container.v1;

/**
 *
 *
 * <pre>
 * StatusCondition describes why a cluster or a node pool has a certain status
 * (e.g., ERROR or DEGRADED).
 * </pre>
 *
 * Protobuf type {@code google.container.v1.StatusCondition}
 */
public final class StatusCondition extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.container.v1.StatusCondition)
    StatusConditionOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use StatusCondition.newBuilder() to construct.
  private StatusCondition(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private StatusCondition() {
    code_ = 0;
    message_ = "";
    canonicalCode_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new StatusCondition();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.container.v1.ClusterServiceProto
        .internal_static_google_container_v1_StatusCondition_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.container.v1.ClusterServiceProto
        .internal_static_google_container_v1_StatusCondition_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.container.v1.StatusCondition.class,
            com.google.container.v1.StatusCondition.Builder.class);
  }

  /**
   *
   *
   * <pre>
   * Code for each condition
   * </pre>
   *
   * Protobuf enum {@code google.container.v1.StatusCondition.Code}
   */
  public enum Code implements com.google.protobuf.ProtocolMessageEnum {
    /**
     *
     *
     * <pre>
     * UNKNOWN indicates a generic condition.
     * </pre>
     *
     * <code>UNKNOWN = 0;</code>
     */
    UNKNOWN(0),
    /**
     *
     *
     * <pre>
     * GCE_STOCKOUT indicates that Google Compute Engine resources are
     * temporarily unavailable.
     * </pre>
     *
     * <code>GCE_STOCKOUT = 1;</code>
     */
    GCE_STOCKOUT(1),
    /**
     *
     *
     * <pre>
     * GKE_SERVICE_ACCOUNT_DELETED indicates that the user deleted their robot
     * service account.
     * </pre>
     *
     * <code>GKE_SERVICE_ACCOUNT_DELETED = 2;</code>
     */
    GKE_SERVICE_ACCOUNT_DELETED(2),
    /**
     *
     *
     * <pre>
     * Google Compute Engine quota was exceeded.
     * </pre>
     *
     * <code>GCE_QUOTA_EXCEEDED = 3;</code>
     */
    GCE_QUOTA_EXCEEDED(3),
    /**
     *
     *
     * <pre>
     * Cluster state was manually changed by an SRE due to a system logic error.
     * </pre>
     *
     * <code>SET_BY_OPERATOR = 4;</code>
     */
    SET_BY_OPERATOR(4),
    /**
     *
     *
     * <pre>
     * Unable to perform an encrypt operation against the CloudKMS key used for
     * etcd level encryption.
     * </pre>
     *
     * <code>CLOUD_KMS_KEY_ERROR = 7;</code>
     */
    CLOUD_KMS_KEY_ERROR(7),
    /**
     *
     *
     * <pre>
     * Cluster CA is expiring soon.
     * </pre>
     *
     * <code>CA_EXPIRING = 9;</code>
     */
    CA_EXPIRING(9),
    /**
     *
     *
     * <pre>
     * Node service account is missing permissions.
     * </pre>
     *
     * <code>NODE_SERVICE_ACCOUNT_MISSING_PERMISSIONS = 10;</code>
     */
    NODE_SERVICE_ACCOUNT_MISSING_PERMISSIONS(10),
    /**
     *
     *
     * <pre>
     * Cloud KMS key version used for etcd level encryption has been destroyed.
     * This is a permanent error.
     * </pre>
     *
     * <code>CLOUD_KMS_KEY_DESTROYED = 11;</code>
     */
    CLOUD_KMS_KEY_DESTROYED(11),
    UNRECOGNIZED(-1),
    ;

    /**
     *
     *
     * <pre>
     * UNKNOWN indicates a generic condition.
     * </pre>
     *
     * <code>UNKNOWN = 0;</code>
     */
    public static final int UNKNOWN_VALUE = 0;

    /**
     *
     *
     * <pre>
     * GCE_STOCKOUT indicates that Google Compute Engine resources are
     * temporarily unavailable.
     * </pre>
     *
     * <code>GCE_STOCKOUT = 1;</code>
     */
    public static final int GCE_STOCKOUT_VALUE = 1;

    /**
     *
     *
     * <pre>
     * GKE_SERVICE_ACCOUNT_DELETED indicates that the user deleted their robot
     * service account.
     * </pre>
     *
     * <code>GKE_SERVICE_ACCOUNT_DELETED = 2;</code>
     */
    public static final int GKE_SERVICE_ACCOUNT_DELETED_VALUE = 2;

    /**
     *
     *
     * <pre>
     * Google Compute Engine quota was exceeded.
     * </pre>
     *
     * <code>GCE_QUOTA_EXCEEDED = 3;</code>
     */
    public static final int GCE_QUOTA_EXCEEDED_VALUE = 3;

    /**
     *
     *
     * <pre>
     * Cluster state was manually changed by an SRE due to a system logic error.
     * </pre>
     *
     * <code>SET_BY_OPERATOR = 4;</code>
     */
    public static final int SET_BY_OPERATOR_VALUE = 4;

    /**
     *
     *
     * <pre>
     * Unable to perform an encrypt operation against the CloudKMS key used for
     * etcd level encryption.
     * </pre>
     *
     * <code>CLOUD_KMS_KEY_ERROR = 7;</code>
     */
    public static final int CLOUD_KMS_KEY_ERROR_VALUE = 7;

    /**
     *
     *
     * <pre>
     * Cluster CA is expiring soon.
     * </pre>
     *
     * <code>CA_EXPIRING = 9;</code>
     */
    public static final int CA_EXPIRING_VALUE = 9;

    /**
     *
     *
     * <pre>
     * Node service account is missing permissions.
     * </pre>
     *
     * <code>NODE_SERVICE_ACCOUNT_MISSING_PERMISSIONS = 10;</code>
     */
    public static final int NODE_SERVICE_ACCOUNT_MISSING_PERMISSIONS_VALUE = 10;

    /**
     *
     *
     * <pre>
     * Cloud KMS key version used for etcd level encryption has been destroyed.
     * This is a permanent error.
     * </pre>
     *
     * <code>CLOUD_KMS_KEY_DESTROYED = 11;</code>
     */
    public static final int CLOUD_KMS_KEY_DESTROYED_VALUE = 11;

    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Code valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Code forNumber(int value) {
      switch (value) {
        case 0:
          return UNKNOWN;
        case 1:
          return GCE_STOCKOUT;
        case 2:
          return GKE_SERVICE_ACCOUNT_DELETED;
        case 3:
          return GCE_QUOTA_EXCEEDED;
        case 4:
          return SET_BY_OPERATOR;
        case 7:
          return CLOUD_KMS_KEY_ERROR;
        case 9:
          return CA_EXPIRING;
        case 10:
          return NODE_SERVICE_ACCOUNT_MISSING_PERMISSIONS;
        case 11:
          return CLOUD_KMS_KEY_DESTROYED;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Code> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<Code> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Code>() {
          public Code findValueByNumber(int number) {
            return Code.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.google.container.v1.StatusCondition.getDescriptor().getEnumTypes().get(0);
    }

    private static final Code[] VALUES = values();

    public static Code valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Code(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.container.v1.StatusCondition.Code)
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_ = 0;

  /**
   *
   *
   * <pre>
   * Machine-friendly representation of the condition
   * Deprecated. Use canonical_code instead.
   * </pre>
   *
   * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
   *
   * @deprecated google.container.v1.StatusCondition.code is deprecated. See
   *     google/container/v1/cluster_service.proto;l=5403
   * @return The enum numeric value on the wire for code.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public int getCodeValue() {
    return code_;
  }

  /**
   *
   *
   * <pre>
   * Machine-friendly representation of the condition
   * Deprecated. Use canonical_code instead.
   * </pre>
   *
   * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
   *
   * @deprecated google.container.v1.StatusCondition.code is deprecated. See
   *     google/container/v1/cluster_service.proto;l=5403
   * @return The code.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public com.google.container.v1.StatusCondition.Code getCode() {
    com.google.container.v1.StatusCondition.Code result =
        com.google.container.v1.StatusCondition.Code.forNumber(code_);
    return result == null ? com.google.container.v1.StatusCondition.Code.UNRECOGNIZED : result;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;

  @SuppressWarnings("serial")
  private volatile java.lang.Object message_ = "";

  /**
   *
   *
   * <pre>
   * Human-friendly representation of the condition
   * </pre>
   *
   * <code>string message = 2;</code>
   *
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Human-friendly representation of the condition
   * </pre>
   *
   * <code>string message = 2;</code>
   *
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CANONICAL_CODE_FIELD_NUMBER = 3;
  private int canonicalCode_ = 0;

  /**
   *
   *
   * <pre>
   * Canonical code of the condition.
   * </pre>
   *
   * <code>.google.rpc.Code canonical_code = 3;</code>
   *
   * @return The enum numeric value on the wire for canonicalCode.
   */
  @java.lang.Override
  public int getCanonicalCodeValue() {
    return canonicalCode_;
  }

  /**
   *
   *
   * <pre>
   * Canonical code of the condition.
   * </pre>
   *
   * <code>.google.rpc.Code canonical_code = 3;</code>
   *
   * @return The canonicalCode.
   */
  @java.lang.Override
  public com.google.rpc.Code getCanonicalCode() {
    com.google.rpc.Code result = com.google.rpc.Code.forNumber(canonicalCode_);
    return result == null ? com.google.rpc.Code.UNRECOGNIZED : result;
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
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (code_ != com.google.container.v1.StatusCondition.Code.UNKNOWN.getNumber()) {
      output.writeEnum(1, code_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (canonicalCode_ != com.google.rpc.Code.OK.getNumber()) {
      output.writeEnum(3, canonicalCode_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != com.google.container.v1.StatusCondition.Code.UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, code_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (canonicalCode_ != com.google.rpc.Code.OK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(3, canonicalCode_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.container.v1.StatusCondition)) {
      return super.equals(obj);
    }
    com.google.container.v1.StatusCondition other = (com.google.container.v1.StatusCondition) obj;

    if (code_ != other.code_) return false;
    if (!getMessage().equals(other.getMessage())) return false;
    if (canonicalCode_ != other.canonicalCode_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + code_;
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + CANONICAL_CODE_FIELD_NUMBER;
    hash = (53 * hash) + canonicalCode_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.container.v1.StatusCondition parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.StatusCondition parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.StatusCondition parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.container.v1.StatusCondition parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.container.v1.StatusCondition parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.container.v1.StatusCondition parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.container.v1.StatusCondition prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  /**
   *
   *
   * <pre>
   * StatusCondition describes why a cluster or a node pool has a certain status
   * (e.g., ERROR or DEGRADED).
   * </pre>
   *
   * Protobuf type {@code google.container.v1.StatusCondition}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.container.v1.StatusCondition)
      com.google.container.v1.StatusConditionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_StatusCondition_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_StatusCondition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.container.v1.StatusCondition.class,
              com.google.container.v1.StatusCondition.Builder.class);
    }

    // Construct using com.google.container.v1.StatusCondition.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      code_ = 0;
      message_ = "";
      canonicalCode_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_StatusCondition_descriptor;
    }

    @java.lang.Override
    public com.google.container.v1.StatusCondition getDefaultInstanceForType() {
      return com.google.container.v1.StatusCondition.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.container.v1.StatusCondition build() {
      com.google.container.v1.StatusCondition result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.container.v1.StatusCondition buildPartial() {
      com.google.container.v1.StatusCondition result =
          new com.google.container.v1.StatusCondition(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.container.v1.StatusCondition result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.code_ = code_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.message_ = message_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.canonicalCode_ = canonicalCode_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.container.v1.StatusCondition) {
        return mergeFrom((com.google.container.v1.StatusCondition) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.container.v1.StatusCondition other) {
      if (other == com.google.container.v1.StatusCondition.getDefaultInstance()) return this;
      if (other.code_ != 0) {
        setCodeValue(other.getCodeValue());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.canonicalCode_ != 0) {
        setCanonicalCodeValue(other.getCanonicalCodeValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8:
              {
                code_ = input.readEnum();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
            case 18:
              {
                message_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            case 24:
              {
                canonicalCode_ = input.readEnum();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private int code_ = 0;

    /**
     *
     *
     * <pre>
     * Machine-friendly representation of the condition
     * Deprecated. Use canonical_code instead.
     * </pre>
     *
     * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
     *
     * @deprecated google.container.v1.StatusCondition.code is deprecated. See
     *     google/container/v1/cluster_service.proto;l=5403
     * @return The enum numeric value on the wire for code.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public int getCodeValue() {
      return code_;
    }

    /**
     *
     *
     * <pre>
     * Machine-friendly representation of the condition
     * Deprecated. Use canonical_code instead.
     * </pre>
     *
     * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
     *
     * @deprecated google.container.v1.StatusCondition.code is deprecated. See
     *     google/container/v1/cluster_service.proto;l=5403
     * @param value The enum numeric value on the wire for code to set.
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder setCodeValue(int value) {
      code_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Machine-friendly representation of the condition
     * Deprecated. Use canonical_code instead.
     * </pre>
     *
     * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
     *
     * @deprecated google.container.v1.StatusCondition.code is deprecated. See
     *     google/container/v1/cluster_service.proto;l=5403
     * @return The code.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public com.google.container.v1.StatusCondition.Code getCode() {
      com.google.container.v1.StatusCondition.Code result =
          com.google.container.v1.StatusCondition.Code.forNumber(code_);
      return result == null ? com.google.container.v1.StatusCondition.Code.UNRECOGNIZED : result;
    }

    /**
     *
     *
     * <pre>
     * Machine-friendly representation of the condition
     * Deprecated. Use canonical_code instead.
     * </pre>
     *
     * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
     *
     * @deprecated google.container.v1.StatusCondition.code is deprecated. See
     *     google/container/v1/cluster_service.proto;l=5403
     * @param value The code to set.
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder setCode(com.google.container.v1.StatusCondition.Code value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      code_ = value.getNumber();
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Machine-friendly representation of the condition
     * Deprecated. Use canonical_code instead.
     * </pre>
     *
     * <code>.google.container.v1.StatusCondition.Code code = 1 [deprecated = true];</code>
     *
     * @deprecated google.container.v1.StatusCondition.code is deprecated. See
     *     google/container/v1/cluster_service.proto;l=5403
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder clearCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";

    /**
     *
     *
     * <pre>
     * Human-friendly representation of the condition
     * </pre>
     *
     * <code>string message = 2;</code>
     *
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Human-friendly representation of the condition
     * </pre>
     *
     * <code>string message = 2;</code>
     *
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Human-friendly representation of the condition
     * </pre>
     *
     * <code>string message = 2;</code>
     *
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      message_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Human-friendly representation of the condition
     * </pre>
     *
     * <code>string message = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      message_ = getDefaultInstance().getMessage();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Human-friendly representation of the condition
     * </pre>
     *
     * <code>string message = 2;</code>
     *
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      message_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private int canonicalCode_ = 0;

    /**
     *
     *
     * <pre>
     * Canonical code of the condition.
     * </pre>
     *
     * <code>.google.rpc.Code canonical_code = 3;</code>
     *
     * @return The enum numeric value on the wire for canonicalCode.
     */
    @java.lang.Override
    public int getCanonicalCodeValue() {
      return canonicalCode_;
    }

    /**
     *
     *
     * <pre>
     * Canonical code of the condition.
     * </pre>
     *
     * <code>.google.rpc.Code canonical_code = 3;</code>
     *
     * @param value The enum numeric value on the wire for canonicalCode to set.
     * @return This builder for chaining.
     */
    public Builder setCanonicalCodeValue(int value) {
      canonicalCode_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Canonical code of the condition.
     * </pre>
     *
     * <code>.google.rpc.Code canonical_code = 3;</code>
     *
     * @return The canonicalCode.
     */
    @java.lang.Override
    public com.google.rpc.Code getCanonicalCode() {
      com.google.rpc.Code result = com.google.rpc.Code.forNumber(canonicalCode_);
      return result == null ? com.google.rpc.Code.UNRECOGNIZED : result;
    }

    /**
     *
     *
     * <pre>
     * Canonical code of the condition.
     * </pre>
     *
     * <code>.google.rpc.Code canonical_code = 3;</code>
     *
     * @param value The canonicalCode to set.
     * @return This builder for chaining.
     */
    public Builder setCanonicalCode(com.google.rpc.Code value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      canonicalCode_ = value.getNumber();
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Canonical code of the condition.
     * </pre>
     *
     * <code>.google.rpc.Code canonical_code = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCanonicalCode() {
      bitField0_ = (bitField0_ & ~0x00000004);
      canonicalCode_ = 0;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.container.v1.StatusCondition)
  }

  // @@protoc_insertion_point(class_scope:google.container.v1.StatusCondition)
  private static final com.google.container.v1.StatusCondition DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.container.v1.StatusCondition();
  }

  public static com.google.container.v1.StatusCondition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StatusCondition> PARSER =
      new com.google.protobuf.AbstractParser<StatusCondition>() {
        @java.lang.Override
        public StatusCondition parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<StatusCondition> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StatusCondition> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.container.v1.StatusCondition getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
