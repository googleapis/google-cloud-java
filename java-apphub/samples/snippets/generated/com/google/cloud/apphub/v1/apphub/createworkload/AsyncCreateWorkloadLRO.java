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

package com.google.cloud.apphub.v1.samples;

// [START apphub_v1_generated_AppHub_CreateWorkload_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.apphub.v1.AppHubClient;
import com.google.cloud.apphub.v1.ApplicationName;
import com.google.cloud.apphub.v1.CreateWorkloadRequest;
import com.google.cloud.apphub.v1.OperationMetadata;
import com.google.cloud.apphub.v1.Workload;

public class AsyncCreateWorkloadLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateWorkloadLRO();
  }

  public static void asyncCreateWorkloadLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AppHubClient appHubClient = AppHubClient.create()) {
      CreateWorkloadRequest request =
          CreateWorkloadRequest.newBuilder()
              .setParent(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
              .setWorkloadId("workloadId-186277134")
              .setWorkload(Workload.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Workload, OperationMetadata> future =
          appHubClient.createWorkloadOperationCallable().futureCall(request);
      // Do something.
      Workload response = future.get();
    }
  }
}
// [END apphub_v1_generated_AppHub_CreateWorkload_LRO_async]
