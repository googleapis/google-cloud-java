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

/** Statistics for win rates for a single metric. */
@AutoValue
@JsonDeserialize(builder = WinRateStats.Builder.class)
public abstract class WinRateStats extends JsonSerializable {
  /** Win rates for the metric, one for each candidate. */
  @JsonProperty("winRates")
  public abstract Optional<List<Float>> winRates();

  /** Tie rate for the metric. */
  @JsonProperty("tieRate")
  public abstract Optional<Float> tieRate();

  /** Instantiates a builder for WinRateStats. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_WinRateStats.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for WinRateStats. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `WinRateStats.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_WinRateStats.Builder();
    }

    /**
     * Setter for winRates.
     *
     * <p>winRates: Win rates for the metric, one for each candidate.
     */
    @JsonProperty("winRates")
    public abstract Builder winRates(List<Float> winRates);

    /**
     * Setter for winRates.
     *
     * <p>winRates: Win rates for the metric, one for each candidate.
     */
    @CanIgnoreReturnValue
    public Builder winRates(Float... winRates) {
      return winRates(Arrays.asList(winRates));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder winRates(Optional<List<Float>> winRates);

    /** Clears the value of winRates field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWinRates() {
      return winRates(Optional.empty());
    }

    /**
     * Setter for tieRate.
     *
     * <p>tieRate: Tie rate for the metric.
     */
    @JsonProperty("tieRate")
    public abstract Builder tieRate(Float tieRate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tieRate(Optional<Float> tieRate);

    /** Clears the value of tieRate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTieRate() {
      return tieRate(Optional.empty());
    }

    public abstract WinRateStats build();
  }

  /** Deserializes a JSON string to a WinRateStats object. */
  @ExcludeFromGeneratedCoverageReport
  public static WinRateStats fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, WinRateStats.class);
  }
}
