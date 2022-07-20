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

package com.example.vision.snippets;

// [START vision_batch_annotate_files_gcs]
import com.google.cloud.vision.v1.AnnotateFileRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.GcsSource;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.InputConfig;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.Word;
import java.io.IOException;

public class BatchAnnotateFilesGcs {

  public static void batchAnnotateFilesGcs() throws IOException {
    String gcsUri = "gs://cloud-samples-data/vision/document_understanding/kafka.pdf";
    batchAnnotateFilesGcs(gcsUri);
  }

  public static void batchAnnotateFilesGcs(String gcsUri) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
      // You can send multiple files to be annotated, this sample demonstrates how to do this with
      // one file. If you want to use multiple files, you have to create a `AnnotateImageRequest`
      // object for each file that you want annotated.
      // First specify where the vision api can find the image
      GcsSource gcsSource = GcsSource.newBuilder().setUri(gcsUri).build();

      // Specify the input config with the file's uri and its type.
      // Supported mime_type: application/pdf, image/tiff, image/gif
      // https://cloud.google.com/vision/docs/reference/rpc/google.cloud.vision.v1#inputconfig
      InputConfig inputConfig =
          InputConfig.newBuilder().setMimeType("application/pdf").setGcsSource(gcsSource).build();

      // Set the type of annotation you want to perform on the file
      // https://cloud.google.com/vision/docs/reference/rpc/google.cloud.vision.v1#google.cloud.vision.v1.Feature.Type
      Feature feature = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();

      // Build the request object for that one file. Note: for additional file you have to create
      // additional `AnnotateFileRequest` objects and store them in a list to be used below.
      // Since we are sending a file of type `application/pdf`, we can use the `pages` field to
      // specify which pages to process. The service can process up to 5 pages per document file.
      // https://cloud.google.com/vision/docs/reference/rpc/google.cloud.vision.v1#google.cloud.vision.v1.AnnotateFileRequest
      AnnotateFileRequest fileRequest =
          AnnotateFileRequest.newBuilder()
              .setInputConfig(inputConfig)
              .addFeatures(feature)
              .addPages(1) // Process the first page
              .addPages(2) // Process the second page
              .addPages(-1) // Process the last page
              .build();

      // Add each `AnnotateFileRequest` object to the batch request.
      BatchAnnotateFilesRequest request =
          BatchAnnotateFilesRequest.newBuilder().addRequests(fileRequest).build();

      // Make the synchronous batch request.
      BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(request);

      // Process the results, just get the first result, since only one file was sent in this
      // sample.
      for (AnnotateImageResponse imageResponse :
          response.getResponsesList().get(0).getResponsesList()) {
        System.out.format("Full text: %s%n", imageResponse.getFullTextAnnotation().getText());
        for (Page page : imageResponse.getFullTextAnnotation().getPagesList()) {
          for (Block block : page.getBlocksList()) {
            System.out.format("%nBlock confidence: %s%n", block.getConfidence());
            for (Paragraph par : block.getParagraphsList()) {
              System.out.format("\tParagraph confidence: %s%n", par.getConfidence());
              for (Word word : par.getWordsList()) {
                System.out.format("\t\tWord confidence: %s%n", word.getConfidence());
                for (Symbol symbol : word.getSymbolsList()) {
                  System.out.format(
                      "\t\t\tSymbol: %s, (confidence: %s)%n",
                      symbol.getText(), symbol.getConfidence());
                }
              }
            }
          }
        }
      }
    }
  }
}
// [END vision_batch_annotate_files_gcs]
