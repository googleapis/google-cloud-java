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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.Transport;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensRequest;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.FunctionDeclaration;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.LlmUtilityServiceClient;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Tool;
import com.google.cloud.vertexai.api.Type;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
public final class GenerativeModelTest {
  private static final String PROJECT = "test_project";
  private static final String LOCATION = "test_location";
  private static final String MODEL_NAME = "gemini-pro";
  private static final String MODEL_NAME_2 = "models/gemini-pro";
  private static final String MODEL_NAME_3 = "publishers/google/models/gemini-pro";
  private static final GenerationConfig GENERATION_CONFIG =
      GenerationConfig.newBuilder().setCandidateCount(1).build();
  private static final GenerationConfig DEFAULT_GENERATION_CONFIG =
      GenerationConfig.newBuilder().setCandidateCount(2).build();
  private static final SafetySetting SAFETY_SETTING =
      SafetySetting.newBuilder()
          .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
          .setThreshold(HarmBlockThreshold.BLOCK_LOW_AND_ABOVE)
          .build();
  private static final SafetySetting DEFAULT_SAFETY_SETTING =
      SafetySetting.newBuilder()
          .setCategory(HarmCategory.HARM_CATEGORY_HATE_SPEECH)
          .setThreshold(HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE)
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

  private static final String TEXT = "What is your name?";

  private VertexAI vertexAi;
  private GenerativeModel model;
  private List<SafetySetting> safetySettings = Arrays.asList(SAFETY_SETTING);
  private List<SafetySetting> defaultSafetySettings = Arrays.asList(DEFAULT_SAFETY_SETTING);
  private List<Tool> tools = Arrays.asList(TOOL);

  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private GoogleCredentials mockGoogleCredentials;

  @Mock private PredictionServiceClient mockPredictionServiceClient;
  @Mock private LlmUtilityServiceClient mockLlmUtilityServiceClient;

  @Mock
  private ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      mockServerStreamCallable;

  @Mock private UnaryCallable<GenerateContentRequest, GenerateContentResponse> mockUnaryCallable;

  @Mock private GenerateContentResponse mockGenerateContentResponse;
  @Mock private ServerStream<GenerateContentResponse> mockServerStream;
  @Mock private Iterator<GenerateContentResponse> mockServerStreamIterator;

  @Before
  public void doBeforeEachTest() {
    vertexAi = new VertexAI(PROJECT, LOCATION, mockGoogleCredentials);
  }

  @Test
  public void testInstantiateGenerativeModel() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.empty());
    assertThat(model.getSafetySettings()).isEqualTo(Optional.empty());
    assertThat(model.getTools()).isEqualTo(Optional.empty());
  }

  @Test
  public void testInstantiateGenerativeModelWithGenerationConfig() {
    model = new GenerativeModel(MODEL_NAME_2, GENERATION_CONFIG, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.of(GENERATION_CONFIG));
    assertThat(model.getSafetySettings()).isEqualTo(Optional.empty());
    assertThat(model.getTools()).isEqualTo(Optional.empty());
  }

  @Test
  public void testInstantiateGenerativeModelwithSafetySettings() {
    model = new GenerativeModel(MODEL_NAME, safetySettings, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.empty());
    assertThat(model.getSafetySettings()).isEqualTo(Optional.of(safetySettings));
    assertThat(model.getTools()).isEqualTo(Optional.empty());
  }

  @Test
  public void testInstantiateGenerativeModelwithGenerationConfigAndSafetySettings() {
    model = new GenerativeModel(MODEL_NAME_3, GENERATION_CONFIG, safetySettings, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.of(GENERATION_CONFIG));
    assertThat(model.getSafetySettings()).isEqualTo(Optional.of(safetySettings));
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilder() {
    model = GenerativeModel.newBuilder().setModelName(MODEL_NAME).setVertexAi(vertexAi).build();
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.empty());
    assertThat(model.getSafetySettings()).isEqualTo(Optional.empty());
    assertThat(model.getTools()).isEqualTo(Optional.empty());
    assertThat(model.getTransport()).isEqualTo(Transport.GRPC);
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderAllConfigs() {
    model =
        GenerativeModel.newBuilder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setGenerationConfig(GENERATION_CONFIG)
            .setSafetySettings(safetySettings)
            .setTools(tools)
            .setTransport(Transport.REST)
            .build();
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.of(GENERATION_CONFIG));
    assertThat(model.getSafetySettings()).isEqualTo(Optional.of(safetySettings));
    assertThat(model.getTools()).isEqualTo(Optional.of(tools));
    assertThat(model.getTransport()).isEqualTo(Transport.REST);
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderMissingModelName() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> GenerativeModel.newBuilder().build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("modelName is required. Please call setModelName() before building.");
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderMissingVertexAi() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> GenerativeModel.newBuilder().setModelName(MODEL_NAME).build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("vertexAi is required. Please call setVertexAi() before building.");
  }

  @Test
  public void testSetGenerationConfig() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    model.setGenerationConfig(GENERATION_CONFIG);
    assertThat(model.getGenerationConfig()).isEqualTo(Optional.of(GENERATION_CONFIG));
  }

  @Test
  public void testSetSafetySettings() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    model.setSafetySettings(safetySettings);
    assertThat(model.getSafetySettings()).isEqualTo(Optional.of(safetySettings));
  }

  @Test
  public void testSetTools() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    model.setTools(tools);
    assertThat(model.getTools()).isEqualTo(Optional.of(tools));
  }

  @Test
  public void testCountTokenswithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("llmUtilityClient");
    field.setAccessible(true);
    field.set(vertexAi, mockLlmUtilityServiceClient);

    CountTokensResponse unused = model.countTokens(TEXT);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void testCountTokenswithContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("llmUtilityClient");
    field.setAccessible(true);
    field.set(vertexAi, mockLlmUtilityServiceClient);

    Content content = ContentMaker.fromString(TEXT);
    CountTokensResponse unused = model.countTokens(content);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(content);
  }

  @Test
  public void testCountTokenswithContents() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("llmUtilityClient");
    field.setAccessible(true);
    field.set(vertexAi, mockLlmUtilityServiceClient);

    Content content = ContentMaker.fromString(TEXT);
    CountTokensResponse unused = model.countTokens(Arrays.asList(content));

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(content);
  }

  @Test
  public void testGenerateContentwithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void testGenerateContentwithContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    GenerateContentResponse unused = model.generateContent(content);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void testGenerateContentwithContents() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    GenerateContentResponse unused = model.generateContent(Arrays.asList(content));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void testGenerateContentwithGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT, GENERATION_CONFIG);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
  }

  @Test
  public void testGenerateContentwithDefaultGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, DEFAULT_GENERATION_CONFIG, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(DEFAULT_GENERATION_CONFIG);
  }

  @Test
  public void testGenerateContentwithSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT, safetySettings);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
  }

  @Test
  public void testGenerateContentwithDefaultSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, defaultSafetySettings, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(DEFAULT_SAFETY_SETTING);
  }

  @Test
  public void testGenerateContentwithDefaultTools() throws Exception {
    model =
        GenerativeModel.newBuilder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void testGenerateContentwithGenerateContentConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    GenerateContentConfig config =
        GenerateContentConfig.newBuilder()
            .setGenerationConfig(GENERATION_CONFIG)
            .setSafetySettings(safetySettings)
            .setTools(tools)
            .build();

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused = model.generateContent(TEXT, config);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());

    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void testGenerateContentStreamwithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream<GenerateContentResponse> unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText())
        .isEqualTo("What is your name?");
  }

  @Test
  public void testGenerateContentStreamwithContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    ResponseStream<GenerateContentResponse> unused = model.generateContentStream(content);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText())
        .isEqualTo("What is your name?");
  }

  @Test
  public void testGenerateContentStreamwithContents() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    ResponseStream unused = model.generateContentStream(Arrays.asList(content));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText())
        .isEqualTo("What is your name?");
  }

  @Test
  public void testGenerateContentStreamwithGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT, GENERATION_CONFIG);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
  }

  @Test
  public void testGenerateContentStreamwithDefaultGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, DEFAULT_GENERATION_CONFIG, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(DEFAULT_GENERATION_CONFIG);
  }

  @Test
  public void testGenerateContentStreamwithSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT, safetySettings);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
  }

  @Test
  public void testGenerateContentStreamwithDefaultSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, defaultSafetySettings, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(DEFAULT_SAFETY_SETTING);
  }

  @Test
  public void testGenerateContentStreamwithDefaultTools() throws Exception {
    model =
        GenerativeModel.newBuilder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void testGenerateContentStreamwithGenerateContentConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    GenerateContentConfig config =
        GenerateContentConfig.newBuilder()
            .setGenerationConfig(GENERATION_CONFIG)
            .setSafetySettings(safetySettings)
            .setTools(tools)
            .build();

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused = model.generateContentStream(TEXT, config);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());

    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }
}
