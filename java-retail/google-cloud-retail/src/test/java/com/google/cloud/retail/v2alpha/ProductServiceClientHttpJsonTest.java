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

package com.google.cloud.retail.v2alpha;

import static com.google.cloud.retail.v2alpha.ProductServiceClient.ListProductsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonProductServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ProductServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ProductServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProductServiceStub.getMethodDescriptors(),
            ProductServiceSettings.getDefaultEndpoint());
    ProductServiceSettings settings =
        ProductServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ProductServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductServiceClient.create(settings);
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
  public void createProductTest() throws Exception {
    Product expectedResponse =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    mockService.addResponse(expectedResponse);

    BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
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
  public void createProductExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7087/locations/location-7087/catalogs/catalog-7087/branches/branche-7087";
    Product product = Product.newBuilder().build();
    String productId = "productId-1051830678";

    Product actualResponse = client.createProduct(parent, product, productId);
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
  public void createProductExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7087/locations/location-7087/catalogs/catalog-7087/branches/branche-7087";
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
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    mockService.addResponse(expectedResponse);

    ProductName name =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    Product actualResponse = client.getProduct(name);
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
  public void getProductExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-436/locations/location-436/catalogs/catalog-436/branches/branche-436/products/product-436";

    Product actualResponse = client.getProduct(name);
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
  public void getProductExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-436/locations/location-436/catalogs/catalog-436/branches/branche-436/products/product-436";
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
    mockService.addResponse(expectedResponse);

    BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

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
  public void listProductsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]");
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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7087/locations/location-7087/catalogs/catalog-7087/branches/branche-7087";

    ListProductsPagedResponse pagedListResponse = client.listProducts(parent);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

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
  public void listProductsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7087/locations/location-7087/catalogs/catalog-7087/branches/branche-7087";
      client.listProducts(parent);
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
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    mockService.addResponse(expectedResponse);

    Product product =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Product actualResponse = client.updateProduct(product, updateMask);
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
  public void updateProductExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Product product =
          Product.newBuilder()
              .setName(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .setId("id3355")
              .setPrimaryProductId("primaryProductId-857339256")
              .addAllCollectionMemberIds(new ArrayList<String>())
              .setGtin("gtin3183314")
              .addAllCategories(new ArrayList<String>())
              .setTitle("title110371416")
              .addAllBrands(new ArrayList<String>())
              .setDescription("description-1724546052")
              .setLanguageCode("languageCode-2092349083")
              .putAllAttributes(new HashMap<String, CustomAttribute>())
              .addAllTags(new ArrayList<String>())
              .setPriceInfo(PriceInfo.newBuilder().build())
              .setRating(Rating.newBuilder().build())
              .setAvailableTime(Timestamp.newBuilder().build())
              .setAvailableQuantity(Int32Value.newBuilder().build())
              .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
              .setUri("uri116076")
              .addAllImages(new ArrayList<Image>())
              .setAudience(Audience.newBuilder().build())
              .setColorInfo(ColorInfo.newBuilder().build())
              .addAllSizes(new ArrayList<String>())
              .addAllMaterials(new ArrayList<String>())
              .addAllPatterns(new ArrayList<String>())
              .addAllConditions(new ArrayList<String>())
              .addAllPromotions(new ArrayList<Promotion>())
              .setPublishTime(Timestamp.newBuilder().build())
              .setRetrievableFields(FieldMask.newBuilder().build())
              .addAllVariants(new ArrayList<Product>())
              .addAllLocalInventories(new ArrayList<LocalInventory>())
              .build();
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
    mockService.addResponse(expectedResponse);

    ProductName name =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    client.deleteProduct(name);

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
  public void deleteProductExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-436/locations/location-436/catalogs/catalog-436/branches/branche-436/products/product-436";

    client.deleteProduct(name);

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
  public void deleteProductExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-436/locations/location-436/catalogs/catalog-436/branches/branche-436/products/product-436";
      client.deleteProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeProductsTest() throws Exception {
    PurgeProductsResponse expectedResponse =
        PurgeProductsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeProductsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PurgeProductsRequest request =
        PurgeProductsRequest.newBuilder()
            .setParent(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    PurgeProductsResponse actualResponse = client.purgeProductsAsync(request).get();
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
  public void purgeProductsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PurgeProductsRequest request =
          PurgeProductsRequest.newBuilder()
              .setParent(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeProductsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ImportProductsRequest request =
        ImportProductsRequest.newBuilder()
            .setParent(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setRequestId("requestId693933066")
            .setInputConfig(ProductInputConfig.newBuilder().build())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .setSkipDefaultBranchProtection(true)
            .build();

    ImportProductsResponse actualResponse = client.importProductsAsync(request).get();
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
  public void importProductsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportProductsRequest request =
          ImportProductsRequest.newBuilder()
              .setParent(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setRequestId("requestId693933066")
              .setInputConfig(ProductInputConfig.newBuilder().build())
              .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
              .setSkipDefaultBranchProtection(true)
              .build();
      client.importProductsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void setInventoryTest() throws Exception {
    SetInventoryResponse expectedResponse = SetInventoryResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setInventoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Product inventory =
        Product.newBuilder()
            .setName(
                ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                    .toString())
            .setId("id3355")
            .setPrimaryProductId("primaryProductId-857339256")
            .addAllCollectionMemberIds(new ArrayList<String>())
            .setGtin("gtin3183314")
            .addAllCategories(new ArrayList<String>())
            .setTitle("title110371416")
            .addAllBrands(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setLanguageCode("languageCode-2092349083")
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .addAllTags(new ArrayList<String>())
            .setPriceInfo(PriceInfo.newBuilder().build())
            .setRating(Rating.newBuilder().build())
            .setAvailableTime(Timestamp.newBuilder().build())
            .setAvailableQuantity(Int32Value.newBuilder().build())
            .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
            .setUri("uri116076")
            .addAllImages(new ArrayList<Image>())
            .setAudience(Audience.newBuilder().build())
            .setColorInfo(ColorInfo.newBuilder().build())
            .addAllSizes(new ArrayList<String>())
            .addAllMaterials(new ArrayList<String>())
            .addAllPatterns(new ArrayList<String>())
            .addAllConditions(new ArrayList<String>())
            .addAllPromotions(new ArrayList<Promotion>())
            .setPublishTime(Timestamp.newBuilder().build())
            .setRetrievableFields(FieldMask.newBuilder().build())
            .addAllVariants(new ArrayList<Product>())
            .addAllLocalInventories(new ArrayList<LocalInventory>())
            .build();
    FieldMask setMask = FieldMask.newBuilder().build();

    SetInventoryResponse actualResponse = client.setInventoryAsync(inventory, setMask).get();
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
  public void setInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Product inventory =
          Product.newBuilder()
              .setName(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .setId("id3355")
              .setPrimaryProductId("primaryProductId-857339256")
              .addAllCollectionMemberIds(new ArrayList<String>())
              .setGtin("gtin3183314")
              .addAllCategories(new ArrayList<String>())
              .setTitle("title110371416")
              .addAllBrands(new ArrayList<String>())
              .setDescription("description-1724546052")
              .setLanguageCode("languageCode-2092349083")
              .putAllAttributes(new HashMap<String, CustomAttribute>())
              .addAllTags(new ArrayList<String>())
              .setPriceInfo(PriceInfo.newBuilder().build())
              .setRating(Rating.newBuilder().build())
              .setAvailableTime(Timestamp.newBuilder().build())
              .setAvailableQuantity(Int32Value.newBuilder().build())
              .addAllFulfillmentInfo(new ArrayList<FulfillmentInfo>())
              .setUri("uri116076")
              .addAllImages(new ArrayList<Image>())
              .setAudience(Audience.newBuilder().build())
              .setColorInfo(ColorInfo.newBuilder().build())
              .addAllSizes(new ArrayList<String>())
              .addAllMaterials(new ArrayList<String>())
              .addAllPatterns(new ArrayList<String>())
              .addAllConditions(new ArrayList<String>())
              .addAllPromotions(new ArrayList<Promotion>())
              .setPublishTime(Timestamp.newBuilder().build())
              .setRetrievableFields(FieldMask.newBuilder().build())
              .addAllVariants(new ArrayList<Product>())
              .addAllLocalInventories(new ArrayList<LocalInventory>())
              .build();
      FieldMask setMask = FieldMask.newBuilder().build();
      client.setInventoryAsync(inventory, setMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addFulfillmentPlacesTest() throws Exception {
    AddFulfillmentPlacesResponse expectedResponse =
        AddFulfillmentPlacesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addFulfillmentPlacesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProductName product =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    AddFulfillmentPlacesResponse actualResponse = client.addFulfillmentPlacesAsync(product).get();
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
  public void addFulfillmentPlacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName product =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
      client.addFulfillmentPlacesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addFulfillmentPlacesTest2() throws Exception {
    AddFulfillmentPlacesResponse expectedResponse =
        AddFulfillmentPlacesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addFulfillmentPlacesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String product =
        "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";

    AddFulfillmentPlacesResponse actualResponse = client.addFulfillmentPlacesAsync(product).get();
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
  public void addFulfillmentPlacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String product =
          "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";
      client.addFulfillmentPlacesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeFulfillmentPlacesTest() throws Exception {
    RemoveFulfillmentPlacesResponse expectedResponse =
        RemoveFulfillmentPlacesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeFulfillmentPlacesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProductName product =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    RemoveFulfillmentPlacesResponse actualResponse =
        client.removeFulfillmentPlacesAsync(product).get();
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
  public void removeFulfillmentPlacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName product =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
      client.removeFulfillmentPlacesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeFulfillmentPlacesTest2() throws Exception {
    RemoveFulfillmentPlacesResponse expectedResponse =
        RemoveFulfillmentPlacesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeFulfillmentPlacesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String product =
        "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";

    RemoveFulfillmentPlacesResponse actualResponse =
        client.removeFulfillmentPlacesAsync(product).get();
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
  public void removeFulfillmentPlacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String product =
          "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";
      client.removeFulfillmentPlacesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addLocalInventoriesTest() throws Exception {
    AddLocalInventoriesResponse expectedResponse = AddLocalInventoriesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addLocalInventoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProductName product =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    AddLocalInventoriesResponse actualResponse = client.addLocalInventoriesAsync(product).get();
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
  public void addLocalInventoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName product =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
      client.addLocalInventoriesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addLocalInventoriesTest2() throws Exception {
    AddLocalInventoriesResponse expectedResponse = AddLocalInventoriesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addLocalInventoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String product =
        "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";

    AddLocalInventoriesResponse actualResponse = client.addLocalInventoriesAsync(product).get();
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
  public void addLocalInventoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String product =
          "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";
      client.addLocalInventoriesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeLocalInventoriesTest() throws Exception {
    RemoveLocalInventoriesResponse expectedResponse =
        RemoveLocalInventoriesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeLocalInventoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProductName product =
        ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");

    RemoveLocalInventoriesResponse actualResponse =
        client.removeLocalInventoriesAsync(product).get();
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
  public void removeLocalInventoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName product =
          ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]");
      client.removeLocalInventoriesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeLocalInventoriesTest2() throws Exception {
    RemoveLocalInventoriesResponse expectedResponse =
        RemoveLocalInventoriesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeLocalInventoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String product =
        "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";

    RemoveLocalInventoriesResponse actualResponse =
        client.removeLocalInventoriesAsync(product).get();
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
  public void removeLocalInventoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String product =
          "projects/project-3856/locations/location-3856/catalogs/catalog-3856/branches/branche-3856/products/product-3856";
      client.removeLocalInventoriesAsync(product).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
