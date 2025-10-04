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

package com.google.cloud.securesourcemanager.v1.samples;

// [START securesourcemanager_v1_generated_SecureSourceManager_ResolvePullRequestComments_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.securesourcemanager.v1.OperationMetadata;
import com.google.cloud.securesourcemanager.v1.PullRequestName;
import com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest;
import com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsResponse;
import com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient;
import java.util.ArrayList;

public class AsyncResolvePullRequestCommentsLRO {

  public static void main(String[] args) throws Exception {
    asyncResolvePullRequestCommentsLRO();
  }

  public static void asyncResolvePullRequestCommentsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
      ResolvePullRequestCommentsRequest request =
          ResolvePullRequestCommentsRequest.newBuilder()
              .setParent(
                  PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                      .toString())
              .addAllNames(new ArrayList<String>())
              .setAutoFill(true)
              .build();
      OperationFuture<ResolvePullRequestCommentsResponse, OperationMetadata> future =
          secureSourceManagerClient
              .resolvePullRequestCommentsOperationCallable()
              .futureCall(request);
      // Do something.
      ResolvePullRequestCommentsResponse response = future.get();
    }
  }
}
// [END securesourcemanager_v1_generated_SecureSourceManager_ResolvePullRequestComments_LRO_async]
