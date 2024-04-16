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

package com.google.cloud.discoveryengine.v1alpha;

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
public class RankServiceClientTest {
  private static MockLocations mockLocations;
  private static MockRankService mockRankService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RankServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRankService = new MockRankService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRankService, mockLocations));
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
    RankServiceSettings settings =
        RankServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RankServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void rankTest() throws Exception {
    RankResponse expectedResponse =
        RankResponse.newBuilder().addAllRecords(new ArrayList<RankingRecord>()).build();
    mockRankService.addResponse(expectedResponse);

    RankRequest request =
        RankRequest.newBuilder()
            .setRankingConfig(
                RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
            .setModel("model104069929")
            .setTopN(110545924)
            .setQuery("query107944136")
            .addAllRecords(new ArrayList<RankingRecord>())
            .setIgnoreRecordDetailsInResponse(true)
            .build();

    RankResponse actualResponse = client.rank(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RankRequest actualRequest = ((RankRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRankingConfig(), actualRequest.getRankingConfig());
    Assert.assertEquals(request.getModel(), actualRequest.getModel());
    Assert.assertEquals(request.getTopN(), actualRequest.getTopN());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getRecordsList(), actualRequest.getRecordsList());
    Assert.assertEquals(
        request.getIgnoreRecordDetailsInResponse(),
        actualRequest.getIgnoreRecordDetailsInResponse());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rankExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRankService.addException(exception);

    try {
      RankRequest request =
          RankRequest.newBuilder()
              .setRankingConfig(
                  RankingConfigName.of("[PROJECT]", "[LOCATION]", "[RANKING_CONFIG]").toString())
              .setModel("model104069929")
              .setTopN(110545924)
              .setQuery("query107944136")
              .addAllRecords(new ArrayList<RankingRecord>())
              .setIgnoreRecordDetailsInResponse(true)
              .build();
      client.rank(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
