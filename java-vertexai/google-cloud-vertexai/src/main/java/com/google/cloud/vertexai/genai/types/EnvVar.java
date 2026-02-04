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

/** Represents an environment variable present in a Container or Python Module. */
@AutoValue
@JsonDeserialize(builder = EnvVar.Builder.class)
public abstract class EnvVar extends JsonSerializable {
  /** Required. Name of the environment variable. Must be a valid C identifier. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * Required. Variables that reference a $(VAR_NAME) are expanded using the previous defined
   * environment variables in the container and any service environment variables. If a variable
   * cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax
   * can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded,
   * regardless of whether the variable exists or not.
   */
  @JsonProperty("value")
  public abstract Optional<String> value();

  /** Instantiates a builder for EnvVar. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EnvVar.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EnvVar. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EnvVar.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EnvVar.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Required. Name of the environment variable. Must be a valid C identifier.
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for value.
     *
     * <p>value: Required. Variables that reference a $(VAR_NAME) are expanded using the previous
     * defined environment variables in the container and any service environment variables. If a
     * variable cannot be resolved, the reference in the input string will be unchanged. The
     * $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will
     * never be expanded, regardless of whether the variable exists or not.
     */
    @JsonProperty("value")
    public abstract Builder value(String value);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder value(Optional<String> value);

    /** Clears the value of value field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValue() {
      return value(Optional.empty());
    }

    public abstract EnvVar build();
  }

  /** Deserializes a JSON string to a EnvVar object. */
  @ExcludeFromGeneratedCoverageReport
  public static EnvVar fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EnvVar.class);
  }
}
