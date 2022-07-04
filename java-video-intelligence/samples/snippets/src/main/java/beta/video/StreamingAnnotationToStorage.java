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

// [START video_streaming_annotation_to_storage_beta]

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse;
import com.google.cloud.videointelligence.v1p3beta1.StreamingFeature;
import com.google.cloud.videointelligence.v1p3beta1.StreamingLabelDetectionConfig;
import com.google.cloud.videointelligence.v1p3beta1.StreamingStorageConfig;
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

public class StreamingAnnotationToStorage {

  // Perform streaming video detection for explicit content
  static void streamingAnnotationToStorage(String filePath, String gcsUri)
      throws IOException, TimeoutException, StatusRuntimeException {
    // String filePath = "path_to_your_video_file";
    // String gcsUri = "gs://BUCKET_ID";

    try (StreamingVideoIntelligenceServiceClient client =
        StreamingVideoIntelligenceServiceClient.create()) {

      Path path = Paths.get(filePath);
      byte[] data = Files.readAllBytes(path);
      // Set the chunk size to 5MB (recommended less than 10MB).
      int chunkSize = 5 * 1024 * 1024;
      int numChunks = (int) Math.ceil((double) data.length / chunkSize);

      StreamingStorageConfig streamingStorageConfig =
          StreamingStorageConfig.newBuilder()
              .setEnableStorageAnnotationResult(true)
              .setAnnotationResultStorageDirectory(gcsUri)
              .build();

      StreamingLabelDetectionConfig labelConfig =
          StreamingLabelDetectionConfig.newBuilder().setStationaryCamera(false).build();

      StreamingVideoConfig streamingVideoConfig =
          StreamingVideoConfig.newBuilder()
              .setFeature(StreamingFeature.STREAMING_LABEL_DETECTION)
              .setLabelDetectionConfig(labelConfig)
              .setStorageConfig(streamingStorageConfig)
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
        System.out.format("Storage Uri: %s\n", response.getAnnotationResultsUri());
      }
    }
  }
}
// [END video_streaming_annotation_to_storage_beta]
