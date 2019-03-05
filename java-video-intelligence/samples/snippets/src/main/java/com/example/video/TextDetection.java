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

package com.example.video;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.videointelligence.v1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1.Feature;
import com.google.cloud.videointelligence.v1.NormalizedVertex;
import com.google.cloud.videointelligence.v1.TextAnnotation;
import com.google.cloud.videointelligence.v1.TextFrame;
import com.google.cloud.videointelligence.v1.TextSegment;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1.VideoSegment;
import com.google.protobuf.ByteString;

import com.google.protobuf.Duration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TextDetection {

  // [START video_detect_text]
  /**
   * Detect text in a video.
   *
   * @param filePath the path to the video file to analyze.
   */
  public static VideoAnnotationResults detectText(String filePath) throws Exception {
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Read file
      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);

      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputContent(ByteString.copyFrom(data))
          .addFeatures(Feature.TEXT_DETECTION)
          .build();

      // asynchronously perform object tracking on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // The first result is retrieved because a single video was processed.
      AnnotateVideoResponse response = future.get(300, TimeUnit.SECONDS);
      VideoAnnotationResults results = response.getAnnotationResults(0);

      // Get only the first annotation for demo purposes.
      TextAnnotation annotation = results.getTextAnnotations(0);
      System.out.println("Text: " + annotation.getText());

      // Get the first text segment.
      TextSegment textSegment = annotation.getSegments(0);
      System.out.println("Confidence: " + textSegment.getConfidence());
      // For the text segment display it's time offset
      VideoSegment videoSegment = textSegment.getSegment();
      Duration startTimeOffset = videoSegment.getStartTimeOffset();
      Duration endTimeOffset = videoSegment.getEndTimeOffset();
      // Display the offset times in seconds, 1e9 is part of the formula to convert nanos to seconds
      System.out.println(String.format("Start time: %.2f",
          startTimeOffset.getSeconds() + startTimeOffset.getNanos() / 1e9));
      System.out.println(String.format("End time: %.2f",
          endTimeOffset.getSeconds() + endTimeOffset.getNanos() / 1e9));

      // Show the first result for the first frame in the segment.
      TextFrame textFrame = textSegment.getFrames(0);
      Duration timeOffset = textFrame.getTimeOffset();
      System.out.println(String.format("Time offset for the first frame: %.2f",
          timeOffset.getSeconds() + timeOffset.getNanos() / 1e9));

      // Display the rotated bounding box for where the text is on the frame.
      System.out.println("Rotated Bounding Box Vertices:");
      List<NormalizedVertex> vertices = textFrame.getRotatedBoundingBox().getVerticesList();
      for (NormalizedVertex normalizedVertex : vertices) {
        System.out.println(String.format(
            "\tVertex.x: %.2f, Vertex.y: %.2f",
            normalizedVertex.getX(),
            normalizedVertex.getY()));
      }
      return results;
    }
  }
  // [END video_detect_text]

  // [START video_detect_text_gcs]
  /**
   * Detect Text in a video.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static VideoAnnotationResults detectTextGcs(String gcsUri) throws Exception {
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.TEXT_DETECTION)
          .build();

      // asynchronously perform object tracking on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // The first result is retrieved because a single video was processed.
      AnnotateVideoResponse response = future.get(300, TimeUnit.SECONDS);
      VideoAnnotationResults results = response.getAnnotationResults(0);

      // Get only the first annotation for demo purposes.
      TextAnnotation annotation = results.getTextAnnotations(0);
      System.out.println("Text: " + annotation.getText());

      // Get the first text segment.
      TextSegment textSegment = annotation.getSegments(0);
      System.out.println("Confidence: " + textSegment.getConfidence());
      // For the text segment display it's time offset
      VideoSegment videoSegment = textSegment.getSegment();
      Duration startTimeOffset = videoSegment.getStartTimeOffset();
      Duration endTimeOffset = videoSegment.getEndTimeOffset();
      // Display the offset times in seconds, 1e9 is part of the formula to convert nanos to seconds
      System.out.println(String.format("Start time: %.2f",
          startTimeOffset.getSeconds() + startTimeOffset.getNanos() / 1e9));
      System.out.println(String.format("End time: %.2f",
          endTimeOffset.getSeconds() + endTimeOffset.getNanos() / 1e9));

      // Show the first result for the first frame in the segment.
      TextFrame textFrame = textSegment.getFrames(0);
      Duration timeOffset = textFrame.getTimeOffset();
      System.out.println(String.format("Time offset for the first frame: %.2f",
          timeOffset.getSeconds() + timeOffset.getNanos() / 1e9));

      // Display the rotated bounding box for where the text is on the frame.
      System.out.println("Rotated Bounding Box Vertices:");
      List<NormalizedVertex> vertices = textFrame.getRotatedBoundingBox().getVerticesList();
      for (NormalizedVertex normalizedVertex : vertices) {
        System.out.println(String.format(
            "\tVertex.x: %.2f, Vertex.y: %.2f",
            normalizedVertex.getX(),
            normalizedVertex.getY()));
      }
      return results;
    }
  }
  // [END video_detect_text_gcs]
}

