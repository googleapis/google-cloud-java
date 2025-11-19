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

/** Pointwise metric instance. */
@AutoValue
@JsonDeserialize(builder = PointwiseMetricInstance.Builder.class)
public abstract class PointwiseMetricInstance extends JsonSerializable {
  /**
   * Instance specified as a json string. String key-value pairs are expected in the json_instance
   * to render PointwiseMetricSpec.instance_prompt_template.
   */
  @JsonProperty("jsonInstance")
  public abstract Optional<String> jsonInstance();

  /** Instantiates a builder for PointwiseMetricInstance. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PointwiseMetricInstance.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PointwiseMetricInstance. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PointwiseMetricInstance.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PointwiseMetricInstance.Builder();
    }

    /**
     * Setter for jsonInstance.
     *
     * <p>jsonInstance: Instance specified as a json string. String key-value pairs are expected in
     * the json_instance to render PointwiseMetricSpec.instance_prompt_template.
     */
    @JsonProperty("jsonInstance")
    public abstract Builder jsonInstance(String jsonInstance);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder jsonInstance(Optional<String> jsonInstance);

    /** Clears the value of jsonInstance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJsonInstance() {
      return jsonInstance(Optional.empty());
    }

    public abstract PointwiseMetricInstance build();
  }

  /** Deserializes a JSON string to a PointwiseMetricInstance object. */
  @ExcludeFromGeneratedCoverageReport
  public static PointwiseMetricInstance fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PointwiseMetricInstance.class);
  }
}
