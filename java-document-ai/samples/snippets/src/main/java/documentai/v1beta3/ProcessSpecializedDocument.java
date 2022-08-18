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

package documentai.v1beta3;

// [START documentai_process_specialized_document]

import com.google.cloud.documentai.v1beta3.Document;
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.RawDocument;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ProcessSpecializedDocument {
  public static void processSpecializedDocument()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String processerId = "your-processor-id";
    String filePath = "path/to/input/file.pdf";
    processSpecializedDocument(projectId, location, processerId, filePath);
  }

  public static void processSpecializedDocument(
      String projectId, String location, String processorId, String filePath)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DocumentProcessorServiceClient client = DocumentProcessorServiceClient.create()) {
      // The full resource name of the processor, e.g.:
      // projects/project-id/locations/location/processor/processor-id
      // You must create new processors in the Cloud Console first
      String name =
          String.format("projects/%s/locations/%s/processors/%s", projectId, location, processorId);

      // Read the file.
      byte[] imageFileData = Files.readAllBytes(Paths.get(filePath));

      // Convert the image data to a Buffer and base64 encode it.
      ByteString content = ByteString.copyFrom(imageFileData);

      RawDocument document =
          RawDocument.newBuilder().setContent(content).setMimeType("application/pdf").build();

      // Configure the process request.
      ProcessRequest request =
          ProcessRequest.newBuilder().setName(name).setRawDocument(document).build();

      // Recognizes text entities in the PDF document
      ProcessResponse result = client.processDocument(request);
      Document documentResponse = result.getDocument();

      System.out.println("Document processing complete.");

      // Read fields specificly from the specalized US drivers license processor:
      // https://cloud.google.com/document-ai/docs/processors-list#processor_us-driver-license-parser
      // retriving data from other specalized processors follow a similar pattern.
      // For a complete list of processors see:
      // https://cloud.google.com/document-ai/docs/processors-list
      //
      // OCR and other data is also present in the quality processor's response.
      // Please see the OCR and other samples for how to parse other data in the
      // response.
      for (Document.Entity entity : documentResponse.getEntitiesList()) {
        // Fields detected. For a full list of fields for each processor see
        // the processor documentation:
        // https://cloud.google.com/document-ai/docs/processors-list
        String entityType = entity.getType();
        // some other value formats in addition to text are availible
        // e.g. dates: `entity.getNormalizedValue().getDateValue().getYear()`
        // check for normilized value with `entity.hasNormalizedValue()`
        String entityTextValue = escapeNewlines(entity.getTextAnchor().getContent());
        float entityConfidence = entity.getConfidence();
        System.out.printf(
            "    * %s: %s (%.2f%% confident)\n",
            entityType, entityTextValue, entityConfidence * 100.0);
      }
    }
  }

  private static String escapeNewlines(String s) {
    return s.replace("\n", "\\n").replace("\r", "\\r");
  }
}
// [END documentai_process_specialized_document]
