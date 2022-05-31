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

package beta.video;

// [START video_streaming_label_detection_beta]

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.videointelligence.v1p3beta1.LabelAnnotation;
import com.google.cloud.videointelligence.v1p3beta1.LabelFrame;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse;
import com.google.cloud.videointelligence.v1p3beta1.StreamingFeature;
import com.google.cloud.videointelligence.v1p3beta1.StreamingLabelDetectionConfig;
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
import java.util.concurrent.TimeoutException;

class StreamingLabelDetection {

  // Perform streaming video label detection
  static void streamingLabelDetection(String filePath)
      throws IOException, TimeoutException, StatusRuntimeException {
    // String filePath = "path_to_your_video_file";

    try (StreamingVideoIntelligenceServiceClient client =
        StreamingVideoIntelligenceServiceClient.create()) {

      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      // Set the chunk size to 5MB (recommended less than 10MB).
      int chunkSize = 5 * 1024 * 1024;
      int numChunks = (int) Math.ceil((double) data.length / chunkSize);

      StreamingLabelDetectionConfig labelConfig =
          StreamingLabelDetectionConfig.newBuilder().setStationaryCamera(false).build();

      StreamingVideoConfig streamingVideoConfig =
          StreamingVideoConfig.newBuilder()
              .setFeature(StreamingFeature.STREAMING_LABEL_DETECTION)
              .setLabelDetectionConfig(labelConfig)
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

        for (LabelAnnotation annotation : annotationResults.getLabelAnnotationsList()) {
          String entity = annotation.getEntity().getDescription();

          // There is only one frame per annotation
          LabelFrame labelFrame = annotation.getFrames(0);
          double offset =
              labelFrame.getTimeOffset().getSeconds() + labelFrame.getTimeOffset().getNanos() / 1e9;
          float confidence = labelFrame.getConfidence();

          System.out.format("%fs: %s (%f)\n", offset, entity, confidence);
        }
      }
    }
  }
}
// [END video_streaming_label_detection_beta]
