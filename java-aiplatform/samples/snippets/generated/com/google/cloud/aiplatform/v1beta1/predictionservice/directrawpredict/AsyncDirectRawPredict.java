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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_PredictionService_DirectRawPredict_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictResponse;
import com.google.cloud.aiplatform.v1beta1.EndpointName;
import com.google.cloud.aiplatform.v1beta1.PredictionServiceClient;
import com.google.protobuf.ByteString;

public class AsyncDirectRawPredict {

  public static void main(String[] args) throws Exception {
    asyncDirectRawPredict();
  }

  public static void asyncDirectRawPredict() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      DirectRawPredictRequest request =
          DirectRawPredictRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setMethodName("methodName-723163380")
              .setInput(ByteString.EMPTY)
              .build();
      ApiFuture<DirectRawPredictResponse> future =
          predictionServiceClient.directRawPredictCallable().futureCall(request);
      // Do something.
      DirectRawPredictResponse response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_PredictionService_DirectRawPredict_async]
