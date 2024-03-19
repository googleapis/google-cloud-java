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

import static com.google.cloud.vertexai.generativeai.ResponseHandler.aggregateStreamIntoResponse;
import static com.google.cloud.vertexai.generativeai.ResponseHandler.getContent;
import static com.google.cloud.vertexai.generativeai.ResponseHandler.getFinishReason;

import com.google.api.core.BetaApi;
import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Represents a conversation between the user and the model */
public class ChatSession {
  private final GenerativeModel model;
  private List<Content> history = new ArrayList<>();
  private ResponseStream<GenerateContentResponse> currentResponseStream = null;
  private GenerateContentResponse currentResponse = null;

  @BetaApi
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
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  @BetaApi
  public ResponseStream<GenerateContentResponse> sendMessageStream(String text) throws IOException {
    return sendMessageStream(text, GenerateContentConfig.newBuilder().build());
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @param config a {@link GenerateContentConfig} that contains all the configs for sending message
   *     in a chat session.
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  @BetaApi
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      String text, GenerateContentConfig config) throws IOException {
    return sendMessageStream(ContentMaker.fromString(text), config);
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  @BetaApi
  public ResponseStream<GenerateContentResponse> sendMessageStream(Content content)
      throws IOException, IllegalArgumentException {
    return sendMessageStream(content, GenerateContentConfig.newBuilder().build());
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @param config a {@link GenerateContentConfig} that contains all the configs for sending message
   *     in a chat session.
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  @BetaApi
  public ResponseStream<GenerateContentResponse> sendMessageStream(
      Content content, GenerateContentConfig config) throws IOException {
    checkLastResponseAndEditHistory();
    history.add(content);
    ResponseStream<GenerateContentResponse> respStream =
        model.generateContentStream(history, config);
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
  @BetaApi
  public GenerateContentResponse sendMessage(String text) throws IOException {
    return sendMessage(text, GenerateContentConfig.newBuilder().build());
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @param config a {@link GenerateContentConfig} that contains all the configs for sending message
   *     in a chat session.
   * @return a response.
   */
  @BetaApi
  public GenerateContentResponse sendMessage(String text, GenerateContentConfig config)
      throws IOException {
    return sendMessage(ContentMaker.fromString(text), config);
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @return a response.
   */
  @BetaApi
  public GenerateContentResponse sendMessage(Content content) throws IOException {
    return sendMessage(content, GenerateContentConfig.newBuilder().build());
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @param config a {@link GenerateContentConfig} that contains all the configs for sending message
   *     in a chat session.
   * @return a response.
   */
  @BetaApi
  public GenerateContentResponse sendMessage(Content content, GenerateContentConfig config)
      throws IOException {
    checkLastResponseAndEditHistory();
    history.add(content);
    GenerateContentResponse response = model.generateContent(history, config);
    currentResponse = response;
    currentResponseStream = null;
    return response;
  }

  private void removeLastContent() {
    int lastIndex = history.size() - 1;
    history.remove(lastIndex);
  }

  /**
   * Checks whether the last response is available and edit the history if necessary.
   *
   * @throws IllegalStateException if the response stream is not finished.
   */
  private void checkLastResponseAndEditHistory() {
    if (currentResponseStream == null && currentResponse == null) {
      return;
    } else if (currentResponseStream != null && !currentResponseStream.isConsumed()) {
      throw new IllegalStateException("Response stream is not consumed");
    } else if (currentResponseStream != null && currentResponseStream.isConsumed()) {
      GenerateContentResponse response = aggregateStreamIntoResponse(currentResponseStream);
      FinishReason finishReason = getFinishReason(response);
      if (finishReason != FinishReason.STOP && finishReason != FinishReason.MAX_TOKENS) {
        // We also remove the request from the history.
        removeLastContent();
        currentResponseStream = null;
        throw new IllegalStateException(
            String.format(
                "The last round of conversation will not be added to history because response"
                    + " stream did not finish normally. Finish reason is %s.",
                finishReason));
      }
      history.add(getContent(response));
    } else if (currentResponseStream == null && currentResponse != null) {
      FinishReason finishReason = getFinishReason(currentResponse);
      if (finishReason != FinishReason.STOP && finishReason != FinishReason.MAX_TOKENS) {
        // We also remove the request from the history.
        removeLastContent();
        currentResponse = null;
        throw new IllegalStateException(
            String.format(
                "The last round of conversation will not be added to history because response did"
                    + " not finish normally. Finish reason is %s.",
                finishReason));
      }
      history.add(getContent(currentResponse));
      currentResponse = null;
    }
  }

  /**
   * Returns the history of the conversation.
   *
   * @return an unmodifiable history of the conversation.
   */
  @BetaApi
  public List<Content> getHistory() {
    try {
      checkLastResponseAndEditHistory();
    } catch (IllegalStateException e) {
      if (e.getMessage()
          .contains("The last round of conversation will not be added to history because")) {
        IllegalStateException modifiedExecption =
            new IllegalStateException("Rerun getHistory() to get cleaned history.");
        modifiedExecption.initCause(e);
        throw modifiedExecption;
      }
      throw e;
    }
    return Collections.unmodifiableList(history);
  }

  /** Set the history to a list of Content */
  @BetaApi
  public void setHistory(List<Content> history) {
    this.history = history;
  }
}
