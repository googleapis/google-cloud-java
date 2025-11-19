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
 * Configuration for automatically setting the TTL ("time-to-live") of the memories in the Memory
 * Bank.
 */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineContextSpecMemoryBankConfigTtlConfig.Builder.class)
public abstract class ReasoningEngineContextSpecMemoryBankConfigTtlConfig extends JsonSerializable {
  /**
   * Optional. The default TTL duration of the memories in the Memory Bank. This applies to all
   * operations that create or update a memory.
   */
  @JsonProperty("defaultTtl")
  public abstract Optional<Duration> defaultTtl();

  /** Optional. The granular TTL configuration of the memories in the Memory Bank. */
  @JsonProperty("granularTtlConfig")
  public abstract Optional<ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig>
      granularTtlConfig();

  /**
   * Optional. The default TTL duration of the memory revisions in the Memory Bank. This applies to
   * all operations that create a memory revision. If not set, a default TTL of 365 days will be
   * used.
   */
  @JsonProperty("memoryRevisionDefaultTtl")
  public abstract Optional<Duration> memoryRevisionDefaultTtl();

  /** Instantiates a builder for ReasoningEngineContextSpecMemoryBankConfigTtlConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigTtlConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpecMemoryBankConfigTtlConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `ReasoningEngineContextSpecMemoryBankConfigTtlConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpecMemoryBankConfigTtlConfig.Builder();
    }

    /**
     * Setter for defaultTtl.
     *
     * <p>defaultTtl: Optional. The default TTL duration of the memories in the Memory Bank. This
     * applies to all operations that create or update a memory.
     */
    @JsonProperty("defaultTtl")
    public abstract Builder defaultTtl(Duration defaultTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder defaultTtl(Optional<Duration> defaultTtl);

    /** Clears the value of defaultTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDefaultTtl() {
      return defaultTtl(Optional.empty());
    }

    /**
     * Setter for granularTtlConfig.
     *
     * <p>granularTtlConfig: Optional. The granular TTL configuration of the memories in the Memory
     * Bank.
     */
    @JsonProperty("granularTtlConfig")
    public abstract Builder granularTtlConfig(
        ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig granularTtlConfig);

    /**
     * Setter for granularTtlConfig builder.
     *
     * <p>granularTtlConfig: Optional. The granular TTL configuration of the memories in the Memory
     * Bank.
     */
    @CanIgnoreReturnValue
    public Builder granularTtlConfig(
        ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig.Builder
            granularTtlConfigBuilder) {
      return granularTtlConfig(granularTtlConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder granularTtlConfig(
        Optional<ReasoningEngineContextSpecMemoryBankConfigTtlConfigGranularTtlConfig>
            granularTtlConfig);

    /** Clears the value of granularTtlConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGranularTtlConfig() {
      return granularTtlConfig(Optional.empty());
    }

    /**
     * Setter for memoryRevisionDefaultTtl.
     *
     * <p>memoryRevisionDefaultTtl: Optional. The default TTL duration of the memory revisions in
     * the Memory Bank. This applies to all operations that create a memory revision. If not set, a
     * default TTL of 365 days will be used.
     */
    @JsonProperty("memoryRevisionDefaultTtl")
    public abstract Builder memoryRevisionDefaultTtl(Duration memoryRevisionDefaultTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memoryRevisionDefaultTtl(Optional<Duration> memoryRevisionDefaultTtl);

    /** Clears the value of memoryRevisionDefaultTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemoryRevisionDefaultTtl() {
      return memoryRevisionDefaultTtl(Optional.empty());
    }

    public abstract ReasoningEngineContextSpecMemoryBankConfigTtlConfig build();
  }

  /** Deserializes a JSON string to a ReasoningEngineContextSpecMemoryBankConfigTtlConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpecMemoryBankConfigTtlConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineContextSpecMemoryBankConfigTtlConfig.class);
  }
}
