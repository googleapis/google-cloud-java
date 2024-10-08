/*
 * Copyright 2024 Google LLC
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
// source: google/cloud/compute/v1/compute.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.compute.v1;

/**
 *
 *
 * <pre>
 * </pre>
 *
 * Protobuf type {@code
 * google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig}
 */
public final class SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
    extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
    SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfigOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig.newBuilder()
  // to construct.
  private SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.compute.v1.Compute
        .internal_static_google_cloud_compute_v1_SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.compute.v1.Compute
        .internal_static_google_cloud_compute_v1_SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.compute.v1
                .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig.class,
            com.google.cloud.compute.v1
                .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
                .Builder.class);
  }

  private int bitField0_;
  public static final int AUTO_DEPLOY_CONFIDENCE_THRESHOLD_FIELD_NUMBER = 84309694;
  private float autoDeployConfidenceThreshold_ = 0F;
  /**
   * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
   *
   * @return Whether the autoDeployConfidenceThreshold field is set.
   */
  @java.lang.Override
  public boolean hasAutoDeployConfidenceThreshold() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
   *
   * @return The autoDeployConfidenceThreshold.
   */
  @java.lang.Override
  public float getAutoDeployConfidenceThreshold() {
    return autoDeployConfidenceThreshold_;
  }

  public static final int AUTO_DEPLOY_EXPIRATION_SEC_FIELD_NUMBER = 69638793;
  private int autoDeployExpirationSec_ = 0;
  /**
   * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
   *
   * @return Whether the autoDeployExpirationSec field is set.
   */
  @java.lang.Override
  public boolean hasAutoDeployExpirationSec() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
   *
   * @return The autoDeployExpirationSec.
   */
  @java.lang.Override
  public int getAutoDeployExpirationSec() {
    return autoDeployExpirationSec_;
  }

  public static final int AUTO_DEPLOY_IMPACTED_BASELINE_THRESHOLD_FIELD_NUMBER = 292441667;
  private float autoDeployImpactedBaselineThreshold_ = 0F;
  /**
   * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
   *
   * @return Whether the autoDeployImpactedBaselineThreshold field is set.
   */
  @java.lang.Override
  public boolean hasAutoDeployImpactedBaselineThreshold() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
   *
   * @return The autoDeployImpactedBaselineThreshold.
   */
  @java.lang.Override
  public float getAutoDeployImpactedBaselineThreshold() {
    return autoDeployImpactedBaselineThreshold_;
  }

  public static final int AUTO_DEPLOY_LOAD_THRESHOLD_FIELD_NUMBER = 522227738;
  private float autoDeployLoadThreshold_ = 0F;
  /**
   * <code>optional float auto_deploy_load_threshold = 522227738;</code>
   *
   * @return Whether the autoDeployLoadThreshold field is set.
   */
  @java.lang.Override
  public boolean hasAutoDeployLoadThreshold() {
    return ((bitField0_ & 0x00000008) != 0);
  }
  /**
   * <code>optional float auto_deploy_load_threshold = 522227738;</code>
   *
   * @return The autoDeployLoadThreshold.
   */
  @java.lang.Override
  public float getAutoDeployLoadThreshold() {
    return autoDeployLoadThreshold_;
  }

  public static final int NAME_FIELD_NUMBER = 3373707;

  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   *
   *
   * <pre>
   * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
   * </pre>
   *
   * <code>optional string name = 3373707;</code>
   *
   * @return Whether the name field is set.
   */
  @java.lang.Override
  public boolean hasName() {
    return ((bitField0_ & 0x00000010) != 0);
  }
  /**
   *
   *
   * <pre>
   * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
   * </pre>
   *
   * <code>optional string name = 3373707;</code>
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
   * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
   * </pre>
   *
   * <code>optional string name = 3373707;</code>
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
    if (((bitField0_ & 0x00000010) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3373707, name_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(69638793, autoDeployExpirationSec_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeFloat(84309694, autoDeployConfidenceThreshold_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeFloat(292441667, autoDeployImpactedBaselineThreshold_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      output.writeFloat(522227738, autoDeployLoadThreshold_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000010) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3373707, name_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size +=
          com.google.protobuf.CodedOutputStream.computeInt32Size(
              69638793, autoDeployExpirationSec_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size +=
          com.google.protobuf.CodedOutputStream.computeFloatSize(
              84309694, autoDeployConfidenceThreshold_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size +=
          com.google.protobuf.CodedOutputStream.computeFloatSize(
              292441667, autoDeployImpactedBaselineThreshold_);
    }
    if (((bitField0_ & 0x00000008) != 0)) {
      size +=
          com.google.protobuf.CodedOutputStream.computeFloatSize(
              522227738, autoDeployLoadThreshold_);
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
    if (!(obj
        instanceof
        com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)) {
      return super.equals(obj);
    }
    com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
        other =
            (com.google.cloud.compute.v1
                    .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
                obj;

    if (hasAutoDeployConfidenceThreshold() != other.hasAutoDeployConfidenceThreshold())
      return false;
    if (hasAutoDeployConfidenceThreshold()) {
      if (java.lang.Float.floatToIntBits(getAutoDeployConfidenceThreshold())
          != java.lang.Float.floatToIntBits(other.getAutoDeployConfidenceThreshold())) return false;
    }
    if (hasAutoDeployExpirationSec() != other.hasAutoDeployExpirationSec()) return false;
    if (hasAutoDeployExpirationSec()) {
      if (getAutoDeployExpirationSec() != other.getAutoDeployExpirationSec()) return false;
    }
    if (hasAutoDeployImpactedBaselineThreshold() != other.hasAutoDeployImpactedBaselineThreshold())
      return false;
    if (hasAutoDeployImpactedBaselineThreshold()) {
      if (java.lang.Float.floatToIntBits(getAutoDeployImpactedBaselineThreshold())
          != java.lang.Float.floatToIntBits(other.getAutoDeployImpactedBaselineThreshold()))
        return false;
    }
    if (hasAutoDeployLoadThreshold() != other.hasAutoDeployLoadThreshold()) return false;
    if (hasAutoDeployLoadThreshold()) {
      if (java.lang.Float.floatToIntBits(getAutoDeployLoadThreshold())
          != java.lang.Float.floatToIntBits(other.getAutoDeployLoadThreshold())) return false;
    }
    if (hasName() != other.hasName()) return false;
    if (hasName()) {
      if (!getName().equals(other.getName())) return false;
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
    if (hasAutoDeployConfidenceThreshold()) {
      hash = (37 * hash) + AUTO_DEPLOY_CONFIDENCE_THRESHOLD_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(getAutoDeployConfidenceThreshold());
    }
    if (hasAutoDeployExpirationSec()) {
      hash = (37 * hash) + AUTO_DEPLOY_EXPIRATION_SEC_FIELD_NUMBER;
      hash = (53 * hash) + getAutoDeployExpirationSec();
    }
    if (hasAutoDeployImpactedBaselineThreshold()) {
      hash = (37 * hash) + AUTO_DEPLOY_IMPACTED_BASELINE_THRESHOLD_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(getAutoDeployImpactedBaselineThreshold());
    }
    if (hasAutoDeployLoadThreshold()) {
      hash = (37 * hash) + AUTO_DEPLOY_LOAD_THRESHOLD_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(getAutoDeployLoadThreshold());
    }
    if (hasName()) {
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(
          java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      parseFrom(
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

  public static Builder newBuilder(
      com.google.cloud.compute.v1
              .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
          prototype) {
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
   * </pre>
   *
   * Protobuf type {@code
   * google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
      com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.compute.v1.Compute
          .internal_static_google_cloud_compute_v1_SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.compute.v1.Compute
          .internal_static_google_cloud_compute_v1_SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.compute.v1
                  .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
                  .class,
              com.google.cloud.compute.v1
                  .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
                  .Builder.class);
    }

    // Construct using
    // com.google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      autoDeployConfidenceThreshold_ = 0F;
      autoDeployExpirationSec_ = 0;
      autoDeployImpactedBaselineThreshold_ = 0F;
      autoDeployLoadThreshold_ = 0F;
      name_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.compute.v1.Compute
          .internal_static_google_cloud_compute_v1_SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
        getDefaultInstanceForType() {
      return com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
          .getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
        build() {
      com.google.cloud.compute.v1
              .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
          result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
        buildPartial() {
      com.google.cloud.compute.v1
              .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
          result =
              new com.google.cloud.compute.v1
                  .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig(
                  this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(
        com.google.cloud.compute.v1
                .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
            result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.autoDeployConfidenceThreshold_ = autoDeployConfidenceThreshold_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.autoDeployExpirationSec_ = autoDeployExpirationSec_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.autoDeployImpactedBaselineThreshold_ = autoDeployImpactedBaselineThreshold_;
        to_bitField0_ |= 0x00000004;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.autoDeployLoadThreshold_ = autoDeployLoadThreshold_;
        to_bitField0_ |= 0x00000008;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.name_ = name_;
        to_bitField0_ |= 0x00000010;
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
      if (other
          instanceof
          com.google.cloud.compute.v1
              .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig) {
        return mergeFrom(
            (com.google.cloud.compute.v1
                    .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
                other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.google.cloud.compute.v1
                .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
            other) {
      if (other
          == com.google.cloud.compute.v1
              .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
              .getDefaultInstance()) return this;
      if (other.hasAutoDeployConfidenceThreshold()) {
        setAutoDeployConfidenceThreshold(other.getAutoDeployConfidenceThreshold());
      }
      if (other.hasAutoDeployExpirationSec()) {
        setAutoDeployExpirationSec(other.getAutoDeployExpirationSec());
      }
      if (other.hasAutoDeployImpactedBaselineThreshold()) {
        setAutoDeployImpactedBaselineThreshold(other.getAutoDeployImpactedBaselineThreshold());
      }
      if (other.hasAutoDeployLoadThreshold()) {
        setAutoDeployLoadThreshold(other.getAutoDeployLoadThreshold());
      }
      if (other.hasName()) {
        name_ = other.name_;
        bitField0_ |= 0x00000010;
        onChanged();
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
            case 26989658:
              {
                name_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000010;
                break;
              } // case 26989658
            case 557110344:
              {
                autoDeployExpirationSec_ = input.readInt32();
                bitField0_ |= 0x00000002;
                break;
              } // case 557110344
            case 674477557:
              {
                autoDeployConfidenceThreshold_ = input.readFloat();
                bitField0_ |= 0x00000001;
                break;
              } // case 674477557
            case -1955433955:
              {
                autoDeployImpactedBaselineThreshold_ = input.readFloat();
                bitField0_ |= 0x00000004;
                break;
              } // case -1955433955
            case -117145387:
              {
                autoDeployLoadThreshold_ = input.readFloat();
                bitField0_ |= 0x00000008;
                break;
              } // case -117145387
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

    private float autoDeployConfidenceThreshold_;
    /**
     * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
     *
     * @return Whether the autoDeployConfidenceThreshold field is set.
     */
    @java.lang.Override
    public boolean hasAutoDeployConfidenceThreshold() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
     *
     * @return The autoDeployConfidenceThreshold.
     */
    @java.lang.Override
    public float getAutoDeployConfidenceThreshold() {
      return autoDeployConfidenceThreshold_;
    }
    /**
     * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
     *
     * @param value The autoDeployConfidenceThreshold to set.
     * @return This builder for chaining.
     */
    public Builder setAutoDeployConfidenceThreshold(float value) {

      autoDeployConfidenceThreshold_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>optional float auto_deploy_confidence_threshold = 84309694;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAutoDeployConfidenceThreshold() {
      bitField0_ = (bitField0_ & ~0x00000001);
      autoDeployConfidenceThreshold_ = 0F;
      onChanged();
      return this;
    }

    private int autoDeployExpirationSec_;
    /**
     * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
     *
     * @return Whether the autoDeployExpirationSec field is set.
     */
    @java.lang.Override
    public boolean hasAutoDeployExpirationSec() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
     *
     * @return The autoDeployExpirationSec.
     */
    @java.lang.Override
    public int getAutoDeployExpirationSec() {
      return autoDeployExpirationSec_;
    }
    /**
     * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
     *
     * @param value The autoDeployExpirationSec to set.
     * @return This builder for chaining.
     */
    public Builder setAutoDeployExpirationSec(int value) {

      autoDeployExpirationSec_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 auto_deploy_expiration_sec = 69638793;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAutoDeployExpirationSec() {
      bitField0_ = (bitField0_ & ~0x00000002);
      autoDeployExpirationSec_ = 0;
      onChanged();
      return this;
    }

    private float autoDeployImpactedBaselineThreshold_;
    /**
     * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
     *
     * @return Whether the autoDeployImpactedBaselineThreshold field is set.
     */
    @java.lang.Override
    public boolean hasAutoDeployImpactedBaselineThreshold() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
     *
     * @return The autoDeployImpactedBaselineThreshold.
     */
    @java.lang.Override
    public float getAutoDeployImpactedBaselineThreshold() {
      return autoDeployImpactedBaselineThreshold_;
    }
    /**
     * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
     *
     * @param value The autoDeployImpactedBaselineThreshold to set.
     * @return This builder for chaining.
     */
    public Builder setAutoDeployImpactedBaselineThreshold(float value) {

      autoDeployImpactedBaselineThreshold_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional float auto_deploy_impacted_baseline_threshold = 292441667;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAutoDeployImpactedBaselineThreshold() {
      bitField0_ = (bitField0_ & ~0x00000004);
      autoDeployImpactedBaselineThreshold_ = 0F;
      onChanged();
      return this;
    }

    private float autoDeployLoadThreshold_;
    /**
     * <code>optional float auto_deploy_load_threshold = 522227738;</code>
     *
     * @return Whether the autoDeployLoadThreshold field is set.
     */
    @java.lang.Override
    public boolean hasAutoDeployLoadThreshold() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional float auto_deploy_load_threshold = 522227738;</code>
     *
     * @return The autoDeployLoadThreshold.
     */
    @java.lang.Override
    public float getAutoDeployLoadThreshold() {
      return autoDeployLoadThreshold_;
    }
    /**
     * <code>optional float auto_deploy_load_threshold = 522227738;</code>
     *
     * @param value The autoDeployLoadThreshold to set.
     * @return This builder for chaining.
     */
    public Builder setAutoDeployLoadThreshold(float value) {

      autoDeployLoadThreshold_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>optional float auto_deploy_load_threshold = 522227738;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAutoDeployLoadThreshold() {
      bitField0_ = (bitField0_ & ~0x00000008);
      autoDeployLoadThreshold_ = 0F;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     *
     *
     * <pre>
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
     *
     * @return Whether the name field is set.
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000010) != 0);
    }
    /**
     *
     *
     * <pre>
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
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
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
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
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
     *
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      name_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000010);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The name must be 1-63 characters long, and comply with RFC1035. The name must be unique within the security policy.
     * </pre>
     *
     * <code>optional string name = 3373707;</code>
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
      bitField0_ |= 0x00000010;
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

    // @@protoc_insertion_point(builder_scope:google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.compute.v1.SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig)
  private static final com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE =
        new com.google.cloud.compute.v1
            .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig();
  }

  public static com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<
          SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig>
      PARSER =
          new com.google.protobuf.AbstractParser<
              SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig>() {
            @java.lang.Override
            public SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
                parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
              Builder builder = newBuilder();
              try {
                builder.mergeFrom(input, extensionRegistry);
              } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());
              } catch (com.google.protobuf.UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException()
                    .setUnfinishedMessage(builder.buildPartial());
              } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                    .setUnfinishedMessage(builder.buildPartial());
              }
              return builder.buildPartial();
            }
          };

  public static com.google.protobuf.Parser<
          SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig>
      parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<
          SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig>
      getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.compute.v1
          .SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfigThresholdConfig
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
