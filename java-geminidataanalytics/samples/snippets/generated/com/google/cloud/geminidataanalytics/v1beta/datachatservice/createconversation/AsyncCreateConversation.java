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

package com.google.cloud.geminidataanalytics.v1beta.samples;

// [START geminidataanalytics_v1beta_generated_DataChatService_CreateConversation_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.geminidataanalytics.v1beta.Conversation;
import com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest;
import com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.LocationName;

public class AsyncCreateConversation {

  public static void main(String[] args) throws Exception {
    asyncCreateConversation();
  }

  public static void asyncCreateConversation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataChatServiceClient dataChatServiceClient = DataChatServiceClient.create()) {
      CreateConversationRequest request =
          CreateConversationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setConversationId("conversationId-1676095234")
              .setConversation(Conversation.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Conversation> future =
          dataChatServiceClient.createConversationCallable().futureCall(request);
      // Do something.
      Conversation response = future.get();
    }
  }
}
// [END geminidataanalytics_v1beta_generated_DataChatService_CreateConversation_async]
