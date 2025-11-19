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

/** Spec for custom output. */
@AutoValue
@JsonDeserialize(builder = CustomOutput.Builder.class)
public abstract class CustomOutput extends JsonSerializable {
  /** Output only. List of raw output strings. */
  @JsonProperty("rawOutputs")
  public abstract Optional<RawOutput> rawOutputs();

  /** Instantiates a builder for CustomOutput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CustomOutput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CustomOutput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CustomOutput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CustomOutput.Builder();
    }

    /**
     * Setter for rawOutputs.
     *
     * <p>rawOutputs: Output only. List of raw output strings.
     */
    @JsonProperty("rawOutputs")
    public abstract Builder rawOutputs(RawOutput rawOutputs);

    /**
     * Setter for rawOutputs builder.
     *
     * <p>rawOutputs: Output only. List of raw output strings.
     */
    @CanIgnoreReturnValue
    public Builder rawOutputs(RawOutput.Builder rawOutputsBuilder) {
      return rawOutputs(rawOutputsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rawOutputs(Optional<RawOutput> rawOutputs);

    /** Clears the value of rawOutputs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRawOutputs() {
      return rawOutputs(Optional.empty());
    }

    public abstract CustomOutput build();
  }

  /** Deserializes a JSON string to a CustomOutput object. */
  @ExcludeFromGeneratedCoverageReport
  public static CustomOutput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CustomOutput.class);
  }
}
