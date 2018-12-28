/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.compute.model.Snapshot;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * A Google Compute Engine snapshot. Compute Engine allows you to take snapshots of your persistent
 * disk and create new persistent disks from that snapshot. This can be useful for backing up data,
 * recreating a persistent disk that might have been lost, or copying a persistent disk. Snapshots
 * can be applied across persistent disk types.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/persistent-disks#snapshots">Use
 *     persistent disk snapshots</a>
 */
public class SnapshotInfo implements Serializable {

  static final Function<Snapshot, SnapshotInfo> FROM_PB_FUNCTION =
      new Function<Snapshot, SnapshotInfo>() {
        @Override
        public SnapshotInfo apply(Snapshot pb) {
          return SnapshotInfo.fromPb(pb);
        }
      };
  static final Function<SnapshotInfo, Snapshot> TO_PB_FUNCTION =
      new Function<SnapshotInfo, Snapshot>() {
        @Override
        public Snapshot apply(SnapshotInfo snapshot) {
          return snapshot.toPb();
        }
      };

  private static final long serialVersionUID = 1065513502131159769L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final String generatedId;
  private final SnapshotId snapshotId;
  private final Long creationTimestamp;
  private final String description;
  private final Status status;
  private final Long diskSizeGb;
  private final List<LicenseId> licenses;
  private final DiskId sourceDisk;
  private final String sourceDiskId;
  private final Long storageBytes;
  private final StorageBytesStatus storageBytesStatus;

  /**
   * The status of a Google Compute Engine snapshot. A snapshot can be used to create a disk only
   * after the snapshot has been successfully created and the status is set to {@code READY}.
   */
  public enum Status {
    /** The snapshot is being created. */
    CREATING,

    /** The snapshot is being deleted. */
    DELETING,

    /** Snapshot's creation failed. */
    FAILED,

    /** Snapshot has been successfully created. */
    READY,

    /** Snapshot is being uploaded. */
    UPLOADING
  }

  /**
   * An indicator of whether {@link SnapshotInfo#getStorageBytes()} is in a stable state or it is
   * being adjusted as a result of shared storage reallocation.
   */
  public enum StorageBytesStatus {
    /** Indicates that the size of the snapshot is being updated. */
    UPDATING,

    /** Indicates that the size of the snapshot is up-to-date. */
    UP_TO_DATE
  }

  /** A builder for {@code SnapshotInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setCreationTimestamp(Long creationTimestamp);

    /** Sets the snapshot identity. */
    public abstract Builder setSnapshotId(SnapshotId snapshotId);

    /** Sets an optional textual description of the snapshot. */
    public abstract Builder setDescription(String description);

    abstract Builder setStatus(Status status);

    abstract Builder setDiskSizeGb(Long diskSizeGb);

    abstract Builder setLicenses(List<LicenseId> licenses);

    /** Sets the identity of the source disk used to create the snapshot. */
    public abstract Builder setSourceDisk(DiskId sourceDisk);

    abstract Builder setSourceDiskId(String sourceDiskId);

    abstract Builder setStorageBytes(Long storageBytes);

    abstract Builder setStorageBytesStatus(StorageBytesStatus storageBytesStatus);

    /** Creates a {@code SnapshotInfo} object. */
    public abstract SnapshotInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private Long creationTimestamp;
    private SnapshotId snapshotId;
    private String description;
    private Status status;
    private Long diskSizeGb;
    private List<LicenseId> licenses;
    private DiskId sourceDisk;
    private String sourceDiskId;
    private Long storageBytes;
    private StorageBytesStatus storageBytesStatus;

    BuilderImpl() {}

    BuilderImpl(SnapshotInfo snapshotInfo) {
      this.generatedId = snapshotInfo.generatedId;
      this.creationTimestamp = snapshotInfo.creationTimestamp;
      this.snapshotId = snapshotInfo.snapshotId;
      this.description = snapshotInfo.description;
      this.status = snapshotInfo.status;
      this.diskSizeGb = snapshotInfo.diskSizeGb;
      this.licenses = snapshotInfo.licenses;
      this.sourceDisk = snapshotInfo.sourceDisk;
      this.sourceDiskId = snapshotInfo.sourceDiskId;
      this.storageBytes = snapshotInfo.storageBytes;
      this.storageBytesStatus = snapshotInfo.storageBytesStatus;
    }

    BuilderImpl(Snapshot snapshotPb) {
      if (snapshotPb.getId() != null) {
        this.generatedId = snapshotPb.getId().toString();
      }
      if (snapshotPb.getCreationTimestamp() != null) {
        this.creationTimestamp = TIMESTAMP_FORMATTER.parseMillis(snapshotPb.getCreationTimestamp());
      }
      this.snapshotId = SnapshotId.fromUrl(snapshotPb.getSelfLink());
      this.description = snapshotPb.getDescription();
      if (snapshotPb.getStatus() != null) {
        this.status = Status.valueOf(snapshotPb.getStatus());
      }
      this.diskSizeGb = snapshotPb.getDiskSizeGb();
      if (snapshotPb.getLicenses() != null) {
        this.licenses = Lists.transform(snapshotPb.getLicenses(), LicenseId.FROM_URL_FUNCTION);
      }
      if (snapshotPb.getSourceDisk() != null) {
        this.sourceDisk = DiskId.fromUrl(snapshotPb.getSourceDisk());
      }
      this.sourceDiskId = snapshotPb.getSourceDiskId();
      this.storageBytes = snapshotPb.getStorageBytes();
      if (snapshotPb.getStorageBytesStatus() != null) {
        this.storageBytesStatus = StorageBytesStatus.valueOf(snapshotPb.getStorageBytesStatus());
      }
    }

    @Override
    BuilderImpl setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    BuilderImpl setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    public BuilderImpl setSnapshotId(SnapshotId snapshotId) {
      this.snapshotId = checkNotNull(snapshotId);
      return this;
    }

    @Override
    public BuilderImpl setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    BuilderImpl setStatus(Status status) {
      this.status = status;
      return this;
    }

    @Override
    BuilderImpl setDiskSizeGb(Long diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    @Override
    BuilderImpl setLicenses(List<LicenseId> licenses) {
      this.licenses = licenses != null ? ImmutableList.copyOf(licenses) : null;
      return this;
    }

    @Override
    public BuilderImpl setSourceDisk(DiskId sourceDisk) {
      this.sourceDisk = checkNotNull(sourceDisk);
      return this;
    }

    @Override
    BuilderImpl setSourceDiskId(String sourceDiskId) {
      this.sourceDiskId = sourceDiskId;
      return this;
    }

    @Override
    BuilderImpl setStorageBytes(Long storageBytes) {
      this.storageBytes = storageBytes;
      return this;
    }

    @Override
    BuilderImpl setStorageBytesStatus(StorageBytesStatus storageBytesStatus) {
      this.storageBytesStatus = storageBytesStatus;
      return this;
    }

    @Override
    public SnapshotInfo build() {
      return new SnapshotInfo(this);
    }
  }

  SnapshotInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.snapshotId = checkNotNull(builder.snapshotId);
    this.description = builder.description;
    this.status = builder.status;
    this.diskSizeGb = builder.diskSizeGb;
    this.licenses = builder.licenses;
    this.sourceDisk = builder.sourceDisk;
    this.sourceDiskId = builder.sourceDiskId;
    this.storageBytes = builder.storageBytes;
    this.storageBytesStatus = builder.storageBytesStatus;
  }

  /** Returns the service-generated unique identifier for the snapshot. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns the snapshot identity. */
  public SnapshotId getSnapshotId() {
    return snapshotId;
  }

  /** Returns a textual description of the snapshot. */
  public String getDescription() {
    return description;
  }

  /** Returns all applicable publicly visible licenses. */
  public List<LicenseId> getLicenses() {
    return licenses;
  }

  /**
   * Returns the status of the snapshot. A snapshot can be used to create other resources, such as
   * disks, only after the snapshot has been successfully created and the status is set to {@code
   * READY}.
   */
  public Status getStatus() {
    return status;
  }

  /** Returns the size of the snapshot (in GB). */
  public Long getDiskSizeGb() {
    return diskSizeGb;
  }

  /** Returns the identity of the source disk used to create this snapshot. */
  public DiskId getSourceDisk() {
    return sourceDisk;
  }

  /**
   * Returns the service-generated unique id of the disk used to create this snapshot. This value
   * may be used to determine whether the snapshot was taken from the current or a previous instance
   * of a given disk name.
   */
  public String getSourceDiskId() {
    return sourceDiskId;
  }

  /**
   * Returns the size of the the storage used by the snapshot. As snapshots share storage, this
   * number is expected to change with snapshot creation/deletion.
   */
  public Long getStorageBytes() {
    return storageBytes;
  }

  /**
   * Indicates whether {@link SnapshotInfo#getStorageBytes()} is in a stable state or it is being
   * adjusted as a result of shared storage reallocation. {@link StorageBytesStatus#UPDATING}
   * indicates that the size of the snapshot is being updated. {@link StorageBytesStatus#UP_TO_DATE}
   * indicates that the size of the snapshot is up-to-date.
   */
  public StorageBytesStatus getStorageBytesStatus() {
    return storageBytesStatus;
  }

  /** Returns a builder for the current snapshot. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("snapshotId", snapshotId)
        .add("description", description)
        .add("status", status)
        .add("diskSizeGb", diskSizeGb)
        .add("licenses", licenses)
        .add("sourceDisk", sourceDisk)
        .add("sourceDiskId", sourceDiskId)
        .add("storageBytes", storageBytes)
        .add("storageBytesStatus", storageBytesStatus)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        generatedId,
        creationTimestamp,
        snapshotId,
        description,
        status,
        diskSizeGb,
        licenses,
        sourceDisk,
        sourceDiskId,
        storageBytes,
        storageBytesStatus);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(SnapshotInfo.class)
            && Objects.equals(toPb(), ((SnapshotInfo) obj).toPb());
  }

  SnapshotInfo setProjectId(String projectId) {
    return toBuilder()
        .setSnapshotId(snapshotId.setProjectId(projectId))
        .setSourceDisk(sourceDisk.setProjectId(projectId))
        .build();
  }

  Snapshot toPb() {
    Snapshot snapshotPb = new Snapshot();
    if (generatedId != null) {
      snapshotPb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      snapshotPb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    snapshotPb.setName(snapshotId.getSnapshot());
    snapshotPb.setDescription(description);
    snapshotPb.setSelfLink(snapshotId.getSelfLink());
    if (status != null) {
      snapshotPb.setStatus(status.name());
    }
    snapshotPb.setDiskSizeGb(diskSizeGb);
    if (licenses != null) {
      snapshotPb.setLicenses(Lists.transform(licenses, LicenseId.TO_URL_FUNCTION));
    }
    if (sourceDisk != null) {
      snapshotPb.setSourceDisk(sourceDisk.getSelfLink());
    }
    snapshotPb.setSourceDiskId(sourceDiskId);
    snapshotPb.setStorageBytes(storageBytes);
    if (storageBytesStatus != null) {
      snapshotPb.setStorageBytesStatus(storageBytesStatus.name());
    }
    return snapshotPb;
  }

  /**
   * Returns a builder for a {@code SnapshotInfo} object given the snapshot identity and a source
   * disk identity.
   */
  public static Builder newBuilder(SnapshotId snapshotId, DiskId source) {
    return new BuilderImpl().setSnapshotId(snapshotId).setSourceDisk(source);
  }

  /**
   * Returns a {@code SnapshotInfo} object given the snapshot identity and a source disk identity.
   */
  public static SnapshotInfo of(SnapshotId snapshotId, DiskId source) {
    return newBuilder(snapshotId, source).build();
  }

  static SnapshotInfo fromPb(Snapshot snapshotPb) {
    return new BuilderImpl(snapshotPb).build();
  }
}
