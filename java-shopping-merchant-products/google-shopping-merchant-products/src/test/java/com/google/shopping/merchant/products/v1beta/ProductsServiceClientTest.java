/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.products.v1beta;

import static com.google.shopping.merchant.products.v1beta.ProductsServiceClient.ListProductsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class ProductsServiceClientTest {
  private static MockProductsService mockProductsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProductsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProductsService = new MockProductsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProductsService));
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
    ProductsServiceSettings settings =
        ProductsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setOfferId("offerId-1548813161")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setDataSource("dataSource1272470629")
            .setVersionNumber(135927952)
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setProductStatus(ProductStatus.newBuilder().build())
            .build();
    mockProductsService.addResponse(expectedResponse);

    ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductRequest actualRequest = ((GetProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductsService.addException(exception);

    try {
      ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductTest2() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setOfferId("offerId-1548813161")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setDataSource("dataSource1272470629")
            .setVersionNumber(135927952)
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setProductStatus(ProductStatus.newBuilder().build())
            .build();
    mockProductsService.addResponse(expectedResponse);

    String name = "name3373707";

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductRequest actualRequest = ((GetProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductsService.addException(exception);

    try {
      String name = "name3373707";
      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockProductsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = ((ListProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsTest2() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockProductsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = ((ListProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
