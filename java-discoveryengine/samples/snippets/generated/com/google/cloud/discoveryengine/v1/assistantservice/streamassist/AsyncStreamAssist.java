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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_AssistantService_StreamAssist_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.discoveryengine.v1.AssistUserMetadata;
import com.google.cloud.discoveryengine.v1.AssistantName;
import com.google.cloud.discoveryengine.v1.AssistantServiceClient;
import com.google.cloud.discoveryengine.v1.Query;
import com.google.cloud.discoveryengine.v1.SessionName;
import com.google.cloud.discoveryengine.v1.StreamAssistRequest;
import com.google.cloud.discoveryengine.v1.StreamAssistResponse;

public class AsyncStreamAssist {

  public static void main(String[] args) throws Exception {
    asyncStreamAssist();
  }

  public static void asyncStreamAssist() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssistantServiceClient assistantServiceClient = AssistantServiceClient.create()) {
      StreamAssistRequest request =
          StreamAssistRequest.newBuilder()
              .setName(
                  AssistantName.of(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[ASSISTANT]")
                      .toString())
              .setQuery(Query.newBuilder().build())
              .setSession(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setUserMetadata(AssistUserMetadata.newBuilder().build())
              .setToolsSpec(StreamAssistRequest.ToolsSpec.newBuilder().build())
              .setGenerationSpec(StreamAssistRequest.GenerationSpec.newBuilder().build())
              .build();
      ServerStream<StreamAssistResponse> stream =
          assistantServiceClient.streamAssistCallable().call(request);
      for (StreamAssistResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END discoveryengine_v1_generated_AssistantService_StreamAssist_async]
