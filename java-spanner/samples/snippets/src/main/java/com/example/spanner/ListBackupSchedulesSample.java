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

// [START spanner_list_backup_schedules]

import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.DatabaseName;
import java.io.IOException;

class ListBackupSchedulesSample {

  static void listBackupSchedules() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    listBackupSchedules(projectId, instanceId, databaseId);
  }

  static void listBackupSchedules(String projectId, String instanceId, String databaseId)
      throws IOException {
    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      DatabaseName databaseName = DatabaseName.of(projectId, instanceId, databaseId);

      System.out.println(
          String.format("Backup schedules for database '%s'", databaseName.toString()));
      for (BackupSchedule backupSchedule :
          databaseAdminClient.listBackupSchedules(databaseName).iterateAll()) {
        System.out.println(
            String.format(
                "Backup schedule: %s\n%s", backupSchedule.getName(), backupSchedule.toString()));
      }
    }
  }
}
// [END spanner_list_backup_schedules]
