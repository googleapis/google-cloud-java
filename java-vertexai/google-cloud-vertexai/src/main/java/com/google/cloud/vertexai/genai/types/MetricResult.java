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
import com.google.genai.types.GoogleRpcStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Result for a single metric on a single instance. */
@AutoValue
@JsonDeserialize(builder = MetricResult.Builder.class)
public abstract class MetricResult extends JsonSerializable {
  /**
   * The score for the metric. Please refer to each metric's documentation for the meaning of the
   * score.
   */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** For rubric-based metrics, the verdicts for each rubric. */
  @JsonProperty("rubricVerdicts")
  public abstract Optional<List<RubricVerdict>> rubricVerdicts();

  /** The explanation for the metric result. */
  @JsonProperty("explanation")
  public abstract Optional<String> explanation();

  /** The error status for the metric result. */
  @JsonProperty("error")
  public abstract Optional<GoogleRpcStatus> error();

  /** Instantiates a builder for MetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MetricResult.Builder();
    }

    /**
     * Setter for score.
     *
     * <p>score: The score for the metric. Please refer to each metric's documentation for the
     * meaning of the score.
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
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: For rubric-based metrics, the verdicts for each rubric.
     */
    @JsonProperty("rubricVerdicts")
    public abstract Builder rubricVerdicts(List<RubricVerdict> rubricVerdicts);

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: For rubric-based metrics, the verdicts for each rubric.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict... rubricVerdicts) {
      return rubricVerdicts(Arrays.asList(rubricVerdicts));
    }

    /**
     * Setter for rubricVerdicts builder.
     *
     * <p>rubricVerdicts: For rubric-based metrics, the verdicts for each rubric.
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
     * Setter for explanation.
     *
     * <p>explanation: The explanation for the metric result.
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
     * Setter for error.
     *
     * <p>error: The error status for the metric result.
     */
    @JsonProperty("error")
    public abstract Builder error(GoogleRpcStatus error);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder error(Optional<GoogleRpcStatus> error);

    /** Clears the value of error field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearError() {
      return error(Optional.empty());
    }

    public abstract MetricResult build();
  }

  /** Deserializes a JSON string to a MetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static MetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MetricResult.class);
  }
}
