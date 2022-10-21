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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_participantsclient_listsuggestions_paged_async]
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse;
import com.google.cloud.dialogflow.v2beta1.ParticipantsClient;
import com.google.cloud.dialogflow.v2beta1.Suggestion;
import com.google.common.base.Strings;

public class AsyncListSuggestionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSuggestionsPaged();
  }

  public static void asyncListSuggestionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ParticipantsClient participantsClient = ParticipantsClient.create()) {
      ListSuggestionsRequest request =
          ListSuggestionsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListSuggestionsResponse response =
            participantsClient.listSuggestionsCallable().call(request);
        for (Suggestion element : response.getSuggestionsList()) {
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
// [END dialogflow_v2beta1_generated_participantsclient_listsuggestions_paged_async]
