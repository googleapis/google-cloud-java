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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_LiveStreamService_BatchRefreshMasterPlaylists_sync]
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsRequest;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsResponse;
import com.google.ads.admanager.v1.LiveStreamServiceClient;
import com.google.ads.admanager.v1.NetworkName;
import java.util.ArrayList;

public class SyncBatchRefreshMasterPlaylists {

  public static void main(String[] args) throws Exception {
    syncBatchRefreshMasterPlaylists();
  }

  public static void syncBatchRefreshMasterPlaylists() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
      BatchRefreshMasterPlaylistsRequest request =
          BatchRefreshMasterPlaylistsRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      BatchRefreshMasterPlaylistsResponse response =
          liveStreamServiceClient.batchRefreshMasterPlaylists(request);
    }
  }
}
// [END admanager_v1_generated_LiveStreamService_BatchRefreshMasterPlaylists_sync]
