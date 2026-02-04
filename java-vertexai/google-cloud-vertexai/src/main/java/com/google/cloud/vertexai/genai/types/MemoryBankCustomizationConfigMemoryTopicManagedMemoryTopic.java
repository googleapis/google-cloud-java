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

/** A managed memory topic defined by the system. */
@AutoValue
@JsonDeserialize(builder = MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.Builder.class)
public abstract class MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic
    extends JsonSerializable {
  /** Required. The managed topic. */
  @JsonProperty("managedTopicEnum")
  public abstract Optional<ManagedTopicEnum> managedTopicEnum();

  /** Instantiates a builder for MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.Builder();
    }

    /**
     * Setter for managedTopicEnum.
     *
     * <p>managedTopicEnum: Required. The managed topic.
     */
    @JsonProperty("managedTopicEnum")
    public abstract Builder managedTopicEnum(ManagedTopicEnum managedTopicEnum);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder managedTopicEnum(Optional<ManagedTopicEnum> managedTopicEnum);

    /** Clears the value of managedTopicEnum field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearManagedTopicEnum() {
      return managedTopicEnum(Optional.empty());
    }

    /**
     * Setter for managedTopicEnum given a known enum.
     *
     * <p>managedTopicEnum: Required. The managed topic.
     */
    @CanIgnoreReturnValue
    public Builder managedTopicEnum(ManagedTopicEnum.Known knownType) {
      return managedTopicEnum(new ManagedTopicEnum(knownType));
    }

    /**
     * Setter for managedTopicEnum given a string.
     *
     * <p>managedTopicEnum: Required. The managed topic.
     */
    @CanIgnoreReturnValue
    public Builder managedTopicEnum(String managedTopicEnum) {
      return managedTopicEnum(new ManagedTopicEnum(managedTopicEnum));
    }

    public abstract MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic build();
  }

  /**
   * Deserializes a JSON string to a MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic
   * object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, MemoryBankCustomizationConfigMemoryTopicManagedMemoryTopic.class);
  }
}
