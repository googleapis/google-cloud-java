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
  private final List<String> licenses;
  private final String name;
  private final RawDisk rawDisk;
  private final String selfLink;
  private final String sourceDisk;
  private final CustomerEncryptionKey sourceDiskEncryptionKey;
  private final String sourceDiskId;
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
    this.licenses = null;
    this.name = null;
    this.rawDisk = null;
    this.selfLink = null;
    this.sourceDisk = null;
    this.sourceDiskEncryptionKey = null;
    this.sourceDiskId = null;
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
      List<String> licenses,
      String name,
      RawDisk rawDisk,
      String selfLink,
      String sourceDisk,
      CustomerEncryptionKey sourceDiskEncryptionKey,
      String sourceDiskId,
      String sourceType,
      String status
      ) {
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
    this.licenses = licenses;
    this.name = name;
    this.rawDisk = rawDisk;
    this.selfLink = selfLink;
    this.sourceDisk = sourceDisk;
    this.sourceDiskEncryptionKey = sourceDiskEncryptionKey;
    this.sourceDiskId = sourceDiskId;
    this.sourceType = sourceType;
    this.status = status;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("archiveSizeBytes") && archiveSizeBytes != null) {
      fieldMap.put("archiveSizeBytes", Collections.singletonList(String.valueOf(archiveSizeBytes)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("deprecated") && deprecated != null) {
      fieldMap.put("deprecated", Collections.singletonList(String.valueOf(deprecated)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("diskSizeGb") && diskSizeGb != null) {
      fieldMap.put("diskSizeGb", Collections.singletonList(String.valueOf(diskSizeGb)));
    }
    if (fieldNames.contains("family") && family != null) {
      fieldMap.put("family", Collections.singletonList(String.valueOf(family)));
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
    if (fieldNames.contains("imageEncryptionKey") && imageEncryptionKey != null) {
      fieldMap.put("imageEncryptionKey", Collections.singletonList(String.valueOf(imageEncryptionKey)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
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
    if (fieldNames.contains("rawDisk") && rawDisk != null) {
      fieldMap.put("rawDisk", Collections.singletonList(String.valueOf(rawDisk)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("sourceDisk") && sourceDisk != null) {
      fieldMap.put("sourceDisk", Collections.singletonList(String.valueOf(sourceDisk)));
    }
    if (fieldNames.contains("sourceDiskEncryptionKey") && sourceDiskEncryptionKey != null) {
      fieldMap.put("sourceDiskEncryptionKey", Collections.singletonList(String.valueOf(sourceDiskEncryptionKey)));
    }
    if (fieldNames.contains("sourceDiskId") && sourceDiskId != null) {
      fieldMap.put("sourceDiskId", Collections.singletonList(String.valueOf(sourceDiskId)));
    }
    if (fieldNames.contains("sourceType") && sourceType != null) {
      fieldMap.put("sourceType", Collections.singletonList(String.valueOf(sourceType)));
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("archiveSizeBytes")) {
      return String.valueOf(archiveSizeBytes);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("deprecated")) {
      return String.valueOf(deprecated);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("diskSizeGb")) {
      return String.valueOf(diskSizeGb);
    }
    if (fieldName.equals("family")) {
      return String.valueOf(family);
    }
    if (fieldName.equals("guestOsFeatures")) {
      return String.valueOf(guestOsFeatures);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("imageEncryptionKey")) {
      return String.valueOf(imageEncryptionKey);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("licenses")) {
      return String.valueOf(licenses);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("rawDisk")) {
      return String.valueOf(rawDisk);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("sourceDisk")) {
      return String.valueOf(sourceDisk);
    }
    if (fieldName.equals("sourceDiskEncryptionKey")) {
      return String.valueOf(sourceDiskEncryptionKey);
    }
    if (fieldName.equals("sourceDiskId")) {
      return String.valueOf(sourceDiskId);
    }
    if (fieldName.equals("sourceType")) {
      return String.valueOf(sourceType);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getArchiveSizeBytes() {
    return archiveSizeBytes;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  public String getDescription() {
    return description;
  }

  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  public String getFamily() {
    return family;
  }

  public List<GuestOsFeature> getGuestOsFeaturesList() {
    return guestOsFeatures;
  }

  public String getId() {
    return id;
  }

  public CustomerEncryptionKey getImageEncryptionKey() {
    return imageEncryptionKey;
  }

  public String getKind() {
    return kind;
  }

  public List<String> getLicensesList() {
    return licenses;
  }

  public String getName() {
    return name;
  }

  public RawDisk getRawDisk() {
    return rawDisk;
  }

  public String getSelfLink() {
    return selfLink;
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

  public String getSourceType() {
    return sourceType;
  }

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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
    private List<String> licenses;
    private String name;
    private RawDisk rawDisk;
    private String selfLink;
    private String sourceDisk;
    private CustomerEncryptionKey sourceDiskEncryptionKey;
    private String sourceDiskId;
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
      this.licenses = source.licenses;
      this.name = source.name;
      this.rawDisk = source.rawDisk;
      this.selfLink = source.selfLink;
      this.sourceDisk = source.sourceDisk;
      this.sourceDiskEncryptionKey = source.sourceDiskEncryptionKey;
      this.sourceDiskId = source.sourceDiskId;
      this.sourceType = source.sourceType;
      this.status = source.status;
    }

    public String getArchiveSizeBytes() {
      return archiveSizeBytes;
    }

    public Builder setArchiveSizeBytes(String archiveSizeBytes) {
      this.archiveSizeBytes = archiveSizeBytes;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
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

    public String getFamily() {
      return family;
    }

    public Builder setFamily(String family) {
      this.family = family;
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

    public CustomerEncryptionKey getImageEncryptionKey() {
      return imageEncryptionKey;
    }

    public Builder setImageEncryptionKey(CustomerEncryptionKey imageEncryptionKey) {
      this.imageEncryptionKey = imageEncryptionKey;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
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

    public RawDisk getRawDisk() {
      return rawDisk;
    }

    public Builder setRawDisk(RawDisk rawDisk) {
      this.rawDisk = rawDisk;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
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

    public String getSourceType() {
      return sourceType;
    }

    public Builder setSourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    public String getStatus() {
      return status;
    }

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
        licenses,
        name,
        rawDisk,
        selfLink,
        sourceDisk,
        sourceDiskEncryptionKey,
        sourceDiskId,
        sourceType,
        status
      );
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
      newBuilder.addAllLicenses(this.licenses);
      newBuilder.setName(this.name);
      newBuilder.setRawDisk(this.rawDisk);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSourceDisk(this.sourceDisk);
      newBuilder.setSourceDiskEncryptionKey(this.sourceDiskEncryptionKey);
      newBuilder.setSourceDiskId(this.sourceDiskId);
      newBuilder.setSourceType(this.sourceType);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Image{"
        + "archiveSizeBytes=" + archiveSizeBytes + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "deprecated=" + deprecated + ", "
        + "description=" + description + ", "
        + "diskSizeGb=" + diskSizeGb + ", "
        + "family=" + family + ", "
        + "guestOsFeatures=" + guestOsFeatures + ", "
        + "id=" + id + ", "
        + "imageEncryptionKey=" + imageEncryptionKey + ", "
        + "kind=" + kind + ", "
        + "licenses=" + licenses + ", "
        + "name=" + name + ", "
        + "rawDisk=" + rawDisk + ", "
        + "selfLink=" + selfLink + ", "
        + "sourceDisk=" + sourceDisk + ", "
        + "sourceDiskEncryptionKey=" + sourceDiskEncryptionKey + ", "
        + "sourceDiskId=" + sourceDiskId + ", "
        + "sourceType=" + sourceType + ", "
        + "status=" + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Image) {
      Image that = (Image) o;
      return
          Objects.equals(this.archiveSizeBytes, that.getArchiveSizeBytes()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.deprecated, that.getDeprecated()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.diskSizeGb, that.getDiskSizeGb()) &&
          Objects.equals(this.family, that.getFamily()) &&
          Objects.equals(this.guestOsFeatures, that.getGuestOsFeaturesList()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.imageEncryptionKey, that.getImageEncryptionKey()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.licenses, that.getLicensesList()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.rawDisk, that.getRawDisk()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.sourceDisk, that.getSourceDisk()) &&
          Objects.equals(this.sourceDiskEncryptionKey, that.getSourceDiskEncryptionKey()) &&
          Objects.equals(this.sourceDiskId, that.getSourceDiskId()) &&
          Objects.equals(this.sourceType, that.getSourceType()) &&
          Objects.equals(this.status, that.getStatus())
          ;
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
      licenses,
      name,
      rawDisk,
      selfLink,
      sourceDisk,
      sourceDiskEncryptionKey,
      sourceDiskId,
      sourceType,
      status
    );
  }
}
