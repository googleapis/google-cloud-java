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
import com.google.genai.types.AutoraterConfig;
import java.util.Optional;

/** Specification for an LLM based metric. */
@AutoValue
@JsonDeserialize(builder = LLMBasedMetricSpec.Builder.class)
public abstract class LLMBasedMetricSpec extends JsonSerializable {
  /** Template for the prompt sent to the judge model. */
  @JsonProperty("metricPromptTemplate")
  public abstract Optional<String> metricPromptTemplate();

  /** System instruction for the judge model. */
  @JsonProperty("systemInstruction")
  public abstract Optional<String> systemInstruction();

  /** Optional configuration for the judge LLM (Autorater). */
  @JsonProperty("judgeAutoraterConfig")
  public abstract Optional<AutoraterConfig> judgeAutoraterConfig();

  /**
   * Use a pre-defined group of rubrics associated with the input. Refers to a key in the
   * rubric_groups map of EvaluationInstance.
   */
  @JsonProperty("rubricGroupKey")
  public abstract Optional<String> rubricGroupKey();

  /** Dynamically generate rubrics using a predefined spec. */
  @JsonProperty("predefinedRubricGenerationSpec")
  public abstract Optional<PredefinedMetricSpec> predefinedRubricGenerationSpec();

  /** Dynamically generate rubrics using this specification. */
  @JsonProperty("rubricGenerationSpec")
  public abstract Optional<RubricGenerationSpec> rubricGenerationSpec();

  /** Instantiates a builder for LLMBasedMetricSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_LLMBasedMetricSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for LLMBasedMetricSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `LLMBasedMetricSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_LLMBasedMetricSpec.Builder();
    }

    /**
     * Setter for metricPromptTemplate.
     *
     * <p>metricPromptTemplate: Template for the prompt sent to the judge model.
     */
    @JsonProperty("metricPromptTemplate")
    public abstract Builder metricPromptTemplate(String metricPromptTemplate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricPromptTemplate(Optional<String> metricPromptTemplate);

    /** Clears the value of metricPromptTemplate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricPromptTemplate() {
      return metricPromptTemplate(Optional.empty());
    }

    /**
     * Setter for systemInstruction.
     *
     * <p>systemInstruction: System instruction for the judge model.
     */
    @JsonProperty("systemInstruction")
    public abstract Builder systemInstruction(String systemInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder systemInstruction(Optional<String> systemInstruction);

    /** Clears the value of systemInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSystemInstruction() {
      return systemInstruction(Optional.empty());
    }

    /**
     * Setter for judgeAutoraterConfig.
     *
     * <p>judgeAutoraterConfig: Optional configuration for the judge LLM (Autorater).
     */
    @JsonProperty("judgeAutoraterConfig")
    public abstract Builder judgeAutoraterConfig(AutoraterConfig judgeAutoraterConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder judgeAutoraterConfig(Optional<AutoraterConfig> judgeAutoraterConfig);

    /** Clears the value of judgeAutoraterConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJudgeAutoraterConfig() {
      return judgeAutoraterConfig(Optional.empty());
    }

    /**
     * Setter for rubricGroupKey.
     *
     * <p>rubricGroupKey: Use a pre-defined group of rubrics associated with the input. Refers to a
     * key in the rubric_groups map of EvaluationInstance.
     */
    @JsonProperty("rubricGroupKey")
    public abstract Builder rubricGroupKey(String rubricGroupKey);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricGroupKey(Optional<String> rubricGroupKey);

    /** Clears the value of rubricGroupKey field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricGroupKey() {
      return rubricGroupKey(Optional.empty());
    }

    /**
     * Setter for predefinedRubricGenerationSpec.
     *
     * <p>predefinedRubricGenerationSpec: Dynamically generate rubrics using a predefined spec.
     */
    @JsonProperty("predefinedRubricGenerationSpec")
    public abstract Builder predefinedRubricGenerationSpec(
        PredefinedMetricSpec predefinedRubricGenerationSpec);

    /**
     * Setter for predefinedRubricGenerationSpec builder.
     *
     * <p>predefinedRubricGenerationSpec: Dynamically generate rubrics using a predefined spec.
     */
    @CanIgnoreReturnValue
    public Builder predefinedRubricGenerationSpec(
        PredefinedMetricSpec.Builder predefinedRubricGenerationSpecBuilder) {
      return predefinedRubricGenerationSpec(predefinedRubricGenerationSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder predefinedRubricGenerationSpec(
        Optional<PredefinedMetricSpec> predefinedRubricGenerationSpec);

    /** Clears the value of predefinedRubricGenerationSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPredefinedRubricGenerationSpec() {
      return predefinedRubricGenerationSpec(Optional.empty());
    }

    /**
     * Setter for rubricGenerationSpec.
     *
     * <p>rubricGenerationSpec: Dynamically generate rubrics using this specification.
     */
    @JsonProperty("rubricGenerationSpec")
    public abstract Builder rubricGenerationSpec(RubricGenerationSpec rubricGenerationSpec);

    /**
     * Setter for rubricGenerationSpec builder.
     *
     * <p>rubricGenerationSpec: Dynamically generate rubrics using this specification.
     */
    @CanIgnoreReturnValue
    public Builder rubricGenerationSpec(RubricGenerationSpec.Builder rubricGenerationSpecBuilder) {
      return rubricGenerationSpec(rubricGenerationSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricGenerationSpec(Optional<RubricGenerationSpec> rubricGenerationSpec);

    /** Clears the value of rubricGenerationSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricGenerationSpec() {
      return rubricGenerationSpec(Optional.empty());
    }

    public abstract LLMBasedMetricSpec build();
  }

  /** Deserializes a JSON string to a LLMBasedMetricSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static LLMBasedMetricSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, LLMBasedMetricSpec.class);
  }
}
