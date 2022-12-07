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
import com.google.protobuf.Timestamp;
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
public class ConsumerProcurementServiceClientTest {
  private static MockConsumerProcurementService mockConsumerProcurementService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConsumerProcurementServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConsumerProcurementService = new MockConsumerProcurementService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConsumerProcurementService));
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
    ConsumerProcurementServiceSettings settings =
        ConsumerProcurementServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConsumerProcurementServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockConsumerProcurementService.addResponse(resultOperation);

    PlaceOrderRequest request =
        PlaceOrderRequest.newBuilder()
            .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
            .setDisplayName("displayName1714148973")
            .addAllLineItemInfo(new ArrayList<LineItemInfo>())
            .setRequestId("requestId693933066")
            .build();

    Order actualResponse = client.placeOrderAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConsumerProcurementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PlaceOrderRequest actualRequest = ((PlaceOrderRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDisplayName(), actualRequest.getDisplayName());
    Assert.assertEquals(request.getLineItemInfoList(), actualRequest.getLineItemInfoList());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void placeOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConsumerProcurementService.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConsumerProcurementService.addResponse(expectedResponse);

    GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();

    Order actualResponse = client.getOrder(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConsumerProcurementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrderRequest actualRequest = ((GetOrderRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConsumerProcurementService.addException(exception);

    try {
      GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
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
    mockConsumerProcurementService.addResponse(expectedResponse);

    ListOrdersRequest request =
        ListOrdersRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListOrdersPagedResponse pagedListResponse = client.listOrders(request);

    List<Order> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrdersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConsumerProcurementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrdersRequest actualRequest = ((ListOrdersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrdersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConsumerProcurementService.addException(exception);

    try {
      ListOrdersRequest request =
          ListOrdersRequest.newBuilder()
              .setParent("parent-995424086")
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
