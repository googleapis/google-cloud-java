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
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
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
public class DashboardsServiceClientTest {
  private static MockDashboardsService mockDashboardsService;
  private static MockServiceHelper serviceHelper;
  private DashboardsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDashboardsService = new MockDashboardsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDashboardsService));
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
  @SuppressWarnings("all")
  public void createDashboardTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Dashboard expectedResponse =
        Dashboard.newBuilder().setName(name).setDisplayName(displayName).setEtag(etag).build();
    mockDashboardsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Dashboard dashboard = Dashboard.newBuilder().build();
    CreateDashboardRequest request =
        CreateDashboardRequest.newBuilder().setParent(parent).setDashboard(dashboard).build();

    Dashboard actualResponse = client.createDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDashboardRequest actualRequest = (CreateDashboardRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dashboard, actualRequest.getDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Dashboard dashboard = Dashboard.newBuilder().build();
      CreateDashboardRequest request =
          CreateDashboardRequest.newBuilder().setParent(parent).setDashboard(dashboard).build();

      client.createDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDashboardsTest() {
    String nextPageToken = "";
    Dashboard dashboardsElement = Dashboard.newBuilder().build();
    List<Dashboard> dashboards = Arrays.asList(dashboardsElement);
    ListDashboardsResponse expectedResponse =
        ListDashboardsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDashboards(dashboards)
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ListDashboardsRequest request = ListDashboardsRequest.newBuilder().setParent(parent).build();

    ListDashboardsPagedResponse pagedListResponse = client.listDashboards(request);

    List<Dashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDashboardsRequest actualRequest = (ListDashboardsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String parent = "parent-995424086";
      ListDashboardsRequest request = ListDashboardsRequest.newBuilder().setParent(parent).build();

      client.listDashboards(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDashboardTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Dashboard expectedResponse =
        Dashboard.newBuilder().setName(name2).setDisplayName(displayName).setEtag(etag).build();
    mockDashboardsService.addResponse(expectedResponse);

    String name = "name3373707";
    GetDashboardRequest request = GetDashboardRequest.newBuilder().setName(name).build();

    Dashboard actualResponse = client.getDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardRequest actualRequest = (GetDashboardRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String name = "name3373707";
      GetDashboardRequest request = GetDashboardRequest.newBuilder().setName(name).build();

      client.getDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDashboardTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDashboardsService.addResponse(expectedResponse);

    String name = "name3373707";
    DeleteDashboardRequest request = DeleteDashboardRequest.newBuilder().setName(name).build();

    client.deleteDashboard(request);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDashboardRequest actualRequest = (DeleteDashboardRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String name = "name3373707";
      DeleteDashboardRequest request = DeleteDashboardRequest.newBuilder().setName(name).build();

      client.deleteDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateDashboardTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String etag = "etag3123477";
    Dashboard expectedResponse =
        Dashboard.newBuilder().setName(name).setDisplayName(displayName).setEtag(etag).build();
    mockDashboardsService.addResponse(expectedResponse);

    Dashboard dashboard = Dashboard.newBuilder().build();
    UpdateDashboardRequest request =
        UpdateDashboardRequest.newBuilder().setDashboard(dashboard).build();

    Dashboard actualResponse = client.updateDashboard(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDashboardRequest actualRequest = (UpdateDashboardRequest) actualRequests.get(0);

    Assert.assertEquals(dashboard, actualRequest.getDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      Dashboard dashboard = Dashboard.newBuilder().build();
      UpdateDashboardRequest request =
          UpdateDashboardRequest.newBuilder().setDashboard(dashboard).build();

      client.updateDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
