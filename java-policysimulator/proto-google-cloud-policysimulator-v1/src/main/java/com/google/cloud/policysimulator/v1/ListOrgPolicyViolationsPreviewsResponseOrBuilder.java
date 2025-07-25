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
// source: google/cloud/policysimulator/v1/orgpolicy.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.policysimulator.v1;

public interface ListOrgPolicyViolationsPreviewsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The list of OrgPolicyViolationsPreview
   * </pre>
   *
   * <code>
   * repeated .google.cloud.policysimulator.v1.OrgPolicyViolationsPreview org_policy_violations_previews = 1;
   * </code>
   */
  java.util.List<com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewsList();

  /**
   *
   *
   * <pre>
   * The list of OrgPolicyViolationsPreview
   * </pre>
   *
   * <code>
   * repeated .google.cloud.policysimulator.v1.OrgPolicyViolationsPreview org_policy_violations_previews = 1;
   * </code>
   */
  com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview getOrgPolicyViolationsPreviews(
      int index);

  /**
   *
   *
   * <pre>
   * The list of OrgPolicyViolationsPreview
   * </pre>
   *
   * <code>
   * repeated .google.cloud.policysimulator.v1.OrgPolicyViolationsPreview org_policy_violations_previews = 1;
   * </code>
   */
  int getOrgPolicyViolationsPreviewsCount();

  /**
   *
   *
   * <pre>
   * The list of OrgPolicyViolationsPreview
   * </pre>
   *
   * <code>
   * repeated .google.cloud.policysimulator.v1.OrgPolicyViolationsPreview org_policy_violations_previews = 1;
   * </code>
   */
  java.util.List<? extends com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewOrBuilder>
      getOrgPolicyViolationsPreviewsOrBuilderList();

  /**
   *
   *
   * <pre>
   * The list of OrgPolicyViolationsPreview
   * </pre>
   *
   * <code>
   * repeated .google.cloud.policysimulator.v1.OrgPolicyViolationsPreview org_policy_violations_previews = 1;
   * </code>
   */
  com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewOrBuilder
      getOrgPolicyViolationsPreviewsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * A token that you can use to retrieve the next page of results.
   * If this field is omitted, there are no subsequent pages.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();

  /**
   *
   *
   * <pre>
   * A token that you can use to retrieve the next page of results.
   * If this field is omitted, there are no subsequent pages.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString getNextPageTokenBytes();
}
