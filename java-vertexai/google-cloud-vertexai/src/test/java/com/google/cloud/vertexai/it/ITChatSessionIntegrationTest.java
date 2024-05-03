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
import com.google.cloud.vertexai.api.Tool;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.FunctionDeclarationMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
    // Set temperature to 0 to reduce randomness on model responses
    GenerationConfig defaultGenerationConfig =
        GenerationConfig.newBuilder().setTemperature(0).build();
    model =
        new GenerativeModel(MODEL_NAME_TEXT, vertexAi)
            .withGenerationConfig(defaultGenerationConfig);
  }

  @After
  public void tearDown() throws IOException {
    vertexAi.close();
  }

  private static void assertSizeAndAlternatingRolesInHistory(
      String methodName,
      ImmutableList<Content> history,
      int expectedSize,
      ImmutableList<Content> expectedUserContent) {
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(String.format("%s: The whole history is:\n%s", methodName, history));
    assertThat(history.size()).isEqualTo(expectedSize);
    for (int i = 1; i < expectedSize; i += 2) {
      if (!expectedUserContent.isEmpty()) {
        assertThat(history.get(i - 1)).isEqualTo(expectedUserContent.get((i - 1) / 2));
      }
      assertThat(history.get(i - 1).getRole()).isEqualTo("user");
      assertThat(history.get(i).getRole()).isEqualTo("model");
    }
  }

  @Ignore(
      "TODO(b/335830545): The Gen AI API is too flaky to handle three sets of simultanenous IT on"
          + " the GitHub side.")
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
    ImmutableList<Content> history = chat.getHistory();

    // Assert
    assertSizeAndAlternatingRolesInHistory(
        Thread.currentThread().getStackTrace()[1].getMethodName(),
        history,
        4,
        ImmutableList.of(expectedFirstContent, expectedThirdContent));
  }

  @Ignore(
      "TODO(b/335830545): The Gen AI API is too flaky to handle three sets of simultanenous IT on"
          + " the GitHub side.")
  @Test
  public void sendMessageWithNewConfigs_historyContainsFullConversation() throws IOException {
    // Arrange
    String firstMessage = "hello!";
    String secondMessage = "how old are you?";
    Content expectedFirstContent = ContentMaker.fromString(firstMessage);
    Content expectedThirdContent = ContentMaker.fromString(secondMessage);
    GenerationConfig config = GenerationConfig.newBuilder().setTemperature(0.7F).build();
    ImmutableList<SafetySetting> safetySettings =
        ImmutableList.of(
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
    ImmutableList<Content> history = chat.getHistory();
    assertSizeAndAlternatingRolesInHistory(
        Thread.currentThread().getStackTrace()[1].getMethodName(),
        history,
        4,
        ImmutableList.of(expectedFirstContent, expectedThirdContent));
  }

  @Ignore(
      "TODO(b/335830545): The Gen AI API is too flaky to handle three sets of simultanenous IT on"
          + " the GitHub side.")
  @Test
  public void sendMessageWithFunctionCalling_functionCallInResponse() throws IOException {
    // Arrange
    String firstMessage = "hello!";
    String secondMessage = "What is the weather in Boston?";
    // Making an Json object representing a function declaration
    // The following code makes a function declaration
    // {
    //   "name": "getCurrentWeather",
    //   "description": "Get the current weather in a given location",
    //   "parameters": {
    //     "type": "OBJECT",
    //     "properties": {
    //       "location": {
    //         "type": "STRING",
    //         "description": "location"
    //       }
    //     }
    //   }
    // }
    JsonObject locationJsonObject = new JsonObject();
    locationJsonObject.addProperty("type", "STRING");
    locationJsonObject.addProperty("description", "location");

    JsonObject propertiesJsonObject = new JsonObject();
    propertiesJsonObject.add("location", locationJsonObject);

    JsonObject parametersJsonObject = new JsonObject();
    parametersJsonObject.addProperty("type", "OBJECT");
    parametersJsonObject.add("properties", propertiesJsonObject);

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", "getCurrentWeather");
    jsonObject.addProperty("description", "Get the current weather in a given location");
    jsonObject.add("parameters", parametersJsonObject);
    Tool tool =
        Tool.newBuilder()
            .addFunctionDeclarations(FunctionDeclarationMaker.fromJsonObject(jsonObject))
            .build();
    ImmutableList<Tool> tools = ImmutableList.of(tool);

    Content functionResponse =
        ContentMaker.fromMultiModalData(
            PartMaker.fromFunctionResponse(
                "getCurrentWeather", Collections.singletonMap("currentWeather", "snowing")));

    // Act
    chat = model.startChat();
    GenerateContentResponse firstResponse = chat.sendMessage(firstMessage);
    GenerateContentResponse secondResponse = chat.withTools(tools).sendMessage(secondMessage);
    GenerateContentResponse thirdResponse = chat.sendMessage(functionResponse);
    ImmutableList<Content> history = chat.getHistory();

    // Assert
    assertThat(firstResponse.getCandidatesList()).hasSize(1);
    assertThat(secondResponse.getCandidatesList()).hasSize(1);
    assertThat(ResponseHandler.getFunctionCalls(secondResponse).size()).isEqualTo(1);
    assertThat(thirdResponse.getCandidatesList()).hasSize(1);
    assertSizeAndAlternatingRolesInHistory(
        Thread.currentThread().getStackTrace()[1].getMethodName(),
        history,
        6,
        ImmutableList.of(
            ContentMaker.fromString(firstMessage),
            ContentMaker.fromString(secondMessage),
            functionResponse));
  }
}
