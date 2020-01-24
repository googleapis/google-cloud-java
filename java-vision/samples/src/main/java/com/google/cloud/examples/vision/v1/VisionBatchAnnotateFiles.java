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
// DO NOT EDIT! This is a generated sample ("Request",  "vision_batch_annotate_files")
// sample-metadata:
//   title:
//   description: Perform batch file annotation
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.VisionBatchAnnotateFiles
// [--args='[--file_path "resources/kafka.pdf"]']

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.AnnotateFileRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.InputConfig;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.Word;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class VisionBatchAnnotateFiles {
  // [START vision_batch_annotate_files]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.AnnotateFileRequest;
   * import com.google.cloud.vision.v1.AnnotateImageResponse;
   * import com.google.cloud.vision.v1.BatchAnnotateFilesRequest;
   * import com.google.cloud.vision.v1.BatchAnnotateFilesResponse;
   * import com.google.cloud.vision.v1.Block;
   * import com.google.cloud.vision.v1.Feature;
   * import com.google.cloud.vision.v1.ImageAnnotatorClient;
   * import com.google.cloud.vision.v1.InputConfig;
   * import com.google.cloud.vision.v1.Page;
   * import com.google.cloud.vision.v1.Paragraph;
   * import com.google.cloud.vision.v1.Symbol;
   * import com.google.cloud.vision.v1.Word;
   * import com.google.protobuf.ByteString;
   * import java.nio.file.Files;
   * import java.nio.file.Path;
   * import java.nio.file.Paths;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleBatchAnnotateFiles() {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "resources/kafka.pdf";
    sampleBatchAnnotateFiles(filePath);
  }

  /**
   * Perform batch file annotation
   *
   * @param filePath Path to local pdf file, e.g. /path/document.pdf
   */
  public static void sampleBatchAnnotateFiles(String filePath) {
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {

      // Supported mime_type: application/pdf, image/tiff, image/gif
      String mimeType = "application/pdf";
      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      InputConfig inputConfig =
          InputConfig.newBuilder().setMimeType(mimeType).setContent(content).build();
      Feature.Type type = Feature.Type.DOCUMENT_TEXT_DETECTION;
      Feature featuresElement = Feature.newBuilder().setType(type).build();
      List<Feature> features = Arrays.asList(featuresElement);

      // The service can process up to 5 pages per document file. Here we specify the first, second,
      // and
      // last page of the document to be processed.
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
  // [END vision_batch_annotate_files]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("file_path").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String filePath = cl.getOptionValue("file_path", "resources/kafka.pdf");

    sampleBatchAnnotateFiles(filePath);
  }
}
