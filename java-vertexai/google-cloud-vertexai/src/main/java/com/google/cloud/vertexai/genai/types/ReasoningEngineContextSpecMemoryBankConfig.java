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

/** Specification for a Memory Bank. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineContextSpecMemoryBankConfig.Builder.class)
public abstract class ReasoningEngineContextSpecMemoryBankConfig extends JsonSerializable {
  /** Optional. Configuration for how to customize Memory Bank behavior for a particular scope. */
  @JsonProperty("customizationConfigs")
  public abstract Optional<List<MemoryBankCustomizationConfig>> customizationConfigs();

  /** Optional. Configuration for how to generate memories for the Memory Bank. */
  @JsonProperty("generationConfig")
  public abstract Optional<ReasoningEngineContextSpecMemoryBankConfigGenerationConfig>
      generationConfig();

  /**
   * Optional. Configuration for how to perform similarity search on memories. If not set, the
   * Memory Bank will use the default embedding model `text-embedding-005`.
   */
  @JsonProperty("similaritySearchConfig")
  public abstract Optional<ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig>
      similaritySearchConfig();

  /**
   * Optional. Configuration for automatic TTL ("time-to-live") of the memories in the Memory Bank.
   * If not set, TTL will not be applied automatically. The TTL can be explicitly set by modifying
   * the `expire_time` of each Memory resource.
   */
  @JsonProperty("ttlConfig")
  public abstract Optional<ReasoningEngineContextSpecMemoryBankConfigTtlConfig> ttlConfig();

  /** If true, no memory revisions will be created for any requests to the Memory Bank. */
  @JsonProperty("disableMemoryRevisions")
  public abstract Optional<Boolean> disableMemoryRevisions();

  /** Instantiates a builder for ReasoningEngineContextSpecMemoryBankConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineContextSpecMemoryBankConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineContextSpecMemoryBankConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineContextSpecMemoryBankConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineContextSpecMemoryBankConfig.Builder();
    }

    /**
     * Setter for customizationConfigs.
     *
     * <p>customizationConfigs: Optional. Configuration for how to customize Memory Bank behavior
     * for a particular scope.
     */
    @JsonProperty("customizationConfigs")
    public abstract Builder customizationConfigs(
        List<MemoryBankCustomizationConfig> customizationConfigs);

    /**
     * Setter for customizationConfigs.
     *
     * <p>customizationConfigs: Optional. Configuration for how to customize Memory Bank behavior
     * for a particular scope.
     */
    @CanIgnoreReturnValue
    public Builder customizationConfigs(MemoryBankCustomizationConfig... customizationConfigs) {
      return customizationConfigs(Arrays.asList(customizationConfigs));
    }

    /**
     * Setter for customizationConfigs builder.
     *
     * <p>customizationConfigs: Optional. Configuration for how to customize Memory Bank behavior
     * for a particular scope.
     */
    @CanIgnoreReturnValue
    public Builder customizationConfigs(
        MemoryBankCustomizationConfig.Builder... customizationConfigsBuilders) {
      return customizationConfigs(
          Arrays.asList(customizationConfigsBuilders).stream()
              .map(MemoryBankCustomizationConfig.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customizationConfigs(
        Optional<List<MemoryBankCustomizationConfig>> customizationConfigs);

    /** Clears the value of customizationConfigs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomizationConfigs() {
      return customizationConfigs(Optional.empty());
    }

    /**
     * Setter for generationConfig.
     *
     * <p>generationConfig: Optional. Configuration for how to generate memories for the Memory
     * Bank.
     */
    @JsonProperty("generationConfig")
    public abstract Builder generationConfig(
        ReasoningEngineContextSpecMemoryBankConfigGenerationConfig generationConfig);

    /**
     * Setter for generationConfig builder.
     *
     * <p>generationConfig: Optional. Configuration for how to generate memories for the Memory
     * Bank.
     */
    @CanIgnoreReturnValue
    public Builder generationConfig(
        ReasoningEngineContextSpecMemoryBankConfigGenerationConfig.Builder
            generationConfigBuilder) {
      return generationConfig(generationConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generationConfig(
        Optional<ReasoningEngineContextSpecMemoryBankConfigGenerationConfig> generationConfig);

    /** Clears the value of generationConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerationConfig() {
      return generationConfig(Optional.empty());
    }

    /**
     * Setter for similaritySearchConfig.
     *
     * <p>similaritySearchConfig: Optional. Configuration for how to perform similarity search on
     * memories. If not set, the Memory Bank will use the default embedding model
     * `text-embedding-005`.
     */
    @JsonProperty("similaritySearchConfig")
    public abstract Builder similaritySearchConfig(
        ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig similaritySearchConfig);

    /**
     * Setter for similaritySearchConfig builder.
     *
     * <p>similaritySearchConfig: Optional. Configuration for how to perform similarity search on
     * memories. If not set, the Memory Bank will use the default embedding model
     * `text-embedding-005`.
     */
    @CanIgnoreReturnValue
    public Builder similaritySearchConfig(
        ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig.Builder
            similaritySearchConfigBuilder) {
      return similaritySearchConfig(similaritySearchConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder similaritySearchConfig(
        Optional<ReasoningEngineContextSpecMemoryBankConfigSimilaritySearchConfig>
            similaritySearchConfig);

    /** Clears the value of similaritySearchConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSimilaritySearchConfig() {
      return similaritySearchConfig(Optional.empty());
    }

    /**
     * Setter for ttlConfig.
     *
     * <p>ttlConfig: Optional. Configuration for automatic TTL ("time-to-live") of the memories in
     * the Memory Bank. If not set, TTL will not be applied automatically. The TTL can be explicitly
     * set by modifying the `expire_time` of each Memory resource.
     */
    @JsonProperty("ttlConfig")
    public abstract Builder ttlConfig(
        ReasoningEngineContextSpecMemoryBankConfigTtlConfig ttlConfig);

    /**
     * Setter for ttlConfig builder.
     *
     * <p>ttlConfig: Optional. Configuration for automatic TTL ("time-to-live") of the memories in
     * the Memory Bank. If not set, TTL will not be applied automatically. The TTL can be explicitly
     * set by modifying the `expire_time` of each Memory resource.
     */
    @CanIgnoreReturnValue
    public Builder ttlConfig(
        ReasoningEngineContextSpecMemoryBankConfigTtlConfig.Builder ttlConfigBuilder) {
      return ttlConfig(ttlConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder ttlConfig(
        Optional<ReasoningEngineContextSpecMemoryBankConfigTtlConfig> ttlConfig);

    /** Clears the value of ttlConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTtlConfig() {
      return ttlConfig(Optional.empty());
    }

    /**
     * Setter for disableMemoryRevisions.
     *
     * <p>disableMemoryRevisions: If true, no memory revisions will be created for any requests to
     * the Memory Bank.
     */
    @JsonProperty("disableMemoryRevisions")
    public abstract Builder disableMemoryRevisions(boolean disableMemoryRevisions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder disableMemoryRevisions(Optional<Boolean> disableMemoryRevisions);

    /** Clears the value of disableMemoryRevisions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisableMemoryRevisions() {
      return disableMemoryRevisions(Optional.empty());
    }

    public abstract ReasoningEngineContextSpecMemoryBankConfig build();
  }

  /** Deserializes a JSON string to a ReasoningEngineContextSpecMemoryBankConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineContextSpecMemoryBankConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineContextSpecMemoryBankConfig.class);
  }
}
