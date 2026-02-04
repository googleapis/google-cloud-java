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
import com.google.genai.types.Content;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Map of placeholder in metric prompt template to contents of model input. */
@AutoValue
@JsonDeserialize(builder = ContentMapContents.Builder.class)
public abstract class ContentMapContents extends JsonSerializable {
  /** Contents of the model input. */
  @JsonProperty("contents")
  public abstract Optional<List<Content>> contents();

  /** Instantiates a builder for ContentMapContents. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ContentMapContents.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ContentMapContents. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ContentMapContents.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ContentMapContents.Builder();
    }

    /**
     * Setter for contents.
     *
     * <p>contents: Contents of the model input.
     */
    @JsonProperty("contents")
    public abstract Builder contents(List<Content> contents);

    /**
     * Setter for contents.
     *
     * <p>contents: Contents of the model input.
     */
    @CanIgnoreReturnValue
    public Builder contents(Content... contents) {
      return contents(Arrays.asList(contents));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contents(Optional<List<Content>> contents);

    /** Clears the value of contents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContents() {
      return contents(Optional.empty());
    }

    public abstract ContentMapContents build();
  }

  /** Deserializes a JSON string to a ContentMapContents object. */
  @ExcludeFromGeneratedCoverageReport
  public static ContentMapContents fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ContentMapContents.class);
  }
}
