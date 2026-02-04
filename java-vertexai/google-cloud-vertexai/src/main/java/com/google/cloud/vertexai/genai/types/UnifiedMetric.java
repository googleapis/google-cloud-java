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

/** The unified metric used for evaluation. */
@AutoValue
@JsonDeserialize(builder = UnifiedMetric.Builder.class)
public abstract class UnifiedMetric extends JsonSerializable {
  /** The spec for an LLM based metric. */
  @JsonProperty("llmBasedMetricSpec")
  public abstract Optional<LLMBasedMetricSpec> llmBasedMetricSpec();

  /** The spec for a custom code execution metric. */
  @JsonProperty("customCodeExecutionSpec")
  public abstract Optional<CustomCodeExecutionSpec> customCodeExecutionSpec();

  /** The spec for a pre-defined metric. */
  @JsonProperty("predefinedMetricSpec")
  public abstract Optional<PredefinedMetricSpec> predefinedMetricSpec();

  /** The spec for a computation based metric. */
  @JsonProperty("computationBasedMetricSpec")
  public abstract Optional<ComputationBasedMetricSpec> computationBasedMetricSpec();

  /** Instantiates a builder for UnifiedMetric. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_UnifiedMetric.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for UnifiedMetric. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `UnifiedMetric.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_UnifiedMetric.Builder();
    }

    /**
     * Setter for llmBasedMetricSpec.
     *
     * <p>llmBasedMetricSpec: The spec for an LLM based metric.
     */
    @JsonProperty("llmBasedMetricSpec")
    public abstract Builder llmBasedMetricSpec(LLMBasedMetricSpec llmBasedMetricSpec);

    /**
     * Setter for llmBasedMetricSpec builder.
     *
     * <p>llmBasedMetricSpec: The spec for an LLM based metric.
     */
    @CanIgnoreReturnValue
    public Builder llmBasedMetricSpec(LLMBasedMetricSpec.Builder llmBasedMetricSpecBuilder) {
      return llmBasedMetricSpec(llmBasedMetricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder llmBasedMetricSpec(Optional<LLMBasedMetricSpec> llmBasedMetricSpec);

    /** Clears the value of llmBasedMetricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLlmBasedMetricSpec() {
      return llmBasedMetricSpec(Optional.empty());
    }

    /**
     * Setter for customCodeExecutionSpec.
     *
     * <p>customCodeExecutionSpec: The spec for a custom code execution metric.
     */
    @JsonProperty("customCodeExecutionSpec")
    public abstract Builder customCodeExecutionSpec(
        CustomCodeExecutionSpec customCodeExecutionSpec);

    /**
     * Setter for customCodeExecutionSpec builder.
     *
     * <p>customCodeExecutionSpec: The spec for a custom code execution metric.
     */
    @CanIgnoreReturnValue
    public Builder customCodeExecutionSpec(
        CustomCodeExecutionSpec.Builder customCodeExecutionSpecBuilder) {
      return customCodeExecutionSpec(customCodeExecutionSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customCodeExecutionSpec(
        Optional<CustomCodeExecutionSpec> customCodeExecutionSpec);

    /** Clears the value of customCodeExecutionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomCodeExecutionSpec() {
      return customCodeExecutionSpec(Optional.empty());
    }

    /**
     * Setter for predefinedMetricSpec.
     *
     * <p>predefinedMetricSpec: The spec for a pre-defined metric.
     */
    @JsonProperty("predefinedMetricSpec")
    public abstract Builder predefinedMetricSpec(PredefinedMetricSpec predefinedMetricSpec);

    /**
     * Setter for predefinedMetricSpec builder.
     *
     * <p>predefinedMetricSpec: The spec for a pre-defined metric.
     */
    @CanIgnoreReturnValue
    public Builder predefinedMetricSpec(PredefinedMetricSpec.Builder predefinedMetricSpecBuilder) {
      return predefinedMetricSpec(predefinedMetricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder predefinedMetricSpec(Optional<PredefinedMetricSpec> predefinedMetricSpec);

    /** Clears the value of predefinedMetricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPredefinedMetricSpec() {
      return predefinedMetricSpec(Optional.empty());
    }

    /**
     * Setter for computationBasedMetricSpec.
     *
     * <p>computationBasedMetricSpec: The spec for a computation based metric.
     */
    @JsonProperty("computationBasedMetricSpec")
    public abstract Builder computationBasedMetricSpec(
        ComputationBasedMetricSpec computationBasedMetricSpec);

    /**
     * Setter for computationBasedMetricSpec builder.
     *
     * <p>computationBasedMetricSpec: The spec for a computation based metric.
     */
    @CanIgnoreReturnValue
    public Builder computationBasedMetricSpec(
        ComputationBasedMetricSpec.Builder computationBasedMetricSpecBuilder) {
      return computationBasedMetricSpec(computationBasedMetricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder computationBasedMetricSpec(
        Optional<ComputationBasedMetricSpec> computationBasedMetricSpec);

    /** Clears the value of computationBasedMetricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearComputationBasedMetricSpec() {
      return computationBasedMetricSpec(Optional.empty());
    }

    public abstract UnifiedMetric build();
  }

  /** Deserializes a JSON string to a UnifiedMetric object. */
  @ExcludeFromGeneratedCoverageReport
  public static UnifiedMetric fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, UnifiedMetric.class);
  }
}
