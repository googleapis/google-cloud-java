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

/** Result of batch prediction resource usage assessment. */
@AutoValue
@JsonDeserialize(builder = BatchPredictionResourceUsageAssessmentResult.Builder.class)
public abstract class BatchPredictionResourceUsageAssessmentResult extends JsonSerializable {
  /** Number of tokens in the dataset. */
  @JsonProperty("tokenCount")
  public abstract Optional<Integer> tokenCount();

  /** Number of audio tokens in the dataset. */
  @JsonProperty("audioTokenCount")
  public abstract Optional<Integer> audioTokenCount();

  /** Instantiates a builder for BatchPredictionResourceUsageAssessmentResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_BatchPredictionResourceUsageAssessmentResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for BatchPredictionResourceUsageAssessmentResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `BatchPredictionResourceUsageAssessmentResult.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_BatchPredictionResourceUsageAssessmentResult.Builder();
    }

    /**
     * Setter for tokenCount.
     *
     * <p>tokenCount: Number of tokens in the dataset.
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
     * Setter for audioTokenCount.
     *
     * <p>audioTokenCount: Number of audio tokens in the dataset.
     */
    @JsonProperty("audioTokenCount")
    public abstract Builder audioTokenCount(Integer audioTokenCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder audioTokenCount(Optional<Integer> audioTokenCount);

    /** Clears the value of audioTokenCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAudioTokenCount() {
      return audioTokenCount(Optional.empty());
    }

    public abstract BatchPredictionResourceUsageAssessmentResult build();
  }

  /** Deserializes a JSON string to a BatchPredictionResourceUsageAssessmentResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static BatchPredictionResourceUsageAssessmentResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, BatchPredictionResourceUsageAssessmentResult.class);
  }
}
