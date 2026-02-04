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

/** Pointwise metric input. */
@AutoValue
@JsonDeserialize(builder = PointwiseMetricInput.Builder.class)
public abstract class PointwiseMetricInput extends JsonSerializable {
  /** Required. Pointwise metric instance. */
  @JsonProperty("instance")
  public abstract Optional<PointwiseMetricInstance> instance();

  /** Instantiates a builder for PointwiseMetricInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PointwiseMetricInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PointwiseMetricInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PointwiseMetricInput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PointwiseMetricInput.Builder();
    }

    /**
     * Setter for instance.
     *
     * <p>instance: Required. Pointwise metric instance.
     */
    @JsonProperty("instance")
    public abstract Builder instance(PointwiseMetricInstance instance);

    /**
     * Setter for instance builder.
     *
     * <p>instance: Required. Pointwise metric instance.
     */
    @CanIgnoreReturnValue
    public Builder instance(PointwiseMetricInstance.Builder instanceBuilder) {
      return instance(instanceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instance(Optional<PointwiseMetricInstance> instance);

    /** Clears the value of instance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstance() {
      return instance(Optional.empty());
    }

    public abstract PointwiseMetricInput build();
  }

  /** Deserializes a JSON string to a PointwiseMetricInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static PointwiseMetricInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PointwiseMetricInput.class);
  }
}
