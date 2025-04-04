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

package com.google.spanner.adapter.v1.samples;

// [START spanner_v1_generated_Adapter_AdaptMessage_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.protobuf.ByteString;
import com.google.spanner.adapter.v1.AdaptMessageRequest;
import com.google.spanner.adapter.v1.AdaptMessageResponse;
import com.google.spanner.adapter.v1.AdapterClient;
import com.google.spanner.adapter.v1.SessionName;
import java.util.HashMap;

public class AsyncAdaptMessage {

  public static void main(String[] args) throws Exception {
    asyncAdaptMessage();
  }

  public static void asyncAdaptMessage() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdapterClient adapterClient = AdapterClient.create()) {
      AdaptMessageRequest request =
          AdaptMessageRequest.newBuilder()
              .setName(
                  SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
              .setProtocol("protocol-989163880")
              .setPayload(ByteString.EMPTY)
              .putAllAttachments(new HashMap<String, String>())
              .build();
      ServerStream<AdaptMessageResponse> stream =
          adapterClient.adaptMessageCallable().call(request);
      for (AdaptMessageResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END spanner_v1_generated_Adapter_AdaptMessage_async]
