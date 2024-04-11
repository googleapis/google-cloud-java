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
public class RegionalInventoryServiceClientTest {
  private static MockRegionalInventoryService mockRegionalInventoryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RegionalInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRegionalInventoryService = new MockRegionalInventoryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRegionalInventoryService));
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
    RegionalInventoryServiceSettings settings =
        RegionalInventoryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionalInventoryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRegionalInventoriesTest() throws Exception {
    RegionalInventory responsesElement = RegionalInventory.newBuilder().build();
    ListRegionalInventoriesResponse expectedResponse =
        ListRegionalInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegionalInventories(Arrays.asList(responsesElement))
            .build();
    mockRegionalInventoryService.addResponse(expectedResponse);

    ProductName parent = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    ListRegionalInventoriesPagedResponse pagedListResponse = client.listRegionalInventories(parent);

    List<RegionalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionalInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegionalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegionalInventoriesRequest actualRequest =
        ((ListRegionalInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegionalInventoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionalInventoryService.addException(exception);

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
    mockRegionalInventoryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRegionalInventoriesPagedResponse pagedListResponse = client.listRegionalInventories(parent);

    List<RegionalInventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegionalInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegionalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegionalInventoriesRequest actualRequest =
        ((ListRegionalInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegionalInventoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionalInventoryService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegionalInventoryService.addResponse(expectedResponse);

    InsertRegionalInventoryRequest request =
        InsertRegionalInventoryRequest.newBuilder()
            .setParent(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
            .setRegionalInventory(RegionalInventory.newBuilder().build())
            .build();

    RegionalInventory actualResponse = client.insertRegionalInventory(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegionalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertRegionalInventoryRequest actualRequest =
        ((InsertRegionalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRegionalInventory(), actualRequest.getRegionalInventory());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertRegionalInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionalInventoryService.addException(exception);

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
    mockRegionalInventoryService.addResponse(expectedResponse);

    RegionalInventoryName name = RegionalInventoryName.of("[ACCOUNT]", "[PRODUCT]", "[REGION]");

    client.deleteRegionalInventory(name);

    List<AbstractMessage> actualRequests = mockRegionalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegionalInventoryRequest actualRequest =
        ((DeleteRegionalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegionalInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionalInventoryService.addException(exception);

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
    mockRegionalInventoryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRegionalInventory(name);

    List<AbstractMessage> actualRequests = mockRegionalInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegionalInventoryRequest actualRequest =
        ((DeleteRegionalInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegionalInventoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegionalInventoryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRegionalInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
