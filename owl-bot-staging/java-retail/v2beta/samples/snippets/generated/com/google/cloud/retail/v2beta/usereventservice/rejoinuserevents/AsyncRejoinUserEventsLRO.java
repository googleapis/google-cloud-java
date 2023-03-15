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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_UserEventService_RejoinUserEvents_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2beta.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2beta.RejoinUserEventsRequest;
import com.google.cloud.retail.v2beta.RejoinUserEventsResponse;
import com.google.cloud.retail.v2beta.UserEventServiceClient;

public class AsyncRejoinUserEventsLRO {

  public static void main(String[] args) throws Exception {
    asyncRejoinUserEventsLRO();
  }

  public static void asyncRejoinUserEventsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      RejoinUserEventsRequest request =
          RejoinUserEventsRequest.newBuilder().setParent("parent-995424086").build();
      OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata> future =
          userEventServiceClient.rejoinUserEventsOperationCallable().futureCall(request);
      // Do something.
      RejoinUserEventsResponse response = future.get();
    }
  }
}
// [END retail_v2beta_generated_UserEventService_RejoinUserEvents_LRO_async]
