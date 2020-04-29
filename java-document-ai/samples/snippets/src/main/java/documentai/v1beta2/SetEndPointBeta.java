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

// [START documentai_set_endpoint_beta]

import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceSettings;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import java.io.IOException;

public class SetEndPointBeta {

  public static void setEndpoint() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String inputGcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    setEndpoint(projectId, location, inputGcsUri);
  }

  public static void setEndpoint(String projectId, String location, String inputGcsUri)
      throws IOException {
    DocumentUnderstandingServiceSettings settings =
        DocumentUnderstandingServiceSettings.newBuilder()
            .setEndpoint("eu-documentai.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DocumentUnderstandingServiceClient client =
        DocumentUnderstandingServiceClient.create(settings)) {
      // Configure the request for processing the PDF
      String parent = String.format("projects/%s/locations/%s", projectId, location);

      GcsSource uri = GcsSource.newBuilder().setUri(inputGcsUri).build();

      // mime_type can be application/pdf, image/tiff,
      // and image/gif, or application/json
      InputConfig config =
          InputConfig.newBuilder().setGcsSource(uri)
                  .setMimeType("application/pdf").build();

      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder().setParent(parent).setInputConfig(config).build();

      // Recognizes text entities in the PDF document
      Document response = client.processDocument(request);

      // Get all of the document text as one big string
      String text = response.getText();

      // Process the output
      for (Document.Entity entity : response.getEntitiesList()) {
        System.out.printf("Entity text: %s\n", getText(entity, text));
        System.out.printf("Entity type: %s\n", entity.getType());
        System.out.printf("Entity mention text: %s\n", entity.getMentionText());
      }
    }
  }

  private static String getText(Document.Entity entity, String text) {
    int startIdx = (int) entity.getTextAnchor().getTextSegments(0).getStartIndex();
    int endIdx = (int) entity.getTextAnchor().getTextSegments(0).getEndIndex();
    return text.substring(startIdx, endIdx);
  }
}
// [END documentai_set_endpoint_beta]
