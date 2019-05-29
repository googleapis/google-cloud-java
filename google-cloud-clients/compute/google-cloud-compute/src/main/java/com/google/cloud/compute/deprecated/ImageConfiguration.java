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

import com.google.api.services.compute.model.Image;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Google Compute Engine image configuration. Use {@link DiskImageConfiguration} to
 * create an image from an existing Google Compute Engine disk. Use {@link
 * StorageImageConfiguration} to create an image from a file stored in Google Cloud Storage.
 */
public abstract class ImageConfiguration implements Serializable {

  private static final long serialVersionUID = -9154332316597745316L;

  private final Type type;
  private final SourceType sourceType;
  private final Long archiveSizeBytes;

  /** Type of a Google Compute Engine image. */
  public enum Type {
    /** A Google Compute Engine image created from a Google Compute Engine disk. */
    DISK,

    /** A Google Compute Engine image created from a file saved in Google Cloud Storage. */
    STORAGE
  }

  /** Image source type. The only admissible value is {@code RAW}. */
  public enum SourceType {
    RAW
  }

  /**
   * Base builder for image configurations.
   *
   * @param <T> the image configuration class
   * @param <B> the image configuration builder
   */
  public abstract static class Builder<T extends ImageConfiguration, B extends Builder<T, B>> {

    private Type type;
    private SourceType sourceType;
    private Long archiveSizeBytes;

    Builder(Type type) {
      this.type = type;
    }

    Builder(ImageConfiguration imageConfiguration) {
      this.type = imageConfiguration.type;
      this.sourceType = imageConfiguration.sourceType;
      this.archiveSizeBytes = imageConfiguration.archiveSizeBytes;
    }

    Builder(Type type, Image imagePb) {
      this.type = type;
      if (imagePb.getSourceType() != null) {
        this.sourceType = SourceType.valueOf(imagePb.getSourceType());
      }
      this.archiveSizeBytes = imagePb.getArchiveSizeBytes();
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B setType(Type type) {
      this.type = type;
      return self();
    }

    B setSourceType(SourceType sourceType) {
      this.sourceType = sourceType;
      return self();
    }

    B setArchiveSizeBytes(Long archiveSizeBytes) {
      this.archiveSizeBytes = archiveSizeBytes;
      return self();
    }

    /** Creates a configuration object. */
    public abstract T build();
  }

  ImageConfiguration(Builder builder) {
    this.type = builder.type;
    this.sourceType = builder.sourceType;
    this.archiveSizeBytes = builder.archiveSizeBytes;
  }

  /**
   * Returns the image's type. This method returns {@link Type#DISK} if this image was created from
   * an existing disk. This method returns {@link Type#STORAGE} if this image was created from a
   * file in Google Cloud Storage.
   */
  public Type getType() {
    return type;
  }

  /** Returns the source type of the disk. The default and only value is {@link SourceType#RAW}. */
  public SourceType getSourceType() {
    return sourceType;
  }

  /** Returns the size of the image archive stored in Google Cloud Storage (in bytes). */
  public Long getArchiveSizeBytes() {
    return archiveSizeBytes;
  }

  /** Returns a builder for the object. */
  public abstract Builder toBuilder();

  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("sourceType", sourceType)
        .add("archiveSizeBytes", archiveSizeBytes);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(type, sourceType, archiveSizeBytes);
  }

  final boolean baseEquals(ImageConfiguration imageConfiguration) {
    return imageConfiguration != null
        && getClass().equals(imageConfiguration.getClass())
        && Objects.equals(toPb(), imageConfiguration.toPb());
  }

  abstract ImageConfiguration setProjectId(String projectId);

  Image toPb() {
    Image imagePb = new Image();
    if (sourceType != null) {
      imagePb.setSourceType(sourceType.name());
    }
    imagePb.setArchiveSizeBytes(archiveSizeBytes);
    return imagePb;
  }

  @SuppressWarnings("unchecked")
  static <T extends ImageConfiguration> T fromPb(Image imagePb) {
    if (imagePb.getSourceDisk() != null) {
      return (T) DiskImageConfiguration.fromPb(imagePb);
    }
    return (T) StorageImageConfiguration.fromPb(imagePb);
  }
}
