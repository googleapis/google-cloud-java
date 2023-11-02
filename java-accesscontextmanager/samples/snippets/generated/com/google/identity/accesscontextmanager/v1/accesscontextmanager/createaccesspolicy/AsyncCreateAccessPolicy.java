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

// [START accesscontextmanager_v1_generated_AccessContextManager_CreateAccessPolicy_async]
import com.google.api.core.ApiFuture;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerClient;
import com.google.identity.accesscontextmanager.v1.AccessPolicy;
import com.google.identity.accesscontextmanager.v1.AccessPolicyName;
import com.google.longrunning.Operation;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncCreateAccessPolicy {

  public static void main(String[] args) throws Exception {
    asyncCreateAccessPolicy();
  }

  public static void asyncCreateAccessPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AccessContextManagerClient accessContextManagerClient =
        AccessContextManagerClient.create()) {
      AccessPolicy request =
          AccessPolicy.newBuilder()
              .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .setParent("parent-995424086")
              .setTitle("title110371416")
              .addAllScopes(new ArrayList<String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      ApiFuture<Operation> future =
          accessContextManagerClient.createAccessPolicyCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END accesscontextmanager_v1_generated_AccessContextManager_CreateAccessPolicy_async]
