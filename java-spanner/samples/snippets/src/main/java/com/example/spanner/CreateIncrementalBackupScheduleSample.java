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

// [START spanner_create_incremental_backup_schedule]

import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.protobuf.Duration;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.BackupScheduleSpec;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.CrontabSpec;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.IncrementalBackupSpec;
import java.io.IOException;

class CreateIncrementalBackupScheduleSample {

  static void createIncrementalBackupSchedule() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupScheduleId = "my-backup-schedule";
    createIncrementalBackupSchedule(projectId, instanceId, databaseId, backupScheduleId);
  }

  static void createIncrementalBackupSchedule(
      String projectId, String instanceId, String databaseId, String backupScheduleId)
      throws IOException {
    final CreateBackupEncryptionConfig encryptionConfig =
        CreateBackupEncryptionConfig.newBuilder()
            .setEncryptionType(
                CreateBackupEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
            .build();
    final BackupSchedule backupSchedule =
        BackupSchedule.newBuilder()
            .setIncrementalBackupSpec(IncrementalBackupSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().setSeconds(3600 * 24).build())
            .setSpec(
                BackupScheduleSpec.newBuilder()
                    .setCronSpec(CrontabSpec.newBuilder().setText("30 12 * * *").build())
                    .build())
            .setEncryptionConfig(encryptionConfig)
            .build();

    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      DatabaseName databaseName = DatabaseName.of(projectId, instanceId, databaseId);
      final BackupSchedule createdBackupSchedule =
          databaseAdminClient.createBackupSchedule(
              CreateBackupScheduleRequest.newBuilder()
                  .setParent(databaseName.toString())
                  .setBackupScheduleId(backupScheduleId)
                  .setBackupSchedule(backupSchedule)
                  .build());
      System.out.println(
          String.format(
              "Created incremental backup schedule: %s\n%s",
              createdBackupSchedule.getName(), createdBackupSchedule.toString()));
    }
  }
}
// [END spanner_create_incremental_backup_schedule]
