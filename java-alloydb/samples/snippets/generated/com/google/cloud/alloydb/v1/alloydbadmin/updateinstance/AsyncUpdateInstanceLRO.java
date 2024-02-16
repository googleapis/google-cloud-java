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

package com.google.cloud.alloydb.v1.samples;

// [START alloydb_v1_generated_AlloyDBAdmin_UpdateInstance_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.alloydb.v1.AlloyDBAdminClient;
import com.google.cloud.alloydb.v1.Instance;
import com.google.cloud.alloydb.v1.OperationMetadata;
import com.google.cloud.alloydb.v1.UpdateInstanceRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateInstanceLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateInstanceLRO();
  }

  public static void asyncUpdateInstanceLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlloyDBAdminClient alloyDBAdminClient = AlloyDBAdminClient.create()) {
      UpdateInstanceRequest request =
          UpdateInstanceRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setInstance(Instance.newBuilder().build())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .setAllowMissing(true)
              .build();
      OperationFuture<Instance, OperationMetadata> future =
          alloyDBAdminClient.updateInstanceOperationCallable().futureCall(request);
      // Do something.
      Instance response = future.get();
    }
  }
}
// [END alloydb_v1_generated_AlloyDBAdmin_UpdateInstance_LRO_async]
