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
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Represents a conversation between the user and the model */
public final class ChatSession {
  private final GenerativeModel model;
  private final Optional<ChatSession> rootChatSession;
  private List<Content> history = new ArrayList<>();
  private Optional<ResponseStream<GenerateContentResponse>> currentResponseStream;
  private Optional<GenerateContentResponse> currentResponse;

  /**
   * Creates a new chat session given a GenerativeModel instance. Configurations of the chat (e.g.,
   * GenerationConfig) inherits from the model.
   */
  public ChatSession(GenerativeModel model) {
    this(model, Optional.empty());
  }

  /**
   * Creates a new chat session given a GenerativeModel instance and a root chat session.
   * Configurations of the chat (e.g., GenerationConfig) inherits from the model.
   *
   * @param model a {@link GenerativeModel} instance that generates contents in the chat.
   * @param rootChatSession a root {@link ChatSession} instance. All the chat history in the current
   *     chat session will be merged to the root chat session.
   * @return a {@link ChatSession} instance.
   */
  private ChatSession(GenerativeModel model, Optional<ChatSession> rootChatSession) {
    checkNotNull(model, "model should not be null");
    this.model = model;
    this.rootChatSession = rootChatSession;
    currentResponseStream = Optional.empty();
    currentResponse = Optional.empty();
  }

  /**
   * Creates a copy of the current ChatSession with updated GenerationConfig.
   *
   * @param generationConfig a {@link com.google.cloud.vertexai.api.GenerationConfig} that will be
   *     used in the new ChatSession.
   * @return a new {@link ChatSession} instance with the specified GenerationConfig.
   */
  public ChatSession withGenerationConfig(GenerationConfig generationConfig) {
    ChatSession rootChat = rootChatSession.orElse(this);
    ChatSession newChatSession =
        new ChatSession(model.withGenerationConfig(generationConfig), Optional.of(rootChat));
    newChatSession.history = history;
    return newChatSession;
  }

  /**
   * Creates a copy of the current ChatSession with updated SafetySettings.
   *
   * @param safetySettings a {@link com.google.cloud.vertexai.api.SafetySetting} that will be used
   *     in the new ChatSession.
   * @return a new {@link ChatSession} instance with the specified SafetySettings.
   */
  public ChatSession withSafetySettings(List<SafetySetting> safetySettings) {
    ChatSession rootChat = rootChatSession.orElse(this);
    ChatSession newChatSession =
        new ChatSession(model.withSafetySettings(safetySettings), Optional.of(rootChat));
    newChatSession.setHistory(history);
    return newChatSession;
  }

  /**
   * Creates a copy of the current ChatSession with updated Tools.
   *
   * @param tools a {@link com.google.cloud.vertexai.api.Tool} that will be used in the new
   *     ChatSession.
   * @return a new {@link ChatSession} instance with the specified Tools.
   */
  public ChatSession withTools(List<Tool> tools) {
    ChatSession rootChat = rootChatSession.orElse(this);
    ChatSession newChatSession = new ChatSession(model.withTools(tools), Optional.of(rootChat));
    newChatSession.setHistory(history);
    return newChatSession;
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param text the message to be sent.
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(String text) throws IOException {
    return sendMessageStream(ContentMaker.fromString(text));
  }

  /**
   * Sends a message to the model and returns a stream of responses.
   *
   * @param content the content to be sent.
   * @return an iterable in which each element is a GenerateContentResponse. Can be converted to
   *     stream by stream() method.
   */
  public ResponseStream<GenerateContentResponse> sendMessageStream(Content content)
      throws IOException, IllegalArgumentException {
    checkLastResponseAndEditHistory();
    history.add(content);
    ResponseStream<GenerateContentResponse> respStream = model.generateContentStream(history);
    setCurrentResponseStream(Optional.of(respStream));

    return respStream;
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param text the message to be sent.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(String text) throws IOException {
    return sendMessage(ContentMaker.fromString(text));
  }

  /**
   * Sends a message to the model and returns a response.
   *
   * @param content the content to be sent.
   * @return a response.
   */
  public GenerateContentResponse sendMessage(Content content) throws IOException {
    checkLastResponseAndEditHistory();
    history.add(content);
    GenerateContentResponse response = model.generateContent(history);
    setCurrentResponse(Optional.of(response));
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
    getCurrentResponse()
        .ifPresent(
            currentResponse -> {
              setCurrentResponse(Optional.empty());
              checkFinishReasonAndRemoveLastContent(currentResponse);
              history.add(getContent(currentResponse));
            });
    getCurrentResponseStream()
        .ifPresent(
            responseStream -> {
              if (!responseStream.isConsumed()) {
                throw new IllegalStateException("Response stream is not consumed");
              } else {
                setCurrentResponseStream(Optional.empty());
                GenerateContentResponse response = aggregateStreamIntoResponse(responseStream);
                checkFinishReasonAndRemoveLastContent(response);
                history.add(getContent(response));
              }
            });
  }

  /** Removes the last content in the history if the response finished with problems. */
  private void checkFinishReasonAndRemoveLastContent(GenerateContentResponse response) {
    FinishReason finishReason = getFinishReason(response);
    if (finishReason != FinishReason.STOP && finishReason != FinishReason.MAX_TOKENS) {
      removeLastContent();
      throw new IllegalStateException(
          String.format(
              "The last round of conversation will not be added to history because response"
                  + " stream did not finish normally. Finish reason is %s.",
              finishReason));
    }
  }

  /**
   * Returns the history of the conversation.
   *
   * @return a history of the conversation as an immutable list of {@link Content}.
   */
  public ImmutableList<Content> getHistory() {
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
    return ImmutableList.copyOf(history);
  }

  /**
   * Returns the current response of the root chat session (if exists) or the current chat session.
   */
  private Optional<GenerateContentResponse> getCurrentResponse() {
    if (rootChatSession.isPresent()) {
      return rootChatSession.get().currentResponse;
    } else {
      return currentResponse;
    }
  }

  /**
   * Returns the current responseStream of the root chat session (if exists) or the current chat
   * session.
   */
  private Optional<ResponseStream<GenerateContentResponse>> getCurrentResponseStream() {
    if (rootChatSession.isPresent()) {
      return rootChatSession.get().currentResponseStream;
    } else {
      return currentResponseStream;
    }
  }

  /** Set the history to a list of Content */
  public void setHistory(List<Content> history) {
    this.history = history;
  }

  /** Sets the current response of the root chat session (if exists) or the current chat session. */
  private void setCurrentResponse(Optional<GenerateContentResponse> response) {
    if (currentResponseStream.isPresent()) {
      throw new IllegalStateException(
          "currentResponse and currentResponseStream cannot be set together");
    }
    if (rootChatSession.isPresent()) {
      rootChatSession.get().setCurrentResponse(response);
    } else {
      currentResponse = response;
    }
  }

  /**
   * Sets the current responseStream of the root chat session (if exists) or the current chat
   * session.
   */
  private void setCurrentResponseStream(
      Optional<ResponseStream<GenerateContentResponse>> responseStream) {
    if (currentResponse.isPresent()) {
      throw new IllegalStateException(
          "currentResponseStream and currentResponse cannot be set together");
    }
    if (rootChatSession.isPresent()) {
      rootChatSession.get().setCurrentResponseStream(responseStream);
    } else {
      currentResponseStream = responseStream;
    }
  }
}
