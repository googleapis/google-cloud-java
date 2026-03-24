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

import com.google.api.client.util.Preconditions;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.encryption.BackupEncryptionConfig;
import com.google.cloud.spanner.encryption.EncryptionInfo;
import com.google.spanner.admin.database.v1.Database;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/** Represents a Cloud Spanner database backup. */
public class BackupInfo {
  public abstract static class Builder {
    abstract Builder setState(State state);

    abstract Builder setSize(long size);

    /**
     * Returned when retrieving a backup.
     *
     * <p>The encryption information for the backup. If the encryption key protecting this resource
     * is customer managed, then kms_key_version will be filled.
     */
    abstract Builder setEncryptionInfo(EncryptionInfo encryptionInfo);

    abstract Builder setProto(com.google.spanner.admin.database.v1.Backup proto);

    /**
     * Optional for creating a new backup.
     *
     * <p>The encryption configuration to be used for the backup. The possible configurations are
     * {@link com.google.cloud.spanner.encryption.CustomerManagedEncryption}, {@link
     * com.google.cloud.spanner.encryption.GoogleDefaultEncryption} and {@link
     * com.google.cloud.spanner.encryption.UseDatabaseEncryption}.
     *
     * <p>If no encryption config is given the backup will be created with the same encryption as
     * set by the database ({@link com.google.cloud.spanner.encryption.UseDatabaseEncryption}).
     */
    public abstract Builder setEncryptionConfig(BackupEncryptionConfig encryptionConfig);

    /**
     * Required for creating a new backup.
     *
     * <p>Sets the expiration time of the backup. The expiration time of the backup, with
     * microseconds granularity that must be at least 6 hours and at most 366 days from the time the
     * request is received. Once the expireTime has passed, Cloud Spanner will delete the backup and
     * free the resources used by the backup.
     */
    public abstract Builder setExpireTime(Timestamp expireTime);

    /**
     * Optional for creating a new backup.
     *
     * <p>Specifies the timestamp to have an externally consistent copy of the database. If no
     * version time is specified, it will be automatically set to the backup create time.
     *
     * <p>The version time can be as far in the past as specified by the database earliest version
     * time (see {@link Database#getEarliestVersionTime()}).
     */
    public abstract Builder setVersionTime(Timestamp versionTime);

    /**
     * Required for creating a new backup.
     *
     * <p>Sets the source database to use for creating the backup.
     */
    public abstract Builder setDatabase(DatabaseId database);

    /** Builds the backup from this builder. */
    public abstract Backup build();

    /**
     * Output Only.
     *
     * <p>Returns the max allowed expiration time of the backup, with microseconds granularity.
     */
    protected Builder setMaxExpireTime(Timestamp maxExpireTime) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    /**
     * Output Only.
     *
     * <p>Returns the names of the destination backups being created by copying this source backup.
     */
    protected Builder addAllReferencingBackups(List<String> referencingBackups) {
      throw new UnsupportedOperationException("Unimplemented");
    }
  }

  abstract static class BuilderImpl extends Builder {
    protected final BackupId id;
    private State state = State.UNSPECIFIED;
    private Timestamp expireTime;
    private Timestamp versionTime;
    private DatabaseId database;
    private long size;
    private BackupEncryptionConfig encryptionConfig;
    private EncryptionInfo encryptionInfo;
    private com.google.spanner.admin.database.v1.Backup proto;
    private Timestamp maxExpireTime;
    private List<String> referencingBackups;

    BuilderImpl(BackupId id) {
      this.id = Preconditions.checkNotNull(id);
    }

    BuilderImpl(BackupInfo other) {
      this.id = other.id;
      this.state = other.state;
      this.expireTime = other.expireTime;
      this.versionTime = other.versionTime;
      this.database = other.database;
      this.size = other.size;
      this.encryptionConfig = other.encryptionConfig;
      this.encryptionInfo = other.encryptionInfo;
      this.proto = other.proto;
      this.maxExpireTime = other.maxExpireTime;
      this.referencingBackups = other.referencingBackups;
    }

    @Override
    Builder setState(State state) {
      this.state = Preconditions.checkNotNull(state);
      return this;
    }

    @Override
    public Builder setExpireTime(Timestamp expireTime) {
      this.expireTime = Preconditions.checkNotNull(expireTime);
      return this;
    }

    @Override
    public Builder setVersionTime(Timestamp versionTime) {
      this.versionTime = versionTime;
      return this;
    }

    @Override
    public Builder setDatabase(DatabaseId database) {
      this.database = Preconditions.checkNotNull(database);
      return this;
    }

    @Override
    public Builder setEncryptionConfig(BackupEncryptionConfig encryptionConfig) {
      this.encryptionConfig = encryptionConfig;
      return this;
    }

    @Override
    Builder setSize(long size) {
      this.size = size;
      return this;
    }

    @Override
    Builder setEncryptionInfo(EncryptionInfo encryptionInfo) {
      this.encryptionInfo = encryptionInfo;
      return this;
    }

    @Override
    Builder setProto(@Nullable com.google.spanner.admin.database.v1.Backup proto) {
      this.proto = proto;
      return this;
    }

    @Override
    protected Builder setMaxExpireTime(Timestamp maxExpireTime) {
      this.maxExpireTime = Preconditions.checkNotNull(maxExpireTime);
      return this;
    }

    @Override
    protected Builder addAllReferencingBackups(List<String> referencingBackups) {
      this.referencingBackups = Preconditions.checkNotNull(referencingBackups);
      return this;
    }
  }

  /** State of the backup. */
  public enum State {
    // Not specified.
    UNSPECIFIED,
    // The backup is still being created and is not ready to use.
    CREATING,
    // The backup is fully created and ready to use.
    READY,
  }

  private final BackupId id;
  private final State state;
  private final Timestamp expireTime;
  private final Timestamp versionTime;
  private final DatabaseId database;
  private final long size;
  private final BackupEncryptionConfig encryptionConfig;
  private final EncryptionInfo encryptionInfo;
  private final com.google.spanner.admin.database.v1.Backup proto;
  private final Timestamp maxExpireTime;
  private final List<String> referencingBackups;

  BackupInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.state = builder.state;
    this.size = builder.size;
    this.encryptionConfig = builder.encryptionConfig;
    this.encryptionInfo = builder.encryptionInfo;
    this.expireTime = builder.expireTime;
    this.versionTime = builder.versionTime;
    this.database = builder.database;
    this.proto = builder.proto;
    this.maxExpireTime = builder.maxExpireTime;
    this.referencingBackups = builder.referencingBackups;
  }

  /** Returns the backup id. */
  public BackupId getId() {
    return id;
  }

  /** Returns the id of the instance that the backup belongs to. */
  public InstanceId getInstanceId() {
    return id.getInstanceId();
  }

  /** Returns the state of the backup. */
  public State getState() {
    return state;
  }

  /** Returns the size of the backup in bytes. */
  public long getSize() {
    return size;
  }

  /**
   * Returns the {@link BackupEncryptionConfig} to encrypt the backup during its creation. Returns
   * <code>null</code> if no customer-managed encryption key should be used.
   */
  public BackupEncryptionConfig getEncryptionConfig() {
    return encryptionConfig;
  }

  /**
   * Returns the {@link EncryptionInfo} of the backup if the backup is encrypted, or <code>null
   * </code> if this backup is not encrypted.
   */
  public EncryptionInfo getEncryptionInfo() {
    return encryptionInfo;
  }

  /** Returns the expire time of the backup. */
  public Timestamp getExpireTime() {
    return expireTime;
  }

  /** Returns the version time of the backup. */
  public Timestamp getVersionTime() {
    return versionTime;
  }

  /** Returns the id of the database that was used to create the backup. */
  public DatabaseId getDatabase() {
    return database;
  }

  /** Returns the raw proto instance that was used to construct this {@link Backup}. */
  public @Nullable com.google.spanner.admin.database.v1.Backup getProto() {
    return proto;
  }

  /** Returns the max expire time of this {@link Backup}. */
  public Timestamp getMaxExpireTime() {
    return maxExpireTime;
  }

  /**
   * Returns the names of the destination backups being created by copying this source backup {@link
   * Backup}.
   */
  public List<String> getReferencingBackups() {
    return referencingBackups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BackupInfo that = (BackupInfo) o;
    return id.equals(that.id)
        && state == that.state
        && size == that.size
        && Objects.equals(encryptionConfig, that.encryptionConfig)
        && Objects.equals(encryptionInfo, that.encryptionInfo)
        && Objects.equals(expireTime, that.expireTime)
        && Objects.equals(versionTime, that.versionTime)
        && Objects.equals(database, that.database)
        && Objects.equals(maxExpireTime, that.maxExpireTime)
        && Objects.equals(referencingBackups, that.referencingBackups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        state,
        size,
        encryptionConfig,
        encryptionInfo,
        expireTime,
        versionTime,
        database,
        maxExpireTime,
        referencingBackups);
  }

  @Override
  public String toString() {
    return String.format(
        "Backup[%s, %s, %d, %s, %s, %s, %s, %s, %s, %s]",
        id.getName(),
        state,
        size,
        encryptionConfig,
        encryptionInfo,
        expireTime,
        versionTime,
        database,
        maxExpireTime,
        referencingBackups);
  }
}
