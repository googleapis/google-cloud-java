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

package com.google.devicesandservices.health.v4;

import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.RollUpDataPointsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.type.Interval;
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
public class DataPointsServiceClientTest {
  private static MockDataPointsService mockDataPointsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataPointsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataPointsService = new MockDataPointsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataPointsService));
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
    DataPointsServiceSettings settings =
        DataPointsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataPointsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDataPointTest() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");

    DataPoint actualResponse = client.getDataPoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataPointRequest actualRequest = ((GetDataPointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataPointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
      client.getDataPoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataPointTest2() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    String name = "name3373707";

    DataPoint actualResponse = client.getDataPoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataPointRequest actualRequest = ((GetDataPointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataPointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataPoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataPointsTest() throws Exception {
    DataPoint responsesElement = DataPoint.newBuilder().build();
    ListDataPointsResponse expectedResponse =
        ListDataPointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataPoints(Arrays.asList(responsesElement))
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");

    ListDataPointsPagedResponse pagedListResponse = client.listDataPoints(parent);

    List<DataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataPointsRequest actualRequest = ((ListDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
      client.listDataPoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataPointsTest2() throws Exception {
    DataPoint responsesElement = DataPoint.newBuilder().build();
    ListDataPointsResponse expectedResponse =
        ListDataPointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataPoints(Arrays.asList(responsesElement))
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataPointsPagedResponse pagedListResponse = client.listDataPoints(parent);

    List<DataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataPointsRequest actualRequest = ((ListDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataPointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataPoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataPointTest() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataPointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataPointsService.addResponse(resultOperation);

    DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
    DataPoint dataPoint = DataPoint.newBuilder().build();

    DataPoint actualResponse = client.createDataPointAsync(parent, dataPoint).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataPointRequest actualRequest = ((CreateDataPointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataPoint, actualRequest.getDataPoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataPointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
      DataPoint dataPoint = DataPoint.newBuilder().build();
      client.createDataPointAsync(parent, dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataPointTest2() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataPointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataPointsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataPoint dataPoint = DataPoint.newBuilder().build();

    DataPoint actualResponse = client.createDataPointAsync(parent, dataPoint).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataPointRequest actualRequest = ((CreateDataPointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataPoint, actualRequest.getDataPoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataPointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataPoint dataPoint = DataPoint.newBuilder().build();
      client.createDataPointAsync(parent, dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataPointTest() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataPointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataPointsService.addResponse(resultOperation);

    DataPoint dataPoint = DataPoint.newBuilder().build();

    DataPoint actualResponse = client.updateDataPointAsync(dataPoint).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataPointRequest actualRequest = ((UpdateDataPointRequest) actualRequests.get(0));

    Assert.assertEquals(dataPoint, actualRequest.getDataPoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataPointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DataPoint dataPoint = DataPoint.newBuilder().build();
      client.updateDataPointAsync(dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchDeleteDataPointsTest() throws Exception {
    BatchDeleteDataPointsResponse expectedResponse =
        BatchDeleteDataPointsResponse.newBuilder()
            .addAllDataPoints(new ArrayList<DataPoint>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteDataPointsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataPointsService.addResponse(resultOperation);

    BatchDeleteDataPointsRequest request =
        BatchDeleteDataPointsRequest.newBuilder()
            .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchDeleteDataPointsResponse actualResponse = client.batchDeleteDataPointsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteDataPointsRequest actualRequest =
        ((BatchDeleteDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteDataPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      BatchDeleteDataPointsRequest request =
          BatchDeleteDataPointsRequest.newBuilder()
              .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchDeleteDataPointsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reconcileDataPointsTest() throws Exception {
    ReconciledDataPoint responsesElement = ReconciledDataPoint.newBuilder().build();
    ReconcileDataPointsResponse expectedResponse =
        ReconcileDataPointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataPoints(Arrays.asList(responsesElement))
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    ReconcileDataPointsRequest request =
        ReconcileDataPointsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setDataSourceFamily("dataSourceFamily586548265")
            .build();

    ReconcileDataPointsPagedResponse pagedListResponse = client.reconcileDataPoints(request);

    List<ReconciledDataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReconcileDataPointsRequest actualRequest = ((ReconcileDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getDataSourceFamily(), actualRequest.getDataSourceFamily());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reconcileDataPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      ReconcileDataPointsRequest request =
          ReconcileDataPointsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setDataSourceFamily("dataSourceFamily586548265")
              .build();
      client.reconcileDataPoints(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollUpDataPointsTest() throws Exception {
    RollupDataPoint responsesElement = RollupDataPoint.newBuilder().build();
    RollUpDataPointsResponse expectedResponse =
        RollUpDataPointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollupDataPoints(Arrays.asList(responsesElement))
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    RollUpDataPointsRequest request =
        RollUpDataPointsRequest.newBuilder()
            .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
            .setRange(Interval.newBuilder().build())
            .setWindowSize(Duration.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setDataSourceFamily("dataSourceFamily586548265")
            .build();

    RollUpDataPointsPagedResponse pagedListResponse = client.rollUpDataPoints(request);

    List<RollupDataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRollupDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollUpDataPointsRequest actualRequest = ((RollUpDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRange(), actualRequest.getRange());
    Assert.assertEquals(request.getWindowSize(), actualRequest.getWindowSize());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getDataSourceFamily(), actualRequest.getDataSourceFamily());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollUpDataPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      RollUpDataPointsRequest request =
          RollUpDataPointsRequest.newBuilder()
              .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
              .setRange(Interval.newBuilder().build())
              .setWindowSize(Duration.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setDataSourceFamily("dataSourceFamily586548265")
              .build();
      client.rollUpDataPoints(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void dailyRollUpDataPointsTest() throws Exception {
    DailyRollUpDataPointsResponse expectedResponse =
        DailyRollUpDataPointsResponse.newBuilder()
            .addAllRollupDataPoints(new ArrayList<DailyRollupDataPoint>())
            .build();
    mockDataPointsService.addResponse(expectedResponse);

    DailyRollUpDataPointsRequest request =
        DailyRollUpDataPointsRequest.newBuilder()
            .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
            .setRange(CivilTimeInterval.newBuilder().build())
            .setWindowSizeDays(1064520774)
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setDataSourceFamily("dataSourceFamily586548265")
            .build();

    DailyRollUpDataPointsResponse actualResponse = client.dailyRollUpDataPoints(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DailyRollUpDataPointsRequest actualRequest =
        ((DailyRollUpDataPointsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRange(), actualRequest.getRange());
    Assert.assertEquals(request.getWindowSizeDays(), actualRequest.getWindowSizeDays());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getDataSourceFamily(), actualRequest.getDataSourceFamily());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void dailyRollUpDataPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DailyRollUpDataPointsRequest request =
          DailyRollUpDataPointsRequest.newBuilder()
              .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
              .setRange(CivilTimeInterval.newBuilder().build())
              .setWindowSizeDays(1064520774)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setDataSourceFamily("dataSourceFamily586548265")
              .build();
      client.dailyRollUpDataPoints(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportExerciseTcxTest() throws Exception {
    ExportExerciseTcxResponse expectedResponse =
        ExportExerciseTcxResponse.newBuilder().setTcxData("tcxData-1476524237").build();
    mockDataPointsService.addResponse(expectedResponse);

    DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");

    ExportExerciseTcxResponse actualResponse = client.exportExerciseTcx(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportExerciseTcxRequest actualRequest = ((ExportExerciseTcxRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportExerciseTcxExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
      client.exportExerciseTcx(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportExerciseTcxTest2() throws Exception {
    ExportExerciseTcxResponse expectedResponse =
        ExportExerciseTcxResponse.newBuilder().setTcxData("tcxData-1476524237").build();
    mockDataPointsService.addResponse(expectedResponse);

    String name = "name3373707";

    ExportExerciseTcxResponse actualResponse = client.exportExerciseTcx(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataPointsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportExerciseTcxRequest actualRequest = ((ExportExerciseTcxRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportExerciseTcxExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataPointsService.addException(exception);

    try {
      String name = "name3373707";
      client.exportExerciseTcx(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
