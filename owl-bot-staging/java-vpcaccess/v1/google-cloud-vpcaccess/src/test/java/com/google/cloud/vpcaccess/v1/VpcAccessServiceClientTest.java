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

package com.google.cloud.vpcaccess.v1;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;
import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class VpcAccessServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVpcAccessService mockVpcAccessService;
  private LocalChannelProvider channelProvider;
  private VpcAccessServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVpcAccessService = new MockVpcAccessService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVpcAccessService, mockLocations));
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
    VpcAccessServiceSettings settings =
        VpcAccessServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VpcAccessServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
            .setNetwork("network1843485230")
            .setIpCidrRange("ipCidrRange-866375486")
            .setMinThroughput(2064735799)
            .setMaxThroughput(1407819749)
            .addAllConnectedProjects(new ArrayList<String>())
            .setSubnet(Connector.Subnet.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setMinInstances(1491624145)
            .setMaxInstances(-330682013)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcAccessService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String connectorId = "connectorId1724784200";
    Connector connector = Connector.newBuilder().build();

    Connector actualResponse = client.createConnectorAsync(parent, connectorId, connector).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectorRequest actualRequest = ((CreateConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connectorId, actualRequest.getConnectorId());
    Assert.assertEquals(connector, actualRequest.getConnector());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String connectorId = "connectorId1724784200";
      Connector connector = Connector.newBuilder().build();
      client.createConnectorAsync(parent, connectorId, connector).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConnectorTest2() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
            .setNetwork("network1843485230")
            .setIpCidrRange("ipCidrRange-866375486")
            .setMinThroughput(2064735799)
            .setMaxThroughput(1407819749)
            .addAllConnectedProjects(new ArrayList<String>())
            .setSubnet(Connector.Subnet.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setMinInstances(1491624145)
            .setMaxInstances(-330682013)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcAccessService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String connectorId = "connectorId1724784200";
    Connector connector = Connector.newBuilder().build();

    Connector actualResponse = client.createConnectorAsync(parent, connectorId, connector).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectorRequest actualRequest = ((CreateConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connectorId, actualRequest.getConnectorId());
    Assert.assertEquals(connector, actualRequest.getConnector());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      String parent = "parent-995424086";
      String connectorId = "connectorId1724784200";
      Connector connector = Connector.newBuilder().build();
      client.createConnectorAsync(parent, connectorId, connector).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
            .setNetwork("network1843485230")
            .setIpCidrRange("ipCidrRange-866375486")
            .setMinThroughput(2064735799)
            .setMaxThroughput(1407819749)
            .addAllConnectedProjects(new ArrayList<String>())
            .setSubnet(Connector.Subnet.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setMinInstances(1491624145)
            .setMaxInstances(-330682013)
            .build();
    mockVpcAccessService.addResponse(expectedResponse);

    ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectorRequest actualRequest = ((GetConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");
      client.getConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectorTest2() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]").toString())
            .setNetwork("network1843485230")
            .setIpCidrRange("ipCidrRange-866375486")
            .setMinThroughput(2064735799)
            .setMaxThroughput(1407819749)
            .addAllConnectedProjects(new ArrayList<String>())
            .setSubnet(Connector.Subnet.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setMinInstances(1491624145)
            .setMaxInstances(-330682013)
            .build();
    mockVpcAccessService.addResponse(expectedResponse);

    String name = "name3373707";

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectorRequest actualRequest = ((GetConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      String name = "name3373707";
      client.getConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectorsTest() throws Exception {
    Connector responsesElement = Connector.newBuilder().build();
    ListConnectorsResponse expectedResponse =
        ListConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectors(Arrays.asList(responsesElement))
            .build();
    mockVpcAccessService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectorsRequest actualRequest = ((ListConnectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectorsTest2() throws Exception {
    Connector responsesElement = Connector.newBuilder().build();
    ListConnectorsResponse expectedResponse =
        ListConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectors(Arrays.asList(responsesElement))
            .build();
    mockVpcAccessService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectorsRequest actualRequest = ((ListConnectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcAccessService.addResponse(resultOperation);

    ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");

    client.deleteConnectorAsync(name).get();

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectorRequest actualRequest = ((DeleteConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      ConnectorName name = ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECTOR]");
      client.deleteConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVpcAccessService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectorAsync(name).get();

    List<AbstractMessage> actualRequests = mockVpcAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectorRequest actualRequest = ((DeleteConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVpcAccessService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectorAsync(name).get();
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
}
