/*
 * Copyright 2021 Google LLC
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

package beta.video;

// [START video_streaming_automl_object_tracking_beta]

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.videointelligence.v1p3beta1.ObjectTrackingAnnotation;
import com.google.cloud.videointelligence.v1p3beta1.ObjectTrackingFrame;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAutomlObjectTrackingConfig;
import com.google.cloud.videointelligence.v1p3beta1.StreamingFeature;
import com.google.cloud.videointelligence.v1p3beta1.StreamingVideoAnnotationResults;
import com.google.cloud.videointelligence.v1p3beta1.StreamingVideoConfig;
import com.google.cloud.videointelligence.v1p3beta1.StreamingVideoIntelligenceServiceClient;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class StreamingAutoMlObjectTracking {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "YOUR_VIDEO_FILE";
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_AUTOML_OBJECT_TRACKING_MODEL_ID";
    streamingAutoMlObjectTracking(filePath, projectId, modelId);
  }

  // Perform streaming video object tracking with an AutoML Model
  static void streamingAutoMlObjectTracking(String filePath, String projectId, String modelId)
      throws StatusRuntimeException, IOException {

    try (StreamingVideoIntelligenceServiceClient client =
        StreamingVideoIntelligenceServiceClient.create()) {

      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      // Set the chunk size to 5MB (recommended less than 10MB).
      int chunkSize = 5 * 1024 * 1024;
      int numChunks = (int) Math.ceil((double) data.length / chunkSize);

      String modelPath =
          String.format("projects/%s/locations/us-central1/models/%s", projectId, modelId);

      StreamingAutomlObjectTrackingConfig streamingAutomlObjectTrackingConfig =
          StreamingAutomlObjectTrackingConfig.newBuilder().setModelName(modelPath).build();

      StreamingVideoConfig streamingVideoConfig =
          StreamingVideoConfig.newBuilder()
              .setFeature(StreamingFeature.STREAMING_AUTOML_OBJECT_TRACKING)
              .setAutomlObjectTrackingConfig(streamingAutomlObjectTrackingConfig)
              .build();

      BidiStream<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse> call =
          client.streamingAnnotateVideoCallable().call();

      // The first request must **only** contain the audio configuration:
      call.send(
          StreamingAnnotateVideoRequest.newBuilder().setVideoConfig(streamingVideoConfig).build());

      // Subsequent requests must **only** contain the audio data.
      // Send the requests in chunks
      for (int i = 0; i < numChunks; i++) {
        call.send(
            StreamingAnnotateVideoRequest.newBuilder()
                .setInputContent(
                    ByteString.copyFrom(
                        Arrays.copyOfRange(data, i * chunkSize, i * chunkSize + chunkSize)))
                .build());
      }

      // Tell the service you are done sending data
      call.closeSend();

      for (StreamingAnnotateVideoResponse response : call) {
        StreamingVideoAnnotationResults annotationResults = response.getAnnotationResults();

        for (ObjectTrackingAnnotation objectAnnotations :
            annotationResults.getObjectAnnotationsList()) {

          String entity = objectAnnotations.getEntity().getDescription();
          float confidence = objectAnnotations.getConfidence();
          long trackId = objectAnnotations.getTrackId();
          System.out.format("%s: %f (ID: %d)\n", entity, confidence, trackId);

          // In streaming, there is always one frame.
          ObjectTrackingFrame frame = objectAnnotations.getFrames(0);
          double offset =
              frame.getTimeOffset().getSeconds() + frame.getTimeOffset().getNanos() / 1e9;
          System.out.format("Offset: %f\n", offset);

          System.out.println("Bounding Box:");
          System.out.format("\tLeft: %f\n", frame.getNormalizedBoundingBox().getLeft());
          System.out.format("\tTop: %f\n", frame.getNormalizedBoundingBox().getTop());
          System.out.format("\tRight: %f\n", frame.getNormalizedBoundingBox().getRight());
          System.out.format("\tBottom: %f\n", frame.getNormalizedBoundingBox().getBottom());
        }
      }
      System.out.println("Video streamed successfully.");
    }
  }
}
// [END video_streaming_automl_object_tracking_beta]
