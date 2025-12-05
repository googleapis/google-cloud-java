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

/** Represents the result of an evaluation item. */
@AutoValue
@JsonDeserialize(builder = EvaluationItemResult.Builder.class)
public abstract class EvaluationItemResult extends JsonSerializable {
  /** The request item that was evaluated. */
  @JsonProperty("evaluationRequest")
  public abstract Optional<String> evaluationRequest();

  /** The evaluation run that was used to generate the result. */
  @JsonProperty("evaluationRun")
  public abstract Optional<String> evaluationRun();

  /** The request that was evaluated. */
  @JsonProperty("request")
  public abstract Optional<EvaluationItemRequest> request();

  /** The metric that was evaluated. */
  @JsonProperty("metric")
  public abstract Optional<String> metric();

  /** TThe results for the metric. */
  @JsonProperty("candidateResults")
  public abstract Optional<List<CandidateResult>> candidateResults();

  /** Metadata about the evaluation result. */
  @JsonProperty("metadata")
  public abstract Optional<Map<String, Object>> metadata();

  /** Instantiates a builder for EvaluationItemResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationItemResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationItemResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationItemResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationItemResult.Builder();
    }

    /**
     * Setter for evaluationRequest.
     *
     * <p>evaluationRequest: The request item that was evaluated.
     */
    @JsonProperty("evaluationRequest")
    public abstract Builder evaluationRequest(String evaluationRequest);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationRequest(Optional<String> evaluationRequest);

    /** Clears the value of evaluationRequest field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationRequest() {
      return evaluationRequest(Optional.empty());
    }

    /**
     * Setter for evaluationRun.
     *
     * <p>evaluationRun: The evaluation run that was used to generate the result.
     */
    @JsonProperty("evaluationRun")
    public abstract Builder evaluationRun(String evaluationRun);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationRun(Optional<String> evaluationRun);

    /** Clears the value of evaluationRun field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationRun() {
      return evaluationRun(Optional.empty());
    }

    /**
     * Setter for request.
     *
     * <p>request: The request that was evaluated.
     */
    @JsonProperty("request")
    public abstract Builder request(EvaluationItemRequest request);

    /**
     * Setter for request builder.
     *
     * <p>request: The request that was evaluated.
     */
    @CanIgnoreReturnValue
    public Builder request(EvaluationItemRequest.Builder requestBuilder) {
      return request(requestBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder request(Optional<EvaluationItemRequest> request);

    /** Clears the value of request field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRequest() {
      return request(Optional.empty());
    }

    /**
     * Setter for metric.
     *
     * <p>metric: The metric that was evaluated.
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
     * Setter for candidateResults.
     *
     * <p>candidateResults: TThe results for the metric.
     */
    @JsonProperty("candidateResults")
    public abstract Builder candidateResults(List<CandidateResult> candidateResults);

    /**
     * Setter for candidateResults.
     *
     * <p>candidateResults: TThe results for the metric.
     */
    @CanIgnoreReturnValue
    public Builder candidateResults(CandidateResult... candidateResults) {
      return candidateResults(Arrays.asList(candidateResults));
    }

    /**
     * Setter for candidateResults builder.
     *
     * <p>candidateResults: TThe results for the metric.
     */
    @CanIgnoreReturnValue
    public Builder candidateResults(CandidateResult.Builder... candidateResultsBuilders) {
      return candidateResults(
          Arrays.asList(candidateResultsBuilders).stream()
              .map(CandidateResult.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateResults(Optional<List<CandidateResult>> candidateResults);

    /** Clears the value of candidateResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateResults() {
      return candidateResults(Optional.empty());
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Metadata about the evaluation result.
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

    public abstract EvaluationItemResult build();
  }

  /** Deserializes a JSON string to a EvaluationItemResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationItemResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationItemResult.class);
  }
}
