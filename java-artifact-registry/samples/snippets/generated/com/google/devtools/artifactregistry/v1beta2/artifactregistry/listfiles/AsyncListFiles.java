/*
 * Copyright 2023 Google LLC
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

package com.google.devtools.artifactregistry.v1beta2.samples;

// [START artifactregistry_v1beta2_generated_ArtifactRegistry_ListFiles_async]
import com.google.api.core.ApiFuture;
import com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient;
import com.google.devtools.artifactregistry.v1beta2.File;
import com.google.devtools.artifactregistry.v1beta2.ListFilesRequest;

public class AsyncListFiles {

  public static void main(String[] args) throws Exception {
    asyncListFiles();
  }

  public static void asyncListFiles() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
      ListFilesRequest request =
          ListFilesRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<File> future = artifactRegistryClient.listFilesPagedCallable().futureCall(request);
      // Do something.
      for (File element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END artifactregistry_v1beta2_generated_ArtifactRegistry_ListFiles_async]
