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

// [START dialogflow_v2_generated_ConversationDatasets_DeleteConversationDataset_String_sync]
import com.google.cloud.dialogflow.v2.ConversationDatasetName;
import com.google.cloud.dialogflow.v2.ConversationDatasetsClient;
import com.google.protobuf.Empty;

public class SyncDeleteConversationDatasetString {

  public static void main(String[] args) throws Exception {
    syncDeleteConversationDatasetString();
  }

  public static void syncDeleteConversationDatasetString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversationDatasetsClient conversationDatasetsClient =
        ConversationDatasetsClient.create()) {
      String name =
          ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
              .toString();
      conversationDatasetsClient.deleteConversationDatasetAsync(name).get();
    }
  }
}
// [END dialogflow_v2_generated_ConversationDatasets_DeleteConversationDataset_String_sync]
