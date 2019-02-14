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
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Network resource. Read Virtual Private Cloud (VPC) Network Overview for more
 * information. (== resource_for v1.networks ==) (== resource_for beta.networks ==)
 */
public final class Network implements ApiMessage {
  private final Boolean autoCreateSubnetworks;
  private final String creationTimestamp;
  private final String description;
  private final String gatewayIPv4;

  @SerializedName("IPv4Range")
  private final String iPv4Range;

  private final String id;
  private final String kind;
  private final String name;
  private final List<NetworkPeering> peerings;
  private final NetworkRoutingConfig routingConfig;
  private final String selfLink;
  private final List<String> subnetworks;

  private Network() {
    this.autoCreateSubnetworks = null;
    this.creationTimestamp = null;
    this.description = null;
    this.gatewayIPv4 = null;
    this.iPv4Range = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.peerings = null;
    this.routingConfig = null;
    this.selfLink = null;
    this.subnetworks = null;
  }

  private Network(
      Boolean autoCreateSubnetworks,
      String creationTimestamp,
      String description,
      String gatewayIPv4,
      String iPv4Range,
      String id,
      String kind,
      String name,
      List<NetworkPeering> peerings,
      NetworkRoutingConfig routingConfig,
      String selfLink,
      List<String> subnetworks) {
    this.autoCreateSubnetworks = autoCreateSubnetworks;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.gatewayIPv4 = gatewayIPv4;
    this.iPv4Range = iPv4Range;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.peerings = peerings;
    this.routingConfig = routingConfig;
    this.selfLink = selfLink;
    this.subnetworks = subnetworks;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoCreateSubnetworks".equals(fieldName)) {
      return autoCreateSubnetworks;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("gatewayIPv4".equals(fieldName)) {
      return gatewayIPv4;
    }
    if ("iPv4Range".equals(fieldName)) {
      return iPv4Range;
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
    if ("peerings".equals(fieldName)) {
      return peerings;
    }
    if ("routingConfig".equals(fieldName)) {
      return routingConfig;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("subnetworks".equals(fieldName)) {
      return subnetworks;
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
   * When set to true, the VPC network is created in "auto" mode. When set to false, the VPC network
   * is created in "custom" mode.
   *
   * <p>An auto mode VPC network starts with one subnet per region. Each subnet has a predetermined
   * range as described in Auto mode VPC network IP ranges.
   */
  public Boolean getAutoCreateSubnetworks() {
    return autoCreateSubnetworks;
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
   * [Output Only] The gateway address for default routing out of the network. This value is read
   * only and is selected by GCP.
   */
  public String getGatewayIPv4() {
    return gatewayIPv4;
  }

  /**
   * The range of internal addresses that are legal on this network. This range is a CIDR
   * specification, for example: 192.168.0.0/16. Provided by the client when the network is created.
   */
  public String getIPv4Range() {
    return iPv4Range;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#network for networks. */
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

  /** [Output Only] A list of network peerings for the resource. */
  public List<NetworkPeering> getPeeringsList() {
    return peerings;
  }

  /**
   * The network-level routing configuration for this network. Used by Cloud Router to determine
   * what type of network-wide routing behavior to enforce.
   */
  public NetworkRoutingConfig getRoutingConfig() {
    return routingConfig;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Server-defined fully-qualified URLs for all subnetworks in this VPC network. */
  public List<String> getSubnetworksList() {
    return subnetworks;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Network prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Network getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Network DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Network();
  }

  public static class Builder {
    private Boolean autoCreateSubnetworks;
    private String creationTimestamp;
    private String description;
    private String gatewayIPv4;
    private String iPv4Range;
    private String id;
    private String kind;
    private String name;
    private List<NetworkPeering> peerings;
    private NetworkRoutingConfig routingConfig;
    private String selfLink;
    private List<String> subnetworks;

    Builder() {}

    public Builder mergeFrom(Network other) {
      if (other == Network.getDefaultInstance()) return this;
      if (other.getAutoCreateSubnetworks() != null) {
        this.autoCreateSubnetworks = other.autoCreateSubnetworks;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGatewayIPv4() != null) {
        this.gatewayIPv4 = other.gatewayIPv4;
      }
      if (other.getIPv4Range() != null) {
        this.iPv4Range = other.iPv4Range;
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
      if (other.getPeeringsList() != null) {
        this.peerings = other.peerings;
      }
      if (other.getRoutingConfig() != null) {
        this.routingConfig = other.routingConfig;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSubnetworksList() != null) {
        this.subnetworks = other.subnetworks;
      }
      return this;
    }

    Builder(Network source) {
      this.autoCreateSubnetworks = source.autoCreateSubnetworks;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.gatewayIPv4 = source.gatewayIPv4;
      this.iPv4Range = source.iPv4Range;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.peerings = source.peerings;
      this.routingConfig = source.routingConfig;
      this.selfLink = source.selfLink;
      this.subnetworks = source.subnetworks;
    }

    /**
     * When set to true, the VPC network is created in "auto" mode. When set to false, the VPC
     * network is created in "custom" mode.
     *
     * <p>An auto mode VPC network starts with one subnet per region. Each subnet has a
     * predetermined range as described in Auto mode VPC network IP ranges.
     */
    public Boolean getAutoCreateSubnetworks() {
      return autoCreateSubnetworks;
    }

    /**
     * When set to true, the VPC network is created in "auto" mode. When set to false, the VPC
     * network is created in "custom" mode.
     *
     * <p>An auto mode VPC network starts with one subnet per region. Each subnet has a
     * predetermined range as described in Auto mode VPC network IP ranges.
     */
    public Builder setAutoCreateSubnetworks(Boolean autoCreateSubnetworks) {
      this.autoCreateSubnetworks = autoCreateSubnetworks;
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
     * [Output Only] The gateway address for default routing out of the network. This value is read
     * only and is selected by GCP.
     */
    public String getGatewayIPv4() {
      return gatewayIPv4;
    }

    /**
     * [Output Only] The gateway address for default routing out of the network. This value is read
     * only and is selected by GCP.
     */
    public Builder setGatewayIPv4(String gatewayIPv4) {
      this.gatewayIPv4 = gatewayIPv4;
      return this;
    }

    /**
     * The range of internal addresses that are legal on this network. This range is a CIDR
     * specification, for example: 192.168.0.0/16. Provided by the client when the network is
     * created.
     */
    public String getIPv4Range() {
      return iPv4Range;
    }

    /**
     * The range of internal addresses that are legal on this network. This range is a CIDR
     * specification, for example: 192.168.0.0/16. Provided by the client when the network is
     * created.
     */
    public Builder setIPv4Range(String iPv4Range) {
      this.iPv4Range = iPv4Range;
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

    /** [Output Only] Type of the resource. Always compute#network for networks. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#network for networks. */
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

    /** [Output Only] A list of network peerings for the resource. */
    public List<NetworkPeering> getPeeringsList() {
      return peerings;
    }

    /** [Output Only] A list of network peerings for the resource. */
    public Builder addAllPeerings(List<NetworkPeering> peerings) {
      if (this.peerings == null) {
        this.peerings = new LinkedList<>();
      }
      this.peerings.addAll(peerings);
      return this;
    }

    /** [Output Only] A list of network peerings for the resource. */
    public Builder addPeerings(NetworkPeering peerings) {
      if (this.peerings == null) {
        this.peerings = new LinkedList<>();
      }
      this.peerings.add(peerings);
      return this;
    }

    /**
     * The network-level routing configuration for this network. Used by Cloud Router to determine
     * what type of network-wide routing behavior to enforce.
     */
    public NetworkRoutingConfig getRoutingConfig() {
      return routingConfig;
    }

    /**
     * The network-level routing configuration for this network. Used by Cloud Router to determine
     * what type of network-wide routing behavior to enforce.
     */
    public Builder setRoutingConfig(NetworkRoutingConfig routingConfig) {
      this.routingConfig = routingConfig;
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
     * [Output Only] Server-defined fully-qualified URLs for all subnetworks in this VPC network.
     */
    public List<String> getSubnetworksList() {
      return subnetworks;
    }

    /**
     * [Output Only] Server-defined fully-qualified URLs for all subnetworks in this VPC network.
     */
    public Builder addAllSubnetworks(List<String> subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.addAll(subnetworks);
      return this;
    }

    /**
     * [Output Only] Server-defined fully-qualified URLs for all subnetworks in this VPC network.
     */
    public Builder addSubnetworks(String subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.add(subnetworks);
      return this;
    }

    public Network build() {

      return new Network(
          autoCreateSubnetworks,
          creationTimestamp,
          description,
          gatewayIPv4,
          iPv4Range,
          id,
          kind,
          name,
          peerings,
          routingConfig,
          selfLink,
          subnetworks);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoCreateSubnetworks(this.autoCreateSubnetworks);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setGatewayIPv4(this.gatewayIPv4);
      newBuilder.setIPv4Range(this.iPv4Range);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllPeerings(this.peerings);
      newBuilder.setRoutingConfig(this.routingConfig);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSubnetworks(this.subnetworks);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Network{"
        + "autoCreateSubnetworks="
        + autoCreateSubnetworks
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "gatewayIPv4="
        + gatewayIPv4
        + ", "
        + "iPv4Range="
        + iPv4Range
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
        + "peerings="
        + peerings
        + ", "
        + "routingConfig="
        + routingConfig
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "subnetworks="
        + subnetworks
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Network) {
      Network that = (Network) o;
      return Objects.equals(this.autoCreateSubnetworks, that.getAutoCreateSubnetworks())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.gatewayIPv4, that.getGatewayIPv4())
          && Objects.equals(this.iPv4Range, that.getIPv4Range())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerings, that.getPeeringsList())
          && Objects.equals(this.routingConfig, that.getRoutingConfig())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.subnetworks, that.getSubnetworksList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoCreateSubnetworks,
        creationTimestamp,
        description,
        gatewayIPv4,
        iPv4Range,
        id,
        kind,
        name,
        peerings,
        routingConfig,
        selfLink,
        subnetworks);
  }
}
