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
 * Represents a Target VPN gateway resource. (== resource_for beta.targetVpnGateways ==) (==
 * resource_for v1.targetVpnGateways ==)
 */
public final class TargetVpnGateway implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final List<String> forwardingRules;
  private final String id;
  private final String kind;
  private final String name;
  private final String network;
  private final String region;
  private final String selfLink;
  private final String status;
  private final List<String> tunnels;

  private TargetVpnGateway() {
    this.creationTimestamp = null;
    this.description = null;
    this.forwardingRules = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
    this.tunnels = null;
  }

  private TargetVpnGateway(
      String creationTimestamp,
      String description,
      List<String> forwardingRules,
      String id,
      String kind,
      String name,
      String network,
      String region,
      String selfLink,
      String status,
      List<String> tunnels) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.forwardingRules = forwardingRules;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.tunnels = tunnels;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("forwardingRules".equals(fieldName)) {
      return forwardingRules;
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
    if ("network".equals(fieldName)) {
      return network;
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
    if ("tunnels".equals(fieldName)) {
      return tunnels;
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

  /**
   * [Output Only] A list of URLs to the ForwardingRule resources. ForwardingRules are created using
   * compute.forwardingRules.insert and associated with a VPN gateway.
   */
  public List<String> getForwardingRulesList() {
    return forwardingRules;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of resource. Always compute#targetVpnGateway for target VPN gateways. */
  public String getKind() {
    return kind;
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
   * URL of the network to which this VPN gateway is attached. Provided by the client when the VPN
   * gateway is created.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * [Output Only] URL of the region where the target VPN gateway resides. You must specify this
   * field as part of the HTTP request URL. It is not settable as a field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The status of the VPN gateway, which can be one of the following: CREATING,
   * READY, FAILED, or DELETING.
   */
  public String getStatus() {
    return status;
  }

  /**
   * [Output Only] A list of URLs to VpnTunnel resources. VpnTunnels are created using the
   * compute.vpntunnels.insert method and associated with a VPN gateway.
   */
  public List<String> getTunnelsList() {
    return tunnels;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetVpnGateway prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetVpnGateway getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetVpnGateway DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetVpnGateway();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private List<String> forwardingRules;
    private String id;
    private String kind;
    private String name;
    private String network;
    private String region;
    private String selfLink;
    private String status;
    private List<String> tunnels;

    Builder() {}

    public Builder mergeFrom(TargetVpnGateway other) {
      if (other == TargetVpnGateway.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getForwardingRulesList() != null) {
        this.forwardingRules = other.forwardingRules;
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
      if (other.getNetwork() != null) {
        this.network = other.network;
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
      if (other.getTunnelsList() != null) {
        this.tunnels = other.tunnels;
      }
      return this;
    }

    Builder(TargetVpnGateway source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.forwardingRules = source.forwardingRules;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.tunnels = source.tunnels;
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

    /**
     * [Output Only] A list of URLs to the ForwardingRule resources. ForwardingRules are created
     * using compute.forwardingRules.insert and associated with a VPN gateway.
     */
    public List<String> getForwardingRulesList() {
      return forwardingRules;
    }

    /**
     * [Output Only] A list of URLs to the ForwardingRule resources. ForwardingRules are created
     * using compute.forwardingRules.insert and associated with a VPN gateway.
     */
    public Builder addAllForwardingRules(List<String> forwardingRules) {
      if (this.forwardingRules == null) {
        this.forwardingRules = new LinkedList<>();
      }
      this.forwardingRules.addAll(forwardingRules);
      return this;
    }

    /**
     * [Output Only] A list of URLs to the ForwardingRule resources. ForwardingRules are created
     * using compute.forwardingRules.insert and associated with a VPN gateway.
     */
    public Builder addForwardingRules(String forwardingRules) {
      if (this.forwardingRules == null) {
        this.forwardingRules = new LinkedList<>();
      }
      this.forwardingRules.add(forwardingRules);
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

    /** [Output Only] Type of resource. Always compute#targetVpnGateway for target VPN gateways. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#targetVpnGateway for target VPN gateways. */
    public Builder setKind(String kind) {
      this.kind = kind;
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
     * URL of the network to which this VPN gateway is attached. Provided by the client when the VPN
     * gateway is created.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * URL of the network to which this VPN gateway is attached. Provided by the client when the VPN
     * gateway is created.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * [Output Only] URL of the region where the target VPN gateway resides. You must specify this
     * field as part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the target VPN gateway resides. You must specify this
     * field as part of the HTTP request URL. It is not settable as a field in the request body.
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
     * [Output Only] The status of the VPN gateway, which can be one of the following: CREATING,
     * READY, FAILED, or DELETING.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the VPN gateway, which can be one of the following: CREATING,
     * READY, FAILED, or DELETING.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * [Output Only] A list of URLs to VpnTunnel resources. VpnTunnels are created using the
     * compute.vpntunnels.insert method and associated with a VPN gateway.
     */
    public List<String> getTunnelsList() {
      return tunnels;
    }

    /**
     * [Output Only] A list of URLs to VpnTunnel resources. VpnTunnels are created using the
     * compute.vpntunnels.insert method and associated with a VPN gateway.
     */
    public Builder addAllTunnels(List<String> tunnels) {
      if (this.tunnels == null) {
        this.tunnels = new LinkedList<>();
      }
      this.tunnels.addAll(tunnels);
      return this;
    }

    /**
     * [Output Only] A list of URLs to VpnTunnel resources. VpnTunnels are created using the
     * compute.vpntunnels.insert method and associated with a VPN gateway.
     */
    public Builder addTunnels(String tunnels) {
      if (this.tunnels == null) {
        this.tunnels = new LinkedList<>();
      }
      this.tunnels.add(tunnels);
      return this;
    }

    public TargetVpnGateway build() {

      return new TargetVpnGateway(
          creationTimestamp,
          description,
          forwardingRules,
          id,
          kind,
          name,
          network,
          region,
          selfLink,
          status,
          tunnels);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.addAllForwardingRules(this.forwardingRules);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.addAllTunnels(this.tunnels);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetVpnGateway{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "forwardingRules="
        + forwardingRules
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
        + "network="
        + network
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
        + "tunnels="
        + tunnels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetVpnGateway) {
      TargetVpnGateway that = (TargetVpnGateway) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.forwardingRules, that.getForwardingRulesList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.tunnels, that.getTunnelsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        forwardingRules,
        id,
        kind,
        name,
        network,
        region,
        selfLink,
        status,
        tunnels);
  }
}
