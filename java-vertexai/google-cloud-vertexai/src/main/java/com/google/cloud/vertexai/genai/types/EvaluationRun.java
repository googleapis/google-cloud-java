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
import com.google.genai.types.GoogleRpcStatus;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/** Represents an evaluation run. */
@AutoValue
@JsonDeserialize(builder = EvaluationRun.Builder.class)
public abstract class EvaluationRun extends JsonSerializable {
  /** */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** */
  @JsonProperty("metadata")
  public abstract Optional<Map<String, Object>> metadata();

  /** */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** */
  @JsonProperty("completionTime")
  public abstract Optional<Instant> completionTime();

  /** */
  @JsonProperty("state")
  public abstract Optional<EvaluationRunState> state();

  /** */
  @JsonProperty("evaluationSetSnapshot")
  public abstract Optional<String> evaluationSetSnapshot();

  /** */
  @JsonProperty("error")
  public abstract Optional<GoogleRpcStatus> error();

  /** */
  @JsonProperty("dataSource")
  public abstract Optional<EvaluationRunDataSource> dataSource();

  /** The evaluation run formatted results. */
  @JsonProperty("evaluationRunResults")
  public abstract Optional<EvaluationRunResults> evaluationRunResults();

  /**
   * The parsed EvaluationItem results for the evaluation run. This is only populated when
   * include_evaluation_items is set to True.
   */
  @JsonProperty("evaluationItemResults")
  public abstract Optional<EvaluationResult> evaluationItemResults();

  /** The evaluation config for the evaluation run. */
  @JsonProperty("evaluationConfig")
  public abstract Optional<EvaluationRunConfig> evaluationConfig();

  /**
   * This field is experimental and may change in future versions. The inference configs for the
   * evaluation run.
   */
  @JsonProperty("inferenceConfigs")
  public abstract Optional<Map<String, EvaluationRunInferenceConfig>> inferenceConfigs();

  /** */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** Instantiates a builder for EvaluationRun. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRun.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRun. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRun.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRun.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name:
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
     * Setter for displayName.
     *
     * <p>displayName:
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
     * Setter for metadata.
     *
     * <p>metadata:
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Map<String, Object> metadata);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Map<String, Object>> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime:
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
     * Setter for completionTime.
     *
     * <p>completionTime:
     */
    @JsonProperty("completionTime")
    public abstract Builder completionTime(Instant completionTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder completionTime(Optional<Instant> completionTime);

    /** Clears the value of completionTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCompletionTime() {
      return completionTime(Optional.empty());
    }

    /**
     * Setter for state.
     *
     * <p>state:
     */
    @JsonProperty("state")
    public abstract Builder state(EvaluationRunState state);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder state(Optional<EvaluationRunState> state);

    /** Clears the value of state field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearState() {
      return state(Optional.empty());
    }

    /**
     * Setter for state given a known enum.
     *
     * <p>state:
     */
    @CanIgnoreReturnValue
    public Builder state(EvaluationRunState.Known knownType) {
      return state(new EvaluationRunState(knownType));
    }

    /**
     * Setter for state given a string.
     *
     * <p>state:
     */
    @CanIgnoreReturnValue
    public Builder state(String state) {
      return state(new EvaluationRunState(state));
    }

    /**
     * Setter for evaluationSetSnapshot.
     *
     * <p>evaluationSetSnapshot:
     */
    @JsonProperty("evaluationSetSnapshot")
    public abstract Builder evaluationSetSnapshot(String evaluationSetSnapshot);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationSetSnapshot(Optional<String> evaluationSetSnapshot);

    /** Clears the value of evaluationSetSnapshot field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationSetSnapshot() {
      return evaluationSetSnapshot(Optional.empty());
    }

    /**
     * Setter for error.
     *
     * <p>error:
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
     * Setter for dataSource.
     *
     * <p>dataSource:
     */
    @JsonProperty("dataSource")
    public abstract Builder dataSource(EvaluationRunDataSource dataSource);

    /**
     * Setter for dataSource builder.
     *
     * <p>dataSource:
     */
    @CanIgnoreReturnValue
    public Builder dataSource(EvaluationRunDataSource.Builder dataSourceBuilder) {
      return dataSource(dataSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dataSource(Optional<EvaluationRunDataSource> dataSource);

    /** Clears the value of dataSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDataSource() {
      return dataSource(Optional.empty());
    }

    /**
     * Setter for evaluationRunResults.
     *
     * <p>evaluationRunResults: The evaluation run formatted results.
     */
    @JsonProperty("evaluationRunResults")
    public abstract Builder evaluationRunResults(EvaluationRunResults evaluationRunResults);

    /**
     * Setter for evaluationRunResults builder.
     *
     * <p>evaluationRunResults: The evaluation run formatted results.
     */
    @CanIgnoreReturnValue
    public Builder evaluationRunResults(EvaluationRunResults.Builder evaluationRunResultsBuilder) {
      return evaluationRunResults(evaluationRunResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationRunResults(Optional<EvaluationRunResults> evaluationRunResults);

    /** Clears the value of evaluationRunResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationRunResults() {
      return evaluationRunResults(Optional.empty());
    }

    /**
     * Setter for evaluationItemResults.
     *
     * <p>evaluationItemResults: The parsed EvaluationItem results for the evaluation run. This is
     * only populated when include_evaluation_items is set to True.
     */
    @JsonProperty("evaluationItemResults")
    public abstract Builder evaluationItemResults(EvaluationResult evaluationItemResults);

    /**
     * Setter for evaluationItemResults builder.
     *
     * <p>evaluationItemResults: The parsed EvaluationItem results for the evaluation run. This is
     * only populated when include_evaluation_items is set to True.
     */
    @CanIgnoreReturnValue
    public Builder evaluationItemResults(EvaluationResult.Builder evaluationItemResultsBuilder) {
      return evaluationItemResults(evaluationItemResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationItemResults(Optional<EvaluationResult> evaluationItemResults);

    /** Clears the value of evaluationItemResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationItemResults() {
      return evaluationItemResults(Optional.empty());
    }

    /**
     * Setter for evaluationConfig.
     *
     * <p>evaluationConfig: The evaluation config for the evaluation run.
     */
    @JsonProperty("evaluationConfig")
    public abstract Builder evaluationConfig(EvaluationRunConfig evaluationConfig);

    /**
     * Setter for evaluationConfig builder.
     *
     * <p>evaluationConfig: The evaluation config for the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder evaluationConfig(EvaluationRunConfig.Builder evaluationConfigBuilder) {
      return evaluationConfig(evaluationConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationConfig(Optional<EvaluationRunConfig> evaluationConfig);

    /** Clears the value of evaluationConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationConfig() {
      return evaluationConfig(Optional.empty());
    }

    /**
     * Setter for inferenceConfigs.
     *
     * <p>inferenceConfigs: This field is experimental and may change in future versions. The
     * inference configs for the evaluation run.
     */
    @JsonProperty("inferenceConfigs")
    public abstract Builder inferenceConfigs(
        Map<String, EvaluationRunInferenceConfig> inferenceConfigs);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inferenceConfigs(
        Optional<Map<String, EvaluationRunInferenceConfig>> inferenceConfigs);

    /** Clears the value of inferenceConfigs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInferenceConfigs() {
      return inferenceConfigs(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels:
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

    public abstract EvaluationRun build();
  }

  /** Deserializes a JSON string to a EvaluationRun object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRun fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRun.class);
  }
}
