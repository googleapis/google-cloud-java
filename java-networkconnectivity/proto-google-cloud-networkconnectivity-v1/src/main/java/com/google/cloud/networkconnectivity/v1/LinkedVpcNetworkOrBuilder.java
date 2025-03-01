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
// source: google/cloud/networkconnectivity/v1/hub.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.networkconnectivity.v1;

public interface LinkedVpcNetworkOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.networkconnectivity.v1.LinkedVpcNetwork)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The URI of the VPC network resource.
   * </pre>
   *
   * <code>
   * string uri = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The uri.
   */
  java.lang.String getUri();
  /**
   *
   *
   * <pre>
   * Required. The URI of the VPC network resource.
   * </pre>
   *
   * <code>
   * string uri = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for uri.
   */
  com.google.protobuf.ByteString getUriBytes();

  /**
   *
   *
   * <pre>
   * Optional. IP ranges encompassing the subnets to be excluded from peering.
   * </pre>
   *
   * <code>repeated string exclude_export_ranges = 2 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return A list containing the excludeExportRanges.
   */
  java.util.List<java.lang.String> getExcludeExportRangesList();
  /**
   *
   *
   * <pre>
   * Optional. IP ranges encompassing the subnets to be excluded from peering.
   * </pre>
   *
   * <code>repeated string exclude_export_ranges = 2 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The count of excludeExportRanges.
   */
  int getExcludeExportRangesCount();
  /**
   *
   *
   * <pre>
   * Optional. IP ranges encompassing the subnets to be excluded from peering.
   * </pre>
   *
   * <code>repeated string exclude_export_ranges = 2 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @param index The index of the element to return.
   * @return The excludeExportRanges at the given index.
   */
  java.lang.String getExcludeExportRanges(int index);
  /**
   *
   *
   * <pre>
   * Optional. IP ranges encompassing the subnets to be excluded from peering.
   * </pre>
   *
   * <code>repeated string exclude_export_ranges = 2 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the excludeExportRanges at the given index.
   */
  com.google.protobuf.ByteString getExcludeExportRangesBytes(int index);

  /**
   *
   *
   * <pre>
   * Optional. IP ranges allowed to be included from peering.
   * </pre>
   *
   * <code>repeated string include_export_ranges = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return A list containing the includeExportRanges.
   */
  java.util.List<java.lang.String> getIncludeExportRangesList();
  /**
   *
   *
   * <pre>
   * Optional. IP ranges allowed to be included from peering.
   * </pre>
   *
   * <code>repeated string include_export_ranges = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The count of includeExportRanges.
   */
  int getIncludeExportRangesCount();
  /**
   *
   *
   * <pre>
   * Optional. IP ranges allowed to be included from peering.
   * </pre>
   *
   * <code>repeated string include_export_ranges = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @param index The index of the element to return.
   * @return The includeExportRanges at the given index.
   */
  java.lang.String getIncludeExportRanges(int index);
  /**
   *
   *
   * <pre>
   * Optional. IP ranges allowed to be included from peering.
   * </pre>
   *
   * <code>repeated string include_export_ranges = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the includeExportRanges at the given index.
   */
  com.google.protobuf.ByteString getIncludeExportRangesBytes(int index);

  /**
   *
   *
   * <pre>
   * Output only. The list of Producer VPC spokes that this VPC spoke is a
   * service consumer VPC spoke for. These producer VPCs are connected through
   * VPC peering to this spoke's backing VPC network.
   * </pre>
   *
   * <code>
   * repeated string producer_vpc_spokes = 4 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return A list containing the producerVpcSpokes.
   */
  java.util.List<java.lang.String> getProducerVpcSpokesList();
  /**
   *
   *
   * <pre>
   * Output only. The list of Producer VPC spokes that this VPC spoke is a
   * service consumer VPC spoke for. These producer VPCs are connected through
   * VPC peering to this spoke's backing VPC network.
   * </pre>
   *
   * <code>
   * repeated string producer_vpc_spokes = 4 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The count of producerVpcSpokes.
   */
  int getProducerVpcSpokesCount();
  /**
   *
   *
   * <pre>
   * Output only. The list of Producer VPC spokes that this VPC spoke is a
   * service consumer VPC spoke for. These producer VPCs are connected through
   * VPC peering to this spoke's backing VPC network.
   * </pre>
   *
   * <code>
   * repeated string producer_vpc_spokes = 4 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @param index The index of the element to return.
   * @return The producerVpcSpokes at the given index.
   */
  java.lang.String getProducerVpcSpokes(int index);
  /**
   *
   *
   * <pre>
   * Output only. The list of Producer VPC spokes that this VPC spoke is a
   * service consumer VPC spoke for. These producer VPCs are connected through
   * VPC peering to this spoke's backing VPC network.
   * </pre>
   *
   * <code>
   * repeated string producer_vpc_spokes = 4 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the producerVpcSpokes at the given index.
   */
  com.google.protobuf.ByteString getProducerVpcSpokesBytes(int index);
}
