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
import java.util.Optional;

/** Represents the results of an evaluation run. */
@AutoValue
@JsonDeserialize(builder = EvaluationRunResults.Builder.class)
public abstract class EvaluationRunResults extends JsonSerializable {
  /** The evaluation set where item level results are stored. */
  @JsonProperty("evaluationSet")
  public abstract Optional<String> evaluationSet();

  /** The summary metrics for the evaluation run. */
  @JsonProperty("summaryMetrics")
  public abstract Optional<SummaryMetric> summaryMetrics();

  /** Instantiates a builder for EvaluationRunResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunResults.Builder();
    }

    /**
     * Setter for evaluationSet.
     *
     * <p>evaluationSet: The evaluation set where item level results are stored.
     */
    @JsonProperty("evaluationSet")
    public abstract Builder evaluationSet(String evaluationSet);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationSet(Optional<String> evaluationSet);

    /** Clears the value of evaluationSet field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationSet() {
      return evaluationSet(Optional.empty());
    }

    /**
     * Setter for summaryMetrics.
     *
     * <p>summaryMetrics: The summary metrics for the evaluation run.
     */
    @JsonProperty("summaryMetrics")
    public abstract Builder summaryMetrics(SummaryMetric summaryMetrics);

    /**
     * Setter for summaryMetrics builder.
     *
     * <p>summaryMetrics: The summary metrics for the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder summaryMetrics(SummaryMetric.Builder summaryMetricsBuilder) {
      return summaryMetrics(summaryMetricsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder summaryMetrics(Optional<SummaryMetric> summaryMetrics);

    /** Clears the value of summaryMetrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSummaryMetrics() {
      return summaryMetrics(Optional.empty());
    }

    public abstract EvaluationRunResults build();
  }

  /** Deserializes a JSON string to a EvaluationRunResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunResults.class);
  }
}
