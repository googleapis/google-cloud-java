/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.EncryptionSpec;
import com.google.genai.types.GoogleRpcStatus;
import com.google.genai.types.JobState;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/** Represents a job that runs custom workloads such as a Docker container or a Python package. */
@AutoValue
@JsonDeserialize(builder = CustomJob.Builder.class)
public abstract class CustomJob extends JsonSerializable {
  /**
   * Required. The display name of the CustomJob. The name can be up to 128 characters long and can
   * consist of any UTF-8 characters.
   */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Required. Job spec. */
  @JsonProperty("jobSpec")
  public abstract Optional<CustomJobSpec> jobSpec();

  /**
   * Customer-managed encryption key options for a CustomJob. If this is set, then all resources
   * created by the CustomJob will be encrypted with the provided encryption key.
   */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** Output only. The detailed state of the job. */
  @JsonProperty("state")
  public abstract Optional<JobState> state();

  /**
   * Output only. Only populated when job's state is `JOB_STATE_FAILED` or `JOB_STATE_CANCELLED`.
   */
  @JsonProperty("error")
  public abstract Optional<GoogleRpcStatus> error();

  /** Output only. Time when the CustomJob was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /**
   * Output only. Time when the CustomJob entered any of the following states:
   * `JOB_STATE_SUCCEEDED`, `JOB_STATE_FAILED`, `JOB_STATE_CANCELLED`.
   */
  @JsonProperty("endTime")
  public abstract Optional<Instant> endTime();

  /**
   * The labels with user-defined metadata to organize CustomJobs. Label keys and values can be no
   * longer than 64 characters (Unicode codepoints), can only contain lowercase letters, numeric
   * characters, underscores and dashes. International characters are allowed. See
   * https://goo.gl/xmQnxf for more information and examples of labels.
   */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** Output only. Resource name of a CustomJob. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzi")
  public abstract Optional<Boolean> satisfiesPzi();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzs")
  public abstract Optional<Boolean> satisfiesPzs();

  /**
   * Output only. Time when the CustomJob for the first time entered the `JOB_STATE_RUNNING` state.
   */
  @JsonProperty("startTime")
  public abstract Optional<Instant> startTime();

  /** Output only. Time when the CustomJob was most recently updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /**
   * Output only. URIs for accessing [interactive
   * shells](https://cloud.google.com/vertex-ai/docs/training/monitor-debug-interactive-shell) (one
   * URI for each training node). Only available if job_spec.enable_web_access is `true`. The keys
   * are names of each node in the training job; for example, `workerpool0-0` for the primary node,
   * `workerpool1-0` for the first node in the second worker pool, and `workerpool1-1` for the
   * second node in the second worker pool. The values are the URIs for each node's interactive
   * shell.
   */
  @JsonProperty("webAccessUris")
  public abstract Optional<Map<String, String>> webAccessUris();

  /** Instantiates a builder for CustomJob. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CustomJob.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CustomJob. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CustomJob.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CustomJob.Builder();
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: Required. The display name of the CustomJob. The name can be up to 128
     * characters long and can consist of any UTF-8 characters.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for jobSpec.
     *
     * <p>jobSpec: Required. Job spec.
     */
    @JsonProperty("jobSpec")
    public abstract Builder jobSpec(CustomJobSpec jobSpec);

    /**
     * Setter for jobSpec builder.
     *
     * <p>jobSpec: Required. Job spec.
     */
    @CanIgnoreReturnValue
    public Builder jobSpec(CustomJobSpec.Builder jobSpecBuilder) {
      return jobSpec(jobSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder jobSpec(Optional<CustomJobSpec> jobSpec);

    /** Clears the value of jobSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJobSpec() {
      return jobSpec(Optional.empty());
    }

    /**
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec: Customer-managed encryption key options for a CustomJob. If this is set,
     * then all resources created by the CustomJob will be encrypted with the provided encryption
     * key.
     */
    @JsonProperty("encryptionSpec")
    public abstract Builder encryptionSpec(EncryptionSpec encryptionSpec);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder encryptionSpec(Optional<EncryptionSpec> encryptionSpec);

    /** Clears the value of encryptionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEncryptionSpec() {
      return encryptionSpec(Optional.empty());
    }

    /**
     * Setter for state.
     *
     * <p>state: Output only. The detailed state of the job.
     */
    @JsonProperty("state")
    public abstract Builder state(JobState state);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder state(Optional<JobState> state);

    /** Clears the value of state field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearState() {
      return state(Optional.empty());
    }

    /**
     * Setter for state given a known enum.
     *
     * <p>state: Output only. The detailed state of the job.
     */
    @CanIgnoreReturnValue
    public Builder state(JobState.Known knownType) {
      return state(new JobState(knownType));
    }

    /**
     * Setter for state given a string.
     *
     * <p>state: Output only. The detailed state of the job.
     */
    @CanIgnoreReturnValue
    public Builder state(String state) {
      return state(new JobState(state));
    }

    /**
     * Setter for error.
     *
     * <p>error: Output only. Only populated when job's state is `JOB_STATE_FAILED` or
     * `JOB_STATE_CANCELLED`.
     */
    @JsonProperty("error")
    public abstract Builder error(GoogleRpcStatus error);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder error(Optional<GoogleRpcStatus> error);

    /** Clears the value of error field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearError() {
      return error(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Output only. Time when the CustomJob was created.
     */
    @JsonProperty("createTime")
    public abstract Builder createTime(Instant createTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder createTime(Optional<Instant> createTime);

    /** Clears the value of createTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreateTime() {
      return createTime(Optional.empty());
    }

    /**
     * Setter for endTime.
     *
     * <p>endTime: Output only. Time when the CustomJob entered any of the following states:
     * `JOB_STATE_SUCCEEDED`, `JOB_STATE_FAILED`, `JOB_STATE_CANCELLED`.
     */
    @JsonProperty("endTime")
    public abstract Builder endTime(Instant endTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder endTime(Optional<Instant> endTime);

    /** Clears the value of endTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEndTime() {
      return endTime(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: The labels with user-defined metadata to organize CustomJobs. Label keys and
     * values can be no longer than 64 characters (Unicode codepoints), can only contain lowercase
     * letters, numeric characters, underscores and dashes. International characters are allowed.
     * See https://goo.gl/xmQnxf for more information and examples of labels.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for name.
     *
     * <p>name: Output only. Resource name of a CustomJob.
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for satisfiesPzi.
     *
     * <p>satisfiesPzi: Output only. Reserved for future use.
     */
    @JsonProperty("satisfiesPzi")
    public abstract Builder satisfiesPzi(boolean satisfiesPzi);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder satisfiesPzi(Optional<Boolean> satisfiesPzi);

    /** Clears the value of satisfiesPzi field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSatisfiesPzi() {
      return satisfiesPzi(Optional.empty());
    }

    /**
     * Setter for satisfiesPzs.
     *
     * <p>satisfiesPzs: Output only. Reserved for future use.
     */
    @JsonProperty("satisfiesPzs")
    public abstract Builder satisfiesPzs(boolean satisfiesPzs);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder satisfiesPzs(Optional<Boolean> satisfiesPzs);

    /** Clears the value of satisfiesPzs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSatisfiesPzs() {
      return satisfiesPzs(Optional.empty());
    }

    /**
     * Setter for startTime.
     *
     * <p>startTime: Output only. Time when the CustomJob for the first time entered the
     * `JOB_STATE_RUNNING` state.
     */
    @JsonProperty("startTime")
    public abstract Builder startTime(Instant startTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder startTime(Optional<Instant> startTime);

    /** Clears the value of startTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStartTime() {
      return startTime(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Time when the CustomJob was most recently updated.
     */
    @JsonProperty("updateTime")
    public abstract Builder updateTime(Instant updateTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder updateTime(Optional<Instant> updateTime);

    /** Clears the value of updateTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUpdateTime() {
      return updateTime(Optional.empty());
    }

    /**
     * Setter for webAccessUris.
     *
     * <p>webAccessUris: Output only. URIs for accessing [interactive
     * shells](https://cloud.google.com/vertex-ai/docs/training/monitor-debug-interactive-shell)
     * (one URI for each training node). Only available if job_spec.enable_web_access is `true`. The
     * keys are names of each node in the training job; for example, `workerpool0-0` for the primary
     * node, `workerpool1-0` for the first node in the second worker pool, and `workerpool1-1` for
     * the second node in the second worker pool. The values are the URIs for each node's
     * interactive shell.
     */
    @JsonProperty("webAccessUris")
    public abstract Builder webAccessUris(Map<String, String> webAccessUris);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder webAccessUris(Optional<Map<String, String>> webAccessUris);

    /** Clears the value of webAccessUris field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWebAccessUris() {
      return webAccessUris(Optional.empty());
    }

    public abstract CustomJob build();
  }

  /** Deserializes a JSON string to a CustomJob object. */
  @ExcludeFromGeneratedCoverageReport
  public static CustomJob fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CustomJob.class);
  }
}
