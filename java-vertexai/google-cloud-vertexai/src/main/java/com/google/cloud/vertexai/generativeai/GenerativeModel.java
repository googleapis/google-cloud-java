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

import com.google.api.core.ApiFuture;
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
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** This class holds a generative model that can complete what you provided. */
public final class GenerativeModel {
  private final String modelName;
  private final String resourceName;
  private final VertexAI vertexAi;
  private final GenerationConfig generationConfig;
  private final ImmutableList<SafetySetting> safetySettings;
  private final ImmutableList<Tool> tools;
  private final Optional<Content> systemInstruction;

  /**
   * Constructs a GenerativeModel instance.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro", where "gemini-pro" is the model
   *     name. Valid model names can be found at
   *     https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models
   * @param vertexAi a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  public GenerativeModel(String modelName, VertexAI vertexAi) {
    this(
        modelName,
        GenerationConfig.getDefaultInstance(),
        ImmutableList.of(),
        ImmutableList.of(),
        Optional.empty(),
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
   * @param vertexAi a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  private GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      ImmutableList<SafetySetting> safetySettings,
      ImmutableList<Tool> tools,
      Optional<Content> systemInstruction,
      VertexAI vertexAi) {
    checkArgument(
        !Strings.isNullOrEmpty(modelName),
        "modelName can't be null or empty. Please refer to"
            + " https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models"
            + " to find the right model name.");
    checkNotNull(vertexAi, "VertexAI can't be null.");
    checkNotNull(generationConfig, "GenerationConfig can't be null.");
    checkNotNull(safetySettings, "ImmutableList<SafetySettings> can't be null.");
    checkNotNull(tools, "ImmutableList<Tool> can't be null.");

    modelName = reconcileModelName(modelName);
    this.modelName = modelName;
    this.resourceName =
        String.format(
            "projects/%s/locations/%s/publishers/google/models/%s",
            vertexAi.getProjectId(), vertexAi.getLocation(), modelName);
    this.vertexAi = vertexAi;
    this.generationConfig = generationConfig;
    this.safetySettings = safetySettings;
    this.tools = tools;
    this.systemInstruction = systemInstruction;
  }

  /** Builder class for {@link GenerativeModel}. */
  public static class Builder {
    private String modelName;
    private VertexAI vertexAi;
    private GenerationConfig generationConfig = GenerationConfig.getDefaultInstance();
    private ImmutableList<SafetySetting> safetySettings = ImmutableList.of();
    private ImmutableList<Tool> tools = ImmutableList.of();
    private Optional<Content> systemInstruction = Optional.empty();

    public GenerativeModel build() {
      checkArgument(
          !Strings.isNullOrEmpty(modelName),
          "modelName is required. Please call setModelName() before building.");
      checkNotNull(vertexAi, "vertexAi is required. Please call setVertexAi() before building.");
      return new GenerativeModel(
          modelName, generationConfig, safetySettings, tools, systemInstruction, vertexAi);
    }

    /**
     * Sets the name of the generative model. This is required for building a GenerativeModel
     * instance. Supported format: "gemini-pro", "models/gemini-pro",
     * "publishers/google/models/gemini-pro", where "gemini-pro" is the model name. Valid model
     * names can be found in the Gemini models documentation:
     * https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models
     */
    @CanIgnoreReturnValue
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
    @CanIgnoreReturnValue
    public Builder setVertexAi(VertexAI vertexAi) {
      checkNotNull(vertexAi, "VertexAI can't be null.");
      this.vertexAi = vertexAi;
      return this;
    }

    /**
     * Sets {@link com.google.cloud.vertexai.api.GenerationConfig} that will be used by default to
     * interact with the generative model.
     */
    @CanIgnoreReturnValue
    public Builder setGenerationConfig(GenerationConfig generationConfig) {
      checkNotNull(generationConfig, "GenerationConfig can't be null.");
      this.generationConfig = generationConfig;
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will be used by
     * default to interact with the generative model.
     */
    @CanIgnoreReturnValue
    public Builder setSafetySettings(List<SafetySetting> safetySettings) {
      checkNotNull(
          safetySettings,
          "safetySettings can't be null. Use an empty list if no safety settings is intended.");
      this.safetySettings = ImmutableList.copyOf(safetySettings);
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.Tool} that will be used by default to
     * interact with the generative model.
     */
    @CanIgnoreReturnValue
    public Builder setTools(List<Tool> tools) {
      checkNotNull(tools, "tools can't be null. Use an empty list if no tool is to be used.");
      this.tools = ImmutableList.copyOf(tools);
      return this;
    }

    /**
     * Sets a system instruction that will be used by default to interact with the generative model.
     */
    @CanIgnoreReturnValue
    public Builder setSystemInstruction(Content systemInstruction) {
      checkNotNull(
          systemInstruction,
          "system instruction can't be null. "
              + "Use Optional.empty() if no system instruction should be provided.");
      this.systemInstruction = Optional.of(systemInstruction);
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
    checkNotNull(generationConfig, "GenerationConfig can't be null.");
    return new GenerativeModel(
        modelName, generationConfig, safetySettings, tools, systemInstruction, vertexAi);
  }

  /**
   * Creates a copy of the current model with updated safetySettings.
   *
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will
   *     be used in the new model.
   * @return a new {@link GenerativeModel} instance with the specified safetySettings.
   */
  public GenerativeModel withSafetySettings(List<SafetySetting> safetySettings) {
    checkNotNull(
        safetySettings,
        "safetySettings can't be null. Use an empty list if no safety settings is intended.");
    return new GenerativeModel(
        modelName,
        generationConfig,
        ImmutableList.copyOf(safetySettings),
        tools,
        systemInstruction,
        vertexAi);
  }

  /**
   * Creates a copy of the current model with updated tools.
   *
   * @param tools a list of {@link com.google.cloud.vertexai.api.Tool} that will be used in the new
   *     model.
   * @return a new {@link GenerativeModel} instance with the specified tools.
   */
  public GenerativeModel withTools(List<Tool> tools) {
    checkNotNull(tools, "tools can't be null. Use an empty list if no tool is to be used.");
    return new GenerativeModel(
        modelName,
        generationConfig,
        safetySettings,
        ImmutableList.copyOf(tools),
        systemInstruction,
        vertexAi);
  }

  /**
   * Creates a copy of the current model with updated system instructions.
   *
   * @param systemInstruction a {@link com.google.cloud.vertexai.api.Content} containing system
   *     instructions.
   * @return a new {@link GenerativeModel} instance with the specified tools.
   */
  public GenerativeModel withSystemInstruction(Content systemInstruction) {
    checkNotNull(
        systemInstruction,
        "system instruction can't be null. "
            + "Use Optional.empty() if no system instruction should be provided.");
    return new GenerativeModel(
        modelName,
        generationConfig,
        safetySettings,
        tools,
        Optional.of(systemInstruction),
        vertexAi);
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
    checkArgument(contents != null && !contents.isEmpty(), "contents can't be null or empty.");
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
  public GenerateContentResponse generateContent(String text) throws IOException {
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
  public GenerateContentResponse generateContent(List<Content> contents) throws IOException {
    return generateContent(buildGenerateContentRequest(contents));
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
    return generateContentStream(buildGenerateContentRequest(contents));
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

  /**
   * Asynchronously generates content from generative model given a text.
   *
   * @param text a text message to send to the generative model
   * @return a {@link com.google.api.core.ApiFuture} represents the response of an asynchronous
   *     generateContent request
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ApiFuture<GenerateContentResponse> generateContentAsync(String text) throws IOException {
    return generateContentAsync(ContentMaker.fromString(text));
  }

  /**
   * Asynchronously generates content from generative model given a single Content.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model.
   *     The role of the content is "user".
   * @return a {@link com.google.api.core.ApiFuture} represents the response of an asynchronous
   *     generateContent request
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ApiFuture<GenerateContentResponse> generateContentAsync(Content content)
      throws IOException {
    return generateContentAsync(Arrays.asList(content));
  }

  /**
   * Asynchronously generates content from generative model given a list of contents.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @return a {@link com.google.api.core.ApiFuture} represents the response of an asynchronous
   *     generateContent request
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ApiFuture<GenerateContentResponse> generateContentAsync(List<Content> contents)
      throws IOException {
    return generateContentAsync(buildGenerateContentRequest(contents));
  }

  /**
   * A base generateContentAsync method that will be used internally.
   *
   * @param request a {@link com.google.cloud.vertexai.api.GenerateContentRequest} instance
   * @return a {@link com.google.api.core.ApiFuture} represents the response of an asynchronous
   *     generateContent request
   * @throws IOException if an I/O error occurs while making the API call
   */
  private ApiFuture<GenerateContentResponse> generateContentAsync(GenerateContentRequest request)
      throws IOException {
    return vertexAi.getPredictionServiceClient().generateContentCallable().futureCall(request);
  }

  /**
   * Builds a {@link com.google.cloud.vertexai.api.GenerateContentRequest} based on a list of
   * contents and model configurations.
   */
  private GenerateContentRequest buildGenerateContentRequest(List<Content> contents) {
    checkArgument(contents != null && !contents.isEmpty(), "contents can't be null or empty.");
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder()
            .setModel(resourceName)
            .addAllContents(contents)
            .setGenerationConfig(generationConfig)
            .addAllSafetySettings(safetySettings)
            .addAllTools(tools);

    if (systemInstruction.isPresent()) {
      requestBuilder.setSystemInstruction(systemInstruction.get());
    }

    return requestBuilder.build();
  }

  /** Returns the model name of this generative model. */
  public String getModelName() {
    return this.modelName;
  }

  /**
   * Returns the {@link com.google.cloud.vertexai.api.GenerationConfig} of this generative model.
   */
  public GenerationConfig getGenerationConfig() {
    return this.generationConfig;
  }

  /**
   * Returns a list of {@link com.google.cloud.vertexai.api.SafetySetting} of this generative model.
   */
  public ImmutableList<SafetySetting> getSafetySettings() {
    return safetySettings;
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.Tool} of this generative model. */
  public ImmutableList<Tool> getTools() {
    return tools;
  }

  /** Returns the optional system instruction of this generative model. */
  public Optional<Content> getSystemInstruction() {
    return systemInstruction;
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
