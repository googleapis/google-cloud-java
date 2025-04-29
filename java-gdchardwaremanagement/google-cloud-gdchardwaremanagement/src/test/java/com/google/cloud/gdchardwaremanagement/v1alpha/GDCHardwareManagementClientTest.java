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

package com.google.cloud.gdchardwaremanagement.v1alpha;

import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListChangeLogEntriesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListCommentsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwareGroupsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwarePagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListOrdersPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSitesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSkusPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListZonesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class GDCHardwareManagementClientTest {
  private static MockGDCHardwareManagement mockGDCHardwareManagement;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GDCHardwareManagementClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGDCHardwareManagement = new MockGDCHardwareManagement();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGDCHardwareManagement, mockLocations));
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
    GDCHardwareManagementSettings settings =
        GDCHardwareManagementSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GDCHardwareManagementClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listOrdersTest() throws Exception {
    Order responsesElement = Order.newBuilder().build();
    ListOrdersResponse expectedResponse =
        ListOrdersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrders(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOrdersPagedResponse pagedListResponse = client.listOrders(parent);

    List<Order> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrdersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrdersRequest actualRequest = ((ListOrdersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrdersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOrdersPagedResponse pagedListResponse = client.listOrders(parent);

    List<Order> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrdersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrdersRequest actualRequest = ((ListOrdersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrdersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOrders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    Order actualResponse = client.getOrder(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrderRequest actualRequest = ((GetOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
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
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Order actualResponse = client.getOrder(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrderRequest actualRequest = ((GetOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getOrder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Order order = Order.newBuilder().build();
    String orderId = "orderId-1207110391";

    Order actualResponse = client.createOrderAsync(parent, order, orderId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrderRequest actualRequest = ((CreateOrderRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(order, actualRequest.getOrder());
    Assert.assertEquals(orderId, actualRequest.getOrderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Order order = Order.newBuilder().build();
      String orderId = "orderId-1207110391";
      client.createOrderAsync(parent, order, orderId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createOrderTest2() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    Order order = Order.newBuilder().build();
    String orderId = "orderId-1207110391";

    Order actualResponse = client.createOrderAsync(parent, order, orderId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrderRequest actualRequest = ((CreateOrderRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(order, actualRequest.getOrder());
    Assert.assertEquals(orderId, actualRequest.getOrderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      Order order = Order.newBuilder().build();
      String orderId = "orderId-1207110391";
      client.createOrderAsync(parent, order, orderId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    Order order = Order.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Order actualResponse = client.updateOrderAsync(order, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOrderRequest actualRequest = ((UpdateOrderRequest) actualRequests.get(0));

    Assert.assertEquals(order, actualRequest.getOrder());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      Order order = Order.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOrderAsync(order, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOrderTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    client.deleteOrderAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOrderRequest actualRequest = ((DeleteOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      client.deleteOrderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOrderTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteOrderAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOrderRequest actualRequest = ((DeleteOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOrderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteOrderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void submitOrderTest() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    Order actualResponse = client.submitOrderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitOrderRequest actualRequest = ((SubmitOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitOrderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      client.submitOrderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void submitOrderTest2() throws Exception {
    Order expectedResponse =
        Order.newBuilder()
            .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .addAllTargetWorkloads(new ArrayList<String>())
            .setCustomerMotivation("customerMotivation419733780")
            .setFulfillmentTime(Timestamp.newBuilder().build())
            .setRegionCode("regionCode-1991004415")
            .setOrderFormUri("orderFormUri212580058")
            .setSubmitTime(Timestamp.newBuilder().build())
            .setBillingId("billingId1828026614")
            .addAllExistingHardware(new ArrayList<HardwareLocation>())
            .setActualInstallationDate(Date.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitOrderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    Order actualResponse = client.submitOrderAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitOrderRequest actualRequest = ((SubmitOrderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitOrderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.submitOrderAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSitesTest() throws Exception {
    Site responsesElement = Site.newBuilder().build();
    ListSitesResponse expectedResponse =
        ListSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSites(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSitesPagedResponse pagedListResponse = client.listSites(parent);

    List<Site> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSitesRequest actualRequest = ((ListSitesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSitesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSitesTest2() throws Exception {
    Site responsesElement = Site.newBuilder().build();
    ListSitesResponse expectedResponse =
        ListSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSites(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSitesPagedResponse pagedListResponse = client.listSites(parent);

    List<Site> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSitesRequest actualRequest = ((ListSitesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSitesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSiteTest() throws Exception {
    Site expectedResponse =
        Site.newBuilder()
            .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .setGoogleMapsPinUri("googleMapsPinUri123053095")
            .addAllAccessTimes(new ArrayList<TimePeriod>())
            .setNotes("notes105008833")
            .setCustomerSiteId("customerSiteId1913503808")
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");

    Site actualResponse = client.getSite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSiteRequest actualRequest = ((GetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");
      client.getSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSiteTest2() throws Exception {
    Site expectedResponse =
        Site.newBuilder()
            .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .setGoogleMapsPinUri("googleMapsPinUri123053095")
            .addAllAccessTimes(new ArrayList<TimePeriod>())
            .setNotes("notes105008833")
            .setCustomerSiteId("customerSiteId1913503808")
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Site actualResponse = client.getSite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSiteRequest actualRequest = ((GetSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSiteTest() throws Exception {
    Site expectedResponse =
        Site.newBuilder()
            .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .setGoogleMapsPinUri("googleMapsPinUri123053095")
            .addAllAccessTimes(new ArrayList<TimePeriod>())
            .setNotes("notes105008833")
            .setCustomerSiteId("customerSiteId1913503808")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Site site = Site.newBuilder().build();
    String siteId = "siteId-902090046";

    Site actualResponse = client.createSiteAsync(parent, site, siteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSiteRequest actualRequest = ((CreateSiteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertEquals(siteId, actualRequest.getSiteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Site site = Site.newBuilder().build();
      String siteId = "siteId-902090046";
      client.createSiteAsync(parent, site, siteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSiteTest2() throws Exception {
    Site expectedResponse =
        Site.newBuilder()
            .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .setGoogleMapsPinUri("googleMapsPinUri123053095")
            .addAllAccessTimes(new ArrayList<TimePeriod>())
            .setNotes("notes105008833")
            .setCustomerSiteId("customerSiteId1913503808")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    Site site = Site.newBuilder().build();
    String siteId = "siteId-902090046";

    Site actualResponse = client.createSiteAsync(parent, site, siteId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSiteRequest actualRequest = ((CreateSiteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertEquals(siteId, actualRequest.getSiteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      Site site = Site.newBuilder().build();
      String siteId = "siteId-902090046";
      client.createSiteAsync(parent, site, siteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSiteTest() throws Exception {
    Site expectedResponse =
        Site.newBuilder()
            .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrganizationContact(OrganizationContact.newBuilder().build())
            .setGoogleMapsPinUri("googleMapsPinUri123053095")
            .addAllAccessTimes(new ArrayList<TimePeriod>())
            .setNotes("notes105008833")
            .setCustomerSiteId("customerSiteId1913503808")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    Site site = Site.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Site actualResponse = client.updateSiteAsync(site, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSiteRequest actualRequest = ((UpdateSiteRequest) actualRequests.get(0));

    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      Site site = Site.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSiteAsync(site, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSiteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");

    client.deleteSiteAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSiteRequest actualRequest = ((DeleteSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");
      client.deleteSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSiteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSiteAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSiteRequest actualRequest = ((DeleteSiteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHardwareGroupsTest() throws Exception {
    HardwareGroup responsesElement = HardwareGroup.newBuilder().build();
    ListHardwareGroupsResponse expectedResponse =
        ListHardwareGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHardwareGroups(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    ListHardwareGroupsPagedResponse pagedListResponse = client.listHardwareGroups(parent);

    List<HardwareGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHardwareGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHardwareGroupsRequest actualRequest = ((ListHardwareGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHardwareGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      client.listHardwareGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHardwareGroupsTest2() throws Exception {
    HardwareGroup responsesElement = HardwareGroup.newBuilder().build();
    ListHardwareGroupsResponse expectedResponse =
        ListHardwareGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHardwareGroups(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHardwareGroupsPagedResponse pagedListResponse = client.listHardwareGroups(parent);

    List<HardwareGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHardwareGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHardwareGroupsRequest actualRequest = ((ListHardwareGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHardwareGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHardwareGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHardwareGroupTest() throws Exception {
    HardwareGroup expectedResponse =
        HardwareGroup.newBuilder()
            .setName(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHardwareCount(1025608696)
            .setConfig(HardwareConfig.newBuilder().build())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    HardwareGroupName name =
        HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");

    HardwareGroup actualResponse = client.getHardwareGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHardwareGroupRequest actualRequest = ((GetHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHardwareGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      HardwareGroupName name =
          HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");
      client.getHardwareGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHardwareGroupTest2() throws Exception {
    HardwareGroup expectedResponse =
        HardwareGroup.newBuilder()
            .setName(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHardwareCount(1025608696)
            .setConfig(HardwareConfig.newBuilder().build())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    HardwareGroup actualResponse = client.getHardwareGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHardwareGroupRequest actualRequest = ((GetHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHardwareGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getHardwareGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHardwareGroupTest() throws Exception {
    HardwareGroup expectedResponse =
        HardwareGroup.newBuilder()
            .setName(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHardwareCount(1025608696)
            .setConfig(HardwareConfig.newBuilder().build())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHardwareGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
    HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
    String hardwareGroupId = "hardwareGroupId-1961682702";

    HardwareGroup actualResponse =
        client.createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHardwareGroupRequest actualRequest = ((CreateHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hardwareGroup, actualRequest.getHardwareGroup());
    Assert.assertEquals(hardwareGroupId, actualRequest.getHardwareGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHardwareGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
      String hardwareGroupId = "hardwareGroupId-1961682702";
      client.createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHardwareGroupTest2() throws Exception {
    HardwareGroup expectedResponse =
        HardwareGroup.newBuilder()
            .setName(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHardwareCount(1025608696)
            .setConfig(HardwareConfig.newBuilder().build())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHardwareGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
    String hardwareGroupId = "hardwareGroupId-1961682702";

    HardwareGroup actualResponse =
        client.createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHardwareGroupRequest actualRequest = ((CreateHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hardwareGroup, actualRequest.getHardwareGroup());
    Assert.assertEquals(hardwareGroupId, actualRequest.getHardwareGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHardwareGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
      String hardwareGroupId = "hardwareGroupId-1961682702";
      client.createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateHardwareGroupTest() throws Exception {
    HardwareGroup expectedResponse =
        HardwareGroup.newBuilder()
            .setName(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setHardwareCount(1025608696)
            .setConfig(HardwareConfig.newBuilder().build())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHardwareGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HardwareGroup actualResponse = client.updateHardwareGroupAsync(hardwareGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHardwareGroupRequest actualRequest = ((UpdateHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(hardwareGroup, actualRequest.getHardwareGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHardwareGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHardwareGroupAsync(hardwareGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHardwareGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHardwareGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    HardwareGroupName name =
        HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");

    client.deleteHardwareGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHardwareGroupRequest actualRequest = ((DeleteHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHardwareGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      HardwareGroupName name =
          HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");
      client.deleteHardwareGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHardwareGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHardwareGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHardwareGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHardwareGroupRequest actualRequest = ((DeleteHardwareGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHardwareGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHardwareGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHardwareTest() throws Exception {
    Hardware responsesElement = Hardware.newBuilder().build();
    ListHardwareResponse expectedResponse =
        ListHardwareResponse.newBuilder()
            .setNextPageToken("")
            .addAllHardware(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHardwarePagedResponse pagedListResponse = client.listHardware(parent);

    List<Hardware> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHardwareList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHardwareRequest actualRequest = ((ListHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHardwareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHardware(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHardwareTest2() throws Exception {
    Hardware responsesElement = Hardware.newBuilder().build();
    ListHardwareResponse expectedResponse =
        ListHardwareResponse.newBuilder()
            .setNextPageToken("")
            .addAllHardware(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHardwarePagedResponse pagedListResponse = client.listHardware(parent);

    List<Hardware> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHardwareList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHardwareRequest actualRequest = ((ListHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHardwareExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHardware(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHardwareTest() throws Exception {
    Hardware expectedResponse =
        Hardware.newBuilder()
            .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrder(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setHardwareGroup(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setCiqUri("ciqUri-1360259935")
            .setConfig(HardwareConfig.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .setPhysicalInfo(HardwarePhysicalInfo.newBuilder().build())
            .setInstallationInfo(HardwareInstallationInfo.newBuilder().build())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .setActualInstallationDate(Date.newBuilder().build())
            .addAllMachineInfos(new ArrayList<Hardware.MachineInfo>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");

    Hardware actualResponse = client.getHardware(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHardwareRequest actualRequest = ((GetHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHardwareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");
      client.getHardware(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHardwareTest2() throws Exception {
    Hardware expectedResponse =
        Hardware.newBuilder()
            .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrder(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setHardwareGroup(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setCiqUri("ciqUri-1360259935")
            .setConfig(HardwareConfig.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .setPhysicalInfo(HardwarePhysicalInfo.newBuilder().build())
            .setInstallationInfo(HardwareInstallationInfo.newBuilder().build())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .setActualInstallationDate(Date.newBuilder().build())
            .addAllMachineInfos(new ArrayList<Hardware.MachineInfo>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Hardware actualResponse = client.getHardware(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHardwareRequest actualRequest = ((GetHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHardwareExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getHardware(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHardwareTest() throws Exception {
    Hardware expectedResponse =
        Hardware.newBuilder()
            .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrder(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setHardwareGroup(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setCiqUri("ciqUri-1360259935")
            .setConfig(HardwareConfig.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .setPhysicalInfo(HardwarePhysicalInfo.newBuilder().build())
            .setInstallationInfo(HardwareInstallationInfo.newBuilder().build())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .setActualInstallationDate(Date.newBuilder().build())
            .addAllMachineInfos(new ArrayList<Hardware.MachineInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHardwareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Hardware hardware = Hardware.newBuilder().build();
    String hardwareId = "hardwareId680924451";

    Hardware actualResponse = client.createHardwareAsync(parent, hardware, hardwareId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHardwareRequest actualRequest = ((CreateHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hardware, actualRequest.getHardware());
    Assert.assertEquals(hardwareId, actualRequest.getHardwareId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHardwareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Hardware hardware = Hardware.newBuilder().build();
      String hardwareId = "hardwareId680924451";
      client.createHardwareAsync(parent, hardware, hardwareId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHardwareTest2() throws Exception {
    Hardware expectedResponse =
        Hardware.newBuilder()
            .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrder(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setHardwareGroup(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setCiqUri("ciqUri-1360259935")
            .setConfig(HardwareConfig.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .setPhysicalInfo(HardwarePhysicalInfo.newBuilder().build())
            .setInstallationInfo(HardwareInstallationInfo.newBuilder().build())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .setActualInstallationDate(Date.newBuilder().build())
            .addAllMachineInfos(new ArrayList<Hardware.MachineInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHardwareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    Hardware hardware = Hardware.newBuilder().build();
    String hardwareId = "hardwareId680924451";

    Hardware actualResponse = client.createHardwareAsync(parent, hardware, hardwareId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHardwareRequest actualRequest = ((CreateHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hardware, actualRequest.getHardware());
    Assert.assertEquals(hardwareId, actualRequest.getHardwareId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHardwareExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      Hardware hardware = Hardware.newBuilder().build();
      String hardwareId = "hardwareId680924451";
      client.createHardwareAsync(parent, hardware, hardwareId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateHardwareTest() throws Exception {
    Hardware expectedResponse =
        Hardware.newBuilder()
            .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setOrder(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
            .setHardwareGroup(
                HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
                    .toString())
            .setSite(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
            .setCiqUri("ciqUri-1360259935")
            .setConfig(HardwareConfig.newBuilder().build())
            .setEstimatedInstallationDate(Date.newBuilder().build())
            .setPhysicalInfo(HardwarePhysicalInfo.newBuilder().build())
            .setInstallationInfo(HardwareInstallationInfo.newBuilder().build())
            .setZone(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setRequestedInstallationDate(Date.newBuilder().build())
            .setActualInstallationDate(Date.newBuilder().build())
            .addAllMachineInfos(new ArrayList<Hardware.MachineInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHardwareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    Hardware hardware = Hardware.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Hardware actualResponse = client.updateHardwareAsync(hardware, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHardwareRequest actualRequest = ((UpdateHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(hardware, actualRequest.getHardware());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHardwareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      Hardware hardware = Hardware.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHardwareAsync(hardware, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHardwareTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHardwareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");

    client.deleteHardwareAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHardwareRequest actualRequest = ((DeleteHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHardwareExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");
      client.deleteHardwareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHardwareTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHardwareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHardwareAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHardwareRequest actualRequest = ((DeleteHardwareRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHardwareExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHardwareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCommentsTest() throws Exception {
    Comment responsesElement = Comment.newBuilder().build();
    ListCommentsResponse expectedResponse =
        ListCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComments(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCommentsRequest actualRequest = ((ListCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      client.listComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCommentsTest2() throws Exception {
    Comment responsesElement = Comment.newBuilder().build();
    ListCommentsResponse expectedResponse =
        ListCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComments(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCommentsRequest actualRequest = ((ListCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCommentTest() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");

    Comment actualResponse = client.getComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCommentRequest actualRequest = ((GetCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");
      client.getComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCommentTest2() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Comment actualResponse = client.getComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCommentRequest actualRequest = ((GetCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCommentTest() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
    Comment comment = Comment.newBuilder().build();
    String commentId = "commentId-1495016486";

    Comment actualResponse = client.createCommentAsync(parent, comment, commentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCommentRequest actualRequest = ((CreateCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(comment, actualRequest.getComment());
    Assert.assertEquals(commentId, actualRequest.getCommentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      Comment comment = Comment.newBuilder().build();
      String commentId = "commentId-1495016486";
      client.createCommentAsync(parent, comment, commentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCommentTest2() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    Comment comment = Comment.newBuilder().build();
    String commentId = "commentId-1495016486";

    Comment actualResponse = client.createCommentAsync(parent, comment, commentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCommentRequest actualRequest = ((CreateCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(comment, actualRequest.getComment());
    Assert.assertEquals(commentId, actualRequest.getCommentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      Comment comment = Comment.newBuilder().build();
      String commentId = "commentId-1495016486";
      client.createCommentAsync(parent, comment, commentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void recordActionOnCommentTest() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");
    RecordActionOnCommentRequest.ActionType actionType =
        RecordActionOnCommentRequest.ActionType.forNumber(0);

    Comment actualResponse = client.recordActionOnComment(name, actionType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecordActionOnCommentRequest actualRequest =
        ((RecordActionOnCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(actionType, actualRequest.getActionType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recordActionOnCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");
      RecordActionOnCommentRequest.ActionType actionType =
          RecordActionOnCommentRequest.ActionType.forNumber(0);
      client.recordActionOnComment(name, actionType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void recordActionOnCommentTest2() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthor("author-1406328437")
            .setText("text3556653")
            .setCustomerViewedTime(Timestamp.newBuilder().build())
            .setAuthorEntity(Entity.forNumber(0))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";
    RecordActionOnCommentRequest.ActionType actionType =
        RecordActionOnCommentRequest.ActionType.forNumber(0);

    Comment actualResponse = client.recordActionOnComment(name, actionType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecordActionOnCommentRequest actualRequest =
        ((RecordActionOnCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(actionType, actualRequest.getActionType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recordActionOnCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      RecordActionOnCommentRequest.ActionType actionType =
          RecordActionOnCommentRequest.ActionType.forNumber(0);
      client.recordActionOnComment(name, actionType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChangeLogEntriesTest() throws Exception {
    ChangeLogEntry responsesElement = ChangeLogEntry.newBuilder().build();
    ListChangeLogEntriesResponse expectedResponse =
        ListChangeLogEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangeLogEntries(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");

    ListChangeLogEntriesPagedResponse pagedListResponse = client.listChangeLogEntries(parent);

    List<ChangeLogEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangeLogEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangeLogEntriesRequest actualRequest =
        ((ListChangeLogEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangeLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
      client.listChangeLogEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChangeLogEntriesTest2() throws Exception {
    ChangeLogEntry responsesElement = ChangeLogEntry.newBuilder().build();
    ListChangeLogEntriesResponse expectedResponse =
        ListChangeLogEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangeLogEntries(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChangeLogEntriesPagedResponse pagedListResponse = client.listChangeLogEntries(parent);

    List<ChangeLogEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangeLogEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangeLogEntriesRequest actualRequest =
        ((ListChangeLogEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangeLogEntriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChangeLogEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangeLogEntryTest() throws Exception {
    ChangeLogEntry expectedResponse =
        ChangeLogEntry.newBuilder()
            .setName(
                ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLog("log107332")
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    ChangeLogEntryName name =
        ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]");

    ChangeLogEntry actualResponse = client.getChangeLogEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangeLogEntryRequest actualRequest = ((GetChangeLogEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangeLogEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      ChangeLogEntryName name =
          ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]");
      client.getChangeLogEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangeLogEntryTest2() throws Exception {
    ChangeLogEntry expectedResponse =
        ChangeLogEntry.newBuilder()
            .setName(
                ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLog("log107332")
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    ChangeLogEntry actualResponse = client.getChangeLogEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangeLogEntryRequest actualRequest = ((GetChangeLogEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangeLogEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getChangeLogEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = ((ListSkusRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest2() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = ((ListSkusRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSkusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuTest() throws Exception {
    Sku expectedResponse =
        Sku.newBuilder()
            .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConfig(SkuConfig.newBuilder().build())
            .addAllInstances(new ArrayList<SkuInstance>())
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setIsActive(true)
            .setVcpuCount(936475650)
            .addAllHardwareCountRanges(new ArrayList<Sku.Range>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]");

    Sku actualResponse = client.getSku(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSkuRequest actualRequest = ((GetSkuRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSkuExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]");
      client.getSku(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuTest2() throws Exception {
    Sku expectedResponse =
        Sku.newBuilder()
            .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConfig(SkuConfig.newBuilder().build())
            .addAllInstances(new ArrayList<SkuInstance>())
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setIsActive(true)
            .setVcpuCount(936475650)
            .addAllHardwareCountRanges(new ArrayList<Sku.Range>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Sku actualResponse = client.getSku(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSkuRequest actualRequest = ((GetSkuRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSkuExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getSku(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZonesTest() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZonesTest2() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    mockGDCHardwareManagement.addResponse(expectedResponse);

    String name = "name3373707";

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateZoneRequest actualRequest = ((CreateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(zoneId, actualRequest.getZoneId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createZoneTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String parent = "parent-995424086";
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateZoneRequest actualRequest = ((CreateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(zoneId, actualRequest.getZoneId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    Zone zone = Zone.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Zone actualResponse = client.updateZoneAsync(zone, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateZoneRequest actualRequest = ((UpdateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      Zone zone = Zone.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateZoneAsync(zone, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteZoneTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");

    client.deleteZoneAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteZoneRequest actualRequest = ((DeleteZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteZoneTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteZoneAsync(name).get();

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteZoneRequest actualRequest = ((DeleteZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void signalZoneStateTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("signalZoneStateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
    SignalZoneStateRequest.StateSignal stateSignal =
        SignalZoneStateRequest.StateSignal.forNumber(0);

    Zone actualResponse = client.signalZoneStateAsync(name, stateSignal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignalZoneStateRequest actualRequest = ((SignalZoneStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(stateSignal, actualRequest.getStateSignal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signalZoneStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
      SignalZoneStateRequest.StateSignal stateSignal =
          SignalZoneStateRequest.StateSignal.forNumber(0);
      client.signalZoneStateAsync(name, stateSignal).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void signalZoneStateTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .addAllContacts(new ArrayList<Contact>())
            .setCiqUri("ciqUri-1360259935")
            .setNetworkConfig(ZoneNetworkConfig.newBuilder().build())
            .setGloballyUniqueId("globallyUniqueId-1207923364")
            .addAllSubscriptionConfigs(new ArrayList<SubscriptionConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("signalZoneStateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGDCHardwareManagement.addResponse(resultOperation);

    String name = "name3373707";
    SignalZoneStateRequest.StateSignal stateSignal =
        SignalZoneStateRequest.StateSignal.forNumber(0);

    Zone actualResponse = client.signalZoneStateAsync(name, stateSignal).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGDCHardwareManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignalZoneStateRequest actualRequest = ((SignalZoneStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(stateSignal, actualRequest.getStateSignal());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void signalZoneStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGDCHardwareManagement.addException(exception);

    try {
      String name = "name3373707";
      SignalZoneStateRequest.StateSignal stateSignal =
          SignalZoneStateRequest.StateSignal.forNumber(0);
      client.signalZoneStateAsync(name, stateSignal).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
