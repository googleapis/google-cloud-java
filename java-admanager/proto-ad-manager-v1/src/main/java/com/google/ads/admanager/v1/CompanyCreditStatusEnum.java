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
// source: google/ads/admanager/v1/company_enums.proto

// Protobuf Java Version: 3.25.8
package com.google.ads.admanager.v1;

/**
 *
 *
 * <pre>
 * Wrapper message for
 * [CompanyCreditStatus][google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus]
 * </pre>
 *
 * Protobuf type {@code google.ads.admanager.v1.CompanyCreditStatusEnum}
 */
public final class CompanyCreditStatusEnum extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.ads.admanager.v1.CompanyCreditStatusEnum)
    CompanyCreditStatusEnumOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use CompanyCreditStatusEnum.newBuilder() to construct.
  private CompanyCreditStatusEnum(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private CompanyCreditStatusEnum() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new CompanyCreditStatusEnum();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.ads.admanager.v1.CompanyEnumsProto
        .internal_static_google_ads_admanager_v1_CompanyCreditStatusEnum_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ads.admanager.v1.CompanyEnumsProto
        .internal_static_google_ads_admanager_v1_CompanyCreditStatusEnum_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ads.admanager.v1.CompanyCreditStatusEnum.class,
            com.google.ads.admanager.v1.CompanyCreditStatusEnum.Builder.class);
  }

  /**
   *
   *
   * <pre>
   * The credit status of a company.
   *
   * Credit statuses specify the credit-worthiness of a company and affect the
   * ad serving of campaigns belonging to the company.
   *
   * In basic settings, only the
   * [ACTIVE][google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus.ACTIVE]
   * and
   * [INACTIVE][google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus.INACTIVE]
   * credit statuses are applicable. In advance settings, all credit statuses
   * are applicable.
   * </pre>
   *
   * Protobuf enum {@code google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus}
   */
  public enum CompanyCreditStatus implements com.google.protobuf.ProtocolMessageEnum {
    /**
     *
     *
     * <pre>
     * No value specified
     * </pre>
     *
     * <code>COMPANY_CREDIT_STATUS_UNSPECIFIED = 0;</code>
     */
    COMPANY_CREDIT_STATUS_UNSPECIFIED(0),
    /**
     *
     *
     * <pre>
     * The company's credit status is active.
     *
     * Line items belonging to the company can serve.
     *
     * This credit status is the default for basic settings and is available in
     * both basic and advance settings.
     * </pre>
     *
     * <code>ACTIVE = 1;</code>
     */
    ACTIVE(1),
    /**
     *
     *
     * <pre>
     * The company's credit status is inactive.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company cannot be
     * created.
     *
     * Companies with this credit status will be hidden by default in company
     * search results.
     *
     * This credit status is available in both basic and advance settings.
     * </pre>
     *
     * <code>INACTIVE = 2;</code>
     */
    INACTIVE(2),
    /**
     *
     *
     * <pre>
     * The company's credit status is on hold.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company can be
     * created.
     *
     * This credit status is the default in advance settings and is only
     * available in advance settings.
     * </pre>
     *
     * <code>ON_HOLD = 3;</code>
     */
    ON_HOLD(3),
    /**
     *
     *
     * <pre>
     * The company's credit status is stopped.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company cannot be
     * created.
     *
     * This credit status is only available in advance settings.
     * </pre>
     *
     * <code>STOP = 4;</code>
     */
    STOP(4),
    /**
     *
     *
     * <pre>
     * The company's credit status is blocked.
     *
     * All active line items belonging to the company will stop serving with
     * immediate effect. Line items belonging to the company cannot be
     * activated, and new orders or line items belonging to the company cannot
     * be created.
     *
     * This credit status is only available in advance settings.
     * </pre>
     *
     * <code>BLOCKED = 5;</code>
     */
    BLOCKED(5),
    UNRECOGNIZED(-1),
    ;

    /**
     *
     *
     * <pre>
     * No value specified
     * </pre>
     *
     * <code>COMPANY_CREDIT_STATUS_UNSPECIFIED = 0;</code>
     */
    public static final int COMPANY_CREDIT_STATUS_UNSPECIFIED_VALUE = 0;

    /**
     *
     *
     * <pre>
     * The company's credit status is active.
     *
     * Line items belonging to the company can serve.
     *
     * This credit status is the default for basic settings and is available in
     * both basic and advance settings.
     * </pre>
     *
     * <code>ACTIVE = 1;</code>
     */
    public static final int ACTIVE_VALUE = 1;

    /**
     *
     *
     * <pre>
     * The company's credit status is inactive.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company cannot be
     * created.
     *
     * Companies with this credit status will be hidden by default in company
     * search results.
     *
     * This credit status is available in both basic and advance settings.
     * </pre>
     *
     * <code>INACTIVE = 2;</code>
     */
    public static final int INACTIVE_VALUE = 2;

    /**
     *
     *
     * <pre>
     * The company's credit status is on hold.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company can be
     * created.
     *
     * This credit status is the default in advance settings and is only
     * available in advance settings.
     * </pre>
     *
     * <code>ON_HOLD = 3;</code>
     */
    public static final int ON_HOLD_VALUE = 3;

    /**
     *
     *
     * <pre>
     * The company's credit status is stopped.
     *
     * Line items belonging to the company cannot be activated. However, line
     * items that were activated before the credit status changed will remain
     * active. New orders or line items belonging to the company cannot be
     * created.
     *
     * This credit status is only available in advance settings.
     * </pre>
     *
     * <code>STOP = 4;</code>
     */
    public static final int STOP_VALUE = 4;

    /**
     *
     *
     * <pre>
     * The company's credit status is blocked.
     *
     * All active line items belonging to the company will stop serving with
     * immediate effect. Line items belonging to the company cannot be
     * activated, and new orders or line items belonging to the company cannot
     * be created.
     *
     * This credit status is only available in advance settings.
     * </pre>
     *
     * <code>BLOCKED = 5;</code>
     */
    public static final int BLOCKED_VALUE = 5;

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
    public static CompanyCreditStatus valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static CompanyCreditStatus forNumber(int value) {
      switch (value) {
        case 0:
          return COMPANY_CREDIT_STATUS_UNSPECIFIED;
        case 1:
          return ACTIVE;
        case 2:
          return INACTIVE;
        case 3:
          return ON_HOLD;
        case 4:
          return STOP;
        case 5:
          return BLOCKED;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<CompanyCreditStatus>
        internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<CompanyCreditStatus>
        internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<CompanyCreditStatus>() {
              public CompanyCreditStatus findValueByNumber(int number) {
                return CompanyCreditStatus.forNumber(number);
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
      return com.google.ads.admanager.v1.CompanyCreditStatusEnum.getDescriptor()
          .getEnumTypes()
          .get(0);
    }

    private static final CompanyCreditStatus[] VALUES = values();

    public static CompanyCreditStatus valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private CompanyCreditStatus(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus)
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
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.ads.admanager.v1.CompanyCreditStatusEnum)) {
      return super.equals(obj);
    }
    com.google.ads.admanager.v1.CompanyCreditStatusEnum other =
        (com.google.ads.admanager.v1.CompanyCreditStatusEnum) obj;

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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum parseFrom(
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

  public static Builder newBuilder(com.google.ads.admanager.v1.CompanyCreditStatusEnum prototype) {
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
   * Wrapper message for
   * [CompanyCreditStatus][google.ads.admanager.v1.CompanyCreditStatusEnum.CompanyCreditStatus]
   * </pre>
   *
   * Protobuf type {@code google.ads.admanager.v1.CompanyCreditStatusEnum}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.ads.admanager.v1.CompanyCreditStatusEnum)
      com.google.ads.admanager.v1.CompanyCreditStatusEnumOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.ads.admanager.v1.CompanyEnumsProto
          .internal_static_google_ads_admanager_v1_CompanyCreditStatusEnum_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ads.admanager.v1.CompanyEnumsProto
          .internal_static_google_ads_admanager_v1_CompanyCreditStatusEnum_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ads.admanager.v1.CompanyCreditStatusEnum.class,
              com.google.ads.admanager.v1.CompanyCreditStatusEnum.Builder.class);
    }

    // Construct using com.google.ads.admanager.v1.CompanyCreditStatusEnum.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.ads.admanager.v1.CompanyEnumsProto
          .internal_static_google_ads_admanager_v1_CompanyCreditStatusEnum_descriptor;
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.CompanyCreditStatusEnum getDefaultInstanceForType() {
      return com.google.ads.admanager.v1.CompanyCreditStatusEnum.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.CompanyCreditStatusEnum build() {
      com.google.ads.admanager.v1.CompanyCreditStatusEnum result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ads.admanager.v1.CompanyCreditStatusEnum buildPartial() {
      com.google.ads.admanager.v1.CompanyCreditStatusEnum result =
          new com.google.ads.admanager.v1.CompanyCreditStatusEnum(this);
      onBuilt();
      return result;
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
      if (other instanceof com.google.ads.admanager.v1.CompanyCreditStatusEnum) {
        return mergeFrom((com.google.ads.admanager.v1.CompanyCreditStatusEnum) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ads.admanager.v1.CompanyCreditStatusEnum other) {
      if (other == com.google.ads.admanager.v1.CompanyCreditStatusEnum.getDefaultInstance())
        return this;
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

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.ads.admanager.v1.CompanyCreditStatusEnum)
  }

  // @@protoc_insertion_point(class_scope:google.ads.admanager.v1.CompanyCreditStatusEnum)
  private static final com.google.ads.admanager.v1.CompanyCreditStatusEnum DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.ads.admanager.v1.CompanyCreditStatusEnum();
  }

  public static com.google.ads.admanager.v1.CompanyCreditStatusEnum getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CompanyCreditStatusEnum> PARSER =
      new com.google.protobuf.AbstractParser<CompanyCreditStatusEnum>() {
        @java.lang.Override
        public CompanyCreditStatusEnum parsePartialFrom(
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

  public static com.google.protobuf.Parser<CompanyCreditStatusEnum> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CompanyCreditStatusEnum> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ads.admanager.v1.CompanyCreditStatusEnum getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
