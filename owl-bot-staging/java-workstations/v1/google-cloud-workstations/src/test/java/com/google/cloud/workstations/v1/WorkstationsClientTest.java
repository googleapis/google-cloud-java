/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.workstations.v1;

import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class WorkstationsClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockWorkstations mockWorkstations;
  private LocalChannelProvider channelProvider;
  private WorkstationsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWorkstations = new MockWorkstations();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWorkstations, mockLocations, mockIAMPolicy));
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
    WorkstationsSettings settings =
        WorkstationsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WorkstationsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationClusterName name =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    WorkstationCluster actualResponse = client.getWorkstationCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationClusterRequest actualRequest =
        ((GetWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String name = "name3373707";

    WorkstationCluster actualResponse = client.getWorkstationCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationClusterRequest actualRequest =
        ((GetWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkstations.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkstationClustersPagedResponse pagedListResponse = client.listWorkstationClusters(parent);

    List<WorkstationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationClustersRequest actualRequest =
        ((ListWorkstationClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkstationClustersPagedResponse pagedListResponse = client.listWorkstationClusters(parent);

    List<WorkstationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationClustersRequest actualRequest =
        ((ListWorkstationClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkstations.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
    String workstationClusterId = "workstationClusterId351421170";

    WorkstationCluster actualResponse =
        client
            .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationClusterRequest actualRequest =
        ((CreateWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workstationCluster, actualRequest.getWorkstationCluster());
    Assert.assertEquals(workstationClusterId, actualRequest.getWorkstationClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      String workstationClusterId = "workstationClusterId351421170";
      client.createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkstations.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
    String workstationClusterId = "workstationClusterId351421170";

    WorkstationCluster actualResponse =
        client
            .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationClusterRequest actualRequest =
        ((CreateWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workstationCluster, actualRequest.getWorkstationCluster());
    Assert.assertEquals(workstationClusterId, actualRequest.getWorkstationClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      String workstationClusterId = "workstationClusterId351421170";
      client.createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkstations.addResponse(resultOperation);

    WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkstationCluster actualResponse =
        client.updateWorkstationClusterAsync(workstationCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkstationClusterRequest actualRequest =
        ((UpdateWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(workstationCluster, actualRequest.getWorkstationCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkstationClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationClusterAsync(workstationCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkstations.addResponse(resultOperation);

    WorkstationClusterName name =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    WorkstationCluster actualResponse = client.deleteWorkstationClusterAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationClusterRequest actualRequest =
        ((DeleteWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationClusterName name =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      client.deleteWorkstationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWorkstations.addResponse(resultOperation);

    String name = "name3373707";

    WorkstationCluster actualResponse = client.deleteWorkstationClusterAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationClusterRequest actualRequest =
        ((DeleteWorkstationClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkstationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    mockWorkstations.addResponse(expectedResponse);

    WorkstationConfigName name =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    WorkstationConfig actualResponse = client.getWorkstationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationConfigRequest actualRequest =
        ((GetWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    mockWorkstations.addResponse(expectedResponse);

    String name = "name3373707";

    WorkstationConfig actualResponse = client.getWorkstationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationConfigRequest actualRequest =
        ((GetWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    ListWorkstationConfigsPagedResponse pagedListResponse = client.listWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationConfigsRequest actualRequest =
        ((ListWorkstationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkstationConfigsPagedResponse pagedListResponse = client.listWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationConfigsRequest actualRequest =
        ((ListWorkstationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");

    ListUsableWorkstationConfigsPagedResponse pagedListResponse =
        client.listUsableWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsableWorkstationConfigsRequest actualRequest =
        ((ListUsableWorkstationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsableWorkstationConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUsableWorkstationConfigsPagedResponse pagedListResponse =
        client.listUsableWorkstationConfigs(parent);

    List<WorkstationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsableWorkstationConfigsRequest actualRequest =
        ((ListUsableWorkstationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsableWorkstationConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationClusterName parent =
        WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
    WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
    String workstationConfigId = "workstationConfigId798542368";

    WorkstationConfig actualResponse =
        client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationConfigRequest actualRequest =
        ((CreateWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workstationConfig, actualRequest.getWorkstationConfig());
    Assert.assertEquals(workstationConfigId, actualRequest.getWorkstationConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationClusterName parent =
          WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
      WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
      String workstationConfigId = "workstationConfigId798542368";
      client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
    String workstationConfigId = "workstationConfigId798542368";

    WorkstationConfig actualResponse =
        client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationConfigRequest actualRequest =
        ((CreateWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workstationConfig, actualRequest.getWorkstationConfig());
    Assert.assertEquals(workstationConfigId, actualRequest.getWorkstationConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
      String workstationConfigId = "workstationConfigId798542368";
      client.createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkstationConfig actualResponse =
        client.updateWorkstationConfigAsync(workstationConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkstationConfigRequest actualRequest =
        ((UpdateWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(workstationConfig, actualRequest.getWorkstationConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkstationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationConfigAsync(workstationConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationConfigName name =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    WorkstationConfig actualResponse = client.deleteWorkstationConfigAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationConfigRequest actualRequest =
        ((DeleteWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationConfigName name =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      client.deleteWorkstationConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setContainer(WorkstationConfig.Container.newBuilder().build())
            .setEncryptionKey(WorkstationConfig.CustomerEncryptionKey.newBuilder().build())
            .addAllReadinessChecks(new ArrayList<WorkstationConfig.ReadinessCheck>())
            .addAllReplicaZones(new ArrayList<String>())
            .setDegraded(true)
            .addAllConditions(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String name = "name3373707";

    WorkstationConfig actualResponse = client.deleteWorkstationConfigAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationConfigRequest actualRequest =
        ((DeleteWorkstationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkstationConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    mockWorkstations.addResponse(expectedResponse);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.getWorkstation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationRequest actualRequest = ((GetWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
            .build();
    mockWorkstations.addResponse(expectedResponse);

    String name = "name3373707";

    Workstation actualResponse = client.getWorkstation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkstationRequest actualRequest = ((GetWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkstationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    ListWorkstationsPagedResponse pagedListResponse = client.listWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationsRequest actualRequest = ((ListWorkstationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkstationsPagedResponse pagedListResponse = client.listWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkstationsRequest actualRequest = ((ListWorkstationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkstationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");

    ListUsableWorkstationsPagedResponse pagedListResponse = client.listUsableWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsableWorkstationsRequest actualRequest =
        ((ListUsableWorkstationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsableWorkstationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUsableWorkstationsPagedResponse pagedListResponse = client.listUsableWorkstations(parent);

    List<Workstation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkstationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsableWorkstationsRequest actualRequest =
        ((ListUsableWorkstationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsableWorkstationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationConfigName parent =
        WorkstationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
    Workstation workstation = Workstation.newBuilder().build();
    String workstationId = "workstationId560540030";

    Workstation actualResponse =
        client.createWorkstationAsync(parent, workstation, workstationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationRequest actualRequest = ((CreateWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workstation, actualRequest.getWorkstation());
    Assert.assertEquals(workstationId, actualRequest.getWorkstationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      WorkstationConfigName parent =
          WorkstationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
      Workstation workstation = Workstation.newBuilder().build();
      String workstationId = "workstationId560540030";
      client.createWorkstationAsync(parent, workstation, workstationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String parent = "parent-995424086";
    Workstation workstation = Workstation.newBuilder().build();
    String workstationId = "workstationId560540030";

    Workstation actualResponse =
        client.createWorkstationAsync(parent, workstation, workstationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkstationRequest actualRequest = ((CreateWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workstation, actualRequest.getWorkstation());
    Assert.assertEquals(workstationId, actualRequest.getWorkstationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkstationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String parent = "parent-995424086";
      Workstation workstation = Workstation.newBuilder().build();
      String workstationId = "workstationId560540030";
      client.createWorkstationAsync(parent, workstation, workstationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    Workstation workstation = Workstation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workstation actualResponse = client.updateWorkstationAsync(workstation, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkstationRequest actualRequest = ((UpdateWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(workstation, actualRequest.getWorkstation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      Workstation workstation = Workstation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkstationAsync(workstation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.deleteWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationRequest actualRequest = ((DeleteWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String name = "name3373707";

    Workstation actualResponse = client.deleteWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkstationRequest actualRequest = ((DeleteWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkstationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.startWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartWorkstationRequest actualRequest = ((StartWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String name = "name3373707";

    Workstation actualResponse = client.startWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartWorkstationRequest actualRequest = ((StartWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startWorkstationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
      client.startWorkstationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    WorkstationName name =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    Workstation actualResponse = client.stopWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopWorkstationRequest actualRequest = ((StopWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopWorkstationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopWorkstationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWorkstations.addResponse(resultOperation);

    String name = "name3373707";

    Workstation actualResponse = client.stopWorkstationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopWorkstationRequest actualRequest = ((StopWorkstationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopWorkstationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String name = "name3373707";
      client.stopWorkstationAsync(name).get();
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
    mockWorkstations.addResponse(expectedResponse);

    WorkstationName workstation =
        WorkstationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[WORKSTATION_CLUSTER]",
            "[WORKSTATION_CONFIG]",
            "[WORKSTATION]");

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(workstation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(workstation.toString(), actualRequest.getWorkstation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

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
    mockWorkstations.addResponse(expectedResponse);

    String workstation = "workstation581588227";

    GenerateAccessTokenResponse actualResponse = client.generateAccessToken(workstation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWorkstations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = ((GenerateAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(workstation, actualRequest.getWorkstation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAccessTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWorkstations.addException(exception);

    try {
      String workstation = "workstation581588227";
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
    mockIAMPolicy.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
    mockIAMPolicy.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
    mockIAMPolicy.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
