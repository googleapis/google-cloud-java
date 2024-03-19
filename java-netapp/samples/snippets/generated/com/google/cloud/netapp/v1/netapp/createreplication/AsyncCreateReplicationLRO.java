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

package com.google.cloud.netapp.v1.samples;

// [START netapp_v1_generated_NetApp_CreateReplication_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.netapp.v1.CreateReplicationRequest;
import com.google.cloud.netapp.v1.NetAppClient;
import com.google.cloud.netapp.v1.OperationMetadata;
import com.google.cloud.netapp.v1.Replication;
import com.google.cloud.netapp.v1.VolumeName;

public class AsyncCreateReplicationLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateReplicationLRO();
  }

  public static void asyncCreateReplicationLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetAppClient netAppClient = NetAppClient.create()) {
      CreateReplicationRequest request =
          CreateReplicationRequest.newBuilder()
              .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
              .setReplication(Replication.newBuilder().build())
              .setReplicationId("replicationId1170820615")
              .build();
      OperationFuture<Replication, OperationMetadata> future =
          netAppClient.createReplicationOperationCallable().futureCall(request);
      // Do something.
      Replication response = future.get();
    }
  }
}
// [END netapp_v1_generated_NetApp_CreateReplication_LRO_async]
