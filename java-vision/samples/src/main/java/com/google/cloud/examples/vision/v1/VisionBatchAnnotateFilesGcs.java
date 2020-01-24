/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "vision_batch_annotate_files_gcs")
// sample-metadata:
//   title:
//   description: Perform batch file annotation
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.VisionBatchAnnotateFilesGcs
// [--args='[--storage_uri "gs://cloud-samples-data/vision/document_understanding/kafka.pdf"]']

package com.google.cloud.examples.vision.v1;

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
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class VisionBatchAnnotateFilesGcs {
  // [START vision_batch_annotate_files_gcs]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.AnnotateFileRequest;
   * import com.google.cloud.vision.v1.AnnotateImageResponse;
   * import com.google.cloud.vision.v1.BatchAnnotateFilesRequest;
   * import com.google.cloud.vision.v1.BatchAnnotateFilesResponse;
   * import com.google.cloud.vision.v1.Block;
   * import com.google.cloud.vision.v1.Feature;
   * import com.google.cloud.vision.v1.GcsSource;
   * import com.google.cloud.vision.v1.ImageAnnotatorClient;
   * import com.google.cloud.vision.v1.InputConfig;
   * import com.google.cloud.vision.v1.Page;
   * import com.google.cloud.vision.v1.Paragraph;
   * import com.google.cloud.vision.v1.Symbol;
   * import com.google.cloud.vision.v1.Word;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleBatchAnnotateFiles() {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://cloud-samples-data/vision/document_understanding/kafka.pdf";
    sampleBatchAnnotateFiles(storageUri);
  }

  /**
   * Perform batch file annotation
   *
   * @param storageUri Cloud Storage URI to source image in the format gs://[bucket]/[file]
   */
  public static void sampleBatchAnnotateFiles(String storageUri) {
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
      GcsSource gcsSource = GcsSource.newBuilder().setUri(storageUri).build();
      InputConfig inputConfig = InputConfig.newBuilder().setGcsSource(gcsSource).build();
      Feature.Type type = Feature.Type.DOCUMENT_TEXT_DETECTION;
      Feature featuresElement = Feature.newBuilder().setType(type).build();
      List<Feature> features = Arrays.asList(featuresElement);

      // The service can process up to 5 pages per document file.
      // Here we specify the first, second, and last page of the document to be processed.
      int pagesElement = 1;
      int pagesElement2 = 2;
      int pagesElement3 = -1;
      List<Integer> pages = Arrays.asList(pagesElement, pagesElement2, pagesElement3);
      AnnotateFileRequest requestsElement =
          AnnotateFileRequest.newBuilder()
              .setInputConfig(inputConfig)
              .addAllFeatures(features)
              .addAllPages(pages)
              .build();
      List<AnnotateFileRequest> requests = Arrays.asList(requestsElement);
      BatchAnnotateFilesRequest request =
          BatchAnnotateFilesRequest.newBuilder().addAllRequests(requests).build();
      BatchAnnotateFilesResponse response = imageAnnotatorClient.batchAnnotateFiles(request);
      for (AnnotateImageResponse imageResponse :
          response.getResponsesList().get(0).getResponsesList()) {
        System.out.printf("Full text: %s\n", imageResponse.getFullTextAnnotation().getText());
        for (Page page : imageResponse.getFullTextAnnotation().getPagesList()) {
          for (Block block : page.getBlocksList()) {
            System.out.printf("\nBlock confidence: %s\n", block.getConfidence());
            for (Paragraph par : block.getParagraphsList()) {
              System.out.printf("\tParagraph confidence: %s\n", par.getConfidence());
              for (Word word : par.getWordsList()) {
                System.out.printf("\t\tWord confidence: %s\n", word.getConfidence());
                for (Symbol symbol : word.getSymbolsList()) {
                  System.out.printf(
                      "\t\t\tSymbol: %s, (confidence: %s)\n",
                      symbol.getText(), symbol.getConfidence());
                }
              }
            }
          }
        }
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END vision_batch_annotate_files_gcs]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("storage_uri").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String storageUri =
        cl.getOptionValue(
            "storage_uri", "gs://cloud-samples-data/vision/document_understanding/kafka.pdf");

    sampleBatchAnnotateFiles(storageUri);
  }
}
