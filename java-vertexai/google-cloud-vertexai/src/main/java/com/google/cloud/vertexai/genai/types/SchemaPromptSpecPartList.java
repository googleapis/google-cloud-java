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
import com.google.genai.types.Part;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a prompt spec part list. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecPartList.Builder.class)
public abstract class SchemaPromptSpecPartList extends JsonSerializable {
  /** A list of elements that can be part of a prompt. */
  @JsonProperty("parts")
  public abstract Optional<List<Part>> parts();

  /** Instantiates a builder for SchemaPromptSpecPartList. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecPartList.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecPartList. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SchemaPromptSpecPartList.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecPartList.Builder();
    }

    /**
     * Setter for parts.
     *
     * <p>parts: A list of elements that can be part of a prompt.
     */
    @JsonProperty("parts")
    public abstract Builder parts(List<Part> parts);

    /**
     * Setter for parts.
     *
     * <p>parts: A list of elements that can be part of a prompt.
     */
    @CanIgnoreReturnValue
    public Builder parts(Part... parts) {
      return parts(Arrays.asList(parts));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder parts(Optional<List<Part>> parts);

    /** Clears the value of parts field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearParts() {
      return parts(Optional.empty());
    }

    public abstract SchemaPromptSpecPartList build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecPartList object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecPartList fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecPartList.class);
  }
}
