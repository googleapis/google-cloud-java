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
// source: google/shopping/merchant/notifications/v1beta/notificationsapi.proto

// Protobuf Java Version: 3.25.3
package com.google.shopping.merchant.notifications.v1beta;

public interface ProductChangeOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.shopping.merchant.notifications.v1beta.ProductChange)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The old value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string old_value = 1;</code>
   *
   * @return Whether the oldValue field is set.
   */
  boolean hasOldValue();

  /**
   *
   *
   * <pre>
   * The old value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string old_value = 1;</code>
   *
   * @return The oldValue.
   */
  java.lang.String getOldValue();

  /**
   *
   *
   * <pre>
   * The old value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string old_value = 1;</code>
   *
   * @return The bytes for oldValue.
   */
  com.google.protobuf.ByteString getOldValueBytes();

  /**
   *
   *
   * <pre>
   * The new value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string new_value = 2;</code>
   *
   * @return Whether the newValue field is set.
   */
  boolean hasNewValue();

  /**
   *
   *
   * <pre>
   * The new value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string new_value = 2;</code>
   *
   * @return The newValue.
   */
  java.lang.String getNewValue();

  /**
   *
   *
   * <pre>
   * The new value of the changed resource or attribute.
   * </pre>
   *
   * <code>optional string new_value = 2;</code>
   *
   * @return The bytes for newValue.
   */
  com.google.protobuf.ByteString getNewValueBytes();

  /**
   *
   *
   * <pre>
   * Countries that have the change (if applicable)
   * </pre>
   *
   * <code>optional string region_code = 3;</code>
   *
   * @return Whether the regionCode field is set.
   */
  boolean hasRegionCode();

  /**
   *
   *
   * <pre>
   * Countries that have the change (if applicable)
   * </pre>
   *
   * <code>optional string region_code = 3;</code>
   *
   * @return The regionCode.
   */
  java.lang.String getRegionCode();

  /**
   *
   *
   * <pre>
   * Countries that have the change (if applicable)
   * </pre>
   *
   * <code>optional string region_code = 3;</code>
   *
   * @return The bytes for regionCode.
   */
  com.google.protobuf.ByteString getRegionCodeBytes();

  /**
   *
   *
   * <pre>
   * Reporting contexts that have the change (if applicable)
   * </pre>
   *
   * <code>
   * optional .google.shopping.type.ReportingContext.ReportingContextEnum reporting_context = 4;
   * </code>
   *
   * @return Whether the reportingContext field is set.
   */
  boolean hasReportingContext();

  /**
   *
   *
   * <pre>
   * Reporting contexts that have the change (if applicable)
   * </pre>
   *
   * <code>
   * optional .google.shopping.type.ReportingContext.ReportingContextEnum reporting_context = 4;
   * </code>
   *
   * @return The enum numeric value on the wire for reportingContext.
   */
  int getReportingContextValue();

  /**
   *
   *
   * <pre>
   * Reporting contexts that have the change (if applicable)
   * </pre>
   *
   * <code>
   * optional .google.shopping.type.ReportingContext.ReportingContextEnum reporting_context = 4;
   * </code>
   *
   * @return The reportingContext.
   */
  com.google.shopping.type.ReportingContext.ReportingContextEnum getReportingContext();
}
