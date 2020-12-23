/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1p2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class AssetServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private AssetServiceClient client;
  private LocalChannelProvider channelProvider;
  private static MockAssetService mockAssetService;

  @BeforeClass
  public static void startStaticServer() {
    mockAssetService = new MockAssetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAssetService));
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
    AssetServiceSettings settings =
        AssetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockAssetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    Feed actualResponse = client.createFeed(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeedRequest actualRequest = ((CreateFeedRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.createFeed(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockAssetService.addResponse(expectedResponse);

    FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");

    Feed actualResponse = client.getFeed(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeedRequest actualRequest = ((GetFeedRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
      client.getFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedTest2() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockAssetService.addResponse(expectedResponse);

    String name = "name3373707";

    Feed actualResponse = client.getFeed(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeedRequest actualRequest = ((GetFeedRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedsTest() throws Exception {
    ListFeedsResponse expectedResponse =
        ListFeedsResponse.newBuilder().addAllFeeds(new ArrayList<Feed>()).build();
    mockAssetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeedsResponse actualResponse = client.listFeeds(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeedsRequest actualRequest = ((ListFeedsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeedsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeeds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockAssetService.addResponse(expectedResponse);

    Feed feed = Feed.newBuilder().build();

    Feed actualResponse = client.updateFeed(feed);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeedRequest actualRequest = ((UpdateFeedRequest) actualRequests.get(0));

    Assert.assertEquals(feed, actualRequest.getFeed());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      Feed feed = Feed.newBuilder().build();
      client.updateFeed(feed);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssetService.addResponse(expectedResponse);

    FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");

    client.deleteFeed(name);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeedRequest actualRequest = ((DeleteFeedRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
      client.deleteFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssetService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFeed(name);

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeedRequest actualRequest = ((DeleteFeedRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
