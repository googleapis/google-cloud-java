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

/** Optional settings for translation prompt. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecTranslationOption.Builder.class)
public abstract class SchemaPromptSpecTranslationOption extends JsonSerializable {
  /** How many shots to use. */
  @JsonProperty("numberOfShots")
  public abstract Optional<Integer> numberOfShots();

  /** Instantiates a builder for SchemaPromptSpecTranslationOption. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecTranslationOption.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecTranslationOption. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecTranslationOption.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecTranslationOption.Builder();
    }

    /**
     * Setter for numberOfShots.
     *
     * <p>numberOfShots: How many shots to use.
     */
    @JsonProperty("numberOfShots")
    public abstract Builder numberOfShots(Integer numberOfShots);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder numberOfShots(Optional<Integer> numberOfShots);

    /** Clears the value of numberOfShots field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNumberOfShots() {
      return numberOfShots(Optional.empty());
    }

    public abstract SchemaPromptSpecTranslationOption build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecTranslationOption object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecTranslationOption fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecTranslationOption.class);
  }
}
