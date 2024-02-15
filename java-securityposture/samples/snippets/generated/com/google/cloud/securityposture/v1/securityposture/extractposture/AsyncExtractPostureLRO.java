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

// [START securityposture_v1_generated_SecurityPosture_ExtractPosture_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.securityposture.v1.ExtractPostureRequest;
import com.google.cloud.securityposture.v1.OperationMetadata;
import com.google.cloud.securityposture.v1.OrganizationName;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.SecurityPostureClient;

public class AsyncExtractPostureLRO {

  public static void main(String[] args) throws Exception {
    asyncExtractPostureLRO();
  }

  public static void asyncExtractPostureLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
      ExtractPostureRequest request =
          ExtractPostureRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPostureId("postureId2023219203")
              .setWorkload("workload35560311")
              .build();
      OperationFuture<Posture, OperationMetadata> future =
          securityPostureClient.extractPostureOperationCallable().futureCall(request);
      // Do something.
      Posture response = future.get();
    }
  }
}
// [END securityposture_v1_generated_SecurityPosture_ExtractPosture_LRO_async]
