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
// source: google/cloud/video/transcoder/v1/resources.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.video.transcoder.v1;

public interface JobOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.video.transcoder.v1.Job)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The resource name of the job.
   * Format: `projects/{project_number}/locations/{location}/jobs/{job}`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The name.
   */
  java.lang.String getName();

  /**
   *
   *
   * <pre>
   * The resource name of the job.
   * Format: `projects/{project_number}/locations/{location}/jobs/{job}`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString getNameBytes();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `input_uri` to populate empty `uri` fields in each
   * element of `Job.config.inputs` or `JobTemplate.config.inputs` when using
   * template. URI of the media. Input files must be at least 5 seconds in
   * duration and stored in Cloud Storage (for example,
   * `gs://bucket/inputs/file.mp4`). See [Supported input and output
   * formats](https://cloud.google.com/transcoder/docs/concepts/supported-input-and-output-formats).
   * </pre>
   *
   * <code>string input_uri = 2 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The inputUri.
   */
  java.lang.String getInputUri();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `input_uri` to populate empty `uri` fields in each
   * element of `Job.config.inputs` or `JobTemplate.config.inputs` when using
   * template. URI of the media. Input files must be at least 5 seconds in
   * duration and stored in Cloud Storage (for example,
   * `gs://bucket/inputs/file.mp4`). See [Supported input and output
   * formats](https://cloud.google.com/transcoder/docs/concepts/supported-input-and-output-formats).
   * </pre>
   *
   * <code>string input_uri = 2 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The bytes for inputUri.
   */
  com.google.protobuf.ByteString getInputUriBytes();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `output_uri` to populate an empty
   * `Job.config.output.uri` or `JobTemplate.config.output.uri` when using
   * template. URI for the output file(s). For example,
   * `gs://my-bucket/outputs/`. See [Supported input and output
   * formats](https://cloud.google.com/transcoder/docs/concepts/supported-input-and-output-formats).
   * </pre>
   *
   * <code>string output_uri = 3 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The outputUri.
   */
  java.lang.String getOutputUri();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `output_uri` to populate an empty
   * `Job.config.output.uri` or `JobTemplate.config.output.uri` when using
   * template. URI for the output file(s). For example,
   * `gs://my-bucket/outputs/`. See [Supported input and output
   * formats](https://cloud.google.com/transcoder/docs/concepts/supported-input-and-output-formats).
   * </pre>
   *
   * <code>string output_uri = 3 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The bytes for outputUri.
   */
  com.google.protobuf.ByteString getOutputUriBytes();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `template_id` to use for populating `Job.config`.
   * The default is `preset/web-hd`, which is the only supported preset.
   *
   * User defined JobTemplate: `{job_template_id}`
   * </pre>
   *
   * <code>string template_id = 4 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return Whether the templateId field is set.
   */
  boolean hasTemplateId();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `template_id` to use for populating `Job.config`.
   * The default is `preset/web-hd`, which is the only supported preset.
   *
   * User defined JobTemplate: `{job_template_id}`
   * </pre>
   *
   * <code>string template_id = 4 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The templateId.
   */
  java.lang.String getTemplateId();

  /**
   *
   *
   * <pre>
   * Input only. Specify the `template_id` to use for populating `Job.config`.
   * The default is `preset/web-hd`, which is the only supported preset.
   *
   * User defined JobTemplate: `{job_template_id}`
   * </pre>
   *
   * <code>string template_id = 4 [(.google.api.field_behavior) = INPUT_ONLY];</code>
   *
   * @return The bytes for templateId.
   */
  com.google.protobuf.ByteString getTemplateIdBytes();

  /**
   *
   *
   * <pre>
   * The configuration for this job.
   * </pre>
   *
   * <code>.google.cloud.video.transcoder.v1.JobConfig config = 5;</code>
   *
   * @return Whether the config field is set.
   */
  boolean hasConfig();

  /**
   *
   *
   * <pre>
   * The configuration for this job.
   * </pre>
   *
   * <code>.google.cloud.video.transcoder.v1.JobConfig config = 5;</code>
   *
   * @return The config.
   */
  com.google.cloud.video.transcoder.v1.JobConfig getConfig();

  /**
   *
   *
   * <pre>
   * The configuration for this job.
   * </pre>
   *
   * <code>.google.cloud.video.transcoder.v1.JobConfig config = 5;</code>
   */
  com.google.cloud.video.transcoder.v1.JobConfigOrBuilder getConfigOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The current state of the job.
   * </pre>
   *
   * <code>
   * .google.cloud.video.transcoder.v1.Job.ProcessingState state = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The enum numeric value on the wire for state.
   */
  int getStateValue();

  /**
   *
   *
   * <pre>
   * Output only. The current state of the job.
   * </pre>
   *
   * <code>
   * .google.cloud.video.transcoder.v1.Job.ProcessingState state = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The state.
   */
  com.google.cloud.video.transcoder.v1.Job.ProcessingState getState();

  /**
   *
   *
   * <pre>
   * Output only. The time the job was created.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 12 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the createTime field is set.
   */
  boolean hasCreateTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the job was created.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 12 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The createTime.
   */
  com.google.protobuf.Timestamp getCreateTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the job was created.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp create_time = 12 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getCreateTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding started.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the startTime field is set.
   */
  boolean hasStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding started.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The startTime.
   */
  com.google.protobuf.Timestamp getStartTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding started.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 13 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getStartTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding finished.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 14 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return Whether the endTime field is set.
   */
  boolean hasEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding finished.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 14 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The endTime.
   */
  com.google.protobuf.Timestamp getEndTime();

  /**
   *
   *
   * <pre>
   * Output only. The time the transcoding finished.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 14 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   */
  com.google.protobuf.TimestampOrBuilder getEndTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Job time to live value in days, which will be effective after job
   * completion. Job should be deleted automatically after the given TTL. Enter
   * a value between 1 and 90. The default is 30.
   * </pre>
   *
   * <code>int32 ttl_after_completion_days = 15;</code>
   *
   * @return The ttlAfterCompletionDays.
   */
  int getTtlAfterCompletionDays();

  /**
   *
   *
   * <pre>
   * The labels associated with this job. You can use these to organize and
   * group your jobs.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 16;</code>
   */
  int getLabelsCount();

  /**
   *
   *
   * <pre>
   * The labels associated with this job. You can use these to organize and
   * group your jobs.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 16;</code>
   */
  boolean containsLabels(java.lang.String key);

  /** Use {@link #getLabelsMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String> getLabels();

  /**
   *
   *
   * <pre>
   * The labels associated with this job. You can use these to organize and
   * group your jobs.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 16;</code>
   */
  java.util.Map<java.lang.String, java.lang.String> getLabelsMap();

  /**
   *
   *
   * <pre>
   * The labels associated with this job. You can use these to organize and
   * group your jobs.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 16;</code>
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
   * The labels associated with this job. You can use these to organize and
   * group your jobs.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 16;</code>
   */
  java.lang.String getLabelsOrThrow(java.lang.String key);

  /**
   *
   *
   * <pre>
   * Output only. An error object that describes the reason for the failure.
   * This property is always present when
   * [ProcessingState][google.cloud.video.transcoder.v1.Job.ProcessingState] is
   * `FAILED`.
   * </pre>
   *
   * <code>.google.rpc.Status error = 17 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return Whether the error field is set.
   */
  boolean hasError();

  /**
   *
   *
   * <pre>
   * Output only. An error object that describes the reason for the failure.
   * This property is always present when
   * [ProcessingState][google.cloud.video.transcoder.v1.Job.ProcessingState] is
   * `FAILED`.
   * </pre>
   *
   * <code>.google.rpc.Status error = 17 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The error.
   */
  com.google.rpc.Status getError();

  /**
   *
   *
   * <pre>
   * Output only. An error object that describes the reason for the failure.
   * This property is always present when
   * [ProcessingState][google.cloud.video.transcoder.v1.Job.ProcessingState] is
   * `FAILED`.
   * </pre>
   *
   * <code>.google.rpc.Status error = 17 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  com.google.rpc.StatusOrBuilder getErrorOrBuilder();

  /**
   *
   *
   * <pre>
   * The processing mode of the job.
   * The default is `PROCESSING_MODE_INTERACTIVE`.
   * </pre>
   *
   * <code>.google.cloud.video.transcoder.v1.Job.ProcessingMode mode = 20;</code>
   *
   * @return The enum numeric value on the wire for mode.
   */
  int getModeValue();

  /**
   *
   *
   * <pre>
   * The processing mode of the job.
   * The default is `PROCESSING_MODE_INTERACTIVE`.
   * </pre>
   *
   * <code>.google.cloud.video.transcoder.v1.Job.ProcessingMode mode = 20;</code>
   *
   * @return The mode.
   */
  com.google.cloud.video.transcoder.v1.Job.ProcessingMode getMode();

  /**
   *
   *
   * <pre>
   * The processing priority of a batch job.
   * This field can only be set for batch mode jobs. The default value is 0.
   * This value cannot be negative. Higher values correspond to higher
   * priorities for the job.
   * </pre>
   *
   * <code>int32 batch_mode_priority = 21;</code>
   *
   * @return The batchModePriority.
   */
  int getBatchModePriority();

  /**
   *
   *
   * <pre>
   * Optional. The optimization strategy of the job. The default is
   * `AUTODETECT`.
   * </pre>
   *
   * <code>
   * .google.cloud.video.transcoder.v1.Job.OptimizationStrategy optimization = 22 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The enum numeric value on the wire for optimization.
   */
  int getOptimizationValue();

  /**
   *
   *
   * <pre>
   * Optional. The optimization strategy of the job. The default is
   * `AUTODETECT`.
   * </pre>
   *
   * <code>
   * .google.cloud.video.transcoder.v1.Job.OptimizationStrategy optimization = 22 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   *
   * @return The optimization.
   */
  com.google.cloud.video.transcoder.v1.Job.OptimizationStrategy getOptimization();

  /**
   *
   *
   * <pre>
   * Optional. Insert silence and duplicate frames when timestamp gaps are
   * detected in a given stream.
   * </pre>
   *
   * <code>bool fill_content_gaps = 25 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The fillContentGaps.
   */
  boolean getFillContentGaps();

  com.google.cloud.video.transcoder.v1.Job.JobConfigCase getJobConfigCase();
}
