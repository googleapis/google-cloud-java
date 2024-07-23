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

package com.google.chat.v1.samples;

// [START chat_v1_generated_ChatService_ListSpaceEvents_Paged_async]
import com.google.chat.v1.ChatServiceClient;
import com.google.chat.v1.ListSpaceEventsRequest;
import com.google.chat.v1.ListSpaceEventsResponse;
import com.google.chat.v1.SpaceEvent;
import com.google.chat.v1.SpaceName;
import com.google.common.base.Strings;

public class AsyncListSpaceEventsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSpaceEventsPaged();
  }

  public static void asyncListSpaceEventsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
      ListSpaceEventsRequest request =
          ListSpaceEventsRequest.newBuilder()
              .setParent(SpaceName.of("[SPACE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListSpaceEventsResponse response =
            chatServiceClient.listSpaceEventsCallable().call(request);
        for (SpaceEvent element : response.getSpaceEventsList()) {
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
// [END chat_v1_generated_ChatService_ListSpaceEvents_Paged_async]
