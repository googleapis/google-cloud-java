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

// [START documentai_batch_parse_form_beta]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsResponse;
import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.FormExtractionParams;
import com.google.cloud.documentai.v1beta2.GcsDestination;
import com.google.cloud.documentai.v1beta2.GcsSource;
import com.google.cloud.documentai.v1beta2.InputConfig;
import com.google.cloud.documentai.v1beta2.KeyValuePairHint;
import com.google.cloud.documentai.v1beta2.OperationMetadata;
import com.google.cloud.documentai.v1beta2.OutputConfig;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.util.JsonFormat;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BatchParseFormBeta {

  public static void batchParseFormGcs()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String outputGcsBucketName = "your-gcs-bucket-name";
    String outputGcsPrefix = "PREFIX";
    String inputGcsUri = "gs://your-gcs-bucket/path/to/input/file.json";
    batchParseFormGcs(projectId, location, outputGcsBucketName, outputGcsPrefix, inputGcsUri);
  }

  public static void batchParseFormGcs(
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
              .setFormExtractionParams(params)
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
          if (document.getPagesCount() > 0) {
            Document.Page page1 = document.getPages(0);
            for (Document.Page.FormField field : page1.getFormFieldsList()) {
              String fieldName = getText(field.getFieldName(), text);
              String fieldValue = getText(field.getFieldValue(), text);

              System.out.println("Extracted form fields pair:");
              System.out.printf("\t(%s, %s))", fieldName, fieldValue);
            }
          }

          // Clean up temp file.
          tempFile.deleteOnExit();
        }
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
// [END documentai_batch_parse_form_beta]
