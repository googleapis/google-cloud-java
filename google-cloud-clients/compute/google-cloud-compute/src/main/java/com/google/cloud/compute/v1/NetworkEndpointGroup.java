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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Represents a collection of network endpoints. */
public final class NetworkEndpointGroup implements ApiMessage {
  private final String creationTimestamp;
  private final Integer defaultPort;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String network;
  private final String networkEndpointType;
  private final String selfLink;
  private final Integer size;
  private final String subnetwork;
  private final String zone;

  private NetworkEndpointGroup() {
    this.creationTimestamp = null;
    this.defaultPort = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.networkEndpointType = null;
    this.selfLink = null;
    this.size = null;
    this.subnetwork = null;
    this.zone = null;
  }

  private NetworkEndpointGroup(
      String creationTimestamp,
      Integer defaultPort,
      String description,
      String id,
      String kind,
      String name,
      String network,
      String networkEndpointType,
      String selfLink,
      Integer size,
      String subnetwork,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.defaultPort = defaultPort;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.networkEndpointType = networkEndpointType;
    this.selfLink = selfLink;
    this.size = size;
    this.subnetwork = subnetwork;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("defaultPort".equals(fieldName)) {
      return defaultPort;
    }
    if ("description".equals(fieldName)) {
      return description;
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
    if ("networkEndpointType".equals(fieldName)) {
      return networkEndpointType;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("size".equals(fieldName)) {
      return size;
    }
    if ("subnetwork".equals(fieldName)) {
      return subnetwork;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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

  /** The default port used if the port number is not specified in the network endpoint. */
  public Integer getDefaultPort() {
    return defaultPort;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
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
   * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
   * group.
   */
  public String getKind() {
    return kind;
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
   * The URL of the network to which all network endpoints in the NEG belong. Uses "default" project
   * network if unspecified.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * Type of network endpoints in this network endpoint group. Currently the only supported value is
   * GCE_VM_IP_PORT.
   */
  public String getNetworkEndpointType() {
    return networkEndpointType;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output only] Number of network endpoints in the network endpoint group. */
  public Integer getSize() {
    return size;
  }

  /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
  public String getSubnetwork() {
    return subnetwork;
  }

  /** [Output Only] The URL of the zone where the network endpoint group is located. */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroup prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroup getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroup DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroup();
  }

  public static class Builder {
    private String creationTimestamp;
    private Integer defaultPort;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String network;
    private String networkEndpointType;
    private String selfLink;
    private Integer size;
    private String subnetwork;
    private String zone;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroup other) {
      if (other == NetworkEndpointGroup.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDefaultPort() != null) {
        this.defaultPort = other.defaultPort;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
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
      if (other.getNetworkEndpointType() != null) {
        this.networkEndpointType = other.networkEndpointType;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSize() != null) {
        this.size = other.size;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(NetworkEndpointGroup source) {
      this.creationTimestamp = source.creationTimestamp;
      this.defaultPort = source.defaultPort;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.networkEndpointType = source.networkEndpointType;
      this.selfLink = source.selfLink;
      this.size = source.size;
      this.subnetwork = source.subnetwork;
      this.zone = source.zone;
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

    /** The default port used if the port number is not specified in the network endpoint. */
    public Integer getDefaultPort() {
      return defaultPort;
    }

    /** The default port used if the port number is not specified in the network endpoint. */
    public Builder setDefaultPort(Integer defaultPort) {
      this.defaultPort = defaultPort;
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
     * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
     * group.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
     * group.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
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
     * The URL of the network to which all network endpoints in the NEG belong. Uses "default"
     * project network if unspecified.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * The URL of the network to which all network endpoints in the NEG belong. Uses "default"
     * project network if unspecified.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * Type of network endpoints in this network endpoint group. Currently the only supported value
     * is GCE_VM_IP_PORT.
     */
    public String getNetworkEndpointType() {
      return networkEndpointType;
    }

    /**
     * Type of network endpoints in this network endpoint group. Currently the only supported value
     * is GCE_VM_IP_PORT.
     */
    public Builder setNetworkEndpointType(String networkEndpointType) {
      this.networkEndpointType = networkEndpointType;
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

    /** [Output only] Number of network endpoints in the network endpoint group. */
    public Integer getSize() {
      return size;
    }

    /** [Output only] Number of network endpoints in the network endpoint group. */
    public Builder setSize(Integer size) {
      this.size = size;
      return this;
    }

    /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
    public String getSubnetwork() {
      return subnetwork;
    }

    /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    /** [Output Only] The URL of the zone where the network endpoint group is located. */
    public String getZone() {
      return zone;
    }

    /** [Output Only] The URL of the zone where the network endpoint group is located. */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public NetworkEndpointGroup build() {

      return new NetworkEndpointGroup(
          creationTimestamp,
          defaultPort,
          description,
          id,
          kind,
          name,
          network,
          networkEndpointType,
          selfLink,
          size,
          subnetwork,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDefaultPort(this.defaultPort);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkEndpointType(this.networkEndpointType);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSize(this.size);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroup{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "defaultPort="
        + defaultPort
        + ", "
        + "description="
        + description
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
        + "networkEndpointType="
        + networkEndpointType
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "size="
        + size
        + ", "
        + "subnetwork="
        + subnetwork
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroup) {
      NetworkEndpointGroup that = (NetworkEndpointGroup) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.defaultPort, that.getDefaultPort())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkEndpointType, that.getNetworkEndpointType())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.size, that.getSize())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        defaultPort,
        description,
        id,
        kind,
        name,
        network,
        networkEndpointType,
        selfLink,
        size,
        subnetwork,
        zone);
  }
}
