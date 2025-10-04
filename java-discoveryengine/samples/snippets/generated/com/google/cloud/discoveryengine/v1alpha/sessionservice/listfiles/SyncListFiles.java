/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_SessionService_ListFiles_sync]
import com.google.cloud.discoveryengine.v1alpha.FileMetadata;
import com.google.cloud.discoveryengine.v1alpha.ListFilesRequest;
import com.google.cloud.discoveryengine.v1alpha.SessionName;
import com.google.cloud.discoveryengine.v1alpha.SessionServiceClient;

public class SyncListFiles {

  public static void main(String[] args) throws Exception {
    syncListFiles();
  }

  public static void syncListFiles() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
      ListFilesRequest request =
          ListFilesRequest.newBuilder()
              .setParent(
                  SessionName.ofProjectLocationCollectionEngineSessionName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (FileMetadata element : sessionServiceClient.listFiles(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END discoveryengine_v1alpha_generated_SessionService_ListFiles_sync]
