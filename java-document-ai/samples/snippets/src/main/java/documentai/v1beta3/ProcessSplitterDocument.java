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

// [START documentai_process_splitter_document]

import com.google.cloud.documentai.v1beta3.Document;
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.RawDocument;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ProcessSplitterDocument {
  public static void processSplitterDocument()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String processerId = "your-processor-id";
    String filePath = "path/to/input/file.pdf";
    processSplitterDocument(projectId, location, processerId, filePath);
  }

  public static void processSplitterDocument(
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

      // Read the splitter output from the document splitter processor:
      // https://cloud.google.com/document-ai/docs/processors-list#processor_doc-splitter
      // This processor only provides text for the document and information on how
      // to split the document on logical boundaries. To identify and extract text,
      // form elements, and entities please see other processors like the OCR, form,
      // and specalized processors.
      List<Document.Entity> entities = documentResponse.getEntitiesList();
      System.out.printf("Found %d subdocuments:\n", entities.size());
      for (Document.Entity entity : entities) {
        float entityConfidence = entity.getConfidence();
        String pagesRangeText = pageRefsToString(entity.getPageAnchor().getPageRefsList());
        String subdocumentType = entity.getType();
        if (subdocumentType.isEmpty()) {
          System.out.printf(
              "%.2f%% confident that %s a subdocument.\n", entityConfidence * 100, pagesRangeText);
        } else {
          System.out.printf(
              "%.2f%% confident that %s a '%s' subdocument.\n",
              entityConfidence * 100, pagesRangeText, subdocumentType);
        }
      }
    }
  }

  // Converts page reference(s) to a string describing the page or page range.
  private static String pageRefsToString(List<Document.PageAnchor.PageRef> pageRefs) {
    if (pageRefs.size() == 1) {
      return String.format("page %d is", pageRefs.get(0).getPage() + 1);
    } else {
      long start = pageRefs.get(0).getPage() + 1;
      long end = pageRefs.get(1).getPage() + 1;
      return String.format("pages %d to %d are", start, end);
    }
  }
}
// [END documentai_process_splitter_document]
