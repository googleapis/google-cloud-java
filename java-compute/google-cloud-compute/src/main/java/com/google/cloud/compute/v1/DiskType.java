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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** A DiskType resource. (== resource_for beta.diskTypes ==) (== resource_for v1.diskTypes ==) */
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
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("defaultDiskSizeGb".equals(fieldName)) {
      return defaultDiskSizeGb;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("validDiskSize".equals(fieldName)) {
      return validDiskSize;
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

  /** [Output Only] Server-defined default disk size in GB. */
  public String getDefaultDiskSizeGb() {
    return defaultDiskSizeGb;
  }

  /** [Output Only] The deprecation status associated with this disk type. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /** [Output Only] An optional description of this resource. */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#diskType for disk types. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /**
   * [Output Only] URL of the region where the disk type resides. Only applicable for regional
   * resources. You must specify this field as part of the HTTP request URL. It is not settable as a
   * field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] An optional textual description of the valid disk size, such as "10GB-10TB". */
  public String getValidDiskSize() {
    return validDiskSize;
  }

  /**
   * [Output Only] URL of the zone where the disk type resides. You must specify this field as part
   * of the HTTP request URL. It is not settable as a field in the request body.
   */
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

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /** [Output Only] Server-defined default disk size in GB. */
    public String getDefaultDiskSizeGb() {
      return defaultDiskSizeGb;
    }

    /** [Output Only] Server-defined default disk size in GB. */
    public Builder setDefaultDiskSizeGb(String defaultDiskSizeGb) {
      this.defaultDiskSizeGb = defaultDiskSizeGb;
      return this;
    }

    /** [Output Only] The deprecation status associated with this disk type. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this disk type. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /** [Output Only] An optional description of this resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] An optional description of this resource. */
    public Builder setDescription(String description) {
      this.description = description;
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

    /** [Output Only] Type of the resource. Always compute#diskType for disk types. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#diskType for disk types. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Name of the resource. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the resource. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * [Output Only] URL of the region where the disk type resides. Only applicable for regional
     * resources. You must specify this field as part of the HTTP request URL. It is not settable as
     * a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the disk type resides. Only applicable for regional
     * resources. You must specify this field as part of the HTTP request URL. It is not settable as
     * a field in the request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
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
     * [Output Only] An optional textual description of the valid disk size, such as "10GB-10TB".
     */
    public String getValidDiskSize() {
      return validDiskSize;
    }

    /**
     * [Output Only] An optional textual description of the valid disk size, such as "10GB-10TB".
     */
    public Builder setValidDiskSize(String validDiskSize) {
      this.validDiskSize = validDiskSize;
      return this;
    }

    /**
     * [Output Only] URL of the zone where the disk type resides. You must specify this field as
     * part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] URL of the zone where the disk type resides. You must specify this field as
     * part of the HTTP request URL. It is not settable as a field in the request body.
     */
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
