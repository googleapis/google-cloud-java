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
public final class RouterBgpPeer implements ApiMessage {
  private final String advertiseMode;
  private final List<String> advertisedGroups;
  private final List<RouterAdvertisedIpRange> advertisedIpRanges;
  private final Integer advertisedRoutePriority;
  private final String interfaceName;
  private final String ipAddress;
  private final String managementType;
  private final String name;
  private final Integer peerAsn;
  private final String peerIpAddress;

  private RouterBgpPeer() {
    this.advertiseMode = null;
    this.advertisedGroups = null;
    this.advertisedIpRanges = null;
    this.advertisedRoutePriority = null;
    this.interfaceName = null;
    this.ipAddress = null;
    this.managementType = null;
    this.name = null;
    this.peerAsn = null;
    this.peerIpAddress = null;
  }

  private RouterBgpPeer(
      String advertiseMode,
      List<String> advertisedGroups,
      List<RouterAdvertisedIpRange> advertisedIpRanges,
      Integer advertisedRoutePriority,
      String interfaceName,
      String ipAddress,
      String managementType,
      String name,
      Integer peerAsn,
      String peerIpAddress) {
    this.advertiseMode = advertiseMode;
    this.advertisedGroups = advertisedGroups;
    this.advertisedIpRanges = advertisedIpRanges;
    this.advertisedRoutePriority = advertisedRoutePriority;
    this.interfaceName = interfaceName;
    this.ipAddress = ipAddress;
    this.managementType = managementType;
    this.name = name;
    this.peerAsn = peerAsn;
    this.peerIpAddress = peerIpAddress;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("advertiseMode".equals(fieldName)) {
      return advertiseMode;
    }
    if ("advertisedGroups".equals(fieldName)) {
      return advertisedGroups;
    }
    if ("advertisedIpRanges".equals(fieldName)) {
      return advertisedIpRanges;
    }
    if ("advertisedRoutePriority".equals(fieldName)) {
      return advertisedRoutePriority;
    }
    if ("interfaceName".equals(fieldName)) {
      return interfaceName;
    }
    if ("ipAddress".equals(fieldName)) {
      return ipAddress;
    }
    if ("managementType".equals(fieldName)) {
      return managementType;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("peerAsn".equals(fieldName)) {
      return peerAsn;
    }
    if ("peerIpAddress".equals(fieldName)) {
      return peerIpAddress;
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

  /** User-specified flag to indicate which mode to use for advertisement. */
  public String getAdvertiseMode() {
    return advertiseMode;
  }

  /**
   * User-specified list of prefix groups to advertise in custom mode, which can take one of the
   * following options: - ALL_SUBNETS: Advertises all available subnets, including peer VPC subnets.
   * - ALL_VPC_SUBNETS: Advertises the router's own VPC subnets. - ALL_PEER_VPC_SUBNETS: Advertises
   * peer subnets of the router's VPC network. Note that this field can only be populated if
   * advertise_mode is CUSTOM and overrides the list defined for the router (in the "bgp" message).
   * These groups are advertised in addition to any specified prefixes. Leave this field blank to
   * advertise no custom groups.
   */
  public List<String> getAdvertisedGroupsList() {
    return advertisedGroups;
  }

  /**
   * User-specified list of individual IP ranges to advertise in custom mode. This field can only be
   * populated if advertise_mode is CUSTOM and overrides the list defined for the router (in the
   * "bgp" message). These IP ranges are advertised in addition to any specified groups. Leave this
   * field blank to advertise no custom IP ranges.
   */
  public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
    return advertisedIpRanges;
  }

  /**
   * The priority of routes advertised to this BGP peer. Where there is more than one matching route
   * of maximum length, the routes with the lowest priority value win.
   */
  public Integer getAdvertisedRoutePriority() {
    return advertisedRoutePriority;
  }

  /** Name of the interface the BGP peer is associated with. */
  public String getInterfaceName() {
    return interfaceName;
  }

  /** IP address of the interface inside Google Cloud Platform. Only IPv4 is supported. */
  public String getIpAddress() {
    return ipAddress;
  }

  /**
   * [Output Only] The resource that configures and manages this BGP peer. - MANAGED_BY_USER is the
   * default value and can be managed by you or other users - MANAGED_BY_ATTACHMENT is a BGP peer
   * that is configured and managed by Cloud Interconnect, specifically by an InterconnectAttachment
   * of type PARTNER. Google automatically creates, updates, and deletes this type of BGP peer when
   * the PARTNER InterconnectAttachment is created, updated, or deleted.
   */
  public String getManagementType() {
    return managementType;
  }

  /** Name of this BGP peer. The name must be 1-63 characters long and comply with RFC1035. */
  public String getName() {
    return name;
  }

  /** Peer BGP Autonomous System Number (ASN). Each BGP interface may use a different value. */
  public Integer getPeerAsn() {
    return peerAsn;
  }

  /** IP address of the BGP interface outside Google Cloud Platform. Only IPv4 is supported. */
  public String getPeerIpAddress() {
    return peerIpAddress;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterBgpPeer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterBgpPeer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterBgpPeer DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterBgpPeer();
  }

  public static class Builder {
    private String advertiseMode;
    private List<String> advertisedGroups;
    private List<RouterAdvertisedIpRange> advertisedIpRanges;
    private Integer advertisedRoutePriority;
    private String interfaceName;
    private String ipAddress;
    private String managementType;
    private String name;
    private Integer peerAsn;
    private String peerIpAddress;

    Builder() {}

    public Builder mergeFrom(RouterBgpPeer other) {
      if (other == RouterBgpPeer.getDefaultInstance()) return this;
      if (other.getAdvertiseMode() != null) {
        this.advertiseMode = other.advertiseMode;
      }
      if (other.getAdvertisedGroupsList() != null) {
        this.advertisedGroups = other.advertisedGroups;
      }
      if (other.getAdvertisedIpRangesList() != null) {
        this.advertisedIpRanges = other.advertisedIpRanges;
      }
      if (other.getAdvertisedRoutePriority() != null) {
        this.advertisedRoutePriority = other.advertisedRoutePriority;
      }
      if (other.getInterfaceName() != null) {
        this.interfaceName = other.interfaceName;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      if (other.getManagementType() != null) {
        this.managementType = other.managementType;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPeerAsn() != null) {
        this.peerAsn = other.peerAsn;
      }
      if (other.getPeerIpAddress() != null) {
        this.peerIpAddress = other.peerIpAddress;
      }
      return this;
    }

    Builder(RouterBgpPeer source) {
      this.advertiseMode = source.advertiseMode;
      this.advertisedGroups = source.advertisedGroups;
      this.advertisedIpRanges = source.advertisedIpRanges;
      this.advertisedRoutePriority = source.advertisedRoutePriority;
      this.interfaceName = source.interfaceName;
      this.ipAddress = source.ipAddress;
      this.managementType = source.managementType;
      this.name = source.name;
      this.peerAsn = source.peerAsn;
      this.peerIpAddress = source.peerIpAddress;
    }

    /** User-specified flag to indicate which mode to use for advertisement. */
    public String getAdvertiseMode() {
      return advertiseMode;
    }

    /** User-specified flag to indicate which mode to use for advertisement. */
    public Builder setAdvertiseMode(String advertiseMode) {
      this.advertiseMode = advertiseMode;
      return this;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode, which can take one of the
     * following options: - ALL_SUBNETS: Advertises all available subnets, including peer VPC
     * subnets. - ALL_VPC_SUBNETS: Advertises the router's own VPC subnets. - ALL_PEER_VPC_SUBNETS:
     * Advertises peer subnets of the router's VPC network. Note that this field can only be
     * populated if advertise_mode is CUSTOM and overrides the list defined for the router (in the
     * "bgp" message). These groups are advertised in addition to any specified prefixes. Leave this
     * field blank to advertise no custom groups.
     */
    public List<String> getAdvertisedGroupsList() {
      return advertisedGroups;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode, which can take one of the
     * following options: - ALL_SUBNETS: Advertises all available subnets, including peer VPC
     * subnets. - ALL_VPC_SUBNETS: Advertises the router's own VPC subnets. - ALL_PEER_VPC_SUBNETS:
     * Advertises peer subnets of the router's VPC network. Note that this field can only be
     * populated if advertise_mode is CUSTOM and overrides the list defined for the router (in the
     * "bgp" message). These groups are advertised in addition to any specified prefixes. Leave this
     * field blank to advertise no custom groups.
     */
    public Builder addAllAdvertisedGroups(List<String> advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new LinkedList<>();
      }
      this.advertisedGroups.addAll(advertisedGroups);
      return this;
    }

    /**
     * User-specified list of prefix groups to advertise in custom mode, which can take one of the
     * following options: - ALL_SUBNETS: Advertises all available subnets, including peer VPC
     * subnets. - ALL_VPC_SUBNETS: Advertises the router's own VPC subnets. - ALL_PEER_VPC_SUBNETS:
     * Advertises peer subnets of the router's VPC network. Note that this field can only be
     * populated if advertise_mode is CUSTOM and overrides the list defined for the router (in the
     * "bgp" message). These groups are advertised in addition to any specified prefixes. Leave this
     * field blank to advertise no custom groups.
     */
    public Builder addAdvertisedGroups(String advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new LinkedList<>();
      }
      this.advertisedGroups.add(advertisedGroups);
      return this;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and overrides the list defined for the router (in
     * the "bgp" message). These IP ranges are advertised in addition to any specified groups. Leave
     * this field blank to advertise no custom IP ranges.
     */
    public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
      return advertisedIpRanges;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and overrides the list defined for the router (in
     * the "bgp" message). These IP ranges are advertised in addition to any specified groups. Leave
     * this field blank to advertise no custom IP ranges.
     */
    public Builder addAllAdvertisedIpRanges(List<RouterAdvertisedIpRange> advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new LinkedList<>();
      }
      this.advertisedIpRanges.addAll(advertisedIpRanges);
      return this;
    }

    /**
     * User-specified list of individual IP ranges to advertise in custom mode. This field can only
     * be populated if advertise_mode is CUSTOM and overrides the list defined for the router (in
     * the "bgp" message). These IP ranges are advertised in addition to any specified groups. Leave
     * this field blank to advertise no custom IP ranges.
     */
    public Builder addAdvertisedIpRanges(RouterAdvertisedIpRange advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new LinkedList<>();
      }
      this.advertisedIpRanges.add(advertisedIpRanges);
      return this;
    }

    /**
     * The priority of routes advertised to this BGP peer. Where there is more than one matching
     * route of maximum length, the routes with the lowest priority value win.
     */
    public Integer getAdvertisedRoutePriority() {
      return advertisedRoutePriority;
    }

    /**
     * The priority of routes advertised to this BGP peer. Where there is more than one matching
     * route of maximum length, the routes with the lowest priority value win.
     */
    public Builder setAdvertisedRoutePriority(Integer advertisedRoutePriority) {
      this.advertisedRoutePriority = advertisedRoutePriority;
      return this;
    }

    /** Name of the interface the BGP peer is associated with. */
    public String getInterfaceName() {
      return interfaceName;
    }

    /** Name of the interface the BGP peer is associated with. */
    public Builder setInterfaceName(String interfaceName) {
      this.interfaceName = interfaceName;
      return this;
    }

    /** IP address of the interface inside Google Cloud Platform. Only IPv4 is supported. */
    public String getIpAddress() {
      return ipAddress;
    }

    /** IP address of the interface inside Google Cloud Platform. Only IPv4 is supported. */
    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * [Output Only] The resource that configures and manages this BGP peer. - MANAGED_BY_USER is
     * the default value and can be managed by you or other users - MANAGED_BY_ATTACHMENT is a BGP
     * peer that is configured and managed by Cloud Interconnect, specifically by an
     * InterconnectAttachment of type PARTNER. Google automatically creates, updates, and deletes
     * this type of BGP peer when the PARTNER InterconnectAttachment is created, updated, or
     * deleted.
     */
    public String getManagementType() {
      return managementType;
    }

    /**
     * [Output Only] The resource that configures and manages this BGP peer. - MANAGED_BY_USER is
     * the default value and can be managed by you or other users - MANAGED_BY_ATTACHMENT is a BGP
     * peer that is configured and managed by Cloud Interconnect, specifically by an
     * InterconnectAttachment of type PARTNER. Google automatically creates, updates, and deletes
     * this type of BGP peer when the PARTNER InterconnectAttachment is created, updated, or
     * deleted.
     */
    public Builder setManagementType(String managementType) {
      this.managementType = managementType;
      return this;
    }

    /** Name of this BGP peer. The name must be 1-63 characters long and comply with RFC1035. */
    public String getName() {
      return name;
    }

    /** Name of this BGP peer. The name must be 1-63 characters long and comply with RFC1035. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** Peer BGP Autonomous System Number (ASN). Each BGP interface may use a different value. */
    public Integer getPeerAsn() {
      return peerAsn;
    }

    /** Peer BGP Autonomous System Number (ASN). Each BGP interface may use a different value. */
    public Builder setPeerAsn(Integer peerAsn) {
      this.peerAsn = peerAsn;
      return this;
    }

    /** IP address of the BGP interface outside Google Cloud Platform. Only IPv4 is supported. */
    public String getPeerIpAddress() {
      return peerIpAddress;
    }

    /** IP address of the BGP interface outside Google Cloud Platform. Only IPv4 is supported. */
    public Builder setPeerIpAddress(String peerIpAddress) {
      this.peerIpAddress = peerIpAddress;
      return this;
    }

    public RouterBgpPeer build() {

      return new RouterBgpPeer(
          advertiseMode,
          advertisedGroups,
          advertisedIpRanges,
          advertisedRoutePriority,
          interfaceName,
          ipAddress,
          managementType,
          name,
          peerAsn,
          peerIpAddress);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdvertiseMode(this.advertiseMode);
      newBuilder.addAllAdvertisedGroups(this.advertisedGroups);
      newBuilder.addAllAdvertisedIpRanges(this.advertisedIpRanges);
      newBuilder.setAdvertisedRoutePriority(this.advertisedRoutePriority);
      newBuilder.setInterfaceName(this.interfaceName);
      newBuilder.setIpAddress(this.ipAddress);
      newBuilder.setManagementType(this.managementType);
      newBuilder.setName(this.name);
      newBuilder.setPeerAsn(this.peerAsn);
      newBuilder.setPeerIpAddress(this.peerIpAddress);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterBgpPeer{"
        + "advertiseMode="
        + advertiseMode
        + ", "
        + "advertisedGroups="
        + advertisedGroups
        + ", "
        + "advertisedIpRanges="
        + advertisedIpRanges
        + ", "
        + "advertisedRoutePriority="
        + advertisedRoutePriority
        + ", "
        + "interfaceName="
        + interfaceName
        + ", "
        + "ipAddress="
        + ipAddress
        + ", "
        + "managementType="
        + managementType
        + ", "
        + "name="
        + name
        + ", "
        + "peerAsn="
        + peerAsn
        + ", "
        + "peerIpAddress="
        + peerIpAddress
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterBgpPeer) {
      RouterBgpPeer that = (RouterBgpPeer) o;
      return Objects.equals(this.advertiseMode, that.getAdvertiseMode())
          && Objects.equals(this.advertisedGroups, that.getAdvertisedGroupsList())
          && Objects.equals(this.advertisedIpRanges, that.getAdvertisedIpRangesList())
          && Objects.equals(this.advertisedRoutePriority, that.getAdvertisedRoutePriority())
          && Objects.equals(this.interfaceName, that.getInterfaceName())
          && Objects.equals(this.ipAddress, that.getIpAddress())
          && Objects.equals(this.managementType, that.getManagementType())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerAsn, that.getPeerAsn())
          && Objects.equals(this.peerIpAddress, that.getPeerIpAddress());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        advertiseMode,
        advertisedGroups,
        advertisedIpRanges,
        advertisedRoutePriority,
        interfaceName,
        ipAddress,
        managementType,
        name,
        peerAsn,
        peerIpAddress);
  }
}
