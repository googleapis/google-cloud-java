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

/** The translation example that contains reference sentences from various sources. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecTranslationExample.Builder.class)
public abstract class SchemaPromptSpecTranslationExample extends JsonSerializable {
  /** The reference sentences from inline text. */
  @JsonProperty("referenceSentencePairLists")
  public abstract Optional<List<SchemaPromptSpecReferenceSentencePairList>>
      referenceSentencePairLists();

  /** The reference sentences from file. */
  @JsonProperty("referenceSentencesFileInputs")
  public abstract Optional<List<SchemaPromptSpecTranslationSentenceFileInput>>
      referenceSentencesFileInputs();

  /** Instantiates a builder for SchemaPromptSpecTranslationExample. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecTranslationExample.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecTranslationExample. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecTranslationExample.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecTranslationExample.Builder();
    }

    /**
     * Setter for referenceSentencePairLists.
     *
     * <p>referenceSentencePairLists: The reference sentences from inline text.
     */
    @JsonProperty("referenceSentencePairLists")
    public abstract Builder referenceSentencePairLists(
        List<SchemaPromptSpecReferenceSentencePairList> referenceSentencePairLists);

    /**
     * Setter for referenceSentencePairLists.
     *
     * <p>referenceSentencePairLists: The reference sentences from inline text.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencePairLists(
        SchemaPromptSpecReferenceSentencePairList... referenceSentencePairLists) {
      return referenceSentencePairLists(Arrays.asList(referenceSentencePairLists));
    }

    /**
     * Setter for referenceSentencePairLists builder.
     *
     * <p>referenceSentencePairLists: The reference sentences from inline text.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencePairLists(
        SchemaPromptSpecReferenceSentencePairList.Builder... referenceSentencePairListsBuilders) {
      return referenceSentencePairLists(
          Arrays.asList(referenceSentencePairListsBuilders).stream()
              .map(SchemaPromptSpecReferenceSentencePairList.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder referenceSentencePairLists(
        Optional<List<SchemaPromptSpecReferenceSentencePairList>> referenceSentencePairLists);

    /** Clears the value of referenceSentencePairLists field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReferenceSentencePairLists() {
      return referenceSentencePairLists(Optional.empty());
    }

    /**
     * Setter for referenceSentencesFileInputs.
     *
     * <p>referenceSentencesFileInputs: The reference sentences from file.
     */
    @JsonProperty("referenceSentencesFileInputs")
    public abstract Builder referenceSentencesFileInputs(
        List<SchemaPromptSpecTranslationSentenceFileInput> referenceSentencesFileInputs);

    /**
     * Setter for referenceSentencesFileInputs.
     *
     * <p>referenceSentencesFileInputs: The reference sentences from file.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencesFileInputs(
        SchemaPromptSpecTranslationSentenceFileInput... referenceSentencesFileInputs) {
      return referenceSentencesFileInputs(Arrays.asList(referenceSentencesFileInputs));
    }

    /**
     * Setter for referenceSentencesFileInputs builder.
     *
     * <p>referenceSentencesFileInputs: The reference sentences from file.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencesFileInputs(
        SchemaPromptSpecTranslationSentenceFileInput.Builder...
            referenceSentencesFileInputsBuilders) {
      return referenceSentencesFileInputs(
          Arrays.asList(referenceSentencesFileInputsBuilders).stream()
              .map(SchemaPromptSpecTranslationSentenceFileInput.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder referenceSentencesFileInputs(
        Optional<List<SchemaPromptSpecTranslationSentenceFileInput>> referenceSentencesFileInputs);

    /** Clears the value of referenceSentencesFileInputs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReferenceSentencesFileInputs() {
      return referenceSentencesFileInputs(Optional.empty());
    }

    public abstract SchemaPromptSpecTranslationExample build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecTranslationExample object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecTranslationExample fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecTranslationExample.class);
  }
}
