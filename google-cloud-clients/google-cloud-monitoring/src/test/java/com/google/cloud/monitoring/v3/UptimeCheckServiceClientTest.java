/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;

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
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckConfigName;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class UptimeCheckServiceClientTest {
  private static MockAlertPolicyService mockAlertPolicyService;
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockNotificationChannelService mockNotificationChannelService;
  private static MockUptimeCheckService mockUptimeCheckService;
  private static MockServiceHelper serviceHelper;
  private UptimeCheckServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAlertPolicyService = new MockAlertPolicyService();
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    mockNotificationChannelService = new MockNotificationChannelService();
    mockUptimeCheckService = new MockUptimeCheckService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAlertPolicyService,
                mockGroupService,
                mockMetricService,
                mockNotificationChannelService,
                mockUptimeCheckService));
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
  @SuppressWarnings("all")
  public void listUptimeCheckConfigsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    UptimeCheckConfig uptimeCheckConfigsElement = UptimeCheckConfig.newBuilder().build();
    List<UptimeCheckConfig> uptimeCheckConfigs = Arrays.asList(uptimeCheckConfigsElement);
    ListUptimeCheckConfigsResponse expectedResponse =
        ListUptimeCheckConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllUptimeCheckConfigs(uptimeCheckConfigs)
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String formattedParent = ProjectName.format("[PROJECT]");

    ListUptimeCheckConfigsPagedResponse pagedListResponse =
        client.listUptimeCheckConfigs(formattedParent);

    List<UptimeCheckConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUptimeCheckConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUptimeCheckConfigsRequest actualRequest =
        (ListUptimeCheckConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listUptimeCheckConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String formattedParent = ProjectName.format("[PROJECT]");

      client.listUptimeCheckConfigs(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getUptimeCheckConfigTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    boolean isInternal = true;
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setIsInternal(isInternal)
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfigName name = UptimeCheckConfigName.of("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

    UptimeCheckConfig actualResponse = client.getUptimeCheckConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUptimeCheckConfigRequest actualRequest = (GetUptimeCheckConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, UptimeCheckConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfigName name = UptimeCheckConfigName.of("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

      client.getUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createUptimeCheckConfigTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    boolean isInternal = true;
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setIsInternal(isInternal)
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    String formattedParent = ProjectName.format("[PROJECT]");
    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse =
        client.createUptimeCheckConfig(formattedParent, uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUptimeCheckConfigRequest actualRequest =
        (CreateUptimeCheckConfigRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      String formattedParent = ProjectName.format("[PROJECT]");
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

      client.createUptimeCheckConfig(formattedParent, uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateUptimeCheckConfigTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    boolean isInternal = true;
    UptimeCheckConfig expectedResponse =
        UptimeCheckConfig.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setIsInternal(isInternal)
            .build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

    UptimeCheckConfig actualResponse = client.updateUptimeCheckConfig(uptimeCheckConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUptimeCheckConfigRequest actualRequest =
        (UpdateUptimeCheckConfigRequest) actualRequests.get(0);

    Assert.assertEquals(uptimeCheckConfig, actualRequest.getUptimeCheckConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();

      client.updateUptimeCheckConfig(uptimeCheckConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUptimeCheckConfigTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockUptimeCheckService.addResponse(expectedResponse);

    UptimeCheckConfigName name = UptimeCheckConfigName.of("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

    client.deleteUptimeCheckConfig(name);

    List<AbstractMessage> actualRequests = mockUptimeCheckService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUptimeCheckConfigRequest actualRequest =
        (DeleteUptimeCheckConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, UptimeCheckConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteUptimeCheckConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUptimeCheckService.addException(exception);

    try {
      UptimeCheckConfigName name = UptimeCheckConfigName.of("[PROJECT]", "[UPTIME_CHECK_CONFIG]");

      client.deleteUptimeCheckConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
