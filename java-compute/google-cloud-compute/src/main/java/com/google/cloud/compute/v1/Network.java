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
public final class Network implements ApiMessage {
  private final Boolean autoCreateSubnetworks;
  private final String creationTimestamp;
  private final String description;
  private final String gatewayIPv4;
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
    if (fieldName.equals("autoCreateSubnetworks")) {
      return autoCreateSubnetworks;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("gatewayIPv4")) {
      return gatewayIPv4;
    }
    if (fieldName.equals("iPv4Range")) {
      return iPv4Range;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("peerings")) {
      return peerings;
    }
    if (fieldName.equals("routingConfig")) {
      return routingConfig;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("subnetworks")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public Boolean getAutoCreateSubnetworks() {
    return autoCreateSubnetworks;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getGatewayIPv4() {
    return gatewayIPv4;
  }

  public String getIPv4Range() {
    return iPv4Range;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public List<NetworkPeering> getPeeringsList() {
    return peerings;
  }

  public NetworkRoutingConfig getRoutingConfig() {
    return routingConfig;
  }

  public String getSelfLink() {
    return selfLink;
  }

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

    public Boolean getAutoCreateSubnetworks() {
      return autoCreateSubnetworks;
    }

    public Builder setAutoCreateSubnetworks(Boolean autoCreateSubnetworks) {
      this.autoCreateSubnetworks = autoCreateSubnetworks;
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

    public String getGatewayIPv4() {
      return gatewayIPv4;
    }

    public Builder setGatewayIPv4(String gatewayIPv4) {
      this.gatewayIPv4 = gatewayIPv4;
      return this;
    }

    public String getIPv4Range() {
      return iPv4Range;
    }

    public Builder setIPv4Range(String iPv4Range) {
      this.iPv4Range = iPv4Range;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
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

    public List<NetworkPeering> getPeeringsList() {
      return peerings;
    }

    public Builder addAllPeerings(List<NetworkPeering> peerings) {
      if (this.peerings == null) {
        this.peerings = new ArrayList<>(peerings.size());
      }
      this.peerings.addAll(peerings);
      return this;
    }

    public Builder addPeerings(NetworkPeering peerings) {
      this.peerings.add(peerings);
      return this;
    }

    public NetworkRoutingConfig getRoutingConfig() {
      return routingConfig;
    }

    public Builder setRoutingConfig(NetworkRoutingConfig routingConfig) {
      this.routingConfig = routingConfig;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<String> getSubnetworksList() {
      return subnetworks;
    }

    public Builder addAllSubnetworks(List<String> subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new ArrayList<>(subnetworks.size());
      }
      this.subnetworks.addAll(subnetworks);
      return this;
    }

    public Builder addSubnetworks(String subnetworks) {
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
