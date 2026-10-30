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

import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListAssistantSessionsPagedResponse;
import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AssistantServiceClientTest {
  private static MockAssistantService mockAssistantService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AssistantServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAssistantService = new MockAssistantService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAssistantService, mockLocations));
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
    AssistantServiceSettings settings =
        AssistantServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssistantServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAssistantSessionsTest() throws Exception {
    AssistantSession responsesElement = AssistantSession.newBuilder().build();
    ListAssistantSessionsResponse expectedResponse =
        ListAssistantSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistantSessions(Arrays.asList(responsesElement))
            .build();
    mockAssistantService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListAssistantSessionsPagedResponse pagedListResponse = client.listAssistantSessions(parent);

    List<AssistantSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssistantSessionsRequest actualRequest =
        ((ListAssistantSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssistantSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listAssistantSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssistantSessionsTest2() throws Exception {
    AssistantSession responsesElement = AssistantSession.newBuilder().build();
    ListAssistantSessionsResponse expectedResponse =
        ListAssistantSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssistantSessions(Arrays.asList(responsesElement))
            .build();
    mockAssistantService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssistantSessionsPagedResponse pagedListResponse = client.listAssistantSessions(parent);

    List<AssistantSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssistantSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssistantSessionsRequest actualRequest =
        ((ListAssistantSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssistantSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAssistantSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantSessionTest() throws Exception {
    AssistantSession expectedResponse =
        AssistantSession.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setRequestor("requestor693934258")
            .addAllMessages(new ArrayList<AssistantMessage>())
            .setState(AssistantSessionState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUserResponseSuggestions(UserResponseSuggestions.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .addAllArtifacts(new ArrayList<AssistantSessionArtifact>())
            .setSessionCheckpoint(SessionCheckpoint.newBuilder().build())
            .setActiveTurn(ActiveTurnInfo.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    AssistantSessionName name =
        AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");

    AssistantSession actualResponse = client.getAssistantSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssistantSessionRequest actualRequest = ((GetAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssistantSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AssistantSessionName name =
          AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");
      client.getAssistantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssistantSessionTest2() throws Exception {
    AssistantSession expectedResponse =
        AssistantSession.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setRequestor("requestor693934258")
            .addAllMessages(new ArrayList<AssistantMessage>())
            .setState(AssistantSessionState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUserResponseSuggestions(UserResponseSuggestions.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .addAllArtifacts(new ArrayList<AssistantSessionArtifact>())
            .setSessionCheckpoint(SessionCheckpoint.newBuilder().build())
            .setActiveTurn(ActiveTurnInfo.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    String name = "name3373707";

    AssistantSession actualResponse = client.getAssistantSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssistantSessionRequest actualRequest = ((GetAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssistantSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String name = "name3373707";
      client.getAssistantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssistantSessionTest() throws Exception {
    AssistantSession expectedResponse =
        AssistantSession.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setRequestor("requestor693934258")
            .addAllMessages(new ArrayList<AssistantMessage>())
            .setState(AssistantSessionState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUserResponseSuggestions(UserResponseSuggestions.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .addAllArtifacts(new ArrayList<AssistantSessionArtifact>())
            .setSessionCheckpoint(SessionCheckpoint.newBuilder().build())
            .setActiveTurn(ActiveTurnInfo.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    String assistantSessionId = "assistantSessionId-1566358253";

    AssistantSession actualResponse = client.createAssistantSession(parent, assistantSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssistantSessionRequest actualRequest =
        ((CreateAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(assistantSessionId, actualRequest.getAssistantSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssistantSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      String assistantSessionId = "assistantSessionId-1566358253";
      client.createAssistantSession(parent, assistantSessionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssistantSessionTest2() throws Exception {
    AssistantSession expectedResponse =
        AssistantSession.newBuilder()
            .setName(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setRequestor("requestor693934258")
            .addAllMessages(new ArrayList<AssistantMessage>())
            .setState(AssistantSessionState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUserResponseSuggestions(UserResponseSuggestions.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .addAllArtifacts(new ArrayList<AssistantSessionArtifact>())
            .setSessionCheckpoint(SessionCheckpoint.newBuilder().build())
            .setActiveTurn(ActiveTurnInfo.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String assistantSessionId = "assistantSessionId-1566358253";

    AssistantSession actualResponse = client.createAssistantSession(parent, assistantSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssistantSessionRequest actualRequest =
        ((CreateAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(assistantSessionId, actualRequest.getAssistantSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssistantSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String parent = "parent-995424086";
      String assistantSessionId = "assistantSessionId-1566358253";
      client.createAssistantSession(parent, assistantSessionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssistantService.addResponse(expectedResponse);

    AssistantSessionName name =
        AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");

    client.deleteAssistantSession(name);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssistantSessionRequest actualRequest =
        ((DeleteAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssistantSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      AssistantSessionName name =
          AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]");
      client.deleteAssistantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssistantSessionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssistantService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAssistantSession(name);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssistantSessionRequest actualRequest =
        ((DeleteAssistantSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssistantSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAssistantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runAssistantTest() throws Exception {
    RunAssistantResponse expectedResponse =
        RunAssistantResponse.newBuilder()
            .setOutput(AssistantOutput.newBuilder().build())
            .setState(AssistantSessionState.forNumber(0))
            .build();
    mockAssistantService.addResponse(expectedResponse);

    RunAssistantRequest request =
        RunAssistantRequest.newBuilder()
            .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setAssistantSession(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setMessage(AssistantMessage.newBuilder().build())
            .build();

    RunAssistantResponse actualResponse = client.runAssistant(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunAssistantRequest actualRequest = ((RunAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getApp(), actualRequest.getApp());
    Assert.assertEquals(request.getAssistantSession(), actualRequest.getAssistantSession());
    Assert.assertEquals(request.getMessage(), actualRequest.getMessage());
    Assert.assertEquals(request.getInteractionType(), actualRequest.getInteractionType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      RunAssistantRequest request =
          RunAssistantRequest.newBuilder()
              .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setAssistantSession(
                  AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                      .toString())
              .setMessage(AssistantMessage.newBuilder().build())
              .build();
      client.runAssistant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void chatAiAssistantTest() throws Exception {
    ChatAiAssistantResponse expectedResponse =
        ChatAiAssistantResponse.newBuilder()
            .setEventId("eventId-1376502443")
            .setEventTime(Timestamp.newBuilder().build())
            .setUiEvent(UiEvent.newBuilder().build())
            .build();
    mockAssistantService.addResponse(expectedResponse);

    ChatAiAssistantRequest request =
        ChatAiAssistantRequest.newBuilder()
            .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setAssistantSession(
                AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                    .toString())
            .setMessage("message954925063")
            .addAllAttachedGcsUris(new ArrayList<String>())
            .setContextToken("contextToken1106626954")
            .build();

    ChatAiAssistantResponse actualResponse = client.chatAiAssistant(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssistantService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ChatAiAssistantRequest actualRequest = ((ChatAiAssistantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getApp(), actualRequest.getApp());
    Assert.assertEquals(request.getAssistantSession(), actualRequest.getAssistantSession());
    Assert.assertEquals(request.getMessage(), actualRequest.getMessage());
    Assert.assertEquals(request.getAttachedGcsUrisList(), actualRequest.getAttachedGcsUrisList());
    Assert.assertEquals(request.getContextToken(), actualRequest.getContextToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void chatAiAssistantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssistantService.addException(exception);

    try {
      ChatAiAssistantRequest request =
          ChatAiAssistantRequest.newBuilder()
              .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setAssistantSession(
                  AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                      .toString())
              .setMessage("message954925063")
              .addAllAttachedGcsUris(new ArrayList<String>())
              .setContextToken("contextToken1106626954")
              .build();
      client.chatAiAssistant(request);
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
