/*
 * Copyright 2023 Google LLC
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

    ProjectName parent = ProjectName.of("[PROJECT]");
    Dashboard dashboard = Dashboard.newBuilder().build();

    Dashboard actualResponse = client.createDashboard(parent, dashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDashboardRequest actualRequest = ((CreateDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dashboard, actualRequest.getDashboard());
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      Dashboard dashboard = Dashboard.newBuilder().build();
      client.createDashboard(parent, dashboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDashboardTest2() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Dashboard dashboard = Dashboard.newBuilder().build();

    Dashboard actualResponse = client.createDashboard(parent, dashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDashboardRequest actualRequest = ((CreateDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dashboard, actualRequest.getDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Dashboard dashboard = Dashboard.newBuilder().build();
      client.createDashboard(parent, dashboard);
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

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDashboardsPagedResponse pagedListResponse = client.listDashboards(parent);

    List<Dashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDashboardsRequest actualRequest = ((ListDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDashboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDashboardsTest2() throws Exception {
    Dashboard responsesElement = Dashboard.newBuilder().build();
    ListDashboardsResponse expectedResponse =
        ListDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDashboards(Arrays.asList(responsesElement))
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDashboardsPagedResponse pagedListResponse = client.listDashboards(parent);

    List<Dashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDashboardsRequest actualRequest = ((ListDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDashboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDashboards(parent);
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

    DashboardName name = DashboardName.of("[PROJECT]", "[DASHBOARD]");

    Dashboard actualResponse = client.getDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardRequest actualRequest = ((GetDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      DashboardName name = DashboardName.of("[PROJECT]", "[DASHBOARD]");
      client.getDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDashboardTest2() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDashboardsService.addResponse(expectedResponse);

    String name = "name3373707";

    Dashboard actualResponse = client.getDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardRequest actualRequest = ((GetDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String name = "name3373707";
      client.getDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDashboardTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDashboardsService.addResponse(expectedResponse);

    DashboardName name = DashboardName.of("[PROJECT]", "[DASHBOARD]");

    client.deleteDashboard(name);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDashboardRequest actualRequest = ((DeleteDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      DashboardName name = DashboardName.of("[PROJECT]", "[DASHBOARD]");
      client.deleteDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDashboardTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDashboardsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDashboard(name);

    List<AbstractMessage> actualRequests = mockDashboardsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDashboardRequest actualRequest = ((DeleteDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDashboard(name);
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
