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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Parameters for executing code in an agent engine sandbox. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = ExecuteCodeAgentEngineSandboxRequestParameters.Builder.class)
public abstract class ExecuteCodeAgentEngineSandboxRequestParameters extends JsonSerializable {
  /** Name of the agent engine sandbox to execute code in. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Inputs to the code execution. */
  @JsonProperty("inputs")
  public abstract Optional<List<Chunk>> inputs();

  /** */
  @JsonProperty("config")
  public abstract Optional<ExecuteCodeAgentEngineSandboxConfig> config();

  /** Instantiates a builder for ExecuteCodeAgentEngineSandboxRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ExecuteCodeAgentEngineSandboxRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ExecuteCodeAgentEngineSandboxRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ExecuteCodeAgentEngineSandboxRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ExecuteCodeAgentEngineSandboxRequestParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Name of the agent engine sandbox to execute code in.
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
     * Setter for inputs.
     *
     * <p>inputs: Inputs to the code execution.
     */
    @JsonProperty("inputs")
    public abstract Builder inputs(List<Chunk> inputs);

    /**
     * Setter for inputs.
     *
     * <p>inputs: Inputs to the code execution.
     */
    @CanIgnoreReturnValue
    public Builder inputs(Chunk... inputs) {
      return inputs(Arrays.asList(inputs));
    }

    /**
     * Setter for inputs builder.
     *
     * <p>inputs: Inputs to the code execution.
     */
    @CanIgnoreReturnValue
    public Builder inputs(Chunk.Builder... inputsBuilders) {
      return inputs(
          Arrays.asList(inputsBuilders).stream()
              .map(Chunk.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inputs(Optional<List<Chunk>> inputs);

    /** Clears the value of inputs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInputs() {
      return inputs(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(ExecuteCodeAgentEngineSandboxConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(ExecuteCodeAgentEngineSandboxConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<ExecuteCodeAgentEngineSandboxConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract ExecuteCodeAgentEngineSandboxRequestParameters build();
  }

  /** Deserializes a JSON string to a ExecuteCodeAgentEngineSandboxRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static ExecuteCodeAgentEngineSandboxRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ExecuteCodeAgentEngineSandboxRequestParameters.class);
  }
}
