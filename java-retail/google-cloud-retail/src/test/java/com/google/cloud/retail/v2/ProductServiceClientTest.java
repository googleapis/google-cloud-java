/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.retail.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ProductServiceClientTest {
  private static MockProductService mockProductService;
  private static MockServiceHelper mockServiceHelper;
  private ProductServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockProductService = new MockProductService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProductService));
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
    ProductServiceSettings settings =
        ProductServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .build();
    mockProductService.addResponse(expectedResponse);

    BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductRequest actualRequest = ((CreateProductRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertEquals(productId, actualRequest.getProductId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
      Product product = Product.newBuilder().build();
      String productId = "productId-1051830678";
      client.createProduct(parent, product, productId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProductTest2() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .build();
    mockProductService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductRequest actualRequest = ((CreateProductRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertEquals(productId, actualRequest.getProductId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      String parent = "parent-995424086";
      Product product = Product.newBuilder().build();
      String productId = "productId-1051830678";
      client.createProduct(parent, product, productId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .build();
    mockProductService.addResponse(expectedResponse);

    ProductName name =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
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
    mockProductService.addException(exception);

    try {
      ProductName name =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
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
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .build();
    mockProductService.addResponse(expectedResponse);

    String name = "name3373707";

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
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
    mockProductService.addException(exception);

    try {
      String name = "name3373707";
      client.getProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .build();
    mockProductService.addResponse(expectedResponse);

    Product product = Product.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Product actualResponse = client.updateProduct(product, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProductRequest actualRequest = ((UpdateProductRequest) actualRequests.get(0));

    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      Product product = Product.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProduct(product, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductService.addResponse(expectedResponse);

    ProductName name =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    client.deleteProduct(name);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductRequest actualRequest = ((DeleteProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      ProductName name =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProduct(name);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductRequest actualRequest = ((DeleteProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importProductsTest() throws Exception {
    ImportProductsResponse expectedResponse =
        ImportProductsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importProductsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductService.addResponse(resultOperation);

    ImportProductsRequest request =
        ImportProductsRequest.newBuilder()
            .setParent("parent-995424086")
            .setInputConfig(ProductInputConfig.newBuilder().build())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    ImportProductsResponse actualResponse = client.importProductsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportProductsRequest actualRequest = ((ImportProductsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInputConfig(), actualRequest.getInputConfig());
    Assert.assertEquals(request.getErrorsConfig(), actualRequest.getErrorsConfig());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductService.addException(exception);

    try {
      ImportProductsRequest request =
          ImportProductsRequest.newBuilder()
              .setParent("parent-995424086")
              .setInputConfig(ProductInputConfig.newBuilder().build())
              .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.importProductsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
