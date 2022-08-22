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

package com.google.cloud.commerce.consumer.procurement.v1alpha1;

import static com.google.cloud.commerce.consumer.procurement.v1alpha1.ConsumerProcurementServiceClient.ListOrdersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.stub.HttpJsonConsumerProcurementServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ConsumerProcurementServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConsumerProcurementServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConsumerProcurementServiceStub.getMethodDescriptors(),
            ConsumerProcurementServiceSettings.getDefaultEndpoint());
    ConsumerProcurementServiceSettings settings =
        ConsumerProcurementServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConsumerProcurementServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConsumerProcurementServiceClient.create(settings);
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
  public void placeOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .addAllLineItems(new ArrayList<LineItem>())
            .addAllCancelledLineItems(new ArrayList<LineItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("placeOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PlaceOrderRequest request =
        PlaceOrderRequest.newBuilder()
            .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllLineItemInfo(new ArrayList<LineItemInfo>())
            .setRequestId("requestId693933066")
            .build();

    Order actualResponse = client.placeOrderAsync(request).get();
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
  public void placeOrderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PlaceOrderRequest request =
          PlaceOrderRequest.newBuilder()
              .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
              .setDisplayName("displayName1714148973")
              .addAllLineItemInfo(new ArrayList<LineItemInfo>())
              .setRequestId("requestId693933066")
              .build();
      client.placeOrderAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .addAllLineItems(new ArrayList<LineItem>())
            .addAllCancelledLineItems(new ArrayList<LineItem>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    GetOrderRequest request =
        GetOrderRequest.newBuilder()
            .setName("billingAccounts/billingAccount-9614/orders/order-9614")
            .build();

    Order actualResponse = client.getOrder(request);
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
  public void getOrderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetOrderRequest request =
          GetOrderRequest.newBuilder()
              .setName("billingAccounts/billingAccount-9614/orders/order-9614")
              .build();
      client.getOrder(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrdersTest() throws Exception {
    Order responsesElement = Order.newBuilder().build();
    ListOrdersResponse expectedResponse =
        ListOrdersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListOrdersRequest request =
        ListOrdersRequest.newBuilder()
            .setParent("billingAccounts/billingAccount-7950")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListOrdersPagedResponse pagedListResponse = client.listOrders(request);

    List<Order> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrdersList().get(0), resources.get(0));

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
  public void listOrdersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListOrdersRequest request =
          ListOrdersRequest.newBuilder()
              .setParent("billingAccounts/billingAccount-7950")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listOrders(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
