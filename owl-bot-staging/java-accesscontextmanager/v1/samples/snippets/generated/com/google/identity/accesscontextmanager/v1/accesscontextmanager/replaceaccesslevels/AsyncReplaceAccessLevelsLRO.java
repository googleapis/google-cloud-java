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

package com.google.identity.accesscontextmanager.v1.samples;

// [START accesscontextmanager_v1_generated_AccessContextManager_ReplaceAccessLevels_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerClient;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.AccessPolicyName;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsResponse;
import java.util.ArrayList;

public class AsyncReplaceAccessLevelsLRO {

  public static void main(String[] args) throws Exception {
    asyncReplaceAccessLevelsLRO();
  }

  public static void asyncReplaceAccessLevelsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AccessContextManagerClient accessContextManagerClient =
        AccessContextManagerClient.create()) {
      ReplaceAccessLevelsRequest request =
          ReplaceAccessLevelsRequest.newBuilder()
              .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .addAllAccessLevels(new ArrayList<AccessLevel>())
              .setEtag("etag3123477")
              .build();
      OperationFuture<ReplaceAccessLevelsResponse, AccessContextManagerOperationMetadata> future =
          accessContextManagerClient.replaceAccessLevelsOperationCallable().futureCall(request);
      // Do something.
      ReplaceAccessLevelsResponse response = future.get();
    }
  }
}
// [END accesscontextmanager_v1_generated_AccessContextManager_ReplaceAccessLevels_LRO_async]
