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
import java.util.Map;
import java.util.Optional;

/** Responses from model or agent. */
@AutoValue
@JsonDeserialize(builder = CandidateResponse.Builder.class)
public abstract class CandidateResponse extends JsonSerializable {
  /** The name of the candidate that produced the response. */
  @JsonProperty("candidate")
  public abstract Optional<String> candidate();

  /** The text response. */
  @JsonProperty("text")
  public abstract Optional<String> text();

  /** Fields and values that can be used to populate the response template. */
  @JsonProperty("value")
  public abstract Optional<Map<String, Object>> value();

  /** Intermediate events (such as tool calls and responses) that led to the final response. */
  @JsonProperty("events")
  public abstract Optional<List<Content>> events();

  /** Instantiates a builder for CandidateResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CandidateResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CandidateResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CandidateResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CandidateResponse.Builder();
    }

    /**
     * Setter for candidate.
     *
     * <p>candidate: The name of the candidate that produced the response.
     */
    @JsonProperty("candidate")
    public abstract Builder candidate(String candidate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidate(Optional<String> candidate);

    /** Clears the value of candidate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidate() {
      return candidate(Optional.empty());
    }

    /**
     * Setter for text.
     *
     * <p>text: The text response.
     */
    @JsonProperty("text")
    public abstract Builder text(String text);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder text(Optional<String> text);

    /** Clears the value of text field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearText() {
      return text(Optional.empty());
    }

    /**
     * Setter for value.
     *
     * <p>value: Fields and values that can be used to populate the response template.
     */
    @JsonProperty("value")
    public abstract Builder value(Map<String, Object> value);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder value(Optional<Map<String, Object>> value);

    /** Clears the value of value field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValue() {
      return value(Optional.empty());
    }

    /**
     * Setter for events.
     *
     * <p>events: Intermediate events (such as tool calls and responses) that led to the final
     * response.
     */
    @JsonProperty("events")
    public abstract Builder events(List<Content> events);

    /**
     * Setter for events.
     *
     * <p>events: Intermediate events (such as tool calls and responses) that led to the final
     * response.
     */
    @CanIgnoreReturnValue
    public Builder events(Content... events) {
      return events(Arrays.asList(events));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder events(Optional<List<Content>> events);

    /** Clears the value of events field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvents() {
      return events(Optional.empty());
    }

    public abstract CandidateResponse build();
  }

  /** Deserializes a JSON string to a CandidateResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static CandidateResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CandidateResponse.class);
  }
}
