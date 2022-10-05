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

package com.google.cloud.speech.v2;

import static com.google.cloud.speech.v2.SpeechClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListPhraseSetsPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListRecognizersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.speech.v2.stub.HttpJsonSpeechStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class SpeechClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SpeechClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSpeechStub.getMethodDescriptors(), SpeechSettings.getDefaultEndpoint());
    SpeechSettings settings =
        SpeechSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SpeechSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpeechClient.create(settings);
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
  public void createRecognizerTest() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Recognizer recognizer = Recognizer.newBuilder().build();
    String recognizerId = "recognizerId771963359";

    Recognizer actualResponse =
        client.createRecognizerAsync(parent, recognizer, recognizerId).get();
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
  public void createRecognizerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Recognizer recognizer = Recognizer.newBuilder().build();
      String recognizerId = "recognizerId771963359";
      client.createRecognizerAsync(parent, recognizer, recognizerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createRecognizerTest2() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Recognizer recognizer = Recognizer.newBuilder().build();
    String recognizerId = "recognizerId771963359";

    Recognizer actualResponse =
        client.createRecognizerAsync(parent, recognizer, recognizerId).get();
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
  public void createRecognizerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Recognizer recognizer = Recognizer.newBuilder().build();
      String recognizerId = "recognizerId771963359";
      client.createRecognizerAsync(parent, recognizer, recognizerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listRecognizersTest() throws Exception {
    Recognizer responsesElement = Recognizer.newBuilder().build();
    ListRecognizersResponse expectedResponse =
        ListRecognizersResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecognizers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRecognizersPagedResponse pagedListResponse = client.listRecognizers(parent);

    List<Recognizer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecognizersList().get(0), resources.get(0));

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
  public void listRecognizersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRecognizers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecognizersTest2() throws Exception {
    Recognizer responsesElement = Recognizer.newBuilder().build();
    ListRecognizersResponse expectedResponse =
        ListRecognizersResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecognizers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRecognizersPagedResponse pagedListResponse = client.listRecognizers(parent);

    List<Recognizer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecognizersList().get(0), resources.get(0));

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
  public void listRecognizersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listRecognizers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecognizerTest() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.getRecognizer(name);
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
  public void getRecognizerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      client.getRecognizer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecognizerTest2() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";

    Recognizer actualResponse = client.getRecognizer(name);
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
  public void getRecognizerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";
      client.getRecognizer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRecognizerTest() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Recognizer recognizer =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Recognizer actualResponse = client.updateRecognizerAsync(recognizer, updateMask).get();
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
  public void updateRecognizerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Recognizer recognizer =
          Recognizer.newBuilder()
              .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
              .setUid("uid115792")
              .setDisplayName("displayName1714148973")
              .setModel("model104069929")
              .addAllLanguageCodes(new ArrayList<String>())
              .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
              .putAllAnnotations(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .setReconciling(true)
              .setKmsKeyName("kmsKeyName412586233")
              .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRecognizerAsync(recognizer, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRecognizerTest() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.deleteRecognizerAsync(name).get();
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
  public void deleteRecognizerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      client.deleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteRecognizerTest2() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";

    Recognizer actualResponse = client.deleteRecognizerAsync(name).get();
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
  public void deleteRecognizerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";
      client.deleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeleteRecognizerTest() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.undeleteRecognizerAsync(name).get();
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
  public void undeleteRecognizerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      client.undeleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeleteRecognizerTest2() throws Exception {
    Recognizer expectedResponse =
        Recognizer.newBuilder()
            .setName(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setModel("model104069929")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDefaultRecognitionConfig(RecognitionConfig.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteRecognizerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";

    Recognizer actualResponse = client.undeleteRecognizerAsync(name).get();
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
  public void undeleteRecognizerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4309/locations/location-4309/recognizers/recognizer-4309";
      client.undeleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void recognizeTest() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    ByteString content = ByteString.EMPTY;

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, content);
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
  public void recognizeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      ByteString content = ByteString.EMPTY;
      client.recognize(recognizer, config, configMask, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void recognizeTest2() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    String uri = "uri116076";

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, uri);
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
  public void recognizeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      String uri = "uri116076";
      client.recognize(recognizer, config, configMask, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void recognizeTest3() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String recognizer = "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    ByteString content = ByteString.EMPTY;

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, content);
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
  public void recognizeExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String recognizer =
          "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      ByteString content = ByteString.EMPTY;
      client.recognize(recognizer, config, configMask, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void recognizeTest4() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String recognizer = "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    String uri = "uri116076";

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, uri);
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
  public void recognizeExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String recognizer =
          "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      String uri = "uri116076";
      client.recognize(recognizer, config, configMask, uri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingRecognizeUnsupportedMethodTest() throws Exception {
    // The streamingRecognize() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void batchRecognizeTest() throws Exception {
    BatchRecognizeResponse expectedResponse =
        BatchRecognizeResponse.newBuilder()
            .putAllResults(new HashMap<String, BatchRecognizeFileResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchRecognizeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    List<BatchRecognizeFileMetadata> files = new ArrayList<>();

    BatchRecognizeResponse actualResponse =
        client.batchRecognizeAsync(recognizer, config, configMask, files).get();
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
  public void batchRecognizeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      List<BatchRecognizeFileMetadata> files = new ArrayList<>();
      client.batchRecognizeAsync(recognizer, config, configMask, files).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchRecognizeTest2() throws Exception {
    BatchRecognizeResponse expectedResponse =
        BatchRecognizeResponse.newBuilder()
            .putAllResults(new HashMap<String, BatchRecognizeFileResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchRecognizeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String recognizer = "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    List<BatchRecognizeFileMetadata> files = new ArrayList<>();

    BatchRecognizeResponse actualResponse =
        client.batchRecognizeAsync(recognizer, config, configMask, files).get();
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
  public void batchRecognizeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String recognizer =
          "projects/project-2882/locations/location-2882/recognizers/recognizer-2882";
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      List<BatchRecognizeFileMetadata> files = new ArrayList<>();
      client.batchRecognizeAsync(recognizer, config, configMask, files).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getConfigTest() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConfigTest2() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-505/locations/location-505/config";

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-505/locations/location-505/config";
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConfigTest() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Config config =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Config actualResponse = client.updateConfig(config, updateMask);
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
  public void updateConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Config config =
          Config.newBuilder()
              .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
              .setKmsKeyName("kmsKeyName412586233")
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConfig(config, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse =
        client.createCustomClassAsync(parent, customClass, customClassId).get();
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
  public void createCustomClassExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClassAsync(parent, customClass, customClassId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse =
        client.createCustomClassAsync(parent, customClass, customClassId).get();
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
  public void createCustomClassExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClassAsync(parent, customClass, customClassId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listCustomClassesTest() throws Exception {
    CustomClass responsesElement = CustomClass.newBuilder().build();
    ListCustomClassesResponse expectedResponse =
        ListCustomClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomClasses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

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
  public void listCustomClassesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCustomClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomClassesTest2() throws Exception {
    CustomClass responsesElement = CustomClass.newBuilder().build();
    ListCustomClassesResponse expectedResponse =
        ListCustomClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomClasses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

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
  public void listCustomClassesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCustomClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.getCustomClass(name);
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
  public void getCustomClassExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.getCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";

    CustomClass actualResponse = client.getCustomClass(name);
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
  public void getCustomClassExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";
      client.getCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CustomClass customClass =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomClass actualResponse = client.updateCustomClassAsync(customClass, updateMask).get();
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
  public void updateCustomClassExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomClass customClass =
          CustomClass.newBuilder()
              .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
              .setUid("uid115792")
              .setDisplayName("displayName1714148973")
              .addAllItems(new ArrayList<CustomClass.ClassItem>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .putAllAnnotations(new HashMap<String, String>())
              .setEtag("etag3123477")
              .setReconciling(true)
              .setKmsKeyName("kmsKeyName412586233")
              .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomClassAsync(customClass, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.deleteCustomClassAsync(name).get();
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
  public void deleteCustomClassExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.deleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";

    CustomClass actualResponse = client.deleteCustomClassAsync(name).get();
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
  public void deleteCustomClassExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";
      client.deleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeleteCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.undeleteCustomClassAsync(name).get();
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
  public void undeleteCustomClassExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.undeleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeleteCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteCustomClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";

    CustomClass actualResponse = client.undeleteCustomClassAsync(name).get();
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
  public void undeleteCustomClassExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4379/locations/location-4379/customClasses/customClasse-4379";
      client.undeleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
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
  public void createPhraseSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
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
  public void createPhraseSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listPhraseSetsTest() throws Exception {
    PhraseSet responsesElement = PhraseSet.newBuilder().build();
    ListPhraseSetsResponse expectedResponse =
        ListPhraseSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhraseSetsPagedResponse pagedListResponse = client.listPhraseSets(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

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
  public void listPhraseSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPhraseSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhraseSetsTest2() throws Exception {
    PhraseSet responsesElement = PhraseSet.newBuilder().build();
    ListPhraseSetsResponse expectedResponse =
        ListPhraseSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPhraseSetsPagedResponse pagedListResponse = client.listPhraseSets(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

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
  public void listPhraseSetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPhraseSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.getPhraseSet(name);
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
  public void getPhraseSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.getPhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";

    PhraseSet actualResponse = client.getPhraseSet(name);
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
  public void getPhraseSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";
      client.getPhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PhraseSet phraseSet =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhraseSet actualResponse = client.updatePhraseSetAsync(phraseSet, updateMask).get();
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
  public void updatePhraseSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseSet phraseSet =
          PhraseSet.newBuilder()
              .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
              .setUid("uid115792")
              .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
              .setBoost(93922211)
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .putAllAnnotations(new HashMap<String, String>())
              .setEtag("etag3123477")
              .setReconciling(true)
              .setKmsKeyName("kmsKeyName412586233")
              .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePhraseSetAsync(phraseSet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.deletePhraseSetAsync(name).get();
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
  public void deletePhraseSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.deletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";

    PhraseSet actualResponse = client.deletePhraseSetAsync(name).get();
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
  public void deletePhraseSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";
      client.deletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeletePhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.undeletePhraseSetAsync(name).get();
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
  public void undeletePhraseSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.undeletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeletePhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .setUid("uid115792")
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setReconciling(true)
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePhraseSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";

    PhraseSet actualResponse = client.undeletePhraseSetAsync(name).get();
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
  public void undeletePhraseSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-458/locations/location-458/phraseSets/phraseSet-458";
      client.undeletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
