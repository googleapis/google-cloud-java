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

package com.google.cloud.vision.v1p4beta1;

import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ProductSearchClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockProductSearch mockProductSearch;
  private ProductSearchClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockProductSearch = new MockProductSearch();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProductSearch));
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
    ProductSearchSettings settings =
        ProductSearchSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductSearchClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createProductSetTest() throws Exception {
    ProductSet expectedResponse =
        ProductSet.newBuilder()
            .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setIndexTime(Timestamp.newBuilder().build())
            .setIndexError(Status.newBuilder().build())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ProductSet productSet = ProductSet.newBuilder().build();
    String productSetId = "productSetId1003042158";

    ProductSet actualResponse = client.createProductSet(parent, productSet, productSetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductSetRequest actualRequest = ((CreateProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(productSet, actualRequest.getProductSet());
    Assert.assertEquals(productSetId, actualRequest.getProductSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProductSet productSet = ProductSet.newBuilder().build();
      String productSetId = "productSetId1003042158";
      client.createProductSet(parent, productSet, productSetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProductSetTest2() throws Exception {
    ProductSet expectedResponse =
        ProductSet.newBuilder()
            .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setIndexTime(Timestamp.newBuilder().build())
            .setIndexError(Status.newBuilder().build())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ProductSet productSet = ProductSet.newBuilder().build();
    String productSetId = "productSetId1003042158";

    ProductSet actualResponse = client.createProductSet(parent, productSet, productSetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProductSetRequest actualRequest = ((CreateProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(productSet, actualRequest.getProductSet());
    Assert.assertEquals(productSetId, actualRequest.getProductSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      ProductSet productSet = ProductSet.newBuilder().build();
      String productSetId = "productSetId1003042158";
      client.createProductSet(parent, productSet, productSetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductSetsTest() throws Exception {
    ProductSet responsesElement = ProductSet.newBuilder().build();
    ListProductSetsResponse expectedResponse =
        ListProductSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductSets(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProductSetsPagedResponse pagedListResponse = client.listProductSets(parent);

    List<ProductSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductSetsRequest actualRequest = ((ListProductSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProductSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductSetsTest2() throws Exception {
    ProductSet responsesElement = ProductSet.newBuilder().build();
    ListProductSetsResponse expectedResponse =
        ListProductSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductSets(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProductSetsPagedResponse pagedListResponse = client.listProductSets(parent);

    List<ProductSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductSetsRequest actualRequest = ((ListProductSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProductSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductSetTest() throws Exception {
    ProductSet expectedResponse =
        ProductSet.newBuilder()
            .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setIndexTime(Timestamp.newBuilder().build())
            .setIndexError(Status.newBuilder().build())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    ProductSet actualResponse = client.getProductSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductSetRequest actualRequest = ((GetProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      client.getProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductSetTest2() throws Exception {
    ProductSet expectedResponse =
        ProductSet.newBuilder()
            .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setIndexTime(Timestamp.newBuilder().build())
            .setIndexError(Status.newBuilder().build())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    ProductSet actualResponse = client.getProductSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductSetRequest actualRequest = ((GetProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.getProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProductSetTest() throws Exception {
    ProductSet expectedResponse =
        ProductSet.newBuilder()
            .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setIndexTime(Timestamp.newBuilder().build())
            .setIndexError(Status.newBuilder().build())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSet productSet = ProductSet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ProductSet actualResponse = client.updateProductSet(productSet, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProductSetRequest actualRequest = ((UpdateProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(productSet, actualRequest.getProductSet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSet productSet = ProductSet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProductSet(productSet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    client.deleteProductSet(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductSetRequest actualRequest = ((DeleteProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      client.deleteProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProductSet(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductSetRequest actualRequest = ((DeleteProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProductCategory("productCategory197299981")
            .addAllProductLabels(new ArrayList<Product.KeyValue>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProductCategory("productCategory197299981")
            .addAllProductLabels(new ArrayList<Product.KeyValue>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

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
  public void listProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProductCategory("productCategory197299981")
            .addAllProductLabels(new ArrayList<Product.KeyValue>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
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
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProductCategory("productCategory197299981")
            .addAllProductLabels(new ArrayList<Product.KeyValue>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    Product actualResponse = client.getProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

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
            .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setProductCategory("productCategory197299981")
            .addAllProductLabels(new ArrayList<Product.KeyValue>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    Product product = Product.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Product actualResponse = client.updateProduct(product, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

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
    mockProductSearch.addResponse(expectedResponse);

    ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.deleteProduct(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProduct(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
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
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceImageTest() throws Exception {
    ReferenceImage expectedResponse =
        ReferenceImage.newBuilder()
            .setName(
                ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllBoundingPolys(new ArrayList<BoundingPoly>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
    ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
    String referenceImageId = "referenceImageId1224107531";

    ReferenceImage actualResponse =
        client.createReferenceImage(parent, referenceImage, referenceImageId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReferenceImageRequest actualRequest =
        ((CreateReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(referenceImage, actualRequest.getReferenceImage());
    Assert.assertEquals(referenceImageId, actualRequest.getReferenceImageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
      String referenceImageId = "referenceImageId1224107531";
      client.createReferenceImage(parent, referenceImage, referenceImageId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceImageTest2() throws Exception {
    ReferenceImage expectedResponse =
        ReferenceImage.newBuilder()
            .setName(
                ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllBoundingPolys(new ArrayList<BoundingPoly>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
    String referenceImageId = "referenceImageId1224107531";

    ReferenceImage actualResponse =
        client.createReferenceImage(parent, referenceImage, referenceImageId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReferenceImageRequest actualRequest =
        ((CreateReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(referenceImage, actualRequest.getReferenceImage());
    Assert.assertEquals(referenceImageId, actualRequest.getReferenceImageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReferenceImageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
      String referenceImageId = "referenceImageId1224107531";
      client.createReferenceImage(parent, referenceImage, referenceImageId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReferenceImageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ReferenceImageName name =
        ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

    client.deleteReferenceImage(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReferenceImageRequest actualRequest =
        ((DeleteReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ReferenceImageName name =
          ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
      client.deleteReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReferenceImageTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteReferenceImage(name);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReferenceImageRequest actualRequest =
        ((DeleteReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReferenceImageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceImagesTest() throws Exception {
    ReferenceImage responsesElement = ReferenceImage.newBuilder().build();
    ListReferenceImagesResponse expectedResponse =
        ListReferenceImagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceImages(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    ListReferenceImagesPagedResponse pagedListResponse = client.listReferenceImages(parent);

    List<ReferenceImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceImagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReferenceImagesRequest actualRequest = ((ListReferenceImagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReferenceImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.listReferenceImages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceImagesTest2() throws Exception {
    ReferenceImage responsesElement = ReferenceImage.newBuilder().build();
    ListReferenceImagesResponse expectedResponse =
        ListReferenceImagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceImages(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReferenceImagesPagedResponse pagedListResponse = client.listReferenceImages(parent);

    List<ReferenceImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceImagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReferenceImagesRequest actualRequest = ((ListReferenceImagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReferenceImagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReferenceImages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReferenceImageTest() throws Exception {
    ReferenceImage expectedResponse =
        ReferenceImage.newBuilder()
            .setName(
                ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllBoundingPolys(new ArrayList<BoundingPoly>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ReferenceImageName name =
        ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");

    ReferenceImage actualResponse = client.getReferenceImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReferenceImageRequest actualRequest = ((GetReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReferenceImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ReferenceImageName name =
          ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
      client.getReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReferenceImageTest2() throws Exception {
    ReferenceImage expectedResponse =
        ReferenceImage.newBuilder()
            .setName(
                ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllBoundingPolys(new ArrayList<BoundingPoly>())
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    ReferenceImage actualResponse = client.getReferenceImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReferenceImageRequest actualRequest = ((GetReferenceImageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getReferenceImageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.getReferenceImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addProductToProductSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.addProductToProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddProductToProductSetRequest actualRequest =
        ((AddProductToProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(product.toString(), actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addProductToProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.addProductToProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addProductToProductSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    String product = "product-309474065";

    client.addProductToProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddProductToProductSetRequest actualRequest =
        ((AddProductToProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addProductToProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      String product = "product-309474065";
      client.addProductToProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addProductToProductSetTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";
    ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.addProductToProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddProductToProductSetRequest actualRequest =
        ((AddProductToProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(product.toString(), actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addProductToProductSetExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.addProductToProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addProductToProductSetTest4() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";
    String product = "product-309474065";

    client.addProductToProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddProductToProductSetRequest actualRequest =
        ((AddProductToProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addProductToProductSetExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      String product = "product-309474065";
      client.addProductToProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeProductFromProductSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.removeProductFromProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductFromProductSetRequest actualRequest =
        ((RemoveProductFromProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(product.toString(), actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeProductFromProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.removeProductFromProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeProductFromProductSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
    String product = "product-309474065";

    client.removeProductFromProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductFromProductSetRequest actualRequest =
        ((RemoveProductFromProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeProductFromProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      String product = "product-309474065";
      client.removeProductFromProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeProductFromProductSetTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";
    ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");

    client.removeProductFromProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductFromProductSetRequest actualRequest =
        ((RemoveProductFromProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(product.toString(), actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeProductFromProductSetExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
      client.removeProductFromProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeProductFromProductSetTest4() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";
    String product = "product-309474065";

    client.removeProductFromProductSet(name, product);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveProductFromProductSetRequest actualRequest =
        ((RemoveProductFromProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(product, actualRequest.getProduct());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeProductFromProductSetExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      String product = "product-309474065";
      client.removeProductFromProductSet(name, product);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsInProductSetTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsInProductSetResponse expectedResponse =
        ListProductsInProductSetResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");

    ListProductsInProductSetPagedResponse pagedListResponse = client.listProductsInProductSet(name);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsInProductSetRequest actualRequest =
        ((ListProductsInProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsInProductSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      client.listProductsInProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsInProductSetTest2() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsInProductSetResponse expectedResponse =
        ListProductsInProductSetResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockProductSearch.addResponse(expectedResponse);

    String name = "name3373707";

    ListProductsInProductSetPagedResponse pagedListResponse = client.listProductsInProductSet(name);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsInProductSetRequest actualRequest =
        ((ListProductsInProductSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsInProductSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String name = "name3373707";
      client.listProductsInProductSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importProductSetsTest() throws Exception {
    ImportProductSetsResponse expectedResponse =
        ImportProductSetsResponse.newBuilder()
            .addAllReferenceImages(new ArrayList<ReferenceImage>())
            .addAllStatuses(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importProductSetsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductSearch.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();

    ImportProductSetsResponse actualResponse =
        client.importProductSetsAsync(parent, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportProductSetsRequest actualRequest = ((ImportProductSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importProductSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
      client.importProductSetsAsync(parent, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importProductSetsTest2() throws Exception {
    ImportProductSetsResponse expectedResponse =
        ImportProductSetsResponse.newBuilder()
            .addAllReferenceImages(new ArrayList<ReferenceImage>())
            .addAllStatuses(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importProductSetsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductSearch.addResponse(resultOperation);

    String parent = "parent-995424086";
    ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();

    ImportProductSetsResponse actualResponse =
        client.importProductSetsAsync(parent, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportProductSetsRequest actualRequest = ((ImportProductSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importProductSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
      client.importProductSetsAsync(parent, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeProductsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeProductsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductSearch.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    client.purgeProductsAsync(parent).get();

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeProductsRequest actualRequest = ((PurgeProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.purgeProductsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeProductsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeProductsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockProductSearch.addResponse(resultOperation);

    String parent = "parent-995424086";

    client.purgeProductsAsync(parent).get();

    List<AbstractMessage> actualRequests = mockProductSearch.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeProductsRequest actualRequest = ((PurgeProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeProductsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductSearch.addException(exception);

    try {
      String parent = "parent-995424086";
      client.purgeProductsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
