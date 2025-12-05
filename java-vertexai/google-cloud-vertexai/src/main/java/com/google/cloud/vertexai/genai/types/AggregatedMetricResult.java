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

/** Evaluation result for a single metric for an evaluation dataset. */
@AutoValue
@JsonDeserialize(builder = AggregatedMetricResult.Builder.class)
public abstract class AggregatedMetricResult extends JsonSerializable {
  /** Name of the metric. */
  @JsonProperty("metricName")
  public abstract Optional<String> metricName();

  /** Total number of cases in the dataset. */
  @JsonProperty("numCasesTotal")
  public abstract Optional<Integer> numCasesTotal();

  /** Number of valid cases in the dataset. */
  @JsonProperty("numCasesValid")
  public abstract Optional<Integer> numCasesValid();

  /** Number of cases with errors in the dataset. */
  @JsonProperty("numCasesError")
  public abstract Optional<Integer> numCasesError();

  /** Mean score of the metric. */
  @JsonProperty("meanScore")
  public abstract Optional<Float> meanScore();

  /** Standard deviation of the metric. */
  @JsonProperty("stdevScore")
  public abstract Optional<Float> stdevScore();

  /**
   * Pass rate of the adaptive rubric metric. Calculated as the number of cases where all criteria
   * passed divided by the total number of valid cases. A case is passing if it has a score of 1.0.
   */
  @JsonProperty("passRate")
  public abstract Optional<Float> passRate();

  /** Instantiates a builder for AggregatedMetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AggregatedMetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AggregatedMetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AggregatedMetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AggregatedMetricResult.Builder();
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
     * Setter for numCasesTotal.
     *
     * <p>numCasesTotal: Total number of cases in the dataset.
     */
    @JsonProperty("numCasesTotal")
    public abstract Builder numCasesTotal(Integer numCasesTotal);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder numCasesTotal(Optional<Integer> numCasesTotal);

    /** Clears the value of numCasesTotal field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNumCasesTotal() {
      return numCasesTotal(Optional.empty());
    }

    /**
     * Setter for numCasesValid.
     *
     * <p>numCasesValid: Number of valid cases in the dataset.
     */
    @JsonProperty("numCasesValid")
    public abstract Builder numCasesValid(Integer numCasesValid);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder numCasesValid(Optional<Integer> numCasesValid);

    /** Clears the value of numCasesValid field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNumCasesValid() {
      return numCasesValid(Optional.empty());
    }

    /**
     * Setter for numCasesError.
     *
     * <p>numCasesError: Number of cases with errors in the dataset.
     */
    @JsonProperty("numCasesError")
    public abstract Builder numCasesError(Integer numCasesError);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder numCasesError(Optional<Integer> numCasesError);

    /** Clears the value of numCasesError field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNumCasesError() {
      return numCasesError(Optional.empty());
    }

    /**
     * Setter for meanScore.
     *
     * <p>meanScore: Mean score of the metric.
     */
    @JsonProperty("meanScore")
    public abstract Builder meanScore(Float meanScore);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder meanScore(Optional<Float> meanScore);

    /** Clears the value of meanScore field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMeanScore() {
      return meanScore(Optional.empty());
    }

    /**
     * Setter for stdevScore.
     *
     * <p>stdevScore: Standard deviation of the metric.
     */
    @JsonProperty("stdevScore")
    public abstract Builder stdevScore(Float stdevScore);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder stdevScore(Optional<Float> stdevScore);

    /** Clears the value of stdevScore field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStdevScore() {
      return stdevScore(Optional.empty());
    }

    /**
     * Setter for passRate.
     *
     * <p>passRate: Pass rate of the adaptive rubric metric. Calculated as the number of cases where
     * all criteria passed divided by the total number of valid cases. A case is passing if it has a
     * score of 1.0.
     */
    @JsonProperty("passRate")
    public abstract Builder passRate(Float passRate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder passRate(Optional<Float> passRate);

    /** Clears the value of passRate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPassRate() {
      return passRate(Optional.empty());
    }

    public abstract AggregatedMetricResult build();
  }

  /** Deserializes a JSON string to a AggregatedMetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static AggregatedMetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AggregatedMetricResult.class);
  }
}
