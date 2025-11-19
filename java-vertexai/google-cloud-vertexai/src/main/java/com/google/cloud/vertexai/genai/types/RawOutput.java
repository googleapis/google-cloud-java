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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Raw output. */
@AutoValue
@JsonDeserialize(builder = RawOutput.Builder.class)
public abstract class RawOutput extends JsonSerializable {
  /** Output only. Raw output string. */
  @JsonProperty("rawOutput")
  public abstract Optional<List<String>> rawOutput();

  /** Instantiates a builder for RawOutput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RawOutput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RawOutput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RawOutput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RawOutput.Builder();
    }

    /**
     * Setter for rawOutput.
     *
     * <p>rawOutput: Output only. Raw output string.
     */
    @JsonProperty("rawOutput")
    public abstract Builder rawOutput(List<String> rawOutput);

    /**
     * Setter for rawOutput.
     *
     * <p>rawOutput: Output only. Raw output string.
     */
    @CanIgnoreReturnValue
    public Builder rawOutput(String... rawOutput) {
      return rawOutput(Arrays.asList(rawOutput));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rawOutput(Optional<List<String>> rawOutput);

    /** Clears the value of rawOutput field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRawOutput() {
      return rawOutput(Optional.empty());
    }

    public abstract RawOutput build();
  }

  /** Deserializes a JSON string to a RawOutput object. */
  @ExcludeFromGeneratedCoverageReport
  public static RawOutput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RawOutput.class);
  }
}
