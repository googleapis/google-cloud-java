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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.stub.HttpJsonProductReviewsServiceStub;
import com.google.shopping.type.CustomAttribute;
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
public class ProductReviewsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ProductReviewsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProductReviewsServiceStub.getMethodDescriptors(),
            ProductReviewsServiceSettings.getDefaultEndpoint());
    ProductReviewsServiceSettings settings =
        ProductReviewsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ProductReviewsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductReviewsServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");

    ProductReview actualResponse = client.getProductReview(name);
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
  public void getProductReviewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-6554/productReviews/productReview-6554";

    ProductReview actualResponse = client.getProductReview(name);
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
  public void getProductReviewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-6554/productReviews/productReview-6554";
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListProductReviewsPagedResponse pagedListResponse = client.listProductReviews(parent);

    List<ProductReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductReviewsList().get(0), resources.get(0));

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
  public void listProductReviewsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListProductReviewsPagedResponse pagedListResponse = client.listProductReviews(parent);

    List<ProductReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductReviewsList().get(0), resources.get(0));

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
  public void listProductReviewsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
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
    mockService.addResponse(expectedResponse);

    InsertProductReviewRequest request =
        InsertProductReviewRequest.newBuilder()
            .setParent("accounts/account-4811")
            .setProductReview(ProductReview.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    ProductReview actualResponse = client.insertProductReview(request);
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
  public void insertProductReviewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertProductReviewRequest request =
          InsertProductReviewRequest.newBuilder()
              .setParent("accounts/account-4811")
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
    mockService.addResponse(expectedResponse);

    ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");

    client.deleteProductReview(name);

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
  public void deleteProductReviewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-6554/productReviews/productReview-6554";

    client.deleteProductReview(name);

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
  public void deleteProductReviewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-6554/productReviews/productReview-6554";
      client.deleteProductReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
