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

package com.google.cloud.redis.cluster.v1;

import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListClustersPagedResponse;
import static com.google.cloud.redis.cluster.v1.CloudRedisClusterClient.ListLocationsPagedResponse;

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
public class CloudRedisClusterClientTest {
  private static MockCloudRedisCluster mockCloudRedisCluster;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudRedisClusterClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudRedisCluster = new MockCloudRedisCluster();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudRedisCluster, mockLocations));
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
    CloudRedisClusterSettings settings =
        CloudRedisClusterSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudRedisClusterClient.create(settings);
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
    mockCloudRedisCluster.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
    mockCloudRedisCluster.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setAuthorizationMode(AuthorizationMode.forNumber(0))
            .setTransitEncryptionMode(TransitEncryptionMode.forNumber(0))
            .setSizeGb(2105542105)
            .setShardCount(-495377042)
            .addAllPscConfigs(new ArrayList<PscConfig>())
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .addAllPscConnections(new ArrayList<PscConnection>())
            .setStateInfo(Cluster.StateInfo.newBuilder().build())
            .setNodeType(NodeType.forNumber(0))
            .setPersistenceConfig(ClusterPersistenceConfig.newBuilder().build())
            .putAllRedisConfigs(new HashMap<String, String>())
            .setPreciseSizeGb(1342268405)
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .build();
    mockCloudRedisCluster.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setAuthorizationMode(AuthorizationMode.forNumber(0))
            .setTransitEncryptionMode(TransitEncryptionMode.forNumber(0))
            .setSizeGb(2105542105)
            .setShardCount(-495377042)
            .addAllPscConfigs(new ArrayList<PscConfig>())
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .addAllPscConnections(new ArrayList<PscConnection>())
            .setStateInfo(Cluster.StateInfo.newBuilder().build())
            .setNodeType(NodeType.forNumber(0))
            .setPersistenceConfig(ClusterPersistenceConfig.newBuilder().build())
            .putAllRedisConfigs(new HashMap<String, String>())
            .setPreciseSizeGb(1342268405)
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .build();
    mockCloudRedisCluster.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

    try {
      String name = "name3373707";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setAuthorizationMode(AuthorizationMode.forNumber(0))
            .setTransitEncryptionMode(TransitEncryptionMode.forNumber(0))
            .setSizeGb(2105542105)
            .setShardCount(-495377042)
            .addAllPscConfigs(new ArrayList<PscConfig>())
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .addAllPscConnections(new ArrayList<PscConnection>())
            .setStateInfo(Cluster.StateInfo.newBuilder().build())
            .setNodeType(NodeType.forNumber(0))
            .setPersistenceConfig(ClusterPersistenceConfig.newBuilder().build())
            .putAllRedisConfigs(new HashMap<String, String>())
            .setPreciseSizeGb(1342268405)
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedisCluster.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
    mockCloudRedisCluster.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
    mockCloudRedisCluster.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setAuthorizationMode(AuthorizationMode.forNumber(0))
            .setTransitEncryptionMode(TransitEncryptionMode.forNumber(0))
            .setSizeGb(2105542105)
            .setShardCount(-495377042)
            .addAllPscConfigs(new ArrayList<PscConfig>())
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .addAllPscConnections(new ArrayList<PscConnection>())
            .setStateInfo(Cluster.StateInfo.newBuilder().build())
            .setNodeType(NodeType.forNumber(0))
            .setPersistenceConfig(ClusterPersistenceConfig.newBuilder().build())
            .putAllRedisConfigs(new HashMap<String, String>())
            .setPreciseSizeGb(1342268405)
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedisCluster.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setAuthorizationMode(AuthorizationMode.forNumber(0))
            .setTransitEncryptionMode(TransitEncryptionMode.forNumber(0))
            .setSizeGb(2105542105)
            .setShardCount(-495377042)
            .addAllPscConfigs(new ArrayList<PscConfig>())
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .addAllPscConnections(new ArrayList<PscConnection>())
            .setStateInfo(Cluster.StateInfo.newBuilder().build())
            .setNodeType(NodeType.forNumber(0))
            .setPersistenceConfig(ClusterPersistenceConfig.newBuilder().build())
            .putAllRedisConfigs(new HashMap<String, String>())
            .setPreciseSizeGb(1342268405)
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudRedisCluster.addResponse(resultOperation);

    String parent = "parent-995424086";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
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
    mockCloudRedisCluster.addException(exception);

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
  public void getClusterCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .build();
    mockCloudRedisCluster.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    CertificateAuthority actualResponse = client.getClusterCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterCertificateAuthorityRequest actualRequest =
        ((GetClusterCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedisCluster.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.getClusterCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .build();
    mockCloudRedisCluster.addResponse(expectedResponse);

    String name = "name3373707";

    CertificateAuthority actualResponse = client.getClusterCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudRedisCluster.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterCertificateAuthorityRequest actualRequest =
        ((GetClusterCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterCertificateAuthorityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudRedisCluster.addException(exception);

    try {
      String name = "name3373707";
      client.getClusterCertificateAuthority(name);
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
