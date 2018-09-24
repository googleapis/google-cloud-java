/*
 * Copyright 2017 Google Inc.
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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1.AnnotateFileResponse;
import com.google.cloud.vision.v1.AnnotateFileResponse.Builder;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.AsyncAnnotateFileRequest;
import com.google.cloud.vision.v1.AsyncAnnotateFileResponse;
import com.google.cloud.vision.v1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.ColorInfo;
import com.google.cloud.vision.v1.CropHint;
import com.google.cloud.vision.v1.CropHintsAnnotation;
import com.google.cloud.vision.v1.DominantColorsAnnotation;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.GcsDestination;
import com.google.cloud.vision.v1.GcsSource;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageContext;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.InputConfig;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.cloud.vision.v1.LocationInfo;
import com.google.cloud.vision.v1.OperationMetadata;
import com.google.cloud.vision.v1.OutputConfig;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetection.WebEntity;
import com.google.cloud.vision.v1.WebDetection.WebImage;
import com.google.cloud.vision.v1.WebDetection.WebLabel;
import com.google.cloud.vision.v1.WebDetection.WebPage;
import com.google.cloud.vision.v1.WebDetectionParams;
import com.google.cloud.vision.v1.Word;

import com.google.protobuf.ByteString;

import com.google.protobuf.util.JsonFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
              + "\tfaces | labels | landmarks | logos | text | safe-search | properties"
              + "| web | web-entities | web-entities-include-geo | crop | ocr \n"
              + "| object-localization \n"
              + "Path:\n\tA file path (ex: ./resources/wakeupcat.jpg) or a URI for a Cloud Storage "
              + "resource (gs://...)\n"
              + "Path to File:\n\tA path to the remote file on Cloud Storage (gs://...)\n"
              + "Path to Destination\n\tA path to the remote destination on Cloud Storage for the"
              + " file to be saved. (gs://BUCKET_NAME/PREFIX/)\n");
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    if (command.equals("faces")) {
      if (path.startsWith("gs://")) {
        detectFacesGcs(path, out);
      } else {
        detectFaces(path, out);
      }
    } else if (command.equals("labels")) {
      if (path.startsWith("gs://")) {
        detectLabelsGcs(path, out);
      } else {
        detectLabels(path, out);
      }
    } else if (command.equals("landmarks")) {
      if (path.startsWith("http")) {
        detectLandmarksUrl(path, out);
      } else if (path.startsWith("gs://")) {
        detectLandmarksGcs(path, out);
      } else {
        detectLandmarks(path, out);
      }
    } else if (command.equals("logos")) {
      if (path.startsWith("gs://")) {
        detectLogosGcs(path, out);
      } else {
        detectLogos(path, out);
      }
    } else if (command.equals("text")) {
      if (path.startsWith("gs://")) {
        detectTextGcs(path, out);
      } else {
        detectText(path, out);
      }
    } else if (command.equals("properties")) {
      if (path.startsWith("gs://")) {
        detectPropertiesGcs(path, out);
      } else {
        detectProperties(path, out);
      }
    } else if (command.equals("safe-search")) {
      if (path.startsWith("gs://")) {
        detectSafeSearchGcs(path, out);
      } else {
        detectSafeSearch(path, out);
      }
    } else if (command.equals("web")) {
      if (path.startsWith("gs://")) {
        detectWebDetectionsGcs(path, out);
      } else {
        detectWebDetections(path, out);
      }
    } else if (command.equals("web-entities")) {
      if (path.startsWith("gs://")) {
        detectWebEntitiesGcs(path, out);
      } else {
        detectWebEntities(path, out);
      }
    } else if (command.equals("web-entities-include-geo")) {
      if (path.startsWith("gs://")) {
        detectWebEntitiesIncludeGeoResultsGcs(path, out);
      } else {
        detectWebEntitiesIncludeGeoResults(path, out);
      }
    } else if (command.equals("crop")) {
      if (path.startsWith("gs://")) {
        detectCropHintsGcs(path, out);
      } else {
        detectCropHints(path, out);
      }
    } else if (command.equals("fulltext")) {
      if (path.startsWith("gs://")) {
        detectDocumentTextGcs(path, out);
      } else {
        detectDocumentText(path, out);
      }
    } else if (command.equals("ocr")) {
      String destPath = args.length > 2 ? args[2] : "";
      detectDocumentsGcs(path, destPath);
    } else if (command.equals("object-localization")) {
      if (path.startsWith("gs://")) {
        detectLocalizedObjectsGcs(path, out);
      } else {
        detectLocalizedObjects(path, out);
      }
    }
  }

  /**
   * Detects faces in the specified local image.
   *
   * @param filePath The path to the file to perform face detection on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_face_detection]
  public static void detectFaces(String filePath, PrintStream out) throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
          out.printf(
              "anger: %s\njoy: %s\nsurprise: %s\nposition: %s",
              annotation.getAngerLikelihood(),
              annotation.getJoyLikelihood(),
              annotation.getSurpriseLikelihood(),
              annotation.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_face_detection]

  /**
   * Detects faces in the specified remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to perform face detection
   *                on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_face_detection_gcs]
  public static void detectFacesGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();

    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
          out.printf(
              "anger: %s\njoy: %s\nsurprise: %s\nposition: %s",
              annotation.getAngerLikelihood(),
              annotation.getJoyLikelihood(),
              annotation.getSurpriseLikelihood(),
              annotation.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_face_detection_gcs]

  /**
   * Detects labels in the specified local image.
   *
   * @param filePath The path to the file to perform label detection on.
   * @param out A {@link PrintStream} to write detected labels to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_label_detection]
  public static void detectLabels(String filePath, PrintStream out) throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
          annotation.getAllFields().forEach((k, v) -> out.printf("%s : %s\n", k, v.toString()));
        }
      }
    }
  }
  // [END vision_label_detection]

  /**
   * Detects labels in the specified remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to perform label detection
   *                on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_label_detection_gcs]
  public static void detectLabelsGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
          annotation.getAllFields().forEach((k, v) ->
              out.printf("%s : %s\n", k, v.toString()));
        }
      }
    }
  }
  // [END vision_label_detection_gcs]

  /**
   * Detects landmarks in the specified local image.
   *
   * @param filePath The path to the file to perform landmark detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_landmark_detection]
  public static void detectLandmarks(String filePath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
          LocationInfo info = annotation.getLocationsList().listIterator().next();
          out.printf("Landmark: %s\n %s\n", annotation.getDescription(), info.getLatLng());
        }
      }
    }
  }
  // [END vision_landmark_detection]

  /**
   * Detects landmarks in the specified URI.
   *
   * @param uri The path to the file to perform landmark detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLandmarksUrl(String uri, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setImageUri(uri).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
          LocationInfo info = annotation.getLocationsList().listIterator().next();
          out.printf("Landmark: %s\n %s\n", annotation.getDescription(), info.getLatLng());
        }
      }
    }
  }

  /**
   * Detects landmarks in the specified remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to perform landmark
   *                detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_landmark_detection_gcs]
  public static void detectLandmarksGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
          LocationInfo info = annotation.getLocationsList().listIterator().next();
          out.printf("Landmark: %s\n %s\n", annotation.getDescription(), info.getLatLng());
        }
      }
    }
  }
  // [END vision_landmark_detection_gcs]

  /**
   * Detects logos in the specified local image.
   *
   * @param filePath The path to the local file to perform logo detection on.
   * @param out A {@link PrintStream} to write detected logos to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_logo_detection]
  public static void detectLogos(String filePath, PrintStream out) throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
          out.println(annotation.getDescription());
        }
      }
    }
  }
  // [END vision_logo_detection]

  /**
   * Detects logos in the specified remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to perform logo detection
   *                on.
   * @param out A {@link PrintStream} to write detected logos to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_logo_detection_gcs]
  public static void detectLogosGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
          out.println(annotation.getDescription());
        }
      }
    }
  }
  // [END vision_logo_detection_gcs]

  /**
   * Detects text in the specified image.
   *
   * @param filePath The path to the file to detect text in.
   * @param out A {@link PrintStream} to write the detected text to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_text_detection]
  public static void detectText(String filePath, PrintStream out) throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
          out.printf("Text: %s\n", annotation.getDescription());
          out.printf("Position : %s\n", annotation.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_text_detection]

  /**
   * Detects text in the specified remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect text in.
   * @param out A {@link PrintStream} to write the detected text to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_text_detection_gcs]
  public static void detectTextGcs(String gcsPath, PrintStream out) throws Exception, IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
          out.printf("Text: %s\n", annotation.getDescription());
          out.printf("Position : %s\n", annotation.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_text_detection_gcs]

  /**
   * Detects image properties such as color frequency from the specified local image.
   *
   * @param filePath The path to the file to detect properties.
   * @param out A {@link PrintStream} to write
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_image_property_detection]
  public static void detectProperties(String filePath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
        for (ColorInfo color : colors.getColorsList()) {
          out.printf(
              "fraction: %f\nr: %f, g: %f, b: %f\n",
              color.getPixelFraction(),
              color.getColor().getRed(),
              color.getColor().getGreen(),
              color.getColor().getBlue());
        }
      }
    }
  }
  // [END vision_image_property_detection]

  /**
   * Detects image properties such as color frequency from the specified remote image on Google
   * Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect properties on.
   * @param out A {@link PrintStream} to write
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_image_property_detection_gcs]
  public static void detectPropertiesGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
        for (ColorInfo color : colors.getColorsList()) {
          out.printf(
              "fraction: %f\nr: %f, g: %f, b: %f\n",
              color.getPixelFraction(),
              color.getColor().getRed(),
              color.getColor().getGreen(),
              color.getColor().getBlue());
        }
      }
    }
  }
  // [END vision_image_property_detection_gcs]

  /**
   * Detects whether the specified image has features you would want to moderate.
   *
   * @param filePath The path to the local file used for safe search detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_safe_search_detection]
  public static void detectSafeSearch(String filePath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
        out.printf(
            "adult: %s\nmedical: %s\nspoofed: %s\nviolence: %s\nracy: %s\n",
            annotation.getAdult(),
            annotation.getMedical(),
            annotation.getSpoof(),
            annotation.getViolence(),
            annotation.getRacy());
      }
    }
  }
  // [END vision_safe_search_detection]

  /**
   * Detects whether the specified image on Google Cloud Storage has features you would want
   * to moderate.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect safe-search on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_safe_search_detection_gcs]
  public static void detectSafeSearchGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
        out.printf(
            "adult: %s\nmedical: %s\nspoofed: %s\nviolence: %s\nracy: %s\n",
            annotation.getAdult(),
            annotation.getMedical(),
            annotation.getSpoof(),
            annotation.getViolence(),
            annotation.getRacy());
      }
    }
  }
  // [END vision_safe_search_detection_gcs]

  // [START vision_web_detection]
  /**
   * Finds references to the specified image on the web.
   *
   * @param filePath The path to the local file used for web annotation detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebDetections(String filePath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // Search the web for usages of the image. You could use these signals later
        // for user input moderation or linking external references.
        // For a full list of available annotations, see http://g.co/cloud/vision/docs
        WebDetection annotation = res.getWebDetection();
        out.println("Entity:Id:Score");
        out.println("===============");
        for (WebEntity entity : annotation.getWebEntitiesList()) {
          out.println(entity.getDescription() + " : " + entity.getEntityId() + " : "
              + entity.getScore());
        }
        for (WebLabel label : annotation.getBestGuessLabelsList()) {
          out.format("\nBest guess label: %s", label.getLabel());
        }
        out.println("\nPages with matching images: Score\n==");
        for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
          out.println(page.getUrl() + " : " + page.getScore());
        }
        out.println("\nPages with partially matching images: Score\n==");
        for (WebImage image : annotation.getPartialMatchingImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
        out.println("\nPages with fully matching images: Score\n==");
        for (WebImage image : annotation.getFullMatchingImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
        out.println("\nPages with visually similar images: Score\n==");
        for (WebImage image : annotation.getVisuallySimilarImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
      }
    }
  }
  // [END vision_web_detection]

  // [START vision_web_detection_gcs]
  /**
   * Detects whether the remote image on Google Cloud Storage has features you would want to
   * moderate.
   *
   * @param gcsPath The path to the remote on Google Cloud Storage file to detect web annotations.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebDetectionsGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // Search the web for usages of the image. You could use these signals later
        // for user input moderation or linking external references.
        // For a full list of available annotations, see http://g.co/cloud/vision/docs
        WebDetection annotation = res.getWebDetection();
        out.println("Entity:Id:Score");
        out.println("===============");
        for (WebEntity entity : annotation.getWebEntitiesList()) {
          out.println(entity.getDescription() + " : " + entity.getEntityId() + " : "
              + entity.getScore());
        }
        for (WebLabel label : annotation.getBestGuessLabelsList()) {
          out.format("\nBest guess label: %s", label.getLabel());
        }
        out.println("\nPages with matching images: Score\n==");
        for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
          out.println(page.getUrl() + " : " + page.getScore());
        }
        out.println("\nPages with partially matching images: Score\n==");
        for (WebImage image : annotation.getPartialMatchingImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
        out.println("\nPages with fully matching images: Score\n==");
        for (WebImage image : annotation.getFullMatchingImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
        out.println("\nPages with visually similar images: Score\n==");
        for (WebImage image : annotation.getVisuallySimilarImagesList()) {
          out.println(image.getUrl() + " : " + image.getScore());
        }
      }
    }
  }
  // [END vision_web_detection_gcs]

  /**
   * Find web entities given a local image.
   * @param filePath The path of the image to detect.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebEntities(String filePath, PrintStream out) throws Exception,
      IOException {
    // Instantiates a client
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Read in the local image
      ByteString contents = ByteString.readFrom(new FileInputStream(filePath));

      // Build the image
      Image image = Image.newBuilder().setContent(contents).build();

      // Create the request with the image and the specified feature: web detection
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION))
          .setImage(image)
          .build();

      // Perform the request
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(Arrays.asList(request));

      // Display the results
      response.getResponsesList().stream()
          .forEach(r -> r.getWebDetection().getWebEntitiesList().stream()
              .forEach(entity -> {
                out.format("Description: %s\n", entity.getDescription());
                out.format("Score: %f\n", entity.getScore());
              }));
    }
  }

  /**
   * Find web entities given the remote image on Google Cloud Storage.
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect web entities.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebEntitiesGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    // Instantiates a client
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Set the image source to the given gs uri
      ImageSource imageSource = ImageSource.newBuilder()
          .setGcsImageUri(gcsPath)
          .build();
      // Build the image
      Image image = Image.newBuilder().setSource(imageSource).build();

      // Create the request with the image and the specified feature: web detection
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION))
          .setImage(image)
          .build();

      // Perform the request
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(Arrays.asList(request));

      // Display the results
      response.getResponsesList().stream()
          .forEach(r -> r.getWebDetection().getWebEntitiesList().stream()
              .forEach(entity -> {
                System.out.format("Description: %s\n", entity.getDescription());
                System.out.format("Score: %f\n", entity.getScore());
              }));
    }
  }

  // [START vision_web_detection_include_geo]
  /**
   * Find web entities given a local image.
   * @param filePath The path of the image to detect.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebEntitiesIncludeGeoResults(String filePath, PrintStream out) throws
      Exception, IOException {
    // Instantiates a client
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Read in the local image
      ByteString contents = ByteString.readFrom(new FileInputStream(filePath));

      // Build the image
      Image image = Image.newBuilder().setContent(contents).build();

      // Enable `IncludeGeoResults`
      WebDetectionParams webDetectionParams = WebDetectionParams.newBuilder()
          .setIncludeGeoResults(true)
          .build();

      // Set the parameters for the image
      ImageContext imageContext = ImageContext.newBuilder()
          .setWebDetectionParams(webDetectionParams)
          .build();

      // Create the request with the image, imageContext, and the specified feature: web detection
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION))
          .setImage(image)
          .setImageContext(imageContext)
          .build();

      // Perform the request
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(Arrays.asList(request));

      // Display the results
      response.getResponsesList().stream()
          .forEach(r -> r.getWebDetection().getWebEntitiesList().stream()
              .forEach(entity -> {
                out.format("Description: %s\n", entity.getDescription());
                out.format("Score: %f\n", entity.getScore());
              }));
    }
  }
  // [END vision_web_detection_include_geo]

  // [START vision_web_detection_include_geo_gcs]
  /**
   * Find web entities given the remote image on Google Cloud Storage.
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect web entities with
   *                geo results.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebEntitiesIncludeGeoResultsGcs(String gcsPath, PrintStream out) throws
      Exception, IOException {
    // Instantiates a client
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Set the image source to the given gs uri
      ImageSource imageSource = ImageSource.newBuilder()
          .setGcsImageUri(gcsPath)
          .build();
      // Build the image
      Image image = Image.newBuilder().setSource(imageSource).build();

      // Enable `IncludeGeoResults`
      WebDetectionParams webDetectionParams = WebDetectionParams.newBuilder()
          .setIncludeGeoResults(true)
          .build();

      // Set the parameters for the image
      ImageContext imageContext = ImageContext.newBuilder()
          .setWebDetectionParams(webDetectionParams)
          .build();

      // Create the request with the image, imageContext, and the specified feature: web detection
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION))
          .setImage(image)
          .setImageContext(imageContext)
          .build();

      // Perform the request
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(Arrays.asList(request));

      // Display the results
      response.getResponsesList().stream()
          .forEach(r -> r.getWebDetection().getWebEntitiesList().stream()
              .forEach(entity -> {
                out.format("Description: %s\n", entity.getDescription());
                out.format("Score: %f\n", entity.getScore());
              }));
    }
  }
  // [END vision_web_detection_include_geo_gcs]

  /**
   * Suggests a region to crop to for a local file.
   *
   * @param filePath The path to the local file used for web annotation detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_crop_hint_detection]
  public static void detectCropHints(String filePath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        CropHintsAnnotation annotation = res.getCropHintsAnnotation();
        for (CropHint hint : annotation.getCropHintsList()) {
          out.println(hint.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_crop_hint_detection]

  /**
   * Suggests a region to crop to for a remote file on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect safe-search on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_crop_hint_detection_gcs]
  public static void detectCropHintsGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          out.printf("Error: %s\n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        CropHintsAnnotation annotation = res.getCropHintsAnnotation();
        for (CropHint hint : annotation.getCropHintsList()) {
          out.println(hint.getBoundingPoly());
        }
      }
    }
  }
  // [END vision_crop_hint_detection_gcs]

  /**
   * Performs document text detection on a local image file.
   *
   * @param filePath The path to the local file to detect document text on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_fulltext_detection]
  public static void detectDocumentText(String filePath, PrintStream out) throws Exception,
       IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
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
        for (Page page: annotation.getPagesList()) {
          String pageText = "";
          for (Block block : page.getBlocksList()) {
            String blockText = "";
            for (Paragraph para : block.getParagraphsList()) {
              String paraText = "";
              for (Word word: para.getWordsList()) {
                String wordText = "";
                for (Symbol symbol: word.getSymbolsList()) {
                  wordText = wordText + symbol.getText();
                  out.format("Symbol text: %s (confidence: %f)\n", symbol.getText(),
                      symbol.getConfidence());
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
  // [END vision_fulltext_detection]

  /**
   * Performs document text detection on a remote image on Google Cloud Storage.
   *
   * @param gcsPath The path to the remote file on Google Cloud Storage to detect document text on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws Exception on errors while closing the client.
   * @throws IOException on Input/Output errors.
   */
  // [START vision_fulltext_detection_gcs]
  public static void detectDocumentTextGcs(String gcsPath, PrintStream out) throws Exception,
      IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
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
        for (Page page: annotation.getPagesList()) {
          String pageText = "";
          for (Block block : page.getBlocksList()) {
            String blockText = "";
            for (Paragraph para : block.getParagraphsList()) {
              String paraText = "";
              for (Word word: para.getWordsList()) {
                String wordText = "";
                for (Symbol symbol: word.getSymbolsList()) {
                  wordText = wordText + symbol.getText();
                  out.format("Symbol text: %s (confidence: %f)\n", symbol.getText(),
                      symbol.getConfidence());
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
  // [END vision_fulltext_detection_gcs]

  // [START vision_text_detection_pdf_gcs]
  /**
   * Performs document text OCR with PDF/TIFF as source files on Google Cloud Storage.
   *
   * @param gcsSourcePath The path to the remote file on Google Cloud Storage to detect document
   *                      text on.
   * @param gcsDestinationPath The path to the remote file on Google Cloud Storage to store the
   *                           results on.
   * @throws Exception on errors while closing the client.
   */
  public static void detectDocumentsGcs(String gcsSourcePath, String gcsDestinationPath) throws
      Exception {
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      List<AsyncAnnotateFileRequest> requests = new ArrayList<>();

      // Set the GCS source path for the remote file.
      GcsSource gcsSource = GcsSource.newBuilder()
          .setUri(gcsSourcePath)
          .build();

      // Create the configuration with the specified MIME (Multipurpose Internet Mail Extensions)
      // types
      InputConfig inputConfig = InputConfig.newBuilder()
          .setMimeType("application/pdf") // Supported MimeTypes: "application/pdf", "image/tiff"
          .setGcsSource(gcsSource)
          .build();

      // Set the GCS destination path for where to save the results.
      GcsDestination gcsDestination = GcsDestination.newBuilder()
          .setUri(gcsDestinationPath)
          .build();

      // Create the configuration for the output with the batch size.
      // The batch size sets how many pages should be grouped into each json output file.
      OutputConfig outputConfig = OutputConfig.newBuilder()
          .setBatchSize(2)
          .setGcsDestination(gcsDestination)
          .build();

      // Select the Feature required by the vision API
      Feature feature = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();

      // Build the OCR request
      AsyncAnnotateFileRequest request = AsyncAnnotateFileRequest.newBuilder()
          .addFeatures(feature)
          .setInputConfig(inputConfig)
          .setOutputConfig(outputConfig)
          .build();

      requests.add(request);

      // Perform the OCR request
      OperationFuture<AsyncBatchAnnotateFilesResponse, OperationMetadata> response =
          client.asyncBatchAnnotateFilesAsync(requests);

      System.out.println("Waiting for the operation to finish.");

      // Wait for the request to finish. (The result is not used, since the API saves the result to
      // the specified location on GCS.)
      List<AsyncAnnotateFileResponse> result = response.get(180, TimeUnit.SECONDS)
          .getResponsesList();

      // Once the request has completed and the output has been
      // written to GCS, we can list all the output files.
      Storage storage = StorageOptions.getDefaultInstance().getService();

      // Get the destination location from the gcsDestinationPath
      Pattern pattern = Pattern.compile("gs://([^/]+)/(.+)");
      Matcher matcher = pattern.matcher(gcsDestinationPath);

      if (matcher.find()) {
        String bucketName = matcher.group(1);
        String prefix = matcher.group(2);

        // Get the list of objects with the given prefix from the GCS bucket
        Bucket bucket = storage.get(bucketName);
        com.google.api.gax.paging.Page<Blob> pageList = bucket.list(BlobListOption.prefix(prefix));

        Blob firstOutputFile = null;

        // List objects with the given prefix.
        System.out.println("Output files:");
        for (Blob blob : pageList.iterateAll()) {
          System.out.println(blob.getName());

          // Process the first output file from GCS.
          // Since we specified batch size = 2, the first response contains
          // the first two pages of the input file.
          if (firstOutputFile == null) {
            firstOutputFile = blob;
          }
        }

        // Get the contents of the file and convert the JSON contents to an AnnotateFileResponse
        // object. If the Blob is small read all its content in one request
        // (Note: the file is a .json file)
        // Storage guide: https://cloud.google.com/storage/docs/downloading-objects
        String jsonContents = new String(firstOutputFile.getContent());
        Builder builder = AnnotateFileResponse.newBuilder();
        JsonFormat.parser().merge(jsonContents, builder);

        // Build the AnnotateFileResponse object
        AnnotateFileResponse annotateFileResponse = builder.build();

        // Parse through the object to get the actual response for the first page of the input file.
        AnnotateImageResponse annotateImageResponse = annotateFileResponse.getResponses(0);

        // Here we print the full text from the first page.
        // The response contains more information:
        // annotation/pages/blocks/paragraphs/words/symbols
        // including confidence score and bounding boxes
        System.out.format("\nText: %s\n", annotateImageResponse.getFullTextAnnotation().getText());
      } else {
        System.out.println("No MATCH");
      }
    }
  }
  // [END vision_text_detection_pdf_gcs]

  // [START vision_localize_objects]
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
  // [END vision_localize_objects]

  // [START vision_localize_objects_gcs]
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
  // [END vision_localize_objects_gcs]
}
