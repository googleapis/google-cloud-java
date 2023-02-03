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

package com.google.cloud.edgecontainer.v1;

import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListClustersPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListMachinesPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListNodePoolsPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListVpnConnectionsPagedResponse;

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
public class EdgeContainerClientTest {
  private static MockEdgeContainer mockEdgeContainer;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EdgeContainerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEdgeContainer = new MockEdgeContainer();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockEdgeContainer));
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
    EdgeContainerSettings settings =
        EdgeContainerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EdgeContainerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listClustersTest() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest2() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFleet(Fleet.newBuilder().build())
            .setNetworking(ClusterNetworking.newBuilder().build())
            .setAuthorization(Authorization.newBuilder().build())
            .setDefaultMaxPodsPerNode(-1433236452)
            .setEndpoint("endpoint1741102485")
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFleet(Fleet.newBuilder().build())
            .setNetworking(ClusterNetworking.newBuilder().build())
            .setAuthorization(Authorization.newBuilder().build())
            .setDefaultMaxPodsPerNode(-1433236452)
            .setEndpoint("endpoint1741102485")
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFleet(Fleet.newBuilder().build())
            .setNetworking(ClusterNetworking.newBuilder().build())
            .setAuthorization(Authorization.newBuilder().build())
            .setDefaultMaxPodsPerNode(-1433236452)
            .setEndpoint("endpoint1741102485")
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFleet(Fleet.newBuilder().build())
            .setNetworking(ClusterNetworking.newBuilder().build())
            .setAuthorization(Authorization.newBuilder().build())
            .setDefaultMaxPodsPerNode(-1433236452)
            .setEndpoint("endpoint1741102485")
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String parent = "parent-995424086";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFleet(Fleet.newBuilder().build())
            .setNetworking(ClusterNetworking.newBuilder().build())
            .setAuthorization(Authorization.newBuilder().build())
            .setDefaultMaxPodsPerNode(-1433236452)
            .setEndpoint("endpoint1741102485")
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClusterRequest actualRequest = ((UpdateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateAccessTokenTest() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    ClusterName cluster = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(cluster.toString(), actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      ClusterName cluster = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.generateAccessToken(cluster);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAccessTokenTest2() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String cluster = "cluster872092154";

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String cluster = "cluster872092154";
      client.generateAccessToken(cluster);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodePoolsTest() throws Exception {
    NodePool responsesElement = NodePool.newBuilder().build();
    ListNodePoolsResponse expectedResponse =
        ListNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodePools(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListNodePoolsPagedResponse pagedListResponse = client.listNodePools(parent);

    List<NodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodePoolsRequest actualRequest = ((ListNodePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodePoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodePoolsTest2() throws Exception {
    NodePool responsesElement = NodePool.newBuilder().build();
    ListNodePoolsResponse expectedResponse =
        ListNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodePools(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNodePoolsPagedResponse pagedListResponse = client.listNodePools(parent);

    List<NodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodePoolsRequest actualRequest = ((ListNodePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodePoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodePoolTest() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName(
                NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNodeLocation("nodeLocation1045991383")
            .setNodeCount(1539922066)
            .setMachineFilter("machineFilter427190943")
            .setLocalDiskEncryption(NodePool.LocalDiskEncryption.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");

    NodePool actualResponse = client.getNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodePoolRequest actualRequest = ((GetNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
      client.getNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodePoolTest2() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName(
                NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNodeLocation("nodeLocation1045991383")
            .setNodeCount(1539922066)
            .setMachineFilter("machineFilter427190943")
            .setLocalDiskEncryption(NodePool.LocalDiskEncryption.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String name = "name3373707";

    NodePool actualResponse = client.getNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodePoolRequest actualRequest = ((GetNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.getNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNodePoolTest() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName(
                NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNodeLocation("nodeLocation1045991383")
            .setNodeCount(1539922066)
            .setMachineFilter("machineFilter427190943")
            .setLocalDiskEncryption(NodePool.LocalDiskEncryption.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    NodePool nodePool = NodePool.newBuilder().build();
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodePoolRequest actualRequest = ((CreateNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(nodePool, actualRequest.getNodePool());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      NodePool nodePool = NodePool.newBuilder().build();
      String nodePoolId = "nodePoolId1121557241";
      client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNodePoolTest2() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName(
                NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNodeLocation("nodeLocation1045991383")
            .setNodeCount(1539922066)
            .setMachineFilter("machineFilter427190943")
            .setLocalDiskEncryption(NodePool.LocalDiskEncryption.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String parent = "parent-995424086";
    NodePool nodePool = NodePool.newBuilder().build();
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodePoolRequest actualRequest = ((CreateNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(nodePool, actualRequest.getNodePool());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      NodePool nodePool = NodePool.newBuilder().build();
      String nodePoolId = "nodePoolId1121557241";
      client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateNodePoolTest() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName(
                NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNodeLocation("nodeLocation1045991383")
            .setNodeCount(1539922066)
            .setMachineFilter("machineFilter427190943")
            .setLocalDiskEncryption(NodePool.LocalDiskEncryption.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    NodePool nodePool = NodePool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NodePool actualResponse = client.updateNodePoolAsync(nodePool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNodePoolRequest actualRequest = ((UpdateNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(nodePool, actualRequest.getNodePool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      NodePool nodePool = NodePool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNodePoolAsync(nodePool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNodePoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");

    client.deleteNodePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNodePoolRequest actualRequest = ((DeleteNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
      client.deleteNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNodePoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNodePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNodePoolRequest actualRequest = ((DeleteNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMachinesTest() throws Exception {
    Machine responsesElement = Machine.newBuilder().build();
    ListMachinesResponse expectedResponse =
        ListMachinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMachines(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMachinesPagedResponse pagedListResponse = client.listMachines(parent);

    List<Machine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMachinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMachinesRequest actualRequest = ((ListMachinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMachinesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMachines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMachinesTest2() throws Exception {
    Machine responsesElement = Machine.newBuilder().build();
    ListMachinesResponse expectedResponse =
        ListMachinesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMachines(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMachinesPagedResponse pagedListResponse = client.listMachines(parent);

    List<Machine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMachinesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMachinesRequest actualRequest = ((ListMachinesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMachinesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMachines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMachineTest() throws Exception {
    Machine expectedResponse =
        Machine.newBuilder()
            .setName(MachineName.of("[PROJECT]", "[LOCATION]", "[MACHINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHostedNode("hostedNode-604250391")
            .setZone("zone3744684")
            .setDisabled(true)
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    MachineName name = MachineName.of("[PROJECT]", "[LOCATION]", "[MACHINE]");

    Machine actualResponse = client.getMachine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMachineRequest actualRequest = ((GetMachineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMachineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      MachineName name = MachineName.of("[PROJECT]", "[LOCATION]", "[MACHINE]");
      client.getMachine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMachineTest2() throws Exception {
    Machine expectedResponse =
        Machine.newBuilder()
            .setName(MachineName.of("[PROJECT]", "[LOCATION]", "[MACHINE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHostedNode("hostedNode-604250391")
            .setZone("zone3744684")
            .setDisabled(true)
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String name = "name3373707";

    Machine actualResponse = client.getMachine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMachineRequest actualRequest = ((GetMachineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMachineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.getMachine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpnConnectionsTest() throws Exception {
    VpnConnection responsesElement = VpnConnection.newBuilder().build();
    ListVpnConnectionsResponse expectedResponse =
        ListVpnConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpnConnections(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVpnConnectionsPagedResponse pagedListResponse = client.listVpnConnections(parent);

    List<VpnConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpnConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVpnConnectionsRequest actualRequest = ((ListVpnConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVpnConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVpnConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpnConnectionsTest2() throws Exception {
    VpnConnection responsesElement = VpnConnection.newBuilder().build();
    ListVpnConnectionsResponse expectedResponse =
        ListVpnConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpnConnections(Arrays.asList(responsesElement))
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVpnConnectionsPagedResponse pagedListResponse = client.listVpnConnections(parent);

    List<VpnConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpnConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVpnConnectionsRequest actualRequest = ((ListVpnConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVpnConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVpnConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpnConnectionTest() throws Exception {
    VpnConnection expectedResponse =
        VpnConnection.newBuilder()
            .setName(VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNatGatewayIp("natGatewayIp-1862796694")
            .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setVpc("vpc116969")
            .setVpcProject(VpnConnection.VpcProject.newBuilder().build())
            .setEnableHighAvailability(true)
            .setDetails(VpnConnection.Details.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");

    VpnConnection actualResponse = client.getVpnConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVpnConnectionRequest actualRequest = ((GetVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVpnConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");
      client.getVpnConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpnConnectionTest2() throws Exception {
    VpnConnection expectedResponse =
        VpnConnection.newBuilder()
            .setName(VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNatGatewayIp("natGatewayIp-1862796694")
            .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setVpc("vpc116969")
            .setVpcProject(VpnConnection.VpcProject.newBuilder().build())
            .setEnableHighAvailability(true)
            .setDetails(VpnConnection.Details.newBuilder().build())
            .build();
    mockEdgeContainer.addResponse(expectedResponse);

    String name = "name3373707";

    VpnConnection actualResponse = client.getVpnConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVpnConnectionRequest actualRequest = ((GetVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVpnConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.getVpnConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVpnConnectionTest() throws Exception {
    VpnConnection expectedResponse =
        VpnConnection.newBuilder()
            .setName(VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNatGatewayIp("natGatewayIp-1862796694")
            .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setVpc("vpc116969")
            .setVpcProject(VpnConnection.VpcProject.newBuilder().build())
            .setEnableHighAvailability(true)
            .setDetails(VpnConnection.Details.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpnConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpnConnection vpnConnection = VpnConnection.newBuilder().build();
    String vpnConnectionId = "vpnConnectionId887330733";

    VpnConnection actualResponse =
        client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpnConnectionRequest actualRequest = ((CreateVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(vpnConnection, actualRequest.getVpnConnection());
    Assert.assertEquals(vpnConnectionId, actualRequest.getVpnConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpnConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpnConnection vpnConnection = VpnConnection.newBuilder().build();
      String vpnConnectionId = "vpnConnectionId887330733";
      client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createVpnConnectionTest2() throws Exception {
    VpnConnection expectedResponse =
        VpnConnection.newBuilder()
            .setName(VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNatGatewayIp("natGatewayIp-1862796694")
            .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setVpc("vpc116969")
            .setVpcProject(VpnConnection.VpcProject.newBuilder().build())
            .setEnableHighAvailability(true)
            .setDetails(VpnConnection.Details.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpnConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String parent = "parent-995424086";
    VpnConnection vpnConnection = VpnConnection.newBuilder().build();
    String vpnConnectionId = "vpnConnectionId887330733";

    VpnConnection actualResponse =
        client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVpnConnectionRequest actualRequest = ((CreateVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(vpnConnection, actualRequest.getVpnConnection());
    Assert.assertEquals(vpnConnectionId, actualRequest.getVpnConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVpnConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String parent = "parent-995424086";
      VpnConnection vpnConnection = VpnConnection.newBuilder().build();
      String vpnConnectionId = "vpnConnectionId887330733";
      client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVpnConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpnConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");

    client.deleteVpnConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVpnConnectionRequest actualRequest = ((DeleteVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVpnConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");
      client.deleteVpnConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteVpnConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpnConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEdgeContainer.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteVpnConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockEdgeContainer.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVpnConnectionRequest actualRequest = ((DeleteVpnConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVpnConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEdgeContainer.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVpnConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
