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

package com.google.cloud.backupdr.v1.samples;

// [START backupdr_v1_generated_BackupDR_UpdateBackupPlan_sync]
import com.google.cloud.backupdr.v1.BackupDRClient;
import com.google.cloud.backupdr.v1.BackupPlan;
import com.google.cloud.backupdr.v1.UpdateBackupPlanRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateBackupPlan {

  public static void main(String[] args) throws Exception {
    syncUpdateBackupPlan();
  }

  public static void syncUpdateBackupPlan() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BackupDRClient backupDRClient = BackupDRClient.create()) {
      UpdateBackupPlanRequest request =
          UpdateBackupPlanRequest.newBuilder()
              .setBackupPlan(BackupPlan.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      BackupPlan response = backupDRClient.updateBackupPlanAsync(request).get();
    }
  }
}
// [END backupdr_v1_generated_BackupDR_UpdateBackupPlan_sync]
