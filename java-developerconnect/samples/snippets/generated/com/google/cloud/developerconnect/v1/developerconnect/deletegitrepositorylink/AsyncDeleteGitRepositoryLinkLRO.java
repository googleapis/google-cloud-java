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

package com.google.cloud.developerconnect.v1.samples;

// [START developerconnect_v1_generated_DeveloperConnect_DeleteGitRepositoryLink_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeveloperConnectClient;
import com.google.cloud.developerconnect.v1.GitRepositoryLinkName;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.protobuf.Empty;

public class AsyncDeleteGitRepositoryLinkLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteGitRepositoryLinkLRO();
  }

  public static void asyncDeleteGitRepositoryLinkLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
      DeleteGitRepositoryLinkRequest request =
          DeleteGitRepositoryLinkRequest.newBuilder()
              .setName(
                  GitRepositoryLinkName.of(
                          "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                      .toString())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .setEtag("etag3123477")
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          developerConnectClient.deleteGitRepositoryLinkOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END developerconnect_v1_generated_DeveloperConnect_DeleteGitRepositoryLink_LRO_async]
