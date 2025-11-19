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
@JsonDeserialize(builder = ParsedResponse.Builder.class)
public abstract class ParsedResponse extends JsonSerializable {
  /** */
  @JsonProperty("optimizationType")
  public abstract Optional<String> optimizationType();

  /** */
  @JsonProperty("applicableGuidelines")
  public abstract Optional<List<ApplicableGuideline>> applicableGuidelines();

  /** */
  @JsonProperty("originalPrompt")
  public abstract Optional<String> originalPrompt();

  /** */
  @JsonProperty("suggestedPrompt")
  public abstract Optional<String> suggestedPrompt();

  /** Instantiates a builder for ParsedResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ParsedResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ParsedResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ParsedResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ParsedResponse.Builder();
    }

    /**
     * Setter for optimizationType.
     *
     * <p>optimizationType:
     */
    @JsonProperty("optimizationType")
    public abstract Builder optimizationType(String optimizationType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder optimizationType(Optional<String> optimizationType);

    /** Clears the value of optimizationType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOptimizationType() {
      return optimizationType(Optional.empty());
    }

    /**
     * Setter for applicableGuidelines.
     *
     * <p>applicableGuidelines:
     */
    @JsonProperty("applicableGuidelines")
    public abstract Builder applicableGuidelines(List<ApplicableGuideline> applicableGuidelines);

    /**
     * Setter for applicableGuidelines.
     *
     * <p>applicableGuidelines:
     */
    @CanIgnoreReturnValue
    public Builder applicableGuidelines(ApplicableGuideline... applicableGuidelines) {
      return applicableGuidelines(Arrays.asList(applicableGuidelines));
    }

    /**
     * Setter for applicableGuidelines builder.
     *
     * <p>applicableGuidelines:
     */
    @CanIgnoreReturnValue
    public Builder applicableGuidelines(
        ApplicableGuideline.Builder... applicableGuidelinesBuilders) {
      return applicableGuidelines(
          Arrays.asList(applicableGuidelinesBuilders).stream()
              .map(ApplicableGuideline.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder applicableGuidelines(Optional<List<ApplicableGuideline>> applicableGuidelines);

    /** Clears the value of applicableGuidelines field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApplicableGuidelines() {
      return applicableGuidelines(Optional.empty());
    }

    /**
     * Setter for originalPrompt.
     *
     * <p>originalPrompt:
     */
    @JsonProperty("originalPrompt")
    public abstract Builder originalPrompt(String originalPrompt);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder originalPrompt(Optional<String> originalPrompt);

    /** Clears the value of originalPrompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOriginalPrompt() {
      return originalPrompt(Optional.empty());
    }

    /**
     * Setter for suggestedPrompt.
     *
     * <p>suggestedPrompt:
     */
    @JsonProperty("suggestedPrompt")
    public abstract Builder suggestedPrompt(String suggestedPrompt);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder suggestedPrompt(Optional<String> suggestedPrompt);

    /** Clears the value of suggestedPrompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSuggestedPrompt() {
      return suggestedPrompt(Optional.empty());
    }

    public abstract ParsedResponse build();
  }

  /** Deserializes a JSON string to a ParsedResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ParsedResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ParsedResponse.class);
  }
}
