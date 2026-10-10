/*
 * Copyright 2026 Google LLC
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

package com.google.shopping.merchant.loyaltycustomers.v1;

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
public class LoyaltyCustomerMatchServiceClientTest {
  private static MockLoyaltyCustomerMatchService mockLoyaltyCustomerMatchService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LoyaltyCustomerMatchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLoyaltyCustomerMatchService = new MockLoyaltyCustomerMatchService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLoyaltyCustomerMatchService));
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
    LoyaltyCustomerMatchServiceSettings settings =
        LoyaltyCustomerMatchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LoyaltyCustomerMatchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void manageLoyaltyCustomerMatchTest() throws Exception {
    ManageLoyaltyCustomerMatchResponse expectedResponse =
        ManageLoyaltyCustomerMatchResponse.newBuilder()
            .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
            .build();
    mockLoyaltyCustomerMatchService.addResponse(expectedResponse);

    ManageLoyaltyCustomerMatchRequest request =
        ManageLoyaltyCustomerMatchRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
            .build();

    ManageLoyaltyCustomerMatchResponse actualResponse = client.manageLoyaltyCustomerMatch(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLoyaltyCustomerMatchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ManageLoyaltyCustomerMatchRequest actualRequest =
        ((ManageLoyaltyCustomerMatchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLoyaltyCustomer(), actualRequest.getLoyaltyCustomer());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void manageLoyaltyCustomerMatchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLoyaltyCustomerMatchService.addException(exception);

    try {
      ManageLoyaltyCustomerMatchRequest request =
          ManageLoyaltyCustomerMatchRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
              .build();
      client.manageLoyaltyCustomerMatch(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
