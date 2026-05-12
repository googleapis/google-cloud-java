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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonNativeDashboardServiceStub;
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
public class NativeDashboardServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static NativeDashboardServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonNativeDashboardServiceStub.getMethodDescriptors(),
            NativeDashboardServiceSettings.getDefaultEndpoint());
    NativeDashboardServiceSettings settings =
        NativeDashboardServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                NativeDashboardServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NativeDashboardServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.createNativeDashboard(parent, nativeDashboard);
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
  public void createNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.createNativeDashboard(parent, nativeDashboard);
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
  public void createNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    NativeDashboard actualResponse = client.getNativeDashboard(name);
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
  public void getNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";

    NativeDashboard actualResponse = client.getNativeDashboard(name);
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
  public void getNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListNativeDashboardsPagedResponse pagedListResponse = client.listNativeDashboards(parent);

    List<NativeDashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNativeDashboardsList().get(0), resources.get(0));

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
  public void listNativeDashboardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListNativeDashboardsPagedResponse pagedListResponse = client.listNativeDashboards(parent);

    List<NativeDashboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNativeDashboardsList().get(0), resources.get(0));

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
  public void listNativeDashboardsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    NativeDashboard nativeDashboard =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    NativeDashboard actualResponse = client.updateNativeDashboard(nativeDashboard, updateMask);
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
  public void updateNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NativeDashboard nativeDashboard =
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.duplicateNativeDashboard(name, nativeDashboard);
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
  public void duplicateNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
    NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();

    NativeDashboard actualResponse = client.duplicateNativeDashboard(name, nativeDashboard);
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
  public void duplicateNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    client.deleteNativeDashboard(name);

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
  public void deleteNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";

    client.deleteNativeDashboard(name);

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
  public void deleteNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();

    AddChartResponse actualResponse = client.addChart(name, dashboardQuery, dashboardChart);
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
  public void addChartExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();

    AddChartResponse actualResponse = client.addChart(name, dashboardQuery, dashboardChart);
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
  public void addChartExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    NativeDashboard actualResponse = client.removeChart(name);
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
  public void removeChartExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";

    NativeDashboard actualResponse = client.removeChart(name);
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
  public void removeChartExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();
    FieldMask editMask = FieldMask.newBuilder().build();

    EditChartResponse actualResponse =
        client.editChart(name, dashboardQuery, dashboardChart, editMask);
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
  public void editChartExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
    DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
    DashboardChart dashboardChart = DashboardChart.newBuilder().build();
    FieldMask editMask = FieldMask.newBuilder().build();

    EditChartResponse actualResponse =
        client.editChart(name, dashboardQuery, dashboardChart, editMask);
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
  public void editChartExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    NativeDashboardName name =
        NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");

    DuplicateChartResponse actualResponse = client.duplicateChart(name);
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
  public void duplicateChartExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";

    DuplicateChartResponse actualResponse = client.duplicateChart(name);
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
  public void duplicateChartExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4644/locations/location-4644/instances/instance-4644/nativeDashboards/nativeDashboard-4644";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    List<String> names = new ArrayList<>();

    ExportNativeDashboardsResponse actualResponse = client.exportNativeDashboards(parent, names);
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
  public void exportNativeDashboardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    List<String> names = new ArrayList<>();

    ExportNativeDashboardsResponse actualResponse = client.exportNativeDashboards(parent, names);
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
  public void exportNativeDashboardsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ImportNativeDashboardsInlineSource source =
        ImportNativeDashboardsInlineSource.newBuilder().build();

    ImportNativeDashboardsResponse actualResponse = client.importNativeDashboards(parent, source);
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
  public void importNativeDashboardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    ImportNativeDashboardsInlineSource source =
        ImportNativeDashboardsInlineSource.newBuilder().build();

    ImportNativeDashboardsResponse actualResponse = client.importNativeDashboards(parent, source);
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
  public void importNativeDashboardsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      ImportNativeDashboardsInlineSource source =
          ImportNativeDashboardsInlineSource.newBuilder().build();
      client.importNativeDashboards(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
