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
@JsonDeserialize(builder = SchemaPromptSpecTranslationSentenceFileInput.Builder.class)
public abstract class SchemaPromptSpecTranslationSentenceFileInput extends JsonSerializable {
  /** Inlined file source. */
  @JsonProperty("fileInputSource")
  public abstract Optional<SchemaPromptSpecTranslationFileInputSource> fileInputSource();

  /** Cloud Storage file source. */
  @JsonProperty("gcsInputSource")
  public abstract Optional<SchemaPromptSpecTranslationGcsInputSource> gcsInputSource();

  /** Instantiates a builder for SchemaPromptSpecTranslationSentenceFileInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecTranslationSentenceFileInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecTranslationSentenceFileInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecTranslationSentenceFileInput.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecTranslationSentenceFileInput.Builder();
    }

    /**
     * Setter for fileInputSource.
     *
     * <p>fileInputSource: Inlined file source.
     */
    @JsonProperty("fileInputSource")
    public abstract Builder fileInputSource(
        SchemaPromptSpecTranslationFileInputSource fileInputSource);

    /**
     * Setter for fileInputSource builder.
     *
     * <p>fileInputSource: Inlined file source.
     */
    @CanIgnoreReturnValue
    public Builder fileInputSource(
        SchemaPromptSpecTranslationFileInputSource.Builder fileInputSourceBuilder) {
      return fileInputSource(fileInputSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder fileInputSource(
        Optional<SchemaPromptSpecTranslationFileInputSource> fileInputSource);

    /** Clears the value of fileInputSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFileInputSource() {
      return fileInputSource(Optional.empty());
    }

    /**
     * Setter for gcsInputSource.
     *
     * <p>gcsInputSource: Cloud Storage file source.
     */
    @JsonProperty("gcsInputSource")
    public abstract Builder gcsInputSource(
        SchemaPromptSpecTranslationGcsInputSource gcsInputSource);

    /**
     * Setter for gcsInputSource builder.
     *
     * <p>gcsInputSource: Cloud Storage file source.
     */
    @CanIgnoreReturnValue
    public Builder gcsInputSource(
        SchemaPromptSpecTranslationGcsInputSource.Builder gcsInputSourceBuilder) {
      return gcsInputSource(gcsInputSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsInputSource(
        Optional<SchemaPromptSpecTranslationGcsInputSource> gcsInputSource);

    /** Clears the value of gcsInputSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsInputSource() {
      return gcsInputSource(Optional.empty());
    }

    public abstract SchemaPromptSpecTranslationSentenceFileInput build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecTranslationSentenceFileInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecTranslationSentenceFileInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaPromptSpecTranslationSentenceFileInput.class);
  }
}
