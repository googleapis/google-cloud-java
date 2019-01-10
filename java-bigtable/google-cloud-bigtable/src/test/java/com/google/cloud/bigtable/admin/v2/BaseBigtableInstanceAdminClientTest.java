/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BaseBigtableInstanceAdminClientTest {
  private static MockBigtableInstanceAdmin mockBigtableInstanceAdmin;
  private static MockBigtableTableAdmin mockBigtableTableAdmin;
  private static MockServiceHelper serviceHelper;
  private BaseBigtableInstanceAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtableInstanceAdmin = new MockBigtableInstanceAdmin();
    mockBigtableTableAdmin = new MockBigtableTableAdmin();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockBigtableInstanceAdmin, mockBigtableTableAdmin));
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
    BaseBigtableInstanceAdminSettings settings =
        BaseBigtableInstanceAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BaseBigtableInstanceAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceTest() throws Exception {
    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance expectedResponse =
        Instance.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String instanceId = "instanceId-2101995259";
    Instance instance = Instance.newBuilder().build();
    Map<String, Cluster> clusters = new HashMap<>();

    Instance actualResponse =
        client.createInstanceAsync(parent, instanceId, instance, clusters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = (CreateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(clusters, actualRequest.getClustersMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String instanceId = "instanceId-2101995259";
      Instance instance = Instance.newBuilder().build();
      Map<String, Cluster> clusters = new HashMap<>();

      client.createInstanceAsync(parent, instanceId, instance, clusters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceTest() {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance expectedResponse =
        Instance.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = (GetInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstanceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstancesResponse actualResponse = client.listInstances(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = (ListInstancesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void partialUpdateInstanceTest() throws Exception {
    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance expectedResponse =
        Instance.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("partialUpdateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.partialUpdateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartialUpdateInstanceRequest actualRequest =
        (PartialUpdateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void partialUpdateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.partialUpdateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    client.deleteInstance(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = (DeleteInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstanceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.deleteInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterTest() throws Exception {
    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes = 1288838783;
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(name.toString())
            .setLocation(location.toString())
            .setServeNodes(serveNodes)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String clusterId = "clusterId240280960";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(parent, clusterId, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = (CreateClusterRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InstanceName.parse(actualRequest.getParent()));
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String clusterId = "clusterId240280960";
      Cluster cluster = Cluster.newBuilder().build();

      client.createClusterAsync(parent, clusterId, cluster).get();
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
    ClusterName name2 = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes = 1288838783;
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(name2.toString())
            .setLocation(location.toString())
            .setServeNodes(serveNodes)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = (GetClusterRequest) actualRequests.get(0);

    Assert.assertEquals(name, ClusterName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListClustersResponse actualResponse = client.listClusters(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = (ListClustersRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InstanceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    client.deleteCluster(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = (DeleteClusterRequest) actualRequests.get(0);

    Assert.assertEquals(name, ClusterName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

      client.deleteCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAppProfileTest() {
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    AppProfile expectedResponse =
        AppProfile.newBuilder().setName(name).setEtag(etag).setDescription(description).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String appProfileId = "appProfileId1262094415";
    AppProfile appProfile = AppProfile.newBuilder().build();

    AppProfile actualResponse = client.createAppProfile(parent, appProfileId, appProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppProfileRequest actualRequest = (CreateAppProfileRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InstanceName.parse(actualRequest.getParent()));
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertEquals(appProfile, actualRequest.getAppProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String appProfileId = "appProfileId1262094415";
      AppProfile appProfile = AppProfile.newBuilder().build();

      client.createAppProfile(parent, appProfileId, appProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAppProfileTest() {
    String name2 = "name2-1052831874";
    String etag = "etag3123477";
    String description = "description-1724546052";
    AppProfile expectedResponse =
        AppProfile.newBuilder().setName(name2).setEtag(etag).setDescription(description).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

    AppProfile actualResponse = client.getAppProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppProfileRequest actualRequest = (GetAppProfileRequest) actualRequests.get(0);

    Assert.assertEquals(name, AppProfileName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

      client.getAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAppProfilesTest() {
    String nextPageToken = "";
    AppProfile appProfilesElement = AppProfile.newBuilder().build();
    List<AppProfile> appProfiles = Arrays.asList(appProfilesElement);
    ListAppProfilesResponse expectedResponse =
        ListAppProfilesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAppProfiles(appProfiles)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListAppProfilesPagedResponse pagedListResponse = client.listAppProfiles(parent);

    List<AppProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppProfilesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppProfilesRequest actualRequest = (ListAppProfilesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InstanceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAppProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.listAppProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAppProfileTest() throws Exception {
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    AppProfile expectedResponse =
        AppProfile.newBuilder().setName(name).setEtag(etag).setDescription(description).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAppProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    AppProfile appProfile = AppProfile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AppProfile actualResponse = client.updateAppProfileAsync(appProfile, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAppProfileRequest actualRequest = (UpdateAppProfileRequest) actualRequests.get(0);

    Assert.assertEquals(appProfile, actualRequest.getAppProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfile appProfile = AppProfile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateAppProfileAsync(appProfile, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAppProfileTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

    client.deleteAppProfile(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppProfileRequest actualRequest = (DeleteAppProfileRequest) actualRequests.get(0);

    Assert.assertEquals(name, AppProfileName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

      client.deleteAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("etag3123477");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("etag3123477");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
