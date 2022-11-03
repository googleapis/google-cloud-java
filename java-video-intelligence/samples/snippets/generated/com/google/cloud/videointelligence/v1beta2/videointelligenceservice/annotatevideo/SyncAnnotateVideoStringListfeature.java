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

package com.google.cloud.videointelligence.v1beta2.samples;

// [START videointelligence_v1beta2_generated_VideoIntelligenceService_AnnotateVideo_StringListfeature_sync]
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta2.Feature;
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncAnnotateVideoStringListfeature {

  public static void main(String[] args) throws Exception {
    syncAnnotateVideoStringListfeature();
  }

  public static void syncAnnotateVideoStringListfeature() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VideoIntelligenceServiceClient videoIntelligenceServiceClient =
        VideoIntelligenceServiceClient.create()) {
      String inputUri = "inputUri470706498";
      List<Feature> features = new ArrayList<>();
      AnnotateVideoResponse response =
          videoIntelligenceServiceClient.annotateVideoAsync(inputUri, features).get();
    }
  }
}
// [END videointelligence_v1beta2_generated_VideoIntelligenceService_AnnotateVideo_StringListfeature_sync]
