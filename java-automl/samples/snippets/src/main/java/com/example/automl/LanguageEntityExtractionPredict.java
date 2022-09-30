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

// [START automl_language_entity_extraction_predict]
import com.google.cloud.automl.v1.AnnotationPayload;
import com.google.cloud.automl.v1.ExamplePayload;
import com.google.cloud.automl.v1.ModelName;
import com.google.cloud.automl.v1.PredictRequest;
import com.google.cloud.automl.v1.PredictResponse;
import com.google.cloud.automl.v1.PredictionServiceClient;
import com.google.cloud.automl.v1.TextSegment;
import com.google.cloud.automl.v1.TextSnippet;
import java.io.IOException;

class LanguageEntityExtractionPredict {

  static void predict() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    String content = "text to predict";
    predict(projectId, modelId, content);
  }

  static void predict(String projectId, String modelId, String content) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient client = PredictionServiceClient.create()) {
      // Get the full path of the model.
      ModelName name = ModelName.of(projectId, "us-central1", modelId);

      // For available mime types, see:
      // https://cloud.google.com/automl/docs/reference/rest/v1/projects.locations.models/predict#textsnippet
      TextSnippet textSnippet =
          TextSnippet.newBuilder()
              .setContent(content)
              .setMimeType("text/plain") // Types: text/plain, text/html
              .build();
      ExamplePayload payload = ExamplePayload.newBuilder().setTextSnippet(textSnippet).build();
      PredictRequest predictRequest =
          PredictRequest.newBuilder().setName(name.toString()).setPayload(payload).build();

      PredictResponse response = client.predict(predictRequest);

      for (AnnotationPayload annotationPayload : response.getPayloadList()) {
        System.out.format("Text Extract Entity Type: %s\n", annotationPayload.getDisplayName());
        System.out.format("Text score: %.2f\n", annotationPayload.getTextExtraction().getScore());
        TextSegment textSegment = annotationPayload.getTextExtraction().getTextSegment();
        System.out.format("Text Extract Entity Content: %s\n", textSegment.getContent());
        System.out.format("Text Start Offset: %s\n", textSegment.getStartOffset());
        System.out.format("Text End Offset: %s\n\n", textSegment.getEndOffset());
      }
    }
  }
}
// [END automl_language_entity_extraction_predict]
