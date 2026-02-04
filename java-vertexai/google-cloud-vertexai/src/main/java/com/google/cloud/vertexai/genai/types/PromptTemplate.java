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

/** A prompt template for creating prompts with variables. */
@AutoValue
@JsonDeserialize(builder = PromptTemplate.Builder.class)
public abstract class PromptTemplate extends JsonSerializable {
  /** The prompt template text. */
  @JsonProperty("text")
  public abstract Optional<String> text();

  /** Instantiates a builder for PromptTemplate. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PromptTemplate.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PromptTemplate. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PromptTemplate.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PromptTemplate.Builder();
    }

    /**
     * Setter for text.
     *
     * <p>text: The prompt template text.
     */
    @JsonProperty("text")
    public abstract Builder text(String text);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder text(Optional<String> text);

    /** Clears the value of text field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearText() {
      return text(Optional.empty());
    }

    public abstract PromptTemplate build();
  }

  /** Deserializes a JSON string to a PromptTemplate object. */
  @ExcludeFromGeneratedCoverageReport
  public static PromptTemplate fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PromptTemplate.class);
  }
}
