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

/** Specification for a computation based metric. */
@AutoValue
@JsonDeserialize(builder = ComputationBasedMetricSpec.Builder.class)
public abstract class ComputationBasedMetricSpec extends JsonSerializable {
  /** The type of the computation based metric. */
  @JsonProperty("type")
  public abstract Optional<ComputationBasedMetricType> type();

  /** Instantiates a builder for ComputationBasedMetricSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ComputationBasedMetricSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ComputationBasedMetricSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ComputationBasedMetricSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ComputationBasedMetricSpec.Builder();
    }

    /**
     * Setter for type.
     *
     * <p>type: The type of the computation based metric.
     */
    @JsonProperty("type")
    public abstract Builder type(ComputationBasedMetricType type);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder type(Optional<ComputationBasedMetricType> type);

    /** Clears the value of type field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearType() {
      return type(Optional.empty());
    }

    /**
     * Setter for type given a known enum.
     *
     * <p>type: The type of the computation based metric.
     */
    @CanIgnoreReturnValue
    public Builder type(ComputationBasedMetricType.Known knownType) {
      return type(new ComputationBasedMetricType(knownType));
    }

    /**
     * Setter for type given a string.
     *
     * <p>type: The type of the computation based metric.
     */
    @CanIgnoreReturnValue
    public Builder type(String type) {
      return type(new ComputationBasedMetricType(type));
    }

    public abstract ComputationBasedMetricSpec build();
  }

  /** Deserializes a JSON string to a ComputationBasedMetricSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ComputationBasedMetricSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ComputationBasedMetricSpec.class);
  }
}
