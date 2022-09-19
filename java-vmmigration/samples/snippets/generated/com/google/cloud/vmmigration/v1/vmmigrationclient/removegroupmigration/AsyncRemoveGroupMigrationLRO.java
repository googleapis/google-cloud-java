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

package com.google.cloud.vmmigration.v1.samples;

// [START vmmigration_v1_generated_vmmigrationclient_removegroupmigration_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vmmigration.v1.GroupName;
import com.google.cloud.vmmigration.v1.MigratingVmName;
import com.google.cloud.vmmigration.v1.OperationMetadata;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.VmMigrationClient;

public class AsyncRemoveGroupMigrationLRO {

  public static void main(String[] args) throws Exception {
    asyncRemoveGroupMigrationLRO();
  }

  public static void asyncRemoveGroupMigrationLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
      RemoveGroupMigrationRequest request =
          RemoveGroupMigrationRequest.newBuilder()
              .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
              .setMigratingVm(
                  MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                      .toString())
              .build();
      OperationFuture<RemoveGroupMigrationResponse, OperationMetadata> future =
          vmMigrationClient.removeGroupMigrationOperationCallable().futureCall(request);
      // Do something.
      RemoveGroupMigrationResponse response = future.get();
    }
  }
}
// [END vmmigration_v1_generated_vmmigrationclient_removegroupmigration_lro_async]
