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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** The response for generating memories. */
@AutoValue
@JsonDeserialize(builder = GenerateMemoriesResponse.Builder.class)
public abstract class GenerateMemoriesResponse extends JsonSerializable {
  /** The generated memories. */
  @JsonProperty("generatedMemories")
  public abstract Optional<List<GenerateMemoriesResponseGeneratedMemory>> generatedMemories();

  /** Instantiates a builder for GenerateMemoriesResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateMemoriesResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateMemoriesResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GenerateMemoriesResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateMemoriesResponse.Builder();
    }

    /**
     * Setter for generatedMemories.
     *
     * <p>generatedMemories: The generated memories.
     */
    @JsonProperty("generatedMemories")
    public abstract Builder generatedMemories(
        List<GenerateMemoriesResponseGeneratedMemory> generatedMemories);

    /**
     * Setter for generatedMemories.
     *
     * <p>generatedMemories: The generated memories.
     */
    @CanIgnoreReturnValue
    public Builder generatedMemories(GenerateMemoriesResponseGeneratedMemory... generatedMemories) {
      return generatedMemories(Arrays.asList(generatedMemories));
    }

    /**
     * Setter for generatedMemories builder.
     *
     * <p>generatedMemories: The generated memories.
     */
    @CanIgnoreReturnValue
    public Builder generatedMemories(
        GenerateMemoriesResponseGeneratedMemory.Builder... generatedMemoriesBuilders) {
      return generatedMemories(
          Arrays.asList(generatedMemoriesBuilders).stream()
              .map(GenerateMemoriesResponseGeneratedMemory.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generatedMemories(
        Optional<List<GenerateMemoriesResponseGeneratedMemory>> generatedMemories);

    /** Clears the value of generatedMemories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGeneratedMemories() {
      return generatedMemories(Optional.empty());
    }

    public abstract GenerateMemoriesResponse build();
  }

  /** Deserializes a JSON string to a GenerateMemoriesResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateMemoriesResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GenerateMemoriesResponse.class);
  }
}
