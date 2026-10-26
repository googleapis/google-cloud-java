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

package com.google.cloud.geminidataanalytics.v1beta;

import static com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
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
import com.google.protobuf.Struct;
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
public class DataA2AServiceClientTest {
  private static MockDataA2AService mockDataA2AService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataA2AServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataA2AService = new MockDataA2AService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataA2AService, mockLocations));
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
    DataA2AServiceSettings settings =
        DataA2AServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataA2AServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void sendMessageTest() throws Exception {
    SendMessageResponse expectedResponse = SendMessageResponse.newBuilder().build();
    mockDataA2AService.addResponse(expectedResponse);

    String tenant = "tenant-877336406";
    A2AMessage message = A2AMessage.newBuilder().build();

    SendMessageResponse actualResponse = client.sendMessage(tenant, message);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataA2AService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendMessageRequest actualRequest = ((SendMessageRequest) actualRequests.get(0));

    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertEquals(message, actualRequest.getMessage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataA2AService.addException(exception);

    try {
      String tenant = "tenant-877336406";
      A2AMessage message = A2AMessage.newBuilder().build();
      client.sendMessage(tenant, message);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendStreamingMessageTest() throws Exception {
    StreamResponse expectedResponse = StreamResponse.newBuilder().build();
    mockDataA2AService.addResponse(expectedResponse);
    SendMessageRequest request =
        SendMessageRequest.newBuilder()
            .setMessage(A2AMessage.newBuilder().build())
            .setConfiguration(SendMessageConfiguration.newBuilder().build())
            .setMetadata(Struct.newBuilder().build())
            .setTenant("tenant-877336406")
            .build();

    MockStreamObserver<StreamResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SendMessageRequest, StreamResponse> callable =
        client.sendStreamingMessageCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<StreamResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void sendStreamingMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataA2AService.addException(exception);
    SendMessageRequest request =
        SendMessageRequest.newBuilder()
            .setMessage(A2AMessage.newBuilder().build())
            .setConfiguration(SendMessageConfiguration.newBuilder().build())
            .setMetadata(Struct.newBuilder().build())
            .setTenant("tenant-877336406")
            .build();

    MockStreamObserver<StreamResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SendMessageRequest, StreamResponse> callable =
        client.sendStreamingMessageCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<StreamResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAgentCardTest() throws Exception {
    AgentCard expectedResponse =
        AgentCard.newBuilder()
            .setProtocolVersion("protocolVersion1752828704")
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setUrl("url116079")
            .setPreferredTransport("preferredTransport1485147048")
            .addAllAdditionalInterfaces(new ArrayList<AgentInterface>())
            .setProvider(AgentProvider.newBuilder().build())
            .setVersion("version351608024")
            .setDocumentationUrl("documentationUrl-1487620011")
            .setCapabilities(AgentCapabilities.newBuilder().build())
            .putAllSecuritySchemes(new HashMap<String, SecurityScheme>())
            .addAllSecurity(new ArrayList<Security>())
            .addAllDefaultInputModes(new ArrayList<String>())
            .addAllDefaultOutputModes(new ArrayList<String>())
            .addAllSkills(new ArrayList<AgentSkill>())
            .setSupportsAuthenticatedExtendedCard(true)
            .addAllSignatures(new ArrayList<AgentCardSignature>())
            .setIconUrl("iconUrl1638765110")
            .build();
    mockDataA2AService.addResponse(expectedResponse);

    String tenant = "tenant-877336406";

    AgentCard actualResponse = client.getAgentCard(tenant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataA2AService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentCardRequest actualRequest = ((GetAgentCardRequest) actualRequests.get(0));

    Assert.assertEquals(tenant, actualRequest.getTenant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentCardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataA2AService.addException(exception);

    try {
      String tenant = "tenant-877336406";
      client.getAgentCard(tenant);
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
