/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.translate.v3;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.translate.v3.stub.HttpJsonTranslationServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TranslationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TranslationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTranslationServiceStub.getMethodDescriptors(),
            TranslationServiceSettings.getDefaultEndpoint());
    TranslationServiceSettings settings =
        TranslationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TranslationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TranslationServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void translateTextTest() throws Exception {
    TranslateTextResponse expectedResponse =
        TranslateTextResponse.newBuilder()
            .addAllTranslations(new ArrayList<Translation>())
            .addAllGlossaryTranslations(new ArrayList<Translation>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String targetLanguageCode = "targetLanguageCode-106414698";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(parent, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void translateTextExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String targetLanguageCode = "targetLanguageCode-106414698";
      List<String> contents = new ArrayList<>();
      client.translateText(parent, targetLanguageCode, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void translateTextTest2() throws Exception {
    TranslateTextResponse expectedResponse =
        TranslateTextResponse.newBuilder()
            .addAllTranslations(new ArrayList<Translation>())
            .addAllGlossaryTranslations(new ArrayList<Translation>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String targetLanguageCode = "targetLanguageCode-106414698";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(parent, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void translateTextExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String targetLanguageCode = "targetLanguageCode-106414698";
      List<String> contents = new ArrayList<>();
      client.translateText(parent, targetLanguageCode, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void translateTextTest3() throws Exception {
    TranslateTextResponse expectedResponse =
        TranslateTextResponse.newBuilder()
            .addAllTranslations(new ArrayList<Translation>())
            .addAllGlossaryTranslations(new ArrayList<Translation>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";
    String sourceLanguageCode = "sourceLanguageCode1645917472";
    String targetLanguageCode = "targetLanguageCode-106414698";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(
            parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void translateTextExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      String sourceLanguageCode = "sourceLanguageCode1645917472";
      String targetLanguageCode = "targetLanguageCode-106414698";
      List<String> contents = new ArrayList<>();
      client.translateText(
          parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void translateTextTest4() throws Exception {
    TranslateTextResponse expectedResponse =
        TranslateTextResponse.newBuilder()
            .addAllTranslations(new ArrayList<Translation>())
            .addAllGlossaryTranslations(new ArrayList<Translation>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";
    String sourceLanguageCode = "sourceLanguageCode1645917472";
    String targetLanguageCode = "targetLanguageCode-106414698";
    List<String> contents = new ArrayList<>();

    TranslateTextResponse actualResponse =
        client.translateText(
            parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void translateTextExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      String sourceLanguageCode = "sourceLanguageCode1645917472";
      String targetLanguageCode = "targetLanguageCode-106414698";
      List<String> contents = new ArrayList<>();
      client.translateText(
          parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";
    String content = "content951530617";

    DetectLanguageResponse actualResponse = client.detectLanguage(parent, model, mimeType, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void detectLanguageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      String content = "content951530617";
      client.detectLanguage(parent, model, mimeType, content);
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String model = "model104069929";
    String mimeType = "mimeType-1392120434";
    String content = "content951530617";

    DetectLanguageResponse actualResponse = client.detectLanguage(parent, model, mimeType, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void detectLanguageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      String content = "content951530617";
      client.detectLanguage(parent, model, mimeType, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportedLanguagesTest() throws Exception {
    SupportedLanguages expectedResponse =
        SupportedLanguages.newBuilder().addAllLanguages(new ArrayList<SupportedLanguage>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String model = "model104069929";
    String displayLanguageCode = "displayLanguageCode-1457478841";

    SupportedLanguages actualResponse =
        client.getSupportedLanguages(parent, model, displayLanguageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSupportedLanguagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String displayLanguageCode = "displayLanguageCode-1457478841";
      client.getSupportedLanguages(parent, model, displayLanguageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportedLanguagesTest2() throws Exception {
    SupportedLanguages expectedResponse =
        SupportedLanguages.newBuilder().addAllLanguages(new ArrayList<SupportedLanguage>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String model = "model104069929";
    String displayLanguageCode = "displayLanguageCode-1457478841";

    SupportedLanguages actualResponse =
        client.getSupportedLanguages(parent, model, displayLanguageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSupportedLanguagesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String model = "model104069929";
      String displayLanguageCode = "displayLanguageCode-1457478841";
      client.getSupportedLanguages(parent, model, displayLanguageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void translateDocumentTest() throws Exception {
    TranslateDocumentResponse expectedResponse =
        TranslateDocumentResponse.newBuilder()
            .setDocumentTranslation(DocumentTranslation.newBuilder().build())
            .setGlossaryDocumentTranslation(DocumentTranslation.newBuilder().build())
            .setModel("model104069929")
            .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TranslateDocumentRequest request =
        TranslateDocumentRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
            .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
            .setModel("model104069929")
            .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();

    TranslateDocumentResponse actualResponse = client.translateDocument(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void translateDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TranslateDocumentRequest request =
          TranslateDocumentRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setSourceLanguageCode("sourceLanguageCode1645917472")
              .setTargetLanguageCode("targetLanguageCode-106414698")
              .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
              .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
              .setModel("model104069929")
              .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.translateDocument(request);
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
    mockService.addResponse(resultOperation);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchTranslateTextExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    }
  }

  @Test
  public void batchTranslateDocumentTest() throws Exception {
    BatchTranslateDocumentResponse expectedResponse =
        BatchTranslateDocumentResponse.newBuilder()
            .setTotalPages(-396186871)
            .setTranslatedPages(-1652747493)
            .setFailedPages(-2002254526)
            .setTotalBillablePages(1292117569)
            .setTotalCharacters(-1368640955)
            .setTranslatedCharacters(-1337326221)
            .setFailedCharacters(1723028396)
            .setTotalBillableCharacters(1242495501)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchTranslateDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String sourceLanguageCode = "sourceLanguageCode1645917472";
    List<String> targetLanguageCodes = new ArrayList<>();
    List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
    BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();

    BatchTranslateDocumentResponse actualResponse =
        client
            .batchTranslateDocumentAsync(
                parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchTranslateDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String sourceLanguageCode = "sourceLanguageCode1645917472";
      List<String> targetLanguageCodes = new ArrayList<>();
      List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
      BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
      client
          .batchTranslateDocumentAsync(
              parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchTranslateDocumentTest2() throws Exception {
    BatchTranslateDocumentResponse expectedResponse =
        BatchTranslateDocumentResponse.newBuilder()
            .setTotalPages(-396186871)
            .setTranslatedPages(-1652747493)
            .setFailedPages(-2002254526)
            .setTotalBillablePages(1292117569)
            .setTotalCharacters(-1368640955)
            .setTranslatedCharacters(-1337326221)
            .setFailedCharacters(1723028396)
            .setTotalBillableCharacters(1242495501)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchTranslateDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String sourceLanguageCode = "sourceLanguageCode1645917472";
    List<String> targetLanguageCodes = new ArrayList<>();
    List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
    BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();

    BatchTranslateDocumentResponse actualResponse =
        client
            .batchTranslateDocumentAsync(
                parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchTranslateDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String sourceLanguageCode = "sourceLanguageCode1645917472";
      List<String> targetLanguageCodes = new ArrayList<>();
      List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
      BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
      client
          .batchTranslateDocumentAsync(
              parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Glossary glossary = Glossary.newBuilder().build();

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createGlossaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Glossary glossary = Glossary.newBuilder().build();
      client.createGlossaryAsync(parent, glossary).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Glossary glossary = Glossary.newBuilder().build();

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createGlossaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Glossary glossary = Glossary.newBuilder().build();
      client.createGlossaryAsync(parent, glossary).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listGlossariesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listGlossariesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGlossaries(parent);
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
    mockService.addResponse(expectedResponse);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getGlossaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9868/locations/location-9868/glossaries/glossarie-9868";

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getGlossaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9868/locations/location-9868/glossaries/glossarie-9868";
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
    mockService.addResponse(resultOperation);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    DeleteGlossaryResponse actualResponse = client.deleteGlossaryAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteGlossaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-9868/locations/location-9868/glossaries/glossarie-9868";

    DeleteGlossaryResponse actualResponse = client.deleteGlossaryAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteGlossaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9868/locations/location-9868/glossaries/glossarie-9868";
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
