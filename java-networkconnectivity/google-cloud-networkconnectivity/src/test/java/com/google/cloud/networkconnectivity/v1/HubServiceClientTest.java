/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListGroupsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRouteTablesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListSpokesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class HubServiceClientTest {
  private static MockHubService mockHubService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HubServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHubService = new MockHubService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockHubService, mockLocations, mockIAMPolicy));
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
    HubServiceSettings settings =
        HubServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HubServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listHubsTest() throws Exception {
    Hub responsesElement = Hub.newBuilder().build();
    ListHubsResponse expectedResponse =
        ListHubsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHubs(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHubsPagedResponse pagedListResponse = client.listHubs(parent);

    List<Hub> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHubsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHubsRequest actualRequest = ((ListHubsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHubsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHubs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHubsTest2() throws Exception {
    Hub responsesElement = Hub.newBuilder().build();
    ListHubsResponse expectedResponse =
        ListHubsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHubs(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHubsPagedResponse pagedListResponse = client.listHubs(parent);

    List<Hub> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHubsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHubsRequest actualRequest = ((ListHubsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHubsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHubs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHubTest() throws Exception {
    Hub expectedResponse =
        Hub.newBuilder()
            .setName(HubName.of("[PROJECT]", "[HUB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllRoutingVpcs(new ArrayList<RoutingVPC>())
            .addAllRouteTables(new ArrayList<String>())
            .setSpokeSummary(SpokeSummary.newBuilder().build())
            .build();
    mockHubService.addResponse(expectedResponse);

    HubName name = HubName.of("[PROJECT]", "[HUB]");

    Hub actualResponse = client.getHub(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHubRequest actualRequest = ((GetHubRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHubExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      client.getHub(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHubTest2() throws Exception {
    Hub expectedResponse =
        Hub.newBuilder()
            .setName(HubName.of("[PROJECT]", "[HUB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllRoutingVpcs(new ArrayList<RoutingVPC>())
            .addAllRouteTables(new ArrayList<String>())
            .setSpokeSummary(SpokeSummary.newBuilder().build())
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Hub actualResponse = client.getHub(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHubRequest actualRequest = ((GetHubRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHubExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getHub(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHubTest() throws Exception {
    Hub expectedResponse =
        Hub.newBuilder()
            .setName(HubName.of("[PROJECT]", "[HUB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllRoutingVpcs(new ArrayList<RoutingVPC>())
            .addAllRouteTables(new ArrayList<String>())
            .setSpokeSummary(SpokeSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHubTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Hub hub = Hub.newBuilder().build();
    String hubId = "hubId99628272";

    Hub actualResponse = client.createHubAsync(parent, hub, hubId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHubRequest actualRequest = ((CreateHubRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hub, actualRequest.getHub());
    Assert.assertEquals(hubId, actualRequest.getHubId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHubExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Hub hub = Hub.newBuilder().build();
      String hubId = "hubId99628272";
      client.createHubAsync(parent, hub, hubId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHubTest2() throws Exception {
    Hub expectedResponse =
        Hub.newBuilder()
            .setName(HubName.of("[PROJECT]", "[HUB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllRoutingVpcs(new ArrayList<RoutingVPC>())
            .addAllRouteTables(new ArrayList<String>())
            .setSpokeSummary(SpokeSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHubTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Hub hub = Hub.newBuilder().build();
    String hubId = "hubId99628272";

    Hub actualResponse = client.createHubAsync(parent, hub, hubId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHubRequest actualRequest = ((CreateHubRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hub, actualRequest.getHub());
    Assert.assertEquals(hubId, actualRequest.getHubId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHubExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      Hub hub = Hub.newBuilder().build();
      String hubId = "hubId99628272";
      client.createHubAsync(parent, hub, hubId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateHubTest() throws Exception {
    Hub expectedResponse =
        Hub.newBuilder()
            .setName(HubName.of("[PROJECT]", "[HUB]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllRoutingVpcs(new ArrayList<RoutingVPC>())
            .addAllRouteTables(new ArrayList<String>())
            .setSpokeSummary(SpokeSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHubTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    Hub hub = Hub.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Hub actualResponse = client.updateHubAsync(hub, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHubRequest actualRequest = ((UpdateHubRequest) actualRequests.get(0));

    Assert.assertEquals(hub, actualRequest.getHub());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHubExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      Hub hub = Hub.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHubAsync(hub, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHubTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHubTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    HubName name = HubName.of("[PROJECT]", "[HUB]");

    client.deleteHubAsync(name).get();

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHubRequest actualRequest = ((DeleteHubRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHubExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      client.deleteHubAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHubTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHubTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHubAsync(name).get();

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHubRequest actualRequest = ((DeleteHubRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHubExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHubAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHubSpokesTest() throws Exception {
    Spoke responsesElement = Spoke.newBuilder().build();
    ListHubSpokesResponse expectedResponse =
        ListHubSpokesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpokes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    HubName name = HubName.of("[PROJECT]", "[HUB]");

    ListHubSpokesPagedResponse pagedListResponse = client.listHubSpokes(name);

    List<Spoke> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpokesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHubSpokesRequest actualRequest = ((ListHubSpokesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHubSpokesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      client.listHubSpokes(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHubSpokesTest2() throws Exception {
    Spoke responsesElement = Spoke.newBuilder().build();
    ListHubSpokesResponse expectedResponse =
        ListHubSpokesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpokes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    ListHubSpokesPagedResponse pagedListResponse = client.listHubSpokes(name);

    List<Spoke> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpokesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHubSpokesRequest actualRequest = ((ListHubSpokesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHubSpokesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.listHubSpokes(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpokesTest() throws Exception {
    Spoke responsesElement = Spoke.newBuilder().build();
    ListSpokesResponse expectedResponse =
        ListSpokesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpokes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSpokesPagedResponse pagedListResponse = client.listSpokes(parent);

    List<Spoke> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpokesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpokesRequest actualRequest = ((ListSpokesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpokesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSpokes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpokesTest2() throws Exception {
    Spoke responsesElement = Spoke.newBuilder().build();
    ListSpokesResponse expectedResponse =
        ListSpokesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpokes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSpokesPagedResponse pagedListResponse = client.listSpokes(parent);

    List<Spoke> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpokesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpokesRequest actualRequest = ((ListSpokesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpokesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSpokes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpokeTest() throws Exception {
    Spoke expectedResponse =
        Spoke.newBuilder()
            .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setHub(HubName.of("[PROJECT]", "[HUB]").toString())
            .setGroup(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setLinkedVpnTunnels(LinkedVpnTunnels.newBuilder().build())
            .setLinkedInterconnectAttachments(LinkedInterconnectAttachments.newBuilder().build())
            .setLinkedRouterApplianceInstances(LinkedRouterApplianceInstances.newBuilder().build())
            .setLinkedVpcNetwork(LinkedVpcNetwork.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllReasons(new ArrayList<Spoke.StateReason>())
            .setSpokeType(SpokeType.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    Spoke actualResponse = client.getSpoke(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpokeRequest actualRequest = ((GetSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.getSpoke(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpokeTest2() throws Exception {
    Spoke expectedResponse =
        Spoke.newBuilder()
            .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setHub(HubName.of("[PROJECT]", "[HUB]").toString())
            .setGroup(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setLinkedVpnTunnels(LinkedVpnTunnels.newBuilder().build())
            .setLinkedInterconnectAttachments(LinkedInterconnectAttachments.newBuilder().build())
            .setLinkedRouterApplianceInstances(LinkedRouterApplianceInstances.newBuilder().build())
            .setLinkedVpcNetwork(LinkedVpcNetwork.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllReasons(new ArrayList<Spoke.StateReason>())
            .setSpokeType(SpokeType.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Spoke actualResponse = client.getSpoke(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpokeRequest actualRequest = ((GetSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpokeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpoke(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpokeTest() throws Exception {
    Spoke expectedResponse =
        Spoke.newBuilder()
            .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setHub(HubName.of("[PROJECT]", "[HUB]").toString())
            .setGroup(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setLinkedVpnTunnels(LinkedVpnTunnels.newBuilder().build())
            .setLinkedInterconnectAttachments(LinkedInterconnectAttachments.newBuilder().build())
            .setLinkedRouterApplianceInstances(LinkedRouterApplianceInstances.newBuilder().build())
            .setLinkedVpcNetwork(LinkedVpcNetwork.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllReasons(new ArrayList<Spoke.StateReason>())
            .setSpokeType(SpokeType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Spoke spoke = Spoke.newBuilder().build();
    String spokeId = "spokeId-1998996281";

    Spoke actualResponse = client.createSpokeAsync(parent, spoke, spokeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpokeRequest actualRequest = ((CreateSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(spoke, actualRequest.getSpoke());
    Assert.assertEquals(spokeId, actualRequest.getSpokeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Spoke spoke = Spoke.newBuilder().build();
      String spokeId = "spokeId-1998996281";
      client.createSpokeAsync(parent, spoke, spokeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSpokeTest2() throws Exception {
    Spoke expectedResponse =
        Spoke.newBuilder()
            .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setHub(HubName.of("[PROJECT]", "[HUB]").toString())
            .setGroup(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setLinkedVpnTunnels(LinkedVpnTunnels.newBuilder().build())
            .setLinkedInterconnectAttachments(LinkedInterconnectAttachments.newBuilder().build())
            .setLinkedRouterApplianceInstances(LinkedRouterApplianceInstances.newBuilder().build())
            .setLinkedVpcNetwork(LinkedVpcNetwork.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllReasons(new ArrayList<Spoke.StateReason>())
            .setSpokeType(SpokeType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Spoke spoke = Spoke.newBuilder().build();
    String spokeId = "spokeId-1998996281";

    Spoke actualResponse = client.createSpokeAsync(parent, spoke, spokeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpokeRequest actualRequest = ((CreateSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(spoke, actualRequest.getSpoke());
    Assert.assertEquals(spokeId, actualRequest.getSpokeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpokeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      Spoke spoke = Spoke.newBuilder().build();
      String spokeId = "spokeId-1998996281";
      client.createSpokeAsync(parent, spoke, spokeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSpokeTest() throws Exception {
    Spoke expectedResponse =
        Spoke.newBuilder()
            .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setHub(HubName.of("[PROJECT]", "[HUB]").toString())
            .setGroup(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setLinkedVpnTunnels(LinkedVpnTunnels.newBuilder().build())
            .setLinkedInterconnectAttachments(LinkedInterconnectAttachments.newBuilder().build())
            .setLinkedRouterApplianceInstances(LinkedRouterApplianceInstances.newBuilder().build())
            .setLinkedVpcNetwork(LinkedVpcNetwork.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
            .addAllReasons(new ArrayList<Spoke.StateReason>())
            .setSpokeType(SpokeType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    Spoke spoke = Spoke.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Spoke actualResponse = client.updateSpokeAsync(spoke, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpokeRequest actualRequest = ((UpdateSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(spoke, actualRequest.getSpoke());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      Spoke spoke = Spoke.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpokeAsync(spoke, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rejectHubSpokeTest() throws Exception {
    RejectHubSpokeResponse expectedResponse =
        RejectHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rejectHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    HubName name = HubName.of("[PROJECT]", "[HUB]");
    SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    RejectHubSpokeResponse actualResponse = client.rejectHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectHubSpokeRequest actualRequest = ((RejectHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(spokeUri.toString(), actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectHubSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.rejectHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rejectHubSpokeTest2() throws Exception {
    RejectHubSpokeResponse expectedResponse =
        RejectHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rejectHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    HubName name = HubName.of("[PROJECT]", "[HUB]");
    String spokeUri = "spokeUri-1839330496";

    RejectHubSpokeResponse actualResponse = client.rejectHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectHubSpokeRequest actualRequest = ((RejectHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(spokeUri, actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectHubSpokeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      String spokeUri = "spokeUri-1839330496";
      client.rejectHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rejectHubSpokeTest3() throws Exception {
    RejectHubSpokeResponse expectedResponse =
        RejectHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rejectHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";
    SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    RejectHubSpokeResponse actualResponse = client.rejectHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectHubSpokeRequest actualRequest = ((RejectHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(spokeUri.toString(), actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectHubSpokeExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.rejectHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rejectHubSpokeTest4() throws Exception {
    RejectHubSpokeResponse expectedResponse =
        RejectHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rejectHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";
    String spokeUri = "spokeUri-1839330496";

    RejectHubSpokeResponse actualResponse = client.rejectHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectHubSpokeRequest actualRequest = ((RejectHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(spokeUri, actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectHubSpokeExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      String spokeUri = "spokeUri-1839330496";
      client.rejectHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void acceptHubSpokeTest() throws Exception {
    AcceptHubSpokeResponse expectedResponse =
        AcceptHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("acceptHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    HubName name = HubName.of("[PROJECT]", "[HUB]");
    SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    AcceptHubSpokeResponse actualResponse = client.acceptHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptHubSpokeRequest actualRequest = ((AcceptHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(spokeUri.toString(), actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptHubSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.acceptHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void acceptHubSpokeTest2() throws Exception {
    AcceptHubSpokeResponse expectedResponse =
        AcceptHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("acceptHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    HubName name = HubName.of("[PROJECT]", "[HUB]");
    String spokeUri = "spokeUri-1839330496";

    AcceptHubSpokeResponse actualResponse = client.acceptHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptHubSpokeRequest actualRequest = ((AcceptHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(spokeUri, actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptHubSpokeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      String spokeUri = "spokeUri-1839330496";
      client.acceptHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void acceptHubSpokeTest3() throws Exception {
    AcceptHubSpokeResponse expectedResponse =
        AcceptHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("acceptHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";
    SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    AcceptHubSpokeResponse actualResponse = client.acceptHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptHubSpokeRequest actualRequest = ((AcceptHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(spokeUri.toString(), actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptHubSpokeExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.acceptHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void acceptHubSpokeTest4() throws Exception {
    AcceptHubSpokeResponse expectedResponse =
        AcceptHubSpokeResponse.newBuilder().setSpoke(Spoke.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("acceptHubSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";
    String spokeUri = "spokeUri-1839330496";

    AcceptHubSpokeResponse actualResponse = client.acceptHubSpokeAsync(name, spokeUri).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptHubSpokeRequest actualRequest = ((AcceptHubSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(spokeUri, actualRequest.getSpokeUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptHubSpokeExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      String spokeUri = "spokeUri-1839330496";
      client.acceptHubSpokeAsync(name, spokeUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSpokeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");

    client.deleteSpokeAsync(name).get();

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpokeRequest actualRequest = ((DeleteSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpokeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
      client.deleteSpokeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSpokeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSpokeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockHubService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSpokeAsync(name).get();

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpokeRequest actualRequest = ((DeleteSpokeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpokeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSpokeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getRouteTableTest() throws Exception {
    RouteTable expectedResponse =
        RouteTable.newBuilder()
            .setName(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    RouteTableName name = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");

    RouteTable actualResponse = client.getRouteTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteTableRequest actualRequest = ((GetRouteTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      RouteTableName name = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");
      client.getRouteTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouteTableTest2() throws Exception {
    RouteTable expectedResponse =
        RouteTable.newBuilder()
            .setName(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    RouteTable actualResponse = client.getRouteTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteTableRequest actualRequest = ((GetRouteTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getRouteTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouteTest() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIpCidrRange("ipCidrRange-866375486")
            .setType(RouteType.forNumber(0))
            .setNextHopVpcNetwork(NextHopVpcNetwork.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .setSpoke(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setLocation("location1901043637")
            .build();
    mockHubService.addResponse(expectedResponse);

    HubRouteName name = HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]");

    Route actualResponse = client.getRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteRequest actualRequest = ((GetRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubRouteName name = HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]");
      client.getRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouteTest2() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIpCidrRange("ipCidrRange-866375486")
            .setType(RouteType.forNumber(0))
            .setNextHopVpcNetwork(NextHopVpcNetwork.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .setSpoke(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
            .setLocation("location1901043637")
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Route actualResponse = client.getRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteRequest actualRequest = ((GetRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoutesTest() throws Exception {
    Route responsesElement = Route.newBuilder().build();
    ListRoutesResponse expectedResponse =
        ListRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoutes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    RouteTableName parent = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");

    ListRoutesPagedResponse pagedListResponse = client.listRoutes(parent);

    List<Route> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutesRequest actualRequest = ((ListRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      RouteTableName parent = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");
      client.listRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoutesTest2() throws Exception {
    Route responsesElement = Route.newBuilder().build();
    ListRoutesResponse expectedResponse =
        ListRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoutes(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRoutesPagedResponse pagedListResponse = client.listRoutes(parent);

    List<Route> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutesRequest actualRequest = ((ListRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRouteTablesTest() throws Exception {
    RouteTable responsesElement = RouteTable.newBuilder().build();
    ListRouteTablesResponse expectedResponse =
        ListRouteTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRouteTables(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    HubName parent = HubName.of("[PROJECT]", "[HUB]");

    ListRouteTablesPagedResponse pagedListResponse = client.listRouteTables(parent);

    List<RouteTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRouteTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRouteTablesRequest actualRequest = ((ListRouteTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRouteTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName parent = HubName.of("[PROJECT]", "[HUB]");
      client.listRouteTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRouteTablesTest2() throws Exception {
    RouteTable responsesElement = RouteTable.newBuilder().build();
    ListRouteTablesResponse expectedResponse =
        ListRouteTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRouteTables(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRouteTablesPagedResponse pagedListResponse = client.listRouteTables(parent);

    List<RouteTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRouteTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRouteTablesRequest actualRequest = ((ListRouteTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRouteTablesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRouteTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    GroupName name = GroupName.of("[PROJECT]", "[HUB]", "[GROUP]");

    Group actualResponse = client.getGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = ((GetGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      GroupName name = GroupName.of("[PROJECT]", "[HUB]", "[GROUP]");
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setState(State.forNumber(0))
            .build();
    mockHubService.addResponse(expectedResponse);

    String name = "name3373707";

    Group actualResponse = client.getGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = ((GetGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String name = "name3373707";
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    HubName parent = HubName.of("[PROJECT]", "[HUB]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      HubName parent = HubName.of("[PROJECT]", "[HUB]");
      client.listGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest2() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockHubService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHubService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGroupsRequest actualRequest = ((ListGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHubService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGroups(parent);
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
