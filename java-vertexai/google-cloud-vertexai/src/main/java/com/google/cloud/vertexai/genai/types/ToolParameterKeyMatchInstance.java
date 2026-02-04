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

/** Tool parameter key match instance. */
@AutoValue
@JsonDeserialize(builder = ToolParameterKeyMatchInstance.Builder.class)
public abstract class ToolParameterKeyMatchInstance extends JsonSerializable {
  /** Required. Output of the evaluated model. */
  @JsonProperty("prediction")
  public abstract Optional<String> prediction();

  /** Required. Ground truth used to compare against the prediction. */
  @JsonProperty("reference")
  public abstract Optional<String> reference();

  /** Instantiates a builder for ToolParameterKeyMatchInstance. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolParameterKeyMatchInstance.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolParameterKeyMatchInstance. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ToolParameterKeyMatchInstance.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolParameterKeyMatchInstance.Builder();
    }

    /**
     * Setter for prediction.
     *
     * <p>prediction: Required. Output of the evaluated model.
     */
    @JsonProperty("prediction")
    public abstract Builder prediction(String prediction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder prediction(Optional<String> prediction);

    /** Clears the value of prediction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPrediction() {
      return prediction(Optional.empty());
    }

    /**
     * Setter for reference.
     *
     * <p>reference: Required. Ground truth used to compare against the prediction.
     */
    @JsonProperty("reference")
    public abstract Builder reference(String reference);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reference(Optional<String> reference);

    /** Clears the value of reference field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReference() {
      return reference(Optional.empty());
    }

    public abstract ToolParameterKeyMatchInstance build();
  }

  /** Deserializes a JSON string to a ToolParameterKeyMatchInstance object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolParameterKeyMatchInstance fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolParameterKeyMatchInstance.class);
  }
}
