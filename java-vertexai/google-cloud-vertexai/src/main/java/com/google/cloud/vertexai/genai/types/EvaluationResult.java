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
import java.util.Map;
import java.util.Optional;

/** Result of an evaluation run for an evaluation dataset. */
@AutoValue
@JsonDeserialize(builder = EvaluationResult.Builder.class)
public abstract class EvaluationResult extends JsonSerializable {
  /** A list of evaluation results for each evaluation case. */
  @JsonProperty("evalCaseResults")
  public abstract Optional<List<EvalCaseResult>> evalCaseResults();

  /** A list of summary-level evaluation results for each metric. */
  @JsonProperty("summaryMetrics")
  public abstract Optional<List<AggregatedMetricResult>> summaryMetrics();

  /**
   * A dictionary of win rates for each metric, only populated for multi-response evaluation runs.
   */
  @JsonProperty("winRates")
  public abstract Optional<Map<String, WinRateStats>> winRates();

  /** The input evaluation dataset(s) for the evaluation run. */
  @JsonProperty("evaluationDataset")
  public abstract Optional<List<EvaluationDataset>> evaluationDataset();

  /** Metadata for the evaluation run. */
  @JsonProperty("metadata")
  public abstract Optional<EvaluationRunMetadata> metadata();

  /**
   * This field is experimental and may change in future versions. The agent info of the agent under
   * evaluation. This can be extended for multi-agent evaluation.
   */
  @JsonProperty("agentInfo")
  public abstract Optional<AgentInfo> agentInfo();

  /** Instantiates a builder for EvaluationResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationResult.Builder();
    }

    /**
     * Setter for evalCaseResults.
     *
     * <p>evalCaseResults: A list of evaluation results for each evaluation case.
     */
    @JsonProperty("evalCaseResults")
    public abstract Builder evalCaseResults(List<EvalCaseResult> evalCaseResults);

    /**
     * Setter for evalCaseResults.
     *
     * <p>evalCaseResults: A list of evaluation results for each evaluation case.
     */
    @CanIgnoreReturnValue
    public Builder evalCaseResults(EvalCaseResult... evalCaseResults) {
      return evalCaseResults(Arrays.asList(evalCaseResults));
    }

    /**
     * Setter for evalCaseResults builder.
     *
     * <p>evalCaseResults: A list of evaluation results for each evaluation case.
     */
    @CanIgnoreReturnValue
    public Builder evalCaseResults(EvalCaseResult.Builder... evalCaseResultsBuilders) {
      return evalCaseResults(
          Arrays.asList(evalCaseResultsBuilders).stream()
              .map(EvalCaseResult.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evalCaseResults(Optional<List<EvalCaseResult>> evalCaseResults);

    /** Clears the value of evalCaseResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvalCaseResults() {
      return evalCaseResults(Optional.empty());
    }

    /**
     * Setter for summaryMetrics.
     *
     * <p>summaryMetrics: A list of summary-level evaluation results for each metric.
     */
    @JsonProperty("summaryMetrics")
    public abstract Builder summaryMetrics(List<AggregatedMetricResult> summaryMetrics);

    /**
     * Setter for summaryMetrics.
     *
     * <p>summaryMetrics: A list of summary-level evaluation results for each metric.
     */
    @CanIgnoreReturnValue
    public Builder summaryMetrics(AggregatedMetricResult... summaryMetrics) {
      return summaryMetrics(Arrays.asList(summaryMetrics));
    }

    /**
     * Setter for summaryMetrics builder.
     *
     * <p>summaryMetrics: A list of summary-level evaluation results for each metric.
     */
    @CanIgnoreReturnValue
    public Builder summaryMetrics(AggregatedMetricResult.Builder... summaryMetricsBuilders) {
      return summaryMetrics(
          Arrays.asList(summaryMetricsBuilders).stream()
              .map(AggregatedMetricResult.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder summaryMetrics(Optional<List<AggregatedMetricResult>> summaryMetrics);

    /** Clears the value of summaryMetrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSummaryMetrics() {
      return summaryMetrics(Optional.empty());
    }

    /**
     * Setter for winRates.
     *
     * <p>winRates: A dictionary of win rates for each metric, only populated for multi-response
     * evaluation runs.
     */
    @JsonProperty("winRates")
    public abstract Builder winRates(Map<String, WinRateStats> winRates);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder winRates(Optional<Map<String, WinRateStats>> winRates);

    /** Clears the value of winRates field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWinRates() {
      return winRates(Optional.empty());
    }

    /**
     * Setter for evaluationDataset.
     *
     * <p>evaluationDataset: The input evaluation dataset(s) for the evaluation run.
     */
    @JsonProperty("evaluationDataset")
    public abstract Builder evaluationDataset(List<EvaluationDataset> evaluationDataset);

    /**
     * Setter for evaluationDataset.
     *
     * <p>evaluationDataset: The input evaluation dataset(s) for the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder evaluationDataset(EvaluationDataset... evaluationDataset) {
      return evaluationDataset(Arrays.asList(evaluationDataset));
    }

    /**
     * Setter for evaluationDataset builder.
     *
     * <p>evaluationDataset: The input evaluation dataset(s) for the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder evaluationDataset(EvaluationDataset.Builder... evaluationDatasetBuilders) {
      return evaluationDataset(
          Arrays.asList(evaluationDatasetBuilders).stream()
              .map(EvaluationDataset.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationDataset(Optional<List<EvaluationDataset>> evaluationDataset);

    /** Clears the value of evaluationDataset field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationDataset() {
      return evaluationDataset(Optional.empty());
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Metadata for the evaluation run.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(EvaluationRunMetadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata: Metadata for the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder metadata(EvaluationRunMetadata.Builder metadataBuilder) {
      return metadata(metadataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<EvaluationRunMetadata> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for agentInfo.
     *
     * <p>agentInfo: This field is experimental and may change in future versions. The agent info of
     * the agent under evaluation. This can be extended for multi-agent evaluation.
     */
    @JsonProperty("agentInfo")
    public abstract Builder agentInfo(AgentInfo agentInfo);

    /**
     * Setter for agentInfo builder.
     *
     * <p>agentInfo: This field is experimental and may change in future versions. The agent info of
     * the agent under evaluation. This can be extended for multi-agent evaluation.
     */
    @CanIgnoreReturnValue
    public Builder agentInfo(AgentInfo.Builder agentInfoBuilder) {
      return agentInfo(agentInfoBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentInfo(Optional<AgentInfo> agentInfo);

    /** Clears the value of agentInfo field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentInfo() {
      return agentInfo(Optional.empty());
    }

    public abstract EvaluationResult build();
  }

  /** Deserializes a JSON string to a EvaluationResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationResult.class);
  }
}
