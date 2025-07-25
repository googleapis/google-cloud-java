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
// source: google/ads/admanager/v1/targeting.proto

// Protobuf Java Version: 3.25.8
package com.google.ads.admanager.v1;

public interface AdUnitTargetingOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.ads.admanager.v1.AdUnitTargeting)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Whether this ad unit's children should be targeted/excluded as well.
   * </pre>
   *
   * <code>optional bool include_descendants = 1;</code>
   *
   * @return Whether the includeDescendants field is set.
   */
  boolean hasIncludeDescendants();

  /**
   *
   *
   * <pre>
   * Whether this ad unit's children should be targeted/excluded as well.
   * </pre>
   *
   * <code>optional bool include_descendants = 1;</code>
   *
   * @return The includeDescendants.
   */
  boolean getIncludeDescendants();

  /**
   *
   *
   * <pre>
   * Optional. The resource name of this ad unit.
   * </pre>
   *
   * <code>
   * optional string ad_unit = 3 [(.google.api.field_behavior) = OPTIONAL, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return Whether the adUnit field is set.
   */
  boolean hasAdUnit();

  /**
   *
   *
   * <pre>
   * Optional. The resource name of this ad unit.
   * </pre>
   *
   * <code>
   * optional string ad_unit = 3 [(.google.api.field_behavior) = OPTIONAL, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The adUnit.
   */
  java.lang.String getAdUnit();

  /**
   *
   *
   * <pre>
   * Optional. The resource name of this ad unit.
   * </pre>
   *
   * <code>
   * optional string ad_unit = 3 [(.google.api.field_behavior) = OPTIONAL, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for adUnit.
   */
  com.google.protobuf.ByteString getAdUnitBytes();
}
