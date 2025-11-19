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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Parameters for evaluating instances. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = EvaluateInstancesRequestParameters.Builder.class)
public abstract class EvaluateInstancesRequestParameters extends JsonSerializable {
  /** */
  @JsonProperty("bleuInput")
  public abstract Optional<BleuInput> bleuInput();

  /** */
  @JsonProperty("exactMatchInput")
  public abstract Optional<ExactMatchInput> exactMatchInput();

  /** */
  @JsonProperty("rougeInput")
  public abstract Optional<RougeInput> rougeInput();

  /** */
  @JsonProperty("pointwiseMetricInput")
  public abstract Optional<PointwiseMetricInput> pointwiseMetricInput();

  /** */
  @JsonProperty("pairwiseMetricInput")
  public abstract Optional<PairwiseMetricInput> pairwiseMetricInput();

  /** */
  @JsonProperty("toolCallValidInput")
  public abstract Optional<ToolCallValidInput> toolCallValidInput();

  /** */
  @JsonProperty("toolNameMatchInput")
  public abstract Optional<ToolNameMatchInput> toolNameMatchInput();

  /** */
  @JsonProperty("toolParameterKeyMatchInput")
  public abstract Optional<ToolParameterKeyMatchInput> toolParameterKeyMatchInput();

  /** */
  @JsonProperty("toolParameterKvMatchInput")
  public abstract Optional<ToolParameterKVMatchInput> toolParameterKvMatchInput();

  /** */
  @JsonProperty("rubricBasedMetricInput")
  public abstract Optional<RubricBasedMetricInput> rubricBasedMetricInput();

  /** */
  @JsonProperty("autoraterConfig")
  public abstract Optional<AutoraterConfig> autoraterConfig();

  /**
   * The metrics used for evaluation. Currently, we only support evaluating a single metric. If
   * multiple metrics are provided, only the first one will be evaluated.
   */
  @JsonProperty("metrics")
  public abstract Optional<List<Metric>> metrics();

  /** The instance to be evaluated. */
  @JsonProperty("instance")
  public abstract Optional<EvaluationInstance> instance();

  /** */
  @JsonProperty("config")
  public abstract Optional<EvaluateInstancesConfig> config();

  /** Instantiates a builder for EvaluateInstancesRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluateInstancesRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluateInstancesRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `EvaluateInstancesRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluateInstancesRequestParameters.Builder();
    }

    /**
     * Setter for bleuInput.
     *
     * <p>bleuInput:
     */
    @JsonProperty("bleuInput")
    public abstract Builder bleuInput(BleuInput bleuInput);

    /**
     * Setter for bleuInput builder.
     *
     * <p>bleuInput:
     */
    @CanIgnoreReturnValue
    public Builder bleuInput(BleuInput.Builder bleuInputBuilder) {
      return bleuInput(bleuInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bleuInput(Optional<BleuInput> bleuInput);

    /** Clears the value of bleuInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBleuInput() {
      return bleuInput(Optional.empty());
    }

    /**
     * Setter for exactMatchInput.
     *
     * <p>exactMatchInput:
     */
    @JsonProperty("exactMatchInput")
    public abstract Builder exactMatchInput(ExactMatchInput exactMatchInput);

    /**
     * Setter for exactMatchInput builder.
     *
     * <p>exactMatchInput:
     */
    @CanIgnoreReturnValue
    public Builder exactMatchInput(ExactMatchInput.Builder exactMatchInputBuilder) {
      return exactMatchInput(exactMatchInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder exactMatchInput(Optional<ExactMatchInput> exactMatchInput);

    /** Clears the value of exactMatchInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExactMatchInput() {
      return exactMatchInput(Optional.empty());
    }

    /**
     * Setter for rougeInput.
     *
     * <p>rougeInput:
     */
    @JsonProperty("rougeInput")
    public abstract Builder rougeInput(RougeInput rougeInput);

    /**
     * Setter for rougeInput builder.
     *
     * <p>rougeInput:
     */
    @CanIgnoreReturnValue
    public Builder rougeInput(RougeInput.Builder rougeInputBuilder) {
      return rougeInput(rougeInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rougeInput(Optional<RougeInput> rougeInput);

    /** Clears the value of rougeInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRougeInput() {
      return rougeInput(Optional.empty());
    }

    /**
     * Setter for pointwiseMetricInput.
     *
     * <p>pointwiseMetricInput:
     */
    @JsonProperty("pointwiseMetricInput")
    public abstract Builder pointwiseMetricInput(PointwiseMetricInput pointwiseMetricInput);

    /**
     * Setter for pointwiseMetricInput builder.
     *
     * <p>pointwiseMetricInput:
     */
    @CanIgnoreReturnValue
    public Builder pointwiseMetricInput(PointwiseMetricInput.Builder pointwiseMetricInputBuilder) {
      return pointwiseMetricInput(pointwiseMetricInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pointwiseMetricInput(Optional<PointwiseMetricInput> pointwiseMetricInput);

    /** Clears the value of pointwiseMetricInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPointwiseMetricInput() {
      return pointwiseMetricInput(Optional.empty());
    }

    /**
     * Setter for pairwiseMetricInput.
     *
     * <p>pairwiseMetricInput:
     */
    @JsonProperty("pairwiseMetricInput")
    public abstract Builder pairwiseMetricInput(PairwiseMetricInput pairwiseMetricInput);

    /**
     * Setter for pairwiseMetricInput builder.
     *
     * <p>pairwiseMetricInput:
     */
    @CanIgnoreReturnValue
    public Builder pairwiseMetricInput(PairwiseMetricInput.Builder pairwiseMetricInputBuilder) {
      return pairwiseMetricInput(pairwiseMetricInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pairwiseMetricInput(Optional<PairwiseMetricInput> pairwiseMetricInput);

    /** Clears the value of pairwiseMetricInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPairwiseMetricInput() {
      return pairwiseMetricInput(Optional.empty());
    }

    /**
     * Setter for toolCallValidInput.
     *
     * <p>toolCallValidInput:
     */
    @JsonProperty("toolCallValidInput")
    public abstract Builder toolCallValidInput(ToolCallValidInput toolCallValidInput);

    /**
     * Setter for toolCallValidInput builder.
     *
     * <p>toolCallValidInput:
     */
    @CanIgnoreReturnValue
    public Builder toolCallValidInput(ToolCallValidInput.Builder toolCallValidInputBuilder) {
      return toolCallValidInput(toolCallValidInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolCallValidInput(Optional<ToolCallValidInput> toolCallValidInput);

    /** Clears the value of toolCallValidInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolCallValidInput() {
      return toolCallValidInput(Optional.empty());
    }

    /**
     * Setter for toolNameMatchInput.
     *
     * <p>toolNameMatchInput:
     */
    @JsonProperty("toolNameMatchInput")
    public abstract Builder toolNameMatchInput(ToolNameMatchInput toolNameMatchInput);

    /**
     * Setter for toolNameMatchInput builder.
     *
     * <p>toolNameMatchInput:
     */
    @CanIgnoreReturnValue
    public Builder toolNameMatchInput(ToolNameMatchInput.Builder toolNameMatchInputBuilder) {
      return toolNameMatchInput(toolNameMatchInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolNameMatchInput(Optional<ToolNameMatchInput> toolNameMatchInput);

    /** Clears the value of toolNameMatchInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolNameMatchInput() {
      return toolNameMatchInput(Optional.empty());
    }

    /**
     * Setter for toolParameterKeyMatchInput.
     *
     * <p>toolParameterKeyMatchInput:
     */
    @JsonProperty("toolParameterKeyMatchInput")
    public abstract Builder toolParameterKeyMatchInput(
        ToolParameterKeyMatchInput toolParameterKeyMatchInput);

    /**
     * Setter for toolParameterKeyMatchInput builder.
     *
     * <p>toolParameterKeyMatchInput:
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKeyMatchInput(
        ToolParameterKeyMatchInput.Builder toolParameterKeyMatchInputBuilder) {
      return toolParameterKeyMatchInput(toolParameterKeyMatchInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKeyMatchInput(
        Optional<ToolParameterKeyMatchInput> toolParameterKeyMatchInput);

    /** Clears the value of toolParameterKeyMatchInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKeyMatchInput() {
      return toolParameterKeyMatchInput(Optional.empty());
    }

    /**
     * Setter for toolParameterKvMatchInput.
     *
     * <p>toolParameterKvMatchInput:
     */
    @JsonProperty("toolParameterKvMatchInput")
    public abstract Builder toolParameterKvMatchInput(
        ToolParameterKVMatchInput toolParameterKvMatchInput);

    /**
     * Setter for toolParameterKvMatchInput builder.
     *
     * <p>toolParameterKvMatchInput:
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKvMatchInput(
        ToolParameterKVMatchInput.Builder toolParameterKvMatchInputBuilder) {
      return toolParameterKvMatchInput(toolParameterKvMatchInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKvMatchInput(
        Optional<ToolParameterKVMatchInput> toolParameterKvMatchInput);

    /** Clears the value of toolParameterKvMatchInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKvMatchInput() {
      return toolParameterKvMatchInput(Optional.empty());
    }

    /**
     * Setter for rubricBasedMetricInput.
     *
     * <p>rubricBasedMetricInput:
     */
    @JsonProperty("rubricBasedMetricInput")
    public abstract Builder rubricBasedMetricInput(RubricBasedMetricInput rubricBasedMetricInput);

    /**
     * Setter for rubricBasedMetricInput builder.
     *
     * <p>rubricBasedMetricInput:
     */
    @CanIgnoreReturnValue
    public Builder rubricBasedMetricInput(
        RubricBasedMetricInput.Builder rubricBasedMetricInputBuilder) {
      return rubricBasedMetricInput(rubricBasedMetricInputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricBasedMetricInput(
        Optional<RubricBasedMetricInput> rubricBasedMetricInput);

    /** Clears the value of rubricBasedMetricInput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricBasedMetricInput() {
      return rubricBasedMetricInput(Optional.empty());
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
     * Setter for metrics.
     *
     * <p>metrics: The metrics used for evaluation. Currently, we only support evaluating a single
     * metric. If multiple metrics are provided, only the first one will be evaluated.
     */
    @JsonProperty("metrics")
    public abstract Builder metrics(List<Metric> metrics);

    /**
     * Setter for metrics.
     *
     * <p>metrics: The metrics used for evaluation. Currently, we only support evaluating a single
     * metric. If multiple metrics are provided, only the first one will be evaluated.
     */
    @CanIgnoreReturnValue
    public Builder metrics(Metric... metrics) {
      return metrics(Arrays.asList(metrics));
    }

    /**
     * Setter for metrics builder.
     *
     * <p>metrics: The metrics used for evaluation. Currently, we only support evaluating a single
     * metric. If multiple metrics are provided, only the first one will be evaluated.
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
     * Setter for instance.
     *
     * <p>instance: The instance to be evaluated.
     */
    @JsonProperty("instance")
    public abstract Builder instance(EvaluationInstance instance);

    /**
     * Setter for instance builder.
     *
     * <p>instance: The instance to be evaluated.
     */
    @CanIgnoreReturnValue
    public Builder instance(EvaluationInstance.Builder instanceBuilder) {
      return instance(instanceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instance(Optional<EvaluationInstance> instance);

    /** Clears the value of instance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstance() {
      return instance(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(EvaluateInstancesConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(EvaluateInstancesConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<EvaluateInstancesConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract EvaluateInstancesRequestParameters build();
  }

  /** Deserializes a JSON string to a EvaluateInstancesRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluateInstancesRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluateInstancesRequestParameters.class);
  }
}
