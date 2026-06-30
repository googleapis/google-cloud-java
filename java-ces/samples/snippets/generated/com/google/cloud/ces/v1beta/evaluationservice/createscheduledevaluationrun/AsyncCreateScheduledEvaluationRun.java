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

// [START ces_v1beta_generated_EvaluationService_CreateScheduledEvaluationRun_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1beta.AppName;
import com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.EvaluationServiceClient;
import com.google.cloud.ces.v1beta.ScheduledEvaluationRun;

public class AsyncCreateScheduledEvaluationRun {

  public static void main(String[] args) throws Exception {
    asyncCreateScheduledEvaluationRun();
  }

  public static void asyncCreateScheduledEvaluationRun() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      CreateScheduledEvaluationRunRequest request =
          CreateScheduledEvaluationRunRequest.newBuilder()
              .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setScheduledEvaluationRunId("scheduledEvaluationRunId-434150723")
              .setScheduledEvaluationRun(ScheduledEvaluationRun.newBuilder().build())
              .build();
      ApiFuture<ScheduledEvaluationRun> future =
          evaluationServiceClient.createScheduledEvaluationRunCallable().futureCall(request);
      // Do something.
      ScheduledEvaluationRun response = future.get();
    }
  }
}
// [END ces_v1beta_generated_EvaluationService_CreateScheduledEvaluationRun_async]
