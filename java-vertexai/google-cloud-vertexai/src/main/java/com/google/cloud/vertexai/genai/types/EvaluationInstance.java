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
import java.util.Map;
import java.util.Optional;

/** A single instance to be evaluated. */
@AutoValue
@JsonDeserialize(builder = EvaluationInstance.Builder.class)
public abstract class EvaluationInstance extends JsonSerializable {
  /** Data used to populate placeholder `prompt` in a metric prompt template. */
  @JsonProperty("prompt")
  public abstract Optional<InstanceData> prompt();

  /** Data used to populate placeholder `response` in a metric prompt template. */
  @JsonProperty("response")
  public abstract Optional<InstanceData> response();

  /** Data used to populate placeholder `reference` in a metric prompt template. */
  @JsonProperty("reference")
  public abstract Optional<InstanceData> reference();

  /** Other data used to populate placeholders based on their key. */
  @JsonProperty("otherData")
  public abstract Optional<MapInstance> otherData();

  /** Data used for agent evaluation. */
  @JsonProperty("agentData")
  public abstract Optional<AgentData> agentData();

  /**
   * Named groups of rubrics associated with this prompt. The key is a user-defined name for the
   * rubric group.
   */
  @JsonProperty("rubricGroups")
  public abstract Optional<Map<String, RubricGroup>> rubricGroups();

  /** Instantiates a builder for EvaluationInstance. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationInstance.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationInstance. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationInstance.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationInstance.Builder();
    }

    /**
     * Setter for prompt.
     *
     * <p>prompt: Data used to populate placeholder `prompt` in a metric prompt template.
     */
    @JsonProperty("prompt")
    public abstract Builder prompt(InstanceData prompt);

    /**
     * Setter for prompt builder.
     *
     * <p>prompt: Data used to populate placeholder `prompt` in a metric prompt template.
     */
    @CanIgnoreReturnValue
    public Builder prompt(InstanceData.Builder promptBuilder) {
      return prompt(promptBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder prompt(Optional<InstanceData> prompt);

    /** Clears the value of prompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPrompt() {
      return prompt(Optional.empty());
    }

    /**
     * Setter for response.
     *
     * <p>response: Data used to populate placeholder `response` in a metric prompt template.
     */
    @JsonProperty("response")
    public abstract Builder response(InstanceData response);

    /**
     * Setter for response builder.
     *
     * <p>response: Data used to populate placeholder `response` in a metric prompt template.
     */
    @CanIgnoreReturnValue
    public Builder response(InstanceData.Builder responseBuilder) {
      return response(responseBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder response(Optional<InstanceData> response);

    /** Clears the value of response field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponse() {
      return response(Optional.empty());
    }

    /**
     * Setter for reference.
     *
     * <p>reference: Data used to populate placeholder `reference` in a metric prompt template.
     */
    @JsonProperty("reference")
    public abstract Builder reference(InstanceData reference);

    /**
     * Setter for reference builder.
     *
     * <p>reference: Data used to populate placeholder `reference` in a metric prompt template.
     */
    @CanIgnoreReturnValue
    public Builder reference(InstanceData.Builder referenceBuilder) {
      return reference(referenceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reference(Optional<InstanceData> reference);

    /** Clears the value of reference field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReference() {
      return reference(Optional.empty());
    }

    /**
     * Setter for otherData.
     *
     * <p>otherData: Other data used to populate placeholders based on their key.
     */
    @JsonProperty("otherData")
    public abstract Builder otherData(MapInstance otherData);

    /**
     * Setter for otherData builder.
     *
     * <p>otherData: Other data used to populate placeholders based on their key.
     */
    @CanIgnoreReturnValue
    public Builder otherData(MapInstance.Builder otherDataBuilder) {
      return otherData(otherDataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder otherData(Optional<MapInstance> otherData);

    /** Clears the value of otherData field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOtherData() {
      return otherData(Optional.empty());
    }

    /**
     * Setter for agentData.
     *
     * <p>agentData: Data used for agent evaluation.
     */
    @JsonProperty("agentData")
    public abstract Builder agentData(AgentData agentData);

    /**
     * Setter for agentData builder.
     *
     * <p>agentData: Data used for agent evaluation.
     */
    @CanIgnoreReturnValue
    public Builder agentData(AgentData.Builder agentDataBuilder) {
      return agentData(agentDataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentData(Optional<AgentData> agentData);

    /** Clears the value of agentData field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentData() {
      return agentData(Optional.empty());
    }

    /**
     * Setter for rubricGroups.
     *
     * <p>rubricGroups: Named groups of rubrics associated with this prompt. The key is a
     * user-defined name for the rubric group.
     */
    @JsonProperty("rubricGroups")
    public abstract Builder rubricGroups(Map<String, RubricGroup> rubricGroups);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricGroups(Optional<Map<String, RubricGroup>> rubricGroups);

    /** Clears the value of rubricGroups field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricGroups() {
      return rubricGroups(Optional.empty());
    }

    public abstract EvaluationInstance build();
  }

  /** Deserializes a JSON string to a EvaluationInstance object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationInstance fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationInstance.class);
  }
}
