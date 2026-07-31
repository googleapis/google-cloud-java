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

package com.google.devicesandservices.health.v4.samples;

// [START health_v4_generated_DataSubscriptionService_UpdateSubscription_async]
import com.google.api.core.ApiFuture;
import com.google.devicesandservices.health.v4.DataSubscriptionServiceClient;
import com.google.devicesandservices.health.v4.Subscription;
import com.google.devicesandservices.health.v4.UpdateSubscriptionRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateSubscription {

  public static void main(String[] args) throws Exception {
    asyncUpdateSubscription();
  }

  public static void asyncUpdateSubscription() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
        DataSubscriptionServiceClient.create()) {
      UpdateSubscriptionRequest request =
          UpdateSubscriptionRequest.newBuilder()
              .setSubscription(Subscription.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Subscription> future =
          dataSubscriptionServiceClient.updateSubscriptionCallable().futureCall(request);
      // Do something.
      Subscription response = future.get();
    }
  }
}
// [END health_v4_generated_DataSubscriptionService_UpdateSubscription_async]
