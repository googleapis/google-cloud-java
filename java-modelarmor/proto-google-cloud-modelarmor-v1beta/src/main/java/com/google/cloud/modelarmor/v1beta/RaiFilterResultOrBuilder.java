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

public interface RaiFilterResultOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.modelarmor.v1beta.RaiFilterResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Output only. Reports whether the RAI filter was successfully executed or
   * not.
   * </pre>
   *
   * <code>
   * .google.cloud.modelarmor.v1beta.FilterExecutionState execution_state = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The enum numeric value on the wire for executionState.
   */
  int getExecutionStateValue();

  /**
   *
   *
   * <pre>
   * Output only. Reports whether the RAI filter was successfully executed or
   * not.
   * </pre>
   *
   * <code>
   * .google.cloud.modelarmor.v1beta.FilterExecutionState execution_state = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The executionState.
   */
  com.google.cloud.modelarmor.v1beta.FilterExecutionState getExecutionState();

  /**
   *
   *
   * <pre>
   * Optional messages corresponding to the result.
   * A message can provide warnings or error details.
   * For example, if execution state is skipped then this field provides
   * related reason/explanation.
   * </pre>
   *
   * <code>repeated .google.cloud.modelarmor.v1beta.MessageItem message_items = 2;</code>
   */
  java.util.List<com.google.cloud.modelarmor.v1beta.MessageItem> getMessageItemsList();

  /**
   *
   *
   * <pre>
   * Optional messages corresponding to the result.
   * A message can provide warnings or error details.
   * For example, if execution state is skipped then this field provides
   * related reason/explanation.
   * </pre>
   *
   * <code>repeated .google.cloud.modelarmor.v1beta.MessageItem message_items = 2;</code>
   */
  com.google.cloud.modelarmor.v1beta.MessageItem getMessageItems(int index);

  /**
   *
   *
   * <pre>
   * Optional messages corresponding to the result.
   * A message can provide warnings or error details.
   * For example, if execution state is skipped then this field provides
   * related reason/explanation.
   * </pre>
   *
   * <code>repeated .google.cloud.modelarmor.v1beta.MessageItem message_items = 2;</code>
   */
  int getMessageItemsCount();

  /**
   *
   *
   * <pre>
   * Optional messages corresponding to the result.
   * A message can provide warnings or error details.
   * For example, if execution state is skipped then this field provides
   * related reason/explanation.
   * </pre>
   *
   * <code>repeated .google.cloud.modelarmor.v1beta.MessageItem message_items = 2;</code>
   */
  java.util.List<? extends com.google.cloud.modelarmor.v1beta.MessageItemOrBuilder>
      getMessageItemsOrBuilderList();

  /**
   *
   *
   * <pre>
   * Optional messages corresponding to the result.
   * A message can provide warnings or error details.
   * For example, if execution state is skipped then this field provides
   * related reason/explanation.
   * </pre>
   *
   * <code>repeated .google.cloud.modelarmor.v1beta.MessageItem message_items = 2;</code>
   */
  com.google.cloud.modelarmor.v1beta.MessageItemOrBuilder getMessageItemsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * Output only. Overall filter match state for RAI.
   * Value is MATCH_FOUND if at least one RAI filter confidence level is
   * equal to or higher than the confidence level defined in configuration.
   * </pre>
   *
   * <code>
   * .google.cloud.modelarmor.v1beta.FilterMatchState match_state = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The enum numeric value on the wire for matchState.
   */
  int getMatchStateValue();

  /**
   *
   *
   * <pre>
   * Output only. Overall filter match state for RAI.
   * Value is MATCH_FOUND if at least one RAI filter confidence level is
   * equal to or higher than the confidence level defined in configuration.
   * </pre>
   *
   * <code>
   * .google.cloud.modelarmor.v1beta.FilterMatchState match_state = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The matchState.
   */
  com.google.cloud.modelarmor.v1beta.FilterMatchState getMatchState();

  /**
   *
   *
   * <pre>
   * The map of RAI filter results where key is RAI filter type - either of
   * "sexually_explicit", "hate_speech", "harassment", "dangerous".
   * </pre>
   *
   * <code>
   * map&lt;string, .google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult&gt; rai_filter_type_results = 4;
   * </code>
   */
  int getRaiFilterTypeResultsCount();

  /**
   *
   *
   * <pre>
   * The map of RAI filter results where key is RAI filter type - either of
   * "sexually_explicit", "hate_speech", "harassment", "dangerous".
   * </pre>
   *
   * <code>
   * map&lt;string, .google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult&gt; rai_filter_type_results = 4;
   * </code>
   */
  boolean containsRaiFilterTypeResults(java.lang.String key);

  /** Use {@link #getRaiFilterTypeResultsMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<
          java.lang.String, com.google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult>
      getRaiFilterTypeResults();

  /**
   *
   *
   * <pre>
   * The map of RAI filter results where key is RAI filter type - either of
   * "sexually_explicit", "hate_speech", "harassment", "dangerous".
   * </pre>
   *
   * <code>
   * map&lt;string, .google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult&gt; rai_filter_type_results = 4;
   * </code>
   */
  java.util.Map<
          java.lang.String, com.google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult>
      getRaiFilterTypeResultsMap();

  /**
   *
   *
   * <pre>
   * The map of RAI filter results where key is RAI filter type - either of
   * "sexually_explicit", "hate_speech", "harassment", "dangerous".
   * </pre>
   *
   * <code>
   * map&lt;string, .google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult&gt; rai_filter_type_results = 4;
   * </code>
   */
  /* nullable */
  com.google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult
      getRaiFilterTypeResultsOrDefault(
          java.lang.String key,
          /* nullable */
          com.google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult defaultValue);

  /**
   *
   *
   * <pre>
   * The map of RAI filter results where key is RAI filter type - either of
   * "sexually_explicit", "hate_speech", "harassment", "dangerous".
   * </pre>
   *
   * <code>
   * map&lt;string, .google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult&gt; rai_filter_type_results = 4;
   * </code>
   */
  com.google.cloud.modelarmor.v1beta.RaiFilterResult.RaiFilterTypeResult
      getRaiFilterTypeResultsOrThrow(java.lang.String key);
}
