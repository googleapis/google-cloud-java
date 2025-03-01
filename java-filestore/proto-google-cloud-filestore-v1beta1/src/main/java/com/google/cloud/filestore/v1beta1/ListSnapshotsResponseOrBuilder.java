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
// source: google/cloud/filestore/v1beta1/cloud_filestore_service.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.filestore.v1beta1;

public interface ListSnapshotsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.filestore.v1beta1.ListSnapshotsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * A list of snapshots in the project for the specified instance.
   * </pre>
   *
   * <code>repeated .google.cloud.filestore.v1beta1.Snapshot snapshots = 1;</code>
   */
  java.util.List<com.google.cloud.filestore.v1beta1.Snapshot> getSnapshotsList();
  /**
   *
   *
   * <pre>
   * A list of snapshots in the project for the specified instance.
   * </pre>
   *
   * <code>repeated .google.cloud.filestore.v1beta1.Snapshot snapshots = 1;</code>
   */
  com.google.cloud.filestore.v1beta1.Snapshot getSnapshots(int index);
  /**
   *
   *
   * <pre>
   * A list of snapshots in the project for the specified instance.
   * </pre>
   *
   * <code>repeated .google.cloud.filestore.v1beta1.Snapshot snapshots = 1;</code>
   */
  int getSnapshotsCount();
  /**
   *
   *
   * <pre>
   * A list of snapshots in the project for the specified instance.
   * </pre>
   *
   * <code>repeated .google.cloud.filestore.v1beta1.Snapshot snapshots = 1;</code>
   */
  java.util.List<? extends com.google.cloud.filestore.v1beta1.SnapshotOrBuilder>
      getSnapshotsOrBuilderList();
  /**
   *
   *
   * <pre>
   * A list of snapshots in the project for the specified instance.
   * </pre>
   *
   * <code>repeated .google.cloud.filestore.v1beta1.Snapshot snapshots = 1;</code>
   */
  com.google.cloud.filestore.v1beta1.SnapshotOrBuilder getSnapshotsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * The token you can use to retrieve the next page of results. Not returned
   * if there are no more results in the list.
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
   * The token you can use to retrieve the next page of results. Not returned
   * if there are no more results in the list.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString getNextPageTokenBytes();
}
