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
// source: google/cloud/securitycenter/v2/chokepoint.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.securitycenter.v2;

public interface ChokepointOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.securitycenter.v2.Chokepoint)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * List of resource names of findings associated with this chokepoint.
   * For example, organizations/123/sources/456/findings/789.
   * This list will have at most 100 findings.
   * </pre>
   *
   * <code>repeated string related_findings = 1;</code>
   *
   * @return A list containing the relatedFindings.
   */
  java.util.List<java.lang.String> getRelatedFindingsList();

  /**
   *
   *
   * <pre>
   * List of resource names of findings associated with this chokepoint.
   * For example, organizations/123/sources/456/findings/789.
   * This list will have at most 100 findings.
   * </pre>
   *
   * <code>repeated string related_findings = 1;</code>
   *
   * @return The count of relatedFindings.
   */
  int getRelatedFindingsCount();

  /**
   *
   *
   * <pre>
   * List of resource names of findings associated with this chokepoint.
   * For example, organizations/123/sources/456/findings/789.
   * This list will have at most 100 findings.
   * </pre>
   *
   * <code>repeated string related_findings = 1;</code>
   *
   * @param index The index of the element to return.
   * @return The relatedFindings at the given index.
   */
  java.lang.String getRelatedFindings(int index);

  /**
   *
   *
   * <pre>
   * List of resource names of findings associated with this chokepoint.
   * For example, organizations/123/sources/456/findings/789.
   * This list will have at most 100 findings.
   * </pre>
   *
   * <code>repeated string related_findings = 1;</code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the relatedFindings at the given index.
   */
  com.google.protobuf.ByteString getRelatedFindingsBytes(int index);
}
