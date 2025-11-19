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

/** Response for the optimize_prompt method. */
@AutoValue
@JsonDeserialize(builder = OptimizeResponse.Builder.class)
public abstract class OptimizeResponse extends JsonSerializable {
  /** */
  @JsonProperty("rawTextResponse")
  public abstract Optional<String> rawTextResponse();

  /** */
  @JsonProperty("parsedResponse")
  public abstract Optional<ParsedResponse> parsedResponse();

  /** Instantiates a builder for OptimizeResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_OptimizeResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for OptimizeResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `OptimizeResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_OptimizeResponse.Builder();
    }

    /**
     * Setter for rawTextResponse.
     *
     * <p>rawTextResponse:
     */
    @JsonProperty("rawTextResponse")
    public abstract Builder rawTextResponse(String rawTextResponse);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rawTextResponse(Optional<String> rawTextResponse);

    /** Clears the value of rawTextResponse field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRawTextResponse() {
      return rawTextResponse(Optional.empty());
    }

    /**
     * Setter for parsedResponse.
     *
     * <p>parsedResponse:
     */
    @JsonProperty("parsedResponse")
    public abstract Builder parsedResponse(ParsedResponse parsedResponse);

    /**
     * Setter for parsedResponse builder.
     *
     * <p>parsedResponse:
     */
    @CanIgnoreReturnValue
    public Builder parsedResponse(ParsedResponse.Builder parsedResponseBuilder) {
      return parsedResponse(parsedResponseBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder parsedResponse(Optional<ParsedResponse> parsedResponse);

    /** Clears the value of parsedResponse field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearParsedResponse() {
      return parsedResponse(Optional.empty());
    }

    public abstract OptimizeResponse build();
  }

  /** Deserializes a JSON string to a OptimizeResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static OptimizeResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, OptimizeResponse.class);
  }
}
