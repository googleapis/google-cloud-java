/*
 * Copyright 2017, Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.video;

import com.google.api.gax.rpc.OperationFuture;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta1.FaceAnnotation;
import com.google.cloud.videointelligence.v1beta1.Feature;
import com.google.cloud.videointelligence.v1beta1.LabelAnnotation;
import com.google.cloud.videointelligence.v1beta1.LabelLocation;
import com.google.cloud.videointelligence.v1beta1.Likelihood;
import com.google.cloud.videointelligence.v1beta1.SafeSearchAnnotation;
import com.google.cloud.videointelligence.v1beta1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1beta1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1beta1.VideoIntelligenceServiceSettings;
import com.google.cloud.videointelligence.v1beta1.VideoSegment;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import org.apache.commons.codec.binary.Base64;


public class Detect {
  /**
   * Detects entities,sentiment and syntax in a document using the Natural Language API.
   * @param args specifies features to detect and the path to the video on Google Cloud Storage.
   *
   * @throws IOException on Input/Output errors.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    try {
      argsHelper(args);
    } catch (Exception e) {
      System.out.println("Exception while running:\n" + e.getMessage() + "\n");
      e.printStackTrace(System.out);
    }
  }

  /**
   * Helper that handles the input passed to the program.
   * @param args specifies features to detect and the path to the video on Google Cloud Storage.
   *
   * @throws IOException on Input/Output errors.
   */
  public static void argsHelper(String[] args) throws
      ExecutionException, IOException, InterruptedException {
    if (args.length < 1) {
      System.out.println("Usage:");
      System.out.printf(
          "\tjava %s \"<command>\" \"<path-to-video>\"\n"
              + "Commands:\n"
              + "\tfaces | labels | shots\n"
              + "Path:\n\tA URI for a Cloud Storage resource (gs://...)\n"
              + "Examples: ",
          Detect.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    if (command.equals("faces")) {
      analyzeFaces(path);
    }
    if (command.equals("labels")) {
      analyzeLabels(path);
    }
    if (command.equals("labels-file")) {
      analyzeLabelsFile(path);
    }
    if (command.equals("shots")) {
      analyzeShots(path);
    }
    if (command.equals("safesearch")) {
      analyzeSafeSearch(path);
    }
  }

  /**
   * Performs facial analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeFaces(String gcsUri) throws ExecutionException,
      IOException, InterruptedException {
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);


    // Create an operation that will contain the response when the operation completes.
    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
            .setInputUri(gcsUri)
            .addFeatures(Feature.FACE_DETECTION)
            .build();

    OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
            client.annotateVideoAsync(request);

    System.out.println("Waiting for operation to complete...");
    for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
      if (result.getFaceAnnotationsCount() > 0) {
        System.out.println("Faces:");
        for (FaceAnnotation annotation : result.getFaceAnnotationsList()) {
          System.out.println("\tFace Thumb is of length: " + annotation.getThumbnail().length());
          for (VideoSegment seg : annotation.getSegmentsList()) {
            System.out.printf("\t\tLocation: %fs - %fs\n",
                seg.getStartTimeOffset() / 1000000.0,
                seg.getEndTimeOffset() / 1000000.0);
          }
          System.out.println();
        }
        System.out.println();
      } else {
        System.out.println("No faces detected in " + gcsUri);
      }
    }
  }

  /**
   * Performs label analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeLabels(String gcsUri) throws
      ExecutionException, IOException, InterruptedException {
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

    // Create an operation that will contain the response when the operation completes.
    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
            .setInputUri(gcsUri)
            .addFeatures(Feature.LABEL_DETECTION)
            .build();

    OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
            client.annotateVideoAsync(request);

    System.out.println("Waiting for operation to complete...");
    for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
      if (result.getLabelAnnotationsCount() > 0) {
        System.out.println("Labels:");
        for (LabelAnnotation annotation : result.getLabelAnnotationsList()) {
          System.out.println("\tDescription: " + annotation.getDescription());
          for (LabelLocation loc : annotation.getLocationsList()) {
            if (loc.getSegment().getStartTimeOffset() == -1
                && loc.getSegment().getEndTimeOffset() == -1) {
              System.out.println("\tLocation: Entire video");
            } else {
              System.out.printf(
                  "\tLocation: %fs - %fs\n",
                  loc.getSegment().getStartTimeOffset() / 1000000.0,
                  loc.getSegment().getEndTimeOffset() / 1000000.0);
            }
          }
          System.out.println();
        }
      } else {
        System.out.println("No labels detected in " + gcsUri);
      }
    }
  }

  /**
   * Performs label analysis on the video at the provided file path.
   *
   * @param filePath the path to the video file to analyze.
   */
  public static void analyzeLabelsFile(String filePath) throws
          ExecutionException, IOException, InterruptedException {
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

    Path path = Paths.get(filePath);
    byte[] data = Files.readAllBytes(path);
    byte[] encodedBytes = Base64.encodeBase64(data);

    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
        .setInputContent(new String(encodedBytes, "UTF-8"))
        .addFeatures(Feature.LABEL_DETECTION)
        .build();

    OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
        client.annotateVideoAsync(request);

    System.out.println("Waiting for operation to complete...");
    for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
      if (result.getLabelAnnotationsCount() > 0) {
        System.out.println("Labels:");
        for (LabelAnnotation annotation : result.getLabelAnnotationsList()) {
          System.out.println("\tDescription: " + annotation.getDescription());
          for (LabelLocation loc : annotation.getLocationsList()) {
            if (loc.getSegment().getStartTimeOffset() == -1
                && loc.getSegment().getEndTimeOffset() == -1) {
              System.out.println("\tLocation: Entire video");
            } else {
              System.out.printf(
                  "\tLocation: %fs - %fs\n",
                  loc.getSegment().getStartTimeOffset() / 1000000.0,
                  loc.getSegment().getEndTimeOffset() / 1000000.0);
            }
          }
          System.out.println();
        }
      } else {
        System.out.println("No labels detected in " + filePath);
      }
    }
  }

  /**
   * Performs shot analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeShots(String gcsUri)
      throws ExecutionException, IOException, InterruptedException {
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

    // Create an operation that will contain the response when the operation completes.
    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
            .setInputUri(gcsUri)
            .addFeatures(Feature.SHOT_CHANGE_DETECTION)
            .build();

    OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
            client.annotateVideoAsync(request);

    System.out.println("Waiting for operation to complete...");

    // Print detected shot changes and their location ranges in the analyzed video.
    for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
      if (result.getShotAnnotationsCount() > 0) {
        System.out.println("Shots:");
        int segCount = 0;
        for (VideoSegment seg : result.getShotAnnotationsList()) {
          System.out.println("\tSegment: " + segCount++);
          System.out.printf("\tLocation: %fs - %fs\n",
              seg.getStartTimeOffset() / 1000000.0,
              seg.getEndTimeOffset() / 1000000.0);
        }
        System.out.println();
      } else {
        System.out.println("No shot changes detected in " + gcsUri);
      }
    }
  }

  /**
   * Performs safe search analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeSafeSearch(String gcsUri)
          throws ExecutionException, IOException, InterruptedException {
    VideoIntelligenceServiceSettings settings =
            VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

    // Create an operation that will contain the response when the operation completes.
    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
            .setInputUri(gcsUri)
            .addFeatures(Feature.SAFE_SEARCH_DETECTION)
            .build();

    OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
            client.annotateVideoAsync(request);

    System.out.println("Waiting for operation to complete...");

    // Print detected safe search annotations and their positions in the analyzed video.
    boolean foundUnsafe = false;
    for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
      if (result.getSafeSearchAnnotationsCount() > 0) {
        System.out.println("Safe search annotations:");
        for (SafeSearchAnnotation note : result.getSafeSearchAnnotationsList()) {
          System.out.printf("Location: %fs\n", note.getTimeOffset() / 1000000.0);
          System.out.println("\tAdult: " + note.getAdult().name());
          System.out.println("\tMedical: " + note.getMedical().name());
          System.out.println("\tRacy: " + note.getRacy().name());
          System.out.println("\tSpoof: " + note.getSpoof().name());
          System.out.println("\tViolent: " + note.getViolent().name());
          System.out.println();

          if (note.getAdult().compareTo(Likelihood.LIKELY) > 1
              || note.getViolent().compareTo(Likelihood.LIKELY) > 1
              || note.getRacy().compareTo(Likelihood.LIKELY) > 1) {
            foundUnsafe = false;
          }
        }
      } else {
        System.out.println("No safe search annotations detected in " + gcsUri);
      }
    }

    if (foundUnsafe) {
      System.out.println("Found potentially unsafe content.");
    } else {
      System.out.println("Did not detect unsafe content.");
    }
  }
}
