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

/** The configuration for agent engine sub-resources to manage context. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineContextSpec.Builder.class)
public abstract class ReasoningEngineContextSpec extends JsonSerializable {
  /** Optional. Specification for a Memory Bank, which manages memories for the Agent Engine. */
  @JsonProperty("memoryBankConfig")
  public abstract Optional<ReasoningEngineContextSpecMemoryBankConfig> memoryBankConfig();

  /** Instantiates a builder for ReasoningEngineContextSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ReasoningEngineContextSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpec.Builder();
    }

    /**
     * Setter for memoryBankConfig.
     *
     * <p>memoryBankConfig: Optional. Specification for a Memory Bank, which manages memories for
     * the Agent Engine.
     */
    @JsonProperty("memoryBankConfig")
    public abstract Builder memoryBankConfig(
        ReasoningEngineContextSpecMemoryBankConfig memoryBankConfig);

    /**
     * Setter for memoryBankConfig builder.
     *
     * <p>memoryBankConfig: Optional. Specification for a Memory Bank, which manages memories for
     * the Agent Engine.
     */
    @CanIgnoreReturnValue
    public Builder memoryBankConfig(
        ReasoningEngineContextSpecMemoryBankConfig.Builder memoryBankConfigBuilder) {
      return memoryBankConfig(memoryBankConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memoryBankConfig(
        Optional<ReasoningEngineContextSpecMemoryBankConfig> memoryBankConfig);

    /** Clears the value of memoryBankConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemoryBankConfig() {
      return memoryBankConfig(Optional.empty());
    }

    public abstract ReasoningEngineContextSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineContextSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngineContextSpec.class);
  }
}
