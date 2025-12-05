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

/** Result for a single candidate. */
@AutoValue
@JsonDeserialize(builder = CandidateResult.Builder.class)
public abstract class CandidateResult extends JsonSerializable {
  /**
   * The candidate that is being evaluated. The value is the same as the candidate name in the
   * EvaluationRequest.
   */
  @JsonProperty("candidate")
  public abstract Optional<String> candidate();

  /** The metric that was evaluated. */
  @JsonProperty("metric")
  public abstract Optional<String> metric();

  /** The score of the metric. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** The explanation for the metric. */
  @JsonProperty("explanation")
  public abstract Optional<String> explanation();

  /** The rubric verdicts for the metric. */
  @JsonProperty("rubricVerdicts")
  public abstract Optional<List<RubricVerdict>> rubricVerdicts();

  /** Additional results for the metric. */
  @JsonProperty("additionalResults")
  public abstract Optional<Map<String, Object>> additionalResults();

  /** Instantiates a builder for CandidateResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CandidateResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CandidateResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CandidateResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CandidateResult.Builder();
    }

    /**
     * Setter for candidate.
     *
     * <p>candidate: The candidate that is being evaluated. The value is the same as the candidate
     * name in the EvaluationRequest.
     */
    @JsonProperty("candidate")
    public abstract Builder candidate(String candidate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidate(Optional<String> candidate);

    /** Clears the value of candidate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidate() {
      return candidate(Optional.empty());
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
     * Setter for score.
     *
     * <p>score: The score of the metric.
     */
    @JsonProperty("score")
    public abstract Builder score(Float score);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder score(Optional<Float> score);

    /** Clears the value of score field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScore() {
      return score(Optional.empty());
    }

    /**
     * Setter for explanation.
     *
     * <p>explanation: The explanation for the metric.
     */
    @JsonProperty("explanation")
    public abstract Builder explanation(String explanation);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder explanation(Optional<String> explanation);

    /** Clears the value of explanation field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExplanation() {
      return explanation(Optional.empty());
    }

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: The rubric verdicts for the metric.
     */
    @JsonProperty("rubricVerdicts")
    public abstract Builder rubricVerdicts(List<RubricVerdict> rubricVerdicts);

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: The rubric verdicts for the metric.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict... rubricVerdicts) {
      return rubricVerdicts(Arrays.asList(rubricVerdicts));
    }

    /**
     * Setter for rubricVerdicts builder.
     *
     * <p>rubricVerdicts: The rubric verdicts for the metric.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict.Builder... rubricVerdictsBuilders) {
      return rubricVerdicts(
          Arrays.asList(rubricVerdictsBuilders).stream()
              .map(RubricVerdict.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricVerdicts(Optional<List<RubricVerdict>> rubricVerdicts);

    /** Clears the value of rubricVerdicts field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricVerdicts() {
      return rubricVerdicts(Optional.empty());
    }

    /**
     * Setter for additionalResults.
     *
     * <p>additionalResults: Additional results for the metric.
     */
    @JsonProperty("additionalResults")
    public abstract Builder additionalResults(Map<String, Object> additionalResults);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder additionalResults(Optional<Map<String, Object>> additionalResults);

    /** Clears the value of additionalResults field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAdditionalResults() {
      return additionalResults(Optional.empty());
    }

    public abstract CandidateResult build();
  }

  /** Deserializes a JSON string to a CandidateResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static CandidateResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CandidateResult.class);
  }
}
