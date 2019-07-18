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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Zone resource.
 *
 * <p>A zone is a deployment area. These deployment areas are subsets of a region. For example the
 * zone us-east1-a is located in the us-east1 region. For more information, read Regions and Zones.
 * (== resource_for beta.zones ==) (== resource_for v1.zones ==)
 */
public final class Zone implements ApiMessage {
  private final List<String> availableCpuPlatforms;
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String status;

  private Zone() {
    this.availableCpuPlatforms = null;
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
  }

  private Zone(
      List<String> availableCpuPlatforms,
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      String id,
      String kind,
      String name,
      String region,
      String selfLink,
      String status) {
    this.availableCpuPlatforms = availableCpuPlatforms;
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("availableCpuPlatforms".equals(fieldName)) {
      return availableCpuPlatforms;
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

  /** [Output Only] Available cpu/platform selections for the zone. */
  public List<String> getAvailableCpuPlatformsList() {
    return availableCpuPlatforms;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] The deprecation status associated with this zone. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /** [Output Only] Textual description of the resource. */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#zone for zones. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] Full URL reference to the region which hosts the zone. */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Status of the zone, either UP or DOWN. */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Zone prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Zone getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Zone DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Zone();
  }

  public static class Builder {
    private List<String> availableCpuPlatforms;
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String status;

    Builder() {}

    public Builder mergeFrom(Zone other) {
      if (other == Zone.getDefaultInstance()) return this;
      if (other.getAvailableCpuPlatformsList() != null) {
        this.availableCpuPlatforms = other.availableCpuPlatforms;
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
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(Zone source) {
      this.availableCpuPlatforms = source.availableCpuPlatforms;
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
    }

    /** [Output Only] Available cpu/platform selections for the zone. */
    public List<String> getAvailableCpuPlatformsList() {
      return availableCpuPlatforms;
    }

    /** [Output Only] Available cpu/platform selections for the zone. */
    public Builder addAllAvailableCpuPlatforms(List<String> availableCpuPlatforms) {
      if (this.availableCpuPlatforms == null) {
        this.availableCpuPlatforms = new LinkedList<>();
      }
      this.availableCpuPlatforms.addAll(availableCpuPlatforms);
      return this;
    }

    /** [Output Only] Available cpu/platform selections for the zone. */
    public Builder addAvailableCpuPlatforms(String availableCpuPlatforms) {
      if (this.availableCpuPlatforms == null) {
        this.availableCpuPlatforms = new LinkedList<>();
      }
      this.availableCpuPlatforms.add(availableCpuPlatforms);
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

    /** [Output Only] The deprecation status associated with this zone. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this zone. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /** [Output Only] Textual description of the resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] Textual description of the resource. */
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

    /** [Output Only] Type of the resource. Always compute#zone for zones. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#zone for zones. */
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

    /** [Output Only] Full URL reference to the region which hosts the zone. */
    public String getRegion() {
      return region;
    }

    /** [Output Only] Full URL reference to the region which hosts the zone. */
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

    /** [Output Only] Status of the zone, either UP or DOWN. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] Status of the zone, either UP or DOWN. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public Zone build() {

      return new Zone(
          availableCpuPlatforms,
          creationTimestamp,
          deprecated,
          description,
          id,
          kind,
          name,
          region,
          selfLink,
          status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAvailableCpuPlatforms(this.availableCpuPlatforms);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Zone{"
        + "availableCpuPlatforms="
        + availableCpuPlatforms
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
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Zone) {
      Zone that = (Zone) o;
      return Objects.equals(this.availableCpuPlatforms, that.getAvailableCpuPlatformsList())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        availableCpuPlatforms,
        creationTimestamp,
        deprecated,
        description,
        id,
        kind,
        name,
        region,
        selfLink,
        status);
  }
}
