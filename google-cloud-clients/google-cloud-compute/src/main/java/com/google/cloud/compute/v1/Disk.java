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
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("diskEncryptionKey")) {
      return diskEncryptionKey;
    }
    if (fieldName.equals("guestOsFeatures")) {
      return guestOsFeatures;
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
    if (fieldName.equals("lastAttachTimestamp")) {
      return lastAttachTimestamp;
    }
    if (fieldName.equals("lastDetachTimestamp")) {
      return lastDetachTimestamp;
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
    if (fieldName.equals("options")) {
      return options;
    }
    if (fieldName.equals("physicalBlockSizeBytes")) {
      return physicalBlockSizeBytes;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("replicaZones")) {
      return replicaZones;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("sizeGb")) {
      return sizeGb;
    }
    if (fieldName.equals("sourceImage")) {
      return sourceImage;
    }
    if (fieldName.equals("sourceImageEncryptionKey")) {
      return sourceImageEncryptionKey;
    }
    if (fieldName.equals("sourceImageId")) {
      return sourceImageId;
    }
    if (fieldName.equals("sourceSnapshot")) {
      return sourceSnapshot;
    }
    if (fieldName.equals("sourceSnapshotEncryptionKey")) {
      return sourceSnapshotEncryptionKey;
    }
    if (fieldName.equals("sourceSnapshotId")) {
      return sourceSnapshotId;
    }
    if (fieldName.equals("status")) {
      return status;
    }
    if (fieldName.equals("type")) {
      return type;
    }
    if (fieldName.equals("users")) {
      return users;
    }
    if (fieldName.equals("zone")) {
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

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public CustomerEncryptionKey getDiskEncryptionKey() {
    return diskEncryptionKey;
  }

  public List<GuestOsFeature> getGuestOsFeaturesList() {
    return guestOsFeatures;
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

  public String getLastAttachTimestamp() {
    return lastAttachTimestamp;
  }

  public String getLastDetachTimestamp() {
    return lastDetachTimestamp;
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

  public String getOptions() {
    return options;
  }

  public String getPhysicalBlockSizeBytes() {
    return physicalBlockSizeBytes;
  }

  public String getRegion() {
    return region;
  }

  public List<String> getReplicaZonesList() {
    return replicaZones;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getSizeGb() {
    return sizeGb;
  }

  public String getSourceImage() {
    return sourceImage;
  }

  public CustomerEncryptionKey getSourceImageEncryptionKey() {
    return sourceImageEncryptionKey;
  }

  public String getSourceImageId() {
    return sourceImageId;
  }

  public String getSourceSnapshot() {
    return sourceSnapshot;
  }

  public CustomerEncryptionKey getSourceSnapshotEncryptionKey() {
    return sourceSnapshotEncryptionKey;
  }

  public String getSourceSnapshotId() {
    return sourceSnapshotId;
  }

  public String getStatus() {
    return status;
  }

  public String getType() {
    return type;
  }

  public List<String> getUsersList() {
    return users;
  }

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

    public CustomerEncryptionKey getDiskEncryptionKey() {
      return diskEncryptionKey;
    }

    public Builder setDiskEncryptionKey(CustomerEncryptionKey diskEncryptionKey) {
      this.diskEncryptionKey = diskEncryptionKey;
      return this;
    }

    public List<GuestOsFeature> getGuestOsFeaturesList() {
      return guestOsFeatures;
    }

    public Builder addAllGuestOsFeatures(List<GuestOsFeature> guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.addAll(guestOsFeatures);
      return this;
    }

    public Builder addGuestOsFeatures(GuestOsFeature guestOsFeatures) {
      if (this.guestOsFeatures == null) {
        this.guestOsFeatures = new LinkedList<>();
      }
      this.guestOsFeatures.add(guestOsFeatures);
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

    public String getLastAttachTimestamp() {
      return lastAttachTimestamp;
    }

    public Builder setLastAttachTimestamp(String lastAttachTimestamp) {
      this.lastAttachTimestamp = lastAttachTimestamp;
      return this;
    }

    public String getLastDetachTimestamp() {
      return lastDetachTimestamp;
    }

    public Builder setLastDetachTimestamp(String lastDetachTimestamp) {
      this.lastDetachTimestamp = lastDetachTimestamp;
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

    public String getOptions() {
      return options;
    }

    public Builder setOptions(String options) {
      this.options = options;
      return this;
    }

    public String getPhysicalBlockSizeBytes() {
      return physicalBlockSizeBytes;
    }

    public Builder setPhysicalBlockSizeBytes(String physicalBlockSizeBytes) {
      this.physicalBlockSizeBytes = physicalBlockSizeBytes;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public List<String> getReplicaZonesList() {
      return replicaZones;
    }

    public Builder addAllReplicaZones(List<String> replicaZones) {
      if (this.replicaZones == null) {
        this.replicaZones = new LinkedList<>();
      }
      this.replicaZones.addAll(replicaZones);
      return this;
    }

    public Builder addReplicaZones(String replicaZones) {
      if (this.replicaZones == null) {
        this.replicaZones = new LinkedList<>();
      }
      this.replicaZones.add(replicaZones);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getSizeGb() {
      return sizeGb;
    }

    public Builder setSizeGb(String sizeGb) {
      this.sizeGb = sizeGb;
      return this;
    }

    public String getSourceImage() {
      return sourceImage;
    }

    public Builder setSourceImage(String sourceImage) {
      this.sourceImage = sourceImage;
      return this;
    }

    public CustomerEncryptionKey getSourceImageEncryptionKey() {
      return sourceImageEncryptionKey;
    }

    public Builder setSourceImageEncryptionKey(CustomerEncryptionKey sourceImageEncryptionKey) {
      this.sourceImageEncryptionKey = sourceImageEncryptionKey;
      return this;
    }

    public String getSourceImageId() {
      return sourceImageId;
    }

    public Builder setSourceImageId(String sourceImageId) {
      this.sourceImageId = sourceImageId;
      return this;
    }

    public String getSourceSnapshot() {
      return sourceSnapshot;
    }

    public Builder setSourceSnapshot(String sourceSnapshot) {
      this.sourceSnapshot = sourceSnapshot;
      return this;
    }

    public CustomerEncryptionKey getSourceSnapshotEncryptionKey() {
      return sourceSnapshotEncryptionKey;
    }

    public Builder setSourceSnapshotEncryptionKey(
        CustomerEncryptionKey sourceSnapshotEncryptionKey) {
      this.sourceSnapshotEncryptionKey = sourceSnapshotEncryptionKey;
      return this;
    }

    public String getSourceSnapshotId() {
      return sourceSnapshotId;
    }

    public Builder setSourceSnapshotId(String sourceSnapshotId) {
      this.sourceSnapshotId = sourceSnapshotId;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public List<String> getUsersList() {
      return users;
    }

    public Builder addAllUsers(List<String> users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
      this.users.addAll(users);
      return this;
    }

    public Builder addUsers(String users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
      this.users.add(users);
      return this;
    }

    public String getZone() {
      return zone;
    }

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
