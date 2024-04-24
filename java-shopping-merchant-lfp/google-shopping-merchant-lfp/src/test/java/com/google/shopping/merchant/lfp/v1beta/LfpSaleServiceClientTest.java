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
public class LfpSaleServiceClientTest {
  private static MockLfpSaleService mockLfpSaleService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LfpSaleServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLfpSaleService = new MockLfpSaleService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLfpSaleService));
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
    LfpSaleServiceSettings settings =
        LfpSaleServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpSaleServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void insertLfpSaleTest() throws Exception {
    LfpSale expectedResponse =
        LfpSale.newBuilder()
            .setName("name3373707")
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setOfferId("offerId-1548813161")
            .setRegionCode("regionCode-1991004415")
            .setContentLanguage("contentLanguage810066673")
            .setGtin("gtin3183314")
            .setPrice(Price.newBuilder().build())
            .setQuantity(-1285004149)
            .setSaleTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setFeedLabel("feedLabel-1661895690")
            .build();
    mockLfpSaleService.addResponse(expectedResponse);

    InsertLfpSaleRequest request =
        InsertLfpSaleRequest.newBuilder()
            .setParent("parent-995424086")
            .setLfpSale(LfpSale.newBuilder().build())
            .build();

    LfpSale actualResponse = client.insertLfpSale(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpSaleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertLfpSaleRequest actualRequest = ((InsertLfpSaleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLfpSale(), actualRequest.getLfpSale());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertLfpSaleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpSaleService.addException(exception);

    try {
      InsertLfpSaleRequest request =
          InsertLfpSaleRequest.newBuilder()
              .setParent("parent-995424086")
              .setLfpSale(LfpSale.newBuilder().build())
              .build();
      client.insertLfpSale(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
