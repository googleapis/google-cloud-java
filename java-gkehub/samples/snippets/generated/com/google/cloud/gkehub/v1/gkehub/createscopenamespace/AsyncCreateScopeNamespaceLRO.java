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

package com.google.cloud.gkehub.v1.samples;

// [START gkehub_v1_generated_GkeHub_CreateScopeNamespace_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.GkeHubClient;
import com.google.cloud.gkehub.v1.Namespace;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.ScopeName;

public class AsyncCreateScopeNamespaceLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateScopeNamespaceLRO();
  }

  public static void asyncCreateScopeNamespaceLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
      CreateScopeNamespaceRequest request =
          CreateScopeNamespaceRequest.newBuilder()
              .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
              .setScopeNamespaceId("scopeNamespaceId-125738782")
              .setScopeNamespace(Namespace.newBuilder().build())
              .build();
      OperationFuture<Namespace, OperationMetadata> future =
          gkeHubClient.createScopeNamespaceOperationCallable().futureCall(request);
      // Do something.
      Namespace response = future.get();
    }
  }
}
// [END gkehub_v1_generated_GkeHub_CreateScopeNamespace_LRO_async]
