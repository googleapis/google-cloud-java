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

/** Results for exact match metric. */
@AutoValue
@JsonDeserialize(builder = ExactMatchResults.Builder.class)
public abstract class ExactMatchResults extends JsonSerializable {
  /** Output only. Exact match metric values. */
  @JsonProperty("exactMatchMetricValues")
  public abstract Optional<List<ExactMatchMetricValue>> exactMatchMetricValues();

  /** Instantiates a builder for ExactMatchResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ExactMatchResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ExactMatchResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ExactMatchResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ExactMatchResults.Builder();
    }

    /**
     * Setter for exactMatchMetricValues.
     *
     * <p>exactMatchMetricValues: Output only. Exact match metric values.
     */
    @JsonProperty("exactMatchMetricValues")
    public abstract Builder exactMatchMetricValues(
        List<ExactMatchMetricValue> exactMatchMetricValues);

    /**
     * Setter for exactMatchMetricValues.
     *
     * <p>exactMatchMetricValues: Output only. Exact match metric values.
     */
    @CanIgnoreReturnValue
    public Builder exactMatchMetricValues(ExactMatchMetricValue... exactMatchMetricValues) {
      return exactMatchMetricValues(Arrays.asList(exactMatchMetricValues));
    }

    /**
     * Setter for exactMatchMetricValues builder.
     *
     * <p>exactMatchMetricValues: Output only. Exact match metric values.
     */
    @CanIgnoreReturnValue
    public Builder exactMatchMetricValues(
        ExactMatchMetricValue.Builder... exactMatchMetricValuesBuilders) {
      return exactMatchMetricValues(
          Arrays.asList(exactMatchMetricValuesBuilders).stream()
              .map(ExactMatchMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder exactMatchMetricValues(
        Optional<List<ExactMatchMetricValue>> exactMatchMetricValues);

    /** Clears the value of exactMatchMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExactMatchMetricValues() {
      return exactMatchMetricValues(Optional.empty());
    }

    public abstract ExactMatchResults build();
  }

  /** Deserializes a JSON string to a ExactMatchResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static ExactMatchResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ExactMatchResults.class);
  }
}
