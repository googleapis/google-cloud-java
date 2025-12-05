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

/** A conversation source for the example. This is similar to `DirectContentsSource`. */
@AutoValue
@JsonDeserialize(
    builder = MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource.Builder.class)
public abstract class MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource
    extends JsonSerializable {
  /** Optional. The input conversation events for the example. */
  @JsonProperty("events")
  public abstract Optional<
          List<MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent>>
      events();

  /**
   * Instantiates a builder for
   * MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource.
   */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource
        .Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource
          .Builder();
    }

    /**
     * Setter for events.
     *
     * <p>events: Optional. The input conversation events for the example.
     */
    @JsonProperty("events")
    public abstract Builder events(
        List<MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent> events);

    /**
     * Setter for events.
     *
     * <p>events: Optional. The input conversation events for the example.
     */
    @CanIgnoreReturnValue
    public Builder events(
        MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent... events) {
      return events(Arrays.asList(events));
    }

    /**
     * Setter for events builder.
     *
     * <p>events: Optional. The input conversation events for the example.
     */
    @CanIgnoreReturnValue
    public Builder events(
        MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent.Builder...
            eventsBuilders) {
      return events(
          Arrays.asList(eventsBuilders).stream()
              .map(
                  MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent
                          .Builder
                      ::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder events(
        Optional<List<MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSourceEvent>>
            events);

    /** Clears the value of events field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvents() {
      return events(Optional.empty());
    }

    public abstract MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource build();
  }

  /**
   * Deserializes a JSON string to a
   * MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, MemoryBankCustomizationConfigGenerateMemoriesExampleConversationSource.class);
  }
}
