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

package com.google.cloud.websecurityscanner.v1;

import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanRunsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.websecurityscanner.v1.stub.HttpJsonWebSecurityScannerStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class WebSecurityScannerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WebSecurityScannerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWebSecurityScannerStub.getMethodDescriptors(),
            WebSecurityScannerSettings.getDefaultEndpoint());
    WebSecurityScannerSettings settings =
        WebSecurityScannerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WebSecurityScannerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebSecurityScannerClient.create(settings);
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
  public void createScanConfigTest() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .setManagedScan(true)
            .setStaticIpScan(true)
            .build();
    mockService.addResponse(expectedResponse);

    CreateScanConfigRequest request =
        CreateScanConfigRequest.newBuilder()
            .setParent("projects/project-2353")
            .setScanConfig(ScanConfig.newBuilder().build())
            .build();

    ScanConfig actualResponse = client.createScanConfig(request);
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
  public void createScanConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateScanConfigRequest request =
          CreateScanConfigRequest.newBuilder()
              .setParent("projects/project-2353")
              .setScanConfig(ScanConfig.newBuilder().build())
              .build();
      client.createScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScanConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteScanConfigRequest request =
        DeleteScanConfigRequest.newBuilder()
            .setName("projects/project-7376/scanConfigs/scanConfig-7376")
            .build();

    client.deleteScanConfig(request);

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
  public void deleteScanConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteScanConfigRequest request =
          DeleteScanConfigRequest.newBuilder()
              .setName("projects/project-7376/scanConfigs/scanConfig-7376")
              .build();
      client.deleteScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanConfigTest() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .setManagedScan(true)
            .setStaticIpScan(true)
            .build();
    mockService.addResponse(expectedResponse);

    GetScanConfigRequest request =
        GetScanConfigRequest.newBuilder()
            .setName("projects/project-7376/scanConfigs/scanConfig-7376")
            .build();

    ScanConfig actualResponse = client.getScanConfig(request);
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
  public void getScanConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetScanConfigRequest request =
          GetScanConfigRequest.newBuilder()
              .setName("projects/project-7376/scanConfigs/scanConfig-7376")
              .build();
      client.getScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScanConfigsTest() throws Exception {
    ScanConfig responsesElement = ScanConfig.newBuilder().build();
    ListScanConfigsResponse expectedResponse =
        ListScanConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScanConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListScanConfigsRequest request =
        ListScanConfigsRequest.newBuilder()
            .setParent("projects/project-2353")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(request);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

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
  public void listScanConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListScanConfigsRequest request =
          ListScanConfigsRequest.newBuilder()
              .setParent("projects/project-2353")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listScanConfigs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateScanConfigTest() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .setManagedScan(true)
            .setStaticIpScan(true)
            .build();
    mockService.addResponse(expectedResponse);

    UpdateScanConfigRequest request =
        UpdateScanConfigRequest.newBuilder()
            .setScanConfig(
                ScanConfig.newBuilder()
                    .setName("projects/project-7376/scanConfigs/scanConfig-7376")
                    .setDisplayName("displayName1714148973")
                    .setMaxQps(844445913)
                    .addAllStartingUrls(new ArrayList<String>())
                    .setAuthentication(ScanConfig.Authentication.newBuilder().build())
                    .addAllBlacklistPatterns(new ArrayList<String>())
                    .setSchedule(ScanConfig.Schedule.newBuilder().build())
                    .setManagedScan(true)
                    .setStaticIpScan(true)
                    .build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    ScanConfig actualResponse = client.updateScanConfig(request);
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
  public void updateScanConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateScanConfigRequest request =
          UpdateScanConfigRequest.newBuilder()
              .setScanConfig(
                  ScanConfig.newBuilder()
                      .setName("projects/project-7376/scanConfigs/scanConfig-7376")
                      .setDisplayName("displayName1714148973")
                      .setMaxQps(844445913)
                      .addAllStartingUrls(new ArrayList<String>())
                      .setAuthentication(ScanConfig.Authentication.newBuilder().build())
                      .addAllBlacklistPatterns(new ArrayList<String>())
                      .setSchedule(ScanConfig.Schedule.newBuilder().build())
                      .setManagedScan(true)
                      .setStaticIpScan(true)
                      .build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName("name3373707")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUrlsCrawledCount(-1749797253)
            .setUrlsTestedCount(-1498664068)
            .setHasVulnerabilities(true)
            .setProgressPercent(-2137894861)
            .setErrorTrace(ScanRunErrorTrace.newBuilder().build())
            .addAllWarningTraces(new ArrayList<ScanRunWarningTrace>())
            .build();
    mockService.addResponse(expectedResponse);

    StartScanRunRequest request =
        StartScanRunRequest.newBuilder()
            .setName("projects/project-7376/scanConfigs/scanConfig-7376")
            .build();

    ScanRun actualResponse = client.startScanRun(request);
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
  public void startScanRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StartScanRunRequest request =
          StartScanRunRequest.newBuilder()
              .setName("projects/project-7376/scanConfigs/scanConfig-7376")
              .build();
      client.startScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName("name3373707")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUrlsCrawledCount(-1749797253)
            .setUrlsTestedCount(-1498664068)
            .setHasVulnerabilities(true)
            .setProgressPercent(-2137894861)
            .setErrorTrace(ScanRunErrorTrace.newBuilder().build())
            .addAllWarningTraces(new ArrayList<ScanRunWarningTrace>())
            .build();
    mockService.addResponse(expectedResponse);

    GetScanRunRequest request =
        GetScanRunRequest.newBuilder()
            .setName("projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135")
            .build();

    ScanRun actualResponse = client.getScanRun(request);
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
  public void getScanRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetScanRunRequest request =
          GetScanRunRequest.newBuilder()
              .setName("projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135")
              .build();
      client.getScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScanRunsTest() throws Exception {
    ScanRun responsesElement = ScanRun.newBuilder().build();
    ListScanRunsResponse expectedResponse =
        ListScanRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScanRuns(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListScanRunsRequest request =
        ListScanRunsRequest.newBuilder()
            .setParent("projects/project-2657/scanConfigs/scanConfig-2657")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(request);

    List<ScanRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanRunsList().get(0), resources.get(0));

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
  public void listScanRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListScanRunsRequest request =
          ListScanRunsRequest.newBuilder()
              .setParent("projects/project-2657/scanConfigs/scanConfig-2657")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listScanRuns(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName("name3373707")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUrlsCrawledCount(-1749797253)
            .setUrlsTestedCount(-1498664068)
            .setHasVulnerabilities(true)
            .setProgressPercent(-2137894861)
            .setErrorTrace(ScanRunErrorTrace.newBuilder().build())
            .addAllWarningTraces(new ArrayList<ScanRunWarningTrace>())
            .build();
    mockService.addResponse(expectedResponse);

    StopScanRunRequest request =
        StopScanRunRequest.newBuilder()
            .setName("projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135")
            .build();

    ScanRun actualResponse = client.stopScanRun(request);
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
  public void stopScanRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StopScanRunRequest request =
          StopScanRunRequest.newBuilder()
              .setName("projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135")
              .build();
      client.stopScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCrawledUrlsTest() throws Exception {
    CrawledUrl responsesElement = CrawledUrl.newBuilder().build();
    ListCrawledUrlsResponse expectedResponse =
        ListCrawledUrlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCrawledUrls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListCrawledUrlsRequest request =
        ListCrawledUrlsRequest.newBuilder()
            .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(request);

    List<CrawledUrl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCrawledUrlsList().get(0), resources.get(0));

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
  public void listCrawledUrlsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListCrawledUrlsRequest request =
          ListCrawledUrlsRequest.newBuilder()
              .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listCrawledUrls(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName("name3373707")
            .setFindingType("findingType1116910179")
            .setHttpMethod("httpMethod751124361")
            .setFuzzedUrl("fuzzedUrl-1730986655")
            .setBody("body3029410")
            .setDescription("description-1724546052")
            .setReproductionUrl("reproductionUrl-2086120797")
            .setFrameUrl("frameUrl-1644982078")
            .setFinalUrl("finalUrl-681275367")
            .setTrackingId("trackingId1168987698")
            .setForm(Form.newBuilder().build())
            .setOutdatedLibrary(OutdatedLibrary.newBuilder().build())
            .setViolatingResource(ViolatingResource.newBuilder().build())
            .setVulnerableHeaders(VulnerableHeaders.newBuilder().build())
            .setVulnerableParameters(VulnerableParameters.newBuilder().build())
            .setXss(Xss.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetFindingRequest request =
        GetFindingRequest.newBuilder()
            .setName(
                "projects/project-9877/scanConfigs/scanConfig-9877/scanRuns/scanRun-9877/findings/finding-9877")
            .build();

    Finding actualResponse = client.getFinding(request);
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
  public void getFindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetFindingRequest request =
          GetFindingRequest.newBuilder()
              .setName(
                  "projects/project-9877/scanConfigs/scanConfig-9877/scanRuns/scanRun-9877/findings/finding-9877")
              .build();
      client.getFinding(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest() throws Exception {
    Finding responsesElement = Finding.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
            .setFilter("filter-1274492040")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListFindingsPagedResponse pagedListResponse = client.listFindings(request);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

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
  public void listFindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListFindingsRequest request =
          ListFindingsRequest.newBuilder()
              .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
              .setFilter("filter-1274492040")
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listFindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingTypeStatsTest() throws Exception {
    ListFindingTypeStatsResponse expectedResponse =
        ListFindingTypeStatsResponse.newBuilder()
            .addAllFindingTypeStats(new ArrayList<FindingTypeStats>())
            .build();
    mockService.addResponse(expectedResponse);

    ListFindingTypeStatsRequest request =
        ListFindingTypeStatsRequest.newBuilder()
            .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
            .build();

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(request);
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
  public void listFindingTypeStatsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListFindingTypeStatsRequest request =
          ListFindingTypeStatsRequest.newBuilder()
              .setParent("projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104")
              .build();
      client.listFindingTypeStats(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
