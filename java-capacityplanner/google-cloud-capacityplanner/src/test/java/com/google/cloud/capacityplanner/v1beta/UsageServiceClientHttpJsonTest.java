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

package com.google.cloud.capacityplanner.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.capacityplanner.v1beta.stub.HttpJsonUsageServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.type.Date;
import java.io.IOException;
import java.util.ArrayList;
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
public class UsageServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UsageServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUsageServiceStub.getMethodDescriptors(),
            UsageServiceSettings.getDefaultEndpoint());
    UsageServiceSettings settings =
        UsageServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UsageServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UsageServiceClient.create(settings);
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
  public void queryUsageHistoriesTest() throws Exception {
    QueryUsageHistoriesResponse expectedResponse =
        QueryUsageHistoriesResponse.newBuilder()
            .addAllUsageHistories(new ArrayList<UsageHistory>())
            .build();
    mockService.addResponse(expectedResponse);

    QueryUsageHistoriesRequest request =
        QueryUsageHistoriesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setIsSpot(true)
            .setMachineFamily("machineFamily419822219")
            .setMachineShape(MachineShape.newBuilder().build())
            .setDiskType("diskType279771767")
            .setConfidentialMode(true)
            .setGpuType("gpuType240737798")
            .setTpuType("tpuType-1106616237")
            .setCloudResourceType("cloudResourceType-1446274243")
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .build();

    QueryUsageHistoriesResponse actualResponse = client.queryUsageHistories(request);
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
  public void queryUsageHistoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QueryUsageHistoriesRequest request =
          QueryUsageHistoriesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setIsSpot(true)
              .setMachineFamily("machineFamily419822219")
              .setMachineShape(MachineShape.newBuilder().build())
              .setDiskType("diskType279771767")
              .setConfidentialMode(true)
              .setGpuType("gpuType240737798")
              .setTpuType("tpuType-1106616237")
              .setCloudResourceType("cloudResourceType-1446274243")
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .build();
      client.queryUsageHistories(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryForecastsTest() throws Exception {
    QueryForecastsResponse expectedResponse =
        QueryForecastsResponse.newBuilder().addAllForecasts(new ArrayList<Forecast>()).build();
    mockService.addResponse(expectedResponse);

    QueryForecastsRequest request =
        QueryForecastsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setMachineFamily("machineFamily419822219")
            .setMachineShape(MachineShape.newBuilder().build())
            .setDiskType("diskType279771767")
            .setConfidentialMode(true)
            .setGpuType("gpuType240737798")
            .setTpuType("tpuType-1106616237")
            .setCloudResourceType("cloudResourceType-1446274243")
            .build();

    QueryForecastsResponse actualResponse = client.queryForecasts(request);
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
  public void queryForecastsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QueryForecastsRequest request =
          QueryForecastsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setMachineFamily("machineFamily419822219")
              .setMachineShape(MachineShape.newBuilder().build())
              .setDiskType("diskType279771767")
              .setConfidentialMode(true)
              .setGpuType("gpuType240737798")
              .setTpuType("tpuType-1106616237")
              .setCloudResourceType("cloudResourceType-1446274243")
              .build();
      client.queryForecasts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryReservationsTest() throws Exception {
    QueryReservationsResponse expectedResponse =
        QueryReservationsResponse.newBuilder()
            .addAllReservations(new ArrayList<ReservationData>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    QueryReservationsResponse actualResponse = client.queryReservations(parent);
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
  public void queryReservationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.queryReservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryReservationsTest2() throws Exception {
    QueryReservationsResponse expectedResponse =
        QueryReservationsResponse.newBuilder()
            .addAllReservations(new ArrayList<ReservationData>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    QueryReservationsResponse actualResponse = client.queryReservations(parent);
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
  public void queryReservationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.queryReservations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportUsageHistoriesTest() throws Exception {
    ExportUsageHistoriesResponse expectedResponse =
        ExportUsageHistoriesResponse.newBuilder().setResponse("response-340323263").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportUsageHistoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportUsageHistoriesRequest request =
        ExportUsageHistoriesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setIsSpot(true)
            .setMachineFamily("machineFamily419822219")
            .setMachineShape(MachineShape.newBuilder().build())
            .setDiskType("diskType279771767")
            .setGpuType("gpuType240737798")
            .setTpuType("tpuType-1106616237")
            .setResourceType("resourceType-384364440")
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();

    ExportUsageHistoriesResponse actualResponse = client.exportUsageHistoriesAsync(request).get();
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
  public void exportUsageHistoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportUsageHistoriesRequest request =
          ExportUsageHistoriesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setIsSpot(true)
              .setMachineFamily("machineFamily419822219")
              .setMachineShape(MachineShape.newBuilder().build())
              .setDiskType("diskType279771767")
              .setGpuType("gpuType240737798")
              .setTpuType("tpuType-1106616237")
              .setResourceType("resourceType-384364440")
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .build();
      client.exportUsageHistoriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportForecastsTest() throws Exception {
    ExportForecastsResponse expectedResponse =
        ExportForecastsResponse.newBuilder().setResponse("response-340323263").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportForecastsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportForecastsRequest request =
        ExportForecastsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setMachineFamily("machineFamily419822219")
            .setMachineShape(MachineShape.newBuilder().build())
            .setDiskType("diskType279771767")
            .setGpuType("gpuType240737798")
            .setTpuType("tpuType-1106616237")
            .setResourceType("resourceType-384364440")
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();

    ExportForecastsResponse actualResponse = client.exportForecastsAsync(request).get();
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
  public void exportForecastsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportForecastsRequest request =
          ExportForecastsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setMachineFamily("machineFamily419822219")
              .setMachineShape(MachineShape.newBuilder().build())
              .setDiskType("diskType279771767")
              .setGpuType("gpuType240737798")
              .setTpuType("tpuType-1106616237")
              .setResourceType("resourceType-384364440")
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .build();
      client.exportForecastsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportReservationsUsageTest() throws Exception {
    ExportReservationsUsageResponse expectedResponse =
        ExportReservationsUsageResponse.newBuilder().setResponse("response-340323263").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportReservationsUsageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportReservationsUsageRequest request =
        ExportReservationsUsageRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setCloudResourceType("cloudResourceType-1446274243")
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();

    ExportReservationsUsageResponse actualResponse =
        client.exportReservationsUsageAsync(request).get();
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
  public void exportReservationsUsageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportReservationsUsageRequest request =
          ExportReservationsUsageRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setCloudResourceType("cloudResourceType-1446274243")
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .build();
      client.exportReservationsUsageAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
