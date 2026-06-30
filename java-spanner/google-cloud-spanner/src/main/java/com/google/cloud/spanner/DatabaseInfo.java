/*
 * Copyright 2017 Google LLC
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

import com.google.cloud.FieldSelector;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.encryption.CustomerManagedEncryption;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.Database.State;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Represents a Cloud Spanner database. */
public class DatabaseInfo {

  /** Represent an updatable field in a Cloud Spanner database. */
  public enum DatabaseField implements FieldSelector {
    DROP_PROTECTION("enable_drop_protection");

    private final String selector;

    DatabaseField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }

    static FieldMask toFieldMask(DatabaseInfo.DatabaseField... fields) {
      FieldMask.Builder builder = FieldMask.newBuilder();
      for (DatabaseInfo.DatabaseField field : fields) {
        builder.addPaths(field.getSelector());
      }
      return builder.build();
    }
  }

  public abstract static class Builder {
    abstract Builder setState(State state);

    abstract Builder setCreateTime(Timestamp createTime);

    abstract Builder setRestoreInfo(RestoreInfo restoreInfo);

    abstract Builder setVersionRetentionPeriod(String versionRetentionPeriod);

    abstract Builder setEarliestVersionTime(Timestamp earliestVersionTime);

    /**
     * Optional for creating a new backup.
     *
     * <p>The encryption configuration to be used for the database. The only encryption, other than
     * Google's default encryption, is a customer managed encryption with a provided key. If no
     * encryption is provided, Google's default encryption will be used.
     */
    public abstract Builder setEncryptionConfig(CustomerManagedEncryption encryptionConfig);

    /**
     * The read-write region which will be used for the database's leader replicas. This can be one
     * of the values as specified in
     * https://cloud.google.com/spanner/docs/instances#available-configurations-multi-region.
     */
    public Builder setDefaultLeader(String defaultLeader) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    public Builder setDialect(Dialect dialect) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    public Builder enableDropProtection() {
      throw new UnsupportedOperationException("Unimplemented");
    }

    public Builder disableDropProtection() {
      throw new UnsupportedOperationException("Unimplemented");
    }

    protected Builder setReconciling(boolean reconciling) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    /**
     * Optional for creating a new database.
     *
     * <p>It is used by CREATE/ALTER PROTO BUNDLE statements which are part of DDL statements.
     * Contains a protobuf-serialized [google.protobuf.FileDescriptorSet]. To generate a proto
     * descriptors file run {@code protoc --include_imports
     * --descriptor_set_out=DESCRIPTOR_OUTPUT_LOCATION LOCATION-OF-PROTO-FILES}
     *
     * @param protoDescriptors The proto descriptors input as byte[] to be used for the database.
     * @return {@link Builder}
     */
    public abstract Builder setProtoDescriptors(@Nonnull byte[] protoDescriptors);

    /**
     * Optional for creating a new database.
     *
     * <p>It is used by CREATE/ALTER PROTO BUNDLE statements which are part of DDL statements.
     * Contains a protobuf-serialized [google.protobuf.FileDescriptorSet]. To generate a proto
     * descriptors file run {@code protoc --include_imports
     * --descriptor_set_out=DESCRIPTOR_OUTPUT_LOCATION LOCATION-OF-PROTO-FILES}
     *
     * @param inputStream The proto descriptors input as InputStream to be used for the database.
     * @return {@link Builder}
     * @throws IOException if there is a problem reading the underlying stream.
     */
    public abstract Builder setProtoDescriptors(@Nonnull InputStream inputStream)
        throws IOException;

    abstract Builder setProto(com.google.spanner.admin.database.v1.Database proto);

    /** Builds the database from this builder. */
    public abstract Database build();
  }

  abstract static class BuilderImpl extends Builder {
    protected final DatabaseId id;
    private State state = State.UNSPECIFIED;
    private Timestamp createTime;
    private RestoreInfo restoreInfo;
    private String versionRetentionPeriod;
    private Timestamp earliestVersionTime;
    private CustomerManagedEncryption encryptionConfig;
    private String defaultLeader;
    private Dialect dialect = Dialect.GOOGLE_STANDARD_SQL;
    private boolean dropProtectionEnabled;
    private boolean reconciling;
    private ByteString protoDescriptors;
    private com.google.spanner.admin.database.v1.Database proto;

    BuilderImpl(DatabaseId id) {
      this.id = Preconditions.checkNotNull(id);
    }

    BuilderImpl(DatabaseInfo other) {
      this.id = other.id;
      this.state = other.state;
      this.createTime = other.createTime;
      this.restoreInfo = other.restoreInfo;
      this.versionRetentionPeriod = other.versionRetentionPeriod;
      this.earliestVersionTime = other.earliestVersionTime;
      this.encryptionConfig = other.encryptionConfig;
      this.defaultLeader = other.defaultLeader;
      this.dialect = other.dialect;
      this.protoDescriptors = other.protoDescriptors;
      this.proto = other.proto;
    }

    @Override
    Builder setState(State state) {
      this.state = Preconditions.checkNotNull(state);
      return this;
    }

    @Override
    Builder setCreateTime(Timestamp createTime) {
      this.createTime = Preconditions.checkNotNull(createTime);
      return this;
    }

    @Override
    Builder setRestoreInfo(@Nullable RestoreInfo restoreInfo) {
      this.restoreInfo = restoreInfo;
      return this;
    }

    @Override
    Builder setVersionRetentionPeriod(String versionRetentionPeriod) {
      this.versionRetentionPeriod = versionRetentionPeriod;
      return this;
    }

    @Override
    Builder setEarliestVersionTime(Timestamp earliestVersionTime) {
      this.earliestVersionTime = earliestVersionTime;
      return this;
    }

    @Override
    public Builder setEncryptionConfig(@Nullable CustomerManagedEncryption encryptionConfig) {
      this.encryptionConfig = encryptionConfig;
      return this;
    }

    @Override
    public Builder setDefaultLeader(String defaultLeader) {
      this.defaultLeader = defaultLeader;
      return this;
    }

    @Override
    public Builder setDialect(Dialect dialect) {
      this.dialect = dialect;
      return this;
    }

    @Override
    public Builder enableDropProtection() {
      this.dropProtectionEnabled = true;
      return this;
    }

    @Override
    public Builder disableDropProtection() {
      this.dropProtectionEnabled = false;
      return this;
    }

    @Override
    protected Builder setReconciling(boolean reconciling) {
      this.reconciling = reconciling;
      return this;
    }

    @Override
    public Builder setProtoDescriptors(@Nonnull byte[] protoDescriptors) {
      Preconditions.checkNotNull(protoDescriptors);
      this.protoDescriptors = ByteString.copyFrom(protoDescriptors);
      return this;
    }

    @Override
    public Builder setProtoDescriptors(@Nonnull InputStream inputStream) throws IOException {
      Preconditions.checkNotNull(inputStream);
      this.protoDescriptors = ByteString.readFrom(inputStream);
      return this;
    }

    @Override
    Builder setProto(@Nullable com.google.spanner.admin.database.v1.Database proto) {
      this.proto = proto;
      return this;
    }
  }

  /** State of the database. */
  public enum State {
    // Not specified.
    UNSPECIFIED {
      @Override
      public com.google.spanner.admin.database.v1.Database.State toProto() {
        return com.google.spanner.admin.database.v1.Database.State.STATE_UNSPECIFIED;
      }
    },
    // The database is still being created and is not ready to use.
    CREATING {
      @Override
      public com.google.spanner.admin.database.v1.Database.State toProto() {
        return com.google.spanner.admin.database.v1.Database.State.CREATING;
      }
    },
    // The database is fully created and ready to use.
    READY {
      @Override
      public com.google.spanner.admin.database.v1.Database.State toProto() {
        return com.google.spanner.admin.database.v1.Database.State.READY;
      }
    },
    // The database has restored and is being optimized for use.
    READY_OPTIMIZING {
      @Override
      public com.google.spanner.admin.database.v1.Database.State toProto() {
        return com.google.spanner.admin.database.v1.Database.State.READY_OPTIMIZING;
      }
    };

    public abstract com.google.spanner.admin.database.v1.Database.State toProto();
  }

  private final DatabaseId id;
  private final State state;
  private final Timestamp createTime;
  private final RestoreInfo restoreInfo;
  private final String versionRetentionPeriod;
  private final Timestamp earliestVersionTime;
  private final CustomerManagedEncryption encryptionConfig;
  private final String defaultLeader;
  private final Dialect dialect;
  private final boolean dropProtectionEnabled;
  private final boolean reconciling;

  private final ByteString protoDescriptors;
  private final com.google.spanner.admin.database.v1.Database proto;

  public DatabaseInfo(DatabaseId id, State state) {
    this.id = id;
    this.state = state;
    this.createTime = null;
    this.restoreInfo = null;
    this.versionRetentionPeriod = null;
    this.earliestVersionTime = null;
    this.encryptionConfig = null;
    this.defaultLeader = null;
    this.dialect = null;
    this.dropProtectionEnabled = false;
    this.reconciling = false;
    this.protoDescriptors = null;
    this.proto = null;
  }

  DatabaseInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.state = builder.state;
    this.createTime = builder.createTime;
    this.restoreInfo = builder.restoreInfo;
    this.versionRetentionPeriod = builder.versionRetentionPeriod;
    this.earliestVersionTime = builder.earliestVersionTime;
    this.encryptionConfig = builder.encryptionConfig;
    this.defaultLeader = builder.defaultLeader;
    this.dialect = builder.dialect;
    this.dropProtectionEnabled = builder.dropProtectionEnabled;
    this.reconciling = builder.reconciling;
    this.protoDescriptors = builder.protoDescriptors;
    this.proto = builder.proto;
  }

  /** Returns the database id. */
  public DatabaseId getId() {
    return id;
  }

  /** Returns the state of the database. */
  public State getState() {
    return state;
  }

  /** Returns the creation time of the database. */
  public Timestamp getCreateTime() {
    return createTime;
  }

  /**
   * Returns the version retention period of the database. This is the period for which Cloud
   * Spanner retains all versions of data for the database. For instance, if set to 3 days, Cloud
   * Spanner will retain data versions that are up to 3 days old.
   */
  public String getVersionRetentionPeriod() {
    return versionRetentionPeriod;
  }

  /**
   * Returns the earliest version time of the database. This is the oldest timestamp that can be
   * used to read old versions of the data.
   */
  public Timestamp getEarliestVersionTime() {
    return earliestVersionTime;
  }

  /**
   * Returns the {@link RestoreInfo} of the database if any is available, or <code>null</code> if no
   * {@link RestoreInfo} is available for this database.
   */
  public @Nullable RestoreInfo getRestoreInfo() {
    return restoreInfo;
  }

  /**
   * Returns the {@link CustomerManagedEncryption} of the database if the database is encrypted, or
   * <code>null</code> if this database is not encrypted.
   */
  public @Nullable CustomerManagedEncryption getEncryptionConfig() {
    return encryptionConfig;
  }

  /**
   * The read-write region which contains the database's leader replicas. If this value was not
   * explicitly set during a create database or update database ddl operations, it will be {@code
   * NULL}.
   */
  public @Nullable String getDefaultLeader() {
    return defaultLeader;
  }

  /**
   * The dialect that is used by the database. It can be one of the values as specified in {@link
   * Dialect#values()}.
   */
  public @Nullable Dialect getDialect() {
    return dialect;
  }

  public boolean isDropProtectionEnabled() {
    return dropProtectionEnabled;
  }

  public boolean getReconciling() {
    return reconciling;
  }

  public ByteString getProtoDescriptors() {
    return protoDescriptors;
  }

  /** Returns the raw proto instance that was used to construct this {@link Database}. */
  public @Nullable com.google.spanner.admin.database.v1.Database getProto() {
    return proto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabaseInfo that = (DatabaseInfo) o;
    return id.equals(that.id)
        && state == that.state
        && Objects.equals(createTime, that.createTime)
        && Objects.equals(restoreInfo, that.restoreInfo)
        && Objects.equals(versionRetentionPeriod, that.versionRetentionPeriod)
        && Objects.equals(earliestVersionTime, that.earliestVersionTime)
        && Objects.equals(encryptionConfig, that.encryptionConfig)
        && Objects.equals(defaultLeader, that.defaultLeader)
        && Objects.equals(dialect, that.dialect)
        && Objects.equals(dropProtectionEnabled, that.dropProtectionEnabled)
        && Objects.equals(reconciling, that.reconciling)
        && Objects.equals(protoDescriptors, that.protoDescriptors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        state,
        createTime,
        restoreInfo,
        versionRetentionPeriod,
        earliestVersionTime,
        encryptionConfig,
        defaultLeader,
        dialect,
        dropProtectionEnabled,
        reconciling,
        protoDescriptors);
  }

  @Override
  public String toString() {
    return String.format(
        "Database[%s, %s, %s, %s, %s, %s, %s, %s, %s %s %s %s]",
        id.getName(),
        state,
        createTime,
        restoreInfo,
        versionRetentionPeriod,
        earliestVersionTime,
        encryptionConfig,
        defaultLeader,
        dialect,
        dropProtectionEnabled,
        reconciling,
        protoDescriptors);
  }
}
