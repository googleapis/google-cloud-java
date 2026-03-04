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

// [START ces_v1beta_generated_EvaluationService_RunEvaluation_sync]
import com.google.cloud.ces.v1beta.AppName;
import com.google.cloud.ces.v1beta.AppVersionName;
import com.google.cloud.ces.v1beta.EvaluationConfig;
import com.google.cloud.ces.v1beta.EvaluationDatasetName;
import com.google.cloud.ces.v1beta.EvaluationServiceClient;
import com.google.cloud.ces.v1beta.GoldenRunMethod;
import com.google.cloud.ces.v1beta.OptimizationConfig;
import com.google.cloud.ces.v1beta.PersonaRunConfig;
import com.google.cloud.ces.v1beta.RunEvaluationRequest;
import com.google.cloud.ces.v1beta.RunEvaluationResponse;
import com.google.cloud.ces.v1beta.ScheduledEvaluationRunName;
import java.util.ArrayList;

public class SyncRunEvaluation {

  public static void main(String[] args) throws Exception {
    syncRunEvaluation();
  }

  public static void syncRunEvaluation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      RunEvaluationRequest request =
          RunEvaluationRequest.newBuilder()
              .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .addAllEvaluations(new ArrayList<String>())
              .setEvaluationDataset(
                  EvaluationDatasetName.of(
                          "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setAppVersion(
                  AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
              .setConfig(EvaluationConfig.newBuilder().build())
              .setRunCount(-485221797)
              .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
              .setOptimizationConfig(OptimizationConfig.newBuilder().build())
              .setScheduledEvaluationRun(
                  ScheduledEvaluationRunName.of(
                          "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
                      .toString())
              .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
              .setGenerateLatencyReport(true)
              .build();
      RunEvaluationResponse response = evaluationServiceClient.runEvaluationAsync(request).get();
    }
  }
}
// [END ces_v1beta_generated_EvaluationService_RunEvaluation_sync]
