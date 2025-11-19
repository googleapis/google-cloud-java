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
import java.time.Duration;
import java.util.Optional;

/**
 * Configuration for TTL of the memories in the Memory Bank based on the action that created or
 * updated the memory.
 */
@AutoValue
@JsonDeserialize(
    builder = ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig.Builder.class)
public abstract class ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig
    extends JsonSerializable {
  /** Optional. The TTL duration for memories uploaded via CreateMemory. */
  @JsonProperty("createTtl")
  public abstract Optional<Duration> createTtl();

  /**
   * Optional. The TTL duration for memories newly generated via GenerateMemories
   * (GenerateMemoriesResponse.GeneratedMemory.Action.CREATED).
   */
  @JsonProperty("generateCreatedTtl")
  public abstract Optional<Duration> generateCreatedTtl();

  /**
   * Optional. The TTL duration for memories updated via GenerateMemories
   * (GenerateMemoriesResponse.GeneratedMemory.Action.UPDATED). In the case of an UPDATE action, the
   * `expire_time` of the existing memory will be updated to the new value (now + TTL).
   */
  @JsonProperty("generateUpdatedTtl")
  public abstract Optional<Duration> generateUpdatedTtl();

  /**
   * Instantiates a builder for
   * ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig.
   */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig
        .Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig
          .Builder();
    }

    /**
     * Setter for createTtl.
     *
     * <p>createTtl: Optional. The TTL duration for memories uploaded via CreateMemory.
     */
    @JsonProperty("createTtl")
    public abstract Builder createTtl(Duration createTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder createTtl(Optional<Duration> createTtl);

    /** Clears the value of createTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreateTtl() {
      return createTtl(Optional.empty());
    }

    /**
     * Setter for generateCreatedTtl.
     *
     * <p>generateCreatedTtl: Optional. The TTL duration for memories newly generated via
     * GenerateMemories (GenerateMemoriesResponse.GeneratedMemory.Action.CREATED).
     */
    @JsonProperty("generateCreatedTtl")
    public abstract Builder generateCreatedTtl(Duration generateCreatedTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generateCreatedTtl(Optional<Duration> generateCreatedTtl);

    /** Clears the value of generateCreatedTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerateCreatedTtl() {
      return generateCreatedTtl(Optional.empty());
    }

    /**
     * Setter for generateUpdatedTtl.
     *
     * <p>generateUpdatedTtl: Optional. The TTL duration for memories updated via GenerateMemories
     * (GenerateMemoriesResponse.GeneratedMemory.Action.UPDATED). In the case of an UPDATE action,
     * the `expire_time` of the existing memory will be updated to the new value (now + TTL).
     */
    @JsonProperty("generateUpdatedTtl")
    public abstract Builder generateUpdatedTtl(Duration generateUpdatedTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generateUpdatedTtl(Optional<Duration> generateUpdatedTtl);

    /** Clears the value of generateUpdatedTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerateUpdatedTtl() {
      return generateUpdatedTtl(Optional.empty());
    }

    public abstract ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig build();
  }

  /**
   * Deserializes a JSON string to a
   * ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig.class);
  }
}
