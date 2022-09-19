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

// [START documentai_process_ocr_document]

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

public class ProcessOcrDocument {
  public static void processOcrDocument()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String location = "your-project-location"; // Format is "us" or "eu".
    String processerId = "your-processor-id";
    String filePath = "path/to/input/file.pdf";
    processOcrDocument(projectId, location, processerId, filePath);
  }

  public static void processOcrDocument(
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
      System.out.printf("Full document text: '%s'\n", escapeNewlines(text));

      // Read the text recognition output from the processor
      List<Document.Page> pages = documentResponse.getPagesList();
      System.out.printf("There are %s page(s) in this document.\n", pages.size());

      for (Document.Page page : pages) {
        System.out.printf("Page %d:\n", page.getPageNumber());
        printPageDimensions(page.getDimension());
        printDetectedLanguages(page.getDetectedLanguagesList());
        printParagraphs(page.getParagraphsList(), text);
        printBlocks(page.getBlocksList(), text);
        printLines(page.getLinesList(), text);
        printTokens(page.getTokensList(), text);
      }
    }
  }

  private static void printPageDimensions(Document.Page.Dimension dimension) {
    String unit = dimension.getUnit();
    System.out.printf("    Width: %.1f %s\n", dimension.getWidth(), unit);
    System.out.printf("    Height: %.1f %s\n", dimension.getHeight(), unit);
  }

  private static void printDetectedLanguages(
      List<Document.Page.DetectedLanguage> detectedLangauges) {
    System.out.println("    Detected languages:");
    for (Document.Page.DetectedLanguage detectedLanguage : detectedLangauges) {
      String languageCode = detectedLanguage.getLanguageCode();
      float confidence = detectedLanguage.getConfidence();
      System.out.printf("        %s (%.2f%%)\n", languageCode, confidence * 100.0);
    }
  }

  private static void printParagraphs(List<Document.Page.Paragraph> paragraphs, String text) {
    System.out.printf("    %d paragraphs detected:\n", paragraphs.size());
    Document.Page.Paragraph firstParagraph = paragraphs.get(0);
    String firstParagraphText = getLayoutText(firstParagraph.getLayout().getTextAnchor(), text);
    System.out.printf("        First paragraph text: %s\n", escapeNewlines(firstParagraphText));
    Document.Page.Paragraph lastParagraph = paragraphs.get(paragraphs.size() - 1);
    String lastParagraphText = getLayoutText(lastParagraph.getLayout().getTextAnchor(), text);
    System.out.printf("        Last paragraph text: %s\n", escapeNewlines(lastParagraphText));
  }

  private static void printBlocks(List<Document.Page.Block> blocks, String text) {
    System.out.printf("    %d blocks detected:\n", blocks.size());
    Document.Page.Block firstBlock = blocks.get(0);
    String firstBlockText = getLayoutText(firstBlock.getLayout().getTextAnchor(), text);
    System.out.printf("        First block text: %s\n", escapeNewlines(firstBlockText));
    Document.Page.Block lastBlock = blocks.get(blocks.size() - 1);
    String lastBlockText = getLayoutText(lastBlock.getLayout().getTextAnchor(), text);
    System.out.printf("        Last block text: %s\n", escapeNewlines(lastBlockText));
  }

  private static void printLines(List<Document.Page.Line> lines, String text) {
    System.out.printf("    %d lines detected:\n", lines.size());
    Document.Page.Line firstLine = lines.get(0);
    String firstLineText = getLayoutText(firstLine.getLayout().getTextAnchor(), text);
    System.out.printf("        First line text: %s\n", escapeNewlines(firstLineText));
    Document.Page.Line lastLine = lines.get(lines.size() - 1);
    String lastLineText = getLayoutText(lastLine.getLayout().getTextAnchor(), text);
    System.out.printf("        Last line text: %s\n", escapeNewlines(lastLineText));
  }

  private static void printTokens(List<Document.Page.Token> tokens, String text) {
    System.out.printf("    %d tokens detected:\n", tokens.size());
    Document.Page.Token firstToken = tokens.get(0);
    String firstTokenText = getLayoutText(firstToken.getLayout().getTextAnchor(), text);
    System.out.printf("        First token text: %s\n", escapeNewlines(firstTokenText));
    Document.Page.Token lastToken = tokens.get(tokens.size() - 1);
    String lastTokenText = getLayoutText(lastToken.getLayout().getTextAnchor(), text);
    System.out.printf("        Last token text: %s\n", escapeNewlines(lastTokenText));
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

  private static String escapeNewlines(String s) {
    return s.replace("\n", "\\n").replace("\r", "\\r");
  }
}
// [END documentai_process_ocr_document]
