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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.StreamsServiceClient.ListClustersPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListSeriesPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListStreamsPagedResponse;

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
import com.google.protobuf.Duration;
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
public class StreamsServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockStreamsService mockStreamsService;
  private LocalChannelProvider channelProvider;
  private StreamsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStreamsService = new MockStreamsService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockStreamsService, mockLocations, mockIAMPolicy));
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
    StreamsServiceSettings settings =
        StreamsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StreamsServiceClient.create(settings);
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
    mockStreamsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
    mockStreamsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
            .putAllAnnotations(new HashMap<String, String>())
            .setDataplaneServiceEndpoint("dataplaneServiceEndpoint-81226728")
            .setPscTarget("pscTarget-1845231503")
            .build();
    mockStreamsService.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
            .putAllAnnotations(new HashMap<String, String>())
            .setDataplaneServiceEndpoint("dataplaneServiceEndpoint-81226728")
            .setPscTarget("pscTarget-1845231503")
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
            .putAllAnnotations(new HashMap<String, String>())
            .setDataplaneServiceEndpoint("dataplaneServiceEndpoint-81226728")
            .setPscTarget("pscTarget-1845231503")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
            .putAllAnnotations(new HashMap<String, String>())
            .setDataplaneServiceEndpoint("dataplaneServiceEndpoint-81226728")
            .setPscTarget("pscTarget-1845231503")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
            .putAllAnnotations(new HashMap<String, String>())
            .setDataplaneServiceEndpoint("dataplaneServiceEndpoint-81226728")
            .setPscTarget("pscTarget-1845231503")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
    mockStreamsService.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
    mockStreamsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
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
    mockStreamsService.addException(exception);

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
  public void listStreamsTest() throws Exception {
    Stream responsesElement = Stream.newBuilder().build();
    ListStreamsResponse expectedResponse =
        ListStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStreams(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListStreamsPagedResponse pagedListResponse = client.listStreams(parent);

    List<Stream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStreamsRequest actualRequest = ((ListStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStreamsTest2() throws Exception {
    Stream responsesElement = Stream.newBuilder().build();
    ListStreamsResponse expectedResponse =
        ListStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStreams(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListStreamsPagedResponse pagedListResponse = client.listStreams(parent);

    List<Stream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStreamsRequest actualRequest = ((ListStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setEnableHlsPlayback(true)
            .setMediaWarehouseAsset("mediaWarehouseAsset-188571919")
            .build();
    mockStreamsService.addResponse(expectedResponse);

    StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");

    Stream actualResponse = client.getStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStreamRequest actualRequest = ((GetStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");
      client.getStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStreamTest2() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setEnableHlsPlayback(true)
            .setMediaWarehouseAsset("mediaWarehouseAsset-188571919")
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String name = "name3373707";

    Stream actualResponse = client.getStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStreamRequest actualRequest = ((GetStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.getStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setEnableHlsPlayback(true)
            .setMediaWarehouseAsset("mediaWarehouseAsset-188571919")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Stream stream = Stream.newBuilder().build();
    String streamId = "streamId1790933179";

    Stream actualResponse = client.createStreamAsync(parent, stream, streamId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStreamRequest actualRequest = ((CreateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(streamId, actualRequest.getStreamId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Stream stream = Stream.newBuilder().build();
      String streamId = "streamId1790933179";
      client.createStreamAsync(parent, stream, streamId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createStreamTest2() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setEnableHlsPlayback(true)
            .setMediaWarehouseAsset("mediaWarehouseAsset-188571919")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Stream stream = Stream.newBuilder().build();
    String streamId = "streamId1790933179";

    Stream actualResponse = client.createStreamAsync(parent, stream, streamId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStreamRequest actualRequest = ((CreateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(streamId, actualRequest.getStreamId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Stream stream = Stream.newBuilder().build();
      String streamId = "streamId1790933179";
      client.createStreamAsync(parent, stream, streamId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setEnableHlsPlayback(true)
            .setMediaWarehouseAsset("mediaWarehouseAsset-188571919")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    Stream stream = Stream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Stream actualResponse = client.updateStreamAsync(stream, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStreamRequest actualRequest = ((UpdateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      Stream stream = Stream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStreamAsync(stream, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");

    client.deleteStreamAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStreamRequest actualRequest = ((DeleteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");
      client.deleteStreamAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteStreamAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStreamRequest actualRequest = ((DeleteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteStreamAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getStreamThumbnailTest() throws Exception {
    GetStreamThumbnailResponse expectedResponse = GetStreamThumbnailResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("getStreamThumbnailTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String stream = "stream-891990144";
    String gcsObjectName = "gcsObjectName-1987275551";

    GetStreamThumbnailResponse actualResponse =
        client.getStreamThumbnailAsync(stream, gcsObjectName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStreamThumbnailRequest actualRequest = ((GetStreamThumbnailRequest) actualRequests.get(0));

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(gcsObjectName, actualRequest.getGcsObjectName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStreamThumbnailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String stream = "stream-891990144";
      String gcsObjectName = "gcsObjectName-1987275551";
      client.getStreamThumbnailAsync(stream, gcsObjectName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateStreamHlsTokenTest() throws Exception {
    GenerateStreamHlsTokenResponse expectedResponse =
        GenerateStreamHlsTokenResponse.newBuilder()
            .setToken("token110541305")
            .setExpirationTime(Timestamp.newBuilder().build())
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String stream = "stream-891990144";

    GenerateStreamHlsTokenResponse actualResponse = client.generateStreamHlsToken(stream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateStreamHlsTokenRequest actualRequest =
        ((GenerateStreamHlsTokenRequest) actualRequests.get(0));

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateStreamHlsTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String stream = "stream-891990144";
      client.generateStreamHlsToken(stream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEventsTest2() throws Exception {
    Event responsesElement = Event.newBuilder().build();
    ListEventsResponse expectedResponse =
        ListEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvents(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEventsPagedResponse pagedListResponse = client.listEvents(parent);

    List<Event> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEventsRequest actualRequest = ((ListEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setGracePeriod(Duration.newBuilder().build())
            .build();
    mockStreamsService.addResponse(expectedResponse);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEventTest2() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setGracePeriod(Duration.newBuilder().build())
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String name = "name3373707";

    Event actualResponse = client.getEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEventRequest actualRequest = ((GetEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setGracePeriod(Duration.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEventAsync(parent, event, eventId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventRequest actualRequest = ((CreateEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertEquals(eventId, actualRequest.getEventId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Event event = Event.newBuilder().build();
      String eventId = "eventId-1376502443";
      client.createEventAsync(parent, event, eventId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEventTest2() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setGracePeriod(Duration.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Event event = Event.newBuilder().build();
    String eventId = "eventId-1376502443";

    Event actualResponse = client.createEventAsync(parent, event, eventId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEventRequest actualRequest = ((CreateEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertEquals(eventId, actualRequest.getEventId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Event event = Event.newBuilder().build();
      String eventId = "eventId-1376502443";
      client.createEventAsync(parent, event, eventId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEventTest() throws Exception {
    Event expectedResponse =
        Event.newBuilder()
            .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setGracePeriod(Duration.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    Event event = Event.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Event actualResponse = client.updateEventAsync(event, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEventRequest actualRequest = ((UpdateEventRequest) actualRequests.get(0));

    Assert.assertEquals(event, actualRequest.getEvent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      Event event = Event.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEventAsync(event, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");

    client.deleteEventAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventRequest actualRequest = ((DeleteEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");
      client.deleteEventAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEventTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEventTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEventAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEventRequest actualRequest = ((DeleteEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEventAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSeriesTest() throws Exception {
    Series responsesElement = Series.newBuilder().build();
    ListSeriesResponse expectedResponse =
        ListSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSeries(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListSeriesPagedResponse pagedListResponse = client.listSeries(parent);

    List<Series> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSeriesRequest actualRequest = ((ListSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      client.listSeries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSeriesTest2() throws Exception {
    Series responsesElement = Series.newBuilder().build();
    ListSeriesResponse expectedResponse =
        ListSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSeries(Arrays.asList(responsesElement))
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSeriesPagedResponse pagedListResponse = client.listSeries(parent);

    List<Series> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSeriesRequest actualRequest = ((ListSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSeries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSeriesTest() throws Exception {
    Series expectedResponse =
        Series.newBuilder()
            .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    mockStreamsService.addResponse(expectedResponse);

    SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");

    Series actualResponse = client.getSeries(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSeriesRequest actualRequest = ((GetSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");
      client.getSeries(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSeriesTest2() throws Exception {
    Series expectedResponse =
        Series.newBuilder()
            .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    mockStreamsService.addResponse(expectedResponse);

    String name = "name3373707";

    Series actualResponse = client.getSeries(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSeriesRequest actualRequest = ((GetSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSeries(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSeriesTest() throws Exception {
    Series expectedResponse =
        Series.newBuilder()
            .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Series series = Series.newBuilder().build();
    String seriesId = "seriesId1367098866";

    Series actualResponse = client.createSeriesAsync(parent, series, seriesId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSeriesRequest actualRequest = ((CreateSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(series, actualRequest.getSeries());
    Assert.assertEquals(seriesId, actualRequest.getSeriesId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Series series = Series.newBuilder().build();
      String seriesId = "seriesId1367098866";
      client.createSeriesAsync(parent, series, seriesId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSeriesTest2() throws Exception {
    Series expectedResponse =
        Series.newBuilder()
            .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Series series = Series.newBuilder().build();
    String seriesId = "seriesId1367098866";

    Series actualResponse = client.createSeriesAsync(parent, series, seriesId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSeriesRequest actualRequest = ((CreateSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(series, actualRequest.getSeries());
    Assert.assertEquals(seriesId, actualRequest.getSeriesId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Series series = Series.newBuilder().build();
      String seriesId = "seriesId1367098866";
      client.createSeriesAsync(parent, series, seriesId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSeriesTest() throws Exception {
    Series expectedResponse =
        Series.newBuilder()
            .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    Series series = Series.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Series actualResponse = client.updateSeriesAsync(series, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSeriesRequest actualRequest = ((UpdateSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(series, actualRequest.getSeries());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      Series series = Series.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSeriesAsync(series, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSeriesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");

    client.deleteSeriesAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSeriesRequest actualRequest = ((DeleteSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");
      client.deleteSeriesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSeriesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSeriesAsync(name).get();

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSeriesRequest actualRequest = ((DeleteSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSeriesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void materializeChannelTest() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("materializeChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.materializeChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MaterializeChannelRequest actualRequest = ((MaterializeChannelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(channel, actualRequest.getChannel());
    Assert.assertEquals(channelId, actualRequest.getChannelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void materializeChannelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.materializeChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void materializeChannelTest2() throws Exception {
    Channel expectedResponse =
        Channel.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
            .setEvent(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("materializeChannelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockStreamsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Channel channel = Channel.newBuilder().build();
    String channelId = "channelId1461735806";

    Channel actualResponse = client.materializeChannelAsync(parent, channel, channelId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MaterializeChannelRequest actualRequest = ((MaterializeChannelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(channel, actualRequest.getChannel());
    Assert.assertEquals(channelId, actualRequest.getChannelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void materializeChannelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Channel channel = Channel.newBuilder().build();
      String channelId = "channelId1461735806";
      client.materializeChannelAsync(parent, channel, channelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
