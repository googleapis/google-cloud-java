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

package com.google.devtools.artifactregistry.v1.samples;

// [START artifactregistry_v1_generated_ArtifactRegistry_CreateRepository_async]
import com.google.api.core.ApiFuture;
import com.google.devtools.artifactregistry.v1.ArtifactRegistryClient;
import com.google.devtools.artifactregistry.v1.CreateRepositoryRequest;
import com.google.devtools.artifactregistry.v1.LocationName;
import com.google.devtools.artifactregistry.v1.Repository;
import com.google.longrunning.Operation;

public class AsyncCreateRepository {

  public static void main(String[] args) throws Exception {
    asyncCreateRepository();
  }

  public static void asyncCreateRepository() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
      CreateRepositoryRequest request =
          CreateRepositoryRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setRepositoryId("repositoryId2113747461")
              .setRepository(Repository.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          artifactRegistryClient.createRepositoryCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END artifactregistry_v1_generated_ArtifactRegistry_CreateRepository_async]
