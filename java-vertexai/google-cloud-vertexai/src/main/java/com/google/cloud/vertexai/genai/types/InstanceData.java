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

/** Instance data used to populate placeholders in a metric prompt template. */
@AutoValue
@JsonDeserialize(builder = InstanceData.Builder.class)
public abstract class InstanceData extends JsonSerializable {
  /** Text data. */
  @JsonProperty("text")
  public abstract Optional<String> text();

  /** List of Gemini content data. */
  @JsonProperty("contents")
  public abstract Optional<InstanceDataContents> contents();

  /** Instantiates a builder for InstanceData. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_InstanceData.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for InstanceData. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `InstanceData.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_InstanceData.Builder();
    }

    /**
     * Setter for text.
     *
     * <p>text: Text data.
     */
    @JsonProperty("text")
    public abstract Builder text(String text);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder text(Optional<String> text);

    /** Clears the value of text field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearText() {
      return text(Optional.empty());
    }

    /**
     * Setter for contents.
     *
     * <p>contents: List of Gemini content data.
     */
    @JsonProperty("contents")
    public abstract Builder contents(InstanceDataContents contents);

    /**
     * Setter for contents builder.
     *
     * <p>contents: List of Gemini content data.
     */
    @CanIgnoreReturnValue
    public Builder contents(InstanceDataContents.Builder contentsBuilder) {
      return contents(contentsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contents(Optional<InstanceDataContents> contents);

    /** Clears the value of contents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContents() {
      return contents(Optional.empty());
    }

    public abstract InstanceData build();
  }

  /** Deserializes a JSON string to a InstanceData object. */
  @ExcludeFromGeneratedCoverageReport
  public static InstanceData fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, InstanceData.class);
  }
}
