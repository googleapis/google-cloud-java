/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents an Image resource.
 *
 * <p>You can use images to create boot disks for your VM instances. For more information, read
 * Images. (== resource_for beta.images ==) (== resource_for v1.images ==)
 */
public final class Image implements ApiMessage {
  private final String archiveSizeBytes;
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final String diskSizeGb;
  private final String family;
  private final List<GuestOsFeature> guestOsFeatures;
  private final String id;
  private final CustomerEncryptionKey imageEncryptionKey;
  private final String kind;
  private final String labelFingerprint;
  private final Map<String, String> labels;
  private final List<String> licenseCodes;
  private final List<String> licenses;
  private final String name;
  private final RawDisk rawDisk;
  private final String selfLink;
  private final String sourceDisk;
  private final CustomerEncryptionKey sourceDiskEncryptionKey;
  private final String sourceDiskId;
  private final String sourceImage;
  private final CustomerEncryptionKey sourceImageEncryptionKey;
  private final String sourceImageId;
  private final String sourceSnapshot;
  private final CustomerEncryptionKey sourceSnapshotEncryptionKey;
  private final String sourceSnapshotId;
  private final String sourceType;
  private final String status;

  private Image() {
    this.archiveSizeBytes = null;
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.diskSizeGb = null;
    this.family = null;
    this.guestOsFeatures = null;
    this.id = null;
    this.imageEncryptionKey = null;
    this.kind = null;
    this.labelFingerprint = null;
    this.labels = null;
    this.licenseCodes = null;
    this.licenses = null;
    this.name = null;
    this.rawDisk = null;
    this.selfLink = null;
    this.sourceDisk = null;
    this.sourceDiskEncryptionKey = null;
    this.sourceDiskId = null;
    this.sourceImage = null;
    this.sourceImageEncryptionKey = null;
    this.sourceImageId = null;
    this.sourceSnapshot = null;
    this.sourceSnapshotEncryptionKey = null;
    this.sourceSnapshotId = null;
    this.sourceType = null;
    this.status = null;
  }

  private Image(
      String archiveSizeBytes,
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      String diskSizeGb,
      String family,
      List<GuestOsFeature> guestOsFeatures,
      String id,
      CustomerEncryptionKey imageEncryptionKey,
      String kind,
      String labelFingerprint,
      Map<String, String> labels,
      List<String> licenseCodes,
      List<String> licenses,
      String name,
      RawDisk rawDisk,
      String selfLink,
      String sourceDisk,
      CustomerEncryptionKey sourceDiskEncryptionKey,
      String sourceDiskId,
      String sourceImage,
      CustomerEncryptionKey sourceImageEncryptionKey,
      String sourceImageId,
      String sourceSnapshot,
      CustomerEncryptionKey sourceSnapshotEncryptionKey,
      String sourceSnapshotId,
      String sourceType,
      String status) {
    this.archiveSizeBytes = archiveSizeBytes;
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.diskSizeGb = diskSizeGb;
    this.family = family;
    this.guestOsFeatures = guestOsFeatures;
    this.id = id;
    this.imageEncryptionKey = imageEncryptionKey;
    this.kind = kind;
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
    this.licenseCodes = licenseCodes;
    this.licenses = licenses;
    this.name = name;
    this.rawDisk = rawDisk;
    this.selfLink = selfLink;
    this.sourceDisk = sourceDisk;
    this.sourceDiskEncryptionKey = sourceDiskEncryptionKey;
    this.sourceDiskId = sourceDiskId;
    this.sourceImage = sourceImage;
    this.sourceImageEncryptionKey = sourceImageEncryptionKey;
    this.sourceImageId = sourceImageId;
    this.sourceSnapshot = sourceSnapshot;
    this.sourceSnapshotEncryptionKey = sourceSnapshotEncryptionKey;
    this.sourceSnapshotId = sourceSnapshotId;
    this.sourceType = sourceType;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("archiveSizeBytes".equals(fieldName)) {
      return archiveSizeBytes;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("diskSizeGb".equals(fieldName)) {
      return diskSizeGb;
    }
    if ("family".equals(fieldName)) {
      return family;
    }
    if ("guestOsFeatures".equals(fieldName)) {
      return guestOsFeatures;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("imageEncryptionKey".equals(fieldName)) {
      return imageEncryptionKey;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("labelFingerprint".equals(fieldName)) {
      return labelFingerprint;
    }
    if ("labels".equals(fieldName)) {
      return labels;
    }
    if ("licenseCodes".equals(fieldName)) {
      return licenseCodes;
    }
    if ("licenses".equals(fieldName)) {
      return licenses;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("rawDisk".equals(fieldName)) {
      return rawDisk;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sourceDisk".equals(fieldName)) {
      return sourceDisk;
    }
    if ("sourceDiskEncryptionKey".equals(fieldName)) {
      return sourceDiskEncryptionKey;
    }
    if ("sourceDiskId".equals(fieldName)) {
      return sourceDiskId;
    }
    if ("sourceImage".equals(fieldName)) {
      return sourceImage;
    }
    if ("sourceImageEncryptionKey".equals(fieldName)) {
      return sourceImageEncryptionKey;
    }
    if ("sourceImageId".equals(fieldName)) {
      return sourceImageId;
    }
    if ("sourceSnapshot".equals(fieldName)) {
      return sourceSnapshot;
    }
    if ("sourceSnapshotEncryptionKey".equals(fieldName)) {
      return sourceSnapshotEncryptionKey;
    }
    if ("sourceSnapshotId".equals(fieldName)) {
      return sourceSnapshotId;
    }
    if ("sourceType".equals(fieldName)) {
      return sourceType;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** Size of the image tar.gz archive stored in Google Cloud Storage (in bytes). */
  public String getArchiveSizeBytes() {
    return archiveSizeBytes;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** The deprecation status associated with this image. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /** Size of the image when restored onto a persistent disk (in GB). */
  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  /**
   * The name of the image family to which this image belongs. You can create disks by specifying an
   * image family instead of a specific image name. The image family always returns its latest image
   * that is not deprecated. The name of the image family must comply with RFC1035.
   */
  public String getFamily() {
    return family;
  }

  /**
   * A list of features to enable on the guest operating system. Applicable only for bootable
   * images. Read Enabling guest operating system features to see a list of available options.
   */
  public List<GuestOsFeature> getGuestOsFeaturesList() {
    return guestOsFeatures;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * Encrypts the image using a customer-supplied encryption key.
   *
   * <p>After you encrypt an image with a customer-supplied key, you must provide the same key if
   * you use the image later (e.g. to create a disk from the image).
   *
   * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
   *
   * <p>If you do not provide an encryption key when creating the image, then the disk will be
   * encrypted using an automatically generated key and you do not need to provide a key to use the
   * image later.
   */
  public CustomerEncryptionKey getImageEncryptionKey() {
    return imageEncryptionKey;
  }

  /** [Output Only] Type of the resource. Always compute#image for images. */
  public String getKind() {
    return kind;
  }

  /**
   * A fingerprint for the labels being applied to this image, which is essentially a hash of the
   * labels used for optimistic locking. The fingerprint is initially generated by Compute Engine
   * and changes after every request to modify or update labels. You must always provide an
   * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
   * fail with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve an image.
   */
  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  /** Labels to apply to this image. These can be later modified by the setLabels method. */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /** Integer license codes indicating which licenses are attached to this image. */
  public List<String> getLicenseCodesList() {
    return licenseCodes;
  }

  /** Any applicable license URI. */
  public List<String> getLicensesList() {
    return licenses;
  }

  /**
   * Name of the resource; provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** The parameters of the raw disk image. */
  public RawDisk getRawDisk() {
    return rawDisk;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * URL of the source disk used to create this image. This can be a full or valid partial URL. You
   * must provide either this property or the rawDisk.source property but not both to create an
   * image. For example, the following are valid values: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
   * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
   */
  public String getSourceDisk() {
    return sourceDisk;
  }

  /**
   * The customer-supplied encryption key of the source disk. Required if the source disk is
   * protected by a customer-supplied encryption key.
   */
  public CustomerEncryptionKey getSourceDiskEncryptionKey() {
    return sourceDiskEncryptionKey;
  }

  /**
   * [Output Only] The ID value of the disk used to create this image. This value may be used to
   * determine whether the image was taken from the current or a previous instance of a given disk
   * name.
   */
  public String getSourceDiskId() {
    return sourceDiskId;
  }

  /**
   * URL of the source image used to create this image. This can be a full or valid partial URL. You
   * must provide exactly one of: - this property, or - the rawDisk.source property, or - the
   * sourceDisk property in order to create an image.
   */
  public String getSourceImage() {
    return sourceImage;
  }

  /**
   * The customer-supplied encryption key of the source image. Required if the source image is
   * protected by a customer-supplied encryption key.
   */
  public CustomerEncryptionKey getSourceImageEncryptionKey() {
    return sourceImageEncryptionKey;
  }

  /**
   * [Output Only] The ID value of the image used to create this image. This value may be used to
   * determine whether the image was taken from the current or a previous instance of a given image
   * name.
   */
  public String getSourceImageId() {
    return sourceImageId;
  }

  /**
   * URL of the source snapshot used to create this image. This can be a full or valid partial URL.
   * You must provide exactly one of: - this property, or - the sourceImage property, or - the
   * rawDisk.source property, or - the sourceDisk property in order to create an image.
   */
  public String getSourceSnapshot() {
    return sourceSnapshot;
  }

  /**
   * The customer-supplied encryption key of the source snapshot. Required if the source snapshot is
   * protected by a customer-supplied encryption key.
   */
  public CustomerEncryptionKey getSourceSnapshotEncryptionKey() {
    return sourceSnapshotEncryptionKey;
  }

  /**
   * [Output Only] The ID value of the snapshot used to create this image. This value may be used to
   * determine whether the snapshot was taken from the current or a previous instance of a given
   * snapshot name.
   */
  public String getSourceSnapshotId() {
    return sourceSnapshotId;
  }

  /** The type of the image used to create this disk. The default and only value is RAW */
  public String getSourceType() {
    return sourceType;
  }

  /**
   * [Output Only] The status of the image. An image can be used to create other resources, such as
   * instances, only after the image has been successfully created and the status is set to READY.
   * Possible values are FAILED, PENDING, or READY.
   */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Image prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Image getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Image DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Image();
  }

  public static class Builder {
    private String archiveSizeBytes;
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private String diskSizeGb;
    private String family;
    private List<GuestOsFeature> guestOsFeatures;
    private String id;
    private CustomerEncryptionKey imageEncryptionKey;
    private String kind;
    private String labelFingerprint;
    private Map<String, String> labels;
    private List<String> licenseCodes;
    private List<String> licenses;
    private String name;
    private RawDisk rawDisk;
    private String selfLink;
    private String sourceDisk;
    private CustomerEncryptionKey sourceDiskEncryptionKey;
    private String sourceDiskId;
    private String sourceImage;
    private CustomerEncryptionKey sourceImageEncryptionKey;
    private String sourceImageId;
    private String sourceSnapshot;
    private CustomerEncryptionKey sourceSnapshotEncryptionKey;
    private String sourceSnapshotId;
    private String sourceType;
    private String status;

    Builder() {}

    public Builder mergeFrom(Image other) {
      if (other == Image.getDefaultInstance()) return this;
      if (other.getArchiveSizeBytes() != null) {
        this.archiveSizeBytes = other.archiveSizeBytes;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDiskSizeGb() != null) {
        this.diskSizeGb = other.diskSizeGb;
      }
      if (other.getFamily() != null) {
        this.family = other.family;
      }
      if (other.getGuestOsFeaturesList() != null) {
        this.guestOsFeatures = other.guestOsFeatures;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getImageEncryptionKey() != null) {
        this.imageEncryptionKey = other.imageEncryptionKey;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLabelFingerprint() != null) {
        this.labelFingerprint = other.labelFingerprint;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      if (other.getLicenseCodesList() != null) {
        this.licenseCodes = other.licenseCodes;
      }
      if (other.getLicensesList() != null) {
        this.licenses = other.licenses;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getRawDisk() != null) {
        this.rawDisk = other.rawDisk;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSourceDisk() != null) {
        this.sourceDisk = other.sourceDisk;
      }
      if (other.getSourceDiskEncryptionKey() != null) {
        this.sourceDiskEncryptionKey = other.sourceDiskEncryptionKey;
      }
      if (other.getSourceDiskId() != null) {
        this.sourceDiskId = other.sourceDiskId;
      }
      if (other.getSourceImage() != null) {
        this.sourceImage = other.sourceImage;
      }
      if (other.getSourceImageEncryptionKey() != null) {
        this.sourceImageEncryptionKey = other.sourceImageEncryptionKey;
      }
      if (other.getSourceImageId() != null) {
        this.sourceImageId = other.sourceImageId;
      }
      if (other.getSourceSnapshot() != null) {
        this.sourceSnapshot = other.sourceSnapshot;
      }
      if (other.getSourceSnapshotEncryptionKey() != null) {
        this.sourceSnapshotEncryptionKey = other.sourceSnapshotEncryptionKey;
      }
      if (other.getSourceSnapshotId() != null) {
        this.sourceSnapshotId = other.sourceSnapshotId;
      }
      if (other.getSourceType() != null) {
        this.sourceType = other.sourceType;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(Image source) {
      this.archiveSizeBytes = source.archiveSizeBytes;
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.diskSizeGb = source.diskSizeGb;
      this.family = source.family;
      this.guestOsFeatures = source.guestOsFeatures;
      this.id = source.id;
      this.imageEncryptionKey = source.imageEncryptionKey;
      this.kind = source.kind;
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
      this.licenseCodes = source.licenseCodes;
      this.licenses = source.licenses;
      this.name = source.name;
      this.rawDisk = source.rawDisk;
      this.selfLink = source.selfLink;
      this.sourceDisk = source.sourceDisk;
      this.sourceDiskEncryptionKey = source.sourceDiskEncryptionKey;
      this.sourceDiskId = source.sourceDiskId;
      this.sourceImage = source.sourceImage;
      this.sourceImageEncryptionKey = source.sourceImageEncryptionKey;
      this.sourceImageId = source.sourceImageId;
      this.sourceSnapshot = source.sourceSnapshot;
      this.sourceSnapshotEncryptionKey = source.sourceSnapshotEncryptionKey;
      this.sourceSnapshotId = source.sourceSnapshotId;
      this.sourceType = source.sourceType;
      this.status = source.status;
    }

    /** Size of the image tar.gz archive stored in Google Cloud Storage (in bytes). */
    public String getArchiveSizeBytes() {
      return archiveSizeBytes;
    }

    /** Size of the image tar.gz archive stored in Google Cloud Storage (in bytes). */
    public Builder setArchiveSizeBytes(String archiveSizeBytes) {
      this.archiveSizeBytes = archiveSizeBytes;
      return this;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /** The deprecation status associated with this image. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** The deprecation status associated with this image. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** Size of the image when restored onto a persistent disk (in GB). */
    public String getDiskSizeGb() {
      return diskSizeGb;
    }

    /** Size of the image when restored onto a persistent disk (in GB). */
    public Builder setDiskSizeGb(String diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    /**
     * The name of the image family to which this image belongs. You can create disks by specifying
     * an image family instead of a specific image name. The image family always returns its latest
     * image that is not deprecated. The name of the image family must comply with RFC1035.
     */
    public String getFamily() {
      return family;
    }

    /**
     * The name of the image family to which this image belongs. You can create disks by specifying
     * an image family instead of a specific image name. The image family always returns its latest
     * image that is not deprecated. The name of the image family must comply with RFC1035.
     */
    public Builder setFamily(String family) {
      this.family = family;
      return this;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public List<GuestOsFeature> getGuestOsFeaturesList() {
      return guestOsFeatures;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public Builder addAllGuestOsFeatures(List<GuestOsFeature> guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.addAll(guestOsFeatures);
      return this;
    }

    /**
     * A list of features to enable on the guest operating system. Applicable only for bootable
     * images. Read Enabling guest operating system features to see a list of available options.
     */
    public Builder addGuestOsFeatures(GuestOsFeature guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.add(guestOsFeatures);
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * Encrypts the image using a customer-supplied encryption key.
     *
     * <p>After you encrypt an image with a customer-supplied key, you must provide the same key if
     * you use the image later (e.g. to create a disk from the image).
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the image, then the disk will be
     * encrypted using an automatically generated key and you do not need to provide a key to use
     * the image later.
     */
    public CustomerEncryptionKey getImageEncryptionKey() {
      return imageEncryptionKey;
    }

    /**
     * Encrypts the image using a customer-supplied encryption key.
     *
     * <p>After you encrypt an image with a customer-supplied key, you must provide the same key if
     * you use the image later (e.g. to create a disk from the image).
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the image, then the disk will be
     * encrypted using an automatically generated key and you do not need to provide a key to use
     * the image later.
     */
    public Builder setImageEncryptionKey(CustomerEncryptionKey imageEncryptionKey) {
      this.imageEncryptionKey = imageEncryptionKey;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#image for images. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#image for images. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A fingerprint for the labels being applied to this image, which is essentially a hash of the
     * labels used for optimistic locking. The fingerprint is initially generated by Compute Engine
     * and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an image.
     */
    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    /**
     * A fingerprint for the labels being applied to this image, which is essentially a hash of the
     * labels used for optimistic locking. The fingerprint is initially generated by Compute Engine
     * and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an image.
     */
    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    /** Labels to apply to this image. These can be later modified by the setLabels method. */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /** Labels to apply to this image. These can be later modified by the setLabels method. */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /** Integer license codes indicating which licenses are attached to this image. */
    public List<String> getLicenseCodesList() {
      return licenseCodes;
    }

    /** Integer license codes indicating which licenses are attached to this image. */
    public Builder addAllLicenseCodes(List<String> licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.addAll(licenseCodes);
      return this;
    }

    /** Integer license codes indicating which licenses are attached to this image. */
    public Builder addLicenseCodes(String licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.add(licenseCodes);
      return this;
    }

    /** Any applicable license URI. */
    public List<String> getLicensesList() {
      return licenses;
    }

    /** Any applicable license URI. */
    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.addAll(licenses);
      return this;
    }

    /** Any applicable license URI. */
    public Builder addLicenses(String licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.add(licenses);
      return this;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** The parameters of the raw disk image. */
    public RawDisk getRawDisk() {
      return rawDisk;
    }

    /** The parameters of the raw disk image. */
    public Builder setRawDisk(RawDisk rawDisk) {
      this.rawDisk = rawDisk;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * URL of the source disk used to create this image. This can be a full or valid partial URL.
     * You must provide either this property or the rawDisk.source property but not both to create
     * an image. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
     * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
     */
    public String getSourceDisk() {
      return sourceDisk;
    }

    /**
     * URL of the source disk used to create this image. This can be a full or valid partial URL.
     * You must provide either this property or the rawDisk.source property but not both to create
     * an image. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
     * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
     */
    public Builder setSourceDisk(String sourceDisk) {
      this.sourceDisk = sourceDisk;
      return this;
    }

    /**
     * The customer-supplied encryption key of the source disk. Required if the source disk is
     * protected by a customer-supplied encryption key.
     */
    public CustomerEncryptionKey getSourceDiskEncryptionKey() {
      return sourceDiskEncryptionKey;
    }

    /**
     * The customer-supplied encryption key of the source disk. Required if the source disk is
     * protected by a customer-supplied encryption key.
     */
    public Builder setSourceDiskEncryptionKey(CustomerEncryptionKey sourceDiskEncryptionKey) {
      this.sourceDiskEncryptionKey = sourceDiskEncryptionKey;
      return this;
    }

    /**
     * [Output Only] The ID value of the disk used to create this image. This value may be used to
     * determine whether the image was taken from the current or a previous instance of a given disk
     * name.
     */
    public String getSourceDiskId() {
      return sourceDiskId;
    }

    /**
     * [Output Only] The ID value of the disk used to create this image. This value may be used to
     * determine whether the image was taken from the current or a previous instance of a given disk
     * name.
     */
    public Builder setSourceDiskId(String sourceDiskId) {
      this.sourceDiskId = sourceDiskId;
      return this;
    }

    /**
     * URL of the source image used to create this image. This can be a full or valid partial URL.
     * You must provide exactly one of: - this property, or - the rawDisk.source property, or - the
     * sourceDisk property in order to create an image.
     */
    public String getSourceImage() {
      return sourceImage;
    }

    /**
     * URL of the source image used to create this image. This can be a full or valid partial URL.
     * You must provide exactly one of: - this property, or - the rawDisk.source property, or - the
     * sourceDisk property in order to create an image.
     */
    public Builder setSourceImage(String sourceImage) {
      this.sourceImage = sourceImage;
      return this;
    }

    /**
     * The customer-supplied encryption key of the source image. Required if the source image is
     * protected by a customer-supplied encryption key.
     */
    public CustomerEncryptionKey getSourceImageEncryptionKey() {
      return sourceImageEncryptionKey;
    }

    /**
     * The customer-supplied encryption key of the source image. Required if the source image is
     * protected by a customer-supplied encryption key.
     */
    public Builder setSourceImageEncryptionKey(CustomerEncryptionKey sourceImageEncryptionKey) {
      this.sourceImageEncryptionKey = sourceImageEncryptionKey;
      return this;
    }

    /**
     * [Output Only] The ID value of the image used to create this image. This value may be used to
     * determine whether the image was taken from the current or a previous instance of a given
     * image name.
     */
    public String getSourceImageId() {
      return sourceImageId;
    }

    /**
     * [Output Only] The ID value of the image used to create this image. This value may be used to
     * determine whether the image was taken from the current or a previous instance of a given
     * image name.
     */
    public Builder setSourceImageId(String sourceImageId) {
      this.sourceImageId = sourceImageId;
      return this;
    }

    /**
     * URL of the source snapshot used to create this image. This can be a full or valid partial
     * URL. You must provide exactly one of: - this property, or - the sourceImage property, or -
     * the rawDisk.source property, or - the sourceDisk property in order to create an image.
     */
    public String getSourceSnapshot() {
      return sourceSnapshot;
    }

    /**
     * URL of the source snapshot used to create this image. This can be a full or valid partial
     * URL. You must provide exactly one of: - this property, or - the sourceImage property, or -
     * the rawDisk.source property, or - the sourceDisk property in order to create an image.
     */
    public Builder setSourceSnapshot(String sourceSnapshot) {
      this.sourceSnapshot = sourceSnapshot;
      return this;
    }

    /**
     * The customer-supplied encryption key of the source snapshot. Required if the source snapshot
     * is protected by a customer-supplied encryption key.
     */
    public CustomerEncryptionKey getSourceSnapshotEncryptionKey() {
      return sourceSnapshotEncryptionKey;
    }

    /**
     * The customer-supplied encryption key of the source snapshot. Required if the source snapshot
     * is protected by a customer-supplied encryption key.
     */
    public Builder setSourceSnapshotEncryptionKey(
        CustomerEncryptionKey sourceSnapshotEncryptionKey) {
      this.sourceSnapshotEncryptionKey = sourceSnapshotEncryptionKey;
      return this;
    }

    /**
     * [Output Only] The ID value of the snapshot used to create this image. This value may be used
     * to determine whether the snapshot was taken from the current or a previous instance of a
     * given snapshot name.
     */
    public String getSourceSnapshotId() {
      return sourceSnapshotId;
    }

    /**
     * [Output Only] The ID value of the snapshot used to create this image. This value may be used
     * to determine whether the snapshot was taken from the current or a previous instance of a
     * given snapshot name.
     */
    public Builder setSourceSnapshotId(String sourceSnapshotId) {
      this.sourceSnapshotId = sourceSnapshotId;
      return this;
    }

    /** The type of the image used to create this disk. The default and only value is RAW */
    public String getSourceType() {
      return sourceType;
    }

    /** The type of the image used to create this disk. The default and only value is RAW */
    public Builder setSourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    /**
     * [Output Only] The status of the image. An image can be used to create other resources, such
     * as instances, only after the image has been successfully created and the status is set to
     * READY. Possible values are FAILED, PENDING, or READY.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the image. An image can be used to create other resources, such
     * as instances, only after the image has been successfully created and the status is set to
     * READY. Possible values are FAILED, PENDING, or READY.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public Image build() {

      return new Image(
          archiveSizeBytes,
          creationTimestamp,
          deprecated,
          description,
          diskSizeGb,
          family,
          guestOsFeatures,
          id,
          imageEncryptionKey,
          kind,
          labelFingerprint,
          labels,
          licenseCodes,
          licenses,
          name,
          rawDisk,
          selfLink,
          sourceDisk,
          sourceDiskEncryptionKey,
          sourceDiskId,
          sourceImage,
          sourceImageEncryptionKey,
          sourceImageId,
          sourceSnapshot,
          sourceSnapshotEncryptionKey,
          sourceSnapshotId,
          sourceType,
          status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setArchiveSizeBytes(this.archiveSizeBytes);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setDiskSizeGb(this.diskSizeGb);
      newBuilder.setFamily(this.family);
      newBuilder.addAllGuestOsFeatures(this.guestOsFeatures);
      newBuilder.setId(this.id);
      newBuilder.setImageEncryptionKey(this.imageEncryptionKey);
      newBuilder.setKind(this.kind);
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      newBuilder.addAllLicenseCodes(this.licenseCodes);
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setName(this.name);
      newBuilder.setRawDisk(this.rawDisk);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSourceDisk(this.sourceDisk);
      newBuilder.setSourceDiskEncryptionKey(this.sourceDiskEncryptionKey);
      newBuilder.setSourceDiskId(this.sourceDiskId);
      newBuilder.setSourceImage(this.sourceImage);
      newBuilder.setSourceImageEncryptionKey(this.sourceImageEncryptionKey);
      newBuilder.setSourceImageId(this.sourceImageId);
      newBuilder.setSourceSnapshot(this.sourceSnapshot);
      newBuilder.setSourceSnapshotEncryptionKey(this.sourceSnapshotEncryptionKey);
      newBuilder.setSourceSnapshotId(this.sourceSnapshotId);
      newBuilder.setSourceType(this.sourceType);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Image{"
        + "archiveSizeBytes="
        + archiveSizeBytes
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "description="
        + description
        + ", "
        + "diskSizeGb="
        + diskSizeGb
        + ", "
        + "family="
        + family
        + ", "
        + "guestOsFeatures="
        + guestOsFeatures
        + ", "
        + "id="
        + id
        + ", "
        + "imageEncryptionKey="
        + imageEncryptionKey
        + ", "
        + "kind="
        + kind
        + ", "
        + "labelFingerprint="
        + labelFingerprint
        + ", "
        + "labels="
        + labels
        + ", "
        + "licenseCodes="
        + licenseCodes
        + ", "
        + "licenses="
        + licenses
        + ", "
        + "name="
        + name
        + ", "
        + "rawDisk="
        + rawDisk
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sourceDisk="
        + sourceDisk
        + ", "
        + "sourceDiskEncryptionKey="
        + sourceDiskEncryptionKey
        + ", "
        + "sourceDiskId="
        + sourceDiskId
        + ", "
        + "sourceImage="
        + sourceImage
        + ", "
        + "sourceImageEncryptionKey="
        + sourceImageEncryptionKey
        + ", "
        + "sourceImageId="
        + sourceImageId
        + ", "
        + "sourceSnapshot="
        + sourceSnapshot
        + ", "
        + "sourceSnapshotEncryptionKey="
        + sourceSnapshotEncryptionKey
        + ", "
        + "sourceSnapshotId="
        + sourceSnapshotId
        + ", "
        + "sourceType="
        + sourceType
        + ", "
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Image) {
      Image that = (Image) o;
      return Objects.equals(this.archiveSizeBytes, that.getArchiveSizeBytes())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.diskSizeGb, that.getDiskSizeGb())
          && Objects.equals(this.family, that.getFamily())
          && Objects.equals(this.guestOsFeatures, that.getGuestOsFeaturesList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.imageEncryptionKey, that.getImageEncryptionKey())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.licenseCodes, that.getLicenseCodesList())
          && Objects.equals(this.licenses, that.getLicensesList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.rawDisk, that.getRawDisk())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sourceDisk, that.getSourceDisk())
          && Objects.equals(this.sourceDiskEncryptionKey, that.getSourceDiskEncryptionKey())
          && Objects.equals(this.sourceDiskId, that.getSourceDiskId())
          && Objects.equals(this.sourceImage, that.getSourceImage())
          && Objects.equals(this.sourceImageEncryptionKey, that.getSourceImageEncryptionKey())
          && Objects.equals(this.sourceImageId, that.getSourceImageId())
          && Objects.equals(this.sourceSnapshot, that.getSourceSnapshot())
          && Objects.equals(this.sourceSnapshotEncryptionKey, that.getSourceSnapshotEncryptionKey())
          && Objects.equals(this.sourceSnapshotId, that.getSourceSnapshotId())
          && Objects.equals(this.sourceType, that.getSourceType())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        archiveSizeBytes,
        creationTimestamp,
        deprecated,
        description,
        diskSizeGb,
        family,
        guestOsFeatures,
        id,
        imageEncryptionKey,
        kind,
        labelFingerprint,
        labels,
        licenseCodes,
        licenses,
        name,
        rawDisk,
        selfLink,
        sourceDisk,
        sourceDiskEncryptionKey,
        sourceDiskId,
        sourceImage,
        sourceImageEncryptionKey,
        sourceImageId,
        sourceSnapshot,
        sourceSnapshotEncryptionKey,
        sourceSnapshotId,
        sourceType,
        status);
  }
}
