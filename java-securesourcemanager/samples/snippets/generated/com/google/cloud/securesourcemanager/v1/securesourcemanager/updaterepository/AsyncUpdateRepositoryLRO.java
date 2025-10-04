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

// [START securesourcemanager_v1_generated_SecureSourceManager_UpdateRepository_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.securesourcemanager.v1.OperationMetadata;
import com.google.cloud.securesourcemanager.v1.Repository;
import com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient;
import com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateRepositoryLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateRepositoryLRO();
  }

  public static void asyncUpdateRepositoryLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
      UpdateRepositoryRequest request =
          UpdateRepositoryRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setRepository(Repository.newBuilder().build())
              .setValidateOnly(true)
              .build();
      OperationFuture<Repository, OperationMetadata> future =
          secureSourceManagerClient.updateRepositoryOperationCallable().futureCall(request);
      // Do something.
      Repository response = future.get();
    }
  }
}
// [END securesourcemanager_v1_generated_SecureSourceManager_UpdateRepository_LRO_async]
