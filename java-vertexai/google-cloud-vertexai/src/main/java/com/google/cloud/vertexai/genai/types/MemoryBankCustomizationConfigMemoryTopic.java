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

/** A topic of information that should be extracted from conversations and stored as memories. */
@AutoValue
@JsonDeserialize(builder = MemoryBankCustomizationConfigMemoryTopic.Builder.class)
public abstract class MemoryBankCustomizationConfigMemoryTopic extends JsonSerializable {
  /** A custom memory topic defined by the developer. */
  @JsonProperty("customMemoryTopic")
  public abstract Optional<MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic>
      customMemoryTopic();

  /** A managed memory topic defined by Memory Bank. */
  @JsonProperty("managedMemoryTopic")
  public abstract Optional<MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic>
      managedMemoryTopic();

  /** Instantiates a builder for MemoryBankCustomizationConfigMemoryTopic. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfigMemoryTopic.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfigMemoryTopic. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `MemoryBankCustomizationConfigMemoryTopic.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfigMemoryTopic.Builder();
    }

    /**
     * Setter for customMemoryTopic.
     *
     * <p>customMemoryTopic: A custom memory topic defined by the developer.
     */
    @JsonProperty("customMemoryTopic")
    public abstract Builder customMemoryTopic(
        MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic customMemoryTopic);

    /**
     * Setter for customMemoryTopic builder.
     *
     * <p>customMemoryTopic: A custom memory topic defined by the developer.
     */
    @CanIgnoreReturnValue
    public Builder customMemoryTopic(
        MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.Builder
            customMemoryTopicBuilder) {
      return customMemoryTopic(customMemoryTopicBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customMemoryTopic(
        Optional<MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic> customMemoryTopic);

    /** Clears the value of customMemoryTopic field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomMemoryTopic() {
      return customMemoryTopic(Optional.empty());
    }

    /**
     * Setter for managedMemoryTopic.
     *
     * <p>managedMemoryTopic: A managed memory topic defined by Memory Bank.
     */
    @JsonProperty("managedMemoryTopic")
    public abstract Builder managedMemoryTopic(
        MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic managedMemoryTopic);

    /**
     * Setter for managedMemoryTopic builder.
     *
     * <p>managedMemoryTopic: A managed memory topic defined by Memory Bank.
     */
    @CanIgnoreReturnValue
    public Builder managedMemoryTopic(
        MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.Builder
            managedMemoryTopicBuilder) {
      return managedMemoryTopic(managedMemoryTopicBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder managedMemoryTopic(
        Optional<MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic> managedMemoryTopic);

    /** Clears the value of managedMemoryTopic field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearManagedMemoryTopic() {
      return managedMemoryTopic(Optional.empty());
    }

    public abstract MemoryBankCustomizationConfigMemoryTopic build();
  }

  /** Deserializes a JSON string to a MemoryBankCustomizationConfigMemoryTopic object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfigMemoryTopic fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, MemoryBankCustomizationConfigMemoryTopic.class);
  }
}
