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

/** The topic ID for a memory. */
@AutoValue
@JsonDeserialize(builder = MemoryTopicId.Builder.class)
public abstract class MemoryTopicId extends JsonSerializable {
  /** Optional. The custom memory topic label. */
  @JsonProperty("customMemoryTopicLabel")
  public abstract Optional<String> customMemoryTopicLabel();

  /** Optional. The managed memory topic. */
  @JsonProperty("managedMemoryTopic")
  public abstract Optional<ManagedTopicEnum> managedMemoryTopic();

  /** Instantiates a builder for MemoryTopicId. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryTopicId.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryTopicId. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MemoryTopicId.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryTopicId.Builder();
    }

    /**
     * Setter for customMemoryTopicLabel.
     *
     * <p>customMemoryTopicLabel: Optional. The custom memory topic label.
     */
    @JsonProperty("customMemoryTopicLabel")
    public abstract Builder customMemoryTopicLabel(String customMemoryTopicLabel);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customMemoryTopicLabel(Optional<String> customMemoryTopicLabel);

    /** Clears the value of customMemoryTopicLabel field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomMemoryTopicLabel() {
      return customMemoryTopicLabel(Optional.empty());
    }

    /**
     * Setter for managedMemoryTopic.
     *
     * <p>managedMemoryTopic: Optional. The managed memory topic.
     */
    @JsonProperty("managedMemoryTopic")
    public abstract Builder managedMemoryTopic(ManagedTopicEnum managedMemoryTopic);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder managedMemoryTopic(Optional<ManagedTopicEnum> managedMemoryTopic);

    /** Clears the value of managedMemoryTopic field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearManagedMemoryTopic() {
      return managedMemoryTopic(Optional.empty());
    }

    /**
     * Setter for managedMemoryTopic given a known enum.
     *
     * <p>managedMemoryTopic: Optional. The managed memory topic.
     */
    @CanIgnoreReturnValue
    public Builder managedMemoryTopic(ManagedTopicEnum.Known knownType) {
      return managedMemoryTopic(new ManagedTopicEnum(knownType));
    }

    /**
     * Setter for managedMemoryTopic given a string.
     *
     * <p>managedMemoryTopic: Optional. The managed memory topic.
     */
    @CanIgnoreReturnValue
    public Builder managedMemoryTopic(String managedMemoryTopic) {
      return managedMemoryTopic(new ManagedTopicEnum(managedMemoryTopic));
    }

    public abstract MemoryTopicId build();
  }

  /** Deserializes a JSON string to a MemoryTopicId object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryTopicId fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryTopicId.class);
  }
}
