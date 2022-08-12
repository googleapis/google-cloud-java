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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.websecurityscanner.v1beta.stub.HttpJsonWebSecurityScannerStub;
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ScanConfig scanConfig = ScanConfig.newBuilder().build();

    ScanConfig actualResponse = client.createScanConfig(parent, scanConfig);
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    ScanConfig scanConfig = ScanConfig.newBuilder().build();

    ScanConfig actualResponse = client.createScanConfig(parent, scanConfig);
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
  public void createScanConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    client.deleteScanConfig(name);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7376/scanConfigs/scanConfig-7376";

    client.deleteScanConfig(name);

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
  public void deleteScanConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7376/scanConfigs/scanConfig-7376";
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
    mockService.addResponse(expectedResponse);

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ScanConfig actualResponse = client.getScanConfig(name);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7376/scanConfigs/scanConfig-7376";

    ScanConfig actualResponse = client.getScanConfig(name);
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
  public void getScanConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7376/scanConfigs/scanConfig-7376";
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(parent);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListScanConfigsPagedResponse pagedListResponse = client.listScanConfigs(parent);

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
  public void listScanConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    ScanConfig scanConfig =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    ScanConfig actualResponse = client.updateScanConfig(scanConfig, updateMask);
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
      ScanConfig scanConfig =
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
    mockService.addResponse(expectedResponse);

    ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ScanRun actualResponse = client.startScanRun(name);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7376/scanConfigs/scanConfig-7376";

    ScanRun actualResponse = client.startScanRun(name);
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
  public void startScanRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7376/scanConfigs/scanConfig-7376";
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
    mockService.addResponse(expectedResponse);

    ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ScanRun actualResponse = client.getScanRun(name);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135";

    ScanRun actualResponse = client.getScanRun(name);
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
  public void getScanRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135";
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
    mockService.addResponse(expectedResponse);

    ScanConfigName parent = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(parent);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2657/scanConfigs/scanConfig-2657";

    ListScanRunsPagedResponse pagedListResponse = client.listScanRuns(parent);

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
  public void listScanRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2657/scanConfigs/scanConfig-2657";
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
    mockService.addResponse(expectedResponse);

    ScanRunName name = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ScanRun actualResponse = client.stopScanRun(name);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135";

    ScanRun actualResponse = client.stopScanRun(name);
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
  public void stopScanRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1135/scanConfigs/scanConfig-1135/scanRuns/scanRun-1135";
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
    mockService.addResponse(expectedResponse);

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(parent);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";

    ListCrawledUrlsPagedResponse pagedListResponse = client.listCrawledUrls(parent);

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
  public void listCrawledUrlsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";
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
    mockService.addResponse(expectedResponse);

    FindingName name = FindingName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]", "[FINDING]");

    Finding actualResponse = client.getFinding(name);
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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9877/scanConfigs/scanConfig-9877/scanRuns/scanRun-9877/findings/finding-9877";

    Finding actualResponse = client.getFinding(name);
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
  public void getFindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9877/scanConfigs/scanConfig-9877/scanRuns/scanRun-9877/findings/finding-9877";
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
    mockService.addResponse(expectedResponse);

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");
    String filter = "filter-1274492040";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent, filter);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";
    String filter = "filter-1274492040";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent, filter);

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
  public void listFindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";
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
    mockService.addResponse(expectedResponse);

    ScanRunName parent = ScanRunName.of("[PROJECT]", "[SCAN_CONFIG]", "[SCAN_RUN]");

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(parent);
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";

    ListFindingTypeStatsResponse actualResponse = client.listFindingTypeStats(parent);
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
  public void listFindingTypeStatsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3104/scanConfigs/scanConfig-3104/scanRuns/scanRun-3104";
      client.listFindingTypeStats(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
