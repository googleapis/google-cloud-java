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

/** The configuration for grounding checking. */
@AutoValue
@JsonDeserialize(builder = SchemaPredictParamsGroundingConfig.Builder.class)
public abstract class SchemaPredictParamsGroundingConfig extends JsonSerializable {
  /** If set, skip finding claim attributions (i.e not generate grounding citation). */
  @JsonProperty("disableAttribution")
  public abstract Optional<Boolean> disableAttribution();

  /** The sources for the grounding checking. */
  @JsonProperty("sources")
  public abstract Optional<List<SchemaPredictParamsGroundingConfigSourceEntry>> sources();

  /** Instantiates a builder for SchemaPredictParamsGroundingConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPredictParamsGroundingConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPredictParamsGroundingConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPredictParamsGroundingConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPredictParamsGroundingConfig.Builder();
    }

    /**
     * Setter for disableAttribution.
     *
     * <p>disableAttribution: If set, skip finding claim attributions (i.e not generate grounding
     * citation).
     */
    @JsonProperty("disableAttribution")
    public abstract Builder disableAttribution(boolean disableAttribution);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder disableAttribution(Optional<Boolean> disableAttribution);

    /** Clears the value of disableAttribution field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisableAttribution() {
      return disableAttribution(Optional.empty());
    }

    /**
     * Setter for sources.
     *
     * <p>sources: The sources for the grounding checking.
     */
    @JsonProperty("sources")
    public abstract Builder sources(List<SchemaPredictParamsGroundingConfigSourceEntry> sources);

    /**
     * Setter for sources.
     *
     * <p>sources: The sources for the grounding checking.
     */
    @CanIgnoreReturnValue
    public Builder sources(SchemaPredictParamsGroundingConfigSourceEntry... sources) {
      return sources(Arrays.asList(sources));
    }

    /**
     * Setter for sources builder.
     *
     * <p>sources: The sources for the grounding checking.
     */
    @CanIgnoreReturnValue
    public Builder sources(
        SchemaPredictParamsGroundingConfigSourceEntry.Builder... sourcesBuilders) {
      return sources(
          Arrays.asList(sourcesBuilders).stream()
              .map(SchemaPredictParamsGroundingConfigSourceEntry.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sources(Optional<List<SchemaPredictParamsGroundingConfigSourceEntry>> sources);

    /** Clears the value of sources field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSources() {
      return sources(Optional.empty());
    }

    public abstract SchemaPredictParamsGroundingConfig build();
  }

  /** Deserializes a JSON string to a SchemaPredictParamsGroundingConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPredictParamsGroundingConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPredictParamsGroundingConfig.class);
  }
}
