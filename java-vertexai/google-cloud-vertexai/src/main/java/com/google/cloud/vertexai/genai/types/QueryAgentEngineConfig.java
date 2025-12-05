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
import com.google.genai.types.HttpOptions;
import java.util.Map;
import java.util.Optional;

/** Config for querying agent engines. */
@AutoValue
@JsonDeserialize(builder = QueryAgentEngineConfig.Builder.class)
public abstract class QueryAgentEngineConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** The class method to call. */
  @JsonProperty("classMethod")
  public abstract Optional<String> classMethod();

  /** The input to the class method. */
  @JsonProperty("input")
  public abstract Optional<Map<String, Object>> input();

  /** */
  @JsonProperty("includeAllFields")
  public abstract Optional<Boolean> includeAllFields();

  /** Instantiates a builder for QueryAgentEngineConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_QueryAgentEngineConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for QueryAgentEngineConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `QueryAgentEngineConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_QueryAgentEngineConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for classMethod.
     *
     * <p>classMethod: The class method to call.
     */
    @JsonProperty("classMethod")
    public abstract Builder classMethod(String classMethod);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder classMethod(Optional<String> classMethod);

    /** Clears the value of classMethod field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearClassMethod() {
      return classMethod(Optional.empty());
    }

    /**
     * Setter for input.
     *
     * <p>input: The input to the class method.
     */
    @JsonProperty("input")
    public abstract Builder input(Map<String, Object> input);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder input(Optional<Map<String, Object>> input);

    /** Clears the value of input field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInput() {
      return input(Optional.empty());
    }

    /**
     * Setter for includeAllFields.
     *
     * <p>includeAllFields:
     */
    @JsonProperty("includeAllFields")
    public abstract Builder includeAllFields(boolean includeAllFields);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder includeAllFields(Optional<Boolean> includeAllFields);

    /** Clears the value of includeAllFields field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearIncludeAllFields() {
      return includeAllFields(Optional.empty());
    }

    public abstract QueryAgentEngineConfig build();
  }

  /** Deserializes a JSON string to a QueryAgentEngineConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static QueryAgentEngineConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, QueryAgentEngineConfig.class);
  }
}
