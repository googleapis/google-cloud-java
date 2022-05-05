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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.FolderName;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.InternalChecker;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckConfigName;
import com.google.monitoring.v3.UptimeCheckIp;
import com.google.monitoring.v3.UptimeCheckRegion;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
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
public class UptimeCheckServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockUptimeCheckService mockUptimeCheckService;
  private LocalChannelProvider channelProvider;
  private UptimeCheckServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUptimeCheckService = new MockUptimeCheckService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockUptimeCheckService));
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
    UptimeCheckServiceSettings settings =
        UptimeCheckServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UptimeCheckServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listUptimeCheckConfigsTest() throws Exception {
    UptimeCheckConfig responsesElement = UptimeCheckConfig.newBuilder().build();
    ListUptimeCheckConfigsResponse expectedResponse =
        ListUptimeCheckConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUptimeCheckConfigs(Arrays.asList(responsesElement))
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListUptimeCheckConfigsPagedResponse pagedListResponse = client.listUptimeCheckConfigs(parent);

    List<UptimeCheckConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckConfigsRequest actualRequest =
        ((ListUptimeCheckConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUptimeCheckConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listUptimeCheckConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUptimeCheckConfigsTest2() throws Exception {
    UptimeCheckConfig responsesElement = UptimeCheckConfig.newBuilder().build();
    ListUptimeCheckConfigsResponse expectedResponse =
        ListUptimeCheckConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUptimeCheckConfigs(Arrays.asList(responsesElement))
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListUptimeCheckConfigsPagedResponse pagedListResponse = client.listUptimeCheckConfigs(parent);

    List<UptimeCheckConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckConfigsRequest actualRequest =
        ((ListUptimeCheckConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUptimeCheckConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listUptimeCheckConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUptimeCheckConfigsTest3() throws Exception {
    UptimeCheckConfig responsesElement = UptimeCheckConfig.newBuilder().build();
    ListUptimeCheckConfigsResponse expectedResponse =
        ListUptimeCheckConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUptimeCheckConfigs(Arrays.asList(responsesElement))
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListUptimeCheckConfigsPagedResponse pagedListResponse = client.listUptimeCheckConfigs(parent);

    List<UptimeCheckConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckConfigsRequest actualRequest =
        ((ListUptimeCheckConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUptimeCheckConfigsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listUptimeCheckConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUptimeCheckConfigsTest4() throws Exception {
    UptimeCheckConfig responsesElement = UptimeCheckConfig.newBuilder().build();
    ListUptimeCheckConfigsResponse expectedResponse =
        ListUptimeCheckConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUptimeCheckConfigs(Arrays.asList(responsesElement))
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUptimeCheckConfigsPagedResponse pagedListResponse = client.listUptimeCheckConfigs(parent);

    List<UptimeCheckConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckConfigsRequest actualRequest =
        ((ListUptimeCheckConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUptimeCheckConfigsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUptimeCheckConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUptimeCheckConfigTest() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfigName name =
        UptimeCheckConfigName.ofProjectUptimeCheckConfigName("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

    UptimeCheckConfig actualResponse = client.getUptimeCheckConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUptimeCheckConfigRequest actualRequest =
        ((GetUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfigName name =
          UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
              "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
      client.getUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUptimeCheckConfigTest2() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String name = "name3373707";

    UptimeCheckConfig actualResponse = client.getUptimeCheckConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUptimeCheckConfigRequest actualRequest =
        ((GetUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUptimeCheckConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String name = "name3373707";
      client.getUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUptimeCheckConfigTest() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.createUptimeCheckConfig(parent, uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUptimeCheckConfigRequest actualRequest =
        ((CreateUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
      client.createUptimeCheckConfig(parent, uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUptimeCheckConfigTest2() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.createUptimeCheckConfig(parent, uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUptimeCheckConfigRequest actualRequest =
        ((CreateUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUptimeCheckConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
      client.createUptimeCheckConfig(parent, uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUptimeCheckConfigTest3() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.createUptimeCheckConfig(parent, uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUptimeCheckConfigRequest actualRequest =
        ((CreateUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUptimeCheckConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
      client.createUptimeCheckConfig(parent, uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUptimeCheckConfigTest4() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.createUptimeCheckConfig(parent, uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUptimeCheckConfigRequest actualRequest =
        ((CreateUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUptimeCheckConfigExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String parent = "parent-995424086";
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
      client.createUptimeCheckConfig(parent, uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUptimeCheckConfigTest() throws Exception {
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(
                UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
                        "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setPeriod(Duration.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllContentMatchers(new ArrayList<UptimeCheckConfig.ContentMatcher>())
            .addAllSelectedRegions(new ArrayList<UptimeCheckRegion>())
            .setIsInternal(true)
            .addAllInternalCheckers(new ArrayList<InternalChecker>())
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.updateUptimeCheckConfig(uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUptimeCheckConfigRequest actualRequest =
        ((UpdateUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
      client.updateUptimeCheckConfig(uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUptimeCheckConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfigName name =
        UptimeCheckConfigName.ofProjectUptimeCheckConfigName("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

    client.deleteUptimeCheckConfig(name);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUptimeCheckConfigRequest actualRequest =
        ((DeleteUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfigName name =
          UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
              "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
      client.deleteUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUptimeCheckConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUptimeCheckConfig(name);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUptimeCheckConfigRequest actualRequest =
        ((DeleteUptimeCheckConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUptimeCheckConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUptimeCheckIpsTest() throws Exception {
    UptimeCheckIp responsesElement = UptimeCheckIp.newBuilder().build();
    ListUptimeCheckIpsResponse expectedResponse =
        ListUptimeCheckIpsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUptimeCheckIps(Arrays.asList(responsesElement))
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    ListUptimeCheckIpsRequest request =
        ListUptimeCheckIpsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListUptimeCheckIpsPagedResponse pagedListResponse = client.listUptimeCheckIps(request);

    List<UptimeCheckIp> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckIpsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckIpsRequest actualRequest = ((ListUptimeCheckIpsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUptimeCheckIpsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      ListUptimeCheckIpsRequest request =
          ListUptimeCheckIpsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listUptimeCheckIps(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
