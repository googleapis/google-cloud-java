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

/** A retrieved memory. */
@AutoValue
@JsonDeserialize(builder = RetrieveMemoriesResponseRetrievedMemory.Builder.class)
public abstract class RetrieveMemoriesResponseRetrievedMemory extends JsonSerializable {
  /**
   * The distance between the query and the retrieved Memory. Smaller values indicate more similar
   * memories. This is only set if similarity search was used for retrieval.
   */
  @JsonProperty("distance")
  public abstract Optional<Double> distance();

  /** The retrieved Memory. */
  @JsonProperty("memory")
  public abstract Optional<Memory> memory();

  /** Instantiates a builder for RetrieveMemoriesResponseRetrievedMemory. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RetrieveMemoriesResponseRetrievedMemory.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RetrieveMemoriesResponseRetrievedMemory. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RetrieveMemoriesResponseRetrievedMemory.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RetrieveMemoriesResponseRetrievedMemory.Builder();
    }

    /**
     * Setter for distance.
     *
     * <p>distance: The distance between the query and the retrieved Memory. Smaller values indicate
     * more similar memories. This is only set if similarity search was used for retrieval.
     */
    @JsonProperty("distance")
    public abstract Builder distance(Double distance);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder distance(Optional<Double> distance);

    /** Clears the value of distance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDistance() {
      return distance(Optional.empty());
    }

    /**
     * Setter for memory.
     *
     * <p>memory: The retrieved Memory.
     */
    @JsonProperty("memory")
    public abstract Builder memory(Memory memory);

    /**
     * Setter for memory builder.
     *
     * <p>memory: The retrieved Memory.
     */
    @CanIgnoreReturnValue
    public Builder memory(Memory.Builder memoryBuilder) {
      return memory(memoryBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memory(Optional<Memory> memory);

    /** Clears the value of memory field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemory() {
      return memory(Optional.empty());
    }

    public abstract RetrieveMemoriesResponseRetrievedMemory build();
  }

  /** Deserializes a JSON string to a RetrieveMemoriesResponseRetrievedMemory object. */
  @ExcludeFromGeneratedCoverageReport
  public static RetrieveMemoriesResponseRetrievedMemory fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, RetrieveMemoriesResponseRetrievedMemory.class);
  }
}
