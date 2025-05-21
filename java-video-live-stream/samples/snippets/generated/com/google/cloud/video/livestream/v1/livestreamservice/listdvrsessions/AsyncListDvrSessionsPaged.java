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

package com.google.cloud.video.livestream.v1.samples;

// [START livestream_v1_generated_LivestreamService_ListDvrSessions_Paged_async]
import com.google.cloud.video.livestream.v1.ChannelName;
import com.google.cloud.video.livestream.v1.DvrSession;
import com.google.cloud.video.livestream.v1.ListDvrSessionsRequest;
import com.google.cloud.video.livestream.v1.ListDvrSessionsResponse;
import com.google.cloud.video.livestream.v1.LivestreamServiceClient;
import com.google.common.base.Strings;

public class AsyncListDvrSessionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListDvrSessionsPaged();
  }

  public static void asyncListDvrSessionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
      ListDvrSessionsRequest request =
          ListDvrSessionsRequest.newBuilder()
              .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListDvrSessionsResponse response =
            livestreamServiceClient.listDvrSessionsCallable().call(request);
        for (DvrSession element : response.getDvrSessionsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END livestream_v1_generated_LivestreamService_ListDvrSessions_Paged_async]
