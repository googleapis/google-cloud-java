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

/** Response for the optimize_prompt method. */
@AutoValue
@JsonDeserialize(builder = OptimizeResponseEndpoint.Builder.class)
public abstract class OptimizeResponseEndpoint extends JsonSerializable {
  /** */
  @JsonProperty("content")
  public abstract Optional<Content> content();

  /** Instantiates a builder for OptimizeResponseEndpoint. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_OptimizeResponseEndpoint.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for OptimizeResponseEndpoint. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `OptimizeResponseEndpoint.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_OptimizeResponseEndpoint.Builder();
    }

    /**
     * Setter for content.
     *
     * <p>content:
     */
    @JsonProperty("content")
    public abstract Builder content(Content content);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder content(Optional<Content> content);

    /** Clears the value of content field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContent() {
      return content(Optional.empty());
    }

    public abstract OptimizeResponseEndpoint build();
  }

  /** Deserializes a JSON string to a OptimizeResponseEndpoint object. */
  @ExcludeFromGeneratedCoverageReport
  public static OptimizeResponseEndpoint fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, OptimizeResponseEndpoint.class);
  }
}
