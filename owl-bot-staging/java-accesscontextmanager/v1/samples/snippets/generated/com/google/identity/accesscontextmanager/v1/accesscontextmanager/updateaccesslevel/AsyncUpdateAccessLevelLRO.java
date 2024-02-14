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

package com.google.identity.accesscontextmanager.v1.samples;

// [START accesscontextmanager_v1_generated_AccessContextManager_UpdateAccessLevel_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerClient;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateAccessLevelLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateAccessLevelLRO();
  }

  public static void asyncUpdateAccessLevelLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AccessContextManagerClient accessContextManagerClient =
        AccessContextManagerClient.create()) {
      UpdateAccessLevelRequest request =
          UpdateAccessLevelRequest.newBuilder()
              .setAccessLevel(AccessLevel.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      OperationFuture<AccessLevel, AccessContextManagerOperationMetadata> future =
          accessContextManagerClient.updateAccessLevelOperationCallable().futureCall(request);
      // Do something.
      AccessLevel response = future.get();
    }
  }
}
// [END accesscontextmanager_v1_generated_AccessContextManager_UpdateAccessLevel_LRO_async]
