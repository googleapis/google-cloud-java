/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.notebooks.v1.samples;

// [START notebooks_v1_generated_managednotebookserviceclient_createruntime_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.notebooks.v1.CreateRuntimeRequest;
import com.google.cloud.notebooks.v1.ManagedNotebookServiceClient;
import com.google.cloud.notebooks.v1.Runtime;
import com.google.cloud.notebooks.v1.RuntimeName;
import com.google.longrunning.Operation;

public class AsyncCreateRuntime {

  public static void main(String[] args) throws Exception {
    asyncCreateRuntime();
  }

  public static void asyncCreateRuntime() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedNotebookServiceClient managedNotebookServiceClient =
        ManagedNotebookServiceClient.create()) {
      CreateRuntimeRequest request =
          CreateRuntimeRequest.newBuilder()
              .setParent(RuntimeName.of("[PROJECT]", "[LOCATION]", "[RUNTIME]").toString())
              .setRuntimeId("runtimeId121455379")
              .setRuntime(Runtime.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          managedNotebookServiceClient.createRuntimeCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END notebooks_v1_generated_managednotebookserviceclient_createruntime_async]
