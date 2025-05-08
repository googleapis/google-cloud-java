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

package com.google.shopping.merchant.ordertracking.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.shopping.merchant.ordertracking.v1beta.stub.HttpJsonOrderTrackingSignalsServiceStub;
import com.google.shopping.type.Price;
import com.google.type.DateTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class OrderTrackingSignalsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OrderTrackingSignalsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOrderTrackingSignalsServiceStub.getMethodDescriptors(),
            OrderTrackingSignalsServiceSettings.getDefaultEndpoint());
    OrderTrackingSignalsServiceSettings settings =
        OrderTrackingSignalsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OrderTrackingSignalsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrderTrackingSignalsServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    String orderTrackingSignalId = "orderTrackingSignalId1140832552";

    OrderTrackingSignal actualResponse =
        client.createOrderTrackingSignal(parent, orderTrackingSignalId);
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
  public void createOrderTrackingSignalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    String orderTrackingSignalId = "orderTrackingSignalId1140832552";

    OrderTrackingSignal actualResponse =
        client.createOrderTrackingSignal(parent, orderTrackingSignalId);
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
  public void createOrderTrackingSignalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      String orderTrackingSignalId = "orderTrackingSignalId1140832552";
      client.createOrderTrackingSignal(parent, orderTrackingSignalId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
