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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.type.CustomAttribute;
import com.google.shopping.type.Price;
import com.google.type.Interval;
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
public class LocalInventoryServiceClientTest {
  private static MockLocalInventoryService mockLocalInventoryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LocalInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLocalInventoryService = new MockLocalInventoryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLocalInventoryService));
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
    LocalInventoryServiceSettings settings =
        LocalInventoryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LocalInventoryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listLocalInventoriesTest() throws Exception {
    LocalInventory responsesElement = LocalInventory.newBuilder().build();
    ListLocalInventoriesResponse expectedResponse =
        ListLocalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocalInventories(Arrays.asList(responsesElement))
            .build();
    mockLocalInventoryService.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    ListLocalInventoriesPagedResponse pagedListResponse = client.listLocalInventories(parent);

    List<LocalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocalInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocalInventoriesRequest actualRequest =
        ((ListLocalInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocalInventoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocalInventoryService.addException(exception);

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
    mockLocalInventoryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLocalInventoriesPagedResponse pagedListResponse = client.listLocalInventories(parent);

    List<LocalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocalInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocalInventoriesRequest actualRequest =
        ((ListLocalInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocalInventoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocalInventoryService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLocalInventoryService.addResponse(expectedResponse);

    InsertLocalInventoryRequest request =
        InsertLocalInventoryRequest.newBuilder()
            .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setLocalInventory(LocalInventory.newBuilder().build())
            .build();

    LocalInventory actualResponse = client.insertLocalInventory(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertLocalInventoryRequest actualRequest =
        ((InsertLocalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLocalInventory(), actualRequest.getLocalInventory());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertLocalInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocalInventoryService.addException(exception);

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
    mockLocalInventoryService.addResponse(expectedResponse);

    LocalInventoryName name = LocalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[STORE_CODE]");

    client.deleteLocalInventory(name);

    List<AbstractMessage> actualRequests = mockLocalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLocalInventoryRequest actualRequest =
        ((DeleteLocalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLocalInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocalInventoryService.addException(exception);

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
    mockLocalInventoryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteLocalInventory(name);

    List<AbstractMessage> actualRequests = mockLocalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLocalInventoryRequest actualRequest =
        ((DeleteLocalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLocalInventoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocalInventoryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLocalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
