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

// [START notebooks_v1_generated_NotebookService_UpgradeInstanceInternal_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.notebooks.v1.Instance;
import com.google.cloud.notebooks.v1.NotebookServiceClient;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest;
import com.google.cloud.notebooks.v1.UpgradeType;

public class AsyncUpgradeInstanceInternalLRO {

  public static void main(String[] args) throws Exception {
    asyncUpgradeInstanceInternalLRO();
  }

  public static void asyncUpgradeInstanceInternalLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
      UpgradeInstanceInternalRequest request =
          UpgradeInstanceInternalRequest.newBuilder()
              .setName("name3373707")
              .setVmId("vmId3622450")
              .setType(UpgradeType.forNumber(0))
              .build();
      OperationFuture<Instance, OperationMetadata> future =
          notebookServiceClient.upgradeInstanceInternalOperationCallable().futureCall(request);
      // Do something.
      Instance response = future.get();
    }
  }
}
// [END notebooks_v1_generated_NotebookService_UpgradeInstanceInternal_LRO_async]
