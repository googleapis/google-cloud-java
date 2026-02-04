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

/** Results for tool parameter key match metric. */
@AutoValue
@JsonDeserialize(builder = ToolParameterKeyMatchResults.Builder.class)
public abstract class ToolParameterKeyMatchResults extends JsonSerializable {
  /** Output only. Tool parameter key match metric values. */
  @JsonProperty("toolParameterKeyMatchMetricValues")
  public abstract Optional<List<ToolParameterKeyMatchMetricValue>>
      toolParameterKeyMatchMetricValues();

  /** Instantiates a builder for ToolParameterKeyMatchResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolParameterKeyMatchResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolParameterKeyMatchResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ToolParameterKeyMatchResults.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolParameterKeyMatchResults.Builder();
    }

    /**
     * Setter for toolParameterKeyMatchMetricValues.
     *
     * <p>toolParameterKeyMatchMetricValues: Output only. Tool parameter key match metric values.
     */
    @JsonProperty("toolParameterKeyMatchMetricValues")
    public abstract Builder toolParameterKeyMatchMetricValues(
        List<ToolParameterKeyMatchMetricValue> toolParameterKeyMatchMetricValues);

    /**
     * Setter for toolParameterKeyMatchMetricValues.
     *
     * <p>toolParameterKeyMatchMetricValues: Output only. Tool parameter key match metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKeyMatchMetricValues(
        ToolParameterKeyMatchMetricValue... toolParameterKeyMatchMetricValues) {
      return toolParameterKeyMatchMetricValues(Arrays.asList(toolParameterKeyMatchMetricValues));
    }

    /**
     * Setter for toolParameterKeyMatchMetricValues builder.
     *
     * <p>toolParameterKeyMatchMetricValues: Output only. Tool parameter key match metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKeyMatchMetricValues(
        ToolParameterKeyMatchMetricValue.Builder... toolParameterKeyMatchMetricValuesBuilders) {
      return toolParameterKeyMatchMetricValues(
          Arrays.asList(toolParameterKeyMatchMetricValuesBuilders).stream()
              .map(ToolParameterKeyMatchMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKeyMatchMetricValues(
        Optional<List<ToolParameterKeyMatchMetricValue>> toolParameterKeyMatchMetricValues);

    /** Clears the value of toolParameterKeyMatchMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKeyMatchMetricValues() {
      return toolParameterKeyMatchMetricValues(Optional.empty());
    }

    public abstract ToolParameterKeyMatchResults build();
  }

  /** Deserializes a JSON string to a ToolParameterKeyMatchResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolParameterKeyMatchResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolParameterKeyMatchResults.class);
  }
}
