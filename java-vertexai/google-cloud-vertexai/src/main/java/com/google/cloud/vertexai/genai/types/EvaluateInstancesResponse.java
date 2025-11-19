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

/** Result of evaluating an LLM metric. */
@AutoValue
@JsonDeserialize(builder = EvaluateInstancesResponse.Builder.class)
public abstract class EvaluateInstancesResponse extends JsonSerializable {
  /** Result for rubric based metric. */
  @JsonProperty("rubricBasedMetricResult")
  public abstract Optional<RubricBasedMetricResult> rubricBasedMetricResult();

  /**
   * A list of metric results for each evaluation case. The order of the metric results is
   * guaranteed to be the same as the order of the instances in the request.
   */
  @JsonProperty("metricResults")
  public abstract Optional<List<MetricResult>> metricResults();

  /** Results for bleu metric. */
  @JsonProperty("bleuResults")
  public abstract Optional<BleuResults> bleuResults();

  /** Translation metrics. Result for Comet metric. */
  @JsonProperty("cometResult")
  public abstract Optional<CometResult> cometResult();

  /** Auto metric evaluation results. Results for exact match metric. */
  @JsonProperty("exactMatchResults")
  public abstract Optional<ExactMatchResults> exactMatchResults();

  /** Result for Metricx metric. */
  @JsonProperty("metricxResult")
  public abstract Optional<MetricxResult> metricxResult();

  /** Result for pairwise metric. */
  @JsonProperty("pairwiseMetricResult")
  public abstract Optional<PairwiseMetricResult> pairwiseMetricResult();

  /** Generic metrics. Result for pointwise metric. */
  @JsonProperty("pointwiseMetricResult")
  public abstract Optional<PointwiseMetricResult> pointwiseMetricResult();

  /** Results for rouge metric. */
  @JsonProperty("rougeResults")
  public abstract Optional<RougeResults> rougeResults();

  /** Tool call metrics. Results for tool call valid metric. */
  @JsonProperty("toolCallValidResults")
  public abstract Optional<ToolCallValidResults> toolCallValidResults();

  /** Results for tool name match metric. */
  @JsonProperty("toolNameMatchResults")
  public abstract Optional<ToolNameMatchResults> toolNameMatchResults();

  /** Results for tool parameter key match metric. */
  @JsonProperty("toolParameterKeyMatchResults")
  public abstract Optional<ToolParameterKeyMatchResults> toolParameterKeyMatchResults();

  /** Results for tool parameter key value match metric. */
  @JsonProperty("toolParameterKvMatchResults")
  public abstract Optional<ToolParameterKVMatchResults> toolParameterKvMatchResults();

  /** Instantiates a builder for EvaluateInstancesResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluateInstancesResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluateInstancesResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluateInstancesResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluateInstancesResponse.Builder();
    }

    /**
     * Setter for rubricBasedMetricResult.
     *
     * <p>rubricBasedMetricResult: Result for rubric based metric.
     */
    @JsonProperty("rubricBasedMetricResult")
    public abstract Builder rubricBasedMetricResult(
        RubricBasedMetricResult rubricBasedMetricResult);

    /**
     * Setter for rubricBasedMetricResult builder.
     *
     * <p>rubricBasedMetricResult: Result for rubric based metric.
     */
    @CanIgnoreReturnValue
    public Builder rubricBasedMetricResult(
        RubricBasedMetricResult.Builder rubricBasedMetricResultBuilder) {
      return rubricBasedMetricResult(rubricBasedMetricResultBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricBasedMetricResult(
        Optional<RubricBasedMetricResult> rubricBasedMetricResult);

    /** Clears the value of rubricBasedMetricResult field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricBasedMetricResult() {
      return rubricBasedMetricResult(Optional.empty());
    }

    /**
     * Setter for metricResults.
     *
     * <p>metricResults: A list of metric results for each evaluation case. The order of the metric
     * results is guaranteed to be the same as the order of the instances in the request.
     */
    @JsonProperty("metricResults")
    public abstract Builder metricResults(List<MetricResult> metricResults);

    /**
     * Setter for metricResults.
     *
     * <p>metricResults: A list of metric results for each evaluation case. The order of the metric
     * results is guaranteed to be the same as the order of the instances in the request.
     */
    @CanIgnoreReturnValue
    public Builder metricResults(MetricResult... metricResults) {
      return metricResults(Arrays.asList(metricResults));
    }

    /**
     * Setter for metricResults builder.
     *
     * <p>metricResults: A list of metric results for each evaluation case. The order of the metric
     * results is guaranteed to be the same as the order of the instances in the request.
     */
    @CanIgnoreReturnValue
    public Builder metricResults(MetricResult.Builder... metricResultsBuilders) {
      return metricResults(
          Arrays.asList(metricResultsBuilders).stream()
              .map(MetricResult.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricResults(Optional<List<MetricResult>> metricResults);

    /** Clears the value of metricResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricResults() {
      return metricResults(Optional.empty());
    }

    /**
     * Setter for bleuResults.
     *
     * <p>bleuResults: Results for bleu metric.
     */
    @JsonProperty("bleuResults")
    public abstract Builder bleuResults(BleuResults bleuResults);

    /**
     * Setter for bleuResults builder.
     *
     * <p>bleuResults: Results for bleu metric.
     */
    @CanIgnoreReturnValue
    public Builder bleuResults(BleuResults.Builder bleuResultsBuilder) {
      return bleuResults(bleuResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bleuResults(Optional<BleuResults> bleuResults);

    /** Clears the value of bleuResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBleuResults() {
      return bleuResults(Optional.empty());
    }

    /**
     * Setter for cometResult.
     *
     * <p>cometResult: Translation metrics. Result for Comet metric.
     */
    @JsonProperty("cometResult")
    public abstract Builder cometResult(CometResult cometResult);

    /**
     * Setter for cometResult builder.
     *
     * <p>cometResult: Translation metrics. Result for Comet metric.
     */
    @CanIgnoreReturnValue
    public Builder cometResult(CometResult.Builder cometResultBuilder) {
      return cometResult(cometResultBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder cometResult(Optional<CometResult> cometResult);

    /** Clears the value of cometResult field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCometResult() {
      return cometResult(Optional.empty());
    }

    /**
     * Setter for exactMatchResults.
     *
     * <p>exactMatchResults: Auto metric evaluation results. Results for exact match metric.
     */
    @JsonProperty("exactMatchResults")
    public abstract Builder exactMatchResults(ExactMatchResults exactMatchResults);

    /**
     * Setter for exactMatchResults builder.
     *
     * <p>exactMatchResults: Auto metric evaluation results. Results for exact match metric.
     */
    @CanIgnoreReturnValue
    public Builder exactMatchResults(ExactMatchResults.Builder exactMatchResultsBuilder) {
      return exactMatchResults(exactMatchResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder exactMatchResults(Optional<ExactMatchResults> exactMatchResults);

    /** Clears the value of exactMatchResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExactMatchResults() {
      return exactMatchResults(Optional.empty());
    }

    /**
     * Setter for metricxResult.
     *
     * <p>metricxResult: Result for Metricx metric.
     */
    @JsonProperty("metricxResult")
    public abstract Builder metricxResult(MetricxResult metricxResult);

    /**
     * Setter for metricxResult builder.
     *
     * <p>metricxResult: Result for Metricx metric.
     */
    @CanIgnoreReturnValue
    public Builder metricxResult(MetricxResult.Builder metricxResultBuilder) {
      return metricxResult(metricxResultBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricxResult(Optional<MetricxResult> metricxResult);

    /** Clears the value of metricxResult field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricxResult() {
      return metricxResult(Optional.empty());
    }

    /**
     * Setter for pairwiseMetricResult.
     *
     * <p>pairwiseMetricResult: Result for pairwise metric.
     */
    @JsonProperty("pairwiseMetricResult")
    public abstract Builder pairwiseMetricResult(PairwiseMetricResult pairwiseMetricResult);

    /**
     * Setter for pairwiseMetricResult builder.
     *
     * <p>pairwiseMetricResult: Result for pairwise metric.
     */
    @CanIgnoreReturnValue
    public Builder pairwiseMetricResult(PairwiseMetricResult.Builder pairwiseMetricResultBuilder) {
      return pairwiseMetricResult(pairwiseMetricResultBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pairwiseMetricResult(Optional<PairwiseMetricResult> pairwiseMetricResult);

    /** Clears the value of pairwiseMetricResult field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPairwiseMetricResult() {
      return pairwiseMetricResult(Optional.empty());
    }

    /**
     * Setter for pointwiseMetricResult.
     *
     * <p>pointwiseMetricResult: Generic metrics. Result for pointwise metric.
     */
    @JsonProperty("pointwiseMetricResult")
    public abstract Builder pointwiseMetricResult(PointwiseMetricResult pointwiseMetricResult);

    /**
     * Setter for pointwiseMetricResult builder.
     *
     * <p>pointwiseMetricResult: Generic metrics. Result for pointwise metric.
     */
    @CanIgnoreReturnValue
    public Builder pointwiseMetricResult(
        PointwiseMetricResult.Builder pointwiseMetricResultBuilder) {
      return pointwiseMetricResult(pointwiseMetricResultBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pointwiseMetricResult(Optional<PointwiseMetricResult> pointwiseMetricResult);

    /** Clears the value of pointwiseMetricResult field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPointwiseMetricResult() {
      return pointwiseMetricResult(Optional.empty());
    }

    /**
     * Setter for rougeResults.
     *
     * <p>rougeResults: Results for rouge metric.
     */
    @JsonProperty("rougeResults")
    public abstract Builder rougeResults(RougeResults rougeResults);

    /**
     * Setter for rougeResults builder.
     *
     * <p>rougeResults: Results for rouge metric.
     */
    @CanIgnoreReturnValue
    public Builder rougeResults(RougeResults.Builder rougeResultsBuilder) {
      return rougeResults(rougeResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rougeResults(Optional<RougeResults> rougeResults);

    /** Clears the value of rougeResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRougeResults() {
      return rougeResults(Optional.empty());
    }

    /**
     * Setter for toolCallValidResults.
     *
     * <p>toolCallValidResults: Tool call metrics. Results for tool call valid metric.
     */
    @JsonProperty("toolCallValidResults")
    public abstract Builder toolCallValidResults(ToolCallValidResults toolCallValidResults);

    /**
     * Setter for toolCallValidResults builder.
     *
     * <p>toolCallValidResults: Tool call metrics. Results for tool call valid metric.
     */
    @CanIgnoreReturnValue
    public Builder toolCallValidResults(ToolCallValidResults.Builder toolCallValidResultsBuilder) {
      return toolCallValidResults(toolCallValidResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolCallValidResults(Optional<ToolCallValidResults> toolCallValidResults);

    /** Clears the value of toolCallValidResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolCallValidResults() {
      return toolCallValidResults(Optional.empty());
    }

    /**
     * Setter for toolNameMatchResults.
     *
     * <p>toolNameMatchResults: Results for tool name match metric.
     */
    @JsonProperty("toolNameMatchResults")
    public abstract Builder toolNameMatchResults(ToolNameMatchResults toolNameMatchResults);

    /**
     * Setter for toolNameMatchResults builder.
     *
     * <p>toolNameMatchResults: Results for tool name match metric.
     */
    @CanIgnoreReturnValue
    public Builder toolNameMatchResults(ToolNameMatchResults.Builder toolNameMatchResultsBuilder) {
      return toolNameMatchResults(toolNameMatchResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolNameMatchResults(Optional<ToolNameMatchResults> toolNameMatchResults);

    /** Clears the value of toolNameMatchResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolNameMatchResults() {
      return toolNameMatchResults(Optional.empty());
    }

    /**
     * Setter for toolParameterKeyMatchResults.
     *
     * <p>toolParameterKeyMatchResults: Results for tool parameter key match metric.
     */
    @JsonProperty("toolParameterKeyMatchResults")
    public abstract Builder toolParameterKeyMatchResults(
        ToolParameterKeyMatchResults toolParameterKeyMatchResults);

    /**
     * Setter for toolParameterKeyMatchResults builder.
     *
     * <p>toolParameterKeyMatchResults: Results for tool parameter key match metric.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKeyMatchResults(
        ToolParameterKeyMatchResults.Builder toolParameterKeyMatchResultsBuilder) {
      return toolParameterKeyMatchResults(toolParameterKeyMatchResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKeyMatchResults(
        Optional<ToolParameterKeyMatchResults> toolParameterKeyMatchResults);

    /** Clears the value of toolParameterKeyMatchResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKeyMatchResults() {
      return toolParameterKeyMatchResults(Optional.empty());
    }

    /**
     * Setter for toolParameterKvMatchResults.
     *
     * <p>toolParameterKvMatchResults: Results for tool parameter key value match metric.
     */
    @JsonProperty("toolParameterKvMatchResults")
    public abstract Builder toolParameterKvMatchResults(
        ToolParameterKVMatchResults toolParameterKvMatchResults);

    /**
     * Setter for toolParameterKvMatchResults builder.
     *
     * <p>toolParameterKvMatchResults: Results for tool parameter key value match metric.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKvMatchResults(
        ToolParameterKVMatchResults.Builder toolParameterKvMatchResultsBuilder) {
      return toolParameterKvMatchResults(toolParameterKvMatchResultsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKvMatchResults(
        Optional<ToolParameterKVMatchResults> toolParameterKvMatchResults);

    /** Clears the value of toolParameterKvMatchResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKvMatchResults() {
      return toolParameterKvMatchResults(Optional.empty());
    }

    public abstract EvaluateInstancesResponse build();
  }

  /** Deserializes a JSON string to a EvaluateInstancesResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluateInstancesResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluateInstancesResponse.class);
  }
}
