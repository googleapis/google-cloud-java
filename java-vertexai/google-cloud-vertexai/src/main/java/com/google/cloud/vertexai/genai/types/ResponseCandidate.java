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
import java.util.Optional;

/** A model-generated content to the prompt. */
@AutoValue
@JsonDeserialize(builder = ResponseCandidate.Builder.class)
public abstract class ResponseCandidate extends JsonSerializable {
  /** The final model-generated response to the `prompt`. */
  @JsonProperty("response")
  public abstract Optional<Content> response();

  /** Instantiates a builder for ResponseCandidate. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ResponseCandidate.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ResponseCandidate. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ResponseCandidate.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ResponseCandidate.Builder();
    }

    /**
     * Setter for response.
     *
     * <p>response: The final model-generated response to the `prompt`.
     */
    @JsonProperty("response")
    public abstract Builder response(Content response);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder response(Optional<Content> response);

    /** Clears the value of response field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponse() {
      return response(Optional.empty());
    }

    public abstract ResponseCandidate build();
  }

  /** Deserializes a JSON string to a ResponseCandidate object. */
  @ExcludeFromGeneratedCoverageReport
  public static ResponseCandidate fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ResponseCandidate.class);
  }
}
