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

package com.google.cloud.spanner.admin.instance.v1;

import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
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
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.DeleteInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.FreeInstanceMetadata;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceConfigName;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.admin.instance.v1.InstancePartition;
import com.google.spanner.admin.instance.v1.InstancePartitionName;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.MoveInstanceRequest;
import com.google.spanner.admin.instance.v1.MoveInstanceResponse;
import com.google.spanner.admin.instance.v1.ProjectName;
import com.google.spanner.admin.instance.v1.ReplicaComputeCapacity;
import com.google.spanner.admin.instance.v1.ReplicaInfo;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
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
public class InstanceAdminClientTest {
  private static MockInstanceAdmin mockInstanceAdmin;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private InstanceAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockInstanceAdmin = new MockInstanceAdmin();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockInstanceAdmin));
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
    InstanceAdminSettings settings =
        InstanceAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InstanceAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listInstanceConfigsTest() throws Exception {
    InstanceConfig responsesElement = InstanceConfig.newBuilder().build();
    ListInstanceConfigsResponse expectedResponse =
        ListInstanceConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstanceConfigs(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstanceConfigsPagedResponse pagedListResponse = client.listInstanceConfigs(parent);

    List<InstanceConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstanceConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstanceConfigsRequest actualRequest = ((ListInstanceConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstanceConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listInstanceConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstanceConfigsTest2() throws Exception {
    InstanceConfig responsesElement = InstanceConfig.newBuilder().build();
    ListInstanceConfigsResponse expectedResponse =
        ListInstanceConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstanceConfigs(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstanceConfigsPagedResponse pagedListResponse = client.listInstanceConfigs(parent);

    List<InstanceConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstanceConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstanceConfigsRequest actualRequest = ((ListInstanceConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstanceConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstanceConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceConfigTest() throws Exception {
    InstanceConfig expectedResponse =
        InstanceConfig.newBuilder()
            .setName(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .addAllReplicas(new ArrayList<ReplicaInfo>())
            .addAllOptionalReplicas(new ArrayList<ReplicaInfo>())
            .setBaseConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllLeaderOptions(new ArrayList<String>())
            .setReconciling(true)
            .setStorageLimitPerProcessingUnit(-1769187130)
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceConfigName name = InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]");

    InstanceConfig actualResponse = client.getInstanceConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceConfigRequest actualRequest = ((GetInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceConfigName name = InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]");
      client.getInstanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceConfigTest2() throws Exception {
    InstanceConfig expectedResponse =
        InstanceConfig.newBuilder()
            .setName(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .addAllReplicas(new ArrayList<ReplicaInfo>())
            .addAllOptionalReplicas(new ArrayList<ReplicaInfo>())
            .setBaseConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllLeaderOptions(new ArrayList<String>())
            .setReconciling(true)
            .setStorageLimitPerProcessingUnit(-1769187130)
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    InstanceConfig actualResponse = client.getInstanceConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceConfigRequest actualRequest = ((GetInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getInstanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstanceConfigTest() throws Exception {
    InstanceConfig expectedResponse =
        InstanceConfig.newBuilder()
            .setName(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .addAllReplicas(new ArrayList<ReplicaInfo>())
            .addAllOptionalReplicas(new ArrayList<ReplicaInfo>())
            .setBaseConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllLeaderOptions(new ArrayList<String>())
            .setReconciling(true)
            .setStorageLimitPerProcessingUnit(-1769187130)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
    String instanceConfigId = "instanceConfigId1750947762";

    InstanceConfig actualResponse =
        client.createInstanceConfigAsync(parent, instanceConfig, instanceConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceConfigRequest actualRequest =
        ((CreateInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instanceConfig, actualRequest.getInstanceConfig());
    Assert.assertEquals(instanceConfigId, actualRequest.getInstanceConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
      String instanceConfigId = "instanceConfigId1750947762";
      client.createInstanceConfigAsync(parent, instanceConfig, instanceConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstanceConfigTest2() throws Exception {
    InstanceConfig expectedResponse =
        InstanceConfig.newBuilder()
            .setName(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .addAllReplicas(new ArrayList<ReplicaInfo>())
            .addAllOptionalReplicas(new ArrayList<ReplicaInfo>())
            .setBaseConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllLeaderOptions(new ArrayList<String>())
            .setReconciling(true)
            .setStorageLimitPerProcessingUnit(-1769187130)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
    String instanceConfigId = "instanceConfigId1750947762";

    InstanceConfig actualResponse =
        client.createInstanceConfigAsync(parent, instanceConfig, instanceConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceConfigRequest actualRequest =
        ((CreateInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceConfig, actualRequest.getInstanceConfig());
    Assert.assertEquals(instanceConfigId, actualRequest.getInstanceConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
      String instanceConfigId = "instanceConfigId1750947762";
      client.createInstanceConfigAsync(parent, instanceConfig, instanceConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceConfigTest() throws Exception {
    InstanceConfig expectedResponse =
        InstanceConfig.newBuilder()
            .setName(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .addAllReplicas(new ArrayList<ReplicaInfo>())
            .addAllOptionalReplicas(new ArrayList<ReplicaInfo>())
            .setBaseConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllLeaderOptions(new ArrayList<String>())
            .setReconciling(true)
            .setStorageLimitPerProcessingUnit(-1769187130)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InstanceConfig actualResponse =
        client.updateInstanceConfigAsync(instanceConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceConfigRequest actualRequest =
        ((UpdateInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(instanceConfig, actualRequest.getInstanceConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceConfig instanceConfig = InstanceConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceConfigAsync(instanceConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceConfigName name = InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]");

    client.deleteInstanceConfig(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceConfigRequest actualRequest =
        ((DeleteInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceConfigName name = InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]");
      client.deleteInstanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstanceConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteInstanceConfig(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceConfigRequest actualRequest =
        ((DeleteInstanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstanceConfigOperationsTest() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListInstanceConfigOperationsResponse expectedResponse =
        ListInstanceConfigOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstanceConfigOperationsPagedResponse pagedListResponse =
        client.listInstanceConfigOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstanceConfigOperationsRequest actualRequest =
        ((ListInstanceConfigOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstanceConfigOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listInstanceConfigOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstanceConfigOperationsTest2() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListInstanceConfigOperationsResponse expectedResponse =
        ListInstanceConfigOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstanceConfigOperationsPagedResponse pagedListResponse =
        client.listInstanceConfigOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstanceConfigOperationsRequest actualRequest =
        ((ListInstanceConfigOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstanceConfigOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstanceConfigOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancePartitionsTest() throws Exception {
    InstancePartition responsesElement = InstancePartition.newBuilder().build();
    ListInstancePartitionsResponse expectedResponse =
        ListInstancePartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstancePartitions(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListInstancePartitionsPagedResponse pagedListResponse = client.listInstancePartitions(parent);

    List<InstancePartition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancePartitionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancePartitionsRequest actualRequest =
        ((ListInstancePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listInstancePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancePartitionsTest2() throws Exception {
    InstancePartition responsesElement = InstancePartition.newBuilder().build();
    ListInstancePartitionsResponse expectedResponse =
        ListInstancePartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstancePartitions(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancePartitionsPagedResponse pagedListResponse = client.listInstancePartitions(parent);

    List<InstancePartition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancePartitionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancePartitionsRequest actualRequest =
        ((ListInstancePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancePartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstancePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setNodeCount(1539922066)
            .setProcessingUnits(-329117885)
            .addAllReplicaComputeCapacity(new ArrayList<ReplicaComputeCapacity>())
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllEndpointUris(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFreeInstanceMetadata(FreeInstanceMetadata.newBuilder().build())
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setNodeCount(1539922066)
            .setProcessingUnits(-329117885)
            .addAllReplicaComputeCapacity(new ArrayList<ReplicaComputeCapacity>())
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllEndpointUris(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFreeInstanceMetadata(FreeInstanceMetadata.newBuilder().build())
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setNodeCount(1539922066)
            .setProcessingUnits(-329117885)
            .addAllReplicaComputeCapacity(new ArrayList<ReplicaComputeCapacity>())
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllEndpointUris(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFreeInstanceMetadata(FreeInstanceMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, instance).get();
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
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setNodeCount(1539922066)
            .setProcessingUnits(-329117885)
            .addAllReplicaComputeCapacity(new ArrayList<ReplicaComputeCapacity>())
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllEndpointUris(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFreeInstanceMetadata(FreeInstanceMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String instanceId = "instanceId902024336";
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instanceId, instance).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String instanceId = "instanceId902024336";
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instanceId, instance).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setNodeCount(1539922066)
            .setProcessingUnits(-329117885)
            .addAllReplicaComputeCapacity(new ArrayList<ReplicaComputeCapacity>())
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllEndpointUris(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFreeInstanceMetadata(FreeInstanceMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask fieldMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, fieldMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(fieldMask, actualRequest.getFieldMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask fieldMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, fieldMask).get();
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
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    client.deleteInstance(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteInstance(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstance(name);
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
    mockInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
    mockInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
    mockInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockInstanceAdmin.addResponse(expectedResponse);

    ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
    mockInstanceAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
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
    mockInstanceAdmin.addException(exception);

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
  public void getInstancePartitionTest() throws Exception {
    InstancePartition expectedResponse =
        InstancePartition.newBuilder()
            .setName(
                InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]")
                    .toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencingDatabases(new ArrayList<String>())
            .addAllReferencingBackups(new ArrayList<String>())
            .setEtag("etag3123477")
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstancePartitionName name =
        InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]");

    InstancePartition actualResponse = client.getInstancePartition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstancePartitionRequest actualRequest =
        ((GetInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstancePartitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstancePartitionName name =
          InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]");
      client.getInstancePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstancePartitionTest2() throws Exception {
    InstancePartition expectedResponse =
        InstancePartition.newBuilder()
            .setName(
                InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]")
                    .toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencingDatabases(new ArrayList<String>())
            .addAllReferencingBackups(new ArrayList<String>())
            .setEtag("etag3123477")
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    InstancePartition actualResponse = client.getInstancePartition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstancePartitionRequest actualRequest =
        ((GetInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstancePartitionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getInstancePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstancePartitionTest() throws Exception {
    InstancePartition expectedResponse =
        InstancePartition.newBuilder()
            .setName(
                InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]")
                    .toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencingDatabases(new ArrayList<String>())
            .addAllReferencingBackups(new ArrayList<String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstancePartitionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    InstancePartition instancePartition = InstancePartition.newBuilder().build();
    String instancePartitionId = "instancePartitionId1364450768";

    InstancePartition actualResponse =
        client.createInstancePartitionAsync(parent, instancePartition, instancePartitionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstancePartitionRequest actualRequest =
        ((CreateInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instancePartition, actualRequest.getInstancePartition());
    Assert.assertEquals(instancePartitionId, actualRequest.getInstancePartitionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstancePartitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      InstancePartition instancePartition = InstancePartition.newBuilder().build();
      String instancePartitionId = "instancePartitionId1364450768";
      client.createInstancePartitionAsync(parent, instancePartition, instancePartitionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstancePartitionTest2() throws Exception {
    InstancePartition expectedResponse =
        InstancePartition.newBuilder()
            .setName(
                InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]")
                    .toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencingDatabases(new ArrayList<String>())
            .addAllReferencingBackups(new ArrayList<String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstancePartitionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    InstancePartition instancePartition = InstancePartition.newBuilder().build();
    String instancePartitionId = "instancePartitionId1364450768";

    InstancePartition actualResponse =
        client.createInstancePartitionAsync(parent, instancePartition, instancePartitionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstancePartitionRequest actualRequest =
        ((CreateInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instancePartition, actualRequest.getInstancePartition());
    Assert.assertEquals(instancePartitionId, actualRequest.getInstancePartitionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstancePartitionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      InstancePartition instancePartition = InstancePartition.newBuilder().build();
      String instancePartitionId = "instancePartitionId1364450768";
      client.createInstancePartitionAsync(parent, instancePartition, instancePartitionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstancePartitionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstancePartitionName name =
        InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]");

    client.deleteInstancePartition(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstancePartitionRequest actualRequest =
        ((DeleteInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstancePartitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstancePartitionName name =
          InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]");
      client.deleteInstancePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstancePartitionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteInstancePartition(name);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstancePartitionRequest actualRequest =
        ((DeleteInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstancePartitionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstancePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateInstancePartitionTest() throws Exception {
    InstancePartition expectedResponse =
        InstancePartition.newBuilder()
            .setName(
                InstancePartitionName.of("[PROJECT]", "[INSTANCE]", "[INSTANCE_PARTITION]")
                    .toString())
            .setConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setAutoscalingConfig(AutoscalingConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencingDatabases(new ArrayList<String>())
            .addAllReferencingBackups(new ArrayList<String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstancePartitionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    InstancePartition instancePartition = InstancePartition.newBuilder().build();
    FieldMask fieldMask = FieldMask.newBuilder().build();

    InstancePartition actualResponse =
        client.updateInstancePartitionAsync(instancePartition, fieldMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstancePartitionRequest actualRequest =
        ((UpdateInstancePartitionRequest) actualRequests.get(0));

    Assert.assertEquals(instancePartition, actualRequest.getInstancePartition());
    Assert.assertEquals(fieldMask, actualRequest.getFieldMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstancePartitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstancePartition instancePartition = InstancePartition.newBuilder().build();
      FieldMask fieldMask = FieldMask.newBuilder().build();
      client.updateInstancePartitionAsync(instancePartition, fieldMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInstancePartitionOperationsTest() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListInstancePartitionOperationsResponse expectedResponse =
        ListInstancePartitionOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListInstancePartitionOperationsPagedResponse pagedListResponse =
        client.listInstancePartitionOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancePartitionOperationsRequest actualRequest =
        ((ListInstancePartitionOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancePartitionOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listInstancePartitionOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancePartitionOperationsTest2() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListInstancePartitionOperationsResponse expectedResponse =
        ListInstancePartitionOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockInstanceAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancePartitionOperationsPagedResponse pagedListResponse =
        client.listInstancePartitionOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancePartitionOperationsRequest actualRequest =
        ((ListInstancePartitionOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancePartitionOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstancePartitionOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveInstanceTest() throws Exception {
    MoveInstanceResponse expectedResponse = MoveInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("moveInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockInstanceAdmin.addResponse(resultOperation);

    MoveInstanceRequest request =
        MoveInstanceRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .setTargetConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
            .build();

    MoveInstanceResponse actualResponse = client.moveInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveInstanceRequest actualRequest = ((MoveInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTargetConfig(), actualRequest.getTargetConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockInstanceAdmin.addException(exception);

    try {
      MoveInstanceRequest request =
          MoveInstanceRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
              .setTargetConfig(InstanceConfigName.of("[PROJECT]", "[INSTANCE_CONFIG]").toString())
              .build();
      client.moveInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
