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
import com.google.cloud.lustre.v1.stub.HttpJsonLustreStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class LustreClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LustreClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLustreStub.getMethodDescriptors(), LustreSettings.getDefaultEndpoint());
    LustreSettings settings =
        LustreSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LustreSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LustreClient.create(settings);
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
    mockService.addResponse(resultOperation);

    Instance instance =
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
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.Reschedule reschedule =
        RescheduleMaintenanceRequest.Reschedule.newBuilder().build();

    Instance actualResponse = client.rescheduleMaintenanceAsync(name, reschedule).get();
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
      RescheduleMaintenanceRequest.Reschedule reschedule =
          RescheduleMaintenanceRequest.Reschedule.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, reschedule).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    RescheduleMaintenanceRequest.Reschedule reschedule =
        RescheduleMaintenanceRequest.Reschedule.newBuilder().build();

    Instance actualResponse = client.rescheduleMaintenanceAsync(name, reschedule).get();
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
      RescheduleMaintenanceRequest.Reschedule reschedule =
          RescheduleMaintenanceRequest.Reschedule.newBuilder().build();
      client.rescheduleMaintenanceAsync(name, reschedule).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ImportDataResponse actualResponse = client.importDataAsync(name).get();
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
  public void importDataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.importDataAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    ImportDataResponse actualResponse = client.importDataAsync(name).get();
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
  public void importDataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.importDataAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ExportDataRequest request =
        ExportDataRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setRequestId("requestId693933066")
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
            .build();

    ExportDataResponse actualResponse = client.exportDataAsync(request).get();
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
  public void exportDataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Mirror mirror = Mirror.newBuilder().build();
    String mirrorId = "mirrorId-1236172486";

    Mirror actualResponse = client.createMirrorAsync(parent, mirror, mirrorId).get();
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
  public void createMirrorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Mirror mirror = Mirror.newBuilder().build();
      String mirrorId = "mirrorId-1236172486";
      client.createMirrorAsync(parent, mirror, mirrorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    Mirror mirror = Mirror.newBuilder().build();
    String mirrorId = "mirrorId-1236172486";

    Mirror actualResponse = client.createMirrorAsync(parent, mirror, mirrorId).get();
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
  public void createMirrorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      Mirror mirror = Mirror.newBuilder().build();
      String mirrorId = "mirrorId-1236172486";
      client.createMirrorAsync(parent, mirror, mirrorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Mirror mirror =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Mirror actualResponse = client.updateMirrorAsync(mirror, updateMask).get();
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
  public void updateMirrorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Mirror mirror =
          Mirror.newBuilder()
              .setName(
                  MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]").toString())
              .setGcsPath(GcsPath.newBuilder().build())
              .setLustrePath(LustrePath.newBuilder().build())
              .setDeletedFilesRetained(true)
              .setDescription("description-1724546052")
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setUid("uid115792")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMirrorAsync(mirror, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");

    client.deleteMirrorAsync(name).get();

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
  public void deleteMirrorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");
      client.deleteMirrorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5876/locations/location-5876/instances/instance-5876/mirrors/mirror-5876";

    client.deleteMirrorAsync(name).get();

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
  public void deleteMirrorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5876/locations/location-5876/instances/instance-5876/mirrors/mirror-5876";
      client.deleteMirrorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    MirrorName name = MirrorName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[MIRROR]");

    Mirror actualResponse = client.getMirror(name);
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
  public void getMirrorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5876/locations/location-5876/instances/instance-5876/mirrors/mirror-5876";

    Mirror actualResponse = client.getMirror(name);
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
  public void getMirrorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5876/locations/location-5876/instances/instance-5876/mirrors/mirror-5876";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListMirrorsPagedResponse pagedListResponse = client.listMirrors(parent);

    List<Mirror> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirrorsList().get(0), resources.get(0));

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
  public void listMirrorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListMirrorsPagedResponse pagedListResponse = client.listMirrors(parent);

    List<Mirror> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMirrorsList().get(0), resources.get(0));

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
  public void listMirrorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
    String directoryPolicyId = "directoryPolicyId1899556730";

    DirectoryPolicy actualResponse =
        client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
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
  public void createDirectoryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
      String directoryPolicyId = "directoryPolicyId1899556730";
      client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
    String directoryPolicyId = "directoryPolicyId1899556730";

    DirectoryPolicy actualResponse =
        client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
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
  public void createDirectoryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      DirectoryPolicy directoryPolicy = DirectoryPolicy.newBuilder().build();
      String directoryPolicyId = "directoryPolicyId1899556730";
      client.createDirectoryPolicyAsync(parent, directoryPolicy, directoryPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    DirectoryPolicyName name =
        DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");

    client.deleteDirectoryPolicyAsync(name).get();

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
  public void deleteDirectoryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DirectoryPolicyName name =
          DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");
      client.deleteDirectoryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8605/locations/location-8605/instances/instance-8605/directoryPolicies/directoryPolicie-8605";

    client.deleteDirectoryPolicyAsync(name).get();

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
  public void deleteDirectoryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8605/locations/location-8605/instances/instance-8605/directoryPolicies/directoryPolicie-8605";
      client.deleteDirectoryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    DirectoryPolicyName name =
        DirectoryPolicyName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DIRECTORY_POLICY]");

    DirectoryPolicy actualResponse = client.getDirectoryPolicy(name);
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
  public void getDirectoryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8605/locations/location-8605/instances/instance-8605/directoryPolicies/directoryPolicie-8605";

    DirectoryPolicy actualResponse = client.getDirectoryPolicy(name);
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
  public void getDirectoryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8605/locations/location-8605/instances/instance-8605/directoryPolicies/directoryPolicie-8605";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDirectoryPoliciesPagedResponse pagedListResponse = client.listDirectoryPolicies(parent);

    List<DirectoryPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDirectoryPoliciesList().get(0), resources.get(0));

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
  public void listDirectoryPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListDirectoryPoliciesPagedResponse pagedListResponse = client.listDirectoryPolicies(parent);

    List<DirectoryPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDirectoryPoliciesList().get(0), resources.get(0));

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
  public void listDirectoryPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
