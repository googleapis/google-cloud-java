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

// [START artifactregistry_v1beta2_generated_ArtifactRegistry_GetProjectSettings_sync]
import com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient;
import com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest;
import com.google.devtools.artifactregistry.v1beta2.ProjectSettings;
import com.google.devtools.artifactregistry.v1beta2.ProjectSettingsName;

public class SyncGetProjectSettings {

  public static void main(String[] args) throws Exception {
    syncGetProjectSettings();
  }

  public static void syncGetProjectSettings() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
      GetProjectSettingsRequest request =
          GetProjectSettingsRequest.newBuilder()
              .setName(ProjectSettingsName.of("[PROJECT]").toString())
              .build();
      ProjectSettings response = artifactRegistryClient.getProjectSettings(request);
    }
  }
}
// [END artifactregistry_v1beta2_generated_ArtifactRegistry_GetProjectSettings_sync]
