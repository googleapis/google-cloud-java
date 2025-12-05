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
import com.google.genai.types.Content;
import java.util.Map;
import java.util.Optional;

/** Message to hold a prompt template and the values to populate the template. */
@AutoValue
@JsonDeserialize(builder = PromptTemplateData.Builder.class)
public abstract class PromptTemplateData extends JsonSerializable {
  /** The values for fields in the prompt template. */
  @JsonProperty("values")
  public abstract Optional<Map<String, Content>> values();

  /** Instantiates a builder for PromptTemplateData. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PromptTemplateData.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PromptTemplateData. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PromptTemplateData.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PromptTemplateData.Builder();
    }

    /**
     * Setter for values.
     *
     * <p>values: The values for fields in the prompt template.
     */
    @JsonProperty("values")
    public abstract Builder values(Map<String, Content> values);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder values(Optional<Map<String, Content>> values);

    /** Clears the value of values field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValues() {
      return values(Optional.empty());
    }

    public abstract PromptTemplateData build();
  }

  /** Deserializes a JSON string to a PromptTemplateData object. */
  @ExcludeFromGeneratedCoverageReport
  public static PromptTemplateData fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PromptTemplateData.class);
  }
}
