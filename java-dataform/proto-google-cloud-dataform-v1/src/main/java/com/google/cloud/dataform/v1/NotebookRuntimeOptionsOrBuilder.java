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
// source: google/cloud/dataform/v1/dataform.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.dataform.v1;

public interface NotebookRuntimeOptionsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.dataform.v1.NotebookRuntimeOptions)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Optional. The Google Cloud Storage location to upload the result to.
   * Format: `gs://bucket-name`.
   * </pre>
   *
   * <code>string gcs_output_bucket = 1 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return Whether the gcsOutputBucket field is set.
   */
  boolean hasGcsOutputBucket();

  /**
   *
   *
   * <pre>
   * Optional. The Google Cloud Storage location to upload the result to.
   * Format: `gs://bucket-name`.
   * </pre>
   *
   * <code>string gcs_output_bucket = 1 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The gcsOutputBucket.
   */
  java.lang.String getGcsOutputBucket();

  /**
   *
   *
   * <pre>
   * Optional. The Google Cloud Storage location to upload the result to.
   * Format: `gs://bucket-name`.
   * </pre>
   *
   * <code>string gcs_output_bucket = 1 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for gcsOutputBucket.
   */
  com.google.protobuf.ByteString getGcsOutputBucketBytes();

  /**
   *
   *
   * <pre>
   * Optional. The resource name of the [Colab runtime template]
   * (https://cloud.google.com/colab/docs/runtimes), from which a runtime is
   * created for notebook executions. If not specified, a runtime is created
   * with Colab's default specifications.
   * </pre>
   *
   * <code>
   * string ai_platform_notebook_runtime_template = 2 [(.google.api.field_behavior) = OPTIONAL, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The aiPlatformNotebookRuntimeTemplate.
   */
  java.lang.String getAiPlatformNotebookRuntimeTemplate();

  /**
   *
   *
   * <pre>
   * Optional. The resource name of the [Colab runtime template]
   * (https://cloud.google.com/colab/docs/runtimes), from which a runtime is
   * created for notebook executions. If not specified, a runtime is created
   * with Colab's default specifications.
   * </pre>
   *
   * <code>
   * string ai_platform_notebook_runtime_template = 2 [(.google.api.field_behavior) = OPTIONAL, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for aiPlatformNotebookRuntimeTemplate.
   */
  com.google.protobuf.ByteString getAiPlatformNotebookRuntimeTemplateBytes();

  com.google.cloud.dataform.v1.NotebookRuntimeOptions.ExecutionSinkCase getExecutionSinkCase();
}
