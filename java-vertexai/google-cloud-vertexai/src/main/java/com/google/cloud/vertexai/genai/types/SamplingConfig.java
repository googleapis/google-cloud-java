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

/** Sampling config for a BigQuery request set. */
@AutoValue
@JsonDeserialize(builder = SamplingConfig.Builder.class)
public abstract class SamplingConfig extends JsonSerializable {
  /** */
  @JsonProperty("samplingCount")
  public abstract Optional<Integer> samplingCount();

  /** */
  @JsonProperty("samplingMethod")
  public abstract Optional<SamplingMethod> samplingMethod();

  /** */
  @JsonProperty("samplingDuration")
  public abstract Optional<String> samplingDuration();

  /** Instantiates a builder for SamplingConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SamplingConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SamplingConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SamplingConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SamplingConfig.Builder();
    }

    /**
     * Setter for samplingCount.
     *
     * <p>samplingCount:
     */
    @JsonProperty("samplingCount")
    public abstract Builder samplingCount(Integer samplingCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder samplingCount(Optional<Integer> samplingCount);

    /** Clears the value of samplingCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSamplingCount() {
      return samplingCount(Optional.empty());
    }

    /**
     * Setter for samplingMethod.
     *
     * <p>samplingMethod:
     */
    @JsonProperty("samplingMethod")
    public abstract Builder samplingMethod(SamplingMethod samplingMethod);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder samplingMethod(Optional<SamplingMethod> samplingMethod);

    /** Clears the value of samplingMethod field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSamplingMethod() {
      return samplingMethod(Optional.empty());
    }

    /**
     * Setter for samplingMethod given a known enum.
     *
     * <p>samplingMethod:
     */
    @CanIgnoreReturnValue
    public Builder samplingMethod(SamplingMethod.Known knownType) {
      return samplingMethod(new SamplingMethod(knownType));
    }

    /**
     * Setter for samplingMethod given a string.
     *
     * <p>samplingMethod:
     */
    @CanIgnoreReturnValue
    public Builder samplingMethod(String samplingMethod) {
      return samplingMethod(new SamplingMethod(samplingMethod));
    }

    /**
     * Setter for samplingDuration.
     *
     * <p>samplingDuration:
     */
    @JsonProperty("samplingDuration")
    public abstract Builder samplingDuration(String samplingDuration);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder samplingDuration(Optional<String> samplingDuration);

    /** Clears the value of samplingDuration field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSamplingDuration() {
      return samplingDuration(Optional.empty());
    }

    public abstract SamplingConfig build();
  }

  /** Deserializes a JSON string to a SamplingConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static SamplingConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SamplingConfig.class);
  }
}
