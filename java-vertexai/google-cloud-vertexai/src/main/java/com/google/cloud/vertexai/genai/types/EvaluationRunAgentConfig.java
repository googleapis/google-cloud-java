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
import com.google.genai.types.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This field is experimental and may change in future versions.
 *
 * <p>Agent config for an evaluation run.
 */
@AutoValue
@JsonDeserialize(builder = EvaluationRunAgentConfig.Builder.class)
public abstract class EvaluationRunAgentConfig extends JsonSerializable {
  /** The developer instruction for the agent. */
  @JsonProperty("developerInstruction")
  public abstract Optional<Content> developerInstruction();

  /** The tools available to the agent. */
  @JsonProperty("tools")
  public abstract Optional<List<Tool>> tools();

  /** Instantiates a builder for EvaluationRunAgentConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunAgentConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunAgentConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunAgentConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunAgentConfig.Builder();
    }

    /**
     * Setter for developerInstruction.
     *
     * <p>developerInstruction: The developer instruction for the agent.
     */
    @JsonProperty("developerInstruction")
    public abstract Builder developerInstruction(Content developerInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder developerInstruction(Optional<Content> developerInstruction);

    /** Clears the value of developerInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDeveloperInstruction() {
      return developerInstruction(Optional.empty());
    }

    /**
     * Setter for tools.
     *
     * <p>tools: The tools available to the agent.
     */
    @JsonProperty("tools")
    public abstract Builder tools(List<Tool> tools);

    /**
     * Setter for tools.
     *
     * <p>tools: The tools available to the agent.
     */
    @CanIgnoreReturnValue
    public Builder tools(Tool... tools) {
      return tools(Arrays.asList(tools));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tools(Optional<List<Tool>> tools);

    /** Clears the value of tools field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTools() {
      return tools(Optional.empty());
    }

    public abstract EvaluationRunAgentConfig build();
  }

  /** Deserializes a JSON string to a EvaluationRunAgentConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunAgentConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunAgentConfig.class);
  }
}
