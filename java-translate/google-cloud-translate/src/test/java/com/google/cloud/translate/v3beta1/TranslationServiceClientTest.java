/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.translate.v3beta1;

import static com.google.cloud.translate.v3beta1.TranslationServiceClient.ListGlossariesPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TranslationServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private TranslationServiceClient client;
  private LocalChannelProvider channelProvider;
  private static MockTranslationService mockTranslationService;

  @BeforeClass
  public static void startStaticServer() {
    mockTranslationService = new MockTranslationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTranslationService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void translateTextTest() throws Exception {
    TranslateTextResponse expectedResponse =
        TranslateTextResponse.newBuilder()
            .addAllTranslations(new ArrayList<Translation>())
            .addAllGlossaryTranslations(new ArrayList<Translation>())
            .build();
    mockTranslationService.addResponse(expectedResponse);

    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .addAllContents(new ArrayList<String>())
            .setMimeType("mimeType-1392120434")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setModel("model104069929")
            .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();

    TranslateTextResponse actualResponse = client.translateText(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TranslateTextRequest actualRequest = ((TranslateTextRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContentsList(), actualRequest.getContentsList());
    Assert.assertEquals(request.getMimeType(), actualRequest.getMimeType());
    Assert.assertEquals(request.getSourceLanguageCode(), actualRequest.getSourceLanguageCode());
    Assert.assertEquals(request.getTargetLanguageCode(), actualRequest.getTargetLanguageCode());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getGlossaryConfig(), actualRequest.getGlossaryConfig());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void translateTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      TranslateTextRequest request =
          TranslateTextRequest.newBuilder()
              .addAllContents(new ArrayList<String>())
              .setMimeType("mimeType-1392120434")
              .setSourceLanguageCode("sourceLanguageCode1645917472")
              .setTargetLanguageCode("targetLanguageCode-106414698")
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setModel("model104069929")
              .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.translateText(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void detectLanguageTest() throws Exception {
    DetectLanguageResponse expectedResponse =
        DetectLanguageResponse.newBuilder()
            .addAllLanguages(new ArrayList<DetectedLanguage>())
            .build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";

    DetectLanguageResponse actualResponse = client.detectLanguage(parent, model, mimeType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectLanguageRequest actualRequest = ((DetectLanguageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(mimeType, actualRequest.getMimeType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detectLanguageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      client.detectLanguage(parent, model, mimeType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void detectLanguageTest2() throws Exception {
    DetectLanguageResponse expectedResponse =
        DetectLanguageResponse.newBuilder()
            .addAllLanguages(new ArrayList<DetectedLanguage>())
            .build();
    mockTranslationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";

    DetectLanguageResponse actualResponse = client.detectLanguage(parent, model, mimeType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectLanguageRequest actualRequest = ((DetectLanguageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(mimeType, actualRequest.getMimeType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detectLanguageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      client.detectLanguage(parent, model, mimeType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportedLanguagesTest() throws Exception {
    SupportedLanguages expectedResponse =
        SupportedLanguages.newBuilder().addAllLanguages(new ArrayList<SupportedLanguage>()).build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String displayLanguageCode = "displayLanguageCode-1457478841";
    String model = "model104069929";

    SupportedLanguages actualResponse =
        client.getSupportedLanguages(parent, displayLanguageCode, model);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSupportedLanguagesRequest actualRequest =
        ((GetSupportedLanguagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(displayLanguageCode, actualRequest.getDisplayLanguageCode());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSupportedLanguagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String displayLanguageCode = "displayLanguageCode-1457478841";
      String model = "model104069929";
      client.getSupportedLanguages(parent, displayLanguageCode, model);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportedLanguagesTest2() throws Exception {
    SupportedLanguages expectedResponse =
        SupportedLanguages.newBuilder().addAllLanguages(new ArrayList<SupportedLanguage>()).build();
    mockTranslationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String displayLanguageCode = "displayLanguageCode-1457478841";
    String model = "model104069929";

    SupportedLanguages actualResponse =
        client.getSupportedLanguages(parent, displayLanguageCode, model);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSupportedLanguagesRequest actualRequest =
        ((GetSupportedLanguagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(displayLanguageCode, actualRequest.getDisplayLanguageCode());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSupportedLanguagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
      String displayLanguageCode = "displayLanguageCode-1457478841";
      String model = "model104069929";
      client.getSupportedLanguages(parent, displayLanguageCode, model);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchTranslateTextTest() throws Exception {
    BatchTranslateResponse expectedResponse =
        BatchTranslateResponse.newBuilder()
            .setTotalCharacters(-1368640955)
            .setTranslatedCharacters(-1337326221)
            .setFailedCharacters(1723028396)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchTranslateTextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    BatchTranslateTextRequest request =
        BatchTranslateTextRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .addAllTargetLanguageCodes(new ArrayList<String>())
            .putAllModels(new HashMap<String, String>())
            .addAllInputConfigs(new ArrayList<InputConfig>())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
            .putAllLabels(new HashMap<String, String>())
            .build();

    BatchTranslateResponse actualResponse = client.batchTranslateTextAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchTranslateTextRequest actualRequest = ((BatchTranslateTextRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSourceLanguageCode(), actualRequest.getSourceLanguageCode());
    Assert.assertEquals(
        request.getTargetLanguageCodesList(), actualRequest.getTargetLanguageCodesList());
    Assert.assertEquals(request.getModelsMap(), actualRequest.getModelsMap());
    Assert.assertEquals(request.getInputConfigsList(), actualRequest.getInputConfigsList());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertEquals(request.getGlossariesMap(), actualRequest.getGlossariesMap());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchTranslateTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      BatchTranslateTextRequest request =
          BatchTranslateTextRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setSourceLanguageCode("sourceLanguageCode1645917472")
              .addAllTargetLanguageCodes(new ArrayList<String>())
              .putAllModels(new HashMap<String, String>())
              .addAllInputConfigs(new ArrayList<InputConfig>())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.batchTranslateTextAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
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
    CreateGlossaryRequest actualRequest = ((CreateGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Glossary glossary = Glossary.newBuilder().build();
      client.createGlossaryAsync(parent, glossary).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGlossaryTest2() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Glossary glossary = Glossary.newBuilder().build();

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryRequest actualRequest = ((CreateGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
      Glossary glossary = Glossary.newBuilder().build();
      client.createGlossaryAsync(parent, glossary).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGlossariesTest() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGlossaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossariesTest2() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockTranslationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGlossaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossariesTest3() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String filter = "filter-1274492040";

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent, filter);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String filter = "filter-1274492040";
      client.listGlossaries(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossariesTest4() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockTranslationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent, filter);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listGlossaries(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockTranslationService.addResponse(expectedResponse);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryRequest actualRequest = ((GetGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.getGlossary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryTest2() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockTranslationService.addResponse(expectedResponse);

    String name = "name3373707";

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryRequest actualRequest = ((GetGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String name = "name3373707";
      client.getGlossary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryTest() throws Exception {
    DeleteGlossaryResponse expectedResponse =
        DeleteGlossaryResponse.newBuilder()
            .setName("name3373707")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
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
    DeleteGlossaryRequest actualRequest = ((DeleteGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGlossaryTest2() throws Exception {
    DeleteGlossaryResponse expectedResponse =
        DeleteGlossaryResponse.newBuilder()
            .setName("name3373707")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTranslationService.addResponse(resultOperation);

    String name = "name3373707";

    DeleteGlossaryResponse actualResponse = client.deleteGlossaryAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryRequest actualRequest = ((DeleteGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTranslationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
