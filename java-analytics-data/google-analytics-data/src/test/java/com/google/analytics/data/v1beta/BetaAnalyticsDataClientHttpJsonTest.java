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

package com.google.analytics.data.v1beta;

import com.google.analytics.data.v1beta.stub.HttpJsonBetaAnalyticsDataStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BetaAnalyticsDataClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BetaAnalyticsDataClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBetaAnalyticsDataStub.getMethodDescriptors(),
            BetaAnalyticsDataSettings.getDefaultEndpoint());
    BetaAnalyticsDataSettings settings =
        BetaAnalyticsDataSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BetaAnalyticsDataSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BetaAnalyticsDataClient.create(settings);
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
  public void runReportTest() throws Exception {
    RunReportResponse expectedResponse =
        RunReportResponse.newBuilder()
            .addAllDimensionHeaders(new ArrayList<DimensionHeader>())
            .addAllMetricHeaders(new ArrayList<MetricHeader>())
            .addAllRows(new ArrayList<Row>())
            .addAllTotals(new ArrayList<Row>())
            .addAllMaximums(new ArrayList<Row>())
            .addAllMinimums(new ArrayList<Row>())
            .setRowCount(1340416618)
            .setMetadata(ResponseMetaData.newBuilder().build())
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    RunReportRequest request =
        RunReportRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllDimensions(new ArrayList<Dimension>())
            .addAllMetrics(new ArrayList<Metric>())
            .addAllDateRanges(new ArrayList<DateRange>())
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setMetricFilter(FilterExpression.newBuilder().build())
            .setOffset(-1019779949)
            .setLimit(102976443)
            .addAllMetricAggregations(new ArrayList<MetricAggregation>())
            .addAllOrderBys(new ArrayList<OrderBy>())
            .setCurrencyCode("currencyCode1004773790")
            .setCohortSpec(CohortSpec.newBuilder().build())
            .setKeepEmptyRows(true)
            .setReturnPropertyQuota(true)
            .build();

    RunReportResponse actualResponse = client.runReport(request);
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
  public void runReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .addAllDateRanges(new ArrayList<DateRange>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setOffset(-1019779949)
              .setLimit(102976443)
              .addAllMetricAggregations(new ArrayList<MetricAggregation>())
              .addAllOrderBys(new ArrayList<OrderBy>())
              .setCurrencyCode("currencyCode1004773790")
              .setCohortSpec(CohortSpec.newBuilder().build())
              .setKeepEmptyRows(true)
              .setReturnPropertyQuota(true)
              .build();
      client.runReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runPivotReportTest() throws Exception {
    RunPivotReportResponse expectedResponse =
        RunPivotReportResponse.newBuilder()
            .addAllPivotHeaders(new ArrayList<PivotHeader>())
            .addAllDimensionHeaders(new ArrayList<DimensionHeader>())
            .addAllMetricHeaders(new ArrayList<MetricHeader>())
            .addAllRows(new ArrayList<Row>())
            .addAllAggregates(new ArrayList<Row>())
            .setMetadata(ResponseMetaData.newBuilder().build())
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    RunPivotReportRequest request =
        RunPivotReportRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllDimensions(new ArrayList<Dimension>())
            .addAllMetrics(new ArrayList<Metric>())
            .addAllDateRanges(new ArrayList<DateRange>())
            .addAllPivots(new ArrayList<Pivot>())
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setMetricFilter(FilterExpression.newBuilder().build())
            .setCurrencyCode("currencyCode1004773790")
            .setCohortSpec(CohortSpec.newBuilder().build())
            .setKeepEmptyRows(true)
            .setReturnPropertyQuota(true)
            .build();

    RunPivotReportResponse actualResponse = client.runPivotReport(request);
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
  public void runPivotReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunPivotReportRequest request =
          RunPivotReportRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .addAllDateRanges(new ArrayList<DateRange>())
              .addAllPivots(new ArrayList<Pivot>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setCurrencyCode("currencyCode1004773790")
              .setCohortSpec(CohortSpec.newBuilder().build())
              .setKeepEmptyRows(true)
              .setReturnPropertyQuota(true)
              .build();
      client.runPivotReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRunReportsTest() throws Exception {
    BatchRunReportsResponse expectedResponse =
        BatchRunReportsResponse.newBuilder()
            .addAllReports(new ArrayList<RunReportResponse>())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    BatchRunReportsRequest request =
        BatchRunReportsRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllRequests(new ArrayList<RunReportRequest>())
            .build();

    BatchRunReportsResponse actualResponse = client.batchRunReports(request);
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
  public void batchRunReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchRunReportsRequest request =
          BatchRunReportsRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllRequests(new ArrayList<RunReportRequest>())
              .build();
      client.batchRunReports(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRunPivotReportsTest() throws Exception {
    BatchRunPivotReportsResponse expectedResponse =
        BatchRunPivotReportsResponse.newBuilder()
            .addAllPivotReports(new ArrayList<RunPivotReportResponse>())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    BatchRunPivotReportsRequest request =
        BatchRunPivotReportsRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllRequests(new ArrayList<RunPivotReportRequest>())
            .build();

    BatchRunPivotReportsResponse actualResponse = client.batchRunPivotReports(request);
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
  public void batchRunPivotReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchRunPivotReportsRequest request =
          BatchRunPivotReportsRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllRequests(new ArrayList<RunPivotReportRequest>())
              .build();
      client.batchRunPivotReports(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataTest() throws Exception {
    Metadata expectedResponse =
        Metadata.newBuilder()
            .setName(MetadataName.of("[PROPERTY]").toString())
            .addAllDimensions(new ArrayList<DimensionMetadata>())
            .addAllMetrics(new ArrayList<MetricMetadata>())
            .build();
    mockService.addResponse(expectedResponse);

    MetadataName name = MetadataName.of("[PROPERTY]");

    Metadata actualResponse = client.getMetadata(name);
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
  public void getMetadataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MetadataName name = MetadataName.of("[PROPERTY]");
      client.getMetadata(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataTest2() throws Exception {
    Metadata expectedResponse =
        Metadata.newBuilder()
            .setName(MetadataName.of("[PROPERTY]").toString())
            .addAllDimensions(new ArrayList<DimensionMetadata>())
            .addAllMetrics(new ArrayList<MetricMetadata>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "properties/propertie-8635/metadata";

    Metadata actualResponse = client.getMetadata(name);
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
  public void getMetadataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "properties/propertie-8635/metadata";
      client.getMetadata(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runRealtimeReportTest() throws Exception {
    RunRealtimeReportResponse expectedResponse =
        RunRealtimeReportResponse.newBuilder()
            .addAllDimensionHeaders(new ArrayList<DimensionHeader>())
            .addAllMetricHeaders(new ArrayList<MetricHeader>())
            .addAllRows(new ArrayList<Row>())
            .addAllTotals(new ArrayList<Row>())
            .addAllMaximums(new ArrayList<Row>())
            .addAllMinimums(new ArrayList<Row>())
            .setRowCount(1340416618)
            .setPropertyQuota(PropertyQuota.newBuilder().build())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    RunRealtimeReportRequest request =
        RunRealtimeReportRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllDimensions(new ArrayList<Dimension>())
            .addAllMetrics(new ArrayList<Metric>())
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setMetricFilter(FilterExpression.newBuilder().build())
            .setLimit(102976443)
            .addAllMetricAggregations(new ArrayList<MetricAggregation>())
            .addAllOrderBys(new ArrayList<OrderBy>())
            .setReturnPropertyQuota(true)
            .addAllMinuteRanges(new ArrayList<MinuteRange>())
            .build();

    RunRealtimeReportResponse actualResponse = client.runRealtimeReport(request);
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
  public void runRealtimeReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunRealtimeReportRequest request =
          RunRealtimeReportRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setLimit(102976443)
              .addAllMetricAggregations(new ArrayList<MetricAggregation>())
              .addAllOrderBys(new ArrayList<OrderBy>())
              .setReturnPropertyQuota(true)
              .addAllMinuteRanges(new ArrayList<MinuteRange>())
              .build();
      client.runRealtimeReport(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkCompatibilityTest() throws Exception {
    CheckCompatibilityResponse expectedResponse =
        CheckCompatibilityResponse.newBuilder()
            .addAllDimensionCompatibilities(new ArrayList<DimensionCompatibility>())
            .addAllMetricCompatibilities(new ArrayList<MetricCompatibility>())
            .build();
    mockService.addResponse(expectedResponse);

    CheckCompatibilityRequest request =
        CheckCompatibilityRequest.newBuilder()
            .setProperty("properties/propertie-2179")
            .addAllDimensions(new ArrayList<Dimension>())
            .addAllMetrics(new ArrayList<Metric>())
            .setDimensionFilter(FilterExpression.newBuilder().build())
            .setMetricFilter(FilterExpression.newBuilder().build())
            .setCompatibilityFilter(Compatibility.forNumber(0))
            .build();

    CheckCompatibilityResponse actualResponse = client.checkCompatibility(request);
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
  public void checkCompatibilityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckCompatibilityRequest request =
          CheckCompatibilityRequest.newBuilder()
              .setProperty("properties/propertie-2179")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setCompatibilityFilter(Compatibility.forNumber(0))
              .build();
      client.checkCompatibility(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
