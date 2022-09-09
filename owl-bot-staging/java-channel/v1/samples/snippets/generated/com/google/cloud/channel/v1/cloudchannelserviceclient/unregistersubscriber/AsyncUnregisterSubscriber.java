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

package com.google.cloud.channel.v1.samples;

// [START channel_v1_generated_cloudchannelserviceclient_unregistersubscriber_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.channel.v1.CloudChannelServiceClient;
import com.google.cloud.channel.v1.UnregisterSubscriberRequest;
import com.google.cloud.channel.v1.UnregisterSubscriberResponse;

public class AsyncUnregisterSubscriber {

  public static void main(String[] args) throws Exception {
    asyncUnregisterSubscriber();
  }

  public static void asyncUnregisterSubscriber() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      UnregisterSubscriberRequest request =
          UnregisterSubscriberRequest.newBuilder()
              .setAccount("account-1177318867")
              .setServiceAccount("serviceAccount1079137720")
              .build();
      ApiFuture<UnregisterSubscriberResponse> future =
          cloudChannelServiceClient.unregisterSubscriberCallable().futureCall(request);
      // Do something.
      UnregisterSubscriberResponse response = future.get();
    }
  }
}
// [END channel_v1_generated_cloudchannelserviceclient_unregistersubscriber_async]
