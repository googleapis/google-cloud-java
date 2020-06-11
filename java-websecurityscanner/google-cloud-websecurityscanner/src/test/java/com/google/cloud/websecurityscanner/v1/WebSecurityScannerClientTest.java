/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class WebSecurityScannerClientTest {
  private static MockWebSecurityScanner mockWebSecurityScanner;
  private static MockServiceHelper serviceHelper;
  private WebSecurityScannerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockWebSecurityScanner = new MockWebSecurityScanner();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockWebSecurityScanner));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void createScanConfigTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    int maxQps = 844445913;
    boolean managedScan = false;
    boolean staticIpScan = true;
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setMaxQps(maxQps)
            .setManagedScan(managedScan)
            .setStaticIpScan(staticIpScan)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    CreateScanConfigRequest request = CreateScanConfigRequest.newBuilder().build();

    ScanConfig actualResponse = client.createScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScanConfigRequest actualRequest = (CreateScanConfigRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      CreateScanConfigRequest request = CreateScanConfigRequest.newBuilder().build();

      client.createScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteScanConfigTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    DeleteScanConfigRequest request = DeleteScanConfigRequest.newBuilder().build();

    client.deleteScanConfig(request);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScanConfigRequest actualRequest = (DeleteScanConfigRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      DeleteScanConfigRequest request = DeleteScanConfigRequest.newBuilder().build();

      client.deleteScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getScanConfigTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    int maxQps = 844445913;
    boolean managedScan = false;
    boolean staticIpScan = true;
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setMaxQps(maxQps)
            .setManagedScan(managedScan)
            .setStaticIpScan(staticIpScan)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetScanConfigRequest request = GetScanConfigRequest.newBuilder().build();

    ScanConfig actualResponse = client.getScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanConfigRequest actualRequest = (GetScanConfigRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetScanConfigRequest request = GetScanConfigRequest.newBuilder().build();

      client.getScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listScanConfigsTest() {
    String nextPageToken = "";
    ScanConfig scanConfigsElement = ScanConfig.newBuilder().build();
    List<ScanConfig> scanConfigs = Arrays.asList(scanConfigsElement);
    ListScanConfigsResponse expectedResponse =
        ListScanConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllScanConfigs(scanConfigs)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder().build();

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(request);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanConfigsRequest actualRequest = (ListScanConfigsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listScanConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder().build();

      client.listScanConfigs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateScanConfigTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    int maxQps = 844445913;
    boolean managedScan = false;
    boolean staticIpScan = true;
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setMaxQps(maxQps)
            .setManagedScan(managedScan)
            .setStaticIpScan(staticIpScan)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    UpdateScanConfigRequest request = UpdateScanConfigRequest.newBuilder().build();

    ScanConfig actualResponse = client.updateScanConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScanConfigRequest actualRequest = (UpdateScanConfigRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      UpdateScanConfigRequest request = UpdateScanConfigRequest.newBuilder().build();

      client.updateScanConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void startScanRunTest() {
    String name = "name3373707";
    long urlsCrawledCount = 1749797253L;
    long urlsTestedCount = 1498664068L;
    boolean hasVulnerabilities = false;
    int progressPercent = 2137894861;
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(name)
            .setUrlsCrawledCount(urlsCrawledCount)
            .setUrlsTestedCount(urlsTestedCount)
            .setHasVulnerabilities(hasVulnerabilities)
            .setProgressPercent(progressPercent)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    StartScanRunRequest request = StartScanRunRequest.newBuilder().build();

    ScanRun actualResponse = client.startScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartScanRunRequest actualRequest = (StartScanRunRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void startScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      StartScanRunRequest request = StartScanRunRequest.newBuilder().build();

      client.startScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getScanRunTest() {
    String name = "name3373707";
    long urlsCrawledCount = 1749797253L;
    long urlsTestedCount = 1498664068L;
    boolean hasVulnerabilities = false;
    int progressPercent = 2137894861;
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(name)
            .setUrlsCrawledCount(urlsCrawledCount)
            .setUrlsTestedCount(urlsTestedCount)
            .setHasVulnerabilities(hasVulnerabilities)
            .setProgressPercent(progressPercent)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetScanRunRequest request = GetScanRunRequest.newBuilder().build();

    ScanRun actualResponse = client.getScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanRunRequest actualRequest = (GetScanRunRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetScanRunRequest request = GetScanRunRequest.newBuilder().build();

      client.getScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listScanRunsTest() {
    String nextPageToken = "";
    ScanRun scanRunsElement = ScanRun.newBuilder().build();
    List<ScanRun> scanRuns = Arrays.asList(scanRunsElement);
    ListScanRunsResponse expectedResponse =
        ListScanRunsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllScanRuns(scanRuns)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListScanRunsRequest request = ListScanRunsRequest.newBuilder().build();

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(request);

    List<ScanRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanRunsRequest actualRequest = (ListScanRunsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listScanRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListScanRunsRequest request = ListScanRunsRequest.newBuilder().build();

      client.listScanRuns(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void stopScanRunTest() {
    String name = "name3373707";
    long urlsCrawledCount = 1749797253L;
    long urlsTestedCount = 1498664068L;
    boolean hasVulnerabilities = false;
    int progressPercent = 2137894861;
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(name)
            .setUrlsCrawledCount(urlsCrawledCount)
            .setUrlsTestedCount(urlsTestedCount)
            .setHasVulnerabilities(hasVulnerabilities)
            .setProgressPercent(progressPercent)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    StopScanRunRequest request = StopScanRunRequest.newBuilder().build();

    ScanRun actualResponse = client.stopScanRun(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopScanRunRequest actualRequest = (StopScanRunRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void stopScanRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      StopScanRunRequest request = StopScanRunRequest.newBuilder().build();

      client.stopScanRun(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCrawledUrlsTest() {
    String nextPageToken = "";
    CrawledUrl crawledUrlsElement = CrawledUrl.newBuilder().build();
    List<CrawledUrl> crawledUrls = Arrays.asList(crawledUrlsElement);
    ListCrawledUrlsResponse expectedResponse =
        ListCrawledUrlsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCrawledUrls(crawledUrls)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListCrawledUrlsRequest request = ListCrawledUrlsRequest.newBuilder().build();

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(request);

    List<CrawledUrl> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCrawledUrlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCrawledUrlsRequest actualRequest = (ListCrawledUrlsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCrawledUrlsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListCrawledUrlsRequest request = ListCrawledUrlsRequest.newBuilder().build();

      client.listCrawledUrls(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getFindingTest() {
    FindingName name = FindingName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]", "[FINDING]");
    String findingType = "findingType274496048";
    String httpMethod = "httpMethod820747384";
    String fuzzedUrl = "fuzzedUrl-2120677666";
    String body = "body3029410";
    String description = "description-1724546052";
    String reproductionUrl = "reproductionUrl-244934180";
    String frameUrl = "frameUrl545464221";
    String finalUrl = "finalUrl355601190";
    String trackingId = "trackingId1878901667";
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(name.toString())
            .setFindingType(findingType)
            .setHttpMethod(httpMethod)
            .setFuzzedUrl(fuzzedUrl)
            .setBody(body)
            .setDescription(description)
            .setReproductionUrl(reproductionUrl)
            .setFrameUrl(frameUrl)
            .setFinalUrl(finalUrl)
            .setTrackingId(trackingId)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    GetFindingRequest request = GetFindingRequest.newBuilder().build();

    Finding actualResponse = client.getFinding(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingRequest actualRequest = (GetFindingRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      GetFindingRequest request = GetFindingRequest.newBuilder().build();

      client.getFinding(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listFindingsTest() {
    String nextPageToken = "";
    Finding findingsElement = Finding.newBuilder().build();
    List<Finding> findings = Arrays.asList(findingsElement);
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFindings(findings)
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListFindingsRequest request = ListFindingsRequest.newBuilder().build();

    ListFindingsPagedResponse pagedListResponse = client.listFindings(request);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = (ListFindingsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListFindingsRequest request = ListFindingsRequest.newBuilder().build();

      client.listFindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listFindingTypeStatsTest() {
    ListFindingTypeStatsResponse expectedResponse =
        ListFindingTypeStatsResponse.newBuilder().build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ListFindingTypeStatsRequest request = ListFindingTypeStatsRequest.newBuilder().build();

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingTypeStatsRequest actualRequest = (ListFindingTypeStatsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFindingTypeStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      ListFindingTypeStatsRequest request = ListFindingTypeStatsRequest.newBuilder().build();

      client.listFindingTypeStats(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
