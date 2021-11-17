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

// [START documentai_process_form_document]

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

public class ProcessFormDocument {
  public static void processFormDocument()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String processerId = "your-processor-id";
    String filePath = "path/to/input/file.pdf";
    processFormDocument(projectId, location, processerId, filePath);
  }

  public static void processFormDocument(
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

      // Read the text recognition output from the processor
      // For a full list of Document object attributes,
      // please reference this page:
      // https://googleapis.dev/java/google-cloud-document-ai/latest/index.html

      // Get all of the document text as one big string
      String text = documentResponse.getText();
      System.out.printf("Full document text: '%s'\n", removeNewlines(text));

      // Read the text recognition output from the processor
      List<Document.Page> pages = documentResponse.getPagesList();
      System.out.printf("There are %s page(s) in this document.\n", pages.size());

      for (Document.Page page : pages) {
        System.out.printf("\n\n**** Page %d ****\n", page.getPageNumber());

        List<Document.Page.Table> tables = page.getTablesList();
        System.out.printf("Found %d table(s):\n", tables.size());
        for (Document.Page.Table table : tables) {
          printTableInfo(table, text);
        }

        List<Document.Page.FormField> formFields = page.getFormFieldsList();
        System.out.printf("Found %d form fields:\n", formFields.size());
        for (Document.Page.FormField formField : formFields) {
          String fieldName = getLayoutText(formField.getFieldName().getTextAnchor(), text);
          String fieldValue = getLayoutText(formField.getFieldValue().getTextAnchor(), text);
          System.out.printf(
              "    * '%s': '%s'\n", removeNewlines(fieldName), removeNewlines(fieldValue));
        }
      }
    }
  }

  private static void printTableInfo(Document.Page.Table table, String text) {
    Document.Page.Table.TableRow firstBodyRow = table.getBodyRows(0);
    int columnCount = firstBodyRow.getCellsCount();
    System.out.printf(
        "    Table with %d columns and %d rows:\n", columnCount, table.getBodyRowsCount());

    Document.Page.Table.TableRow headerRow = table.getHeaderRows(0);
    StringBuilder headerRowText = new StringBuilder();
    for (Document.Page.Table.TableCell cell : headerRow.getCellsList()) {
      String columnName = getLayoutText(cell.getLayout().getTextAnchor(), text);
      headerRowText.append(String.format("%s | ", removeNewlines(columnName)));
    }
    headerRowText.setLength(headerRowText.length() - 3);
    System.out.printf("        Collumns: %s\n", headerRowText.toString());

    StringBuilder firstRowText = new StringBuilder();
    for (Document.Page.Table.TableCell cell : firstBodyRow.getCellsList()) {
      String cellText = getLayoutText(cell.getLayout().getTextAnchor(), text);
      firstRowText.append(String.format("%s | ", removeNewlines(cellText)));
    }
    firstRowText.setLength(firstRowText.length() - 3);
    System.out.printf("        First row data: %s\n", firstRowText.toString());
  }

  // Extract shards from the text field
  private static String getLayoutText(Document.TextAnchor textAnchor, String text) {
    if (textAnchor.getTextSegmentsList().size() > 0) {
      int startIdx = (int) textAnchor.getTextSegments(0).getStartIndex();
      int endIdx = (int) textAnchor.getTextSegments(0).getEndIndex();
      return text.substring(startIdx, endIdx);
    }
    return "[NO TEXT]";
  }

  private static String removeNewlines(String s) {
    return s.replace("\n", "").replace("\r", "");
  }
}
// [END documentai_process_form_document]
