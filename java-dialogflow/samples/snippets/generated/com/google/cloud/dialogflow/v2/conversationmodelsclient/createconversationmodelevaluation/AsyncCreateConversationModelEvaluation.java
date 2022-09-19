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

package com.google.cloud.dialogflow.v2.samples;

// [START dialogflow_v2_generated_conversationmodelsclient_createconversationmodelevaluation_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.v2.ConversationModelEvaluation;
import com.google.cloud.dialogflow.v2.ConversationModelName;
import com.google.cloud.dialogflow.v2.ConversationModelsClient;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest;
import com.google.longrunning.Operation;

public class AsyncCreateConversationModelEvaluation {

  public static void main(String[] args) throws Exception {
    asyncCreateConversationModelEvaluation();
  }

  public static void asyncCreateConversationModelEvaluation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
      CreateConversationModelEvaluationRequest request =
          CreateConversationModelEvaluationRequest.newBuilder()
              .setParent(
                  ConversationModelName.ofProjectLocationConversationModelName(
                          "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
                      .toString())
              .setConversationModelEvaluation(ConversationModelEvaluation.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          conversationModelsClient.createConversationModelEvaluationCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END dialogflow_v2_generated_conversationmodelsclient_createconversationmodelevaluation_async]
