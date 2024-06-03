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

package com.google.cloud.managedkafka.v1;

import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListConsumerGroupsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListLocationsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListTopicsPagedResponse;

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
public class ManagedKafkaClientTest {
  private static MockLocations mockLocations;
  private static MockManagedKafka mockManagedKafka;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ManagedKafkaClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockManagedKafka = new MockManagedKafka();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockManagedKafka, mockLocations));
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
    ManagedKafkaSettings settings =
        ManagedKafkaSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ManagedKafkaClient.create(settings);
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
    mockManagedKafka.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
    mockManagedKafka.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .setRebalanceConfig(RebalanceConfig.newBuilder().build())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .setRebalanceConfig(RebalanceConfig.newBuilder().build())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .setRebalanceConfig(RebalanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafka.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .setRebalanceConfig(RebalanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafka.addResponse(resultOperation);

    String parent = "parent-995424086";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .setRebalanceConfig(RebalanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockManagedKafka.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
    mockManagedKafka.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
    mockManagedKafka.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
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
    mockManagedKafka.addException(exception);

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
  public void listTopicsTest() throws Exception {
    Topic responsesElement = Topic.newBuilder().build();
    ListTopicsResponse expectedResponse =
        ListTopicsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTopics(Arrays.asList(responsesElement))
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListTopicsPagedResponse pagedListResponse = client.listTopics(parent);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = ((ListTopicsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listTopics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTopicsTest2() throws Exception {
    Topic responsesElement = Topic.newBuilder().build();
    ListTopicsResponse expectedResponse =
        ListTopicsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTopics(Arrays.asList(responsesElement))
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTopicsPagedResponse pagedListResponse = client.listTopics(parent);

    List<Topic> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTopicsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTopicsRequest actualRequest = ((ListTopicsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTopicsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTopics(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
            .setPartitionCount(-1738969222)
            .setReplicationFactor(-1434332894)
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");

    Topic actualResponse = client.getTopic(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = ((GetTopicRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");
      client.getTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTopicTest2() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
            .setPartitionCount(-1738969222)
            .setReplicationFactor(-1434332894)
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String name = "name3373707";

    Topic actualResponse = client.getTopic(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTopicRequest actualRequest = ((GetTopicRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String name = "name3373707";
      client.getTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
            .setPartitionCount(-1738969222)
            .setReplicationFactor(-1434332894)
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Topic topic = Topic.newBuilder().build();
    String topicId = "topicId-1139259734";

    Topic actualResponse = client.createTopic(parent, topic, topicId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTopicRequest actualRequest = ((CreateTopicRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(topicId, actualRequest.getTopicId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Topic topic = Topic.newBuilder().build();
      String topicId = "topicId-1139259734";
      client.createTopic(parent, topic, topicId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTopicTest2() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
            .setPartitionCount(-1738969222)
            .setReplicationFactor(-1434332894)
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Topic topic = Topic.newBuilder().build();
    String topicId = "topicId-1139259734";

    Topic actualResponse = client.createTopic(parent, topic, topicId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTopicRequest actualRequest = ((CreateTopicRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(topicId, actualRequest.getTopicId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String parent = "parent-995424086";
      Topic topic = Topic.newBuilder().build();
      String topicId = "topicId-1139259734";
      client.createTopic(parent, topic, topicId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTopicTest() throws Exception {
    Topic expectedResponse =
        Topic.newBuilder()
            .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
            .setPartitionCount(-1738969222)
            .setReplicationFactor(-1434332894)
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    Topic topic = Topic.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Topic actualResponse = client.updateTopic(topic, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTopicRequest actualRequest = ((UpdateTopicRequest) actualRequests.get(0));

    Assert.assertEquals(topic, actualRequest.getTopic());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      Topic topic = Topic.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTopic(topic, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTopicTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafka.addResponse(expectedResponse);

    TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");

    client.deleteTopic(name);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = ((DeleteTopicRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTopicExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");
      client.deleteTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTopicTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafka.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTopic(name);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTopicRequest actualRequest = ((DeleteTopicRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTopicExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTopic(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConsumerGroupsTest() throws Exception {
    ConsumerGroup responsesElement = ConsumerGroup.newBuilder().build();
    ListConsumerGroupsResponse expectedResponse =
        ListConsumerGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConsumerGroups(Arrays.asList(responsesElement))
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListConsumerGroupsPagedResponse pagedListResponse = client.listConsumerGroups(parent);

    List<ConsumerGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConsumerGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConsumerGroupsRequest actualRequest = ((ListConsumerGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConsumerGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listConsumerGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConsumerGroupsTest2() throws Exception {
    ConsumerGroup responsesElement = ConsumerGroup.newBuilder().build();
    ListConsumerGroupsResponse expectedResponse =
        ListConsumerGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConsumerGroups(Arrays.asList(responsesElement))
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConsumerGroupsPagedResponse pagedListResponse = client.listConsumerGroups(parent);

    List<ConsumerGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConsumerGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConsumerGroupsRequest actualRequest = ((ListConsumerGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConsumerGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConsumerGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConsumerGroupTest() throws Exception {
    ConsumerGroup expectedResponse =
        ConsumerGroup.newBuilder()
            .setName(
                ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
                    .toString())
            .putAllTopics(new HashMap<String, ConsumerTopicMetadata>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ConsumerGroupName name =
        ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");

    ConsumerGroup actualResponse = client.getConsumerGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConsumerGroupRequest actualRequest = ((GetConsumerGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConsumerGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ConsumerGroupName name =
          ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");
      client.getConsumerGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConsumerGroupTest2() throws Exception {
    ConsumerGroup expectedResponse =
        ConsumerGroup.newBuilder()
            .setName(
                ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
                    .toString())
            .putAllTopics(new HashMap<String, ConsumerTopicMetadata>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    String name = "name3373707";

    ConsumerGroup actualResponse = client.getConsumerGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConsumerGroupRequest actualRequest = ((GetConsumerGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConsumerGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String name = "name3373707";
      client.getConsumerGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConsumerGroupTest() throws Exception {
    ConsumerGroup expectedResponse =
        ConsumerGroup.newBuilder()
            .setName(
                ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
                    .toString())
            .putAllTopics(new HashMap<String, ConsumerTopicMetadata>())
            .build();
    mockManagedKafka.addResponse(expectedResponse);

    ConsumerGroup consumerGroup = ConsumerGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConsumerGroup actualResponse = client.updateConsumerGroup(consumerGroup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConsumerGroupRequest actualRequest = ((UpdateConsumerGroupRequest) actualRequests.get(0));

    Assert.assertEquals(consumerGroup, actualRequest.getConsumerGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConsumerGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ConsumerGroup consumerGroup = ConsumerGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConsumerGroup(consumerGroup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConsumerGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafka.addResponse(expectedResponse);

    ConsumerGroupName name =
        ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");

    client.deleteConsumerGroup(name);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConsumerGroupRequest actualRequest = ((DeleteConsumerGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConsumerGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      ConsumerGroupName name =
          ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");
      client.deleteConsumerGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConsumerGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockManagedKafka.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConsumerGroup(name);

    List<AbstractMessage> actualRequests = mockManagedKafka.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConsumerGroupRequest actualRequest = ((DeleteConsumerGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConsumerGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockManagedKafka.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConsumerGroup(name);
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
