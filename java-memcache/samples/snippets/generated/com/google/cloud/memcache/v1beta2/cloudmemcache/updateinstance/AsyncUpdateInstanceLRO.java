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

package com.google.cloud.memcache.v1beta2.samples;

// [START memcache_v1beta2_generated_CloudMemcache_UpdateInstance_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.memcache.v1beta2.CloudMemcacheClient;
import com.google.cloud.memcache.v1beta2.Instance;
import com.google.cloud.memcache.v1beta2.OperationMetadata;
import com.google.cloud.memcache.v1beta2.UpdateInstanceRequest;
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
    try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
      UpdateInstanceRequest request =
          UpdateInstanceRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setResource(Instance.newBuilder().build())
              .build();
      OperationFuture<Instance, OperationMetadata> future =
          cloudMemcacheClient.updateInstanceOperationCallable().futureCall(request);
      // Do something.
      Instance response = future.get();
    }
  }
}
// [END memcache_v1beta2_generated_CloudMemcache_UpdateInstance_LRO_async]
