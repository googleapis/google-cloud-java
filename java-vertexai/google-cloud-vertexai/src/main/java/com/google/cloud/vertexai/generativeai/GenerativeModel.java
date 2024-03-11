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
import com.google.cloud.vertexai.Transport;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensRequest;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** This class holds a generative model that can complete what you provided. */
public class GenerativeModel {
  private final String modelName;
  private final String resourceName;
  private final VertexAI vertexAi;
  private GenerationConfig generationConfig = null;
  private List<SafetySetting> safetySettings = null;
  private List<Tool> tools = null;
  private Transport transport;

  public static Builder newBuilder() {
    return new Builder();
  }

  private GenerativeModel(Builder builder) {
    this.modelName = builder.modelName;

    this.vertexAi = builder.vertexAi;

    this.resourceName =
        String.format(
            "projects/%s/locations/%s/publishers/google/models/%s",
            this.vertexAi.getProjectId(), this.vertexAi.getLocation(), this.modelName);

    if (builder.generationConfig != null) {
      this.generationConfig = builder.generationConfig;
    }
    if (builder.safetySettings != null) {
      this.safetySettings = builder.safetySettings;
    }
    if (builder.tools != null) {
      this.tools = builder.tools;
    }

    if (builder.transport != null) {
      this.transport = builder.transport;
    } else {
      this.transport = this.vertexAi.getTransport();
    }
  }

  /** Builder class for {@link GenerativeModel}. */
  public static class Builder {
    private String modelName;
    private VertexAI vertexAi;
    private GenerationConfig generationConfig;
    private List<SafetySetting> safetySettings;
    private List<Tool> tools;
    private Transport transport;

    private Builder() {}

    public GenerativeModel build() {
      if (this.modelName == null) {
        throw new IllegalArgumentException(
            "modelName is required. Please call setModelName() before building.");
      }
      if (this.vertexAi == null) {
        throw new IllegalArgumentException(
            "vertexAi is required. Please call setVertexAi() before building.");
      }
      return new GenerativeModel(this);
    }

    /**
     * Sets the name of the generative model. This is required for building a GenerativeModel
     * instance. Supported format: "gemini-pro", "models/gemini-pro",
     * "publishers/google/models/gemini-pro", where "gemini-pro" is the model name. Valid model
     * names can be found at
     * https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models
     */
    public Builder setModelName(String modelName) {
      this.modelName = reconcileModelName(modelName);
      return this;
    }

    /**
     * Sets {@link com.google.cloud.vertexai.VertexAI} that contains the default configs for the
     * generative model. This is required for building a GenerativeModel instance.
     */
    public Builder setVertexAi(VertexAI vertexAi) {
      this.vertexAi = vertexAi;
      return this;
    }

    /**
     * Sets {@link com.google.cloud.vertexai.api.GenerationConfig} that will be used by default to
     * interact with the generative model.
     */
    @BetaApi
    public Builder setGenerationConfig(GenerationConfig generationConfig) {
      this.generationConfig = generationConfig;
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.SafetySetting} that will be used by
     * default to interact with the generative model.
     */
    @BetaApi
    public Builder setSafetySettings(List<SafetySetting> safetySettings) {
      this.safetySettings = new ArrayList<>();
      for (SafetySetting safetySetting : safetySettings) {
        if (safetySetting != null) {
          this.safetySettings.add(safetySetting);
        }
      }
      return this;
    }

    /**
     * Sets a list of {@link com.google.cloud.vertexai.api.Tool} that will be used by default to
     * interact with the generative model.
     */
    @BetaApi
    public Builder setTools(List<Tool> tools) {
      this.tools = new ArrayList<>();
      for (Tool tool : tools) {
        if (tool != null) {
          this.tools.add(tool);
        }
      }
      return this;
    }

    /**
     * Sets the {@link Transport} layer for API calls in the generative model. It overrides the
     * transport setting in {@link com.google.cloud.vertexai.VertexAI}
     */
    public Builder setTransport(Transport transport) {
      this.transport = transport;
      return this;
    }
  }

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
    this(modelName, null, null, vertexAi, null);
  }

  /**
   * Constructs a GenerativeModel instance.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   * @param transport the {@link Transport} layer for API calls in the generative model. It
   *     overrides the transport setting in {@link com.google.cloud.vertexai.VertexAI}
   */
  public GenerativeModel(String modelName, VertexAI vertexAi, Transport transport) {
    this(modelName, null, null, vertexAi, transport);
  }

  /**
   * Constructs a GenerativeModel instance with default generation config.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance that
   *     will be used by default for generating response
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  @BetaApi
  public GenerativeModel(String modelName, GenerationConfig generationConfig, VertexAI vertexAi) {
    this(modelName, generationConfig, null, vertexAi, null);
  }

  /**
   * Constructs a GenerativeModel instance with default generation config.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance that
   *     will be used by default for generating response
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   * @param transport the {@link Transport} layer for API calls in the generative model. It
   *     overrides the transport setting in {@link com.google.cloud.vertexai.VertexAI}
   */
  @BetaApi
  public GenerativeModel(
      String modelName, GenerationConfig generationConfig, VertexAI vertexAi, Transport transport) {
    this(modelName, generationConfig, null, vertexAi, transport);
  }

  /**
   * Constructs a GenerativeModel instance with default safety settings.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} instances
   *     that will be used by default for generating response
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  @BetaApi("safetySettings is a preview feature.")
  public GenerativeModel(String modelName, List<SafetySetting> safetySettings, VertexAI vertexAi) {
    this(modelName, null, safetySettings, vertexAi, null);
  }

  /**
   * Constructs a GenerativeModel instance with default safety settings.
   *
   * @param modelName the name of the generative model. Supported format: "gemini-pro",
   *     "models/gemini-pro", "publishers/google/models/gemini-pro"
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} instances
   *     that will be used by default for generating response
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   * @param transport the {@link Transport} layer for API calls in the generative model. It
   *     overrides the transport setting in {@link com.google.cloud.vertexai.VertexAI}
   */
  @BetaApi("safetySettings is a preview feature.")
  public GenerativeModel(
      String modelName,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi,
      Transport transport) {
    this(modelName, null, safetySettings, vertexAi, transport);
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
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   */
  @BetaApi("safetySettings is a preview feature.")
  public GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi) {
    this(modelName, generationConfig, safetySettings, vertexAi, null);
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
   * @param vertexAI a {@link com.google.cloud.vertexai.VertexAI} that contains the default configs
   *     for the generative model
   * @param transport the {@link Transport} layer for API calls in the generative model. It
   *     overrides the transport setting in {@link com.google.cloud.vertexai.VertexAI}
   */
  @BetaApi
  public GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi,
      Transport transport) {
    modelName = reconcileModelName(modelName);
    this.modelName = modelName;
    this.resourceName =
        String.format(
            "projects/%s/locations/%s/publishers/google/models/%s",
            vertexAi.getProjectId(), vertexAi.getLocation(), modelName);
    if (generationConfig != null) {
      this.generationConfig = generationConfig;
    }
    if (safetySettings != null) {
      this.safetySettings = new ArrayList<>();
      for (SafetySetting safetySetting : safetySettings) {
        this.safetySettings.add(safetySetting);
      }
    }
    this.vertexAi = vertexAi;
    if (transport != null) {
      this.transport = transport;
    } else {
      this.transport = vertexAi.getTransport();
    }
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
    if (this.transport == Transport.REST) {
      return vertexAi.getLlmUtilityRestClient().countTokens(request);
    } else {
      return vertexAi.getLlmUtilityClient().countTokens(request);
    }
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
    return generateContent(text, null, null);
  }

  /**
   * Generates content from generative model given a text and configs.
   *
   * @param text a text message to send to the generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public GenerateContentResponse generateContent(String text, GenerateContentConfig config)
      throws IOException {
    return generateContent(ContentMaker.fromString(text), config);
  }

  /**
   * Generates content from generative model given a text and generation config.
   *
   * @param text a text message to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(String, GenerateContentConfig)} instead
   */
  @BetaApi
  @Deprecated
  public GenerateContentResponse generateContent(String text, GenerationConfig generationConfig)
      throws IOException {
    return generateContent(text, generationConfig, null);
  }

  /**
   * Generates content from generative model given a text and safety settings.
   *
   * @param text a text message to send to the generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(String, GenerateContentConfig)} instead
   */
  @BetaApi("Both generateContent and safetySettings are preview features.")
  @Deprecated
  public GenerateContentResponse generateContent(String text, List<SafetySetting> safetySettings)
      throws IOException {
    return generateContent(text, null, safetySettings);
  }

  /**
   * Generates content from generative model given a text, generation config, and safety settings.
   *
   * @param text a text message to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(String, GenerateContentConfig)} instead
   */
  @BetaApi("Both generateContent and safetySettings are preview features.")
  @Deprecated
  public GenerateContentResponse generateContent(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Part part = Part.newBuilder().setText(text).build();
    Content content = Content.newBuilder().addParts(part).setRole("user").build();
    List<Content> contents = Arrays.asList(content);
    return generateContent(contents, generationConfig, safetySettings);
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
    return generateContent(contents, null, null);
  }

  /**
   * Generates content from this model given a list of contents and generation config.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi("generateContent is a preview feature.")
  @Deprecated
  public GenerateContentResponse generateContent(
      List<Content> contents, GenerationConfig generationConfig) throws IOException {
    return generateContent(contents, generationConfig, null);
  }

  /**
   * Generates content from this model given a list of contents and safety settings.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi("Both generateContent and safetySettings are preview features")
  @Deprecated
  public GenerateContentResponse generateContent(
      List<Content> contents, List<SafetySetting> safetySettings) throws IOException {
    return generateContent(contents, null, safetySettings);
  }

  /**
   * Generates content from generative model given a list of contents and configs.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public GenerateContentResponse generateContent(
      List<Content> contents, GenerateContentConfig config) throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    if (config.getGenerationConfig() != null) {
      requestBuilder.setGenerationConfig(config.getGenerationConfig());
    } else if (this.generationConfig != null) {
      requestBuilder.setGenerationConfig(this.generationConfig);
    }
    if (config.getSafetySettings().isEmpty() == false) {
      requestBuilder.addAllSafetySettings(config.getSafetySettings());
    } else if (this.safetySettings != null) {
      requestBuilder.addAllSafetySettings(this.safetySettings);
    }
    if (config.getTools().isEmpty() == false) {
      requestBuilder.addAllTools(config.getTools());
    } else if (this.tools != null) {
      requestBuilder.addAllTools(this.tools);
    }

    return generateContent(requestBuilder.build());
  }

  /**
   * Generates content from generative model given a list of contents, generation config, and safety
   * settings.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi("Both generateContent and safetySettings are preview features")
  @Deprecated
  public GenerateContentResponse generateContent(
      List<Content> contents, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    if (generationConfig != null) {
      requestBuilder.setGenerationConfig(generationConfig);
    } else if (this.generationConfig != null) {
      requestBuilder.setGenerationConfig(this.generationConfig);
    }
    if (safetySettings != null) {
      requestBuilder.addAllSafetySettings(safetySettings);
    } else if (this.safetySettings != null) {
      requestBuilder.addAllSafetySettings(this.safetySettings);
    }
    if (this.tools != null) {
      requestBuilder.addAllTools(this.tools);
    }
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
    if (this.transport == Transport.REST) {
      return vertexAi.getPredictionServiceRestClient().generateContentCallable().call(request);
    } else {
      return vertexAi.getPredictionServiceClient().generateContentCallable().call(request);
    }
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
    return generateContent(content, null, null);
  }

  /**
   * Generates content from generative model given a single content and configs.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   */
  @BetaApi
  public GenerateContentResponse generateContent(Content content, GenerateContentConfig config)
      throws IOException {
    return generateContent(Arrays.asList(content), config);
  }

  /**
   * Generates content from this model given a single content and generation config.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(Content, GenerateContentConfig)} instead
   */
  @BetaApi("generateContent is a preview feature.")
  @Deprecated
  public GenerateContentResponse generateContent(Content content, GenerationConfig generationConfig)
      throws IOException {
    return generateContent(content, generationConfig, null);
  }

  /**
   * Generates content from this model given a single content and safety settings.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(Content, GenerateContentConfig)} instead
   */
  @BetaApi("generateContent is a preview feature.")
  @Deprecated
  public GenerateContentResponse generateContent(
      Content content, List<SafetySetting> safetySettings) throws IOException {
    return generateContent(content, null, safetySettings);
  }

  /**
   * Generates content from generative model given a single content, generation config, and safety
   * settings.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link com.google.cloud.vertexai.api.GenerateContentResponse} instance that contains
   *     response contents and other metadata
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContent(Content, GenerateContentConfig)} instead
   */
  @BetaApi("Both generateContent and safetySettings are preview features.")
  @Deprecated
  public GenerateContentResponse generateContent(
      Content content, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    return generateContent(Arrays.asList(content), generationConfig, safetySettings);
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
    return generateContentStream(text, null, null);
  }

  /**
   * Generates content with streaming support from generative model given a text and configs.
   *
   * @param text a text message to send to the generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, GenerateContentConfig config) throws IOException {
    return generateContentStream(ContentMaker.fromString(text), config);
  }

  /**
   * Generates content with streaming support from generative model given a text and generation
   * config.
   *
   * @param text a text message to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(String, GenerateContentConfig)} instead
   */
  @BetaApi
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, GenerationConfig generationConfig) throws IOException {
    return generateContentStream(text, generationConfig, null);
  }

  /**
   * Generates content with streaming support from generative model given a text and safety
   * settings.
   *
   * @param text a text message to send to the generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(String, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, List<SafetySetting> safetySettings) throws IOException {
    return generateContentStream(text, null, safetySettings);
  }

  /**
   * Generates content with streaming support from generative model given a text, generation config,
   * and safety settings.
   *
   * @param text a text message to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(String, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Part part = Part.newBuilder().setText(text).build();
    Content content = Content.newBuilder().addParts(part).setRole("user").build();
    List<Content> contents = Arrays.asList(content);
    return generateContentStream(contents, generationConfig, safetySettings);
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
    return generateContentStream(content, null, null);
  }

  /**
   * Generates content with streaming support from generative model given a single content and
   * configs.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      Content content, GenerateContentConfig config) throws IOException {
    return generateContentStream(Arrays.asList(content), config);
  }

  /**
   * Generates content with streaming support from generative model given a single Content and
   * generation config.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(Content, GenerateContentConfig)} instead
   */
  @BetaApi
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      Content content, GenerationConfig generationConfig) throws IOException {
    return generateContentStream(content, generationConfig, null);
  }

  /**
   * Generates content with streaming support from generative model given a single content and
   * safety settings.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(Content, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      Content content, List<SafetySetting> safetySettings) throws IOException {
    return generateContentStream(content, null, safetySettings);
  }

  /**
   * Generates content with streaming support from generative model given a single content,
   * generation config, and safety settings.
   *
   * @param content a {@link com.google.cloud.vertexai.api.Content} to send to the generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(Content, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      Content content, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    return generateContentStream(Arrays.asList(content), generationConfig, safetySettings);
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
    return generateContentStream(contents, null, null);
  }

  /**
   * Generates content with streaming support from generative model given a list of contents and
   * generation config.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, GenerationConfig generationConfig) throws IOException {
    return generateContentStream(contents, generationConfig, null);
  }

  /**
   * Generates content with streaming support from generative model given a list of contents and
   * safety settings.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, List<SafetySetting> safetySettings) throws IOException {
    return generateContentStream(contents, null, safetySettings);
  }

  /**
   * Generates content with streaming support from generative model given a list of contents,
   * generation config, and safety settings.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} instance for
   *     generating response. {@link #getGenerationConfig} will not be used if this is set
   * @param safetySettings a list of {@link com.google.cloud.vertexai.api.SafetySetting} for
   *     generating response. {@link #getSafetySettings} will not be used if this is set
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   * @deprecated use {@link #generateContentStream(List<Content>, GenerateContentConfig)} instead
   */
  @BetaApi("safetySettings is a preview feature.")
  @Deprecated
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    if (generationConfig != null) {
      requestBuilder.setGenerationConfig(generationConfig);
    } else if (this.generationConfig != null) {
      requestBuilder.setGenerationConfig(this.generationConfig);
    }
    if (safetySettings != null) {
      requestBuilder.addAllSafetySettings(safetySettings);
    } else if (this.safetySettings != null) {
      requestBuilder.addAllSafetySettings(this.safetySettings);
    }
    if (this.tools != null) {
      requestBuilder.addAllTools(this.tools);
    }
    return generateContentStream(requestBuilder.build());
  }

  /**
   * Generates content with streaming support from generative model given a list of contents and
   * configs.
   *
   * @param contents a list of {@link com.google.cloud.vertexai.api.Content} to send to the
   *     generative model
   * @param config a {@link GenerateContentConfig} that contains all the configs in making a
   *     generate content api call
   * @return a {@link ResponseStream} that contains a streaming of {@link
   *     com.google.cloud.vertexai.api.GenerateContentResponse}
   * @throws IOException if an I/O error occurs while making the API call
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, GenerateContentConfig config) throws IOException {
    GenerateContentRequest.Builder requestBuilder =
        GenerateContentRequest.newBuilder().setModel(this.resourceName).addAllContents(contents);
    if (config.getGenerationConfig() != null) {
      requestBuilder.setGenerationConfig(config.getGenerationConfig());
    } else if (this.generationConfig != null) {
      requestBuilder.setGenerationConfig(this.generationConfig);
    }
    if (config.getSafetySettings().isEmpty() == false) {
      requestBuilder.addAllSafetySettings(config.getSafetySettings());
    } else if (this.safetySettings != null) {
      requestBuilder.addAllSafetySettings(this.safetySettings);
    }
    if (config.getTools().isEmpty() == false) {
      requestBuilder.addAllTools(config.getTools());
    } else if (this.tools != null) {
      requestBuilder.addAllTools(this.tools);
    }

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
    if (this.transport == Transport.REST) {
      return new ResponseStream(
          new ResponseStreamIteratorWithHistory(
              vertexAi
                  .getPredictionServiceRestClient()
                  .streamGenerateContentCallable()
                  .call(request)
                  .iterator()));
    } else {
      return new ResponseStream(
          new ResponseStreamIteratorWithHistory(
              vertexAi
                  .getPredictionServiceClient()
                  .streamGenerateContentCallable()
                  .call(request)
                  .iterator()));
    }
  }

  /**
   * Sets the value for {@link #getGenerationConfig}, which will be used by default for generating
   * response.
   */
  @BetaApi
  public void setGenerationConfig(GenerationConfig generationConfig) {
    this.generationConfig = generationConfig;
  }

  /**
   * Sets the value for {@link #getSafetySettings}, which will be used by default for generating
   * response.
   */
  @BetaApi("safetySettings is a preview feature.")
  public void setSafetySettings(List<SafetySetting> safetySettings) {
    this.safetySettings = new ArrayList<>();
    for (SafetySetting safetySetting : safetySettings) {
      this.safetySettings.add(safetySetting);
    }
  }

  /**
   * Sets the value for {@link #getTools}, which will be used by default for generating response.
   */
  @BetaApi("tools is a preview feature.")
  public void setTools(List<Tool> tools) {
    this.tools = new ArrayList<>();
    for (Tool tool : tools) {
      this.tools.add(tool);
    }
  }

  /**
   * Sets the value for {@link #getTransport}, which defines the layer for API calls in this
   * generative model.
   */
  public void setTransport(Transport transport) {
    this.transport = transport;
  }

  /** Returns the model name of this generative model. */
  public String getModelName() {
    return this.modelName;
  }

  /** Returns the {@link Transport} layer for API calls in this generative model. */
  public Transport getTransport() {
    return this.transport;
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
  public List<SafetySetting> getSafetySettings() {
    if (this.safetySettings != null) {
      return Collections.unmodifiableList(this.safetySettings);
    } else {
      return null;
    }
  }

  /** Returns a list of {@link com.google.cloud.vertexai.api.Tool} of this generative model. */
  @BetaApi("tools is a preview feature.")
  public List<Tool> getTools() {
    if (this.tools != null) {
      return Collections.unmodifiableList(this.tools);
    } else {
      return null;
    }
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
