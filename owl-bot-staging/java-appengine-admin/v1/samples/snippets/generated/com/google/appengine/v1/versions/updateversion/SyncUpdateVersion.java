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

package com.google.appengine.v1.samples;

// [START appengine_v1_generated_Versions_UpdateVersion_sync]
import com.google.appengine.v1.UpdateVersionRequest;
import com.google.appengine.v1.Version;
import com.google.appengine.v1.VersionsClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateVersion {

  public static void main(String[] args) throws Exception {
    syncUpdateVersion();
  }

  public static void syncUpdateVersion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VersionsClient versionsClient = VersionsClient.create()) {
      UpdateVersionRequest request =
          UpdateVersionRequest.newBuilder()
              .setName("name3373707")
              .setVersion(Version.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      Version response = versionsClient.updateVersionAsync(request).get();
    }
  }
}
// [END appengine_v1_generated_Versions_UpdateVersion_sync]
