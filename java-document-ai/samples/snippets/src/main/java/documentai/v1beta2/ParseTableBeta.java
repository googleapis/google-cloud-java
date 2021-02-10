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

// [START documentai_parse_table_beta]

import com.google.cloud.documentai.v1beta2.BoundingPoly;
import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.NormalizedVertex;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import com.google.cloud.documentai.v1beta2.TableBoundHint;
import com.google.cloud.documentai.v1beta2.TableExtractionParams;
import java.io.IOException;
import java.util.List;

public class ParseTableBeta {

  public static void parseTable() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String inputGcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    parseTable(projectId, location, inputGcsUri);
  }

  public static void parseTable(String projectId, String location, String inputGcsUri)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DocumentUnderstandingServiceClient client = DocumentUnderstandingServiceClient.create()) {
      // Configure the request for processing the PDF
      String parent = String.format("projects/%s/locations/%s", projectId, location);

      TableBoundHint tableBoundHints =
          TableBoundHint.newBuilder()
              .setBoundingBox(
                  // Define a polygon around tables to detect
                  // Each vertice coordinate must be a number between 0 and 1
                  BoundingPoly.newBuilder()
                      // top left
                      .addNormalizedVertices(NormalizedVertex.newBuilder().setX(0).setX(0).build())
                      // top right
                      .addNormalizedVertices(NormalizedVertex.newBuilder().setX(1).setX(0).build())
                      // bottom right
                      .addNormalizedVertices(NormalizedVertex.newBuilder().setX(1).setX(1).build())
                      // bottom left
                      .addNormalizedVertices(NormalizedVertex.newBuilder().setX(0).setX(1).build())
                      .build())
              .setPageNumber(1)
              .build();

      TableExtractionParams params =
          TableExtractionParams.newBuilder()
              .setEnabled(true)
              .addTableBoundHints(tableBoundHints)
              .build();

      GcsSource uri = GcsSource.newBuilder().setUri(inputGcsUri).build();

      // mime_type can be application/pdf, image/tiff,
      // and image/gif, or application/json
      InputConfig config =
          InputConfig.newBuilder().setGcsSource(uri).setMimeType("application/pdf").build();

      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder()
              .setParent(parent)
              .setTableExtractionParams(params)
              .setInputConfig(config)
              .build();

      // Recognizes text entities in the PDF document
      Document response = client.processDocument(request);

      // Get all of the document text as one big string
      String text = response.getText();

      // Get the first table in the document
      if (response.getPagesCount() > 0) {
        Document.Page page1 = response.getPages(0);
        if (page1.getTablesCount() > 0) {
          Document.Page.Table table = page1.getTables(0);

          System.out.println("Results from first table processed:");
          List<Document.Page.DetectedLanguage> detectedLangs = page1.getDetectedLanguagesList();
          String langCode =
              detectedLangs.size() > 0 ? detectedLangs.get(0).getLanguageCode() : "NOT_FOUND";
          System.out.printf("First detected language: : %s", langCode);

          Document.Page.Table.TableRow headerRow = table.getHeaderRows(0);
          System.out.println("Header row:");

          for (Document.Page.Table.TableCell tableCell : headerRow.getCellsList()) {
            if (tableCell.getLayout().getTextAnchor().getTextSegmentsList() != null) {
              // Extract shards from the text field
              // First shard in document doesn't have startIndex property
              System.out.printf("\t%s", getText(tableCell.getLayout(), text));
            }
          }
        }
      }
    }
  }

  // Extract shards from the text field
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
// [END documentai_parse_table_beta]
