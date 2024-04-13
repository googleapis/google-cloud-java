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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_GroundedGenerationService_CheckGrounding_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1alpha.CheckGroundingRequest;
import com.google.cloud.discoveryengine.v1alpha.CheckGroundingResponse;
import com.google.cloud.discoveryengine.v1alpha.CheckGroundingSpec;
import com.google.cloud.discoveryengine.v1alpha.GroundedGenerationServiceClient;
import com.google.cloud.discoveryengine.v1alpha.GroundingConfigName;
import com.google.cloud.discoveryengine.v1alpha.GroundingFact;
import java.util.ArrayList;

public class AsyncCheckGrounding {

  public static void main(String[] args) throws Exception {
    asyncCheckGrounding();
  }

  public static void asyncCheckGrounding() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GroundedGenerationServiceClient groundedGenerationServiceClient =
        GroundedGenerationServiceClient.create()) {
      CheckGroundingRequest request =
          CheckGroundingRequest.newBuilder()
              .setGroundingConfig(
                  GroundingConfigName.of("[PROJECT]", "[LOCATION]", "[GROUNDING_CONFIG]")
                      .toString())
              .setAnswerCandidate("answerCandidate-292402331")
              .addAllFacts(new ArrayList<GroundingFact>())
              .setGroundingSpec(CheckGroundingSpec.newBuilder().build())
              .build();
      ApiFuture<CheckGroundingResponse> future =
          groundedGenerationServiceClient.checkGroundingCallable().futureCall(request);
      // Do something.
      CheckGroundingResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1alpha_generated_GroundedGenerationService_CheckGrounding_async]
