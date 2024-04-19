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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Candidate;
import com.google.cloud.vertexai.api.Candidate.FinishReason;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.FunctionDeclaration;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Tool;
import com.google.cloud.vertexai.api.Type;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public final class ChatSessionTest {
  private static final String PROJECT = "test_project";
  private static final String LOCATION = "test_location";

  private static final String SAMPLE_MESSAGE1 = "how are you?";
  private static final String RESPONSE_STREAM_CHUNK1_TEXT = "I do not have any feelings";
  private static final String RESPONSE_STREAM_CHUNK2_TEXT = "But I'm happy to help you!";
  private static final String FULL_RESPONSE_TEXT =
      RESPONSE_STREAM_CHUNK1_TEXT + RESPONSE_STREAM_CHUNK2_TEXT;
  private static final String SAMPLE_MESSAGE_2 = "What can you do for me?";
  private static final String RESPONSE_TEXT_2 = "I can summarize a bo";
  private static final GenerateContentResponse RESPONSE_STREAM_CHUNK1_RESPONSE =
      GenerateContentResponse.newBuilder()
          .addCandidates(
              Candidate.newBuilder()
                  .setContent(
                      Content.newBuilder()
                          .addParts(Part.newBuilder().setText(RESPONSE_STREAM_CHUNK1_TEXT))))
          .build();
  private static final GenerateContentResponse RESPONSE_STREAM_CHUNK2_RESPONSE =
      GenerateContentResponse.newBuilder()
          .addCandidates(
              Candidate.newBuilder()
                  .setFinishReason(FinishReason.MAX_TOKENS)
                  .setContent(
                      Content.newBuilder()
                          .addParts(Part.newBuilder().setText(RESPONSE_STREAM_CHUNK2_TEXT))))
          .build();
  private static final GenerateContentResponse
      RESPONSE_STREAM_CHUNK2_RESPONSE_WITHOUT_FINISH_REASON =
          GenerateContentResponse.newBuilder()
              .addCandidates(
                  Candidate.newBuilder()
                      .setContent(
                          Content.newBuilder()
                              .addParts(Part.newBuilder().setText(RESPONSE_STREAM_CHUNK2_TEXT))))
              .build();
  private static final GenerateContentResponse RESPONSE_FROM_UNARY_CALL =
      GenerateContentResponse.newBuilder()
          .addCandidates(
              Candidate.newBuilder()
                  .setFinishReason(FinishReason.STOP)
                  .setContent(
                      Content.newBuilder().addParts(Part.newBuilder().setText(FULL_RESPONSE_TEXT))))
          .build();
  private static final GenerateContentResponse RESPONSE_FROM_UNARY_CALL_2 =
      GenerateContentResponse.newBuilder()
          .addCandidates(
              Candidate.newBuilder()
                  .setFinishReason(FinishReason.MAX_TOKENS)
                  .setContent(
                      Content.newBuilder().addParts(Part.newBuilder().setText(RESPONSE_TEXT_2))))
          .build();

  private static final GenerateContentResponse RESPONSE_FROM_UNARY_CALL_WITH_OTHER_FINISH_REASON =
      GenerateContentResponse.newBuilder()
          .addCandidates(
              Candidate.newBuilder()
                  .setFinishReason(FinishReason.SAFETY)
                  .setContent(
                      Content.newBuilder().addParts(Part.newBuilder().setText(FULL_RESPONSE_TEXT))))
          .build();

  private static final GenerationConfig GENERATION_CONFIG =
      GenerationConfig.newBuilder().setCandidateCount(1).build();
  private static final SafetySetting SAFETY_SETTING =
      SafetySetting.newBuilder()
          .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
          .setThreshold(HarmBlockThreshold.BLOCK_LOW_AND_ABOVE)
          .build();
  private static final Tool TOOL =
      Tool.newBuilder()
          .addFunctionDeclarations(
              FunctionDeclaration.newBuilder()
                  .setName("getCurrentWeather")
                  .setDescription("Get the current weather in a given location")
                  .setParameters(
                      Schema.newBuilder()
                          .setType(Type.OBJECT)
                          .putProperties(
                              "location",
                              Schema.newBuilder()
                                  .setType(Type.STRING)
                                  .setDescription("location")
                                  .build())
                          .addRequired("location")))
          .build();

  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private GenerativeModel mockGenerativeModel;
  @Mock private Iterator<GenerateContentResponse> mockServerStreamIterator;

  @Mock private PredictionServiceClient mockPredictionServiceClient;

  @Mock private UnaryCallable<GenerateContentRequest, GenerateContentResponse> mockUnaryCallable;

  @Mock private GenerateContentResponse mockGenerateContentResponse;

  private ChatSession chat;

  @Before
  public void doBeforeEachTest() {
    chat = new ChatSession(mockGenerativeModel);
  }

  @Test
  public void sendMessageStreamWithText_historyContainsTwoTurns() throws IOException {
    // (Arrange) Set up the responseStream
    ResponseStream<GenerateContentResponse> responseStream =
        new ResponseStream(new ResponseStreamIteratorWithHistory(mockServerStreamIterator));
    when(mockServerStreamIterator.hasNext()).thenReturn(true, true, false);
    when(mockServerStreamIterator.next())
        .thenReturn(RESPONSE_STREAM_CHUNK1_RESPONSE, RESPONSE_STREAM_CHUNK2_RESPONSE);

    // (Arrange) Set up the return value of the generateContentStream
    when(mockGenerativeModel.generateContentStream(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(responseStream);

    // (Act) send request, consume response and get history
    ResponseStream<GenerateContentResponse> returnedResponseStream =
        chat.sendMessageStream(SAMPLE_MESSAGE1);
    // User needs to consume the response stream;
    returnedResponseStream.stream().forEach(element -> {});

    List<Content> history = chat.getHistory();
    // (Assert) 1. The request message is in the first content of history. 2. The streamed output is
    // combined into the second content of history.
    assertThat(history.get(0).getParts(0).getText()).isEqualTo(SAMPLE_MESSAGE1);
    assertThat(history.get(1).getParts(0).getText()).isEqualTo(FULL_RESPONSE_TEXT);
  }

  @Test
  public void sendMessageStreamWithText_throwsIllegalStateExceptionIfResponseNotConsumed()
      throws IOException {
    // (Arrange) Set up the responseStream
    ResponseStream<GenerateContentResponse> responseStream =
        new ResponseStream(new ResponseStreamIteratorWithHistory(mockServerStreamIterator));

    // (Arrange) Set up the return value of the generateContentStream
    when(mockGenerativeModel.generateContentStream(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(responseStream);

    // (Act & Assert) Send request, consume response and get history, but not consume the response
    // Assert IllegalStateException will be thrown.
    ResponseStream<GenerateContentResponse> returnedResponseStream =
        chat.sendMessageStream(SAMPLE_MESSAGE1);

    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> chat.getHistory());
    assertThat(thrown).hasMessageThat().isEqualTo("Response stream is not consumed");
  }

  @Test
  public void sendMessageWithText_historyContainsTwoTurns() throws IOException {

    // (Arrange) Set up the return value of the generateContent
    when(mockGenerativeModel.generateContent(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(RESPONSE_FROM_UNARY_CALL);

    // (Act) Send text message via sendMessage and get the history.
    GenerateContentResponse response = chat.sendMessage(SAMPLE_MESSAGE1);
    List<Content> history = chat.getHistory();
    // (Assert) Assert that 1) the first content contains the user request text, and 2) the second
    // content in history contains the response.
    assertThat(history.get(0).getParts(0).getText()).isEqualTo(SAMPLE_MESSAGE1);
    assertThat(history.get(1).getParts(0).getText()).isEqualTo(FULL_RESPONSE_TEXT);
  }

  @Test
  public void sendMessageWithTextThenModifyHistory_historyChangedToNewContentList()
      throws IOException {

    // (Arrange) Set up the return value of the generateContent
    when(mockGenerativeModel.generateContent(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(RESPONSE_FROM_UNARY_CALL);

    // (Act) Send text message via sendMessage and get the history.
    GenerateContentResponse response = chat.sendMessage(SAMPLE_MESSAGE1);
    List<Content> history = chat.getHistory();
    // (Assert) Assert that 1) the first content contains the user request text, and 2) the second
    // content in history contains the response.
    assertThat(history.get(0).getParts(0).getText()).isEqualTo(SAMPLE_MESSAGE1);
    assertThat(history.get(1).getParts(0).getText()).isEqualTo(FULL_RESPONSE_TEXT);

    // (Act) Set history to an empty list
    chat.setHistory(Arrays.asList());
    // (Assert) Asser that the history is empty.
    assertThat(chat.getHistory().size()).isEqualTo(0);
  }

  @Test
  public void sendMessageStreamWithText_throwsIllegalStateExceptionWhenFinishReasonIsNotSTOP()
      throws IOException {
    // (Arrange) Set up the responseStream
    ResponseStream<GenerateContentResponse> responseStream =
        new ResponseStream(new ResponseStreamIteratorWithHistory(mockServerStreamIterator));
    when(mockServerStreamIterator.hasNext()).thenReturn(true, true, false);
    when(mockServerStreamIterator.next())
        .thenReturn(
            RESPONSE_STREAM_CHUNK1_RESPONSE, RESPONSE_STREAM_CHUNK2_RESPONSE_WITHOUT_FINISH_REASON);

    // (Arrange) Set up the return value of the generateContentStream
    when(mockGenerativeModel.generateContentStream(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(responseStream);

    // (Act) send request, consume response
    ResponseStream<GenerateContentResponse> returndResponseStream =
        chat.sendMessageStream(SAMPLE_MESSAGE1);
    returndResponseStream.stream().forEach(element -> {});

    // (Act & Assert) get history and assert IllegalStateException for not having the right finish
    // reason.
    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> chat.getHistory());
    assertThat(thrown).hasMessageThat().isEqualTo("Rerun getHistory() to get cleaned history.");

    // Assert that the history can be fetched again and it's empty.
    List<Content> history = chat.getHistory();
    assertThat(history.size()).isEqualTo(0);
  }

  @Test
  public void sendMessageWithText_throwsIllegalStateExceptionWhenFinishReasonIsNotSTOP()
      throws IOException {
    // (Arrange) Set up the return value of the generateContent
    when(mockGenerativeModel.generateContent(
            Arrays.asList(ContentMaker.fromString(SAMPLE_MESSAGE1))))
        .thenReturn(RESPONSE_FROM_UNARY_CALL_WITH_OTHER_FINISH_REASON);

    // (Act) Send text message via sendMessage
    GenerateContentResponse response = chat.sendMessage(SAMPLE_MESSAGE1);

    // (Act & Assert) get history and assert IllegalStateException for not having the right finish
    // reason.
    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> chat.getHistory());
    assertThat(thrown).hasMessageThat().isEqualTo("Rerun getHistory() to get cleaned history.");
    // Assert that the history can be fetched again and it's empty.
    List<Content> history = chat.getHistory();
    assertThat(history.size()).isEqualTo(0);
  }

  @Test
  public void testChatSessionMergeHistoryToRootChatSession() throws Exception {

    // (Arrange) Set up the return value of the generateContent

    VertexAI vertexAi =
        new VertexAI.Builder()
            .setProjectId(PROJECT)
            .setLocation(LOCATION)
            .setPredictionClientSupplier(() -> mockPredictionServiceClient)
            .build();

    GenerativeModel model = new GenerativeModel("gemini-pro", vertexAi);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(RESPONSE_FROM_UNARY_CALL)
        .thenReturn(RESPONSE_FROM_UNARY_CALL_2);

    // (Act) Send text message in root chat
    ChatSession rootChat = model.startChat();
    GenerateContentResponse response = rootChat.sendMessage(SAMPLE_MESSAGE1);
    // (Act) Create a child chat session and send message again
    ChatSession childChat =
        rootChat
            .withGenerationConfig(GENERATION_CONFIG)
            .withSafetySettings(Arrays.asList(SAFETY_SETTING))
            .withTools(Arrays.asList(TOOL));
    response = childChat.sendMessage(SAMPLE_MESSAGE_2);

    // (Assert) root chat history should contain all 4 contents
    List<Content> history = rootChat.getHistory();
    assertThat(history.get(0).getParts(0).getText()).isEqualTo(SAMPLE_MESSAGE1);
    assertThat(history.get(1).getParts(0).getText()).isEqualTo(FULL_RESPONSE_TEXT);
    assertThat(history.get(2).getParts(0).getText()).isEqualTo(SAMPLE_MESSAGE_2);
    assertThat(history.get(3).getParts(0).getText()).isEqualTo(RESPONSE_TEXT_2);

    // (Assert) the second request (from child chat) should contained updated configurations
    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable, times(2)).call(request.capture());
    assertThat(request.getAllValues().get(1).getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getAllValues().get(1).getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getAllValues().get(1).getTools(0)).isEqualTo(TOOL);
  }
}
