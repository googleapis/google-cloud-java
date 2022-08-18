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

// [START videointelligence_v1beta2_generated_videointelligenceserviceclient_create_setcredentialsprovider1_sync]
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient;
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceSettings;

public class SyncCreateSetCredentialsProvider1 {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider1();
  }

  public static void syncCreateSetCredentialsProvider1() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    VideoIntelligenceServiceSettings videoIntelligenceServiceSettings =
        VideoIntelligenceServiceSettings.newBuilder()
            .setTransportChannelProvider(
                VideoIntelligenceServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
            .build();
    VideoIntelligenceServiceClient videoIntelligenceServiceClient =
        VideoIntelligenceServiceClient.create(videoIntelligenceServiceSettings);
  }
}
// [END videointelligence_v1beta2_generated_videointelligenceserviceclient_create_setcredentialsprovider1_sync]
