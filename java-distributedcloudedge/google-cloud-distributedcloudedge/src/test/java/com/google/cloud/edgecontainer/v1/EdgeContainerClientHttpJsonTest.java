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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.edgecontainer.v1.stub.HttpJsonEdgeContainerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EdgeContainerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EdgeContainerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEdgeContainerStub.getMethodDescriptors(),
            EdgeContainerSettings.getDefaultEndpoint());
    EdgeContainerSettings settings =
        EdgeContainerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EdgeContainerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EdgeContainerClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listClustersTest() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Cluster cluster =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Cluster cluster =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    client.deleteClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAccessTokenTest() throws Exception {
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ClusterName cluster = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateAccessTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String cluster = "projects/project-7126/locations/location-7126/clusters/cluster-7126";

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateAccessTokenExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String cluster = "projects/project-7126/locations/location-7126/clusters/cluster-7126";
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
    mockService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListNodePoolsPagedResponse pagedListResponse = client.listNodePools(parent);

    List<NodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodePoolsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNodePoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";

    ListNodePoolsPagedResponse pagedListResponse = client.listNodePools(parent);

    List<NodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodePoolsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNodePoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
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
    mockService.addResponse(expectedResponse);

    NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");

    NodePool actualResponse = client.getNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    NodePool actualResponse = client.getNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
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
    mockService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    NodePool nodePool = NodePool.newBuilder().build();
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      NodePool nodePool = NodePool.newBuilder().build();
      String nodePoolId = "nodePoolId1121557241";
      client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
    NodePool nodePool = NodePool.newBuilder().build();
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      NodePool nodePool = NodePool.newBuilder().build();
      String nodePoolId = "nodePoolId1121557241";
      client.createNodePoolAsync(parent, nodePool, nodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    NodePool nodePool =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    NodePool actualResponse = client.updateNodePoolAsync(nodePool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NodePool nodePool =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNodePoolAsync(nodePool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");

    client.deleteNodePoolAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NodePoolName name = NodePoolName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
      client.deleteNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    client.deleteNodePoolAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
      client.deleteNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMachinesPagedResponse pagedListResponse = client.listMachines(parent);

    List<Machine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMachinesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listMachinesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListMachinesPagedResponse pagedListResponse = client.listMachines(parent);

    List<Machine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMachinesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listMachinesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    MachineName name = MachineName.of("[PROJECT]", "[LOCATION]", "[MACHINE]");

    Machine actualResponse = client.getMachine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getMachineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5716/locations/location-5716/machines/machine-5716";

    Machine actualResponse = client.getMachine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getMachineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5716/locations/location-5716/machines/machine-5716";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVpnConnectionsPagedResponse pagedListResponse = client.listVpnConnections(parent);

    List<VpnConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpnConnectionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVpnConnectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListVpnConnectionsPagedResponse pagedListResponse = client.listVpnConnections(parent);

    List<VpnConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpnConnectionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVpnConnectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");

    VpnConnection actualResponse = client.getVpnConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVpnConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1361/locations/location-1361/vpnConnections/vpnConnection-1361";

    VpnConnection actualResponse = client.getVpnConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVpnConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1361/locations/location-1361/vpnConnections/vpnConnection-1361";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpnConnection vpnConnection = VpnConnection.newBuilder().build();
    String vpnConnectionId = "vpnConnectionId887330733";

    VpnConnection actualResponse =
        client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createVpnConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpnConnection vpnConnection = VpnConnection.newBuilder().build();
      String vpnConnectionId = "vpnConnectionId887330733";
      client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    VpnConnection vpnConnection = VpnConnection.newBuilder().build();
    String vpnConnectionId = "vpnConnectionId887330733";

    VpnConnection actualResponse =
        client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createVpnConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      VpnConnection vpnConnection = VpnConnection.newBuilder().build();
      String vpnConnectionId = "vpnConnectionId887330733";
      client.createVpnConnectionAsync(parent, vpnConnection, vpnConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");

    client.deleteVpnConnectionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteVpnConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VpnConnectionName name = VpnConnectionName.of("[PROJECT]", "[LOCATION]", "[VPN_CONNECTION]");
      client.deleteVpnConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-1361/locations/location-1361/vpnConnections/vpnConnection-1361";

    client.deleteVpnConnectionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteVpnConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1361/locations/location-1361/vpnConnections/vpnConnection-1361";
      client.deleteVpnConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
