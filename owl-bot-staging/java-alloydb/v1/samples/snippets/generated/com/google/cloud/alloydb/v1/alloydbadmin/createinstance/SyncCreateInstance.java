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

// [START alloydb_v1_generated_AlloyDBAdmin_CreateInstance_sync]
import com.google.cloud.alloydb.v1.AlloyDBAdminClient;
import com.google.cloud.alloydb.v1.ClusterName;
import com.google.cloud.alloydb.v1.CreateInstanceRequest;
import com.google.cloud.alloydb.v1.Instance;

public class SyncCreateInstance {

  public static void main(String[] args) throws Exception {
    syncCreateInstance();
  }

  public static void syncCreateInstance() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlloyDBAdminClient alloyDBAdminClient = AlloyDBAdminClient.create()) {
      CreateInstanceRequest request =
          CreateInstanceRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setInstanceId("instanceId902024336")
              .setInstance(Instance.newBuilder().build())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .build();
      Instance response = alloyDBAdminClient.createInstanceAsync(request).get();
    }
  }
}
// [END alloydb_v1_generated_AlloyDBAdmin_CreateInstance_sync]
