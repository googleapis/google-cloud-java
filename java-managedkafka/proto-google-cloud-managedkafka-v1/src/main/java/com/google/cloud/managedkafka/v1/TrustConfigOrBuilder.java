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
// source: google/cloud/managedkafka/v1/resources.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.managedkafka.v1;

public interface TrustConfigOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.managedkafka.v1.TrustConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Optional. Configuration for the Google Certificate Authority Service.
   * Maximum 10.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig cas_configs = 1 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.List<com.google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig>
      getCasConfigsList();

  /**
   *
   *
   * <pre>
   * Optional. Configuration for the Google Certificate Authority Service.
   * Maximum 10.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig cas_configs = 1 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig getCasConfigs(
      int index);

  /**
   *
   *
   * <pre>
   * Optional. Configuration for the Google Certificate Authority Service.
   * Maximum 10.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig cas_configs = 1 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  int getCasConfigsCount();

  /**
   *
   *
   * <pre>
   * Optional. Configuration for the Google Certificate Authority Service.
   * Maximum 10.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig cas_configs = 1 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.List<
          ? extends
              com.google.cloud.managedkafka.v1.TrustConfig
                  .CertificateAuthorityServiceConfigOrBuilder>
      getCasConfigsOrBuilderList();

  /**
   *
   *
   * <pre>
   * Optional. Configuration for the Google Certificate Authority Service.
   * Maximum 10.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfig cas_configs = 1 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.cloud.managedkafka.v1.TrustConfig.CertificateAuthorityServiceConfigOrBuilder
      getCasConfigsOrBuilder(int index);
}
