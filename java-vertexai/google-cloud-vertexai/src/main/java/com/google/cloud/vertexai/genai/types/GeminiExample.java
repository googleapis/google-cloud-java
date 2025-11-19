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
import com.google.genai.types.Content;
import com.google.genai.types.GenerationConfig;
import com.google.genai.types.SafetySetting;
import com.google.genai.types.Tool;
import com.google.genai.types.ToolConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents a Gemini example. */
@AutoValue
@JsonDeserialize(builder = GeminiExample.Builder.class)
public abstract class GeminiExample extends JsonSerializable {
  /** The model used to generate the Gemini example. */
  @JsonProperty("model")
  public abstract Optional<String> model();

  /** Contents of the Gemini example. */
  @JsonProperty("contents")
  public abstract Optional<List<Content>> contents();

  /** System instruction for the Gemini example. */
  @JsonProperty("systemInstruction")
  public abstract Optional<Content> systemInstruction();

  /** Cached content for the Gemini example. */
  @JsonProperty("cachedContent")
  public abstract Optional<String> cachedContent();

  /** Tools for the Gemini example. */
  @JsonProperty("tools")
  public abstract Optional<Tool> tools();

  /** Tools for the Gemini example. */
  @JsonProperty("toolConfig")
  public abstract Optional<ToolConfig> toolConfig();

  /** Safety settings for the Gemini example. */
  @JsonProperty("safetySettings")
  public abstract Optional<SafetySetting> safetySettings();

  /** Labels for the Gemini example. */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** Generation config for the Gemini example. */
  @JsonProperty("generationConfig")
  public abstract Optional<GenerationConfig> generationConfig();

  /** Instantiates a builder for GeminiExample. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GeminiExample.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GeminiExample. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GeminiExample.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GeminiExample.Builder();
    }

    /**
     * Setter for model.
     *
     * <p>model: The model used to generate the Gemini example.
     */
    @JsonProperty("model")
    public abstract Builder model(String model);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder model(Optional<String> model);

    /** Clears the value of model field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearModel() {
      return model(Optional.empty());
    }

    /**
     * Setter for contents.
     *
     * <p>contents: Contents of the Gemini example.
     */
    @JsonProperty("contents")
    public abstract Builder contents(List<Content> contents);

    /**
     * Setter for contents.
     *
     * <p>contents: Contents of the Gemini example.
     */
    @CanIgnoreReturnValue
    public Builder contents(Content... contents) {
      return contents(Arrays.asList(contents));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contents(Optional<List<Content>> contents);

    /** Clears the value of contents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContents() {
      return contents(Optional.empty());
    }

    /**
     * Setter for systemInstruction.
     *
     * <p>systemInstruction: System instruction for the Gemini example.
     */
    @JsonProperty("systemInstruction")
    public abstract Builder systemInstruction(Content systemInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder systemInstruction(Optional<Content> systemInstruction);

    /** Clears the value of systemInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSystemInstruction() {
      return systemInstruction(Optional.empty());
    }

    /**
     * Setter for cachedContent.
     *
     * <p>cachedContent: Cached content for the Gemini example.
     */
    @JsonProperty("cachedContent")
    public abstract Builder cachedContent(String cachedContent);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder cachedContent(Optional<String> cachedContent);

    /** Clears the value of cachedContent field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCachedContent() {
      return cachedContent(Optional.empty());
    }

    /**
     * Setter for tools.
     *
     * <p>tools: Tools for the Gemini example.
     */
    @JsonProperty("tools")
    public abstract Builder tools(Tool tools);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tools(Optional<Tool> tools);

    /** Clears the value of tools field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTools() {
      return tools(Optional.empty());
    }

    /**
     * Setter for toolConfig.
     *
     * <p>toolConfig: Tools for the Gemini example.
     */
    @JsonProperty("toolConfig")
    public abstract Builder toolConfig(ToolConfig toolConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolConfig(Optional<ToolConfig> toolConfig);

    /** Clears the value of toolConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolConfig() {
      return toolConfig(Optional.empty());
    }

    /**
     * Setter for safetySettings.
     *
     * <p>safetySettings: Safety settings for the Gemini example.
     */
    @JsonProperty("safetySettings")
    public abstract Builder safetySettings(SafetySetting safetySettings);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder safetySettings(Optional<SafetySetting> safetySettings);

    /** Clears the value of safetySettings field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSafetySettings() {
      return safetySettings(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: Labels for the Gemini example.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for generationConfig.
     *
     * <p>generationConfig: Generation config for the Gemini example.
     */
    @JsonProperty("generationConfig")
    public abstract Builder generationConfig(GenerationConfig generationConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generationConfig(Optional<GenerationConfig> generationConfig);

    /** Clears the value of generationConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerationConfig() {
      return generationConfig(Optional.empty());
    }

    public abstract GeminiExample build();
  }

  /** Deserializes a JSON string to a GeminiExample object. */
  @ExcludeFromGeneratedCoverageReport
  public static GeminiExample fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GeminiExample.class);
  }
}
