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

/** A prompt instance's parameters set that contains a set of variable values. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptInstancePromptExecution.Builder.class)
public abstract class SchemaPromptInstancePromptExecution extends JsonSerializable {
  /** Maps variable names to their value. */
  @JsonProperty("arguments")
  public abstract Optional<Map<String, SchemaPromptInstanceVariableValue>> arguments();

  /** Instantiates a builder for SchemaPromptInstancePromptExecution. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptInstancePromptExecution.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptInstancePromptExecution. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptInstancePromptExecution.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptInstancePromptExecution.Builder();
    }

    /**
     * Setter for arguments.
     *
     * <p>arguments: Maps variable names to their value.
     */
    @JsonProperty("arguments")
    public abstract Builder arguments(Map<String, SchemaPromptInstanceVariableValue> arguments);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder arguments(Optional<Map<String, SchemaPromptInstanceVariableValue>> arguments);

    /** Clears the value of arguments field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearArguments() {
      return arguments(Optional.empty());
    }

    public abstract SchemaPromptInstancePromptExecution build();
  }

  /** Deserializes a JSON string to a SchemaPromptInstancePromptExecution object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptInstancePromptExecution fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptInstancePromptExecution.class);
  }
}
