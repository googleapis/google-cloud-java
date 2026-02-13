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

package com.google.cloud.ces.v1.samples;

// [START ces_v1_generated_AgentService_ListConversations_Paged_async]
import com.google.cloud.ces.v1.AgentServiceClient;
import com.google.cloud.ces.v1.AppName;
import com.google.cloud.ces.v1.Conversation;
import com.google.cloud.ces.v1.ListConversationsRequest;
import com.google.cloud.ces.v1.ListConversationsResponse;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncListConversationsPaged {

  public static void main(String[] args) throws Exception {
    asyncListConversationsPaged();
  }

  public static void asyncListConversationsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
      ListConversationsRequest request =
          ListConversationsRequest.newBuilder()
              .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .addAllSources(new ArrayList<Conversation.Source>())
              .build();
      while (true) {
        ListConversationsResponse response =
            agentServiceClient.listConversationsCallable().call(request);
        for (Conversation element : response.getConversationsList()) {
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
// [END ces_v1_generated_AgentService_ListConversations_Paged_async]
