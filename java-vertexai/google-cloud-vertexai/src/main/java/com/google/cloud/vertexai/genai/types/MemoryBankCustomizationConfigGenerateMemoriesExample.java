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

/** An example of how to generate memories for a particular scope. */
@AutoValue
@JsonDeserialize(builder = MemoryBankCustomizationConfigGenerateMemoriesExample.Builder.class)
public abstract class MemoryBankCustomizationConfigGenerateMemoriesExample
    extends JsonSerializable {
  /** A conversation source for the example. */
  @JsonProperty("conversationSource")
  public abstract Optional<MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource>
      conversationSource();

  /**
   * Optional. The memories that are expected to be generated from the input conversation. An empty
   * list indicates that no memories are expected to be generated for the input conversation.
   */
  @JsonProperty("generatedMemories")
  public abstract Optional<
          List<MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory>>
      generatedMemories();

  /** Instantiates a builder for MemoryBankCustomizationConfigGenerateMemoriesExample. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfigGenerateMemoriesExample.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfigGenerateMemoriesExample. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `MemoryBankCustomizationConfigGenerateMemoriesExample.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfigGenerateMemoriesExample.Builder();
    }

    /**
     * Setter for conversationSource.
     *
     * <p>conversationSource: A conversation source for the example.
     */
    @JsonProperty("conversationSource")
    public abstract Builder conversationSource(
        MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource conversationSource);

    /**
     * Setter for conversationSource builder.
     *
     * <p>conversationSource: A conversation source for the example.
     */
    @CanIgnoreReturnValue
    public Builder conversationSource(
        MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource.Builder
            conversationSourceBuilder) {
      return conversationSource(conversationSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder conversationSource(
        Optional<MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource>
            conversationSource);

    /** Clears the value of conversationSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConversationSource() {
      return conversationSource(Optional.empty());
    }

    /**
     * Setter for generatedMemories.
     *
     * <p>generatedMemories: Optional. The memories that are expected to be generated from the input
     * conversation. An empty list indicates that no memories are expected to be generated for the
     * input conversation.
     */
    @JsonProperty("generatedMemories")
    public abstract Builder generatedMemories(
        List<MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory>
            generatedMemories);

    /**
     * Setter for generatedMemories.
     *
     * <p>generatedMemories: Optional. The memories that are expected to be generated from the input
     * conversation. An empty list indicates that no memories are expected to be generated for the
     * input conversation.
     */
    @CanIgnoreReturnValue
    public Builder generatedMemories(
        MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory... generatedMemories) {
      return generatedMemories(Arrays.asList(generatedMemories));
    }

    /**
     * Setter for generatedMemories builder.
     *
     * <p>generatedMemories: Optional. The memories that are expected to be generated from the input
     * conversation. An empty list indicates that no memories are expected to be generated for the
     * input conversation.
     */
    @CanIgnoreReturnValue
    public Builder generatedMemories(
        MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory.Builder...
            generatedMemoriesBuilders) {
      return generatedMemories(
          Arrays.asList(generatedMemoriesBuilders).stream()
              .map(
                  MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory.Builder
                      ::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generatedMemories(
        Optional<List<MemoryBankCustomizationConfigGenerateMemoriesExampleGeneratedMemory>>
            generatedMemories);

    /** Clears the value of generatedMemories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGeneratedMemories() {
      return generatedMemories(Optional.empty());
    }

    public abstract MemoryBankCustomizationConfigGenerateMemoriesExample build();
  }

  /**
   * Deserializes a JSON string to a MemoryBankCustomizationConfigGenerateMemoriesExample object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfigGenerateMemoriesExample fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, MemoryBankCustomizationConfigGenerateMemoriesExample.class);
  }
}
