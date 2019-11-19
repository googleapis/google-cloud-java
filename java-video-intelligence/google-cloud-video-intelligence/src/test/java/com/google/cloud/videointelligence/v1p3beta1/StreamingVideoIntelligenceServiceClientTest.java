/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.videointelligence.v1p3beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class StreamingVideoIntelligenceServiceClientTest {
  private static MockVideoIntelligenceService mockVideoIntelligenceService;
  private static MockStreamingVideoIntelligenceService mockStreamingVideoIntelligenceService;
  private static MockServiceHelper serviceHelper;
  private StreamingVideoIntelligenceServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockVideoIntelligenceService = new MockVideoIntelligenceService();
    mockStreamingVideoIntelligenceService = new MockStreamingVideoIntelligenceService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockVideoIntelligenceService, mockStreamingVideoIntelligenceService));
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
    StreamingVideoIntelligenceServiceSettings settings =
        StreamingVideoIntelligenceServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StreamingVideoIntelligenceServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void streamingAnnotateVideoTest() throws Exception {
    String annotationResultsUri = "annotationResultsUri-238075757";
    StreamingAnnotateVideoResponse expectedResponse =
        StreamingAnnotateVideoResponse.newBuilder()
            .setAnnotationResultsUri(annotationResultsUri)
            .build();
    mockStreamingVideoIntelligenceService.addResponse(expectedResponse);
    StreamingAnnotateVideoRequest request = StreamingAnnotateVideoRequest.newBuilder().build();

    MockStreamObserver<StreamingAnnotateVideoResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse> callable =
        client.streamingAnnotateVideoCallable();
    ApiStreamObserver<StreamingAnnotateVideoRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingAnnotateVideoResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void streamingAnnotateVideoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockStreamingVideoIntelligenceService.addException(exception);
    StreamingAnnotateVideoRequest request = StreamingAnnotateVideoRequest.newBuilder().build();

    MockStreamObserver<StreamingAnnotateVideoResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse> callable =
        client.streamingAnnotateVideoCallable();
    ApiStreamObserver<StreamingAnnotateVideoRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingAnnotateVideoResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
