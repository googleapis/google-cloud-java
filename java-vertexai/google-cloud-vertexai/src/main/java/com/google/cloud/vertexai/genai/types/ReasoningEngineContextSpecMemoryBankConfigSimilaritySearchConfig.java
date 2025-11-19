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

/** Configuration for how to perform similarity search on memories. */
@AutoValue
@JsonDeserialize(
    builder = ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.Builder.class)
public abstract class ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig
    extends JsonSerializable {
  /**
   * Required. The model used to generate embeddings to lookup similar memories. Format:
   * `projects/{project}/locations/{location}/publishers/google/models/{model}`.
   */
  @JsonProperty("embeddingModel")
  public abstract Optional<String> embeddingModel();

  /**
   * Instantiates a builder for ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.
   */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig
          .Builder();
    }

    /**
     * Setter for embeddingModel.
     *
     * <p>embeddingModel: Required. The model used to generate embeddings to lookup similar
     * memories. Format: `projects/{project}/locations/{location}/publishers/google/models/{model}`.
     */
    @JsonProperty("embeddingModel")
    public abstract Builder embeddingModel(String embeddingModel);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder embeddingModel(Optional<String> embeddingModel);

    /** Clears the value of embeddingModel field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEmbeddingModel() {
      return embeddingModel(Optional.empty());
    }

    public abstract ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig build();
  }

  /**
   * Deserializes a JSON string to a
   * ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.class);
  }
}
