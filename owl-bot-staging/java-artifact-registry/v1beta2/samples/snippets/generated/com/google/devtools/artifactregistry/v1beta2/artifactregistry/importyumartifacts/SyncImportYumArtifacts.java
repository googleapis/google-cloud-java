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

package com.google.devtools.artifactregistry.v1beta2.samples;

// [START artifactregistry_v1beta2_generated_ArtifactRegistry_ImportYumArtifacts_sync]
import com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient;
import com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest;
import com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsResponse;

public class SyncImportYumArtifacts {

  public static void main(String[] args) throws Exception {
    syncImportYumArtifacts();
  }

  public static void syncImportYumArtifacts() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
      ImportYumArtifactsRequest request =
          ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();
      ImportYumArtifactsResponse response =
          artifactRegistryClient.importYumArtifactsAsync(request).get();
    }
  }
}
// [END artifactregistry_v1beta2_generated_ArtifactRegistry_ImportYumArtifacts_sync]
