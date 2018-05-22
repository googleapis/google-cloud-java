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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class Address implements ApiMessage {
  private final String address;
  private final String addressType;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String ipVersion;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String status;
  private final String subnetwork;
  private final List<String> users;

  private Address() {
    this.address = null;
    this.addressType = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.ipVersion = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
    this.subnetwork = null;
    this.users = null;
  }

  private Address(
      String address,
      String addressType,
      String creationTimestamp,
      String description,
      String id,
      String ipVersion,
      String kind,
      String name,
      String region,
      String selfLink,
      String status,
      String subnetwork,
      List<String> users) {
    this.address = address;
    this.addressType = addressType;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.ipVersion = ipVersion;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.subnetwork = subnetwork;
    this.users = users;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("address")) {
      return address;
    }
    if (fieldName.equals("addressType")) {
      return addressType;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("ipVersion")) {
      return ipVersion;
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
    if (fieldName.equals("status")) {
      return status;
    }
    if (fieldName.equals("subnetwork")) {
      return subnetwork;
    }
    if (fieldName.equals("users")) {
      return users;
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

  public String getAddress() {
    return address;
  }

  public String getAddressType() {
    return addressType;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getIpVersion() {
    return ipVersion;
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

  public String getStatus() {
    return status;
  }

  public String getSubnetwork() {
    return subnetwork;
  }

  public List<String> getUsersList() {
    return users;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Address prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Address getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Address DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Address();
  }

  public static class Builder {
    private String address;
    private String addressType;
    private String creationTimestamp;
    private String description;
    private String id;
    private String ipVersion;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String status;
    private String subnetwork;
    private List<String> users;

    Builder() {}

    public Builder mergeFrom(Address other) {
      if (other == Address.getDefaultInstance()) return this;
      if (other.getAddress() != null) {
        this.address = other.address;
      }
      if (other.getAddressType() != null) {
        this.addressType = other.addressType;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpVersion() != null) {
        this.ipVersion = other.ipVersion;
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
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getUsersList() != null) {
        this.users = other.users;
      }
      return this;
    }

    Builder(Address source) {
      this.address = source.address;
      this.addressType = source.addressType;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.ipVersion = source.ipVersion;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.subnetwork = source.subnetwork;
      this.users = source.users;
    }

    public String getAddress() {
      return address;
    }

    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    public String getAddressType() {
      return addressType;
    }

    public Builder setAddressType(String addressType) {
      this.addressType = addressType;
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

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getIpVersion() {
      return ipVersion;
    }

    public Builder setIpVersion(String ipVersion) {
      this.ipVersion = ipVersion;
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

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getSubnetwork() {
      return subnetwork;
    }

    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
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

    public Address build() {

      return new Address(
          address,
          addressType,
          creationTimestamp,
          description,
          id,
          ipVersion,
          kind,
          name,
          region,
          selfLink,
          status,
          subnetwork,
          users);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAddress(this.address);
      newBuilder.setAddressType(this.addressType);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setIpVersion(this.ipVersion);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.addAllUsers(this.users);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Address{"
        + "address="
        + address
        + ", "
        + "addressType="
        + addressType
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "ipVersion="
        + ipVersion
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
        + ", "
        + "subnetwork="
        + subnetwork
        + ", "
        + "users="
        + users
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Address) {
      Address that = (Address) o;
      return Objects.equals(this.address, that.getAddress())
          && Objects.equals(this.addressType, that.getAddressType())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipVersion, that.getIpVersion())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.users, that.getUsersList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        address,
        addressType,
        creationTimestamp,
        description,
        id,
        ipVersion,
        kind,
        name,
        region,
        selfLink,
        status,
        subnetwork,
        users);
  }
}
