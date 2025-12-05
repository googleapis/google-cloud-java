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
import java.util.Map;
import java.util.Optional;

/** Represents a summary metric for an evaluation run. */
@AutoValue
@JsonDeserialize(builder = SummaryMetric.Builder.class)
public abstract class SummaryMetric extends JsonSerializable {
  /** Map of metric name to metric value. */
  @JsonProperty("metrics")
  public abstract Optional<Map<String, Object>> metrics();

  /** The total number of items that were evaluated. */
  @JsonProperty("totalItems")
  public abstract Optional<Integer> totalItems();

  /** The number of items that failed to be evaluated. */
  @JsonProperty("failedItems")
  public abstract Optional<Integer> failedItems();

  /** Instantiates a builder for SummaryMetric. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SummaryMetric.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SummaryMetric. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SummaryMetric.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SummaryMetric.Builder();
    }

    /**
     * Setter for metrics.
     *
     * <p>metrics: Map of metric name to metric value.
     */
    @JsonProperty("metrics")
    public abstract Builder metrics(Map<String, Object> metrics);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metrics(Optional<Map<String, Object>> metrics);

    /** Clears the value of metrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetrics() {
      return metrics(Optional.empty());
    }

    /**
     * Setter for totalItems.
     *
     * <p>totalItems: The total number of items that were evaluated.
     */
    @JsonProperty("totalItems")
    public abstract Builder totalItems(Integer totalItems);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder totalItems(Optional<Integer> totalItems);

    /** Clears the value of totalItems field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTotalItems() {
      return totalItems(Optional.empty());
    }

    /**
     * Setter for failedItems.
     *
     * <p>failedItems: The number of items that failed to be evaluated.
     */
    @JsonProperty("failedItems")
    public abstract Builder failedItems(Integer failedItems);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder failedItems(Optional<Integer> failedItems);

    /** Clears the value of failedItems field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFailedItems() {
      return failedItems(Optional.empty());
    }

    public abstract SummaryMetric build();
  }

  /** Deserializes a JSON string to a SummaryMetric object. */
  @ExcludeFromGeneratedCoverageReport
  public static SummaryMetric fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SummaryMetric.class);
  }
}
