/*
 * Copyright 2020 Google LLC
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

package video;

// [START video_detect_person]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.videointelligence.v1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1.DetectedAttribute;
import com.google.cloud.videointelligence.v1.DetectedLandmark;
import com.google.cloud.videointelligence.v1.Feature;
import com.google.cloud.videointelligence.v1.PersonDetectionAnnotation;
import com.google.cloud.videointelligence.v1.PersonDetectionConfig;
import com.google.cloud.videointelligence.v1.TimestampedObject;
import com.google.cloud.videointelligence.v1.Track;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1.VideoContext;
import com.google.cloud.videointelligence.v1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1.VideoSegment;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DetectPerson {

  public static void detectPerson() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String localFilePath = "resources/googlework_short.mp4";
    detectPerson(localFilePath);
  }

  // Detects people in a video stored in a local file using the Cloud Video Intelligence API.
  public static void detectPerson(String localFilePath) throws Exception {
    try (VideoIntelligenceServiceClient videoIntelligenceServiceClient =
        VideoIntelligenceServiceClient.create()) {
      // Reads a local video file and converts it to base64.
      Path path = Paths.get(localFilePath);
      byte[] data = Files.readAllBytes(path);
      ByteString inputContent = ByteString.copyFrom(data);

      PersonDetectionConfig personDetectionConfig =
          PersonDetectionConfig.newBuilder()
              // Must set includeBoundingBoxes to true to get poses and attributes.
              .setIncludeBoundingBoxes(true)
              .setIncludePoseLandmarks(true)
              .setIncludeAttributes(true)
              .build();
      VideoContext videoContext =
          VideoContext.newBuilder().setPersonDetectionConfig(personDetectionConfig).build();

      AnnotateVideoRequest request =
          AnnotateVideoRequest.newBuilder()
              .setInputContent(inputContent)
              .addFeatures(Feature.PERSON_DETECTION)
              .setVideoContext(videoContext)
              .build();

      // Detects people in a video
      // We get the first result because only one video is processed.
      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> future =
          videoIntelligenceServiceClient.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");
      AnnotateVideoResponse response = future.get();

      // Gets annotations for video
      VideoAnnotationResults annotationResult = response.getAnnotationResultsList().get(0);

      // Annotations for list of people detected, tracked and recognized in video.
      for (PersonDetectionAnnotation personDetectionAnnotation :
          annotationResult.getPersonDetectionAnnotationsList()) {
        System.out.print("Person detected:\n");
        for (Track track : personDetectionAnnotation.getTracksList()) {
          VideoSegment segment = track.getSegment();
          System.out.printf(
              "\tStart: %d.%.0fs\n",
              segment.getStartTimeOffset().getSeconds(),
              segment.getStartTimeOffset().getNanos() / 1e6);
          System.out.printf(
              "\tEnd: %d.%.0fs\n",
              segment.getEndTimeOffset().getSeconds(), segment.getEndTimeOffset().getNanos() / 1e6);

          // Each segment includes timestamped objects that include characteristic--e.g. clothes,
          // posture of the person detected.
          TimestampedObject firstTimestampedObject = track.getTimestampedObjects(0);

          // Attributes include unique pieces of clothing, poses (i.e., body landmarks)
          // of the person detected.
          for (DetectedAttribute attribute : firstTimestampedObject.getAttributesList()) {
            System.out.printf(
                "\tAttribute: %s; Value: %s\n", attribute.getName(), attribute.getValue());
          }

          // Landmarks in person detection include body parts.
          for (DetectedLandmark attribute : firstTimestampedObject.getLandmarksList()) {
            System.out.printf(
                "\tLandmark: %s; Vertex: %f, %f\n",
                attribute.getName(), attribute.getPoint().getX(), attribute.getPoint().getY());
          }
        }
      }
    }
  }
}
// [END video_detect_person]
