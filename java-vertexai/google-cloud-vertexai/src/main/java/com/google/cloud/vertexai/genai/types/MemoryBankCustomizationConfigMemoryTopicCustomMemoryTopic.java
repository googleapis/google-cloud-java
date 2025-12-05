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

/** A custom memory topic defined by the developer. */
@AutoValue
@JsonDeserialize(builder = MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.Builder.class)
public abstract class MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic
    extends JsonSerializable {
  /** Required. The label of the topic. */
  @JsonProperty("label")
  public abstract Optional<String> label();

  /**
   * Required. Description of the memory topic. This should explain what information should be
   * extracted for this topic.
   */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Instantiates a builder for MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.Builder();
    }

    /**
     * Setter for label.
     *
     * <p>label: Required. The label of the topic.
     */
    @JsonProperty("label")
    public abstract Builder label(String label);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder label(Optional<String> label);

    /** Clears the value of label field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabel() {
      return label(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: Required. Description of the memory topic. This should explain what
     * information should be extracted for this topic.
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    public abstract MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic build();
  }

  /**
   * Deserializes a JSON string to a MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic
   * object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, MemoryBankCustomizationConfigMemoryTopicCustomMemoryTopic.class);
  }
}
