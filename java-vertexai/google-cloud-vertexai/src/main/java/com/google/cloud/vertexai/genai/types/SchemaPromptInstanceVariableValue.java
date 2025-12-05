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

/** Represents a prompt instance variable. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptInstanceVariableValue.Builder.class)
public abstract class SchemaPromptInstanceVariableValue extends JsonSerializable {
  /** The parts of the variable value. */
  @JsonProperty("partList")
  public abstract Optional<SchemaPromptSpecPartList> partList();

  /** Instantiates a builder for SchemaPromptInstanceVariableValue. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptInstanceVariableValue.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptInstanceVariableValue. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptInstanceVariableValue.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptInstanceVariableValue.Builder();
    }

    /**
     * Setter for partList.
     *
     * <p>partList: The parts of the variable value.
     */
    @JsonProperty("partList")
    public abstract Builder partList(SchemaPromptSpecPartList partList);

    /**
     * Setter for partList builder.
     *
     * <p>partList: The parts of the variable value.
     */
    @CanIgnoreReturnValue
    public Builder partList(SchemaPromptSpecPartList.Builder partListBuilder) {
      return partList(partListBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder partList(Optional<SchemaPromptSpecPartList> partList);

    /** Clears the value of partList field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPartList() {
      return partList(Optional.empty());
    }

    public abstract SchemaPromptInstanceVariableValue build();
  }

  /** Deserializes a JSON string to a SchemaPromptInstanceVariableValue object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptInstanceVariableValue fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptInstanceVariableValue.class);
  }
}
