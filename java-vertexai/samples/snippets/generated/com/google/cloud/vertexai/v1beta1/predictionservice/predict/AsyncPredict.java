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

package com.google.cloud.vertexai.v1beta1.samples;

// [START aiplatform_v1beta1_generated_PredictionService_Predict_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vertexai.v1beta1.EndpointName;
import com.google.cloud.vertexai.v1beta1.PredictRequest;
import com.google.cloud.vertexai.v1beta1.PredictResponse;
import com.google.cloud.vertexai.v1beta1.PredictionServiceClient;
import com.google.protobuf.Value;
import java.util.ArrayList;

public class AsyncPredict {

  public static void main(String[] args) throws Exception {
    asyncPredict();
  }

  public static void asyncPredict() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      PredictRequest request =
          PredictRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllInstances(new ArrayList<Value>())
              .setParameters(Value.newBuilder().setBoolValue(true).build())
              .build();
      ApiFuture<PredictResponse> future =
          predictionServiceClient.predictCallable().futureCall(request);
      // Do something.
      PredictResponse response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_PredictionService_Predict_async]
