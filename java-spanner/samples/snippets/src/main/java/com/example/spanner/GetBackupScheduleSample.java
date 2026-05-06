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

// [START spanner_get_backup_schedule]

import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.BackupScheduleName;
import com.google.spanner.admin.database.v1.GetBackupScheduleRequest;
import java.io.IOException;

class GetBackupScheduleSample {

  static void getBackupSchedule() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupScheduleId = "my-backup-schedule";
    getBackupSchedule(projectId, instanceId, databaseId, backupScheduleId);
  }

  static void getBackupSchedule(
      String projectId, String instanceId, String databaseId, String backupScheduleId)
      throws IOException {
    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      BackupScheduleName backupScheduleName =
          BackupScheduleName.of(projectId, instanceId, databaseId, backupScheduleId);
      final BackupSchedule backupSchedule =
          databaseAdminClient.getBackupSchedule(
              GetBackupScheduleRequest.newBuilder().setName(backupScheduleName.toString()).build());
      System.out.println(
          String.format(
              "Backup schedule: %s\n%s", backupSchedule.getName(), backupSchedule.toString()));
    }
  }
}
// [END spanner_get_backup_schedule]
