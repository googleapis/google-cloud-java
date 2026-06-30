/*
 * Copyright 2022 Google Inc.
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

package com.example.spanner.admin.archived;

// [START spanner_copy_backup]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Backup;
import com.google.cloud.spanner.BackupId;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CopyBackupSample {
  static void copyBackup() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String sourceBackupId = "my-backup";
    String destinationBackupId = "my-destination-backup";
    try (Spanner spanner =
                 SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      copyBackup(databaseAdminClient, projectId, instanceId, sourceBackupId, destinationBackupId);
    }
  }

  static void copyBackup(
          DatabaseAdminClient databaseAdminClient,
          String projectId,
          String instanceId,
          String sourceBackupId,
          String destinationBackupId) {

    Timestamp expireTime =
            Timestamp.ofTimeMicroseconds(
                  TimeUnit.MICROSECONDS.convert(
                          System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14),
                          TimeUnit.MILLISECONDS));
    // Creates a copy of an existing backup.
    Backup destinationBackup =
          databaseAdminClient
                  .newBackupBuilder(BackupId.of(projectId, instanceId, destinationBackupId))
                  .setExpireTime(expireTime)
                   .build();

    // Initiate the request which returns an OperationFuture.
    System.out.println("Copying backup [" + destinationBackup.getId() + "]...");
    OperationFuture<Backup, CopyBackupMetadata> operation =
          databaseAdminClient.copyBackup(
                  BackupId.of(projectId, instanceId, sourceBackupId), destinationBackup);
    try {
      // Wait for the backup operation to complete.
      destinationBackup = operation.get();
      System.out.println("Copied backup [" + destinationBackup.getId() + "]");
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // Load the metadata of the new backup from the server.
    destinationBackup = destinationBackup.reload();
    System.out.println(
              String.format(
                      "Backup %s of size %d bytes was copied at %s for version of database at %s",
                      destinationBackup.getId().getName(),
                      destinationBackup.getSize(),
                      LocalDateTime.ofEpochSecond(
                              destinationBackup.getProto().getCreateTime().getSeconds(),
                              destinationBackup.getProto().getCreateTime().getNanos(),
                              OffsetDateTime.now().getOffset()),
                      LocalDateTime.ofEpochSecond(
                              destinationBackup.getProto().getVersionTime().getSeconds(),
                              destinationBackup.getProto().getVersionTime().getNanos(),
                              OffsetDateTime.now().getOffset())));
    return;
  }
}
// [END spanner_copy_backup]
