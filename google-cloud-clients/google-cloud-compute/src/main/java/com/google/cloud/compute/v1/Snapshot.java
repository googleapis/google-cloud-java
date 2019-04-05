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
 * A persistent disk snapshot resource. (== resource_for beta.snapshots ==) (== resource_for
 * v1.snapshots ==)
 */
public final class Snapshot implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String diskSizeGb;
  private final String id;
  private final String kind;
  private final String labelFingerprint;
  private final Map<String, String> labels;
  private final List<String> licenseCodes;
  private final List<String> licenses;
  private final String name;
  private final String selfLink;
  private final CustomerEncryptionKey snapshotEncryptionKey;
  private final String sourceDisk;
  private final CustomerEncryptionKey sourceDiskEncryptionKey;
  private final String sourceDiskId;
  private final String status;
  private final String storageBytes;
  private final String storageBytesStatus;
  private final List<String> storageLocations;

  private Snapshot() {
    this.creationTimestamp = null;
    this.description = null;
    this.diskSizeGb = null;
    this.id = null;
    this.kind = null;
    this.labelFingerprint = null;
    this.labels = null;
    this.licenseCodes = null;
    this.licenses = null;
    this.name = null;
    this.selfLink = null;
    this.snapshotEncryptionKey = null;
    this.sourceDisk = null;
    this.sourceDiskEncryptionKey = null;
    this.sourceDiskId = null;
    this.status = null;
    this.storageBytes = null;
    this.storageBytesStatus = null;
    this.storageLocations = null;
  }

  private Snapshot(
      String creationTimestamp,
      String description,
      String diskSizeGb,
      String id,
      String kind,
      String labelFingerprint,
      Map<String, String> labels,
      List<String> licenseCodes,
      List<String> licenses,
      String name,
      String selfLink,
      CustomerEncryptionKey snapshotEncryptionKey,
      String sourceDisk,
      CustomerEncryptionKey sourceDiskEncryptionKey,
      String sourceDiskId,
      String status,
      String storageBytes,
      String storageBytesStatus,
      List<String> storageLocations) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.diskSizeGb = diskSizeGb;
    this.id = id;
    this.kind = kind;
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
    this.licenseCodes = licenseCodes;
    this.licenses = licenses;
    this.name = name;
    this.selfLink = selfLink;
    this.snapshotEncryptionKey = snapshotEncryptionKey;
    this.sourceDisk = sourceDisk;
    this.sourceDiskEncryptionKey = sourceDiskEncryptionKey;
    this.sourceDiskId = sourceDiskId;
    this.status = status;
    this.storageBytes = storageBytes;
    this.storageBytesStatus = storageBytesStatus;
    this.storageLocations = storageLocations;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("diskSizeGb".equals(fieldName)) {
      return diskSizeGb;
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
    if ("licenseCodes".equals(fieldName)) {
      return licenseCodes;
    }
    if ("licenses".equals(fieldName)) {
      return licenses;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("snapshotEncryptionKey".equals(fieldName)) {
      return snapshotEncryptionKey;
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
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("storageBytes".equals(fieldName)) {
      return storageBytes;
    }
    if ("storageBytesStatus".equals(fieldName)) {
      return storageBytesStatus;
    }
    if ("storageLocations".equals(fieldName)) {
      return storageLocations;
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

  /** [Output Only] Size of the snapshot, specified in GB. */
  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#snapshot for Snapshot resources. */
  public String getKind() {
    return kind;
  }

  /**
   * A fingerprint for the labels being applied to this snapshot, which is essentially a hash of the
   * labels set used for optimistic locking. The fingerprint is initially generated by Compute
   * Engine and changes after every request to modify or update labels. You must always provide an
   * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
   * fail with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve a snapshot.
   */
  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  /**
   * Labels to apply to this snapshot. These can be later modified by the setLabels method. Label
   * values may be empty.
   */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /**
   * [Output Only] Integer license codes indicating which licenses are attached to this snapshot.
   */
  public List<String> getLicenseCodesList() {
    return licenseCodes;
  }

  /**
   * [Output Only] A list of public visible licenses that apply to this snapshot. This can be
   * because the original image had licenses attached (such as a Windows image).
   */
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

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Encrypts the snapshot using a customer-supplied encryption key.
   *
   * <p>After you encrypt a snapshot using a customer-supplied key, you must provide the same key if
   * you use the image later For example, you must provide the encryption key when you create a disk
   * from the encrypted snapshot in a future request.
   *
   * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
   *
   * <p>If you do not provide an encryption key when creating the snapshot, then the snapshot will
   * be encrypted using an automatically generated key and you do not need to provide a key to use
   * the snapshot later.
   */
  public CustomerEncryptionKey getSnapshotEncryptionKey() {
    return snapshotEncryptionKey;
  }

  /** [Output Only] The source disk used to create this snapshot. */
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
   * [Output Only] The ID value of the disk used to create this snapshot. This value may be used to
   * determine whether the snapshot was taken from the current or a previous instance of a given
   * disk name.
   */
  public String getSourceDiskId() {
    return sourceDiskId;
  }

  /**
   * [Output Only] The status of the snapshot. This can be CREATING, DELETING, FAILED, READY, or
   * UPLOADING.
   */
  public String getStatus() {
    return status;
  }

  /**
   * [Output Only] A size of the storage used by the snapshot. As snapshots share storage, this
   * number is expected to change with snapshot creation/deletion.
   */
  public String getStorageBytes() {
    return storageBytes;
  }

  /**
   * [Output Only] An indicator whether storageBytes is in a stable state or it is being adjusted as
   * a result of shared storage reallocation. This status can either be UPDATING, meaning the size
   * of the snapshot is being updated, or UP_TO_DATE, meaning the size of the snapshot is
   * up-to-date.
   */
  public String getStorageBytesStatus() {
    return storageBytesStatus;
  }

  /** GCS bucket storage location of the snapshot (regional or multi-regional). */
  public List<String> getStorageLocationsList() {
    return storageLocations;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Snapshot prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Snapshot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Snapshot DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Snapshot();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String diskSizeGb;
    private String id;
    private String kind;
    private String labelFingerprint;
    private Map<String, String> labels;
    private List<String> licenseCodes;
    private List<String> licenses;
    private String name;
    private String selfLink;
    private CustomerEncryptionKey snapshotEncryptionKey;
    private String sourceDisk;
    private CustomerEncryptionKey sourceDiskEncryptionKey;
    private String sourceDiskId;
    private String status;
    private String storageBytes;
    private String storageBytesStatus;
    private List<String> storageLocations;

    Builder() {}

    public Builder mergeFrom(Snapshot other) {
      if (other == Snapshot.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDiskSizeGb() != null) {
        this.diskSizeGb = other.diskSizeGb;
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
      if (other.getLicenseCodesList() != null) {
        this.licenseCodes = other.licenseCodes;
      }
      if (other.getLicensesList() != null) {
        this.licenses = other.licenses;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSnapshotEncryptionKey() != null) {
        this.snapshotEncryptionKey = other.snapshotEncryptionKey;
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
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStorageBytes() != null) {
        this.storageBytes = other.storageBytes;
      }
      if (other.getStorageBytesStatus() != null) {
        this.storageBytesStatus = other.storageBytesStatus;
      }
      if (other.getStorageLocationsList() != null) {
        this.storageLocations = other.storageLocations;
      }
      return this;
    }

    Builder(Snapshot source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.diskSizeGb = source.diskSizeGb;
      this.id = source.id;
      this.kind = source.kind;
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
      this.licenseCodes = source.licenseCodes;
      this.licenses = source.licenses;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.snapshotEncryptionKey = source.snapshotEncryptionKey;
      this.sourceDisk = source.sourceDisk;
      this.sourceDiskEncryptionKey = source.sourceDiskEncryptionKey;
      this.sourceDiskId = source.sourceDiskId;
      this.status = source.status;
      this.storageBytes = source.storageBytes;
      this.storageBytesStatus = source.storageBytesStatus;
      this.storageLocations = source.storageLocations;
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

    /** [Output Only] Size of the snapshot, specified in GB. */
    public String getDiskSizeGb() {
      return diskSizeGb;
    }

    /** [Output Only] Size of the snapshot, specified in GB. */
    public Builder setDiskSizeGb(String diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
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

    /** [Output Only] Type of the resource. Always compute#snapshot for Snapshot resources. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#snapshot for Snapshot resources. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A fingerprint for the labels being applied to this snapshot, which is essentially a hash of
     * the labels set used for optimistic locking. The fingerprint is initially generated by Compute
     * Engine and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a snapshot.
     */
    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    /**
     * A fingerprint for the labels being applied to this snapshot, which is essentially a hash of
     * the labels set used for optimistic locking. The fingerprint is initially generated by Compute
     * Engine and changes after every request to modify or update labels. You must always provide an
     * up-to-date fingerprint hash in order to update or change labels, otherwise the request will
     * fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a snapshot.
     */
    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    /**
     * Labels to apply to this snapshot. These can be later modified by the setLabels method. Label
     * values may be empty.
     */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /**
     * Labels to apply to this snapshot. These can be later modified by the setLabels method. Label
     * values may be empty.
     */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * [Output Only] Integer license codes indicating which licenses are attached to this snapshot.
     */
    public List<String> getLicenseCodesList() {
      return licenseCodes;
    }

    /**
     * [Output Only] Integer license codes indicating which licenses are attached to this snapshot.
     */
    public Builder addAllLicenseCodes(List<String> licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.addAll(licenseCodes);
      return this;
    }

    /**
     * [Output Only] Integer license codes indicating which licenses are attached to this snapshot.
     */
    public Builder addLicenseCodes(String licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.add(licenseCodes);
      return this;
    }

    /**
     * [Output Only] A list of public visible licenses that apply to this snapshot. This can be
     * because the original image had licenses attached (such as a Windows image).
     */
    public List<String> getLicensesList() {
      return licenses;
    }

    /**
     * [Output Only] A list of public visible licenses that apply to this snapshot. This can be
     * because the original image had licenses attached (such as a Windows image).
     */
    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.addAll(licenses);
      return this;
    }

    /**
     * [Output Only] A list of public visible licenses that apply to this snapshot. This can be
     * because the original image had licenses attached (such as a Windows image).
     */
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
     * Encrypts the snapshot using a customer-supplied encryption key.
     *
     * <p>After you encrypt a snapshot using a customer-supplied key, you must provide the same key
     * if you use the image later For example, you must provide the encryption key when you create a
     * disk from the encrypted snapshot in a future request.
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the snapshot, then the snapshot will
     * be encrypted using an automatically generated key and you do not need to provide a key to use
     * the snapshot later.
     */
    public CustomerEncryptionKey getSnapshotEncryptionKey() {
      return snapshotEncryptionKey;
    }

    /**
     * Encrypts the snapshot using a customer-supplied encryption key.
     *
     * <p>After you encrypt a snapshot using a customer-supplied key, you must provide the same key
     * if you use the image later For example, you must provide the encryption key when you create a
     * disk from the encrypted snapshot in a future request.
     *
     * <p>Customer-supplied encryption keys do not protect access to metadata of the disk.
     *
     * <p>If you do not provide an encryption key when creating the snapshot, then the snapshot will
     * be encrypted using an automatically generated key and you do not need to provide a key to use
     * the snapshot later.
     */
    public Builder setSnapshotEncryptionKey(CustomerEncryptionKey snapshotEncryptionKey) {
      this.snapshotEncryptionKey = snapshotEncryptionKey;
      return this;
    }

    /** [Output Only] The source disk used to create this snapshot. */
    public String getSourceDisk() {
      return sourceDisk;
    }

    /** [Output Only] The source disk used to create this snapshot. */
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
     * [Output Only] The ID value of the disk used to create this snapshot. This value may be used
     * to determine whether the snapshot was taken from the current or a previous instance of a
     * given disk name.
     */
    public String getSourceDiskId() {
      return sourceDiskId;
    }

    /**
     * [Output Only] The ID value of the disk used to create this snapshot. This value may be used
     * to determine whether the snapshot was taken from the current or a previous instance of a
     * given disk name.
     */
    public Builder setSourceDiskId(String sourceDiskId) {
      this.sourceDiskId = sourceDiskId;
      return this;
    }

    /**
     * [Output Only] The status of the snapshot. This can be CREATING, DELETING, FAILED, READY, or
     * UPLOADING.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the snapshot. This can be CREATING, DELETING, FAILED, READY, or
     * UPLOADING.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * [Output Only] A size of the storage used by the snapshot. As snapshots share storage, this
     * number is expected to change with snapshot creation/deletion.
     */
    public String getStorageBytes() {
      return storageBytes;
    }

    /**
     * [Output Only] A size of the storage used by the snapshot. As snapshots share storage, this
     * number is expected to change with snapshot creation/deletion.
     */
    public Builder setStorageBytes(String storageBytes) {
      this.storageBytes = storageBytes;
      return this;
    }

    /**
     * [Output Only] An indicator whether storageBytes is in a stable state or it is being adjusted
     * as a result of shared storage reallocation. This status can either be UPDATING, meaning the
     * size of the snapshot is being updated, or UP_TO_DATE, meaning the size of the snapshot is
     * up-to-date.
     */
    public String getStorageBytesStatus() {
      return storageBytesStatus;
    }

    /**
     * [Output Only] An indicator whether storageBytes is in a stable state or it is being adjusted
     * as a result of shared storage reallocation. This status can either be UPDATING, meaning the
     * size of the snapshot is being updated, or UP_TO_DATE, meaning the size of the snapshot is
     * up-to-date.
     */
    public Builder setStorageBytesStatus(String storageBytesStatus) {
      this.storageBytesStatus = storageBytesStatus;
      return this;
    }

    /** GCS bucket storage location of the snapshot (regional or multi-regional). */
    public List<String> getStorageLocationsList() {
      return storageLocations;
    }

    /** GCS bucket storage location of the snapshot (regional or multi-regional). */
    public Builder addAllStorageLocations(List<String> storageLocations) {
      if (this.storageLocations == null) {
        this.storageLocations = new LinkedList<>();
      }
      this.storageLocations.addAll(storageLocations);
      return this;
    }

    /** GCS bucket storage location of the snapshot (regional or multi-regional). */
    public Builder addStorageLocations(String storageLocations) {
      if (this.storageLocations == null) {
        this.storageLocations = new LinkedList<>();
      }
      this.storageLocations.add(storageLocations);
      return this;
    }

    public Snapshot build() {

      return new Snapshot(
          creationTimestamp,
          description,
          diskSizeGb,
          id,
          kind,
          labelFingerprint,
          labels,
          licenseCodes,
          licenses,
          name,
          selfLink,
          snapshotEncryptionKey,
          sourceDisk,
          sourceDiskEncryptionKey,
          sourceDiskId,
          status,
          storageBytes,
          storageBytesStatus,
          storageLocations);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setDiskSizeGb(this.diskSizeGb);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      newBuilder.addAllLicenseCodes(this.licenseCodes);
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSnapshotEncryptionKey(this.snapshotEncryptionKey);
      newBuilder.setSourceDisk(this.sourceDisk);
      newBuilder.setSourceDiskEncryptionKey(this.sourceDiskEncryptionKey);
      newBuilder.setSourceDiskId(this.sourceDiskId);
      newBuilder.setStatus(this.status);
      newBuilder.setStorageBytes(this.storageBytes);
      newBuilder.setStorageBytesStatus(this.storageBytesStatus);
      newBuilder.addAllStorageLocations(this.storageLocations);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Snapshot{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "diskSizeGb="
        + diskSizeGb
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
        + "licenseCodes="
        + licenseCodes
        + ", "
        + "licenses="
        + licenses
        + ", "
        + "name="
        + name
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "snapshotEncryptionKey="
        + snapshotEncryptionKey
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
        + "status="
        + status
        + ", "
        + "storageBytes="
        + storageBytes
        + ", "
        + "storageBytesStatus="
        + storageBytesStatus
        + ", "
        + "storageLocations="
        + storageLocations
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Snapshot) {
      Snapshot that = (Snapshot) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.diskSizeGb, that.getDiskSizeGb())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.licenseCodes, that.getLicenseCodesList())
          && Objects.equals(this.licenses, that.getLicensesList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.snapshotEncryptionKey, that.getSnapshotEncryptionKey())
          && Objects.equals(this.sourceDisk, that.getSourceDisk())
          && Objects.equals(this.sourceDiskEncryptionKey, that.getSourceDiskEncryptionKey())
          && Objects.equals(this.sourceDiskId, that.getSourceDiskId())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.storageBytes, that.getStorageBytes())
          && Objects.equals(this.storageBytesStatus, that.getStorageBytesStatus())
          && Objects.equals(this.storageLocations, that.getStorageLocationsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        diskSizeGb,
        id,
        kind,
        labelFingerprint,
        labels,
        licenseCodes,
        licenses,
        name,
        selfLink,
        snapshotEncryptionKey,
        sourceDisk,
        sourceDiskEncryptionKey,
        sourceDiskId,
        status,
        storageBytes,
        storageBytesStatus,
        storageLocations);
  }
}
