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

// [START documentai_parse_form_beta]

import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.FormExtractionParams;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.KeyValuePairHint;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ParseFormBeta {
  public static void parseForm() throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String inputGcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    parseForm(projectId, location, inputGcsUri);
  }

  public static void parseForm(String projectId, String location, String inputGcsUri)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DocumentUnderstandingServiceClient client = DocumentUnderstandingServiceClient.create()) {
      // Configure the request for processing the PDF
      String parent = String.format("projects/%s/locations/%s", projectId, location);

      // Improve form parsing results by providing key-value pair hints.
      // For each key hint, key is text that is likely to appear in the
      // document as a form field name (i.e. "DOB").
      // Value types are optional, but can be one or more of:
      // ADDRESS, LOCATION, ORGANIZATION, PERSON, PHONE_NUMBER, ID,
      // NUMBER, EMAIL, PRICE, TERMS, DATE, NAME
      KeyValuePairHint keyValuePairHint =
          KeyValuePairHint.newBuilder().setKey("Phone").addValueTypes("PHONE_NUMBER").build();
      KeyValuePairHint keyValuePairHint2 =
          KeyValuePairHint.newBuilder()
              .setKey("Contact")
              .addValueTypes("EMAIL")
              .addValueTypes("NAME")
              .build();

      // Setting enabled=True enables form extraction
      FormExtractionParams params =
          FormExtractionParams.newBuilder()
              .setEnabled(true)
              .addKeyValuePairHints(keyValuePairHint)
              .addKeyValuePairHints(keyValuePairHint2)
              .build();

      GcsSource uri = GcsSource.newBuilder().setUri(inputGcsUri).build();

      // mime_type can be application/pdf, image/tiff,
      // and image/gif, or application/json
      InputConfig config =
          InputConfig.newBuilder().setGcsSource(uri).setMimeType("application/pdf").build();

      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder()
              .setParent(parent)
              .setFormExtractionParams(params)
              .setInputConfig(config)
              .build();

      // Recognizes text entities in the PDF document
      Document response = client.processDocument(request);

      // Get all of the document text as one big string
      String text = response.getText();

      // Process the output
      Document.Page page1 = response.getPages(0);
      for (Document.Page.FormField field : page1.getFormFieldsList()) {
        String fieldName = getText(field.getFieldName(), text);
        String fieldValue = getText(field.getFieldValue(), text);

        System.out.println("Extracted form fields pair:");
        System.out.printf("\t(%s, %s))", fieldName, fieldValue);
      }
    }
  }

  private static String getText(Document.Page.Layout layout, String text) {
    Document.TextAnchor textAnchor = layout.getTextAnchor();
    if (textAnchor.getTextSegmentsList().size() > 0) {
      int startIdx = (int) textAnchor.getTextSegments(0).getStartIndex();
      int endIdx = (int) textAnchor.getTextSegments(0).getEndIndex();
      return text.substring(startIdx, endIdx);
    }
    return "[NO TEXT]";
  }
}
// [END documentai_parse_form_beta]
