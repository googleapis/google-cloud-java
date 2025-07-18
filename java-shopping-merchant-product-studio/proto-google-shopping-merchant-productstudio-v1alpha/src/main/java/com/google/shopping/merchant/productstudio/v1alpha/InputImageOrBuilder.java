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
// source: google/shopping/merchant/productstudio/v1alpha/productstudio_common.proto

// Protobuf Java Version: 3.25.8
package com.google.shopping.merchant.productstudio.v1alpha;

public interface InputImageOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.shopping.merchant.productstudio.v1alpha.InputImage)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Public uri of the image.
   * </pre>
   *
   * <code>string image_uri = 1;</code>
   *
   * @return Whether the imageUri field is set.
   */
  boolean hasImageUri();

  /**
   *
   *
   * <pre>
   * Public uri of the image.
   * </pre>
   *
   * <code>string image_uri = 1;</code>
   *
   * @return The imageUri.
   */
  java.lang.String getImageUri();

  /**
   *
   *
   * <pre>
   * Public uri of the image.
   * </pre>
   *
   * <code>string image_uri = 1;</code>
   *
   * @return The bytes for imageUri.
   */
  com.google.protobuf.ByteString getImageUriBytes();

  /**
   *
   *
   * <pre>
   * Raw image bytes.
   * </pre>
   *
   * <code>bytes image_bytes = 2;</code>
   *
   * @return Whether the imageBytes field is set.
   */
  boolean hasImageBytes();

  /**
   *
   *
   * <pre>
   * Raw image bytes.
   * </pre>
   *
   * <code>bytes image_bytes = 2;</code>
   *
   * @return The imageBytes.
   */
  com.google.protobuf.ByteString getImageBytes();

  com.google.shopping.merchant.productstudio.v1alpha.InputImage.ImageCase getImageCase();
}
