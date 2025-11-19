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

/** Represents the prompt to be evaluated. */
@AutoValue
@JsonDeserialize(builder = EvaluationPrompt.Builder.class)
public abstract class EvaluationPrompt extends JsonSerializable {
  /** Text prompt. */
  @JsonProperty("text")
  public abstract Optional<String> text();

  /** Fields and values that can be used to populate the prompt template. */
  @JsonProperty("value")
  public abstract Optional<Map<String, Object>> value();

  /** Prompt template data. */
  @JsonProperty("promptTemplateData")
  public abstract Optional<PromptTemplateData> promptTemplateData();

  /** Instantiates a builder for EvaluationPrompt. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationPrompt.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationPrompt. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationPrompt.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationPrompt.Builder();
    }

    /**
     * Setter for text.
     *
     * <p>text: Text prompt.
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

    /**
     * Setter for value.
     *
     * <p>value: Fields and values that can be used to populate the prompt template.
     */
    @JsonProperty("value")
    public abstract Builder value(Map<String, Object> value);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder value(Optional<Map<String, Object>> value);

    /** Clears the value of value field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValue() {
      return value(Optional.empty());
    }

    /**
     * Setter for promptTemplateData.
     *
     * <p>promptTemplateData: Prompt template data.
     */
    @JsonProperty("promptTemplateData")
    public abstract Builder promptTemplateData(PromptTemplateData promptTemplateData);

    /**
     * Setter for promptTemplateData builder.
     *
     * <p>promptTemplateData: Prompt template data.
     */
    @CanIgnoreReturnValue
    public Builder promptTemplateData(PromptTemplateData.Builder promptTemplateDataBuilder) {
      return promptTemplateData(promptTemplateDataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptTemplateData(Optional<PromptTemplateData> promptTemplateData);

    /** Clears the value of promptTemplateData field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptTemplateData() {
      return promptTemplateData(Optional.empty());
    }

    public abstract EvaluationPrompt build();
  }

  /** Deserializes a JSON string to a EvaluationPrompt object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationPrompt fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationPrompt.class);
  }
}
