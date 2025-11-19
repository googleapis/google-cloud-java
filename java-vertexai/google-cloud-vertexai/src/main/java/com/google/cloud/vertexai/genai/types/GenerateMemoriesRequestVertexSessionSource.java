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
import java.time.Instant;
import java.util.Optional;

/** The vertex session source for generating memories. */
@AutoValue
@JsonDeserialize(builder = GenerateMemoriesRequestVertexSessionSource.Builder.class)
public abstract class GenerateMemoriesRequestVertexSessionSource extends JsonSerializable {
  /** Optional. End time (exclusive) of the time range. If not set, the end time is unbounded. */
  @JsonProperty("endTime")
  public abstract Optional<Instant> endTime();

  /**
   * Required. The resource name of the Session to generate memories for. Format:
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}`
   */
  @JsonProperty("session")
  public abstract Optional<String> session();

  /**
   * Optional. Time range to define which session events should be used to generate memories. Start
   * time (inclusive) of the time range. If not set, the start time is unbounded.
   */
  @JsonProperty("startTime")
  public abstract Optional<Instant> startTime();

  /** Instantiates a builder for GenerateMemoriesRequestVertexSessionSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateMemoriesRequestVertexSessionSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateMemoriesRequestVertexSessionSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateMemoriesRequestVertexSessionSource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateMemoriesRequestVertexSessionSource.Builder();
    }

    /**
     * Setter for endTime.
     *
     * <p>endTime: Optional. End time (exclusive) of the time range. If not set, the end time is
     * unbounded.
     */
    @JsonProperty("endTime")
    public abstract Builder endTime(Instant endTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder endTime(Optional<Instant> endTime);

    /** Clears the value of endTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEndTime() {
      return endTime(Optional.empty());
    }

    /**
     * Setter for session.
     *
     * <p>session: Required. The resource name of the Session to generate memories for. Format:
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}`
     */
    @JsonProperty("session")
    public abstract Builder session(String session);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder session(Optional<String> session);

    /** Clears the value of session field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSession() {
      return session(Optional.empty());
    }

    /**
     * Setter for startTime.
     *
     * <p>startTime: Optional. Time range to define which session events should be used to generate
     * memories. Start time (inclusive) of the time range. If not set, the start time is unbounded.
     */
    @JsonProperty("startTime")
    public abstract Builder startTime(Instant startTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder startTime(Optional<Instant> startTime);

    /** Clears the value of startTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStartTime() {
      return startTime(Optional.empty());
    }

    public abstract GenerateMemoriesRequestVertexSessionSource build();
  }

  /** Deserializes a JSON string to a GenerateMemoriesRequestVertexSessionSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateMemoriesRequestVertexSessionSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GenerateMemoriesRequestVertexSessionSource.class);
  }
}
