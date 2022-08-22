/*
 * Copyright 2020 Google LLC
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

// [START video_detect_logo]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.videointelligence.v1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1.DetectedAttribute;
import com.google.cloud.videointelligence.v1.Entity;
import com.google.cloud.videointelligence.v1.Feature;
import com.google.cloud.videointelligence.v1.LogoRecognitionAnnotation;
import com.google.cloud.videointelligence.v1.NormalizedBoundingBox;
import com.google.cloud.videointelligence.v1.TimestampedObject;
import com.google.cloud.videointelligence.v1.Track;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1.VideoSegment;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LogoDetection {

  public static void detectLogo() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String localFilePath = "path/to/your/video.mp4";
    detectLogo(localFilePath);
  }

  public static void detectLogo(String filePath)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // Read file
      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      // Create the request
      AnnotateVideoRequest request =
          AnnotateVideoRequest.newBuilder()
              .setInputContent(ByteString.copyFrom(data))
              .addFeatures(Feature.LOGO_RECOGNITION)
              .build();

      // asynchronously perform object tracking on videos
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      // The first result is retrieved because a single video was processed.
      AnnotateVideoResponse response = future.get(300, TimeUnit.SECONDS);
      VideoAnnotationResults annotationResult = response.getAnnotationResults(0);

      // Annotations for list of logos detected, tracked and recognized in video.
      for (LogoRecognitionAnnotation logoRecognitionAnnotation :
          annotationResult.getLogoRecognitionAnnotationsList()) {
        Entity entity = logoRecognitionAnnotation.getEntity();
        // Opaque entity ID. Some IDs may be available in
        // [Google Knowledge Graph Search API](https://developers.google.com/knowledge-graph/).
        System.out.printf("Entity Id : %s\n", entity.getEntityId());
        System.out.printf("Description : %s\n", entity.getDescription());
        // All logo tracks where the recognized logo appears. Each track corresponds to one logo
        // instance appearing in consecutive frames.
        for (Track track : logoRecognitionAnnotation.getTracksList()) {

          // Video segment of a track.
          Duration startTimeOffset = track.getSegment().getStartTimeOffset();
          System.out.printf(
              "\n\tStart Time Offset: %s.%s\n",
              startTimeOffset.getSeconds(), startTimeOffset.getNanos());
          Duration endTimeOffset = track.getSegment().getEndTimeOffset();
          System.out.printf(
              "\tEnd Time Offset: %s.%s\n", endTimeOffset.getSeconds(), endTimeOffset.getNanos());
          System.out.printf("\tConfidence: %s\n", track.getConfidence());

          // The object with timestamp and attributes per frame in the track.
          for (TimestampedObject timestampedObject : track.getTimestampedObjectsList()) {

            // Normalized Bounding box in a frame, where the object is located.
            NormalizedBoundingBox normalizedBoundingBox =
                timestampedObject.getNormalizedBoundingBox();
            System.out.printf("\n\t\tLeft: %s\n", normalizedBoundingBox.getLeft());
            System.out.printf("\t\tTop: %s\n", normalizedBoundingBox.getTop());
            System.out.printf("\t\tRight: %s\n", normalizedBoundingBox.getRight());
            System.out.printf("\t\tBottom: %s\n", normalizedBoundingBox.getBottom());

            // Optional. The attributes of the object in the bounding box.
            for (DetectedAttribute attribute : timestampedObject.getAttributesList()) {
              System.out.printf("\n\t\t\tName: %s\n", attribute.getName());
              System.out.printf("\t\t\tConfidence: %s\n", attribute.getConfidence());
              System.out.printf("\t\t\tValue: %s\n", attribute.getValue());
            }
          }

          // Optional. Attributes in the track level.
          for (DetectedAttribute trackAttribute : track.getAttributesList()) {
            System.out.printf("\n\t\tName : %s\n", trackAttribute.getName());
            System.out.printf("\t\tConfidence : %s\n", trackAttribute.getConfidence());
            System.out.printf("\t\tValue : %s\n", trackAttribute.getValue());
          }
        }

        // All video segments where the recognized logo appears. There might be multiple instances
        // of the same logo class appearing in one VideoSegment.
        for (VideoSegment segment : logoRecognitionAnnotation.getSegmentsList()) {
          System.out.printf(
              "\n\tStart Time Offset : %s.%s\n",
              segment.getStartTimeOffset().getSeconds(), segment.getStartTimeOffset().getNanos());
          System.out.printf(
              "\tEnd Time Offset : %s.%s\n",
              segment.getEndTimeOffset().getSeconds(), segment.getEndTimeOffset().getNanos());
        }
      }
    }
  }
}
// [END video_detect_logo]
