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
public class SessionsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private SessionsClient client;
  private LocalChannelProvider channelProvider;
  private static MockSessions mockSessions;

  @BeforeClass
  public static void startStaticServer() {
    mockSessions = new MockSessions();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSessions));
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
  public void detectIntentTest() throws Exception {
    DetectIntentResponse expectedResponse =
        DetectIntentResponse.newBuilder()
            .setResponseId("responseId-633138884")
            .setQueryResult(QueryResult.newBuilder().build())
            .setOutputAudio(ByteString.EMPTY)
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();
    mockSessions.addResponse(expectedResponse);

    DetectIntentRequest request =
        DetectIntentRequest.newBuilder()
            .setSession(
                SessionName.ofProjectLocationAgentSessionName(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                    .toString())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setQueryInput(QueryInput.newBuilder().build())
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();

    DetectIntentResponse actualResponse = client.detectIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DetectIntentRequest actualRequest = ((DetectIntentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getQueryParams(), actualRequest.getQueryParams());
    Assert.assertEquals(request.getQueryInput(), actualRequest.getQueryInput());
    Assert.assertEquals(request.getOutputAudioConfig(), actualRequest.getOutputAudioConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void detectIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      DetectIntentRequest request =
          DetectIntentRequest.newBuilder()
              .setSession(
                  SessionName.ofProjectLocationAgentSessionName(
                          "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                      .toString())
              .setQueryParams(QueryParameters.newBuilder().build())
              .setQueryInput(QueryInput.newBuilder().build())
              .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
              .build();
      client.detectIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingDetectIntentTest() throws Exception {
    StreamingDetectIntentResponse expectedResponse =
        StreamingDetectIntentResponse.newBuilder().build();
    mockSessions.addResponse(expectedResponse);
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder()
            .setSession(
                SessionName.ofProjectLocationAgentSessionName(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                    .toString())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setQueryInput(QueryInput.newBuilder().build())
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
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
  public void streamingDetectIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);
    StreamingDetectIntentRequest request =
        StreamingDetectIntentRequest.newBuilder()
            .setSession(
                SessionName.ofProjectLocationAgentSessionName(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                    .toString())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setQueryInput(QueryInput.newBuilder().build())
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
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
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void matchIntentTest() throws Exception {
    MatchIntentResponse expectedResponse =
        MatchIntentResponse.newBuilder()
            .addAllMatches(new ArrayList<Match>())
            .setCurrentPage(Page.newBuilder().build())
            .build();
    mockSessions.addResponse(expectedResponse);

    MatchIntentRequest request =
        MatchIntentRequest.newBuilder()
            .setSession(
                SessionName.ofProjectLocationAgentSessionName(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                    .toString())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setQueryInput(QueryInput.newBuilder().build())
            .build();

    MatchIntentResponse actualResponse = client.matchIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MatchIntentRequest actualRequest = ((MatchIntentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getQueryParams(), actualRequest.getQueryParams());
    Assert.assertEquals(request.getQueryInput(), actualRequest.getQueryInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void matchIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      MatchIntentRequest request =
          MatchIntentRequest.newBuilder()
              .setSession(
                  SessionName.ofProjectLocationAgentSessionName(
                          "[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]")
                      .toString())
              .setQueryParams(QueryParameters.newBuilder().build())
              .setQueryInput(QueryInput.newBuilder().build())
              .build();
      client.matchIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fulfillIntentTest() throws Exception {
    FulfillIntentResponse expectedResponse =
        FulfillIntentResponse.newBuilder()
            .setResponseId("responseId-633138884")
            .setQueryResult(QueryResult.newBuilder().build())
            .setOutputAudio(ByteString.EMPTY)
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();
    mockSessions.addResponse(expectedResponse);

    FulfillIntentRequest request =
        FulfillIntentRequest.newBuilder()
            .setMatchIntentRequest(MatchIntentRequest.newBuilder().build())
            .setMatch(Match.newBuilder().build())
            .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
            .build();

    FulfillIntentResponse actualResponse = client.fulfillIntent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FulfillIntentRequest actualRequest = ((FulfillIntentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getMatchIntentRequest(), actualRequest.getMatchIntentRequest());
    Assert.assertEquals(request.getMatch(), actualRequest.getMatch());
    Assert.assertEquals(request.getOutputAudioConfig(), actualRequest.getOutputAudioConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fulfillIntentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessions.addException(exception);

    try {
      FulfillIntentRequest request =
          FulfillIntentRequest.newBuilder()
              .setMatchIntentRequest(MatchIntentRequest.newBuilder().build())
              .setMatch(Match.newBuilder().build())
              .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
              .build();
      client.fulfillIntent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
