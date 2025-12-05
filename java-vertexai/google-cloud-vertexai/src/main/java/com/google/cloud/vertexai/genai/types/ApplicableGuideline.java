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

/** Applicable guideline for the optimize_prompt method. */
@AutoValue
@JsonDeserialize(builder = ApplicableGuideline.Builder.class)
public abstract class ApplicableGuideline extends JsonSerializable {
  /** */
  @JsonProperty("applicableGuideline")
  public abstract Optional<String> applicableGuideline();

  /** */
  @JsonProperty("suggestedImprovement")
  public abstract Optional<String> suggestedImprovement();

  /** */
  @JsonProperty("textBeforeChange")
  public abstract Optional<String> textBeforeChange();

  /** */
  @JsonProperty("textAfterChange")
  public abstract Optional<String> textAfterChange();

  /** Instantiates a builder for ApplicableGuideline. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ApplicableGuideline.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ApplicableGuideline. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ApplicableGuideline.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ApplicableGuideline.Builder();
    }

    /**
     * Setter for applicableGuideline.
     *
     * <p>applicableGuideline:
     */
    @JsonProperty("applicableGuideline")
    public abstract Builder applicableGuideline(String applicableGuideline);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder applicableGuideline(Optional<String> applicableGuideline);

    /** Clears the value of applicableGuideline field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApplicableGuideline() {
      return applicableGuideline(Optional.empty());
    }

    /**
     * Setter for suggestedImprovement.
     *
     * <p>suggestedImprovement:
     */
    @JsonProperty("suggestedImprovement")
    public abstract Builder suggestedImprovement(String suggestedImprovement);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder suggestedImprovement(Optional<String> suggestedImprovement);

    /** Clears the value of suggestedImprovement field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSuggestedImprovement() {
      return suggestedImprovement(Optional.empty());
    }

    /**
     * Setter for textBeforeChange.
     *
     * <p>textBeforeChange:
     */
    @JsonProperty("textBeforeChange")
    public abstract Builder textBeforeChange(String textBeforeChange);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder textBeforeChange(Optional<String> textBeforeChange);

    /** Clears the value of textBeforeChange field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTextBeforeChange() {
      return textBeforeChange(Optional.empty());
    }

    /**
     * Setter for textAfterChange.
     *
     * <p>textAfterChange:
     */
    @JsonProperty("textAfterChange")
    public abstract Builder textAfterChange(String textAfterChange);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder textAfterChange(Optional<String> textAfterChange);

    /** Clears the value of textAfterChange field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTextAfterChange() {
      return textAfterChange(Optional.empty());
    }

    public abstract ApplicableGuideline build();
  }

  /** Deserializes a JSON string to a ApplicableGuideline object. */
  @ExcludeFromGeneratedCoverageReport
  public static ApplicableGuideline fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ApplicableGuideline.class);
  }
}
