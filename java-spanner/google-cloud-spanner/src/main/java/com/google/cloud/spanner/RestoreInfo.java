/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import com.google.cloud.Timestamp;
import javax.annotation.Nullable;

/** Represents the restore information of a Cloud Spanner database. */
public class RestoreInfo {
  private static class Builder {
    private final BackupId backup;
    private RestoreSourceType sourceType;
    private Timestamp backupCreateTime;
    private DatabaseId sourceDatabase;
    private com.google.spanner.admin.database.v1.RestoreInfo proto;

    private Builder(BackupId backup) {
      this.backup = backup;
    }

    private Builder setSourceType(RestoreSourceType sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    private Builder setBackupCreateTime(Timestamp backupCreateTime) {
      this.backupCreateTime = backupCreateTime;
      return this;
    }

    private Builder setSourceDatabase(DatabaseId sourceDatabase) {
      this.sourceDatabase = sourceDatabase;
      return this;
    }

    private Builder setProto(com.google.spanner.admin.database.v1.RestoreInfo proto) {
      this.proto = proto;
      return this;
    }

    private RestoreInfo build() {
      return new RestoreInfo(this);
    }
  }

  /** Source of the restore information. */
  public enum RestoreSourceType {
    // Not specified.
    UNSPECIFIED,
    // The database was restored from a Backup.
    BACKUP
  }

  private final BackupId backup;
  private final RestoreSourceType sourceType;
  private final Timestamp backupCreateTime;
  private final DatabaseId sourceDatabase;
  private final com.google.spanner.admin.database.v1.RestoreInfo proto;

  private RestoreInfo(Builder builder) {
    this.backup = builder.backup;
    this.sourceType = builder.sourceType;
    this.backupCreateTime = builder.backupCreateTime;
    this.sourceDatabase = builder.sourceDatabase;
    this.proto = builder.proto;
  }

  /** The backup source of the restored database. The backup may no longer exist. */
  public BackupId getBackup() {
    return backup;
  }

  /** The source type of the restore. */
  public RestoreSourceType getSourceType() {
    return sourceType;
  }

  /** The create time of the backup for the restore. */
  public Timestamp getBackupCreateTime() {
    return backupCreateTime;
  }

  /** The source database that was used to create the backup. The database may no longer exist. */
  public DatabaseId getSourceDatabase() {
    return sourceDatabase;
  }

  /** Returns the raw proto instance that was used to construct this {@link RestoreInfo}. */
  public @Nullable com.google.spanner.admin.database.v1.RestoreInfo getProto() {
    return proto;
  }

  /**
   * Returns a {@link RestoreInfo} instance from the given proto, or <code>null</code> if the given
   * proto is the default proto instance (i.e. there is no restore info).
   */
  static RestoreInfo fromProtoOrNullIfDefaultInstance(
      com.google.spanner.admin.database.v1.RestoreInfo proto) {
    return proto.equals(com.google.spanner.admin.database.v1.RestoreInfo.getDefaultInstance())
        ? null
        : new Builder(BackupId.of(proto.getBackupInfo().getBackup()))
            .setSourceType(fromProtoSourceType(proto.getSourceType()))
            .setBackupCreateTime(Timestamp.fromProto(proto.getBackupInfo().getCreateTime()))
            .setSourceDatabase(DatabaseId.of(proto.getBackupInfo().getSourceDatabase()))
            .setProto(proto)
            .build();
  }

  static RestoreSourceType fromProtoSourceType(
      com.google.spanner.admin.database.v1.RestoreSourceType protoSourceType) {
    switch (protoSourceType) {
      case BACKUP:
        return RestoreSourceType.BACKUP;
      case TYPE_UNSPECIFIED:
        return RestoreSourceType.UNSPECIFIED;
      default:
        throw new IllegalArgumentException("Unrecognized source type " + protoSourceType);
    }
  }
}
