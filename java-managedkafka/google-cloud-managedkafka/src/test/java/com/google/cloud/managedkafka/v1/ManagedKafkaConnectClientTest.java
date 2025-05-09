/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.managedkafka.v1;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

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
public class ManagedKafkaConnectClientTest {
  private static MockLocations mockLocations;
  private static MockManagedKafkaConnect mockManagedKafkaConnect;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ManagedKafkaConnectClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockManagedKafkaConnect = new MockManagedKafkaConnect();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockManagedKafkaConnect, mockLocations));
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
    ManagedKafkaConnectSettings settings =
        ManagedKafkaConnectSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ManagedKafkaConnectClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConnectClustersTest() throws Exception {
    ConnectCluster responsesElement = ConnectCluster.newBuilder().build();
    ListConnectClustersResponse expectedResponse =
        ListConnectClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectClusters(Arrays.asList(responsesElement))
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectClustersPagedResponse pagedListResponse = client.listConnectClusters(parent);

    List<ConnectCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectClustersRequest actualRequest = ((ListConnectClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnectClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectClustersTest2() throws Exception {
    ConnectCluster responsesElement = ConnectCluster.newBuilder().build();
    ListConnectClustersResponse expectedResponse =
        ListConnectClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectClusters(Arrays.asList(responsesElement))
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectClustersPagedResponse pagedListResponse = client.listConnectClusters(parent);

    List<ConnectCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectClustersRequest actualRequest = ((ListConnectClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectClusterName name = ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    ConnectCluster actualResponse = client.getConnectCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectClusterRequest actualRequest = ((GetConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectClusterName name =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      client.getConnectCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectClusterTest2() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    ConnectCluster actualResponse = client.getConnectCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectClusterRequest actualRequest = ((GetConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.getConnectCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafkaConnect.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
    String connectClusterId = "connectClusterId-1562078485";

    ConnectCluster actualResponse =
        client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectClusterRequest actualRequest =
        ((CreateConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connectCluster, actualRequest.getConnectCluster());
    Assert.assertEquals(connectClusterId, actualRequest.getConnectClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
      String connectClusterId = "connectClusterId-1562078485";
      client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConnectClusterTest2() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafkaConnect.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
    String connectClusterId = "connectClusterId-1562078485";

    ConnectCluster actualResponse =
        client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectClusterRequest actualRequest =
        ((CreateConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connectCluster, actualRequest.getConnectCluster());
    Assert.assertEquals(connectClusterId, actualRequest.getConnectClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
      String connectClusterId = "connectClusterId-1562078485";
      client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafkaConnect.addResponse(resultOperation);

    ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConnectCluster actualResponse =
        client.updateConnectClusterAsync(connectCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectClusterRequest actualRequest =
        ((UpdateConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(connectCluster, actualRequest.getConnectCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectClusterAsync(connectCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafkaConnect.addResponse(resultOperation);

    ConnectClusterName name = ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    client.deleteConnectClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectClusterRequest actualRequest =
        ((DeleteConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectClusterName name =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      client.deleteConnectClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafkaConnect.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectClusterRequest actualRequest =
        ((DeleteConnectClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectClusterName parent =
        ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectClusterName parent =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
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
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
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
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.getConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectClusterName parent =
        ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
    Connector connector = Connector.newBuilder().build();
    String connectorId = "connectorId1724784200";

    Connector actualResponse = client.createConnector(parent, connector, connectorId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectorRequest actualRequest = ((CreateConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connector, actualRequest.getConnector());
    Assert.assertEquals(connectorId, actualRequest.getConnectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectClusterName parent =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      Connector connector = Connector.newBuilder().build();
      String connectorId = "connectorId1724784200";
      client.createConnector(parent, connector, connectorId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectorTest2() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Connector connector = Connector.newBuilder().build();
    String connectorId = "connectorId1724784200";

    Connector actualResponse = client.createConnector(parent, connector, connectorId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectorRequest actualRequest = ((CreateConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connector, actualRequest.getConnector());
    Assert.assertEquals(connectorId, actualRequest.getConnectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String parent = "parent-995424086";
      Connector connector = Connector.newBuilder().build();
      String connectorId = "connectorId1724784200";
      client.createConnector(parent, connector, connectorId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    Connector connector = Connector.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connector actualResponse = client.updateConnector(connector, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectorRequest actualRequest = ((UpdateConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(connector, actualRequest.getConnector());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      Connector connector = Connector.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnector(connector, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    client.deleteConnector(name);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.deleteConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConnector(name);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
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
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseConnectorTest() throws Exception {
    PauseConnectorResponse expectedResponse = PauseConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    PauseConnectorResponse actualResponse = client.pauseConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseConnectorRequest actualRequest = ((PauseConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.pauseConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseConnectorTest2() throws Exception {
    PauseConnectorResponse expectedResponse = PauseConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    PauseConnectorResponse actualResponse = client.pauseConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseConnectorRequest actualRequest = ((PauseConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.pauseConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeConnectorTest() throws Exception {
    ResumeConnectorResponse expectedResponse = ResumeConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    ResumeConnectorResponse actualResponse = client.resumeConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeConnectorRequest actualRequest = ((ResumeConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.resumeConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeConnectorTest2() throws Exception {
    ResumeConnectorResponse expectedResponse = ResumeConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    ResumeConnectorResponse actualResponse = client.resumeConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeConnectorRequest actualRequest = ((ResumeConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.resumeConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restartConnectorTest() throws Exception {
    RestartConnectorResponse expectedResponse = RestartConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    RestartConnectorResponse actualResponse = client.restartConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartConnectorRequest actualRequest = ((RestartConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.restartConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restartConnectorTest2() throws Exception {
    RestartConnectorResponse expectedResponse = RestartConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    RestartConnectorResponse actualResponse = client.restartConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartConnectorRequest actualRequest = ((RestartConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.restartConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopConnectorTest() throws Exception {
    StopConnectorResponse expectedResponse = StopConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    StopConnectorResponse actualResponse = client.stopConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopConnectorRequest actualRequest = ((StopConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopConnectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.stopConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopConnectorTest2() throws Exception {
    StopConnectorResponse expectedResponse = StopConnectorResponse.newBuilder().build();
    mockManagedKafkaConnect.addResponse(expectedResponse);

    String name = "name3373707";

    StopConnectorResponse actualResponse = client.stopConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafkaConnect.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopConnectorRequest actualRequest = ((StopConnectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopConnectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafkaConnect.addException(exception);

    try {
      String name = "name3373707";
      client.stopConnector(name);
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
