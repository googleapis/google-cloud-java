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

package com.google.cloud.devtools.cloudbuild.v2.samples;

// [START cloudbuild_v2_generated_RepositoryManager_UpdateConnection_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.devtools.cloudbuild.v2.RepositoryManagerClient;
import com.google.cloudbuild.v2.Connection;
import com.google.cloudbuild.v2.OperationMetadata;
import com.google.cloudbuild.v2.UpdateConnectionRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateConnectionLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateConnectionLRO();
  }

  public static void asyncUpdateConnectionLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RepositoryManagerClient repositoryManagerClient = RepositoryManagerClient.create()) {
      UpdateConnectionRequest request =
          UpdateConnectionRequest.newBuilder()
              .setConnection(Connection.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setAllowMissing(true)
              .setEtag("etag3123477")
              .build();
      OperationFuture<Connection, OperationMetadata> future =
          repositoryManagerClient.updateConnectionOperationCallable().futureCall(request);
      // Do something.
      Connection response = future.get();
    }
  }
}
// [END cloudbuild_v2_generated_RepositoryManager_UpdateConnection_LRO_async]
