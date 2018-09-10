/*
 * Copyright 2018 Google Inc.
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

import com.google.cloud.vision.v1p3beta1.AnnotateImageRequest;
import com.google.cloud.vision.v1p3beta1.AnnotateImageResponse;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p3beta1.Block;
import com.google.cloud.vision.v1p3beta1.Feature;
import com.google.cloud.vision.v1p3beta1.Feature.Type;
import com.google.cloud.vision.v1p3beta1.Image;
import com.google.cloud.vision.v1p3beta1.ImageAnnotatorClient;
import com.google.cloud.vision.v1p3beta1.ImageContext;
import com.google.cloud.vision.v1p3beta1.ImageSource;
import com.google.cloud.vision.v1p3beta1.LocalizedObjectAnnotation;
import com.google.cloud.vision.v1p3beta1.Page;
import com.google.cloud.vision.v1p3beta1.Paragraph;
import com.google.cloud.vision.v1p3beta1.Symbol;
import com.google.cloud.vision.v1p3beta1.TextAnnotation;
import com.google.cloud.vision.v1p3beta1.Word;
import com.google.protobuf.ByteString;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Detect {

  /**
   * Detects entities, sentiment, and syntax in a document using the Vision API.
   *
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void main(String[] args) throws Exception, IOException {
    argsHelper(args, System.out);
  }

  /**
   * Helper that handles the input passed to the program.
   *
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void argsHelper(String[] args, PrintStream out) throws Exception, IOException {
    if (args.length < 1) {
      out.println("Usage:");
      out.printf(
          "\tmvn exec:java -DDetect -Dexec.args=\"<command> <path-to-image>\"\n"
              + "\tmvn exec:java -DDetect -Dexec.args=\"ocr <path-to-file> <path-to-destination>\""
              + "\n"
              + "Commands:\n"
              + "\tobject-localization| handwritten-ocr\n"
              + "Path:\n\tA file path (ex: ./resources/wakeupcat.jpg) or a URI for a Cloud Storage "
              + "resource (gs://...)\n"
              + "Path to File:\n\tA path to the remote file on Cloud Storage (gs://...)\n"
              + "Path to Destination\n\tA path to the remote destination on Cloud Storage for the"
              + " file to be saved. (gs://BUCKET_NAME/PREFIX/)\n");
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    if (command.equals("object-localization")) {
      if (path.startsWith("gs://")) {
        detectLocalizedObjectsGcs(path, out);
      } else {
        detectLocalizedObjects(path, out);
      }
    } else if (command.equals("handwritten-ocr")) {
      if (path.startsWith("gs://")) {
        detectHandwrittenOcrGcs(path, out);
      } else {
        detectHandwrittenOcr(path, out);
      }
    }
  }

  // [START vision_localize_objects_beta]
  /**
   * Detects localized objects in the specified local image.
   *
   * @param filePath The path to the file to perform localized object detection on.
   * @param out A {@link PrintStream} to write detected objects to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLocalizedObjects(String filePath, PrintStream out)
      throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION))
            .setImage(img)
            .build();
    requests.add(request);

    // Perform the request
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      // Display the results
      for (AnnotateImageResponse res : responses) {
        for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
          out.format("Object name: %s\n", entity.getName());
          out.format("Confidence: %s\n", entity.getScore());
          out.format("Normalized Vertices:\n");
          entity
              .getBoundingPoly()
              .getNormalizedVerticesList()
              .forEach(vertex -> out.format("- (%s, %s)\n", vertex.getX(), vertex.getY()));
        }
      }
    }
  }
  // [END vision_localize_objects_beta]

  // [START vision_localize_objects_gcs_beta]
  /**
   * Detects localized objects in a remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect localized objects
   *     on.
   * @param out A {@link PrintStream} to write detected objects to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLocalizedObjectsGcs(String gcsPath, PrintStream out)
      throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();

    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION))
            .setImage(img)
            .build();
    requests.add(request);

    // Perform the request
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();
      client.close();
      // Display the results
      for (AnnotateImageResponse res : responses) {
        for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
          out.format("Object name: %s\n", entity.getName());
          out.format("Confidence: %s\n", entity.getScore());
          out.format("Normalized Vertices:\n");
          entity
              .getBoundingPoly()
              .getNormalizedVerticesList()
              .forEach(vertex -> out.format("- (%s, %s)\n", vertex.getX(), vertex.getY()));
        }
      }
    }
  }
  // [END vision_localize_objects_gcs_beta]

  // [START vision_handwritten_ocr_beta]
  /**
   * Performs handwritten text detection on a local image file.
   *
   * @param filePath The path to the local file to detect handwritten text on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectHandwrittenOcr(String filePath, PrintStream out) throws Exception {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    // Set the Language Hint codes for handwritten OCR
    ImageContext imageContext =
        ImageContext.newBuilder().addLanguageHints("en-t-i0-handwrit").build();

    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImage(img)
            .setImageContext(imageContext)
            .build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();
      client.close();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        TextAnnotation annotation = res.getFullTextAnnotation();
        for (Page page : annotation.getPagesList()) {
          String pageText = "";
          for (Block block : page.getBlocksList()) {
            String blockText = "";
            for (Paragraph para : block.getParagraphsList()) {
              String paraText = "";
              for (Word word : para.getWordsList()) {
                String wordText = "";
                for (Symbol symbol : word.getSymbolsList()) {
                  wordText = wordText + symbol.getText();
                  out.format(
                      "Symbol text: %s (confidence: %f)\n",
                      symbol.getText(), symbol.getConfidence());
                }
                out.format("Word text: %s (confidence: %f)\n\n", wordText, word.getConfidence());
                paraText = String.format("%s %s", paraText, wordText);
              }
              // Output Example using Paragraph:
              out.println("\nParagraph: \n" + paraText);
              out.format("Paragraph Confidence: %f\n", para.getConfidence());
              blockText = blockText + paraText;
            }
            pageText = pageText + blockText;
          }
        }
        out.println("\nComplete annotation:");
        out.println(annotation.getText());
      }
    }
  }
  // [END vision_handwritten_ocr_beta]

  // [START vision_handwritten_ocr_gcs_beta]
  /**
   * Performs handwritten text detection on a remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect handwritten text
   *     on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectHandwrittenOcrGcs(String gcsPath, PrintStream out) throws Exception {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();

    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    // Set the parameters for the image
    ImageContext imageContext =
        ImageContext.newBuilder().addLanguageHints("en-t-i0-handwrit").build();

    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImage(img)
            .setImageContext(imageContext)
            .build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();
      client.close();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        TextAnnotation annotation = res.getFullTextAnnotation();
        for (Page page : annotation.getPagesList()) {
          String pageText = "";
          for (Block block : page.getBlocksList()) {
            String blockText = "";
            for (Paragraph para : block.getParagraphsList()) {
              String paraText = "";
              for (Word word : para.getWordsList()) {
                String wordText = "";
                for (Symbol symbol : word.getSymbolsList()) {
                  wordText = wordText + symbol.getText();
                  out.format(
                      "Symbol text: %s (confidence: %f)\n",
                      symbol.getText(), symbol.getConfidence());
                }
                out.format("Word text: %s (confidence: %f)\n\n", wordText, word.getConfidence());
                paraText = String.format("%s %s", paraText, wordText);
              }
              // Output Example using Paragraph:
              out.println("\nParagraph: \n" + paraText);
              out.format("Paragraph Confidence: %f\n", para.getConfidence());
              blockText = blockText + paraText;
            }
            pageText = pageText + blockText;
          }
        }
        out.println("\nComplete annotation:");
        out.println(annotation.getText());
      }
    }
  }
  // [END vision_handwritten_ocr_gcs_beta]
}
