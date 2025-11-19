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
import com.google.genai.types.AutoraterConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Specification for a metric that is based on rubrics. */
@AutoValue
@JsonDeserialize(builder = RubricBasedMetricSpec.Builder.class)
public abstract class RubricBasedMetricSpec extends JsonSerializable {
  /** Template for the prompt used by the judge model to evaluate against rubrics. */
  @JsonProperty("metricPromptTemplate")
  public abstract Optional<String> metricPromptTemplate();

  /** Optional configuration for the judge LLM (Autorater). */
  @JsonProperty("judgeAutoraterConfig")
  public abstract Optional<AutoraterConfig> judgeAutoraterConfig();

  /** Use rubrics provided directly in the spec. */
  @JsonProperty("inlineRubrics")
  public abstract Optional<List<Rubric>> inlineRubrics();

  /**
   * Use a pre-defined group of rubrics associated with the input content. This refers to a key in
   * the `rubric_groups` map of `RubricEnhancedContents`.
   */
  @JsonProperty("rubricGroupKey")
  public abstract Optional<String> rubricGroupKey();

  /** Dynamically generate rubrics for evaluation using this specification. */
  @JsonProperty("rubricGenerationSpec")
  public abstract Optional<RubricGenerationSpec> rubricGenerationSpec();

  /** Instantiates a builder for RubricBasedMetricSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricBasedMetricSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricBasedMetricSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricBasedMetricSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricBasedMetricSpec.Builder();
    }

    /**
     * Setter for metricPromptTemplate.
     *
     * <p>metricPromptTemplate: Template for the prompt used by the judge model to evaluate against
     * rubrics.
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
     * Setter for inlineRubrics.
     *
     * <p>inlineRubrics: Use rubrics provided directly in the spec.
     */
    @JsonProperty("inlineRubrics")
    public abstract Builder inlineRubrics(List<Rubric> inlineRubrics);

    /**
     * Setter for inlineRubrics.
     *
     * <p>inlineRubrics: Use rubrics provided directly in the spec.
     */
    @CanIgnoreReturnValue
    public Builder inlineRubrics(Rubric... inlineRubrics) {
      return inlineRubrics(Arrays.asList(inlineRubrics));
    }

    /**
     * Setter for inlineRubrics builder.
     *
     * <p>inlineRubrics: Use rubrics provided directly in the spec.
     */
    @CanIgnoreReturnValue
    public Builder inlineRubrics(Rubric.Builder... inlineRubricsBuilders) {
      return inlineRubrics(
          Arrays.asList(inlineRubricsBuilders).stream()
              .map(Rubric.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inlineRubrics(Optional<List<Rubric>> inlineRubrics);

    /** Clears the value of inlineRubrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInlineRubrics() {
      return inlineRubrics(Optional.empty());
    }

    /**
     * Setter for rubricGroupKey.
     *
     * <p>rubricGroupKey: Use a pre-defined group of rubrics associated with the input content. This
     * refers to a key in the `rubric_groups` map of `RubricEnhancedContents`.
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
     * Setter for rubricGenerationSpec.
     *
     * <p>rubricGenerationSpec: Dynamically generate rubrics for evaluation using this
     * specification.
     */
    @JsonProperty("rubricGenerationSpec")
    public abstract Builder rubricGenerationSpec(RubricGenerationSpec rubricGenerationSpec);

    /**
     * Setter for rubricGenerationSpec builder.
     *
     * <p>rubricGenerationSpec: Dynamically generate rubrics for evaluation using this
     * specification.
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

    public abstract RubricBasedMetricSpec build();
  }

  /** Deserializes a JSON string to a RubricBasedMetricSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricBasedMetricSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricBasedMetricSpec.class);
  }
}
