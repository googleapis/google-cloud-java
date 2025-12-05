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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Rubric-enhanced contents for evaluation. */
@AutoValue
@JsonDeserialize(builder = RubricEnhancedContents.Builder.class)
public abstract class RubricEnhancedContents extends JsonSerializable {
  /** User prompt, using the standard Content type from the Gen AI SDK. */
  @JsonProperty("prompt")
  public abstract Optional<List<Content>> prompt();

  /** Response, using the standard Content type from the Gen AI SDK. */
  @JsonProperty("response")
  public abstract Optional<List<Content>> response();

  /** Instantiates a builder for RubricEnhancedContents. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricEnhancedContents.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricEnhancedContents. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricEnhancedContents.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricEnhancedContents.Builder();
    }

    /**
     * Setter for prompt.
     *
     * <p>prompt: User prompt, using the standard Content type from the Gen AI SDK.
     */
    @JsonProperty("prompt")
    public abstract Builder prompt(List<Content> prompt);

    /**
     * Setter for prompt.
     *
     * <p>prompt: User prompt, using the standard Content type from the Gen AI SDK.
     */
    @CanIgnoreReturnValue
    public Builder prompt(Content... prompt) {
      return prompt(Arrays.asList(prompt));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder prompt(Optional<List<Content>> prompt);

    /** Clears the value of prompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPrompt() {
      return prompt(Optional.empty());
    }

    /**
     * Setter for response.
     *
     * <p>response: Response, using the standard Content type from the Gen AI SDK.
     */
    @JsonProperty("response")
    public abstract Builder response(List<Content> response);

    /**
     * Setter for response.
     *
     * <p>response: Response, using the standard Content type from the Gen AI SDK.
     */
    @CanIgnoreReturnValue
    public Builder response(Content... response) {
      return response(Arrays.asList(response));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder response(Optional<List<Content>> response);

    /** Clears the value of response field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponse() {
      return response(Optional.empty());
    }

    public abstract RubricEnhancedContents build();
  }

  /** Deserializes a JSON string to a RubricEnhancedContents object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricEnhancedContents fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricEnhancedContents.class);
  }
}
