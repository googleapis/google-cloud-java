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
/** Region resource. (== resource_for beta.regions ==) (== resource_for v1.regions ==) */
public final class Region implements ApiMessage {
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final List<Quota> quotas;
  private final String selfLink;
  private final String status;
  private final List<String> zones;

  private Region() {
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.quotas = null;
    this.selfLink = null;
    this.status = null;
    this.zones = null;
  }

  private Region(
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      String id,
      String kind,
      String name,
      List<Quota> quotas,
      String selfLink,
      String status,
      List<String> zones) {
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.quotas = quotas;
    this.selfLink = selfLink;
    this.status = status;
    this.zones = zones;
  }

  @Override
  public Object getFieldValue(String fieldName) {
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
    if ("quotas".equals(fieldName)) {
      return quotas;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("zones".equals(fieldName)) {
      return zones;
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

  /** [Output Only] The deprecation status associated with this region. */
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

  /** [Output Only] Type of the resource. Always compute#region for regions. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] Quotas assigned to this region. */
  public List<Quota> getQuotasList() {
    return quotas;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Status of the region, either UP or DOWN. */
  public String getStatus() {
    return status;
  }

  /** [Output Only] A list of zones available in this region, in the form of resource URLs. */
  public List<String> getZonesList() {
    return zones;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Region prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Region getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Region DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Region();
  }

  public static class Builder {
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private String id;
    private String kind;
    private String name;
    private List<Quota> quotas;
    private String selfLink;
    private String status;
    private List<String> zones;

    Builder() {}

    public Builder mergeFrom(Region other) {
      if (other == Region.getDefaultInstance()) return this;
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
      if (other.getQuotasList() != null) {
        this.quotas = other.quotas;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getZonesList() != null) {
        this.zones = other.zones;
      }
      return this;
    }

    Builder(Region source) {
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.quotas = source.quotas;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.zones = source.zones;
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

    /** [Output Only] The deprecation status associated with this region. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this region. */
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

    /** [Output Only] Type of the resource. Always compute#region for regions. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#region for regions. */
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

    /** [Output Only] Quotas assigned to this region. */
    public List<Quota> getQuotasList() {
      return quotas;
    }

    /** [Output Only] Quotas assigned to this region. */
    public Builder addAllQuotas(List<Quota> quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.addAll(quotas);
      return this;
    }

    /** [Output Only] Quotas assigned to this region. */
    public Builder addQuotas(Quota quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.add(quotas);
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

    /** [Output Only] Status of the region, either UP or DOWN. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] Status of the region, either UP or DOWN. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] A list of zones available in this region, in the form of resource URLs. */
    public List<String> getZonesList() {
      return zones;
    }

    /** [Output Only] A list of zones available in this region, in the form of resource URLs. */
    public Builder addAllZones(List<String> zones) {
      if (this.zones == null) {
        this.zones = new LinkedList<>();
      }
      this.zones.addAll(zones);
      return this;
    }

    /** [Output Only] A list of zones available in this region, in the form of resource URLs. */
    public Builder addZones(String zones) {
      if (this.zones == null) {
        this.zones = new LinkedList<>();
      }
      this.zones.add(zones);
      return this;
    }

    public Region build() {

      return new Region(
          creationTimestamp,
          deprecated,
          description,
          id,
          kind,
          name,
          quotas,
          selfLink,
          status,
          zones);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllQuotas(this.quotas);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.addAllZones(this.zones);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Region{"
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
        + "quotas="
        + quotas
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "status="
        + status
        + ", "
        + "zones="
        + zones
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Region) {
      Region that = (Region) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.quotas, that.getQuotasList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.zones, that.getZonesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        deprecated,
        description,
        id,
        kind,
        name,
        quotas,
        selfLink,
        status,
        zones);
  }
}
