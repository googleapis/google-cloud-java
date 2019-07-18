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
 * Represents an Interconnect Attachment (VLAN) Location resource.
 *
 * <p>You can use this resource to find location details about an Interconnect attachment (VLAN).
 * For more information about interconnect attachments, read Creating VLAN Attachments.
 */
public final class InterconnectLocation implements ApiMessage {
  private final String address;
  private final String availabilityZone;
  private final String city;
  private final String continent;
  private final String creationTimestamp;
  private final String description;
  private final String facilityProvider;
  private final String facilityProviderFacilityId;
  private final String id;
  private final String kind;
  private final String name;
  private final String peeringdbFacilityId;
  private final List<InterconnectLocationRegionInfo> regionInfos;
  private final String selfLink;
  private final String status;

  private InterconnectLocation() {
    this.address = null;
    this.availabilityZone = null;
    this.city = null;
    this.continent = null;
    this.creationTimestamp = null;
    this.description = null;
    this.facilityProvider = null;
    this.facilityProviderFacilityId = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.peeringdbFacilityId = null;
    this.regionInfos = null;
    this.selfLink = null;
    this.status = null;
  }

  private InterconnectLocation(
      String address,
      String availabilityZone,
      String city,
      String continent,
      String creationTimestamp,
      String description,
      String facilityProvider,
      String facilityProviderFacilityId,
      String id,
      String kind,
      String name,
      String peeringdbFacilityId,
      List<InterconnectLocationRegionInfo> regionInfos,
      String selfLink,
      String status) {
    this.address = address;
    this.availabilityZone = availabilityZone;
    this.city = city;
    this.continent = continent;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.facilityProvider = facilityProvider;
    this.facilityProviderFacilityId = facilityProviderFacilityId;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.peeringdbFacilityId = peeringdbFacilityId;
    this.regionInfos = regionInfos;
    this.selfLink = selfLink;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("address".equals(fieldName)) {
      return address;
    }
    if ("availabilityZone".equals(fieldName)) {
      return availabilityZone;
    }
    if ("city".equals(fieldName)) {
      return city;
    }
    if ("continent".equals(fieldName)) {
      return continent;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("facilityProvider".equals(fieldName)) {
      return facilityProvider;
    }
    if ("facilityProviderFacilityId".equals(fieldName)) {
      return facilityProviderFacilityId;
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
    if ("peeringdbFacilityId".equals(fieldName)) {
      return peeringdbFacilityId;
    }
    if ("regionInfos".equals(fieldName)) {
      return regionInfos;
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

  /**
   * [Output Only] The postal address of the Point of Presence, each line in the address is
   * separated by a newline character.
   */
  public String getAddress() {
    return address;
  }

  /**
   * [Output Only] Availability zone for this InterconnectLocation. Within a metropolitan area
   * (metro), maintenance will not be simultaneously scheduled in more than one availability zone.
   * Example: "zone1" or "zone2".
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * [Output Only] Metropolitan area designator that indicates which city an interconnect is
   * located. For example: "Chicago, IL", "Amsterdam, Netherlands".
   */
  public String getCity() {
    return city;
  }

  /**
   * [Output Only] Continent for this location, which can take one of the following values: - AFRICA
   * - ASIA_PAC - EUROPE - NORTH_AMERICA - SOUTH_AMERICA
   */
  public String getContinent() {
    return continent;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] An optional description of the resource. */
  public String getDescription() {
    return description;
  }

  /** [Output Only] The name of the provider for this facility (e.g., EQUINIX). */
  public String getFacilityProvider() {
    return facilityProvider;
  }

  /** [Output Only] A provider-assigned Identifier for this facility (e.g., Ashburn-DC1). */
  public String getFacilityProviderFacilityId() {
    return facilityProviderFacilityId;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] Type of the resource. Always compute#interconnectLocation for interconnect
   * locations.
   */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /**
   * [Output Only] The peeringdb identifier for this facility (corresponding with a netfac type in
   * peeringdb).
   */
  public String getPeeringdbFacilityId() {
    return peeringdbFacilityId;
  }

  /**
   * [Output Only] A list of InterconnectLocation.RegionInfo objects, that describe parameters
   * pertaining to the relation between this InterconnectLocation and various Google Cloud regions.
   */
  public List<InterconnectLocationRegionInfo> getRegionInfosList() {
    return regionInfos;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The status of this InterconnectLocation, which can take one of the following
   * values: - CLOSED: The InterconnectLocation is closed and is unavailable for provisioning new
   * Interconnects. - AVAILABLE: The InterconnectLocation is available for provisioning new
   * Interconnects.
   */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectLocation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectLocation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectLocation DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectLocation();
  }

  public static class Builder {
    private String address;
    private String availabilityZone;
    private String city;
    private String continent;
    private String creationTimestamp;
    private String description;
    private String facilityProvider;
    private String facilityProviderFacilityId;
    private String id;
    private String kind;
    private String name;
    private String peeringdbFacilityId;
    private List<InterconnectLocationRegionInfo> regionInfos;
    private String selfLink;
    private String status;

    Builder() {}

    public Builder mergeFrom(InterconnectLocation other) {
      if (other == InterconnectLocation.getDefaultInstance()) return this;
      if (other.getAddress() != null) {
        this.address = other.address;
      }
      if (other.getAvailabilityZone() != null) {
        this.availabilityZone = other.availabilityZone;
      }
      if (other.getCity() != null) {
        this.city = other.city;
      }
      if (other.getContinent() != null) {
        this.continent = other.continent;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFacilityProvider() != null) {
        this.facilityProvider = other.facilityProvider;
      }
      if (other.getFacilityProviderFacilityId() != null) {
        this.facilityProviderFacilityId = other.facilityProviderFacilityId;
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
      if (other.getPeeringdbFacilityId() != null) {
        this.peeringdbFacilityId = other.peeringdbFacilityId;
      }
      if (other.getRegionInfosList() != null) {
        this.regionInfos = other.regionInfos;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(InterconnectLocation source) {
      this.address = source.address;
      this.availabilityZone = source.availabilityZone;
      this.city = source.city;
      this.continent = source.continent;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.facilityProvider = source.facilityProvider;
      this.facilityProviderFacilityId = source.facilityProviderFacilityId;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.peeringdbFacilityId = source.peeringdbFacilityId;
      this.regionInfos = source.regionInfos;
      this.selfLink = source.selfLink;
      this.status = source.status;
    }

    /**
     * [Output Only] The postal address of the Point of Presence, each line in the address is
     * separated by a newline character.
     */
    public String getAddress() {
      return address;
    }

    /**
     * [Output Only] The postal address of the Point of Presence, each line in the address is
     * separated by a newline character.
     */
    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    /**
     * [Output Only] Availability zone for this InterconnectLocation. Within a metropolitan area
     * (metro), maintenance will not be simultaneously scheduled in more than one availability zone.
     * Example: "zone1" or "zone2".
     */
    public String getAvailabilityZone() {
      return availabilityZone;
    }

    /**
     * [Output Only] Availability zone for this InterconnectLocation. Within a metropolitan area
     * (metro), maintenance will not be simultaneously scheduled in more than one availability zone.
     * Example: "zone1" or "zone2".
     */
    public Builder setAvailabilityZone(String availabilityZone) {
      this.availabilityZone = availabilityZone;
      return this;
    }

    /**
     * [Output Only] Metropolitan area designator that indicates which city an interconnect is
     * located. For example: "Chicago, IL", "Amsterdam, Netherlands".
     */
    public String getCity() {
      return city;
    }

    /**
     * [Output Only] Metropolitan area designator that indicates which city an interconnect is
     * located. For example: "Chicago, IL", "Amsterdam, Netherlands".
     */
    public Builder setCity(String city) {
      this.city = city;
      return this;
    }

    /**
     * [Output Only] Continent for this location, which can take one of the following values: -
     * AFRICA - ASIA_PAC - EUROPE - NORTH_AMERICA - SOUTH_AMERICA
     */
    public String getContinent() {
      return continent;
    }

    /**
     * [Output Only] Continent for this location, which can take one of the following values: -
     * AFRICA - ASIA_PAC - EUROPE - NORTH_AMERICA - SOUTH_AMERICA
     */
    public Builder setContinent(String continent) {
      this.continent = continent;
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

    /** [Output Only] An optional description of the resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] An optional description of the resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** [Output Only] The name of the provider for this facility (e.g., EQUINIX). */
    public String getFacilityProvider() {
      return facilityProvider;
    }

    /** [Output Only] The name of the provider for this facility (e.g., EQUINIX). */
    public Builder setFacilityProvider(String facilityProvider) {
      this.facilityProvider = facilityProvider;
      return this;
    }

    /** [Output Only] A provider-assigned Identifier for this facility (e.g., Ashburn-DC1). */
    public String getFacilityProviderFacilityId() {
      return facilityProviderFacilityId;
    }

    /** [Output Only] A provider-assigned Identifier for this facility (e.g., Ashburn-DC1). */
    public Builder setFacilityProviderFacilityId(String facilityProviderFacilityId) {
      this.facilityProviderFacilityId = facilityProviderFacilityId;
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

    /**
     * [Output Only] Type of the resource. Always compute#interconnectLocation for interconnect
     * locations.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#interconnectLocation for interconnect
     * locations.
     */
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
     * [Output Only] The peeringdb identifier for this facility (corresponding with a netfac type in
     * peeringdb).
     */
    public String getPeeringdbFacilityId() {
      return peeringdbFacilityId;
    }

    /**
     * [Output Only] The peeringdb identifier for this facility (corresponding with a netfac type in
     * peeringdb).
     */
    public Builder setPeeringdbFacilityId(String peeringdbFacilityId) {
      this.peeringdbFacilityId = peeringdbFacilityId;
      return this;
    }

    /**
     * [Output Only] A list of InterconnectLocation.RegionInfo objects, that describe parameters
     * pertaining to the relation between this InterconnectLocation and various Google Cloud
     * regions.
     */
    public List<InterconnectLocationRegionInfo> getRegionInfosList() {
      return regionInfos;
    }

    /**
     * [Output Only] A list of InterconnectLocation.RegionInfo objects, that describe parameters
     * pertaining to the relation between this InterconnectLocation and various Google Cloud
     * regions.
     */
    public Builder addAllRegionInfos(List<InterconnectLocationRegionInfo> regionInfos) {
      if (this.regionInfos == null) {
        this.regionInfos = new LinkedList<>();
      }
      this.regionInfos.addAll(regionInfos);
      return this;
    }

    /**
     * [Output Only] A list of InterconnectLocation.RegionInfo objects, that describe parameters
     * pertaining to the relation between this InterconnectLocation and various Google Cloud
     * regions.
     */
    public Builder addRegionInfos(InterconnectLocationRegionInfo regionInfos) {
      if (this.regionInfos == null) {
        this.regionInfos = new LinkedList<>();
      }
      this.regionInfos.add(regionInfos);
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
     * [Output Only] The status of this InterconnectLocation, which can take one of the following
     * values: - CLOSED: The InterconnectLocation is closed and is unavailable for provisioning new
     * Interconnects. - AVAILABLE: The InterconnectLocation is available for provisioning new
     * Interconnects.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of this InterconnectLocation, which can take one of the following
     * values: - CLOSED: The InterconnectLocation is closed and is unavailable for provisioning new
     * Interconnects. - AVAILABLE: The InterconnectLocation is available for provisioning new
     * Interconnects.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public InterconnectLocation build() {

      return new InterconnectLocation(
          address,
          availabilityZone,
          city,
          continent,
          creationTimestamp,
          description,
          facilityProvider,
          facilityProviderFacilityId,
          id,
          kind,
          name,
          peeringdbFacilityId,
          regionInfos,
          selfLink,
          status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAddress(this.address);
      newBuilder.setAvailabilityZone(this.availabilityZone);
      newBuilder.setCity(this.city);
      newBuilder.setContinent(this.continent);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setFacilityProvider(this.facilityProvider);
      newBuilder.setFacilityProviderFacilityId(this.facilityProviderFacilityId);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setPeeringdbFacilityId(this.peeringdbFacilityId);
      newBuilder.addAllRegionInfos(this.regionInfos);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectLocation{"
        + "address="
        + address
        + ", "
        + "availabilityZone="
        + availabilityZone
        + ", "
        + "city="
        + city
        + ", "
        + "continent="
        + continent
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "facilityProvider="
        + facilityProvider
        + ", "
        + "facilityProviderFacilityId="
        + facilityProviderFacilityId
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
        + "peeringdbFacilityId="
        + peeringdbFacilityId
        + ", "
        + "regionInfos="
        + regionInfos
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
    if (o instanceof InterconnectLocation) {
      InterconnectLocation that = (InterconnectLocation) o;
      return Objects.equals(this.address, that.getAddress())
          && Objects.equals(this.availabilityZone, that.getAvailabilityZone())
          && Objects.equals(this.city, that.getCity())
          && Objects.equals(this.continent, that.getContinent())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.facilityProvider, that.getFacilityProvider())
          && Objects.equals(this.facilityProviderFacilityId, that.getFacilityProviderFacilityId())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peeringdbFacilityId, that.getPeeringdbFacilityId())
          && Objects.equals(this.regionInfos, that.getRegionInfosList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        address,
        availabilityZone,
        city,
        continent,
        creationTimestamp,
        description,
        facilityProvider,
        facilityProviderFacilityId,
        id,
        kind,
        name,
        peeringdbFacilityId,
        regionInfos,
        selfLink,
        status);
  }
}
