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

/** Result for a rubric-based metric. */
@AutoValue
@JsonDeserialize(builder = RubricBasedMetricResult.Builder.class)
public abstract class RubricBasedMetricResult extends JsonSerializable {
  /** Passing rate of all the rubrics. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** The details of all the rubrics and their verdicts. */
  @JsonProperty("rubricVerdicts")
  public abstract Optional<List<RubricVerdict>> rubricVerdicts();

  /** Instantiates a builder for RubricBasedMetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricBasedMetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricBasedMetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricBasedMetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricBasedMetricResult.Builder();
    }

    /**
     * Setter for score.
     *
     * <p>score: Passing rate of all the rubrics.
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
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts.
     */
    @JsonProperty("rubricVerdicts")
    public abstract Builder rubricVerdicts(List<RubricVerdict> rubricVerdicts);

    /**
     * Setter for rubricVerdicts.
     *
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts.
     */
    @CanIgnoreReturnValue
    public Builder rubricVerdicts(RubricVerdict... rubricVerdicts) {
      return rubricVerdicts(Arrays.asList(rubricVerdicts));
    }

    /**
     * Setter for rubricVerdicts builder.
     *
     * <p>rubricVerdicts: The details of all the rubrics and their verdicts.
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

    public abstract RubricBasedMetricResult build();
  }

  /** Deserializes a JSON string to a RubricBasedMetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricBasedMetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricBasedMetricResult.class);
  }
}
