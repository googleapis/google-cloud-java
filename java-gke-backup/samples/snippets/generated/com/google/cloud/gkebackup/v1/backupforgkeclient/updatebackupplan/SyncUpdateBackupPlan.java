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

package com.google.cloud.gkebackup.v1.samples;

// [START gkebackup_v1_generated_backupforgkeclient_updatebackupplan_sync]
import com.google.cloud.gkebackup.v1.BackupForGKEClient;
import com.google.cloud.gkebackup.v1.BackupPlan;
import com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateBackupPlan {

  public static void main(String[] args) throws Exception {
    syncUpdateBackupPlan();
  }

  public static void syncUpdateBackupPlan() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
      UpdateBackupPlanRequest request =
          UpdateBackupPlanRequest.newBuilder()
              .setBackupPlan(BackupPlan.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      BackupPlan response = backupForGKEClient.updateBackupPlanAsync(request).get();
    }
  }
}
// [END gkebackup_v1_generated_backupforgkeclient_updatebackupplan_sync]
