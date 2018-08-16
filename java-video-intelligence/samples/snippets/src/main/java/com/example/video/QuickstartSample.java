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

package com.example.video;

// [START video_quickstart]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.videointelligence.v1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1.Entity;
import com.google.cloud.videointelligence.v1.Feature;
import com.google.cloud.videointelligence.v1.LabelAnnotation;
import com.google.cloud.videointelligence.v1.LabelSegment;
import com.google.cloud.videointelligence.v1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1.VideoIntelligenceServiceClient;
import java.util.List;

public class QuickstartSample {

  /**
   * Demonstrates using the video intelligence client to detect labels in a video file.
   */
  public static void main(String[] args) throws Exception {
    // Instantiate a video intelligence client
    try (VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create()) {
      // The Google Cloud Storage path to the video to annotate.
      String gcsUri = "gs://demomaker/cat.mp4";

      // Create an operation that will contain the response when the operation completes.
      AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
          .setInputUri(gcsUri)
          .addFeatures(Feature.LABEL_DETECTION)
          .build();

      OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress> response =
          client.annotateVideoAsync(request);

      System.out.println("Waiting for operation to complete...");

      List<VideoAnnotationResults> results = response.get().getAnnotationResultsList();
      if (results.isEmpty()) {
        System.out.println("No labels detected in " + gcsUri);
        return;
      }
      for (VideoAnnotationResults result : results) {
        System.out.println("Labels:");
        // get video segment label annotations
        for (LabelAnnotation annotation : result.getSegmentLabelAnnotationsList()) {
          System.out
              .println("Video label description : " + annotation.getEntity().getDescription());
          // categories
          for (Entity categoryEntity : annotation.getCategoryEntitiesList()) {
            System.out.println("Label Category description : " + categoryEntity.getDescription());
          }
          // segments
          for (LabelSegment segment : annotation.getSegmentsList()) {
            double startTime = segment.getSegment().getStartTimeOffset().getSeconds()
                + segment.getSegment().getStartTimeOffset().getNanos() / 1e9;
            double endTime = segment.getSegment().getEndTimeOffset().getSeconds()
                + segment.getSegment().getEndTimeOffset().getNanos() / 1e9;
            System.out.printf("Segment location : %.3f:%.3f\n", startTime, endTime);
            System.out.println("Confidence : " + segment.getConfidence());
          }
        }
      }
    }
  }
}
// [END video_quickstart]
