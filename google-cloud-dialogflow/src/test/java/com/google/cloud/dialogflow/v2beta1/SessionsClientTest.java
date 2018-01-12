/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dialogflow.v2beta1;

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
public class SessionsClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private SessionsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockContexts = new MockContexts();
    mockEntityTypes = new MockEntityTypes();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAgents,
                mockContexts,
                mockEntityTypes,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions));
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
    SessionsSettings settings =
        SessionsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void detectIntentTest() {
    String responseId = "responseId1847552473";
    DetectIntentResponse expectedResponse =
        DetectIntentResponse.newBuilder().setResponseId(responseId).build();
    mockSessions.addResponse(expectedResponse);

    SessionName session = SessionName.of("[PROJECT]", "[SESSION]");
    QueryInput queryInput = QueryInput.newBuilder().build();

    DetectIntentResponse actualResponse = client.detectIntent(session, queryInput);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectIntentRequest actualRequest = (DetectIntentRequest) actualRequests.get(0);

    Assert.assertEquals(session, actualRequest.getSessionAsSessionName());
    Assert.assertEquals(queryInput, actualRequest.getQueryInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void detectIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      SessionName session = SessionName.of("[PROJECT]", "[SESSION]");
      QueryInput queryInput = QueryInput.newBuilder().build();

      client.detectIntent(session, queryInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void streamingDetectIntentTest() throws Exception {
    String responseId = "responseId1847552473";
    StreamingDetectIntentResponse expectedResponse =
        StreamingDetectIntentResponse.newBuilder().setResponseId(responseId).build();
    mockSessions.addResponse(expectedResponse);
    String session = "session1984987798";
    QueryInput queryInput = QueryInput.newBuilder().build();
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder()
            .setSession(session)
            .setQueryInput(queryInput)
            .build();

    MockStreamObserver<StreamingDetectIntentResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse> callable =
        client.streamingDetectIntentCallable();
    ApiStreamObserver<StreamingDetectIntentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingDetectIntentResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void streamingDetectIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);
    String session = "session1984987798";
    QueryInput queryInput = QueryInput.newBuilder().build();
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder()
            .setSession(session)
            .setQueryInput(queryInput)
            .build();

    MockStreamObserver<StreamingDetectIntentResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse> callable =
        client.streamingDetectIntentCallable();
    ApiStreamObserver<StreamingDetectIntentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingDetectIntentResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof StatusRuntimeException);
      StatusRuntimeException statusException = (StatusRuntimeException) e.getCause();
      Assert.assertEquals(Status.INVALID_ARGUMENT, statusException.getStatus());
    }
  }
}
