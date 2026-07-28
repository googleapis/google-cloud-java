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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonDashboardChartServiceStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DashboardChartServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DashboardChartServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDashboardChartServiceStub.getMethodDescriptors(),
            DashboardChartServiceSettings.getDefaultEndpoint());
    DashboardChartServiceSettings settings =
        DashboardChartServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DashboardChartServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardChartServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    DashboardChartName name =
        DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");

    DashboardChart actualResponse = client.getDashboardChart(name);
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
  public void getDashboardChartExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7735/locations/location-7735/instances/instance-7735/dashboardCharts/dashboardChart-7735";

    DashboardChart actualResponse = client.getDashboardChart(name);
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
  public void getDashboardChartExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7735/locations/location-7735/instances/instance-7735/dashboardCharts/dashboardChart-7735";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> names = new ArrayList<>();

    BatchGetDashboardChartsResponse actualResponse = client.batchGetDashboardCharts(parent, names);
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
  public void batchGetDashboardChartsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    List<String> names = new ArrayList<>();

    BatchGetDashboardChartsResponse actualResponse = client.batchGetDashboardCharts(parent, names);
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
  public void batchGetDashboardChartsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      List<String> names = new ArrayList<>();
      client.batchGetDashboardCharts(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
