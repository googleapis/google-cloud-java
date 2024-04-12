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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_ConversationalSearchService_ConverseConversation_sync]
import com.google.cloud.discoveryengine.v1.Conversation;
import com.google.cloud.discoveryengine.v1.ConversationName;
import com.google.cloud.discoveryengine.v1.ConversationalSearchServiceClient;
import com.google.cloud.discoveryengine.v1.ConverseConversationRequest;
import com.google.cloud.discoveryengine.v1.ConverseConversationResponse;
import com.google.cloud.discoveryengine.v1.SearchRequest;
import com.google.cloud.discoveryengine.v1.ServingConfigName;
import com.google.cloud.discoveryengine.v1.TextInput;
import java.util.HashMap;

public class SyncConverseConversation {

  public static void main(String[] args) throws Exception {
    syncConverseConversation();
  }

  public static void syncConverseConversation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationalSearchServiceClient conversationalSearchServiceClient =
        ConversationalSearchServiceClient.create()) {
      ConverseConversationRequest request =
          ConverseConversationRequest.newBuilder()
              .setName(
                  ConversationName.ofProjectLocationDataStoreConversationName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                      .toString())
              .setQuery(TextInput.newBuilder().build())
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setConversation(Conversation.newBuilder().build())
              .setSafeSearch(true)
              .putAllUserLabels(new HashMap<String, String>())
              .setSummarySpec(SearchRequest.ContentSearchSpec.SummarySpec.newBuilder().build())
              .setFilter("filter-1274492040")
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .build();
      ConverseConversationResponse response =
          conversationalSearchServiceClient.converseConversation(request);
    }
  }
}
// [END discoveryengine_v1_generated_ConversationalSearchService_ConverseConversation_sync]
