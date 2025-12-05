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

/** Spec for pairwise metric result. */
@AutoValue
@JsonDeserialize(builder = PairwiseMetricResult.Builder.class)
public abstract class PairwiseMetricResult extends JsonSerializable {
  /** Output only. Spec for custom output. */
  @JsonProperty("customOutput")
  public abstract Optional<CustomOutput> customOutput();

  /** Output only. Explanation for pairwise metric score. */
  @JsonProperty("explanation")
  public abstract Optional<String> explanation();

  /** Output only. Pairwise metric choice. */
  @JsonProperty("pairwiseChoice")
  public abstract Optional<PairwiseChoice> pairwiseChoice();

  /** Instantiates a builder for PairwiseMetricResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PairwiseMetricResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PairwiseMetricResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PairwiseMetricResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PairwiseMetricResult.Builder();
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
     * <p>explanation: Output only. Explanation for pairwise metric score.
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
     * Setter for pairwiseChoice.
     *
     * <p>pairwiseChoice: Output only. Pairwise metric choice.
     */
    @JsonProperty("pairwiseChoice")
    public abstract Builder pairwiseChoice(PairwiseChoice pairwiseChoice);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pairwiseChoice(Optional<PairwiseChoice> pairwiseChoice);

    /** Clears the value of pairwiseChoice field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPairwiseChoice() {
      return pairwiseChoice(Optional.empty());
    }

    /**
     * Setter for pairwiseChoice given a known enum.
     *
     * <p>pairwiseChoice: Output only. Pairwise metric choice.
     */
    @CanIgnoreReturnValue
    public Builder pairwiseChoice(PairwiseChoice.Known knownType) {
      return pairwiseChoice(new PairwiseChoice(knownType));
    }

    /**
     * Setter for pairwiseChoice given a string.
     *
     * <p>pairwiseChoice: Output only. Pairwise metric choice.
     */
    @CanIgnoreReturnValue
    public Builder pairwiseChoice(String pairwiseChoice) {
      return pairwiseChoice(new PairwiseChoice(pairwiseChoice));
    }

    public abstract PairwiseMetricResult build();
  }

  /** Deserializes a JSON string to a PairwiseMetricResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static PairwiseMetricResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PairwiseMetricResult.class);
  }
}
