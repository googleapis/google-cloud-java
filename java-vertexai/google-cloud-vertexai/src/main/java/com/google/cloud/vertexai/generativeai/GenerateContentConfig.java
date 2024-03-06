/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.generativeai;

import com.google.api.core.BetaApi;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;

/** This class holds all the configs when making a generate content API call */
public class GenerateContentConfig {
  private final Optional<GenerationConfig> generationConfig;
  private final Optional<ImmutableList<SafetySetting>> safetySettings;
  private final Optional<ImmutableList<Tool>> tools;

  /** Creates a builder for the GenerateContentConfig. */
  public static Builder newBuilder() {
    return new Builder();
  }

  private GenerateContentConfig(Builder builder) {
    this.generationConfig = builder.generationConfig;
    this.safetySettings = builder.safetySettings;
    this.tools = builder.tools;
  }

  /** Builder class for {@link GenerateContentConfig}. */
  public static class Builder {
    private Optional<GenerationConfig> generationConfig = Optional.empty();
    private Optional<ImmutableList<SafetySetting>> safetySettings = Optional.empty();
    private Optional<ImmutableList<Tool>> tools = Optional.empty();

    private Builder() {}

    /** Builds a GenerateContentConfig instance. */
    public GenerateContentConfig build() {
      return new GenerateContentConfig(this);
    }

    /**
     * Set {@link com.google.cloud.vertexai.api.GenerationConfig} that will be used in the generate
     * content API call.
     *
     * @return builder for the GenerateContentConfig
     */
    @BetaApi
    public Builder setGenerationConfig(GenerationConfig generationConfig) {
      this.generationConfig = Optional.of(generationConfig);
      return this;
    }

    /**
     * Set a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will be used in the
     * generate content API call.
     *
     * @return builder for the GenerateContentConfig
     */
    @BetaApi
    public Builder setSafetySettings(List<SafetySetting> safetySettings) {
      this.safetySettings = Optional.of(ImmutableList.copyOf(safetySettings));
      return this;
    }

    /**
     * Set a list of {@link com.google.cloud.vertexai.api.Tool} that will be used in the generate
     * content API call.
     *
     * @return builder for the GenerateContentConfig
     */
    @BetaApi
    public Builder setTools(List<Tool> tools) {
      this.tools = Optional.of(ImmutableList.copyOf(tools));
      return this;
    }
  }

  /** Returns the {@link com.google.cloud.vertexai.api.GenerationConfig} of this config. */
  @BetaApi
  public Optional<GenerationConfig> getGenerationConfig() {
    return this.generationConfig;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.SafetySettings} of this config. */
  @BetaApi("safetySettings is a preview feature.")
  public Optional<ImmutableList<SafetySetting>> getSafetySettings() {
    return this.safetySettings;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.Tool} of this config. */
  @BetaApi("tools is a preview feature.")
  public Optional<ImmutableList<Tool>> getTools() {
    return this.tools;
  }
}
