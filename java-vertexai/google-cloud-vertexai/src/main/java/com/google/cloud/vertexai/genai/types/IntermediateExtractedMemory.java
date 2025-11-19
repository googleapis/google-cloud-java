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

/** An extracted memory that is the intermediate result before consolidation. */
@AutoValue
@JsonDeserialize(builder = IntermediateExtractedMemory.Builder.class)
public abstract class IntermediateExtractedMemory extends JsonSerializable {
  /** Output only. The fact of the extracted memory. */
  @JsonProperty("fact")
  public abstract Optional<String> fact();

  /** Instantiates a builder for IntermediateExtractedMemory. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_IntermediateExtractedMemory.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for IntermediateExtractedMemory. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `IntermediateExtractedMemory.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_IntermediateExtractedMemory.Builder();
    }

    /**
     * Setter for fact.
     *
     * <p>fact: Output only. The fact of the extracted memory.
     */
    @JsonProperty("fact")
    public abstract Builder fact(String fact);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder fact(Optional<String> fact);

    /** Clears the value of fact field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFact() {
      return fact(Optional.empty());
    }

    public abstract IntermediateExtractedMemory build();
  }

  /** Deserializes a JSON string to a IntermediateExtractedMemory object. */
  @ExcludeFromGeneratedCoverageReport
  public static IntermediateExtractedMemory fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, IntermediateExtractedMemory.class);
  }
}
