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
import java.util.Optional;

/** Represents a single turn/invocation in the conversation. */
@AutoValue
@JsonDeserialize(builder = ConversationTurn.Builder.class)
public abstract class ConversationTurn extends JsonSerializable {
  /** The 0-based index of the turn in the conversation sequence. */
  @JsonProperty("turnIndex")
  public abstract Optional<Integer> turnIndex();

  /** A unique identifier for the turn. */
  @JsonProperty("turnId")
  public abstract Optional<String> turnId();

  /** The list of events that occurred during this turn. */
  @JsonProperty("events")
  public abstract Optional<List<AgentEvent>> events();

  /** Instantiates a builder for ConversationTurn. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ConversationTurn.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ConversationTurn. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ConversationTurn.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ConversationTurn.Builder();
    }

    /**
     * Setter for turnIndex.
     *
     * <p>turnIndex: The 0-based index of the turn in the conversation sequence.
     */
    @JsonProperty("turnIndex")
    public abstract Builder turnIndex(Integer turnIndex);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder turnIndex(Optional<Integer> turnIndex);

    /** Clears the value of turnIndex field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTurnIndex() {
      return turnIndex(Optional.empty());
    }

    /**
     * Setter for turnId.
     *
     * <p>turnId: A unique identifier for the turn.
     */
    @JsonProperty("turnId")
    public abstract Builder turnId(String turnId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder turnId(Optional<String> turnId);

    /** Clears the value of turnId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTurnId() {
      return turnId(Optional.empty());
    }

    /**
     * Setter for events.
     *
     * <p>events: The list of events that occurred during this turn.
     */
    @JsonProperty("events")
    public abstract Builder events(List<AgentEvent> events);

    /**
     * Setter for events.
     *
     * <p>events: The list of events that occurred during this turn.
     */
    @CanIgnoreReturnValue
    public Builder events(AgentEvent... events) {
      return events(Arrays.asList(events));
    }

    /**
     * Setter for events builder.
     *
     * <p>events: The list of events that occurred during this turn.
     */
    @CanIgnoreReturnValue
    public Builder events(AgentEvent.Builder... eventsBuilders) {
      return events(
          Arrays.asList(eventsBuilders).stream()
              .map(AgentEvent.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder events(Optional<List<AgentEvent>> events);

    /** Clears the value of events field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvents() {
      return events(Optional.empty());
    }

    public abstract ConversationTurn build();
  }

  /** Deserializes a JSON string to a ConversationTurn object. */
  @ExcludeFromGeneratedCoverageReport
  public static ConversationTurn fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ConversationTurn.class);
  }
}
