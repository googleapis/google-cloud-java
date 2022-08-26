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

package com.google.cloud.datafusion.v1;

import static com.google.cloud.datafusion.v1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1.DataFusionClient.ListInstancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datafusion.v1.stub.HttpJsonDataFusionStub;
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
public class DataFusionClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataFusionClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataFusionStub.getMethodDescriptors(), DataFusionSettings.getDefaultEndpoint());
    DataFusionSettings settings =
        DataFusionSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataFusionSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataFusionClient.create(settings);
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
  public void listAvailableVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListAvailableVersionsResponse expectedResponse =
        ListAvailableVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAvailableVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAvailableVersionsPagedResponse pagedListResponse = client.listAvailableVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAvailableVersionsList().get(0), resources.get(0));

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
  public void listAvailableVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAvailableVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAvailableVersionsTest2() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListAvailableVersionsResponse expectedResponse =
        ListAvailableVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAvailableVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAvailableVersionsPagedResponse pagedListResponse = client.listAvailableVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAvailableVersionsList().get(0), resources.get(0));

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
  public void listAvailableVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAvailableVersions(parent);
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
    mockService.addResponse(expectedResponse);

    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setOrderBy("orderBy-1207110587")
            .build();

    ListInstancesPagedResponse pagedListResponse = client.listInstances(request);

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
      ListInstancesRequest request =
          ListInstancesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      client.listInstances(request);
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
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
            .build();
    mockService.addResponse(expectedResponse);

    GetInstanceRequest request =
        GetInstanceRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .build();

    Instance actualResponse = client.getInstance(request);
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
      GetInstanceRequest request =
          GetInstanceRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .build();
      client.getInstance(request);
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
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
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
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
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
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
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
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
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
              .setDescription("description-1724546052")
              .setEnableStackdriverLogging(true)
              .setEnableStackdriverMonitoring(true)
              .setPrivateInstance(true)
              .setNetworkConfig(NetworkConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .putAllOptions(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setStateMessage("stateMessage1128185398")
              .setServiceEndpoint("serviceEndpoint-1323187350")
              .setZone("zone3744684")
              .setVersion("version351608024")
              .setServiceAccount("serviceAccount1079137720")
              .setDisplayName("displayName1714148973")
              .addAllAvailableVersion(new ArrayList<Version>())
              .setApiEndpoint("apiEndpoint-2038677041")
              .setGcsBucket("gcsBucket239654881")
              .addAllAccelerators(new ArrayList<Accelerator>())
              .setP4ServiceAccount("p4ServiceAccount-184825700")
              .setTenantProjectId("tenantProjectId674318474")
              .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
              .setEnableRbac(true)
              .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
              .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restartInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .addAllDisabledReason(new ArrayList<Instance.DisabledReason>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restartInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RestartInstanceRequest request =
        RestartInstanceRequest.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .build();

    Instance actualResponse = client.restartInstanceAsync(request).get();
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
  public void restartInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestartInstanceRequest request =
          RestartInstanceRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .build();
      client.restartInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
