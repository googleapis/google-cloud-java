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

package com.google.cloud.mediatranslation.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class SpeechTranslationServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpeechTranslationService mockSpeechTranslationService;
  private LocalChannelProvider channelProvider;
  private SpeechTranslationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpeechTranslationService = new MockSpeechTranslationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSpeechTranslationService));
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
    SpeechTranslationServiceSettings settings =
        SpeechTranslationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpeechTranslationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void streamingTranslateSpeechTest() throws Exception {
    StreamingTranslateSpeechResponse expectedResponse =
        StreamingTranslateSpeechResponse.newBuilder()
            .setError(Status.newBuilder().build())
            .setResult(StreamingTranslateSpeechResult.newBuilder().build())
            .build();
    mockSpeechTranslationService.addResponse(expectedResponse);
    StreamingTranslateSpeechRequest request = StreamingTranslateSpeechRequest.newBuilder().build();

    MockStreamObserver<StreamingTranslateSpeechResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse>
        callable = client.streamingTranslateSpeechCallable();
    ApiStreamObserver<StreamingTranslateSpeechRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingTranslateSpeechResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingTranslateSpeechExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpeechTranslationService.addException(exception);
    StreamingTranslateSpeechRequest request = StreamingTranslateSpeechRequest.newBuilder().build();

    MockStreamObserver<StreamingTranslateSpeechResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingTranslateSpeechRequest, StreamingTranslateSpeechResponse>
        callable = client.streamingTranslateSpeechCallable();
    ApiStreamObserver<StreamingTranslateSpeechRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingTranslateSpeechResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
