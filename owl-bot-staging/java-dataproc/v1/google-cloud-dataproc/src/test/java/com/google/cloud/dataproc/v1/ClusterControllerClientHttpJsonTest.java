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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.ClusterControllerClient.ListClustersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonClusterControllerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
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
public class ClusterControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ClusterControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonClusterControllerStub.getMethodDescriptors(),
            ClusterControllerSettings.getDefaultEndpoint());
    ClusterControllerSettings settings =
        ClusterControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ClusterControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ClusterControllerClient.create(settings);
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
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .setVirtualClusterConfig(VirtualClusterConfig.newBuilder().build())
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
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String region = "region-9622";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(projectId, region, cluster).get();
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
      String projectId = "projectId-1530";
      String region = "region-9622";
      Cluster cluster = Cluster.newBuilder().build();
      client.createClusterAsync(projectId, region, cluster).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .setVirtualClusterConfig(VirtualClusterConfig.newBuilder().build())
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
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String clusterName = "clusterName-7787";
    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse =
        client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
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
      String projectId = "projectId-1530";
      String region = "region-9622";
      String clusterName = "clusterName-7787";
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(projectId, region, clusterName, cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .setVirtualClusterConfig(VirtualClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    StopClusterRequest request =
        StopClusterRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setRegion("region-9622")
            .setClusterName("clusterName-7787")
            .setClusterUuid("clusterUuid-1141510955")
            .setRequestId("requestId693933066")
            .build();

    Cluster actualResponse = client.stopClusterAsync(request).get();
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
  public void stopClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StopClusterRequest request =
          StopClusterRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setRegion("region-9622")
              .setClusterName("clusterName-7787")
              .setClusterUuid("clusterUuid-1141510955")
              .setRequestId("requestId693933066")
              .build();
      client.stopClusterAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .setVirtualClusterConfig(VirtualClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    StartClusterRequest request =
        StartClusterRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setRegion("region-9622")
            .setClusterName("clusterName-7787")
            .setClusterUuid("clusterUuid-1141510955")
            .setRequestId("requestId693933066")
            .build();

    Cluster actualResponse = client.startClusterAsync(request).get();
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
  public void startClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StartClusterRequest request =
          StartClusterRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setRegion("region-9622")
              .setClusterName("clusterName-7787")
              .setClusterUuid("clusterUuid-1141510955")
              .setRequestId("requestId693933066")
              .build();
      client.startClusterAsync(request).get();
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

    String projectId = "projectId-1530";
    String region = "region-9622";
    String clusterName = "clusterName-7787";

    client.deleteClusterAsync(projectId, region, clusterName).get();

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
      String projectId = "projectId-1530";
      String region = "region-9622";
      String clusterName = "clusterName-7787";
      client.deleteClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setProjectId("projectId-894832108")
            .setClusterName("clusterName-1141738587")
            .setConfig(ClusterConfig.newBuilder().build())
            .setVirtualClusterConfig(VirtualClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStatus(ClusterStatus.newBuilder().build())
            .addAllStatusHistory(new ArrayList<ClusterStatus>())
            .setClusterUuid("clusterUuid-1141510955")
            .setMetrics(ClusterMetrics.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String clusterName = "clusterName-7787";

    Cluster actualResponse = client.getCluster(projectId, region, clusterName);
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
      String projectId = "projectId-1530";
      String region = "region-9622";
      String clusterName = "clusterName-7787";
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region);

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
      String projectId = "projectId-1530";
      String region = "region-9622";
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String filter = "filter-1274492040";

    ListClustersPagedResponse pagedListResponse = client.listClusters(projectId, region, filter);

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
      String projectId = "projectId-1530";
      String region = "region-9622";
      String filter = "filter-1274492040";
      client.listClusters(projectId, region, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void diagnoseClusterTest() throws Exception {
    DiagnoseClusterResults expectedResponse =
        DiagnoseClusterResults.newBuilder().setOutputUri("outputUri-2119300949").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("diagnoseClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String region = "region-9622";
    String clusterName = "clusterName-7787";

    DiagnoseClusterResults actualResponse =
        client.diagnoseClusterAsync(projectId, region, clusterName).get();
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
  public void diagnoseClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String region = "region-9622";
      String clusterName = "clusterName-7787";
      client.diagnoseClusterAsync(projectId, region, clusterName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
