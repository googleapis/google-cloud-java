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

/** */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecTranslationFileInputSource.Builder.class)
public abstract class SchemaPromptSpecTranslationFileInputSource extends JsonSerializable {
  /** The file's contents. */
  @JsonProperty("content")
  public abstract Optional<String> content();

  /** The file's display name. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The file's mime type. */
  @JsonProperty("mimeType")
  public abstract Optional<String> mimeType();

  /** Instantiates a builder for SchemaPromptSpecTranslationFileInputSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecTranslationFileInputSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecTranslationFileInputSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecTranslationFileInputSource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecTranslationFileInputSource.Builder();
    }

    /**
     * Setter for content.
     *
     * <p>content: The file's contents.
     */
    @JsonProperty("content")
    public abstract Builder content(String content);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder content(Optional<String> content);

    /** Clears the value of content field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContent() {
      return content(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: The file's display name.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for mimeType.
     *
     * <p>mimeType: The file's mime type.
     */
    @JsonProperty("mimeType")
    public abstract Builder mimeType(String mimeType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder mimeType(Optional<String> mimeType);

    /** Clears the value of mimeType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMimeType() {
      return mimeType(Optional.empty());
    }

    public abstract SchemaPromptSpecTranslationFileInputSource build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecTranslationFileInputSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecTranslationFileInputSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaPromptSpecTranslationFileInputSource.class);
  }
}
