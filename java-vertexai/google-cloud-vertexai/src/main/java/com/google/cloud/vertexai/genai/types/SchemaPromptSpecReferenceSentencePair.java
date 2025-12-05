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

/** A pair of sentences used as reference in source and target languages. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecReferenceSentencePair.Builder.class)
public abstract class SchemaPromptSpecReferenceSentencePair extends JsonSerializable {
  /** Source sentence in the sentence pair. */
  @JsonProperty("sourceSentence")
  public abstract Optional<String> sourceSentence();

  /** Target sentence in the sentence pair. */
  @JsonProperty("targetSentence")
  public abstract Optional<String> targetSentence();

  /** Instantiates a builder for SchemaPromptSpecReferenceSentencePair. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecReferenceSentencePair.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecReferenceSentencePair. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecReferenceSentencePair.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecReferenceSentencePair.Builder();
    }

    /**
     * Setter for sourceSentence.
     *
     * <p>sourceSentence: Source sentence in the sentence pair.
     */
    @JsonProperty("sourceSentence")
    public abstract Builder sourceSentence(String sourceSentence);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sourceSentence(Optional<String> sourceSentence);

    /** Clears the value of sourceSentence field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSourceSentence() {
      return sourceSentence(Optional.empty());
    }

    /**
     * Setter for targetSentence.
     *
     * <p>targetSentence: Target sentence in the sentence pair.
     */
    @JsonProperty("targetSentence")
    public abstract Builder targetSentence(String targetSentence);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder targetSentence(Optional<String> targetSentence);

    /** Clears the value of targetSentence field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTargetSentence() {
      return targetSentence(Optional.empty());
    }

    public abstract SchemaPromptSpecReferenceSentencePair build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecReferenceSentencePair object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecReferenceSentencePair fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecReferenceSentencePair.class);
  }
}
