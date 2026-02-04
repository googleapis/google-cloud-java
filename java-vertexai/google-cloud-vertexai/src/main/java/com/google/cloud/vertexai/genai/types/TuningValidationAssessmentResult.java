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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** The result of a tuning validation assessment. */
@AutoValue
@JsonDeserialize(builder = TuningValidationAssessmentResult.Builder.class)
public abstract class TuningValidationAssessmentResult extends JsonSerializable {
  /** The list of errors found in the dataset. */
  @JsonProperty("errors")
  public abstract Optional<List<String>> errors();

  /** Instantiates a builder for TuningValidationAssessmentResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_TuningValidationAssessmentResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for TuningValidationAssessmentResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `TuningValidationAssessmentResult.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_TuningValidationAssessmentResult.Builder();
    }

    /**
     * Setter for errors.
     *
     * <p>errors: The list of errors found in the dataset.
     */
    @JsonProperty("errors")
    public abstract Builder errors(List<String> errors);

    /**
     * Setter for errors.
     *
     * <p>errors: The list of errors found in the dataset.
     */
    @CanIgnoreReturnValue
    public Builder errors(String... errors) {
      return errors(Arrays.asList(errors));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder errors(Optional<List<String>> errors);

    /** Clears the value of errors field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearErrors() {
      return errors(Optional.empty());
    }

    public abstract TuningValidationAssessmentResult build();
  }

  /** Deserializes a JSON string to a TuningValidationAssessmentResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static TuningValidationAssessmentResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, TuningValidationAssessmentResult.class);
  }
}
