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

import static com.google.shopping.merchant.inventories.v1beta.RegionalInventoryServiceClient.ListRegionalInventoriesPagedResponse;

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
import com.google.shopping.merchant.inventories.v1beta.stub.HttpJsonRegionalInventoryServiceStub;
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
public class RegionalInventoryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RegionalInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRegionalInventoryServiceStub.getMethodDescriptors(),
            RegionalInventoryServiceSettings.getDefaultEndpoint());
    RegionalInventoryServiceSettings settings =
        RegionalInventoryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RegionalInventoryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionalInventoryServiceClient.create(settings);
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
  public void listRegionalInventoriesTest() throws Exception {
    RegionalInventory responsesElement = RegionalInventory.newBuilder().build();
    ListRegionalInventoriesResponse expectedResponse =
        ListRegionalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegionalInventories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    ListRegionalInventoriesPagedResponse pagedListResponse = client.listRegionalInventories(parent);

    List<RegionalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionalInventoriesList().get(0), resources.get(0));

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
  public void listRegionalInventoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");
      client.listRegionalInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegionalInventoriesTest2() throws Exception {
    RegionalInventory responsesElement = RegionalInventory.newBuilder().build();
    ListRegionalInventoriesResponse expectedResponse =
        ListRegionalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegionalInventories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-653/products/product-653";

    ListRegionalInventoriesPagedResponse pagedListResponse = client.listRegionalInventories(parent);

    List<RegionalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionalInventoriesList().get(0), resources.get(0));

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
  public void listRegionalInventoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-653/products/product-653";
      client.listRegionalInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertRegionalInventoryTest() throws Exception {
    RegionalInventory expectedResponse =
        RegionalInventory.newBuilder()
            .setName(RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]").toString())
            .setAccount(-1177318867)
            .setRegion("region-934795532")
            .setPrice(Price.newBuilder().build())
            .setSalePrice(Price.newBuilder().build())
            .setSalePriceEffectiveDate(Interval.newBuilder().build())
            .setAvailability("availability1997542747")
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .build();
    mockService.addResponse(expectedResponse);

    InsertRegionalInventoryRequest request =
        InsertRegionalInventoryRequest.newBuilder()
            .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setRegionalInventory(RegionalInventory.newBuilder().build())
            .build();

    RegionalInventory actualResponse = client.insertRegionalInventory(request);
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
  public void insertRegionalInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertRegionalInventoryRequest request =
          InsertRegionalInventoryRequest.newBuilder()
              .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
              .setRegionalInventory(RegionalInventory.newBuilder().build())
              .build();
      client.insertRegionalInventory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionalInventoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RegionalInventoryName name = RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]");

    client.deleteRegionalInventory(name);

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
  public void deleteRegionalInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionalInventoryName name = RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]");
      client.deleteRegionalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRegionalInventoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "accounts/account-9207/products/product-9207/regionalInventories/regionalInventorie-9207";

    client.deleteRegionalInventory(name);

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
  public void deleteRegionalInventoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accounts/account-9207/products/product-9207/regionalInventories/regionalInventorie-9207";
      client.deleteRegionalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
