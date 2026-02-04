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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents data specific to multi-turn agent evaluations. */
@AutoValue
@JsonDeserialize(builder = AgentData.Builder.class)
public abstract class AgentData extends JsonSerializable {
  /**
   * A map containing the static configurations for each agent in the system. Key: agent_id (matches
   * the `author` field in events). Value: The static configuration of the agent.
   */
  @JsonProperty("agents")
  public abstract Optional<Map<String, AgentConfig>> agents();

  /**
   * A chronological list of conversation turns. Each turn represents a logical execution cycle
   * (e.g., User Input -> Agent Response).
   */
  @JsonProperty("turns")
  public abstract Optional<List<ConversationTurn>> turns();

  /** Agent configuration. */
  @JsonProperty("agentConfig")
  public abstract Optional<AgentConfig> agentConfig();

  /** A JSON string containing a sequence of events. */
  @JsonProperty("eventsText")
  public abstract Optional<String> eventsText();

  /** A list of events. */
  @JsonProperty("events")
  public abstract Optional<Events> events();

  /** Instantiates a builder for AgentData. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentData.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentData. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AgentData.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentData.Builder();
    }

    /**
     * Setter for agents.
     *
     * <p>agents: A map containing the static configurations for each agent in the system. Key:
     * agent_id (matches the `author` field in events). Value: The static configuration of the
     * agent.
     */
    @JsonProperty("agents")
    public abstract Builder agents(Map<String, AgentConfig> agents);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agents(Optional<Map<String, AgentConfig>> agents);

    /** Clears the value of agents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgents() {
      return agents(Optional.empty());
    }

    /**
     * Setter for turns.
     *
     * <p>turns: A chronological list of conversation turns. Each turn represents a logical
     * execution cycle (e.g., User Input -> Agent Response).
     */
    @JsonProperty("turns")
    public abstract Builder turns(List<ConversationTurn> turns);

    /**
     * Setter for turns.
     *
     * <p>turns: A chronological list of conversation turns. Each turn represents a logical
     * execution cycle (e.g., User Input -> Agent Response).
     */
    @CanIgnoreReturnValue
    public Builder turns(ConversationTurn... turns) {
      return turns(Arrays.asList(turns));
    }

    /**
     * Setter for turns builder.
     *
     * <p>turns: A chronological list of conversation turns. Each turn represents a logical
     * execution cycle (e.g., User Input -> Agent Response).
     */
    @CanIgnoreReturnValue
    public Builder turns(ConversationTurn.Builder... turnsBuilders) {
      return turns(
          Arrays.asList(turnsBuilders).stream()
              .map(ConversationTurn.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder turns(Optional<List<ConversationTurn>> turns);

    /** Clears the value of turns field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTurns() {
      return turns(Optional.empty());
    }

    /**
     * Setter for agentConfig.
     *
     * <p>agentConfig: Agent configuration.
     */
    @JsonProperty("agentConfig")
    public abstract Builder agentConfig(AgentConfig agentConfig);

    /**
     * Setter for agentConfig builder.
     *
     * <p>agentConfig: Agent configuration.
     */
    @CanIgnoreReturnValue
    public Builder agentConfig(AgentConfig.Builder agentConfigBuilder) {
      return agentConfig(agentConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentConfig(Optional<AgentConfig> agentConfig);

    /** Clears the value of agentConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentConfig() {
      return agentConfig(Optional.empty());
    }

    /**
     * Setter for eventsText.
     *
     * <p>eventsText: A JSON string containing a sequence of events.
     */
    @JsonProperty("eventsText")
    public abstract Builder eventsText(String eventsText);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder eventsText(Optional<String> eventsText);

    /** Clears the value of eventsText field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEventsText() {
      return eventsText(Optional.empty());
    }

    /**
     * Setter for events.
     *
     * <p>events: A list of events.
     */
    @JsonProperty("events")
    public abstract Builder events(Events events);

    /**
     * Setter for events builder.
     *
     * <p>events: A list of events.
     */
    @CanIgnoreReturnValue
    public Builder events(Events.Builder eventsBuilder) {
      return events(eventsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder events(Optional<Events> events);

    /** Clears the value of events field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvents() {
      return events(Optional.empty());
    }

    public abstract AgentData build();
  }

  /** Deserializes a JSON string to a AgentData object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentData fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentData.class);
  }
}
