/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ClusterControllerClientTest {
  private static MockClusterController mockClusterController;
  private static MockJobController mockJobController;
  private static MockWorkflowTemplateService mockWorkflowTemplateService;
  private static MockServiceHelper serviceHelper;
  private ClusterControllerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterController = new MockClusterController();
    mockJobController = new MockJobController();
    mockWorkflowTemplateService = new MockWorkflowTemplateService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockClusterController, mockJobController, mockWorkflowTemplateService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void createClusterTest() throws Exception {
    String projectId2 = "projectId2939242356";
    String clusterName = "clusterName-1018081872";
    String clusterUuid = "clusterUuid-1017854240";
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId(projectId2)
            .setClusterName(clusterName)
            .setClusterUuid(clusterUuid)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(projectId, region, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = (CreateClusterRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      Cluster cluster = Cluster.newBuilder().build();

      client.createClusterAsync(projectId, region, cluster).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateClusterTest() throws Exception {
    String projectId2 = "projectId2939242356";
    String clusterName2 = "clusterName2875867491";
    String clusterUuid = "clusterUuid-1017854240";
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId(projectId2)
            .setClusterName(clusterName2)
            .setClusterUuid(clusterUuid)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String clusterName = "clusterName-1018081872";
    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse =
        client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClusterRequest actualRequest = (UpdateClusterRequest) actualRequests.get(0);

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
  @SuppressWarnings("all")
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String clusterName = "clusterName-1018081872";
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String clusterName = "clusterName-1018081872";

    Empty actualResponse = client.deleteClusterAsync(projectId, region, clusterName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = (DeleteClusterRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String clusterName = "clusterName-1018081872";

      client.deleteClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterTest() {
    String projectId2 = "projectId2939242356";
    String clusterName2 = "clusterName2875867491";
    String clusterUuid = "clusterUuid-1017854240";
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId(projectId2)
            .setClusterName(clusterName2)
            .setClusterUuid(clusterUuid)
            .build();
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String clusterName = "clusterName-1018081872";

    Cluster actualResponse = client.getCluster(projectId, region, clusterName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = (GetClusterRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String clusterName = "clusterName-1018081872";

      client.getCluster(projectId, region, clusterName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersTest() {
    String nextPageToken = "";
    Cluster clustersElement = Cluster.newBuilder().build();
    List<Cluster> clusters = Arrays.asList(clustersElement);
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllClusters(clusters)
            .build();
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = (ListClustersRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";

      client.listClusters(projectId, region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersTest2() {
    String nextPageToken = "";
    Cluster clustersElement = Cluster.newBuilder().build();
    List<Cluster> clusters = Arrays.asList(clustersElement);
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllClusters(clusters)
            .build();
    mockClusterController.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String filter = "filter-1274492040";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region, filter);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = (ListClustersRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String filter = "filter-1274492040";

      client.listClusters(projectId, region, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void diagnoseClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("diagnoseClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockClusterController.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String region = "region-934795532";
    String clusterName = "clusterName-1018081872";

    Empty actualResponse = client.diagnoseClusterAsync(projectId, region, clusterName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiagnoseClusterRequest actualRequest = (DiagnoseClusterRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(region, actualRequest.getRegion());
    Assert.assertEquals(clusterName, actualRequest.getClusterName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void diagnoseClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterController.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String region = "region-934795532";
      String clusterName = "clusterName-1018081872";

      client.diagnoseClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
