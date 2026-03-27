/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_restore_backup_with_MR_CMEK]

import static com.google.spanner.admin.database.v1.RestoreDatabaseEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION;

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.RestoreDatabaseEncryptionConfig;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import java.util.concurrent.ExecutionException;

public class RestoreBackupWithMultiRegionEncryptionKey {

  static void restoreBackupWithMultiRegionEncryptionKey() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupId = "my-backup";
    String[] kmsKeyNames =
        new String[] {
          "projects/" + projectId + "/locations/<location1>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location2>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location3>/keyRings/<keyRing>/cryptoKeys/<keyId>"
        };

    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient adminClient = spanner.createDatabaseAdminClient()) {
      restoreBackupWithMultiRegionEncryptionKey(
          adminClient, projectId, instanceId, backupId, databaseId, kmsKeyNames);
    }
  }

  static Void restoreBackupWithMultiRegionEncryptionKey(
      DatabaseAdminClient adminClient,
      String projectId,
      String instanceId,
      String backupId,
      String restoreId,
      String[] kmsKeyNames) {
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(InstanceName.of(projectId, instanceId).toString())
            .setDatabaseId(restoreId)
            .setBackup(BackupName.of(projectId, instanceId, backupId).toString())
            .setEncryptionConfig(
                RestoreDatabaseEncryptionConfig.newBuilder()
                    .setEncryptionType(CUSTOMER_MANAGED_ENCRYPTION)
                    .addAllKmsKeyNames(ImmutableList.copyOf(kmsKeyNames)))
            .build();
    Database database;
    try {
      System.out.println("Waiting for operation to complete...");
      database = adminClient.restoreDatabaseAsync(request).get();
      ;
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }

    System.out.printf(
        "Database %s restored to %s from backup %s using encryption keys %s%n",
        database.getRestoreInfo().getBackupInfo().getSourceDatabase(),
        database.getName(),
        database.getRestoreInfo().getBackupInfo().getBackup(),
        database.getEncryptionConfig().getKmsKeyNamesList());
    return null;
  }
}
// [END spanner_restore_backup_with_MR_CMEK]
