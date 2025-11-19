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

/** Result of tuning resource usage assessment. */
@AutoValue
@JsonDeserialize(builder = TuningResourceUsageAssessmentResult.Builder.class)
public abstract class TuningResourceUsageAssessmentResult extends JsonSerializable {
  /** The number of tokens in the dataset. */
  @JsonProperty("tokenCount")
  public abstract Optional<Integer> tokenCount();

  /** The number of billable characters in the dataset. */
  @JsonProperty("billableCharacterCount")
  public abstract Optional<Integer> billableCharacterCount();

  /** Instantiates a builder for TuningResourceUsageAssessmentResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_TuningResourceUsageAssessmentResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for TuningResourceUsageAssessmentResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `TuningResourceUsageAssessmentResult.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_TuningResourceUsageAssessmentResult.Builder();
    }

    /**
     * Setter for tokenCount.
     *
     * <p>tokenCount: The number of tokens in the dataset.
     */
    @JsonProperty("tokenCount")
    public abstract Builder tokenCount(Integer tokenCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tokenCount(Optional<Integer> tokenCount);

    /** Clears the value of tokenCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTokenCount() {
      return tokenCount(Optional.empty());
    }

    /**
     * Setter for billableCharacterCount.
     *
     * <p>billableCharacterCount: The number of billable characters in the dataset.
     */
    @JsonProperty("billableCharacterCount")
    public abstract Builder billableCharacterCount(Integer billableCharacterCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder billableCharacterCount(Optional<Integer> billableCharacterCount);

    /** Clears the value of billableCharacterCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBillableCharacterCount() {
      return billableCharacterCount(Optional.empty());
    }

    public abstract TuningResourceUsageAssessmentResult build();
  }

  /** Deserializes a JSON string to a TuningResourceUsageAssessmentResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static TuningResourceUsageAssessmentResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, TuningResourceUsageAssessmentResult.class);
  }
}
