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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_VizierService_ListOptimalTrials_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest;
import com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse;
import com.google.cloud.aiplatform.v1.StudyName;
import com.google.cloud.aiplatform.v1.VizierServiceClient;

public class AsyncListOptimalTrials {

  public static void main(String[] args) throws Exception {
    asyncListOptimalTrials();
  }

  public static void asyncListOptimalTrials() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
      ListOptimalTrialsRequest request =
          ListOptimalTrialsRequest.newBuilder()
              .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
              .build();
      ApiFuture<ListOptimalTrialsResponse> future =
          vizierServiceClient.listOptimalTrialsCallable().futureCall(request);
      // Do something.
      ListOptimalTrialsResponse response = future.get();
    }
  }
}
// [END aiplatform_v1_generated_VizierService_ListOptimalTrials_async]
