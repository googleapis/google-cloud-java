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

// [START discoveryengine_v1alpha_generated_EvaluationService_ListEvaluationResults_sync]
import com.google.cloud.discoveryengine.v1alpha.EvaluationName;
import com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsResponse;

public class SyncListEvaluationResults {

  public static void main(String[] args) throws Exception {
    syncListEvaluationResults();
  }

  public static void syncListEvaluationResults() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      ListEvaluationResultsRequest request =
          ListEvaluationResultsRequest.newBuilder()
              .setEvaluation(
                  EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (ListEvaluationResultsResponse.EvaluationResult element :
          evaluationServiceClient.listEvaluationResults(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END discoveryengine_v1alpha_generated_EvaluationService_ListEvaluationResults_sync]
