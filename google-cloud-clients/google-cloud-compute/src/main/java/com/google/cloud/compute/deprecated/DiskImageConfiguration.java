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

import com.google.api.services.compute.model.Image;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * A Google Compute Engine disk image configuration. This class can be used to create images from an
 * existing Google Compute Engine disk.
 */
public class DiskImageConfiguration extends ImageConfiguration {

  private static final long serialVersionUID = 2716403667042981170L;

  private final DiskId sourceDisk;
  private final String sourceDiskId;

  /** A builder for {@code DiskImageConfiguration} objects. */
  public static final class Builder
      extends ImageConfiguration.Builder<DiskImageConfiguration, Builder> {

    private DiskId sourceDisk;
    private String sourceDiskId;

    private Builder() {
      super(Type.DISK);
    }

    private Builder(DiskImageConfiguration imageConfiguration) {
      super(imageConfiguration);
      this.sourceDisk = imageConfiguration.sourceDisk;
      this.sourceDiskId = imageConfiguration.sourceDiskId;
    }

    private Builder(Image imagePb) {
      super(Type.DISK, imagePb);
      this.sourceDisk = DiskId.fromUrl(imagePb.getSourceDisk());
      this.sourceDiskId = imagePb.getSourceDiskId();
    }

    /** Sets the identity of the source disk used to create the image. */
    public Builder setSourceDisk(DiskId sourceDisk) {
      this.sourceDisk = checkNotNull(sourceDisk);
      return this;
    }

    Builder setSourceDiskId(String sourceDiskId) {
      this.sourceDiskId = sourceDiskId;
      return this;
    }

    /** Creates a {@code DiskImageConfiguration} object. */
    @Override
    public DiskImageConfiguration build() {
      return new DiskImageConfiguration(this);
    }
  }

  private DiskImageConfiguration(Builder builder) {
    super(builder);
    this.sourceDisk = checkNotNull(builder.sourceDisk);
    this.sourceDiskId = builder.sourceDiskId;
  }

  /** Returns the identity of the source disk used to create this image. */
  public DiskId getSourceDisk() {
    return sourceDisk;
  }

  /**
   * Returns the service-generated unique id of the disk used to create this image. This value may
   * be used to determine whether the image was taken from the current or a previous instance of a
   * given disk name.
   */
  public String getSourceDiskId() {
    return sourceDiskId;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("sourceDisk", sourceDisk).add("sourceDiskId", sourceDiskId);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), sourceDisk, sourceDiskId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(DiskImageConfiguration.class)
            && baseEquals((DiskImageConfiguration) obj);
  }

  @Override
  DiskImageConfiguration setProjectId(String projectId) {
    if (sourceDisk.getProject() != null) {
      return this;
    }
    return toBuilder().setSourceDisk(sourceDisk.setProjectId(projectId)).build();
  }

  @Override
  Image toPb() {
    Image imagePb = super.toPb();
    imagePb.setSourceDisk(sourceDisk.getSelfLink());
    imagePb.setSourceDiskId(sourceDiskId);
    return imagePb;
  }

  /** Creates a builder for a {@code DiskImageConfiguration} given the source disk identity. */
  public static Builder newBuilder(DiskId sourceDisk) {
    return new Builder().setSourceDisk(sourceDisk);
  }

  /** Creates a {@code DiskImageConfiguration} object given the source disk identity. */
  public static DiskImageConfiguration of(DiskId sourceId) {
    return newBuilder(sourceId).build();
  }

  @SuppressWarnings("unchecked")
  static DiskImageConfiguration fromPb(Image imagePb) {
    return new Builder(imagePb).build();
  }
}
