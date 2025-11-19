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
import com.google.genai.types.FunctionCallingConfig;
import com.google.genai.types.GenerationConfig;
import com.google.genai.types.Part;
import com.google.genai.types.SafetySetting;
import com.google.genai.types.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents a prompt message. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecPromptMessage.Builder.class)
public abstract class SchemaPromptSpecPromptMessage extends JsonSerializable {
  /** Generation config. */
  @JsonProperty("generationConfig")
  public abstract Optional<GenerationConfig> generationConfig();

  /** Tool config. This config is shared for all tools provided in the request. */
  @JsonProperty("toolConfig")
  public abstract Optional<FunctionCallingConfig> toolConfig();

  /**
   * A list of `Tools` the model may use to generate the next response. A `Tool` is a piece of code
   * that enables the system to interact with external systems to perform an action, or set of
   * actions, outside of knowledge and scope of the model.
   */
  @JsonProperty("tools")
  public abstract Optional<List<Tool>> tools();

  /**
   * Per request settings for blocking unsafe content. Enforced on
   * GenerateContentResponse.candidates.
   */
  @JsonProperty("safetySettings")
  public abstract Optional<List<SafetySetting>> safetySettings();

  /**
   * The content of the current conversation with the model. For single-turn queries, this is a
   * single instance. For multi-turn queries, this is a repeated field that contains conversation
   * history + latest request.
   */
  @JsonProperty("contents")
  public abstract Optional<List<Content>> contents();

  /**
   * The user provided system instructions for the model. Note: only text should be used in parts
   * and content in each part will be in a separate paragraph.
   */
  @JsonProperty("systemInstruction")
  public abstract Optional<Content> systemInstruction();

  /** */
  @JsonProperty("variables")
  public abstract Optional<List<Map<String, Part>>> variables();

  /** The model name. */
  @JsonProperty("model")
  public abstract Optional<String> model();

  /** Instantiates a builder for SchemaPromptSpecPromptMessage. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecPromptMessage.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecPromptMessage. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecPromptMessage.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecPromptMessage.Builder();
    }

    /**
     * Setter for generationConfig.
     *
     * <p>generationConfig: Generation config.
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

    /**
     * Setter for toolConfig.
     *
     * <p>toolConfig: Tool config. This config is shared for all tools provided in the request.
     */
    @JsonProperty("toolConfig")
    public abstract Builder toolConfig(FunctionCallingConfig toolConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder toolConfig(Optional<FunctionCallingConfig> toolConfig);

    /** Clears the value of toolConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearToolConfig() {
      return toolConfig(Optional.empty());
    }

    /**
     * Setter for tools.
     *
     * <p>tools: A list of `Tools` the model may use to generate the next response. A `Tool` is a
     * piece of code that enables the system to interact with external systems to perform an action,
     * or set of actions, outside of knowledge and scope of the model.
     */
    @JsonProperty("tools")
    public abstract Builder tools(List<Tool> tools);

    /**
     * Setter for tools.
     *
     * <p>tools: A list of `Tools` the model may use to generate the next response. A `Tool` is a
     * piece of code that enables the system to interact with external systems to perform an action,
     * or set of actions, outside of knowledge and scope of the model.
     */
    @CanIgnoreReturnValue
    public Builder tools(Tool... tools) {
      return tools(Arrays.asList(tools));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tools(Optional<List<Tool>> tools);

    /** Clears the value of tools field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTools() {
      return tools(Optional.empty());
    }

    /**
     * Setter for safetySettings.
     *
     * <p>safetySettings: Per request settings for blocking unsafe content. Enforced on
     * GenerateContentResponse.candidates.
     */
    @JsonProperty("safetySettings")
    public abstract Builder safetySettings(List<SafetySetting> safetySettings);

    /**
     * Setter for safetySettings.
     *
     * <p>safetySettings: Per request settings for blocking unsafe content. Enforced on
     * GenerateContentResponse.candidates.
     */
    @CanIgnoreReturnValue
    public Builder safetySettings(SafetySetting... safetySettings) {
      return safetySettings(Arrays.asList(safetySettings));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder safetySettings(Optional<List<SafetySetting>> safetySettings);

    /** Clears the value of safetySettings field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSafetySettings() {
      return safetySettings(Optional.empty());
    }

    /**
     * Setter for contents.
     *
     * <p>contents: The content of the current conversation with the model. For single-turn queries,
     * this is a single instance. For multi-turn queries, this is a repeated field that contains
     * conversation history + latest request.
     */
    @JsonProperty("contents")
    public abstract Builder contents(List<Content> contents);

    /**
     * Setter for contents.
     *
     * <p>contents: The content of the current conversation with the model. For single-turn queries,
     * this is a single instance. For multi-turn queries, this is a repeated field that contains
     * conversation history + latest request.
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
     * <p>systemInstruction: The user provided system instructions for the model. Note: only text
     * should be used in parts and content in each part will be in a separate paragraph.
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
     * Setter for variables.
     *
     * <p>variables:
     */
    @JsonProperty("variables")
    public abstract Builder variables(List<Map<String, Part>> variables);

    /**
     * Setter for variables.
     *
     * <p>variables:
     */
    @CanIgnoreReturnValue
    public Builder variables(Map<String, Part>... variables) {
      return variables(Arrays.asList(variables));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder variables(Optional<List<Map<String, Part>>> variables);

    /** Clears the value of variables field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVariables() {
      return variables(Optional.empty());
    }

    /**
     * Setter for model.
     *
     * <p>model: The model name.
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

    public abstract SchemaPromptSpecPromptMessage build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecPromptMessage object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecPromptMessage fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecPromptMessage.class);
  }
}
