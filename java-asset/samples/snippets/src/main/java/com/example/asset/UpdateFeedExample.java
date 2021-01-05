/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.asset;

// [START asset_quickstart_update_feed]
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.FeedOutputConfig;
import com.google.cloud.asset.v1.PubsubDestination;
import com.google.cloud.asset.v1.UpdateFeedRequest;
import com.google.protobuf.FieldMask;

public class UpdateFeedExample {

  // Update a feed
  public static void updateFeed(String feedName, String topic) throws Exception {
    // String feedName = "MY_FEED_NAME"
    // String topic = "projects/[PROJECT_ID]/topics/[TOPIC_NAME]"
    Feed feed = Feed.newBuilder()
        .setName(feedName)
        .setFeedOutputConfig(
            FeedOutputConfig.newBuilder().setPubsubDestination(
                PubsubDestination.newBuilder().setTopic(topic).build()).build()).build();
    UpdateFeedRequest request = UpdateFeedRequest.newBuilder()
        .setFeed(feed)
        .setUpdateMask(
          FieldMask.newBuilder().addPaths("feed_output_config.pubsub_destination.topic").build())
        .build();
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AssetServiceClient client = AssetServiceClient.create()) {
      Feed response = client.updateFeed(request);
      System.out.println("Feed updated successfully: " + response.getName());
    } catch (Exception e) {
      System.out.println("Error during UpdateFeed: \n" + e.toString());
    }
  }
}
// [END asset_quickstart_update_feed]
