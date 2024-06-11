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
import static com.google.cloud.vertexai.generativeai.ResponseHandler.getFunctionCalls;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.FunctionCall;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import com.google.cloud.vertexai.api.ToolConfig;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Represents a conversation between the user and the model */
public final class ChatSession {
  private final GenerativeModel model;
  private final Optional<ChatSession> rootChatSession;
  private final Optional<AutomaticFunctionCallingResponder> automaticFunctionCallingResponder;
  private List<Content> history;
  private int previousHistorySize;
  private Optional<ResponseStream<GenerateContentResponse>> currentResponseStream;
  private Optional<GenerateContentResponse> currentResponse;

  /**
   * Creates a new chat session given a GenerativeModel instance. Configurations of the chat (e.g.,
   * GenerationConfig) inherits from the model.
   */
  public ChatSession(GenerativeModel model) {
    this(model, new ArrayList<>(), 0, Optional.empty(), Optional.empty());
  }

  /**
   * Creates a new chat session given a GenerativeModel instance and a root chat session.
   * Configurations of the chat (e.g., GenerationConfig) inherits from the model.
   *
   * @param model a {@link GenerativeModel} instance that generates contents in the chat.
   * @param history a list of {@link Content} containing interleaving conversation between "user"
   *     and "model".
   * @param previousHistorySize the size of the previous history.
   * @param rootChatSession a root {@link ChatSession} instance. All the chat history in the current
   *     chat session will be merged to the root chat session.
   * @param automaticFunctionCallingResponder an {@link AutomaticFunctionCallingResponder} instance
   *     that can automatically respond to function calls requested by the model.
   * @return a {@link ChatSession} instance.
   */
  private ChatSession(
      GenerativeModel model,
      List<Content> history,
      int previousHistorySize,
      Optional<ChatSession> rootChatSession,
      Optional<AutomaticFunctionCallingResponder> automaticFunctionCallingResponder) {
    checkNotNull(model, "model should not be null");
    this.model = model;
    this.history = history;
    this.previousHistorySize = previousHistorySize;
    this.rootChatSession = rootChatSession;
    this.automaticFunctionCallingResponder = automaticFunctionCallingResponder;
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
    return new ChatSession(
        model.withGenerationConfig(generationConfig),
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        automaticFunctionCallingResponder);
  }

  /**
   * Creates a copy of the current ChatSession with updated SafetySettings.
   *
   * @param safetySettings a {@link com.google.cloud.vertexai.api.SafetySetting} that will be used
   *     in the new ChatSession.
   * @return a new {@link ChatSession} instance with the specified SafetySettings.
   */
  public ChatSession withSafetySettings(List<SafetySetting> safetySettings) {
    return new ChatSession(
        model.withSafetySettings(safetySettings),
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        automaticFunctionCallingResponder);
  }

  /**
   * Creates a copy of the current ChatSession with updated Tools.
   *
   * @param tools a {@link com.google.cloud.vertexai.api.Tool} that will be used in the new
   *     ChatSession.
   * @return a new {@link ChatSession} instance with the specified Tools.
   */
  public ChatSession withTools(List<Tool> tools) {
    return new ChatSession(
        model.withTools(tools),
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        automaticFunctionCallingResponder);
  }

  /**
   * Creates a copy of the current ChatSession with updated ToolConfig.
   *
   * @param toolConfig a {@link com.google.cloud.vertexai.api.ToolConfig} that will be used in the
   *     new ChatSession.
   * @return a new {@link ChatSession} instance with the specified ToolConfigs.
   */
  public ChatSession withToolConfig(ToolConfig toolConfig) {
    return new ChatSession(
        model.withToolConfig(toolConfig),
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        automaticFunctionCallingResponder);
  }

  /**
   * Creates a copy of the current ChatSession with updated SystemInstruction.
   *
   * @param systemInstruction a {@link com.google.cloud.vertexai.api.Content} containing system
   *     instructions.
   * @return a new {@link ChatSession} instance with the specified ToolConfigs.
   */
  public ChatSession withSystemInstruction(Content systemInstruction) {
    return new ChatSession(
        model.withSystemInstruction(systemInstruction),
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        automaticFunctionCallingResponder);
  }

  /**
   * Creates a copy of the current ChatSession with updated AutomaticFunctionCallingResponder.
   *
   * @param automaticFunctionCallingResponder an {@link AutomaticFunctionCallingResponder} instance
   *     that will be used in the new ChatSession.
   * @return a new {@link ChatSession} instance with the specified
   *     AutomaticFunctionCallingResponder.
   */
  public ChatSession withAutomaticFunctionCallingResponder(
      AutomaticFunctionCallingResponder automaticFunctionCallingResponder) {
    return new ChatSession(
        model,
        history,
        previousHistorySize,
        Optional.of(rootChatSession.orElse(this)),
        Optional.of(automaticFunctionCallingResponder));
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
      throws IOException {
    checkLastResponseAndEditHistory();
    history.add(content);

    ResponseStream<GenerateContentResponse> respStream;
    try {
      respStream = model.generateContentStream(history);
    } catch (IOException e) {
      // If the API call fails, revert the history before throwing.
      revertHistory();
      throw e;
    }
    setCurrentResponseStream(Optional.of(respStream));

    // TODO(jayceeli) enable AFC in sendMessageStream
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
    GenerateContentResponse response;
    try {
      response = model.generateContent(history);
      setCurrentResponse(Optional.of(response));
      return autoRespond(response);
    } catch (Exception e) {
      // If any step fails, reset the history and current response.
      checkLastResponseAndEditHistory();
      revertHistory();
      throw e;
    }
  }

  /**
   * Automatically responds to the model if there is an AutomaticFunctionCallingResponder and
   * model's response contains function calls.
   */
  private GenerateContentResponse autoRespond(GenerateContentResponse originalResponse)
      throws IOException {
    // Return the original response if there is no AFC responder or no function calls in the
    // response.
    if (!automaticFunctionCallingResponder.isPresent()) {
      return originalResponse;
    }
    ImmutableList<FunctionCall> functionCalls = getFunctionCalls(originalResponse);
    if (functionCalls.isEmpty()) {
      return originalResponse;
    }

    // Each time we call the `autoRespond`, we add 2 contents(user's functionResponse and model's
    // functionCall) to the history and update the previousHistorySize during
    // `checkLastResponseAndEditHistory`. But we shouldn't update the previousHistorySize because we
    // will revert the whole history if any intermediate step fails. So we offset the
    // previousHistorySize by 2 here.
    setPreviousHistorySize(getPreviousHistorySize() - 2);
    GenerateContentResponse response;
    try {
      // Let the responder generate the response content and send it to the model.
      Content autoRespondedContent =
          automaticFunctionCallingResponder.get().getContentFromFunctionCalls(functionCalls);
      response = sendMessage(autoRespondedContent);
    } finally {
      // Reset the responder whether it succeeds or fails.
      automaticFunctionCallingResponder.get().resetRemainingFunctionCalls();
    }
    return response;
  }

  /** Reverts the history to the previous state. */
  private void revertHistory() {
    history.subList(getPreviousHistorySize(), history.size()).clear();
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
              checkFinishReasonAndEditHistory(currentResponse);
              history.add(getContent(currentResponse));
              // If `checkFinishReasonAndEditHistory` passes, we add 2 contents(user's message and
              // model's response) to the history and then one round of conversation is finished. So
              // we add 2 to the previousHistorySize.
              setPreviousHistorySize(getPreviousHistorySize() + 2);
            });
    getCurrentResponseStream()
        .ifPresent(
            responseStream -> {
              if (!responseStream.isConsumed()) {
                throw new IllegalStateException("Response stream is not consumed");
              } else {
                setCurrentResponseStream(Optional.empty());
                GenerateContentResponse response = aggregateStreamIntoResponse(responseStream);
                checkFinishReasonAndEditHistory(response);
                history.add(getContent(response));
                // If `checkFinishReasonAndEditHistory` passes, we add 2 contents(user's message and
                // model's response) to the history and then one round of conversation is finished.
                // So we add 2 to the previousHistorySize.
                setPreviousHistorySize(getPreviousHistorySize() + 2);
              }
            });
  }

  /** Reverts the history if the response finished with problems. */
  private void checkFinishReasonAndEditHistory(GenerateContentResponse response) {
    FinishReason finishReason = getFinishReason(response);
    if (finishReason != FinishReason.STOP && finishReason != FinishReason.MAX_TOKENS) {
      revertHistory();
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
   * Returns the previous history size of the root chat session (if exists) or the current chat
   * session.
   */
  private int getPreviousHistorySize() {
    if (rootChatSession.isPresent()) {
      return rootChatSession.get().previousHistorySize;
    }
    return previousHistorySize;
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

  /**
   * Sets the history to a list of Content.
   *
   * @param history A list of {@link Content} containing interleaving conversation between "user"
   *     and "model".
   */
  public void setHistory(List<Content> history) {
    this.history = new ArrayList<>(history);
  }

  /**
   * Sets the previous history size of the root chat session (if exists) or the current chat
   * session.
   */
  private void setPreviousHistorySize(int historySize) {
    previousHistorySize = historySize;
    if (rootChatSession.isPresent()) {
      rootChatSession.get().previousHistorySize = historySize;
    }
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
