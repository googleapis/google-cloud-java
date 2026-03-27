/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_copy_backup_with_MR_CMEK]

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.CopyBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CopyBackupEncryptionConfig.EncryptionType;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CopyBackupWithMultiRegionEncryptionKey {

  static void copyBackupWithMultiRegionEncryptionKey() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String sourceBackupId = "my-backup";
    String destinationBackupId = "my-destination-backup";
    String[] kmsKeyNames =
        new String[] {
          "projects/" + projectId + "/locations/<location1>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location2>/keyRings/<keyRing>/cryptoKeys/<keyId>",
          "projects/" + projectId + "/locations/<location3>/keyRings/<keyRing>/cryptoKeys/<keyId>"
        };

    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      copyBackupWithMultiRegionEncryptionKey(
          databaseAdminClient,
          projectId,
          instanceId,
          sourceBackupId,
          destinationBackupId,
          kmsKeyNames);
    }
  }

  static void copyBackupWithMultiRegionEncryptionKey(
      DatabaseAdminClient databaseAdminClient,
      String projectId,
      String instanceId,
      String sourceBackupId,
      String destinationBackupId,
      String[] kmsKeyNames) {

    Timestamp expireTime =
        Timestamp.ofTimeMicroseconds(
            TimeUnit.MICROSECONDS.convert(
                System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14), TimeUnit.MILLISECONDS));

    // Initiate the request which returns an OperationFuture.
    System.out.println("Copying backup [" + destinationBackupId + "]...");
    CopyBackupRequest request =
        CopyBackupRequest.newBuilder()
            .setParent(InstanceName.of(projectId, instanceId).toString())
            .setBackupId(destinationBackupId)
            .setSourceBackup(BackupName.of(projectId, instanceId, sourceBackupId).toString())
            .setExpireTime(expireTime.toProto())
            .setEncryptionConfig(
                CopyBackupEncryptionConfig.newBuilder()
                    .setEncryptionType(EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
                    .addAllKmsKeyNames(ImmutableList.copyOf(kmsKeyNames))
                    .build())
            .build();
    Backup destinationBackup;
    try {
      // Creates a copy of an existing backup.
      // Wait for the backup operation to complete.
      destinationBackup = databaseAdminClient.copyBackupAsync(request).get();
      System.out.println("Copied backup [" + destinationBackup.getName() + "]");
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // Load the metadata of the new backup from the server.
    destinationBackup = databaseAdminClient.getBackup(destinationBackup.getName());
    System.out.println(
        String.format(
            "Backup %s of size %d bytes was copied at %s for version of database at %s",
            destinationBackup.getName(),
            destinationBackup.getSizeBytes(),
            OffsetDateTime.ofInstant(
                Instant.ofEpochSecond(
                    destinationBackup.getCreateTime().getSeconds(),
                    destinationBackup.getCreateTime().getNanos()),
                ZoneId.systemDefault()),
            OffsetDateTime.ofInstant(
                Instant.ofEpochSecond(
                    destinationBackup.getVersionTime().getSeconds(),
                    destinationBackup.getVersionTime().getNanos()),
                ZoneId.systemDefault())));
  }
}
// [END spanner_copy_backup_with_MR_CMEK]
