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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_Conversations_GenerateStatelessSuggestion_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.v2beta1.ConversationContext;
import com.google.cloud.dialogflow.v2beta1.ConversationsClient;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSuggestionRequest;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSuggestionResponse;
import com.google.cloud.dialogflow.v2beta1.LocationName;
import com.google.cloud.dialogflow.v2beta1.TriggerEvent;
import java.util.ArrayList;

public class AsyncGenerateStatelessSuggestion {

  public static void main(String[] args) throws Exception {
    asyncGenerateStatelessSuggestion();
  }

  public static void asyncGenerateStatelessSuggestion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationsClient conversationsClient = ConversationsClient.create()) {
      GenerateStatelessSuggestionRequest request =
          GenerateStatelessSuggestionRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setConversationContext(ConversationContext.newBuilder().build())
              .addAllTriggerEvents(new ArrayList<TriggerEvent>())
              .build();
      ApiFuture<GenerateStatelessSuggestionResponse> future =
          conversationsClient.generateStatelessSuggestionCallable().futureCall(request);
      // Do something.
      GenerateStatelessSuggestionResponse response = future.get();
    }
  }
}
// [END dialogflow_v2beta1_generated_Conversations_GenerateStatelessSuggestion_async]
