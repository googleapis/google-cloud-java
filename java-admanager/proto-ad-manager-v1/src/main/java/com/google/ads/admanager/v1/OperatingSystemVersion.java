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
// source: google/ads/admanager/v1/operating_system_version_messages.proto

// Protobuf Java Version: 3.25.8
package com.google.ads.admanager.v1;

/**
 *
 *
 * <pre>
 * Represents a specific version of an operating system.
 * </pre>
 *
 * Protobuf type {@code google.ads.admanager.v1.OperatingSystemVersion}
 */
public final class OperatingSystemVersion extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.ads.admanager.v1.OperatingSystemVersion)
    OperatingSystemVersionOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use OperatingSystemVersion.newBuilder() to construct.
  private OperatingSystemVersion(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private OperatingSystemVersion() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new OperatingSystemVersion();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.ads.admanager.v1.OperatingSystemVersionMessagesProto
        .internal_static_google_ads_admanager_v1_OperatingSystemVersion_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ads.admanager.v1.OperatingSystemVersionMessagesProto
        .internal_static_google_ads_admanager_v1_OperatingSystemVersion_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ads.admanager.v1.OperatingSystemVersion.class,
            com.google.ads.admanager.v1.OperatingSystemVersion.Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;

  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";

  /**
   *
   *
   * <pre>
   * Identifier. The resource name of the `OperatingSystemVersion`.
   * Format:
   * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
   *
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Identifier. The resource name of the `OperatingSystemVersion`.
   * Format:
   * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
   *
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MAJOR_VERSION_FIELD_NUMBER = 2;
  private int majorVersion_ = 0;

  /**
   *
   *
   * <pre>
   * Output only. The major version of the operating system.
   * </pre>
   *
   * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return Whether the majorVersion field is set.
   */
  @java.lang.Override
  public boolean hasMajorVersion() {
    return ((bitField0_ & 0x00000001) != 0);
  }

  /**
   *
   *
   * <pre>
   * Output only. The major version of the operating system.
   * </pre>
   *
   * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The majorVersion.
   */
  @java.lang.Override
  public int getMajorVersion() {
    return majorVersion_;
  }

  public static final int MINOR_VERSION_FIELD_NUMBER = 3;
  private int minorVersion_ = 0;

  /**
   *
   *
   * <pre>
   * Output only. The minor version of the operating system.
   * </pre>
   *
   * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return Whether the minorVersion field is set.
   */
  @java.lang.Override
  public boolean hasMinorVersion() {
    return ((bitField0_ & 0x00000002) != 0);
  }

  /**
   *
   *
   * <pre>
   * Output only. The minor version of the operating system.
   * </pre>
   *
   * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The minorVersion.
   */
  @java.lang.Override
  public int getMinorVersion() {
    return minorVersion_;
  }

  public static final int MICRO_VERSION_FIELD_NUMBER = 4;
  private int microVersion_ = 0;

  /**
   *
   *
   * <pre>
   * Output only. The micro version of the operating system.
   * </pre>
   *
   * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return Whether the microVersion field is set.
   */
  @java.lang.Override
  public boolean hasMicroVersion() {
    return ((bitField0_ & 0x00000004) != 0);
  }

  /**
   *
   *
   * <pre>
   * Output only. The micro version of the operating system.
   * </pre>
   *
   * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The microVersion.
   */
  @java.lang.Override
  public int getMicroVersion() {
    return microVersion_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt32(2, majorVersion_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(3, minorVersion_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeInt32(4, microVersion_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, majorVersion_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, minorVersion_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, microVersion_);
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
    if (!(obj instanceof com.google.ads.admanager.v1.OperatingSystemVersion)) {
      return super.equals(obj);
    }
    com.google.ads.admanager.v1.OperatingSystemVersion other =
        (com.google.ads.admanager.v1.OperatingSystemVersion) obj;

    if (!getName().equals(other.getName())) return false;
    if (hasMajorVersion() != other.hasMajorVersion()) return false;
    if (hasMajorVersion()) {
      if (getMajorVersion() != other.getMajorVersion()) return false;
    }
    if (hasMinorVersion() != other.hasMinorVersion()) return false;
    if (hasMinorVersion()) {
      if (getMinorVersion() != other.getMinorVersion()) return false;
    }
    if (hasMicroVersion() != other.hasMicroVersion()) return false;
    if (hasMicroVersion()) {
      if (getMicroVersion() != other.getMicroVersion()) return false;
    }
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (hasMajorVersion()) {
      hash = (37 * hash) + MAJOR_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getMajorVersion();
    }
    if (hasMinorVersion()) {
      hash = (37 * hash) + MINOR_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getMinorVersion();
    }
    if (hasMicroVersion()) {
      hash = (37 * hash) + MICRO_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getMicroVersion();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion parseFrom(
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

  public static Builder newBuilder(com.google.ads.admanager.v1.OperatingSystemVersion prototype) {
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
   * Represents a specific version of an operating system.
   * </pre>
   *
   * Protobuf type {@code google.ads.admanager.v1.OperatingSystemVersion}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.ads.admanager.v1.OperatingSystemVersion)
      com.google.ads.admanager.v1.OperatingSystemVersionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.ads.admanager.v1.OperatingSystemVersionMessagesProto
          .internal_static_google_ads_admanager_v1_OperatingSystemVersion_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ads.admanager.v1.OperatingSystemVersionMessagesProto
          .internal_static_google_ads_admanager_v1_OperatingSystemVersion_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ads.admanager.v1.OperatingSystemVersion.class,
              com.google.ads.admanager.v1.OperatingSystemVersion.Builder.class);
    }

    // Construct using com.google.ads.admanager.v1.OperatingSystemVersion.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      name_ = "";
      majorVersion_ = 0;
      minorVersion_ = 0;
      microVersion_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.ads.admanager.v1.OperatingSystemVersionMessagesProto
          .internal_static_google_ads_admanager_v1_OperatingSystemVersion_descriptor;
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.OperatingSystemVersion getDefaultInstanceForType() {
      return com.google.ads.admanager.v1.OperatingSystemVersion.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.OperatingSystemVersion build() {
      com.google.ads.admanager.v1.OperatingSystemVersion result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.OperatingSystemVersion buildPartial() {
      com.google.ads.admanager.v1.OperatingSystemVersion result =
          new com.google.ads.admanager.v1.OperatingSystemVersion(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.ads.admanager.v1.OperatingSystemVersion result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.majorVersion_ = majorVersion_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.minorVersion_ = minorVersion_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.microVersion_ = microVersion_;
        to_bitField0_ |= 0x00000004;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof com.google.ads.admanager.v1.OperatingSystemVersion) {
        return mergeFrom((com.google.ads.admanager.v1.OperatingSystemVersion) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ads.admanager.v1.OperatingSystemVersion other) {
      if (other == com.google.ads.admanager.v1.OperatingSystemVersion.getDefaultInstance())
        return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasMajorVersion()) {
        setMajorVersion(other.getMajorVersion());
      }
      if (other.hasMinorVersion()) {
        setMinorVersion(other.getMinorVersion());
      }
      if (other.hasMicroVersion()) {
        setMicroVersion(other.getMicroVersion());
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
            case 10:
              {
                name_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 16:
              {
                majorVersion_ = input.readInt32();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
            case 24:
              {
                minorVersion_ = input.readInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
            case 32:
              {
                microVersion_ = input.readInt32();
                bitField0_ |= 0x00000008;
                break;
              } // case 32
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

    private java.lang.Object name_ = "";

    /**
     *
     *
     * <pre>
     * Identifier. The resource name of the `OperatingSystemVersion`.
     * Format:
     * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
     * </pre>
     *
     * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
     *
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Identifier. The resource name of the `OperatingSystemVersion`.
     * Format:
     * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
     * </pre>
     *
     * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
     *
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Identifier. The resource name of the `OperatingSystemVersion`.
     * Format:
     * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
     * </pre>
     *
     * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
     *
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Identifier. The resource name of the `OperatingSystemVersion`.
     * Format:
     * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
     * </pre>
     *
     * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Identifier. The resource name of the `OperatingSystemVersion`.
     * Format:
     * `networks/{network_code}/operatingSystemVersions/{operating_system_version_id}`
     * </pre>
     *
     * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
     *
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int majorVersion_;

    /**
     *
     *
     * <pre>
     * Output only. The major version of the operating system.
     * </pre>
     *
     * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return Whether the majorVersion field is set.
     */
    @java.lang.Override
    public boolean hasMajorVersion() {
      return ((bitField0_ & 0x00000002) != 0);
    }

    /**
     *
     *
     * <pre>
     * Output only. The major version of the operating system.
     * </pre>
     *
     * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return The majorVersion.
     */
    @java.lang.Override
    public int getMajorVersion() {
      return majorVersion_;
    }

    /**
     *
     *
     * <pre>
     * Output only. The major version of the operating system.
     * </pre>
     *
     * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @param value The majorVersion to set.
     * @return This builder for chaining.
     */
    public Builder setMajorVersion(int value) {

      majorVersion_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The major version of the operating system.
     * </pre>
     *
     * <code>optional int32 major_version = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMajorVersion() {
      bitField0_ = (bitField0_ & ~0x00000002);
      majorVersion_ = 0;
      onChanged();
      return this;
    }

    private int minorVersion_;

    /**
     *
     *
     * <pre>
     * Output only. The minor version of the operating system.
     * </pre>
     *
     * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return Whether the minorVersion field is set.
     */
    @java.lang.Override
    public boolean hasMinorVersion() {
      return ((bitField0_ & 0x00000004) != 0);
    }

    /**
     *
     *
     * <pre>
     * Output only. The minor version of the operating system.
     * </pre>
     *
     * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return The minorVersion.
     */
    @java.lang.Override
    public int getMinorVersion() {
      return minorVersion_;
    }

    /**
     *
     *
     * <pre>
     * Output only. The minor version of the operating system.
     * </pre>
     *
     * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @param value The minorVersion to set.
     * @return This builder for chaining.
     */
    public Builder setMinorVersion(int value) {

      minorVersion_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The minor version of the operating system.
     * </pre>
     *
     * <code>optional int32 minor_version = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMinorVersion() {
      bitField0_ = (bitField0_ & ~0x00000004);
      minorVersion_ = 0;
      onChanged();
      return this;
    }

    private int microVersion_;

    /**
     *
     *
     * <pre>
     * Output only. The micro version of the operating system.
     * </pre>
     *
     * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return Whether the microVersion field is set.
     */
    @java.lang.Override
    public boolean hasMicroVersion() {
      return ((bitField0_ & 0x00000008) != 0);
    }

    /**
     *
     *
     * <pre>
     * Output only. The micro version of the operating system.
     * </pre>
     *
     * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return The microVersion.
     */
    @java.lang.Override
    public int getMicroVersion() {
      return microVersion_;
    }

    /**
     *
     *
     * <pre>
     * Output only. The micro version of the operating system.
     * </pre>
     *
     * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @param value The microVersion to set.
     * @return This builder for chaining.
     */
    public Builder setMicroVersion(int value) {

      microVersion_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The micro version of the operating system.
     * </pre>
     *
     * <code>optional int32 micro_version = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMicroVersion() {
      bitField0_ = (bitField0_ & ~0x00000008);
      microVersion_ = 0;
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

    // @@protoc_insertion_point(builder_scope:google.ads.admanager.v1.OperatingSystemVersion)
  }

  // @@protoc_insertion_point(class_scope:google.ads.admanager.v1.OperatingSystemVersion)
  private static final com.google.ads.admanager.v1.OperatingSystemVersion DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.ads.admanager.v1.OperatingSystemVersion();
  }

  public static com.google.ads.admanager.v1.OperatingSystemVersion getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OperatingSystemVersion> PARSER =
      new com.google.protobuf.AbstractParser<OperatingSystemVersion>() {
        @java.lang.Override
        public OperatingSystemVersion parsePartialFrom(
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

  public static com.google.protobuf.Parser<OperatingSystemVersion> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OperatingSystemVersion> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ads.admanager.v1.OperatingSystemVersion getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
