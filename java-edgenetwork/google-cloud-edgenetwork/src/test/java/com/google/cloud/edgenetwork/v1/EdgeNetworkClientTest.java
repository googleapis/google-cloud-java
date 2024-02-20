/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.edgenetwork.v1;

import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

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
public class EdgeNetworkClientTest {
  private static MockEdgeNetwork mockEdgeNetwork;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EdgeNetworkClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEdgeNetwork = new MockEdgeNetwork();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEdgeNetwork, mockLocations));
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
    EdgeNetworkSettings settings =
        EdgeNetworkSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EdgeNetworkClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void initializeZoneTest() throws Exception {
    InitializeZoneResponse expectedResponse = InitializeZoneResponse.newBuilder().build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    InitializeZoneResponse actualResponse = client.initializeZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InitializeZoneRequest actualRequest = ((InitializeZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void initializeZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.initializeZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void initializeZoneTest2() throws Exception {
    InitializeZoneResponse expectedResponse = InitializeZoneResponse.newBuilder().build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    InitializeZoneResponse actualResponse = client.initializeZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InitializeZoneRequest actualRequest = ((InitializeZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void initializeZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.initializeZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZonesTest() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZonesTest2() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLayoutName("layoutName341460181")
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLayoutName("layoutName341460181")
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworksTest() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworksRequest actualRequest = ((ListNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworksTest2() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNetworksRequest actualRequest = ((ListNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNetworksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setMtu(108462)
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");

    Network actualResponse = client.getNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkRequest actualRequest = ((GetNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setMtu(108462)
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    Network actualResponse = client.getNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNetworkRequest actualRequest = ((GetNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseNetworkTest() throws Exception {
    DiagnoseNetworkResponse expectedResponse =
        DiagnoseNetworkResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(DiagnoseNetworkResponse.NetworkStatus.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");

    DiagnoseNetworkResponse actualResponse = client.diagnoseNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseNetworkRequest actualRequest = ((DiagnoseNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
      client.diagnoseNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseNetworkTest2() throws Exception {
    DiagnoseNetworkResponse expectedResponse =
        DiagnoseNetworkResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(DiagnoseNetworkResponse.NetworkStatus.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    DiagnoseNetworkResponse actualResponse = client.diagnoseNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseNetworkRequest actualRequest = ((DiagnoseNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.diagnoseNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setMtu(108462)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
    Network network = Network.newBuilder().build();
    String networkId = "networkId2062782441";

    Network actualResponse = client.createNetworkAsync(parent, network, networkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkRequest actualRequest = ((CreateNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(network, actualRequest.getNetwork());
    Assert.assertEquals(networkId, actualRequest.getNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      Network network = Network.newBuilder().build();
      String networkId = "networkId2062782441";
      client.createNetworkAsync(parent, network, networkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setMtu(108462)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String parent = "parent-995424086";
    Network network = Network.newBuilder().build();
    String networkId = "networkId2062782441";

    Network actualResponse = client.createNetworkAsync(parent, network, networkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNetworkRequest actualRequest = ((CreateNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(network, actualRequest.getNetwork());
    Assert.assertEquals(networkId, actualRequest.getNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      Network network = Network.newBuilder().build();
      String networkId = "networkId2062782441";
      client.createNetworkAsync(parent, network, networkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");

    client.deleteNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkRequest actualRequest = ((DeleteNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
      client.deleteNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNetworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNetworkRequest actualRequest = ((DeleteNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSubnetsTest() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubnetsRequest actualRequest = ((ListSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubnetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubnetsTest2() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubnetsRequest actualRequest = ((ListSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubnetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubnetTest() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllIpv4Cidr(new ArrayList<String>())
            .addAllIpv6Cidr(new ArrayList<String>())
            .setVlanId(536153463)
            .setState(ResourceState.forNumber(0))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");

    Subnet actualResponse = client.getSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubnetRequest actualRequest = ((GetSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");
      client.getSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubnetTest2() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllIpv4Cidr(new ArrayList<String>())
            .addAllIpv6Cidr(new ArrayList<String>())
            .setVlanId(536153463)
            .setState(ResourceState.forNumber(0))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    Subnet actualResponse = client.getSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSubnetRequest actualRequest = ((GetSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubnetTest() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllIpv4Cidr(new ArrayList<String>())
            .addAllIpv6Cidr(new ArrayList<String>())
            .setVlanId(536153463)
            .setState(ResourceState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
    Subnet subnet = Subnet.newBuilder().build();
    String subnetId = "subnetId-2066159272";

    Subnet actualResponse = client.createSubnetAsync(parent, subnet, subnetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubnetRequest actualRequest = ((CreateSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(subnet, actualRequest.getSubnet());
    Assert.assertEquals(subnetId, actualRequest.getSubnetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      Subnet subnet = Subnet.newBuilder().build();
      String subnetId = "subnetId-2066159272";
      client.createSubnetAsync(parent, subnet, subnetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSubnetTest2() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllIpv4Cidr(new ArrayList<String>())
            .addAllIpv6Cidr(new ArrayList<String>())
            .setVlanId(536153463)
            .setState(ResourceState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String parent = "parent-995424086";
    Subnet subnet = Subnet.newBuilder().build();
    String subnetId = "subnetId-2066159272";

    Subnet actualResponse = client.createSubnetAsync(parent, subnet, subnetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSubnetRequest actualRequest = ((CreateSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(subnet, actualRequest.getSubnet());
    Assert.assertEquals(subnetId, actualRequest.getSubnetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      Subnet subnet = Subnet.newBuilder().build();
      String subnetId = "subnetId-2066159272";
      client.createSubnetAsync(parent, subnet, subnetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSubnetTest() throws Exception {
    Subnet expectedResponse =
        Subnet.newBuilder()
            .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllIpv4Cidr(new ArrayList<String>())
            .addAllIpv6Cidr(new ArrayList<String>())
            .setVlanId(536153463)
            .setState(ResourceState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    Subnet subnet = Subnet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subnet actualResponse = client.updateSubnetAsync(subnet, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSubnetRequest actualRequest = ((UpdateSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(subnet, actualRequest.getSubnet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      Subnet subnet = Subnet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubnetAsync(subnet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubnetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");

    client.deleteSubnetAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubnetRequest actualRequest = ((DeleteSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");
      client.deleteSubnetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSubnetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSubnetAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSubnetRequest actualRequest = ((DeleteSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSubnetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInterconnectsTest() throws Exception {
    Interconnect responsesElement = Interconnect.newBuilder().build();
    ListInterconnectsResponse expectedResponse =
        ListInterconnectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterconnects(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    ListInterconnectsPagedResponse pagedListResponse = client.listInterconnects(parent);

    List<Interconnect> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterconnectsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterconnectsRequest actualRequest = ((ListInterconnectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterconnectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.listInterconnects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterconnectsTest2() throws Exception {
    Interconnect responsesElement = Interconnect.newBuilder().build();
    ListInterconnectsResponse expectedResponse =
        ListInterconnectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterconnects(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterconnectsPagedResponse pagedListResponse = client.listInterconnects(parent);

    List<Interconnect> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterconnectsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterconnectsRequest actualRequest = ((ListInterconnectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterconnectsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterconnects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterconnectTest() throws Exception {
    Interconnect expectedResponse =
        Interconnect.newBuilder()
            .setName(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setDeviceCloudResourceName("deviceCloudResourceName-1996267816")
            .addAllPhysicalPorts(new ArrayList<String>())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    InterconnectName name =
        InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");

    Interconnect actualResponse = client.getInterconnect(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterconnectRequest actualRequest = ((GetInterconnectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterconnectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      InterconnectName name =
          InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");
      client.getInterconnect(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterconnectTest2() throws Exception {
    Interconnect expectedResponse =
        Interconnect.newBuilder()
            .setName(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setDeviceCloudResourceName("deviceCloudResourceName-1996267816")
            .addAllPhysicalPorts(new ArrayList<String>())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    Interconnect actualResponse = client.getInterconnect(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterconnectRequest actualRequest = ((GetInterconnectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterconnectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getInterconnect(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseInterconnectTest() throws Exception {
    DiagnoseInterconnectResponse expectedResponse =
        DiagnoseInterconnectResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(InterconnectDiagnostics.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    InterconnectName name =
        InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");

    DiagnoseInterconnectResponse actualResponse = client.diagnoseInterconnect(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseInterconnectRequest actualRequest =
        ((DiagnoseInterconnectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseInterconnectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      InterconnectName name =
          InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");
      client.diagnoseInterconnect(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseInterconnectTest2() throws Exception {
    DiagnoseInterconnectResponse expectedResponse =
        DiagnoseInterconnectResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(InterconnectDiagnostics.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    DiagnoseInterconnectResponse actualResponse = client.diagnoseInterconnect(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseInterconnectRequest actualRequest =
        ((DiagnoseInterconnectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseInterconnectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.diagnoseInterconnect(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterconnectAttachmentsTest() throws Exception {
    InterconnectAttachment responsesElement = InterconnectAttachment.newBuilder().build();
    ListInterconnectAttachmentsResponse expectedResponse =
        ListInterconnectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterconnectAttachments(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    ListInterconnectAttachmentsPagedResponse pagedListResponse =
        client.listInterconnectAttachments(parent);

    List<InterconnectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterconnectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterconnectAttachmentsRequest actualRequest =
        ((ListInterconnectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterconnectAttachmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.listInterconnectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInterconnectAttachmentsTest2() throws Exception {
    InterconnectAttachment responsesElement = InterconnectAttachment.newBuilder().build();
    ListInterconnectAttachmentsResponse expectedResponse =
        ListInterconnectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInterconnectAttachments(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInterconnectAttachmentsPagedResponse pagedListResponse =
        client.listInterconnectAttachments(parent);

    List<InterconnectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInterconnectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInterconnectAttachmentsRequest actualRequest =
        ((ListInterconnectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInterconnectAttachmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInterconnectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterconnectAttachmentTest() throws Exception {
    InterconnectAttachment expectedResponse =
        InterconnectAttachment.newBuilder()
            .setName(
                InterconnectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterconnect(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setVlanId(536153463)
            .setMtu(108462)
            .setState(ResourceState.forNumber(0))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    InterconnectAttachmentName name =
        InterconnectAttachmentName.of(
            "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");

    InterconnectAttachment actualResponse = client.getInterconnectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterconnectAttachmentRequest actualRequest =
        ((GetInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterconnectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      InterconnectAttachmentName name =
          InterconnectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");
      client.getInterconnectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInterconnectAttachmentTest2() throws Exception {
    InterconnectAttachment expectedResponse =
        InterconnectAttachment.newBuilder()
            .setName(
                InterconnectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterconnect(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setVlanId(536153463)
            .setMtu(108462)
            .setState(ResourceState.forNumber(0))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    InterconnectAttachment actualResponse = client.getInterconnectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInterconnectAttachmentRequest actualRequest =
        ((GetInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInterconnectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getInterconnectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInterconnectAttachmentTest() throws Exception {
    InterconnectAttachment expectedResponse =
        InterconnectAttachment.newBuilder()
            .setName(
                InterconnectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterconnect(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setVlanId(536153463)
            .setMtu(108462)
            .setState(ResourceState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterconnectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
    InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
    String interconnectAttachmentId = "interconnectAttachmentId1053538636";

    InterconnectAttachment actualResponse =
        client
            .createInterconnectAttachmentAsync(
                parent, interconnectAttachment, interconnectAttachmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterconnectAttachmentRequest actualRequest =
        ((CreateInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(interconnectAttachment, actualRequest.getInterconnectAttachment());
    Assert.assertEquals(interconnectAttachmentId, actualRequest.getInterconnectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterconnectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
      String interconnectAttachmentId = "interconnectAttachmentId1053538636";
      client
          .createInterconnectAttachmentAsync(
              parent, interconnectAttachment, interconnectAttachmentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInterconnectAttachmentTest2() throws Exception {
    InterconnectAttachment expectedResponse =
        InterconnectAttachment.newBuilder()
            .setName(
                InterconnectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterconnect(
                InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
                    .toString())
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .setVlanId(536153463)
            .setMtu(108462)
            .setState(ResourceState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInterconnectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String parent = "parent-995424086";
    InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
    String interconnectAttachmentId = "interconnectAttachmentId1053538636";

    InterconnectAttachment actualResponse =
        client
            .createInterconnectAttachmentAsync(
                parent, interconnectAttachment, interconnectAttachmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInterconnectAttachmentRequest actualRequest =
        ((CreateInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(interconnectAttachment, actualRequest.getInterconnectAttachment());
    Assert.assertEquals(interconnectAttachmentId, actualRequest.getInterconnectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInterconnectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
      String interconnectAttachmentId = "interconnectAttachmentId1053538636";
      client
          .createInterconnectAttachmentAsync(
              parent, interconnectAttachment, interconnectAttachmentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterconnectAttachmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterconnectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    InterconnectAttachmentName name =
        InterconnectAttachmentName.of(
            "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");

    client.deleteInterconnectAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterconnectAttachmentRequest actualRequest =
        ((DeleteInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterconnectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      InterconnectAttachmentName name =
          InterconnectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");
      client.deleteInterconnectAttachmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInterconnectAttachmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInterconnectAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInterconnectAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInterconnectAttachmentRequest actualRequest =
        ((DeleteInterconnectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInterconnectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInterconnectAttachmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRoutersTest() throws Exception {
    Router responsesElement = Router.newBuilder().build();
    ListRoutersResponse expectedResponse =
        ListRoutersResponse.newBuilder()
            .setNextPageToken("")
            .addAllRouters(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    ListRoutersPagedResponse pagedListResponse = client.listRouters(parent);

    List<Router> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutersRequest actualRequest = ((ListRoutersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.listRouters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoutersTest2() throws Exception {
    Router responsesElement = Router.newBuilder().build();
    ListRoutersResponse expectedResponse =
        ListRoutersResponse.newBuilder()
            .setNextPageToken("")
            .addAllRouters(Arrays.asList(responsesElement))
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRoutersPagedResponse pagedListResponse = client.listRouters(parent);

    List<Router> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutersRequest actualRequest = ((ListRoutersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRouters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouterTest() throws Exception {
    Router expectedResponse =
        Router.newBuilder()
            .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllInterface(new ArrayList<Router.Interface>())
            .addAllBgpPeer(new ArrayList<Router.BgpPeer>())
            .setBgp(Router.Bgp.newBuilder().build())
            .setState(ResourceState.forNumber(0))
            .addAllRouteAdvertisements(new ArrayList<String>())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");

    Router actualResponse = client.getRouter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouterRequest actualRequest = ((GetRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
      client.getRouter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouterTest2() throws Exception {
    Router expectedResponse =
        Router.newBuilder()
            .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllInterface(new ArrayList<Router.Interface>())
            .addAllBgpPeer(new ArrayList<Router.BgpPeer>())
            .setBgp(Router.Bgp.newBuilder().build())
            .setState(ResourceState.forNumber(0))
            .addAllRouteAdvertisements(new ArrayList<String>())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    Router actualResponse = client.getRouter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouterRequest actualRequest = ((GetRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.getRouter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseRouterTest() throws Exception {
    DiagnoseRouterResponse expectedResponse =
        DiagnoseRouterResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(RouterStatus.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");

    DiagnoseRouterResponse actualResponse = client.diagnoseRouter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseRouterRequest actualRequest = ((DiagnoseRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseRouterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
      client.diagnoseRouter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseRouterTest2() throws Exception {
    DiagnoseRouterResponse expectedResponse =
        DiagnoseRouterResponse.newBuilder()
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResult(RouterStatus.newBuilder().build())
            .build();
    mockEdgeNetwork.addResponse(expectedResponse);

    String name = "name3373707";

    DiagnoseRouterResponse actualResponse = client.diagnoseRouter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseRouterRequest actualRequest = ((DiagnoseRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseRouterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.diagnoseRouter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRouterTest() throws Exception {
    Router expectedResponse =
        Router.newBuilder()
            .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllInterface(new ArrayList<Router.Interface>())
            .addAllBgpPeer(new ArrayList<Router.BgpPeer>())
            .setBgp(Router.Bgp.newBuilder().build())
            .setState(ResourceState.forNumber(0))
            .addAllRouteAdvertisements(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRouterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
    Router router = Router.newBuilder().build();
    String routerId = "routerId5435972";

    Router actualResponse = client.createRouterAsync(parent, router, routerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRouterRequest actualRequest = ((CreateRouterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(router, actualRequest.getRouter());
    Assert.assertEquals(routerId, actualRequest.getRouterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRouterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      Router router = Router.newBuilder().build();
      String routerId = "routerId5435972";
      client.createRouterAsync(parent, router, routerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRouterTest2() throws Exception {
    Router expectedResponse =
        Router.newBuilder()
            .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllInterface(new ArrayList<Router.Interface>())
            .addAllBgpPeer(new ArrayList<Router.BgpPeer>())
            .setBgp(Router.Bgp.newBuilder().build())
            .setState(ResourceState.forNumber(0))
            .addAllRouteAdvertisements(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRouterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String parent = "parent-995424086";
    Router router = Router.newBuilder().build();
    String routerId = "routerId5435972";

    Router actualResponse = client.createRouterAsync(parent, router, routerId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRouterRequest actualRequest = ((CreateRouterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(router, actualRequest.getRouter());
    Assert.assertEquals(routerId, actualRequest.getRouterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRouterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String parent = "parent-995424086";
      Router router = Router.newBuilder().build();
      String routerId = "routerId5435972";
      client.createRouterAsync(parent, router, routerId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRouterTest() throws Exception {
    Router expectedResponse =
        Router.newBuilder()
            .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
            .addAllInterface(new ArrayList<Router.Interface>())
            .addAllBgpPeer(new ArrayList<Router.BgpPeer>())
            .setBgp(Router.Bgp.newBuilder().build())
            .setState(ResourceState.forNumber(0))
            .addAllRouteAdvertisements(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRouterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    Router router = Router.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Router actualResponse = client.updateRouterAsync(router, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRouterRequest actualRequest = ((UpdateRouterRequest) actualRequests.get(0));

    Assert.assertEquals(router, actualRequest.getRouter());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRouterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      Router router = Router.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRouterAsync(router, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRouterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRouterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");

    client.deleteRouterAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRouterRequest actualRequest = ((DeleteRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRouterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
      client.deleteRouterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRouterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRouterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeNetwork.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRouterAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeNetwork.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRouterRequest actualRequest = ((DeleteRouterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRouterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeNetwork.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRouterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
