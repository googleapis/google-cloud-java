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
// source: google/cloud/securitycenter/v2/resource.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.securitycenter.v2;

/**
 *
 *
 * <pre>
 * The cloud provider the finding pertains to.
 * </pre>
 *
 * Protobuf enum {@code google.cloud.securitycenter.v2.CloudProvider}
 */
public enum CloudProvider implements com.google.protobuf.ProtocolMessageEnum {
  /**
   *
   *
   * <pre>
   * The cloud provider is unspecified.
   * </pre>
   *
   * <code>CLOUD_PROVIDER_UNSPECIFIED = 0;</code>
   */
  CLOUD_PROVIDER_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * The cloud provider is Google Cloud.
   * </pre>
   *
   * <code>GOOGLE_CLOUD_PLATFORM = 1;</code>
   */
  GOOGLE_CLOUD_PLATFORM(1),
  /**
   *
   *
   * <pre>
   * The cloud provider is Amazon Web Services.
   * </pre>
   *
   * <code>AMAZON_WEB_SERVICES = 2;</code>
   */
  AMAZON_WEB_SERVICES(2),
  /**
   *
   *
   * <pre>
   * The cloud provider is Microsoft Azure.
   * </pre>
   *
   * <code>MICROSOFT_AZURE = 3;</code>
   */
  MICROSOFT_AZURE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   *
   *
   * <pre>
   * The cloud provider is unspecified.
   * </pre>
   *
   * <code>CLOUD_PROVIDER_UNSPECIFIED = 0;</code>
   */
  public static final int CLOUD_PROVIDER_UNSPECIFIED_VALUE = 0;

  /**
   *
   *
   * <pre>
   * The cloud provider is Google Cloud.
   * </pre>
   *
   * <code>GOOGLE_CLOUD_PLATFORM = 1;</code>
   */
  public static final int GOOGLE_CLOUD_PLATFORM_VALUE = 1;

  /**
   *
   *
   * <pre>
   * The cloud provider is Amazon Web Services.
   * </pre>
   *
   * <code>AMAZON_WEB_SERVICES = 2;</code>
   */
  public static final int AMAZON_WEB_SERVICES_VALUE = 2;

  /**
   *
   *
   * <pre>
   * The cloud provider is Microsoft Azure.
   * </pre>
   *
   * <code>MICROSOFT_AZURE = 3;</code>
   */
  public static final int MICROSOFT_AZURE_VALUE = 3;

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
  public static CloudProvider valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static CloudProvider forNumber(int value) {
    switch (value) {
      case 0:
        return CLOUD_PROVIDER_UNSPECIFIED;
      case 1:
        return GOOGLE_CLOUD_PLATFORM;
      case 2:
        return AMAZON_WEB_SERVICES;
      case 3:
        return MICROSOFT_AZURE;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<CloudProvider> internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<CloudProvider> internalValueMap =
      new com.google.protobuf.Internal.EnumLiteMap<CloudProvider>() {
        public CloudProvider findValueByNumber(int number) {
          return CloudProvider.forNumber(number);
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
    return com.google.cloud.securitycenter.v2.ResourceProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final CloudProvider[] VALUES = values();

  public static CloudProvider valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private CloudProvider(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.cloud.securitycenter.v2.CloudProvider)
}
