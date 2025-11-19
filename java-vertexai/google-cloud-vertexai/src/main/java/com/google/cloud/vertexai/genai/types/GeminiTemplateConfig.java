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
import java.util.Map;
import java.util.Optional;

/** Represents a Gemini template config. */
@AutoValue
@JsonDeserialize(builder = GeminiTemplateConfig.Builder.class)
public abstract class GeminiTemplateConfig extends JsonSerializable {
  /**
   * Required. The template that will be used for assembling the request to use for downstream
   * applications.
   */
  @JsonProperty("geminiExample")
  public abstract Optional<GeminiExample> geminiExample();

  /** Required. Map of template parameters to the columns in the dataset table. */
  @JsonProperty("fieldMapping")
  public abstract Optional<Map<String, String>> fieldMapping();

  /** Instantiates a builder for GeminiTemplateConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GeminiTemplateConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GeminiTemplateConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GeminiTemplateConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GeminiTemplateConfig.Builder();
    }

    /**
     * Setter for geminiExample.
     *
     * <p>geminiExample: Required. The template that will be used for assembling the request to use
     * for downstream applications.
     */
    @JsonProperty("geminiExample")
    public abstract Builder geminiExample(GeminiExample geminiExample);

    /**
     * Setter for geminiExample builder.
     *
     * <p>geminiExample: Required. The template that will be used for assembling the request to use
     * for downstream applications.
     */
    @CanIgnoreReturnValue
    public Builder geminiExample(GeminiExample.Builder geminiExampleBuilder) {
      return geminiExample(geminiExampleBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder geminiExample(Optional<GeminiExample> geminiExample);

    /** Clears the value of geminiExample field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGeminiExample() {
      return geminiExample(Optional.empty());
    }

    /**
     * Setter for fieldMapping.
     *
     * <p>fieldMapping: Required. Map of template parameters to the columns in the dataset table.
     */
    @JsonProperty("fieldMapping")
    public abstract Builder fieldMapping(Map<String, String> fieldMapping);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder fieldMapping(Optional<Map<String, String>> fieldMapping);

    /** Clears the value of fieldMapping field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFieldMapping() {
      return fieldMapping(Optional.empty());
    }

    public abstract GeminiTemplateConfig build();
  }

  /** Deserializes a JSON string to a GeminiTemplateConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static GeminiTemplateConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GeminiTemplateConfig.class);
  }
}
