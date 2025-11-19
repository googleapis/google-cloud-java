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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Evaluation result for a single evaluation case for a single metric. */
@AutoValue
@JsonDeserialize(builder = EvalCaseMetricResult.Builder.class)
public abstract class EvalCaseMetricResult extends JsonSerializable {
  /** Name of the metric. */
  @JsonProperty("metricName")
  public abstract Optional<String> metricName();

  /** Score of the metric. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** Explanation of the metric. */
  @JsonProperty("explanation")
  public abstract Optional<String> explanation();

  /** The details of all the rubrics and their verdicts for rubric-based metrics. */
  @JsonProperty("rubricVerdicts")
  public abstract Optional<List<RubricVerdict>> rubricVerdicts();

  /** Raw output of the metric. */
  @JsonProperty("rawOutput")
  public abstract Optional<List<String>> rawOutput();

  /** Error message for the metric. */
  @JsonProperty("errorMessage")
  public abstract Optional<String> errorMessage();

  /** Instantiates a builder for EvalCaseMetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvalCaseMetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvalCaseMetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvalCaseMetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvalCaseMetricResult.Builder();
    }

    /**
     * Setter for metricName.
     *
     * <p>metricName: Name of the metric.
     */
    @JsonProperty("metricName")
    public abstract Builder metricName(String metricName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricName(Optional<String> metricName);

    /** Clears the value of metricName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricName() {
      return metricName(Optional.empty());
    }

    /**
     * Setter for score.
     *
     * <p>score: Score of the metric.
     */
    @JsonProperty("score")
    public abstract Builder score(Float score);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder score(Optional<Float> score);

    /** Clears the value of score field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScore() {
      return score(Optional.empty());
    }

    /**
     * Setter for explanation.
     *
     * <p>explanation: Explanation of the metric.
     */
    @JsonProperty("explanation")
    public abstract Builder explanation(String explanation);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder explanation(Optional<String> explanation);

    /** Clears the value of explanation field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExplanation() {
      return explanation(Optional.empty());
    }

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts for rubric-based
     * metrics.
     */
    @JsonProperty("rubricVerdicts")
    public abstract Builder rubricVerdicts(List<RubricVerdict> rubricVerdicts);

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts for rubric-based
     * metrics.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict... rubricVerdicts) {
      return rubricVerdicts(Arrays.asList(rubricVerdicts));
    }

    /**
     * Setter for rubricVerdicts builder.
     *
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts for rubric-based
     * metrics.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict.Builder... rubricVerdictsBuilders) {
      return rubricVerdicts(
          Arrays.asList(rubricVerdictsBuilders).stream()
              .map(RubricVerdict.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricVerdicts(Optional<List<RubricVerdict>> rubricVerdicts);

    /** Clears the value of rubricVerdicts field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricVerdicts() {
      return rubricVerdicts(Optional.empty());
    }

    /**
     * Setter for rawOutput.
     *
     * <p>rawOutput: Raw output of the metric.
     */
    @JsonProperty("rawOutput")
    public abstract Builder rawOutput(List<String> rawOutput);

    /**
     * Setter for rawOutput.
     *
     * <p>rawOutput: Raw output of the metric.
     */
    @CanIgnoreReturnValue
    public Builder rawOutput(String... rawOutput) {
      return rawOutput(Arrays.asList(rawOutput));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rawOutput(Optional<List<String>> rawOutput);

    /** Clears the value of rawOutput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRawOutput() {
      return rawOutput(Optional.empty());
    }

    /**
     * Setter for errorMessage.
     *
     * <p>errorMessage: Error message for the metric.
     */
    @JsonProperty("errorMessage")
    public abstract Builder errorMessage(String errorMessage);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder errorMessage(Optional<String> errorMessage);

    /** Clears the value of errorMessage field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearErrorMessage() {
      return errorMessage(Optional.empty());
    }

    public abstract EvalCaseMetricResult build();
  }

  /** Deserializes a JSON string to a EvalCaseMetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvalCaseMetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvalCaseMetricResult.class);
  }
}
