/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_AppPlatform_CreateProcessor_StringProcessorString_sync]
import com.google.cloud.visionai.v1.AppPlatformClient;
import com.google.cloud.visionai.v1.LocationName;
import com.google.cloud.visionai.v1.Processor;

public class SyncCreateProcessorStringProcessorString {

  public static void main(String[] args) throws Exception {
    syncCreateProcessorStringProcessorString();
  }

  public static void syncCreateProcessorStringProcessorString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      Processor processor = Processor.newBuilder().build();
      String processorId = "processorId203323725";
      Processor response =
          appPlatformClient.createProcessorAsync(parent, processor, processorId).get();
    }
  }
}
// [END visionai_v1_generated_AppPlatform_CreateProcessor_StringProcessorString_sync]
