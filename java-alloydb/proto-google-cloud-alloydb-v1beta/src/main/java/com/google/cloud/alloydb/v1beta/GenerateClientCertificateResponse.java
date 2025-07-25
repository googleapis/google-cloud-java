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
// source: google/cloud/alloydb/v1beta/service.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.alloydb.v1beta;

/**
 *
 *
 * <pre>
 * Message returned by a GenerateClientCertificate operation.
 * </pre>
 *
 * Protobuf type {@code google.cloud.alloydb.v1beta.GenerateClientCertificateResponse}
 */
public final class GenerateClientCertificateResponse extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.alloydb.v1beta.GenerateClientCertificateResponse)
    GenerateClientCertificateResponseOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use GenerateClientCertificateResponse.newBuilder() to construct.
  private GenerateClientCertificateResponse(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private GenerateClientCertificateResponse() {
    pemCertificate_ = "";
    pemCertificateChain_ = com.google.protobuf.LazyStringArrayList.emptyList();
    caCert_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new GenerateClientCertificateResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.alloydb.v1beta.ServiceProto
        .internal_static_google_cloud_alloydb_v1beta_GenerateClientCertificateResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.alloydb.v1beta.ServiceProto
        .internal_static_google_cloud_alloydb_v1beta_GenerateClientCertificateResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.class,
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.Builder.class);
  }

  public static final int PEM_CERTIFICATE_FIELD_NUMBER = 1;

  @SuppressWarnings("serial")
  private volatile java.lang.Object pemCertificate_ = "";

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded, signed X.509 certificate.
   * </pre>
   *
   * <code>
   * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
   *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
   * @return The pemCertificate.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.lang.String getPemCertificate() {
    java.lang.Object ref = pemCertificate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      pemCertificate_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded, signed X.509 certificate.
   * </pre>
   *
   * <code>
   * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
   *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
   * @return The bytes for pemCertificate.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public com.google.protobuf.ByteString getPemCertificateBytes() {
    java.lang.Object ref = pemCertificate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      pemCertificate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PEM_CERTIFICATE_CHAIN_FIELD_NUMBER = 2;

  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList pemCertificateChain_ =
      com.google.protobuf.LazyStringArrayList.emptyList();

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded chain that may be used to verify the X.509
   * certificate. Expected to be in issuer-to-root order according to RFC 5246.
   * </pre>
   *
   * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return A list containing the pemCertificateChain.
   */
  public com.google.protobuf.ProtocolStringList getPemCertificateChainList() {
    return pemCertificateChain_;
  }

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded chain that may be used to verify the X.509
   * certificate. Expected to be in issuer-to-root order according to RFC 5246.
   * </pre>
   *
   * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The count of pemCertificateChain.
   */
  public int getPemCertificateChainCount() {
    return pemCertificateChain_.size();
  }

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded chain that may be used to verify the X.509
   * certificate. Expected to be in issuer-to-root order according to RFC 5246.
   * </pre>
   *
   * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @param index The index of the element to return.
   * @return The pemCertificateChain at the given index.
   */
  public java.lang.String getPemCertificateChain(int index) {
    return pemCertificateChain_.get(index);
  }

  /**
   *
   *
   * <pre>
   * Output only. The pem-encoded chain that may be used to verify the X.509
   * certificate. Expected to be in issuer-to-root order according to RFC 5246.
   * </pre>
   *
   * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the pemCertificateChain at the given index.
   */
  public com.google.protobuf.ByteString getPemCertificateChainBytes(int index) {
    return pemCertificateChain_.getByteString(index);
  }

  public static final int CA_CERT_FIELD_NUMBER = 3;

  @SuppressWarnings("serial")
  private volatile java.lang.Object caCert_ = "";

  /**
   *
   *
   * <pre>
   * Optional. The pem-encoded cluster ca X.509 certificate.
   * </pre>
   *
   * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The caCert.
   */
  @java.lang.Override
  public java.lang.String getCaCert() {
    java.lang.Object ref = caCert_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      caCert_ = s;
      return s;
    }
  }

  /**
   *
   *
   * <pre>
   * Optional. The pem-encoded cluster ca X.509 certificate.
   * </pre>
   *
   * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for caCert.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getCaCertBytes() {
    java.lang.Object ref = caCert_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      caCert_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(pemCertificate_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, pemCertificate_);
    }
    for (int i = 0; i < pemCertificateChain_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, pemCertificateChain_.getRaw(i));
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(caCert_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, caCert_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(pemCertificate_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, pemCertificate_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < pemCertificateChain_.size(); i++) {
        dataSize += computeStringSizeNoTag(pemCertificateChain_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPemCertificateChainList().size();
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(caCert_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, caCert_);
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
    if (!(obj instanceof com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse)) {
      return super.equals(obj);
    }
    com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse other =
        (com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse) obj;

    if (!getPemCertificate().equals(other.getPemCertificate())) return false;
    if (!getPemCertificateChainList().equals(other.getPemCertificateChainList())) return false;
    if (!getCaCert().equals(other.getCaCert())) return false;
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
    hash = (37 * hash) + PEM_CERTIFICATE_FIELD_NUMBER;
    hash = (53 * hash) + getPemCertificate().hashCode();
    if (getPemCertificateChainCount() > 0) {
      hash = (37 * hash) + PEM_CERTIFICATE_CHAIN_FIELD_NUMBER;
      hash = (53 * hash) + getPemCertificateChainList().hashCode();
    }
    hash = (37 * hash) + CA_CERT_FIELD_NUMBER;
    hash = (53 * hash) + getCaCert().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse parseFrom(
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
      com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse prototype) {
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
   * Message returned by a GenerateClientCertificate operation.
   * </pre>
   *
   * Protobuf type {@code google.cloud.alloydb.v1beta.GenerateClientCertificateResponse}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.alloydb.v1beta.GenerateClientCertificateResponse)
      com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.alloydb.v1beta.ServiceProto
          .internal_static_google_cloud_alloydb_v1beta_GenerateClientCertificateResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.alloydb.v1beta.ServiceProto
          .internal_static_google_cloud_alloydb_v1beta_GenerateClientCertificateResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.class,
              com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.Builder.class);
    }

    // Construct using
    // com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      pemCertificate_ = "";
      pemCertificateChain_ = com.google.protobuf.LazyStringArrayList.emptyList();
      caCert_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.alloydb.v1beta.ServiceProto
          .internal_static_google_cloud_alloydb_v1beta_GenerateClientCertificateResponse_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
        getDefaultInstanceForType() {
      return com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse build() {
      com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse buildPartial() {
      com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse result =
          new com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(
        com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.pemCertificate_ = pemCertificate_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        pemCertificateChain_.makeImmutable();
        result.pemCertificateChain_ = pemCertificateChain_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.caCert_ = caCert_;
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
      if (other instanceof com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse) {
        return mergeFrom((com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse other) {
      if (other
          == com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.getDefaultInstance())
        return this;
      if (!other.getPemCertificate().isEmpty()) {
        pemCertificate_ = other.pemCertificate_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.pemCertificateChain_.isEmpty()) {
        if (pemCertificateChain_.isEmpty()) {
          pemCertificateChain_ = other.pemCertificateChain_;
          bitField0_ |= 0x00000002;
        } else {
          ensurePemCertificateChainIsMutable();
          pemCertificateChain_.addAll(other.pemCertificateChain_);
        }
        onChanged();
      }
      if (!other.getCaCert().isEmpty()) {
        caCert_ = other.caCert_;
        bitField0_ |= 0x00000004;
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
            case 10:
              {
                pemCertificate_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 18:
              {
                java.lang.String s = input.readStringRequireUtf8();
                ensurePemCertificateChainIsMutable();
                pemCertificateChain_.add(s);
                break;
              } // case 18
            case 26:
              {
                caCert_ = input.readStringRequireUtf8();
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

    private java.lang.Object pemCertificate_ = "";

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded, signed X.509 certificate.
     * </pre>
     *
     * <code>
     * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
     *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
     * @return The pemCertificate.
     */
    @java.lang.Deprecated
    public java.lang.String getPemCertificate() {
      java.lang.Object ref = pemCertificate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pemCertificate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded, signed X.509 certificate.
     * </pre>
     *
     * <code>
     * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
     *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
     * @return The bytes for pemCertificate.
     */
    @java.lang.Deprecated
    public com.google.protobuf.ByteString getPemCertificateBytes() {
      java.lang.Object ref = pemCertificate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        pemCertificate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded, signed X.509 certificate.
     * </pre>
     *
     * <code>
     * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
     *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
     * @param value The pemCertificate to set.
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder setPemCertificate(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      pemCertificate_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded, signed X.509 certificate.
     * </pre>
     *
     * <code>
     * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
     *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder clearPemCertificate() {
      pemCertificate_ = getDefaultInstance().getPemCertificate();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded, signed X.509 certificate.
     * </pre>
     *
     * <code>
     * string pem_certificate = 1 [deprecated = true, (.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @deprecated google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.pem_certificate is
     *     deprecated. See google/cloud/alloydb/v1beta/service.proto;l=1902
     * @param value The bytes for pemCertificate to set.
     * @return This builder for chaining.
     */
    @java.lang.Deprecated
    public Builder setPemCertificateBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      pemCertificate_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringArrayList pemCertificateChain_ =
        com.google.protobuf.LazyStringArrayList.emptyList();

    private void ensurePemCertificateChainIsMutable() {
      if (!pemCertificateChain_.isModifiable()) {
        pemCertificateChain_ = new com.google.protobuf.LazyStringArrayList(pemCertificateChain_);
      }
      bitField0_ |= 0x00000002;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @return A list containing the pemCertificateChain.
     */
    public com.google.protobuf.ProtocolStringList getPemCertificateChainList() {
      pemCertificateChain_.makeImmutable();
      return pemCertificateChain_;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @return The count of pemCertificateChain.
     */
    public int getPemCertificateChainCount() {
      return pemCertificateChain_.size();
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param index The index of the element to return.
     * @return The pemCertificateChain at the given index.
     */
    public java.lang.String getPemCertificateChain(int index) {
      return pemCertificateChain_.get(index);
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param index The index of the value to return.
     * @return The bytes of the pemCertificateChain at the given index.
     */
    public com.google.protobuf.ByteString getPemCertificateChainBytes(int index) {
      return pemCertificateChain_.getByteString(index);
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param index The index to set the value at.
     * @param value The pemCertificateChain to set.
     * @return This builder for chaining.
     */
    public Builder setPemCertificateChain(int index, java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensurePemCertificateChainIsMutable();
      pemCertificateChain_.set(index, value);
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param value The pemCertificateChain to add.
     * @return This builder for chaining.
     */
    public Builder addPemCertificateChain(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensurePemCertificateChainIsMutable();
      pemCertificateChain_.add(value);
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param values The pemCertificateChain to add.
     * @return This builder for chaining.
     */
    public Builder addAllPemCertificateChain(java.lang.Iterable<java.lang.String> values) {
      ensurePemCertificateChainIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(values, pemCertificateChain_);
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPemCertificateChain() {
      pemCertificateChain_ = com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      ;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Output only. The pem-encoded chain that may be used to verify the X.509
     * certificate. Expected to be in issuer-to-root order according to RFC 5246.
     * </pre>
     *
     * <code>repeated string pem_certificate_chain = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
     * </code>
     *
     * @param value The bytes of the pemCertificateChain to add.
     * @return This builder for chaining.
     */
    public Builder addPemCertificateChainBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      ensurePemCertificateChainIsMutable();
      pemCertificateChain_.add(value);
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object caCert_ = "";

    /**
     *
     *
     * <pre>
     * Optional. The pem-encoded cluster ca X.509 certificate.
     * </pre>
     *
     * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @return The caCert.
     */
    public java.lang.String getCaCert() {
      java.lang.Object ref = caCert_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        caCert_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Optional. The pem-encoded cluster ca X.509 certificate.
     * </pre>
     *
     * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @return The bytes for caCert.
     */
    public com.google.protobuf.ByteString getCaCertBytes() {
      java.lang.Object ref = caCert_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        caCert_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     *
     *
     * <pre>
     * Optional. The pem-encoded cluster ca X.509 certificate.
     * </pre>
     *
     * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @param value The caCert to set.
     * @return This builder for chaining.
     */
    public Builder setCaCert(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      caCert_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Optional. The pem-encoded cluster ca X.509 certificate.
     * </pre>
     *
     * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCaCert() {
      caCert_ = getDefaultInstance().getCaCert();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Optional. The pem-encoded cluster ca X.509 certificate.
     * </pre>
     *
     * <code>string ca_cert = 3 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @param value The bytes for caCert to set.
     * @return This builder for chaining.
     */
    public Builder setCaCertBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      caCert_ = value;
      bitField0_ |= 0x00000004;
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

    // @@protoc_insertion_point(builder_scope:google.cloud.alloydb.v1beta.GenerateClientCertificateResponse)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.alloydb.v1beta.GenerateClientCertificateResponse)
  private static final com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse();
  }

  public static com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GenerateClientCertificateResponse> PARSER =
      new com.google.protobuf.AbstractParser<GenerateClientCertificateResponse>() {
        @java.lang.Override
        public GenerateClientCertificateResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GenerateClientCertificateResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GenerateClientCertificateResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
