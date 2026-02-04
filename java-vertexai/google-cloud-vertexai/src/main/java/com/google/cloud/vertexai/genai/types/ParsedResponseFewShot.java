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

/** Response for the optimize_prompt method. */
@AutoValue
@JsonDeserialize(builder = ParsedResponseFewShot.Builder.class)
public abstract class ParsedResponseFewShot extends JsonSerializable {
  /** */
  @JsonProperty("suggestedModifications")
  public abstract Optional<List<ApplicableGuideline>> suggestedModifications();

  /** */
  @JsonProperty("originalSystemInstructions")
  public abstract Optional<String> originalSystemInstructions();

  /** */
  @JsonProperty("newSystemInstructions")
  public abstract Optional<String> newSystemInstructions();

  /** Instantiates a builder for ParsedResponseFewShot. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ParsedResponseFewShot.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ParsedResponseFewShot. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ParsedResponseFewShot.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ParsedResponseFewShot.Builder();
    }

    /**
     * Setter for suggestedModifications.
     *
     * <p>suggestedModifications:
     */
    @JsonProperty("suggestedModifications")
    public abstract Builder suggestedModifications(
        List<ApplicableGuideline> suggestedModifications);

    /**
     * Setter for suggestedModifications.
     *
     * <p>suggestedModifications:
     */
    @CanIgnoreReturnValue
    public Builder suggestedModifications(ApplicableGuideline... suggestedModifications) {
      return suggestedModifications(Arrays.asList(suggestedModifications));
    }

    /**
     * Setter for suggestedModifications builder.
     *
     * <p>suggestedModifications:
     */
    @CanIgnoreReturnValue
    public Builder suggestedModifications(
        ApplicableGuideline.Builder... suggestedModificationsBuilders) {
      return suggestedModifications(
          Arrays.asList(suggestedModificationsBuilders).stream()
              .map(ApplicableGuideline.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder suggestedModifications(
        Optional<List<ApplicableGuideline>> suggestedModifications);

    /** Clears the value of suggestedModifications field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSuggestedModifications() {
      return suggestedModifications(Optional.empty());
    }

    /**
     * Setter for originalSystemInstructions.
     *
     * <p>originalSystemInstructions:
     */
    @JsonProperty("originalSystemInstructions")
    public abstract Builder originalSystemInstructions(String originalSystemInstructions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder originalSystemInstructions(Optional<String> originalSystemInstructions);

    /** Clears the value of originalSystemInstructions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOriginalSystemInstructions() {
      return originalSystemInstructions(Optional.empty());
    }

    /**
     * Setter for newSystemInstructions.
     *
     * <p>newSystemInstructions:
     */
    @JsonProperty("newSystemInstructions")
    public abstract Builder newSystemInstructions(String newSystemInstructions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder newSystemInstructions(Optional<String> newSystemInstructions);

    /** Clears the value of newSystemInstructions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNewSystemInstructions() {
      return newSystemInstructions(Optional.empty());
    }

    public abstract ParsedResponseFewShot build();
  }

  /** Deserializes a JSON string to a ParsedResponseFewShot object. */
  @ExcludeFromGeneratedCoverageReport
  public static ParsedResponseFewShot fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ParsedResponseFewShot.class);
  }
}
