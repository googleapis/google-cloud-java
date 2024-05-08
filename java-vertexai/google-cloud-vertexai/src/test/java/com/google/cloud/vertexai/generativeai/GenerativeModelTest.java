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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensRequest;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.FunctionDeclaration;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.GoogleSearchRetrieval;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.LlmUtilityServiceClient;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.Retrieval;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Tool;
import com.google.cloud.vertexai.api.Type;
import com.google.cloud.vertexai.api.VertexAISearch;
import java.util.ArrayList;
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
public final class GenerativeModelTest {
  private static final String PROJECT = "test_project";
  private static final String LOCATION = "test_location";
  private static final String MODEL_NAME = "gemini-pro";
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
  private static final Tool GOOGLE_SEARCH_TOOL =
      Tool.newBuilder()
          .setGoogleSearchRetrieval(GoogleSearchRetrieval.newBuilder().setDisableAttribution(false))
          .build();
  private static final Tool VERTEX_AI_SEARCH_TOOL =
      Tool.newBuilder()
          .setRetrieval(
              Retrieval.newBuilder()
                  .setVertexAiSearch(
                      VertexAISearch.newBuilder()
                          .setDatastore(
                              String.format(
                                  "projects/%s/locations/%s/collections/%s/dataStores/%s",
                                  PROJECT, "global", "default_collection", "test_123")))
                  .setDisableAttribution(false))
          .build();

  private static final String TEXT = "What is your name?";

  private VertexAI vertexAi;
  private GenerativeModel model;
  private List<SafetySetting> safetySettings = Arrays.asList(SAFETY_SETTING);
  private List<SafetySetting> defaultSafetySettings = Arrays.asList(DEFAULT_SAFETY_SETTING);
  private List<Tool> tools = Arrays.asList(TOOL, GOOGLE_SEARCH_TOOL, VERTEX_AI_SEARCH_TOOL);

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
  @Mock private ApiFuture<GenerateContentResponse> mockApiFuture;

  @Before
  public void setUp() {
    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.futureCall(any(GenerateContentRequest.class))).thenReturn(mockApiFuture);

    vertexAi =
        new VertexAI.Builder()
            .setProjectId(PROJECT)
            .setLocation(LOCATION)
            .setCredentials(mockGoogleCredentials)
            .setLlmClientSupplier(() -> mockLlmUtilityServiceClient)
            .setPredictionClientSupplier(() -> mockPredictionServiceClient)
            .build();
  }

  @Test
  public void testInstantiateGenerativeModel() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GenerationConfig.getDefaultInstance());
    assertThat(model.getSafetySettings()).isEmpty();
    assertThat(model.getTools()).isEmpty();
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilder() {
    model = new GenerativeModel.Builder().setModelName(MODEL_NAME).setVertexAi(vertexAi).build();
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GenerationConfig.getDefaultInstance());
    assertThat(model.getSafetySettings()).isEmpty();
    assertThat(model.getTools()).isEmpty();
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderAllConfigs() {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setGenerationConfig(GENERATION_CONFIG)
            .setSafetySettings(safetySettings)
            .setTools(tools)
            .build();
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(model.getSafetySettings()).isEqualTo(safetySettings);
    assertThat(model.getTools()).isEqualTo(tools);
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderMissingModelName() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> new GenerativeModel.Builder().build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("modelName is required. Please call setModelName() before building.");
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderEmptyModelName() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> new GenerativeModel.Builder().setModelName("").build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "modelName can't be null or empty. Please refer to"
                + " https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models"
                + " to find the right model name.");
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderNullModelName() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> new GenerativeModel.Builder().setModelName(null).build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "modelName can't be null or empty. Please refer to"
                + " https://cloud.google.com/vertex-ai/docs/generative-ai/learn/models#gemini-models"
                + " to find the right model name.");
  }

  @Test
  public void testInstantiateGenerativeModelwithBuilderMissingVertexAi() {
    NullPointerException thrown =
        assertThrows(
            NullPointerException.class,
            () -> new GenerativeModel.Builder().setModelName(MODEL_NAME).build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("vertexAi is required. Please call setVertexAi() before building.");
  }

  @Test
  public void testCountTokenswithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    CountTokensResponse unused = model.countTokens(TEXT);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void testCountTokenswithContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Content content = ContentMaker.fromString(TEXT);
    CountTokensResponse unused = model.countTokens(content);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(content);
  }

  @Test
  public void testCountTokenswithContents() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Content content = ContentMaker.fromString(TEXT);
    CountTokensResponse unused = model.countTokens(Arrays.asList(content));

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(content);
  }

  @Test
  public void testGenerateContentwithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

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
  public void testGenerateContentwithSystemInstruction() throws Exception {
    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    String systemInstructionText =
        "You're a helpful assistant that starts all its answers with: \"COOL\"";
    Content systemInstruction = ContentMaker.fromString(systemInstructionText);

    model = new GenerativeModel(MODEL_NAME, vertexAi).withSystemInstruction(systemInstruction);

    Content content = ContentMaker.fromString(TEXT);
    GenerateContentResponse unused = model.generateContent(Arrays.asList(content));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getSystemInstruction().getParts(0).getText())
        .isEqualTo(systemInstructionText);
  }

  @Test
  public void testGenerateContentwithDefaultGenerationConfig() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setVertexAi(vertexAi)
            .setModelName(MODEL_NAME)
            .setGenerationConfig(DEFAULT_GENERATION_CONFIG)
            .build();

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
  public void testGenerateContentwithDefaultSafetySettings() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setSafetySettings(defaultSafetySettings)
            .setVertexAi(vertexAi)
            .build();

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
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

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
  public void testGenerateContentwithFluentApi() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);

    GenerateContentResponse unused =
        model
            .withGenerationConfig(GENERATION_CONFIG)
            .withSafetySettings(safetySettings)
            .withTools(tools)
            .generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void generateContent_withNullContents_throws() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    List<Content> contents = null;

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> model.generateContent(contents));
    assertThat(thrown).hasMessageThat().isEqualTo("contents can't be null or empty.");
  }

  @Test
  public void testGenerateContentStreamwithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

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
  public void testGenerateContentStreamwithDefaultGenerationConfig() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setGenerationConfig(DEFAULT_GENERATION_CONFIG)
            .setVertexAi(vertexAi)
            .build();

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
  public void testGenerateContentStreamwithDefaultSafetySettings() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setSafetySettings(defaultSafetySettings)
            .setVertexAi(vertexAi)
            .build();

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
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

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
  public void testGenerateContentStreamwithFluentApi() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    ResponseStream unused =
        model
            .withGenerationConfig(GENERATION_CONFIG)
            .withSafetySettings(safetySettings)
            .withTools(tools)
            .generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void generateContentStream_withEmptyContents_throws() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    List<Content> contents = new ArrayList<>();

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> model.generateContentStream(contents));
    assertThat(thrown).hasMessageThat().isEqualTo("contents can't be null or empty.");
  }

  @Test
  public void generateContentAsync_withText_sendsCorrectRequest() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.futureCall(any(GenerateContentRequest.class))).thenReturn(mockApiFuture);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void generateContentAsync_withContent_sendsCorrectRequest() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.futureCall(any(GenerateContentRequest.class))).thenReturn(mockApiFuture);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(content);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void generateContentAsync_withContents_sendsCorrectRequest() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.futureCall(any(GenerateContentRequest.class))).thenReturn(mockApiFuture);

    Content content =
        Content.newBuilder().setRole("user").addParts(Part.newBuilder().setText(TEXT)).build();
    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(Arrays.asList(content));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }
}
