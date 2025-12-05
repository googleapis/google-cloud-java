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
import com.google.genai.types.GenerationConfig;
import java.util.Map;
import java.util.Optional;

/** The metric used for evaluation. */
@AutoValue
@JsonDeserialize(builder = Metric.Builder.class)
public abstract class Metric extends JsonSerializable {
  /** The name of the metric. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The prompt template for the metric. */
  @JsonProperty("promptTemplate")
  public abstract Optional<String> promptTemplate();

  /** The judge model for the metric. */
  @JsonProperty("judgeModel")
  public abstract Optional<String> judgeModel();

  /** The generation config for the judge LLM (temperature, top_k, top_p, etc). */
  @JsonProperty("judgeModelGenerationConfig")
  public abstract Optional<GenerationConfig> judgeModelGenerationConfig();

  /** The sampling count for the judge model. */
  @JsonProperty("judgeModelSamplingCount")
  public abstract Optional<Integer> judgeModelSamplingCount();

  /** The system instruction for the judge model. */
  @JsonProperty("judgeModelSystemInstruction")
  public abstract Optional<String> judgeModelSystemInstruction();

  /** Whether to return the raw output from the judge model. */
  @JsonProperty("returnRawOutput")
  public abstract Optional<Boolean> returnRawOutput();

  /** The rubric group name for the rubric-based metric. */
  @JsonProperty("rubricGroupName")
  public abstract Optional<String> rubricGroupName();

  /** Optional steering instruction parameters for the automated predefined metric. */
  @JsonProperty("metricSpecParameters")
  public abstract Optional<Map<String, Object>> metricSpecParameters();

  /** Instantiates a builder for Metric. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Metric.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Metric. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Metric.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Metric.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: The name of the metric.
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for promptTemplate.
     *
     * <p>promptTemplate: The prompt template for the metric.
     */
    @JsonProperty("promptTemplate")
    public abstract Builder promptTemplate(String promptTemplate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptTemplate(Optional<String> promptTemplate);

    /** Clears the value of promptTemplate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptTemplate() {
      return promptTemplate(Optional.empty());
    }

    /**
     * Setter for judgeModel.
     *
     * <p>judgeModel: The judge model for the metric.
     */
    @JsonProperty("judgeModel")
    public abstract Builder judgeModel(String judgeModel);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder judgeModel(Optional<String> judgeModel);

    /** Clears the value of judgeModel field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJudgeModel() {
      return judgeModel(Optional.empty());
    }

    /**
     * Setter for judgeModelGenerationConfig.
     *
     * <p>judgeModelGenerationConfig: The generation config for the judge LLM (temperature, top_k,
     * top_p, etc).
     */
    @JsonProperty("judgeModelGenerationConfig")
    public abstract Builder judgeModelGenerationConfig(GenerationConfig judgeModelGenerationConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder judgeModelGenerationConfig(
        Optional<GenerationConfig> judgeModelGenerationConfig);

    /** Clears the value of judgeModelGenerationConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJudgeModelGenerationConfig() {
      return judgeModelGenerationConfig(Optional.empty());
    }

    /**
     * Setter for judgeModelSamplingCount.
     *
     * <p>judgeModelSamplingCount: The sampling count for the judge model.
     */
    @JsonProperty("judgeModelSamplingCount")
    public abstract Builder judgeModelSamplingCount(Integer judgeModelSamplingCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder judgeModelSamplingCount(Optional<Integer> judgeModelSamplingCount);

    /** Clears the value of judgeModelSamplingCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJudgeModelSamplingCount() {
      return judgeModelSamplingCount(Optional.empty());
    }

    /**
     * Setter for judgeModelSystemInstruction.
     *
     * <p>judgeModelSystemInstruction: The system instruction for the judge model.
     */
    @JsonProperty("judgeModelSystemInstruction")
    public abstract Builder judgeModelSystemInstruction(String judgeModelSystemInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder judgeModelSystemInstruction(Optional<String> judgeModelSystemInstruction);

    /** Clears the value of judgeModelSystemInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJudgeModelSystemInstruction() {
      return judgeModelSystemInstruction(Optional.empty());
    }

    /**
     * Setter for returnRawOutput.
     *
     * <p>returnRawOutput: Whether to return the raw output from the judge model.
     */
    @JsonProperty("returnRawOutput")
    public abstract Builder returnRawOutput(boolean returnRawOutput);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder returnRawOutput(Optional<Boolean> returnRawOutput);

    /** Clears the value of returnRawOutput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReturnRawOutput() {
      return returnRawOutput(Optional.empty());
    }

    /**
     * Setter for rubricGroupName.
     *
     * <p>rubricGroupName: The rubric group name for the rubric-based metric.
     */
    @JsonProperty("rubricGroupName")
    public abstract Builder rubricGroupName(String rubricGroupName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricGroupName(Optional<String> rubricGroupName);

    /** Clears the value of rubricGroupName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricGroupName() {
      return rubricGroupName(Optional.empty());
    }

    /**
     * Setter for metricSpecParameters.
     *
     * <p>metricSpecParameters: Optional steering instruction parameters for the automated
     * predefined metric.
     */
    @JsonProperty("metricSpecParameters")
    public abstract Builder metricSpecParameters(Map<String, Object> metricSpecParameters);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricSpecParameters(Optional<Map<String, Object>> metricSpecParameters);

    /** Clears the value of metricSpecParameters field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricSpecParameters() {
      return metricSpecParameters(Optional.empty());
    }

    public abstract Metric build();
  }

  /** Deserializes a JSON string to a Metric object. */
  @ExcludeFromGeneratedCoverageReport
  public static Metric fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Metric.class);
  }
}
