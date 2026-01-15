/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListHotTabletsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListLogicalViewsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListMaterializedViewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.CreateLogicalViewRequest;
import com.google.bigtable.admin.v2.CreateMaterializedViewRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.DeleteLogicalViewRequest;
import com.google.bigtable.admin.v2.DeleteMaterializedViewRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.GetLogicalViewRequest;
import com.google.bigtable.admin.v2.GetMaterializedViewRequest;
import com.google.bigtable.admin.v2.HotTablet;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListHotTabletsRequest;
import com.google.bigtable.admin.v2.ListHotTabletsResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.ListLogicalViewsRequest;
import com.google.bigtable.admin.v2.ListLogicalViewsResponse;
import com.google.bigtable.admin.v2.ListMaterializedViewsRequest;
import com.google.bigtable.admin.v2.ListMaterializedViewsResponse;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.LogicalView;
import com.google.bigtable.admin.v2.LogicalViewName;
import com.google.bigtable.admin.v2.MaterializedView;
import com.google.bigtable.admin.v2.MaterializedViewName;
import com.google.bigtable.admin.v2.PartialUpdateClusterRequest;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateLogicalViewRequest;
import com.google.bigtable.admin.v2.UpdateMaterializedViewRequest;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class BaseBigtableInstanceAdminClientTest {
  private static MockBigtableInstanceAdmin mockBigtableInstanceAdmin;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BaseBigtableInstanceAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtableInstanceAdmin = new MockBigtableInstanceAdmin();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBigtableInstanceAdmin));
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
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();
    Map<String, Cluster> clusters = new HashMap<>();

    Instance actualResponse =
        client.createInstanceAsync(parent, instanceId, instance, clusters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(clusters, actualRequest.getClustersMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      Map<String, Cluster> clusters = new HashMap<>();
      client.createInstanceAsync(parent, instanceId, instance, clusters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();
    Map<String, Cluster> clusters = new HashMap<>();

    Instance actualResponse =
        client.createInstanceAsync(parent, instanceId, instance, clusters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(clusters, actualRequest.getClustersMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      Map<String, Cluster> clusters = new HashMap<>();
      client.createInstanceAsync(parent, instanceId, instance, clusters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .addAllInstances(new ArrayList<Instance>())
            .addAllFailedLocations(new ArrayList<String>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstancesResponse actualResponse = client.listInstances(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .addAllInstances(new ArrayList<Instance>())
            .addAllFailedLocations(new ArrayList<String>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesResponse actualResponse = client.listInstances(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    Instance request =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();

    Instance actualResponse = client.updateInstance(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Instance actualRequest = ((Instance) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getDisplayName(), actualRequest.getDisplayName());
    Assert.assertEquals(request.getState(), actualRequest.getState());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertEquals(request.getCreateTime(), actualRequest.getCreateTime());
    Assert.assertEquals(request.getSatisfiesPzs(), actualRequest.getSatisfiesPzs());
    Assert.assertEquals(request.getSatisfiesPzi(), actualRequest.getSatisfiesPzi());
    Assert.assertEquals(request.getTagsMap(), actualRequest.getTagsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      Instance request =
          Instance.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setSatisfiesPzs(true)
              .setSatisfiesPzi(true)
              .putAllTags(new HashMap<String, String>())
              .build();
      client.updateInstance(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void partialUpdateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .putAllTags(new HashMap<String, String>())
            .build();
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

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartialUpdateInstanceRequest actualRequest =
        ((PartialUpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void partialUpdateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.partialUpdateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    client.deleteInstance(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.deleteInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstanceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteInstance(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String clusterId = "clusterId561939637";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(parent, clusterId, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String clusterId = "clusterId561939637";
      Cluster cluster = Cluster.newBuilder().build();
      client.createClusterAsync(parent, clusterId, cluster).get();
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
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String clusterId = "clusterId561939637";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(parent, clusterId, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String clusterId = "clusterId561939637";
      Cluster cluster = Cluster.newBuilder().build();
      client.createClusterAsync(parent, clusterId, cluster).get();
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
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
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
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest() throws Exception {
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .addAllClusters(new ArrayList<Cluster>())
            .addAllFailedLocations(new ArrayList<String>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListClustersResponse actualResponse = client.listClusters(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest2() throws Exception {
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .addAllClusters(new ArrayList<Cluster>())
            .addAllFailedLocations(new ArrayList<String>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClustersResponse actualResponse = client.listClusters(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    Cluster request =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();

    Cluster actualResponse = client.updateClusterAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Cluster actualRequest = ((Cluster) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getState(), actualRequest.getState());
    Assert.assertEquals(request.getServeNodes(), actualRequest.getServeNodes());
    Assert.assertEquals(request.getNodeScalingFactor(), actualRequest.getNodeScalingFactor());
    Assert.assertEquals(request.getClusterConfig(), actualRequest.getClusterConfig());
    Assert.assertEquals(request.getDefaultStorageType(), actualRequest.getDefaultStorageType());
    Assert.assertEquals(request.getEncryptionConfig(), actualRequest.getEncryptionConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      Cluster request =
          Cluster.newBuilder()
              .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
              .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setServeNodes(-1288838783)
              .setDefaultStorageType(StorageType.forNumber(0))
              .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
              .build();
      client.updateClusterAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void partialUpdateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setServeNodes(-1288838783)
            .setDefaultStorageType(StorageType.forNumber(0))
            .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("partialUpdateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    Cluster cluster = Cluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.partialUpdateClusterAsync(cluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PartialUpdateClusterRequest actualRequest =
        ((PartialUpdateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void partialUpdateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      Cluster cluster = Cluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.partialUpdateClusterAsync(cluster, updateMask).get();
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
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    client.deleteCluster(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
      client.deleteCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCluster(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
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
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppProfileTest() throws Exception {
    AppProfile expectedResponse =
        AppProfile.newBuilder()
            .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String appProfileId = "appProfileId704923523";
    AppProfile appProfile = AppProfile.newBuilder().build();

    AppProfile actualResponse = client.createAppProfile(parent, appProfileId, appProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppProfileRequest actualRequest = ((CreateAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertEquals(appProfile, actualRequest.getAppProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String appProfileId = "appProfileId704923523";
      AppProfile appProfile = AppProfile.newBuilder().build();
      client.createAppProfile(parent, appProfileId, appProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppProfileTest2() throws Exception {
    AppProfile expectedResponse =
        AppProfile.newBuilder()
            .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String appProfileId = "appProfileId704923523";
    AppProfile appProfile = AppProfile.newBuilder().build();

    AppProfile actualResponse = client.createAppProfile(parent, appProfileId, appProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppProfileRequest actualRequest = ((CreateAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertEquals(appProfile, actualRequest.getAppProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String appProfileId = "appProfileId704923523";
      AppProfile appProfile = AppProfile.newBuilder().build();
      client.createAppProfile(parent, appProfileId, appProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppProfileTest() throws Exception {
    AppProfile expectedResponse =
        AppProfile.newBuilder()
            .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

    AppProfile actualResponse = client.getAppProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppProfileRequest actualRequest = ((GetAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
      client.getAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppProfileTest2() throws Exception {
    AppProfile expectedResponse =
        AppProfile.newBuilder()
            .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    AppProfile actualResponse = client.getAppProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppProfileRequest actualRequest = ((GetAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppProfilesTest() throws Exception {
    AppProfile responsesElement = AppProfile.newBuilder().build();
    ListAppProfilesResponse expectedResponse =
        ListAppProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppProfiles(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListAppProfilesPagedResponse pagedListResponse = client.listAppProfiles(parent);

    List<AppProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppProfilesRequest actualRequest = ((ListAppProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listAppProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppProfilesTest2() throws Exception {
    AppProfile responsesElement = AppProfile.newBuilder().build();
    ListAppProfilesResponse expectedResponse =
        ListAppProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppProfiles(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAppProfilesPagedResponse pagedListResponse = client.listAppProfiles(parent);

    List<AppProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppProfilesRequest actualRequest = ((ListAppProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAppProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAppProfileTest() throws Exception {
    AppProfile expectedResponse =
        AppProfile.newBuilder()
            .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
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

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAppProfileRequest actualRequest = ((UpdateAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(appProfile, actualRequest.getAppProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfile appProfile = AppProfile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAppProfileAsync(appProfile, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAppProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");

    client.deleteAppProfile(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppProfileRequest actualRequest = ((DeleteAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
      client.deleteAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAppProfile(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppProfileRequest actualRequest = ((DeleteAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAppProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppProfileTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
    boolean ignoreWarnings = true;

    client.deleteAppProfile(name, ignoreWarnings);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppProfileRequest actualRequest = ((DeleteAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(ignoreWarnings, actualRequest.getIgnoreWarnings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppProfileExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
      boolean ignoreWarnings = true;
      client.deleteAppProfile(name, ignoreWarnings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppProfileTest4() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";
    boolean ignoreWarnings = true;

    client.deleteAppProfile(name, ignoreWarnings);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppProfileRequest actualRequest = ((DeleteAppProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(ignoreWarnings, actualRequest.getIgnoreWarnings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppProfileExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      boolean ignoreWarnings = true;
      client.deleteAppProfile(name, ignoreWarnings);
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
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHotTabletsTest() throws Exception {
    HotTablet responsesElement = HotTablet.newBuilder().build();
    ListHotTabletsResponse expectedResponse =
        ListHotTabletsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHotTablets(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    ListHotTabletsPagedResponse pagedListResponse = client.listHotTablets(parent);

    List<HotTablet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHotTabletsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHotTabletsRequest actualRequest = ((ListHotTabletsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHotTabletsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
      client.listHotTablets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHotTabletsTest2() throws Exception {
    HotTablet responsesElement = HotTablet.newBuilder().build();
    ListHotTabletsResponse expectedResponse =
        ListHotTabletsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHotTablets(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHotTabletsPagedResponse pagedListResponse = client.listHotTablets(parent);

    List<HotTablet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHotTabletsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHotTabletsRequest actualRequest = ((ListHotTabletsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHotTabletsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHotTablets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLogicalViewTest() throws Exception {
    LogicalView expectedResponse =
        LogicalView.newBuilder()
            .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLogicalViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    LogicalView logicalView = LogicalView.newBuilder().build();
    String logicalViewId = "logicalViewId-1408054263";

    LogicalView actualResponse =
        client.createLogicalViewAsync(parent, logicalView, logicalViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLogicalViewRequest actualRequest = ((CreateLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(logicalView, actualRequest.getLogicalView());
    Assert.assertEquals(logicalViewId, actualRequest.getLogicalViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLogicalViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      LogicalView logicalView = LogicalView.newBuilder().build();
      String logicalViewId = "logicalViewId-1408054263";
      client.createLogicalViewAsync(parent, logicalView, logicalViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLogicalViewTest2() throws Exception {
    LogicalView expectedResponse =
        LogicalView.newBuilder()
            .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLogicalViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    LogicalView logicalView = LogicalView.newBuilder().build();
    String logicalViewId = "logicalViewId-1408054263";

    LogicalView actualResponse =
        client.createLogicalViewAsync(parent, logicalView, logicalViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLogicalViewRequest actualRequest = ((CreateLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(logicalView, actualRequest.getLogicalView());
    Assert.assertEquals(logicalViewId, actualRequest.getLogicalViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLogicalViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      LogicalView logicalView = LogicalView.newBuilder().build();
      String logicalViewId = "logicalViewId-1408054263";
      client.createLogicalViewAsync(parent, logicalView, logicalViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getLogicalViewTest() throws Exception {
    LogicalView expectedResponse =
        LogicalView.newBuilder()
            .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");

    LogicalView actualResponse = client.getLogicalView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalViewRequest actualRequest = ((GetLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");
      client.getLogicalView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalViewTest2() throws Exception {
    LogicalView expectedResponse =
        LogicalView.newBuilder()
            .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    LogicalView actualResponse = client.getLogicalView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalViewRequest actualRequest = ((GetLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getLogicalView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalViewsTest() throws Exception {
    LogicalView responsesElement = LogicalView.newBuilder().build();
    ListLogicalViewsResponse expectedResponse =
        ListLogicalViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalViews(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListLogicalViewsPagedResponse pagedListResponse = client.listLogicalViews(parent);

    List<LogicalView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogicalViewsRequest actualRequest = ((ListLogicalViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogicalViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listLogicalViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalViewsTest2() throws Exception {
    LogicalView responsesElement = LogicalView.newBuilder().build();
    ListLogicalViewsResponse expectedResponse =
        ListLogicalViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalViews(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLogicalViewsPagedResponse pagedListResponse = client.listLogicalViews(parent);

    List<LogicalView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogicalViewsRequest actualRequest = ((ListLogicalViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogicalViewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLogicalViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLogicalViewTest() throws Exception {
    LogicalView expectedResponse =
        LogicalView.newBuilder()
            .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLogicalViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    LogicalView logicalView = LogicalView.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogicalView actualResponse = client.updateLogicalViewAsync(logicalView, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLogicalViewRequest actualRequest = ((UpdateLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(logicalView, actualRequest.getLogicalView());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLogicalViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      LogicalView logicalView = LogicalView.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLogicalViewAsync(logicalView, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLogicalViewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");

    client.deleteLogicalView(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogicalViewRequest actualRequest = ((DeleteLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLogicalViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");
      client.deleteLogicalView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLogicalViewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteLogicalView(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLogicalViewRequest actualRequest = ((DeleteLogicalViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLogicalViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLogicalView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMaterializedViewTest() throws Exception {
    MaterializedView expectedResponse =
        MaterializedView.newBuilder()
            .setName(
                MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
                    .toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMaterializedViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    MaterializedView materializedView = MaterializedView.newBuilder().build();
    String materializedViewId = "materializedViewId682270903";

    MaterializedView actualResponse =
        client.createMaterializedViewAsync(parent, materializedView, materializedViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMaterializedViewRequest actualRequest =
        ((CreateMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(materializedView, actualRequest.getMaterializedView());
    Assert.assertEquals(materializedViewId, actualRequest.getMaterializedViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMaterializedViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      MaterializedView materializedView = MaterializedView.newBuilder().build();
      String materializedViewId = "materializedViewId682270903";
      client.createMaterializedViewAsync(parent, materializedView, materializedViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMaterializedViewTest2() throws Exception {
    MaterializedView expectedResponse =
        MaterializedView.newBuilder()
            .setName(
                MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
                    .toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMaterializedViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    MaterializedView materializedView = MaterializedView.newBuilder().build();
    String materializedViewId = "materializedViewId682270903";

    MaterializedView actualResponse =
        client.createMaterializedViewAsync(parent, materializedView, materializedViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMaterializedViewRequest actualRequest =
        ((CreateMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(materializedView, actualRequest.getMaterializedView());
    Assert.assertEquals(materializedViewId, actualRequest.getMaterializedViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMaterializedViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      MaterializedView materializedView = MaterializedView.newBuilder().build();
      String materializedViewId = "materializedViewId682270903";
      client.createMaterializedViewAsync(parent, materializedView, materializedViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getMaterializedViewTest() throws Exception {
    MaterializedView expectedResponse =
        MaterializedView.newBuilder()
            .setName(
                MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
                    .toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    MaterializedViewName name =
        MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");

    MaterializedView actualResponse = client.getMaterializedView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMaterializedViewRequest actualRequest = ((GetMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMaterializedViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      MaterializedViewName name =
          MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");
      client.getMaterializedView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMaterializedViewTest2() throws Exception {
    MaterializedView expectedResponse =
        MaterializedView.newBuilder()
            .setName(
                MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
                    .toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    MaterializedView actualResponse = client.getMaterializedView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMaterializedViewRequest actualRequest = ((GetMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMaterializedViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getMaterializedView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMaterializedViewsTest() throws Exception {
    MaterializedView responsesElement = MaterializedView.newBuilder().build();
    ListMaterializedViewsResponse expectedResponse =
        ListMaterializedViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMaterializedViews(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListMaterializedViewsPagedResponse pagedListResponse = client.listMaterializedViews(parent);

    List<MaterializedView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMaterializedViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMaterializedViewsRequest actualRequest =
        ((ListMaterializedViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMaterializedViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listMaterializedViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMaterializedViewsTest2() throws Exception {
    MaterializedView responsesElement = MaterializedView.newBuilder().build();
    ListMaterializedViewsResponse expectedResponse =
        ListMaterializedViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMaterializedViews(Arrays.asList(responsesElement))
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMaterializedViewsPagedResponse pagedListResponse = client.listMaterializedViews(parent);

    List<MaterializedView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMaterializedViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMaterializedViewsRequest actualRequest =
        ((ListMaterializedViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMaterializedViewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMaterializedViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMaterializedViewTest() throws Exception {
    MaterializedView expectedResponse =
        MaterializedView.newBuilder()
            .setName(
                MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
                    .toString())
            .setQuery("query107944136")
            .setEtag("etag3123477")
            .setDeletionProtection(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMaterializedViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    MaterializedView materializedView = MaterializedView.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MaterializedView actualResponse =
        client.updateMaterializedViewAsync(materializedView, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMaterializedViewRequest actualRequest =
        ((UpdateMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(materializedView, actualRequest.getMaterializedView());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMaterializedViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      MaterializedView materializedView = MaterializedView.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMaterializedViewAsync(materializedView, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMaterializedViewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    MaterializedViewName name =
        MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");

    client.deleteMaterializedView(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMaterializedViewRequest actualRequest =
        ((DeleteMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMaterializedViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      MaterializedViewName name =
          MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");
      client.deleteMaterializedView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMaterializedViewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMaterializedView(name);

    List<AbstractMessage> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMaterializedViewRequest actualRequest =
        ((DeleteMaterializedViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMaterializedViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMaterializedView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
