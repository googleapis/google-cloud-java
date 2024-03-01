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

package com.google.cloud.workstations.v1beta;

import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.workstations.v1beta.stub.HttpJsonWorkstationsStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class WorkstationsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WorkstationsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWorkstationsStub.getMethodDescriptors(),
            WorkstationsSettings.getDefaultEndpoint());
    WorkstationsSettings settings =
        WorkstationsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WorkstationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkstationsClient.create(settings);
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
  public void getWorkstationClusterTest() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationClusterName name =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    WorkstationCluster actualResponse = client.getWorkstationCluster(name);
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
  public void getWorkstationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationClusterName name =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      client.getWorkstationCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkstationClusterTest2() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7538/locations/location-7538/workstationClusters/workstationCluster-7538";

    WorkstationCluster actualResponse = client.getWorkstationCluster(name);
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
  public void getWorkstationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7538/locations/location-7538/workstationClusters/workstationCluster-7538";
      client.getWorkstationCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationClustersTest() throws Exception {
    WorkstationCluster responsesElement = WorkstationCluster.newBuilder().build();
    ListWorkstationClustersResponse expectedResponse =
        ListWorkstationClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkstationClustersPagedResponse pagedListResponse = client.listWorkstationClusters(parent);

    List<WorkstationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationClustersList().get(0), resources.get(0));

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
  public void listWorkstationClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listWorkstationClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationClustersTest2() throws Exception {
    WorkstationCluster responsesElement = WorkstationCluster.newBuilder().build();
    ListWorkstationClustersResponse expectedResponse =
        ListWorkstationClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListWorkstationClustersPagedResponse pagedListResponse = client.listWorkstationClusters(parent);

    List<WorkstationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationClustersList().get(0), resources.get(0));

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
  public void listWorkstationClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listWorkstationClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkstationClusterTest() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
    String workstationClusterId = "workstationClusterId351421170";

    WorkstationCluster actualResponse =
        client
            .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
            .get();
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
  public void createWorkstationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      String workstationClusterId = "workstationClusterId351421170";
      client.createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createWorkstationClusterTest2() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
    String workstationClusterId = "workstationClusterId351421170";

    WorkstationCluster actualResponse =
        client
            .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
            .get();
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
  public void createWorkstationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      String workstationClusterId = "workstationClusterId351421170";
      client.createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkstationClusterTest() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkstationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationCluster workstationCluster =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkstationCluster actualResponse =
        client.updateWorkstationClusterAsync(workstationCluster, updateMask).get();
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
  public void updateWorkstationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationCluster workstationCluster =
          WorkstationCluster.newBuilder()
              .setName(
                  WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setUid("uid115792")
              .setReconciling(true)
              .putAllAnnotations(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .setNetwork("network1843485230")
              .setSubnetwork("subnetwork-1302785042")
              .setControlPlaneIp("controlPlaneIp-1263362938")
              .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
              .setDegraded(true)
              .addAllConditions(new ArrayList<Status>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationClusterAsync(workstationCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationClusterTest() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationClusterName name =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    WorkstationCluster actualResponse = client.deleteWorkstationClusterAsync(name).get();
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
  public void deleteWorkstationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationClusterName name =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      client.deleteWorkstationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationClusterTest2() throws Exception {
    WorkstationCluster expectedResponse =
        WorkstationCluster.newBuilder()
            .setName(
                WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setNetwork("network1843485230")
            .setSubnetwork("subnetwork-1302785042")
            .setControlPlaneIp("controlPlaneIp-1263362938")
            .setPrivateClusterConfig(WorkstationCluster.PrivateClusterConfig.newBuilder().build())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7538/locations/location-7538/workstationClusters/workstationCluster-7538";

    WorkstationCluster actualResponse = client.deleteWorkstationClusterAsync(name).get();
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
  public void deleteWorkstationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7538/locations/location-7538/workstationClusters/workstationCluster-7538";
      client.deleteWorkstationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getWorkstationConfigTest() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationConfigName name =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    WorkstationConfig actualResponse = client.getWorkstationConfig(name);
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
  public void getWorkstationConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfigName name =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      client.getWorkstationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkstationConfigTest2() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6150/locations/location-6150/workstationClusters/workstationCluster-6150/workstationConfigs/workstationConfig-6150";

    WorkstationConfig actualResponse = client.getWorkstationConfig(name);
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
  public void getWorkstationConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6150/locations/location-6150/workstationClusters/workstationCluster-6150/workstationConfigs/workstationConfig-6150";
      client.getWorkstationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationConfigsTest() throws Exception {
    WorkstationConfig responsesElement = WorkstationConfig.newBuilder().build();
    ListWorkstationConfigsResponse expectedResponse =
        ListWorkstationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    ListWorkstationConfigsPagedResponse pagedListResponse = client.listWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

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
  public void listWorkstationConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationClusterName parent =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      client.listWorkstationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationConfigsTest2() throws Exception {
    WorkstationConfig responsesElement = WorkstationConfig.newBuilder().build();
    ListWorkstationConfigsResponse expectedResponse =
        ListWorkstationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";

    ListWorkstationConfigsPagedResponse pagedListResponse = client.listWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

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
  public void listWorkstationConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";
      client.listWorkstationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsableWorkstationConfigsTest() throws Exception {
    WorkstationConfig responsesElement = WorkstationConfig.newBuilder().build();
    ListUsableWorkstationConfigsResponse expectedResponse =
        ListUsableWorkstationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    ListUsableWorkstationConfigsPagedResponse pagedListResponse =
        client.listUsableWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

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
  public void listUsableWorkstationConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationClusterName parent =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      client.listUsableWorkstationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsableWorkstationConfigsTest2() throws Exception {
    WorkstationConfig responsesElement = WorkstationConfig.newBuilder().build();
    ListUsableWorkstationConfigsResponse expectedResponse =
        ListUsableWorkstationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstationConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";

    ListUsableWorkstationConfigsPagedResponse pagedListResponse =
        client.listUsableWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

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
  public void listUsableWorkstationConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";
      client.listUsableWorkstationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkstationConfigTest() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
    WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
    String workstationConfigId = "workstationConfigId798542368";

    WorkstationConfig actualResponse =
        client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
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
  public void createWorkstationConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationClusterName parent =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
      String workstationConfigId = "workstationConfigId798542368";
      client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createWorkstationConfigTest2() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";
    WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
    String workstationConfigId = "workstationConfigId798542368";

    WorkstationConfig actualResponse =
        client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
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
  public void createWorkstationConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5665/locations/location-5665/workstationClusters/workstationCluster-5665";
      WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
      String workstationConfigId = "workstationConfigId798542368";
      client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkstationConfigTest() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationConfig workstationConfig =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkstationConfig actualResponse =
        client.updateWorkstationConfigAsync(workstationConfig, updateMask).get();
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
  public void updateWorkstationConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfig workstationConfig =
          WorkstationConfig.newBuilder()
              .setName(
                  WorkstationConfigName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setUid("uid115792")
              .setReconciling(true)
              .putAllAnnotations(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .setIdleTimeout(Duration.newBuilder().build())
              .setRunningTimeout(Duration.newBuilder().build())
              .setHost(WorkstationConfig.Host.newBuilder().build())
              .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
              .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
              .setContainer(WorkstationConfig.Container.newBuilder().build())
              .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
              .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
              .addAllReplicaZones(new ArrayList<String>())
              .setDegraded(true)
              .addAllConditions(new ArrayList<Status>())
              .setEnableAuditAgent(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationConfigAsync(workstationConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationConfigTest() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationConfigName name =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    WorkstationConfig actualResponse = client.deleteWorkstationConfigAsync(name).get();
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
  public void deleteWorkstationConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfigName name =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      client.deleteWorkstationConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationConfigTest2() throws Exception {
    WorkstationConfig expectedResponse =
        WorkstationConfig.newBuilder()
            .setName(
                WorkstationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setIdleTimeout(Duration.newBuilder().build())
            .setRunningTimeout(Duration.newBuilder().build())
            .setHost(WorkstationConfig.Host.newBuilder().build())
            .addAllPersistentDirectories(new ArrayList<WorkstationConfig.PersistentDirectory>())
            .addAllEphemeralDirectories(new ArrayList<WorkstationConfig.EphemeralDirectory>())
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .setEnableAuditAgent(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6150/locations/location-6150/workstationClusters/workstationCluster-6150/workstationConfigs/workstationConfig-6150";

    WorkstationConfig actualResponse = client.deleteWorkstationConfigAsync(name).get();
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
  public void deleteWorkstationConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6150/locations/location-6150/workstationClusters/workstationCluster-6150/workstationConfigs/workstationConfig-6150";
      client.deleteWorkstationConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.getWorkstation(name);
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
  public void getWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationName name =
          WorkstationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKSTATION_CLUSTER]",
              "[WORKSTATION_CONFIG]",
              "[WORKSTATION]");
      client.getWorkstation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkstationTest2() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";

    Workstation actualResponse = client.getWorkstation(name);
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
  public void getWorkstationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";
      client.getWorkstation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationsTest() throws Exception {
    Workstation responsesElement = Workstation.newBuilder().build();
    ListWorkstationsResponse expectedResponse =
        ListWorkstationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    ListWorkstationsPagedResponse pagedListResponse = client.listWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

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
  public void listWorkstationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfigName parent =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      client.listWorkstations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkstationsTest2() throws Exception {
    Workstation responsesElement = Workstation.newBuilder().build();
    ListWorkstationsResponse expectedResponse =
        ListWorkstationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";

    ListWorkstationsPagedResponse pagedListResponse = client.listWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

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
  public void listWorkstationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";
      client.listWorkstations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsableWorkstationsTest() throws Exception {
    Workstation responsesElement = Workstation.newBuilder().build();
    ListUsableWorkstationsResponse expectedResponse =
        ListUsableWorkstationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    ListUsableWorkstationsPagedResponse pagedListResponse = client.listUsableWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

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
  public void listUsableWorkstationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfigName parent =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      client.listUsableWorkstations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsableWorkstationsTest2() throws Exception {
    Workstation responsesElement = Workstation.newBuilder().build();
    ListUsableWorkstationsResponse expectedResponse =
        ListUsableWorkstationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkstations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";

    ListUsableWorkstationsPagedResponse pagedListResponse = client.listUsableWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

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
  public void listUsableWorkstationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";
      client.listUsableWorkstations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
    Workstation workstation = Workstation.newBuilder().build();
    String workstationId = "workstationId560540030";

    Workstation actualResponse =
        client.createWorkstationAsync(parent, workstation, workstationId).get();
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
  public void createWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationConfigName parent =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      Workstation workstation = Workstation.newBuilder().build();
      String workstationId = "workstationId560540030";
      client.createWorkstationAsync(parent, workstation, workstationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createWorkstationTest2() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";
    Workstation workstation = Workstation.newBuilder().build();
    String workstationId = "workstationId560540030";

    Workstation actualResponse =
        client.createWorkstationAsync(parent, workstation, workstationId).get();
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
  public void createWorkstationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4265/locations/location-4265/workstationClusters/workstationCluster-4265/workstationConfigs/workstationConfig-4265";
      Workstation workstation = Workstation.newBuilder().build();
      String workstationId = "workstationId560540030";
      client.createWorkstationAsync(parent, workstation, workstationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Workstation workstation =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workstation actualResponse = client.updateWorkstationAsync(workstation, updateMask).get();
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
  public void updateWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Workstation workstation =
          Workstation.newBuilder()
              .setName(
                  WorkstationName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]",
                          "[WORKSTATION]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setUid("uid115792")
              .setReconciling(true)
              .putAllAnnotations(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setStartTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .setHost("host3208616")
              .putAllEnv(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationAsync(workstation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.deleteWorkstationAsync(name).get();
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
  public void deleteWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationName name =
          WorkstationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKSTATION_CLUSTER]",
              "[WORKSTATION_CONFIG]",
              "[WORKSTATION]");
      client.deleteWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkstationTest2() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";

    Workstation actualResponse = client.deleteWorkstationAsync(name).get();
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
  public void deleteWorkstationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";
      client.deleteWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.startWorkstationAsync(name).get();
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
  public void startWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationName name =
          WorkstationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKSTATION_CLUSTER]",
              "[WORKSTATION_CONFIG]",
              "[WORKSTATION]");
      client.startWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startWorkstationTest2() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";

    Workstation actualResponse = client.startWorkstationAsync(name).get();
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
  public void startWorkstationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";
      client.startWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopWorkstationTest() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.stopWorkstationAsync(name).get();
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
  public void stopWorkstationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkstationName name =
          WorkstationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKSTATION_CLUSTER]",
              "[WORKSTATION_CONFIG]",
              "[WORKSTATION]");
      client.stopWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopWorkstationTest2() throws Exception {
    Workstation expectedResponse =
        Workstation.newBuilder()
            .setName(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setReconciling(true)
            .putAllAnnotations(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setHost("host3208616")
            .putAllEnv(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";

    Workstation actualResponse = client.stopWorkstationAsync(name).get();
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
  public void stopWorkstationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8004/locations/location-8004/workstationClusters/workstationCluster-8004/workstationConfigs/workstationConfig-8004/workstations/workstation-8004";
      client.stopWorkstationAsync(name).get();
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

    WorkstationName workstation =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(workstation);
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
      WorkstationName workstation =
          WorkstationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[WORKSTATION_CLUSTER]",
              "[WORKSTATION_CONFIG]",
              "[WORKSTATION]");
      client.generateAccessToken(workstation);
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

    String workstation =
        "projects/project-2916/locations/location-2916/workstationClusters/workstationCluster-2916/workstationConfigs/workstationConfig-2916/workstations/workstation-2916";

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(workstation);
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
      String workstation =
          "projects/project-2916/locations/location-2916/workstationClusters/workstationCluster-2916/workstationConfigs/workstationConfig-2916/workstations/workstation-2916";
      client.generateAccessToken(workstation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  WorkstationName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]",
                          "[WORKSTATION]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  WorkstationName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]",
                          "[WORKSTATION]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                WorkstationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[WORKSTATION_CLUSTER]",
                        "[WORKSTATION_CONFIG]",
                        "[WORKSTATION]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  WorkstationName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[WORKSTATION_CLUSTER]",
                          "[WORKSTATION_CONFIG]",
                          "[WORKSTATION]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
