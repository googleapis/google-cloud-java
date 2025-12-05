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

/** A list of reference sentence pairs. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecReferenceSentencePairList.Builder.class)
public abstract class SchemaPromptSpecReferenceSentencePairList extends JsonSerializable {
  /** Reference sentence pairs. */
  @JsonProperty("referenceSentencePairs")
  public abstract Optional<List<SchemaPromptSpecReferenceSentencePair>> referenceSentencePairs();

  /** Instantiates a builder for SchemaPromptSpecReferenceSentencePairList. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecReferenceSentencePairList.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecReferenceSentencePairList. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecReferenceSentencePairList.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecReferenceSentencePairList.Builder();
    }

    /**
     * Setter for referenceSentencePairs.
     *
     * <p>referenceSentencePairs: Reference sentence pairs.
     */
    @JsonProperty("referenceSentencePairs")
    public abstract Builder referenceSentencePairs(
        List<SchemaPromptSpecReferenceSentencePair> referenceSentencePairs);

    /**
     * Setter for referenceSentencePairs.
     *
     * <p>referenceSentencePairs: Reference sentence pairs.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencePairs(
        SchemaPromptSpecReferenceSentencePair... referenceSentencePairs) {
      return referenceSentencePairs(Arrays.asList(referenceSentencePairs));
    }

    /**
     * Setter for referenceSentencePairs builder.
     *
     * <p>referenceSentencePairs: Reference sentence pairs.
     */
    @CanIgnoreReturnValue
    public Builder referenceSentencePairs(
        SchemaPromptSpecReferenceSentencePair.Builder... referenceSentencePairsBuilders) {
      return referenceSentencePairs(
          Arrays.asList(referenceSentencePairsBuilders).stream()
              .map(SchemaPromptSpecReferenceSentencePair.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder referenceSentencePairs(
        Optional<List<SchemaPromptSpecReferenceSentencePair>> referenceSentencePairs);

    /** Clears the value of referenceSentencePairs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReferenceSentencePairs() {
      return referenceSentencePairs(Optional.empty());
    }

    public abstract SchemaPromptSpecReferenceSentencePairList build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecReferenceSentencePairList object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecReferenceSentencePairList fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaPromptSpecReferenceSentencePairList.class);
  }
}
