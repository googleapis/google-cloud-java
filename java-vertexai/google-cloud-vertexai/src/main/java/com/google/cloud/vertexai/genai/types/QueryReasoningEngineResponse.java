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

/** The response for querying an agent engine. */
@AutoValue
@JsonDeserialize(builder = QueryReasoningEngineResponse.Builder.class)
public abstract class QueryReasoningEngineResponse extends JsonSerializable {
  /** Response provided by users in JSON object format. */
  @JsonProperty("output")
  public abstract Optional<Object> output();

  /** Instantiates a builder for QueryReasoningEngineResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_QueryReasoningEngineResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for QueryReasoningEngineResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `QueryReasoningEngineResponse.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_QueryReasoningEngineResponse.Builder();
    }

    /**
     * Setter for output.
     *
     * <p>output: Response provided by users in JSON object format.
     */
    @JsonProperty("output")
    public abstract Builder output(Object output);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder output(Optional<Object> output);

    /** Clears the value of output field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOutput() {
      return output(Optional.empty());
    }

    public abstract QueryReasoningEngineResponse build();
  }

  /** Deserializes a JSON string to a QueryReasoningEngineResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static QueryReasoningEngineResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, QueryReasoningEngineResponse.class);
  }
}
