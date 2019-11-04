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

import com.google.api.services.compute.model.Disk;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Google Compute Engine disk configurations. A disk can be used as primary storage
 * for your virtual machine instances. Use {@link StandardDiskConfiguration} to create a standard
 * disk given a disk type and size. Use {@link ImageDiskConfiguration} to create a disk from a
 * Compute Engine disk image. Use {@link SnapshotDiskConfiguration} to create a disk from a Compute
 * Engine disk snapshot.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public abstract class DiskConfiguration implements Serializable {

  private static final long serialVersionUID = -1783061701255428417L;

  private final Type type;
  private final Long sizeGb;
  private final DiskTypeId diskType;

  /** Type of a Google Compute Engine disk configuration. */
  public enum Type {
    /** A Google Compute Engine standard disk configuration. */
    STANDARD,

    /** A Google Compute Engine disk configuration that creates a disk from an image. */
    IMAGE,

    /** A Google Compute Engine disk configuration that creates a disk from a snapshot. */
    SNAPSHOT
  }

  /**
   * Base builder for disk configurations.
   *
   * @param <T> the disk configuration type
   * @param <B> the disk configuration builder
   */
  public abstract static class Builder<T extends DiskConfiguration, B extends Builder<T, B>> {

    private Type type;
    private Long sizeGb;
    private DiskTypeId diskType;

    Builder(Type type) {
      this.type = type;
    }

    Builder(DiskConfiguration diskConfiguration) {
      this.type = diskConfiguration.type;
      this.sizeGb = diskConfiguration.sizeGb;
      this.diskType = diskConfiguration.diskType;
    }

    Builder(Type type, Disk diskPb) {
      this.type = type;
      this.sizeGb = diskPb.getSizeGb();
      if (diskPb.getType() != null) {
        this.diskType = DiskTypeId.fromUrl(diskPb.getType());
      }
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    B setType(Type type) {
      this.type = type;
      return self();
    }

    /** Sets the size of the persistent disk, in GB. */
    public B setSizeGb(Long sizeGb) {
      this.sizeGb = sizeGb;
      return self();
    }

    /** Sets the identity of the disk type. If not set {@code pd-standard} will be used. */
    public B setDiskType(DiskTypeId diskType) {
      this.diskType = diskType;
      return self();
    }

    /** Creates an object. */
    public abstract T build();
  }

  DiskConfiguration(Builder builder) {
    this.type = builder.type;
    this.sizeGb = builder.sizeGb;
    this.diskType = builder.diskType;
  }

  /**
   * Returns the disk configuration's type. This method returns {@link Type#STANDARD} for a standard
   * configuration that creates a disk given its type and size. This method returns {@link
   * Type#SNAPSHOT} for a configuration that creates a disk from a Google Compute Engine snapshot.
   * This method returns {@link Type#IMAGE} for a configuration that creates a disk from a Google
   * Compute Engine image.
   */
  public Type getType() {
    return type;
  }

  /** Returns the size of the persistent disk, in GB. */
  public Long getSizeGb() {
    return sizeGb;
  }

  /** Returns the identity of the disk type. */
  public DiskTypeId getDiskType() {
    return diskType;
  }

  /** Returns a builder for the object. */
  public abstract Builder toBuilder();

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("sizeGb", sizeGb)
        .add("diskType", diskType);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(type, sizeGb, diskType);
  }

  final boolean baseEquals(DiskConfiguration diskConfiguration) {
    return diskConfiguration != null
        && getClass().equals(diskConfiguration.getClass())
        && Objects.equals(toPb(), diskConfiguration.toPb());
  }

  abstract DiskConfiguration setProjectId(String projectId);

  Disk toPb() {
    Disk diskPb = new Disk();
    diskPb.setSizeGb(sizeGb);
    if (diskType != null) {
      diskPb.setType(diskType.getSelfLink());
    }
    return diskPb;
  }

  @SuppressWarnings("unchecked")
  static <T extends DiskConfiguration> T fromPb(Disk diskPb) {
    if (diskPb.getSourceImage() != null) {
      return (T) ImageDiskConfiguration.fromPb(diskPb);
    } else if (diskPb.getSourceSnapshot() != null) {
      return (T) SnapshotDiskConfiguration.fromPb(diskPb);
    }
    return (T) StandardDiskConfiguration.fromPb(diskPb);
  }
}
