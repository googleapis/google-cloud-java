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

// [START spanner_update_backup_schedule]

import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.BackupScheduleName;
import com.google.spanner.admin.database.v1.BackupScheduleSpec;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CrontabSpec;
import com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest;
import java.io.IOException;

class UpdateBackupScheduleSample {

  static void updateBackupSchedule() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupScheduleId = "my-backup-schedule";
    updateBackupSchedule(projectId, instanceId, databaseId, backupScheduleId);
  }

  static void updateBackupSchedule(
      String projectId, String instanceId, String databaseId, String backupScheduleId)
      throws IOException {
    BackupScheduleName backupScheduleName =
        BackupScheduleName.of(projectId, instanceId, databaseId, backupScheduleId);
    final CreateBackupEncryptionConfig encryptionConfig =
        CreateBackupEncryptionConfig.newBuilder()
            .setEncryptionType(CreateBackupEncryptionConfig.EncryptionType.USE_DATABASE_ENCRYPTION)
            .build();
    final BackupSchedule backupSchedule =
        BackupSchedule.newBuilder()
            .setName(backupScheduleName.toString())
            .setRetentionDuration(Duration.newBuilder().setSeconds(3600 * 48))
            .setSpec(
                BackupScheduleSpec.newBuilder()
                    .setCronSpec(CrontabSpec.newBuilder().setText("45 15 * * *").build())
                    .build())
            .setEncryptionConfig(encryptionConfig)
            .build();

    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      final FieldMask fieldMask =
          FieldMask.newBuilder()
              .addPaths("retention_duration")
              .addPaths("spec.cron_spec.text")
              .addPaths("encryption_config")
              .build();
      final BackupSchedule updatedBackupSchedule =
          databaseAdminClient.updateBackupSchedule(
              UpdateBackupScheduleRequest.newBuilder()
                  .setBackupSchedule(backupSchedule)
                  .setUpdateMask(fieldMask)
                  .build());
      System.out.println(
          String.format(
              "Updated backup schedule: %s\n%s",
              updatedBackupSchedule.getName(), updatedBackupSchedule.toString()));
    }
  }
}
// [END spanner_update_backup_schedule]
