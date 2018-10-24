/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1p2beta1.Entity;
import com.google.cloud.videointelligence.v1p2beta1.Feature;
import com.google.cloud.videointelligence.v1p2beta1.NormalizedBoundingBox;
import com.google.cloud.videointelligence.v1p2beta1.ObjectTrackingAnnotation;
import com.google.cloud.videointelligence.v1p2beta1.ObjectTrackingFrame;
import com.google.cloud.videointelligence.v1p2beta1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1p2beta1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1p2beta1.VideoSegment;
import com.google.protobuf.ByteString;

import com.google.protobuf.Duration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TrackObjects {

  // [START video_object_tracking_beta]
  /**
   * Track objects in a video.
   *
   * @param filePath the path to the video file to analyze.
   */
  public static VideoAnnotationResults trackObjects(String filePath) throws Exception {
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Read file
      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);

      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputContent(ByteString.copyFrom(data))
          .addFeatures(Feature.OBJECT_TRACKING)
          .setLocationId("us-east1")
          .build();

      // asynchronously perform object tracking on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // The first result is retrieved because a single video was processed.
      AnnotateVideoResponse response = future.get(300, TimeUnit.SECONDS);
      VideoAnnotationResults results = response.getAnnotationResults(0);

      // Get only the first annotation for demo purposes.
      ObjectTrackingAnnotation annotation = results.getObjectAnnotations(0);
      System.out.println("Confidence: " + annotation.getConfidence());

      if (annotation.hasEntity()) {
        Entity entity = annotation.getEntity();
        System.out.println("Entity description: " + entity.getDescription());
        System.out.println("Entity id:: " + entity.getEntityId());
      }

      if (annotation.hasSegment()) {
        VideoSegment videoSegment = annotation.getSegment();
        Duration startTimeOffset = videoSegment.getStartTimeOffset();
        Duration endTimeOffset = videoSegment.getEndTimeOffset();
        // Display the segment time in seconds, 1e9 converts nanos to seconds
        System.out.println(String.format(
            "Segment: %.2fs to %.2fs",
            startTimeOffset.getSeconds() + startTimeOffset.getNanos() / 1e9,
            endTimeOffset.getSeconds() + endTimeOffset.getNanos() / 1e9));
      }

      // Here we print only the bounding box of the first frame in this segment.
      ObjectTrackingFrame frame = annotation.getFrames(0);
      // Display the offset time in seconds, 1e9 converts nanos to seconds
      Duration timeOffset = frame.getTimeOffset();
      System.out.println(String.format(
          "Time offset of the first frame: %.2fs",
          timeOffset.getSeconds() + timeOffset.getNanos() / 1e9));

      // Display the bounding box of the detected object
      NormalizedBoundingBox normalizedBoundingBox = frame.getNormalizedBoundingBox();
      System.out.println("Bounding box position:");
      System.out.println("\tleft: " + normalizedBoundingBox.getLeft());
      System.out.println("\ttop: " + normalizedBoundingBox.getTop());
      System.out.println("\tright: " + normalizedBoundingBox.getRight());
      System.out.println("\tbottom: " + normalizedBoundingBox.getBottom());
      return results;
    }
  }
  // [END video_object_tracking_beta]

  // [START video_object_tracking_gcs_beta]
  /**
   * Track objects in a video.
   *
   * @param gcsUri the path to the video file to analyze.
   */
  public static VideoAnnotationResults trackObjectsGcs(String gcsUri) throws Exception {
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Create the request
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.OBJECT_TRACKING)
          .setLocationId("us-east1")
          .build();

      // asynchronously perform object tracking on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // The first result is retrieved because a single video was processed.
      AnnotateVideoResponse response = future.get(300, TimeUnit.SECONDS);
      VideoAnnotationResults results = response.getAnnotationResults(0);

      // Get only the first annotation for demo purposes.
      ObjectTrackingAnnotation annotation = results.getObjectAnnotations(0);
      System.out.println("Confidence: " + annotation.getConfidence());

      if (annotation.hasEntity()) {
        Entity entity = annotation.getEntity();
        System.out.println("Entity description: " + entity.getDescription());
        System.out.println("Entity id:: " + entity.getEntityId());
      }

      if (annotation.hasSegment()) {
        VideoSegment videoSegment = annotation.getSegment();
        Duration startTimeOffset = videoSegment.getStartTimeOffset();
        Duration endTimeOffset = videoSegment.getEndTimeOffset();
        // Display the segment time in seconds, 1e9 converts nanos to seconds
        System.out.println(String.format(
            "Segment: %.2fs to %.2fs",
            startTimeOffset.getSeconds() + startTimeOffset.getNanos() / 1e9,
            endTimeOffset.getSeconds() + endTimeOffset.getNanos() / 1e9));
      }

      // Here we print only the bounding box of the first frame in this segment.
      ObjectTrackingFrame frame = annotation.getFrames(0);
      // Display the offset time in seconds, 1e9 converts nanos to seconds
      Duration timeOffset = frame.getTimeOffset();
      System.out.println(String.format(
          "Time offset of the first frame: %.2fs",
          timeOffset.getSeconds() + timeOffset.getNanos() / 1e9));

      // Display the bounding box of the detected object
      NormalizedBoundingBox normalizedBoundingBox = frame.getNormalizedBoundingBox();
      System.out.println("Bounding box position:");
      System.out.println("\tleft: " + normalizedBoundingBox.getLeft());
      System.out.println("\ttop: " + normalizedBoundingBox.getTop());
      System.out.println("\tright: " + normalizedBoundingBox.getRight());
      System.out.println("\tbottom: " + normalizedBoundingBox.getBottom());
      return results;
    }
  }
  // [END video_object_tracking_gcs_beta]
}

