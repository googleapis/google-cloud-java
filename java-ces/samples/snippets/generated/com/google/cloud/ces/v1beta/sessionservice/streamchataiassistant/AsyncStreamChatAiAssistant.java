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

package com.google.cloud.ces.v1beta.samples;

// [START ces_v1beta_generated_SessionService_StreamChatAiAssistant_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.ces.v1beta.AssistantConfirmationResponse;
import com.google.cloud.ces.v1beta.AssistantSessionName;
import com.google.cloud.ces.v1beta.OperationCompletedEvent;
import com.google.cloud.ces.v1beta.SessionServiceClient;
import com.google.cloud.ces.v1beta.StreamChatAiAssistantRequest;
import com.google.cloud.ces.v1beta.StreamChatAiAssistantResponse;
import java.util.ArrayList;

public class AsyncStreamChatAiAssistant {

  public static void main(String[] args) throws Exception {
    asyncStreamChatAiAssistant();
  }

  public static void asyncStreamChatAiAssistant() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
      StreamChatAiAssistantRequest request =
          StreamChatAiAssistantRequest.newBuilder()
              .setName(
                  AssistantSessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[ASSISTANT_SESSION]")
                      .toString())
              .setMessage("message954925063")
              .addAllAttachedGcsUris(new ArrayList<String>())
              .setContextToken("contextToken1106626954")
              .setConfirmationResponse(AssistantConfirmationResponse.newBuilder().build())
              .addAllClientCapabilities(
                  new ArrayList<StreamChatAiAssistantRequest.ClientCapability>())
              .setOperationCompletedEvent(OperationCompletedEvent.newBuilder().build())
              .setResumeFromSequenceNumber(15486916)
              .setAttachOnly(true)
              .build();
      ServerStream<StreamChatAiAssistantResponse> stream =
          sessionServiceClient.streamChatAiAssistantCallable().call(request);
      for (StreamChatAiAssistantResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END ces_v1beta_generated_SessionService_StreamChatAiAssistant_async]
