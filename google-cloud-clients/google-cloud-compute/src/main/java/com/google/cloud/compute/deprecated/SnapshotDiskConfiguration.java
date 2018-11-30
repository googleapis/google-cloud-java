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
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * A Google Compute Engine disk configuration to create a disk from a Google Compute Engine
 * snapshot.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public class SnapshotDiskConfiguration extends DiskConfiguration {

  private static final long serialVersionUID = -1996055058706221049L;

  private final SnapshotId sourceSnapshot;
  private final String sourceSnapshotId;

  /** A builder for {@code SnapshotDiskConfiguration} objects. */
  public static class Builder
      extends DiskConfiguration.Builder<SnapshotDiskConfiguration, Builder> {

    private SnapshotId sourceSnapshot;
    private String sourceSnapshotId;

    private Builder(SnapshotId sourceSnapshot) {
      super(Type.SNAPSHOT);
      this.sourceSnapshot = checkNotNull(sourceSnapshot);
    }

    private Builder(SnapshotDiskConfiguration configuration) {
      super(configuration);
      this.sourceSnapshot = configuration.sourceSnapshot;
      this.sourceSnapshotId = configuration.sourceSnapshotId;
    }

    private Builder(Disk diskPb) {
      super(Type.SNAPSHOT, diskPb);
      this.sourceSnapshot = SnapshotId.fromUrl(diskPb.getSourceSnapshot());
      this.sourceSnapshotId = diskPb.getSourceSnapshotId();
    }

    /**
     * Sets the size of the persistent disk, in GB. If not set the disk will have the size of the
     * snapshot. This value can be larger than the snapshot's size. If the provided size is smaller
     * than the snapshot's size then disk creation will fail.
     *
     * @see <a href=
     *     "https://cloud.google.com/compute/docs/disks/persistent-disks#restoresnapshotlargersize">
     *     Restoring a snapshot to a larger size</a>
     */
    @Override
    public Builder setSizeGb(Long sizeGb) {
      super.setSizeGb(sizeGb);
      return this;
    }

    /** Sets the identity of the source snapshot used to create the disk. */
    public Builder setSourceSnapshot(SnapshotId sourceSnapshot) {
      this.sourceSnapshot = checkNotNull(sourceSnapshot);
      return this;
    }

    Builder setSourceSnapshotId(String sourceSnapshotId) {
      this.sourceSnapshotId = sourceSnapshotId;
      return this;
    }

    /** Creates a {@code SnapshotDiskConfiguration} object. */
    @Override
    public SnapshotDiskConfiguration build() {
      return new SnapshotDiskConfiguration(this);
    }
  }

  private SnapshotDiskConfiguration(Builder builder) {
    super(builder);
    this.sourceSnapshot = builder.sourceSnapshot;
    this.sourceSnapshotId = builder.sourceSnapshotId;
  }

  /** Returns the identity of the source snapshot used to create the disk. */
  public SnapshotId getSourceSnapshot() {
    return sourceSnapshot;
  }

  /**
   * Returns the service-generated unique id of the snapshot used to create this disk. This value
   * identifies the exact snapshot that was used to create the persistent disk. For example, if you
   * created the persistent disk from a snapshot that was later deleted and recreated under the same
   * name, the source snapshot ID would identify the exact version of the snapshot that was used.
   */
  public String getSourceSnapshotId() {
    return sourceSnapshotId;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("sourceSnapshot", sourceSnapshot)
        .add("sourceSnapshotId", sourceSnapshotId);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), sourceSnapshot, sourceSnapshotId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(SnapshotDiskConfiguration.class)
            && baseEquals((SnapshotDiskConfiguration) obj);
  }

  @Override
  SnapshotDiskConfiguration setProjectId(String projectId) {
    Builder builder = toBuilder().setSourceSnapshot(sourceSnapshot.setProjectId(projectId));
    if (getDiskType() != null) {
      builder.setDiskType(getDiskType().setProjectId(projectId));
    }
    return builder.build();
  }

  @Override
  Disk toPb() {
    return super.toPb()
        .setSourceSnapshot(sourceSnapshot.getSelfLink())
        .setSourceSnapshotId(sourceSnapshotId);
  }

  /**
   * Returns a builder for a {@code SnapshotDiskConfiguration} object given the snapshot identity.
   */
  public static Builder newBuilder(SnapshotId sourceSnapshot) {
    return new Builder(sourceSnapshot);
  }

  /** Returns a {@code SnapshotDiskConfiguration} object given the snapshot identity. */
  public static SnapshotDiskConfiguration of(SnapshotId sourceSnapshot) {
    return newBuilder(sourceSnapshot).build();
  }

  @SuppressWarnings("unchecked")
  static SnapshotDiskConfiguration fromPb(Disk diskPb) {
    return new Builder(diskPb).build();
  }
}
