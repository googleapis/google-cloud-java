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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_EvaluationService_GenerateInstanceRubrics_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.Content;
import com.google.cloud.aiplatform.v1beta1.EvaluationInstance;
import com.google.cloud.aiplatform.v1beta1.EvaluationServiceClient;
import com.google.cloud.aiplatform.v1beta1.GenerateInstanceRubricsRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateInstanceRubricsResponse;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.PredefinedMetricSpec;
import com.google.cloud.aiplatform.v1beta1.RubricGenerationSpec;
import java.util.ArrayList;

public class AsyncGenerateInstanceRubrics {

  public static void main(String[] args) throws Exception {
    asyncGenerateInstanceRubrics();
  }

  public static void asyncGenerateInstanceRubrics() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
      GenerateInstanceRubricsRequest request =
          GenerateInstanceRubricsRequest.newBuilder()
              .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .addAllContents(new ArrayList<Content>())
              .setPredefinedRubricGenerationSpec(PredefinedMetricSpec.newBuilder().build())
              .setRubricGenerationSpec(RubricGenerationSpec.newBuilder().build())
              .setAgentConfig(EvaluationInstance.DeprecatedAgentConfig.newBuilder().build())
              .build();
      ApiFuture<GenerateInstanceRubricsResponse> future =
          evaluationServiceClient.generateInstanceRubricsCallable().futureCall(request);
      // Do something.
      GenerateInstanceRubricsResponse response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_EvaluationService_GenerateInstanceRubrics_async]
