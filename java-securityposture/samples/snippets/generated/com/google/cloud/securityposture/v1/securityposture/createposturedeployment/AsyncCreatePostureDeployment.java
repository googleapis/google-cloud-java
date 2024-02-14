/*
 * Copyright 2023 Google LLC
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

// [START securityposture_v1_generated_SecurityPosture_CreatePostureDeployment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.OrganizationName;
import com.google.cloud.securityposture.v1.PostureDeployment;
import com.google.cloud.securityposture.v1.SecurityPostureClient;
import com.google.longrunning.Operation;

public class AsyncCreatePostureDeployment {

  public static void main(String[] args) throws Exception {
    asyncCreatePostureDeployment();
  }

  public static void asyncCreatePostureDeployment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
      CreatePostureDeploymentRequest request =
          CreatePostureDeploymentRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPostureDeploymentId("postureDeploymentId1771206568")
              .setPostureDeployment(PostureDeployment.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          securityPostureClient.createPostureDeploymentCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END securityposture_v1_generated_SecurityPosture_CreatePostureDeployment_async]
