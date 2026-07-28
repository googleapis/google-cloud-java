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

package com.google.cloud.memorystore.v1;

import static com.google.cloud.memorystore.v1.MemorystoreClient.ListAuthTokensPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListInstancesPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListLocationsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListTokenAuthUsersPagedResponse;

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
public class MemorystoreClientTest {
  private static MockLocations mockLocations;
  private static MockMemorystore mockMemorystore;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MemorystoreClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMemorystore = new MockMemorystore();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMemorystore, mockLocations));
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
    MemorystoreSettings settings =
        MemorystoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MemorystoreClient.create(settings);
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
    mockMemorystore.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
    mockMemorystore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
    mockMemorystore.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
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
    mockMemorystore.addException(exception);

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
  public void getCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName("name3373707").build();
    mockMemorystore.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateAuthorityRequest actualRequest =
        ((GetCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName("name3373707").build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateAuthorityRequest actualRequest =
        ((GetCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateAuthorityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedRegionalCertificateAuthorityTest() throws Exception {
    SharedRegionalCertificateAuthority expectedResponse =
        SharedRegionalCertificateAuthority.newBuilder()
            .setName(
                SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    SharedRegionalCertificateAuthorityName name =
        SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]");

    SharedRegionalCertificateAuthority actualResponse =
        client.getSharedRegionalCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSharedRegionalCertificateAuthorityRequest actualRequest =
        ((GetSharedRegionalCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSharedRegionalCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      SharedRegionalCertificateAuthorityName name =
          SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]");
      client.getSharedRegionalCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedRegionalCertificateAuthorityTest2() throws Exception {
    SharedRegionalCertificateAuthority expectedResponse =
        SharedRegionalCertificateAuthority.newBuilder()
            .setName(
                SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    SharedRegionalCertificateAuthority actualResponse =
        client.getSharedRegionalCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSharedRegionalCertificateAuthorityRequest actualRequest =
        ((GetSharedRegionalCertificateAuthorityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSharedRegionalCertificateAuthorityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getSharedRegionalCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rescheduleMaintenanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(rescheduleType, actualRequest.getRescheduleType());
    Assert.assertEquals(scheduleTime, actualRequest.getScheduleTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RescheduleMaintenanceRequest actualRequest =
        ((RescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(rescheduleType, actualRequest.getRescheduleType());
    Assert.assertEquals(scheduleTime, actualRequest.getScheduleTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBackupCollectionsTest() throws Exception {
    BackupCollection responsesElement = BackupCollection.newBuilder().build();
    ListBackupCollectionsResponse expectedResponse =
        ListBackupCollectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupCollections(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupCollectionsPagedResponse pagedListResponse = client.listBackupCollections(parent);

    List<BackupCollection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupCollectionsRequest actualRequest =
        ((ListBackupCollectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupCollectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackupCollections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupCollectionsTest2() throws Exception {
    BackupCollection responsesElement = BackupCollection.newBuilder().build();
    ListBackupCollectionsResponse expectedResponse =
        ListBackupCollectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupCollections(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupCollectionsPagedResponse pagedListResponse = client.listBackupCollections(parent);

    List<BackupCollection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupCollectionsRequest actualRequest =
        ((ListBackupCollectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupCollectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupCollections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupCollectionTest() throws Exception {
    BackupCollection expectedResponse =
        BackupCollection.newBuilder()
            .setName(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setInstanceUid("instanceUid-2102004869")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setTotalBackupSizeBytes(-665105137)
            .setTotalBackupCount(775900525)
            .setLastBackupTime(Timestamp.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    BackupCollectionName name =
        BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");

    BackupCollection actualResponse = client.getBackupCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupCollectionRequest actualRequest = ((GetBackupCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      BackupCollectionName name =
          BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
      client.getBackupCollection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupCollectionTest2() throws Exception {
    BackupCollection expectedResponse =
        BackupCollection.newBuilder()
            .setName(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setInstanceUid("instanceUid-2102004869")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setTotalBackupSizeBytes(-665105137)
            .setTotalBackupCount(775900525)
            .setLastBackupTime(Timestamp.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    BackupCollection actualResponse = client.getBackupCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupCollectionRequest actualRequest = ((GetBackupCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupCollectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupCollection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    BackupCollectionName parent =
        BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      BackupCollectionName parent =
          BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest2() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setInstanceUid("instanceUid-2102004869")
            .setTotalSizeBytes(-115423608)
            .setExpireTime(Timestamp.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .addAllBackupFiles(new ArrayList<BackupFile>())
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockMemorystore.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setInstanceUid("instanceUid-2102004869")
            .setTotalSizeBytes(-115423608)
            .setExpireTime(Timestamp.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .addAllBackupFiles(new ArrayList<BackupFile>())
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");

    client.deleteBackupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setInstanceUid("instanceUid-2102004869")
            .setTotalSizeBytes(-115423608)
            .setExpireTime(Timestamp.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .addAllBackupFiles(new ArrayList<BackupFile>())
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    ExportBackupRequest request =
        ExportBackupRequest.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                    .toString())
            .build();

    Backup actualResponse = client.exportBackupAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportBackupRequest actualRequest = ((ExportBackupRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGcsBucket(), actualRequest.getGcsBucket());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      ExportBackupRequest request =
          ExportBackupRequest.newBuilder()
              .setName(
                  BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                      .toString())
              .build();
      client.exportBackupAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void backupInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("backupInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.backupInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BackupInstanceRequest actualRequest = ((BackupInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void backupInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.backupInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void backupInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("backupInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";

    Instance actualResponse = client.backupInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BackupInstanceRequest actualRequest = ((BackupInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void backupInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.backupInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startMigrationTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    StartMigrationRequest request =
        StartMigrationRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .build();

    Instance actualResponse = client.startMigrationAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartMigrationRequest actualRequest = ((StartMigrationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSelfManagedSource(), actualRequest.getSelfManagedSource());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startMigrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      StartMigrationRequest request =
          StartMigrationRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .build();
      client.startMigrationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void finishMigrationTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("finishMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    boolean force = true;

    Instance actualResponse = client.finishMigrationAsync(name, force).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinishMigrationRequest actualRequest = ((FinishMigrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void finishMigrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      boolean force = true;
      client.finishMigrationAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void finishMigrationTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("finishMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";
    boolean force = true;

    Instance actualResponse = client.finishMigrationAsync(name, force).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinishMigrationRequest actualRequest = ((FinishMigrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void finishMigrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.finishMigrationAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTokenAuthUsersTest() throws Exception {
    TokenAuthUser responsesElement = TokenAuthUser.newBuilder().build();
    ListTokenAuthUsersResponse expectedResponse =
        ListTokenAuthUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTokenAuthUsers(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListTokenAuthUsersPagedResponse pagedListResponse = client.listTokenAuthUsers(parent);

    List<TokenAuthUser> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTokenAuthUsersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTokenAuthUsersRequest actualRequest = ((ListTokenAuthUsersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTokenAuthUsersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listTokenAuthUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTokenAuthUsersTest2() throws Exception {
    TokenAuthUser responsesElement = TokenAuthUser.newBuilder().build();
    ListTokenAuthUsersResponse expectedResponse =
        ListTokenAuthUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTokenAuthUsers(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTokenAuthUsersPagedResponse pagedListResponse = client.listTokenAuthUsers(parent);

    List<TokenAuthUser> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTokenAuthUsersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTokenAuthUsersRequest actualRequest = ((ListTokenAuthUsersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTokenAuthUsersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTokenAuthUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTokenAuthUserTest() throws Exception {
    TokenAuthUser expectedResponse =
        TokenAuthUser.newBuilder()
            .setName(
                TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
                    .toString())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    TokenAuthUserName name =
        TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");

    TokenAuthUser actualResponse = client.getTokenAuthUser(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTokenAuthUserRequest actualRequest = ((GetTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTokenAuthUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      TokenAuthUserName name =
          TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
      client.getTokenAuthUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTokenAuthUserTest2() throws Exception {
    TokenAuthUser expectedResponse =
        TokenAuthUser.newBuilder()
            .setName(
                TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
                    .toString())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    TokenAuthUser actualResponse = client.getTokenAuthUser(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTokenAuthUserRequest actualRequest = ((GetTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTokenAuthUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getTokenAuthUser(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthTokensTest() throws Exception {
    AuthToken responsesElement = AuthToken.newBuilder().build();
    ListAuthTokensResponse expectedResponse =
        ListAuthTokensResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthTokens(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    TokenAuthUserName parent =
        TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");

    ListAuthTokensPagedResponse pagedListResponse = client.listAuthTokens(parent);

    List<AuthToken> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthTokensList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthTokensRequest actualRequest = ((ListAuthTokensRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthTokensExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      TokenAuthUserName parent =
          TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
      client.listAuthTokens(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthTokensTest2() throws Exception {
    AuthToken responsesElement = AuthToken.newBuilder().build();
    ListAuthTokensResponse expectedResponse =
        ListAuthTokensResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthTokens(Arrays.asList(responsesElement))
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuthTokensPagedResponse pagedListResponse = client.listAuthTokens(parent);

    List<AuthToken> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthTokensList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthTokensRequest actualRequest = ((ListAuthTokensRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthTokensExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAuthTokens(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthTokenTest() throws Exception {
    AuthToken expectedResponse =
        AuthToken.newBuilder()
            .setName(
                AuthTokenName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[INSTANCE]",
                        "[TOKEN_AUTH_USER]",
                        "[AUTH_TOKEN]")
                    .toString())
            .setToken("token110541305")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    AuthTokenName name =
        AuthTokenName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");

    AuthToken actualResponse = client.getAuthToken(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthTokenRequest actualRequest = ((GetAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      AuthTokenName name =
          AuthTokenName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");
      client.getAuthToken(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthTokenTest2() throws Exception {
    AuthToken expectedResponse =
        AuthToken.newBuilder()
            .setName(
                AuthTokenName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[INSTANCE]",
                        "[TOKEN_AUTH_USER]",
                        "[AUTH_TOKEN]")
                    .toString())
            .setToken("token110541305")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMemorystore.addResponse(expectedResponse);

    String name = "name3373707";

    AuthToken actualResponse = client.getAuthToken(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthTokenRequest actualRequest = ((GetAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthToken(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addTokenAuthUserTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addTokenAuthUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String tokenAuthUser = "tokenAuthUser345456300";

    Instance actualResponse = client.addTokenAuthUserAsync(instance, tokenAuthUser).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddTokenAuthUserRequest actualRequest = ((AddTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertEquals(tokenAuthUser, actualRequest.getTokenAuthUser());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addTokenAuthUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String tokenAuthUser = "tokenAuthUser345456300";
      client.addTokenAuthUserAsync(instance, tokenAuthUser).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addTokenAuthUserTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateInfo(Instance.StateInfo.newBuilder().build())
            .setUid("uid115792")
            .setReplicaCount(564075208)
            .setShardCount(-495377042)
            .addAllDiscoveryEndpoints(new ArrayList<DiscoveryEndpoint>())
            .setPersistenceConfig(PersistenceConfig.newBuilder().build())
            .setEngineVersion("engineVersion-1416229834")
            .putAllEngineConfigs(new HashMap<String, String>())
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setZoneDistributionConfig(ZoneDistributionConfig.newBuilder().build())
            .setDeletionProtectionEnabled(true)
            .addAllPscAutoConnections(new ArrayList<PscAutoConnection>())
            .addAllPscAttachmentDetails(new ArrayList<PscAttachmentDetail>())
            .addAllEndpoints(new ArrayList<Instance.InstanceEndpoint>())
            .setSimulateMaintenanceEvent(true)
            .setOndemandMaintenance(true)
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setKmsKey("kmsKey-1127483058")
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .setEffectiveMaintenanceVersion("effectiveMaintenanceVersion-380297140")
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setAllowFewerZonesDeployment(true)
            .setServerCaPool("serverCaPool1433802429")
            .setRotateServerCertificate(true)
            .setMigrationConfig(MigrationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addTokenAuthUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String instance = "instance555127957";
    String tokenAuthUser = "tokenAuthUser345456300";

    Instance actualResponse = client.addTokenAuthUserAsync(instance, tokenAuthUser).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddTokenAuthUserRequest actualRequest = ((AddTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(tokenAuthUser, actualRequest.getTokenAuthUser());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addTokenAuthUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String instance = "instance555127957";
      String tokenAuthUser = "tokenAuthUser345456300";
      client.addTokenAuthUserAsync(instance, tokenAuthUser).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTokenAuthUserTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTokenAuthUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    TokenAuthUserName name =
        TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");

    client.deleteTokenAuthUserAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTokenAuthUserRequest actualRequest = ((DeleteTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTokenAuthUserExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      TokenAuthUserName name =
          TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
      client.deleteTokenAuthUserAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTokenAuthUserTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTokenAuthUserTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTokenAuthUserAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTokenAuthUserRequest actualRequest = ((DeleteTokenAuthUserRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTokenAuthUserExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTokenAuthUserAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addAuthTokenTest() throws Exception {
    TokenAuthUser expectedResponse =
        TokenAuthUser.newBuilder()
            .setName(
                TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAuthTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    TokenAuthUserName tokenAuthUser =
        TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
    AuthToken authToken = AuthToken.newBuilder().build();

    TokenAuthUser actualResponse = client.addAuthTokenAsync(tokenAuthUser, authToken).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddAuthTokenRequest actualRequest = ((AddAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(tokenAuthUser.toString(), actualRequest.getTokenAuthUser());
    Assert.assertEquals(authToken, actualRequest.getAuthToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addAuthTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      TokenAuthUserName tokenAuthUser =
          TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
      AuthToken authToken = AuthToken.newBuilder().build();
      client.addAuthTokenAsync(tokenAuthUser, authToken).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addAuthTokenTest2() throws Exception {
    TokenAuthUser expectedResponse =
        TokenAuthUser.newBuilder()
            .setName(
                TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAuthTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String tokenAuthUser = "tokenAuthUser345456300";
    AuthToken authToken = AuthToken.newBuilder().build();

    TokenAuthUser actualResponse = client.addAuthTokenAsync(tokenAuthUser, authToken).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddAuthTokenRequest actualRequest = ((AddAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(tokenAuthUser, actualRequest.getTokenAuthUser());
    Assert.assertEquals(authToken, actualRequest.getAuthToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addAuthTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String tokenAuthUser = "tokenAuthUser345456300";
      AuthToken authToken = AuthToken.newBuilder().build();
      client.addAuthTokenAsync(tokenAuthUser, authToken).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthTokenTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    AuthTokenName name =
        AuthTokenName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");

    client.deleteAuthTokenAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthTokenRequest actualRequest = ((DeleteAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      AuthTokenName name =
          AuthTokenName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");
      client.deleteAuthTokenAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthTokenTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemorystore.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAuthTokenAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemorystore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthTokenRequest actualRequest = ((DeleteAuthTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemorystore.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAuthTokenAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
