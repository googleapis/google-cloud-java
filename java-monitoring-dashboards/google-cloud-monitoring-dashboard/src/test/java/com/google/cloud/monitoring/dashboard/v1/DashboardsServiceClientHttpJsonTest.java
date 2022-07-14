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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.monitoring.dashboard.v1.stub.HttpJsonDashboardsServiceStub;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DashboardsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DashboardsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDashboardsServiceStub.getMethodDescriptors(),
            DashboardsServiceSettings.getDefaultEndpoint());
    DashboardsServiceSettings settings =
        DashboardsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DashboardsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DashboardsServiceClient.create(settings);
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
  public void createDashboardTest() throws Exception {
    Dashboard expectedResponse =
        Dashboard.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .addAllDashboardFilters(new ArrayList<DashboardFilter>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CreateDashboardRequest request =
        CreateDashboardRequest.newBuilder()
            .setParent("projects/project-2353")
            .setDashboard(Dashboard.newBuilder().build())
            .setValidateOnly(true)
            .build();

    Dashboard actualResponse = client.createDashboard(request);
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
  public void createDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateDashboardRequest request =
          CreateDashboardRequest.newBuilder()
              .setParent("projects/project-2353")
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
    mockService.addResponse(expectedResponse);

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
  public void listDashboardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    GetDashboardRequest request =
        GetDashboardRequest.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .build();

    Dashboard actualResponse = client.getDashboard(request);
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
  public void getDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    DeleteDashboardRequest request =
        DeleteDashboardRequest.newBuilder()
            .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
            .build();

    client.deleteDashboard(request);

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
  public void deleteDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    UpdateDashboardRequest request =
        UpdateDashboardRequest.newBuilder()
            .setDashboard(
                Dashboard.newBuilder()
                    .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
                    .setDisplayName("displayName1714148973")
                    .setEtag("etag3123477")
                    .addAllDashboardFilters(new ArrayList<DashboardFilter>())
                    .putAllLabels(new HashMap<String, String>())
                    .build())
            .setValidateOnly(true)
            .build();

    Dashboard actualResponse = client.updateDashboard(request);
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
  public void updateDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateDashboardRequest request =
          UpdateDashboardRequest.newBuilder()
              .setDashboard(
                  Dashboard.newBuilder()
                      .setName(DashboardName.of("[PROJECT]", "[DASHBOARD]").toString())
                      .setDisplayName("displayName1714148973")
                      .setEtag("etag3123477")
                      .addAllDashboardFilters(new ArrayList<DashboardFilter>())
                      .putAllLabels(new HashMap<String, String>())
                      .build())
              .setValidateOnly(true)
              .build();
      client.updateDashboard(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
