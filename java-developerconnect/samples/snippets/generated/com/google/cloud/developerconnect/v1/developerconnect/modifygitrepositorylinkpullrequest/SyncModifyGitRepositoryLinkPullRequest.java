/*
 * Copyright 2026 Google LLC
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

// [START developerconnect_v1_generated_DeveloperConnect_ModifyGitRepositoryLinkPullRequest_sync]
import com.google.cloud.developerconnect.v1.DeveloperConnectClient;
import com.google.cloud.developerconnect.v1.GitRepositoryLinkName;
import com.google.cloud.developerconnect.v1.ModifyGitRepositoryLinkPullRequestRequest;
import com.google.cloud.developerconnect.v1.PullRequest;

public class SyncModifyGitRepositoryLinkPullRequest {

  public static void main(String[] args) throws Exception {
    syncModifyGitRepositoryLinkPullRequest();
  }

  public static void syncModifyGitRepositoryLinkPullRequest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
      ModifyGitRepositoryLinkPullRequestRequest request =
          ModifyGitRepositoryLinkPullRequestRequest.newBuilder()
              .setName(
                  GitRepositoryLinkName.of(
                          "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                      .toString())
              .setPullRequestId("pullRequestId1573471045")
              .setTitle("title110371416")
              .setBody("body3029410")
              .setBaseRef("baseRef-332628990")
              .build();
      PullRequest response = developerConnectClient.modifyGitRepositoryLinkPullRequest(request);
    }
  }
}
// [END developerconnect_v1_generated_DeveloperConnect_ModifyGitRepositoryLinkPullRequest_sync]
