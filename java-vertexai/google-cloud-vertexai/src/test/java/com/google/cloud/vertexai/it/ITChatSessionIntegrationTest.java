/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vertexai.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITChatSessionIntegrationTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String MODEL_NAME_TEXT = "gemini-pro";
  private static final String LOCATION = "us-central1";
  private static final Logger logger =
      Logger.getLogger(ITGenerativeModelIntegrationTest.class.getName());

  private VertexAI vertexAi;
  private GenerativeModel model;
  private ChatSession chat;

  @Before
  public void setUp() throws IOException {
    vertexAi = new VertexAI(PROJECT_ID, LOCATION);
    model = new GenerativeModel(MODEL_NAME_TEXT, vertexAi);
  }

  @After
  public void tearDown() throws IOException {
    vertexAi.close();
  }

  @Test
  public void sendMessageMixedStreamAndUnary_historyOfFour() throws IOException {
    // Arrange
    String firstMessage = "hello!";
    String secondMessage = "how old are you?";
    Content expectedFirstContent = ContentMaker.fromString(firstMessage);
    Content expectedThirdContent = ContentMaker.fromString(secondMessage);

    // Act
    chat = model.startChat();
    ResponseStream<GenerateContentResponse> stream = chat.sendMessageStream(firstMessage);
    // We consume the stream before sending another message
    for (GenerateContentResponse resp : stream) {
      // Assert while consuming
      assertThat(resp.getCandidatesList()).isNotEmpty();
    }
    GenerateContentResponse response = chat.sendMessage(secondMessage);
    List<Content> history = chat.getHistory();

    // Assert
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(String.format("The whole history is:\n%s", history));
    assertThat(history.size()).isEqualTo(4);
    assertThat(history.get(0)).isEqualTo(expectedFirstContent);
    assertThat(history.get(1).getRole()).isEqualTo("model");
    assertThat(history.get(2)).isEqualTo(expectedThirdContent);
    assertThat(history.get(3).getRole()).isEqualTo("model");
  }

  @Test
  public void sendMessageWithNewConfigs_historyContainsFullConversation() throws IOException {
    // Arrange
    String firstMessage = "hello!";
    String secondMessage = "how old are you?";
    Content expectedFirstContent = ContentMaker.fromString(firstMessage);
    Content expectedThirdContent = ContentMaker.fromString(secondMessage);
    GenerationConfig config = GenerationConfig.newBuilder().setTemperature(0.7F).build();
    List<SafetySetting> safetySettings =
        Arrays.asList(
            SafetySetting.newBuilder()
                .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
                .setThreshold(SafetySetting.HarmBlockThreshold.BLOCK_ONLY_HIGH)
                .build());

    // Act
    chat = model.startChat();
    ResponseStream<GenerateContentResponse> stream =
        chat.withGenerationConfig(config)
            .withSafetySettings(safetySettings)
            .sendMessageStream(firstMessage);
    // We consume the stream before sending another message
    for (GenerateContentResponse resp : stream) {
      // Assert while consuming
      assertThat(resp.getCandidatesList()).isNotEmpty();
    }
    GenerateContentResponse response =
        chat.withGenerationConfig(config)
            .withSafetySettings(safetySettings)
            .sendMessage(secondMessage);

    // Assert
    List<Content> history = chat.getHistory();
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(String.format("The whole history is:\n%s", history));
    assertThat(history.size()).isEqualTo(4);
    assertThat(history.get(0)).isEqualTo(expectedFirstContent);
    assertThat(history.get(1).getRole()).isEqualTo("model");
    assertThat(history.get(2)).isEqualTo(expectedThirdContent);
    assertThat(history.get(3).getRole()).isEqualTo("model");
  }
}
