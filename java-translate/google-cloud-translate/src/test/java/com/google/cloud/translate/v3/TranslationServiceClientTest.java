/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.translate.v3;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TranslationServiceClientTest {
  private static MockTranslationService mockTranslationService;
  private static MockServiceHelper serviceHelper;
  private TranslationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTranslationService = new MockTranslationService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTranslationService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    TranslationServiceSettings settings =
        TranslationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TranslationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGlossaryTest() throws Exception {
    String name2 = "name2-1052831874";
    DeleteGlossaryResponse expectedResponse =
        DeleteGlossaryResponse.newBuilder().setName(name2).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    DeleteGlossaryResponse actualResponse = client.deleteGlossaryAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryRequest actualRequest = (DeleteGlossaryRequest) actualRequests.get(0);

    Assert.assertEquals(name, GlossaryName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void translateTextTest() {
    TranslateTextResponse expectedResponse = TranslateTextResponse.newBuilder().build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String targetLanguageCode = "targetLanguageCode1323228230";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(parent, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TranslateTextRequest actualRequest = (TranslateTextRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(targetLanguageCode, actualRequest.getTargetLanguageCode());
    Assert.assertEquals(contents, actualRequest.getContentsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void translateTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String targetLanguageCode = "targetLanguageCode1323228230";
      List<String> contents = new ArrayList<>();

      client.translateText(parent, targetLanguageCode, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void translateTextTest2() {
    TranslateTextResponse expectedResponse = TranslateTextResponse.newBuilder().build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String mimeType = "mimeType-196041627";
    String sourceLanguageCode = "sourceLanguageCode1687263568";
    String targetLanguageCode = "targetLanguageCode1323228230";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(
            parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TranslateTextRequest actualRequest = (TranslateTextRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(mimeType, actualRequest.getMimeType());
    Assert.assertEquals(sourceLanguageCode, actualRequest.getSourceLanguageCode());
    Assert.assertEquals(targetLanguageCode, actualRequest.getTargetLanguageCode());
    Assert.assertEquals(contents, actualRequest.getContentsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void translateTextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-196041627";
      String sourceLanguageCode = "sourceLanguageCode1687263568";
      String targetLanguageCode = "targetLanguageCode1323228230";
      List<String> contents = new ArrayList<>();

      client.translateText(
          parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void detectLanguageTest() {
    DetectLanguageResponse expectedResponse = DetectLanguageResponse.newBuilder().build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String mimeType = "mimeType-196041627";
    String content = "content951530617";

    DetectLanguageResponse actualResponse = client.detectLanguage(parent, model, mimeType, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectLanguageRequest actualRequest = (DetectLanguageRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(mimeType, actualRequest.getMimeType());
    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void detectLanguageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-196041627";
      String content = "content951530617";

      client.detectLanguage(parent, model, mimeType, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSupportedLanguagesTest() {
    SupportedLanguages expectedResponse = SupportedLanguages.newBuilder().build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String displayLanguageCode = "displayLanguageCode30710199";

    SupportedLanguages actualResponse =
        client.getSupportedLanguages(parent, model, displayLanguageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSupportedLanguagesRequest actualRequest =
        (GetSupportedLanguagesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(displayLanguageCode, actualRequest.getDisplayLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSupportedLanguagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String displayLanguageCode = "displayLanguageCode30710199";

      client.getSupportedLanguages(parent, model, displayLanguageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchTranslateTextTest() throws Exception {
    long totalCharacters = 1368640955L;
    long translatedCharacters = 1337326221L;
    long failedCharacters = 1723028396L;
    BatchTranslateResponse expectedResponse =
        BatchTranslateResponse.newBuilder()
            .setTotalCharacters(totalCharacters)
            .setTranslatedCharacters(translatedCharacters)
            .setFailedCharacters(failedCharacters)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchTranslateTextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String sourceLanguageCode = "sourceLanguageCode1687263568";
    List<String> targetLanguageCodes = new ArrayList<>();
    List<InputConfig> inputConfigs = new ArrayList<>();
    OutputConfig outputConfig = OutputConfig.newBuilder().build();
    BatchTranslateTextRequest request =
        BatchTranslateTextRequest.newBuilder()
            .setParent(parent.toString())
            .setSourceLanguageCode(sourceLanguageCode)
            .addAllTargetLanguageCodes(targetLanguageCodes)
            .addAllInputConfigs(inputConfigs)
            .setOutputConfig(outputConfig)
            .build();

    BatchTranslateResponse actualResponse = client.batchTranslateTextAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchTranslateTextRequest actualRequest = (BatchTranslateTextRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(sourceLanguageCode, actualRequest.getSourceLanguageCode());
    Assert.assertEquals(targetLanguageCodes, actualRequest.getTargetLanguageCodesList());
    Assert.assertEquals(inputConfigs, actualRequest.getInputConfigsList());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchTranslateTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String sourceLanguageCode = "sourceLanguageCode1687263568";
      List<String> targetLanguageCodes = new ArrayList<>();
      List<InputConfig> inputConfigs = new ArrayList<>();
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      BatchTranslateTextRequest request =
          BatchTranslateTextRequest.newBuilder()
              .setParent(parent.toString())
              .setSourceLanguageCode(sourceLanguageCode)
              .addAllTargetLanguageCodes(targetLanguageCodes)
              .addAllInputConfigs(inputConfigs)
              .setOutputConfig(outputConfig)
              .build();

      client.batchTranslateTextAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGlossaryTest() throws Exception {
    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
    int entryCount = 811131134;
    Glossary expectedResponse =
        Glossary.newBuilder().setName(name.toString()).setEntryCount(entryCount).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Glossary glossary = Glossary.newBuilder().build();

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryRequest actualRequest = (CreateGlossaryRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Glossary glossary = Glossary.newBuilder().build();

      client.createGlossaryAsync(parent, glossary).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGlossariesTest() {
    String nextPageToken = "";
    Glossary glossariesElement = Glossary.newBuilder().build();
    List<Glossary> glossaries = Arrays.asList(glossariesElement);
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllGlossaries(glossaries)
            .build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = (ListGlossariesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listGlossariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listGlossaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGlossaryTest() {
    GlossaryName name2 = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
    int entryCount = 811131134;
    Glossary expectedResponse =
        Glossary.newBuilder().setName(name2.toString()).setEntryCount(entryCount).build();
    mockTranslationService.addResponse(expectedResponse);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryRequest actualRequest = (GetGlossaryRequest) actualRequests.get(0);

    Assert.assertEquals(name, GlossaryName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

      client.getGlossary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
