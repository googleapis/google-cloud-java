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

package com.example.spanner.admin.archived;

// [START spanner_create_backup_with_encryption_key]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Backup;
import com.google.cloud.spanner.BackupId;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.encryption.EncryptionConfigs;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;

public class CreateBackupWithEncryptionKey {

  static void createBackupWithEncryptionKey() throws InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String backupId = "my-backup";
    String kmsKeyName =
        "projects/" + projectId + "/locations/<location>/keyRings/<keyRing>/cryptoKeys/<keyId>";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
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
      String projectId, String instanceId, String databaseId, String backupId, String kmsKeyName)
      throws InterruptedException {
    // Set expire time to 14 days from now.
    final Timestamp expireTime = Timestamp.ofTimeMicroseconds(TimeUnit.MICROSECONDS.convert(
        System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14), TimeUnit.MILLISECONDS));
    final Backup backupToCreate = adminClient
        .newBackupBuilder(BackupId.of(projectId, instanceId, backupId))
        .setDatabase(DatabaseId.of(projectId, instanceId, databaseId))
        .setExpireTime(expireTime)
        .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(kmsKeyName))
        .build();
    final OperationFuture<Backup, CreateBackupMetadata> operation = adminClient
        .createBackup(backupToCreate);

    Backup backup;
    try {
      System.out.println("Waiting for operation to complete...");
      backup = operation.get(1200, TimeUnit.SECONDS);
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
        backup.getId().getName(),
        backup.getSize(),
        LocalDateTime.ofEpochSecond(
            backup.getProto().getCreateTime().getSeconds(),
            backup.getProto().getCreateTime().getNanos(),
            OffsetDateTime.now().getOffset()),
        kmsKeyName
    );

    return null;
  }
}
// [END spanner_create_backup_with_encryption_key]
