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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensRequest;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This class holds a generative model that can complete what you provided. */
public final class GenerativeModel {
  private final String modelName;
  private final String resourceName;
  private final VertexAI vertexAi;
  private GenerationConfig generationConfig = GenerationConfig.getDefaultInstance();
  private ImmutableList<SafetySetting> safetySettings = ImmutableList.of();
  private ImmutableList<Tool> tools = ImmutableList.of();

  /**
   * Constructs a GenerativeModel instance.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro", where "gemini-pro" is the model
   *     name. Valid model names can be found at
   *     https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  public GenerativeModel(String modelName, VertexAI vertexAi) {
    this(
        modelName,
        GenerationConfig.getDefaultInstance(),
        new ArrayList<SafetySetting>(),
        new ArrayList<Tool>(),
        vertexAi);
  }

  /**
   * Constructs a GenerativeModel instance with default generation config and safety settings.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance that
   *     will be used by default for generating response
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} instances
   *     that will be used by default for generating response
   * @param tools a list of {@link com.google.cloud.vertexai.api.Tool} instances that can be used by
   *     the model as auxiliary tools to generate content.
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  private GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      List<SafetySetting> safetySettings,
      List<Tool> tools,
      VertexAI vertexAi) {
    modelName = reconcileModelName(modelName);
    this.modelName = modelName;
    this.resourceName =
        String.format(
            "projects/%s/locations/%s/publishers/google/models/%s",
            vertexAi.getProjectId(), vertexAi.getLocation(), modelName);
    checkNotNull(generationConfig, "GenerationConfig can't be null.");
    checkNotNull(safetySettings, "List<SafetySettings> can't be null.");
    checkNotNull(tools, "List<Tool> can't be null.");
    this.vertexAi = vertexAi;
    this.generationConfig = generationConfig;
    this.safetySettings = ImmutableList.copyOf(safetySettings);
    this.tools = ImmutableList.copyOf(tools);
  }

  /** Builder class for {@link GenerativeModel}. */
  public static class Builder {
    private String modelName;
    private VertexAI vertexAi;
    private GenerationConfig generationConfig = GenerationConfig.getDefaultInstance();
    private ImmutableList<SafetySetting> safetySettings = ImmutableList.of();
    private ImmutableList<Tool> tools = ImmutableList.of();

    public GenerativeModel build() {
      checkArgument(
          !Strings.isNullOrEmpty(modelName),
          "modelName is required. Please call setModelName() before building.");
      checkNotNull(vertexAi, "vertexAi is required. Please call setVertexAi() before building.");
      return new GenerativeModel(modelName, generationConfig, safetySettings, tools, vertexAi);
    }

    /**
     * Sets the name of the generative model. This is required for building a GenerativeModel
     * instance. Supported format: "gemini-pro", "models/gemini-pro",
     * "publishers/google/models/gemini-pro", where "gemini-pro" is the model name. Valid model
     * names can be found at
     * https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models
     */
    public Builder setModelName(String modelName) {
      checkArgument(
          !Strings.isNullOrEmpty(modelName),
          "modelName can't be null or empty. Please refer to"
              + " https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models"
              + " to find the right model name.");

      this.modelName = reconcileModelName(modelName);
      return this;
    }

    /**
     * Sets {@link com.google.cloud.vertexai.VertexAI} that contains the default configs for the
     * generative model. This is required for building a GenerativeModel instance.
     */
    public Builder setVertexAi(VertexAI vertexAi) {
      checkNotNull(vertexAi, "VertexAI can't be null.");
      this.vertexAi = vertexAi;
      return this;
    }

    /**
     * Sets {@link com.google.cloud.vertexai.api.GenerationConfig} that will be used by default to
     * interact with the generative model.
     */
    @BetaApi
    public Builder setGenerationConfig(GenerationConfig generationConfig) {
      checkNotNull(generationConfig, "GenerationConfig can't be null.");
      this.generationConfig = generationConfig;
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will be used by
     * default to interact with the generative model.
     */
    @BetaApi
    public Builder setSafetySettings(List<SafetySetting> safetySettings) {
      checkNotNull(
          safetySettings,
          "safetySettings can't be null. Use an empty list if no safety settings is intended.");
      safetySettings.removeIf(safetySetting -> safetySetting == null);
      this.safetySettings = ImmutableList.copyOf(safetySettings);
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.Tool} that will be used by default to
     * interact with the generative model.
     */
    @BetaApi
    public Builder setTools(List<Tool> tools) {
      checkNotNull(tools, "tools can't be null. Use an empty list if no tool is to be used.");
      tools.removeIf(tool -> tool == null);
      this.tools = ImmutableList.copyOf(tools);
      return this;
    }
  }

  /**
   * Creates a copy of the current model with updated GenerationConfig.
   *
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} that will be
   *     used in the new model.
   * @return a new {@link GenerativeModel} instance with the specified GenerationConfig.
   */
  public GenerativeModel withGenerationConfig(GenerationConfig generationConfig) {
    return new GenerativeModel(modelName, generationConfig, safetySettings, tools, vertexAi);
  }

  /**
   * Creates a copy of the current model with updated safetySettings.
   *
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will
   *     be used in the new model.
   * @return a new {@link GenerativeModel} instance with the specified safetySettings.
   */
  public GenerativeModel withSafetySettings(List<SafetySetting> safetySettings) {
    return new GenerativeModel(
        modelName, generationConfig, ImmutableList.copyOf(safetySettings), tools, vertexAi);
  }

  /**
   * Creates a copy of the current model with updated tools.
   *
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.Tool} that will be used in
   *     the new model.
   * @return a new {@link GenerativeModel} instance with the specified tools.
   */
  public GenerativeModel withTools(List<Tool> tools) {
    return new GenerativeModel(
        modelName, generationConfig, safetySettings, ImmutableList.copyOf(tools), vertexAi);
  }

  /**
   * Counts tokens in a text message.
   *
   * @param text a text message to count tokens
   * @return a {@link com.google.cloud.vertexai.api.CountTokensResponse} instance that contains the
   *     total tokens and total billable characters of the given list of contents
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public CountTokensResponse countTokens(String text) throws IOException {
    // TODO(b/330402637): Check null and empty values for the input string.
    return countTokens(ContentMaker.fromString(text));
  }

  /**
   * Counts tokens in a single content.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to count tokens
   * @return a {@link com.google.cloud.vertexai.api.CountTokensResponse} instance that contains the
   *     total tokens and total billable characters of the given list of contents
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public CountTokensResponse countTokens(Content content) throws IOException {
    return countTokens(Arrays.asList(content));
  }

  /**
   * Counts tokens in a list of contents.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to count tokens
   * @return a {@link com.google.cloud.vertexai.api.CountTokensResponse} instance that contains the
   *     total tokens and total billable characters of the given list of contents
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public CountTokensResponse countTokens(List<Content> contents) throws IOException {
    CountTokensRequest request =
        CountTokensRequest.newBuilder()
            .setEndpoint(resourceName)
            .setModel(resourceName)
            .addAllContents(contents)
            .build();
    return countTokensFromRequest(request);
  }

  /**
   * Sends CountTokensRequest given a request message.
   *
   * @param request a {@link com.google.cloud.vertexai.api.CountTokensRequest} that contains a list
   *     of contents
   * @return a {@link com.google.cloud.vertexai.api.CountTokensResponse} instance that contains the
   *     total tokens and total billable characters of the given list of contents
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  private CountTokensResponse countTokensFromRequest(CountTokensRequest request)
      throws IOException {
    return vertexAi.getLlmUtilityClient().countTokens(request);
  }

  /**
   * Generates content from generative model given a text.
   *
   * @param text a text message to send to the generative model
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public GenerateContentResponse generateContent(String text) throws IOException {
    // TODO(b/330402637): Check null and empty values for the input string.
    return generateContent(ContentMaker.fromString(text));
  }

  /**
   * Generates content from this model given a single content.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi("generateContent is a preview feature.")
  public GenerateContentResponse generateContent(Content content) throws IOException {
    return generateContent(Arrays.asList(content));
  }

  /**
   * Generates content from this model given a list of contents.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi("generateContent is a preview feature.")
  public GenerateContentResponse generateContent(List<Content> contents) throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    requestBuilder.setGenerationConfig(this.generationConfig);
    requestBuilder.addAllSafetySettings(this.safetySettings);
    requestBuilder.addAllTools(this.tools);
    return generateContent(requestBuilder.build());
  }

  /**
   * A base generateContent method that will be used internally.
   *
   * @param request a {@link com.google.cloud.vertexai.api.GenerateContentRequest} instance
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  private GenerateContentResponse generateContent(GenerateContentRequest request)
      throws IOException {
    return vertexAi.getPredictionServiceClient().generateContentCallable().call(request);
  }

  /**
   * Generates content with streaming support from generative model given a text.
   *
   * @param text a text message to send to the generative model
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(String text)
      throws IOException {
    return generateContentStream(ContentMaker.fromString(text));
  }

  /**
   * Generates content with streaming support from generative model given a single Content.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model.
   *     The role of the content is "user".
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(Content content)
      throws IOException {
    return generateContentStream(Arrays.asList(content));
  }

  /**
   * Generates content with streaming support from generative model given a list of contents.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(List<Content> contents)
      throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    requestBuilder.setGenerationConfig(this.generationConfig);
    requestBuilder.addAllSafetySettings(this.safetySettings);
    requestBuilder.addAllTools(this.tools);

    return generateContentStream(requestBuilder.build());
  }

  /**
   * A base generateContentStream method that will be used internally.
   *
   * @param request a {@link com.google.cloud.vertexai.api.GenerateContentRequest} instance
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  private ResponseStream<GenerateContentResponse> generateContentStream(
      GenerateContentRequest request) throws IOException {
    return new ResponseStream(
        new ResponseStreamIteratorWithHistory(
            vertexAi
                .getPredictionServiceClient()
                .streamGenerateContentCallable()
                .call(request)
                .iterator()));
  }

  /** Returns the model name of this generative model. */
  public String getModelName() {
    return this.modelName;
  }

  /**
   * Returns the {@link com.google.cloud.vertexai.api.GenerationConfig} of this generative model.
   */
  @BetaApi
  public GenerationConfig getGenerationConfig() {
    return this.generationConfig;
  }

  /**
   * Returns a list of {@link com.google.cloud.vertexai.api.SafetySettings} of this generative
   * model.
   */
  @BetaApi("safetySettings is a preview feature.")
  public ImmutableList<SafetySetting> getSafetySettings() {
    return safetySettings;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.Tool} of this generative model. */
  @BetaApi("tools is a preview feature.")
  public ImmutableList<Tool> getTools() {
    return tools;
  }

  public ChatSession startChat() {
    return new ChatSession(this);
  }

  /** Keeps the model name only, if users specify the resource name, and returns the model name. */
  private static String reconcileModelName(String modelName) {
    for (String prefix : Constants.MODEL_NAME_PREFIXES) {
      if (modelName.startsWith(prefix)) {
        modelName = modelName.substring(prefix.length());
        break;
      }
    }
    return modelName;
  }
}
