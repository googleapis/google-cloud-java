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
 * This field is experimental and may change in future versions.
 *
 * <p>Configuration that describes an agent.
 */
@AutoValue
@JsonDeserialize(builder = EvaluationRunInferenceConfig.Builder.class)
public abstract class EvaluationRunInferenceConfig extends JsonSerializable {
  /** The agent config. */
  @JsonProperty("agentConfig")
  public abstract Optional<EvaluationRunAgentConfig> agentConfig();

  /** The fully qualified name of the publisher model or endpoint to use for inference. */
  @JsonProperty("model")
  public abstract Optional<String> model();

  /** Instantiates a builder for EvaluationRunInferenceConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunInferenceConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunInferenceConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `EvaluationRunInferenceConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunInferenceConfig.Builder();
    }

    /**
     * Setter for agentConfig.
     *
     * <p>agentConfig: The agent config.
     */
    @JsonProperty("agentConfig")
    public abstract Builder agentConfig(EvaluationRunAgentConfig agentConfig);

    /**
     * Setter for agentConfig builder.
     *
     * <p>agentConfig: The agent config.
     */
    @CanIgnoreReturnValue
    public Builder agentConfig(EvaluationRunAgentConfig.Builder agentConfigBuilder) {
      return agentConfig(agentConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentConfig(Optional<EvaluationRunAgentConfig> agentConfig);

    /** Clears the value of agentConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentConfig() {
      return agentConfig(Optional.empty());
    }

    /**
     * Setter for model.
     *
     * <p>model: The fully qualified name of the publisher model or endpoint to use for inference.
     */
    @JsonProperty("model")
    public abstract Builder model(String model);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder model(Optional<String> model);

    /** Clears the value of model field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearModel() {
      return model(Optional.empty());
    }

    public abstract EvaluationRunInferenceConfig build();
  }

  /** Deserializes a JSON string to a EvaluationRunInferenceConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunInferenceConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunInferenceConfig.class);
  }
}
