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

package com.google.ads.datamanager.v1;

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
public class MarketingDataInsightsServiceClientTest {
  private static MockMarketingDataInsightsService mockMarketingDataInsightsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MarketingDataInsightsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMarketingDataInsightsService = new MockMarketingDataInsightsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMarketingDataInsightsService));
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
    MarketingDataInsightsServiceSettings settings =
        MarketingDataInsightsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MarketingDataInsightsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void retrieveInsightsTest() throws Exception {
    RetrieveInsightsResponse expectedResponse =
        RetrieveInsightsResponse.newBuilder()
            .addAllMarketingDataInsights(
                new ArrayList<RetrieveInsightsResponse.MarketingDataInsight>())
            .build();
    mockMarketingDataInsightsService.addResponse(expectedResponse);

    RetrieveInsightsRequest request =
        RetrieveInsightsRequest.newBuilder()
            .setParent("parent-995424086")
            .setBaseline(Baseline.newBuilder().build())
            .setUserListId("userListId1381604868")
            .build();

    RetrieveInsightsResponse actualResponse = client.retrieveInsights(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingDataInsightsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveInsightsRequest actualRequest = ((RetrieveInsightsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getBaseline(), actualRequest.getBaseline());
    Assert.assertEquals(request.getUserListId(), actualRequest.getUserListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveInsightsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingDataInsightsService.addException(exception);

    try {
      RetrieveInsightsRequest request =
          RetrieveInsightsRequest.newBuilder()
              .setParent("parent-995424086")
              .setBaseline(Baseline.newBuilder().build())
              .setUserListId("userListId1381604868")
              .build();
      client.retrieveInsights(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
