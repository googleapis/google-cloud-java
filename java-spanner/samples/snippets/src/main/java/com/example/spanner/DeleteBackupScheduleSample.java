/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_delete_backup_schedule]

import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.BackupScheduleName;
import com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest;
import java.io.IOException;

class DeleteBackupScheduleSample {

  static void deleteBackupSchedule() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupScheduleId = "my-backup-schedule";
    deleteBackupSchedule(projectId, instanceId, databaseId, backupScheduleId);
  }

  static void deleteBackupSchedule(
      String projectId, String instanceId, String databaseId, String backupScheduleId)
      throws IOException {
    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      BackupScheduleName backupScheduleName =
          BackupScheduleName.of(projectId, instanceId, databaseId, backupScheduleId);
      databaseAdminClient.deleteBackupSchedule(
          DeleteBackupScheduleRequest.newBuilder().setName(backupScheduleName.toString()).build());
      System.out.println(
          String.format("Deleted backup schedule: %s", backupScheduleName.toString()));
    }
  }
}
// [END spanner_delete_backup_schedule]
