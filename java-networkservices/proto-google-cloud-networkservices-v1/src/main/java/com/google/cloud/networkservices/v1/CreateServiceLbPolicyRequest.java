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
// source: google/cloud/networkservices/v1/service_lb_policy.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.networkservices.v1;

/**
 *
 *
 * <pre>
 * Request used by the ServiceLbPolicy method.
 * </pre>
 *
 * Protobuf type {@code google.cloud.networkservices.v1.CreateServiceLbPolicyRequest}
 */
public final class CreateServiceLbPolicyRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.networkservices.v1.CreateServiceLbPolicyRequest)
    CreateServiceLbPolicyRequestOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use CreateServiceLbPolicyRequest.newBuilder() to construct.
  private CreateServiceLbPolicyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private CreateServiceLbPolicyRequest() {
    parent_ = "";
    serviceLbPolicyId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new CreateServiceLbPolicyRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.networkservices.v1.ServiceLbPolicyProto
        .internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.networkservices.v1.ServiceLbPolicyProto
        .internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.class,
            com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.Builder.class);
  }

  private int bitField0_;
  public static final int PARENT_FIELD_NUMBER = 1;

  @SuppressWarnings("serial")
  private volatile java.lang.Object parent_ = "";

  /**
   *
   *
   * <pre>
   * Required. The parent resource of the ServiceLbPolicy. Must be in the
   * format `projects/{project}/locations/{location}`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  @java.lang.Override
  public java.lang.String getParent() {
    java.lang.Object ref = parent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      parent_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Required. The parent resource of the ServiceLbPolicy. Must be in the
   * format `projects/{project}/locations/{location}`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getParentBytes() {
    java.lang.Object ref = parent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      parent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVICE_LB_POLICY_ID_FIELD_NUMBER = 2;

  @SuppressWarnings("serial")
  private volatile java.lang.Object serviceLbPolicyId_ = "";

  /**
   *
   *
   * <pre>
   * Required. Short name of the ServiceLbPolicy resource to be created.
   * E.g. for resource name
   * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
   * the id is value of {service_lb_policy_name}
   * </pre>
   *
   * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The serviceLbPolicyId.
   */
  @java.lang.Override
  public java.lang.String getServiceLbPolicyId() {
    java.lang.Object ref = serviceLbPolicyId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serviceLbPolicyId_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Required. Short name of the ServiceLbPolicy resource to be created.
   * E.g. for resource name
   * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
   * the id is value of {service_lb_policy_name}
   * </pre>
   *
   * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for serviceLbPolicyId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getServiceLbPolicyIdBytes() {
    java.lang.Object ref = serviceLbPolicyId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      serviceLbPolicyId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVICE_LB_POLICY_FIELD_NUMBER = 3;
  private com.google.cloud.networkservices.v1.ServiceLbPolicy serviceLbPolicy_;

  /**
   *
   *
   * <pre>
   * Required. ServiceLbPolicy resource to be created.
   * </pre>
   *
   * <code>
   * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the serviceLbPolicy field is set.
   */
  @java.lang.Override
  public boolean hasServiceLbPolicy() {
    return ((bitField0_ & 0x00000001) != 0);
  }

  /**
   *
   *
   * <pre>
   * Required. ServiceLbPolicy resource to be created.
   * </pre>
   *
   * <code>
   * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The serviceLbPolicy.
   */
  @java.lang.Override
  public com.google.cloud.networkservices.v1.ServiceLbPolicy getServiceLbPolicy() {
    return serviceLbPolicy_ == null
        ? com.google.cloud.networkservices.v1.ServiceLbPolicy.getDefaultInstance()
        : serviceLbPolicy_;
  }

  /**
   *
   *
   * <pre>
   * Required. ServiceLbPolicy resource to be created.
   * </pre>
   *
   * <code>
   * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  @java.lang.Override
  public com.google.cloud.networkservices.v1.ServiceLbPolicyOrBuilder
      getServiceLbPolicyOrBuilder() {
    return serviceLbPolicy_ == null
        ? com.google.cloud.networkservices.v1.ServiceLbPolicy.getDefaultInstance()
        : serviceLbPolicy_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(parent_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, parent_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(serviceLbPolicyId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serviceLbPolicyId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getServiceLbPolicy());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(parent_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, parent_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(serviceLbPolicyId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serviceLbPolicyId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getServiceLbPolicy());
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
    if (!(obj instanceof com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest)) {
      return super.equals(obj);
    }
    com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest other =
        (com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest) obj;

    if (!getParent().equals(other.getParent())) return false;
    if (!getServiceLbPolicyId().equals(other.getServiceLbPolicyId())) return false;
    if (hasServiceLbPolicy() != other.hasServiceLbPolicy()) return false;
    if (hasServiceLbPolicy()) {
      if (!getServiceLbPolicy().equals(other.getServiceLbPolicy())) return false;
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
    hash = (37 * hash) + PARENT_FIELD_NUMBER;
    hash = (53 * hash) + getParent().hashCode();
    hash = (37 * hash) + SERVICE_LB_POLICY_ID_FIELD_NUMBER;
    hash = (53 * hash) + getServiceLbPolicyId().hashCode();
    if (hasServiceLbPolicy()) {
      hash = (37 * hash) + SERVICE_LB_POLICY_FIELD_NUMBER;
      hash = (53 * hash) + getServiceLbPolicy().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest parseFrom(
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
      com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest prototype) {
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
   * Request used by the ServiceLbPolicy method.
   * </pre>
   *
   * Protobuf type {@code google.cloud.networkservices.v1.CreateServiceLbPolicyRequest}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.networkservices.v1.CreateServiceLbPolicyRequest)
      com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.networkservices.v1.ServiceLbPolicyProto
          .internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.networkservices.v1.ServiceLbPolicyProto
          .internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.class,
              com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.Builder.class);
    }

    // Construct using com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getServiceLbPolicyFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      parent_ = "";
      serviceLbPolicyId_ = "";
      serviceLbPolicy_ = null;
      if (serviceLbPolicyBuilder_ != null) {
        serviceLbPolicyBuilder_.dispose();
        serviceLbPolicyBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.networkservices.v1.ServiceLbPolicyProto
          .internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest
        getDefaultInstanceForType() {
      return com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest build() {
      com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest buildPartial() {
      com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest result =
          new com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(
        com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.parent_ = parent_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.serviceLbPolicyId_ = serviceLbPolicyId_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.serviceLbPolicy_ =
            serviceLbPolicyBuilder_ == null ? serviceLbPolicy_ : serviceLbPolicyBuilder_.build();
        to_bitField0_ |= 0x00000001;
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
      if (other instanceof com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest) {
        return mergeFrom((com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest other) {
      if (other
          == com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest.getDefaultInstance())
        return this;
      if (!other.getParent().isEmpty()) {
        parent_ = other.parent_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getServiceLbPolicyId().isEmpty()) {
        serviceLbPolicyId_ = other.serviceLbPolicyId_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.hasServiceLbPolicy()) {
        mergeServiceLbPolicy(other.getServiceLbPolicy());
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
                parent_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 18:
              {
                serviceLbPolicyId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            case 26:
              {
                input.readMessage(getServiceLbPolicyFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000004;
                break;
              } // case 26
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

    private java.lang.Object parent_ = "";

    /**
     *
     *
     * <pre>
     * Required. The parent resource of the ServiceLbPolicy. Must be in the
     * format `projects/{project}/locations/{location}`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return The parent.
     */
    public java.lang.String getParent() {
      java.lang.Object ref = parent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        parent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Required. The parent resource of the ServiceLbPolicy. Must be in the
     * format `projects/{project}/locations/{location}`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return The bytes for parent.
     */
    public com.google.protobuf.ByteString getParentBytes() {
      java.lang.Object ref = parent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        parent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Required. The parent resource of the ServiceLbPolicy. Must be in the
     * format `projects/{project}/locations/{location}`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @param value The parent to set.
     * @return This builder for chaining.
     */
    public Builder setParent(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      parent_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. The parent resource of the ServiceLbPolicy. Must be in the
     * format `projects/{project}/locations/{location}`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return This builder for chaining.
     */
    public Builder clearParent() {
      parent_ = getDefaultInstance().getParent();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. The parent resource of the ServiceLbPolicy. Must be in the
     * format `projects/{project}/locations/{location}`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @param value The bytes for parent to set.
     * @return This builder for chaining.
     */
    public Builder setParentBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      parent_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object serviceLbPolicyId_ = "";

    /**
     *
     *
     * <pre>
     * Required. Short name of the ServiceLbPolicy resource to be created.
     * E.g. for resource name
     * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
     * the id is value of {service_lb_policy_name}
     * </pre>
     *
     * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return The serviceLbPolicyId.
     */
    public java.lang.String getServiceLbPolicyId() {
      java.lang.Object ref = serviceLbPolicyId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serviceLbPolicyId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Required. Short name of the ServiceLbPolicy resource to be created.
     * E.g. for resource name
     * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
     * the id is value of {service_lb_policy_name}
     * </pre>
     *
     * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return The bytes for serviceLbPolicyId.
     */
    public com.google.protobuf.ByteString getServiceLbPolicyIdBytes() {
      java.lang.Object ref = serviceLbPolicyId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        serviceLbPolicyId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Required. Short name of the ServiceLbPolicy resource to be created.
     * E.g. for resource name
     * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
     * the id is value of {service_lb_policy_name}
     * </pre>
     *
     * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @param value The serviceLbPolicyId to set.
     * @return This builder for chaining.
     */
    public Builder setServiceLbPolicyId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      serviceLbPolicyId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. Short name of the ServiceLbPolicy resource to be created.
     * E.g. for resource name
     * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
     * the id is value of {service_lb_policy_name}
     * </pre>
     *
     * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearServiceLbPolicyId() {
      serviceLbPolicyId_ = getDefaultInstance().getServiceLbPolicyId();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. Short name of the ServiceLbPolicy resource to be created.
     * E.g. for resource name
     * `projects/{project}/locations/{location}/serviceLbPolicies/{service_lb_policy_name}`.
     * the id is value of {service_lb_policy_name}
     * </pre>
     *
     * <code>string service_lb_policy_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @param value The bytes for serviceLbPolicyId to set.
     * @return This builder for chaining.
     */
    public Builder setServiceLbPolicyIdBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      serviceLbPolicyId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private com.google.cloud.networkservices.v1.ServiceLbPolicy serviceLbPolicy_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.networkservices.v1.ServiceLbPolicy,
            com.google.cloud.networkservices.v1.ServiceLbPolicy.Builder,
            com.google.cloud.networkservices.v1.ServiceLbPolicyOrBuilder>
        serviceLbPolicyBuilder_;

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     *
     * @return Whether the serviceLbPolicy field is set.
     */
    public boolean hasServiceLbPolicy() {
      return ((bitField0_ & 0x00000004) != 0);
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     *
     * @return The serviceLbPolicy.
     */
    public com.google.cloud.networkservices.v1.ServiceLbPolicy getServiceLbPolicy() {
      if (serviceLbPolicyBuilder_ == null) {
        return serviceLbPolicy_ == null
            ? com.google.cloud.networkservices.v1.ServiceLbPolicy.getDefaultInstance()
            : serviceLbPolicy_;
      } else {
        return serviceLbPolicyBuilder_.getMessage();
      }
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public Builder setServiceLbPolicy(com.google.cloud.networkservices.v1.ServiceLbPolicy value) {
      if (serviceLbPolicyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        serviceLbPolicy_ = value;
      } else {
        serviceLbPolicyBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public Builder setServiceLbPolicy(
        com.google.cloud.networkservices.v1.ServiceLbPolicy.Builder builderForValue) {
      if (serviceLbPolicyBuilder_ == null) {
        serviceLbPolicy_ = builderForValue.build();
      } else {
        serviceLbPolicyBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public Builder mergeServiceLbPolicy(com.google.cloud.networkservices.v1.ServiceLbPolicy value) {
      if (serviceLbPolicyBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)
            && serviceLbPolicy_ != null
            && serviceLbPolicy_
                != com.google.cloud.networkservices.v1.ServiceLbPolicy.getDefaultInstance()) {
          getServiceLbPolicyBuilder().mergeFrom(value);
        } else {
          serviceLbPolicy_ = value;
        }
      } else {
        serviceLbPolicyBuilder_.mergeFrom(value);
      }
      if (serviceLbPolicy_ != null) {
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public Builder clearServiceLbPolicy() {
      bitField0_ = (bitField0_ & ~0x00000004);
      serviceLbPolicy_ = null;
      if (serviceLbPolicyBuilder_ != null) {
        serviceLbPolicyBuilder_.dispose();
        serviceLbPolicyBuilder_ = null;
      }
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public com.google.cloud.networkservices.v1.ServiceLbPolicy.Builder getServiceLbPolicyBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getServiceLbPolicyFieldBuilder().getBuilder();
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    public com.google.cloud.networkservices.v1.ServiceLbPolicyOrBuilder
        getServiceLbPolicyOrBuilder() {
      if (serviceLbPolicyBuilder_ != null) {
        return serviceLbPolicyBuilder_.getMessageOrBuilder();
      } else {
        return serviceLbPolicy_ == null
            ? com.google.cloud.networkservices.v1.ServiceLbPolicy.getDefaultInstance()
            : serviceLbPolicy_;
      }
    }

    /**
     *
     *
     * <pre>
     * Required. ServiceLbPolicy resource to be created.
     * </pre>
     *
     * <code>
     * .google.cloud.networkservices.v1.ServiceLbPolicy service_lb_policy = 3 [(.google.api.field_behavior) = REQUIRED];
     * </code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.networkservices.v1.ServiceLbPolicy,
            com.google.cloud.networkservices.v1.ServiceLbPolicy.Builder,
            com.google.cloud.networkservices.v1.ServiceLbPolicyOrBuilder>
        getServiceLbPolicyFieldBuilder() {
      if (serviceLbPolicyBuilder_ == null) {
        serviceLbPolicyBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.cloud.networkservices.v1.ServiceLbPolicy,
                com.google.cloud.networkservices.v1.ServiceLbPolicy.Builder,
                com.google.cloud.networkservices.v1.ServiceLbPolicyOrBuilder>(
                getServiceLbPolicy(), getParentForChildren(), isClean());
        serviceLbPolicy_ = null;
      }
      return serviceLbPolicyBuilder_;
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

    // @@protoc_insertion_point(builder_scope:google.cloud.networkservices.v1.CreateServiceLbPolicyRequest)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.networkservices.v1.CreateServiceLbPolicyRequest)
  private static final com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest();
  }

  public static com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateServiceLbPolicyRequest> PARSER =
      new com.google.protobuf.AbstractParser<CreateServiceLbPolicyRequest>() {
        @java.lang.Override
        public CreateServiceLbPolicyRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateServiceLbPolicyRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateServiceLbPolicyRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
