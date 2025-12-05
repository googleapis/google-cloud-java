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

/** Represents the verdict of an evaluation against a single rubric. */
@AutoValue
@JsonDeserialize(builder = RubricVerdict.Builder.class)
public abstract class RubricVerdict extends JsonSerializable {
  /**
   * Required. The full rubric definition that was evaluated. Storing this ensures the verdict is
   * self-contained and understandable, especially if the original rubric definition changes or was
   * dynamically generated.
   */
  @JsonProperty("evaluatedRubric")
  public abstract Optional<Rubric> evaluatedRubric();

  /**
   * Required. Outcome of the evaluation against the rubric, represented as a boolean. `true`
   * indicates a "Pass", `false` indicates a "Fail".
   */
  @JsonProperty("verdict")
  public abstract Optional<Boolean> verdict();

  /**
   * Optional. Human-readable reasoning or explanation for the verdict. This can include specific
   * examples or details from the evaluated content that justify the given verdict.
   */
  @JsonProperty("reasoning")
  public abstract Optional<String> reasoning();

  /** Instantiates a builder for RubricVerdict. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricVerdict.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricVerdict. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricVerdict.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricVerdict.Builder();
    }

    /**
     * Setter for evaluatedRubric.
     *
     * <p>evaluatedRubric: Required. The full rubric definition that was evaluated. Storing this
     * ensures the verdict is self-contained and understandable, especially if the original rubric
     * definition changes or was dynamically generated.
     */
    @JsonProperty("evaluatedRubric")
    public abstract Builder evaluatedRubric(Rubric evaluatedRubric);

    /**
     * Setter for evaluatedRubric builder.
     *
     * <p>evaluatedRubric: Required. The full rubric definition that was evaluated. Storing this
     * ensures the verdict is self-contained and understandable, especially if the original rubric
     * definition changes or was dynamically generated.
     */
    @CanIgnoreReturnValue
    public Builder evaluatedRubric(Rubric.Builder evaluatedRubricBuilder) {
      return evaluatedRubric(evaluatedRubricBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluatedRubric(Optional<Rubric> evaluatedRubric);

    /** Clears the value of evaluatedRubric field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluatedRubric() {
      return evaluatedRubric(Optional.empty());
    }

    /**
     * Setter for verdict.
     *
     * <p>verdict: Required. Outcome of the evaluation against the rubric, represented as a boolean.
     * `true` indicates a "Pass", `false` indicates a "Fail".
     */
    @JsonProperty("verdict")
    public abstract Builder verdict(boolean verdict);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder verdict(Optional<Boolean> verdict);

    /** Clears the value of verdict field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVerdict() {
      return verdict(Optional.empty());
    }

    /**
     * Setter for reasoning.
     *
     * <p>reasoning: Optional. Human-readable reasoning or explanation for the verdict. This can
     * include specific examples or details from the evaluated content that justify the given
     * verdict.
     */
    @JsonProperty("reasoning")
    public abstract Builder reasoning(String reasoning);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reasoning(Optional<String> reasoning);

    /** Clears the value of reasoning field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReasoning() {
      return reasoning(Optional.empty());
    }

    public abstract RubricVerdict build();
  }

  /** Deserializes a JSON string to a RubricVerdict object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricVerdict fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricVerdict.class);
  }
}
