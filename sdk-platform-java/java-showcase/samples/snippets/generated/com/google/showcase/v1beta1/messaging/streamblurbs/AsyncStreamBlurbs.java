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

package com.google.showcase.v1beta1.samples;

// [START localhost7469_v1beta1_generated_Messaging_StreamBlurbs_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.protobuf.Timestamp;
import com.google.showcase.v1beta1.MessagingClient;
import com.google.showcase.v1beta1.ProfileName;
import com.google.showcase.v1beta1.StreamBlurbsRequest;
import com.google.showcase.v1beta1.StreamBlurbsResponse;

public class AsyncStreamBlurbs {

  public static void main(String[] args) throws Exception {
    asyncStreamBlurbs();
  }

  public static void asyncStreamBlurbs() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MessagingClient messagingClient = MessagingClient.create()) {
      StreamBlurbsRequest request =
          StreamBlurbsRequest.newBuilder()
              .setName(ProfileName.of("[USER]").toString())
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      ServerStream<StreamBlurbsResponse> stream =
          messagingClient.streamBlurbsCallable().call(request);
      for (StreamBlurbsResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END localhost7469_v1beta1_generated_Messaging_StreamBlurbs_async]
