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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataplex.v1.stub.HttpJsonDataScanServiceStub;
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
public class DataScanServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataScanServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataScanServiceStub.getMethodDescriptors(),
            DataScanServiceSettings.getDefaultEndpoint());
    DataScanServiceSettings settings =
        DataScanServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataScanServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataScanServiceClient.create(settings);
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
  public void createDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataScan dataScan = DataScan.newBuilder().build();
    String dataScanId = "dataScanId1260787906";

    DataScan actualResponse = client.createDataScanAsync(parent, dataScan, dataScanId).get();
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
  public void createDataScanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataScan dataScan = DataScan.newBuilder().build();
      String dataScanId = "dataScanId1260787906";
      client.createDataScanAsync(parent, dataScan, dataScanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataScanTest2() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    DataScan dataScan = DataScan.newBuilder().build();
    String dataScanId = "dataScanId1260787906";

    DataScan actualResponse = client.createDataScanAsync(parent, dataScan, dataScanId).get();
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
  public void createDataScanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DataScan dataScan = DataScan.newBuilder().build();
      String dataScanId = "dataScanId1260787906";
      client.createDataScanAsync(parent, dataScan, dataScanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataScan dataScan =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataScan actualResponse = client.updateDataScanAsync(dataScan, updateMask).get();
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
  public void updateDataScanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScan dataScan =
          DataScan.newBuilder()
              .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
              .setUid("uid115792")
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setState(State.forNumber(0))
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setData(DataSource.newBuilder().build())
              .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
              .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
              .setType(DataScanType.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataScanAsync(dataScan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataScanTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    client.deleteDataScanAsync(name).get();

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
  public void deleteDataScanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.deleteDataScanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataScanTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataScanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";

    client.deleteDataScanAsync(name).get();

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
  public void deleteDataScanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";
      client.deleteDataScanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getDataScanTest() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    DataScan actualResponse = client.getDataScan(name);
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
  public void getDataScanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.getDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanTest2() throws Exception {
    DataScan expectedResponse =
        DataScan.newBuilder()
            .setName(DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]").toString())
            .setUid("uid115792")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setState(State.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(DataSource.newBuilder().build())
            .setExecutionSpec(DataScan.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(DataScan.ExecutionStatus.newBuilder().build())
            .setType(DataScanType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";

    DataScan actualResponse = client.getDataScan(name);
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
  public void getDataScanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";
      client.getDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScansTest() throws Exception {
    DataScan responsesElement = DataScan.newBuilder().build();
    ListDataScansResponse expectedResponse =
        ListDataScansResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScans(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataScansPagedResponse pagedListResponse = client.listDataScans(parent);

    List<DataScan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScansList().get(0), resources.get(0));

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
  public void listDataScansExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataScans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScansTest2() throws Exception {
    DataScan responsesElement = DataScan.newBuilder().build();
    ListDataScansResponse expectedResponse =
        ListDataScansResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScans(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDataScansPagedResponse pagedListResponse = client.listDataScans(parent);

    List<DataScan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScansList().get(0), resources.get(0));

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
  public void listDataScansExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDataScans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runDataScanTest() throws Exception {
    RunDataScanResponse expectedResponse =
        RunDataScanResponse.newBuilder().setJob(DataScanJob.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    RunDataScanResponse actualResponse = client.runDataScan(name);
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
  public void runDataScanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScanName name = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.runDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runDataScanTest2() throws Exception {
    RunDataScanResponse expectedResponse =
        RunDataScanResponse.newBuilder().setJob(DataScanJob.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";

    RunDataScanResponse actualResponse = client.runDataScan(name);
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
  public void runDataScanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1806/locations/location-1806/dataScans/dataScan-1806";
      client.runDataScan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanJobTest() throws Exception {
    DataScanJob expectedResponse =
        DataScanJob.newBuilder()
            .setName(
                DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setMessage("message954925063")
            .setType(DataScanType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    DataScanJobName name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]");

    DataScanJob actualResponse = client.getDataScanJob(name);
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
  public void getDataScanJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScanJobName name = DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]");
      client.getDataScanJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataScanJobTest2() throws Exception {
    DataScanJob expectedResponse =
        DataScanJob.newBuilder()
            .setName(
                DataScanJobName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setMessage("message954925063")
            .setType(DataScanType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7138/locations/location-7138/dataScans/dataScan-7138/jobs/job-7138";

    DataScanJob actualResponse = client.getDataScanJob(name);
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
  public void getDataScanJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7138/locations/location-7138/dataScans/dataScan-7138/jobs/job-7138";
      client.getDataScanJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScanJobsTest() throws Exception {
    DataScanJob responsesElement = DataScanJob.newBuilder().build();
    ListDataScanJobsResponse expectedResponse =
        ListDataScanJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScanJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataScanName parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");

    ListDataScanJobsPagedResponse pagedListResponse = client.listDataScanJobs(parent);

    List<DataScanJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScanJobsList().get(0), resources.get(0));

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
  public void listDataScanJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataScanName parent = DataScanName.of("[PROJECT]", "[LOCATION]", "[DATASCAN]");
      client.listDataScanJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataScanJobsTest2() throws Exception {
    DataScanJob responsesElement = DataScanJob.newBuilder().build();
    ListDataScanJobsResponse expectedResponse =
        ListDataScanJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataScanJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-881/locations/location-881/dataScans/dataScan-881";

    ListDataScanJobsPagedResponse pagedListResponse = client.listDataScanJobs(parent);

    List<DataScanJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataScanJobsList().get(0), resources.get(0));

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
  public void listDataScanJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-881/locations/location-881/dataScans/dataScan-881";
      client.listDataScanJobs(parent);
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
