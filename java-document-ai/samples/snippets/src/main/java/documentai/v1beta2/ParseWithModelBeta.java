/*
 * Copyright 2020 Google LLC
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

package documentai.v1beta2;

// [START documentai_parse_with_model_beta]

import com.google.cloud.documentai.v1beta2.AutoMlParams;
import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import java.io.IOException;

public class ParseWithModelBeta {

  public static void parseWithModel() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    // AutoML model name formatted as:
    //   "projects/[PROJECT_ID]/locations/[LOCATION]/models/[MODEL_ID]"
    String autoMlModel = "your-full-resource-model-name";
    String gcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    parseWithModel(projectId, location, autoMlModel, gcsUri);
  }

  public static void parseWithModel(
      String projectId, String location, String autoMlModel, String gcsUri) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DocumentUnderstandingServiceClient client = DocumentUnderstandingServiceClient.create()) {
      // Configure the request for processing the PDF
      String parent = String.format("projects/%s/locations/%s", projectId, location);

      AutoMlParams params = AutoMlParams.newBuilder().setModel(autoMlModel).build();

      GcsSource uri = GcsSource.newBuilder().setUri(gcsUri).build();

      // mime_type can be application/pdf, image/tiff,
      // and image/gif, or application/json
      InputConfig config =
          InputConfig.newBuilder().setGcsSource(uri).setMimeType("application/pdf").build();

      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder()
              .setParent(parent)
              .setAutomlParams(params)
              .setInputConfig(config)
              .build();

      // Recognizes text entities in the PDF document
      Document response = client.processDocument(request);

      // Process the output
      for (Document.Label label : response.getLabelsList()) {
        System.out.printf("Label detected: %s\n", label.getName());
        System.out.printf("Confidence:  %s\n", label.getConfidence());
      }
    }
  }
}
// [END documentai_parse_with_model_beta]
