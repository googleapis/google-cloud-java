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

package com.google.shopping.merchant.lfp.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import com.google.shopping.type.Price;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class LfpInventoryServiceClientTest {
  private static MockLfpInventoryService mockLfpInventoryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LfpInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLfpInventoryService = new MockLfpInventoryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLfpInventoryService));
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
    LfpInventoryServiceSettings settings =
        LfpInventoryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpInventoryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void insertLfpInventoryTest() throws Exception {
    LfpInventory expectedResponse =
        LfpInventory.newBuilder()
            .setName(
                LfpInventoryName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]", "[OFFER]")
                    .toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setOfferId("offerId-1548813161")
            .setRegionCode("regionCode-1991004415")
            .setContentLanguage("contentLanguage810066673")
            .setGtin("gtin3183314")
            .setPrice(Price.newBuilder().build())
            .setAvailability("availability1997542747")
            .setQuantity(-1285004149)
            .setCollectionTime(Timestamp.newBuilder().build())
            .setPickupMethod("pickupMethod139786877")
            .setPickupSla("pickupSla-1416603380")
            .setFeedLabel("feedLabel-1661895690")
            .build();
    mockLfpInventoryService.addResponse(expectedResponse);

    InsertLfpInventoryRequest request =
        InsertLfpInventoryRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setLfpInventory(LfpInventory.newBuilder().build())
            .build();

    LfpInventory actualResponse = client.insertLfpInventory(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpInventoryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertLfpInventoryRequest actualRequest = ((InsertLfpInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLfpInventory(), actualRequest.getLfpInventory());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertLfpInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpInventoryService.addException(exception);

    try {
      InsertLfpInventoryRequest request =
          InsertLfpInventoryRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setLfpInventory(LfpInventory.newBuilder().build())
              .build();
      client.insertLfpInventory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
