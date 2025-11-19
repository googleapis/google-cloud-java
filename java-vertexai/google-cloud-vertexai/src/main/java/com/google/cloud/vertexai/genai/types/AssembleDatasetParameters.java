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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Parameters for assembling a multimodal dataset resource. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = AssembleDatasetParameters.Builder.class)
public abstract class AssembleDatasetParameters extends JsonSerializable {
  /** */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** */
  @JsonProperty("geminiRequestReadConfig")
  public abstract Optional<GeminiRequestReadConfig> geminiRequestReadConfig();

  /** */
  @JsonProperty("config")
  public abstract Optional<AssembleDatasetConfig> config();

  /** Instantiates a builder for AssembleDatasetParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AssembleDatasetParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AssembleDatasetParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AssembleDatasetParameters.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AssembleDatasetParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name:
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for geminiRequestReadConfig.
     *
     * <p>geminiRequestReadConfig:
     */
    @JsonProperty("geminiRequestReadConfig")
    public abstract Builder geminiRequestReadConfig(
        GeminiRequestReadConfig geminiRequestReadConfig);

    /**
     * Setter for geminiRequestReadConfig builder.
     *
     * <p>geminiRequestReadConfig:
     */
    @CanIgnoreReturnValue
    public Builder geminiRequestReadConfig(
        GeminiRequestReadConfig.Builder geminiRequestReadConfigBuilder) {
      return geminiRequestReadConfig(geminiRequestReadConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder geminiRequestReadConfig(
        Optional<GeminiRequestReadConfig> geminiRequestReadConfig);

    /** Clears the value of geminiRequestReadConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGeminiRequestReadConfig() {
      return geminiRequestReadConfig(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(AssembleDatasetConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(AssembleDatasetConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<AssembleDatasetConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract AssembleDatasetParameters build();
  }

  /** Deserializes a JSON string to a AssembleDatasetParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static AssembleDatasetParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AssembleDatasetParameters.class);
  }
}
