/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListInstancesPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.memorystore.v1.stub.HttpJsonMemorystoreStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class MemorystoreClientTest {
  private static MockHttpService mockService;
  private static MemorystoreClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMemorystoreStub.getMethodDescriptors(),
            MemorystoreSettings.getDefaultEndpoint());
    MemorystoreSettings settings =
        MemorystoreSettings.newBuilder()
            .setTransportChannelProvider(
                MemorystoreSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MemorystoreClient.create(settings);
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
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

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
  public void listInstancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

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
  public void listInstancesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
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
  public void getInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.getInstance(name);
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
  public void getInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
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
  public void createInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
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
  public void createInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Instance instance =
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
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
  public void updateInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Instance instance =
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
              .setOndemandMaintenance(true)
              .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
              .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
              .setCrossInstanceReplicationConfig(
                  CrossInstanceReplicationConfig.newBuilder().build())
              .setAsyncInstanceEndpointsDeletionEnabled(true)
              .setBackupCollection(
                  BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                      .toString())
              .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

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
  public void deleteInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    client.deleteInstanceAsync(name).get();

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
  public void deleteInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName("name3373707").build();
    mockService.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
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
  public void getCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
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
  public void getCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.getCertificateAuthority(name);
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
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
  public void rescheduleMaintenanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
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
  public void rescheduleMaintenanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupCollectionsPagedResponse pagedListResponse = client.listBackupCollections(parent);

    List<BackupCollection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupCollectionsList().get(0), resources.get(0));

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
  public void listBackupCollectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupCollectionsPagedResponse pagedListResponse = client.listBackupCollections(parent);

    List<BackupCollection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupCollectionsList().get(0), resources.get(0));

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
  public void listBackupCollectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
            .build();
    mockService.addResponse(expectedResponse);

    BackupCollectionName name =
        BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");

    BackupCollection actualResponse = client.getBackupCollection(name);
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
  public void getBackupCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9529/locations/location-9529/backupCollections/backupCollection-9529";

    BackupCollection actualResponse = client.getBackupCollection(name);
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
  public void getBackupCollectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9529/locations/location-9529/backupCollections/backupCollection-9529";
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
    mockService.addResponse(expectedResponse);

    BackupCollectionName parent =
        BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

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
  public void listBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2584/locations/location-2584/backupCollections/backupCollection-2584";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

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
  public void listBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2584/locations/location-2584/backupCollections/backupCollection-2584";
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
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
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
  public void getBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3318/locations/location-3318/backupCollections/backupCollection-3318/backups/backup-3318";

    Backup actualResponse = client.getBackup(name);
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
  public void getBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3318/locations/location-3318/backupCollections/backupCollection-3318/backups/backup-3318";
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
    mockService.addResponse(resultOperation);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");

    client.deleteBackupAsync(name).get();

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
  public void deleteBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3318/locations/location-3318/backupCollections/backupCollection-3318/backups/backup-3318";

    client.deleteBackupAsync(name).get();

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
  public void deleteBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3318/locations/location-3318/backupCollections/backupCollection-3318/backups/backup-3318";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportBackupRequest request =
        ExportBackupRequest.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
                    .toString())
            .build();

    Backup actualResponse = client.exportBackupAsync(request).get();
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
  public void exportBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("backupInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.backupInstanceAsync(name).get();
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
  public void backupInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.backupInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setOndemandMaintenance(true)
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setCrossInstanceReplicationConfig(CrossInstanceReplicationConfig.newBuilder().build())
            .setAsyncInstanceEndpointsDeletionEnabled(true)
            .setBackupCollection(
                BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
                    .toString())
            .setAutomatedBackupConfig(AutomatedBackupConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("backupInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.backupInstanceAsync(name).get();
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
  public void backupInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.backupInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
