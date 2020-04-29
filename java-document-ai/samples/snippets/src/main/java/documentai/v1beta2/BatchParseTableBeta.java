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

// [START documentai_batch_parse_table_beta]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsResponse;
import com.google.cloud.documentai.v1beta2.BoundingPoly;
import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.GcsDestination;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.NormalizedVertex;
import com.google.cloud.documentai.v1beta2.OperationMetadata;
import com.google.cloud.documentai.v1beta2.OutputConfig;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import com.google.cloud.documentai.v1beta2.TableBoundHint;
import com.google.cloud.documentai.v1beta2.TableExtractionParams;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.util.JsonFormat;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BatchParseTableBeta {

  public static void batchParseTableGcs()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String outputGcsBucketName = "your-gcs-bucket-name";
    String outputGcsPrefix = "PREFIX";
    String inputGcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    batchParseTableGcs(projectId, location, outputGcsBucketName, outputGcsPrefix, inputGcsUri);
  }

  public static void batchParseTableGcs(
      String projectId,
      String location,
      String outputGcsBucketName,
      String outputGcsPrefix,
      String inputGcsUri)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
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

      GcsSource inputUri = GcsSource.newBuilder().setUri(inputGcsUri).build();

      // mime_type can be application/pdf, image/tiff,
      // and image/gif, or application/json
      InputConfig config =
          InputConfig.newBuilder().setGcsSource(inputUri).setMimeType("application/pdf").build();

      GcsDestination gcsDestination =
          GcsDestination.newBuilder()
              .setUri(String.format("gs://%s/%s", outputGcsBucketName, outputGcsPrefix))
              .build();

      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).setPagesPerShard(1).build();

      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder()
              .setTableExtractionParams(params)
              .setInputConfig(config)
              .setOutputConfig(outputConfig)
              .build();

      BatchProcessDocumentsRequest requests =
          BatchProcessDocumentsRequest.newBuilder().addRequests(request).setParent(parent).build();

      // Batch process document using a long-running operation.
      OperationFuture<BatchProcessDocumentsResponse, OperationMetadata> future =
          client.batchProcessDocumentsAsync(requests);

      // Wait for operation to complete.
      System.out.println("Waiting for operation to complete...");
      future.get(300, TimeUnit.SECONDS);

      System.out.println("Document processing complete.");

      Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
      Bucket bucket = storage.get(outputGcsBucketName);

      // List all of the files in the Storage bucket.
      Page<Blob> blobs =
          bucket.list(
              Storage.BlobListOption.currentDirectory(),
              Storage.BlobListOption.prefix(outputGcsPrefix));

      int idx = 0;
      for (Blob blob : blobs.iterateAll()) {
        if (!blob.isDirectory()) {
          System.out.printf("Fetched file #%d\n", ++idx);
          // Read the results

          // Download and store json data in a temp file.
          File tempFile = File.createTempFile("file", ".json");
          Blob fileInfo = storage.get(BlobId.of(outputGcsBucketName, blob.getName()));
          fileInfo.downloadTo(tempFile.toPath());

          // Parse json file into Document.
          FileReader reader = new FileReader(tempFile);
          Document.Builder builder = Document.newBuilder();
          JsonFormat.parser().merge(reader, builder);
          Document document = builder.build();

          // Get all of the document text as one big string.
          String text = document.getText();

          // Process the output.
          Document.Page page1 = document.getPages(0);
          Document.Page.Table table = page1.getTables(0);

          System.out.println("Results from first table processed:");
          System.out.println(
              "First detected language: " + page1.getDetectedLanguages(0).getLanguageCode());
          System.out.println("Header row:");

          Document.Page.Table.TableRow headerRow = table.getHeaderRows(0);

          for (Document.Page.Table.TableCell tableCell : headerRow.getCellsList()) {
            if (!tableCell.getLayout().getTextAnchor().getTextSegmentsList().isEmpty()) {
              // Extract shards from the text field
              // First shard in document doesn't have startIndex property
              List<Document.TextAnchor.TextSegment> textSegments =
                  tableCell.getLayout().getTextAnchor().getTextSegmentsList();
              int startIdx =
                  textSegments.size() > 0 ? (int) textSegments.get(0).getStartIndex() : 0;
              int endIdx = (int) textSegments.get(0).getEndIndex();
              System.out.printf("\t%s", text.substring(startIdx, endIdx));
            }
          }

          // Clean up temp file.
          tempFile.deleteOnExit();
        }
      }
    }
  }
}
// [END documentai_batch_parse_table_beta]
