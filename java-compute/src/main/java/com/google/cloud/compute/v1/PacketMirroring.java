/*
 * Copyright 2020 Google LLC
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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Represents a PacketMirroring resource. */
public final class PacketMirroring implements ApiMessage {
  private final PacketMirroringForwardingRuleInfo collectorIlb;
  private final String creationTimestamp;
  private final String description;
  private final String enable;
  private final PacketMirroringFilter filter;
  private final String id;
  private final String kind;
  private final PacketMirroringMirroredResourceInfo mirroredResources;
  private final String name;
  private final PacketMirroringNetworkInfo network;
  private final Integer priority;
  private final String region;
  private final String selfLink;

  private PacketMirroring() {
    this.collectorIlb = null;
    this.creationTimestamp = null;
    this.description = null;
    this.enable = null;
    this.filter = null;
    this.id = null;
    this.kind = null;
    this.mirroredResources = null;
    this.name = null;
    this.network = null;
    this.priority = null;
    this.region = null;
    this.selfLink = null;
  }

  private PacketMirroring(
      PacketMirroringForwardingRuleInfo collectorIlb,
      String creationTimestamp,
      String description,
      String enable,
      PacketMirroringFilter filter,
      String id,
      String kind,
      PacketMirroringMirroredResourceInfo mirroredResources,
      String name,
      PacketMirroringNetworkInfo network,
      Integer priority,
      String region,
      String selfLink) {
    this.collectorIlb = collectorIlb;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.enable = enable;
    this.filter = filter;
    this.id = id;
    this.kind = kind;
    this.mirroredResources = mirroredResources;
    this.name = name;
    this.network = network;
    this.priority = priority;
    this.region = region;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("collectorIlb".equals(fieldName)) {
      return collectorIlb;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("enable".equals(fieldName)) {
      return enable;
    }
    if ("filter".equals(fieldName)) {
      return filter;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("mirroredResources".equals(fieldName)) {
      return mirroredResources;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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
   * The Forwarding Rule resource of type loadBalancingScheme=INTERNAL that will be used as
   * collector for mirrored traffic. The specified forwarding rule must have isMirroringCollector
   * set to true.
   */
  public PacketMirroringForwardingRuleInfo getCollectorIlb() {
    return collectorIlb;
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
   * Indicates whether or not this packet mirroring takes effect. If set to FALSE, this packet
   * mirroring policy will not be enforced on the network.
   *
   * <p>The default is TRUE.
   */
  public String getEnable() {
    return enable;
  }

  /** Filter for mirrored traffic. If unspecified, all traffic is mirrored. */
  public PacketMirroringFilter getFilter() {
    return filter;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#packetMirroring for packet mirrorings. */
  public String getKind() {
    return kind;
  }

  /**
   * PacketMirroring mirroredResourceInfos. MirroredResourceInfo specifies a set of mirrored VM
   * instances, subnetworks and/or tags for which traffic from/to all VM instances will be mirrored.
   */
  public PacketMirroringMirroredResourceInfo getMirroredResources() {
    return mirroredResources;
  }

  /**
   * Name of the resource; provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * Specifies the mirrored VPC network. Only packets in this network will be mirrored. All mirrored
   * VMs should have a NIC in the given network. All mirrored subnetworks should belong to the given
   * network.
   */
  public PacketMirroringNetworkInfo getNetwork() {
    return network;
  }

  /**
   * The priority of applying this configuration. Priority is used to break ties in cases where
   * there is more than one matching rule. In the case of two rules that apply for a given Instance,
   * the one with the lowest-numbered priority value wins.
   *
   * <p>Default value is 1000. Valid range is 0 through 65535.
   */
  public Integer getPriority() {
    return priority;
  }

  /** [Output Only] URI of the region where the packetMirroring resides. */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PacketMirroring prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PacketMirroring getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PacketMirroring DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PacketMirroring();
  }

  public static class Builder {
    private PacketMirroringForwardingRuleInfo collectorIlb;
    private String creationTimestamp;
    private String description;
    private String enable;
    private PacketMirroringFilter filter;
    private String id;
    private String kind;
    private PacketMirroringMirroredResourceInfo mirroredResources;
    private String name;
    private PacketMirroringNetworkInfo network;
    private Integer priority;
    private String region;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(PacketMirroring other) {
      if (other == PacketMirroring.getDefaultInstance()) return this;
      if (other.getCollectorIlb() != null) {
        this.collectorIlb = other.collectorIlb;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnable() != null) {
        this.enable = other.enable;
      }
      if (other.getFilter() != null) {
        this.filter = other.filter;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getMirroredResources() != null) {
        this.mirroredResources = other.mirroredResources;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(PacketMirroring source) {
      this.collectorIlb = source.collectorIlb;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.enable = source.enable;
      this.filter = source.filter;
      this.id = source.id;
      this.kind = source.kind;
      this.mirroredResources = source.mirroredResources;
      this.name = source.name;
      this.network = source.network;
      this.priority = source.priority;
      this.region = source.region;
      this.selfLink = source.selfLink;
    }

    /**
     * The Forwarding Rule resource of type loadBalancingScheme=INTERNAL that will be used as
     * collector for mirrored traffic. The specified forwarding rule must have isMirroringCollector
     * set to true.
     */
    public PacketMirroringForwardingRuleInfo getCollectorIlb() {
      return collectorIlb;
    }

    /**
     * The Forwarding Rule resource of type loadBalancingScheme=INTERNAL that will be used as
     * collector for mirrored traffic. The specified forwarding rule must have isMirroringCollector
     * set to true.
     */
    public Builder setCollectorIlb(PacketMirroringForwardingRuleInfo collectorIlb) {
      this.collectorIlb = collectorIlb;
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
     * Indicates whether or not this packet mirroring takes effect. If set to FALSE, this packet
     * mirroring policy will not be enforced on the network.
     *
     * <p>The default is TRUE.
     */
    public String getEnable() {
      return enable;
    }

    /**
     * Indicates whether or not this packet mirroring takes effect. If set to FALSE, this packet
     * mirroring policy will not be enforced on the network.
     *
     * <p>The default is TRUE.
     */
    public Builder setEnable(String enable) {
      this.enable = enable;
      return this;
    }

    /** Filter for mirrored traffic. If unspecified, all traffic is mirrored. */
    public PacketMirroringFilter getFilter() {
      return filter;
    }

    /** Filter for mirrored traffic. If unspecified, all traffic is mirrored. */
    public Builder setFilter(PacketMirroringFilter filter) {
      this.filter = filter;
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

    /** [Output Only] Type of the resource. Always compute#packetMirroring for packet mirrorings. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#packetMirroring for packet mirrorings. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * PacketMirroring mirroredResourceInfos. MirroredResourceInfo specifies a set of mirrored VM
     * instances, subnetworks and/or tags for which traffic from/to all VM instances will be
     * mirrored.
     */
    public PacketMirroringMirroredResourceInfo getMirroredResources() {
      return mirroredResources;
    }

    /**
     * PacketMirroring mirroredResourceInfos. MirroredResourceInfo specifies a set of mirrored VM
     * instances, subnetworks and/or tags for which traffic from/to all VM instances will be
     * mirrored.
     */
    public Builder setMirroredResources(PacketMirroringMirroredResourceInfo mirroredResources) {
      this.mirroredResources = mirroredResources;
      return this;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
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
     * Specifies the mirrored VPC network. Only packets in this network will be mirrored. All
     * mirrored VMs should have a NIC in the given network. All mirrored subnetworks should belong
     * to the given network.
     */
    public PacketMirroringNetworkInfo getNetwork() {
      return network;
    }

    /**
     * Specifies the mirrored VPC network. Only packets in this network will be mirrored. All
     * mirrored VMs should have a NIC in the given network. All mirrored subnetworks should belong
     * to the given network.
     */
    public Builder setNetwork(PacketMirroringNetworkInfo network) {
      this.network = network;
      return this;
    }

    /**
     * The priority of applying this configuration. Priority is used to break ties in cases where
     * there is more than one matching rule. In the case of two rules that apply for a given
     * Instance, the one with the lowest-numbered priority value wins.
     *
     * <p>Default value is 1000. Valid range is 0 through 65535.
     */
    public Integer getPriority() {
      return priority;
    }

    /**
     * The priority of applying this configuration. Priority is used to break ties in cases where
     * there is more than one matching rule. In the case of two rules that apply for a given
     * Instance, the one with the lowest-numbered priority value wins.
     *
     * <p>Default value is 1000. Valid range is 0 through 65535.
     */
    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    /** [Output Only] URI of the region where the packetMirroring resides. */
    public String getRegion() {
      return region;
    }

    /** [Output Only] URI of the region where the packetMirroring resides. */
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

    public PacketMirroring build() {

      return new PacketMirroring(
          collectorIlb,
          creationTimestamp,
          description,
          enable,
          filter,
          id,
          kind,
          mirroredResources,
          name,
          network,
          priority,
          region,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCollectorIlb(this.collectorIlb);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEnable(this.enable);
      newBuilder.setFilter(this.filter);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setMirroredResources(this.mirroredResources);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setPriority(this.priority);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PacketMirroring{"
        + "collectorIlb="
        + collectorIlb
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "enable="
        + enable
        + ", "
        + "filter="
        + filter
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "mirroredResources="
        + mirroredResources
        + ", "
        + "name="
        + name
        + ", "
        + "network="
        + network
        + ", "
        + "priority="
        + priority
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PacketMirroring) {
      PacketMirroring that = (PacketMirroring) o;
      return Objects.equals(this.collectorIlb, that.getCollectorIlb())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enable, that.getEnable())
          && Objects.equals(this.filter, that.getFilter())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.mirroredResources, that.getMirroredResources())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        collectorIlb,
        creationTimestamp,
        description,
        enable,
        filter,
        id,
        kind,
        mirroredResources,
        name,
        network,
        priority,
        region,
        selfLink);
  }
}
