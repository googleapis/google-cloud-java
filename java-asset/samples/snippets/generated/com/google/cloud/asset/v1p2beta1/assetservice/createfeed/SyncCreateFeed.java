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

package com.google.cloud.asset.v1p2beta1.samples;

// [START cloudasset_v1p2beta1_generated_AssetService_CreateFeed_sync]
import com.google.cloud.asset.v1p2beta1.AssetServiceClient;
import com.google.cloud.asset.v1p2beta1.CreateFeedRequest;
import com.google.cloud.asset.v1p2beta1.Feed;

public class SyncCreateFeed {

  public static void main(String[] args) throws Exception {
    syncCreateFeed();
  }

  public static void syncCreateFeed() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
      CreateFeedRequest request =
          CreateFeedRequest.newBuilder()
              .setParent("parent-995424086")
              .setFeedId("feedId-1278410919")
              .setFeed(Feed.newBuilder().build())
              .build();
      Feed response = assetServiceClient.createFeed(request);
    }
  }
}
// [END cloudasset_v1p2beta1_generated_AssetService_CreateFeed_sync]
