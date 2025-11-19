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

/** Results for rouge metric. */
@AutoValue
@JsonDeserialize(builder = RougeResults.Builder.class)
public abstract class RougeResults extends JsonSerializable {
  /** Output only. Rouge metric values. */
  @JsonProperty("rougeMetricValues")
  public abstract Optional<List<RougeMetricValue>> rougeMetricValues();

  /** Instantiates a builder for RougeResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RougeResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RougeResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RougeResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RougeResults.Builder();
    }

    /**
     * Setter for rougeMetricValues.
     *
     * <p>rougeMetricValues: Output only. Rouge metric values.
     */
    @JsonProperty("rougeMetricValues")
    public abstract Builder rougeMetricValues(List<RougeMetricValue> rougeMetricValues);

    /**
     * Setter for rougeMetricValues.
     *
     * <p>rougeMetricValues: Output only. Rouge metric values.
     */
    @CanIgnoreReturnValue
    public Builder rougeMetricValues(RougeMetricValue... rougeMetricValues) {
      return rougeMetricValues(Arrays.asList(rougeMetricValues));
    }

    /**
     * Setter for rougeMetricValues builder.
     *
     * <p>rougeMetricValues: Output only. Rouge metric values.
     */
    @CanIgnoreReturnValue
    public Builder rougeMetricValues(RougeMetricValue.Builder... rougeMetricValuesBuilders) {
      return rougeMetricValues(
          Arrays.asList(rougeMetricValuesBuilders).stream()
              .map(RougeMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rougeMetricValues(Optional<List<RougeMetricValue>> rougeMetricValues);

    /** Clears the value of rougeMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRougeMetricValues() {
      return rougeMetricValues(Optional.empty());
    }

    public abstract RougeResults build();
  }

  /** Deserializes a JSON string to a RougeResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static RougeResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RougeResults.class);
  }
}
