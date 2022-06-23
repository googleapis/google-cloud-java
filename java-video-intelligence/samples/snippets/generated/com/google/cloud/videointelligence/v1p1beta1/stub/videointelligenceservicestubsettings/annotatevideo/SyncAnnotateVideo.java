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

package com.google.cloud.videointelligence.v1p1beta1.stub.samples;

// [START
// videointelligence_v1p1beta1_generated_videointelligenceservicestubsettings_annotatevideo_sync]
import com.google.cloud.videointelligence.v1p1beta1.stub.VideoIntelligenceServiceStubSettings;
import java.time.Duration;

public class SyncAnnotateVideo {

  public static void main(String[] args) throws Exception {
    syncAnnotateVideo();
  }

  public static void syncAnnotateVideo() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    VideoIntelligenceServiceStubSettings.Builder videoIntelligenceServiceSettingsBuilder =
        VideoIntelligenceServiceStubSettings.newBuilder();
    videoIntelligenceServiceSettingsBuilder
        .annotateVideoSettings()
        .setRetrySettings(
            videoIntelligenceServiceSettingsBuilder
                .annotateVideoSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    VideoIntelligenceServiceStubSettings videoIntelligenceServiceSettings =
        videoIntelligenceServiceSettingsBuilder.build();
  }
}
// [END
// videointelligence_v1p1beta1_generated_videointelligenceservicestubsettings_annotatevideo_sync]
