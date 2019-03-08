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

import com.google.api.services.compute.model.Disk;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A Google Compute Engine persistent disk. A disk can be used as primary storage for your virtual
 * machine instances.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public class DiskInfo implements Serializable {

  static final Function<Disk, DiskInfo> FROM_PB_FUNCTION =
      new Function<Disk, DiskInfo>() {
        @Override
        public DiskInfo apply(Disk pb) {
          return DiskInfo.fromPb(pb);
        }
      };
  static final Function<DiskInfo, Disk> TO_PB_FUNCTION =
      new Function<DiskInfo, Disk>() {
        @Override
        public Disk apply(DiskInfo diskType) {
          return diskType.toPb();
        }
      };

  private static final long serialVersionUID = -7173418340679279619L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);

  private final String generatedId;
  private final DiskId diskId;
  private final DiskConfiguration configuration;
  private final Long creationTimestamp;
  private final CreationStatus creationStatus;
  private final String description;
  private final List<LicenseId> licenses;
  private final List<InstanceId> attachedInstances;
  private final Long lastAttachTimestamp;
  private final Long lastDetachTimestamp;

  /** The status of disk creation. */
  public enum CreationStatus {
    /** The disk is being created. */
    CREATING,

    /** Disk creation failed. */
    FAILED,

    /** The disk has been created and is ready to use. */
    READY,

    /** The disk is being restored. */
    RESTORING
  }

  /** Builder for {@code DiskInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    /** Sets the disk configuration. */
    public abstract Builder setConfiguration(DiskConfiguration configuration);

    /** Sets the disk identity. */
    public abstract Builder setDiskId(DiskId diskId);

    abstract Builder setCreationTimestamp(Long creationTimestamp);

    abstract Builder setCreationStatus(CreationStatus creationStatus);

    /** Sets an optional textual description of the resource. */
    public abstract Builder setDescription(String description);

    abstract Builder setLicenses(List<LicenseId> licenses);

    abstract Builder setAttachedInstances(List<InstanceId> attachedInstances);

    abstract Builder setLastAttachTimestamp(Long lastAttachTimestamp);

    abstract Builder setLastDetachTimestamp(Long lastDetachTimestamp);

    /** Creates a {@code DiskInfo} object. */
    public abstract DiskInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private DiskId diskId;
    private DiskConfiguration configuration;
    private Long creationTimestamp;
    private CreationStatus creationStatus;
    private String description;
    private List<LicenseId> licenses;
    private List<InstanceId> attachedInstances;
    private Long lastAttachTimestamp;
    private Long lastDetachTimestamp;

    BuilderImpl(DiskId diskId, DiskConfiguration configuration) {
      this.diskId = checkNotNull(diskId);
      this.configuration = checkNotNull(configuration);
    }

    BuilderImpl(DiskInfo diskInfo) {
      this.generatedId = diskInfo.generatedId;
      this.configuration = diskInfo.configuration;
      this.creationTimestamp = diskInfo.creationTimestamp;
      this.creationStatus = diskInfo.creationStatus;
      this.diskId = diskInfo.diskId;
      this.description = diskInfo.description;
      this.licenses = diskInfo.licenses;
      this.attachedInstances = diskInfo.attachedInstances;
      this.lastAttachTimestamp = diskInfo.lastAttachTimestamp;
      this.lastDetachTimestamp = diskInfo.lastDetachTimestamp;
    }

    BuilderImpl(Disk diskPb) {
      if (diskPb.getId() != null) {
        this.generatedId = diskPb.getId().toString();
      }
      this.configuration = DiskConfiguration.fromPb(diskPb);
      if (diskPb.getCreationTimestamp() != null) {
        this.creationTimestamp =
            TIMESTAMP_FORMATTER.parse(diskPb.getCreationTimestamp(), Instant.FROM).toEpochMilli();
      }
      if (diskPb.getStatus() != null) {
        this.creationStatus = CreationStatus.valueOf(diskPb.getStatus());
      }
      this.diskId = DiskId.fromUrl(diskPb.getSelfLink());
      this.description = diskPb.getDescription();
      if (diskPb.getLicenses() != null) {
        this.licenses = Lists.transform(diskPb.getLicenses(), LicenseId.FROM_URL_FUNCTION);
      }
      if (diskPb.getUsers() != null) {
        this.attachedInstances = Lists.transform(diskPb.getUsers(), InstanceId.FROM_URL_FUNCTION);
      }
      if (diskPb.getLastAttachTimestamp() != null) {
        this.lastAttachTimestamp =
            TIMESTAMP_FORMATTER.parse(diskPb.getLastAttachTimestamp(), Instant.FROM).toEpochMilli();
      }
      if (diskPb.getLastDetachTimestamp() != null) {
        this.lastDetachTimestamp =
            TIMESTAMP_FORMATTER.parse(diskPb.getLastDetachTimestamp(), Instant.FROM).toEpochMilli();
      }
    }

    @Override
    BuilderImpl setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    public BuilderImpl setConfiguration(DiskConfiguration configuration) {
      this.configuration = checkNotNull(configuration);
      return this;
    }

    @Override
    public BuilderImpl setDiskId(DiskId diskId) {
      this.diskId = checkNotNull(diskId);
      return this;
    }

    @Override
    BuilderImpl setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    BuilderImpl setCreationStatus(CreationStatus creationStatus) {
      this.creationStatus = creationStatus;
      return this;
    }

    @Override
    public BuilderImpl setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    BuilderImpl setLicenses(List<LicenseId> licenses) {
      this.licenses = licenses != null ? ImmutableList.copyOf(licenses) : null;
      return this;
    }

    @Override
    BuilderImpl setAttachedInstances(List<InstanceId> attachedInstances) {
      this.attachedInstances =
          attachedInstances != null ? ImmutableList.copyOf(attachedInstances) : null;
      return this;
    }

    @Override
    BuilderImpl setLastAttachTimestamp(Long lastAttachTimestamp) {
      this.lastAttachTimestamp = lastAttachTimestamp;
      return this;
    }

    @Override
    BuilderImpl setLastDetachTimestamp(Long lastDetachTimestamp) {
      this.lastDetachTimestamp = lastDetachTimestamp;
      return this;
    }

    @Override
    public DiskInfo build() {
      return new DiskInfo(this);
    }
  }

  DiskInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.configuration = builder.configuration;
    this.creationTimestamp = builder.creationTimestamp;
    this.creationStatus = builder.creationStatus;
    this.diskId = builder.diskId;
    this.description = builder.description;
    this.licenses = builder.licenses;
    this.attachedInstances = builder.attachedInstances;
    this.lastAttachTimestamp = builder.lastAttachTimestamp;
    this.lastDetachTimestamp = builder.lastDetachTimestamp;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns the service-generated unique identifier for the disk. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the disk configuration. */
  @SuppressWarnings("unchecked")
  public <T extends DiskConfiguration> T getConfiguration() {
    return (T) configuration;
  }

  /** Returns the disk identity. */
  public DiskId getDiskId() {
    return diskId;
  }

  /** Returns the creation status of the disk. */
  public CreationStatus getCreationStatus() {
    return creationStatus;
  }

  /** Returns a textual description of the disk. */
  public String getDescription() {
    return description;
  }

  /** Returns all applicable publicly visible licenses for the disk. */
  public List<LicenseId> getLicenses() {
    return licenses;
  }

  /** Returns all the identities of the instances this disk is attached to. */
  public List<InstanceId> getAttachedInstances() {
    return attachedInstances;
  }

  /** Returns the last attach timestamp in milliseconds since epoch. */
  public Long getLastAttachTimestamp() {
    return lastAttachTimestamp;
  }

  /** Returns the last detach timestamp in milliseconds since epoch. */
  public Long getLastDetachTimestamp() {
    return lastDetachTimestamp;
  }

  /** Returns a builder for the object. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("diskId", diskId)
        .add("configuration", configuration)
        .add("creationTimestamp", creationTimestamp)
        .add("creationStatus", creationStatus)
        .add("description", description)
        .add("licenses", licenses)
        .add("attachedInstances", attachedInstances)
        .add("lastAttachTimestamp", lastAttachTimestamp)
        .add("lastDetachTimestamp", lastDetachTimestamp)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        diskId,
        configuration,
        creationTimestamp,
        creationStatus,
        description,
        licenses,
        attachedInstances,
        lastAttachTimestamp,
        lastDetachTimestamp);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(DiskInfo.class)
            && Objects.equals(toPb(), ((DiskInfo) obj).toPb());
  }

  /**
   * Returns a builder for a {@code DiskInfo} object given its identity and configuration. Use
   * {@link StandardDiskConfiguration} to create a simple disk given its type and size. Use {@link
   * SnapshotDiskConfiguration} to create a disk from a snapshot. Use {@link ImageDiskConfiguration}
   * to create a disk from a disk image.
   */
  public static Builder newBuilder(DiskId diskId, DiskConfiguration configuration) {
    return new BuilderImpl(diskId, configuration);
  }

  /**
   * Returns a {@code DiskInfo} object given its identity and configuration. Use {@link
   * StandardDiskConfiguration} to create a simple disk given its type and size. Use {@link
   * SnapshotDiskConfiguration} to create a disk from a snapshot. Use {@link ImageDiskConfiguration}
   * to create a disk from a disk image.
   */
  public static DiskInfo of(DiskId diskId, DiskConfiguration configuration) {
    return newBuilder(diskId, configuration).build();
  }

  DiskInfo setProjectId(String projectId) {
    return toBuilder()
        .setDiskId(diskId.setProjectId(projectId))
        .setConfiguration(configuration.setProjectId(projectId))
        .build();
  }

  Disk toPb() {
    Disk diskPb = configuration.toPb();
    if (generatedId != null) {
      diskPb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      diskPb.setCreationTimestamp(
          TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(creationTimestamp)));
    }
    diskPb.setZone(diskId.getZoneId().getSelfLink());
    if (creationStatus != null) {
      diskPb.setStatus(creationStatus.toString());
    }
    diskPb.setName(diskId.getDisk());
    diskPb.setDescription(description);
    diskPb.setSelfLink(diskId.getSelfLink());
    if (licenses != null) {
      diskPb.setLicenses(Lists.transform(licenses, LicenseId.TO_URL_FUNCTION));
    }
    if (attachedInstances != null) {
      diskPb.setUsers(Lists.transform(attachedInstances, InstanceId.TO_URL_FUNCTION));
    }
    if (lastAttachTimestamp != null) {
      diskPb.setLastAttachTimestamp(
          TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(lastAttachTimestamp)));
    }
    if (lastDetachTimestamp != null) {
      diskPb.setLastDetachTimestamp(
          TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(lastDetachTimestamp)));
    }
    return diskPb;
  }

  static DiskInfo fromPb(Disk diskPb) {
    return new BuilderImpl(diskPb).build();
  }
}
