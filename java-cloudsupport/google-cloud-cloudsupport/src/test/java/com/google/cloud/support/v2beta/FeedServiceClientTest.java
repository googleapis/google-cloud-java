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

package com.google.cloud.support.v2beta;

import static com.google.cloud.support.v2beta.FeedServiceClient.ShowFeedPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
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
public class FeedServiceClientTest {
  private static MockFeedService mockFeedService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FeedServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFeedService = new MockFeedService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFeedService));
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
    FeedServiceSettings settings =
        FeedServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeedServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void showFeedTest() throws Exception {
    FeedItem responsesElement = FeedItem.newBuilder().build();
    ShowFeedResponse expectedResponse =
        ShowFeedResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedItems(Arrays.asList(responsesElement))
            .build();
    mockFeedService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    ShowFeedPagedResponse pagedListResponse = client.showFeed(parent);

    List<FeedItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeedService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowFeedRequest actualRequest = ((ShowFeedRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showFeedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeedService.addException(exception);

    try {
      CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
      client.showFeed(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showFeedTest2() throws Exception {
    FeedItem responsesElement = FeedItem.newBuilder().build();
    ShowFeedResponse expectedResponse =
        ShowFeedResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedItems(Arrays.asList(responsesElement))
            .build();
    mockFeedService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ShowFeedPagedResponse pagedListResponse = client.showFeed(parent);

    List<FeedItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeedService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowFeedRequest actualRequest = ((ShowFeedRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showFeedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeedService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.showFeed(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
