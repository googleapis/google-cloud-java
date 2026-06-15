/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

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
public class NativeDashboardServiceClientTest {
  private static MockNativeDashboardService mockNativeDashboardService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NativeDashboardServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNativeDashboardService = new MockNativeDashboardService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNativeDashboardService));
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
    NativeDashboardServiceSettings settings =
        NativeDashboardServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NativeDashboardServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createNativeDashboardTest() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.createNativeDashboard(parent, nativeDashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNativeDashboardRequest actualRequest =
        ((CreateNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(nativeDashboard, actualRequest.getNativeDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
      client.createNativeDashboard(parent, nativeDashboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNativeDashboardTest2() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.createNativeDashboard(parent, nativeDashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNativeDashboardRequest actualRequest =
        ((CreateNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(nativeDashboard, actualRequest.getNativeDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
      client.createNativeDashboard(parent, nativeDashboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNativeDashboardTest() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    NativeDashboard actualResponse = client.getNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNativeDashboardRequest actualRequest = ((GetNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      client.getNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNativeDashboardTest2() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    NativeDashboard actualResponse = client.getNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNativeDashboardRequest actualRequest = ((GetNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      client.getNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNativeDashboardsTest() throws Exception {
    NativeDashboard responsesElement = NativeDashboard.newBuilder().build();
    ListNativeDashboardsResponse expectedResponse =
        ListNativeDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNativeDashboards(Arrays.asList(responsesElement))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListNativeDashboardsPagedResponse pagedListResponse = client.listNativeDashboards(parent);

    List<NativeDashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNativeDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNativeDashboardsRequest actualRequest =
        ((ListNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNativeDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listNativeDashboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNativeDashboardsTest2() throws Exception {
    NativeDashboard responsesElement = NativeDashboard.newBuilder().build();
    ListNativeDashboardsResponse expectedResponse =
        ListNativeDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNativeDashboards(Arrays.asList(responsesElement))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNativeDashboardsPagedResponse pagedListResponse = client.listNativeDashboards(parent);

    List<NativeDashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNativeDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNativeDashboardsRequest actualRequest =
        ((ListNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNativeDashboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNativeDashboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNativeDashboardTest() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NativeDashboard actualResponse = client.updateNativeDashboard(nativeDashboard, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNativeDashboardRequest actualRequest =
        ((UpdateNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(nativeDashboard, actualRequest.getNativeDashboard());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNativeDashboard(nativeDashboard, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void duplicateNativeDashboardTest() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.duplicateNativeDashboard(name, nativeDashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DuplicateNativeDashboardRequest actualRequest =
        ((DuplicateNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(nativeDashboard, actualRequest.getNativeDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void duplicateNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
      client.duplicateNativeDashboard(name, nativeDashboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void duplicateNativeDashboardTest2() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.duplicateNativeDashboard(name, nativeDashboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DuplicateNativeDashboardRequest actualRequest =
        ((DuplicateNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(nativeDashboard, actualRequest.getNativeDashboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void duplicateNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
      client.duplicateNativeDashboard(name, nativeDashboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNativeDashboardTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    client.deleteNativeDashboard(name);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNativeDashboardRequest actualRequest =
        ((DeleteNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      client.deleteNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNativeDashboardTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteNativeDashboard(name);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNativeDashboardRequest actualRequest =
        ((DeleteNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addChartTest() throws Exception {
    AddChartResponse expectedResponse =
        AddChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();

    AddChartResponse actualResponse = client.addChart(name, dashboardQuery, dashboardChart);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddChartRequest actualRequest = ((AddChartRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(dashboardQuery, actualRequest.getDashboardQuery());
    Assert.assertEquals(dashboardChart, actualRequest.getDashboardChart());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addChartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
      DashboardChart dashboardChart = DashboardChart.newBuilder().build();
      client.addChart(name, dashboardQuery, dashboardChart);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addChartTest2() throws Exception {
    AddChartResponse expectedResponse =
        AddChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();

    AddChartResponse actualResponse = client.addChart(name, dashboardQuery, dashboardChart);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddChartRequest actualRequest = ((AddChartRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(dashboardQuery, actualRequest.getDashboardQuery());
    Assert.assertEquals(dashboardChart, actualRequest.getDashboardChart());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addChartExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
      DashboardChart dashboardChart = DashboardChart.newBuilder().build();
      client.addChart(name, dashboardQuery, dashboardChart);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeChartTest() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    NativeDashboard actualResponse = client.removeChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveChartRequest actualRequest = ((RemoveChartRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeChartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      client.removeChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeChartTest2() throws Exception {
    NativeDashboard expectedResponse =
        NativeDashboard.newBuilder()
            .setName(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefinition(DashboardDefinition.newBuilder().build())
            .setType(DashboardType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateUserId("createUserId1591742050")
            .setUpdateUserId("updateUserId-884287377")
            .setDashboardUserData(DashboardUserData.newBuilder().build())
            .setEtag("etag3123477")
            .setAccess(DashboardAccess.forNumber(0))
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    NativeDashboard actualResponse = client.removeChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveChartRequest actualRequest = ((RemoveChartRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeChartExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      client.removeChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void editChartTest() throws Exception {
    EditChartResponse expectedResponse =
        EditChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();
    FieldMask editMask = FieldMask.newBuilder().build();

    EditChartResponse actualResponse =
        client.editChart(name, dashboardQuery, dashboardChart, editMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EditChartRequest actualRequest = ((EditChartRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(dashboardQuery, actualRequest.getDashboardQuery());
    Assert.assertEquals(dashboardChart, actualRequest.getDashboardChart());
    Assert.assertEquals(editMask, actualRequest.getEditMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void editChartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
      DashboardChart dashboardChart = DashboardChart.newBuilder().build();
      FieldMask editMask = FieldMask.newBuilder().build();
      client.editChart(name, dashboardQuery, dashboardChart, editMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void editChartTest2() throws Exception {
    EditChartResponse expectedResponse =
        EditChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();
    FieldMask editMask = FieldMask.newBuilder().build();

    EditChartResponse actualResponse =
        client.editChart(name, dashboardQuery, dashboardChart, editMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EditChartRequest actualRequest = ((EditChartRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(dashboardQuery, actualRequest.getDashboardQuery());
    Assert.assertEquals(dashboardChart, actualRequest.getDashboardChart());
    Assert.assertEquals(editMask, actualRequest.getEditMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void editChartExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
      DashboardChart dashboardChart = DashboardChart.newBuilder().build();
      FieldMask editMask = FieldMask.newBuilder().build();
      client.editChart(name, dashboardQuery, dashboardChart, editMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void duplicateChartTest() throws Exception {
    DuplicateChartResponse expectedResponse =
        DuplicateChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    DuplicateChartResponse actualResponse = client.duplicateChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DuplicateChartRequest actualRequest = ((DuplicateChartRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void duplicateChartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      NativeDashboardName name =
          NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
      client.duplicateChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void duplicateChartTest2() throws Exception {
    DuplicateChartResponse expectedResponse =
        DuplicateChartResponse.newBuilder()
            .setNativeDashboard(NativeDashboard.newBuilder().build())
            .setDashboardChart(DashboardChart.newBuilder().build())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    DuplicateChartResponse actualResponse = client.duplicateChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DuplicateChartRequest actualRequest = ((DuplicateChartRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void duplicateChartExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      client.duplicateChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportNativeDashboardsTest() throws Exception {
    ExportNativeDashboardsResponse expectedResponse =
        ExportNativeDashboardsResponse.newBuilder().build();
    mockNativeDashboardService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> names = new ArrayList<>();

    ExportNativeDashboardsResponse actualResponse = client.exportNativeDashboards(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportNativeDashboardsRequest actualRequest =
        ((ExportNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportNativeDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      List<String> names = new ArrayList<>();
      client.exportNativeDashboards(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportNativeDashboardsTest2() throws Exception {
    ExportNativeDashboardsResponse expectedResponse =
        ExportNativeDashboardsResponse.newBuilder().build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    ExportNativeDashboardsResponse actualResponse = client.exportNativeDashboards(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportNativeDashboardsRequest actualRequest =
        ((ExportNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportNativeDashboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.exportNativeDashboards(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importNativeDashboardsTest() throws Exception {
    ImportNativeDashboardsResponse expectedResponse =
        ImportNativeDashboardsResponse.newBuilder()
            .addAllResults(new ArrayList<ImportExportStatus>())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ImportNativeDashboardsInlineSource source =
        ImportNativeDashboardsInlineSource.newBuilder().build();

    ImportNativeDashboardsResponse actualResponse = client.importNativeDashboards(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportNativeDashboardsRequest actualRequest =
        ((ImportNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importNativeDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      ImportNativeDashboardsInlineSource source =
          ImportNativeDashboardsInlineSource.newBuilder().build();
      client.importNativeDashboards(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importNativeDashboardsTest2() throws Exception {
    ImportNativeDashboardsResponse expectedResponse =
        ImportNativeDashboardsResponse.newBuilder()
            .addAllResults(new ArrayList<ImportExportStatus>())
            .build();
    mockNativeDashboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ImportNativeDashboardsInlineSource source =
        ImportNativeDashboardsInlineSource.newBuilder().build();

    ImportNativeDashboardsResponse actualResponse = client.importNativeDashboards(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportNativeDashboardsRequest actualRequest =
        ((ImportNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importNativeDashboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNativeDashboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      ImportNativeDashboardsInlineSource source =
          ImportNativeDashboardsInlineSource.newBuilder().build();
      client.importNativeDashboards(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
