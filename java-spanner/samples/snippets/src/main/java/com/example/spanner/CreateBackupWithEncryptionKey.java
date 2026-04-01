/*
 * Copyright 2021 Google LLC
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

// [START spanner_create_backup_with_encryption_key]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig.EncryptionType;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.InstanceName;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;

public class CreateBackupWithEncryptionKey {

  static void createBackupWithEncryptionKey() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupId = "my-backup";
    String kmsKeyName =
        "projects/" + projectId + "/locations/<location>/keyRings/<keyRing>/cryptoKeys/<keyId>";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient adminClient = spanner.createDatabaseAdminClient()) {
      createBackupWithEncryptionKey(
          adminClient,
          projectId,
          instanceId,
          databaseId,
          backupId,
          kmsKeyName);
    }
  }

  static Void createBackupWithEncryptionKey(DatabaseAdminClient adminClient,
      String projectId, String instanceId, String databaseId, String backupId, String kmsKeyName) {
    // Set expire time to 14 days from now.
    final Timestamp expireTime =
        Timestamp.newBuilder().setSeconds(TimeUnit.MILLISECONDS.toSeconds((
            System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14)))).build();
    final BackupName backupName = BackupName.of(projectId, instanceId, backupId);
    Backup backup = Backup.newBuilder()
        .setName(backupName.toString())
        .setDatabase(DatabaseName.of(projectId, instanceId, databaseId).toString())
        .setExpireTime(expireTime).build();

    final CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(InstanceName.of(projectId, instanceId).toString())
            .setBackupId(backupId)
            .setBackup(backup)
            .setEncryptionConfig(
                CreateBackupEncryptionConfig.newBuilder()
                    .setEncryptionType(EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
                    .setKmsKeyName(kmsKeyName).build()).build();
    try {
      System.out.println("Waiting for operation to complete...");
      backup = adminClient.createBackupAsync(request).get(1200, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } catch (TimeoutException e) {
      // If the operation timed out propagates the timeout
      throw SpannerExceptionFactory.propagateTimeout(e);
    }
    System.out.printf(
        "Backup %s of size %d bytes was created at %s using encryption key %s%n",
        backup.getName(),
        backup.getSizeBytes(),
        LocalDateTime.ofEpochSecond(
            backup.getCreateTime().getSeconds(),
            backup.getCreateTime().getNanos(),
            OffsetDateTime.now().getOffset()),
        kmsKeyName
    );

    return null;
  }
}
// [END spanner_create_backup_with_encryption_key]
