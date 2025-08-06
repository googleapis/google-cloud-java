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

package com.google.shopping.merchant.lfp.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class LfpMerchantStateServiceClientTest {
  private static MockLfpMerchantStateService mockLfpMerchantStateService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LfpMerchantStateServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLfpMerchantStateService = new MockLfpMerchantStateService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLfpMerchantStateService));
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
    LfpMerchantStateServiceSettings settings =
        LfpMerchantStateServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpMerchantStateServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getLfpMerchantStateTest() throws Exception {
    LfpMerchantState expectedResponse =
        LfpMerchantState.newBuilder()
            .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
            .setLinkedGbps(-1308276092)
            .addAllStoreStates(new ArrayList<LfpMerchantState.LfpStoreState>())
            .setInventoryStats(LfpMerchantState.InventoryStats.newBuilder().build())
            .addAllCountrySettings(new ArrayList<LfpMerchantState.CountrySettings>())
            .build();
    mockLfpMerchantStateService.addResponse(expectedResponse);

    LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");

    LfpMerchantState actualResponse = client.getLfpMerchantState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpMerchantStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLfpMerchantStateRequest actualRequest = ((GetLfpMerchantStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLfpMerchantStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpMerchantStateService.addException(exception);

    try {
      LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");
      client.getLfpMerchantState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLfpMerchantStateTest2() throws Exception {
    LfpMerchantState expectedResponse =
        LfpMerchantState.newBuilder()
            .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
            .setLinkedGbps(-1308276092)
            .addAllStoreStates(new ArrayList<LfpMerchantState.LfpStoreState>())
            .setInventoryStats(LfpMerchantState.InventoryStats.newBuilder().build())
            .addAllCountrySettings(new ArrayList<LfpMerchantState.CountrySettings>())
            .build();
    mockLfpMerchantStateService.addResponse(expectedResponse);

    String name = "name3373707";

    LfpMerchantState actualResponse = client.getLfpMerchantState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpMerchantStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLfpMerchantStateRequest actualRequest = ((GetLfpMerchantStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLfpMerchantStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpMerchantStateService.addException(exception);

    try {
      String name = "name3373707";
      client.getLfpMerchantState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
