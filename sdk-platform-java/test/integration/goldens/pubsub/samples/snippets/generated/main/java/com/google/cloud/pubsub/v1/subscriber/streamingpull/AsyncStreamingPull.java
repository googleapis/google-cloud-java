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

package com.google.cloud.pubsub.v1.samples;

// [START pubsub_v1_generated_Subscriber_StreamingPull_async]
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriptionName;
import java.util.ArrayList;

public class AsyncStreamingPull {

  public static void main(String[] args) throws Exception {
    asyncStreamingPull();
  }

  public static void asyncStreamingPull() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      BidiStream<StreamingPullRequest, StreamingPullResponse> bidiStream =
          subscriptionAdminClient.streamingPullCallable().call();
      StreamingPullRequest request =
          StreamingPullRequest.newBuilder()
              .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
              .addAllAckIds(new ArrayList<String>())
              .addAllModifyDeadlineSeconds(new ArrayList<Integer>())
              .addAllModifyDeadlineAckIds(new ArrayList<String>())
              .setStreamAckDeadlineSeconds(1875467245)
              .setClientId("clientId908408390")
              .setMaxOutstandingMessages(-1315266996)
              .setMaxOutstandingBytes(-2103098517)
              .build();
      bidiStream.send(request);
      for (StreamingPullResponse response : bidiStream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END pubsub_v1_generated_Subscriber_StreamingPull_async]
