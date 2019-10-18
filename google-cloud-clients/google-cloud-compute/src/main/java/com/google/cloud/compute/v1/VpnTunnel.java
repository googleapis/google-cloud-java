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
 * Represents a Cloud VPN Tunnel resource.
 *
 * <p>For more information about VPN, read the the Cloud VPN Overview. (== resource_for
 * beta.vpnTunnels ==) (== resource_for v1.vpnTunnels ==)
 */
public final class VpnTunnel implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String detailedStatus;
  private final String id;
  private final Integer ikeVersion;
  private final String kind;
  private final List<String> localTrafficSelector;
  private final String name;
  private final String peerExternalGateway;
  private final Integer peerExternalGatewayInterface;
  private final String peerGcpGateway;
  private final String peerIp;
  private final String region;
  private final List<String> remoteTrafficSelector;
  private final String router;
  private final String selfLink;
  private final String sharedSecret;
  private final String sharedSecretHash;
  private final String status;
  private final String targetVpnGateway;
  private final String vpnGateway;
  private final Integer vpnGatewayInterface;

  private VpnTunnel() {
    this.creationTimestamp = null;
    this.description = null;
    this.detailedStatus = null;
    this.id = null;
    this.ikeVersion = null;
    this.kind = null;
    this.localTrafficSelector = null;
    this.name = null;
    this.peerExternalGateway = null;
    this.peerExternalGatewayInterface = null;
    this.peerGcpGateway = null;
    this.peerIp = null;
    this.region = null;
    this.remoteTrafficSelector = null;
    this.router = null;
    this.selfLink = null;
    this.sharedSecret = null;
    this.sharedSecretHash = null;
    this.status = null;
    this.targetVpnGateway = null;
    this.vpnGateway = null;
    this.vpnGatewayInterface = null;
  }

  private VpnTunnel(
      String creationTimestamp,
      String description,
      String detailedStatus,
      String id,
      Integer ikeVersion,
      String kind,
      List<String> localTrafficSelector,
      String name,
      String peerExternalGateway,
      Integer peerExternalGatewayInterface,
      String peerGcpGateway,
      String peerIp,
      String region,
      List<String> remoteTrafficSelector,
      String router,
      String selfLink,
      String sharedSecret,
      String sharedSecretHash,
      String status,
      String targetVpnGateway,
      String vpnGateway,
      Integer vpnGatewayInterface) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.detailedStatus = detailedStatus;
    this.id = id;
    this.ikeVersion = ikeVersion;
    this.kind = kind;
    this.localTrafficSelector = localTrafficSelector;
    this.name = name;
    this.peerExternalGateway = peerExternalGateway;
    this.peerExternalGatewayInterface = peerExternalGatewayInterface;
    this.peerGcpGateway = peerGcpGateway;
    this.peerIp = peerIp;
    this.region = region;
    this.remoteTrafficSelector = remoteTrafficSelector;
    this.router = router;
    this.selfLink = selfLink;
    this.sharedSecret = sharedSecret;
    this.sharedSecretHash = sharedSecretHash;
    this.status = status;
    this.targetVpnGateway = targetVpnGateway;
    this.vpnGateway = vpnGateway;
    this.vpnGatewayInterface = vpnGatewayInterface;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("detailedStatus".equals(fieldName)) {
      return detailedStatus;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("ikeVersion".equals(fieldName)) {
      return ikeVersion;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("localTrafficSelector".equals(fieldName)) {
      return localTrafficSelector;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("peerExternalGateway".equals(fieldName)) {
      return peerExternalGateway;
    }
    if ("peerExternalGatewayInterface".equals(fieldName)) {
      return peerExternalGatewayInterface;
    }
    if ("peerGcpGateway".equals(fieldName)) {
      return peerGcpGateway;
    }
    if ("peerIp".equals(fieldName)) {
      return peerIp;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("remoteTrafficSelector".equals(fieldName)) {
      return remoteTrafficSelector;
    }
    if ("router".equals(fieldName)) {
      return router;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sharedSecret".equals(fieldName)) {
      return sharedSecret;
    }
    if ("sharedSecretHash".equals(fieldName)) {
      return sharedSecretHash;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("targetVpnGateway".equals(fieldName)) {
      return targetVpnGateway;
    }
    if ("vpnGateway".equals(fieldName)) {
      return vpnGateway;
    }
    if ("vpnGatewayInterface".equals(fieldName)) {
      return vpnGatewayInterface;
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

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /** [Output Only] Detailed status message for the VPN tunnel. */
  public String getDetailedStatus() {
    return detailedStatus;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * IKE protocol version to use when establishing the VPN tunnel with the peer VPN gateway.
   * Acceptable IKE versions are 1 or 2. The default version is 2.
   */
  public Integer getIkeVersion() {
    return ikeVersion;
  }

  /** [Output Only] Type of resource. Always compute#vpnTunnel for VPN tunnels. */
  public String getKind() {
    return kind;
  }

  /**
   * Local traffic selector to use when establishing the VPN tunnel with the peer VPN gateway. The
   * value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges must be
   * disjoint. Only IPv4 is supported.
   */
  public List<String> getLocalTrafficSelectorList() {
    return localTrafficSelector;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * URL of the peer side external VPN gateway to which this VPN tunnel is connected. Provided by
   * the client when the VPN tunnel is created. This field is exclusive with the field
   * peerGcpGateway.
   */
  public String getPeerExternalGateway() {
    return peerExternalGateway;
  }

  /**
   * The interface ID of the external VPN gateway to which this VPN tunnel is connected. Provided by
   * the client when the VPN tunnel is created.
   */
  public Integer getPeerExternalGatewayInterface() {
    return peerExternalGatewayInterface;
  }

  /**
   * URL of the peer side HA GCP VPN gateway to which this VPN tunnel is connected. Provided by the
   * client when the VPN tunnel is created. This field can be used when creating highly available
   * VPN from VPC network to VPC network, the field is exclusive with the field peerExternalGateway.
   * If provided, the VPN tunnel will automatically use the same vpnGatewayInterface ID in the peer
   * GCP VPN gateway.
   */
  public String getPeerGcpGateway() {
    return peerGcpGateway;
  }

  /** IP address of the peer VPN gateway. Only IPv4 is supported. */
  public String getPeerIp() {
    return peerIp;
  }

  /**
   * [Output Only] URL of the region where the VPN tunnel resides. You must specify this field as
   * part of the HTTP request URL. It is not settable as a field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /**
   * Remote traffic selectors to use when establishing the VPN tunnel with the peer VPN gateway. The
   * value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges should be
   * disjoint. Only IPv4 is supported.
   */
  public List<String> getRemoteTrafficSelectorList() {
    return remoteTrafficSelector;
  }

  /** URL of the router resource to be used for dynamic routing. */
  public String getRouter() {
    return router;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Shared secret used to set the secure session between the Cloud VPN gateway and the peer VPN
   * gateway.
   */
  public String getSharedSecret() {
    return sharedSecret;
  }

  /** Hash of the shared secret. */
  public String getSharedSecretHash() {
    return sharedSecretHash;
  }

  /**
   * [Output Only] The status of the VPN tunnel, which can be one of the following: - PROVISIONING:
   * Resource is being allocated for the VPN tunnel. - WAITING_FOR_FULL_CONFIG: Waiting to receive
   * all VPN-related configs from the user. Network, TargetVpnGateway, VpnTunnel, ForwardingRule,
   * and Route resources are needed to setup the VPN tunnel. - FIRST_HANDSHAKE: Successful first
   * handshake with the peer VPN. - ESTABLISHED: Secure session is successfully established with the
   * peer VPN. - NETWORK_ERROR: Deprecated, replaced by NO_INCOMING_PACKETS - AUTHORIZATION_ERROR:
   * Auth error (for example, bad shared secret). - NEGOTIATION_FAILURE: Handshake failed. -
   * DEPROVISIONING: Resources are being deallocated for the VPN tunnel. - FAILED: Tunnel creation
   * has failed and the tunnel is not ready to be used.
   */
  public String getStatus() {
    return status;
  }

  /**
   * URL of the Target VPN gateway with which this VPN tunnel is associated. Provided by the client
   * when the VPN tunnel is created.
   */
  public String getTargetVpnGateway() {
    return targetVpnGateway;
  }

  /**
   * URL of the VPN gateway with which this VPN tunnel is associated. Provided by the client when
   * the VPN tunnel is created. This must be used (instead of target_vpn_gateway) if a High
   * Availability VPN gateway resource is created.
   */
  public String getVpnGateway() {
    return vpnGateway;
  }

  /** The interface ID of the VPN gateway with which this VPN tunnel is associated. */
  public Integer getVpnGatewayInterface() {
    return vpnGatewayInterface;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnTunnel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnTunnel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnTunnel DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnTunnel();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String detailedStatus;
    private String id;
    private Integer ikeVersion;
    private String kind;
    private List<String> localTrafficSelector;
    private String name;
    private String peerExternalGateway;
    private Integer peerExternalGatewayInterface;
    private String peerGcpGateway;
    private String peerIp;
    private String region;
    private List<String> remoteTrafficSelector;
    private String router;
    private String selfLink;
    private String sharedSecret;
    private String sharedSecretHash;
    private String status;
    private String targetVpnGateway;
    private String vpnGateway;
    private Integer vpnGatewayInterface;

    Builder() {}

    public Builder mergeFrom(VpnTunnel other) {
      if (other == VpnTunnel.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDetailedStatus() != null) {
        this.detailedStatus = other.detailedStatus;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIkeVersion() != null) {
        this.ikeVersion = other.ikeVersion;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLocalTrafficSelectorList() != null) {
        this.localTrafficSelector = other.localTrafficSelector;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPeerExternalGateway() != null) {
        this.peerExternalGateway = other.peerExternalGateway;
      }
      if (other.getPeerExternalGatewayInterface() != null) {
        this.peerExternalGatewayInterface = other.peerExternalGatewayInterface;
      }
      if (other.getPeerGcpGateway() != null) {
        this.peerGcpGateway = other.peerGcpGateway;
      }
      if (other.getPeerIp() != null) {
        this.peerIp = other.peerIp;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getRemoteTrafficSelectorList() != null) {
        this.remoteTrafficSelector = other.remoteTrafficSelector;
      }
      if (other.getRouter() != null) {
        this.router = other.router;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSharedSecret() != null) {
        this.sharedSecret = other.sharedSecret;
      }
      if (other.getSharedSecretHash() != null) {
        this.sharedSecretHash = other.sharedSecretHash;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getTargetVpnGateway() != null) {
        this.targetVpnGateway = other.targetVpnGateway;
      }
      if (other.getVpnGateway() != null) {
        this.vpnGateway = other.vpnGateway;
      }
      if (other.getVpnGatewayInterface() != null) {
        this.vpnGatewayInterface = other.vpnGatewayInterface;
      }
      return this;
    }

    Builder(VpnTunnel source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.detailedStatus = source.detailedStatus;
      this.id = source.id;
      this.ikeVersion = source.ikeVersion;
      this.kind = source.kind;
      this.localTrafficSelector = source.localTrafficSelector;
      this.name = source.name;
      this.peerExternalGateway = source.peerExternalGateway;
      this.peerExternalGatewayInterface = source.peerExternalGatewayInterface;
      this.peerGcpGateway = source.peerGcpGateway;
      this.peerIp = source.peerIp;
      this.region = source.region;
      this.remoteTrafficSelector = source.remoteTrafficSelector;
      this.router = source.router;
      this.selfLink = source.selfLink;
      this.sharedSecret = source.sharedSecret;
      this.sharedSecretHash = source.sharedSecretHash;
      this.status = source.status;
      this.targetVpnGateway = source.targetVpnGateway;
      this.vpnGateway = source.vpnGateway;
      this.vpnGatewayInterface = source.vpnGatewayInterface;
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
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** [Output Only] Detailed status message for the VPN tunnel. */
    public String getDetailedStatus() {
      return detailedStatus;
    }

    /** [Output Only] Detailed status message for the VPN tunnel. */
    public Builder setDetailedStatus(String detailedStatus) {
      this.detailedStatus = detailedStatus;
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
     * IKE protocol version to use when establishing the VPN tunnel with the peer VPN gateway.
     * Acceptable IKE versions are 1 or 2. The default version is 2.
     */
    public Integer getIkeVersion() {
      return ikeVersion;
    }

    /**
     * IKE protocol version to use when establishing the VPN tunnel with the peer VPN gateway.
     * Acceptable IKE versions are 1 or 2. The default version is 2.
     */
    public Builder setIkeVersion(Integer ikeVersion) {
      this.ikeVersion = ikeVersion;
      return this;
    }

    /** [Output Only] Type of resource. Always compute#vpnTunnel for VPN tunnels. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#vpnTunnel for VPN tunnels. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Local traffic selector to use when establishing the VPN tunnel with the peer VPN gateway. The
     * value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges must be
     * disjoint. Only IPv4 is supported.
     */
    public List<String> getLocalTrafficSelectorList() {
      return localTrafficSelector;
    }

    /**
     * Local traffic selector to use when establishing the VPN tunnel with the peer VPN gateway. The
     * value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges must be
     * disjoint. Only IPv4 is supported.
     */
    public Builder addAllLocalTrafficSelector(List<String> localTrafficSelector) {
      if (this.localTrafficSelector == null) {
        this.localTrafficSelector = new LinkedList<>();
      }
      this.localTrafficSelector.addAll(localTrafficSelector);
      return this;
    }

    /**
     * Local traffic selector to use when establishing the VPN tunnel with the peer VPN gateway. The
     * value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges must be
     * disjoint. Only IPv4 is supported.
     */
    public Builder addLocalTrafficSelector(String localTrafficSelector) {
      if (this.localTrafficSelector == null) {
        this.localTrafficSelector = new LinkedList<>();
      }
      this.localTrafficSelector.add(localTrafficSelector);
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * URL of the peer side external VPN gateway to which this VPN tunnel is connected. Provided by
     * the client when the VPN tunnel is created. This field is exclusive with the field
     * peerGcpGateway.
     */
    public String getPeerExternalGateway() {
      return peerExternalGateway;
    }

    /**
     * URL of the peer side external VPN gateway to which this VPN tunnel is connected. Provided by
     * the client when the VPN tunnel is created. This field is exclusive with the field
     * peerGcpGateway.
     */
    public Builder setPeerExternalGateway(String peerExternalGateway) {
      this.peerExternalGateway = peerExternalGateway;
      return this;
    }

    /**
     * The interface ID of the external VPN gateway to which this VPN tunnel is connected. Provided
     * by the client when the VPN tunnel is created.
     */
    public Integer getPeerExternalGatewayInterface() {
      return peerExternalGatewayInterface;
    }

    /**
     * The interface ID of the external VPN gateway to which this VPN tunnel is connected. Provided
     * by the client when the VPN tunnel is created.
     */
    public Builder setPeerExternalGatewayInterface(Integer peerExternalGatewayInterface) {
      this.peerExternalGatewayInterface = peerExternalGatewayInterface;
      return this;
    }

    /**
     * URL of the peer side HA GCP VPN gateway to which this VPN tunnel is connected. Provided by
     * the client when the VPN tunnel is created. This field can be used when creating highly
     * available VPN from VPC network to VPC network, the field is exclusive with the field
     * peerExternalGateway. If provided, the VPN tunnel will automatically use the same
     * vpnGatewayInterface ID in the peer GCP VPN gateway.
     */
    public String getPeerGcpGateway() {
      return peerGcpGateway;
    }

    /**
     * URL of the peer side HA GCP VPN gateway to which this VPN tunnel is connected. Provided by
     * the client when the VPN tunnel is created. This field can be used when creating highly
     * available VPN from VPC network to VPC network, the field is exclusive with the field
     * peerExternalGateway. If provided, the VPN tunnel will automatically use the same
     * vpnGatewayInterface ID in the peer GCP VPN gateway.
     */
    public Builder setPeerGcpGateway(String peerGcpGateway) {
      this.peerGcpGateway = peerGcpGateway;
      return this;
    }

    /** IP address of the peer VPN gateway. Only IPv4 is supported. */
    public String getPeerIp() {
      return peerIp;
    }

    /** IP address of the peer VPN gateway. Only IPv4 is supported. */
    public Builder setPeerIp(String peerIp) {
      this.peerIp = peerIp;
      return this;
    }

    /**
     * [Output Only] URL of the region where the VPN tunnel resides. You must specify this field as
     * part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the VPN tunnel resides. You must specify this field as
     * part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /**
     * Remote traffic selectors to use when establishing the VPN tunnel with the peer VPN gateway.
     * The value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges should
     * be disjoint. Only IPv4 is supported.
     */
    public List<String> getRemoteTrafficSelectorList() {
      return remoteTrafficSelector;
    }

    /**
     * Remote traffic selectors to use when establishing the VPN tunnel with the peer VPN gateway.
     * The value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges should
     * be disjoint. Only IPv4 is supported.
     */
    public Builder addAllRemoteTrafficSelector(List<String> remoteTrafficSelector) {
      if (this.remoteTrafficSelector == null) {
        this.remoteTrafficSelector = new LinkedList<>();
      }
      this.remoteTrafficSelector.addAll(remoteTrafficSelector);
      return this;
    }

    /**
     * Remote traffic selectors to use when establishing the VPN tunnel with the peer VPN gateway.
     * The value should be a CIDR formatted string, for example: 192.168.0.0/16. The ranges should
     * be disjoint. Only IPv4 is supported.
     */
    public Builder addRemoteTrafficSelector(String remoteTrafficSelector) {
      if (this.remoteTrafficSelector == null) {
        this.remoteTrafficSelector = new LinkedList<>();
      }
      this.remoteTrafficSelector.add(remoteTrafficSelector);
      return this;
    }

    /** URL of the router resource to be used for dynamic routing. */
    public String getRouter() {
      return router;
    }

    /** URL of the router resource to be used for dynamic routing. */
    public Builder setRouter(String router) {
      this.router = router;
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
     * Shared secret used to set the secure session between the Cloud VPN gateway and the peer VPN
     * gateway.
     */
    public String getSharedSecret() {
      return sharedSecret;
    }

    /**
     * Shared secret used to set the secure session between the Cloud VPN gateway and the peer VPN
     * gateway.
     */
    public Builder setSharedSecret(String sharedSecret) {
      this.sharedSecret = sharedSecret;
      return this;
    }

    /** Hash of the shared secret. */
    public String getSharedSecretHash() {
      return sharedSecretHash;
    }

    /** Hash of the shared secret. */
    public Builder setSharedSecretHash(String sharedSecretHash) {
      this.sharedSecretHash = sharedSecretHash;
      return this;
    }

    /**
     * [Output Only] The status of the VPN tunnel, which can be one of the following: -
     * PROVISIONING: Resource is being allocated for the VPN tunnel. - WAITING_FOR_FULL_CONFIG:
     * Waiting to receive all VPN-related configs from the user. Network, TargetVpnGateway,
     * VpnTunnel, ForwardingRule, and Route resources are needed to setup the VPN tunnel. -
     * FIRST_HANDSHAKE: Successful first handshake with the peer VPN. - ESTABLISHED: Secure session
     * is successfully established with the peer VPN. - NETWORK_ERROR: Deprecated, replaced by
     * NO_INCOMING_PACKETS - AUTHORIZATION_ERROR: Auth error (for example, bad shared secret). -
     * NEGOTIATION_FAILURE: Handshake failed. - DEPROVISIONING: Resources are being deallocated for
     * the VPN tunnel. - FAILED: Tunnel creation has failed and the tunnel is not ready to be used.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the VPN tunnel, which can be one of the following: -
     * PROVISIONING: Resource is being allocated for the VPN tunnel. - WAITING_FOR_FULL_CONFIG:
     * Waiting to receive all VPN-related configs from the user. Network, TargetVpnGateway,
     * VpnTunnel, ForwardingRule, and Route resources are needed to setup the VPN tunnel. -
     * FIRST_HANDSHAKE: Successful first handshake with the peer VPN. - ESTABLISHED: Secure session
     * is successfully established with the peer VPN. - NETWORK_ERROR: Deprecated, replaced by
     * NO_INCOMING_PACKETS - AUTHORIZATION_ERROR: Auth error (for example, bad shared secret). -
     * NEGOTIATION_FAILURE: Handshake failed. - DEPROVISIONING: Resources are being deallocated for
     * the VPN tunnel. - FAILED: Tunnel creation has failed and the tunnel is not ready to be used.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * URL of the Target VPN gateway with which this VPN tunnel is associated. Provided by the
     * client when the VPN tunnel is created.
     */
    public String getTargetVpnGateway() {
      return targetVpnGateway;
    }

    /**
     * URL of the Target VPN gateway with which this VPN tunnel is associated. Provided by the
     * client when the VPN tunnel is created.
     */
    public Builder setTargetVpnGateway(String targetVpnGateway) {
      this.targetVpnGateway = targetVpnGateway;
      return this;
    }

    /**
     * URL of the VPN gateway with which this VPN tunnel is associated. Provided by the client when
     * the VPN tunnel is created. This must be used (instead of target_vpn_gateway) if a High
     * Availability VPN gateway resource is created.
     */
    public String getVpnGateway() {
      return vpnGateway;
    }

    /**
     * URL of the VPN gateway with which this VPN tunnel is associated. Provided by the client when
     * the VPN tunnel is created. This must be used (instead of target_vpn_gateway) if a High
     * Availability VPN gateway resource is created.
     */
    public Builder setVpnGateway(String vpnGateway) {
      this.vpnGateway = vpnGateway;
      return this;
    }

    /** The interface ID of the VPN gateway with which this VPN tunnel is associated. */
    public Integer getVpnGatewayInterface() {
      return vpnGatewayInterface;
    }

    /** The interface ID of the VPN gateway with which this VPN tunnel is associated. */
    public Builder setVpnGatewayInterface(Integer vpnGatewayInterface) {
      this.vpnGatewayInterface = vpnGatewayInterface;
      return this;
    }

    public VpnTunnel build() {

      return new VpnTunnel(
          creationTimestamp,
          description,
          detailedStatus,
          id,
          ikeVersion,
          kind,
          localTrafficSelector,
          name,
          peerExternalGateway,
          peerExternalGatewayInterface,
          peerGcpGateway,
          peerIp,
          region,
          remoteTrafficSelector,
          router,
          selfLink,
          sharedSecret,
          sharedSecretHash,
          status,
          targetVpnGateway,
          vpnGateway,
          vpnGatewayInterface);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setDetailedStatus(this.detailedStatus);
      newBuilder.setId(this.id);
      newBuilder.setIkeVersion(this.ikeVersion);
      newBuilder.setKind(this.kind);
      newBuilder.addAllLocalTrafficSelector(this.localTrafficSelector);
      newBuilder.setName(this.name);
      newBuilder.setPeerExternalGateway(this.peerExternalGateway);
      newBuilder.setPeerExternalGatewayInterface(this.peerExternalGatewayInterface);
      newBuilder.setPeerGcpGateway(this.peerGcpGateway);
      newBuilder.setPeerIp(this.peerIp);
      newBuilder.setRegion(this.region);
      newBuilder.addAllRemoteTrafficSelector(this.remoteTrafficSelector);
      newBuilder.setRouter(this.router);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSharedSecret(this.sharedSecret);
      newBuilder.setSharedSecretHash(this.sharedSecretHash);
      newBuilder.setStatus(this.status);
      newBuilder.setTargetVpnGateway(this.targetVpnGateway);
      newBuilder.setVpnGateway(this.vpnGateway);
      newBuilder.setVpnGatewayInterface(this.vpnGatewayInterface);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnTunnel{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "detailedStatus="
        + detailedStatus
        + ", "
        + "id="
        + id
        + ", "
        + "ikeVersion="
        + ikeVersion
        + ", "
        + "kind="
        + kind
        + ", "
        + "localTrafficSelector="
        + localTrafficSelector
        + ", "
        + "name="
        + name
        + ", "
        + "peerExternalGateway="
        + peerExternalGateway
        + ", "
        + "peerExternalGatewayInterface="
        + peerExternalGatewayInterface
        + ", "
        + "peerGcpGateway="
        + peerGcpGateway
        + ", "
        + "peerIp="
        + peerIp
        + ", "
        + "region="
        + region
        + ", "
        + "remoteTrafficSelector="
        + remoteTrafficSelector
        + ", "
        + "router="
        + router
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sharedSecret="
        + sharedSecret
        + ", "
        + "sharedSecretHash="
        + sharedSecretHash
        + ", "
        + "status="
        + status
        + ", "
        + "targetVpnGateway="
        + targetVpnGateway
        + ", "
        + "vpnGateway="
        + vpnGateway
        + ", "
        + "vpnGatewayInterface="
        + vpnGatewayInterface
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnTunnel) {
      VpnTunnel that = (VpnTunnel) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.detailedStatus, that.getDetailedStatus())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ikeVersion, that.getIkeVersion())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.localTrafficSelector, that.getLocalTrafficSelectorList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerExternalGateway, that.getPeerExternalGateway())
          && Objects.equals(
              this.peerExternalGatewayInterface, that.getPeerExternalGatewayInterface())
          && Objects.equals(this.peerGcpGateway, that.getPeerGcpGateway())
          && Objects.equals(this.peerIp, that.getPeerIp())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.remoteTrafficSelector, that.getRemoteTrafficSelectorList())
          && Objects.equals(this.router, that.getRouter())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sharedSecret, that.getSharedSecret())
          && Objects.equals(this.sharedSecretHash, that.getSharedSecretHash())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.targetVpnGateway, that.getTargetVpnGateway())
          && Objects.equals(this.vpnGateway, that.getVpnGateway())
          && Objects.equals(this.vpnGatewayInterface, that.getVpnGatewayInterface());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        detailedStatus,
        id,
        ikeVersion,
        kind,
        localTrafficSelector,
        name,
        peerExternalGateway,
        peerExternalGatewayInterface,
        peerGcpGateway,
        peerIp,
        region,
        remoteTrafficSelector,
        router,
        selfLink,
        sharedSecret,
        sharedSecretHash,
        status,
        targetVpnGateway,
        vpnGateway,
        vpnGatewayInterface);
  }
}
