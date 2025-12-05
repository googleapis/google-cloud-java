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

/** Results for tool parameter key value match metric. */
@AutoValue
@JsonDeserialize(builder = ToolParameterKVMatchResults.Builder.class)
public abstract class ToolParameterKVMatchResults extends JsonSerializable {
  /** Output only. Tool parameter key value match metric values. */
  @JsonProperty("toolParameterKvMatchMetricValues")
  public abstract Optional<List<ToolParameterKVMatchMetricValue>>
      toolParameterKvMatchMetricValues();

  /** Instantiates a builder for ToolParameterKVMatchResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolParameterKVMatchResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolParameterKVMatchResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolParameterKVMatchResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolParameterKVMatchResults.Builder();
    }

    /**
     * Setter for toolParameterKvMatchMetricValues.
     *
     * <p>toolParameterKvMatchMetricValues: Output only. Tool parameter key value match metric
     * values.
     */
    @JsonProperty("toolParameterKvMatchMetricValues")
    public abstract Builder toolParameterKvMatchMetricValues(
        List<ToolParameterKVMatchMetricValue> toolParameterKvMatchMetricValues);

    /**
     * Setter for toolParameterKvMatchMetricValues.
     *
     * <p>toolParameterKvMatchMetricValues: Output only. Tool parameter key value match metric
     * values.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKvMatchMetricValues(
        ToolParameterKVMatchMetricValue... toolParameterKvMatchMetricValues) {
      return toolParameterKvMatchMetricValues(Arrays.asList(toolParameterKvMatchMetricValues));
    }

    /**
     * Setter for toolParameterKvMatchMetricValues builder.
     *
     * <p>toolParameterKvMatchMetricValues: Output only. Tool parameter key value match metric
     * values.
     */
    @CanIgnoreReturnValue
    public Builder toolParameterKvMatchMetricValues(
        ToolParameterKVMatchMetricValue.Builder... toolParameterKvMatchMetricValuesBuilders) {
      return toolParameterKvMatchMetricValues(
          Arrays.asList(toolParameterKvMatchMetricValuesBuilders).stream()
              .map(ToolParameterKVMatchMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolParameterKvMatchMetricValues(
        Optional<List<ToolParameterKVMatchMetricValue>> toolParameterKvMatchMetricValues);

    /** Clears the value of toolParameterKvMatchMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolParameterKvMatchMetricValues() {
      return toolParameterKvMatchMetricValues(Optional.empty());
    }

    public abstract ToolParameterKVMatchResults build();
  }

  /** Deserializes a JSON string to a ToolParameterKVMatchResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolParameterKVMatchResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolParameterKVMatchResults.class);
  }
}
