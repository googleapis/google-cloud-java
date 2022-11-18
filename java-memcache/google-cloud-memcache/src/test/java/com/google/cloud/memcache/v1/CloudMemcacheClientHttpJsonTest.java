/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.memcache.v1;

import static com.google.cloud.memcache.v1.CloudMemcacheClient.ListInstancesPagedResponse;
import static com.google.cloud.memcache.v1.CloudMemcacheClient.ListLocationsPagedResponse;

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
import com.google.cloud.memcache.v1.stub.HttpJsonCloudMemcacheStub;
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
public class CloudMemcacheClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudMemcacheClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudMemcacheStub.getMethodDescriptors(),
            CloudMemcacheSettings.getDefaultEndpoint());
    CloudMemcacheSettings settings =
        CloudMemcacheSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudMemcacheSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudMemcacheClient.create(settings);
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
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
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setAuthorizedNetwork("authorizedNetwork1515554835")
              .addAllZones(new ArrayList<String>())
              .setNodeCount(1539922066)
              .setNodeConfig(Instance.NodeConfig.newBuilder().build())
              .setMemcacheVersion(MemcacheVersion.forNumber(0))
              .setParameters(MemcacheParameters.newBuilder().build())
              .addAllMemcacheNodes(new ArrayList<Instance.Node>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setMemcacheFullVersion("memcacheFullVersion976507452")
              .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
              .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
              .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
              .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateParametersTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FieldMask updateMask = FieldMask.newBuilder().build();
    MemcacheParameters parameters = MemcacheParameters.newBuilder().build();

    Instance actualResponse = client.updateParametersAsync(name, updateMask, parameters).get();
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
  public void updateParametersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FieldMask updateMask = FieldMask.newBuilder().build();
      MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
      client.updateParametersAsync(name, updateMask, parameters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateParametersTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    FieldMask updateMask = FieldMask.newBuilder().build();
    MemcacheParameters parameters = MemcacheParameters.newBuilder().build();

    Instance actualResponse = client.updateParametersAsync(name, updateMask, parameters).get();
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
  public void updateParametersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      FieldMask updateMask = FieldMask.newBuilder().build();
      MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
      client.updateParametersAsync(name, updateMask, parameters).get();
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
  public void applyParametersTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applyParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applyParametersAsync(name, nodeIds, applyAll).get();
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
  public void applyParametersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applyParametersAsync(name, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void applyParametersTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("applyParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    List<String> nodeIds = new ArrayList<>();
    boolean applyAll = true;

    Instance actualResponse = client.applyParametersAsync(name, nodeIds, applyAll).get();
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
  public void applyParametersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      client.applyParametersAsync(name, nodeIds, applyAll).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void rescheduleMaintenanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(instance, rescheduleType, scheduleTime).get();
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
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(instance, rescheduleType, scheduleTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void rescheduleMaintenanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizedNetwork("authorizedNetwork1515554835")
            .addAllZones(new ArrayList<String>())
            .setNodeCount(1539922066)
            .setNodeConfig(Instance.NodeConfig.newBuilder().build())
            .setMemcacheVersion(MemcacheVersion.forNumber(0))
            .setParameters(MemcacheParameters.newBuilder().build())
            .addAllMemcacheNodes(new ArrayList<Instance.Node>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMemcacheFullVersion("memcacheFullVersion976507452")
            .addAllInstanceMessages(new ArrayList<Instance.InstanceMessage>())
            .setDiscoveryEndpoint("discoveryEndpoint-1155573915")
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rescheduleMaintenanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
    RescheduleMaintenanceRequest.RescheduleType rescheduleType =
        RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
    Timestamp scheduleTime = Timestamp.newBuilder().build();

    Instance actualResponse =
        client.rescheduleMaintenanceAsync(instance, rescheduleType, scheduleTime).get();
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
      String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
      RescheduleMaintenanceRequest.RescheduleType rescheduleType =
          RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
      Timestamp scheduleTime = Timestamp.newBuilder().build();
      client.rescheduleMaintenanceAsync(instance, rescheduleType, scheduleTime).get();
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
