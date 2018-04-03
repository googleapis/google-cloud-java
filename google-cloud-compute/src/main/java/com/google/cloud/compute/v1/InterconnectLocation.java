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
      String selfLink
      ) {
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
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("address") && address != null) {
      fieldMap.put("address", Collections.singletonList(String.valueOf(address)));
    }
    if (fieldNames.contains("availabilityZone") && availabilityZone != null) {
      fieldMap.put("availabilityZone", Collections.singletonList(String.valueOf(availabilityZone)));
    }
    if (fieldNames.contains("city") && city != null) {
      fieldMap.put("city", Collections.singletonList(String.valueOf(city)));
    }
    if (fieldNames.contains("continent") && continent != null) {
      fieldMap.put("continent", Collections.singletonList(String.valueOf(continent)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("facilityProvider") && facilityProvider != null) {
      fieldMap.put("facilityProvider", Collections.singletonList(String.valueOf(facilityProvider)));
    }
    if (fieldNames.contains("facilityProviderFacilityId") && facilityProviderFacilityId != null) {
      fieldMap.put("facilityProviderFacilityId", Collections.singletonList(String.valueOf(facilityProviderFacilityId)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("peeringdbFacilityId") && peeringdbFacilityId != null) {
      fieldMap.put("peeringdbFacilityId", Collections.singletonList(String.valueOf(peeringdbFacilityId)));
    }
    if (fieldNames.contains("regionInfos") && regionInfos != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (InterconnectLocationRegionInfo item : regionInfos) {
        stringList.add(item.toString());
      }
      fieldMap.put("regionInfos", stringList.build());
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("address")) {
      return String.valueOf(address);
    }
    if (fieldName.equals("availabilityZone")) {
      return String.valueOf(availabilityZone);
    }
    if (fieldName.equals("city")) {
      return String.valueOf(city);
    }
    if (fieldName.equals("continent")) {
      return String.valueOf(continent);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("facilityProvider")) {
      return String.valueOf(facilityProvider);
    }
    if (fieldName.equals("facilityProviderFacilityId")) {
      return String.valueOf(facilityProviderFacilityId);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("peeringdbFacilityId")) {
      return String.valueOf(peeringdbFacilityId);
    }
    if (fieldName.equals("regionInfos")) {
      return String.valueOf(regionInfos);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getAddress() {
    return address;
  }

  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public String getCity() {
    return city;
  }

  public String getContinent() {
    return continent;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getFacilityProvider() {
    return facilityProvider;
  }

  public String getFacilityProviderFacilityId() {
    return facilityProviderFacilityId;
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

  public String getPeeringdbFacilityId() {
    return peeringdbFacilityId;
  }

  public List<InterconnectLocationRegionInfo> getRegionInfosList() {
    return regionInfos;
  }

  public String getSelfLink() {
    return selfLink;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(InterconnectLocation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
    }

    public String getAddress() {
      return address;
    }

    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    public String getAvailabilityZone() {
      return availabilityZone;
    }

    public Builder setAvailabilityZone(String availabilityZone) {
      this.availabilityZone = availabilityZone;
      return this;
    }

    public String getCity() {
      return city;
    }

    public Builder setCity(String city) {
      this.city = city;
      return this;
    }

    public String getContinent() {
      return continent;
    }

    public Builder setContinent(String continent) {
      this.continent = continent;
      return this;
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

    public String getFacilityProvider() {
      return facilityProvider;
    }

    public Builder setFacilityProvider(String facilityProvider) {
      this.facilityProvider = facilityProvider;
      return this;
    }

    public String getFacilityProviderFacilityId() {
      return facilityProviderFacilityId;
    }

    public Builder setFacilityProviderFacilityId(String facilityProviderFacilityId) {
      this.facilityProviderFacilityId = facilityProviderFacilityId;
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

    public String getPeeringdbFacilityId() {
      return peeringdbFacilityId;
    }

    public Builder setPeeringdbFacilityId(String peeringdbFacilityId) {
      this.peeringdbFacilityId = peeringdbFacilityId;
      return this;
    }

    public List<InterconnectLocationRegionInfo> getRegionInfosList() {
      return regionInfos;
    }

    public Builder addAllRegionInfos(List<InterconnectLocationRegionInfo> regionInfos) {
      if (this.regionInfos == null) {
        this.regionInfos = new ArrayList<>(regionInfos.size());
      }
      this.regionInfos.addAll(regionInfos);
      return this;
    }

    public Builder addRegionInfos(InterconnectLocationRegionInfo regionInfos) {
      this.regionInfos.add(regionInfos);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
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
        selfLink
      );
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
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectLocation{"
        + "address=" + address + ", "
        + "availabilityZone=" + availabilityZone + ", "
        + "city=" + city + ", "
        + "continent=" + continent + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "facilityProvider=" + facilityProvider + ", "
        + "facilityProviderFacilityId=" + facilityProviderFacilityId + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "peeringdbFacilityId=" + peeringdbFacilityId + ", "
        + "regionInfos=" + regionInfos + ", "
        + "selfLink=" + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectLocation) {
      InterconnectLocation that = (InterconnectLocation) o;
      return
          Objects.equals(this.address, that.getAddress()) &&
          Objects.equals(this.availabilityZone, that.getAvailabilityZone()) &&
          Objects.equals(this.city, that.getCity()) &&
          Objects.equals(this.continent, that.getContinent()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.facilityProvider, that.getFacilityProvider()) &&
          Objects.equals(this.facilityProviderFacilityId, that.getFacilityProviderFacilityId()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.peeringdbFacilityId, that.getPeeringdbFacilityId()) &&
          Objects.equals(this.regionInfos, that.getRegionInfosList()) &&
          Objects.equals(this.selfLink, that.getSelfLink())
          ;
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
      selfLink
    );
  }
}
