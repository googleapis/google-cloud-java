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

/** Prompt variation that embeds preambles to prompt string. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecMultimodalPrompt.Builder.class)
public abstract class SchemaPromptSpecMultimodalPrompt extends JsonSerializable {
  /** The prompt message. */
  @JsonProperty("promptMessage")
  public abstract Optional<SchemaPromptSpecPromptMessage> promptMessage();

  /** Instantiates a builder for SchemaPromptSpecMultimodalPrompt. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecMultimodalPrompt.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecMultimodalPrompt. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecMultimodalPrompt.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecMultimodalPrompt.Builder();
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

    public abstract SchemaPromptSpecMultimodalPrompt build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecMultimodalPrompt object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecMultimodalPrompt fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecMultimodalPrompt.class);
  }
}
