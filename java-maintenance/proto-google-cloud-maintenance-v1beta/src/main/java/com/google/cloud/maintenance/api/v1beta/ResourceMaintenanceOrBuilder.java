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
// source: google/cloud/maintenance/api/v1beta/maintenance_service.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.maintenance.api.v1beta;

public interface ResourceMaintenanceOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.maintenance.api.v1beta.ResourceMaintenance)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Identifier. The name of the resource_maintenance resource.
   * Format:
   * `"projects/{project}/locations/{location}/resourceMaintenance/{resource-maintenance-id}"`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
   *
   * @return The name.
   */
  java.lang.String getName();

  /**
   *
   *
   * <pre>
   * Identifier. The name of the resource_maintenance resource.
   * Format:
   * `"projects/{project}/locations/{location}/resourceMaintenance/{resource-maintenance-id}"`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = IDENTIFIER];</code>
   *
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString getNameBytes();

  /**
   *
   *
   * <pre>
   * Output only. The resource spec of the resource maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Resource resource = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the resource field is set.
   */
  boolean hasResource();

  /**
   *
   *
   * <pre>
   * Output only. The resource spec of the resource maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Resource resource = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The resource.
   */
  com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.Resource getResource();

  /**
   *
   *
   * <pre>
   * Output only. The resource spec of the resource maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Resource resource = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.ResourceOrBuilder
      getResourceOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The details of the maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Maintenance maintenance = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenance field is set.
   */
  boolean hasMaintenance();

  /**
   *
   *
   * <pre>
   * Output only. The details of the maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Maintenance maintenance = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenance.
   */
  com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.Maintenance getMaintenance();

  /**
   *
   *
   * <pre>
   * Output only. The details of the maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.Maintenance maintenance = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.MaintenanceOrBuilder
      getMaintenanceOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The state of the resource maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.State state = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The enum numeric value on the wire for state.
   */
  int getStateValue();

  /**
   *
   *
   * <pre>
   * Output only. The state of the resource maintenance.
   * </pre>
   *
   * <code>
   * .google.cloud.maintenance.api.v1beta.ResourceMaintenance.State state = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The state.
   */
  com.google.cloud.maintenance.api.v1beta.ResourceMaintenance.State getState();

  /**
   *
   *
   * <pre>
   * Output only. The create time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the createTime field is set.
   */
  boolean hasCreateTime();

  /**
   *
   *
   * <pre>
   * Output only. The create time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The createTime.
   */
  com.google.protobuf.Timestamp getCreateTime();

  /**
   *
   *
   * <pre>
   * Output only. The create time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getCreateTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The update time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 6 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the updateTime field is set.
   */
  boolean hasUpdateTime();

  /**
   *
   *
   * <pre>
   * Output only. The update time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 6 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The updateTime.
   */
  com.google.protobuf.Timestamp getUpdateTime();

  /**
   *
   *
   * <pre>
   * Output only. The update time of the resource maintenance.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 6 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdateTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has started.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_start_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenanceStartTime field is set.
   */
  boolean hasMaintenanceStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has started.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_start_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenanceStartTime.
   */
  com.google.protobuf.Timestamp getMaintenanceStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has started.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_start_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getMaintenanceStartTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has completed.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_end_time = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenanceEndTime field is set.
   */
  boolean hasMaintenanceEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has completed.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_end_time = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenanceEndTime.
   */
  com.google.protobuf.Timestamp getMaintenanceEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance has completed.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_end_time = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getMaintenanceEndTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance was cancelled.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_cancel_time = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenanceCancelTime field is set.
   */
  boolean hasMaintenanceCancelTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance was cancelled.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_cancel_time = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenanceCancelTime.
   */
  com.google.protobuf.Timestamp getMaintenanceCancelTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the resource maintenance was cancelled.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_cancel_time = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getMaintenanceCancelTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * start.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_start_time = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenanceScheduledStartTime field is set.
   */
  boolean hasMaintenanceScheduledStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * start.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_start_time = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenanceScheduledStartTime.
   */
  com.google.protobuf.Timestamp getMaintenanceScheduledStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * start.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_start_time = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getMaintenanceScheduledStartTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * end.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_end_time = 11 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the maintenanceScheduledEndTime field is set.
   */
  boolean hasMaintenanceScheduledEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * end.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_end_time = 11 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The maintenanceScheduledEndTime.
   */
  com.google.protobuf.Timestamp getMaintenanceScheduledEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time when the maintenance on the resource was scheduled to
   * end.
   * </pre>
   *
   * <code>
   * .google.protobuf.Timestamp maintenance_scheduled_end_time = 11 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getMaintenanceScheduledEndTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. Indicates whether the user has some control over that
   * maintenance, either
   *  proactively before maintenance was scheduled with maintenance policy or
   *  with reactive controls after it was scheduled (see controls field)
   * </pre>
   *
   * <code>bool user_controllable = 12 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The userControllable.
   */
  boolean getUserControllable();

  /**
   *
   *
   * <pre>
   * Output only. The controls of the maintenance.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.maintenance.api.v1beta.MaintenanceControl controls = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  java.util.List<com.google.cloud.maintenance.api.v1beta.MaintenanceControl> getControlsList();

  /**
   *
   *
   * <pre>
   * Output only. The controls of the maintenance.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.maintenance.api.v1beta.MaintenanceControl controls = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.cloud.maintenance.api.v1beta.MaintenanceControl getControls(int index);

  /**
   *
   *
   * <pre>
   * Output only. The controls of the maintenance.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.maintenance.api.v1beta.MaintenanceControl controls = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  int getControlsCount();

  /**
   *
   *
   * <pre>
   * Output only. The controls of the maintenance.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.maintenance.api.v1beta.MaintenanceControl controls = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  java.util.List<? extends com.google.cloud.maintenance.api.v1beta.MaintenanceControlOrBuilder>
      getControlsOrBuilderList();

  /**
   *
   *
   * <pre>
   * Output only. The controls of the maintenance.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.maintenance.api.v1beta.MaintenanceControl controls = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.cloud.maintenance.api.v1beta.MaintenanceControlOrBuilder getControlsOrBuilder(
      int index);

  /**
   *
   *
   * <pre>
   * Optional. The labels on the resource, which can be used for categorization.
   * similar to Kubernetes resource labels.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 10401 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  int getLabelsCount();

  /**
   *
   *
   * <pre>
   * Optional. The labels on the resource, which can be used for categorization.
   * similar to Kubernetes resource labels.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 10401 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  boolean containsLabels(java.lang.String key);

  /** Use {@link #getLabelsMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String> getLabels();

  /**
   *
   *
   * <pre>
   * Optional. The labels on the resource, which can be used for categorization.
   * similar to Kubernetes resource labels.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 10401 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.Map<java.lang.String, java.lang.String> getLabelsMap();

  /**
   *
   *
   * <pre>
   * Optional. The labels on the resource, which can be used for categorization.
   * similar to Kubernetes resource labels.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 10401 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  /* nullable */
  java.lang.String getLabelsOrDefault(
      java.lang.String key,
      /* nullable */
      java.lang.String defaultValue);

  /**
   *
   *
   * <pre>
   * Optional. The labels on the resource, which can be used for categorization.
   * similar to Kubernetes resource labels.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 10401 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.lang.String getLabelsOrThrow(java.lang.String key);

  /**
   *
   *
   * <pre>
   * Optional. Annotations is an unstructured key-value map stored with a
   * resource that may be set by external tools to store and retrieve arbitrary
   * metadata. They are not queryable and should be preserved when modifying
   * objects.
   *
   * More info: https://kubernetes.io/docs/user-guide/annotations
   * </pre>
   *
   * <code>map&lt;string, string&gt; annotations = 10402 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  int getAnnotationsCount();

  /**
   *
   *
   * <pre>
   * Optional. Annotations is an unstructured key-value map stored with a
   * resource that may be set by external tools to store and retrieve arbitrary
   * metadata. They are not queryable and should be preserved when modifying
   * objects.
   *
   * More info: https://kubernetes.io/docs/user-guide/annotations
   * </pre>
   *
   * <code>map&lt;string, string&gt; annotations = 10402 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  boolean containsAnnotations(java.lang.String key);

  /** Use {@link #getAnnotationsMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String> getAnnotations();

  /**
   *
   *
   * <pre>
   * Optional. Annotations is an unstructured key-value map stored with a
   * resource that may be set by external tools to store and retrieve arbitrary
   * metadata. They are not queryable and should be preserved when modifying
   * objects.
   *
   * More info: https://kubernetes.io/docs/user-guide/annotations
   * </pre>
   *
   * <code>map&lt;string, string&gt; annotations = 10402 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.Map<java.lang.String, java.lang.String> getAnnotationsMap();

  /**
   *
   *
   * <pre>
   * Optional. Annotations is an unstructured key-value map stored with a
   * resource that may be set by external tools to store and retrieve arbitrary
   * metadata. They are not queryable and should be preserved when modifying
   * objects.
   *
   * More info: https://kubernetes.io/docs/user-guide/annotations
   * </pre>
   *
   * <code>map&lt;string, string&gt; annotations = 10402 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  /* nullable */
  java.lang.String getAnnotationsOrDefault(
      java.lang.String key,
      /* nullable */
      java.lang.String defaultValue);

  /**
   *
   *
   * <pre>
   * Optional. Annotations is an unstructured key-value map stored with a
   * resource that may be set by external tools to store and retrieve arbitrary
   * metadata. They are not queryable and should be preserved when modifying
   * objects.
   *
   * More info: https://kubernetes.io/docs/user-guide/annotations
   * </pre>
   *
   * <code>map&lt;string, string&gt; annotations = 10402 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.lang.String getAnnotationsOrThrow(java.lang.String key);

  /**
   *
   *
   * <pre>
   * Output only. The unique identifier of the resource. UID is unique in the
   * time and space for this resource within the scope of the service. It is
   * typically generated by the server on successful creation of a resource
   * and must not be changed. UID is used to uniquely identify resources
   * with resource name reuses. This should be a UUID4.
   * </pre>
   *
   * <code>
   * string uid = 10201 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.field_info) = { ... }
   * </code>
   *
   * @return The uid.
   */
  java.lang.String getUid();

  /**
   *
   *
   * <pre>
   * Output only. The unique identifier of the resource. UID is unique in the
   * time and space for this resource within the scope of the service. It is
   * typically generated by the server on successful creation of a resource
   * and must not be changed. UID is used to uniquely identify resources
   * with resource name reuses. This should be a UUID4.
   * </pre>
   *
   * <code>
   * string uid = 10201 [(.google.api.field_behavior) = OUTPUT_ONLY, (.google.api.field_info) = { ... }
   * </code>
   *
   * @return The bytes for uid.
   */
  com.google.protobuf.ByteString getUidBytes();

  /**
   *
   *
   * <pre>
   * Output only. An opaque value that uniquely identifies a version or
   * generation of a resource. It can be used to confirm that the client
   * and server agree on the ordering of a resource being written.
   * </pre>
   *
   * <code>string etag = 10202 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The etag.
   */
  java.lang.String getEtag();

  /**
   *
   *
   * <pre>
   * Output only. An opaque value that uniquely identifies a version or
   * generation of a resource. It can be used to confirm that the client
   * and server agree on the ordering of a resource being written.
   * </pre>
   *
   * <code>string etag = 10202 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The bytes for etag.
   */
  com.google.protobuf.ByteString getEtagBytes();
}
