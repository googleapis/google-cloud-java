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
import com.google.genai.types.Content;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** A comprehensive representation of a GenAI interaction for evaluation. */
@AutoValue
@JsonDeserialize(builder = EvalCase.Builder.class)
public abstract class EvalCase extends JsonSerializable {
  /** The most recent user message (current input). */
  @JsonProperty("prompt")
  public abstract Optional<Content> prompt();

  /**
   * Model-generated replies to the last user message in a conversation. Multiple responses are
   * allowed to support use cases such as comparing different model outputs.
   */
  @JsonProperty("responses")
  public abstract Optional<List<ResponseCandidate>> responses();

  /**
   * User-provided, golden reference model reply to prompt in context of chat history; Reference for
   * last response in a conversation.
   */
  @JsonProperty("reference")
  public abstract Optional<ResponseCandidate> reference();

  /** System instruction for the model. */
  @JsonProperty("systemInstruction")
  public abstract Optional<Content> systemInstruction();

  /** List of all prior messages in the conversation (chat history). */
  @JsonProperty("conversationHistory")
  public abstract Optional<List<Message>> conversationHistory();

  /**
   * Named groups of rubrics associated with this prompt. The key is a user-defined name for the
   * rubric group.
   */
  @JsonProperty("rubricGroups")
  public abstract Optional<Map<String, RubricGroup>> rubricGroups();

  /** Unique identifier for the evaluation case. */
  @JsonProperty("evalCaseId")
  public abstract Optional<String> evalCaseId();

  /**
   * This field is experimental and may change in future versions. Intermediate events of a single
   * turn in an agent run or intermediate events of the last turn for multi-turn an agent run.
   */
  @JsonProperty("intermediateEvents")
  public abstract Optional<List<Event>> intermediateEvents();

  /**
   * This field is experimental and may change in future versions. The agent info of the agent under
   * evaluation. This can be extended for multi-agent evaluation.
   */
  @JsonProperty("agentInfo")
  public abstract Optional<AgentInfo> agentInfo();

  /** Instantiates a builder for EvalCase. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvalCase.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvalCase. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvalCase.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvalCase.Builder();
    }

    /**
     * Setter for prompt.
     *
     * <p>prompt: The most recent user message (current input).
     */
    @JsonProperty("prompt")
    public abstract Builder prompt(Content prompt);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder prompt(Optional<Content> prompt);

    /** Clears the value of prompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPrompt() {
      return prompt(Optional.empty());
    }

    /**
     * Setter for responses.
     *
     * <p>responses: Model-generated replies to the last user message in a conversation. Multiple
     * responses are allowed to support use cases such as comparing different model outputs.
     */
    @JsonProperty("responses")
    public abstract Builder responses(List<ResponseCandidate> responses);

    /**
     * Setter for responses.
     *
     * <p>responses: Model-generated replies to the last user message in a conversation. Multiple
     * responses are allowed to support use cases such as comparing different model outputs.
     */
    @CanIgnoreReturnValue
    public Builder responses(ResponseCandidate... responses) {
      return responses(Arrays.asList(responses));
    }

    /**
     * Setter for responses builder.
     *
     * <p>responses: Model-generated replies to the last user message in a conversation. Multiple
     * responses are allowed to support use cases such as comparing different model outputs.
     */
    @CanIgnoreReturnValue
    public Builder responses(ResponseCandidate.Builder... responsesBuilders) {
      return responses(
          Arrays.asList(responsesBuilders).stream()
              .map(ResponseCandidate.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder responses(Optional<List<ResponseCandidate>> responses);

    /** Clears the value of responses field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponses() {
      return responses(Optional.empty());
    }

    /**
     * Setter for reference.
     *
     * <p>reference: User-provided, golden reference model reply to prompt in context of chat
     * history; Reference for last response in a conversation.
     */
    @JsonProperty("reference")
    public abstract Builder reference(ResponseCandidate reference);

    /**
     * Setter for reference builder.
     *
     * <p>reference: User-provided, golden reference model reply to prompt in context of chat
     * history; Reference for last response in a conversation.
     */
    @CanIgnoreReturnValue
    public Builder reference(ResponseCandidate.Builder referenceBuilder) {
      return reference(referenceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reference(Optional<ResponseCandidate> reference);

    /** Clears the value of reference field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReference() {
      return reference(Optional.empty());
    }

    /**
     * Setter for systemInstruction.
     *
     * <p>systemInstruction: System instruction for the model.
     */
    @JsonProperty("systemInstruction")
    public abstract Builder systemInstruction(Content systemInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder systemInstruction(Optional<Content> systemInstruction);

    /** Clears the value of systemInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSystemInstruction() {
      return systemInstruction(Optional.empty());
    }

    /**
     * Setter for conversationHistory.
     *
     * <p>conversationHistory: List of all prior messages in the conversation (chat history).
     */
    @JsonProperty("conversationHistory")
    public abstract Builder conversationHistory(List<Message> conversationHistory);

    /**
     * Setter for conversationHistory.
     *
     * <p>conversationHistory: List of all prior messages in the conversation (chat history).
     */
    @CanIgnoreReturnValue
    public Builder conversationHistory(Message... conversationHistory) {
      return conversationHistory(Arrays.asList(conversationHistory));
    }

    /**
     * Setter for conversationHistory builder.
     *
     * <p>conversationHistory: List of all prior messages in the conversation (chat history).
     */
    @CanIgnoreReturnValue
    public Builder conversationHistory(Message.Builder... conversationHistoryBuilders) {
      return conversationHistory(
          Arrays.asList(conversationHistoryBuilders).stream()
              .map(Message.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder conversationHistory(Optional<List<Message>> conversationHistory);

    /** Clears the value of conversationHistory field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConversationHistory() {
      return conversationHistory(Optional.empty());
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

    /**
     * Setter for evalCaseId.
     *
     * <p>evalCaseId: Unique identifier for the evaluation case.
     */
    @JsonProperty("evalCaseId")
    public abstract Builder evalCaseId(String evalCaseId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evalCaseId(Optional<String> evalCaseId);

    /** Clears the value of evalCaseId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvalCaseId() {
      return evalCaseId(Optional.empty());
    }

    /**
     * Setter for intermediateEvents.
     *
     * <p>intermediateEvents: This field is experimental and may change in future versions.
     * Intermediate events of a single turn in an agent run or intermediate events of the last turn
     * for multi-turn an agent run.
     */
    @JsonProperty("intermediateEvents")
    public abstract Builder intermediateEvents(List<Event> intermediateEvents);

    /**
     * Setter for intermediateEvents.
     *
     * <p>intermediateEvents: This field is experimental and may change in future versions.
     * Intermediate events of a single turn in an agent run or intermediate events of the last turn
     * for multi-turn an agent run.
     */
    @CanIgnoreReturnValue
    public Builder intermediateEvents(Event... intermediateEvents) {
      return intermediateEvents(Arrays.asList(intermediateEvents));
    }

    /**
     * Setter for intermediateEvents builder.
     *
     * <p>intermediateEvents: This field is experimental and may change in future versions.
     * Intermediate events of a single turn in an agent run or intermediate events of the last turn
     * for multi-turn an agent run.
     */
    @CanIgnoreReturnValue
    public Builder intermediateEvents(Event.Builder... intermediateEventsBuilders) {
      return intermediateEvents(
          Arrays.asList(intermediateEventsBuilders).stream()
              .map(Event.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder intermediateEvents(Optional<List<Event>> intermediateEvents);

    /** Clears the value of intermediateEvents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearIntermediateEvents() {
      return intermediateEvents(Optional.empty());
    }

    /**
     * Setter for agentInfo.
     *
     * <p>agentInfo: This field is experimental and may change in future versions. The agent info of
     * the agent under evaluation. This can be extended for multi-agent evaluation.
     */
    @JsonProperty("agentInfo")
    public abstract Builder agentInfo(AgentInfo agentInfo);

    /**
     * Setter for agentInfo builder.
     *
     * <p>agentInfo: This field is experimental and may change in future versions. The agent info of
     * the agent under evaluation. This can be extended for multi-agent evaluation.
     */
    @CanIgnoreReturnValue
    public Builder agentInfo(AgentInfo.Builder agentInfoBuilder) {
      return agentInfo(agentInfoBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentInfo(Optional<AgentInfo> agentInfo);

    /** Clears the value of agentInfo field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentInfo() {
      return agentInfo(Optional.empty());
    }

    public abstract EvalCase build();
  }

  /** Deserializes a JSON string to a EvalCase object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvalCase fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvalCase.class);
  }
}
