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

package com.google.cloud.geminidataanalytics.v1beta.samples;

// [START geminidataanalytics_v1beta_generated_DataA2AService_SendStreamingMessage_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.geminidataanalytics.v1beta.A2AMessage;
import com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageConfiguration;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest;
import com.google.cloud.geminidataanalytics.v1beta.StreamResponse;
import com.google.protobuf.Struct;

public class AsyncSendStreamingMessage {

  public static void main(String[] args) throws Exception {
    asyncSendStreamingMessage();
  }

  public static void asyncSendStreamingMessage() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataA2AServiceClient dataA2AServiceClient = DataA2AServiceClient.create()) {
      SendMessageRequest request =
          SendMessageRequest.newBuilder()
              .setMessage(A2AMessage.newBuilder().build())
              .setConfiguration(SendMessageConfiguration.newBuilder().build())
              .setMetadata(Struct.newBuilder().build())
              .setTenant("tenant-877336406")
              .build();
      ServerStream<StreamResponse> stream =
          dataA2AServiceClient.sendStreamingMessageCallable().call(request);
      for (StreamResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END geminidataanalytics_v1beta_generated_DataA2AService_SendStreamingMessage_async]
