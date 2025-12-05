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

/** The metric used for evaluation run. */
@AutoValue
@JsonDeserialize(builder = EvaluationRunMetric.Builder.class)
public abstract class EvaluationRunMetric extends JsonSerializable {
  /** The name of the metric. */
  @JsonProperty("metric")
  public abstract Optional<String> metric();

  /** The unified metric used for evaluation run. */
  @JsonProperty("metricConfig")
  public abstract Optional<UnifiedMetric> metricConfig();

  /** Instantiates a builder for EvaluationRunMetric. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunMetric.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunMetric. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunMetric.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunMetric.Builder();
    }

    /**
     * Setter for metric.
     *
     * <p>metric: The name of the metric.
     */
    @JsonProperty("metric")
    public abstract Builder metric(String metric);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metric(Optional<String> metric);

    /** Clears the value of metric field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetric() {
      return metric(Optional.empty());
    }

    /**
     * Setter for metricConfig.
     *
     * <p>metricConfig: The unified metric used for evaluation run.
     */
    @JsonProperty("metricConfig")
    public abstract Builder metricConfig(UnifiedMetric metricConfig);

    /**
     * Setter for metricConfig builder.
     *
     * <p>metricConfig: The unified metric used for evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder metricConfig(UnifiedMetric.Builder metricConfigBuilder) {
      return metricConfig(metricConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricConfig(Optional<UnifiedMetric> metricConfig);

    /** Clears the value of metricConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricConfig() {
      return metricConfig(Optional.empty());
    }

    public abstract EvaluationRunMetric build();
  }

  /** Deserializes a JSON string to a EvaluationRunMetric object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunMetric fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunMetric.class);
  }
}
