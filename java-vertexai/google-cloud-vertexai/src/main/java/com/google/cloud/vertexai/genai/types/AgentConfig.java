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

/** Configuration for an Agent. */
@AutoValue
@JsonDeserialize(builder = AgentConfig.Builder.class)
public abstract class AgentConfig extends JsonSerializable {
  /** A JSON string containing a list of tools available to an agent. */
  @JsonProperty("toolsText")
  public abstract Optional<String> toolsText();

  /** List of tools. */
  @JsonProperty("tools")
  public abstract Optional<Tools> tools();

  /** A field containing instructions from the developer for the agent. */
  @JsonProperty("developerInstruction")
  public abstract Optional<InstanceData> developerInstruction();

  /** Instantiates a builder for AgentConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AgentConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentConfig.Builder();
    }

    /**
     * Setter for toolsText.
     *
     * <p>toolsText: A JSON string containing a list of tools available to an agent.
     */
    @JsonProperty("toolsText")
    public abstract Builder toolsText(String toolsText);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolsText(Optional<String> toolsText);

    /** Clears the value of toolsText field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolsText() {
      return toolsText(Optional.empty());
    }

    /**
     * Setter for tools.
     *
     * <p>tools: List of tools.
     */
    @JsonProperty("tools")
    public abstract Builder tools(Tools tools);

    /**
     * Setter for tools builder.
     *
     * <p>tools: List of tools.
     */
    @CanIgnoreReturnValue
    public Builder tools(Tools.Builder toolsBuilder) {
      return tools(toolsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tools(Optional<Tools> tools);

    /** Clears the value of tools field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTools() {
      return tools(Optional.empty());
    }

    /**
     * Setter for developerInstruction.
     *
     * <p>developerInstruction: A field containing instructions from the developer for the agent.
     */
    @JsonProperty("developerInstruction")
    public abstract Builder developerInstruction(InstanceData developerInstruction);

    /**
     * Setter for developerInstruction builder.
     *
     * <p>developerInstruction: A field containing instructions from the developer for the agent.
     */
    @CanIgnoreReturnValue
    public Builder developerInstruction(InstanceData.Builder developerInstructionBuilder) {
      return developerInstruction(developerInstructionBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder developerInstruction(Optional<InstanceData> developerInstruction);

    /** Clears the value of developerInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDeveloperInstruction() {
      return developerInstruction(Optional.empty());
    }

    public abstract AgentConfig build();
  }

  /** Deserializes a JSON string to a AgentConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentConfig.class);
  }
}
