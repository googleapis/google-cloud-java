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

package com.google.shopping.merchant.inventories.v1beta;

import static com.google.shopping.merchant.inventories.v1beta.LocalInventoryServiceClient.ListLocalInventoriesPagedResponse;

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
import com.google.shopping.merchant.inventories.v1beta.stub.HttpJsonLocalInventoryServiceStub;
import com.google.shopping.type.CustomAttribute;
import com.google.shopping.type.Price;
import com.google.type.Interval;
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
public class LocalInventoryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LocalInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLocalInventoryServiceStub.getMethodDescriptors(),
            LocalInventoryServiceSettings.getDefaultEndpoint());
    LocalInventoryServiceSettings settings =
        LocalInventoryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LocalInventoryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LocalInventoryServiceClient.create(settings);
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
  public void listLocalInventoriesTest() throws Exception {
    LocalInventory responsesElement = LocalInventory.newBuilder().build();
    ListLocalInventoriesResponse expectedResponse =
        ListLocalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocalInventories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    ListLocalInventoriesPagedResponse pagedListResponse = client.listLocalInventories(parent);

    List<LocalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocalInventoriesList().get(0), resources.get(0));

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
  public void listLocalInventoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");
      client.listLocalInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocalInventoriesTest2() throws Exception {
    LocalInventory responsesElement = LocalInventory.newBuilder().build();
    ListLocalInventoriesResponse expectedResponse =
        ListLocalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocalInventories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-653/products/product-653";

    ListLocalInventoriesPagedResponse pagedListResponse = client.listLocalInventories(parent);

    List<LocalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocalInventoriesList().get(0), resources.get(0));

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
  public void listLocalInventoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-653/products/product-653";
      client.listLocalInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertLocalInventoryTest() throws Exception {
    LocalInventory expectedResponse =
        LocalInventory.newBuilder()
            .setName(LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]").toString())
            .setAccount(-1177318867)
            .setStoreCode("storeCode1691468398")
            .setPrice(Price.newBuilder().build())
            .setSalePrice(Price.newBuilder().build())
            .setSalePriceEffectiveDate(Interval.newBuilder().build())
            .setAvailability("availability1997542747")
            .setQuantity(-1285004149)
            .setPickupMethod("pickupMethod139786877")
            .setPickupSla("pickupSla-1416603380")
            .setInstoreProductLocation("instoreProductLocation965688136")
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .build();
    mockService.addResponse(expectedResponse);

    InsertLocalInventoryRequest request =
        InsertLocalInventoryRequest.newBuilder()
            .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setLocalInventory(LocalInventory.newBuilder().build())
            .build();

    LocalInventory actualResponse = client.insertLocalInventory(request);
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
  public void insertLocalInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertLocalInventoryRequest request =
          InsertLocalInventoryRequest.newBuilder()
              .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
              .setLocalInventory(LocalInventory.newBuilder().build())
              .build();
      client.insertLocalInventory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLocalInventoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    LocalInventoryName name = LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]");

    client.deleteLocalInventory(name);

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
  public void deleteLocalInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocalInventoryName name = LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]");
      client.deleteLocalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLocalInventoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "accounts/account-7207/products/product-7207/localInventories/localInventorie-7207";

    client.deleteLocalInventory(name);

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
  public void deleteLocalInventoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accounts/account-7207/products/product-7207/localInventories/localInventorie-7207";
      client.deleteLocalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
