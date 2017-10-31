/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SpeechClientTest {
  private static MockSpeech mockSpeech;
  private static MockServiceHelper serviceHelper;
  private SpeechClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpeech = new MockSpeech();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockSpeech));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    SpeechSettings settings =
        SpeechSettings.newBuilder()
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpeechClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void recognizeTest() {
    RecognizeResponse expectedResponse = RecognizeResponse.newBuilder().build();
    mockSpeech.addResponse(expectedResponse);

    RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
    int sampleRateHertz = 44100;
    String languageCode = "en-US";
    RecognitionConfig config =
        RecognitionConfig.newBuilder()
            .setEncoding(encoding)
            .setSampleRateHertz(sampleRateHertz)
            .setLanguageCode(languageCode)
            .build();
    String uri = "gs://bucket_name/file_name.flac";
    RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();

    RecognizeResponse actualResponse = client.recognize(config, audio);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecognizeRequest actualRequest = (RecognizeRequest) actualRequests.get(0);

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
  }

  @Test
  @SuppressWarnings("all")
  public void recognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
      int sampleRateHertz = 44100;
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(encoding)
              .setSampleRateHertz(sampleRateHertz)
              .setLanguageCode(languageCode)
              .build();
      String uri = "gs://bucket_name/file_name.flac";
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();

      client.recognize(config, audio);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void longRunningRecognizeTest() throws Exception {
    LongRunningRecognizeResponse expectedResponse =
        LongRunningRecognizeResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("longRunningRecognizeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSpeech.addResponse(resultOperation);

    RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
    int sampleRateHertz = 44100;
    String languageCode = "en-US";
    RecognitionConfig config =
        RecognitionConfig.newBuilder()
            .setEncoding(encoding)
            .setSampleRateHertz(sampleRateHertz)
            .setLanguageCode(languageCode)
            .build();
    String uri = "gs://bucket_name/file_name.flac";
    RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();

    LongRunningRecognizeResponse actualResponse =
        client.longRunningRecognizeAsync(config, audio).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LongRunningRecognizeRequest actualRequest = (LongRunningRecognizeRequest) actualRequests.get(0);

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
  }

  @Test
  @SuppressWarnings("all")
  public void longRunningRecognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSpeech.addException(exception);

    try {
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
      int sampleRateHertz = 44100;
      String languageCode = "en-US";
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(encoding)
              .setSampleRateHertz(sampleRateHertz)
              .setLanguageCode(languageCode)
              .build();
      String uri = "gs://bucket_name/file_name.flac";
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();

      client.longRunningRecognizeAsync(config, audio).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void streamingRecognizeTest() throws Exception {
    StreamingRecognizeResponse expectedResponse = StreamingRecognizeResponse.newBuilder().build();
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
  @SuppressWarnings("all")
  public void streamingRecognizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
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
      Assert.assertTrue(e.getCause() instanceof StatusRuntimeException);
      StatusRuntimeException statusException = (StatusRuntimeException) e.getCause();
      Assert.assertEquals(Status.INVALID_ARGUMENT, statusException.getStatus());
    }
  }
}
