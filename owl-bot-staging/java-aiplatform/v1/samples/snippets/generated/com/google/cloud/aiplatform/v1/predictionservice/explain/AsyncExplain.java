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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_PredictionService_Explain_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.ExplainRequest;
import com.google.cloud.aiplatform.v1.ExplainResponse;
import com.google.cloud.aiplatform.v1.ExplanationSpecOverride;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.protobuf.Value;
import java.util.ArrayList;

public class AsyncExplain {

  public static void main(String[] args) throws Exception {
    asyncExplain();
  }

  public static void asyncExplain() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      ExplainRequest request =
          ExplainRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllInstances(new ArrayList<Value>())
              .setParameters(Value.newBuilder().setBoolValue(true).build())
              .setExplanationSpecOverride(ExplanationSpecOverride.newBuilder().build())
              .setDeployedModelId("deployedModelId-1817547906")
              .build();
      ApiFuture<ExplainResponse> future =
          predictionServiceClient.explainCallable().futureCall(request);
      // Do something.
      ExplainResponse response = future.get();
    }
  }
}
// [END aiplatform_v1_generated_PredictionService_Explain_async]
