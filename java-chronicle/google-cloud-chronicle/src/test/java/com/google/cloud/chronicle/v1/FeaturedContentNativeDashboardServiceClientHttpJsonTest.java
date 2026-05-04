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

import static com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardServiceClient.ListFeaturedContentNativeDashboardsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonFeaturedContentNativeDashboardServiceStub;
import com.google.common.collect.Lists;
import java.io.IOException;
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
public class FeaturedContentNativeDashboardServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FeaturedContentNativeDashboardServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFeaturedContentNativeDashboardServiceStub.getMethodDescriptors(),
            FeaturedContentNativeDashboardServiceSettings.getDefaultEndpoint());
    FeaturedContentNativeDashboardServiceSettings settings =
        FeaturedContentNativeDashboardServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FeaturedContentNativeDashboardServiceSettings
                    .defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeaturedContentNativeDashboardServiceClient.create(settings);
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
  public void getFeaturedContentNativeDashboardTest() throws Exception {
    FeaturedContentNativeDashboard expectedResponse =
        FeaturedContentNativeDashboard.newBuilder()
            .setName(
                FeaturedContentNativeDashboardName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[INSTANCE]",
                        "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
                    .toString())
            .setContentMetadata(FeaturedContentMetadata.newBuilder().build())
            .setDashboardContent(NativeDashboardWithChartsAndQueries.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FeaturedContentNativeDashboardName name =
        FeaturedContentNativeDashboardName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");

    FeaturedContentNativeDashboard actualResponse = client.getFeaturedContentNativeDashboard(name);
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
  public void getFeaturedContentNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeaturedContentNativeDashboardName name =
          FeaturedContentNativeDashboardName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
      client.getFeaturedContentNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeaturedContentNativeDashboardTest2() throws Exception {
    FeaturedContentNativeDashboard expectedResponse =
        FeaturedContentNativeDashboard.newBuilder()
            .setName(
                FeaturedContentNativeDashboardName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[INSTANCE]",
                        "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
                    .toString())
            .setContentMetadata(FeaturedContentMetadata.newBuilder().build())
            .setDashboardContent(NativeDashboardWithChartsAndQueries.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5212/locations/location-5212/instances/instance-5212/contentHub/featuredContentNativeDashboards/featuredContentNativeDashboard-5212";

    FeaturedContentNativeDashboard actualResponse = client.getFeaturedContentNativeDashboard(name);
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
  public void getFeaturedContentNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5212/locations/location-5212/instances/instance-5212/contentHub/featuredContentNativeDashboards/featuredContentNativeDashboard-5212";
      client.getFeaturedContentNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturedContentNativeDashboardsTest() throws Exception {
    FeaturedContentNativeDashboard responsesElement =
        FeaturedContentNativeDashboard.newBuilder().build();
    ListFeaturedContentNativeDashboardsResponse expectedResponse =
        ListFeaturedContentNativeDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeaturedContentNativeDashboards(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ContentHubName parent = ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFeaturedContentNativeDashboardsPagedResponse pagedListResponse =
        client.listFeaturedContentNativeDashboards(parent);

    List<FeaturedContentNativeDashboard> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFeaturedContentNativeDashboardsList().get(0), resources.get(0));

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
  public void listFeaturedContentNativeDashboardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ContentHubName parent = ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFeaturedContentNativeDashboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturedContentNativeDashboardsTest2() throws Exception {
    FeaturedContentNativeDashboard responsesElement =
        FeaturedContentNativeDashboard.newBuilder().build();
    ListFeaturedContentNativeDashboardsResponse expectedResponse =
        ListFeaturedContentNativeDashboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeaturedContentNativeDashboards(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-152/locations/location-152/instances/instance-152/contentHub";

    ListFeaturedContentNativeDashboardsPagedResponse pagedListResponse =
        client.listFeaturedContentNativeDashboards(parent);

    List<FeaturedContentNativeDashboard> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFeaturedContentNativeDashboardsList().get(0), resources.get(0));

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
  public void listFeaturedContentNativeDashboardsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-152/locations/location-152/instances/instance-152/contentHub";
      client.listFeaturedContentNativeDashboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installFeaturedContentNativeDashboardTest() throws Exception {
    InstallFeaturedContentNativeDashboardResponse expectedResponse =
        InstallFeaturedContentNativeDashboardResponse.newBuilder()
            .setNativeDashboard(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    FeaturedContentNativeDashboardName name =
        FeaturedContentNativeDashboardName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");

    InstallFeaturedContentNativeDashboardResponse actualResponse =
        client.installFeaturedContentNativeDashboard(name);
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
  public void installFeaturedContentNativeDashboardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeaturedContentNativeDashboardName name =
          FeaturedContentNativeDashboardName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
      client.installFeaturedContentNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installFeaturedContentNativeDashboardTest2() throws Exception {
    InstallFeaturedContentNativeDashboardResponse expectedResponse =
        InstallFeaturedContentNativeDashboardResponse.newBuilder()
            .setNativeDashboard(
                NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5212/locations/location-5212/instances/instance-5212/contentHub/featuredContentNativeDashboards/featuredContentNativeDashboard-5212";

    InstallFeaturedContentNativeDashboardResponse actualResponse =
        client.installFeaturedContentNativeDashboard(name);
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
  public void installFeaturedContentNativeDashboardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5212/locations/location-5212/instances/instance-5212/contentHub/featuredContentNativeDashboards/featuredContentNativeDashboard-5212";
      client.installFeaturedContentNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
