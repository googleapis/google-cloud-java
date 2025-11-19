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

/** Configuration for how to generate memories. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.Builder.class)
public abstract class ReasoningEngineContextSpecMemoryBankConfigGenerationConfig
    extends JsonSerializable {
  /**
   * Required. The model used to generate memories. Format:
   * `projects/{project}/locations/{location}/publishers/google/models/{model}`.
   */
  @JsonProperty("model")
  public abstract Optional<String> model();

  /** Instantiates a builder for ReasoningEngineContextSpecMemoryBankConfigGenerationConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpecMemoryBankConfigGenerationConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.Builder();
    }

    /**
     * Setter for model.
     *
     * <p>model: Required. The model used to generate memories. Format:
     * `projects/{project}/locations/{location}/publishers/google/models/{model}`.
     */
    @JsonProperty("model")
    public abstract Builder model(String model);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder model(Optional<String> model);

    /** Clears the value of model field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearModel() {
      return model(Optional.empty());
    }

    public abstract ReasoningEngineContextSpecMemoryBankConfigGenerationConfig build();
  }

  /**
   * Deserializes a JSON string to a ReasoningEngineContextSpecMemoryBankConfigGenerationConfig
   * object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpecMemoryBankConfigGenerationConfig fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.class);
  }
}
