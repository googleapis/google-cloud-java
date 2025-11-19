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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.AutoraterConfig;
import com.google.genai.types.OutputConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Parameters for batch dataset evaluation. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = EvaluateDatasetRequestParameters.Builder.class)
public abstract class EvaluateDatasetRequestParameters extends JsonSerializable {
  /** */
  @JsonProperty("dataset")
  public abstract Optional<EvaluationDataset> dataset();

  /** */
  @JsonProperty("metrics")
  public abstract Optional<List<Metric>> metrics();

  /** */
  @JsonProperty("outputConfig")
  public abstract Optional<OutputConfig> outputConfig();

  /** */
  @JsonProperty("autoraterConfig")
  public abstract Optional<AutoraterConfig> autoraterConfig();

  /** */
  @JsonProperty("config")
  public abstract Optional<EvaluateDatasetConfig> config();

  /** Instantiates a builder for EvaluateDatasetRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluateDatasetRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluateDatasetRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `EvaluateDatasetRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluateDatasetRequestParameters.Builder();
    }

    /**
     * Setter for dataset.
     *
     * <p>dataset:
     */
    @JsonProperty("dataset")
    public abstract Builder dataset(EvaluationDataset dataset);

    /**
     * Setter for dataset builder.
     *
     * <p>dataset:
     */
    @CanIgnoreReturnValue
    public Builder dataset(EvaluationDataset.Builder datasetBuilder) {
      return dataset(datasetBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dataset(Optional<EvaluationDataset> dataset);

    /** Clears the value of dataset field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDataset() {
      return dataset(Optional.empty());
    }

    /**
     * Setter for metrics.
     *
     * <p>metrics:
     */
    @JsonProperty("metrics")
    public abstract Builder metrics(List<Metric> metrics);

    /**
     * Setter for metrics.
     *
     * <p>metrics:
     */
    @CanIgnoreReturnValue
    public Builder metrics(Metric... metrics) {
      return metrics(Arrays.asList(metrics));
    }

    /**
     * Setter for metrics builder.
     *
     * <p>metrics:
     */
    @CanIgnoreReturnValue
    public Builder metrics(Metric.Builder... metricsBuilders) {
      return metrics(
          Arrays.asList(metricsBuilders).stream()
              .map(Metric.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metrics(Optional<List<Metric>> metrics);

    /** Clears the value of metrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetrics() {
      return metrics(Optional.empty());
    }

    /**
     * Setter for outputConfig.
     *
     * <p>outputConfig:
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
     * <p>autoraterConfig:
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

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(EvaluateDatasetConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(EvaluateDatasetConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<EvaluateDatasetConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract EvaluateDatasetRequestParameters build();
  }

  /** Deserializes a JSON string to a EvaluateDatasetRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluateDatasetRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluateDatasetRequestParameters.class);
  }
}
