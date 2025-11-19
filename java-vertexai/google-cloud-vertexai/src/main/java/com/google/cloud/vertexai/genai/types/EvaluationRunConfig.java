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
import com.google.genai.types.AutoraterConfig;
import com.google.genai.types.OutputConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** The evaluation configuration used for the evaluation run. */
@AutoValue
@JsonDeserialize(builder = EvaluationRunConfig.Builder.class)
public abstract class EvaluationRunConfig extends JsonSerializable {
  /** The metrics to be calculated in the evaluation run. */
  @JsonProperty("metrics")
  public abstract Optional<List<EvaluationRunMetric>> metrics();

  /** The output config for the evaluation run. */
  @JsonProperty("outputConfig")
  public abstract Optional<OutputConfig> outputConfig();

  /** The autorater config for the evaluation run. */
  @JsonProperty("autoraterConfig")
  public abstract Optional<AutoraterConfig> autoraterConfig();

  /** Instantiates a builder for EvaluationRunConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunConfig.Builder();
    }

    /**
     * Setter for metrics.
     *
     * <p>metrics: The metrics to be calculated in the evaluation run.
     */
    @JsonProperty("metrics")
    public abstract Builder metrics(List<EvaluationRunMetric> metrics);

    /**
     * Setter for metrics.
     *
     * <p>metrics: The metrics to be calculated in the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder metrics(EvaluationRunMetric... metrics) {
      return metrics(Arrays.asList(metrics));
    }

    /**
     * Setter for metrics builder.
     *
     * <p>metrics: The metrics to be calculated in the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder metrics(EvaluationRunMetric.Builder... metricsBuilders) {
      return metrics(
          Arrays.asList(metricsBuilders).stream()
              .map(EvaluationRunMetric.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metrics(Optional<List<EvaluationRunMetric>> metrics);

    /** Clears the value of metrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetrics() {
      return metrics(Optional.empty());
    }

    /**
     * Setter for outputConfig.
     *
     * <p>outputConfig: The output config for the evaluation run.
     */
    @JsonProperty("outputConfig")
    public abstract Builder outputConfig(OutputConfig outputConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder outputConfig(Optional<OutputConfig> outputConfig);

    /** Clears the value of outputConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOutputConfig() {
      return outputConfig(Optional.empty());
    }

    /**
     * Setter for autoraterConfig.
     *
     * <p>autoraterConfig: The autorater config for the evaluation run.
     */
    @JsonProperty("autoraterConfig")
    public abstract Builder autoraterConfig(AutoraterConfig autoraterConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder autoraterConfig(Optional<AutoraterConfig> autoraterConfig);

    /** Clears the value of autoraterConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAutoraterConfig() {
      return autoraterConfig(Optional.empty());
    }

    public abstract EvaluationRunConfig build();
  }

  /** Deserializes a JSON string to a EvaluationRunConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunConfig.class);
  }
}
