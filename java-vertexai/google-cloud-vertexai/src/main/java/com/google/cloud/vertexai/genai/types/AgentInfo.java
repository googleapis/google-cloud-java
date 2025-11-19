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

/** The agent info of an agent, used for agent eval. */
@AutoValue
@JsonDeserialize(builder = AgentInfo.Builder.class)
public abstract class AgentInfo extends JsonSerializable {
  /**
   * The agent engine used to run agent. Agent engine resource name in str type, with format
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine_id}`.
   */
  @JsonProperty("agentResourceName")
  public abstract Optional<String> agentResourceName();

  /** Agent name, used as an identifier. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Agent developer instruction. */
  @JsonProperty("instruction")
  public abstract Optional<String> instruction();

  /** Agent description. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Instantiates a builder for AgentInfo. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentInfo.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentInfo. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AgentInfo.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentInfo.Builder();
    }

    /**
     * Setter for agentResourceName.
     *
     * <p>agentResourceName: The agent engine used to run agent. Agent engine resource name in str
     * type, with format
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine_id}`.
     */
    @JsonProperty("agentResourceName")
    public abstract Builder agentResourceName(String agentResourceName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentResourceName(Optional<String> agentResourceName);

    /** Clears the value of agentResourceName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentResourceName() {
      return agentResourceName(Optional.empty());
    }

    /**
     * Setter for name.
     *
     * <p>name: Agent name, used as an identifier.
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
     * Setter for instruction.
     *
     * <p>instruction: Agent developer instruction.
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
     * Setter for description.
     *
     * <p>description: Agent description.
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

    public abstract AgentInfo build();
  }

  /** Deserializes a JSON string to a AgentInfo object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentInfo fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentInfo.class);
  }
}
