/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import static com.google.cloud.ces.v1beta.SessionServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class SessionServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSessionService mockSessionService;
  private LocalChannelProvider channelProvider;
  private SessionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSessionService = new MockSessionService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSessionService, mockLocations));
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
    SessionServiceSettings settings =
        SessionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void runSessionTest() throws Exception {
    RunSessionResponse expectedResponse =
        RunSessionResponse.newBuilder().addAllOutputs(new ArrayList<SessionOutput>()).build();
    mockSessionService.addResponse(expectedResponse);

    RunSessionRequest request =
        RunSessionRequest.newBuilder()
            .setConfig(SessionConfig.newBuilder().build())
            .addAllInputs(new ArrayList<SessionInput>())
            .build();

    RunSessionResponse actualResponse = client.runSession(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunSessionRequest actualRequest = ((RunSessionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getConfig(), actualRequest.getConfig());
    Assert.assertEquals(request.getInputsList(), actualRequest.getInputsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);

    try {
      RunSessionRequest request =
          RunSessionRequest.newBuilder()
              .setConfig(SessionConfig.newBuilder().build())
              .addAllInputs(new ArrayList<SessionInput>())
              .build();
      client.runSession(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamRunSessionTest() throws Exception {
    RunSessionResponse expectedResponse =
        RunSessionResponse.newBuilder().addAllOutputs(new ArrayList<SessionOutput>()).build();
    mockSessionService.addResponse(expectedResponse);
    RunSessionRequest request =
        RunSessionRequest.newBuilder()
            .setConfig(SessionConfig.newBuilder().build())
            .addAllInputs(new ArrayList<SessionInput>())
            .build();

    MockStreamObserver<RunSessionResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunSessionRequest, RunSessionResponse> callable =
        client.streamRunSessionCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<RunSessionResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamRunSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);
    RunSessionRequest request =
        RunSessionRequest.newBuilder()
            .setConfig(SessionConfig.newBuilder().build())
            .addAllInputs(new ArrayList<SessionInput>())
            .build();

    MockStreamObserver<RunSessionResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<RunSessionRequest, RunSessionResponse> callable =
        client.streamRunSessionCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<RunSessionResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void bidiRunSessionTest() throws Exception {
    BidiSessionServerMessage expectedResponse = BidiSessionServerMessage.newBuilder().build();
    mockSessionService.addResponse(expectedResponse);
    BidiSessionClientMessage request = BidiSessionClientMessage.newBuilder().build();

    MockStreamObserver<BidiSessionServerMessage> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<BidiSessionClientMessage, BidiSessionServerMessage> callable =
        client.bidiRunSessionCallable();
    ApiStreamObserver<BidiSessionClientMessage> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<BidiSessionServerMessage> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void bidiRunSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);
    BidiSessionClientMessage request = BidiSessionClientMessage.newBuilder().build();

    MockStreamObserver<BidiSessionServerMessage> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<BidiSessionClientMessage, BidiSessionServerMessage> callable =
        client.bidiRunSessionCallable();
    ApiStreamObserver<BidiSessionClientMessage> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<BidiSessionServerMessage> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamChatAiAssistantTest() throws Exception {
    StreamChatAiAssistantResponse expectedResponse =
        StreamChatAiAssistantResponse.newBuilder()
            .setEventId("eventId-1376502443")
            .setEventTime(Timestamp.newBuilder().build())
            .setUiEvent(UiEvent.newBuilder().build())
            .setTurnMetadata(TurnMetadata.newBuilder().build())
            .setSequenceNumber(-1309190777)
            .setTurnInProgress(true)
            .build();
    mockSessionService.addResponse(expectedResponse);
    StreamChatAiAssistantRequest request =
        StreamChatAiAssistantRequest.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setMessage("message954925063")
            .addAllAttachedGcsUris(new ArrayList<String>())
            .setContextToken("contextToken1106626954")
            .setConfirmationResponse(AssistantConfirmationResponse.newBuilder().build())
            .addAllClientCapabilities(
                new ArrayList<StreamChatAiAssistantRequest.ClientCapability>())
            .setOperationCompletedEvent(OperationCompletedEvent.newBuilder().build())
            .setResumeFromSequenceNumber(15486916)
            .setAttachOnly(true)
            .build();

    MockStreamObserver<StreamChatAiAssistantResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamChatAiAssistantRequest, StreamChatAiAssistantResponse> callable =
        client.streamChatAiAssistantCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<StreamChatAiAssistantResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamChatAiAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);
    StreamChatAiAssistantRequest request =
        StreamChatAiAssistantRequest.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setMessage("message954925063")
            .addAllAttachedGcsUris(new ArrayList<String>())
            .setContextToken("contextToken1106626954")
            .setConfirmationResponse(AssistantConfirmationResponse.newBuilder().build())
            .addAllClientCapabilities(
                new ArrayList<StreamChatAiAssistantRequest.ClientCapability>())
            .setOperationCompletedEvent(OperationCompletedEvent.newBuilder().build())
            .setResumeFromSequenceNumber(15486916)
            .setAttachOnly(true)
            .build();

    MockStreamObserver<StreamChatAiAssistantResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamChatAiAssistantRequest, StreamChatAiAssistantResponse> callable =
        client.streamChatAiAssistantCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<StreamChatAiAssistantResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelAssistantTurnTest() throws Exception {
    CancelAssistantTurnResponse expectedResponse =
        CancelAssistantTurnResponse.newBuilder().setCancelled(true).build();
    mockSessionService.addResponse(expectedResponse);

    CancelAssistantTurnRequest request =
        CancelAssistantTurnRequest.newBuilder()
            .setName("name3373707")
            .setTurnId("turnId-862429576")
            .build();

    CancelAssistantTurnResponse actualResponse = client.cancelAssistantTurn(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelAssistantTurnRequest actualRequest = ((CancelAssistantTurnRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTurnId(), actualRequest.getTurnId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelAssistantTurnExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);

    try {
      CancelAssistantTurnRequest request =
          CancelAssistantTurnRequest.newBuilder()
              .setName("name3373707")
              .setTurnId("turnId-862429576")
              .build();
      client.cancelAssistantTurn(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateOnboardingSuggestionsTest() throws Exception {
    GenerateOnboardingSuggestionsResponse expectedResponse =
        GenerateOnboardingSuggestionsResponse.newBuilder()
            .addAllSuggestions(new ArrayList<AssistantSuggestion>())
            .setContextToken("contextToken1106626954")
            .build();
    mockSessionService.addResponse(expectedResponse);

    GenerateOnboardingSuggestionsRequest request =
        GenerateOnboardingSuggestionsRequest.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setMaxSuggestions(618824852)
            .build();

    GenerateOnboardingSuggestionsResponse actualResponse =
        client.generateOnboardingSuggestions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateOnboardingSuggestionsRequest actualRequest =
        ((GenerateOnboardingSuggestionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getMaxSuggestions(), actualRequest.getMaxSuggestions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateOnboardingSuggestionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionService.addException(exception);

    try {
      GenerateOnboardingSuggestionsRequest request =
          GenerateOnboardingSuggestionsRequest.newBuilder()
              .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setMaxSuggestions(618824852)
              .build();
      client.generateOnboardingSuggestions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
