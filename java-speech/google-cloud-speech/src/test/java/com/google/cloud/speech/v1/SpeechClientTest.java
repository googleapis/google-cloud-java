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

package com.google.cloud.speech.v1;

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
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
  private static MockSpeech mockSpeech;
  private static MockServiceHelper mockServiceHelper;
  private SpeechClient client;
  private LocalChannelProvider channelProvider;

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
  public void recognizeTest() throws Exception {
    RecognizeResponse expectedResponse =
        RecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .build();
    mockSpeech.addResponse(expectedResponse);

    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    RecognitionAudio audio = RecognitionAudio.newBuilder().build();

    RecognizeResponse actualResponse = client.recognize(config, audio);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = ((RecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
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
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().build();
      client.recognize(config, audio);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void longRunningRecognizeTest() throws Exception {
    LongRunningRecognizeResponse expectedResponse =
        LongRunningRecognizeResponse.newBuilder()
            .addAllResults(new ArrayList<SpeechRecognitionResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("longRunningRecognizeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpeech.addResponse(resultOperation);

    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    RecognitionAudio audio = RecognitionAudio.newBuilder().build();

    LongRunningRecognizeResponse actualResponse =
        client.longRunningRecognizeAsync(config, audio).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LongRunningRecognizeRequest actualRequest =
        ((LongRunningRecognizeRequest) actualRequests.get(0));

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void longRunningRecognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().build();
      client.longRunningRecognizeAsync(config, audio).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamingRecognizeTest() throws Exception {
    StreamingRecognizeResponse expectedResponse =
        StreamingRecognizeResponse.newBuilder()
            .setError(Status.newBuilder().build())
            .addAllResults(new ArrayList<StreamingRecognitionResult>())
            .build();
    mockSpeech.addResponse(expectedResponse);
    StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder().build();

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
    StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder().build();

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
}
