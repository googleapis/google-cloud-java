/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.videointelligence.v1p3beta1.samples;

// [START videointelligence_v1p3beta1_generated_VideoIntelligenceService_AnnotateVideo_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.videointelligence.v1p3beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p3beta1.Feature;
import com.google.cloud.videointelligence.v1p3beta1.VideoContext;
import com.google.cloud.videointelligence.v1p3beta1.VideoIntelligenceServiceClient;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import java.util.ArrayList;

public class AsyncAnnotateVideo {

  public static void main(String[] args) throws Exception {
    asyncAnnotateVideo();
  }

  public static void asyncAnnotateVideo() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VideoIntelligenceServiceClient videoIntelligenceServiceClient =
        VideoIntelligenceServiceClient.create()) {
      AnnotateVideoRequest request =
          AnnotateVideoRequest.newBuilder()
              .setInputUri("inputUri470706498")
              .setInputContent(ByteString.EMPTY)
              .addAllFeatures(new ArrayList<Feature>())
              .setVideoContext(VideoContext.newBuilder().build())
              .setOutputUri("outputUri-2119300949")
              .setLocationId("locationId1541836720")
              .build();
      ApiFuture<Operation> future =
          videoIntelligenceServiceClient.annotateVideoCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END videointelligence_v1p3beta1_generated_VideoIntelligenceService_AnnotateVideo_async]
