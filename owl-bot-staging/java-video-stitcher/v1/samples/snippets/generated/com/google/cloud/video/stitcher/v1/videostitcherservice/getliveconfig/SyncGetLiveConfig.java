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

package com.google.cloud.video.stitcher.v1.samples;

// [START videostitcher_v1_generated_VideoStitcherService_GetLiveConfig_sync]
import com.google.cloud.video.stitcher.v1.GetLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.LiveConfig;
import com.google.cloud.video.stitcher.v1.LiveConfigName;
import com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient;

public class SyncGetLiveConfig {

  public static void main(String[] args) throws Exception {
    syncGetLiveConfig();
  }

  public static void syncGetLiveConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VideoStitcherServiceClient videoStitcherServiceClient =
        VideoStitcherServiceClient.create()) {
      GetLiveConfigRequest request =
          GetLiveConfigRequest.newBuilder()
              .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
              .build();
      LiveConfig response = videoStitcherServiceClient.getLiveConfig(request);
    }
  }
}
// [END videostitcher_v1_generated_VideoStitcherService_GetLiveConfig_sync]
