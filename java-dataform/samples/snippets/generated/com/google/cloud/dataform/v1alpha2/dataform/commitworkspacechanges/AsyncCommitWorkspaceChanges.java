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

package com.google.cloud.dataform.v1alpha2.samples;

// [START dataform_v1alpha2_generated_Dataform_CommitWorkspaceChanges_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dataform.v1alpha2.CommitAuthor;
import com.google.cloud.dataform.v1alpha2.CommitWorkspaceChangesRequest;
import com.google.cloud.dataform.v1alpha2.DataformClient;
import com.google.cloud.dataform.v1alpha2.WorkspaceName;
import com.google.protobuf.Empty;
import java.util.ArrayList;

public class AsyncCommitWorkspaceChanges {

  public static void main(String[] args) throws Exception {
    asyncCommitWorkspaceChanges();
  }

  public static void asyncCommitWorkspaceChanges() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataformClient dataformClient = DataformClient.create()) {
      CommitWorkspaceChangesRequest request =
          CommitWorkspaceChangesRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setAuthor(CommitAuthor.newBuilder().build())
              .setCommitMessage("commitMessage2039804624")
              .addAllPaths(new ArrayList<String>())
              .build();
      ApiFuture<Empty> future = dataformClient.commitWorkspaceChangesCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END dataform_v1alpha2_generated_Dataform_CommitWorkspaceChanges_async]
