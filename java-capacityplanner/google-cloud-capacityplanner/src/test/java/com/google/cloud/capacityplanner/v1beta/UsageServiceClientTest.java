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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.type.Date;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class UsageServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUsageService mockUsageService;
  private LocalChannelProvider channelProvider;
  private UsageServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUsageService = new MockUsageService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockUsageService));
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
    UsageServiceSettings settings =
        UsageServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UsageServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void queryUsageHistoriesTest() throws Exception {
    QueryUsageHistoriesResponse expectedResponse =
        QueryUsageHistoriesResponse.newBuilder()
            .addAllUsageHistories(new ArrayList<UsageHistory>())
            .build();
    mockUsageService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryUsageHistoriesRequest actualRequest = ((QueryUsageHistoriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLocationLevel(), actualRequest.getLocationLevel());
    Assert.assertEquals(request.getIsSpot(), actualRequest.getIsSpot());
    Assert.assertEquals(request.getMachineFamily(), actualRequest.getMachineFamily());
    Assert.assertEquals(request.getMachineShape(), actualRequest.getMachineShape());
    Assert.assertEquals(request.getDiskType(), actualRequest.getDiskType());
    Assert.assertEquals(request.getConfidentialMode(), actualRequest.getConfidentialMode());
    Assert.assertEquals(request.getGpuType(), actualRequest.getGpuType());
    Assert.assertEquals(request.getTpuType(), actualRequest.getTpuType());
    Assert.assertEquals(request.getCloudResourceType(), actualRequest.getCloudResourceType());
    Assert.assertEquals(
        request.getUsageAggregationMethod(), actualRequest.getUsageAggregationMethod());
    Assert.assertEquals(request.getStartDate(), actualRequest.getStartDate());
    Assert.assertEquals(request.getEndDate(), actualRequest.getEndDate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryUsageHistoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
    mockUsageService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryForecastsRequest actualRequest = ((QueryForecastsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getMachineFamily(), actualRequest.getMachineFamily());
    Assert.assertEquals(request.getMachineShape(), actualRequest.getMachineShape());
    Assert.assertEquals(request.getDiskType(), actualRequest.getDiskType());
    Assert.assertEquals(request.getConfidentialMode(), actualRequest.getConfidentialMode());
    Assert.assertEquals(request.getGpuType(), actualRequest.getGpuType());
    Assert.assertEquals(request.getTpuType(), actualRequest.getTpuType());
    Assert.assertEquals(request.getCloudResourceType(), actualRequest.getCloudResourceType());
    Assert.assertEquals(request.getForecastType(), actualRequest.getForecastType());
    Assert.assertEquals(request.getPredictionInterval(), actualRequest.getPredictionInterval());
    Assert.assertEquals(request.getAggregationMethod(), actualRequest.getAggregationMethod());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryForecastsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
    mockUsageService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    QueryReservationsResponse actualResponse = client.queryReservations(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryReservationsRequest actualRequest = ((QueryReservationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryReservationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
    mockUsageService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    QueryReservationsResponse actualResponse = client.queryReservations(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryReservationsRequest actualRequest = ((QueryReservationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryReservationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockUsageService.addResponse(resultOperation);

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

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportUsageHistoriesRequest actualRequest =
        ((ExportUsageHistoriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getIsSpot(), actualRequest.getIsSpot());
    Assert.assertEquals(request.getMachineFamily(), actualRequest.getMachineFamily());
    Assert.assertEquals(request.getMachineShape(), actualRequest.getMachineShape());
    Assert.assertEquals(request.getDiskType(), actualRequest.getDiskType());
    Assert.assertEquals(request.getGpuType(), actualRequest.getGpuType());
    Assert.assertEquals(request.getTpuType(), actualRequest.getTpuType());
    Assert.assertEquals(request.getResourceType(), actualRequest.getResourceType());
    Assert.assertEquals(
        request.getUsageAggregationMethod(), actualRequest.getUsageAggregationMethod());
    Assert.assertEquals(request.getStartDate(), actualRequest.getStartDate());
    Assert.assertEquals(request.getEndDate(), actualRequest.getEndDate());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportUsageHistoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockUsageService.addResponse(resultOperation);

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

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportForecastsRequest actualRequest = ((ExportForecastsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getMachineFamily(), actualRequest.getMachineFamily());
    Assert.assertEquals(request.getMachineShape(), actualRequest.getMachineShape());
    Assert.assertEquals(request.getDiskType(), actualRequest.getDiskType());
    Assert.assertEquals(request.getGpuType(), actualRequest.getGpuType());
    Assert.assertEquals(request.getTpuType(), actualRequest.getTpuType());
    Assert.assertEquals(request.getResourceType(), actualRequest.getResourceType());
    Assert.assertEquals(request.getPredictionInterval(), actualRequest.getPredictionInterval());
    Assert.assertEquals(request.getAggregationMethod(), actualRequest.getAggregationMethod());
    Assert.assertEquals(request.getStartDate(), actualRequest.getStartDate());
    Assert.assertEquals(request.getEndDate(), actualRequest.getEndDate());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportForecastsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockUsageService.addResponse(resultOperation);

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

    List<AbstractMessage> actualRequests = mockUsageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportReservationsUsageRequest actualRequest =
        ((ExportReservationsUsageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getMachineFamily(), actualRequest.getMachineFamily());
    Assert.assertEquals(request.getMachineShape(), actualRequest.getMachineShape());
    Assert.assertEquals(request.getGpuType(), actualRequest.getGpuType());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLocationLevel(), actualRequest.getLocationLevel());
    Assert.assertEquals(request.getCloudResourceType(), actualRequest.getCloudResourceType());
    Assert.assertEquals(
        request.getUsageAggregationMethod(), actualRequest.getUsageAggregationMethod());
    Assert.assertEquals(request.getShareType(), actualRequest.getShareType());
    Assert.assertEquals(request.getStartDate(), actualRequest.getStartDate());
    Assert.assertEquals(request.getEndDate(), actualRequest.getEndDate());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportReservationsUsageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUsageService.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
