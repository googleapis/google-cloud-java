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

package com.google.cloud.baremetalsolution.v2;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLocationsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListOSImagesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListProvisioningQuotasPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSSHKeysPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.baremetalsolution.v2.stub.HttpJsonBareMetalSolutionStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class BareMetalSolutionClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BareMetalSolutionClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBareMetalSolutionStub.getMethodDescriptors(),
            BareMetalSolutionSettings.getDefaultEndpoint());
    BareMetalSolutionSettings settings =
        BareMetalSolutionSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BareMetalSolutionSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BareMetalSolutionClient.create(settings);
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
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
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
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
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
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
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
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
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
              .setId("id3355")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setMachineType("machineType-218117087")
              .setHyperthreadingEnabled(true)
              .putAllLabels(new HashMap<String, String>())
              .addAllLuns(new ArrayList<Lun>())
              .addAllVolumes(new ArrayList<Volume>())
              .addAllNetworks(new ArrayList<Network>())
              .setInteractiveSerialConsoleEnabled(true)
              .setOsImage("osImage-1203193385")
              .setPod("pod111173")
              .setNetworkTemplate("networkTemplate1699249352")
              .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
              .setLoginInfo("loginInfo-1719604297")
              .setWorkloadProfile(WorkloadProfile.forNumber(0))
              .setFirmwareVersion("firmwareVersion788603549")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void renameInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String newInstanceId = "newInstanceId1749535312";

    Instance actualResponse = client.renameInstance(name, newInstanceId);
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
  public void renameInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String newInstanceId = "newInstanceId1749535312";
      client.renameInstance(name, newInstanceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    String newInstanceId = "newInstanceId1749535312";

    Instance actualResponse = client.renameInstance(name, newInstanceId);
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
  public void renameInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      String newInstanceId = "newInstanceId1749535312";
      client.renameInstance(name, newInstanceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetInstanceTest() throws Exception {
    ResetInstanceResponse expectedResponse = ResetInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ResetInstanceResponse actualResponse = client.resetInstanceAsync(name).get();
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
  public void resetInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.resetInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resetInstanceTest2() throws Exception {
    ResetInstanceResponse expectedResponse = ResetInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    ResetInstanceResponse actualResponse = client.resetInstanceAsync(name).get();
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
  public void resetInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.resetInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startInstanceTest() throws Exception {
    StartInstanceResponse expectedResponse = StartInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    StartInstanceResponse actualResponse = client.startInstanceAsync(name).get();
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
  public void startInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startInstanceTest2() throws Exception {
    StartInstanceResponse expectedResponse = StartInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    StartInstanceResponse actualResponse = client.startInstanceAsync(name).get();
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
  public void startInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopInstanceTest() throws Exception {
    StopInstanceResponse expectedResponse = StopInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    StopInstanceResponse actualResponse = client.stopInstanceAsync(name).get();
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
  public void stopInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopInstanceTest2() throws Exception {
    StopInstanceResponse expectedResponse = StopInstanceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    StopInstanceResponse actualResponse = client.stopInstanceAsync(name).get();
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
  public void stopInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void enableInteractiveSerialConsoleTest() throws Exception {
    EnableInteractiveSerialConsoleResponse expectedResponse =
        EnableInteractiveSerialConsoleResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableInteractiveSerialConsoleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    EnableInteractiveSerialConsoleResponse actualResponse =
        client.enableInteractiveSerialConsoleAsync(name).get();
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
  public void enableInteractiveSerialConsoleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.enableInteractiveSerialConsoleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void enableInteractiveSerialConsoleTest2() throws Exception {
    EnableInteractiveSerialConsoleResponse expectedResponse =
        EnableInteractiveSerialConsoleResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableInteractiveSerialConsoleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    EnableInteractiveSerialConsoleResponse actualResponse =
        client.enableInteractiveSerialConsoleAsync(name).get();
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
  public void enableInteractiveSerialConsoleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.enableInteractiveSerialConsoleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableInteractiveSerialConsoleTest() throws Exception {
    DisableInteractiveSerialConsoleResponse expectedResponse =
        DisableInteractiveSerialConsoleResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableInteractiveSerialConsoleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    DisableInteractiveSerialConsoleResponse actualResponse =
        client.disableInteractiveSerialConsoleAsync(name).get();
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
  public void disableInteractiveSerialConsoleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.disableInteractiveSerialConsoleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableInteractiveSerialConsoleTest2() throws Exception {
    DisableInteractiveSerialConsoleResponse expectedResponse =
        DisableInteractiveSerialConsoleResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableInteractiveSerialConsoleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    DisableInteractiveSerialConsoleResponse actualResponse =
        client.disableInteractiveSerialConsoleAsync(name).get();
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
  public void disableInteractiveSerialConsoleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.disableInteractiveSerialConsoleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void detachLunTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
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
  public void detachLunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void detachLunTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String lun = "lun107525";

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
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
  public void detachLunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String lun = "lun107525";
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void detachLunTest3() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
    LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
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
  public void detachLunExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
      LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void detachLunTest4() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setId("id3355")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMachineType("machineType-218117087")
            .setHyperthreadingEnabled(true)
            .putAllLabels(new HashMap<String, String>())
            .addAllLuns(new ArrayList<Lun>())
            .addAllVolumes(new ArrayList<Volume>())
            .addAllNetworks(new ArrayList<Network>())
            .setInteractiveSerialConsoleEnabled(true)
            .setOsImage("osImage-1203193385")
            .setPod("pod111173")
            .setNetworkTemplate("networkTemplate1699249352")
            .addAllLogicalInterfaces(new ArrayList<LogicalInterface>())
            .setLoginInfo("loginInfo-1719604297")
            .setWorkloadProfile(WorkloadProfile.forNumber(0))
            .setFirmwareVersion("firmwareVersion788603549")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("detachLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
    String lun = "lun107525";

    Instance actualResponse = client.detachLunAsync(instance, lun).get();
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
  public void detachLunExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
      String lun = "lun107525";
      client.detachLunAsync(instance, lun).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSSHKeysTest() throws Exception {
    SSHKey responsesElement = SSHKey.newBuilder().build();
    ListSSHKeysResponse expectedResponse =
        ListSSHKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllSshKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSSHKeysPagedResponse pagedListResponse = client.listSSHKeys(parent);

    List<SSHKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSshKeysList().get(0), resources.get(0));

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
  public void listSSHKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSSHKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSSHKeysTest2() throws Exception {
    SSHKey responsesElement = SSHKey.newBuilder().build();
    ListSSHKeysResponse expectedResponse =
        ListSSHKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllSshKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSSHKeysPagedResponse pagedListResponse = client.listSSHKeys(parent);

    List<SSHKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSshKeysList().get(0), resources.get(0));

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
  public void listSSHKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSSHKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSSHKeyTest() throws Exception {
    SSHKey expectedResponse =
        SSHKey.newBuilder()
            .setName(SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]").toString())
            .setPublicKey("publicKey1446899510")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SSHKey sshKey = SSHKey.newBuilder().build();
    String sshKeyId = "sshKeyId593257138";

    SSHKey actualResponse = client.createSSHKey(parent, sshKey, sshKeyId);
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
  public void createSSHKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SSHKey sshKey = SSHKey.newBuilder().build();
      String sshKeyId = "sshKeyId593257138";
      client.createSSHKey(parent, sshKey, sshKeyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSSHKeyTest2() throws Exception {
    SSHKey expectedResponse =
        SSHKey.newBuilder()
            .setName(SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]").toString())
            .setPublicKey("publicKey1446899510")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    SSHKey sshKey = SSHKey.newBuilder().build();
    String sshKeyId = "sshKeyId593257138";

    SSHKey actualResponse = client.createSSHKey(parent, sshKey, sshKeyId);
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
  public void createSSHKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      SSHKey sshKey = SSHKey.newBuilder().build();
      String sshKeyId = "sshKeyId593257138";
      client.createSSHKey(parent, sshKey, sshKeyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSSHKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SshKeyName name = SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]");

    client.deleteSSHKey(name);

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
  public void deleteSSHKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SshKeyName name = SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]");
      client.deleteSSHKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSSHKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1826/locations/location-1826/sshKeys/sshKey-1826";

    client.deleteSSHKey(name);

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
  public void deleteSSHKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1826/locations/location-1826/sshKeys/sshKey-1826";
      client.deleteSSHKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumesTest() throws Exception {
    Volume responsesElement = Volume.newBuilder().build();
    ListVolumesResponse expectedResponse =
        ListVolumesResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVolumesPagedResponse pagedListResponse = client.listVolumes(parent);

    List<Volume> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumesList().get(0), resources.get(0));

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
  public void listVolumesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVolumes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumesTest2() throws Exception {
    Volume responsesElement = Volume.newBuilder().build();
    ListVolumesResponse expectedResponse =
        ListVolumesResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListVolumesPagedResponse pagedListResponse = client.listVolumes(parent);

    List<Volume> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumesList().get(0), resources.get(0));

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
  public void listVolumesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listVolumes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    mockService.addResponse(expectedResponse);

    VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    Volume actualResponse = client.getVolume(name);
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
  public void getVolumeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.getVolume(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeTest2() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";

    Volume actualResponse = client.getVolume(name);
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
  public void getVolumeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";
      client.getVolume(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Volume volume =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Volume actualResponse = client.updateVolumeAsync(volume, updateMask).get();
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
  public void updateVolumeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Volume volume =
          Volume.newBuilder()
              .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
              .setId("id3355")
              .setRequestedSizeGib(525454387)
              .setOriginallyRequestedSizeGib(44854004)
              .setCurrentSizeGib(72696456)
              .setEmergencySizeGib(1936971120)
              .setMaxSizeGib(1805521661)
              .setAutoGrownSizeGib(1245638678)
              .setRemainingSpaceGib(1423108606)
              .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setSnapshotEnabled(true)
              .setPod("pod111173")
              .setBootVolume(true)
              .setPerformanceTier(VolumePerformanceTier.forNumber(0))
              .setNotes("notes105008833")
              .setExpireTime(Timestamp.newBuilder().build())
              .addAllInstances(new ArrayList<String>())
              .setAttached(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVolumeAsync(volume, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void renameVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    mockService.addResponse(expectedResponse);

    VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
    String newVolumeId = "newVolumeId-613023851";

    Volume actualResponse = client.renameVolume(name, newVolumeId);
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
  public void renameVolumeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      String newVolumeId = "newVolumeId-613023851";
      client.renameVolume(name, newVolumeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameVolumeTest2() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";
    String newVolumeId = "newVolumeId-613023851";

    Volume actualResponse = client.renameVolume(name, newVolumeId);
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
  public void renameVolumeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";
      String newVolumeId = "newVolumeId-613023851";
      client.renameVolume(name, newVolumeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void evictVolumeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("evictVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    client.evictVolumeAsync(name).get();

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
  public void evictVolumeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.evictVolumeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void evictVolumeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("evictVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";

    client.evictVolumeAsync(name).get();

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
  public void evictVolumeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4193/locations/location-4193/volumes/volume-4193";
      client.evictVolumeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resizeVolumeTest() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resizeVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
    long sizeGib = 847296130;

    Volume actualResponse = client.resizeVolumeAsync(volume, sizeGib).get();
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
  public void resizeVolumeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      long sizeGib = 847296130;
      client.resizeVolumeAsync(volume, sizeGib).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resizeVolumeTest2() throws Exception {
    Volume expectedResponse =
        Volume.newBuilder()
            .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setId("id3355")
            .setRequestedSizeGib(525454387)
            .setOriginallyRequestedSizeGib(44854004)
            .setCurrentSizeGib(72696456)
            .setEmergencySizeGib(1936971120)
            .setMaxSizeGib(1805521661)
            .setAutoGrownSizeGib(1245638678)
            .setRemainingSpaceGib(1423108606)
            .setSnapshotReservationDetail(Volume.SnapshotReservationDetail.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSnapshotEnabled(true)
            .setPod("pod111173")
            .setBootVolume(true)
            .setPerformanceTier(VolumePerformanceTier.forNumber(0))
            .setNotes("notes105008833")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .setAttached(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resizeVolumeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String volume = "projects/project-6830/locations/location-6830/volumes/volume-6830";
    long sizeGib = 847296130;

    Volume actualResponse = client.resizeVolumeAsync(volume, sizeGib).get();
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
  public void resizeVolumeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String volume = "projects/project-6830/locations/location-6830/volumes/volume-6830";
      long sizeGib = 847296130;
      client.resizeVolumeAsync(volume, sizeGib).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listNetworksTest() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

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
  public void listNetworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworksTest2() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(parent);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

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
  public void listNetworksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkUsageTest() throws Exception {
    ListNetworkUsageResponse expectedResponse =
        ListNetworkUsageResponse.newBuilder().addAllNetworks(new ArrayList<NetworkUsage>()).build();
    mockService.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworkUsageResponse actualResponse = client.listNetworkUsage(location);
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
  public void listNetworkUsageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworkUsage(location);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkUsageTest2() throws Exception {
    ListNetworkUsageResponse expectedResponse =
        ListNetworkUsageResponse.newBuilder().addAllNetworks(new ArrayList<NetworkUsage>()).build();
    mockService.addResponse(expectedResponse);

    String location = "projects/project-7132/locations/location-7132";

    ListNetworkUsageResponse actualResponse = client.listNetworkUsage(location);
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
  public void listNetworkUsageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String location = "projects/project-7132/locations/location-7132";
      client.listNetworkUsage(location);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");

    Network actualResponse = client.getNetwork(name);
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
  public void getNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6795/locations/location-6795/networks/network-6795";

    Network actualResponse = client.getNetwork(name);
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
  public void getNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6795/locations/location-6795/networks/network-6795";
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Network network =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Network actualResponse = client.updateNetworkAsync(network, updateMask).get();
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
  public void updateNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Network network =
          Network.newBuilder()
              .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
              .setId("id3355")
              .setIpAddress("ipAddress1634032845")
              .addAllMacAddress(new ArrayList<String>())
              .setVlanId("vlanId-813989410")
              .setCidr("cidr3053428")
              .setVrf(VRF.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setServicesCidr("servicesCidr377076978")
              .addAllReservations(new ArrayList<NetworkAddressReservation>())
              .setPod("pod111173")
              .addAllMountPoints(new ArrayList<NetworkMountPoint>())
              .setJumboFramesEnabled(true)
              .setGatewayIp("gatewayIp-1354641781")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetworkAsync(network, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
    VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();

    VolumeSnapshot actualResponse = client.createVolumeSnapshot(parent, volumeSnapshot);
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
  public void createVolumeSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
      client.createVolumeSnapshot(parent, volumeSnapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-402/locations/location-402/volumes/volume-402";
    VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();

    VolumeSnapshot actualResponse = client.createVolumeSnapshot(parent, volumeSnapshot);
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
  public void createVolumeSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-402/locations/location-402/volumes/volume-402";
      VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
      client.createVolumeSnapshot(parent, volumeSnapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreVolumeSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VolumeSnapshotName volumeSnapshot =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    VolumeSnapshot actualResponse = client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
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
  public void restoreVolumeSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeSnapshotName volumeSnapshot =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restoreVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreVolumeSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String volumeSnapshot =
        "projects/project-3235/locations/location-3235/volumes/volume-3235/snapshots/snapshot-3235";

    VolumeSnapshot actualResponse = client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
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
  public void restoreVolumeSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String volumeSnapshot =
          "projects/project-3235/locations/location-3235/volumes/volume-3235/snapshots/snapshot-3235";
      client.restoreVolumeSnapshotAsync(volumeSnapshot).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVolumeSnapshotTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    VolumeSnapshotName name =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    client.deleteVolumeSnapshot(name);

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
  public void deleteVolumeSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeSnapshotName name =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.deleteVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteVolumeSnapshotTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4650/locations/location-4650/volumes/volume-4650/snapshots/snapshot-4650";

    client.deleteVolumeSnapshot(name);

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
  public void deleteVolumeSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4650/locations/location-4650/volumes/volume-4650/snapshots/snapshot-4650";
      client.deleteVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeSnapshotTest() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    VolumeSnapshotName name =
        VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");

    VolumeSnapshot actualResponse = client.getVolumeSnapshot(name);
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
  public void getVolumeSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeSnapshotName name =
          VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
      client.getVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeSnapshotTest2() throws Exception {
    VolumeSnapshot expectedResponse =
        VolumeSnapshot.newBuilder()
            .setName(
                VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
                    .toString())
            .setId("id3355")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4650/locations/location-4650/volumes/volume-4650/snapshots/snapshot-4650";

    VolumeSnapshot actualResponse = client.getVolumeSnapshot(name);
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
  public void getVolumeSnapshotExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4650/locations/location-4650/volumes/volume-4650/snapshots/snapshot-4650";
      client.getVolumeSnapshot(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeSnapshotsTest() throws Exception {
    VolumeSnapshot responsesElement = VolumeSnapshot.newBuilder().build();
    ListVolumeSnapshotsResponse expectedResponse =
        ListVolumeSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeSnapshots(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    ListVolumeSnapshotsPagedResponse pagedListResponse = client.listVolumeSnapshots(parent);

    List<VolumeSnapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeSnapshotsList().get(0), resources.get(0));

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
  public void listVolumeSnapshotsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.listVolumeSnapshots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeSnapshotsTest2() throws Exception {
    VolumeSnapshot responsesElement = VolumeSnapshot.newBuilder().build();
    ListVolumeSnapshotsResponse expectedResponse =
        ListVolumeSnapshotsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeSnapshots(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-402/locations/location-402/volumes/volume-402";

    ListVolumeSnapshotsPagedResponse pagedListResponse = client.listVolumeSnapshots(parent);

    List<VolumeSnapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeSnapshotsList().get(0), resources.get(0));

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
  public void listVolumeSnapshotsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-402/locations/location-402/volumes/volume-402";
      client.listVolumeSnapshots(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLunTest() throws Exception {
    Lun expectedResponse =
        Lun.newBuilder()
            .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
            .setId("id3355")
            .setSizeGb(2105542105)
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setShareable(true)
            .setBootLun(true)
            .setWwid("wwid3662843")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    Lun actualResponse = client.getLun(name);
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
  public void getLunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.getLun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLunTest2() throws Exception {
    Lun expectedResponse =
        Lun.newBuilder()
            .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
            .setId("id3355")
            .setSizeGb(2105542105)
            .setStorageVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .setShareable(true)
            .setBootLun(true)
            .setWwid("wwid3662843")
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllInstances(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5639/locations/location-5639/volumes/volume-5639/luns/lun-5639";

    Lun actualResponse = client.getLun(name);
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
  public void getLunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5639/locations/location-5639/volumes/volume-5639/luns/lun-5639";
      client.getLun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLunsTest() throws Exception {
    Lun responsesElement = Lun.newBuilder().build();
    ListLunsResponse expectedResponse =
        ListLunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLuns(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");

    ListLunsPagedResponse pagedListResponse = client.listLuns(parent);

    List<Lun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLunsList().get(0), resources.get(0));

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
  public void listLunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
      client.listLuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLunsTest2() throws Exception {
    Lun responsesElement = Lun.newBuilder().build();
    ListLunsResponse expectedResponse =
        ListLunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLuns(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-402/locations/location-402/volumes/volume-402";

    ListLunsPagedResponse pagedListResponse = client.listLuns(parent);

    List<Lun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLunsList().get(0), resources.get(0));

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
  public void listLunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-402/locations/location-402/volumes/volume-402";
      client.listLuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void evictLunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("evictLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");

    client.evictLunAsync(name).get();

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
  public void evictLunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
      client.evictLunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void evictLunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("evictLunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-5639/locations/location-5639/volumes/volume-5639/luns/lun-5639";

    client.evictLunAsync(name).get();

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
  public void evictLunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5639/locations/location-5639/volumes/volume-5639/luns/lun-5639";
      client.evictLunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    mockService.addResponse(expectedResponse);

    NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");

    NfsShare actualResponse = client.getNfsShare(name);
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
  public void getNfsShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
      client.getNfsShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNfsShareTest2() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";

    NfsShare actualResponse = client.getNfsShare(name);
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
  public void getNfsShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";
      client.getNfsShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNfsSharesTest() throws Exception {
    NfsShare responsesElement = NfsShare.newBuilder().build();
    ListNfsSharesResponse expectedResponse =
        ListNfsSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNfsShares(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNfsSharesPagedResponse pagedListResponse = client.listNfsShares(parent);

    List<NfsShare> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNfsSharesList().get(0), resources.get(0));

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
  public void listNfsSharesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNfsShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNfsSharesTest2() throws Exception {
    NfsShare responsesElement = NfsShare.newBuilder().build();
    ListNfsSharesResponse expectedResponse =
        ListNfsSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNfsShares(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNfsSharesPagedResponse pagedListResponse = client.listNfsShares(parent);

    List<NfsShare> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNfsSharesList().get(0), resources.get(0));

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
  public void listNfsSharesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNfsShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NfsShare nfsShare =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NfsShare actualResponse = client.updateNfsShareAsync(nfsShare, updateMask).get();
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
  public void updateNfsShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NfsShare nfsShare =
          NfsShare.newBuilder()
              .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
              .setNfsShareId("nfsShareId-1834781921")
              .setId("id3355")
              .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
              .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
              .putAllLabels(new HashMap<String, String>())
              .setRequestedSizeGib(525454387)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNfsShareAsync(nfsShare, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NfsShare nfsShare = NfsShare.newBuilder().build();

    NfsShare actualResponse = client.createNfsShareAsync(parent, nfsShare).get();
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
  public void createNfsShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NfsShare nfsShare = NfsShare.newBuilder().build();
      client.createNfsShareAsync(parent, nfsShare).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createNfsShareTest2() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    NfsShare nfsShare = NfsShare.newBuilder().build();

    NfsShare actualResponse = client.createNfsShareAsync(parent, nfsShare).get();
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
  public void createNfsShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      NfsShare nfsShare = NfsShare.newBuilder().build();
      client.createNfsShareAsync(parent, nfsShare).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void renameNfsShareTest() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    mockService.addResponse(expectedResponse);

    NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
    String newNfsshareId = "newNfsshareId1643043071";

    NfsShare actualResponse = client.renameNfsShare(name, newNfsshareId);
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
  public void renameNfsShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
      String newNfsshareId = "newNfsshareId1643043071";
      client.renameNfsShare(name, newNfsshareId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameNfsShareTest2() throws Exception {
    NfsShare expectedResponse =
        NfsShare.newBuilder()
            .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
            .setNfsShareId("nfsShareId-1834781921")
            .setId("id3355")
            .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
            .addAllAllowedClients(new ArrayList<NfsShare.AllowedClient>())
            .putAllLabels(new HashMap<String, String>())
            .setRequestedSizeGib(525454387)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";
    String newNfsshareId = "newNfsshareId1643043071";

    NfsShare actualResponse = client.renameNfsShare(name, newNfsshareId);
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
  public void renameNfsShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";
      String newNfsshareId = "newNfsshareId1643043071";
      client.renameNfsShare(name, newNfsshareId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNfsShareTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");

    client.deleteNfsShareAsync(name).get();

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
  public void deleteNfsShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
      client.deleteNfsShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteNfsShareTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNfsShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";

    client.deleteNfsShareAsync(name).get();

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
  public void deleteNfsShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1365/locations/location-1365/nfsShares/nfsShare-1365";
      client.deleteNfsShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listProvisioningQuotasTest() throws Exception {
    ProvisioningQuota responsesElement = ProvisioningQuota.newBuilder().build();
    ListProvisioningQuotasResponse expectedResponse =
        ListProvisioningQuotasResponse.newBuilder()
            .setNextPageToken("")
            .addAllProvisioningQuotas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProvisioningQuotasPagedResponse pagedListResponse = client.listProvisioningQuotas(parent);

    List<ProvisioningQuota> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProvisioningQuotasList().get(0), resources.get(0));

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
  public void listProvisioningQuotasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProvisioningQuotas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProvisioningQuotasTest2() throws Exception {
    ProvisioningQuota responsesElement = ProvisioningQuota.newBuilder().build();
    ListProvisioningQuotasResponse expectedResponse =
        ListProvisioningQuotasResponse.newBuilder()
            .setNextPageToken("")
            .addAllProvisioningQuotas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListProvisioningQuotasPagedResponse pagedListResponse = client.listProvisioningQuotas(parent);

    List<ProvisioningQuota> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProvisioningQuotasList().get(0), resources.get(0));

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
  public void listProvisioningQuotasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listProvisioningQuotas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitProvisioningConfigTest() throws Exception {
    SubmitProvisioningConfigResponse expectedResponse =
        SubmitProvisioningConfigResponse.newBuilder()
            .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();

    SubmitProvisioningConfigResponse actualResponse =
        client.submitProvisioningConfig(parent, provisioningConfig);
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
  public void submitProvisioningConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
      client.submitProvisioningConfig(parent, provisioningConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitProvisioningConfigTest2() throws Exception {
    SubmitProvisioningConfigResponse expectedResponse =
        SubmitProvisioningConfigResponse.newBuilder()
            .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();

    SubmitProvisioningConfigResponse actualResponse =
        client.submitProvisioningConfig(parent, provisioningConfig);
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
  public void submitProvisioningConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
      client.submitProvisioningConfig(parent, provisioningConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProvisioningConfigTest() throws Exception {
    ProvisioningConfig expectedResponse =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    mockService.addResponse(expectedResponse);

    ProvisioningConfigName name =
        ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]");

    ProvisioningConfig actualResponse = client.getProvisioningConfig(name);
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
  public void getProvisioningConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProvisioningConfigName name =
          ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]");
      client.getProvisioningConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProvisioningConfigTest2() throws Exception {
    ProvisioningConfig expectedResponse =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6646/locations/location-6646/provisioningConfigs/provisioningConfig-6646";

    ProvisioningConfig actualResponse = client.getProvisioningConfig(name);
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
  public void getProvisioningConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6646/locations/location-6646/provisioningConfigs/provisioningConfig-6646";
      client.getProvisioningConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProvisioningConfigTest() throws Exception {
    ProvisioningConfig expectedResponse =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();

    ProvisioningConfig actualResponse = client.createProvisioningConfig(parent, provisioningConfig);
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
  public void createProvisioningConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
      client.createProvisioningConfig(parent, provisioningConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProvisioningConfigTest2() throws Exception {
    ProvisioningConfig expectedResponse =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();

    ProvisioningConfig actualResponse = client.createProvisioningConfig(parent, provisioningConfig);
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
  public void createProvisioningConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
      client.createProvisioningConfig(parent, provisioningConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProvisioningConfigTest() throws Exception {
    ProvisioningConfig expectedResponse =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    mockService.addResponse(expectedResponse);

    ProvisioningConfig provisioningConfig =
        ProvisioningConfig.newBuilder()
            .setName(
                ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                    .toString())
            .addAllInstances(new ArrayList<InstanceConfig>())
            .addAllNetworks(new ArrayList<NetworkConfig>())
            .addAllVolumes(new ArrayList<VolumeConfig>())
            .setTicketId("ticketId1937367367")
            .setHandoverServiceAccount("handoverServiceAccount-1161200037")
            .setEmail("email96619420")
            .setLocation("location1901043637")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudConsoleUri("cloudConsoleUri-2074144598")
            .setVpcScEnabled(true)
            .setStatusMessage("statusMessage-958704715")
            .setCustomId("customId606174316")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ProvisioningConfig actualResponse =
        client.updateProvisioningConfig(provisioningConfig, updateMask);
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
  public void updateProvisioningConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProvisioningConfig provisioningConfig =
          ProvisioningConfig.newBuilder()
              .setName(
                  ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
                      .toString())
              .addAllInstances(new ArrayList<InstanceConfig>())
              .addAllNetworks(new ArrayList<NetworkConfig>())
              .addAllVolumes(new ArrayList<VolumeConfig>())
              .setTicketId("ticketId1937367367")
              .setHandoverServiceAccount("handoverServiceAccount-1161200037")
              .setEmail("email96619420")
              .setLocation("location1901043637")
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCloudConsoleUri("cloudConsoleUri-2074144598")
              .setVpcScEnabled(true)
              .setStatusMessage("statusMessage-958704715")
              .setCustomId("customId606174316")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProvisioningConfig(provisioningConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
    String newNetworkId = "newNetworkId-1927751127";

    Network actualResponse = client.renameNetwork(name, newNetworkId);
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
  public void renameNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
      String newNetworkId = "newNetworkId-1927751127";
      client.renameNetwork(name, newNetworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
            .setId("id3355")
            .setIpAddress("ipAddress1634032845")
            .addAllMacAddress(new ArrayList<String>())
            .setVlanId("vlanId-813989410")
            .setCidr("cidr3053428")
            .setVrf(VRF.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setServicesCidr("servicesCidr377076978")
            .addAllReservations(new ArrayList<NetworkAddressReservation>())
            .setPod("pod111173")
            .addAllMountPoints(new ArrayList<NetworkMountPoint>())
            .setJumboFramesEnabled(true)
            .setGatewayIp("gatewayIp-1354641781")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6795/locations/location-6795/networks/network-6795";
    String newNetworkId = "newNetworkId-1927751127";

    Network actualResponse = client.renameNetwork(name, newNetworkId);
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
  public void renameNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6795/locations/location-6795/networks/network-6795";
      String newNetworkId = "newNetworkId-1927751127";
      client.renameNetwork(name, newNetworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSImagesTest() throws Exception {
    OSImage responsesElement = OSImage.newBuilder().build();
    ListOSImagesResponse expectedResponse =
        ListOSImagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsImages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOSImagesPagedResponse pagedListResponse = client.listOSImages(parent);

    List<OSImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsImagesList().get(0), resources.get(0));

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
  public void listOSImagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listOSImages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSImagesTest2() throws Exception {
    OSImage responsesElement = OSImage.newBuilder().build();
    ListOSImagesResponse expectedResponse =
        ListOSImagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsImages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListOSImagesPagedResponse pagedListResponse = client.listOSImages(parent);

    List<OSImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsImagesList().get(0), resources.get(0));

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
  public void listOSImagesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listOSImages(parent);
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
