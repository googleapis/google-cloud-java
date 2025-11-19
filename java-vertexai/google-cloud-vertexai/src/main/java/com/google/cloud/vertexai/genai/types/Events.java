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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a list of events for an agent. */
@AutoValue
@JsonDeserialize(builder = Events.Builder.class)
public abstract class Events extends JsonSerializable {
  /** A list of events. */
  @JsonProperty("event")
  public abstract Optional<List<Content>> event();

  /** Instantiates a builder for Events. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Events.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Events. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Events.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Events.Builder();
    }

    /**
     * Setter for event.
     *
     * <p>event: A list of events.
     */
    @JsonProperty("event")
    public abstract Builder event(List<Content> event);

    /**
     * Setter for event.
     *
     * <p>event: A list of events.
     */
    @CanIgnoreReturnValue
    public Builder event(Content... event) {
      return event(Arrays.asList(event));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder event(Optional<List<Content>> event);

    /** Clears the value of event field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvent() {
      return event(Optional.empty());
    }

    public abstract Events build();
  }

  /** Deserializes a JSON string to a Events object. */
  @ExcludeFromGeneratedCoverageReport
  public static Events fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Events.class);
  }
}
