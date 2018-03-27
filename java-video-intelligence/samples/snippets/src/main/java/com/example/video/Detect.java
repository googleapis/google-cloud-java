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

package com.example.video;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.videointelligence.v1p1beta1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1p1beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p1beta1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1p1beta1.EmotionAttribute;
import com.google.cloud.videointelligence.v1p1beta1.FaceConfig;
import com.google.cloud.videointelligence.v1p1beta1.FaceDetectionAnnotation;
import com.google.cloud.videointelligence.v1p1beta1.FaceDetectionFrame;
import com.google.cloud.videointelligence.v1p1beta1.FaceSegment;
import com.google.cloud.videointelligence.v1p1beta1.Feature;
import com.google.cloud.videointelligence.v1p1beta1.NormalizedBoundingBox;
import com.google.cloud.videointelligence.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.videointelligence.v1p1beta1.SpeechTranscription;
import com.google.cloud.videointelligence.v1p1beta1.SpeechTranscriptionConfig;
import com.google.cloud.videointelligence.v1p1beta1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1p1beta1.VideoContext;
import com.google.cloud.videointelligence.v1p1beta1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1p1beta1.WordInfo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Detect {
  /**
   * Detects face's bounding boxes, emotions, and video transcription using the Video Intelligence
   * API
   * @param args specifies features to detect and the path to the video on Google Cloud Storage.
   */
  public static void main(String[] args) {
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
              + "\tfaces-bounding-boxes | faces-emotions | speech-transcription\n"
              + "Path:\n\tA URI for a Cloud Storage resource (gs://...)\n"
              + "Examples: ",
          Detect.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    if (command.equals("faces-bounding-boxes")) {
      analyzeFacesBoundingBoxes(path);
    }
    if (command.equals("faces-emotions")) {
      analyzeFaceEmotions(path);
    }
    if (command.equals("speech-transcription")) {
      speechTranscription(path);
    }
  }


  // [START video_face_bounding_boxes]
  /**
   * Detects faces' bounding boxes on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeFacesBoundingBoxes(String gcsUri) throws Exception {
    // Instantiate a com.google.cloud.videointelligence.v1p1beta1.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Set the configuration to include bounding boxes
      FaceConfig config = FaceConfig.newBuilder()
          .setIncludeBoundingBoxes(true)
          .build();

      // Set the video context with the above configuration
      VideoContext context = VideoContext.newBuilder()
          .setFaceDetectionConfig(config)
          .build();

      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.FACE_DETECTION)
          .setVideoContext(context)
          .build();

      // asynchronously perform facial analysis on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> response =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      boolean faceFound = false;
      // Display the results
      for (VideoAnnotationResults results : response.get(900, TimeUnit.SECONDS)
          .getAnnotationResultsList()) {
        int faceCount = 0;
        // Display the results for each face
        for (FaceDetectionAnnotation faceAnnotation : results.getFaceDetectionAnnotationsList()) {
          faceFound = true;
          System.out.println("\nFace: " + ++faceCount);
          // Each FaceDetectionAnnotation has only one segment.
          for (FaceSegment segment : faceAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3fs to %.3f\n", startTime, endTime);
          }
          // There are typically many frames for each face,
          try {
            // Here we process only the first frame.
            if (faceAnnotation.getFramesCount() > 0) {
              FaceDetectionFrame frame = faceAnnotation.getFrames(0); // get the first frame
              double timeOffset = frame.getTimeOffset().getSeconds()
                  + frame.getTimeOffset().getNanos() / 1e9;
              System.out.printf("First frame time offset: %.3fs\n", timeOffset);
              // print info on the first normalized bounding box
              NormalizedBoundingBox box = frame.getAttributes(0).getNormalizedBoundingBox();
              System.out.printf("\tLeft: %.3f\n", box.getLeft());
              System.out.printf("\tTop: %.3f\n", box.getTop());
              System.out.printf("\tBottom: %.3f\n", box.getBottom());
              System.out.printf("\tRight: %.3f\n", box.getRight());
            } else {
              System.out.println("No frames found in annotation");
            }
          } catch (IndexOutOfBoundsException ioe) {
            System.out.println("Could not retrieve frame: " + ioe.getMessage());
          }
        }
      }

      if (!faceFound) {
        System.out.println("No faces detected in " + gcsUri);
      }
    }
  }
  // [END video_face_bounding_boxes]

  // [START video_face_emotions]
  /**
   * Analyze faces' emotions over frames on the video at the provided Cloud Storage path.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void analyzeFaceEmotions(String gcsUri) throws Exception {
    // Instantiate a com.google.cloud.videointelligence.v1p1beta1.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Set the configuration to include bounding boxes
      FaceConfig config = FaceConfig.newBuilder()
          .setIncludeEmotions(true)
          .build();

      // Set the video context with the above configuration
      VideoContext context = VideoContext.newBuilder()
          .setFaceDetectionConfig(config)
          .build();

      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.FACE_DETECTION)
          .setVideoContext(context)
          .build();

      // asynchronously perform facial analysis on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> response =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      boolean faceFound = false;
      // Display the results
      for (VideoAnnotationResults results : response.get(600, TimeUnit.SECONDS)
          .getAnnotationResultsList()) {
        int faceCount = 0;
        // Display the results for each face
        for (FaceDetectionAnnotation faceAnnotation : results.getFaceDetectionAnnotationsList()) {
          faceFound = true;
          System.out.println("\nFace: " + ++faceCount);
          // Each FaceDetectionAnnotation has only one segment.
          for (FaceSegment segment : faceAnnotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location: %.3fs to %.3f\n", startTime, endTime);
          }

          try {
            // Print each frame's highest emotion
            for (FaceDetectionFrame frame : faceAnnotation.getFramesList()) {
              double timeOffset = frame.getTimeOffset().getSeconds()
                  + frame.getTimeOffset().getNanos() / 1e9;
              float highestScore = 0.0f;
              String emotion = "";
              // Get the highest scoring emotion for the current frame
              for (EmotionAttribute emotionAttribute : frame.getAttributes(0).getEmotionsList()) {
                if (emotionAttribute.getScore() > highestScore) {
                  highestScore = emotionAttribute.getScore();
                  emotion = emotionAttribute.getEmotion().name();
                }
              }
              System.out.printf("\t%4.2fs: %14s %4.3f\n", timeOffset, emotion, highestScore);
            }

          } catch (IndexOutOfBoundsException ioe) {
            System.out.println("Could not retrieve frame: " + ioe.getMessage());
          }
        }
      }

      if (!faceFound) {
        System.out.println("No faces detected in " + gcsUri);
      }
    }
  }
  // [END video_face_emotions]

  // [START video_speech_transcription]
  /**
   * Transcribe speech from a video stored on GCS.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static void speechTranscription(String gcsUri) throws Exception {
    // Instantiate a com.google.cloud.videointelligence.v1p1beta1.VideoIntelligenceServiceClient
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Set the language code
      SpeechTranscriptionConfig config = SpeechTranscriptionConfig.newBuilder()
          .setLanguageCode("en-US")
          .build();

      // Set the video context with the above configuration
      VideoContext context = VideoContext.newBuilder()
          .setSpeechTranscriptionConfig(config)
          .build();

      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.SPEECH_TRANSCRIPTION)
          .setVideoContext(context)
          .build();

      // asynchronously perform facial analysis on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> response =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // Display the results
      for (VideoAnnotationResults results : response.get(180, TimeUnit.SECONDS)
          .getAnnotationResultsList()) {
        for (SpeechTranscription speechTranscription : results.getSpeechTranscriptionsList()) {
          try {
            // Print the transcription
            if (speechTranscription.getAlternativesCount() > 0) {
              SpeechRecognitionAlternative alternative = speechTranscription.getAlternatives(0);

              System.out.printf("Transcript: %s\n", alternative.getTranscript());
              System.out.printf("Confidence: %.2f\n", alternative.getConfidence());

              System.out.println("Word level information:");
              for (WordInfo wordInfo : alternative.getWordsList()) {
                double startTime = wordInfo.getStartTime().getSeconds()
                    + wordInfo.getStartTime().getNanos() / 1e9;
                double endTime = wordInfo.getEndTime().getSeconds()
                    + wordInfo.getEndTime().getNanos() / 1e9;
                System.out.printf("\t%4.2fs - %4.2fs: %s\n",
                    startTime, endTime, wordInfo.getWord());
              }
            } else {
              System.out.println("No transcription found");
            }
          } catch (IndexOutOfBoundsException ioe) {
            System.out.println("Could not retrieve frame: " + ioe.getMessage());
          }
        }
      }
    }
  }
  // [END video_speech_transcription]
}
