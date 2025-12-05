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
import java.util.Map;
import java.util.Optional;

/** Aggregated metric results for a single response candidate of an EvalCase. */
@AutoValue
@JsonDeserialize(builder = ResponseCandidateResult.Builder.class)
public abstract class ResponseCandidateResult extends JsonSerializable {
  /** Index of the response candidate this result pertains to. */
  @JsonProperty("responseIndex")
  public abstract Optional<Integer> responseIndex();

  /** A dictionary of metric results for this response candidate, keyed by metric name. */
  @JsonProperty("metricResults")
  public abstract Optional<Map<String, EvalCaseMetricResult>> metricResults();

  /** Instantiates a builder for ResponseCandidateResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ResponseCandidateResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ResponseCandidateResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ResponseCandidateResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ResponseCandidateResult.Builder();
    }

    /**
     * Setter for responseIndex.
     *
     * <p>responseIndex: Index of the response candidate this result pertains to.
     */
    @JsonProperty("responseIndex")
    public abstract Builder responseIndex(Integer responseIndex);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder responseIndex(Optional<Integer> responseIndex);

    /** Clears the value of responseIndex field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponseIndex() {
      return responseIndex(Optional.empty());
    }

    /**
     * Setter for metricResults.
     *
     * <p>metricResults: A dictionary of metric results for this response candidate, keyed by metric
     * name.
     */
    @JsonProperty("metricResults")
    public abstract Builder metricResults(Map<String, EvalCaseMetricResult> metricResults);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricResults(Optional<Map<String, EvalCaseMetricResult>> metricResults);

    /** Clears the value of metricResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricResults() {
      return metricResults(Optional.empty());
    }

    public abstract ResponseCandidateResult build();
  }

  /** Deserializes a JSON string to a ResponseCandidateResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static ResponseCandidateResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ResponseCandidateResult.class);
  }
}
