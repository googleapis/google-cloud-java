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

package com.google.cloud.financialservices.v1;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.financialservices.v1.stub.HttpJsonAMLStub;
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
import com.google.type.Interval;
import com.google.type.TimeZone;
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
public class AMLClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AMLClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAMLStub.getMethodDescriptors(), AMLSettings.getDefaultEndpoint());
    AMLSettings settings =
        AMLSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AMLSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AMLClient.create(settings);
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
            .setKmsKey("kmsKey-1127483058")
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
            .setKmsKey("kmsKey-1127483058")
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
            .setKmsKey("kmsKey-1127483058")
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
            .setKmsKey("kmsKey-1127483058")
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
            .setKmsKey("kmsKey-1127483058")
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
            .setKmsKey("kmsKey-1127483058")
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
              .setKmsKey("kmsKey-1127483058")
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
  public void importRegisteredPartiesTest() throws Exception {
    ImportRegisteredPartiesResponse expectedResponse =
        ImportRegisteredPartiesResponse.newBuilder()
            .setPartiesAdded(2042133253)
            .setPartiesRemoved(1929921829)
            .setPartiesTotal(2060023113)
            .setPartiesFailedToRemove(151928353)
            .setPartiesUptiered(1998473271)
            .setPartiesDowntiered(-1262161346)
            .setPartiesFailedToDowntier(1915135969)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ImportRegisteredPartiesRequest.UpdateMode mode =
        ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
    List<String> partyTables = new ArrayList<>();

    ImportRegisteredPartiesResponse actualResponse =
        client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
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
  public void importRegisteredPartiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      ImportRegisteredPartiesRequest.UpdateMode mode =
          ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      List<String> partyTables = new ArrayList<>();
      client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importRegisteredPartiesTest2() throws Exception {
    ImportRegisteredPartiesResponse expectedResponse =
        ImportRegisteredPartiesResponse.newBuilder()
            .setPartiesAdded(2042133253)
            .setPartiesRemoved(1929921829)
            .setPartiesTotal(2060023113)
            .setPartiesFailedToRemove(151928353)
            .setPartiesUptiered(1998473271)
            .setPartiesDowntiered(-1262161346)
            .setPartiesFailedToDowntier(1915135969)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    ImportRegisteredPartiesRequest.UpdateMode mode =
        ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
    List<String> partyTables = new ArrayList<>();

    ImportRegisteredPartiesResponse actualResponse =
        client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
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
  public void importRegisteredPartiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      ImportRegisteredPartiesRequest.UpdateMode mode =
          ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      List<String> partyTables = new ArrayList<>();
      client.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportRegisteredPartiesTest() throws Exception {
    ExportRegisteredPartiesResponse expectedResponse =
        ExportRegisteredPartiesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);

    ExportRegisteredPartiesResponse actualResponse =
        client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
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
  public void exportRegisteredPartiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportRegisteredPartiesTest2() throws Exception {
    ExportRegisteredPartiesResponse expectedResponse =
        ExportRegisteredPartiesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegisteredPartiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
    BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
    LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);

    ExportRegisteredPartiesResponse actualResponse =
        client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
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
  public void exportRegisteredPartiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
      LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
      client.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDatasetsTest() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

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
  public void listDatasetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest2() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

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
  public void listDatasetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-111/locations/location-111/instances/instance-111/datasets/dataset-111";

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-111/locations/location-111/instances/instance-111/datasets/dataset-111";
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Dataset dataset = Dataset.newBuilder().build();
    String datasetId = "datasetId-345342029";

    Dataset actualResponse = client.createDatasetAsync(parent, dataset, datasetId).get();
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
  public void createDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Dataset dataset = Dataset.newBuilder().build();
      String datasetId = "datasetId-345342029";
      client.createDatasetAsync(parent, dataset, datasetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    Dataset dataset = Dataset.newBuilder().build();
    String datasetId = "datasetId-345342029";

    Dataset actualResponse = client.createDatasetAsync(parent, dataset, datasetId).get();
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
  public void createDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      Dataset dataset = Dataset.newBuilder().build();
      String datasetId = "datasetId-345342029";
      client.createDatasetAsync(parent, dataset, datasetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Dataset dataset =
        Dataset.newBuilder()
            .setName(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllTableSpecs(new HashMap<String, String>())
            .setDateRange(Interval.newBuilder().build())
            .setTimeZone(TimeZone.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Dataset actualResponse = client.updateDatasetAsync(dataset, updateMask).get();
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
  public void updateDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Dataset dataset =
          Dataset.newBuilder()
              .setName(
                  DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .putAllTableSpecs(new HashMap<String, String>())
              .setDateRange(Interval.newBuilder().build())
              .setTimeZone(TimeZone.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetAsync(dataset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");

    client.deleteDatasetAsync(name).get();

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
  public void deleteDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-111/locations/location-111/instances/instance-111/datasets/dataset-111";

    client.deleteDatasetAsync(name).get();

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
  public void deleteDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-111/locations/location-111/instances/instance-111/datasets/dataset-111";
      client.deleteDatasetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

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
  public void listModelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");

    Model actualResponse = client.getModel(name);
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
  public void getModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7184/locations/location-7184/instances/instance-7184/models/model-7184";

    Model actualResponse = client.getModel(name);
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
  public void getModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7184/locations/location-7184/instances/instance-7184/models/model-7184";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Model model = Model.newBuilder().build();
    String modelId = "modelId1226956324";

    Model actualResponse = client.createModelAsync(parent, model, modelId).get();
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
  public void createModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Model model = Model.newBuilder().build();
      String modelId = "modelId1226956324";
      client.createModelAsync(parent, model, modelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    Model model = Model.newBuilder().build();
    String modelId = "modelId1226956324";

    Model actualResponse = client.createModelAsync(parent, model, modelId).get();
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
  public void createModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      Model model = Model.newBuilder().build();
      String modelId = "modelId1226956324";
      client.createModelAsync(parent, model, modelId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Model model =
        Model.newBuilder()
            .setName(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setEngineConfig(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setPrimaryDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Model actualResponse = client.updateModelAsync(model, updateMask).get();
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
  public void updateModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Model model =
          Model.newBuilder()
              .setName(
                  ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setEngineVersion(
                  EngineVersionName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                      .toString())
              .setEngineConfig(
                  EngineConfigName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                      .toString())
              .setPrimaryDataset(
                  DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
                      .toString())
              .setEndTime(Timestamp.newBuilder().build())
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateModelAsync(model, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportModelMetadataTest() throws Exception {
    ExportModelMetadataResponse expectedResponse = ExportModelMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ModelName model = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportModelMetadataResponse actualResponse =
        client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
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
  public void exportModelMetadataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName model = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportModelMetadataTest2() throws Exception {
    ExportModelMetadataResponse expectedResponse = ExportModelMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String model =
        "projects/project-1422/locations/location-1422/instances/instance-1422/models/model-1422";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportModelMetadataResponse actualResponse =
        client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
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
  public void exportModelMetadataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String model =
          "projects/project-1422/locations/location-1422/instances/instance-1422/models/model-1422";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportModelMetadataAsync(model, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");

    client.deleteModelAsync(name).get();

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
  public void deleteModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7184/locations/location-7184/instances/instance-7184/models/model-7184";

    client.deleteModelAsync(name).get();

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
  public void deleteModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7184/locations/location-7184/instances/instance-7184/models/model-7184";
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEngineConfigsTest() throws Exception {
    EngineConfig responsesElement = EngineConfig.newBuilder().build();
    ListEngineConfigsResponse expectedResponse =
        ListEngineConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListEngineConfigsPagedResponse pagedListResponse = client.listEngineConfigs(parent);

    List<EngineConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineConfigsList().get(0), resources.get(0));

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
  public void listEngineConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listEngineConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineConfigsTest2() throws Exception {
    EngineConfig responsesElement = EngineConfig.newBuilder().build();
    ListEngineConfigsResponse expectedResponse =
        ListEngineConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListEngineConfigsPagedResponse pagedListResponse = client.listEngineConfigs(parent);

    List<EngineConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineConfigsList().get(0), resources.get(0));

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
  public void listEngineConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listEngineConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EngineConfigName name =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");

    EngineConfig actualResponse = client.getEngineConfig(name);
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
  public void getEngineConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineConfigName name =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      client.getEngineConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineConfigTest2() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4863/locations/location-4863/instances/instance-4863/engineConfigs/engineConfig-4863";

    EngineConfig actualResponse = client.getEngineConfig(name);
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
  public void getEngineConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4863/locations/location-4863/instances/instance-4863/engineConfigs/engineConfig-4863";
      client.getEngineConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    EngineConfig engineConfig = EngineConfig.newBuilder().build();
    String engineConfigId = "engineConfigId451461215";

    EngineConfig actualResponse =
        client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
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
  public void createEngineConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      EngineConfig engineConfig = EngineConfig.newBuilder().build();
      String engineConfigId = "engineConfigId451461215";
      client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEngineConfigTest2() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    EngineConfig engineConfig = EngineConfig.newBuilder().build();
    String engineConfigId = "engineConfigId451461215";

    EngineConfig actualResponse =
        client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
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
  public void createEngineConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      EngineConfig engineConfig = EngineConfig.newBuilder().build();
      String engineConfigId = "engineConfigId451461215";
      client.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEngineConfigTest() throws Exception {
    EngineConfig expectedResponse =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EngineConfig engineConfig =
        EngineConfig.newBuilder()
            .setName(
                EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEngineVersion(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setTuning(EngineConfig.Tuning.newBuilder().build())
            .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EngineConfig actualResponse = client.updateEngineConfigAsync(engineConfig, updateMask).get();
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
  public void updateEngineConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineConfig engineConfig =
          EngineConfig.newBuilder()
              .setName(
                  EngineConfigName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setEngineVersion(
                  EngineVersionName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                      .toString())
              .setTuning(EngineConfig.Tuning.newBuilder().build())
              .setPerformanceTarget(EngineConfig.PerformanceTarget.newBuilder().build())
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .setHyperparameterSource(EngineConfig.HyperparameterSource.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEngineConfigAsync(engineConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportEngineConfigMetadataTest() throws Exception {
    ExportEngineConfigMetadataResponse expectedResponse =
        ExportEngineConfigMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEngineConfigMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EngineConfigName engineConfig =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportEngineConfigMetadataResponse actualResponse =
        client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
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
  public void exportEngineConfigMetadataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineConfigName engineConfig =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportEngineConfigMetadataTest2() throws Exception {
    ExportEngineConfigMetadataResponse expectedResponse =
        ExportEngineConfigMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEngineConfigMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String engineConfig =
        "projects/project-7896/locations/location-7896/instances/instance-7896/engineConfigs/engineConfig-7896";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportEngineConfigMetadataResponse actualResponse =
        client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
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
  public void exportEngineConfigMetadataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String engineConfig =
          "projects/project-7896/locations/location-7896/instances/instance-7896/engineConfigs/engineConfig-7896";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEngineConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EngineConfigName name =
        EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");

    client.deleteEngineConfigAsync(name).get();

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
  public void deleteEngineConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineConfigName name =
          EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
      client.deleteEngineConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEngineConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4863/locations/location-4863/instances/instance-4863/engineConfigs/engineConfig-4863";

    client.deleteEngineConfigAsync(name).get();

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
  public void deleteEngineConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4863/locations/location-4863/instances/instance-4863/engineConfigs/engineConfig-4863";
      client.deleteEngineConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getEngineVersionTest() throws Exception {
    EngineVersion expectedResponse =
        EngineVersion.newBuilder()
            .setName(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setExpectedLimitationStartTime(Timestamp.newBuilder().build())
            .setExpectedDecommissionTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    EngineVersionName name =
        EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]");

    EngineVersion actualResponse = client.getEngineVersion(name);
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
  public void getEngineVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineVersionName name =
          EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]");
      client.getEngineVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineVersionTest2() throws Exception {
    EngineVersion expectedResponse =
        EngineVersion.newBuilder()
            .setName(
                EngineVersionName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
                    .toString())
            .setExpectedLimitationStartTime(Timestamp.newBuilder().build())
            .setExpectedDecommissionTime(Timestamp.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2109/locations/location-2109/instances/instance-2109/engineVersions/engineVersion-2109";

    EngineVersion actualResponse = client.getEngineVersion(name);
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
  public void getEngineVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2109/locations/location-2109/instances/instance-2109/engineVersions/engineVersion-2109";
      client.getEngineVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineVersionsTest() throws Exception {
    EngineVersion responsesElement = EngineVersion.newBuilder().build();
    ListEngineVersionsResponse expectedResponse =
        ListEngineVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListEngineVersionsPagedResponse pagedListResponse = client.listEngineVersions(parent);

    List<EngineVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineVersionsList().get(0), resources.get(0));

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
  public void listEngineVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listEngineVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEngineVersionsTest2() throws Exception {
    EngineVersion responsesElement = EngineVersion.newBuilder().build();
    ListEngineVersionsResponse expectedResponse =
        ListEngineVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngineVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListEngineVersionsPagedResponse pagedListResponse = client.listEngineVersions(parent);

    List<EngineVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEngineVersionsList().get(0), resources.get(0));

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
  public void listEngineVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listEngineVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionResultsTest() throws Exception {
    PredictionResult responsesElement = PredictionResult.newBuilder().build();
    ListPredictionResultsResponse expectedResponse =
        ListPredictionResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListPredictionResultsPagedResponse pagedListResponse = client.listPredictionResults(parent);

    List<PredictionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPredictionResultsList().get(0), resources.get(0));

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
  public void listPredictionResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listPredictionResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionResultsTest2() throws Exception {
    PredictionResult responsesElement = PredictionResult.newBuilder().build();
    ListPredictionResultsResponse expectedResponse =
        ListPredictionResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListPredictionResultsPagedResponse pagedListResponse = client.listPredictionResults(parent);

    List<PredictionResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPredictionResultsList().get(0), resources.get(0));

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
  public void listPredictionResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listPredictionResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    PredictionResultName name =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");

    PredictionResult actualResponse = client.getPredictionResult(name);
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
  public void getPredictionResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictionResultName name =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      client.getPredictionResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPredictionResultTest2() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7417/locations/location-7417/instances/instance-7417/predictionResults/predictionResult-7417";

    PredictionResult actualResponse = client.getPredictionResult(name);
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
  public void getPredictionResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7417/locations/location-7417/instances/instance-7417/predictionResults/predictionResult-7417";
      client.getPredictionResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    PredictionResult predictionResult = PredictionResult.newBuilder().build();
    String predictionResultId = "predictionResultId62892999";

    PredictionResult actualResponse =
        client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
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
  public void createPredictionResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      PredictionResult predictionResult = PredictionResult.newBuilder().build();
      String predictionResultId = "predictionResultId62892999";
      client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPredictionResultTest2() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    PredictionResult predictionResult = PredictionResult.newBuilder().build();
    String predictionResultId = "predictionResultId62892999";

    PredictionResult actualResponse =
        client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
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
  public void createPredictionResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      PredictionResult predictionResult = PredictionResult.newBuilder().build();
      String predictionResultId = "predictionResultId62892999";
      client.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePredictionResultTest() throws Exception {
    PredictionResult expectedResponse =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PredictionResult predictionResult =
        PredictionResult.newBuilder()
            .setName(
                PredictionResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setPredictionPeriods(2013524770)
            .setOutputs(PredictionResult.Outputs.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PredictionResult actualResponse =
        client.updatePredictionResultAsync(predictionResult, updateMask).get();
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
  public void updatePredictionResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictionResult predictionResult =
          PredictionResult.newBuilder()
              .setName(
                  PredictionResultName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDataset(
                  DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
                      .toString())
              .setModel(
                  ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
              .setEndTime(Timestamp.newBuilder().build())
              .setPredictionPeriods(2013524770)
              .setOutputs(PredictionResult.Outputs.newBuilder().build())
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePredictionResultAsync(predictionResult, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportPredictionResultMetadataTest() throws Exception {
    ExportPredictionResultMetadataResponse expectedResponse =
        ExportPredictionResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportPredictionResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PredictionResultName predictionResult =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportPredictionResultMetadataResponse actualResponse =
        client
            .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
            .get();
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
  public void exportPredictionResultMetadataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictionResultName predictionResult =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client
          .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportPredictionResultMetadataTest2() throws Exception {
    ExportPredictionResultMetadataResponse expectedResponse =
        ExportPredictionResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportPredictionResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String predictionResult =
        "projects/project-3688/locations/location-3688/instances/instance-3688/predictionResults/predictionResult-3688";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportPredictionResultMetadataResponse actualResponse =
        client
            .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
            .get();
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
  public void exportPredictionResultMetadataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String predictionResult =
          "projects/project-3688/locations/location-3688/instances/instance-3688/predictionResults/predictionResult-3688";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client
          .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePredictionResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PredictionResultName name =
        PredictionResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");

    client.deletePredictionResultAsync(name).get();

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
  public void deletePredictionResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictionResultName name =
          PredictionResultName.of(
              "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
      client.deletePredictionResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePredictionResultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePredictionResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7417/locations/location-7417/instances/instance-7417/predictionResults/predictionResult-7417";

    client.deletePredictionResultAsync(name).get();

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
  public void deletePredictionResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7417/locations/location-7417/instances/instance-7417/predictionResults/predictionResult-7417";
      client.deletePredictionResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listBacktestResultsTest() throws Exception {
    BacktestResult responsesElement = BacktestResult.newBuilder().build();
    ListBacktestResultsResponse expectedResponse =
        ListBacktestResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBacktestResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListBacktestResultsPagedResponse pagedListResponse = client.listBacktestResults(parent);

    List<BacktestResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBacktestResultsList().get(0), resources.get(0));

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
  public void listBacktestResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listBacktestResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBacktestResultsTest2() throws Exception {
    BacktestResult responsesElement = BacktestResult.newBuilder().build();
    ListBacktestResultsResponse expectedResponse =
        ListBacktestResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBacktestResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListBacktestResultsPagedResponse pagedListResponse = client.listBacktestResults(parent);

    List<BacktestResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBacktestResultsList().get(0), resources.get(0));

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
  public void listBacktestResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listBacktestResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    BacktestResultName name =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");

    BacktestResult actualResponse = client.getBacktestResult(name);
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
  public void getBacktestResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BacktestResultName name =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      client.getBacktestResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBacktestResultTest2() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8995/locations/location-8995/instances/instance-8995/backtestResults/backtestResult-8995";

    BacktestResult actualResponse = client.getBacktestResult(name);
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
  public void getBacktestResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8995/locations/location-8995/instances/instance-8995/backtestResults/backtestResult-8995";
      client.getBacktestResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    BacktestResult backtestResult = BacktestResult.newBuilder().build();
    String backtestResultId = "backtestResultId-2045569231";

    BacktestResult actualResponse =
        client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
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
  public void createBacktestResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      BacktestResult backtestResult = BacktestResult.newBuilder().build();
      String backtestResultId = "backtestResultId-2045569231";
      client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createBacktestResultTest2() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    BacktestResult backtestResult = BacktestResult.newBuilder().build();
    String backtestResultId = "backtestResultId-2045569231";

    BacktestResult actualResponse =
        client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
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
  public void createBacktestResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      BacktestResult backtestResult = BacktestResult.newBuilder().build();
      String backtestResultId = "backtestResultId-2045569231";
      client.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateBacktestResultTest() throws Exception {
    BacktestResult expectedResponse =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BacktestResult backtestResult =
        BacktestResult.newBuilder()
            .setName(
                BacktestResultName.of(
                        "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDataset(
                DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString())
            .setModel(
                ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
            .setEndTime(Timestamp.newBuilder().build())
            .setBacktestPeriods(-94937460)
            .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
            .setLineOfBusiness(LineOfBusiness.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BacktestResult actualResponse =
        client.updateBacktestResultAsync(backtestResult, updateMask).get();
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
  public void updateBacktestResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BacktestResult backtestResult =
          BacktestResult.newBuilder()
              .setName(
                  BacktestResultName.of(
                          "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDataset(
                  DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
                      .toString())
              .setModel(
                  ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
              .setEndTime(Timestamp.newBuilder().build())
              .setBacktestPeriods(-94937460)
              .setPerformanceTarget(BacktestResult.PerformanceTarget.newBuilder().build())
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBacktestResultAsync(backtestResult, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportBacktestResultMetadataTest() throws Exception {
    ExportBacktestResultMetadataResponse expectedResponse =
        ExportBacktestResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBacktestResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BacktestResultName backtestResult =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportBacktestResultMetadataResponse actualResponse =
        client
            .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
            .get();
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
  public void exportBacktestResultMetadataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BacktestResultName backtestResult =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportBacktestResultMetadataTest2() throws Exception {
    ExportBacktestResultMetadataResponse expectedResponse =
        ExportBacktestResultMetadataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportBacktestResultMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String backtestResult =
        "projects/project-9112/locations/location-9112/instances/instance-9112/backtestResults/backtestResult-9112";
    BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();

    ExportBacktestResultMetadataResponse actualResponse =
        client
            .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
            .get();
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
  public void exportBacktestResultMetadataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String backtestResult =
          "projects/project-9112/locations/location-9112/instances/instance-9112/backtestResults/backtestResult-9112";
      BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
      client.exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteBacktestResultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BacktestResultName name =
        BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");

    client.deleteBacktestResultAsync(name).get();

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
  public void deleteBacktestResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BacktestResultName name =
          BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
      client.deleteBacktestResultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteBacktestResultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBacktestResultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8995/locations/location-8995/instances/instance-8995/backtestResults/backtestResult-8995";

    client.deleteBacktestResultAsync(name).get();

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
  public void deleteBacktestResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8995/locations/location-8995/instances/instance-8995/backtestResults/backtestResult-8995";
      client.deleteBacktestResultAsync(name).get();
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
