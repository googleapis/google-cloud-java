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
  private static final Content DEFAULT_SYSTEM_INSTRUCTION =
      ContentMaker.fromString(
          "You're a helpful assistant that starts all its answers with: \"COOL\"");
  private static final Tool GOOGLE_SEARCH_TOOL =
      Tool.newBuilder().setGoogleSearchRetrieval(GoogleSearchRetrieval.newBuilder()).build();
  private static final Tool VERTEX_AI_SEARCH_TOOL =
      Tool.newBuilder()
          .setRetrieval(
              Retrieval.newBuilder()
                  .setVertexAiSearch(
                      VertexAISearch.newBuilder()
                          .setDatastore(
                              "projects/test_project/locations/global/collections/default_collection/dataStores/test_123"))
                  .setDisableAttribution(false))
          .build();

  private static final String TEXT = "What is your name?";
  private static final Content CONTENT = ContentMaker.fromString(TEXT);

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
    // Mock Unary generateContent
    when(mockPredictionServiceClient.generateContentCallable()).thenReturn(mockUnaryCallable);
    when(mockUnaryCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockGenerateContentResponse);
    // Mock stream generateContent
    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);
    // Mock async generateContent
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
  public void instantiate_hasCorrectFields() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GenerationConfig.getDefaultInstance());
    assertThat(model.getSafetySettings()).isEmpty();
    assertThat(model.getTools()).isEmpty();
  }

  @Test
  public void instantiate_withModelNameStartingFromProjects_hasCorrectFields() {
    model =
        new GenerativeModel(
            "projects/test_project/locations/test_location/publishers/google/models/gemini-pro",
            vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GenerationConfig.getDefaultInstance());
    assertThat(model.getSafetySettings()).isEmpty();
    assertThat(model.getTools()).isEmpty();
  }

  @Test
  public void instantiateWithBuilder_hasCorrectFields() {
    model = new GenerativeModel.Builder().setModelName(MODEL_NAME).setVertexAi(vertexAi).build();
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GenerationConfig.getDefaultInstance());
    assertThat(model.getSafetySettings()).isEmpty();
    assertThat(model.getTools()).isEmpty();
  }

  @Test
  public void instantiateWithBuilder_withAllConfigs_hasCorrectFields() {
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
  public void instantiateWithBuilder_missingModelName_throwsIllegalArgumentException() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> new GenerativeModel.Builder().build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("modelName is required. Please call setModelName() before building.");
  }

  @Test
  public void instantiateWithBuilder_emptyModelName_throwsIllegalArgumentException() {
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
  public void instantiateWithBuilder_nullModelName_throwsIllegalArgumentException() {
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
  public void instantiateWithBuilder_missingVertexAi_throwsNullPointerException() {
    NullPointerException thrown =
        assertThrows(
            NullPointerException.class,
            () -> new GenerativeModel.Builder().setModelName(MODEL_NAME).build());
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("vertexAi is required. Please call setVertexAi() before building.");
  }

  @Test
  public void countTokens_withText_requestHasCorrectText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    CountTokensResponse unused = model.countTokens(TEXT);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void countTokens_withContent_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    CountTokensResponse unused = model.countTokens(CONTENT);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void countTokens_withContents_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    CountTokensResponse unused = model.countTokens(Arrays.asList(CONTENT));

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockLlmUtilityServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContent_withText_requestHasCorrectFields() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getModel())
        .isEqualTo(
            "projects/test_project/locations/test_location/publishers/google/models/gemini-pro");
  }

  @Test
  public void generateContent_withFullModelName_requestHasCorrectResourceName() throws Exception {
    model =
        new GenerativeModel(
            "projects/another_project/locations/europe-west4/publishers/google/models/another_model",
            vertexAi);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getModel())
        .isEqualTo(
            "projects/another_project/locations/europe-west4/publishers/google/models/another_model");
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void generateContent_withContent_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    GenerateContentResponse unused = model.generateContent(CONTENT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContent_withContents_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    GenerateContentResponse unused = model.generateContent(Arrays.asList(CONTENT));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContent_withDefaultGenerationConfig_requestHasCorrectGenerationConfigAndText()
      throws Exception {
    model =
        new GenerativeModel.Builder()
            .setVertexAi(vertexAi)
            .setModelName(MODEL_NAME)
            .setGenerationConfig(DEFAULT_GENERATION_CONFIG)
            .build();

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(DEFAULT_GENERATION_CONFIG);
  }

  @Test
  public void generateContent_withDefaultSafetySettings_requestHasCorrectSafetySettingsAndText()
      throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setSafetySettings(defaultSafetySettings)
            .setVertexAi(vertexAi)
            .build();

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(DEFAULT_SAFETY_SETTING);
  }

  @Test
  public void generateContent_withDefaultTools_requestHasCorrectToolsAndText() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void
      generateContent_withDefaultSystemInstruction_requestHasCorrectSystemInstructionAndText()
          throws Exception {
    model =
        new GenerativeModel.Builder()
            .setVertexAi(vertexAi)
            .setModelName(MODEL_NAME)
            .setSystemInstruction(DEFAULT_SYSTEM_INSTRUCTION)
            .build();
    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    Content expectedSystemInstruction = DEFAULT_SYSTEM_INSTRUCTION.toBuilder().clearRole().build();
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSystemInstruction()).isEqualTo(expectedSystemInstruction);
  }

  @Test
  public void generateContent_withAllConfigsInFluentApi_requestHasCorrectFields() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    GenerateContentResponse unused =
        model
            .withGenerationConfig(GENERATION_CONFIG)
            .withSafetySettings(safetySettings)
            .withTools(tools)
            .withSystemInstruction(DEFAULT_SYSTEM_INSTRUCTION)
            .generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).call(request.capture());
    Content expectedSystemInstruction = DEFAULT_SYSTEM_INSTRUCTION.toBuilder().clearRole().build();
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
    assertThat(request.getValue().getSystemInstruction()).isEqualTo(expectedSystemInstruction);
  }

  @Test
  public void generateContent_withNullContents_throwsIllegalArgumentException() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    List<Content> contents = null;

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> model.generateContent(contents));
    assertThat(thrown).hasMessageThat().isEqualTo("contents can't be null or empty.");
  }

  @Test
  public void generateContentStream_withText_requestHasCorrectText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ResponseStream<GenerateContentResponse> unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void generateContentStream_withContent_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ResponseStream<GenerateContentResponse> unused = model.generateContentStream(CONTENT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContentStream_withContents_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ResponseStream unused = model.generateContentStream(Arrays.asList(CONTENT));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContentStream_withDefaultGenerationConfig_requestHasCorrectGenerationConfig()
      throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setGenerationConfig(DEFAULT_GENERATION_CONFIG)
            .setVertexAi(vertexAi)
            .build();

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(DEFAULT_GENERATION_CONFIG);
  }

  @Test
  public void generateContentStream_withDefaultSafetySettings_requestHasCorrectSafetySettings()
      throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setSafetySettings(defaultSafetySettings)
            .setVertexAi(vertexAi)
            .build();

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(DEFAULT_SAFETY_SETTING);
  }

  @Test
  public void generateContentStream_withDefaultTools_requestHasCorrectTools() throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setTools(tools)
            .build();

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
  }

  @Test
  public void
      generateContentStream_withDefaultSystemInstruction_requestHasCorrectSystemInstruction()
          throws Exception {
    model =
        new GenerativeModel.Builder()
            .setModelName(MODEL_NAME)
            .setVertexAi(vertexAi)
            .setSystemInstruction(DEFAULT_SYSTEM_INSTRUCTION)
            .build();

    ResponseStream unused = model.generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    Content expectedSystemInstruction = DEFAULT_SYSTEM_INSTRUCTION.toBuilder().clearRole().build();
    assertThat(request.getValue().getSystemInstruction()).isEqualTo(expectedSystemInstruction);
  }

  @Test
  public void generateContentStream_withAllConfigsInFluentApi_requestHasCorrectFields()
      throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ResponseStream unused =
        model
            .withGenerationConfig(GENERATION_CONFIG)
            .withSafetySettings(safetySettings)
            .withTools(tools)
            .withSystemInstruction(DEFAULT_SYSTEM_INSTRUCTION)
            .generateContentStream(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    Content expectedSystemInstruction = DEFAULT_SYSTEM_INSTRUCTION.toBuilder().clearRole().build();
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
    assertThat(request.getValue().getTools(0)).isEqualTo(TOOL);
    assertThat(request.getValue().getSystemInstruction()).isEqualTo(expectedSystemInstruction);
  }

  @Test
  public void generateContentStream_withEmptyContents_throwsIllegalArgumentException()
      throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    List<Content> contents = new ArrayList<>();

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> model.generateContentStream(contents));
    assertThat(thrown).hasMessageThat().isEqualTo("contents can't be null or empty.");
  }

  @Test
  public void generateContentAsync_withText_requestHasCorrectText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Test
  public void generateContentAsync_withContent_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(CONTENT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }

  @Test
  public void generateContentAsync_withContents_requestHasCorrectContent() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    ApiFuture<GenerateContentResponse> unused = model.generateContentAsync(Arrays.asList(CONTENT));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockUnaryCallable).futureCall(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(CONTENT);
  }
}
