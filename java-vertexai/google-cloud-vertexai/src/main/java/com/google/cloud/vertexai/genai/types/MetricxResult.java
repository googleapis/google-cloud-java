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

/**
 * Spec for MetricX result - calculates the MetricX score for the given instance using the version
 * specified in the spec.
 */
@AutoValue
@JsonDeserialize(builder = MetricxResult.Builder.class)
public abstract class MetricxResult extends JsonSerializable {
  /** Output only. MetricX score. Range depends on version. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** Instantiates a builder for MetricxResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MetricxResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MetricxResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MetricxResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MetricxResult.Builder();
    }

    /**
     * Setter for score.
     *
     * <p>score: Output only. MetricX score. Range depends on version.
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

    public abstract MetricxResult build();
  }

  /** Deserializes a JSON string to a MetricxResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static MetricxResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MetricxResult.class);
  }
}
