/*
 * Copyright 2020 Google LLC
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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class WebSecurityScannerClientTest {
  private static MockWebSecurityScanner mockWebSecurityScanner;
  private static MockServiceHelper mockServiceHelper;
  private WebSecurityScannerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebSecurityScanner = new MockWebSecurityScanner();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockWebSecurityScanner));
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
    WebSecurityScannerSettings settings =
        WebSecurityScannerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WebSecurityScannerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    CreateScanConfigRequest request =
        CreateScanConfigRequest.newBuilder()
            .setParent("parent-995424086")
            .setScanConfig(ScanConfig.newBuilder().build())
            .build();

    ScanConfig actualResponse = client.createScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScanConfigRequest actualRequest = ((CreateScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getScanConfig(), actualRequest.getScanConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      CreateScanConfigRequest request =
          CreateScanConfigRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    DeleteScanConfigRequest request =
        DeleteScanConfigRequest.newBuilder().setName("name3373707").build();

    client.deleteScanConfig(request);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScanConfigRequest actualRequest = ((DeleteScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      DeleteScanConfigRequest request =
          DeleteScanConfigRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetScanConfigRequest request = GetScanConfigRequest.newBuilder().setName("name3373707").build();

    ScanConfig actualResponse = client.getScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanConfigRequest actualRequest = ((GetScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetScanConfigRequest request =
          GetScanConfigRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListScanConfigsRequest request =
        ListScanConfigsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(request);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanConfigsRequest actualRequest = ((ListScanConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScanConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListScanConfigsRequest request =
          ListScanConfigsRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    UpdateScanConfigRequest request =
        UpdateScanConfigRequest.newBuilder()
            .setScanConfig(ScanConfig.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    ScanConfig actualResponse = client.updateScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScanConfigRequest actualRequest = ((UpdateScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getScanConfig(), actualRequest.getScanConfig());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      UpdateScanConfigRequest request =
          UpdateScanConfigRequest.newBuilder()
              .setScanConfig(ScanConfig.newBuilder().build())
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    StartScanRunRequest request = StartScanRunRequest.newBuilder().setName("name3373707").build();

    ScanRun actualResponse = client.startScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartScanRunRequest actualRequest = ((StartScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      StartScanRunRequest request = StartScanRunRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetScanRunRequest request = GetScanRunRequest.newBuilder().setName("name3373707").build();

    ScanRun actualResponse = client.getScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanRunRequest actualRequest = ((GetScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetScanRunRequest request = GetScanRunRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListScanRunsRequest request =
        ListScanRunsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(request);

    List<ScanRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanRunsRequest actualRequest = ((ListScanRunsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScanRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListScanRunsRequest request =
          ListScanRunsRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    StopScanRunRequest request = StopScanRunRequest.newBuilder().setName("name3373707").build();

    ScanRun actualResponse = client.stopScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopScanRunRequest actualRequest = ((StopScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      StopScanRunRequest request = StopScanRunRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListCrawledUrlsRequest request =
        ListCrawledUrlsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(request);

    List<CrawledUrl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCrawledUrlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCrawledUrlsRequest actualRequest = ((ListCrawledUrlsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCrawledUrlsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListCrawledUrlsRequest request =
          ListCrawledUrlsRequest.newBuilder()
              .setParent("parent-995424086")
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
            .setName(
                FindingName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]", "[FINDING]").toString())
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetFindingRequest request = GetFindingRequest.newBuilder().setName("name3373707").build();

    Finding actualResponse = client.getFinding(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingRequest actualRequest = ((GetFindingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetFindingRequest request = GetFindingRequest.newBuilder().setName("name3373707").build();
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListFindingsPagedResponse pagedListResponse = client.listFindings(request);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListFindingsRequest request =
          ListFindingsRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListFindingTypeStatsRequest request =
        ListFindingTypeStatsRequest.newBuilder().setParent("parent-995424086").build();

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingTypeStatsRequest actualRequest =
        ((ListFindingTypeStatsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingTypeStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListFindingTypeStatsRequest request =
          ListFindingTypeStatsRequest.newBuilder().setParent("parent-995424086").build();
      client.listFindingTypeStats(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
