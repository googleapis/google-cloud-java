/*
 * Copyright 2024 Google LLC
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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_UserService_GetUser_sync]
import com.google.ads.admanager.v1.GetUserRequest;
import com.google.ads.admanager.v1.User;
import com.google.ads.admanager.v1.UserName;
import com.google.ads.admanager.v1.UserServiceClient;

public class SyncGetUser {

  public static void main(String[] args) throws Exception {
    syncGetUser();
  }

  public static void syncGetUser() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UserServiceClient userServiceClient = UserServiceClient.create()) {
      GetUserRequest request =
          GetUserRequest.newBuilder()
              .setName(UserName.of("[NETWORK_CODE]", "[USER]").toString())
              .build();
      User response = userServiceClient.getUser(request);
    }
  }
}
// [END admanager_v1_generated_UserService_GetUser_sync]
