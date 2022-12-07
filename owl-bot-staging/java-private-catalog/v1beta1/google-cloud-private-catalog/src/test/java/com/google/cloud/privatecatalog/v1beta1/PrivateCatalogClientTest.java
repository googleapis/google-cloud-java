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

package com.google.cloud.privatecatalog.v1beta1;

import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchCatalogsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchProductsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchVersionsPagedResponse;

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
public class PrivateCatalogClientTest {
  private static MockPrivateCatalog mockPrivateCatalog;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PrivateCatalogClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPrivateCatalog = new MockPrivateCatalog();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPrivateCatalog));
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
    PrivateCatalogSettings settings =
        PrivateCatalogSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrivateCatalogClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    SearchCatalogsResponse expectedResponse =
        SearchCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockPrivateCatalog.addResponse(expectedResponse);

    SearchCatalogsRequest request =
        SearchCatalogsRequest.newBuilder()
            .setResource("resource-341064690")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchCatalogsPagedResponse pagedListResponse = client.searchCatalogs(request);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivateCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCatalogsRequest actualRequest = ((SearchCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivateCatalog.addException(exception);

    try {
      SearchCatalogsRequest request =
          SearchCatalogsRequest.newBuilder()
              .setResource("resource-341064690")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchCatalogs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    SearchProductsResponse expectedResponse =
        SearchProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockPrivateCatalog.addResponse(expectedResponse);

    SearchProductsRequest request =
        SearchProductsRequest.newBuilder()
            .setResource("resource-341064690")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchProductsPagedResponse pagedListResponse = client.searchProducts(request);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivateCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProductsRequest actualRequest = ((SearchProductsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivateCatalog.addException(exception);

    try {
      SearchProductsRequest request =
          SearchProductsRequest.newBuilder()
              .setResource("resource-341064690")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchProducts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    SearchVersionsResponse expectedResponse =
        SearchVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockPrivateCatalog.addResponse(expectedResponse);

    SearchVersionsRequest request =
        SearchVersionsRequest.newBuilder()
            .setResource("resource-341064690")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchVersionsPagedResponse pagedListResponse = client.searchVersions(request);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivateCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchVersionsRequest actualRequest = ((SearchVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivateCatalog.addException(exception);

    try {
      SearchVersionsRequest request =
          SearchVersionsRequest.newBuilder()
              .setResource("resource-341064690")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchVersions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
