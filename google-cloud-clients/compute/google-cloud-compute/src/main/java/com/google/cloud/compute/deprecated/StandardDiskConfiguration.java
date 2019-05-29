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
import java.util.Objects;

/**
 * A Google Compute Engine standard persistent disk configuration. This class allows users to create
 * a disk given its type and size.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public class StandardDiskConfiguration extends DiskConfiguration {

  private static final long serialVersionUID = -6974045909359567054L;

  /** A builder for {@code StandardDiskConfiguration} objects. */
  public static class Builder
      extends DiskConfiguration.Builder<StandardDiskConfiguration, Builder> {

    private Builder() {
      super(Type.STANDARD);
    }

    private Builder(StandardDiskConfiguration configuration) {
      super(configuration);
    }

    private Builder(Disk diskPb) {
      super(Type.STANDARD, diskPb);
    }

    /** Sets the size of the persistent disk, in GB. If not set, 500GB is used. */
    @Override
    public Builder setSizeGb(Long sizeGb) {
      super.setSizeGb(sizeGb);
      return this;
    }

    /** Creates a {@code StandardDiskConfiguration} object. */
    @Override
    public StandardDiskConfiguration build() {
      return new StandardDiskConfiguration(this);
    }
  }

  private StandardDiskConfiguration(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode());
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(StandardDiskConfiguration.class)
            && baseEquals((StandardDiskConfiguration) obj);
  }

  @Override
  StandardDiskConfiguration setProjectId(String projectId) {
    if (getDiskType() == null || getDiskType().getProject() != null) {
      return this;
    }
    return toBuilder().setDiskType(getDiskType().setProjectId(projectId)).build();
  }

  /** Returns a builder for a {@code StandardDiskConfiguration} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a {@code StandardDiskConfiguration} object given the disk type. */
  public static StandardDiskConfiguration of(DiskTypeId diskType) {
    return newBuilder().setDiskType(diskType).build();
  }

  /** Returns a {@code StandardDiskConfiguration} object given the disk size in GB. */
  public static StandardDiskConfiguration of(long sizeGb) {
    return newBuilder().setSizeGb(sizeGb).build();
  }

  /** Returns a {@code StandardDiskConfiguration} object given the disk type and size in GB. */
  public static StandardDiskConfiguration of(DiskTypeId diskType, long sizeGb) {
    return newBuilder().setDiskType(diskType).setSizeGb(sizeGb).build();
  }

  @SuppressWarnings("unchecked")
  static StandardDiskConfiguration fromPb(Disk diskPb) {
    return new Builder(diskPb).build();
  }
}
