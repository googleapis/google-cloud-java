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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class DashboardChartServiceClientTest {
  private static MockDashboardChartService mockDashboardChartService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DashboardChartServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDashboardChartService = new MockDashboardChartService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDashboardChartService));
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
    DashboardChartServiceSettings settings =
        DashboardChartServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardChartServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDashboardChartTest() throws Exception {
    DashboardChart expectedResponse =
        DashboardChart.newBuilder()
            .setName(
                DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setNativeDashboard(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setTileType(TileType.forNumber(0))
            .setChartDatasource(DashboardChart.ChartDatasource.newBuilder().build())
            .setVisualization(DashboardChart.Visualization.newBuilder().build())
            .setEtag("etag3123477")
            .setDrillDownConfig(DashboardChart.DrillDownConfig.newBuilder().build())
            .addAllTokens(new ArrayList<String>())
            .build();
    mockDashboardChartService.addResponse(expectedResponse);

    DashboardChartName name =
        DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");

    DashboardChart actualResponse = client.getDashboardChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardChartService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardChartRequest actualRequest = ((GetDashboardChartRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardChartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardChartService.addException(exception);

    try {
      DashboardChartName name =
          DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");
      client.getDashboardChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDashboardChartTest2() throws Exception {
    DashboardChart expectedResponse =
        DashboardChart.newBuilder()
            .setName(
                DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setNativeDashboard(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .setTileType(TileType.forNumber(0))
            .setChartDatasource(DashboardChart.ChartDatasource.newBuilder().build())
            .setVisualization(DashboardChart.Visualization.newBuilder().build())
            .setEtag("etag3123477")
            .setDrillDownConfig(DashboardChart.DrillDownConfig.newBuilder().build())
            .addAllTokens(new ArrayList<String>())
            .build();
    mockDashboardChartService.addResponse(expectedResponse);

    String name = "name3373707";

    DashboardChart actualResponse = client.getDashboardChart(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardChartService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDashboardChartRequest actualRequest = ((GetDashboardChartRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDashboardChartExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardChartService.addException(exception);

    try {
      String name = "name3373707";
      client.getDashboardChart(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetDashboardChartsTest() throws Exception {
    BatchGetDashboardChartsResponse expectedResponse =
        BatchGetDashboardChartsResponse.newBuilder()
            .addAllDashboardCharts(new ArrayList<DashboardChart>())
            .build();
    mockDashboardChartService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> names = new ArrayList<>();

    BatchGetDashboardChartsResponse actualResponse = client.batchGetDashboardCharts(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardChartService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetDashboardChartsRequest actualRequest =
        ((BatchGetDashboardChartsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetDashboardChartsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardChartService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      List<String> names = new ArrayList<>();
      client.batchGetDashboardCharts(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetDashboardChartsTest2() throws Exception {
    BatchGetDashboardChartsResponse expectedResponse =
        BatchGetDashboardChartsResponse.newBuilder()
            .addAllDashboardCharts(new ArrayList<DashboardChart>())
            .build();
    mockDashboardChartService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    BatchGetDashboardChartsResponse actualResponse = client.batchGetDashboardCharts(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDashboardChartService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetDashboardChartsRequest actualRequest =
        ((BatchGetDashboardChartsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetDashboardChartsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDashboardChartService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.batchGetDashboardCharts(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
