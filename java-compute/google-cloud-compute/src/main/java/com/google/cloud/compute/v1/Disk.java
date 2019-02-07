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
/** A Disk resource. (== resource_for beta.disks ==) (== resource_for v1.disks ==) */
public final class Disk implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final CustomerEncryptionKey diskEncryptionKey;
  private final List<GuestOsFeature> guestOsFeatures;
  private final String id;
  private final String kind;
  private final String labelFingerprint;
  private final Map<String, String> labels;
  private final String lastAttachTimestamp;
  private final String lastDetachTimestamp;
  private final List<String> licenseCodes;
  private final List<String> licenses;
  private final String name;
  private final String options;
  private final String physicalBlockSizeBytes;
  private final String region;
  private final List<String> replicaZones;
  private final String selfLink;
  private final String sizeGb;
  private final String sourceImage;
  private final CustomerEncryptionKey sourceImageEncryptionKey;
  private final String sourceImageId;
  private final String sourceSnapshot;
  private final CustomerEncryptionKey sourceSnapshotEncryptionKey;
  private final String sourceSnapshotId;
  private final String status;
  private final String type;
  private final List<String> users;
  private final String zone;

  private Disk() {
    this.creationTimestamp = null;
    this.description = null;
    this.diskEncryptionKey = null;
    this.guestOsFeatures = null;
    this.id = null;
    this.kind = null;
    this.labelFingerprint = null;
    this.labels = null;
    this.lastAttachTimestamp = null;
    this.lastDetachTimestamp = null;
    this.licenseCodes = null;
    this.licenses = null;
    this.name = null;
    this.options = null;
    this.physicalBlockSizeBytes = null;
    this.region = null;
    this.replicaZones = null;
    this.selfLink = null;
    this.sizeGb = null;
    this.sourceImage = null;
    this.sourceImageEncryptionKey = null;
    this.sourceImageId = null;
    this.sourceSnapshot = null;
    this.sourceSnapshotEncryptionKey = null;
    this.sourceSnapshotId = null;
    this.status = null;
    this.type = null;
    this.users = null;
    this.zone = null;
  }

  private Disk(
      String creationTimestamp,
      String description,
      CustomerEncryptionKey diskEncryptionKey,
      List<GuestOsFeature> guestOsFeatures,
      String id,
      String kind,
      String labelFingerprint,
      Map<String, String> labels,
      String lastAttachTimestamp,
      String lastDetachTimestamp,
      List<String> licenseCodes,
      List<String> licenses,
      String name,
      String options,
      String physicalBlockSizeBytes,
      String region,
      List<String> replicaZones,
      String selfLink,
      String sizeGb,
      String sourceImage,
      CustomerEncryptionKey sourceImageEncryptionKey,
      String sourceImageId,
      String sourceSnapshot,
      CustomerEncryptionKey sourceSnapshotEncryptionKey,
      String sourceSnapshotId,
      String status,
      String type,
      List<String> users,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.diskEncryptionKey = diskEncryptionKey;
    this.guestOsFeatures = guestOsFeatures;
    this.id = id;
    this.kind = kind;
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
    this.lastAttachTimestamp = lastAttachTimestamp;
    this.lastDetachTimestamp = lastDetachTimestamp;
    this.licenseCodes = licenseCodes;
    this.licenses = licenses;
    this.name = name;
    this.options = options;
    this.physicalBlockSizeBytes = physicalBlockSizeBytes;
    this.region = region;
    this.replicaZones = replicaZones;
    this.selfLink = selfLink;
    this.sizeGb = sizeGb;
    this.sourceImage = sourceImage;
    this.sourceImageEncryptionKey = sourceImageEncryptionKey;
    this.sourceImageId = sourceImageId;
    this.sourceSnapshot = sourceSnapshot;
    this.sourceSnapshotEncryptionKey = sourceSnapshotEncryptionKey;
    this.sourceSnapshotId = sourceSnapshotId;
    this.status = status;
    this.type = type;
    this.users = users;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("diskEncryptionKey".equals(fieldName)) {
      return diskEncryptionKey;
    }
    if ("guestOsFeatures".equals(fieldName)) {
      return guestOsFeatures;
    }
    if ("id".equals(fieldName)) {
      return id;
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
    if ("lastAttachTimestamp".equals(fieldName)) {
      return lastAttachTimestamp;
    }
    if ("lastDetachTimestamp".equals(fieldName)) {
      return lastDetachTimestamp;
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
    if ("options".equals(fieldName)) {
      return options;
    }
    if ("physicalBlockSizeBytes".equals(fieldName)) {
      return physicalBlockSizeBytes;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("replicaZones".equals(fieldName)) {
      return replicaZones;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sizeGb".equals(fieldName)) {
      return sizeGb;
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
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("type".equals(fieldName)) {
      return type;
    }
    if ("users".equals(fieldName)) {
      return users;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Encrypts the disk using a customer-supplied encryption key.
   *
   * <p>After you encrypt a disk with a customer-supplied key, you must provide the same key if you
   * use the disk later (e.g. to create a disk snapshot or an image, or to attach the disk to a
   * virtual machine).
   *
   * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
   *
   * <p>If you do not provide an encryption key when creating the disk, then the disk will be
   * encrypted using an automatically generated key and you do not need to provide a key to use the
   * disk later.
   */
  public CustomerEncryptionKey getDiskEncryptionKey() {
    return diskEncryptionKey;
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

  /** [Output Only] Type of the resource. Always compute#disk for disks. */
  public String getKind() {
    return kind;
  }

  /**
   * A fingerprint for the labels being applied to this disk, which is essentially a hash of the
   * labels set used for optimistic locking. The fingerprint is initially generated by Compute
   * Engine and changes after every request to modify or update labels. You must always provide an
   * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
   * fail with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve a disk.
   */
  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  /** Labels to apply to this disk. These can be later modified by the setLabels method. */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /** [Output Only] Last attach timestamp in RFC3339 text format. */
  public String getLastAttachTimestamp() {
    return lastAttachTimestamp;
  }

  /** [Output Only] Last detach timestamp in RFC3339 text format. */
  public String getLastDetachTimestamp() {
    return lastDetachTimestamp;
  }

  /** Integer license codes indicating which licenses are attached to this disk. */
  public List<String> getLicenseCodesList() {
    return licenseCodes;
  }

  /** A list of publicly visible licenses. Reserved for Google's use. */
  public List<String> getLicensesList() {
    return licenses;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** Internal use only. */
  public String getOptions() {
    return options;
  }

  /**
   * Physical block size of the persistent disk, in bytes. If not present in a request, a default
   * value is used. Currently supported sizes are 4096 and 16384, other sizes may be added in the
   * future. If an unsupported value is requested, the error message will list the supported values
   * for the caller's project.
   */
  public String getPhysicalBlockSizeBytes() {
    return physicalBlockSizeBytes;
  }

  /**
   * [Output Only] URL of the region where the disk resides. Only applicable for regional resources.
   * You must specify this field as part of the HTTP request URL. It is not settable as a field in
   * the request body.
   */
  public String getRegion() {
    return region;
  }

  /**
   * URLs of the zones where the disk should be replicated to. Only applicable for regional
   * resources.
   */
  public List<String> getReplicaZonesList() {
    return replicaZones;
  }

  /** [Output Only] Server-defined fully-qualified URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Size of the persistent disk, specified in GB. You can specify this field when creating a
   * persistent disk using the sourceImage or sourceSnapshot parameter, or specify it alone to
   * create an empty persistent disk.
   *
   * <p>If you specify this field along with sourceImage or sourceSnapshot, the value of sizeGb must
   * not be less than the size of the sourceImage or the size of the snapshot. Acceptable values are
   * 1 to 65536, inclusive.
   */
  public String getSizeGb() {
    return sizeGb;
  }

  /**
   * The source image used to create this disk. If the source image is deleted, this field will not
   * be set.
   *
   * <p>To create a disk with one of the public operating system images, specify the image by its
   * family name. For example, specify family/debian-9 to use the latest Debian 9 image:
   * projects/debian-cloud/global/images/family/debian-9
   *
   * <p>Alternatively, use a specific version of a public operating system image:
   * projects/debian-cloud/global/images/debian-9-stretch-vYYYYMMDD
   *
   * <p>To create a disk with a custom image that you created, specify the image name in the
   * following format: global/images/my-custom-image
   *
   * <p>You can also specify a custom image by its image family, which returns the latest version of
   * the image in that family. Replace the image name with family/family-name:
   * global/images/family/my-image-family
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
   * [Output Only] The ID value of the image used to create this disk. This value identifies the
   * exact image that was used to create this persistent disk. For example, if you created the
   * persistent disk from an image that was later deleted and recreated under the same name, the
   * source image ID would identify the exact version of the image that was used.
   */
  public String getSourceImageId() {
    return sourceImageId;
  }

  /**
   * The source snapshot used to create this disk. You can provide this as a partial or full URL to
   * the resource. For example, the following are valid values: -
   * https://www.googleapis.com/compute/v1/projects/project/global/snapshots/snapshot -
   * projects/project/global/snapshots/snapshot - global/snapshots/snapshot
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
   * [Output Only] The unique ID of the snapshot used to create this disk. This value identifies the
   * exact snapshot that was used to create this persistent disk. For example, if you created the
   * persistent disk from a snapshot that was later deleted and recreated under the same name, the
   * source snapshot ID would identify the exact version of the snapshot that was used.
   */
  public String getSourceSnapshotId() {
    return sourceSnapshotId;
  }

  /** [Output Only] The status of disk creation. */
  public String getStatus() {
    return status;
  }

  /**
   * URL of the disk type resource describing which disk type to use to create the disk. Provide
   * this when creating the disk. For example: project/zones/zone/diskTypes/pd-standard or pd-ssd
   */
  public String getType() {
    return type;
  }

  /**
   * [Output Only] Links to the users of the disk (attached instances) in form:
   * project/zones/zone/instances/instance
   */
  public List<String> getUsersList() {
    return users;
  }

  /**
   * [Output Only] URL of the zone where the disk resides. You must specify this field as part of
   * the HTTP request URL. It is not settable as a field in the request body.
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Disk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Disk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Disk DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Disk();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private CustomerEncryptionKey diskEncryptionKey;
    private List<GuestOsFeature> guestOsFeatures;
    private String id;
    private String kind;
    private String labelFingerprint;
    private Map<String, String> labels;
    private String lastAttachTimestamp;
    private String lastDetachTimestamp;
    private List<String> licenseCodes;
    private List<String> licenses;
    private String name;
    private String options;
    private String physicalBlockSizeBytes;
    private String region;
    private List<String> replicaZones;
    private String selfLink;
    private String sizeGb;
    private String sourceImage;
    private CustomerEncryptionKey sourceImageEncryptionKey;
    private String sourceImageId;
    private String sourceSnapshot;
    private CustomerEncryptionKey sourceSnapshotEncryptionKey;
    private String sourceSnapshotId;
    private String status;
    private String type;
    private List<String> users;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Disk other) {
      if (other == Disk.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDiskEncryptionKey() != null) {
        this.diskEncryptionKey = other.diskEncryptionKey;
      }
      if (other.getGuestOsFeaturesList() != null) {
        this.guestOsFeatures = other.guestOsFeatures;
      }
      if (other.getId() != null) {
        this.id = other.id;
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
      if (other.getLastAttachTimestamp() != null) {
        this.lastAttachTimestamp = other.lastAttachTimestamp;
      }
      if (other.getLastDetachTimestamp() != null) {
        this.lastDetachTimestamp = other.lastDetachTimestamp;
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
      if (other.getOptions() != null) {
        this.options = other.options;
      }
      if (other.getPhysicalBlockSizeBytes() != null) {
        this.physicalBlockSizeBytes = other.physicalBlockSizeBytes;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getReplicaZonesList() != null) {
        this.replicaZones = other.replicaZones;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSizeGb() != null) {
        this.sizeGb = other.sizeGb;
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
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      if (other.getUsersList() != null) {
        this.users = other.users;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Disk source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.diskEncryptionKey = source.diskEncryptionKey;
      this.guestOsFeatures = source.guestOsFeatures;
      this.id = source.id;
      this.kind = source.kind;
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
      this.lastAttachTimestamp = source.lastAttachTimestamp;
      this.lastDetachTimestamp = source.lastDetachTimestamp;
      this.licenseCodes = source.licenseCodes;
      this.licenses = source.licenses;
      this.name = source.name;
      this.options = source.options;
      this.physicalBlockSizeBytes = source.physicalBlockSizeBytes;
      this.region = source.region;
      this.replicaZones = source.replicaZones;
      this.selfLink = source.selfLink;
      this.sizeGb = source.sizeGb;
      this.sourceImage = source.sourceImage;
      this.sourceImageEncryptionKey = source.sourceImageEncryptionKey;
      this.sourceImageId = source.sourceImageId;
      this.sourceSnapshot = source.sourceSnapshot;
      this.sourceSnapshotEncryptionKey = source.sourceSnapshotEncryptionKey;
      this.sourceSnapshotId = source.sourceSnapshotId;
      this.status = source.status;
      this.type = source.type;
      this.users = source.users;
      this.zone = source.zone;
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

    /**
     * Encrypts the disk using a customer-supplied encryption key.
     *
     * <p>After you encrypt a disk with a customer-supplied key, you must provide the same key if
     * you use the disk later (e.g. to create a disk snapshot or an image, or to attach the disk to
     * a virtual machine).
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the disk, then the disk will be
     * encrypted using an automatically generated key and you do not need to provide a key to use
     * the disk later.
     */
    public CustomerEncryptionKey getDiskEncryptionKey() {
      return diskEncryptionKey;
    }

    /**
     * Encrypts the disk using a customer-supplied encryption key.
     *
     * <p>After you encrypt a disk with a customer-supplied key, you must provide the same key if
     * you use the disk later (e.g. to create a disk snapshot or an image, or to attach the disk to
     * a virtual machine).
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the disk, then the disk will be
     * encrypted using an automatically generated key and you do not need to provide a key to use
     * the disk later.
     */
    public Builder setDiskEncryptionKey(CustomerEncryptionKey diskEncryptionKey) {
      this.diskEncryptionKey = diskEncryptionKey;
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

    /** [Output Only] Type of the resource. Always compute#disk for disks. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#disk for disks. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A fingerprint for the labels being applied to this disk, which is essentially a hash of the
     * labels set used for optimistic locking. The fingerprint is initially generated by Compute
     * Engine and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a disk.
     */
    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    /**
     * A fingerprint for the labels being applied to this disk, which is essentially a hash of the
     * labels set used for optimistic locking. The fingerprint is initially generated by Compute
     * Engine and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a disk.
     */
    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    /** Labels to apply to this disk. These can be later modified by the setLabels method. */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /** Labels to apply to this disk. These can be later modified by the setLabels method. */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /** [Output Only] Last attach timestamp in RFC3339 text format. */
    public String getLastAttachTimestamp() {
      return lastAttachTimestamp;
    }

    /** [Output Only] Last attach timestamp in RFC3339 text format. */
    public Builder setLastAttachTimestamp(String lastAttachTimestamp) {
      this.lastAttachTimestamp = lastAttachTimestamp;
      return this;
    }

    /** [Output Only] Last detach timestamp in RFC3339 text format. */
    public String getLastDetachTimestamp() {
      return lastDetachTimestamp;
    }

    /** [Output Only] Last detach timestamp in RFC3339 text format. */
    public Builder setLastDetachTimestamp(String lastDetachTimestamp) {
      this.lastDetachTimestamp = lastDetachTimestamp;
      return this;
    }

    /** Integer license codes indicating which licenses are attached to this disk. */
    public List<String> getLicenseCodesList() {
      return licenseCodes;
    }

    /** Integer license codes indicating which licenses are attached to this disk. */
    public Builder addAllLicenseCodes(List<String> licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.addAll(licenseCodes);
      return this;
    }

    /** Integer license codes indicating which licenses are attached to this disk. */
    public Builder addLicenseCodes(String licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.add(licenseCodes);
      return this;
    }

    /** A list of publicly visible licenses. Reserved for Google's use. */
    public List<String> getLicensesList() {
      return licenses;
    }

    /** A list of publicly visible licenses. Reserved for Google's use. */
    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.addAll(licenses);
      return this;
    }

    /** A list of publicly visible licenses. Reserved for Google's use. */
    public Builder addLicenses(String licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.add(licenses);
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** Internal use only. */
    public String getOptions() {
      return options;
    }

    /** Internal use only. */
    public Builder setOptions(String options) {
      this.options = options;
      return this;
    }

    /**
     * Physical block size of the persistent disk, in bytes. If not present in a request, a default
     * value is used. Currently supported sizes are 4096 and 16384, other sizes may be added in the
     * future. If an unsupported value is requested, the error message will list the supported
     * values for the caller's project.
     */
    public String getPhysicalBlockSizeBytes() {
      return physicalBlockSizeBytes;
    }

    /**
     * Physical block size of the persistent disk, in bytes. If not present in a request, a default
     * value is used. Currently supported sizes are 4096 and 16384, other sizes may be added in the
     * future. If an unsupported value is requested, the error message will list the supported
     * values for the caller's project.
     */
    public Builder setPhysicalBlockSizeBytes(String physicalBlockSizeBytes) {
      this.physicalBlockSizeBytes = physicalBlockSizeBytes;
      return this;
    }

    /**
     * [Output Only] URL of the region where the disk resides. Only applicable for regional
     * resources. You must specify this field as part of the HTTP request URL. It is not settable as
     * a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the disk resides. Only applicable for regional
     * resources. You must specify this field as part of the HTTP request URL. It is not settable as
     * a field in the request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /**
     * URLs of the zones where the disk should be replicated to. Only applicable for regional
     * resources.
     */
    public List<String> getReplicaZonesList() {
      return replicaZones;
    }

    /**
     * URLs of the zones where the disk should be replicated to. Only applicable for regional
     * resources.
     */
    public Builder addAllReplicaZones(List<String> replicaZones) {
      if (this.replicaZones == null) {
        this.replicaZones = new LinkedList<>();
      }
      this.replicaZones.addAll(replicaZones);
      return this;
    }

    /**
     * URLs of the zones where the disk should be replicated to. Only applicable for regional
     * resources.
     */
    public Builder addReplicaZones(String replicaZones) {
      if (this.replicaZones == null) {
        this.replicaZones = new LinkedList<>();
      }
      this.replicaZones.add(replicaZones);
      return this;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Size of the persistent disk, specified in GB. You can specify this field when creating a
     * persistent disk using the sourceImage or sourceSnapshot parameter, or specify it alone to
     * create an empty persistent disk.
     *
     * <p>If you specify this field along with sourceImage or sourceSnapshot, the value of sizeGb
     * must not be less than the size of the sourceImage or the size of the snapshot. Acceptable
     * values are 1 to 65536, inclusive.
     */
    public String getSizeGb() {
      return sizeGb;
    }

    /**
     * Size of the persistent disk, specified in GB. You can specify this field when creating a
     * persistent disk using the sourceImage or sourceSnapshot parameter, or specify it alone to
     * create an empty persistent disk.
     *
     * <p>If you specify this field along with sourceImage or sourceSnapshot, the value of sizeGb
     * must not be less than the size of the sourceImage or the size of the snapshot. Acceptable
     * values are 1 to 65536, inclusive.
     */
    public Builder setSizeGb(String sizeGb) {
      this.sizeGb = sizeGb;
      return this;
    }

    /**
     * The source image used to create this disk. If the source image is deleted, this field will
     * not be set.
     *
     * <p>To create a disk with one of the public operating system images, specify the image by its
     * family name. For example, specify family/debian-9 to use the latest Debian 9 image:
     * projects/debian-cloud/global/images/family/debian-9
     *
     * <p>Alternatively, use a specific version of a public operating system image:
     * projects/debian-cloud/global/images/debian-9-stretch-vYYYYMMDD
     *
     * <p>To create a disk with a custom image that you created, specify the image name in the
     * following format: global/images/my-custom-image
     *
     * <p>You can also specify a custom image by its image family, which returns the latest version
     * of the image in that family. Replace the image name with family/family-name:
     * global/images/family/my-image-family
     */
    public String getSourceImage() {
      return sourceImage;
    }

    /**
     * The source image used to create this disk. If the source image is deleted, this field will
     * not be set.
     *
     * <p>To create a disk with one of the public operating system images, specify the image by its
     * family name. For example, specify family/debian-9 to use the latest Debian 9 image:
     * projects/debian-cloud/global/images/family/debian-9
     *
     * <p>Alternatively, use a specific version of a public operating system image:
     * projects/debian-cloud/global/images/debian-9-stretch-vYYYYMMDD
     *
     * <p>To create a disk with a custom image that you created, specify the image name in the
     * following format: global/images/my-custom-image
     *
     * <p>You can also specify a custom image by its image family, which returns the latest version
     * of the image in that family. Replace the image name with family/family-name:
     * global/images/family/my-image-family
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
     * [Output Only] The ID value of the image used to create this disk. This value identifies the
     * exact image that was used to create this persistent disk. For example, if you created the
     * persistent disk from an image that was later deleted and recreated under the same name, the
     * source image ID would identify the exact version of the image that was used.
     */
    public String getSourceImageId() {
      return sourceImageId;
    }

    /**
     * [Output Only] The ID value of the image used to create this disk. This value identifies the
     * exact image that was used to create this persistent disk. For example, if you created the
     * persistent disk from an image that was later deleted and recreated under the same name, the
     * source image ID would identify the exact version of the image that was used.
     */
    public Builder setSourceImageId(String sourceImageId) {
      this.sourceImageId = sourceImageId;
      return this;
    }

    /**
     * The source snapshot used to create this disk. You can provide this as a partial or full URL
     * to the resource. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/global/snapshots/snapshot -
     * projects/project/global/snapshots/snapshot - global/snapshots/snapshot
     */
    public String getSourceSnapshot() {
      return sourceSnapshot;
    }

    /**
     * The source snapshot used to create this disk. You can provide this as a partial or full URL
     * to the resource. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/global/snapshots/snapshot -
     * projects/project/global/snapshots/snapshot - global/snapshots/snapshot
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
     * [Output Only] The unique ID of the snapshot used to create this disk. This value identifies
     * the exact snapshot that was used to create this persistent disk. For example, if you created
     * the persistent disk from a snapshot that was later deleted and recreated under the same name,
     * the source snapshot ID would identify the exact version of the snapshot that was used.
     */
    public String getSourceSnapshotId() {
      return sourceSnapshotId;
    }

    /**
     * [Output Only] The unique ID of the snapshot used to create this disk. This value identifies
     * the exact snapshot that was used to create this persistent disk. For example, if you created
     * the persistent disk from a snapshot that was later deleted and recreated under the same name,
     * the source snapshot ID would identify the exact version of the snapshot that was used.
     */
    public Builder setSourceSnapshotId(String sourceSnapshotId) {
      this.sourceSnapshotId = sourceSnapshotId;
      return this;
    }

    /** [Output Only] The status of disk creation. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] The status of disk creation. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * URL of the disk type resource describing which disk type to use to create the disk. Provide
     * this when creating the disk. For example: project/zones/zone/diskTypes/pd-standard or pd-ssd
     */
    public String getType() {
      return type;
    }

    /**
     * URL of the disk type resource describing which disk type to use to create the disk. Provide
     * this when creating the disk. For example: project/zones/zone/diskTypes/pd-standard or pd-ssd
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * [Output Only] Links to the users of the disk (attached instances) in form:
     * project/zones/zone/instances/instance
     */
    public List<String> getUsersList() {
      return users;
    }

    /**
     * [Output Only] Links to the users of the disk (attached instances) in form:
     * project/zones/zone/instances/instance
     */
    public Builder addAllUsers(List<String> users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
      this.users.addAll(users);
      return this;
    }

    /**
     * [Output Only] Links to the users of the disk (attached instances) in form:
     * project/zones/zone/instances/instance
     */
    public Builder addUsers(String users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
      this.users.add(users);
      return this;
    }

    /**
     * [Output Only] URL of the zone where the disk resides. You must specify this field as part of
     * the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] URL of the zone where the disk resides. You must specify this field as part of
     * the HTTP request URL. It is not settable as a field in the request body.
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Disk build() {

      return new Disk(
          creationTimestamp,
          description,
          diskEncryptionKey,
          guestOsFeatures,
          id,
          kind,
          labelFingerprint,
          labels,
          lastAttachTimestamp,
          lastDetachTimestamp,
          licenseCodes,
          licenses,
          name,
          options,
          physicalBlockSizeBytes,
          region,
          replicaZones,
          selfLink,
          sizeGb,
          sourceImage,
          sourceImageEncryptionKey,
          sourceImageId,
          sourceSnapshot,
          sourceSnapshotEncryptionKey,
          sourceSnapshotId,
          status,
          type,
          users,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setDiskEncryptionKey(this.diskEncryptionKey);
      newBuilder.addAllGuestOsFeatures(this.guestOsFeatures);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      newBuilder.setLastAttachTimestamp(this.lastAttachTimestamp);
      newBuilder.setLastDetachTimestamp(this.lastDetachTimestamp);
      newBuilder.addAllLicenseCodes(this.licenseCodes);
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setName(this.name);
      newBuilder.setOptions(this.options);
      newBuilder.setPhysicalBlockSizeBytes(this.physicalBlockSizeBytes);
      newBuilder.setRegion(this.region);
      newBuilder.addAllReplicaZones(this.replicaZones);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSizeGb(this.sizeGb);
      newBuilder.setSourceImage(this.sourceImage);
      newBuilder.setSourceImageEncryptionKey(this.sourceImageEncryptionKey);
      newBuilder.setSourceImageId(this.sourceImageId);
      newBuilder.setSourceSnapshot(this.sourceSnapshot);
      newBuilder.setSourceSnapshotEncryptionKey(this.sourceSnapshotEncryptionKey);
      newBuilder.setSourceSnapshotId(this.sourceSnapshotId);
      newBuilder.setStatus(this.status);
      newBuilder.setType(this.type);
      newBuilder.addAllUsers(this.users);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Disk{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "diskEncryptionKey="
        + diskEncryptionKey
        + ", "
        + "guestOsFeatures="
        + guestOsFeatures
        + ", "
        + "id="
        + id
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
        + "lastAttachTimestamp="
        + lastAttachTimestamp
        + ", "
        + "lastDetachTimestamp="
        + lastDetachTimestamp
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
        + "options="
        + options
        + ", "
        + "physicalBlockSizeBytes="
        + physicalBlockSizeBytes
        + ", "
        + "region="
        + region
        + ", "
        + "replicaZones="
        + replicaZones
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sizeGb="
        + sizeGb
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
        + "status="
        + status
        + ", "
        + "type="
        + type
        + ", "
        + "users="
        + users
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Disk) {
      Disk that = (Disk) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.diskEncryptionKey, that.getDiskEncryptionKey())
          && Objects.equals(this.guestOsFeatures, that.getGuestOsFeaturesList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.lastAttachTimestamp, that.getLastAttachTimestamp())
          && Objects.equals(this.lastDetachTimestamp, that.getLastDetachTimestamp())
          && Objects.equals(this.licenseCodes, that.getLicenseCodesList())
          && Objects.equals(this.licenses, that.getLicensesList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.options, that.getOptions())
          && Objects.equals(this.physicalBlockSizeBytes, that.getPhysicalBlockSizeBytes())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.replicaZones, that.getReplicaZonesList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sizeGb, that.getSizeGb())
          && Objects.equals(this.sourceImage, that.getSourceImage())
          && Objects.equals(this.sourceImageEncryptionKey, that.getSourceImageEncryptionKey())
          && Objects.equals(this.sourceImageId, that.getSourceImageId())
          && Objects.equals(this.sourceSnapshot, that.getSourceSnapshot())
          && Objects.equals(this.sourceSnapshotEncryptionKey, that.getSourceSnapshotEncryptionKey())
          && Objects.equals(this.sourceSnapshotId, that.getSourceSnapshotId())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.type, that.getType())
          && Objects.equals(this.users, that.getUsersList())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        diskEncryptionKey,
        guestOsFeatures,
        id,
        kind,
        labelFingerprint,
        labels,
        lastAttachTimestamp,
        lastDetachTimestamp,
        licenseCodes,
        licenses,
        name,
        options,
        physicalBlockSizeBytes,
        region,
        replicaZones,
        selfLink,
        sizeGb,
        sourceImage,
        sourceImageEncryptionKey,
        sourceImageId,
        sourceSnapshot,
        sourceSnapshotEncryptionKey,
        sourceSnapshotId,
        status,
        type,
        users,
        zone);
  }
}
