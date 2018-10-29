/*
 * Copyright 2018 Google LLC
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
      String storageBytesStatus) {
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
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("diskSizeGb")) {
      return diskSizeGb;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("labelFingerprint")) {
      return labelFingerprint;
    }
    if (fieldName.equals("labels")) {
      return labels;
    }
    if (fieldName.equals("licenseCodes")) {
      return licenseCodes;
    }
    if (fieldName.equals("licenses")) {
      return licenses;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("snapshotEncryptionKey")) {
      return snapshotEncryptionKey;
    }
    if (fieldName.equals("sourceDisk")) {
      return sourceDisk;
    }
    if (fieldName.equals("sourceDiskEncryptionKey")) {
      return sourceDiskEncryptionKey;
    }
    if (fieldName.equals("sourceDiskId")) {
      return sourceDiskId;
    }
    if (fieldName.equals("status")) {
      return status;
    }
    if (fieldName.equals("storageBytes")) {
      return storageBytes;
    }
    if (fieldName.equals("storageBytesStatus")) {
      return storageBytesStatus;
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

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  public Map<String, String> getLabelsMap() {
    return labels;
  }

  public List<String> getLicenseCodesList() {
    return licenseCodes;
  }

  public List<String> getLicensesList() {
    return licenses;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public CustomerEncryptionKey getSnapshotEncryptionKey() {
    return snapshotEncryptionKey;
  }

  public String getSourceDisk() {
    return sourceDisk;
  }

  public CustomerEncryptionKey getSourceDiskEncryptionKey() {
    return sourceDiskEncryptionKey;
  }

  public String getSourceDiskId() {
    return sourceDiskId;
  }

  public String getStatus() {
    return status;
  }

  public String getStorageBytes() {
    return storageBytes;
  }

  public String getStorageBytesStatus() {
    return storageBytesStatus;
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
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getDiskSizeGb() {
      return diskSizeGb;
    }

    public Builder setDiskSizeGb(String diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    public Map<String, String> getLabelsMap() {
      return labels;
    }

    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    public List<String> getLicenseCodesList() {
      return licenseCodes;
    }

    public Builder addAllLicenseCodes(List<String> licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.addAll(licenseCodes);
      return this;
    }

    public Builder addLicenseCodes(String licenseCodes) {
      if (this.licenseCodes == null) {
        this.licenseCodes = new LinkedList<>();
      }
      this.licenseCodes.add(licenseCodes);
      return this;
    }

    public List<String> getLicensesList() {
      return licenses;
    }

    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.addAll(licenses);
      return this;
    }

    public Builder addLicenses(String licenses) {
      if (this.licenses == null) {
        this.licenses = new LinkedList<>();
      }
      this.licenses.add(licenses);
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public CustomerEncryptionKey getSnapshotEncryptionKey() {
      return snapshotEncryptionKey;
    }

    public Builder setSnapshotEncryptionKey(CustomerEncryptionKey snapshotEncryptionKey) {
      this.snapshotEncryptionKey = snapshotEncryptionKey;
      return this;
    }

    public String getSourceDisk() {
      return sourceDisk;
    }

    public Builder setSourceDisk(String sourceDisk) {
      this.sourceDisk = sourceDisk;
      return this;
    }

    public CustomerEncryptionKey getSourceDiskEncryptionKey() {
      return sourceDiskEncryptionKey;
    }

    public Builder setSourceDiskEncryptionKey(CustomerEncryptionKey sourceDiskEncryptionKey) {
      this.sourceDiskEncryptionKey = sourceDiskEncryptionKey;
      return this;
    }

    public String getSourceDiskId() {
      return sourceDiskId;
    }

    public Builder setSourceDiskId(String sourceDiskId) {
      this.sourceDiskId = sourceDiskId;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getStorageBytes() {
      return storageBytes;
    }

    public Builder setStorageBytes(String storageBytes) {
      this.storageBytes = storageBytes;
      return this;
    }

    public String getStorageBytesStatus() {
      return storageBytesStatus;
    }

    public Builder setStorageBytesStatus(String storageBytesStatus) {
      this.storageBytesStatus = storageBytesStatus;
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
          storageBytesStatus);
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
          && Objects.equals(this.storageBytesStatus, that.getStorageBytesStatus());
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
        storageBytesStatus);
  }
}
