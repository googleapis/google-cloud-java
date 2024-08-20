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

package com.google.cloud.translate.v3;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtFilesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtSentencesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossaryEntriesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListModelsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
  public void romanizeTextTest() throws Exception {
    RomanizeTextResponse expectedResponse =
        RomanizeTextResponse.newBuilder()
            .addAllRomanizations(new ArrayList<Romanization>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> contents = new ArrayList<>();

    RomanizeTextResponse actualResponse = client.romanizeText(parent, contents);
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
  public void romanizeTextExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> contents = new ArrayList<>();
      client.romanizeText(parent, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void romanizeTextTest2() throws Exception {
    RomanizeTextResponse expectedResponse =
        RomanizeTextResponse.newBuilder()
            .addAllRomanizations(new ArrayList<Romanization>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<String> contents = new ArrayList<>();

    RomanizeTextResponse actualResponse = client.romanizeText(parent, contents);
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
  public void romanizeTextExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<String> contents = new ArrayList<>();
      client.romanizeText(parent, contents);
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
            .setCustomizedAttribution("customizedAttribution557650238")
            .setIsTranslateNativePdfOnly(true)
            .setEnableShadowRemovalNativePdf(true)
            .setEnableRotationCorrection(true)
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
              .setCustomizedAttribution("customizedAttribution557650238")
              .setIsTranslateNativePdfOnly(true)
              .setEnableShadowRemovalNativePdf(true)
              .setEnableRotationCorrection(true)
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
            .setDisplayName("displayName1714148973")
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
            .setDisplayName("displayName1714148973")
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
  public void updateGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Glossary glossary =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setInputConfig(GlossaryInputConfig.newBuilder().build())
            .setEntryCount(-811131134)
            .setSubmitTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Glossary actualResponse = client.updateGlossaryAsync(glossary, updateMask).get();
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
  public void updateGlossaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Glossary glossary =
          Glossary.newBuilder()
              .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
              .setInputConfig(GlossaryInputConfig.newBuilder().build())
              .setEntryCount(-811131134)
              .setSubmitTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGlossaryAsync(glossary, updateMask).get();
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
            .setDisplayName("displayName1714148973")
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
            .setDisplayName("displayName1714148973")
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

  @Test
  public void getGlossaryEntryTest() throws Exception {
    GlossaryEntry expectedResponse =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    GlossaryEntryName name =
        GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");

    GlossaryEntry actualResponse = client.getGlossaryEntry(name);
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
  public void getGlossaryEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryEntryName name =
          GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");
      client.getGlossaryEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryEntryTest2() throws Exception {
    GlossaryEntry expectedResponse =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1530/locations/location-1530/glossaries/glossarie-1530/glossaryEntries/glossaryEntrie-1530";

    GlossaryEntry actualResponse = client.getGlossaryEntry(name);
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
  public void getGlossaryEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1530/locations/location-1530/glossaries/glossarie-1530/glossaryEntries/glossaryEntrie-1530";
      client.getGlossaryEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryEntriesTest() throws Exception {
    GlossaryEntry responsesElement = GlossaryEntry.newBuilder().build();
    ListGlossaryEntriesResponse expectedResponse =
        ListGlossaryEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaryEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    ListGlossaryEntriesPagedResponse pagedListResponse = client.listGlossaryEntries(parent);

    List<GlossaryEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossaryEntriesList().get(0), resources.get(0));

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
  public void listGlossaryEntriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.listGlossaryEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryEntriesTest2() throws Exception {
    GlossaryEntry responsesElement = GlossaryEntry.newBuilder().build();
    ListGlossaryEntriesResponse expectedResponse =
        ListGlossaryEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaryEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1837/locations/location-1837/glossaries/glossarie-1837";

    ListGlossaryEntriesPagedResponse pagedListResponse = client.listGlossaryEntries(parent);

    List<GlossaryEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossaryEntriesList().get(0), resources.get(0));

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
  public void listGlossaryEntriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1837/locations/location-1837/glossaries/glossarie-1837";
      client.listGlossaryEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryEntryTest() throws Exception {
    GlossaryEntry expectedResponse =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
    GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();

    GlossaryEntry actualResponse = client.createGlossaryEntry(parent, glossaryEntry);
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
  public void createGlossaryEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();
      client.createGlossaryEntry(parent, glossaryEntry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryEntryTest2() throws Exception {
    GlossaryEntry expectedResponse =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1837/locations/location-1837/glossaries/glossarie-1837";
    GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();

    GlossaryEntry actualResponse = client.createGlossaryEntry(parent, glossaryEntry);
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
  public void createGlossaryEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1837/locations/location-1837/glossaries/glossarie-1837";
      GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();
      client.createGlossaryEntry(parent, glossaryEntry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGlossaryEntryTest() throws Exception {
    GlossaryEntry expectedResponse =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    GlossaryEntry glossaryEntry =
        GlossaryEntry.newBuilder()
            .setName(
                GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .build();

    GlossaryEntry actualResponse = client.updateGlossaryEntry(glossaryEntry);
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
  public void updateGlossaryEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryEntry glossaryEntry =
          GlossaryEntry.newBuilder()
              .setName(
                  GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
                      .toString())
              .setDescription("description-1724546052")
              .build();
      client.updateGlossaryEntry(glossaryEntry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryEntryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    GlossaryEntryName name =
        GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");

    client.deleteGlossaryEntry(name);

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
  public void deleteGlossaryEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GlossaryEntryName name =
          GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");
      client.deleteGlossaryEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryEntryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1530/locations/location-1530/glossaries/glossarie-1530/glossaryEntries/glossaryEntrie-1530";

    client.deleteGlossaryEntry(name);

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
  public void deleteGlossaryEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1530/locations/location-1530/glossaries/glossarie-1530/glossaryEntries/glossaryEntrie-1530";
      client.deleteGlossaryEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDatasetAsync(parent, dataset).get();
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
  public void createDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Dataset dataset = Dataset.newBuilder().build();
      client.createDatasetAsync(parent, dataset).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDatasetAsync(parent, dataset).get();
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
  public void createDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Dataset dataset = Dataset.newBuilder().build();
      client.createDatasetAsync(parent, dataset).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1333/locations/location-1333/datasets/dataset-1333";

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1333/locations/location-1333/datasets/dataset-1333";
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

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
  public void listDatasetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest2() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

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
  public void listDatasetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    client.deleteDatasetAsync(name).get();

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
  public void deleteDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1333/locations/location-1333/datasets/dataset-1333";

    client.deleteDatasetAsync(name).get();

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
  public void deleteDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1333/locations/location-1333/datasets/dataset-1333";
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAdaptiveMtDatasetTest() throws Exception {
    AdaptiveMtDataset expectedResponse =
        AdaptiveMtDataset.newBuilder()
            .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();

    AdaptiveMtDataset actualResponse = client.createAdaptiveMtDataset(parent, adaptiveMtDataset);
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
  public void createAdaptiveMtDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();
      client.createAdaptiveMtDataset(parent, adaptiveMtDataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdaptiveMtDatasetTest2() throws Exception {
    AdaptiveMtDataset expectedResponse =
        AdaptiveMtDataset.newBuilder()
            .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();

    AdaptiveMtDataset actualResponse = client.createAdaptiveMtDataset(parent, adaptiveMtDataset);
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
  public void createAdaptiveMtDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();
      client.createAdaptiveMtDataset(parent, adaptiveMtDataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdaptiveMtDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    client.deleteAdaptiveMtDataset(name);

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
  public void deleteAdaptiveMtDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.deleteAdaptiveMtDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdaptiveMtDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1672/locations/location-1672/adaptiveMtDatasets/adaptiveMtDataset-1672";

    client.deleteAdaptiveMtDataset(name);

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
  public void deleteAdaptiveMtDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1672/locations/location-1672/adaptiveMtDatasets/adaptiveMtDataset-1672";
      client.deleteAdaptiveMtDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdaptiveMtDatasetTest() throws Exception {
    AdaptiveMtDataset expectedResponse =
        AdaptiveMtDataset.newBuilder()
            .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    AdaptiveMtDataset actualResponse = client.getAdaptiveMtDataset(name);
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
  public void getAdaptiveMtDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.getAdaptiveMtDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdaptiveMtDatasetTest2() throws Exception {
    AdaptiveMtDataset expectedResponse =
        AdaptiveMtDataset.newBuilder()
            .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setExampleCount(1517063674)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1672/locations/location-1672/adaptiveMtDatasets/adaptiveMtDataset-1672";

    AdaptiveMtDataset actualResponse = client.getAdaptiveMtDataset(name);
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
  public void getAdaptiveMtDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1672/locations/location-1672/adaptiveMtDatasets/adaptiveMtDataset-1672";
      client.getAdaptiveMtDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtDatasetsTest() throws Exception {
    AdaptiveMtDataset responsesElement = AdaptiveMtDataset.newBuilder().build();
    ListAdaptiveMtDatasetsResponse expectedResponse =
        ListAdaptiveMtDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAdaptiveMtDatasetsPagedResponse pagedListResponse = client.listAdaptiveMtDatasets(parent);

    List<AdaptiveMtDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtDatasetsList().get(0), resources.get(0));

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
  public void listAdaptiveMtDatasetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAdaptiveMtDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtDatasetsTest2() throws Exception {
    AdaptiveMtDataset responsesElement = AdaptiveMtDataset.newBuilder().build();
    ListAdaptiveMtDatasetsResponse expectedResponse =
        ListAdaptiveMtDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAdaptiveMtDatasetsPagedResponse pagedListResponse = client.listAdaptiveMtDatasets(parent);

    List<AdaptiveMtDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtDatasetsList().get(0), resources.get(0));

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
  public void listAdaptiveMtDatasetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAdaptiveMtDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void adaptiveMtTranslateTest() throws Exception {
    AdaptiveMtTranslateResponse expectedResponse =
        AdaptiveMtTranslateResponse.newBuilder()
            .addAllTranslations(new ArrayList<AdaptiveMtTranslation>())
            .setLanguageCode("languageCode-2092349083")
            .addAllGlossaryTranslations(new ArrayList<AdaptiveMtTranslation>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> content = new ArrayList<>();

    AdaptiveMtTranslateResponse actualResponse = client.adaptiveMtTranslate(parent, content);
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
  public void adaptiveMtTranslateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> content = new ArrayList<>();
      client.adaptiveMtTranslate(parent, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void adaptiveMtTranslateTest2() throws Exception {
    AdaptiveMtTranslateResponse expectedResponse =
        AdaptiveMtTranslateResponse.newBuilder()
            .addAllTranslations(new ArrayList<AdaptiveMtTranslation>())
            .setLanguageCode("languageCode-2092349083")
            .addAllGlossaryTranslations(new ArrayList<AdaptiveMtTranslation>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<String> content = new ArrayList<>();

    AdaptiveMtTranslateResponse actualResponse = client.adaptiveMtTranslate(parent, content);
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
  public void adaptiveMtTranslateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<String> content = new ArrayList<>();
      client.adaptiveMtTranslate(parent, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdaptiveMtFileTest() throws Exception {
    AdaptiveMtFile expectedResponse =
        AdaptiveMtFile.newBuilder()
            .setName(
                AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryCount(-811131134)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtFileName name =
        AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");

    AdaptiveMtFile actualResponse = client.getAdaptiveMtFile(name);
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
  public void getAdaptiveMtFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtFileName name =
          AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
      client.getAdaptiveMtFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAdaptiveMtFileTest2() throws Exception {
    AdaptiveMtFile expectedResponse =
        AdaptiveMtFile.newBuilder()
            .setName(
                AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryCount(-811131134)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2034/locations/location-2034/adaptiveMtDatasets/adaptiveMtDataset-2034/adaptiveMtFiles/adaptiveMtFile-2034";

    AdaptiveMtFile actualResponse = client.getAdaptiveMtFile(name);
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
  public void getAdaptiveMtFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2034/locations/location-2034/adaptiveMtDatasets/adaptiveMtDataset-2034/adaptiveMtFiles/adaptiveMtFile-2034";
      client.getAdaptiveMtFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdaptiveMtFileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtFileName name =
        AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");

    client.deleteAdaptiveMtFile(name);

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
  public void deleteAdaptiveMtFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtFileName name =
          AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
      client.deleteAdaptiveMtFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAdaptiveMtFileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2034/locations/location-2034/adaptiveMtDatasets/adaptiveMtDataset-2034/adaptiveMtFiles/adaptiveMtFile-2034";

    client.deleteAdaptiveMtFile(name);

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
  public void deleteAdaptiveMtFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2034/locations/location-2034/adaptiveMtDatasets/adaptiveMtDataset-2034/adaptiveMtFiles/adaptiveMtFile-2034";
      client.deleteAdaptiveMtFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importAdaptiveMtFileTest() throws Exception {
    ImportAdaptiveMtFileResponse expectedResponse =
        ImportAdaptiveMtFileResponse.newBuilder()
            .setAdaptiveMtFile(AdaptiveMtFile.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtDatasetName parent = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    ImportAdaptiveMtFileResponse actualResponse = client.importAdaptiveMtFile(parent);
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
  public void importAdaptiveMtFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtDatasetName parent =
          AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.importAdaptiveMtFile(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importAdaptiveMtFileTest2() throws Exception {
    ImportAdaptiveMtFileResponse expectedResponse =
        ImportAdaptiveMtFileResponse.newBuilder()
            .setAdaptiveMtFile(AdaptiveMtFile.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7369/locations/location-7369/adaptiveMtDatasets/adaptiveMtDataset-7369";

    ImportAdaptiveMtFileResponse actualResponse = client.importAdaptiveMtFile(parent);
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
  public void importAdaptiveMtFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7369/locations/location-7369/adaptiveMtDatasets/adaptiveMtDataset-7369";
      client.importAdaptiveMtFile(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtFilesTest() throws Exception {
    AdaptiveMtFile responsesElement = AdaptiveMtFile.newBuilder().build();
    ListAdaptiveMtFilesResponse expectedResponse =
        ListAdaptiveMtFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtDatasetName parent = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    ListAdaptiveMtFilesPagedResponse pagedListResponse = client.listAdaptiveMtFiles(parent);

    List<AdaptiveMtFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtFilesList().get(0), resources.get(0));

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
  public void listAdaptiveMtFilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtDatasetName parent =
          AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.listAdaptiveMtFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtFilesTest2() throws Exception {
    AdaptiveMtFile responsesElement = AdaptiveMtFile.newBuilder().build();
    ListAdaptiveMtFilesResponse expectedResponse =
        ListAdaptiveMtFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7369/locations/location-7369/adaptiveMtDatasets/adaptiveMtDataset-7369";

    ListAdaptiveMtFilesPagedResponse pagedListResponse = client.listAdaptiveMtFiles(parent);

    List<AdaptiveMtFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtFilesList().get(0), resources.get(0));

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
  public void listAdaptiveMtFilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7369/locations/location-7369/adaptiveMtDatasets/adaptiveMtDataset-7369";
      client.listAdaptiveMtFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtSentencesTest() throws Exception {
    AdaptiveMtSentence responsesElement = AdaptiveMtSentence.newBuilder().build();
    ListAdaptiveMtSentencesResponse expectedResponse =
        ListAdaptiveMtSentencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtSentences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AdaptiveMtFileName parent =
        AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");

    ListAdaptiveMtSentencesPagedResponse pagedListResponse = client.listAdaptiveMtSentences(parent);

    List<AdaptiveMtSentence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtSentencesList().get(0), resources.get(0));

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
  public void listAdaptiveMtSentencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AdaptiveMtFileName parent =
          AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
      client.listAdaptiveMtSentences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAdaptiveMtSentencesTest2() throws Exception {
    AdaptiveMtSentence responsesElement = AdaptiveMtSentence.newBuilder().build();
    ListAdaptiveMtSentencesResponse expectedResponse =
        ListAdaptiveMtSentencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdaptiveMtSentences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2383/locations/location-2383/adaptiveMtDatasets/adaptiveMtDataset-2383/adaptiveMtFiles/adaptiveMtFile-2383";

    ListAdaptiveMtSentencesPagedResponse pagedListResponse = client.listAdaptiveMtSentences(parent);

    List<AdaptiveMtSentence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdaptiveMtSentencesList().get(0), resources.get(0));

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
  public void listAdaptiveMtSentencesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2383/locations/location-2383/adaptiveMtDatasets/adaptiveMtDataset-2383/adaptiveMtFiles/adaptiveMtFile-2383";
      client.listAdaptiveMtSentences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importDataTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String dataset = "projects/project-462/locations/location-462/datasets/dataset-462";
    DatasetInputConfig inputConfig = DatasetInputConfig.newBuilder().build();

    client.importDataAsync(dataset, inputConfig).get();

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
  public void importDataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String dataset = "projects/project-462/locations/location-462/datasets/dataset-462";
      DatasetInputConfig inputConfig = DatasetInputConfig.newBuilder().build();
      client.importDataAsync(dataset, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportDataTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String dataset = "projects/project-462/locations/location-462/datasets/dataset-462";
    DatasetOutputConfig outputConfig = DatasetOutputConfig.newBuilder().build();

    client.exportDataAsync(dataset, outputConfig).get();

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
  public void exportDataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String dataset = "projects/project-462/locations/location-462/datasets/dataset-462";
      DatasetOutputConfig outputConfig = DatasetOutputConfig.newBuilder().build();
      client.exportDataAsync(dataset, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listExamplesTest() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest2() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8892/locations/location-8892/datasets/dataset-8892";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8892/locations/location-8892/datasets/dataset-8892";
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDataset("dataset1443214456")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Model model = Model.newBuilder().build();

    Model actualResponse = client.createModelAsync(parent, model).get();
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
  public void createModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Model model = Model.newBuilder().build();
      client.createModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDataset("dataset1443214456")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Model model = Model.newBuilder().build();

    Model actualResponse = client.createModelAsync(parent, model).get();
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
  public void createModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Model model = Model.newBuilder().build();
      client.createModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDataset("dataset1443214456")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    Model actualResponse = client.getModel(name);
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
  public void getModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDataset("dataset1443214456")
            .setSourceLanguageCode("sourceLanguageCode1645917472")
            .setTargetLanguageCode("targetLanguageCode-106414698")
            .setTrainExampleCount(-1755438077)
            .setValidateExampleCount(159308433)
            .setTestExampleCount(483147021)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7594/locations/location-7594/models/model-7594";

    Model actualResponse = client.getModel(name);
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
  public void getModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7594/locations/location-7594/models/model-7594";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    client.deleteModelAsync(name).get();

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
  public void deleteModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7594/locations/location-7594/models/model-7594";

    client.deleteModelAsync(name).get();

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
  public void deleteModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7594/locations/location-7594/models/model-7594";
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
