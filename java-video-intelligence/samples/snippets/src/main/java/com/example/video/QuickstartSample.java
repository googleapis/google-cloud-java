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

// [START videointelligence_quickstart]
import com.google.api.gax.grpc.OperationFuture;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1beta1.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta1.Feature;
import com.google.cloud.videointelligence.v1beta1.LabelAnnotation;
import com.google.cloud.videointelligence.v1beta1.LabelLocation;
import com.google.cloud.videointelligence.v1beta1.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1beta1.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1beta1.VideoIntelligenceServiceSettings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class QuickstartSample {
  public static void main(String[] args) throws
        ExecutionException, IOException, InterruptedException {
    // Instantiate the client
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.defaultBuilder().build();
    VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

    // The Google Cloud Storage path to the video to annotate.
    String gcsUri = "gs://demomaker/cat.mp4";

    // Create an operation that will contain the response when the operation completes.
    AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
            .setInputUri(gcsUri)
            .addFeatures(Feature.LABEL_DETECTION)
            .build();

    OperationFuture<AnnotateVideoResponse> operation =
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
}
// [END videointelligence_quickstart]
