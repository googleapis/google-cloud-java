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

// [START dialogflow_v2_generated_conversationmodelsclient_createconversationmodel_sync]
import com.google.cloud.dialogflow.v2.ConversationModel;
import com.google.cloud.dialogflow.v2.ConversationModelsClient;
import com.google.cloud.dialogflow.v2.CreateConversationModelRequest;

public class SyncCreateConversationModel {

  public static void main(String[] args) throws Exception {
    syncCreateConversationModel();
  }

  public static void syncCreateConversationModel() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
      CreateConversationModelRequest request =
          CreateConversationModelRequest.newBuilder()
              .setParent("parent-995424086")
              .setConversationModel(ConversationModel.newBuilder().build())
              .build();
      ConversationModel response =
          conversationModelsClient.createConversationModelAsync(request).get();
    }
  }
}
// [END dialogflow_v2_generated_conversationmodelsclient_createconversationmodel_sync]
