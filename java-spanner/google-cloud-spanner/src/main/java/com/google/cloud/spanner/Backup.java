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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.client.util.Preconditions;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.Policy;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.encryption.EncryptionInfo;
import com.google.longrunning.Operation;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;

/**
 * Represents a Cloud Spanner database backup. {@code Backup} adds a layer of service related
 * functionality over {@code BackupInfo}.
 */
public class Backup extends BackupInfo {
  public static class Builder extends BackupInfo.BuilderImpl {
    private final DatabaseAdminClient dbClient;

    Builder(DatabaseAdminClient dbClient, BackupId backupId) {
      super(backupId);
      this.dbClient = Preconditions.checkNotNull(dbClient);
    }

    private Builder(Backup backup) {
      super(backup);
      this.dbClient = backup.dbClient;
    }

    @Override
    public Backup build() {
      return new Backup(this);
    }
  }

  private static final String FILTER_BACKUP_OPERATIONS_TEMPLATE = "name:backups/%s";
  private final DatabaseAdminClient dbClient;

  Backup(Builder builder) {
    super(builder);
    this.dbClient = Preconditions.checkNotNull(builder.dbClient);
  }

  /** Creates a backup on the server based on the source of this {@link Backup} instance. */
  public OperationFuture<Backup, CreateBackupMetadata> create() {
    return dbClient.createBackup(this);
  }

  /**
   * Returns <code>true</code> if a backup with the id of this {@link Backup} exists on Cloud
   * Spanner.
   */
  public boolean exists() {
    try {
      dbClient.getBackup(instance(), backup());
    } catch (SpannerException e) {
      if (e.getErrorCode() == ErrorCode.NOT_FOUND) {
        return false;
      }
      throw e;
    }
    return true;
  }

  /**
   * Returns <code>true</code> if this backup is ready to use. The value returned by this method
   * could be out-of-sync with the value returned by {@link #getState()}, as this method will make a
   * round-trip to the server and return a value based on the response from the server.
   */
  public boolean isReady() {
    return reload().getState() == State.READY;
  }

  /**
   * Fetches the backup's current information and returns a new {@link Backup} instance. It does not
   * update this instance.
   */
  public Backup reload() throws SpannerException {
    return dbClient.getBackup(instance(), backup());
  }

  /** Deletes this backup on Cloud Spanner. */
  public void delete() throws SpannerException {
    dbClient.deleteBackup(instance(), backup());
  }

  /**
   * Updates the expire time of this backup on Cloud Spanner. If this {@link Backup} does not have
   * an expire time, the method will throw an {@link IllegalStateException}.
   */
  public void updateExpireTime() {
    Preconditions.checkState(getExpireTime() != null, "This backup has no expire time");
    dbClient.updateBackup(instance(), backup(), getExpireTime());
  }

  /**
   * Restores this backup to the specified database. The database must not already exist and will be
   * created by this call. The database may be created in a different instance than where the backup
   * is stored.
   */
  public OperationFuture<Database, RestoreDatabaseMetadata> restore(DatabaseId database) {
    Preconditions.checkNotNull(database);
    return dbClient.restoreDatabase(
        instance(), backup(), database.getInstanceId().getInstance(), database.getDatabase());
  }

  /** Returns all long-running backup operations for this {@link Backup}. */
  public Page<Operation> listBackupOperations() {
    return dbClient.listBackupOperations(
        instance(), Options.filter(String.format(FILTER_BACKUP_OPERATIONS_TEMPLATE, backup())));
  }

  /** Returns the IAM {@link Policy} for this backup. */
  public Policy getIAMPolicy() {
    return dbClient.getBackupIAMPolicy(instance(), backup());
  }

  /**
   * Updates the IAM policy for this backup and returns the resulting policy. It is highly
   * recommended to first get the current policy and base the updated policy on the returned policy.
   * See {@link Policy.Builder#setEtag(String)} for information on the recommended read-modify-write
   * cycle.
   */
  public Policy setIAMPolicy(Policy policy) {
    return dbClient.setBackupIAMPolicy(instance(), backup(), policy);
  }

  /**
   * Tests for the given permissions on this backup for the caller.
   *
   * @param permissions the permissions to test for. Permissions with wildcards (such as '*',
   *     'spanner.*', 'spanner.instances.*') are not allowed.
   * @return the subset of the tested permissions that the caller is allowed.
   */
  public Iterable<String> testIAMPermissions(Iterable<String> permissions) {
    return dbClient.testBackupIAMPermissions(instance(), backup(), permissions);
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private String instance() {
    return getInstanceId().getInstance();
  }

  private String backup() {
    return getId().getBackup();
  }

  private String sourceDatabase() {
    return getDatabase().getDatabase();
  }

  static Backup fromProto(
      com.google.spanner.admin.database.v1.Backup proto, DatabaseAdminClient client) {
    checkArgument(!proto.getName().isEmpty(), "Missing expected 'name' field");
    checkArgument(!proto.getDatabase().isEmpty(), "Missing expected 'database' field");
    return new Backup.Builder(client, BackupId.of(proto.getName()))
        .setState(fromProtoState(proto.getState()))
        .setSize(proto.getSizeBytes())
        .setExpireTime(Timestamp.fromProto(proto.getExpireTime()))
        .setVersionTime(Timestamp.fromProto(proto.getVersionTime()))
        .setDatabase(DatabaseId.of(proto.getDatabase()))
        .setEncryptionInfo(EncryptionInfo.fromProtoOrNull(proto.getEncryptionInfo()))
        .setProto(proto)
        .setMaxExpireTime(Timestamp.fromProto(proto.getMaxExpireTime()))
        .addAllReferencingBackups(proto.getReferencingBackupsList())
        .build();
  }

  static BackupInfo.State fromProtoState(
      com.google.spanner.admin.database.v1.Backup.State protoState) {
    switch (protoState) {
      case STATE_UNSPECIFIED:
        return BackupInfo.State.UNSPECIFIED;
      case CREATING:
        return BackupInfo.State.CREATING;
      case READY:
        return BackupInfo.State.READY;
      default:
        throw new IllegalArgumentException("Unrecognized state " + protoState);
    }
  }
}
