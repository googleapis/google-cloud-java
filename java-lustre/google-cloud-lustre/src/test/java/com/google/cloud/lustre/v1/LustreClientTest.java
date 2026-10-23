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

package com.google.cloud.lustre.v1;

import static com.google.cloud.lustre.v1.LustreClient.ListDirectoryPoliciesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListInstancesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListLocationsPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListMirrorsPagedResponse;

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
public class LustreClientTest {
  private static MockLocations mockLocations;
  private static MockLustre mockLustre;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LustreClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLustre = new MockLustre();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLustre, mockLocations));
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
    LustreSettings settings =
        LustreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LustreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockLustre.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockLustre.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    mockLustre.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
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
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    mockLustre.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

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
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
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
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
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
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
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
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
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
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rescheduleMaintenanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.Reschedule reschedule =
        RescheduleMaintenanceRequest.Reschedule.newBuilder().build();

    Instance actualResponse = client.rescheduleMaintenanceAsync(name, reschedule).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(reschedule, actualRequest.getReschedule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      RescheduleMaintenanceRequest.Reschedule reschedule =
          RescheduleMaintenanceRequest.Reschedule.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, reschedule).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rescheduleMaintenanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setFilesystem("filesystem-1572513109")
            .setCapacityGib(498394811)
            .setNetwork("network1843485230")
            .setMountPoint("mountPoint1280692471")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setPerUnitStorageThroughput(-946502681)
            .setGkeSupportEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setStateReason("stateReason1148834357")
            .setPlacementPolicy("placementPolicy1565402231")
            .setAccessRulesOptions(AccessRulesOptions.newBuilder().build())
            .setUid("uid115792")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setUpcomingMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setDynamicTierOptions(DynamicTierOptions.newBuilder().build())
            .setAvailableVersion("availableVersion2060002767")
            .setTargetVersion("targetVersion-1639412217")
            .setEffectiveVersion("effectiveVersion1393275185")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String name = "name3373707";
    RescheduleMaintenanceRequest.Reschedule reschedule =
        RescheduleMaintenanceRequest.Reschedule.newBuilder().build();

    Instance actualResponse = client.rescheduleMaintenanceAsync(name, reschedule).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(reschedule, actualRequest.getReschedule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      RescheduleMaintenanceRequest.Reschedule reschedule =
          RescheduleMaintenanceRequest.Reschedule.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, reschedule).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDataTest() throws Exception {
    ImportDataResponse expectedResponse = ImportDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ImportDataResponse actualResponse = client.importDataAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataRequest actualRequest = ((ImportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.importDataAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDataTest2() throws Exception {
    ImportDataResponse expectedResponse = ImportDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String name = "name3373707";

    ImportDataResponse actualResponse = client.importDataAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataRequest actualRequest = ((ImportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.importDataAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportDataTest() throws Exception {
    ExportDataResponse expectedResponse = ExportDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setRequestId("requestId693933066")
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .build();

    ExportDataResponse actualResponse = client.exportDataAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = ((ExportDataRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLustrePath(), actualRequest.getLustrePath());
    Assert.assertEquals(request.getGcsPath(), actualRequest.getGcsPath());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(request.getServiceAccount(), actualRequest.getServiceAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      ExportDataRequest request =
          ExportDataRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .setRequestId("requestId693933066")
              .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
              .build();
      client.exportDataAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirrorTest() throws Exception {
    Mirror expectedResponse =
        Mirror.newBuilder()
            .setName(MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
            .setGcsPath(GcsPath.newBuilder().build())
            .setLustrePath(LustrePath.newBuilder().build())
            .setDeletedFilesRetained(true)
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirrorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Mirror mirror = Mirror.newBuilder().build();
    String mirrorId = "mirrorId-1236172486";

    Mirror actualResponse = client.createMirrorAsync(parent, mirror, mirrorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirrorRequest actualRequest = ((CreateMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mirror, actualRequest.getMirror());
    Assert.assertEquals(mirrorId, actualRequest.getMirrorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirrorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Mirror mirror = Mirror.newBuilder().build();
      String mirrorId = "mirrorId-1236172486";
      client.createMirrorAsync(parent, mirror, mirrorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMirrorTest2() throws Exception {
    Mirror expectedResponse =
        Mirror.newBuilder()
            .setName(MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
            .setGcsPath(GcsPath.newBuilder().build())
            .setLustrePath(LustrePath.newBuilder().build())
            .setDeletedFilesRetained(true)
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMirrorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String parent = "parent-995424086";
    Mirror mirror = Mirror.newBuilder().build();
    String mirrorId = "mirrorId-1236172486";

    Mirror actualResponse = client.createMirrorAsync(parent, mirror, mirrorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMirrorRequest actualRequest = ((CreateMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mirror, actualRequest.getMirror());
    Assert.assertEquals(mirrorId, actualRequest.getMirrorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMirrorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      Mirror mirror = Mirror.newBuilder().build();
      String mirrorId = "mirrorId-1236172486";
      client.createMirrorAsync(parent, mirror, mirrorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMirrorTest() throws Exception {
    Mirror expectedResponse =
        Mirror.newBuilder()
            .setName(MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
            .setGcsPath(GcsPath.newBuilder().build())
            .setLustrePath(LustrePath.newBuilder().build())
            .setDeletedFilesRetained(true)
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMirrorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    Mirror mirror = Mirror.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Mirror actualResponse = client.updateMirrorAsync(mirror, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMirrorRequest actualRequest = ((UpdateMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(mirror, actualRequest.getMirror());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMirrorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      Mirror mirror = Mirror.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMirrorAsync(mirror, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirrorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirrorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");

    client.deleteMirrorAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirrorRequest actualRequest = ((DeleteMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirrorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");
      client.deleteMirrorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMirrorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMirrorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMirrorAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMirrorRequest actualRequest = ((DeleteMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMirrorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMirrorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getMirrorTest() throws Exception {
    Mirror expectedResponse =
        Mirror.newBuilder()
            .setName(MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
            .setGcsPath(GcsPath.newBuilder().build())
            .setLustrePath(LustrePath.newBuilder().build())
            .setDeletedFilesRetained(true)
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockLustre.addResponse(expectedResponse);

    MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");

    Mirror actualResponse = client.getMirror(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirrorRequest actualRequest = ((GetMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirrorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");
      client.getMirror(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMirrorTest2() throws Exception {
    Mirror expectedResponse =
        Mirror.newBuilder()
            .setName(MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
            .setGcsPath(GcsPath.newBuilder().build())
            .setLustrePath(LustrePath.newBuilder().build())
            .setDeletedFilesRetained(true)
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockLustre.addResponse(expectedResponse);

    String name = "name3373707";

    Mirror actualResponse = client.getMirror(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMirrorRequest actualRequest = ((GetMirrorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMirrorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.getMirror(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirrorsTest() throws Exception {
    Mirror responsesElement = Mirror.newBuilder().build();
    ListMirrorsResponse expectedResponse =
        ListMirrorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirrors(Arrays.asList(responsesElement))
            .build();
    mockLustre.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListMirrorsPagedResponse pagedListResponse = client.listMirrors(parent);

    List<Mirror> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirrorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirrorsRequest actualRequest = ((ListMirrorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirrorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listMirrors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMirrorsTest2() throws Exception {
    Mirror responsesElement = Mirror.newBuilder().build();
    ListMirrorsResponse expectedResponse =
        ListMirrorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMirrors(Arrays.asList(responsesElement))
            .build();
    mockLustre.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMirrorsPagedResponse pagedListResponse = client.listMirrors(parent);

    List<Mirror> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirrorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMirrorsRequest actualRequest = ((ListMirrorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMirrorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMirrors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDirectoryPolicyTest() throws Exception {
    DirectoryPolicy expectedResponse =
        DirectoryPolicy.newBuilder()
            .setName(
                DirectoryPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]")
                    .toString())
            .setDirectoryPath("directoryPath596047922")
            .setLustreProjectId(-532265949)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDirectoryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
    String directoryPolicyId = "directoryPolicyId1899556730";

    DirectoryPolicy actualResponse =
        client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDirectoryPolicyRequest actualRequest =
        ((CreateDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(directoryPolicy, actualRequest.getDirectoryPolicy());
    Assert.assertEquals(directoryPolicyId, actualRequest.getDirectoryPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDirectoryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
      String directoryPolicyId = "directoryPolicyId1899556730";
      client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDirectoryPolicyTest2() throws Exception {
    DirectoryPolicy expectedResponse =
        DirectoryPolicy.newBuilder()
            .setName(
                DirectoryPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]")
                    .toString())
            .setDirectoryPath("directoryPath596047922")
            .setLustreProjectId(-532265949)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDirectoryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String parent = "parent-995424086";
    DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
    String directoryPolicyId = "directoryPolicyId1899556730";

    DirectoryPolicy actualResponse =
        client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDirectoryPolicyRequest actualRequest =
        ((CreateDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(directoryPolicy, actualRequest.getDirectoryPolicy());
    Assert.assertEquals(directoryPolicyId, actualRequest.getDirectoryPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDirectoryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
      String directoryPolicyId = "directoryPolicyId1899556730";
      client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDirectoryPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDirectoryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    DirectoryPolicyName name =
        DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");

    client.deleteDirectoryPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDirectoryPolicyRequest actualRequest =
        ((DeleteDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDirectoryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      DirectoryPolicyName name =
          DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");
      client.deleteDirectoryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDirectoryPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDirectoryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLustre.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDirectoryPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDirectoryPolicyRequest actualRequest =
        ((DeleteDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDirectoryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDirectoryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDirectoryPolicyTest() throws Exception {
    DirectoryPolicy expectedResponse =
        DirectoryPolicy.newBuilder()
            .setName(
                DirectoryPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]")
                    .toString())
            .setDirectoryPath("directoryPath596047922")
            .setLustreProjectId(-532265949)
            .setUid("uid115792")
            .build();
    mockLustre.addResponse(expectedResponse);

    DirectoryPolicyName name =
        DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");

    DirectoryPolicy actualResponse = client.getDirectoryPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDirectoryPolicyRequest actualRequest = ((GetDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDirectoryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      DirectoryPolicyName name =
          DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");
      client.getDirectoryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDirectoryPolicyTest2() throws Exception {
    DirectoryPolicy expectedResponse =
        DirectoryPolicy.newBuilder()
            .setName(
                DirectoryPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]")
                    .toString())
            .setDirectoryPath("directoryPath596047922")
            .setLustreProjectId(-532265949)
            .setUid("uid115792")
            .build();
    mockLustre.addResponse(expectedResponse);

    String name = "name3373707";

    DirectoryPolicy actualResponse = client.getDirectoryPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDirectoryPolicyRequest actualRequest = ((GetDirectoryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDirectoryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String name = "name3373707";
      client.getDirectoryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDirectoryPoliciesTest() throws Exception {
    DirectoryPolicy responsesElement = DirectoryPolicy.newBuilder().build();
    ListDirectoryPoliciesResponse expectedResponse =
        ListDirectoryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDirectoryPolicies(Arrays.asList(responsesElement))
            .build();
    mockLustre.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDirectoryPoliciesPagedResponse pagedListResponse = client.listDirectoryPolicies(parent);

    List<DirectoryPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDirectoryPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDirectoryPoliciesRequest actualRequest =
        ((ListDirectoryPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDirectoryPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDirectoryPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDirectoryPoliciesTest2() throws Exception {
    DirectoryPolicy responsesElement = DirectoryPolicy.newBuilder().build();
    ListDirectoryPoliciesResponse expectedResponse =
        ListDirectoryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDirectoryPolicies(Arrays.asList(responsesElement))
            .build();
    mockLustre.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDirectoryPoliciesPagedResponse pagedListResponse = client.listDirectoryPolicies(parent);

    List<DirectoryPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDirectoryPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLustre.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDirectoryPoliciesRequest actualRequest =
        ((ListDirectoryPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDirectoryPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLustre.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDirectoryPolicies(parent);
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
