/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.BackupName;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.util.Timestamps;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * A backup lets you save a copy of a table's schema and data and restore the backup to a new table
 * at a later time.
 */
public class Backup {
  public enum State {
    /** Not specified. */
    STATE_UNSPECIFIED(com.google.bigtable.admin.v2.Backup.State.STATE_UNSPECIFIED),

    /**
     * The pending backup is still being created. Operations on the backup may fail with
     * `FAILED_PRECONDITION` in this state.
     */
    CREATING(com.google.bigtable.admin.v2.Backup.State.CREATING),
    /** The backup is complete and ready for use. */
    READY(com.google.bigtable.admin.v2.Backup.State.READY),

    /** The state of the backup is not known by this client. Please upgrade your client. */
    UNRECOGNIZED(com.google.bigtable.admin.v2.Backup.State.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.Backup.State proto;

    State(com.google.bigtable.admin.v2.Backup.State proto) {
      this.proto = proto;
    }

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static Backup.State fromProto(com.google.bigtable.admin.v2.Backup.State proto) {
      for (Backup.State state : values()) {
        if (state.proto.equals(proto)) {
          return state;
        }
      }
      return STATE_UNSPECIFIED;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.Backup.State toProto() {
      return proto;
    }
  }

  @Nonnull private final com.google.bigtable.admin.v2.Backup proto;
  @Nonnull private final String id;
  @Nonnull private final String instanceId;

  @InternalApi
  public static Backup fromProto(@Nonnull com.google.bigtable.admin.v2.Backup proto) {
    return new Backup(proto);
  }

  private Backup(@Nonnull com.google.bigtable.admin.v2.Backup proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(!proto.getName().isEmpty(), "Name must be set");
    Preconditions.checkArgument(!proto.getSourceTable().isEmpty(), "Source table must be set");

    BackupName name = BackupName.parse(proto.getName());
    this.id = name.getBackup();
    this.instanceId = name.getInstance();
    this.proto = proto;
  }

  /** Get the ID of this backup. */
  public String getId() {
    return id;
  }

  /** Get the source table ID from which the backup is created. */
  public String getSourceTableId() {
    return NameUtil.extractTableIdFromTableName(proto.getSourceTable());
  }

  /** Get the instance ID where this backup is located. */
  public String getInstanceId() {
    return instanceId;
  }

  /** Get the expire time of this backup. */
  public Instant getExpireTime() {
    return Instant.ofEpochMilli(Timestamps.toMillis(proto.getExpireTime()));
  }

  /** Get the start time when this backup is taken. */
  public @Nullable Instant getStartTime() {
    if (proto.hasStartTime()) {
      return Instant.ofEpochMilli(Timestamps.toMillis(proto.getStartTime()));
    }
    return null;
  }

  /** Get the end time when the creation of this backup has completed. */
  public @Nullable Instant getEndTime() {
    if (proto.hasEndTime()) {
      return Instant.ofEpochMilli(Timestamps.toMillis(proto.getEndTime()));
    }
    return null;
  }

  /** Get the size of this backup. */
  public long getSizeBytes() {
    return proto.getSizeBytes();
  }

  /** Get the state of this backup. */
  public State getState() {
    return State.fromProto(proto.getState());
  }

  /**
   * Get the encryption information for the backup.
   *
   * <p>If encryption_type is CUSTOMER_MANAGED_ENCRYPTION, kms_key_version will be filled in with
   * status UNKNOWN.
   *
   * <p>If encryption_type is GOOGLE_DEFAULT_ENCRYPTION, all other fields will have default value.
   */
  public EncryptionInfo getEncryptionInfo() {
    return EncryptionInfo.fromProto(proto.getEncryptionInfo());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Backup backup = (Backup) o;
    return Objects.equal(proto, backup.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }
}
