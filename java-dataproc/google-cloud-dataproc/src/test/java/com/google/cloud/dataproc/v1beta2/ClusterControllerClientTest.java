/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dataproc.v1beta2;

import static com.google.cloud.dataproc.v1beta2.ClusterControllerClient.ListClustersPagedResponse;

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
public class ClusterControllerClientTest {
  private static MockClusterController mockClusterController;
  private static MockServiceHelper mockServiceHelper;
  private ClusterControllerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterController = new MockClusterController();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockClusterController));
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
    ClusterControllerSettings settings =
        ClusterControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ClusterControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(projectId, region, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      Cluster cluster = Cluster.newBuilder().build();
      client.createClusterAsync(projectId, region, cluster).get();
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
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    String clusterName = "clusterName-1141738587";
    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse =
        client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClusterRequest actualRequest = ((UpdateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
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
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String clusterName = "clusterName-1141738587";
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
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
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    String clusterName = "clusterName-1141738587";

    client.deleteClusterAsync(projectId, region, clusterName).get();

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String clusterName = "clusterName-1141738587";
      client.deleteClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    String clusterName = "clusterName-1141738587";

    Cluster actualResponse = client.getCluster(projectId, region, clusterName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String clusterName = "clusterName-1141738587";
      client.getCluster(projectId, region, clusterName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String region = "region-934795532";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      client.listClusters(projectId, region);
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
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    String filter = "filter-1274492040";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region, filter);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String filter = "filter-1274492040";
      client.listClusters(projectId, region, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("diagnoseClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String region = "region-934795532";
    String clusterName = "clusterName-1141738587";

    client.diagnoseClusterAsync(projectId, region, clusterName).get();

    List<AbstractMessage> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseClusterRequest actualRequest = ((DiagnoseClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void diagnoseClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String clusterName = "clusterName-1141738587";
      client.diagnoseClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
