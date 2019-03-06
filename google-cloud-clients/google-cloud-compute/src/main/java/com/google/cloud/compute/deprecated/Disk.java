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

import com.google.cloud.compute.deprecated.Compute.DiskOption;
import com.google.cloud.compute.deprecated.Compute.OperationOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine persistent disk. A disk can be used as primary storage for your virtual
 * machine instances. Objects of this class are immutable. To get a {@code Disk} object with the
 * most recent information use {@link #reload}. {@code Disk} adds a layer of service-related
 * functionality over {@link DiskInfo}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public class Disk extends DiskInfo {

  private static final long serialVersionUID = 7234747955588262204L;

  private final ComputeOptions options;
  private transient Compute compute;

  /** A builder for {@code Disk} objects. */
  public static class Builder extends DiskInfo.Builder {

    private final Compute compute;
    private final DiskInfo.BuilderImpl infoBuilder;

    Builder(Compute compute, DiskId diskId, DiskConfiguration diskConfiguration) {
      this.compute = compute;
      this.infoBuilder = new DiskInfo.BuilderImpl(diskId, diskConfiguration);
    }

    Builder(Disk disk) {
      this.compute = disk.compute;
      this.infoBuilder = new DiskInfo.BuilderImpl(disk);
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    public Builder setConfiguration(DiskConfiguration configuration) {
      infoBuilder.setConfiguration(configuration);
      return this;
    }

    @Override
    public Builder setDiskId(DiskId diskId) {
      infoBuilder.setDiskId(diskId);
      return this;
    }

    @Override
    Builder setCreationTimestamp(Long creationTimestamp) {
      infoBuilder.setCreationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    Builder setCreationStatus(CreationStatus creationStatus) {
      infoBuilder.setCreationStatus(creationStatus);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setLicenses(List<LicenseId> licenses) {
      infoBuilder.setLicenses(licenses);
      return this;
    }

    @Override
    Builder setAttachedInstances(List<InstanceId> attachedInstances) {
      infoBuilder.setAttachedInstances(attachedInstances);
      return this;
    }

    @Override
    Builder setLastAttachTimestamp(Long lastAttachTimestamp) {
      infoBuilder.setLastAttachTimestamp(lastAttachTimestamp);
      return this;
    }

    @Override
    Builder setLastDetachTimestamp(Long lastDetachTimestamp) {
      infoBuilder.setLastDetachTimestamp(lastDetachTimestamp);
      return this;
    }

    @Override
    public Disk build() {
      return new Disk(compute, infoBuilder);
    }
  }

  Disk(Compute compute, DiskInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.compute = checkNotNull(compute);
    this.options = compute.getOptions();
  }

  /**
   * Checks if this disk exists.
   *
   * @return {@code true} if this disk exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(DiskOption.fields()) != null;
  }

  /**
   * Fetches current disk's latest information. Returns {@code null} if the disk does not exist.
   *
   * @param options disk options
   * @return a {@code Disk} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Disk reload(DiskOption... options) {
    return compute.getDisk(getDiskId(), options);
  }

  /**
   * Deletes this disk.
   *
   * @return a zone operation if the delete request was successfully sent, {@code null} if the disk
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.deleteDisk(getDiskId(), options);
  }

  /**
   * Creates a snapshot for this disk given the snapshot's name.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  public Operation createSnapshot(String snapshot, OperationOption... options) {
    return compute.create(SnapshotInfo.of(SnapshotId.of(snapshot), getDiskId()), options);
  }

  /**
   * Creates a snapshot for this disk given the snapshot's name and description.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  public Operation createSnapshot(String snapshot, String description, OperationOption... options) {
    SnapshotInfo snapshotInfo =
        SnapshotInfo.newBuilder(SnapshotId.of(snapshot), getDiskId())
            .setDescription(description)
            .build();
    return compute.create(snapshotInfo, options);
  }

  /**
   * Creates an image for this disk given the image's name.
   *
   * @return a global operation if the image creation was successfully requested
   * @throws ComputeException upon failure
   */
  public Operation createImage(String image, OperationOption... options) {
    ImageInfo imageInfo = ImageInfo.of(ImageId.of(image), DiskImageConfiguration.of(getDiskId()));
    return compute.create(imageInfo, options);
  }

  /**
   * Creates an image for this disk given the image's name and description.
   *
   * @return a global operation if the image creation was successfully requested
   * @throws ComputeException upon failure
   */
  public Operation createImage(String image, String description, OperationOption... options) {
    ImageInfo imageInfo =
        ImageInfo.newBuilder(ImageId.of(image), DiskImageConfiguration.of(getDiskId()))
            .setDescription(description)
            .build();
    return compute.create(imageInfo, options);
  }

  /**
   * Resizes this disk to the requested size. The new size must be larger than the previous one.
   *
   * @return a zone operation if the resize request was issued correctly, {@code null} if this disk
   *     was not found
   * @throws ComputeException upon failure or if the new disk size is smaller than the previous one
   */
  public Operation resize(long sizeGb, OperationOption... options) {
    return compute.resize(getDiskId(), sizeGb, options);
  }

  /** Returns the disk's {@code Compute} object used to issue requests. */
  public Compute getCompute() {
    return compute;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Disk.class)) {
      return false;
    }
    Disk other = (Disk) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.getService();
  }

  static Disk fromPb(Compute compute, com.google.api.services.compute.model.Disk diskPb) {
    return new Disk(compute, new DiskInfo.BuilderImpl(diskPb));
  }
}
