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
 * A Google Compute Engine image configuration used to create images from a Google Cloud Storage URL
 * where the disk image is stored.
 */
public class StorageImageConfiguration extends ImageConfiguration {

  private static final long serialVersionUID = 8160447986545005880L;

  private final ContainerType containerType;
  private final String sha1;
  private final String source;

  /**
   * The format used to encode and transmit the block device. The only supported value is {@code
   * TAR}. This is just a container and transmission format, not a runtime format.
   */
  public enum ContainerType {
    TAR
  }

  /** A builder for {@code StorageImageConfiguration} objects. */
  public static final class Builder
      extends ImageConfiguration.Builder<StorageImageConfiguration, Builder> {

    private ContainerType containerType;
    private String sha1;
    private String source;

    private Builder() {
      super(Type.STORAGE);
    }

    private Builder(StorageImageConfiguration imageConfiguration) {
      super(imageConfiguration);
      this.containerType = imageConfiguration.containerType;
      this.sha1 = imageConfiguration.sha1;
      this.source = imageConfiguration.source;
    }

    private Builder(Image imagePb) {
      super(Type.STORAGE, imagePb);
      if (imagePb.getRawDisk().getContainerType() != null) {
        this.containerType = ContainerType.valueOf(imagePb.getRawDisk().getContainerType());
      }
      this.sha1 = imagePb.getRawDisk().getSha1Checksum();
      this.source = imagePb.getRawDisk().getSource();
    }

    /**
     * Sets the format used to encode and transmit the block device. The only supported value is
     * {@code TAR}. This is just a container and transmission format, not a runtime format.
     */
    public Builder setContainerType(ContainerType containerType) {
      this.containerType = containerType;
      return this;
    }

    /** Sets the SHA1 checksum of the disk image before unpackaging. */
    public Builder setSha1(String sha1) {
      this.sha1 = sha1;
      return this;
    }

    /**
     * Sets the full Google Cloud Storage URL where the disk image is stored (e.g. {@code
     * gs://bucket/file}).
     */
    public Builder setSource(String source) {
      this.source = checkNotNull(source);
      return this;
    }

    /** Creates a {@code StorageImageConfiguration} object. */
    @Override
    public StorageImageConfiguration build() {
      return new StorageImageConfiguration(this);
    }
  }

  private StorageImageConfiguration(Builder builder) {
    super(builder);
    this.source = checkNotNull(builder.source);
    this.containerType = builder.containerType;
    this.sha1 = builder.sha1;
  }

  /**
   * Returns the format used to encode and transmit the block device. This is just a container and
   * transmission format, not a runtime format.
   */
  public ContainerType getContainerType() {
    return containerType;
  }

  /** Returns the SHA1 checksum of the disk image before unpackaging. */
  public String getSha1() {
    return sha1;
  }

  /**
   * Returns the full Google Cloud Storage URL where the disk image is stored (e.g. {@code
   * gs://bucket/file}).
   */
  public String getSource() {
    return source;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("source", source)
        .add("containerType", containerType)
        .add("sha1", sha1);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), source, containerType, sha1);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(StorageImageConfiguration.class)
            && Objects.equals(toPb(), ((StorageImageConfiguration) obj).toPb());
  }

  @Override
  StorageImageConfiguration setProjectId(String projectId) {
    return this;
  }

  @Override
  Image toPb() {
    Image.RawDisk rawDiskPb = new Image.RawDisk();
    rawDiskPb.setSource(source);
    rawDiskPb.setSha1Checksum(sha1);
    if (containerType != null) {
      rawDiskPb.setContainerType(containerType.name());
    }
    Image imagePb = super.toPb();
    return imagePb.setRawDisk(rawDiskPb);
  }

  /**
   * Creates a {@code StorageImageConfiguration} builder given the full Google Cloud Storage URL
   * where the disk image is stored.
   */
  public static Builder newBuilder(String source) {
    return new Builder().setSource(source);
  }

  /**
   * Creates a {@code StorageImageConfiguration} object given the full Google Cloud Storage URL
   * where the disk image is stored.
   */
  public static StorageImageConfiguration of(String source) {
    return newBuilder(source).build();
  }

  @SuppressWarnings("unchecked")
  static StorageImageConfiguration fromPb(Image imagePb) {
    return new Builder(imagePb).build();
  }
}
