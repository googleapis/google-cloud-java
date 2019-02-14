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
 * A Google Compute Engine disk configuration to create a disk from a Google Compute Engine image.
 *
 * @see <a href="https://cloud.google.com/compute/docs/disks/">Block Storage</a>
 */
public class ImageDiskConfiguration extends DiskConfiguration {

  private static final long serialVersionUID = 6469117882950722812L;

  private final ImageId sourceImage;
  private final String sourceImageId;

  /** A builder for {@code ImageDiskConfiguration} objects. */
  public static class Builder extends DiskConfiguration.Builder<ImageDiskConfiguration, Builder> {

    private ImageId sourceImage;
    private String sourceImageId;

    private Builder(ImageId sourceImage) {
      super(Type.IMAGE);
      this.sourceImage = checkNotNull(sourceImage);
    }

    private Builder(ImageDiskConfiguration configuration) {
      super(configuration);
      this.sourceImage = configuration.sourceImage;
      this.sourceImageId = configuration.sourceImageId;
    }

    private Builder(Disk diskPb) {
      super(Type.IMAGE, diskPb);
      this.sourceImage = ImageId.fromUrl(diskPb.getSourceImage());
      this.sourceImageId = diskPb.getSourceImageId();
    }

    /**
     * Sets the size of the persistent disk, in GB. If not set the disk will have the size of the
     * image. This value can be larger than the image's size. If the provided size is smaller than
     * the image's size then disk creation will fail.
     */
    @Override
    public Builder setSizeGb(Long sizeGb) {
      super.setSizeGb(sizeGb);
      return this;
    }

    /** Sets the identity of the source image used to create the disk. */
    public Builder setSourceImage(ImageId sourceImage) {
      this.sourceImage = checkNotNull(sourceImage);
      return this;
    }

    Builder setSourceImageId(String sourceImageId) {
      this.sourceImageId = sourceImageId;
      return this;
    }

    /** Creates an {@code ImageDiskConfiguration} object. */
    @Override
    public ImageDiskConfiguration build() {
      return new ImageDiskConfiguration(this);
    }
  }

  private ImageDiskConfiguration(Builder builder) {
    super(builder);
    this.sourceImage = builder.sourceImage;
    this.sourceImageId = builder.sourceImageId;
  }

  /** Returns the identity of the source image used to create the disk. */
  public ImageId getSourceImage() {
    return sourceImage;
  }

  /**
   * Returns the service-generated unique id of the image used to create this disk. This value
   * identifies the exact image that was used to create this persistent disk. For example, if you
   * created the persistent disk from an image that was later deleted and recreated under the same
   * name, the source image service-generated id would identify the exact version of the image that
   * was used.
   */
  public String getSourceImageId() {
    return sourceImageId;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("sourceImage", sourceImage)
        .add("sourceImageId", sourceImageId);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), sourceImage, sourceImageId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ImageDiskConfiguration.class)
            && baseEquals((ImageDiskConfiguration) obj);
  }

  @Override
  ImageDiskConfiguration setProjectId(String projectId) {
    Builder builder = toBuilder().setSourceImage(sourceImage.setProjectId(projectId));
    if (getDiskType() != null) {
      builder.setDiskType(getDiskType().setProjectId(projectId));
    }
    return builder.build();
  }

  @Override
  Disk toPb() {
    return super.toPb().setSourceImage(sourceImage.getSelfLink()).setSourceImageId(sourceImageId);
  }

  /** Returns a builder for an {@code ImageDiskConfiguration} object given the image identity. */
  public static Builder newBuilder(ImageId imageId) {
    return new Builder(imageId);
  }

  /** Returns an {@code ImageDiskConfiguration} object given the image identity. */
  public static ImageDiskConfiguration of(ImageId imageId) {
    return newBuilder(imageId).build();
  }

  @SuppressWarnings("unchecked")
  static ImageDiskConfiguration fromPb(Disk diskPb) {
    return new Builder(diskPb).build();
  }
}
