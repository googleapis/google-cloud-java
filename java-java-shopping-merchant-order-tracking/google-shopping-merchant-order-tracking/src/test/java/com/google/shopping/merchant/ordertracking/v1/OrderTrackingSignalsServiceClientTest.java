/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.ordertracking.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.shopping.type.Price;
import com.google.type.DateTime;
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
public class OrderTrackingSignalsServiceClientTest {
  private static MockOrderTrackingSignalsService mockOrderTrackingSignalsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OrderTrackingSignalsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOrderTrackingSignalsService = new MockOrderTrackingSignalsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockOrderTrackingSignalsService));
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
    OrderTrackingSignalsServiceSettings settings =
        OrderTrackingSignalsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrderTrackingSignalsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createOrderTrackingSignalTest() throws Exception {
    OrderTrackingSignal expectedResponse =
        OrderTrackingSignal.newBuilder()
            .setOrderTrackingSignalId(-628640997)
            .setMerchantId(574223090)
            .setOrderCreatedTime(DateTime.newBuilder().build())
            .setOrderId("orderId-1207110391")
            .addAllShippingInfo(new ArrayList<OrderTrackingSignal.ShippingInfo>())
            .addAllLineItems(new ArrayList<OrderTrackingSignal.LineItemDetails>())
            .addAllShipmentLineItemMapping(
                new ArrayList<OrderTrackingSignal.ShipmentLineItemMapping>())
            .setCustomerShippingFee(Price.newBuilder().build())
            .setDeliveryPostalCode("deliveryPostalCode-1839507348")
            .setDeliveryRegionCode("deliveryRegionCode-1546697195")
            .build();
    mockOrderTrackingSignalsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    String orderTrackingSignalId = "orderTrackingSignalId1140832552";

    OrderTrackingSignal actualResponse =
        client.createOrderTrackingSignal(parent, orderTrackingSignalId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrderTrackingSignalsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrderTrackingSignalRequest actualRequest =
        ((CreateOrderTrackingSignalRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(orderTrackingSignalId, actualRequest.getOrderTrackingSignalId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrderTrackingSignalExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrderTrackingSignalsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      String orderTrackingSignalId = "orderTrackingSignalId1140832552";
      client.createOrderTrackingSignal(parent, orderTrackingSignalId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOrderTrackingSignalTest2() throws Exception {
    OrderTrackingSignal expectedResponse =
        OrderTrackingSignal.newBuilder()
            .setOrderTrackingSignalId(-628640997)
            .setMerchantId(574223090)
            .setOrderCreatedTime(DateTime.newBuilder().build())
            .setOrderId("orderId-1207110391")
            .addAllShippingInfo(new ArrayList<OrderTrackingSignal.ShippingInfo>())
            .addAllLineItems(new ArrayList<OrderTrackingSignal.LineItemDetails>())
            .addAllShipmentLineItemMapping(
                new ArrayList<OrderTrackingSignal.ShipmentLineItemMapping>())
            .setCustomerShippingFee(Price.newBuilder().build())
            .setDeliveryPostalCode("deliveryPostalCode-1839507348")
            .setDeliveryRegionCode("deliveryRegionCode-1546697195")
            .build();
    mockOrderTrackingSignalsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String orderTrackingSignalId = "orderTrackingSignalId1140832552";

    OrderTrackingSignal actualResponse =
        client.createOrderTrackingSignal(parent, orderTrackingSignalId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrderTrackingSignalsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrderTrackingSignalRequest actualRequest =
        ((CreateOrderTrackingSignalRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(orderTrackingSignalId, actualRequest.getOrderTrackingSignalId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrderTrackingSignalExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrderTrackingSignalsService.addException(exception);

    try {
      String parent = "parent-995424086";
      String orderTrackingSignalId = "orderTrackingSignalId1140832552";
      client.createOrderTrackingSignal(parent, orderTrackingSignalId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
