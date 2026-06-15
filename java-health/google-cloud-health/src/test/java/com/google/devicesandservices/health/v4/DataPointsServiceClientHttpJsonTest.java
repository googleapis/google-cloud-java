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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.devicesandservices.health.v4.stub.HttpJsonDataPointsServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.type.Interval;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DataPointsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataPointsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataPointsServiceStub.getMethodDescriptors(),
            DataPointsServiceSettings.getDefaultEndpoint());
    DataPointsServiceSettings settings =
        DataPointsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataPointsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataPointsServiceClient.create(settings);
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
  public void getDataPointTest() throws Exception {
    DataPoint expectedResponse =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");

    DataPoint actualResponse = client.getDataPoint(name);
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
  public void getDataPointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-9228/dataTypes/dataType-9228/dataPoints/dataPoint-9228";

    DataPoint actualResponse = client.getDataPoint(name);
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
  public void getDataPointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9228/dataTypes/dataType-9228/dataPoints/dataPoint-9228";
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
    mockService.addResponse(expectedResponse);

    DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");

    ListDataPointsPagedResponse pagedListResponse = client.listDataPoints(parent);

    List<DataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataPointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "users/user-180/dataTypes/dataType-180";

    ListDataPointsPagedResponse pagedListResponse = client.listDataPoints(parent);

    List<DataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataPointsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "users/user-180/dataTypes/dataType-180";
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
    mockService.addResponse(resultOperation);

    DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
    DataPoint dataPoint = DataPoint.newBuilder().build();

    DataPoint actualResponse = client.createDataPointAsync(parent, dataPoint).get();
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
  public void createDataPointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
      DataPoint dataPoint = DataPoint.newBuilder().build();
      client.createDataPointAsync(parent, dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "users/user-180/dataTypes/dataType-180";
    DataPoint dataPoint = DataPoint.newBuilder().build();

    DataPoint actualResponse = client.createDataPointAsync(parent, dataPoint).get();
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
  public void createDataPointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "users/user-180/dataTypes/dataType-180";
      DataPoint dataPoint = DataPoint.newBuilder().build();
      client.createDataPointAsync(parent, dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    DataPoint dataPoint =
        DataPoint.newBuilder()
            .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
            .setDataSource(DataSource.newBuilder().build())
            .build();

    DataPoint actualResponse = client.updateDataPointAsync(dataPoint).get();
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
  public void updateDataPointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataPoint dataPoint =
          DataPoint.newBuilder()
              .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
              .setDataSource(DataSource.newBuilder().build())
              .build();
      client.updateDataPointAsync(dataPoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BatchDeleteDataPointsRequest request =
        BatchDeleteDataPointsRequest.newBuilder()
            .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchDeleteDataPointsResponse actualResponse = client.batchDeleteDataPointsAsync(request).get();
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
  public void batchDeleteDataPointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchDeleteDataPointsRequest request =
          BatchDeleteDataPointsRequest.newBuilder()
              .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchDeleteDataPointsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ReconcileDataPointsRequest request =
        ReconcileDataPointsRequest.newBuilder()
            .setParent("users/user-180/dataTypes/dataType-180")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setDataSourceFamily("dataSourceFamily586548265")
            .build();

    ReconcileDataPointsPagedResponse pagedListResponse = client.reconcileDataPoints(request);

    List<ReconciledDataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataPointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void reconcileDataPointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReconcileDataPointsRequest request =
          ReconcileDataPointsRequest.newBuilder()
              .setParent("users/user-180/dataTypes/dataType-180")
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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void rollUpDataPointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void dailyRollUpDataPointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");

    ExportExerciseTcxResponse actualResponse = client.exportExerciseTcx(name);
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
  public void exportExerciseTcxExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-9228/dataTypes/dataType-9228/dataPoints/dataPoint-9228";

    ExportExerciseTcxResponse actualResponse = client.exportExerciseTcx(name);
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
  public void exportExerciseTcxExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9228/dataTypes/dataType-9228/dataPoints/dataPoint-9228";
      client.exportExerciseTcx(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
