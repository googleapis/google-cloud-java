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

// [START developerconnect_v1_generated_DeveloperConnect_FetchGitRepositoryLinkFileBlame_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.developerconnect.v1.DeveloperConnectClient;
import com.google.cloud.developerconnect.v1.FetchGitRepositoryLinkFileBlameRequest;
import com.google.cloud.developerconnect.v1.FetchGitRepositoryLinkFileBlameResponse;
import com.google.cloud.developerconnect.v1.GitRepositoryLinkName;

public class AsyncFetchGitRepositoryLinkFileBlame {

  public static void main(String[] args) throws Exception {
    asyncFetchGitRepositoryLinkFileBlame();
  }

  public static void asyncFetchGitRepositoryLinkFileBlame() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
      FetchGitRepositoryLinkFileBlameRequest request =
          FetchGitRepositoryLinkFileBlameRequest.newBuilder()
              .setName(
                  GitRepositoryLinkName.of(
                          "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
                      .toString())
              .setRef("ref112787")
              .setPath("path3433509")
              .setFirstLine(-161037277)
              .setLastLine(2013070333)
              .build();
      ApiFuture<FetchGitRepositoryLinkFileBlameResponse> future =
          developerConnectClient.fetchGitRepositoryLinkFileBlameCallable().futureCall(request);
      // Do something.
      FetchGitRepositoryLinkFileBlameResponse response = future.get();
    }
  }
}
// [END developerconnect_v1_generated_DeveloperConnect_FetchGitRepositoryLinkFileBlame_async]
