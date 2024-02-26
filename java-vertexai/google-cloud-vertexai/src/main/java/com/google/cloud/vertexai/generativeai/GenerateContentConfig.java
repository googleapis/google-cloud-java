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

/** This class holds all the configs when making a generate content API call */
public class GenerateContentConfig {
  private GenerationConfig generationConfig;
  private ImmutableList<SafetySetting> safetySettings;
  private ImmutableList<Tool> tools;

  /** Creates a builder for the GenerateContentConfig. */
  public static Builder newBuilder() {
    return new Builder();
  }

  private GenerateContentConfig(Builder builder) {
    if (builder.generationConfig != null) {
      this.generationConfig = builder.generationConfig;
    } else {
      this.generationConfig = null;
    }
    if (builder.safetySettings != null) {
      this.safetySettings = builder.safetySettings;
    } else {
      this.safetySettings = ImmutableList.of();
    }
    if (builder.tools != null) {
      this.tools = builder.tools;
    } else {
      this.tools = ImmutableList.of();
    }
  }

  /** Builder class for {@link GenerateContentConfig}. */
  public static class Builder {
    private GenerationConfig generationConfig;
    private ImmutableList<SafetySetting> safetySettings;
    private ImmutableList<Tool> tools;

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
      this.generationConfig = generationConfig;
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
      ImmutableList.Builder builder = ImmutableList.builder();
      for (SafetySetting safetySetting : safetySettings) {
        if (safetySetting != null) {
          builder.add(safetySetting);
        }
      }
      this.safetySettings = builder.build();

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
      ImmutableList.Builder builder = ImmutableList.builder();
      for (Tool tool : tools) {
        if (tool != null) {
          builder.add(tool);
        }
      }
      this.tools = builder.build();

      return this;
    }
  }

  /**
   * Sets the value for {@link #getGenerationConfig}, which will be used in the generate content API
   * call.
   */
  @BetaApi
  public void setGenerationConfig(GenerationConfig generationConfig) {
    this.generationConfig = generationConfig;
  }

  /**
   * Sets the value for {@link #getSafetySettings}, which will be used in the generate content API
   * call.
   */
  @BetaApi("safetySettings is a preview feature.")
  public void setSafetySettings(List<SafetySetting> safetySettings) {
    ImmutableList.Builder builder = ImmutableList.builder();
    for (SafetySetting safetySetting : safetySettings) {
      if (safetySetting != null) {
        builder.add(safetySetting);
      }
    }
    this.safetySettings = builder.build();
  }

  /** Sets the value for {@link #getTools}, which will be used in the generate content API call. */
  @BetaApi("tools is a preview feature.")
  public void setTools(List<Tool> tools) {
    ImmutableList.Builder builder = ImmutableList.builder();
    for (Tool tool : tools) {
      if (tool != null) {
        builder.add(tool);
      }
    }
    this.tools = builder.build();
  }

  /** Returns the {@link com.google.cloud.vertexai.api.GenerationConfig} of this config. */
  @BetaApi
  public GenerationConfig getGenerationConfig() {
    return this.generationConfig;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.SafetySettings} of this config. */
  @BetaApi("safetySettings is a preview feature.")
  public ImmutableList<SafetySetting> getSafetySettings() {
    return this.safetySettings;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.Tool} of this config. */
  @BetaApi("tools is a preview feature.")
  public ImmutableList<Tool> getTools() {
    return this.tools;
  }
}
