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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ReportServiceClient.FetchReportResultRowsPagedResponse;
import static com.google.ads.admanager.v1.ReportServiceClient.ListReportsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonReportServiceStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class ReportServiceClientTest {
  private static MockHttpService mockService;
  private static ReportServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonReportServiceStub.getMethodDescriptors(),
            ReportServiceSettings.getDefaultEndpoint());
    ReportServiceSettings settings =
        ReportServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ReportServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReportServiceClient.create(settings);
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
  public void getReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");

    Report actualResponse = client.getReport(name);
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
  public void getReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
      client.getReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-6698/reports/report-6698";

    Report actualResponse = client.getReport(name);
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
  public void getReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6698/reports/report-6698";
      client.getReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

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
  public void listReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest2() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

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
  public void listReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    Report report = Report.newBuilder().build();

    Report actualResponse = client.createReport(parent, report);
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
  public void createReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      Report report = Report.newBuilder().build();
      client.createReport(parent, report);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    Report report = Report.newBuilder().build();

    Report actualResponse = client.createReport(parent, report);
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
  public void createReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      Report report = Report.newBuilder().build();
      client.createReport(parent, report);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Report report =
        Report.newBuilder()
            .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
            .setReportId(-353329146)
            .setReportDefinition(ReportDefinition.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLocale("locale-1097462182")
            .setScheduleOptions(ScheduleOptions.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Report actualResponse = client.updateReport(report, updateMask);
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
  public void updateReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Report report =
          Report.newBuilder()
              .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
              .setReportId(-353329146)
              .setReportDefinition(ReportDefinition.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setLocale("locale-1097462182")
              .setScheduleOptions(ScheduleOptions.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReport(report, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runReportTest() throws Exception {
    RunReportResponse expectedResponse =
        RunReportResponse.newBuilder().setReportResult("reportResult560943729").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");

    RunReportResponse actualResponse = client.runReportAsync(name).get();
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
      ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
      client.runReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void runReportTest2() throws Exception {
    RunReportResponse expectedResponse =
        RunReportResponse.newBuilder().setReportResult("reportResult560943729").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "networks/network-6698/reports/report-6698";

    RunReportResponse actualResponse = client.runReportAsync(name).get();
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
  public void runReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6698/reports/report-6698";
      client.runReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchReportResultRowsTest() throws Exception {
    Report.DataTable.Row responsesElement = Report.DataTable.Row.newBuilder().build();
    FetchReportResultRowsResponse expectedResponse =
        FetchReportResultRowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-7528/reports/report-7528/results/result-7528";

    FetchReportResultRowsPagedResponse pagedListResponse = client.fetchReportResultRows(name);

    List<Report.DataTable.Row> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

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
  public void fetchReportResultRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-7528/reports/report-7528/results/result-7528";
      client.fetchReportResultRows(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
