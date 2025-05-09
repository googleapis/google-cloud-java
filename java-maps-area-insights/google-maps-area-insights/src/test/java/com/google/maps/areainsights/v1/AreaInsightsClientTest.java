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

package com.google.maps.areainsights.v1;

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
public class AreaInsightsClientTest {
  private static MockAreaInsights mockAreaInsights;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AreaInsightsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAreaInsights = new MockAreaInsights();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAreaInsights));
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
    AreaInsightsSettings settings =
        AreaInsightsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AreaInsightsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void computeInsightsTest() throws Exception {
    ComputeInsightsResponse expectedResponse =
        ComputeInsightsResponse.newBuilder()
            .setCount(94851343)
            .addAllPlaceInsights(new ArrayList<PlaceInsight>())
            .build();
    mockAreaInsights.addResponse(expectedResponse);

    ComputeInsightsRequest request =
        ComputeInsightsRequest.newBuilder()
            .addAllInsights(new ArrayList<Insight>())
            .setFilter(Filter.newBuilder().build())
            .build();

    ComputeInsightsResponse actualResponse = client.computeInsights(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAreaInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeInsightsRequest actualRequest = ((ComputeInsightsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInsightsList(), actualRequest.getInsightsList());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeInsightsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAreaInsights.addException(exception);

    try {
      ComputeInsightsRequest request =
          ComputeInsightsRequest.newBuilder()
              .addAllInsights(new ArrayList<Insight>())
              .setFilter(Filter.newBuilder().build())
              .build();
      client.computeInsights(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
