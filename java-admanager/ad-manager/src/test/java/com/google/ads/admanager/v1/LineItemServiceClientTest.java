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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonLineItemServiceStub;
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
import com.google.protobuf.Timestamp;
import com.google.type.Money;
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
public class LineItemServiceClientTest {
  private static MockHttpService mockService;
  private static LineItemServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLineItemServiceStub.getMethodDescriptors(),
            LineItemServiceSettings.getDefaultEndpoint());
    LineItemServiceSettings settings =
        LineItemServiceSettings.newBuilder()
            .setTransportChannelProvider(
                LineItemServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineItemServiceClient.create(settings);
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
  public void getLineItemTest() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]").toString())
            .setDisplayName("displayName1714148973")
            .setArchived(true)
            .setContractedUnitsBought(-424175607)
            .setCostPerUnit(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDiscount(273184065)
            .setExternalId("externalId-1699764666")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setUnlimitedEndTime(true)
            .setLastModifiedByApp("lastModifiedByApp-522754549")
            .setMissingCreatives(true)
            .setNotes("notes105008833")
            .setPriority(-1165461084)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setPrimaryGoal(Goal.newBuilder().build())
            .setImpressionLimit(Goal.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LineItemName name = LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]");

    LineItem actualResponse = client.getLineItem(name);
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
  public void getLineItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItemName name = LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]");
      client.getLineItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineItemTest2() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]").toString())
            .setDisplayName("displayName1714148973")
            .setArchived(true)
            .setContractedUnitsBought(-424175607)
            .setCostPerUnit(Money.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDiscount(273184065)
            .setExternalId("externalId-1699764666")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setUnlimitedEndTime(true)
            .setLastModifiedByApp("lastModifiedByApp-522754549")
            .setMissingCreatives(true)
            .setNotes("notes105008833")
            .setPriority(-1165461084)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setPrimaryGoal(Goal.newBuilder().build())
            .setImpressionLimit(Goal.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-3908/orders/order-3908/lineItems/lineItem-3908";

    LineItem actualResponse = client.getLineItem(name);
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
  public void getLineItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-3908/orders/order-3908/lineItems/lineItem-3908";
      client.getLineItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemsTest() throws Exception {
    LineItem responsesElement = LineItem.newBuilder().build();
    ListLineItemsResponse expectedResponse =
        ListLineItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrderName parent = OrderName.of("[NETWORK_CODE]", "[ORDER]");

    ListLineItemsPagedResponse pagedListResponse = client.listLineItems(parent);

    List<LineItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemsList().get(0), resources.get(0));

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
  public void listLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrderName parent = OrderName.of("[NETWORK_CODE]", "[ORDER]");
      client.listLineItems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemsTest2() throws Exception {
    LineItem responsesElement = LineItem.newBuilder().build();
    ListLineItemsResponse expectedResponse =
        ListLineItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-283/orders/order-283";

    ListLineItemsPagedResponse pagedListResponse = client.listLineItems(parent);

    List<LineItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemsList().get(0), resources.get(0));

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
  public void listLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-283/orders/order-283";
      client.listLineItems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
