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
 * Represents a Route resource. A route specifies how certain packets should be handled by the
 * network. Routes are associated with instances by tags and the set of routes for a particular
 * instance is called its routing table.
 *
 * <p>For each packet leaving an instance, the system searches that instance's routing table for a
 * single best matching route. Routes match packets by destination IP address, preferring smaller or
 * more specific ranges over larger ones. If there is a tie, the system selects the route with the
 * smallest priority value. If there is still a tie, it uses the layer three and four packet headers
 * to select just one of the remaining matching routes. The packet is then forwarded as specified by
 * the nextHop field of the winning route - either to another instance destination, an instance
 * gateway, or a Google Compute Engine-operated gateway.
 *
 * <p>Packets that do not match any route in the sending instance's routing table are dropped. (==
 * resource_for beta.routes ==) (== resource_for v1.routes ==)
 */
public final class Route implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String destRange;
  private final String id;
  private final String kind;
  private final String name;
  private final String network;
  private final String nextHopGateway;
  private final String nextHopInstance;
  private final String nextHopIp;
  private final String nextHopNetwork;
  private final String nextHopPeering;
  private final String nextHopVpnTunnel;
  private final Integer priority;
  private final String selfLink;
  private final List<String> tags;
  private final List<Warnings> warnings;

  private Route() {
    this.creationTimestamp = null;
    this.description = null;
    this.destRange = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.nextHopGateway = null;
    this.nextHopInstance = null;
    this.nextHopIp = null;
    this.nextHopNetwork = null;
    this.nextHopPeering = null;
    this.nextHopVpnTunnel = null;
    this.priority = null;
    this.selfLink = null;
    this.tags = null;
    this.warnings = null;
  }

  private Route(
      String creationTimestamp,
      String description,
      String destRange,
      String id,
      String kind,
      String name,
      String network,
      String nextHopGateway,
      String nextHopInstance,
      String nextHopIp,
      String nextHopNetwork,
      String nextHopPeering,
      String nextHopVpnTunnel,
      Integer priority,
      String selfLink,
      List<String> tags,
      List<Warnings> warnings) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.destRange = destRange;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.nextHopGateway = nextHopGateway;
    this.nextHopInstance = nextHopInstance;
    this.nextHopIp = nextHopIp;
    this.nextHopNetwork = nextHopNetwork;
    this.nextHopPeering = nextHopPeering;
    this.nextHopVpnTunnel = nextHopVpnTunnel;
    this.priority = priority;
    this.selfLink = selfLink;
    this.tags = tags;
    this.warnings = warnings;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("destRange".equals(fieldName)) {
      return destRange;
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
    if ("nextHopGateway".equals(fieldName)) {
      return nextHopGateway;
    }
    if ("nextHopInstance".equals(fieldName)) {
      return nextHopInstance;
    }
    if ("nextHopIp".equals(fieldName)) {
      return nextHopIp;
    }
    if ("nextHopNetwork".equals(fieldName)) {
      return nextHopNetwork;
    }
    if ("nextHopPeering".equals(fieldName)) {
      return nextHopPeering;
    }
    if ("nextHopVpnTunnel".equals(fieldName)) {
      return nextHopVpnTunnel;
    }
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("tags".equals(fieldName)) {
      return tags;
    }
    if ("warnings".equals(fieldName)) {
      return warnings;
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
   * The destination range of outgoing packets that this route applies to. Only IPv4 is supported.
   */
  public String getDestRange() {
    return destRange;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of this resource. Always compute#routes for Route resources. */
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

  /** Fully-qualified URL of the network that this route applies to. */
  public String getNetwork() {
    return network;
  }

  /**
   * The URL to a gateway that should handle matching packets. You can only specify the internet
   * gateway using a full or partial valid URL:
   * projects/&lt;project-id&gt;/global/gateways/default-internet-gateway
   */
  public String getNextHopGateway() {
    return nextHopGateway;
  }

  /**
   * The URL to an instance that should handle matching packets. You can specify this as a full or
   * partial URL. For example:
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/
   */
  public String getNextHopInstance() {
    return nextHopInstance;
  }

  /**
   * The network IP address of an instance that should handle matching packets. Only IPv4 is
   * supported.
   */
  public String getNextHopIp() {
    return nextHopIp;
  }

  /** The URL of the local network if it should handle matching packets. */
  public String getNextHopNetwork() {
    return nextHopNetwork;
  }

  /**
   * [Output Only] The network peering name that should handle matching packets, which should
   * conform to RFC1035.
   */
  public String getNextHopPeering() {
    return nextHopPeering;
  }

  /** The URL to a VpnTunnel that should handle matching packets. */
  public String getNextHopVpnTunnel() {
    return nextHopVpnTunnel;
  }

  /**
   * The priority of this route. Priority is used to break ties in cases where there is more than
   * one matching route of equal prefix length. In the case of two routes with equal prefix length,
   * the one with the lowest-numbered priority value wins. Default value is 1000. Valid range is 0
   * through 65535.
   */
  public Integer getPriority() {
    return priority;
  }

  /** [Output Only] Server-defined fully-qualified URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** A list of instance tags to which this route applies. */
  public List<String> getTagsList() {
    return tags;
  }

  /**
   * [Output Only] If potential misconfigurations are detected for this route, this field will be
   * populated with warning messages.
   */
  public List<Warnings> getWarningsList() {
    return warnings;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Route prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Route getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Route DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Route();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String destRange;
    private String id;
    private String kind;
    private String name;
    private String network;
    private String nextHopGateway;
    private String nextHopInstance;
    private String nextHopIp;
    private String nextHopNetwork;
    private String nextHopPeering;
    private String nextHopVpnTunnel;
    private Integer priority;
    private String selfLink;
    private List<String> tags;
    private List<Warnings> warnings;

    Builder() {}

    public Builder mergeFrom(Route other) {
      if (other == Route.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDestRange() != null) {
        this.destRange = other.destRange;
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
      if (other.getNextHopGateway() != null) {
        this.nextHopGateway = other.nextHopGateway;
      }
      if (other.getNextHopInstance() != null) {
        this.nextHopInstance = other.nextHopInstance;
      }
      if (other.getNextHopIp() != null) {
        this.nextHopIp = other.nextHopIp;
      }
      if (other.getNextHopNetwork() != null) {
        this.nextHopNetwork = other.nextHopNetwork;
      }
      if (other.getNextHopPeering() != null) {
        this.nextHopPeering = other.nextHopPeering;
      }
      if (other.getNextHopVpnTunnel() != null) {
        this.nextHopVpnTunnel = other.nextHopVpnTunnel;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getTagsList() != null) {
        this.tags = other.tags;
      }
      if (other.getWarningsList() != null) {
        this.warnings = other.warnings;
      }
      return this;
    }

    Builder(Route source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.destRange = source.destRange;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.nextHopGateway = source.nextHopGateway;
      this.nextHopInstance = source.nextHopInstance;
      this.nextHopIp = source.nextHopIp;
      this.nextHopNetwork = source.nextHopNetwork;
      this.nextHopPeering = source.nextHopPeering;
      this.nextHopVpnTunnel = source.nextHopVpnTunnel;
      this.priority = source.priority;
      this.selfLink = source.selfLink;
      this.tags = source.tags;
      this.warnings = source.warnings;
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
     * The destination range of outgoing packets that this route applies to. Only IPv4 is supported.
     */
    public String getDestRange() {
      return destRange;
    }

    /**
     * The destination range of outgoing packets that this route applies to. Only IPv4 is supported.
     */
    public Builder setDestRange(String destRange) {
      this.destRange = destRange;
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

    /** [Output Only] Type of this resource. Always compute#routes for Route resources. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of this resource. Always compute#routes for Route resources. */
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

    /** Fully-qualified URL of the network that this route applies to. */
    public String getNetwork() {
      return network;
    }

    /** Fully-qualified URL of the network that this route applies to. */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * The URL to a gateway that should handle matching packets. You can only specify the internet
     * gateway using a full or partial valid URL:
     * projects/&lt;project-id&gt;/global/gateways/default-internet-gateway
     */
    public String getNextHopGateway() {
      return nextHopGateway;
    }

    /**
     * The URL to a gateway that should handle matching packets. You can only specify the internet
     * gateway using a full or partial valid URL:
     * projects/&lt;project-id&gt;/global/gateways/default-internet-gateway
     */
    public Builder setNextHopGateway(String nextHopGateway) {
      this.nextHopGateway = nextHopGateway;
      return this;
    }

    /**
     * The URL to an instance that should handle matching packets. You can specify this as a full or
     * partial URL. For example:
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/
     */
    public String getNextHopInstance() {
      return nextHopInstance;
    }

    /**
     * The URL to an instance that should handle matching packets. You can specify this as a full or
     * partial URL. For example:
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/
     */
    public Builder setNextHopInstance(String nextHopInstance) {
      this.nextHopInstance = nextHopInstance;
      return this;
    }

    /**
     * The network IP address of an instance that should handle matching packets. Only IPv4 is
     * supported.
     */
    public String getNextHopIp() {
      return nextHopIp;
    }

    /**
     * The network IP address of an instance that should handle matching packets. Only IPv4 is
     * supported.
     */
    public Builder setNextHopIp(String nextHopIp) {
      this.nextHopIp = nextHopIp;
      return this;
    }

    /** The URL of the local network if it should handle matching packets. */
    public String getNextHopNetwork() {
      return nextHopNetwork;
    }

    /** The URL of the local network if it should handle matching packets. */
    public Builder setNextHopNetwork(String nextHopNetwork) {
      this.nextHopNetwork = nextHopNetwork;
      return this;
    }

    /**
     * [Output Only] The network peering name that should handle matching packets, which should
     * conform to RFC1035.
     */
    public String getNextHopPeering() {
      return nextHopPeering;
    }

    /**
     * [Output Only] The network peering name that should handle matching packets, which should
     * conform to RFC1035.
     */
    public Builder setNextHopPeering(String nextHopPeering) {
      this.nextHopPeering = nextHopPeering;
      return this;
    }

    /** The URL to a VpnTunnel that should handle matching packets. */
    public String getNextHopVpnTunnel() {
      return nextHopVpnTunnel;
    }

    /** The URL to a VpnTunnel that should handle matching packets. */
    public Builder setNextHopVpnTunnel(String nextHopVpnTunnel) {
      this.nextHopVpnTunnel = nextHopVpnTunnel;
      return this;
    }

    /**
     * The priority of this route. Priority is used to break ties in cases where there is more than
     * one matching route of equal prefix length. In the case of two routes with equal prefix
     * length, the one with the lowest-numbered priority value wins. Default value is 1000. Valid
     * range is 0 through 65535.
     */
    public Integer getPriority() {
      return priority;
    }

    /**
     * The priority of this route. Priority is used to break ties in cases where there is more than
     * one matching route of equal prefix length. In the case of two routes with equal prefix
     * length, the one with the lowest-numbered priority value wins. Default value is 1000. Valid
     * range is 0 through 65535.
     */
    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** A list of instance tags to which this route applies. */
    public List<String> getTagsList() {
      return tags;
    }

    /** A list of instance tags to which this route applies. */
    public Builder addAllTags(List<String> tags) {
      if (this.tags == null) {
        this.tags = new LinkedList<>();
      }
      this.tags.addAll(tags);
      return this;
    }

    /** A list of instance tags to which this route applies. */
    public Builder addTags(String tags) {
      if (this.tags == null) {
        this.tags = new LinkedList<>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * [Output Only] If potential misconfigurations are detected for this route, this field will be
     * populated with warning messages.
     */
    public List<Warnings> getWarningsList() {
      return warnings;
    }

    /**
     * [Output Only] If potential misconfigurations are detected for this route, this field will be
     * populated with warning messages.
     */
    public Builder addAllWarnings(List<Warnings> warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.addAll(warnings);
      return this;
    }

    /**
     * [Output Only] If potential misconfigurations are detected for this route, this field will be
     * populated with warning messages.
     */
    public Builder addWarnings(Warnings warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.add(warnings);
      return this;
    }

    public Route build() {

      return new Route(
          creationTimestamp,
          description,
          destRange,
          id,
          kind,
          name,
          network,
          nextHopGateway,
          nextHopInstance,
          nextHopIp,
          nextHopNetwork,
          nextHopPeering,
          nextHopVpnTunnel,
          priority,
          selfLink,
          tags,
          warnings);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setDestRange(this.destRange);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNextHopGateway(this.nextHopGateway);
      newBuilder.setNextHopInstance(this.nextHopInstance);
      newBuilder.setNextHopIp(this.nextHopIp);
      newBuilder.setNextHopNetwork(this.nextHopNetwork);
      newBuilder.setNextHopPeering(this.nextHopPeering);
      newBuilder.setNextHopVpnTunnel(this.nextHopVpnTunnel);
      newBuilder.setPriority(this.priority);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllTags(this.tags);
      newBuilder.addAllWarnings(this.warnings);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Route{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "destRange="
        + destRange
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
        + "nextHopGateway="
        + nextHopGateway
        + ", "
        + "nextHopInstance="
        + nextHopInstance
        + ", "
        + "nextHopIp="
        + nextHopIp
        + ", "
        + "nextHopNetwork="
        + nextHopNetwork
        + ", "
        + "nextHopPeering="
        + nextHopPeering
        + ", "
        + "nextHopVpnTunnel="
        + nextHopVpnTunnel
        + ", "
        + "priority="
        + priority
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "tags="
        + tags
        + ", "
        + "warnings="
        + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Route) {
      Route that = (Route) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.destRange, that.getDestRange())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.nextHopGateway, that.getNextHopGateway())
          && Objects.equals(this.nextHopInstance, that.getNextHopInstance())
          && Objects.equals(this.nextHopIp, that.getNextHopIp())
          && Objects.equals(this.nextHopNetwork, that.getNextHopNetwork())
          && Objects.equals(this.nextHopPeering, that.getNextHopPeering())
          && Objects.equals(this.nextHopVpnTunnel, that.getNextHopVpnTunnel())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.tags, that.getTagsList())
          && Objects.equals(this.warnings, that.getWarningsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        destRange,
        id,
        kind,
        name,
        network,
        nextHopGateway,
        nextHopInstance,
        nextHopIp,
        nextHopNetwork,
        nextHopPeering,
        nextHopVpnTunnel,
        priority,
        selfLink,
        tags,
        warnings);
  }
}
