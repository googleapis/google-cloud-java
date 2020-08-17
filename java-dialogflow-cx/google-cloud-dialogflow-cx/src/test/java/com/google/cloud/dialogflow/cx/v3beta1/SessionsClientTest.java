/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.dialogflow.cx.v3beta1;

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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class SessionsClientTest {
  private static MockPages mockPages;
  private static MockFlows mockFlows;
  private static MockAgents mockAgents;
  private static MockEntityTypes mockEntityTypes;
  private static MockEnvironments mockEnvironments;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockTransitionRouteGroups mockTransitionRouteGroups;
  private static MockVersions mockVersions;
  private static MockWebhooks mockWebhooks;
  private static MockServiceHelper serviceHelper;
  private SessionsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPages = new MockPages();
    mockFlows = new MockFlows();
    mockAgents = new MockAgents();
    mockEntityTypes = new MockEntityTypes();
    mockEnvironments = new MockEnvironments();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    mockTransitionRouteGroups = new MockTransitionRouteGroups();
    mockVersions = new MockVersions();
    mockWebhooks = new MockWebhooks();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockPages,
                mockFlows,
                mockAgents,
                mockEntityTypes,
                mockEnvironments,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions,
                mockTransitionRouteGroups,
                mockVersions,
                mockWebhooks));
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
    ByteString outputAudio = ByteString.copyFromUtf8("24");
    DetectIntentResponse expectedResponse =
        DetectIntentResponse.newBuilder()
            .setResponseId(responseId)
            .setOutputAudio(outputAudio)
            .build();
    mockSessions.addResponse(expectedResponse);

    SessionName session =
        SessionName.ofProjectLocationAgentSessionName(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]");
    QueryInput queryInput = QueryInput.newBuilder().build();
    DetectIntentRequest request =
        DetectIntentRequest.newBuilder()
            .setSession(session.toString())
            .setQueryInput(queryInput)
            .build();

    DetectIntentResponse actualResponse = client.detectIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectIntentRequest actualRequest = (DetectIntentRequest) actualRequests.get(0);

    Assert.assertEquals(session, SessionName.parse(actualRequest.getSession()));
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
      SessionName session =
          SessionName.ofProjectLocationAgentSessionName(
              "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]");
      QueryInput queryInput = QueryInput.newBuilder().build();
      DetectIntentRequest request =
          DetectIntentRequest.newBuilder()
              .setSession(session.toString())
              .setQueryInput(queryInput)
              .build();

      client.detectIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void streamingDetectIntentTest() throws Exception {
    StreamingDetectIntentResponse expectedResponse =
        StreamingDetectIntentResponse.newBuilder().build();
    mockSessions.addResponse(expectedResponse);
    QueryInput queryInput = QueryInput.newBuilder().build();
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder().setQueryInput(queryInput).build();

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
    QueryInput queryInput = QueryInput.newBuilder().build();
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder().setQueryInput(queryInput).build();

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
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void matchIntentTest() {
    String text = "text3556653";
    MatchIntentResponse expectedResponse = MatchIntentResponse.newBuilder().setText(text).build();
    mockSessions.addResponse(expectedResponse);

    SessionName session =
        SessionName.ofProjectLocationAgentSessionName(
            "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]");
    QueryInput queryInput = QueryInput.newBuilder().build();
    MatchIntentRequest request =
        MatchIntentRequest.newBuilder()
            .setSession(session.toString())
            .setQueryInput(queryInput)
            .build();

    MatchIntentResponse actualResponse = client.matchIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MatchIntentRequest actualRequest = (MatchIntentRequest) actualRequests.get(0);

    Assert.assertEquals(session, SessionName.parse(actualRequest.getSession()));
    Assert.assertEquals(queryInput, actualRequest.getQueryInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void matchIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      SessionName session =
          SessionName.ofProjectLocationAgentSessionName(
              "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]");
      QueryInput queryInput = QueryInput.newBuilder().build();
      MatchIntentRequest request =
          MatchIntentRequest.newBuilder()
              .setSession(session.toString())
              .setQueryInput(queryInput)
              .build();

      client.matchIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void fulfillIntentTest() {
    String responseId = "responseId1847552473";
    ByteString outputAudio = ByteString.copyFromUtf8("24");
    FulfillIntentResponse expectedResponse =
        FulfillIntentResponse.newBuilder()
            .setResponseId(responseId)
            .setOutputAudio(outputAudio)
            .build();
    mockSessions.addResponse(expectedResponse);

    FulfillIntentRequest request = FulfillIntentRequest.newBuilder().build();

    FulfillIntentResponse actualResponse = client.fulfillIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FulfillIntentRequest actualRequest = (FulfillIntentRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void fulfillIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      FulfillIntentRequest request = FulfillIntentRequest.newBuilder().build();

      client.fulfillIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
