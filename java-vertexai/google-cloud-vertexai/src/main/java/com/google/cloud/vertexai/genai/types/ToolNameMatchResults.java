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

/** Results for tool name match metric. */
@AutoValue
@JsonDeserialize(builder = ToolNameMatchResults.Builder.class)
public abstract class ToolNameMatchResults extends JsonSerializable {
  /** Output only. Tool name match metric values. */
  @JsonProperty("toolNameMatchMetricValues")
  public abstract Optional<List<ToolNameMatchMetricValue>> toolNameMatchMetricValues();

  /** Instantiates a builder for ToolNameMatchResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolNameMatchResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolNameMatchResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolNameMatchResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolNameMatchResults.Builder();
    }

    /**
     * Setter for toolNameMatchMetricValues.
     *
     * <p>toolNameMatchMetricValues: Output only. Tool name match metric values.
     */
    @JsonProperty("toolNameMatchMetricValues")
    public abstract Builder toolNameMatchMetricValues(
        List<ToolNameMatchMetricValue> toolNameMatchMetricValues);

    /**
     * Setter for toolNameMatchMetricValues.
     *
     * <p>toolNameMatchMetricValues: Output only. Tool name match metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolNameMatchMetricValues(
        ToolNameMatchMetricValue... toolNameMatchMetricValues) {
      return toolNameMatchMetricValues(Arrays.asList(toolNameMatchMetricValues));
    }

    /**
     * Setter for toolNameMatchMetricValues builder.
     *
     * <p>toolNameMatchMetricValues: Output only. Tool name match metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolNameMatchMetricValues(
        ToolNameMatchMetricValue.Builder... toolNameMatchMetricValuesBuilders) {
      return toolNameMatchMetricValues(
          Arrays.asList(toolNameMatchMetricValuesBuilders).stream()
              .map(ToolNameMatchMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolNameMatchMetricValues(
        Optional<List<ToolNameMatchMetricValue>> toolNameMatchMetricValues);

    /** Clears the value of toolNameMatchMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolNameMatchMetricValues() {
      return toolNameMatchMetricValues(Optional.empty());
    }

    public abstract ToolNameMatchResults build();
  }

  /** Deserializes a JSON string to a ToolNameMatchResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolNameMatchResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolNameMatchResults.class);
  }
}
