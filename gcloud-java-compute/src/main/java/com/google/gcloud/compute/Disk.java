/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gcloud.compute.Compute.DiskOption;
import com.google.gcloud.compute.Compute.OperationOption;

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

  /**
   * A builder for {@code Disk} objects.
   */
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
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    public Builder configuration(DiskConfiguration configuration) {
      infoBuilder.configuration(configuration);
      return this;
    }

    @Override
    public Builder diskId(DiskId diskId) {
      infoBuilder.diskId(diskId);
      return this;
    }

    @Override
    Builder creationTimestamp(Long creationTimestamp) {
      infoBuilder.creationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    Builder creationStatus(CreationStatus creationStatus) {
      infoBuilder.creationStatus(creationStatus);
      return this;
    }

    @Override
    public Builder description(String description) {
      infoBuilder.description(description);
      return this;
    }

    @Override
    Builder licenses(List<LicenseId> licenses) {
      infoBuilder.licenses(licenses);
      return this;
    }

    @Override
    Builder attachedInstances(List<InstanceId> attachedInstances) {
      infoBuilder.attachedInstances(attachedInstances);
      return this;
    }

    @Override
    Builder lastAttachTimestamp(Long lastAttachTimestamp) {
      infoBuilder.lastAttachTimestamp(lastAttachTimestamp);
      return this;
    }

    @Override
    Builder lastDetachTimestamp(Long lastDetachTimestamp) {
      infoBuilder.lastDetachTimestamp(lastDetachTimestamp);
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
    this.options = compute.options();
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
    return compute.get(diskId(), options);
  }

  /**
   * Deletes this disk.
   *
   * @return a zone operation if the delete request was successfully sent, {@code null} if the disk
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.delete(diskId(), options);
  }

  /**
   * Creates a snapshot for this disk given the snapshot's name.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  public Operation createSnapshot(String snapshot, OperationOption... options) {
    return compute.create(SnapshotInfo.of(SnapshotId.of(snapshot), diskId()), options);
  }

  /**
   * Creates a snapshot for this disk given the snapshot's name and description.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  public Operation createSnapshot(String snapshot, String description, OperationOption... options) {
    SnapshotInfo snapshotInfo = SnapshotInfo.builder(SnapshotId.of(snapshot), diskId())
        .description(description)
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
    ImageInfo imageInfo = ImageInfo.of(ImageId.of(image), DiskImageConfiguration.of(diskId()));
    return compute.create(imageInfo, options);
  }

  /**
   * Creates an image for this disk given the image's name and description.
   *
   * @return a global operation if the image creation was successfully requested
   * @throws ComputeException upon failure
   */
  public Operation createImage(String image, String description, OperationOption... options) {
    ImageInfo imageInfo = ImageInfo.builder(ImageId.of(image), DiskImageConfiguration.of(diskId()))
        .description(description)
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
    return compute.resize(diskId(), sizeGb, options);
  }

  /**
   * Returns the disk's {@code Compute} object used to issue requests.
   */
  public Compute compute() {
    return compute;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj instanceof Disk
        && Objects.equals(toPb(), ((Disk) obj).toPb())
        && Objects.equals(options, ((Disk) obj).options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.service();
  }

  static Disk fromPb(Compute compute, com.google.api.services.compute.model.Disk diskPb) {
    return new Disk(compute, new DiskInfo.BuilderImpl(diskPb));
  }
}
