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

/** Eval result for a single evaluation case. */
@AutoValue
@JsonDeserialize(builder = EvalCaseResult.Builder.class)
public abstract class EvalCaseResult extends JsonSerializable {
  /** Index of the evaluation case. */
  @JsonProperty("evalCaseIndex")
  public abstract Optional<Integer> evalCaseIndex();

  /** A list of results, one for each response candidate of the EvalCase. */
  @JsonProperty("responseCandidateResults")
  public abstract Optional<List<ResponseCandidateResult>> responseCandidateResults();

  /** Instantiates a builder for EvalCaseResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvalCaseResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvalCaseResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvalCaseResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvalCaseResult.Builder();
    }

    /**
     * Setter for evalCaseIndex.
     *
     * <p>evalCaseIndex: Index of the evaluation case.
     */
    @JsonProperty("evalCaseIndex")
    public abstract Builder evalCaseIndex(Integer evalCaseIndex);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evalCaseIndex(Optional<Integer> evalCaseIndex);

    /** Clears the value of evalCaseIndex field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvalCaseIndex() {
      return evalCaseIndex(Optional.empty());
    }

    /**
     * Setter for responseCandidateResults.
     *
     * <p>responseCandidateResults: A list of results, one for each response candidate of the
     * EvalCase.
     */
    @JsonProperty("responseCandidateResults")
    public abstract Builder responseCandidateResults(
        List<ResponseCandidateResult> responseCandidateResults);

    /**
     * Setter for responseCandidateResults.
     *
     * <p>responseCandidateResults: A list of results, one for each response candidate of the
     * EvalCase.
     */
    @CanIgnoreReturnValue
    public Builder responseCandidateResults(ResponseCandidateResult... responseCandidateResults) {
      return responseCandidateResults(Arrays.asList(responseCandidateResults));
    }

    /**
     * Setter for responseCandidateResults builder.
     *
     * <p>responseCandidateResults: A list of results, one for each response candidate of the
     * EvalCase.
     */
    @CanIgnoreReturnValue
    public Builder responseCandidateResults(
        ResponseCandidateResult.Builder... responseCandidateResultsBuilders) {
      return responseCandidateResults(
          Arrays.asList(responseCandidateResultsBuilders).stream()
              .map(ResponseCandidateResult.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder responseCandidateResults(
        Optional<List<ResponseCandidateResult>> responseCandidateResults);

    /** Clears the value of responseCandidateResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponseCandidateResults() {
      return responseCandidateResults(Optional.empty());
    }

    public abstract EvalCaseResult build();
  }

  /** Deserializes a JSON string to a EvalCaseResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvalCaseResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvalCaseResult.class);
  }
}
