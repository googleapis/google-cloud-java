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

package com.google.cloud.run.v2.samples;

// [START run_v2_generated_WorkerPools_CreateWorkerPool_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.run.v2.CreateWorkerPoolRequest;
import com.google.cloud.run.v2.LocationName;
import com.google.cloud.run.v2.WorkerPool;
import com.google.cloud.run.v2.WorkerPoolsClient;
import com.google.longrunning.Operation;

public class AsyncCreateWorkerPool {

  public static void main(String[] args) throws Exception {
    asyncCreateWorkerPool();
  }

  public static void asyncCreateWorkerPool() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
      CreateWorkerPoolRequest request =
          CreateWorkerPoolRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setWorkerPool(WorkerPool.newBuilder().build())
              .setWorkerPoolId("workerPoolId-46320779")
              .setValidateOnly(true)
              .build();
      ApiFuture<Operation> future =
          workerPoolsClient.createWorkerPoolCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END run_v2_generated_WorkerPools_CreateWorkerPool_async]
