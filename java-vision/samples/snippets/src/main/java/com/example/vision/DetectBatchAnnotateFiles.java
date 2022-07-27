/*
 * Copyright 2019 Google LLC
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

package com.example.vision;

// [START vision_batch_annotate_files_beta]
import com.google.api.core.ApiFuture;
import com.google.cloud.vision.v1p4beta1.AnnotateFileRequest;
import com.google.cloud.vision.v1p4beta1.AnnotateFileResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.Block;
import com.google.cloud.vision.v1p4beta1.Feature;
import com.google.cloud.vision.v1p4beta1.Feature.Type;
import com.google.cloud.vision.v1p4beta1.ImageAnnotatorClient;
import com.google.cloud.vision.v1p4beta1.InputConfig;
import com.google.cloud.vision.v1p4beta1.Page;
import com.google.cloud.vision.v1p4beta1.Paragraph;
import com.google.cloud.vision.v1p4beta1.Symbol;
import com.google.cloud.vision.v1p4beta1.TextAnnotation;
import com.google.cloud.vision.v1p4beta1.Word;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectBatchAnnotateFiles {

  // Performs document feature detection on a local PDF/TIFF/GIF file.
  public static void detectBatchAnnotateFiles(String filePath) {
    // String filePath = "path/to/your_file";

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Annotate the first two pages and the last one (max 5 pages)
      // First page starts at 1, and not 0. Last page is -1.
      List<Integer> pages = Arrays.asList(1, 2, -1);
      ByteString pdfBytes = ByteString.readFrom(new FileInputStream(filePath));
      Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
      // Other supported mime types : 'image/tiff' or 'image/gif'
      InputConfig inputConfig =
          InputConfig.newBuilder().setMimeType("application/pdf").setContent(pdfBytes).build();
      AnnotateFileRequest request =
          AnnotateFileRequest.newBuilder()
              .addFeatures(feat)
              .setInputConfig(inputConfig)
              .addAllPages(pages)
              .build();
      List<AnnotateFileRequest> requests = new ArrayList<>();
      requests.add(request);

      BatchAnnotateFilesRequest batchAnnotateFilesRequest =
          BatchAnnotateFilesRequest.newBuilder().addAllRequests(requests).build();
      ApiFuture<BatchAnnotateFilesResponse> future =
          client.batchAnnotateFilesCallable().futureCall(batchAnnotateFilesRequest);
      BatchAnnotateFilesResponse response = future.get();

      // Getting the first response
      AnnotateFileResponse annotateFileResponse = response.getResponses(0);

      // For full list of available annotations, see http://g.co/cloud/vision/docs
      TextAnnotation textAnnotation = annotateFileResponse.getResponses(0).getFullTextAnnotation();
      for (Page page : textAnnotation.getPagesList()) {
        String pageText = "";
        for (Block block : page.getBlocksList()) {
          String blockText = "";
          for (Paragraph para : block.getParagraphsList()) {
            String paraText = "";
            for (Word word : para.getWordsList()) {
              String wordText = "";
              for (Symbol symbol : word.getSymbolsList()) {
                wordText = wordText + symbol.getText();
                System.out.format(
                    "Symbol text: %s (Confidence: %f)\n", symbol.getText(), symbol.getConfidence());
              }
              System.out.format(
                  "Word text: %s (Confidence: %f)\n\n", wordText, word.getConfidence());
              paraText = String.format("%s %s", paraText, wordText);
            }
            // Output Example using Paragraph:
            System.out.println("\nParagraph: \n" + paraText);
            System.out.format("Paragraph Confidence: %f\n", para.getConfidence());
            blockText = blockText + paraText;
          }
          pageText = pageText + blockText;
        }
      }
      System.out.println("\nComplete annotation:");
      System.out.println(textAnnotation.getText());

    } catch (Exception e) {
      System.out.println("Error during detectPdfText: \n" + e.toString());
    }
  }
}
// [END vision_batch_annotate_files_beta]
