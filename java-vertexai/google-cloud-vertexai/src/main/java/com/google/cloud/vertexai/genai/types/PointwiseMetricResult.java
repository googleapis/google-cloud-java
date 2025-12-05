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
import java.util.Optional;

/** Spec for pointwise metric result. */
@AutoValue
@JsonDeserialize(builder = PointwiseMetricResult.Builder.class)
public abstract class PointwiseMetricResult extends JsonSerializable {
  /** Output only. Spec for custom output. */
  @JsonProperty("customOutput")
  public abstract Optional<CustomOutput> customOutput();

  /** Output only. Explanation for pointwise metric score. */
  @JsonProperty("explanation")
  public abstract Optional<String> explanation();

  /** Output only. Pointwise metric score. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** Instantiates a builder for PointwiseMetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PointwiseMetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PointwiseMetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PointwiseMetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PointwiseMetricResult.Builder();
    }

    /**
     * Setter for customOutput.
     *
     * <p>customOutput: Output only. Spec for custom output.
     */
    @JsonProperty("customOutput")
    public abstract Builder customOutput(CustomOutput customOutput);

    /**
     * Setter for customOutput builder.
     *
     * <p>customOutput: Output only. Spec for custom output.
     */
    @CanIgnoreReturnValue
    public Builder customOutput(CustomOutput.Builder customOutputBuilder) {
      return customOutput(customOutputBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customOutput(Optional<CustomOutput> customOutput);

    /** Clears the value of customOutput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomOutput() {
      return customOutput(Optional.empty());
    }

    /**
     * Setter for explanation.
     *
     * <p>explanation: Output only. Explanation for pointwise metric score.
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
     * Setter for score.
     *
     * <p>score: Output only. Pointwise metric score.
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

    public abstract PointwiseMetricResult build();
  }

  /** Deserializes a JSON string to a PointwiseMetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static PointwiseMetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PointwiseMetricResult.class);
  }
}
