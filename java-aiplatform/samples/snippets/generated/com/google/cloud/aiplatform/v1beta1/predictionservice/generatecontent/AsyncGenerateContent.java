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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_PredictionService_GenerateContent_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1beta1.CachedContentName;
import com.google.cloud.aiplatform.v1beta1.Content;
import com.google.cloud.aiplatform.v1beta1.GenerateContentRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateContentResponse;
import com.google.cloud.aiplatform.v1beta1.GenerationConfig;
import com.google.cloud.aiplatform.v1beta1.ModelArmorConfig;
import com.google.cloud.aiplatform.v1beta1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1beta1.SafetySetting;
import com.google.cloud.aiplatform.v1beta1.Tool;
import com.google.cloud.aiplatform.v1beta1.ToolConfig;
import java.util.ArrayList;
import java.util.HashMap;

public class AsyncGenerateContent {

  public static void main(String[] args) throws Exception {
    asyncGenerateContent();
  }

  public static void asyncGenerateContent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      GenerateContentRequest request =
          GenerateContentRequest.newBuilder()
              .setModel("model104069929")
              .addAllContents(new ArrayList<Content>())
              .setSystemInstruction(Content.newBuilder().build())
              .setCachedContent(
                  CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString())
              .addAllTools(new ArrayList<Tool>())
              .setToolConfig(ToolConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .addAllSafetySettings(new ArrayList<SafetySetting>())
              .setModelArmorConfig(ModelArmorConfig.newBuilder().build())
              .setGenerationConfig(GenerationConfig.newBuilder().build())
              .build();
      ApiFuture<GenerateContentResponse> future =
          predictionServiceClient.generateContentCallable().futureCall(request);
      // Do something.
      GenerateContentResponse response = future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_PredictionService_GenerateContent_async]
