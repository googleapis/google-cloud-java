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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class FeaturedContentNativeDashboardServiceClientTest {
  private static MockFeaturedContentNativeDashboardService
      mockFeaturedContentNativeDashboardService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FeaturedContentNativeDashboardServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFeaturedContentNativeDashboardService = new MockFeaturedContentNativeDashboardService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFeaturedContentNativeDashboardService));
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
    FeaturedContentNativeDashboardServiceSettings settings =
        FeaturedContentNativeDashboardServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeaturedContentNativeDashboardServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    FeaturedContentNativeDashboardName name =
        FeaturedContentNativeDashboardName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");

    FeaturedContentNativeDashboard actualResponse = client.getFeaturedContentNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeaturedContentNativeDashboardRequest actualRequest =
        ((GetFeaturedContentNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeaturedContentNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    FeaturedContentNativeDashboard actualResponse = client.getFeaturedContentNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeaturedContentNativeDashboardRequest actualRequest =
        ((GetFeaturedContentNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeaturedContentNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    ContentHubName parent = ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFeaturedContentNativeDashboardsPagedResponse pagedListResponse =
        client.listFeaturedContentNativeDashboards(parent);

    List<FeaturedContentNativeDashboard> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFeaturedContentNativeDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeaturedContentNativeDashboardsRequest actualRequest =
        ((ListFeaturedContentNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeaturedContentNativeDashboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeaturedContentNativeDashboardsPagedResponse pagedListResponse =
        client.listFeaturedContentNativeDashboards(parent);

    List<FeaturedContentNativeDashboard> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFeaturedContentNativeDashboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeaturedContentNativeDashboardsRequest actualRequest =
        ((ListFeaturedContentNativeDashboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeaturedContentNativeDashboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    FeaturedContentNativeDashboardName name =
        FeaturedContentNativeDashboardName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");

    InstallFeaturedContentNativeDashboardResponse actualResponse =
        client.installFeaturedContentNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstallFeaturedContentNativeDashboardRequest actualRequest =
        ((InstallFeaturedContentNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void installFeaturedContentNativeDashboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

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
    mockFeaturedContentNativeDashboardService.addResponse(expectedResponse);

    String name = "name3373707";

    InstallFeaturedContentNativeDashboardResponse actualResponse =
        client.installFeaturedContentNativeDashboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeaturedContentNativeDashboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstallFeaturedContentNativeDashboardRequest actualRequest =
        ((InstallFeaturedContentNativeDashboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void installFeaturedContentNativeDashboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeaturedContentNativeDashboardService.addException(exception);

    try {
      String name = "name3373707";
      client.installFeaturedContentNativeDashboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
