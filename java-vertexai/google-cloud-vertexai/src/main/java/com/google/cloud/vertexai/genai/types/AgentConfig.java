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
import com.google.genai.types.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents configuration for an Agent. */
@AutoValue
@JsonDeserialize(builder = AgentConfig.Builder.class)
public abstract class AgentConfig extends JsonSerializable {
  /**
   * Unique identifier of the agent. This ID is used to refer to this agent, e.g., in
   * AgentEvent.author, or in the `sub_agents` field. It must be unique within the `agents` map.
   */
  @JsonProperty("agentId")
  public abstract Optional<String> agentId();

  /**
   * The type or class of the agent (e.g., "LlmAgent", "RouterAgent", "ToolUseAgent"). Useful for
   * the autorater to understand the expected behavior of the agent.
   */
  @JsonProperty("agentType")
  public abstract Optional<String> agentType();

  /**
   * A high-level description of the agent's role and responsibilities. Critical for evaluating if
   * the agent is routing tasks correctly.
   */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /**
   * The instructions for the LLM model, guiding the agent's behavior. Can be static or dynamic.
   * Dynamic instructions can contain placeholders like {variable_name} that will be resolved at
   * runtime using the `AgentEvent.state_delta` field.
   */
  @JsonProperty("instruction")
  public abstract Optional<String> instruction();

  /** The list of tools available to this agent. */
  @JsonProperty("tools")
  public abstract Optional<List<Tool>> tools();

  /**
   * The list of valid agent IDs that this agent can delegate to. This defines the directed edges in
   * the multi-agent system graph topology.
   */
  @JsonProperty("subAgents")
  public abstract Optional<List<String>> subAgents();

  /** A JSON string containing a list of tools available to an agent. */
  @JsonProperty("toolsText")
  public abstract Optional<String> toolsText();

  /** List of tools. */
  @JsonProperty("legacyTools")
  public abstract Optional<Tools> legacyTools();

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
     * Setter for agentId.
     *
     * <p>agentId: Unique identifier of the agent. This ID is used to refer to this agent, e.g., in
     * AgentEvent.author, or in the `sub_agents` field. It must be unique within the `agents` map.
     */
    @JsonProperty("agentId")
    public abstract Builder agentId(String agentId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentId(Optional<String> agentId);

    /** Clears the value of agentId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentId() {
      return agentId(Optional.empty());
    }

    /**
     * Setter for agentType.
     *
     * <p>agentType: The type or class of the agent (e.g., "LlmAgent", "RouterAgent",
     * "ToolUseAgent"). Useful for the autorater to understand the expected behavior of the agent.
     */
    @JsonProperty("agentType")
    public abstract Builder agentType(String agentType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentType(Optional<String> agentType);

    /** Clears the value of agentType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentType() {
      return agentType(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: A high-level description of the agent's role and responsibilities. Critical
     * for evaluating if the agent is routing tasks correctly.
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    /**
     * Setter for instruction.
     *
     * <p>instruction: The instructions for the LLM model, guiding the agent's behavior. Can be
     * static or dynamic. Dynamic instructions can contain placeholders like {variable_name} that
     * will be resolved at runtime using the `AgentEvent.state_delta` field.
     */
    @JsonProperty("instruction")
    public abstract Builder instruction(String instruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instruction(Optional<String> instruction);

    /** Clears the value of instruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstruction() {
      return instruction(Optional.empty());
    }

    /**
     * Setter for tools.
     *
     * <p>tools: The list of tools available to this agent.
     */
    @JsonProperty("tools")
    public abstract Builder tools(List<Tool> tools);

    /**
     * Setter for tools.
     *
     * <p>tools: The list of tools available to this agent.
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

    /**
     * Setter for subAgents.
     *
     * <p>subAgents: The list of valid agent IDs that this agent can delegate to. This defines the
     * directed edges in the multi-agent system graph topology.
     */
    @JsonProperty("subAgents")
    public abstract Builder subAgents(List<String> subAgents);

    /**
     * Setter for subAgents.
     *
     * <p>subAgents: The list of valid agent IDs that this agent can delegate to. This defines the
     * directed edges in the multi-agent system graph topology.
     */
    @CanIgnoreReturnValue
    public Builder subAgents(String... subAgents) {
      return subAgents(Arrays.asList(subAgents));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder subAgents(Optional<List<String>> subAgents);

    /** Clears the value of subAgents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSubAgents() {
      return subAgents(Optional.empty());
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
     * Setter for legacyTools.
     *
     * <p>legacyTools: List of tools.
     */
    @JsonProperty("legacyTools")
    public abstract Builder legacyTools(Tools legacyTools);

    /**
     * Setter for legacyTools builder.
     *
     * <p>legacyTools: List of tools.
     */
    @CanIgnoreReturnValue
    public Builder legacyTools(Tools.Builder legacyToolsBuilder) {
      return legacyTools(legacyToolsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder legacyTools(Optional<Tools> legacyTools);

    /** Clears the value of legacyTools field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLegacyTools() {
      return legacyTools(Optional.empty());
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
