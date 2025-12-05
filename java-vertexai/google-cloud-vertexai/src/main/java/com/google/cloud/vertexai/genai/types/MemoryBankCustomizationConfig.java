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

/** Configuration for organizing memories for a particular scope. */
@AutoValue
@JsonDeserialize(builder = MemoryBankCustomizationConfig.Builder.class)
public abstract class MemoryBankCustomizationConfig extends JsonSerializable {
  /**
   * Optional. The scope keys (i.e. 'user_id') for which to use this config. A request's scope must
   * include all of the provided keys for the config to be used (order does not matter). If empty,
   * then the config will be used for all requests that do not have a more specific config. Only one
   * default config is allowed per Memory Bank.
   */
  @JsonProperty("scopeKeys")
  public abstract Optional<List<String>> scopeKeys();

  /**
   * Optional. Topics of information that should be extracted from conversations and stored as
   * memories. If not set, then Memory Bank's default topics will be used.
   */
  @JsonProperty("memoryTopics")
  public abstract Optional<List<MemoryBankCustomizationConfigMemoryTopic>> memoryTopics();

  /** Optional. Examples of how to generate memories for a particular scope. */
  @JsonProperty("generateMemoriesExamples")
  public abstract Optional<List<MemoryBankCustomizationConfigGenerateMemoriesExample>>
      generateMemoriesExamples();

  /** Instantiates a builder for MemoryBankCustomizationConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `MemoryBankCustomizationConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfig.Builder();
    }

    /**
     * Setter for scopeKeys.
     *
     * <p>scopeKeys: Optional. The scope keys (i.e. 'user_id') for which to use this config. A
     * request's scope must include all of the provided keys for the config to be used (order does
     * not matter). If empty, then the config will be used for all requests that do not have a more
     * specific config. Only one default config is allowed per Memory Bank.
     */
    @JsonProperty("scopeKeys")
    public abstract Builder scopeKeys(List<String> scopeKeys);

    /**
     * Setter for scopeKeys.
     *
     * <p>scopeKeys: Optional. The scope keys (i.e. 'user_id') for which to use this config. A
     * request's scope must include all of the provided keys for the config to be used (order does
     * not matter). If empty, then the config will be used for all requests that do not have a more
     * specific config. Only one default config is allowed per Memory Bank.
     */
    @CanIgnoreReturnValue
    public Builder scopeKeys(String... scopeKeys) {
      return scopeKeys(Arrays.asList(scopeKeys));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder scopeKeys(Optional<List<String>> scopeKeys);

    /** Clears the value of scopeKeys field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScopeKeys() {
      return scopeKeys(Optional.empty());
    }

    /**
     * Setter for memoryTopics.
     *
     * <p>memoryTopics: Optional. Topics of information that should be extracted from conversations
     * and stored as memories. If not set, then Memory Bank's default topics will be used.
     */
    @JsonProperty("memoryTopics")
    public abstract Builder memoryTopics(
        List<MemoryBankCustomizationConfigMemoryTopic> memoryTopics);

    /**
     * Setter for memoryTopics.
     *
     * <p>memoryTopics: Optional. Topics of information that should be extracted from conversations
     * and stored as memories. If not set, then Memory Bank's default topics will be used.
     */
    @CanIgnoreReturnValue
    public Builder memoryTopics(MemoryBankCustomizationConfigMemoryTopic... memoryTopics) {
      return memoryTopics(Arrays.asList(memoryTopics));
    }

    /**
     * Setter for memoryTopics builder.
     *
     * <p>memoryTopics: Optional. Topics of information that should be extracted from conversations
     * and stored as memories. If not set, then Memory Bank's default topics will be used.
     */
    @CanIgnoreReturnValue
    public Builder memoryTopics(
        MemoryBankCustomizationConfigMemoryTopic.Builder... memoryTopicsBuilders) {
      return memoryTopics(
          Arrays.asList(memoryTopicsBuilders).stream()
              .map(MemoryBankCustomizationConfigMemoryTopic.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memoryTopics(
        Optional<List<MemoryBankCustomizationConfigMemoryTopic>> memoryTopics);

    /** Clears the value of memoryTopics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemoryTopics() {
      return memoryTopics(Optional.empty());
    }

    /**
     * Setter for generateMemoriesExamples.
     *
     * <p>generateMemoriesExamples: Optional. Examples of how to generate memories for a particular
     * scope.
     */
    @JsonProperty("generateMemoriesExamples")
    public abstract Builder generateMemoriesExamples(
        List<MemoryBankCustomizationConfigGenerateMemoriesExample> generateMemoriesExamples);

    /**
     * Setter for generateMemoriesExamples.
     *
     * <p>generateMemoriesExamples: Optional. Examples of how to generate memories for a particular
     * scope.
     */
    @CanIgnoreReturnValue
    public Builder generateMemoriesExamples(
        MemoryBankCustomizationConfigGenerateMemoriesExample... generateMemoriesExamples) {
      return generateMemoriesExamples(Arrays.asList(generateMemoriesExamples));
    }

    /**
     * Setter for generateMemoriesExamples builder.
     *
     * <p>generateMemoriesExamples: Optional. Examples of how to generate memories for a particular
     * scope.
     */
    @CanIgnoreReturnValue
    public Builder generateMemoriesExamples(
        MemoryBankCustomizationConfigGenerateMemoriesExample.Builder...
            generateMemoriesExamplesBuilders) {
      return generateMemoriesExamples(
          Arrays.asList(generateMemoriesExamplesBuilders).stream()
              .map(MemoryBankCustomizationConfigGenerateMemoriesExample.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generateMemoriesExamples(
        Optional<List<MemoryBankCustomizationConfigGenerateMemoriesExample>>
            generateMemoriesExamples);

    /** Clears the value of generateMemoriesExamples field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerateMemoriesExamples() {
      return generateMemoriesExamples(Optional.empty());
    }

    public abstract MemoryBankCustomizationConfig build();
  }

  /** Deserializes a JSON string to a MemoryBankCustomizationConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryBankCustomizationConfig.class);
  }
}
