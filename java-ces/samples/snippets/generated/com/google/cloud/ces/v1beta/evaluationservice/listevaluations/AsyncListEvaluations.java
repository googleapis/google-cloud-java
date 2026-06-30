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

package com.google.cloud.ces.v1beta.samples;

// [START ces_v1beta_generated_EvaluationService_ListEvaluations_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1beta.AppName;
import com.google.cloud.ces.v1beta.Evaluation;
import com.google.cloud.ces.v1beta.EvaluationServiceClient;
import com.google.cloud.ces.v1beta.ListEvaluationsRequest;

public class AsyncListEvaluations {

  public static void main(String[] args) throws Exception {
    asyncListEvaluations();
  }

  public static void asyncListEvaluations() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      ListEvaluationsRequest request =
          ListEvaluationsRequest.newBuilder()
              .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setEvaluationFilter("evaluationFilter1361994196")
              .setEvaluationRunFilter("evaluationRunFilter299014663")
              .setOrderBy("orderBy-1207110587")
              .setLastTenResults(true)
              .build();
      ApiFuture<Evaluation> future =
          evaluationServiceClient.listEvaluationsPagedCallable().futureCall(request);
      // Do something.
      for (Evaluation element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END ces_v1beta_generated_EvaluationService_ListEvaluations_async]
