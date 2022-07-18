/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.asset.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.CreateFeedRequest;
import com.google.cloud.asset.v1.DeleteFeedRequest;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.FeedName;
import com.google.cloud.asset.v1.FeedOutputConfig;
import com.google.cloud.asset.v1.GetFeedRequest;
import com.google.cloud.asset.v1.ListFeedsRequest;
import com.google.cloud.asset.v1.ListFeedsResponse;
import com.google.cloud.asset.v1.ProjectName;
import com.google.cloud.asset.v1.PubsubDestination;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.resourcemanager.ProjectInfo;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.pubsub.v1.ProjectTopicName;
import java.io.IOException;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String formatProjectName = ProjectName.of(PROJECT_ID).toString();
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String FEED_ID = "test-feed-id-" + ID;
  private static final String TOPIC_ID = "test-topic-id-" + ID;
  private static final ProjectTopicName TOPIC_NAME = ProjectTopicName.of(PROJECT_ID, TOPIC_ID);
  private static AssetServiceClient assetServiceClient;
  private static TopicAdminClient topicAdminClient;
  private static Feed feed;
  private static String feedName;
  private static String formattedFeedName;

  @BeforeClass
  public static void setUp() throws IOException {

    /* create topic */
    topicAdminClient = TopicAdminClient.create();
    topicAdminClient.createTopic(TOPIC_NAME);

    /* create feed */
    assetServiceClient = AssetServiceClient.create();
    PubsubDestination destination =
        PubsubDestination.newBuilder().setTopic(TOPIC_NAME.toString()).build();
    FeedOutputConfig outputConfig =
        FeedOutputConfig.newBuilder().setPubsubDestination(destination).build();
    Feed createFeed = Feed.newBuilder().addAssetNames(ID).setFeedOutputConfig(outputConfig).build();
    CreateFeedRequest request =
        CreateFeedRequest.newBuilder()
            .setParent(formatProjectName)
            .setFeedId(FEED_ID)
            .setFeed(createFeed)
            .build();
    feed = assetServiceClient.createFeed(request);
    feedName = getName(feed.getName());
    formattedFeedName = FeedName.of(getProjectNumber(PROJECT_ID), feedName).toString();
  }

  @AfterClass
  public static void tearDown() {
    /* delete topic */
    topicAdminClient.deleteTopic(TOPIC_NAME);

    /* delete feed */
    DeleteFeedRequest feedRequest =
        DeleteFeedRequest.newBuilder().setName(formattedFeedName).build();
    assetServiceClient.deleteFeed(feedRequest);
    assetServiceClient.close();
  }

  @Test
  public void getFeedTest() {
    GetFeedRequest request = GetFeedRequest.newBuilder().setName(formattedFeedName).build();
    Feed actualFeed = assetServiceClient.getFeed(request);
    assertEquals(feed.getName(), actualFeed.getName());
    assertEquals(feed.getAssetNamesList(), actualFeed.getAssetNamesList());
    assertEquals(feed.getAssetNamesCount(), actualFeed.getAssetNamesCount());
    assertEquals(feed.getFeedOutputConfig(), actualFeed.getFeedOutputConfig());
  }

  @Test
  public void listFeedsTest() {
    ListFeedsRequest request = ListFeedsRequest.newBuilder().setParent(formatProjectName).build();
    ListFeedsResponse feeds = assetServiceClient.listFeeds(request);
    for (Feed actualFeed : feeds.getFeedsList()) {
      if (feed.getName().equals(actualFeed.getName())) {
        assertEquals(feed.getAssetNamesList(), actualFeed.getAssetNamesList());
        assertEquals(feed.getAssetNamesCount(), actualFeed.getAssetNamesCount());
        assertEquals(feed.getFeedOutputConfig(), actualFeed.getFeedOutputConfig());
      }
    }
  }

  private static String getName(String name) {
    return name.substring(name.lastIndexOf("/")).replace("/", "");
  }

  private static String getProjectNumber(String projectId) {
    ResourceManager resourceManager = ResourceManagerOptions.getDefaultInstance().getService();
    ProjectInfo project = resourceManager.get(projectId);
    return Long.toString(project.getProjectNumber());
  }
}
