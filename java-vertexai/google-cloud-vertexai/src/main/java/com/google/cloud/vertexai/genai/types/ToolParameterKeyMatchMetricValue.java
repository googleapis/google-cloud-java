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

/** Tool parameter key match metric value for an instance. */
@AutoValue
@JsonDeserialize(builder = ToolParameterKeyMatchMetricValue.Builder.class)
public abstract class ToolParameterKeyMatchMetricValue extends JsonSerializable {
  /** Output only. Tool parameter key match score. */
  @JsonProperty("score")
  public abstract Optional<Float> score();

  /** Instantiates a builder for ToolParameterKeyMatchMetricValue. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolParameterKeyMatchMetricValue.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolParameterKeyMatchMetricValue. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ToolParameterKeyMatchMetricValue.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolParameterKeyMatchMetricValue.Builder();
    }

    /**
     * Setter for score.
     *
     * <p>score: Output only. Tool parameter key match score.
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

    public abstract ToolParameterKeyMatchMetricValue build();
  }

  /** Deserializes a JSON string to a ToolParameterKeyMatchMetricValue object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolParameterKeyMatchMetricValue fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolParameterKeyMatchMetricValue.class);
  }
}
