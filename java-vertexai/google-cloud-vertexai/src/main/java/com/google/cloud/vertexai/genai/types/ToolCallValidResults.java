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

/** Results for tool call valid metric. */
@AutoValue
@JsonDeserialize(builder = ToolCallValidResults.Builder.class)
public abstract class ToolCallValidResults extends JsonSerializable {
  /** Output only. Tool call valid metric values. */
  @JsonProperty("toolCallValidMetricValues")
  public abstract Optional<List<ToolCallValidMetricValue>> toolCallValidMetricValues();

  /** Instantiates a builder for ToolCallValidResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolCallValidResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolCallValidResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolCallValidResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolCallValidResults.Builder();
    }

    /**
     * Setter for toolCallValidMetricValues.
     *
     * <p>toolCallValidMetricValues: Output only. Tool call valid metric values.
     */
    @JsonProperty("toolCallValidMetricValues")
    public abstract Builder toolCallValidMetricValues(
        List<ToolCallValidMetricValue> toolCallValidMetricValues);

    /**
     * Setter for toolCallValidMetricValues.
     *
     * <p>toolCallValidMetricValues: Output only. Tool call valid metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolCallValidMetricValues(
        ToolCallValidMetricValue... toolCallValidMetricValues) {
      return toolCallValidMetricValues(Arrays.asList(toolCallValidMetricValues));
    }

    /**
     * Setter for toolCallValidMetricValues builder.
     *
     * <p>toolCallValidMetricValues: Output only. Tool call valid metric values.
     */
    @CanIgnoreReturnValue
    public Builder toolCallValidMetricValues(
        ToolCallValidMetricValue.Builder... toolCallValidMetricValuesBuilders) {
      return toolCallValidMetricValues(
          Arrays.asList(toolCallValidMetricValuesBuilders).stream()
              .map(ToolCallValidMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolCallValidMetricValues(
        Optional<List<ToolCallValidMetricValue>> toolCallValidMetricValues);

    /** Clears the value of toolCallValidMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolCallValidMetricValues() {
      return toolCallValidMetricValues(Optional.empty());
    }

    public abstract ToolCallValidResults build();
  }

  /** Deserializes a JSON string to a ToolCallValidResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolCallValidResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolCallValidResults.class);
  }
}
