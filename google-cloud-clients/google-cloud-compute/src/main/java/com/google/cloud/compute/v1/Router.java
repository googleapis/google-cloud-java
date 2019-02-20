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
/** Router resource. */
public final class Router implements ApiMessage {
  private final RouterBgp bgp;
  private final List<RouterBgpPeer> bgpPeers;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final List<RouterInterface> interfaces;
  private final String kind;
  private final String name;
  private final List<RouterNat> nats;
  private final String network;
  private final String region;
  private final String selfLink;

  private Router() {
    this.bgp = null;
    this.bgpPeers = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.interfaces = null;
    this.kind = null;
    this.name = null;
    this.nats = null;
    this.network = null;
    this.region = null;
    this.selfLink = null;
  }

  private Router(
      RouterBgp bgp,
      List<RouterBgpPeer> bgpPeers,
      String creationTimestamp,
      String description,
      String id,
      List<RouterInterface> interfaces,
      String kind,
      String name,
      List<RouterNat> nats,
      String network,
      String region,
      String selfLink) {
    this.bgp = bgp;
    this.bgpPeers = bgpPeers;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.interfaces = interfaces;
    this.kind = kind;
    this.name = name;
    this.nats = nats;
    this.network = network;
    this.region = region;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("bgp".equals(fieldName)) {
      return bgp;
    }
    if ("bgpPeers".equals(fieldName)) {
      return bgpPeers;
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
    if ("interfaces".equals(fieldName)) {
      return interfaces;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("nats".equals(fieldName)) {
      return nats;
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

  /** BGP information specific to this router. */
  public RouterBgp getBgp() {
    return bgp;
  }

  /**
   * BGP information that needs to be configured into the routing stack to establish the BGP
   * peering. It must specify peer ASN and either interface name, IP, or peer IP. Please refer to
   * RFC4273.
   */
  public List<RouterBgpPeer> getBgpPeersList() {
    return bgpPeers;
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
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * Router interfaces. Each interface requires either one linked resource (e.g. linkedVpnTunnel),
   * or IP address and IP address range (e.g. ipRange), or both.
   */
  public List<RouterInterface> getInterfacesList() {
    return interfaces;
  }

  /** [Output Only] Type of resource. Always compute#router for routers. */
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

  /** A list of Nat services created in this router. */
  public List<RouterNat> getNatsList() {
    return nats;
  }

  /** URI of the network to which this router belongs. */
  public String getNetwork() {
    return network;
  }

  /**
   * [Output Only] URI of the region where the router resides. You must specify this field as part
   * of the HTTP request URL. It is not settable as a field in the request body.
   */
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

  public static Builder newBuilder(Router prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Router getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Router DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Router();
  }

  public static class Builder {
    private RouterBgp bgp;
    private List<RouterBgpPeer> bgpPeers;
    private String creationTimestamp;
    private String description;
    private String id;
    private List<RouterInterface> interfaces;
    private String kind;
    private String name;
    private List<RouterNat> nats;
    private String network;
    private String region;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(Router other) {
      if (other == Router.getDefaultInstance()) return this;
      if (other.getBgp() != null) {
        this.bgp = other.bgp;
      }
      if (other.getBgpPeersList() != null) {
        this.bgpPeers = other.bgpPeers;
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
      if (other.getInterfacesList() != null) {
        this.interfaces = other.interfaces;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNatsList() != null) {
        this.nats = other.nats;
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
      return this;
    }

    Builder(Router source) {
      this.bgp = source.bgp;
      this.bgpPeers = source.bgpPeers;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.interfaces = source.interfaces;
      this.kind = source.kind;
      this.name = source.name;
      this.nats = source.nats;
      this.network = source.network;
      this.region = source.region;
      this.selfLink = source.selfLink;
    }

    /** BGP information specific to this router. */
    public RouterBgp getBgp() {
      return bgp;
    }

    /** BGP information specific to this router. */
    public Builder setBgp(RouterBgp bgp) {
      this.bgp = bgp;
      return this;
    }

    /**
     * BGP information that needs to be configured into the routing stack to establish the BGP
     * peering. It must specify peer ASN and either interface name, IP, or peer IP. Please refer to
     * RFC4273.
     */
    public List<RouterBgpPeer> getBgpPeersList() {
      return bgpPeers;
    }

    /**
     * BGP information that needs to be configured into the routing stack to establish the BGP
     * peering. It must specify peer ASN and either interface name, IP, or peer IP. Please refer to
     * RFC4273.
     */
    public Builder addAllBgpPeers(List<RouterBgpPeer> bgpPeers) {
      if (this.bgpPeers == null) {
        this.bgpPeers = new LinkedList<>();
      }
      this.bgpPeers.addAll(bgpPeers);
      return this;
    }

    /**
     * BGP information that needs to be configured into the routing stack to establish the BGP
     * peering. It must specify peer ASN and either interface name, IP, or peer IP. Please refer to
     * RFC4273.
     */
    public Builder addBgpPeers(RouterBgpPeer bgpPeers) {
      if (this.bgpPeers == null) {
        this.bgpPeers = new LinkedList<>();
      }
      this.bgpPeers.add(bgpPeers);
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
     * Router interfaces. Each interface requires either one linked resource (e.g. linkedVpnTunnel),
     * or IP address and IP address range (e.g. ipRange), or both.
     */
    public List<RouterInterface> getInterfacesList() {
      return interfaces;
    }

    /**
     * Router interfaces. Each interface requires either one linked resource (e.g. linkedVpnTunnel),
     * or IP address and IP address range (e.g. ipRange), or both.
     */
    public Builder addAllInterfaces(List<RouterInterface> interfaces) {
      if (this.interfaces == null) {
        this.interfaces = new LinkedList<>();
      }
      this.interfaces.addAll(interfaces);
      return this;
    }

    /**
     * Router interfaces. Each interface requires either one linked resource (e.g. linkedVpnTunnel),
     * or IP address and IP address range (e.g. ipRange), or both.
     */
    public Builder addInterfaces(RouterInterface interfaces) {
      if (this.interfaces == null) {
        this.interfaces = new LinkedList<>();
      }
      this.interfaces.add(interfaces);
      return this;
    }

    /** [Output Only] Type of resource. Always compute#router for routers. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#router for routers. */
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

    /** A list of Nat services created in this router. */
    public List<RouterNat> getNatsList() {
      return nats;
    }

    /** A list of Nat services created in this router. */
    public Builder addAllNats(List<RouterNat> nats) {
      if (this.nats == null) {
        this.nats = new LinkedList<>();
      }
      this.nats.addAll(nats);
      return this;
    }

    /** A list of Nat services created in this router. */
    public Builder addNats(RouterNat nats) {
      if (this.nats == null) {
        this.nats = new LinkedList<>();
      }
      this.nats.add(nats);
      return this;
    }

    /** URI of the network to which this router belongs. */
    public String getNetwork() {
      return network;
    }

    /** URI of the network to which this router belongs. */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * [Output Only] URI of the region where the router resides. You must specify this field as part
     * of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URI of the region where the router resides. You must specify this field as part
     * of the HTTP request URL. It is not settable as a field in the request body.
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

    public Router build() {

      return new Router(
          bgp,
          bgpPeers,
          creationTimestamp,
          description,
          id,
          interfaces,
          kind,
          name,
          nats,
          network,
          region,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBgp(this.bgp);
      newBuilder.addAllBgpPeers(this.bgpPeers);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.addAllInterfaces(this.interfaces);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllNats(this.nats);
      newBuilder.setNetwork(this.network);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Router{"
        + "bgp="
        + bgp
        + ", "
        + "bgpPeers="
        + bgpPeers
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
        + "interfaces="
        + interfaces
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "nats="
        + nats
        + ", "
        + "network="
        + network
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
    if (o instanceof Router) {
      Router that = (Router) o;
      return Objects.equals(this.bgp, that.getBgp())
          && Objects.equals(this.bgpPeers, that.getBgpPeersList())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.interfaces, that.getInterfacesList())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.nats, that.getNatsList())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        bgp,
        bgpPeers,
        creationTimestamp,
        description,
        id,
        interfaces,
        kind,
        name,
        nats,
        network,
        region,
        selfLink);
  }
}
