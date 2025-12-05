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

/** Represents the config for reading Gemini requests. */
@AutoValue
@JsonDeserialize(builder = GeminiRequestReadConfig.Builder.class)
public abstract class GeminiRequestReadConfig extends JsonSerializable {
  /** Gemini request template with placeholders. */
  @JsonProperty("templateConfig")
  public abstract Optional<GeminiTemplateConfig> templateConfig();

  /**
   * Optional. Column name in the dataset table that contains already fully assembled Gemini
   * requests.
   */
  @JsonProperty("assembledRequestColumnName")
  public abstract Optional<String> assembledRequestColumnName();

  /** Instantiates a builder for GeminiRequestReadConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GeminiRequestReadConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GeminiRequestReadConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GeminiRequestReadConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GeminiRequestReadConfig.Builder();
    }

    /**
     * Setter for templateConfig.
     *
     * <p>templateConfig: Gemini request template with placeholders.
     */
    @JsonProperty("templateConfig")
    public abstract Builder templateConfig(GeminiTemplateConfig templateConfig);

    /**
     * Setter for templateConfig builder.
     *
     * <p>templateConfig: Gemini request template with placeholders.
     */
    @CanIgnoreReturnValue
    public Builder templateConfig(GeminiTemplateConfig.Builder templateConfigBuilder) {
      return templateConfig(templateConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder templateConfig(Optional<GeminiTemplateConfig> templateConfig);

    /** Clears the value of templateConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTemplateConfig() {
      return templateConfig(Optional.empty());
    }

    /**
     * Setter for assembledRequestColumnName.
     *
     * <p>assembledRequestColumnName: Optional. Column name in the dataset table that contains
     * already fully assembled Gemini requests.
     */
    @JsonProperty("assembledRequestColumnName")
    public abstract Builder assembledRequestColumnName(String assembledRequestColumnName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder assembledRequestColumnName(Optional<String> assembledRequestColumnName);

    /** Clears the value of assembledRequestColumnName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAssembledRequestColumnName() {
      return assembledRequestColumnName(Optional.empty());
    }

    public abstract GeminiRequestReadConfig build();
  }

  /** Deserializes a JSON string to a GeminiRequestReadConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static GeminiRequestReadConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GeminiRequestReadConfig.class);
  }
}
