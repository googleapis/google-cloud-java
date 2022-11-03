/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class RecommendationServiceClientTest {
  private static MockRecommendationService mockRecommendationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RecommendationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRecommendationService = new MockRecommendationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRecommendationService));
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
    RecommendationServiceSettings settings =
        RecommendationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RecommendationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void recommendTest() throws Exception {
    RecommendResponse expectedResponse =
        RecommendResponse.newBuilder()
            .addAllResults(new ArrayList<RecommendResponse.RecommendationResult>())
            .setAttributionToken("attributionToken104706234")
            .addAllMissingIds(new ArrayList<String>())
            .setValidateOnly(true)
            .build();
    mockRecommendationService.addResponse(expectedResponse);

    RecommendRequest request =
        RecommendRequest.newBuilder()
            .setServingConfig(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setUserEvent(UserEvent.newBuilder().build())
            .setPageSize(883849137)
            .setFilter("filter-1274492040")
            .setValidateOnly(true)
            .putAllParams(new HashMap<String, Value>())
            .putAllUserLabels(new HashMap<String, String>())
            .build();

    RecommendResponse actualResponse = client.recommend(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommendationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecommendRequest actualRequest = ((RecommendRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServingConfig(), actualRequest.getServingConfig());
    Assert.assertEquals(request.getUserEvent(), actualRequest.getUserEvent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertEquals(request.getParamsMap(), actualRequest.getParamsMap());
    Assert.assertEquals(request.getUserLabelsMap(), actualRequest.getUserLabelsMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recommendExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommendationService.addException(exception);

    try {
      RecommendRequest request =
          RecommendRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.of(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setUserEvent(UserEvent.newBuilder().build())
              .setPageSize(883849137)
              .setFilter("filter-1274492040")
              .setValidateOnly(true)
              .putAllParams(new HashMap<String, Value>())
              .putAllUserLabels(new HashMap<String, String>())
              .build();
      client.recommend(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
