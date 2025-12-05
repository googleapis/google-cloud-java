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

/** The direct memories source for generating memories. */
@AutoValue
@JsonDeserialize(builder = GenerateMemoriesRequestDirectMemoriesSource.Builder.class)
public abstract class GenerateMemoriesRequestDirectMemoriesSource extends JsonSerializable {
  /**
   * Required. The direct memories to upload to Memory Bank. At most 5 direct memories are allowed
   * per request.
   */
  @JsonProperty("directMemories")
  public abstract Optional<List<GenerateMemoriesRequestDirectMemoriesSourceDirectMemory>>
      directMemories();

  /** Instantiates a builder for GenerateMemoriesRequestDirectMemoriesSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateMemoriesRequestDirectMemoriesSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateMemoriesRequestDirectMemoriesSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateMemoriesRequestDirectMemoriesSource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateMemoriesRequestDirectMemoriesSource.Builder();
    }

    /**
     * Setter for directMemories.
     *
     * <p>directMemories: Required. The direct memories to upload to Memory Bank. At most 5 direct
     * memories are allowed per request.
     */
    @JsonProperty("directMemories")
    public abstract Builder directMemories(
        List<GenerateMemoriesRequestDirectMemoriesSourceDirectMemory> directMemories);

    /**
     * Setter for directMemories.
     *
     * <p>directMemories: Required. The direct memories to upload to Memory Bank. At most 5 direct
     * memories are allowed per request.
     */
    @CanIgnoreReturnValue
    public Builder directMemories(
        GenerateMemoriesRequestDirectMemoriesSourceDirectMemory... directMemories) {
      return directMemories(Arrays.asList(directMemories));
    }

    /**
     * Setter for directMemories builder.
     *
     * <p>directMemories: Required. The direct memories to upload to Memory Bank. At most 5 direct
     * memories are allowed per request.
     */
    @CanIgnoreReturnValue
    public Builder directMemories(
        GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.Builder... directMemoriesBuilders) {
      return directMemories(
          Arrays.asList(directMemoriesBuilders).stream()
              .map(GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder directMemories(
        Optional<List<GenerateMemoriesRequestDirectMemoriesSourceDirectMemory>> directMemories);

    /** Clears the value of directMemories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDirectMemories() {
      return directMemories(Optional.empty());
    }

    public abstract GenerateMemoriesRequestDirectMemoriesSource build();
  }

  /** Deserializes a JSON string to a GenerateMemoriesRequestDirectMemoriesSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateMemoriesRequestDirectMemoriesSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GenerateMemoriesRequestDirectMemoriesSource.class);
  }
}
