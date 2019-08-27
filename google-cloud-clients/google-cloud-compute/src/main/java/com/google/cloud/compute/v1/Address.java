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
 * Represents an IP Address resource.
 *
 * <p>An address resource represents a regional internal IP address. Regional internal IP addresses
 * are RFC 1918 addresses that come from either a primary or secondary IP range of a subnet in a VPC
 * network. Regional external IP addresses can be assigned to GCP VM instances, Cloud VPN gateways,
 * regional external forwarding rules for network load balancers (in either Standard or Premium
 * Tier), and regional external forwarding rules for HTTP(S), SSL Proxy, and TCP Proxy load
 * balancers in Standard Tier. For more information, read IP addresses.
 *
 * <p>A globalAddresses resource represent a global external IP address. Global external IP
 * addresses are IPv4 or IPv6 addresses. They can only be assigned to global forwarding rules for
 * HTTP(S), SSL Proxy, or TCP Proxy load balancers in Premium Tier. For more information, read
 * Global resources. (== resource_for beta.addresses ==) (== resource_for v1.addresses ==) (==
 * resource_for beta.globalAddresses ==) (== resource_for v1.globalAddresses ==)
 */
public final class Address implements ApiMessage {
  private final String address;
  private final String addressType;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String ipVersion;
  private final String kind;
  private final String name;
  private final String network;
  private final String networkTier;
  private final Integer prefixLength;
  private final String purpose;
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
    this.network = null;
    this.networkTier = null;
    this.prefixLength = null;
    this.purpose = null;
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
      String network,
      String networkTier,
      Integer prefixLength,
      String purpose,
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
    this.network = network;
    this.networkTier = networkTier;
    this.prefixLength = prefixLength;
    this.purpose = purpose;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.subnetwork = subnetwork;
    this.users = users;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("address".equals(fieldName)) {
      return address;
    }
    if ("addressType".equals(fieldName)) {
      return addressType;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("ipVersion".equals(fieldName)) {
      return ipVersion;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("networkTier".equals(fieldName)) {
      return networkTier;
    }
    if ("prefixLength".equals(fieldName)) {
      return prefixLength;
    }
    if ("purpose".equals(fieldName)) {
      return purpose;
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
    if ("subnetwork".equals(fieldName)) {
      return subnetwork;
    }
    if ("users".equals(fieldName)) {
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** The static IP address represented by this resource. */
  public String getAddress() {
    return address;
  }

  /**
   * The type of address to reserve, either INTERNAL or EXTERNAL. If unspecified, defaults to
   * EXTERNAL.
   */
  public String getAddressType() {
    return addressType;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** An optional description of this resource. Provide this field when you create the resource. */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * The IP version that will be used by this address. Valid options are IPV4 or IPV6. This can only
   * be specified for a global address.
   */
  public String getIpVersion() {
    return ipVersion;
  }

  /** [Output Only] Type of the resource. Always compute#address for addresses. */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`. The first character
   * must be a lowercase letter, and all following characters (except for the last character) must
   * be a dash, lowercase letter, or digit. The last character must be a lowercase letter or digit.
   */
  public String getName() {
    return name;
  }

  /**
   * The URL of the network in which to reserve the address. This field can only be used with
   * INTERNAL type with the VPC_PEERING purpose.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * This signifies the networking tier used for configuring this address and can only take the
   * following values: PREMIUM or STANDARD. Global forwarding rules can only be Premium Tier.
   * Regional forwarding rules can be either Premium or Standard Tier. Standard Tier addresses
   * applied to regional forwarding rules can be used with any external load balancer. Regional
   * forwarding rules in Premium Tier can only be used with a network load balancer.
   *
   * <p>If this field is not specified, it is assumed to be PREMIUM.
   */
  public String getNetworkTier() {
    return networkTier;
  }

  /** The prefix length if the resource reprensents an IP range. */
  public Integer getPrefixLength() {
    return prefixLength;
  }

  /**
   * The purpose of this resource, which can be one of the following values: - `GCE_ENDPOINT` for
   * addresses that are used by VM instances, alias IP ranges, internal load balancers, and similar
   * resources. - `DNS_RESOLVER` for a DNS resolver address in a subnetwork - `VPC_PEERING` for
   * addresses that are reserved for VPC peer networks. - `NAT_AUTO` for addresses that are external
   * IP addresses automatically reserved for Cloud NAT.
   */
  public String getPurpose() {
    return purpose;
  }

  /**
   * [Output Only] The URL of the region where the regional address resides. This field is not
   * applicable to global addresses. You must specify this field as part of the HTTP request URL.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The status of the address, which can be one of RESERVING, RESERVED, or IN_USE. An
   * address that is RESERVING is currently in the process of being reserved. A RESERVED address is
   * currently reserved and available to use. An IN_USE address is currently being used by another
   * resource and is not available.
   */
  public String getStatus() {
    return status;
  }

  /**
   * The URL of the subnetwork in which to reserve the address. If an IP address is specified, it
   * must be within the subnetwork's IP range. This field can only be used with INTERNAL type with a
   * GCE_ENDPOINT or DNS_RESOLVER purpose.
   */
  public String getSubnetwork() {
    return subnetwork;
  }

  /** [Output Only] The URLs of the resources that are using this address. */
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
    private String network;
    private String networkTier;
    private Integer prefixLength;
    private String purpose;
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
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getNetworkTier() != null) {
        this.networkTier = other.networkTier;
      }
      if (other.getPrefixLength() != null) {
        this.prefixLength = other.prefixLength;
      }
      if (other.getPurpose() != null) {
        this.purpose = other.purpose;
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
      this.network = source.network;
      this.networkTier = source.networkTier;
      this.prefixLength = source.prefixLength;
      this.purpose = source.purpose;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.subnetwork = source.subnetwork;
      this.users = source.users;
    }

    /** The static IP address represented by this resource. */
    public String getAddress() {
      return address;
    }

    /** The static IP address represented by this resource. */
    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    /**
     * The type of address to reserve, either INTERNAL or EXTERNAL. If unspecified, defaults to
     * EXTERNAL.
     */
    public String getAddressType() {
      return addressType;
    }

    /**
     * The type of address to reserve, either INTERNAL or EXTERNAL. If unspecified, defaults to
     * EXTERNAL.
     */
    public Builder setAddressType(String addressType) {
      this.addressType = addressType;
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

    /**
     * An optional description of this resource. Provide this field when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this field when you create the resource.
     */
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

    /**
     * The IP version that will be used by this address. Valid options are IPV4 or IPV6. This can
     * only be specified for a global address.
     */
    public String getIpVersion() {
      return ipVersion;
    }

    /**
     * The IP version that will be used by this address. Valid options are IPV4 or IPV6. This can
     * only be specified for a global address.
     */
    public Builder setIpVersion(String ipVersion) {
      this.ipVersion = ipVersion;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#address for addresses. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#address for addresses. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`. The first character
     * must be a lowercase letter, and all following characters (except for the last character) must
     * be a dash, lowercase letter, or digit. The last character must be a lowercase letter or
     * digit.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`. The first character
     * must be a lowercase letter, and all following characters (except for the last character) must
     * be a dash, lowercase letter, or digit. The last character must be a lowercase letter or
     * digit.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The URL of the network in which to reserve the address. This field can only be used with
     * INTERNAL type with the VPC_PEERING purpose.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * The URL of the network in which to reserve the address. This field can only be used with
     * INTERNAL type with the VPC_PEERING purpose.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * This signifies the networking tier used for configuring this address and can only take the
     * following values: PREMIUM or STANDARD. Global forwarding rules can only be Premium Tier.
     * Regional forwarding rules can be either Premium or Standard Tier. Standard Tier addresses
     * applied to regional forwarding rules can be used with any external load balancer. Regional
     * forwarding rules in Premium Tier can only be used with a network load balancer.
     *
     * <p>If this field is not specified, it is assumed to be PREMIUM.
     */
    public String getNetworkTier() {
      return networkTier;
    }

    /**
     * This signifies the networking tier used for configuring this address and can only take the
     * following values: PREMIUM or STANDARD. Global forwarding rules can only be Premium Tier.
     * Regional forwarding rules can be either Premium or Standard Tier. Standard Tier addresses
     * applied to regional forwarding rules can be used with any external load balancer. Regional
     * forwarding rules in Premium Tier can only be used with a network load balancer.
     *
     * <p>If this field is not specified, it is assumed to be PREMIUM.
     */
    public Builder setNetworkTier(String networkTier) {
      this.networkTier = networkTier;
      return this;
    }

    /** The prefix length if the resource reprensents an IP range. */
    public Integer getPrefixLength() {
      return prefixLength;
    }

    /** The prefix length if the resource reprensents an IP range. */
    public Builder setPrefixLength(Integer prefixLength) {
      this.prefixLength = prefixLength;
      return this;
    }

    /**
     * The purpose of this resource, which can be one of the following values: - `GCE_ENDPOINT` for
     * addresses that are used by VM instances, alias IP ranges, internal load balancers, and
     * similar resources. - `DNS_RESOLVER` for a DNS resolver address in a subnetwork -
     * `VPC_PEERING` for addresses that are reserved for VPC peer networks. - `NAT_AUTO` for
     * addresses that are external IP addresses automatically reserved for Cloud NAT.
     */
    public String getPurpose() {
      return purpose;
    }

    /**
     * The purpose of this resource, which can be one of the following values: - `GCE_ENDPOINT` for
     * addresses that are used by VM instances, alias IP ranges, internal load balancers, and
     * similar resources. - `DNS_RESOLVER` for a DNS resolver address in a subnetwork -
     * `VPC_PEERING` for addresses that are reserved for VPC peer networks. - `NAT_AUTO` for
     * addresses that are external IP addresses automatically reserved for Cloud NAT.
     */
    public Builder setPurpose(String purpose) {
      this.purpose = purpose;
      return this;
    }

    /**
     * [Output Only] The URL of the region where the regional address resides. This field is not
     * applicable to global addresses. You must specify this field as part of the HTTP request URL.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] The URL of the region where the regional address resides. This field is not
     * applicable to global addresses. You must specify this field as part of the HTTP request URL.
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
     * [Output Only] The status of the address, which can be one of RESERVING, RESERVED, or IN_USE.
     * An address that is RESERVING is currently in the process of being reserved. A RESERVED
     * address is currently reserved and available to use. An IN_USE address is currently being used
     * by another resource and is not available.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the address, which can be one of RESERVING, RESERVED, or IN_USE.
     * An address that is RESERVING is currently in the process of being reserved. A RESERVED
     * address is currently reserved and available to use. An IN_USE address is currently being used
     * by another resource and is not available.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * The URL of the subnetwork in which to reserve the address. If an IP address is specified, it
     * must be within the subnetwork's IP range. This field can only be used with INTERNAL type with
     * a GCE_ENDPOINT or DNS_RESOLVER purpose.
     */
    public String getSubnetwork() {
      return subnetwork;
    }

    /**
     * The URL of the subnetwork in which to reserve the address. If an IP address is specified, it
     * must be within the subnetwork's IP range. This field can only be used with INTERNAL type with
     * a GCE_ENDPOINT or DNS_RESOLVER purpose.
     */
    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    /** [Output Only] The URLs of the resources that are using this address. */
    public List<String> getUsersList() {
      return users;
    }

    /** [Output Only] The URLs of the resources that are using this address. */
    public Builder addAllUsers(List<String> users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
      this.users.addAll(users);
      return this;
    }

    /** [Output Only] The URLs of the resources that are using this address. */
    public Builder addUsers(String users) {
      if (this.users == null) {
        this.users = new LinkedList<>();
      }
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
          network,
          networkTier,
          prefixLength,
          purpose,
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
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkTier(this.networkTier);
      newBuilder.setPrefixLength(this.prefixLength);
      newBuilder.setPurpose(this.purpose);
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
        + "network="
        + network
        + ", "
        + "networkTier="
        + networkTier
        + ", "
        + "prefixLength="
        + prefixLength
        + ", "
        + "purpose="
        + purpose
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
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkTier, that.getNetworkTier())
          && Objects.equals(this.prefixLength, that.getPrefixLength())
          && Objects.equals(this.purpose, that.getPurpose())
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
        network,
        networkTier,
        prefixLength,
        purpose,
        region,
        selfLink,
        status,
        subnetwork,
        users);
  }
}
