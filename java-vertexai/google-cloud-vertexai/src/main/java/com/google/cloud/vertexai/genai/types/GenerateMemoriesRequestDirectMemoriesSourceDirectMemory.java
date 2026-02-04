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

/** A direct memory to upload to Memory Bank. */
@AutoValue
@JsonDeserialize(builder = GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.Builder.class)
public abstract class GenerateMemoriesRequestDirectMemoriesSourceDirectMemory
    extends JsonSerializable {
  /** Required. The fact to consolidate with existing memories. */
  @JsonProperty("fact")
  public abstract Optional<String> fact();

  /** Optional. The topics that the consolidated memories should be associated with. */
  @JsonProperty("topics")
  public abstract Optional<List<MemoryTopicId>> topics();

  /** Instantiates a builder for GenerateMemoriesRequestDirectMemoriesSourceDirectMemory. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateMemoriesRequestDirectMemoriesSourceDirectMemory. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.Builder();
    }

    /**
     * Setter for fact.
     *
     * <p>fact: Required. The fact to consolidate with existing memories.
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

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The topics that the consolidated memories should be associated with.
     */
    @JsonProperty("topics")
    public abstract Builder topics(List<MemoryTopicId> topics);

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The topics that the consolidated memories should be associated with.
     */
    @CanIgnoreReturnValue
    public Builder topics(MemoryTopicId... topics) {
      return topics(Arrays.asList(topics));
    }

    /**
     * Setter for topics builder.
     *
     * <p>topics: Optional. The topics that the consolidated memories should be associated with.
     */
    @CanIgnoreReturnValue
    public Builder topics(MemoryTopicId.Builder... topicsBuilders) {
      return topics(
          Arrays.asList(topicsBuilders).stream()
              .map(MemoryTopicId.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder topics(Optional<List<MemoryTopicId>> topics);

    /** Clears the value of topics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTopics() {
      return topics(Optional.empty());
    }

    public abstract GenerateMemoriesRequestDirectMemoriesSourceDirectMemory build();
  }

  /**
   * Deserializes a JSON string to a GenerateMemoriesRequestDirectMemoriesSourceDirectMemory object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateMemoriesRequestDirectMemoriesSourceDirectMemory fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GenerateMemoriesRequestDirectMemoriesSourceDirectMemory.class);
  }
}
