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
// source: google/cloud/modelarmor/v1beta/service.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.modelarmor.v1beta;

public interface DataItemOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.modelarmor.v1beta.DataItem)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Plaintext string data for sanitization.
   * </pre>
   *
   * <code>string text = 1;</code>
   *
   * @return Whether the text field is set.
   */
  boolean hasText();

  /**
   *
   *
   * <pre>
   * Plaintext string data for sanitization.
   * </pre>
   *
   * <code>string text = 1;</code>
   *
   * @return The text.
   */
  java.lang.String getText();

  /**
   *
   *
   * <pre>
   * Plaintext string data for sanitization.
   * </pre>
   *
   * <code>string text = 1;</code>
   *
   * @return The bytes for text.
   */
  com.google.protobuf.ByteString getTextBytes();

  /**
   *
   *
   * <pre>
   * Data provided in the form of bytes.
   * </pre>
   *
   * <code>.google.cloud.modelarmor.v1beta.ByteDataItem byte_item = 2;</code>
   *
   * @return Whether the byteItem field is set.
   */
  boolean hasByteItem();

  /**
   *
   *
   * <pre>
   * Data provided in the form of bytes.
   * </pre>
   *
   * <code>.google.cloud.modelarmor.v1beta.ByteDataItem byte_item = 2;</code>
   *
   * @return The byteItem.
   */
  com.google.cloud.modelarmor.v1beta.ByteDataItem getByteItem();

  /**
   *
   *
   * <pre>
   * Data provided in the form of bytes.
   * </pre>
   *
   * <code>.google.cloud.modelarmor.v1beta.ByteDataItem byte_item = 2;</code>
   */
  com.google.cloud.modelarmor.v1beta.ByteDataItemOrBuilder getByteItemOrBuilder();

  com.google.cloud.modelarmor.v1beta.DataItem.DataItemCase getDataItemCase();
}
