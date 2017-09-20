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
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta2.Entity;
import com.google.cloud.videointelligence.v1beta2.ExplicitContentFrame;
import com.google.cloud.videointelligence.v1beta2.FaceAnnotation;
import com.google.cloud.videointelligence.v1beta2.FaceFrame;
import com.google.cloud.videointelligence.v1beta2.FaceSegment;
import com.google.cloud.videointelligence.v1beta2.Feature;
import com.google.cloud.videointelligence.v1beta2.LabelAnnotation;
import com.google.cloud.videointelligence.v1beta2.LabelDetectionConfig;
import com.google.cloud.videointelligence.v1beta2.LabelDetectionMode;
import com.google.cloud.videointelligence.v1beta2.LabelSegment;
import com.google.cloud.videointelligence.v1beta2.NormalizedBoundingBox;
import com.google.cloud.videointelligence.v1beta2.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1beta2.VideoContext;
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1beta2.VideoSegment;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.codec.binary.Base64;


public class Detect {
  /**
   * Detects entities,sentiment and syntax in a document using the Natural Language API.
   * @param args specifies features to detect and the path to the video on Google Cloud Storage.
   *
   * @throws IOException on Input/Output errors.
   */
  public static void main(String[] args) throws Exception {
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
  public static void argsHelper(String[] args) throws Exception {
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
    if (command.equals("explicit-content")) {
      analyzeExplicitContent(path);
    }
  }

  /**
   * Performs facial analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeFaces(String gcsUri) throws Exception {
    // [START detect_faces]
    // Instantiate a com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // detect shot and frame
      LabelDetectionConfig labelDetectionConfig = LabelDetectionConfig.newBuilder()
          .setLabelDetectionMode(LabelDetectionMode.SHOT_AND_FRAME_MODE)
          .build();

      VideoContext videoContext = VideoContext.newBuilder()
          .setLabelDetectionConfig(labelDetectionConfig)
          .build();

      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .setVideoContext(videoContext)
          .addFeatures(Feature.LABEL_DETECTION)
          .build();

      // asynchronously perform facial analysis on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> response
          = client.annotateVideoAsync(request);

      boolean faceFound = false;
      for (VideoAnnotationResults results : response.get().getAnnotationResultsList()) {
        int faceCount = 0;
        for (FaceAnnotation faceAnnotation : results.getFaceAnnotationsList()) {
          faceFound = true;
          System.out.println("Face: " + ++faceCount);
          System.out.println("Thumbnail size: " + faceAnnotation.getThumbnail().size());
          for (FaceSegment segment : faceAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location : %.3f:%.3f\n", startTime, endTime);
          }
          // printing info on the first frame
          FaceFrame frame = faceAnnotation.getFrames(0);
          double timeOffset = frame.getTimeOffset().getSeconds()
              + frame.getTimeOffset().getNanos() / 1e9;
          System.out.printf("First frame time offset: %.3fs", timeOffset);
          // print info on the first normalized bounding box
          NormalizedBoundingBox box = frame.getNormalizedBoundingBoxesList().get(0);
          System.out.printf("Left: %.3f\n", box.getLeft());
          System.out.printf("Top: %.3f\n", box.getTop());
          System.out.printf("Bottom: %.3f\n", box.getBottom());
          System.out.printf("Right: %.3f\n", box.getRight());
        }
      }
      if (!faceFound) {
        System.out.println("No faces detected in " + gcsUri);
      }
      // [END detect_faces]
    }
  }

  /**
   * Performs label analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeLabels(String gcsUri) throws Exception {
    // [START detect_labels_gcs]
    // Instantiate a com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Provide path to file hosted on GCS as "gs://bucket-name/..."
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.LABEL_DETECTION)
          .build();
      // Create an operation that will contain the response when the operation completes.
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      for (VideoAnnotationResults results : operation.get().getAnnotationResultsList()) {
        // process video / segment level label annotations
        System.out.println("Locations: ");
        for (LabelAnnotation labelAnnotation : results.getSegmentLabelAnnotationsList()) {
          System.out
              .println("Video label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Video label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.3f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }

        // process shot label annotations
        for (LabelAnnotation labelAnnotation : results.getShotLabelAnnotationsList()) {
          System.out
              .println("Shot label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Shot label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.3f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }

        // process frame label annotations
        for (LabelAnnotation labelAnnotation : results.getFrameLabelAnnotationsList()) {
          System.out
              .println("Frame label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Frame label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.2f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }
      }
    }
    // [END detect_labels_gcs]
  }

  /**
   * Performs label analysis on the video at the provided file path.
   *
   * @param filePath the path to the video file to analyze.
   */
  public static void analyzeLabelsFile(String filePath) throws Exception {
    // [START detect_labels_file]
    // Instantiate a com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Read file and encode into Base64
      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      byte[] encodedBytes = Base64.encodeBase64(data);

      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputContent(ByteString.copyFrom(encodedBytes))
          .addFeatures(Feature.LABEL_DETECTION)
          .build();

      // Create an operation that will contain the response when the operation completes.
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      for (VideoAnnotationResults results : operation.get().getAnnotationResultsList()) {
        // process video / segment level label annotations
        System.out.println("Locations: ");
        for (LabelAnnotation labelAnnotation : results.getSegmentLabelAnnotationsList()) {
          System.out
              .println("Video label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Video label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.2f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }

        // process shot label annotations
        for (LabelAnnotation labelAnnotation : results.getShotLabelAnnotationsList()) {
          System.out
              .println("Shot label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Shot label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.2f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }

        // process frame label annotations
        for (LabelAnnotation labelAnnotation : results.getFrameLabelAnnotationsList()) {
          System.out
              .println("Frame label: " + labelAnnotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : labelAnnotation.getCategoryEntitiesList()) {
            System.out.println("Frame label category: " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : labelAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3f:%.2f\n", startTime, endTime);
            System.out.println("Confidence: " + segment.getConfidence());
          }
        }
      }
    }
    // [END detect_labels_file]
  }

  /**
   * Performs shot analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeShots(String gcsUri) throws Exception {
    // [START detect_shots]
    // Instantiate a com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Provide path to file hosted on GCS as "gs://bucket-name/..."
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.SHOT_CHANGE_DETECTION)
          .build();

      // Create an operation that will contain the response when the operation completes.
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
          client.annotateVideoAsync(request);
      System.out.println("Waiting for operation to complete...");

      // Print detected shot changes and their location ranges in the analyzed video.
      for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
        if (result.getShotAnnotationsCount() > 0) {
          System.out.println("Shots: ");
          for (VideoSegment segment : result.getShotAnnotationsList()) {
            double startTime = segment.getStartTimeOffset().getSeconds()
                + segment.getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getEndTimeOffset().getSeconds()
                + segment.getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Location: %.3f:%.3f\n", startTime, endTime);
          }
        } else {
          System.out.println("No shot changes detected in " + gcsUri);
        }
      }
    }
    // [END detect_shots]
  }

  /**
   * Performs explicit content analysis on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeExplicitContent(String gcsUri) throws Exception {
    // [START detect_explicit_content]
    // Instantiate a com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Create an operation that will contain the response when the operation completes.
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.EXPLICIT_CONTENT_DETECTION)
          .build();

      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");

      // Print detected annotations and their positions in the analyzed video.
      for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
        for (ExplicitContentFrame frame : result.getExplicitAnnotation().getFramesList()) {
          double frameTime =
              frame.getTimeOffset().getSeconds() + frame.getTimeOffset().getNanos() / 1e9;
          System.out.printf("Location: %.3fs\n", frameTime);
          System.out.println("Adult: " + frame.getPornographyLikelihood());
        }
      }
      // [END detect_explicit_content]
    }
  }
}
