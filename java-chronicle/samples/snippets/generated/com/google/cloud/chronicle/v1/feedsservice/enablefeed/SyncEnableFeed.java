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

package com.google.cloud.chronicle.v1.samples;

// [START chronicle_v1_generated_FeedsService_EnableFeed_sync]
import com.google.cloud.chronicle.v1.EnableFeedRequest;
import com.google.cloud.chronicle.v1.Feed;
import com.google.cloud.chronicle.v1.FeedName;
import com.google.cloud.chronicle.v1.FeedsServiceClient;

public class SyncEnableFeed {

  public static void main(String[] args) throws Exception {
    syncEnableFeed();
  }

  public static void syncEnableFeed() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
      EnableFeedRequest request =
          EnableFeedRequest.newBuilder()
              .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
              .build();
      Feed response = feedsServiceClient.enableFeed(request);
    }
  }
}
// [END chronicle_v1_generated_FeedsService_EnableFeed_sync]
