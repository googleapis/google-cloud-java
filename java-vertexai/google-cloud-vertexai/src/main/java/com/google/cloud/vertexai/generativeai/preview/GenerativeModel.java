/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.Transport;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.v1beta1.Content;
import com.google.cloud.vertexai.v1beta1.GenerateContentRequest;
import com.google.cloud.vertexai.v1beta1.GenerateContentRequest.Builder;
import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import com.google.cloud.vertexai.v1beta1.GenerationConfig;
import com.google.cloud.vertexai.v1beta1.Part;
import com.google.cloud.vertexai.v1beta1.SafetySetting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Generative model class. */
public class GenerativeModel {
  private final String modelName;
  private final String resourceName;
  private final VertexAI vertexAi;
  private GenerationConfig generationConfig = null;
  private List<SafetySetting> safetySettings = null;
  private Transport transport;

  /** Instantiates a generative model. */
  public GenerativeModel(String modelName, VertexAI vertexAi) {
    this(modelName, null, null, vertexAi, null);
  }

  /** Instantiates a generative model. */
  public GenerativeModel(String modelName, VertexAI vertexAi, Transport transport) {
    this(modelName, null, null, vertexAi, transport);
  }

  /** Instantiates a generative model with default generation config. */
  public GenerativeModel(String modelName, GenerationConfig generationConfig, VertexAI vertexAi) {
    this(modelName, generationConfig, null, vertexAi, null);
  }

  /** Instantiates a generative model with default generation config. */
  public GenerativeModel(
      String modelName, GenerationConfig generationConfig, VertexAI vertexAi, Transport transport) {
    this(modelName, generationConfig, null, vertexAi, transport);
  }

  /** Instantiates a generative model with default generation config. */
  public GenerativeModel(String modelName, List<SafetySetting> safetySettings, VertexAI vertexAi) {
    this(modelName, null, safetySettings, vertexAi, null);
  }

  /** Instantiates a generative model with default generation config. */
  public GenerativeModel(
      String modelName,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi,
      Transport transport) {
    this(modelName, null, safetySettings, vertexAi, transport);
  }

  public GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi) {
    this(modelName, generationConfig, safetySettings, vertexAi, null);
  }

  /** Instantiates a generative model with default generation config. */
  public GenerativeModel(
      String modelName,
      GenerationConfig generationConfig,
      List<SafetySetting> safetySettings,
      VertexAI vertexAi,
      Transport transport) {
    validateModelName(modelName);
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

  /** Generate content from generative model given a text. */
  public GenerateContentResponse generateContent(String text) throws IOException {
    return generateContent(text, null, null);
  }

  /** Generate content from generative model given a text and generation config. */
  public GenerateContentResponse generateContent(String text, GenerationConfig generationConfig)
      throws IOException {
    return generateContent(text, generationConfig, null);
  }

  /** Generate content from generative model given a text and safety settings. */
  public GenerateContentResponse generateContent(String text, List<SafetySetting> safetySettings)
      throws IOException {
    return generateContent(text, null, safetySettings);
  }

  /**
   * Generate content from generative model given a text, generation config, and safety settings.
   */
  public GenerateContentResponse generateContent(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Part part = Part.newBuilder().setText(text).build();
    Content content = Content.newBuilder().addParts(part).setRole("user").build();
    List<Content> contents = Arrays.asList(content);
    return generateContent(contents, generationConfig, safetySettings);
  }

  /** Generate content from this model given a list of contents. */
  public GenerateContentResponse generateContent(List<Content> contents) throws IOException {
    return generateContent(contents, null, null);
  }

  /** Generate content from this model given a list of contents and generation config. */
  public GenerateContentResponse generateContent(
      List<Content> contents, GenerationConfig generationConfig) throws IOException {
    return generateContent(contents, generationConfig, null);
  }

  /** Generate content from this model given a list of contents and safety settings. */
  public GenerateContentResponse generateContent(
      List<Content> contents, List<SafetySetting> safetySettings) throws IOException {
    return generateContent(contents, null, safetySettings);
  }

  /**
   * Generate content from generative model given a list of contents, generation config, and safety
   * settings.
   */
  public GenerateContentResponse generateContent(
      List<Content> contents, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Builder requestBuilder = GenerateContentRequest.newBuilder().addAllContents(contents);
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
    return ResponseHandler.aggregateStreamIntoResponse(generateContentStream(requestBuilder));
  }

  /** Generate content with streaming support from generative model given a text. */
  public ResponseStream<GenerateContentResponse> generateContentStream(String text)
      throws IOException {
    return generateContentStream(text, null, null);
  }

  /**
   * Generate content with streaming support from generative model given a text and generation
   * config.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, GenerationConfig generationConfig) throws IOException {
    return generateContentStream(text, generationConfig, null);
  }

  /**
   * Generate content with streaming support from generative model given a text and safety settings.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, List<SafetySetting> safetySettings) throws IOException {
    return generateContentStream(text, null, safetySettings);
  }

  /**
   * Generate content with streaming support from generative model given a text, generation config,
   * and safety settings.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Part part = Part.newBuilder().setText(text).build();
    Content content = Content.newBuilder().addParts(part).setRole("user").build();
    List<Content> contents = Arrays.asList(content);
    return generateContentStream(contents, generationConfig, safetySettings);
  }

  /** Generate content with streaming support from generative model given a list of contents. */
  public ResponseStream<GenerateContentResponse> generateContentStream(List<Content> contents)
      throws IOException {
    return generateContentStream(contents, null, null);
  }

  /**
   * Generate content with streaming support from generative model given a list of contents and
   * generation config.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, GenerationConfig generationConfig) throws IOException {
    return generateContentStream(contents, generationConfig, null);
  }

  /**
   * Generate content with streaming support from generative model given a list of contents and
   * safety settings.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, List<SafetySetting> safetySettings) throws IOException {
    return generateContentStream(contents, null, safetySettings);
  }

  /**
   * Generate content with streaming support from generative model given a list of contents,
   * generation config, and safety settings.
   */
  public ResponseStream<GenerateContentResponse> generateContentStream(
      List<Content> contents, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    Builder requestBuilder = GenerateContentRequest.newBuilder().addAllContents(contents);
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
    return generateContentStream(requestBuilder);
  }

  private ResponseStream<GenerateContentResponse> generateContentStream(Builder requestBuilder)
      throws IOException {
    GenerateContentRequest request =
        requestBuilder.setEndpoint(this.resourceName).setModel(this.resourceName).build();
    ResponseStream<GenerateContentResponse> responseStream = null;
    if (this.transport == Transport.REST) {
      responseStream =
          new ResponseStream(
              new ResponseStreamIteratorWithHistory(
                  vertexAi
                      .getPredictionServiceRestClient()
                      .streamGenerateContentCallable()
                      .call(request)
                      .iterator()));
    } else {
      responseStream =
          new ResponseStream(
              new ResponseStreamIteratorWithHistory(
                  vertexAi
                      .getPredictionServiceClient()
                      .streamGenerateContentCallable()
                      .call(request)
                      .iterator()));
    }
    return responseStream;
  }

  /** Set the default generation config for this generative model. */
  public void setGenerationConfig(GenerationConfig generationConfig) {
    this.generationConfig = generationConfig;
  }

  /** Set the default safety settings for this generative model. */
  public void setSafetySettings(List<SafetySetting> safetySettings) {
    this.safetySettings = new ArrayList<>();
    for (SafetySetting safetySetting : safetySettings) {
      this.safetySettings.add(safetySetting);
    }
  }

  public void setTransport(Transport transport) {
    this.transport = transport;
  }

  /** Get the model name of this generative model. */
  public String getModelName() {
    return this.modelName;
  }

  public Transport getTransport() {
    return this.transport;
  }

  /** Get the default generation config of this generative model. */
  public GenerationConfig getGenerationConfig() {
    return this.generationConfig;
  }

  /** Get the default safety settings of this generative model. */
  public List<SafetySetting> getSafetySettings() {
    if (this.safetySettings != null) {
      return Collections.unmodifiableList(this.safetySettings);
    } else {
      return null;
    }
  }

  public ChatSession startChat() {
    return new ChatSession(this);
  }

  /** Checks if the model name is valid. */
  private static void validateModelName(String modelName) {
    if (!Constants.GENERATIVE_MODEL_NAMES.contains(modelName)) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid model name: %s. Please choose from: %s",
              modelName, Constants.GENERATIVE_MODEL_NAMES));
    }
  }
}
