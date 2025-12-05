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

/** Prompt variation for Translation use case. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecTranslationPrompt.Builder.class)
public abstract class SchemaPromptSpecTranslationPrompt extends JsonSerializable {
  /** The translation example. */
  @JsonProperty("example")
  public abstract Optional<SchemaPromptSpecTranslationExample> example();

  /** The translation option. */
  @JsonProperty("option")
  public abstract Optional<SchemaPromptSpecTranslationOption> option();

  /** The prompt message. */
  @JsonProperty("promptMessage")
  public abstract Optional<SchemaPromptSpecPromptMessage> promptMessage();

  /** The source language code. */
  @JsonProperty("sourceLanguageCode")
  public abstract Optional<String> sourceLanguageCode();

  /** The target language code. */
  @JsonProperty("targetLanguageCode")
  public abstract Optional<String> targetLanguageCode();

  /** Instantiates a builder for SchemaPromptSpecTranslationPrompt. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecTranslationPrompt.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecTranslationPrompt. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecTranslationPrompt.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecTranslationPrompt.Builder();
    }

    /**
     * Setter for example.
     *
     * <p>example: The translation example.
     */
    @JsonProperty("example")
    public abstract Builder example(SchemaPromptSpecTranslationExample example);

    /**
     * Setter for example builder.
     *
     * <p>example: The translation example.
     */
    @CanIgnoreReturnValue
    public Builder example(SchemaPromptSpecTranslationExample.Builder exampleBuilder) {
      return example(exampleBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder example(Optional<SchemaPromptSpecTranslationExample> example);

    /** Clears the value of example field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExample() {
      return example(Optional.empty());
    }

    /**
     * Setter for option.
     *
     * <p>option: The translation option.
     */
    @JsonProperty("option")
    public abstract Builder option(SchemaPromptSpecTranslationOption option);

    /**
     * Setter for option builder.
     *
     * <p>option: The translation option.
     */
    @CanIgnoreReturnValue
    public Builder option(SchemaPromptSpecTranslationOption.Builder optionBuilder) {
      return option(optionBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder option(Optional<SchemaPromptSpecTranslationOption> option);

    /** Clears the value of option field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOption() {
      return option(Optional.empty());
    }

    /**
     * Setter for promptMessage.
     *
     * <p>promptMessage: The prompt message.
     */
    @JsonProperty("promptMessage")
    public abstract Builder promptMessage(SchemaPromptSpecPromptMessage promptMessage);

    /**
     * Setter for promptMessage builder.
     *
     * <p>promptMessage: The prompt message.
     */
    @CanIgnoreReturnValue
    public Builder promptMessage(SchemaPromptSpecPromptMessage.Builder promptMessageBuilder) {
      return promptMessage(promptMessageBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptMessage(Optional<SchemaPromptSpecPromptMessage> promptMessage);

    /** Clears the value of promptMessage field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptMessage() {
      return promptMessage(Optional.empty());
    }

    /**
     * Setter for sourceLanguageCode.
     *
     * <p>sourceLanguageCode: The source language code.
     */
    @JsonProperty("sourceLanguageCode")
    public abstract Builder sourceLanguageCode(String sourceLanguageCode);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sourceLanguageCode(Optional<String> sourceLanguageCode);

    /** Clears the value of sourceLanguageCode field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSourceLanguageCode() {
      return sourceLanguageCode(Optional.empty());
    }

    /**
     * Setter for targetLanguageCode.
     *
     * <p>targetLanguageCode: The target language code.
     */
    @JsonProperty("targetLanguageCode")
    public abstract Builder targetLanguageCode(String targetLanguageCode);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder targetLanguageCode(Optional<String> targetLanguageCode);

    /** Clears the value of targetLanguageCode field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTargetLanguageCode() {
      return targetLanguageCode(Optional.empty());
    }

    public abstract SchemaPromptSpecTranslationPrompt build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecTranslationPrompt object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecTranslationPrompt fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecTranslationPrompt.class);
  }
}
