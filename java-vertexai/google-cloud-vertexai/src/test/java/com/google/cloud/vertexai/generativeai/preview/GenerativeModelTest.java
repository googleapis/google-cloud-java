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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensRequest;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import java.lang.reflect.Field;
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
  private static final String INVALID_MODEL_NAME = "invalid name";
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

  private static final String TEXT = "What is your name?";

  private VertexAI vertexAi;
  private GenerativeModel model;
  private List<SafetySetting> safetySettings = Arrays.asList(SAFETY_SETTING);
  private List<SafetySetting> defaultSafetySettings = Arrays.asList(DEFAULT_SAFETY_SETTING);

  @Rule public final MockitoRule mocksRule = MockitoJUnit.rule();

  @Mock private GoogleCredentials mockGoogleCredentials;

  @Mock private PredictionServiceClient mockPredictionServiceClient;

  @Mock
  private ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      mockServerStreamCallable;

  @Mock private UnaryCallable<GenerateContentRequest, GenerateContentResponse> mockUnaryCallable;

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
    assertThat(model.getGenerationConfig()).isNull();
    assertThat(model.getSafetySettings()).isNull();
  }

  @Test
  public void testInstantiateGenerativeModelWithGenerationConfig() {
    model = new GenerativeModel(MODEL_NAME, GENERATION_CONFIG, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(model.getSafetySettings()).isNull();
  }

  @Test
  public void testInstantiateGenerativeModelwithSafetySettings() {
    model = new GenerativeModel(MODEL_NAME, safetySettings, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isNull();
    assertThat(model.getSafetySettings()).isEqualTo(safetySettings);
  }

  @Test
  public void testInstantiateGenerativeModelwithGenerationConfigAndSafetySettings() {
    model = new GenerativeModel(MODEL_NAME, GENERATION_CONFIG, safetySettings, vertexAi);
    assertThat(model.getModelName()).isEqualTo(MODEL_NAME);
    assertThat(model.getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
    assertThat(model.getSafetySettings()).isEqualTo(safetySettings);
  }

  @Test
  public void testInstantiateGenerativeModelWithInvalidName() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> new GenerativeModel(INVALID_MODEL_NAME, vertexAi));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "Invalid model name: %s. Please choose from: %s",
                INVALID_MODEL_NAME, Constants.GENERATIVE_MODEL_NAMES));
  }

  @Test
  public void testSetGenerationConfig() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    model.setGenerationConfig(GENERATION_CONFIG);
    assertThat(model.getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
  }

  @Test
  public void testSetSafetySettings() {
    model = new GenerativeModel(MODEL_NAME, vertexAi);
    model.setSafetySettings(safetySettings);
    assertThat(model.getSafetySettings()).isEqualTo(safetySettings);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testCountTokenswithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    CountTokensResponse unused = model.countTokens(TEXT);

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockPredictionServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testCountTokenswithContents() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    Content content = ContentMaker.fromString(TEXT);
    CountTokensResponse unused = model.countTokens(Arrays.asList(content));

    ArgumentCaptor<CountTokensRequest> request = ArgumentCaptor.forClass(CountTokensRequest.class);
    verify(mockPredictionServiceClient).countTokens(request.capture());
    assertThat(request.getValue().getContents(0)).isEqualTo(content);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithText() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithContent() throws Exception {
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
    GenerateContentResponse unused = model.generateContent(content);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }


  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithContents() throws Exception {
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
    GenerateContentResponse unused = model.generateContent(Arrays.asList(content));

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    GenerateContentResponse unused = model.generateContent(TEXT, GENERATION_CONFIG);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(GENERATION_CONFIG);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithDefaultGenerationConfig() throws Exception {
    model = new GenerativeModel(MODEL_NAME, DEFAULT_GENERATION_CONFIG, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getGenerationConfig()).isEqualTo(DEFAULT_GENERATION_CONFIG);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    GenerateContentResponse unused = model.generateContent(TEXT, safetySettings);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(SAFETY_SETTING);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
  @Test
  public void testGenerateContentwithDefaultSafetySettings() throws Exception {
    model = new GenerativeModel(MODEL_NAME, defaultSafetySettings, vertexAi);

    Field field = VertexAI.class.getDeclaredField("predictionServiceClient");
    field.setAccessible(true);
    field.set(vertexAi, mockPredictionServiceClient);

    when(mockPredictionServiceClient.streamGenerateContentCallable())
        .thenReturn(mockServerStreamCallable);
    when(mockServerStreamCallable.call(any(GenerateContentRequest.class)))
        .thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(mockServerStreamIterator);

    GenerateContentResponse unused = model.generateContent(TEXT);

    ArgumentCaptor<GenerateContentRequest> request =
        ArgumentCaptor.forClass(GenerateContentRequest.class);
    verify(mockServerStreamCallable).call(request.capture());
    assertThat(request.getValue().getContents(0).getParts(0).getText()).isEqualTo(TEXT);
    assertThat(request.getValue().getSafetySettings(0)).isEqualTo(DEFAULT_SAFETY_SETTING);
  }

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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

  @Ignore("need to make the test compatible with Mockito 4.x")
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
}
