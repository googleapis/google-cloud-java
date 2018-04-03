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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
  private final List<String> licenses;
  private final String name;
  private final String options;
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
    this.licenses = null;
    this.name = null;
    this.options = null;
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
      List<String> licenses,
      String name,
      String options,
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
      String zone
      ) {
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
    this.licenses = licenses;
    this.name = name;
    this.options = options;
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("diskEncryptionKey") && diskEncryptionKey != null) {
      fieldMap.put("diskEncryptionKey", Collections.singletonList(String.valueOf(diskEncryptionKey)));
    }
    if (fieldNames.contains("guestOsFeatures") && guestOsFeatures != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (GuestOsFeature item : guestOsFeatures) {
        stringList.add(item.toString());
      }
      fieldMap.put("guestOsFeatures", stringList.build());
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("labelFingerprint") && labelFingerprint != null) {
      fieldMap.put("labelFingerprint", Collections.singletonList(String.valueOf(labelFingerprint)));
    }
    if (fieldNames.contains("labels") && labels != null) {
      fieldMap.put("labels", Collections.singletonList(String.valueOf(labels)));
    }
    if (fieldNames.contains("lastAttachTimestamp") && lastAttachTimestamp != null) {
      fieldMap.put("lastAttachTimestamp", Collections.singletonList(String.valueOf(lastAttachTimestamp)));
    }
    if (fieldNames.contains("lastDetachTimestamp") && lastDetachTimestamp != null) {
      fieldMap.put("lastDetachTimestamp", Collections.singletonList(String.valueOf(lastDetachTimestamp)));
    }
    if (fieldNames.contains("licenses") && licenses != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : licenses) {
        stringList.add(item.toString());
      }
      fieldMap.put("licenses", stringList.build());
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("options") && options != null) {
      fieldMap.put("options", Collections.singletonList(String.valueOf(options)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("sizeGb") && sizeGb != null) {
      fieldMap.put("sizeGb", Collections.singletonList(String.valueOf(sizeGb)));
    }
    if (fieldNames.contains("sourceImage") && sourceImage != null) {
      fieldMap.put("sourceImage", Collections.singletonList(String.valueOf(sourceImage)));
    }
    if (fieldNames.contains("sourceImageEncryptionKey") && sourceImageEncryptionKey != null) {
      fieldMap.put("sourceImageEncryptionKey", Collections.singletonList(String.valueOf(sourceImageEncryptionKey)));
    }
    if (fieldNames.contains("sourceImageId") && sourceImageId != null) {
      fieldMap.put("sourceImageId", Collections.singletonList(String.valueOf(sourceImageId)));
    }
    if (fieldNames.contains("sourceSnapshot") && sourceSnapshot != null) {
      fieldMap.put("sourceSnapshot", Collections.singletonList(String.valueOf(sourceSnapshot)));
    }
    if (fieldNames.contains("sourceSnapshotEncryptionKey") && sourceSnapshotEncryptionKey != null) {
      fieldMap.put("sourceSnapshotEncryptionKey", Collections.singletonList(String.valueOf(sourceSnapshotEncryptionKey)));
    }
    if (fieldNames.contains("sourceSnapshotId") && sourceSnapshotId != null) {
      fieldMap.put("sourceSnapshotId", Collections.singletonList(String.valueOf(sourceSnapshotId)));
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    if (fieldNames.contains("type") && type != null) {
      fieldMap.put("type", Collections.singletonList(String.valueOf(type)));
    }
    if (fieldNames.contains("users") && users != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : users) {
        stringList.add(item.toString());
      }
      fieldMap.put("users", stringList.build());
    }
    if (fieldNames.contains("zone") && zone != null) {
      fieldMap.put("zone", Collections.singletonList(String.valueOf(zone)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("diskEncryptionKey")) {
      return String.valueOf(diskEncryptionKey);
    }
    if (fieldName.equals("guestOsFeatures")) {
      return String.valueOf(guestOsFeatures);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("labelFingerprint")) {
      return String.valueOf(labelFingerprint);
    }
    if (fieldName.equals("labels")) {
      return String.valueOf(labels);
    }
    if (fieldName.equals("lastAttachTimestamp")) {
      return String.valueOf(lastAttachTimestamp);
    }
    if (fieldName.equals("lastDetachTimestamp")) {
      return String.valueOf(lastDetachTimestamp);
    }
    if (fieldName.equals("licenses")) {
      return String.valueOf(licenses);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("options")) {
      return String.valueOf(options);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("sizeGb")) {
      return String.valueOf(sizeGb);
    }
    if (fieldName.equals("sourceImage")) {
      return String.valueOf(sourceImage);
    }
    if (fieldName.equals("sourceImageEncryptionKey")) {
      return String.valueOf(sourceImageEncryptionKey);
    }
    if (fieldName.equals("sourceImageId")) {
      return String.valueOf(sourceImageId);
    }
    if (fieldName.equals("sourceSnapshot")) {
      return String.valueOf(sourceSnapshot);
    }
    if (fieldName.equals("sourceSnapshotEncryptionKey")) {
      return String.valueOf(sourceSnapshotEncryptionKey);
    }
    if (fieldName.equals("sourceSnapshotId")) {
      return String.valueOf(sourceSnapshotId);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    if (fieldName.equals("type")) {
      return String.valueOf(type);
    }
    if (fieldName.equals("users")) {
      return String.valueOf(users);
    }
    if (fieldName.equals("zone")) {
      return String.valueOf(zone);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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

  public List<String> getLicensesList() {
    return licenses;
  }

  public String getName() {
    return name;
  }

  public String getOptions() {
    return options;
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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
    private List<String> licenses;
    private String name;
    private String options;
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
      if (other.getLicensesList() != null) {
        this.licenses = other.licenses;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getOptions() != null) {
        this.options = other.options;
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
      this.licenses = source.licenses;
      this.name = source.name;
      this.options = source.options;
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
        this.guestOsFeatures = new ArrayList<>(guestOsFeatures.size());
      }
      this.guestOsFeatures.addAll(guestOsFeatures);
      return this;
    }

    public Builder addGuestOsFeatures(GuestOsFeature guestOsFeatures) {
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

    public List<String> getLicensesList() {
      return licenses;
    }

    public Builder addAllLicenses(List<String> licenses) {
      if (this.licenses == null) {
        this.licenses = new ArrayList<>(licenses.size());
      }
      this.licenses.addAll(licenses);
      return this;
    }

    public Builder addLicenses(String licenses) {
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

    public Builder setSourceSnapshotEncryptionKey(CustomerEncryptionKey sourceSnapshotEncryptionKey) {
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
        this.users = new ArrayList<>(users.size());
      }
      this.users.addAll(users);
      return this;
    }

    public Builder addUsers(String users) {
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
        licenses,
        name,
        options,
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
        zone
      );
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
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setName(this.name);
      newBuilder.setOptions(this.options);
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
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "diskEncryptionKey=" + diskEncryptionKey + ", "
        + "guestOsFeatures=" + guestOsFeatures + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "labelFingerprint=" + labelFingerprint + ", "
        + "labels=" + labels + ", "
        + "lastAttachTimestamp=" + lastAttachTimestamp + ", "
        + "lastDetachTimestamp=" + lastDetachTimestamp + ", "
        + "licenses=" + licenses + ", "
        + "name=" + name + ", "
        + "options=" + options + ", "
        + "selfLink=" + selfLink + ", "
        + "sizeGb=" + sizeGb + ", "
        + "sourceImage=" + sourceImage + ", "
        + "sourceImageEncryptionKey=" + sourceImageEncryptionKey + ", "
        + "sourceImageId=" + sourceImageId + ", "
        + "sourceSnapshot=" + sourceSnapshot + ", "
        + "sourceSnapshotEncryptionKey=" + sourceSnapshotEncryptionKey + ", "
        + "sourceSnapshotId=" + sourceSnapshotId + ", "
        + "status=" + status + ", "
        + "type=" + type + ", "
        + "users=" + users + ", "
        + "zone=" + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Disk) {
      Disk that = (Disk) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.diskEncryptionKey, that.getDiskEncryptionKey()) &&
          Objects.equals(this.guestOsFeatures, that.getGuestOsFeaturesList()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.labelFingerprint, that.getLabelFingerprint()) &&
          Objects.equals(this.labels, that.getLabelsMap()) &&
          Objects.equals(this.lastAttachTimestamp, that.getLastAttachTimestamp()) &&
          Objects.equals(this.lastDetachTimestamp, that.getLastDetachTimestamp()) &&
          Objects.equals(this.licenses, that.getLicensesList()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.options, that.getOptions()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.sizeGb, that.getSizeGb()) &&
          Objects.equals(this.sourceImage, that.getSourceImage()) &&
          Objects.equals(this.sourceImageEncryptionKey, that.getSourceImageEncryptionKey()) &&
          Objects.equals(this.sourceImageId, that.getSourceImageId()) &&
          Objects.equals(this.sourceSnapshot, that.getSourceSnapshot()) &&
          Objects.equals(this.sourceSnapshotEncryptionKey, that.getSourceSnapshotEncryptionKey()) &&
          Objects.equals(this.sourceSnapshotId, that.getSourceSnapshotId()) &&
          Objects.equals(this.status, that.getStatus()) &&
          Objects.equals(this.type, that.getType()) &&
          Objects.equals(this.users, that.getUsersList()) &&
          Objects.equals(this.zone, that.getZone())
          ;
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
      licenses,
      name,
      options,
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
      zone
    );
  }
}
