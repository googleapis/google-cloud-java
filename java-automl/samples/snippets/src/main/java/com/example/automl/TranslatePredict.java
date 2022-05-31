/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.automl;

// [START automl_translate_predict]
import com.google.cloud.automl.v1.ExamplePayload;
import com.google.cloud.automl.v1.ModelName;
import com.google.cloud.automl.v1.PredictRequest;
import com.google.cloud.automl.v1.PredictResponse;
import com.google.cloud.automl.v1.PredictionServiceClient;
import com.google.cloud.automl.v1.TextSnippet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class TranslatePredict {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    String filePath = "path_to_local_file.txt";
    predict(projectId, modelId, filePath);
  }

  static void predict(String projectId, String modelId, String filePath) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient client = PredictionServiceClient.create()) {
      // Get the full path of the model.
      ModelName name = ModelName.of(projectId, "us-central1", modelId);

      String content = new String(Files.readAllBytes(Paths.get(filePath)));

      TextSnippet textSnippet = TextSnippet.newBuilder().setContent(content).build();
      ExamplePayload payload = ExamplePayload.newBuilder().setTextSnippet(textSnippet).build();
      PredictRequest predictRequest =
          PredictRequest.newBuilder().setName(name.toString()).setPayload(payload).build();

      PredictResponse response = client.predict(predictRequest);
      TextSnippet translatedContent =
          response.getPayload(0).getTranslation().getTranslatedContent();
      System.out.format("Translated Content: %s\n", translatedContent.getContent());
    }
  }
}
// [END automl_translate_predict]
