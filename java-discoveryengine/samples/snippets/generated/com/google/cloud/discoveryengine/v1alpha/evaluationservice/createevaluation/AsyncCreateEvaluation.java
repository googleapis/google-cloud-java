/*
 * Copyright 2025 Google LLC
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

// [START discoveryengine_v1alpha_generated_EvaluationService_CreateEvaluation_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1alpha.CreateEvaluationRequest;
import com.google.cloud.discoveryengine.v1alpha.Evaluation;
import com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient;
import com.google.cloud.discoveryengine.v1alpha.LocationName;
import com.google.longrunning.Operation;

public class AsyncCreateEvaluation {

  public static void main(String[] args) throws Exception {
    asyncCreateEvaluation();
  }

  public static void asyncCreateEvaluation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      CreateEvaluationRequest request =
          CreateEvaluationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setEvaluation(Evaluation.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          evaluationServiceClient.createEvaluationCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END discoveryengine_v1alpha_generated_EvaluationService_CreateEvaluation_async]
