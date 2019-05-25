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
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A Google Compute Engine Image. An image contains a boot loader, an operating system and a root
 * file system that is necessary for starting an instance. Compute Engine offers publicly-available
 * images of certain operating systems that you can use, or you can create a custom image. A custom
 * image is an image created from one of your virtual machine instances that contains your specific
 * instance configurations. Use {@link DiskImageConfiguration} to create an image from an existing
 * disk. Use {@link StorageImageConfiguration} to create an image from a file stored in Google Cloud
 * Storage.
 *
 * @see <a href="https://cloud.google.com/compute/docs/images">Images</a>
 */
public class ImageInfo implements Serializable {

  static final Function<Image, ImageInfo> FROM_PB_FUNCTION =
      new Function<Image, ImageInfo>() {
        @Override
        public ImageInfo apply(Image pb) {
          return ImageInfo.fromPb(pb);
        }
      };
  static final Function<ImageInfo, Image> TO_PB_FUNCTION =
      new Function<ImageInfo, Image>() {
        @Override
        public Image apply(ImageInfo image) {
          return image.toPb();
        }
      };

  private static final long serialVersionUID = -1061916352807358977L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);

  private final String generatedId;
  private final ImageId imageId;
  private final Long creationTimestamp;
  private final String description;
  private final ImageConfiguration configuration;
  private final Status status;
  private final Long diskSizeGb;
  private final List<LicenseId> licenses;
  private final DeprecationStatus<ImageId> deprecationStatus;

  /**
   * The status of a Google Compute Engine Image. An image can be used to create other disks only
   * after it has been successfully created and its status is set to {@code READY}.
   */
  public enum Status {
    /** Image creation failed. The image can not be used. */
    FAILED,

    /** Image creation is pending. The image is not ready to be used yet. */
    PENDING,

    /** Image has been created and is ready for use. */
    READY
  }

  /** A builder for {@code ImageInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder getCreationTimestamp(Long creationTimestamp);

    /** Sets the image identity. */
    public abstract Builder setImageId(ImageId imageId);

    /** Sets an optional textual description of the image. */
    public abstract Builder setDescription(String description);

    /**
     * Sets the image configuration. Use {@link DiskImageConfiguration} to create an image from an
     * existing disk. Use {@link StorageImageConfiguration} to create an image from a file stored in
     * Google Cloud Storage.
     */
    public abstract Builder setConfiguration(ImageConfiguration configuration);

    abstract Builder setStatus(Status status);

    abstract Builder setDiskSizeGb(Long diskSizeGb);

    abstract Builder setLicenses(List<LicenseId> licenses);

    abstract Builder setDeprecationStatus(DeprecationStatus<ImageId> deprecationStatus);

    /** Creates a {@code ImageInfo} object. */
    public abstract ImageInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private Long creationTimestamp;
    private ImageId imageId;
    private String description;
    private ImageConfiguration configuration;
    private Status status;
    private Long diskSizeGb;
    private List<LicenseId> licenses;
    private DeprecationStatus<ImageId> deprecationStatus;

    BuilderImpl() {}

    BuilderImpl(ImageInfo imageInfo) {
      this.generatedId = imageInfo.generatedId;
      this.creationTimestamp = imageInfo.creationTimestamp;
      this.imageId = imageInfo.imageId;
      this.description = imageInfo.description;
      this.configuration = imageInfo.configuration;
      this.status = imageInfo.status;
      this.diskSizeGb = imageInfo.diskSizeGb;
      this.licenses = imageInfo.licenses;
      this.deprecationStatus = imageInfo.deprecationStatus;
    }

    BuilderImpl(Image imagePb) {
      if (imagePb.getId() != null) {
        this.generatedId = imagePb.getId().toString();
      }
      if (imagePb.getCreationTimestamp() != null) {
        this.creationTimestamp =
            TIMESTAMP_FORMATTER.parse(imagePb.getCreationTimestamp(), Instant.FROM).toEpochMilli();
      }
      this.imageId = ImageId.fromUrl(imagePb.getSelfLink());
      this.description = imagePb.getDescription();
      this.configuration = ImageConfiguration.fromPb(imagePb);
      if (imagePb.getStatus() != null) {
        this.status = Status.valueOf(imagePb.getStatus());
      }
      this.diskSizeGb = imagePb.getDiskSizeGb();
      if (imagePb.getLicenses() != null) {
        this.licenses = Lists.transform(imagePb.getLicenses(), LicenseId.FROM_URL_FUNCTION);
      }
      if (imagePb.getDeprecated() != null) {
        this.deprecationStatus =
            DeprecationStatus.fromPb(imagePb.getDeprecated(), ImageId.FROM_URL_FUNCTION);
      }
    }

    @Override
    BuilderImpl setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    BuilderImpl getCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    public BuilderImpl setImageId(ImageId imageId) {
      this.imageId = checkNotNull(imageId);
      return this;
    }

    @Override
    public BuilderImpl setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    public BuilderImpl setConfiguration(ImageConfiguration configuration) {
      this.configuration = checkNotNull(configuration);
      return this;
    }

    @Override
    BuilderImpl setStatus(Status status) {
      this.status = status;
      return this;
    }

    @Override
    BuilderImpl setDiskSizeGb(Long diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    @Override
    BuilderImpl setLicenses(List<LicenseId> licenses) {
      this.licenses = licenses != null ? ImmutableList.copyOf(licenses) : null;
      return this;
    }

    @Override
    BuilderImpl setDeprecationStatus(DeprecationStatus<ImageId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

    @Override
    public ImageInfo build() {
      return new ImageInfo(this);
    }
  }

  ImageInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.imageId = checkNotNull(builder.imageId);
    this.description = builder.description;
    this.configuration = checkNotNull(builder.configuration);
    this.status = builder.status;
    this.diskSizeGb = builder.diskSizeGb;
    this.licenses = builder.licenses;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /** Returns the service-generated unique identifier for the image. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns the image identity. */
  public ImageId getImageId() {
    return imageId;
  }

  /** Returns a textual description of the image. */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the image configuration. This method returns an instance of {@link
   * DiskImageConfiguration} if the the image was created from a Google Compute Engine disk. This
   * method returns an instance of {@link StorageImageConfiguration} if the image was created from a
   * file stored in Google Cloud Storage.
   */
  @SuppressWarnings("unchecked")
  public <T extends ImageConfiguration> T getConfiguration() {
    return (T) configuration;
  }

  /** Returns all applicable publicly visible licenses. */
  public List<LicenseId> getLicenses() {
    return licenses;
  }

  /**
   * Returns the status of the image. An image can be used to create other disks only after it has
   * been successfully created and its status is set to {@link Status#READY}.
   */
  public Status getStatus() {
    return status;
  }

  /** Returns the size of the image when restored onto a persistent disk (in GB). */
  public Long getDiskSizeGb() {
    return diskSizeGb;
  }

  /**
   * Returns the deprecation status of the image. If {@link DeprecationStatus#getStatus()} is either
   * {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE} the image
   * must not be used. Returns {@code null} if the image is not deprecated.
   */
  public DeprecationStatus<ImageId> getDeprecationStatus() {
    return deprecationStatus;
  }

  /** Returns a builder for the current image. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("imageId", imageId)
        .add("description", description)
        .add("configuration", configuration)
        .add("status", status)
        .add("diskSizeGb", diskSizeGb)
        .add("licenses", licenses)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        generatedId,
        creationTimestamp,
        imageId,
        description,
        configuration,
        status,
        diskSizeGb,
        licenses);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ImageInfo.class)
            && Objects.equals(toPb(), ((ImageInfo) obj).toPb());
  }

  ImageInfo setProjectId(String projectId) {
    return toBuilder()
        .setImageId(imageId.setProjectId(projectId))
        .setConfiguration(configuration.setProjectId(projectId))
        .build();
  }

  Image toPb() {
    Image imagePb = configuration.toPb();
    if (generatedId != null) {
      imagePb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      imagePb.setCreationTimestamp(
          TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(creationTimestamp)));
    }
    imagePb.setName(imageId.getImage());
    imagePb.setDescription(description);
    imagePb.setSelfLink(imageId.getSelfLink());
    if (status != null) {
      imagePb.setStatus(status.name());
    }
    imagePb.setDiskSizeGb(diskSizeGb);
    if (licenses != null) {
      imagePb.setLicenses(Lists.transform(licenses, LicenseId.TO_URL_FUNCTION));
    }
    if (deprecationStatus != null) {
      imagePb.setDeprecated(deprecationStatus.toPb());
    }
    return imagePb;
  }

  /**
   * Returns a builder for an {@code ImageInfo} object given the image identity and an image
   * configuration. Use {@link DiskImageConfiguration} to create an image from an existing disk. Use
   * {@link StorageImageConfiguration} to create an image from a file stored in Google Cloud
   * Storage.
   */
  public static Builder newBuilder(ImageId imageId, ImageConfiguration configuration) {
    return new BuilderImpl().setImageId(imageId).setConfiguration(configuration);
  }

  /**
   * Returns an {@code ImageInfo} object given the image identity and an image configuration. Use
   * {@link DiskImageConfiguration} to create an image from an existing disk. Use {@link
   * StorageImageConfiguration} to create an image from a file stored in Google Cloud Storage.
   */
  public static ImageInfo of(ImageId imageId, ImageConfiguration configuration) {
    return newBuilder(imageId, configuration).build();
  }

  static ImageInfo fromPb(Image imagePb) {
    return new BuilderImpl(imagePb).build();
  }
}
