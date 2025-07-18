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
// source: google/cloud/aiplatform/v1beta1/session.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.aiplatform.v1beta1;

public interface SessionEventOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.aiplatform.v1beta1.SessionEvent)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Identifier. The resource name of the event.
   * Format:`projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}`.
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
   * Identifier. The resource name of the event.
   * Format:`projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}`.
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
   * Required. The name of the agent that sent the event, or user.
   * </pre>
   *
   * <code>string author = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The author.
   */
  java.lang.String getAuthor();

  /**
   *
   *
   * <pre>
   * Required. The name of the agent that sent the event, or user.
   * </pre>
   *
   * <code>string author = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for author.
   */
  com.google.protobuf.ByteString getAuthorBytes();

  /**
   *
   *
   * <pre>
   * Optional. Content of the event provided by the author.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.Content content = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return Whether the content field is set.
   */
  boolean hasContent();

  /**
   *
   *
   * <pre>
   * Optional. Content of the event provided by the author.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.Content content = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The content.
   */
  com.google.cloud.aiplatform.v1beta1.Content getContent();

  /**
   *
   *
   * <pre>
   * Optional. Content of the event provided by the author.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.Content content = 4 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.cloud.aiplatform.v1beta1.ContentOrBuilder getContentOrBuilder();

  /**
   *
   *
   * <pre>
   * Required. The invocation id of the event, multiple events can have the same
   * invocation id.
   * </pre>
   *
   * <code>string invocation_id = 5 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The invocationId.
   */
  java.lang.String getInvocationId();

  /**
   *
   *
   * <pre>
   * Required. The invocation id of the event, multiple events can have the same
   * invocation id.
   * </pre>
   *
   * <code>string invocation_id = 5 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for invocationId.
   */
  com.google.protobuf.ByteString getInvocationIdBytes();

  /**
   *
   *
   * <pre>
   * Optional. Actions executed by the agent.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventActions actions = 6 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return Whether the actions field is set.
   */
  boolean hasActions();

  /**
   *
   *
   * <pre>
   * Optional. Actions executed by the agent.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventActions actions = 6 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The actions.
   */
  com.google.cloud.aiplatform.v1beta1.EventActions getActions();

  /**
   *
   *
   * <pre>
   * Optional. Actions executed by the agent.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventActions actions = 6 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.cloud.aiplatform.v1beta1.EventActionsOrBuilder getActionsOrBuilder();

  /**
   *
   *
   * <pre>
   * Required. Timestamp when the event was created on client side.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 8 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();

  /**
   *
   *
   * <pre>
   * Required. Timestamp when the event was created on client side.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 8 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The timestamp.
   */
  com.google.protobuf.Timestamp getTimestamp();

  /**
   *
   *
   * <pre>
   * Required. Timestamp when the event was created on client side.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 8 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();

  /**
   *
   *
   * <pre>
   * Optional. Error code if the response is an error. Code varies by model.
   * </pre>
   *
   * <code>string error_code = 9 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The errorCode.
   */
  java.lang.String getErrorCode();

  /**
   *
   *
   * <pre>
   * Optional. Error code if the response is an error. Code varies by model.
   * </pre>
   *
   * <code>string error_code = 9 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for errorCode.
   */
  com.google.protobuf.ByteString getErrorCodeBytes();

  /**
   *
   *
   * <pre>
   * Optional. Error message if the response is an error.
   * </pre>
   *
   * <code>string error_message = 10 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The errorMessage.
   */
  java.lang.String getErrorMessage();

  /**
   *
   *
   * <pre>
   * Optional. Error message if the response is an error.
   * </pre>
   *
   * <code>string error_message = 10 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for errorMessage.
   */
  com.google.protobuf.ByteString getErrorMessageBytes();

  /**
   *
   *
   * <pre>
   * Optional. Metadata relating to this event.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventMetadata event_metadata = 11 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return Whether the eventMetadata field is set.
   */
  boolean hasEventMetadata();

  /**
   *
   *
   * <pre>
   * Optional. Metadata relating to this event.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventMetadata event_metadata = 11 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The eventMetadata.
   */
  com.google.cloud.aiplatform.v1beta1.EventMetadata getEventMetadata();

  /**
   *
   *
   * <pre>
   * Optional. Metadata relating to this event.
   * </pre>
   *
   * <code>
   * .google.cloud.aiplatform.v1beta1.EventMetadata event_metadata = 11 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.cloud.aiplatform.v1beta1.EventMetadataOrBuilder getEventMetadataOrBuilder();
}
