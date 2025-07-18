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
// source: google/cloud/securitycenter/v2/notification_config.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.securitycenter.v2;

public interface NotificationConfigOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.securitycenter.v2.NotificationConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Identifier. The relative resource name of this notification config. See:
   * https://cloud.google.com/apis/design/resource_names#relative_resource_name
   * The following list shows some examples:
   * +
   * `organizations/{organization_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
   * +
   * `folders/{folder_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
   * +
   * `projects/{project_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
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
   * Identifier. The relative resource name of this notification config. See:
   * https://cloud.google.com/apis/design/resource_names#relative_resource_name
   * The following list shows some examples:
   * +
   * `organizations/{organization_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
   * +
   * `folders/{folder_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
   * +
   * `projects/{project_id}/locations/{location_id}/notificationConfigs/notify_public_bucket`
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
   * The description of the notification config (max of 1024 characters).
   * </pre>
   *
   * <code>string description = 2;</code>
   *
   * @return The description.
   */
  java.lang.String getDescription();

  /**
   *
   *
   * <pre>
   * The description of the notification config (max of 1024 characters).
   * </pre>
   *
   * <code>string description = 2;</code>
   *
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString getDescriptionBytes();

  /**
   *
   *
   * <pre>
   * The Pub/Sub topic to send notifications to. Its format is
   * "projects/[project_id]/topics/[topic]".
   * </pre>
   *
   * <code>string pubsub_topic = 3 [(.google.api.resource_reference) = { ... }</code>
   *
   * @return The pubsubTopic.
   */
  java.lang.String getPubsubTopic();

  /**
   *
   *
   * <pre>
   * The Pub/Sub topic to send notifications to. Its format is
   * "projects/[project_id]/topics/[topic]".
   * </pre>
   *
   * <code>string pubsub_topic = 3 [(.google.api.resource_reference) = { ... }</code>
   *
   * @return The bytes for pubsubTopic.
   */
  com.google.protobuf.ByteString getPubsubTopicBytes();

  /**
   *
   *
   * <pre>
   * Output only. The service account that needs "pubsub.topics.publish"
   * permission to publish to the Pub/Sub topic.
   * </pre>
   *
   * <code>string service_account = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The serviceAccount.
   */
  java.lang.String getServiceAccount();

  /**
   *
   *
   * <pre>
   * Output only. The service account that needs "pubsub.topics.publish"
   * permission to publish to the Pub/Sub topic.
   * </pre>
   *
   * <code>string service_account = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The bytes for serviceAccount.
   */
  com.google.protobuf.ByteString getServiceAccountBytes();

  /**
   *
   *
   * <pre>
   * The config for triggering streaming-based notifications.
   * </pre>
   *
   * <code>.google.cloud.securitycenter.v2.NotificationConfig.StreamingConfig streaming_config = 5;
   * </code>
   *
   * @return Whether the streamingConfig field is set.
   */
  boolean hasStreamingConfig();

  /**
   *
   *
   * <pre>
   * The config for triggering streaming-based notifications.
   * </pre>
   *
   * <code>.google.cloud.securitycenter.v2.NotificationConfig.StreamingConfig streaming_config = 5;
   * </code>
   *
   * @return The streamingConfig.
   */
  com.google.cloud.securitycenter.v2.NotificationConfig.StreamingConfig getStreamingConfig();

  /**
   *
   *
   * <pre>
   * The config for triggering streaming-based notifications.
   * </pre>
   *
   * <code>.google.cloud.securitycenter.v2.NotificationConfig.StreamingConfig streaming_config = 5;
   * </code>
   */
  com.google.cloud.securitycenter.v2.NotificationConfig.StreamingConfigOrBuilder
      getStreamingConfigOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The timestamp of when the notification config was last
   * updated.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the updateTime field is set.
   */
  boolean hasUpdateTime();

  /**
   *
   *
   * <pre>
   * Output only. The timestamp of when the notification config was last
   * updated.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The updateTime.
   */
  com.google.protobuf.Timestamp getUpdateTime();

  /**
   *
   *
   * <pre>
   * Output only. The timestamp of when the notification config was last
   * updated.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp update_time = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdateTimeOrBuilder();

  com.google.cloud.securitycenter.v2.NotificationConfig.NotifyConfigCase getNotifyConfigCase();
}
