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

/**
 * Message representing a single testable criterion for evaluation.
 *
 * <p>One input prompt could have multiple rubrics.
 */
@AutoValue
@JsonDeserialize(builder = Rubric.Builder.class)
public abstract class Rubric extends JsonSerializable {
  /**
   * Required. Unique identifier for the rubric. This ID is used to refer to this rubric, e.g., in
   * RubricVerdict.
   */
  @JsonProperty("rubricId")
  public abstract Optional<String> rubricId();

  /** Required. The actual testable criteria for the rubric. */
  @JsonProperty("content")
  public abstract Optional<RubricContent> content();

  /**
   * Optional. A type designator for the rubric, which can inform how it's evaluated or interpreted
   * by systems or users. It's recommended to use consistent, well-defined, upper snake_case
   * strings. Examples: "SUMMARIZATION_QUALITY", "SAFETY_HARMFUL_CONTENT", "INSTRUCTION_ADHERENCE".
   */
  @JsonProperty("type")
  public abstract Optional<String> type();

  /** Optional. The relative importance of this rubric. */
  @JsonProperty("importance")
  public abstract Optional<Importance> importance();

  /** Instantiates a builder for Rubric. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Rubric.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Rubric. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Rubric.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Rubric.Builder();
    }

    /**
     * Setter for rubricId.
     *
     * <p>rubricId: Required. Unique identifier for the rubric. This ID is used to refer to this
     * rubric, e.g., in RubricVerdict.
     */
    @JsonProperty("rubricId")
    public abstract Builder rubricId(String rubricId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricId(Optional<String> rubricId);

    /** Clears the value of rubricId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricId() {
      return rubricId(Optional.empty());
    }

    /**
     * Setter for content.
     *
     * <p>content: Required. The actual testable criteria for the rubric.
     */
    @JsonProperty("content")
    public abstract Builder content(RubricContent content);

    /**
     * Setter for content builder.
     *
     * <p>content: Required. The actual testable criteria for the rubric.
     */
    @CanIgnoreReturnValue
    public Builder content(RubricContent.Builder contentBuilder) {
      return content(contentBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder content(Optional<RubricContent> content);

    /** Clears the value of content field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContent() {
      return content(Optional.empty());
    }

    /**
     * Setter for type.
     *
     * <p>type: Optional. A type designator for the rubric, which can inform how it's evaluated or
     * interpreted by systems or users. It's recommended to use consistent, well-defined, upper
     * snake_case strings. Examples: "SUMMARIZATION_QUALITY", "SAFETY_HARMFUL_CONTENT",
     * "INSTRUCTION_ADHERENCE".
     */
    @JsonProperty("type")
    public abstract Builder type(String type);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder type(Optional<String> type);

    /** Clears the value of type field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearType() {
      return type(Optional.empty());
    }

    /**
     * Setter for importance.
     *
     * <p>importance: Optional. The relative importance of this rubric.
     */
    @JsonProperty("importance")
    public abstract Builder importance(Importance importance);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder importance(Optional<Importance> importance);

    /** Clears the value of importance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearImportance() {
      return importance(Optional.empty());
    }

    /**
     * Setter for importance given a known enum.
     *
     * <p>importance: Optional. The relative importance of this rubric.
     */
    @CanIgnoreReturnValue
    public Builder importance(Importance.Known knownType) {
      return importance(new Importance(knownType));
    }

    /**
     * Setter for importance given a string.
     *
     * <p>importance: Optional. The relative importance of this rubric.
     */
    @CanIgnoreReturnValue
    public Builder importance(String importance) {
      return importance(new Importance(importance));
    }

    public abstract Rubric build();
  }

  /** Deserializes a JSON string to a Rubric object. */
  @ExcludeFromGeneratedCoverageReport
  public static Rubric fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Rubric.class);
  }
}
