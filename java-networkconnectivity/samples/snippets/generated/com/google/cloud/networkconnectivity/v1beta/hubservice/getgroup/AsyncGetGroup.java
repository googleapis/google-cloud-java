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

package com.google.cloud.networkconnectivity.v1beta.samples;

// [START networkconnectivity_v1beta_generated_HubService_GetGroup_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networkconnectivity.v1beta.GetGroupRequest;
import com.google.cloud.networkconnectivity.v1beta.Group;
import com.google.cloud.networkconnectivity.v1beta.GroupName;
import com.google.cloud.networkconnectivity.v1beta.HubServiceClient;

public class AsyncGetGroup {

  public static void main(String[] args) throws Exception {
    asyncGetGroup();
  }

  public static void asyncGetGroup() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      GetGroupRequest request =
          GetGroupRequest.newBuilder()
              .setName(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .build();
      ApiFuture<Group> future = hubServiceClient.getGroupCallable().futureCall(request);
      // Do something.
      Group response = future.get();
    }
  }
}
// [END networkconnectivity_v1beta_generated_HubService_GetGroup_async]
