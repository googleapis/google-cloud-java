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
import com.google.genai.types.Content;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Parameters for generating rubrics. */
@AutoValue
@JsonDeserialize(builder = GenerateInstanceRubricsRequest.Builder.class)
public abstract class GenerateInstanceRubricsRequest extends JsonSerializable {
  /**
   * The prompt to generate rubrics from. For single-turn queries, this is a single instance. For
   * multi-turn queries, this is a repeated field that contains conversation history + latest
   * request.
   */
  @JsonProperty("contents")
  public abstract Optional<List<Content>> contents();

  /**
   * Specification for using the rubric generation configs of a pre-defined metric, e.g.
   * "generic_quality_v1" and "instruction_following_v1". Some of the configs may be only used in
   * rubric generation and not supporting evaluation, e.g. "fully_customized_generic_quality_v1". If
   * this field is set, the `rubric_generation_spec` field will be ignored.
   */
  @JsonProperty("predefinedRubricGenerationSpec")
  public abstract Optional<PredefinedMetricSpec> predefinedRubricGenerationSpec();

  /** Specification for how the rubrics should be generated. */
  @JsonProperty("rubricGenerationSpec")
  public abstract Optional<RubricGenerationSpec> rubricGenerationSpec();

  /** */
  @JsonProperty("config")
  public abstract Optional<RubricGenerationConfig> config();

  /** Instantiates a builder for GenerateInstanceRubricsRequest. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateInstanceRubricsRequest.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateInstanceRubricsRequest. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateInstanceRubricsRequest.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateInstanceRubricsRequest.Builder();
    }

    /**
     * Setter for contents.
     *
     * <p>contents: The prompt to generate rubrics from. For single-turn queries, this is a single
     * instance. For multi-turn queries, this is a repeated field that contains conversation history
     * + latest request.
     */
    @JsonProperty("contents")
    public abstract Builder contents(List<Content> contents);

    /**
     * Setter for contents.
     *
     * <p>contents: The prompt to generate rubrics from. For single-turn queries, this is a single
     * instance. For multi-turn queries, this is a repeated field that contains conversation history
     * + latest request.
     */
    @CanIgnoreReturnValue
    public Builder contents(Content... contents) {
      return contents(Arrays.asList(contents));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contents(Optional<List<Content>> contents);

    /** Clears the value of contents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContents() {
      return contents(Optional.empty());
    }

    /**
     * Setter for predefinedRubricGenerationSpec.
     *
     * <p>predefinedRubricGenerationSpec: Specification for using the rubric generation configs of a
     * pre-defined metric, e.g. "generic_quality_v1" and "instruction_following_v1". Some of the
     * configs may be only used in rubric generation and not supporting evaluation, e.g.
     * "fully_customized_generic_quality_v1". If this field is set, the `rubric_generation_spec`
     * field will be ignored.
     */
    @JsonProperty("predefinedRubricGenerationSpec")
    public abstract Builder predefinedRubricGenerationSpec(
        PredefinedMetricSpec predefinedRubricGenerationSpec);

    /**
     * Setter for predefinedRubricGenerationSpec builder.
     *
     * <p>predefinedRubricGenerationSpec: Specification for using the rubric generation configs of a
     * pre-defined metric, e.g. "generic_quality_v1" and "instruction_following_v1". Some of the
     * configs may be only used in rubric generation and not supporting evaluation, e.g.
     * "fully_customized_generic_quality_v1". If this field is set, the `rubric_generation_spec`
     * field will be ignored.
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
     * <p>rubricGenerationSpec: Specification for how the rubrics should be generated.
     */
    @JsonProperty("rubricGenerationSpec")
    public abstract Builder rubricGenerationSpec(RubricGenerationSpec rubricGenerationSpec);

    /**
     * Setter for rubricGenerationSpec builder.
     *
     * <p>rubricGenerationSpec: Specification for how the rubrics should be generated.
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

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(RubricGenerationConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(RubricGenerationConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<RubricGenerationConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract GenerateInstanceRubricsRequest build();
  }

  /** Deserializes a JSON string to a GenerateInstanceRubricsRequest object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateInstanceRubricsRequest fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GenerateInstanceRubricsRequest.class);
  }
}
