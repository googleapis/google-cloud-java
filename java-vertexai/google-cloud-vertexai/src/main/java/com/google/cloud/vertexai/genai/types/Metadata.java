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
import java.util.Map;
import java.util.Optional;

/** Metadata for a chunk. */
@AutoValue
@JsonDeserialize(builder = Metadata.Builder.class)
public abstract class Metadata extends JsonSerializable {
  /**
   * Optional. Attributes attached to the data. The keys have semantic conventions and the consumers
   * of the attributes should know how to deserialize the value bytes based on the keys.
   */
  @JsonProperty("attributes")
  public abstract Optional<Map<String, byte[]>> attributes();

  /** Instantiates a builder for Metadata. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Metadata.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Metadata. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Metadata.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Metadata.Builder();
    }

    /**
     * Setter for attributes.
     *
     * <p>attributes: Optional. Attributes attached to the data. The keys have semantic conventions
     * and the consumers of the attributes should know how to deserialize the value bytes based on
     * the keys.
     */
    @JsonProperty("attributes")
    public abstract Builder attributes(Map<String, byte[]> attributes);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder attributes(Optional<Map<String, byte[]>> attributes);

    /** Clears the value of attributes field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAttributes() {
      return attributes(Optional.empty());
    }

    public abstract Metadata build();
  }

  /** Deserializes a JSON string to a Metadata object. */
  @ExcludeFromGeneratedCoverageReport
  public static Metadata fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Metadata.class);
  }
}
