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

package com.google.cloud.securityposture.v1.samples;

// [START securityposture_v1_generated_SecurityPosture_CreatePosture_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.securityposture.v1.CreatePostureRequest;
import com.google.cloud.securityposture.v1.OrganizationName;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.SecurityPostureClient;
import com.google.longrunning.Operation;

public class AsyncCreatePosture {

  public static void main(String[] args) throws Exception {
    asyncCreatePosture();
  }

  public static void asyncCreatePosture() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
      CreatePostureRequest request =
          CreatePostureRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPostureId("postureId2023219203")
              .setPosture(Posture.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          securityPostureClient.createPostureCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END securityposture_v1_generated_SecurityPosture_CreatePosture_async]
