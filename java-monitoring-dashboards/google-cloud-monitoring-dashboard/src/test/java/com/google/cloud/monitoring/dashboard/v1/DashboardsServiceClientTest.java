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

package com.google.cloud.monitoring.dashboard.v1;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DashboardFilter;
import com.google.monitoring.dashboard.v1.DashboardName;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.ProjectName;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class DashboardsServiceClientTest {
  private static MockDashboardsService mockDashboardsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DashboardsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDashboardsService = new MockDashboardsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDashboardsService));
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
    DashboardsServiceSettings settings =
        DashboardsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDashboardTest() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    CreateDashboardRequest request =
        CreateDashboardRequest.newBuilder()
            .setParent("parent-995424086")
            .setDashboard(Dashboard.newBuilder().build())
            .setValidateOnly(true)
            .build();

    Dashboard actualResponse = client.createDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDashboardRequest actualRequest = ((CreateDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDashboard(), actualRequest.getDashboard());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      CreateDashboardRequest request =
          CreateDashboardRequest.newBuilder()
              .setParent("parent-995424086")
              .setDashboard(Dashboard.newBuilder().build())
              .setValidateOnly(true)
              .build();
      client.createDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDashboardsTest() throws Exception {
    Dashboard responsesElement = Dashboard.newBuilder().build();
    ListDashboardsResponse expectedResponse =
        ListDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDashboards(Arrays.asList(responsesElement))
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    ListDashboardsRequest request =
        ListDashboardsRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListDashboardsPagedResponse pagedListResponse = client.listDashboards(request);

    List<Dashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDashboardsRequest actualRequest = ((ListDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      ListDashboardsRequest request =
          ListDashboardsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listDashboards(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDashboardTest() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    GetDashboardRequest request =
        GetDashboardRequest.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .build();

    Dashboard actualResponse = client.getDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardRequest actualRequest = ((GetDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      GetDashboardRequest request =
          GetDashboardRequest.newBuilder()
              .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
              .build();
      client.getDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDashboardTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDashboardsService.addResponse(expectedResponse);

    DeleteDashboardRequest request =
        DeleteDashboardRequest.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .build();

    client.deleteDashboard(request);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDashboardRequest actualRequest = ((DeleteDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      DeleteDashboardRequest request =
          DeleteDashboardRequest.newBuilder()
              .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
              .build();
      client.deleteDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDashboardTest() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    UpdateDashboardRequest request =
        UpdateDashboardRequest.newBuilder()
            .setDashboard(Dashboard.newBuilder().build())
            .setValidateOnly(true)
            .build();

    Dashboard actualResponse = client.updateDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDashboardRequest actualRequest = ((UpdateDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDashboard(), actualRequest.getDashboard());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      UpdateDashboardRequest request =
          UpdateDashboardRequest.newBuilder()
              .setDashboard(Dashboard.newBuilder().build())
              .setValidateOnly(true)
              .build();
      client.updateDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
