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

/** A memory that was generated. */
@AutoValue
@JsonDeserialize(builder = GenerateMemoriesResponseGeneratedMemory.Builder.class)
public abstract class GenerateMemoriesResponseGeneratedMemory extends JsonSerializable {
  /** The generated memory. */
  @JsonProperty("memory")
  public abstract Optional<Memory> memory();

  /** The action to take. */
  @JsonProperty("action")
  public abstract Optional<GenerateMemoriesResponseGeneratedMemoryAction> action();

  /**
   * The previous revision of the Memory before the action was performed. This field is only set if
   * the action is `UPDATED` or `DELETED`. You can use this to rollback the Memory to the previous
   * revision, undoing the action. Format:
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}/revisions/{revision}`
   */
  @JsonProperty("previousRevision")
  public abstract Optional<String> previousRevision();

  /** Instantiates a builder for GenerateMemoriesResponseGeneratedMemory. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateMemoriesResponseGeneratedMemory.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateMemoriesResponseGeneratedMemory. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateMemoriesResponseGeneratedMemory.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateMemoriesResponseGeneratedMemory.Builder();
    }

    /**
     * Setter for memory.
     *
     * <p>memory: The generated memory.
     */
    @JsonProperty("memory")
    public abstract Builder memory(Memory memory);

    /**
     * Setter for memory builder.
     *
     * <p>memory: The generated memory.
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

    /**
     * Setter for action.
     *
     * <p>action: The action to take.
     */
    @JsonProperty("action")
    public abstract Builder action(GenerateMemoriesResponseGeneratedMemoryAction action);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder action(Optional<GenerateMemoriesResponseGeneratedMemoryAction> action);

    /** Clears the value of action field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAction() {
      return action(Optional.empty());
    }

    /**
     * Setter for action given a known enum.
     *
     * <p>action: The action to take.
     */
    @CanIgnoreReturnValue
    public Builder action(GenerateMemoriesResponseGeneratedMemoryAction.Known knownType) {
      return action(new GenerateMemoriesResponseGeneratedMemoryAction(knownType));
    }

    /**
     * Setter for action given a string.
     *
     * <p>action: The action to take.
     */
    @CanIgnoreReturnValue
    public Builder action(String action) {
      return action(new GenerateMemoriesResponseGeneratedMemoryAction(action));
    }

    /**
     * Setter for previousRevision.
     *
     * <p>previousRevision: The previous revision of the Memory before the action was performed.
     * This field is only set if the action is `UPDATED` or `DELETED`. You can use this to rollback
     * the Memory to the previous revision, undoing the action. Format:
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}/revisions/{revision}`
     */
    @JsonProperty("previousRevision")
    public abstract Builder previousRevision(String previousRevision);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder previousRevision(Optional<String> previousRevision);

    /** Clears the value of previousRevision field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPreviousRevision() {
      return previousRevision(Optional.empty());
    }

    public abstract GenerateMemoriesResponseGeneratedMemory build();
  }

  /** Deserializes a JSON string to a GenerateMemoriesResponseGeneratedMemory object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateMemoriesResponseGeneratedMemory fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GenerateMemoriesResponseGeneratedMemory.class);
  }
}
