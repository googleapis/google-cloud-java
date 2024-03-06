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

package com.google.chat.v1.samples;

// [START chat_v1_generated_ChatService_SetUpSpace_sync]
import com.google.chat.v1.ChatServiceClient;
import com.google.chat.v1.Membership;
import com.google.chat.v1.SetUpSpaceRequest;
import com.google.chat.v1.Space;
import java.util.ArrayList;

public class SyncSetUpSpace {

  public static void main(String[] args) throws Exception {
    syncSetUpSpace();
  }

  public static void syncSetUpSpace() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
      SetUpSpaceRequest request =
          SetUpSpaceRequest.newBuilder()
              .setSpace(Space.newBuilder().build())
              .setRequestId("requestId693933066")
              .addAllMemberships(new ArrayList<Membership>())
              .build();
      Space response = chatServiceClient.setUpSpace(request);
    }
  }
}
// [END chat_v1_generated_ChatService_SetUpSpace_sync]
