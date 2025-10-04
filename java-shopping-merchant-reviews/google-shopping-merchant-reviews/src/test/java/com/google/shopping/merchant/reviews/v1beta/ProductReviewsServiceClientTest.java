/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.reviews.v1beta;

import static com.google.shopping.merchant.reviews.v1beta.ProductReviewsServiceClient.ListProductReviewsPagedResponse;

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
import com.google.shopping.type.CustomAttribute;
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
public class ProductReviewsServiceClientTest {
  private static MockProductReviewsService mockProductReviewsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProductReviewsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProductReviewsService = new MockProductReviewsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockProductReviewsService));
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
    ProductReviewsServiceSettings settings =
        ProductReviewsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductReviewsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProductReviewTest() throws Exception {
    ProductReview expectedResponse =
        ProductReview.newBuilder()
            .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
            .setProductReviewId("productReviewId-114402142")
            .setProductReviewAttributes(ProductReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setProductReviewStatus(ProductReviewStatus.newBuilder().build())
            .build();
    mockProductReviewsService.addResponse(expectedResponse);

    ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");

    ProductReview actualResponse = client.getProductReview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductReviewRequest actualRequest = ((GetProductReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
      client.getProductReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductReviewTest2() throws Exception {
    ProductReview expectedResponse =
        ProductReview.newBuilder()
            .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
            .setProductReviewId("productReviewId-114402142")
            .setProductReviewAttributes(ProductReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setProductReviewStatus(ProductReviewStatus.newBuilder().build())
            .build();
    mockProductReviewsService.addResponse(expectedResponse);

    String name = "name3373707";

    ProductReview actualResponse = client.getProductReview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductReviewRequest actualRequest = ((GetProductReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductReviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      String name = "name3373707";
      client.getProductReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductReviewsTest() throws Exception {
    ProductReview responsesElement = ProductReview.newBuilder().build();
    ListProductReviewsResponse expectedResponse =
        ListProductReviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductReviews(Arrays.asList(responsesElement))
            .build();
    mockProductReviewsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListProductReviewsPagedResponse pagedListResponse = client.listProductReviews(parent);

    List<ProductReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductReviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductReviewsRequest actualRequest = ((ListProductReviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductReviewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listProductReviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductReviewsTest2() throws Exception {
    ProductReview responsesElement = ProductReview.newBuilder().build();
    ListProductReviewsResponse expectedResponse =
        ListProductReviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductReviews(Arrays.asList(responsesElement))
            .build();
    mockProductReviewsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProductReviewsPagedResponse pagedListResponse = client.listProductReviews(parent);

    List<ProductReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductReviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductReviewsRequest actualRequest = ((ListProductReviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductReviewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProductReviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertProductReviewTest() throws Exception {
    ProductReview expectedResponse =
        ProductReview.newBuilder()
            .setName(ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]").toString())
            .setProductReviewId("productReviewId-114402142")
            .setProductReviewAttributes(ProductReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setProductReviewStatus(ProductReviewStatus.newBuilder().build())
            .build();
    mockProductReviewsService.addResponse(expectedResponse);

    InsertProductReviewRequest request =
        InsertProductReviewRequest.newBuilder()
            .setParent("parent-995424086")
            .setProductReview(ProductReview.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    ProductReview actualResponse = client.insertProductReview(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertProductReviewRequest actualRequest = ((InsertProductReviewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getProductReview(), actualRequest.getProductReview());
    Assert.assertEquals(request.getDataSource(), actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertProductReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      InsertProductReviewRequest request =
          InsertProductReviewRequest.newBuilder()
              .setParent("parent-995424086")
              .setProductReview(ProductReview.newBuilder().build())
              .setDataSource("dataSource1272470629")
              .build();
      client.insertProductReview(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductReviewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductReviewsService.addResponse(expectedResponse);

    ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");

    client.deleteProductReview(name);

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductReviewRequest actualRequest = ((DeleteProductReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
      client.deleteProductReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductReviewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductReviewsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProductReview(name);

    List<AbstractMessage> actualRequests = mockProductReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductReviewRequest actualRequest = ((DeleteProductReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductReviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductReviewsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProductReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
