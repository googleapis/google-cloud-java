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

import static com.google.cloud.vertexai.generativeai.preview.ResponseHandler.aggregateStreamIntoResponse;
import static com.google.cloud.vertexai.generativeai.preview.ResponseHandler.getContent;

import com.google.cloud.vertexai.v1beta1.Content;
import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import com.google.cloud.vertexai.v1beta1.GenerationConfig;
import com.google.cloud.vertexai.v1beta1.SafetySetting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Represents a conversation between the user and the model */
public class ChatSession {
  private final GenerativeModel model;
  private List<Content> history = new ArrayList<>();
  private ResponseStream<GenerateContentResponse> currentResponseStream = null;
  private GenerateContentResponse currentResponse = null;

  public ChatSession(GenerativeModel model) {
    if (model == null) {
      throw new IllegalArgumentException("model should not be null");
    }
    this.model = model;
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(String text) throws IOException {
    return sendMessageStream(text, null, null);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @param generationConfig the generation config.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      String text, GenerationConfig generationConfig) throws IOException {
    return sendMessageStream(text, generationConfig, null);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @param safetySettings the safety settings.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      String text, List<SafetySetting> safetySettings) throws IOException {
    return sendMessageStream(text, null, safetySettings);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @param generationConfig the generation config.
   * @param safetySettings the safety settings.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    checkLastResponseAndEditHistory();

    history.add(ContentMaker.fromString("user", text));

    ResponseStream<GenerateContentResponse> respStream =
        model.generateContentStream(history, generationConfig, safetySettings);
    currentResponseStream = respStream;
    currentResponse = null;
    return respStream;
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(Content content)
      throws IOException, IllegalArgumentException {
    return sendMessageStream(content, null, null);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @param generationConfig the generation config.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      Content content, GenerationConfig generationConfig) throws IOException, IllegalArgumentException {
    return sendMessageStream(content, generationConfig, null);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @param safetySettings the safety settings.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      Content content, List<SafetySetting> safetySettings) throws IOException, IllegalArgumentException {
    return sendMessageStream(content, null, safetySettings);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @param generationConfig the generation config.
   * @param safetySettings the safety settings.
   * @return a stream of responses.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      Content content, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException, IllegalArgumentException {
    checkLastResponseAndEditHistory();
    if (content.getPartsCount() != 1) {
      throw new IllegalArgumentException("ChatSession only allow text content in one single Part.");
    }
    if (!content.getParts(0).hasText()) {
      throw new IllegalArgumentException("ChatSession only allow text content.");
    }

    history.add(content);
    ResponseStream<GenerateContentResponse> respStream =
        model.generateContentStream(history, generationConfig, safetySettings);
    currentResponseStream = respStream;
    currentResponse = null;
    return respStream;
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(String text) throws IOException {
    return sendMessage(text, null, null);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @param generationConfig the generation config.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(String text, GenerationConfig generationConfig)
      throws IOException {
    return sendMessage(text, generationConfig, null);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @param safetySettings the safety settings.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(String text, List<SafetySetting> safetySettings)
      throws IOException {
    return sendMessage(text, null, safetySettings);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @param generationConfig the generation config.
   * @param safetySettings the safety settings.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(
      String text, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {

    checkLastResponseAndEditHistory();
    history.add(ContentMaker.fromString("user", text));
    GenerateContentResponse response =
        model.generateContent(history, generationConfig, safetySettings);
    currentResponse = response;
    currentResponseStream = null;
    return response;
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(Content content) throws IOException {
    return sendMessage(content, null, null);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @param generationConfig the generation config.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(Content content, GenerationConfig generationConfig)
      throws IOException {
    return sendMessage(content, generationConfig, null);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @param safetySettings the safety settings.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(Content content, List<SafetySetting> safetySettings)
      throws IOException {
    return sendMessage(content, null, safetySettings);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @param generationConfig the generation config.
   * @param safetySettings the safety settings.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(
      Content content, GenerationConfig generationConfig, List<SafetySetting> safetySettings)
      throws IOException {
    checkLastResponseAndEditHistory();
    history.add(content);
    GenerateContentResponse response =
        model.generateContent(history, generationConfig, safetySettings);
    currentResponse = response;
    currentResponseStream = null;
    return response;
  }

  /**
   * Checks whether the last response is available and edit the history if necessary.
   *
   * @throws IllegalStateException if the response stream is not finished.
   */
  private void checkLastResponseAndEditHistory() throws IllegalStateException {
    if (currentResponseStream == null && currentResponse == null) {
      return;
    } else if (currentResponseStream != null && !currentResponseStream.isConsumed()) {
      throw new IllegalStateException("Response stream is not consumed");
    } else if (currentResponseStream != null && currentResponseStream.isConsumed()) {
      // TODO(zhenyiqi): also checks the finish reason, if it's not STOP, throw an error
      history.add(getContent(aggregateStreamIntoResponse(currentResponseStream)));
    } else if (currentResponseStream == null && currentResponse != null) {
      // TODO(zhenyiqi): also checks the finish reason, if it's not STOP, throw an error
      history.add(getContent(currentResponse));
      currentResponse = null;
    }
  }

  /**
   * Returns the history of the conversation.
   *
   * @return the history of the conversation.
   */
  public List<Content> getHistory() {
    checkLastResponseAndEditHistory();
    return history;
  }
}
