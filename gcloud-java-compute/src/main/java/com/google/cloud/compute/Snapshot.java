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

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.compute.Compute.OperationOption;
import com.google.cloud.compute.Compute.SnapshotOption;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine snapshot. Compute Engine allows you to take snapshots of your persistent
 * disk and create new persistent disks from that snapshot. This can be useful for backing up data,
 * recreating a persistent disk that might have been lost, or copying a persistent disk. Snapshots
 * can be applied across persistent disk types. {@code Snapshot} adds a layer of service-related
 * functionality over {@link SnapshotInfo}. Objects of this class are immutable; to get a
 * {@code Snapshot} object with the most recent information use {@link #reload}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/persistent-disks#snapshots">Use
 *     persistent disk snapshots</a>
 */
public class Snapshot extends SnapshotInfo {

  private static final long serialVersionUID = -973924811396336695L;

  private final ComputeOptions options;
  private transient Compute compute;

  /**
   * A builder for {@code Snapshot} objects.
   */
  public static class Builder extends SnapshotInfo.Builder {

    private final Compute compute;
    private final SnapshotInfo.BuilderImpl infoBuilder;

    Builder(Compute compute, SnapshotId snapshotId, DiskId sourceDisk) {
      this.compute = compute;
      this.infoBuilder = new SnapshotInfo.BuilderImpl();
      this.infoBuilder.snapshotId(snapshotId);
      this.infoBuilder.sourceDisk(sourceDisk);
    }

    Builder(Snapshot snapshot) {
      this.compute = snapshot.compute;
      this.infoBuilder = new SnapshotInfo.BuilderImpl(snapshot);
    }

    @Override
    Builder generatedId(String generatedId) {
      infoBuilder.generatedId(generatedId);
      return this;
    }

    @Override
    Builder creationTimestamp(Long creationTimestamp) {
      infoBuilder.creationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    public Builder snapshotId(SnapshotId snapshotId) {
      infoBuilder.snapshotId(snapshotId);
      return this;
    }

    @Override
    public Builder description(String description) {
      infoBuilder.description(description);
      return this;
    }

    @Override
    Builder status(Status status) {
      infoBuilder.status(status);
      return this;
    }

    @Override
    Builder diskSizeGb(Long diskSizeGb) {
      infoBuilder.diskSizeGb(diskSizeGb);
      return this;
    }

    @Override
    Builder licenses(List<LicenseId> licenses) {
      infoBuilder.licenses(licenses);
      return this;
    }

    @Override
    public Builder sourceDisk(DiskId sourceDisk) {
      infoBuilder.sourceDisk(sourceDisk);
      return this;
    }

    @Override
    Builder sourceDiskId(String sourceDiskId) {
      infoBuilder.sourceDiskId(sourceDiskId);
      return this;
    }

    @Override
    Builder storageBytes(Long storageBytes) {
      infoBuilder.storageBytes(storageBytes);
      return this;
    }

    @Override
    Builder storageBytesStatus(StorageBytesStatus storageBytesStatus) {
      infoBuilder.storageBytesStatus(storageBytesStatus);
      return this;
    }

    @Override
    public Snapshot build() {
      return new Snapshot(compute, infoBuilder);
    }
  }

  Snapshot(Compute compute, SnapshotInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.compute = checkNotNull(compute);
    this.options = compute.options();
  }

  /**
   * Checks if this snapshot exists.
   *
   * @return {@code true} if this snapshot exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(SnapshotOption.fields()) != null;
  }

  /**
   * Fetches current snapshot's latest information. Returns {@code null} if the snapshot does not
   * exist.
   *
   * @param options snapshot options
   * @return a {@code Snapshot} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Snapshot reload(SnapshotOption... options) {
    return compute.getSnapshot(snapshotId().snapshot(), options);
  }

  /**
   * Deletes this snapshot.
   *
   * @return a global operation if delete request was successfully sent, {@code null} if the
   *     snapshot was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.deleteSnapshot(snapshotId(), options);
  }

  /**
   * Returns the snapshot's {@code Compute} object used to issue requests.
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
    return obj instanceof Snapshot
        && Objects.equals(toPb(), ((Snapshot) obj).toPb())
        && Objects.equals(options, ((Snapshot) obj).options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.service();
  }

  static Snapshot fromPb(Compute compute,
        com.google.api.services.compute.model.Snapshot snapshotPb) {
    return new Snapshot(compute, new SnapshotInfo.BuilderImpl(snapshotPb));
  }
}
