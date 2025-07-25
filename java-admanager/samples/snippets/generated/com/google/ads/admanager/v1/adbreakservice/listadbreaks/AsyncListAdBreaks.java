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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_AdBreakService_ListAdBreaks_async]
import com.google.ads.admanager.v1.AdBreak;
import com.google.ads.admanager.v1.AdBreakServiceClient;
import com.google.ads.admanager.v1.ListAdBreaksRequest;
import com.google.ads.admanager.v1.LiveStreamEventName;
import com.google.api.core.ApiFuture;

public class AsyncListAdBreaks {

  public static void main(String[] args) throws Exception {
    asyncListAdBreaks();
  }

  public static void asyncListAdBreaks() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
      ListAdBreaksRequest request =
          ListAdBreaksRequest.newBuilder()
              .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setSkip(3532159)
              .build();
      ApiFuture<AdBreak> future =
          adBreakServiceClient.listAdBreaksPagedCallable().futureCall(request);
      // Do something.
      for (AdBreak element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END admanager_v1_generated_AdBreakService_ListAdBreaks_async]
