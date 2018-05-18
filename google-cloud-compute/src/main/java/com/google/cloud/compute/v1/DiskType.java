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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class DiskType implements ApiMessage {
  private final String creationTimestamp;
  private final String defaultDiskSizeGb;
  private final DeprecationStatus deprecated;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String validDiskSize;
  private final String zone;

  private DiskType() {
    this.creationTimestamp = null;
    this.defaultDiskSizeGb = null;
    this.deprecated = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.validDiskSize = null;
    this.zone = null;
  }

  private DiskType(
      String creationTimestamp,
      String defaultDiskSizeGb,
      DeprecationStatus deprecated,
      String description,
      String id,
      String kind,
      String name,
      String region,
      String selfLink,
      String validDiskSize,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.defaultDiskSizeGb = defaultDiskSizeGb;
    this.deprecated = deprecated;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.validDiskSize = validDiskSize;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("defaultDiskSizeGb")) {
      return defaultDiskSizeGb;
    }
    if (fieldName.equals("deprecated")) {
      return deprecated;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("validDiskSize")) {
      return validDiskSize;
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

  public String getDefaultDiskSizeGb() {
    return defaultDiskSizeGb;
  }

  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getValidDiskSize() {
    return validDiskSize;
  }

  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DiskType prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DiskType getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DiskType DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DiskType();
  }

  public static class Builder {
    private String creationTimestamp;
    private String defaultDiskSizeGb;
    private DeprecationStatus deprecated;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String validDiskSize;
    private String zone;

    Builder() {}

    public Builder mergeFrom(DiskType other) {
      if (other == DiskType.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDefaultDiskSizeGb() != null) {
        this.defaultDiskSizeGb = other.defaultDiskSizeGb;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getValidDiskSize() != null) {
        this.validDiskSize = other.validDiskSize;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(DiskType source) {
      this.creationTimestamp = source.creationTimestamp;
      this.defaultDiskSizeGb = source.defaultDiskSizeGb;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.validDiskSize = source.validDiskSize;
      this.zone = source.zone;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDefaultDiskSizeGb() {
      return defaultDiskSizeGb;
    }

    public Builder setDefaultDiskSizeGb(String defaultDiskSizeGb) {
      this.defaultDiskSizeGb = defaultDiskSizeGb;
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

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getValidDiskSize() {
      return validDiskSize;
    }

    public Builder setValidDiskSize(String validDiskSize) {
      this.validDiskSize = validDiskSize;
      return this;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public DiskType build() {

      return new DiskType(
          creationTimestamp,
          defaultDiskSizeGb,
          deprecated,
          description,
          id,
          kind,
          name,
          region,
          selfLink,
          validDiskSize,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDefaultDiskSizeGb(this.defaultDiskSizeGb);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setValidDiskSize(this.validDiskSize);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DiskType{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "defaultDiskSizeGb="
        + defaultDiskSizeGb
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "validDiskSize="
        + validDiskSize
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
    if (o instanceof DiskType) {
      DiskType that = (DiskType) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.defaultDiskSizeGb, that.getDefaultDiskSizeGb())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.validDiskSize, that.getValidDiskSize())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        defaultDiskSizeGb,
        deprecated,
        description,
        id,
        kind,
        name,
        region,
        selfLink,
        validDiskSize,
        zone);
  }
}
