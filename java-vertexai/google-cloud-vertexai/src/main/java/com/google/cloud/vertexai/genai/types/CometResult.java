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
 * Spec for Comet result - calculates the comet score for the given instance using the version
 * specified in the spec.
 */
@AutoValue
@JsonDeserialize(builder = CometResult.Builder.class)
public abstract class CometResult extends JsonSerializable {
  /** Output only. Comet score. Range depends on version. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** Instantiates a builder for CometResult. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CometResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CometResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CometResult.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CometResult.Builder();
    }

    /**
     * Setter for score.
     *
     * <p>score: Output only. Comet score. Range depends on version.
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

    public abstract CometResult build();
  }

  /** Deserializes a JSON string to a CometResult object. */
  @ExcludeFromGeneratedCoverageReport
  public static CometResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CometResult.class);
  }
}
