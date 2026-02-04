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
import com.google.genai.types.HttpOptions;
import java.util.Optional;

/** Config for Prompt Optimizer. */
@AutoValue
@JsonDeserialize(builder = OptimizeConfig.Builder.class)
public abstract class OptimizeConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The optimization target for the prompt optimizer. It must be one of the OptimizeTarget enum
   * values: OPTIMIZATION_TARGET_GEMINI_NANO for the prompts from Android core API,
   * OPTIMIZATION_TARGET_FEW_SHOT_RUBRICS for the few-shot prompt optimizer with rubrics,
   * OPTIMIZATION_TARGET_FEW_SHOT_TARGET_RESPONSE for the few-shot prompt optimizer with target
   * responses.
   */
  @JsonProperty("optimizationTarget")
  public abstract Optional<OptimizeTarget> optimizationTarget();

  /**
   * The examples dataframe for the few-shot prompt optimizer. It must contain "prompt" and
   * "model_response" columns. Depending on which optimization target is used, it also needs to
   * contain "rubrics" and "rubrics_evaluations" or "target_response" columns.
   */
  @JsonProperty("examplesDataframe")
  public abstract Optional<PandasDataFrame> examplesDataframe();

  /** Instantiates a builder for OptimizeConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_OptimizeConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for OptimizeConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `OptimizeConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_OptimizeConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for optimizationTarget.
     *
     * <p>optimizationTarget: The optimization target for the prompt optimizer. It must be one of
     * the OptimizeTarget enum values: OPTIMIZATION_TARGET_GEMINI_NANO for the prompts from Android
     * core API, OPTIMIZATION_TARGET_FEW_SHOT_RUBRICS for the few-shot prompt optimizer with
     * rubrics, OPTIMIZATION_TARGET_FEW_SHOT_TARGET_RESPONSE for the few-shot prompt optimizer with
     * target responses.
     */
    @JsonProperty("optimizationTarget")
    public abstract Builder optimizationTarget(OptimizeTarget optimizationTarget);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder optimizationTarget(Optional<OptimizeTarget> optimizationTarget);

    /** Clears the value of optimizationTarget field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOptimizationTarget() {
      return optimizationTarget(Optional.empty());
    }

    /**
     * Setter for optimizationTarget given a known enum.
     *
     * <p>optimizationTarget: The optimization target for the prompt optimizer. It must be one of
     * the OptimizeTarget enum values: OPTIMIZATION_TARGET_GEMINI_NANO for the prompts from Android
     * core API, OPTIMIZATION_TARGET_FEW_SHOT_RUBRICS for the few-shot prompt optimizer with
     * rubrics, OPTIMIZATION_TARGET_FEW_SHOT_TARGET_RESPONSE for the few-shot prompt optimizer with
     * target responses.
     */
    @CanIgnoreReturnValue
    public Builder optimizationTarget(OptimizeTarget.Known knownType) {
      return optimizationTarget(new OptimizeTarget(knownType));
    }

    /**
     * Setter for optimizationTarget given a string.
     *
     * <p>optimizationTarget: The optimization target for the prompt optimizer. It must be one of
     * the OptimizeTarget enum values: OPTIMIZATION_TARGET_GEMINI_NANO for the prompts from Android
     * core API, OPTIMIZATION_TARGET_FEW_SHOT_RUBRICS for the few-shot prompt optimizer with
     * rubrics, OPTIMIZATION_TARGET_FEW_SHOT_TARGET_RESPONSE for the few-shot prompt optimizer with
     * target responses.
     */
    @CanIgnoreReturnValue
    public Builder optimizationTarget(String optimizationTarget) {
      return optimizationTarget(new OptimizeTarget(optimizationTarget));
    }

    /**
     * Setter for examplesDataframe.
     *
     * <p>examplesDataframe: The examples dataframe for the few-shot prompt optimizer. It must
     * contain "prompt" and "model_response" columns. Depending on which optimization target is
     * used, it also needs to contain "rubrics" and "rubrics_evaluations" or "target_response"
     * columns.
     */
    @JsonProperty("examplesDataframe")
    public abstract Builder examplesDataframe(PandasDataFrame examplesDataframe);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder examplesDataframe(Optional<PandasDataFrame> examplesDataframe);

    /** Clears the value of examplesDataframe field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExamplesDataframe() {
      return examplesDataframe(Optional.empty());
    }

    public abstract OptimizeConfig build();
  }

  /** Deserializes a JSON string to a OptimizeConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static OptimizeConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, OptimizeConfig.class);
  }
}
