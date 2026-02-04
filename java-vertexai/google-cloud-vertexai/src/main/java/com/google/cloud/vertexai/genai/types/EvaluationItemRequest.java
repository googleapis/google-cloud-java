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

/** Single evaluation request. */
@AutoValue
@JsonDeserialize(builder = EvaluationItemRequest.Builder.class)
public abstract class EvaluationItemRequest extends JsonSerializable {
  /** The request/prompt to evaluate. */
  @JsonProperty("prompt")
  public abstract Optional<EvaluationPrompt> prompt();

  /** The ideal response or ground truth. */
  @JsonProperty("goldenResponse")
  public abstract Optional<CandidateResponse> goldenResponse();

  /**
   * Named groups of rubrics associated with this prompt. The key is a user-defined name for the
   * rubric group.
   */
  @JsonProperty("rubrics")
  public abstract Optional<Map<String, RubricGroup>> rubrics();

  /** Responses from model under test and other baseline models for comparison. */
  @JsonProperty("candidateResponses")
  public abstract Optional<List<CandidateResponse>> candidateResponses();

  /** Instantiates a builder for EvaluationItemRequest. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationItemRequest.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationItemRequest. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationItemRequest.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationItemRequest.Builder();
    }

    /**
     * Setter for prompt.
     *
     * <p>prompt: The request/prompt to evaluate.
     */
    @JsonProperty("prompt")
    public abstract Builder prompt(EvaluationPrompt prompt);

    /**
     * Setter for prompt builder.
     *
     * <p>prompt: The request/prompt to evaluate.
     */
    @CanIgnoreReturnValue
    public Builder prompt(EvaluationPrompt.Builder promptBuilder) {
      return prompt(promptBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder prompt(Optional<EvaluationPrompt> prompt);

    /** Clears the value of prompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPrompt() {
      return prompt(Optional.empty());
    }

    /**
     * Setter for goldenResponse.
     *
     * <p>goldenResponse: The ideal response or ground truth.
     */
    @JsonProperty("goldenResponse")
    public abstract Builder goldenResponse(CandidateResponse goldenResponse);

    /**
     * Setter for goldenResponse builder.
     *
     * <p>goldenResponse: The ideal response or ground truth.
     */
    @CanIgnoreReturnValue
    public Builder goldenResponse(CandidateResponse.Builder goldenResponseBuilder) {
      return goldenResponse(goldenResponseBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder goldenResponse(Optional<CandidateResponse> goldenResponse);

    /** Clears the value of goldenResponse field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGoldenResponse() {
      return goldenResponse(Optional.empty());
    }

    /**
     * Setter for rubrics.
     *
     * <p>rubrics: Named groups of rubrics associated with this prompt. The key is a user-defined
     * name for the rubric group.
     */
    @JsonProperty("rubrics")
    public abstract Builder rubrics(Map<String, RubricGroup> rubrics);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubrics(Optional<Map<String, RubricGroup>> rubrics);

    /** Clears the value of rubrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubrics() {
      return rubrics(Optional.empty());
    }

    /**
     * Setter for candidateResponses.
     *
     * <p>candidateResponses: Responses from model under test and other baseline models for
     * comparison.
     */
    @JsonProperty("candidateResponses")
    public abstract Builder candidateResponses(List<CandidateResponse> candidateResponses);

    /**
     * Setter for candidateResponses.
     *
     * <p>candidateResponses: Responses from model under test and other baseline models for
     * comparison.
     */
    @CanIgnoreReturnValue
    public Builder candidateResponses(CandidateResponse... candidateResponses) {
      return candidateResponses(Arrays.asList(candidateResponses));
    }

    /**
     * Setter for candidateResponses builder.
     *
     * <p>candidateResponses: Responses from model under test and other baseline models for
     * comparison.
     */
    @CanIgnoreReturnValue
    public Builder candidateResponses(CandidateResponse.Builder... candidateResponsesBuilders) {
      return candidateResponses(
          Arrays.asList(candidateResponsesBuilders).stream()
              .map(CandidateResponse.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateResponses(Optional<List<CandidateResponse>> candidateResponses);

    /** Clears the value of candidateResponses field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateResponses() {
      return candidateResponses(Optional.empty());
    }

    public abstract EvaluationItemRequest build();
  }

  /** Deserializes a JSON string to a EvaluationItemRequest object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationItemRequest fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationItemRequest.class);
  }
}
