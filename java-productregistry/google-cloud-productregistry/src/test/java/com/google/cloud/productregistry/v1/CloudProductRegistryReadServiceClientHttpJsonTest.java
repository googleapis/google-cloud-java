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

package com.google.cloud.productregistry.v1;

import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductVariantsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListProductSuitesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.productregistry.v1.stub.HttpJsonCloudProductRegistryReadServiceStub;
import com.google.common.collect.Lists;
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
public class CloudProductRegistryReadServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudProductRegistryReadServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudProductRegistryReadServiceStub.getMethodDescriptors(),
            CloudProductRegistryReadServiceSettings.getDefaultEndpoint());
    CloudProductRegistryReadServiceSettings settings =
        CloudProductRegistryReadServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudProductRegistryReadServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudProductRegistryReadServiceClient.create(settings);
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
  public void getProductSuiteTest() throws Exception {
    ProductSuite expectedResponse =
        ProductSuite.newBuilder()
            .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .setTitle("title110371416")
            .addAllLogicalProducts(new ArrayList<String>())
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");

    ProductSuite actualResponse = client.getProductSuite(name);
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
  public void getProductSuiteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");
      client.getProductSuite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductSuiteTest2() throws Exception {
    ProductSuite expectedResponse =
        ProductSuite.newBuilder()
            .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .setTitle("title110371416")
            .addAllLogicalProducts(new ArrayList<String>())
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "productSuites/productSuite-5478";

    ProductSuite actualResponse = client.getProductSuite(name);
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
  public void getProductSuiteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "productSuites/productSuite-5478";
      client.getProductSuite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductSuitesTest() throws Exception {
    ProductSuite responsesElement = ProductSuite.newBuilder().build();
    ListProductSuitesResponse expectedResponse =
        ListProductSuitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductSuites(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListProductSuitesRequest request =
        ListProductSuitesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListProductSuitesPagedResponse pagedListResponse = client.listProductSuites(request);

    List<ProductSuite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductSuitesList().get(0), resources.get(0));

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
  public void listProductSuitesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListProductSuitesRequest request =
          ListProductSuitesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listProductSuites(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductTest() throws Exception {
    LogicalProduct expectedResponse =
        LogicalProduct.newBuilder()
            .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
            .setTitle("title110371416")
            .setProductSuite(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .addAllVariants(new ArrayList<String>())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    LogicalProductName name = LogicalProductName.of("[LOGICAL_PRODUCT]");

    LogicalProduct actualResponse = client.getLogicalProduct(name);
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
  public void getLogicalProductExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LogicalProductName name = LogicalProductName.of("[LOGICAL_PRODUCT]");
      client.getLogicalProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductTest2() throws Exception {
    LogicalProduct expectedResponse =
        LogicalProduct.newBuilder()
            .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
            .setTitle("title110371416")
            .setProductSuite(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .addAllVariants(new ArrayList<String>())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "logicalProducts/logicalProduct-7011";

    LogicalProduct actualResponse = client.getLogicalProduct(name);
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
  public void getLogicalProductExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "logicalProducts/logicalProduct-7011";
      client.getLogicalProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductsTest() throws Exception {
    LogicalProduct responsesElement = LogicalProduct.newBuilder().build();
    ListLogicalProductsResponse expectedResponse =
        ListLogicalProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProducts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLogicalProductsRequest request =
        ListLogicalProductsRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLogicalProductsPagedResponse pagedListResponse = client.listLogicalProducts(request);

    List<LogicalProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductsList().get(0), resources.get(0));

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
  public void listLogicalProductsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLogicalProductsRequest request =
          ListLogicalProductsRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLogicalProducts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductVariantTest() throws Exception {
    LogicalProductVariant expectedResponse =
        LogicalProductVariant.newBuilder()
            .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
            .setTitle("title110371416")
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    LogicalProductVariantName name = LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]");

    LogicalProductVariant actualResponse = client.getLogicalProductVariant(name);
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
  public void getLogicalProductVariantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LogicalProductVariantName name =
          LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]");
      client.getLogicalProductVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductVariantTest2() throws Exception {
    LogicalProductVariant expectedResponse =
        LogicalProductVariant.newBuilder()
            .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
            .setTitle("title110371416")
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "logicalProducts/logicalProduct-8757/variants/variant-8757";

    LogicalProductVariant actualResponse = client.getLogicalProductVariant(name);
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
  public void getLogicalProductVariantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "logicalProducts/logicalProduct-8757/variants/variant-8757";
      client.getLogicalProductVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductVariantsTest() throws Exception {
    LogicalProductVariant responsesElement = LogicalProductVariant.newBuilder().build();
    ListLogicalProductVariantsResponse expectedResponse =
        ListLogicalProductVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProductVariants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LogicalProductName parent = LogicalProductName.of("[LOGICAL_PRODUCT]");

    ListLogicalProductVariantsPagedResponse pagedListResponse =
        client.listLogicalProductVariants(parent);

    List<LogicalProductVariant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductVariantsList().get(0), resources.get(0));

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
  public void listLogicalProductVariantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LogicalProductName parent = LogicalProductName.of("[LOGICAL_PRODUCT]");
      client.listLogicalProductVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductVariantsTest2() throws Exception {
    LogicalProductVariant responsesElement = LogicalProductVariant.newBuilder().build();
    ListLogicalProductVariantsResponse expectedResponse =
        ListLogicalProductVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProductVariants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "logicalProducts/logicalProduct-5742";

    ListLogicalProductVariantsPagedResponse pagedListResponse =
        client.listLogicalProductVariants(parent);

    List<LogicalProductVariant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductVariantsList().get(0), resources.get(0));

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
  public void listLogicalProductVariantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "logicalProducts/logicalProduct-5742";
      client.listLogicalProductVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEntityTest() throws Exception {
    LookupEntityResponse expectedResponse = LookupEntityResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    LookupEntityRequest request =
        LookupEntityRequest.newBuilder()
            .setLookupUri("logicalProducts/logicalProduct-3418")
            .build();

    LookupEntityResponse actualResponse = client.lookupEntity(request);
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
  public void lookupEntityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LookupEntityRequest request =
          LookupEntityRequest.newBuilder()
              .setLookupUri("logicalProducts/logicalProduct-3418")
              .build();
      client.lookupEntity(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
