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

package com.google.cloud.networkconnectivity.v1alpha1;

import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListSpokesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HubServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHubService = new MockHubService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockHubService));
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
            .addAllSpokes(new ArrayList<String>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllSpokes(new ArrayList<String>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllSpokes(new ArrayList<String>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllSpokes(new ArrayList<String>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllSpokes(new ArrayList<String>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllLinkedVpnTunnels(new ArrayList<String>())
            .addAllLinkedInterconnectAttachments(new ArrayList<String>())
            .addAllLinkedRouterApplianceInstances(new ArrayList<RouterApplianceInstance>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllLinkedVpnTunnels(new ArrayList<String>())
            .addAllLinkedInterconnectAttachments(new ArrayList<String>())
            .addAllLinkedRouterApplianceInstances(new ArrayList<RouterApplianceInstance>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllLinkedVpnTunnels(new ArrayList<String>())
            .addAllLinkedInterconnectAttachments(new ArrayList<String>())
            .addAllLinkedRouterApplianceInstances(new ArrayList<RouterApplianceInstance>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllLinkedVpnTunnels(new ArrayList<String>())
            .addAllLinkedInterconnectAttachments(new ArrayList<String>())
            .addAllLinkedRouterApplianceInstances(new ArrayList<RouterApplianceInstance>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
            .addAllLinkedVpnTunnels(new ArrayList<String>())
            .addAllLinkedInterconnectAttachments(new ArrayList<String>())
            .addAllLinkedRouterApplianceInstances(new ArrayList<RouterApplianceInstance>())
            .setUniqueId("uniqueId-294460212")
            .setState(State.forNumber(0))
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
}
