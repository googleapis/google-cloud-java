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

/** Results for bleu metric. */
@AutoValue
@JsonDeserialize(builder = BleuResults.Builder.class)
public abstract class BleuResults extends JsonSerializable {
  /** Output only. Bleu metric values. */
  @JsonProperty("bleuMetricValues")
  public abstract Optional<List<BleuMetricValue>> bleuMetricValues();

  /** Instantiates a builder for BleuResults. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_BleuResults.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for BleuResults. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `BleuResults.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_BleuResults.Builder();
    }

    /**
     * Setter for bleuMetricValues.
     *
     * <p>bleuMetricValues: Output only. Bleu metric values.
     */
    @JsonProperty("bleuMetricValues")
    public abstract Builder bleuMetricValues(List<BleuMetricValue> bleuMetricValues);

    /**
     * Setter for bleuMetricValues.
     *
     * <p>bleuMetricValues: Output only. Bleu metric values.
     */
    @CanIgnoreReturnValue
    public Builder bleuMetricValues(BleuMetricValue... bleuMetricValues) {
      return bleuMetricValues(Arrays.asList(bleuMetricValues));
    }

    /**
     * Setter for bleuMetricValues builder.
     *
     * <p>bleuMetricValues: Output only. Bleu metric values.
     */
    @CanIgnoreReturnValue
    public Builder bleuMetricValues(BleuMetricValue.Builder... bleuMetricValuesBuilders) {
      return bleuMetricValues(
          Arrays.asList(bleuMetricValuesBuilders).stream()
              .map(BleuMetricValue.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bleuMetricValues(Optional<List<BleuMetricValue>> bleuMetricValues);

    /** Clears the value of bleuMetricValues field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBleuMetricValues() {
      return bleuMetricValues(Optional.empty());
    }

    public abstract BleuResults build();
  }

  /** Deserializes a JSON string to a BleuResults object. */
  @ExcludeFromGeneratedCoverageReport
  public static BleuResults fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, BleuResults.class);
  }
}
