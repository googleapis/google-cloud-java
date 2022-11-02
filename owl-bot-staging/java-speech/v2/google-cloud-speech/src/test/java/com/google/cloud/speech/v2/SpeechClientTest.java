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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
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
public class SpeechClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpeech mockSpeech;
  private LocalChannelProvider channelProvider;
  private SpeechClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpeech = new MockSpeech();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSpeech));
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
    SpeechSettings settings =
        SpeechSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpeechClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockSpeech.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Recognizer recognizer = Recognizer.newBuilder().build();
    String recognizerId = "recognizerId771963359";

    Recognizer actualResponse =
        client.createRecognizerAsync(parent, recognizer, recognizerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRecognizerRequest actualRequest = ((CreateRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(recognizerId, actualRequest.getRecognizerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRecognizerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Recognizer recognizer = Recognizer.newBuilder().build();
      String recognizerId = "recognizerId771963359";
      client.createRecognizerAsync(parent, recognizer, recognizerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String parent = "parent-995424086";
    Recognizer recognizer = Recognizer.newBuilder().build();
    String recognizerId = "recognizerId771963359";

    Recognizer actualResponse =
        client.createRecognizerAsync(parent, recognizer, recognizerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRecognizerRequest actualRequest = ((CreateRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(recognizerId, actualRequest.getRecognizerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRecognizerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
      Recognizer recognizer = Recognizer.newBuilder().build();
      String recognizerId = "recognizerId771963359";
      client.createRecognizerAsync(parent, recognizer, recognizerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRecognizersPagedResponse pagedListResponse = client.listRecognizers(parent);

    List<Recognizer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecognizersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecognizersRequest actualRequest = ((ListRecognizersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecognizersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRecognizersPagedResponse pagedListResponse = client.listRecognizers(parent);

    List<Recognizer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecognizersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecognizersRequest actualRequest = ((ListRecognizersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecognizersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockSpeech.addResponse(expectedResponse);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.getRecognizer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecognizerRequest actualRequest = ((GetRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRecognizerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String name = "name3373707";

    Recognizer actualResponse = client.getRecognizer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecognizerRequest actualRequest = ((GetRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRecognizerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
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
    mockSpeech.addResponse(resultOperation);

    Recognizer recognizer = Recognizer.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Recognizer actualResponse = client.updateRecognizerAsync(recognizer, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRecognizerRequest actualRequest = ((UpdateRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRecognizerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      Recognizer recognizer = Recognizer.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRecognizerAsync(recognizer, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.deleteRecognizerAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRecognizerRequest actualRequest = ((DeleteRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRecognizerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      client.deleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    Recognizer actualResponse = client.deleteRecognizerAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRecognizerRequest actualRequest = ((DeleteRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRecognizerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");

    Recognizer actualResponse = client.undeleteRecognizerAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteRecognizerRequest actualRequest = ((UndeleteRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteRecognizerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognizerName name = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      client.undeleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    Recognizer actualResponse = client.undeleteRecognizerAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteRecognizerRequest actualRequest = ((UndeleteRecognizerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteRecognizerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.undeleteRecognizerAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void recognizeTest() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockSpeech.addResponse(expectedResponse);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    ByteString content = ByteString.EMPTY;

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = ((RecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer.toString(), actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    String uri = "uri116076";

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = ((RecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer.toString(), actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recognizeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String recognizer = "recognizer429853092";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    ByteString content = ByteString.EMPTY;

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = ((RecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recognizeExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String recognizer = "recognizer429853092";
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
    mockSpeech.addResponse(expectedResponse);

    String recognizer = "recognizer429853092";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    String uri = "uri116076";

    RecognizeResponse actualResponse = client.recognize(recognizer, config, configMask, uri);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = ((RecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recognizeExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String recognizer = "recognizer429853092";
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
  public void streamingRecognizeTest() throws Exception {
    StreamingRecognizeResponse expectedResponse =
        StreamingRecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<StreamingRecognitionResult>())
            .setSpeechEventOffset(Duration.newBuilder().build())
            .setMetadata(RecognitionResponseMetadata.newBuilder().build())
            .build();
    mockSpeech.addResponse(expectedResponse);
    StreamingRecognizeRequest request =
        StreamingRecognizeRequest.newBuilder()
            .setRecognizer(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .build();

    MockStreamObserver<StreamingRecognizeResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse> callable =
        client.streamingRecognizeCallable();
    ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingRecognizeResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingRecognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);
    StreamingRecognizeRequest request =
        StreamingRecognizeRequest.newBuilder()
            .setRecognizer(RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]").toString())
            .build();

    MockStreamObserver<StreamingRecognizeResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse> callable =
        client.streamingRecognizeCallable();
    ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingRecognizeResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
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
    mockSpeech.addResponse(resultOperation);

    RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    List<BatchRecognizeFileMetadata> files = new ArrayList<>();

    BatchRecognizeResponse actualResponse =
        client.batchRecognizeAsync(recognizer, config, configMask, files).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRecognizeRequest actualRequest = ((BatchRecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer.toString(), actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(files, actualRequest.getFilesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchRecognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognizerName recognizer = RecognizerName.of("[PROJECT]", "[LOCATION]", "[RECOGNIZER]");
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      List<BatchRecognizeFileMetadata> files = new ArrayList<>();
      client.batchRecognizeAsync(recognizer, config, configMask, files).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String recognizer = "recognizer429853092";
    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    FieldMask configMask = FieldMask.newBuilder().build();
    List<BatchRecognizeFileMetadata> files = new ArrayList<>();

    BatchRecognizeResponse actualResponse =
        client.batchRecognizeAsync(recognizer, config, configMask, files).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRecognizeRequest actualRequest = ((BatchRecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(recognizer, actualRequest.getRecognizer());
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(configMask, actualRequest.getConfigMask());
    Assert.assertEquals(files, actualRequest.getFilesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchRecognizeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String recognizer = "recognizer429853092";
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      FieldMask configMask = FieldMask.newBuilder().build();
      List<BatchRecognizeFileMetadata> files = new ArrayList<>();
      client.batchRecognizeAsync(recognizer, config, configMask, files).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(expectedResponse);

    ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");

    Config actualResponse = client.getConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConfigRequest actualRequest = ((GetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String name = "name3373707";

    Config actualResponse = client.getConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConfigRequest actualRequest = ((GetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
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
    mockSpeech.addResponse(expectedResponse);

    Config config = Config.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Config actualResponse = client.updateConfig(config, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConfigRequest actualRequest = ((UpdateConfigRequest) actualRequests.get(0));

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      Config config = Config.newBuilder().build();
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
    mockSpeech.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse =
        client.createCustomClassAsync(parent, customClass, customClassId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomClassRequest actualRequest = ((CreateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(customClassId, actualRequest.getCustomClassId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClassAsync(parent, customClass, customClassId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String parent = "parent-995424086";
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse =
        client.createCustomClassAsync(parent, customClass, customClassId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomClassRequest actualRequest = ((CreateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(customClassId, actualRequest.getCustomClassId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClassAsync(parent, customClass, customClassId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomClassesRequest actualRequest = ((ListCustomClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomClassesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomClassesRequest actualRequest = ((ListCustomClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomClassesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockSpeech.addResponse(expectedResponse);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.getCustomClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomClassRequest actualRequest = ((GetCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String name = "name3373707";

    CustomClass actualResponse = client.getCustomClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomClassRequest actualRequest = ((GetCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
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
    mockSpeech.addResponse(resultOperation);

    CustomClass customClass = CustomClass.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomClass actualResponse = client.updateCustomClassAsync(customClass, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomClassRequest actualRequest = ((UpdateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      CustomClass customClass = CustomClass.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomClassAsync(customClass, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.deleteCustomClassAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomClassRequest actualRequest = ((DeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.deleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    CustomClass actualResponse = client.deleteCustomClassAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomClassRequest actualRequest = ((DeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.undeleteCustomClassAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteCustomClassRequest actualRequest = ((UndeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.undeleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    CustomClass actualResponse = client.undeleteCustomClassAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteCustomClassRequest actualRequest = ((UndeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.undeleteCustomClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseSetRequest actualRequest = ((CreatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(phraseSetId, actualRequest.getPhraseSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String parent = "parent-995424086";
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseSetRequest actualRequest = ((CreatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(phraseSetId, actualRequest.getPhraseSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSetAsync(parent, phraseSet, phraseSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhraseSetsPagedResponse pagedListResponse = client.listPhraseSets(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseSetsRequest actualRequest = ((ListPhraseSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPhraseSetsPagedResponse pagedListResponse = client.listPhraseSets(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseSetsRequest actualRequest = ((ListPhraseSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockSpeech.addResponse(expectedResponse);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.getPhraseSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseSetRequest actualRequest = ((GetPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

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
    mockSpeech.addResponse(expectedResponse);

    String name = "name3373707";

    PhraseSet actualResponse = client.getPhraseSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseSetRequest actualRequest = ((GetPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
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
    mockSpeech.addResponse(resultOperation);

    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhraseSet actualResponse = client.updatePhraseSetAsync(phraseSet, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePhraseSetRequest actualRequest = ((UpdatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePhraseSetAsync(phraseSet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.deletePhraseSetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseSetRequest actualRequest = ((DeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.deletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    PhraseSet actualResponse = client.deletePhraseSetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseSetRequest actualRequest = ((DeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.deletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.undeletePhraseSetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePhraseSetRequest actualRequest = ((UndeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.undeletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSpeech.addResponse(resultOperation);

    String name = "name3373707";

    PhraseSet actualResponse = client.undeletePhraseSetAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeletePhraseSetRequest actualRequest = ((UndeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeletePhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      String name = "name3373707";
      client.undeletePhraseSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
