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

package com.google.cloud.websecurityscanner.v1beta;

import static com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient.ListScanRunsPagedResponse;

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
  private static MockServiceHelper mockServiceHelper;
  private static MockWebSecurityScanner mockWebSecurityScanner;
  private LocalChannelProvider channelProvider;
  private WebSecurityScannerClient client;

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
            .setName(ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .addAllTargetPlatforms(new ArrayList<ScanConfig.TargetPlatform>())
            .setLatestRun(ScanRun.newBuilder().build())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ScanConfig scanConfig = ScanConfig.newBuilder().build();

    ScanConfig actualResponse = client.createScanConfig(parent, scanConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScanConfigRequest actualRequest = ((CreateScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(scanConfig, actualRequest.getScanConfig());
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      ScanConfig scanConfig = ScanConfig.newBuilder().build();
      client.createScanConfig(parent, scanConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScanConfigTest2() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .addAllTargetPlatforms(new ArrayList<ScanConfig.TargetPlatform>())
            .setLatestRun(ScanRun.newBuilder().build())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ScanConfig scanConfig = ScanConfig.newBuilder().build();

    ScanConfig actualResponse = client.createScanConfig(parent, scanConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateScanConfigRequest actualRequest = ((CreateScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(scanConfig, actualRequest.getScanConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createScanConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      ScanConfig scanConfig = ScanConfig.newBuilder().build();
      client.createScanConfig(parent, scanConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScanConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    client.deleteScanConfig(name);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScanConfigRequest actualRequest = ((DeleteScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
      client.deleteScanConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteScanConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteScanConfig(name);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteScanConfigRequest actualRequest = ((DeleteScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteScanConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.deleteScanConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanConfigTest() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .addAllTargetPlatforms(new ArrayList<ScanConfig.TargetPlatform>())
            .setLatestRun(ScanRun.newBuilder().build())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ScanConfig actualResponse = client.getScanConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanConfigRequest actualRequest = ((GetScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
      client.getScanConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanConfigTest2() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .addAllTargetPlatforms(new ArrayList<ScanConfig.TargetPlatform>())
            .setLatestRun(ScanRun.newBuilder().build())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String name = "name3373707";

    ScanConfig actualResponse = client.getScanConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanConfigRequest actualRequest = ((GetScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScanConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.getScanConfig(name);
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

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(parent);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanConfigsRequest actualRequest = ((ListScanConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listScanConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScanConfigsTest2() throws Exception {
    ScanConfig responsesElement = ScanConfig.newBuilder().build();
    ListScanConfigsResponse expectedResponse =
        ListScanConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScanConfigs(Arrays.asList(responsesElement))
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(parent);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanConfigsRequest actualRequest = ((ListScanConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScanConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listScanConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateScanConfigTest() throws Exception {
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setMaxQps(844445913)
            .addAllStartingUrls(new ArrayList<String>())
            .setAuthentication(ScanConfig.Authentication.newBuilder().build())
            .addAllBlacklistPatterns(new ArrayList<String>())
            .setSchedule(ScanConfig.Schedule.newBuilder().build())
            .addAllTargetPlatforms(new ArrayList<ScanConfig.TargetPlatform>())
            .setLatestRun(ScanRun.newBuilder().build())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    ScanConfig scanConfig = ScanConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ScanConfig actualResponse = client.updateScanConfig(scanConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScanConfigRequest actualRequest = ((UpdateScanConfigRequest) actualRequests.get(0));

    Assert.assertEquals(scanConfig, actualRequest.getScanConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
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
      ScanConfig scanConfig = ScanConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScanConfig(scanConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ScanRun actualResponse = client.startScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartScanRunRequest actualRequest = ((StartScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
      client.startScanRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startScanRunTest2() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    String name = "name3373707";

    ScanRun actualResponse = client.startScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartScanRunRequest actualRequest = ((StartScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startScanRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.startScanRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ScanRun actualResponse = client.getScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanRunRequest actualRequest = ((GetScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
      client.getScanRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScanRunTest2() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    String name = "name3373707";

    ScanRun actualResponse = client.getScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanRunRequest actualRequest = ((GetScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScanRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.getScanRun(name);
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

    ScanConfigName parent = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(parent);

    List<ScanRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanRunsRequest actualRequest = ((ListScanRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      ScanConfigName parent = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
      client.listScanRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScanRunsTest2() throws Exception {
    ScanRun responsesElement = ScanRun.newBuilder().build();
    ListScanRunsResponse expectedResponse =
        ListScanRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllScanRuns(Arrays.asList(responsesElement))
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(parent);

    List<ScanRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanRunsRequest actualRequest = ((ListScanRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listScanRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listScanRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopScanRunTest() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ScanRun actualResponse = client.stopScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopScanRunRequest actualRequest = ((StopScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
      client.stopScanRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopScanRunTest2() throws Exception {
    ScanRun expectedResponse =
        ScanRun.newBuilder()
            .setName(ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]").toString())
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

    String name = "name3373707";

    ScanRun actualResponse = client.stopScanRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopScanRunRequest actualRequest = ((StopScanRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopScanRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.stopScanRun(name);
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

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(parent);

    List<CrawledUrl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCrawledUrlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCrawledUrlsRequest actualRequest = ((ListCrawledUrlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
      client.listCrawledUrls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCrawledUrlsTest2() throws Exception {
    CrawledUrl responsesElement = CrawledUrl.newBuilder().build();
    ListCrawledUrlsResponse expectedResponse =
        ListCrawledUrlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCrawledUrls(Arrays.asList(responsesElement))
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(parent);

    List<CrawledUrl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCrawledUrlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCrawledUrlsRequest actualRequest = ((ListCrawledUrlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCrawledUrlsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCrawledUrls(parent);
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

    FindingName name = FindingName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]", "[FINDING]");

    Finding actualResponse = client.getFinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingRequest actualRequest = ((GetFindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      FindingName name = FindingName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]", "[FINDING]");
      client.getFinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingTest2() throws Exception {
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

    String name = "name3373707";

    Finding actualResponse = client.getFinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingRequest actualRequest = ((GetFindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String name = "name3373707";
      client.getFinding(name);
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

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
    String filter = "filter-1274492040";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent, filter);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
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
      ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
      String filter = "filter-1274492040";
      client.listFindings(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest2() throws Exception {
    Finding responsesElement = Finding.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindings(Arrays.asList(responsesElement))
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent, filter);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listFindings(parent, filter);
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

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingTypeStatsRequest actualRequest =
        ((ListFindingTypeStatsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
      client.listFindingTypeStats(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingTypeStatsTest2() throws Exception {
    ListFindingTypeStatsResponse expectedResponse =
        ListFindingTypeStatsResponse.newBuilder()
            .addAllFindingTypeStats(new ArrayList<FindingTypeStats>())
            .build();
    mockWebSecurityScanner.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWebSecurityScanner.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingTypeStatsRequest actualRequest =
        ((ListFindingTypeStatsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingTypeStatsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWebSecurityScanner.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFindingTypeStats(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
