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

package com.google.cloud.vertexai.api.samples;

// [START aiplatform_v1beta1_generated_PredictionService_StreamGenerateContent_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.EndpointName;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.Tool;
import java.util.ArrayList;

public class AsyncStreamGenerateContent {

  public static void main(String[] args) throws Exception {
    asyncStreamGenerateContent();
  }

  public static void asyncStreamGenerateContent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      GenerateContentRequest request =
          GenerateContentRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setModel("model104069929")
              .addAllContents(new ArrayList<Content>())
              .addAllTools(new ArrayList<Tool>())
              .addAllSafetySettings(new ArrayList<SafetySetting>())
              .setGenerationConfig(GenerationConfig.newBuilder().build())
              .build();
      ServerStream<GenerateContentResponse> stream =
          predictionServiceClient.streamGenerateContentCallable().call(request);
      for (GenerateContentResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END aiplatform_v1beta1_generated_PredictionService_StreamGenerateContent_async]
