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

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonOrderServiceStub;
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
public class OrderServiceClientTest {
  private static MockHttpService mockService;
  private static OrderServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOrderServiceStub.getMethodDescriptors(),
            OrderServiceSettings.getDefaultEndpoint());
    OrderServiceSettings settings =
        OrderServiceSettings.newBuilder()
            .setTransportChannelProvider(
                OrderServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrderServiceClient.create(settings);
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
  public void getOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setOrderId(1234304940)
            .setDisplayName("displayName1714148973")
            .setProgrammatic(true)
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllAdvertiserContacts(new ArrayList<String>())
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencyContacts(new ArrayList<String>())
            .setAgency(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllEffectiveTeams(new ArrayList<String>())
            .setCreator(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .setCurrencyCode("currencyCode1004773790")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setExternalOrderId(-1332092512)
            .setArchived(true)
            .setLastModifiedByApp("lastModifiedByApp-522754549")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotes("notes105008833")
            .setPoNumber("poNumber-300606936")
            .setSalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSecondarySalespeople(new ArrayList<String>())
            .addAllSecondaryTraffickers(new ArrayList<String>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .build();
    mockService.addResponse(expectedResponse);

    OrderName name = OrderName.of("[NETWORK_CODE]", "[ORDER]");

    Order actualResponse = client.getOrder(name);
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
      OrderName name = OrderName.of("[NETWORK_CODE]", "[ORDER]");
      client.getOrder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrderTest2() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setOrderId(1234304940)
            .setDisplayName("displayName1714148973")
            .setProgrammatic(true)
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllAdvertiserContacts(new ArrayList<String>())
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencyContacts(new ArrayList<String>())
            .setAgency(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllEffectiveTeams(new ArrayList<String>())
            .setCreator(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .setCurrencyCode("currencyCode1004773790")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setExternalOrderId(-1332092512)
            .setArchived(true)
            .setLastModifiedByApp("lastModifiedByApp-522754549")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotes("notes105008833")
            .setPoNumber("poNumber-300606936")
            .setSalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSecondarySalespeople(new ArrayList<String>())
            .addAllSecondaryTraffickers(new ArrayList<String>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-2300/orders/order-2300";

    Order actualResponse = client.getOrder(name);
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
  public void getOrderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-2300/orders/order-2300";
      client.getOrder(name);
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

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListOrdersPagedResponse pagedListResponse = client.listOrders(parent);

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
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listOrders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrdersTest2() throws Exception {
    Order responsesElement = Order.newBuilder().build();
    ListOrdersResponse expectedResponse =
        ListOrdersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListOrdersPagedResponse pagedListResponse = client.listOrders(parent);

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
  public void listOrdersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listOrders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
