/**
 * Copyright 2017, Google, Inc.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.vision;

import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import com.google.cloud.vision.spi.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
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
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.LocationInfo;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetection.WebEntity;
import com.google.cloud.vision.v1.WebDetection.WebImage;
import com.google.cloud.vision.v1.WebDetection.WebPage;
import com.google.cloud.vision.v1.Word;
import com.google.protobuf.ByteString;
import org.joda.time.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Detect {

  /**
   * Detects entities,sentiment and syntax in a document using the Natural Language API.
   *
   * @throws IOException on Input/Output errors.
   */
  public static void main(String[] args) throws IOException {
    argsHelper(args, System.out);
  }

  /**
   * Helper that handles the input passed to the program.
   *
   * @throws IOException on Input/Output errors.
   */
  public static void argsHelper(String[] args, PrintStream out) throws IOException {
    if (args.length < 1) {
      out.println("Usage:");
      out.printf(
          "\tjava %s \"<command>\" \"<path-to-image>\"\n"
              + "Commands:\n"
              + "\tfaces | labels | landmarks | logos | text | safe-search | properties"
              + "| web | crop \n"
              + "Path:\n\tA file path (ex: ./resources/wakeupcat.jpg) or a URI for a Cloud Storage "
              + "resource (gs://...)\n",
          Detect.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    Detect app = new Detect();
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
    }
  }

  /**
   * Constructs a {@link Detect} which connects to the Cloud Vision API.
   *
   * @param client The Vision API client.
   */
  public Detect() {
  }

  /**
   * Detects faces in the specified local image.
   *
   * @param filePath The path to the file to perform face detection on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectFaces(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects faces in the specified remote image.
   *
   * @param gcsPath The path to the remote file to perform face detection on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectFacesGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageAnnotatorSettings.Builder imageAnnotatorSettingsBuilder =
        ImageAnnotatorSettings.defaultBuilder();
    imageAnnotatorSettingsBuilder
        .batchAnnotateImagesSettings()
        .getRetrySettingsBuilder()
        .setTotalTimeout(Duration.standardSeconds(30));
    ImageAnnotatorSettings settings = imageAnnotatorSettingsBuilder.build();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();

    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    ImageAnnotatorClient client = ImageAnnotatorClient.create(settings);
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

  /**
   * Detects labels in the specified local image.
   *
   * @param filePath The path to the file to perform label detection on.
   * @param out A {@link PrintStream} to write detected labels to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLabels(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects labels in the specified remote image.
   *
   * @param gcsPath The path to the remote file to perform label detection on.
   * @param out A {@link PrintStream} to write detected features to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLabelsGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects landmarks in the specified local image.
   *
   * @param filePath The path to the file to perform landmark detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLandmarks(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects landmarks in the specified URI.
   *
   * @param url The path to the file to perform landmark detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLandmarksUrl(String url, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setImageUri(url).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects landmarks in the specified remote image.
   *
   * @param gcsPath The path to the remote file to perform landmark detection on.
   * @param out A {@link PrintStream} to write detected landmarks to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLandmarksGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects logos in the specified local image.
   *
   * @param filePath The path to the local file to perform logo detection on.
   * @param out A {@link PrintStream} to write detected logos to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLogos(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects logos in the specified remote image.
   *
   * @param gcsPath The path to the remote file to perform logo detection on.
   * @param out A {@link PrintStream} to write detected logos to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectLogosGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects text in the specified image.
   *
   * @param filePath The path to the file to detect text in.
   * @param out A {@link PrintStream} to write the detected text to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectText(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects text in the specified remote image.
   *
   * @param gcsPath The path to the remote file to detect text in.
   * @param out A {@link PrintStream} to write the detected text to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectTextGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects image properties such as color frequency from the specified local image.
   *
   * @param filePath The path to the file to detect properties.
   * @param out A {@link PrintStream} to write
   * @throws IOException on Input/Output errors.
   */
  public static void detectProperties(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects image properties such as color frequency from the specified remote image.
   *
   * @param gcsPath The path to the remote file to detect properties on.
   * @param out A {@link PrintStream} to write
   * @throws IOException on Input/Output errors.
   */
  public static void detectPropertiesGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Detects whether the specified image has features you would want to moderate.
   *
   * @param filePath The path to the local file used for safe search detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectSafeSearch(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

    for (AnnotateImageResponse res : responses) {
      if (res.hasError()) {
        out.printf("Error: %s\n", res.getError().getMessage());
        return;
      }

      // For full list of available annotations, see http://g.co/cloud/vision/docs
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      out.printf(
          "adult: %s\nmedical: %s\nspoofed: %s\nviolence: %s\n",
          annotation.getAdult(),
          annotation.getMedical(),
          annotation.getSpoof(),
          annotation.getViolence());
    }
  }

  /**
   * Detects whether the specified remote image has features you would want to moderate.
   *
   * @param gcsPath The path to the remote file to detect safe-search on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectSafeSearchGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

    for (AnnotateImageResponse res : responses) {
      if (res.hasError()) {
        out.printf("Error: %s\n", res.getError().getMessage());
        return;
      }

      // For full list of available annotations, see http://g.co/cloud/vision/docs
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      out.printf(
          "adult: %s\nmedical: %s\nspoofed: %s\nviolence: %s\n",
          annotation.getAdult(),
          annotation.getMedical(),
          annotation.getSpoof(),
          annotation.getViolence());
    }
  }

  /**
   * Finds references to the specified image on the web.
   *
   * @param filePath The path to the local file used for web annotation detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebDetections(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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
    }
  }

  /**
   * Detects whether the specified remote image has features you would want to moderate.
   *
   * @param gcsPath The path to the remote file to detect safe-search on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectWebDetectionsGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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
    }
  }

  /**
   * Suggests a region to crop to for a local file.
   *
   * @param filePath The path to the local file used for web annotation detection.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectCropHints(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Suggests a region to crop to for a remote file.
   *
   * @param gcsPath The path to the remote file to detect safe-search on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectCropHintsGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
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

  /**
   * Performs document text detection on a local image file.
   *
   * @param filePath The path to the local file to detect document text on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectDocumentText(String filePath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

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
              }
              paraText = paraText + wordText;
            }
            // Output Example using Paragraph:
            out.println("Paragraph: \n" + paraText);
            out.println("Bounds: \n" + para.getBoundingBox() + "\n");
            blockText = blockText + paraText;
          }
          pageText = pageText + blockText;
        }
      }
      out.println(annotation.getText());
    }
  }

  /**
   * Performs document text detection on a local image file.
   *
   * @param gcsPath The path to the remote file to detect document text on.
   * @param out A {@link PrintStream} to write the results to.
   * @throws IOException on Input/Output errors.
   */
  public static void detectDocumentTextGcs(String gcsPath, PrintStream out) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    BatchAnnotateImagesResponse response =
        ImageAnnotatorClient.create().batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

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
              }
              paraText = paraText + wordText;
            }
            // Output Example using Paragraph:
            out.println("Paragraph: \n" + paraText);
            out.println("Bounds: \n" + para.getBoundingBox() + "\n");
            blockText = blockText + paraText;
          }
          pageText = pageText + blockText;
        }
      }
      out.println(annotation.getText());
    }
  }
}
