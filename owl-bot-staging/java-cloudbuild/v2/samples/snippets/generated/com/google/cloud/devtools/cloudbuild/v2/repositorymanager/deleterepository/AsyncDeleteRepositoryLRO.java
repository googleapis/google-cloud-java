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

package com.google.cloud.devtools.cloudbuild.v2.samples;

// [START cloudbuild_v2_generated_RepositoryManager_DeleteRepository_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient;
import com.google.cloudbuild.v2.DeleteRepositoryRequest;
import com.google.cloudbuild.v2.OperationMetadata;
import com.google.cloudbuild.v2.RepositoryName;
import com.google.protobuf.Empty;

public class AsyncDeleteRepositoryLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteRepositoryLRO();
  }

  public static void asyncDeleteRepositoryLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RepositoryManagerClient repositoryManagerClient = RepositoryManagerClient.create()) {
      DeleteRepositoryRequest request =
          DeleteRepositoryRequest.newBuilder()
              .setName(
                  RepositoryName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]", "[REPOSITORY]")
                      .toString())
              .setEtag("etag3123477")
              .setValidateOnly(true)
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          repositoryManagerClient.deleteRepositoryOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END cloudbuild_v2_generated_RepositoryManager_DeleteRepository_LRO_async]
