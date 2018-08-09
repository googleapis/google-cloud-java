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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ForwardingRule implements ApiMessage {
  private final String backendService;
  private final String creationTimestamp;
  private final String description;
  private final String iPAddress;
  private final String iPProtocol;
  private final String id;
  private final String ipVersion;
  private final String kind;
  private final String loadBalancingScheme;
  private final String name;
  private final String network;
  private final String networkTier;
  private final String portRange;
  private final List<String> ports;
  private final String region;
  private final String selfLink;
  private final String subnetwork;
  private final String target;

  private ForwardingRule() {
    this.backendService = null;
    this.creationTimestamp = null;
    this.description = null;
    this.iPAddress = null;
    this.iPProtocol = null;
    this.id = null;
    this.ipVersion = null;
    this.kind = null;
    this.loadBalancingScheme = null;
    this.name = null;
    this.network = null;
    this.networkTier = null;
    this.portRange = null;
    this.ports = null;
    this.region = null;
    this.selfLink = null;
    this.subnetwork = null;
    this.target = null;
  }

  private ForwardingRule(
      String backendService,
      String creationTimestamp,
      String description,
      String iPAddress,
      String iPProtocol,
      String id,
      String ipVersion,
      String kind,
      String loadBalancingScheme,
      String name,
      String network,
      String networkTier,
      String portRange,
      List<String> ports,
      String region,
      String selfLink,
      String subnetwork,
      String target) {
    this.backendService = backendService;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.iPAddress = iPAddress;
    this.iPProtocol = iPProtocol;
    this.id = id;
    this.ipVersion = ipVersion;
    this.kind = kind;
    this.loadBalancingScheme = loadBalancingScheme;
    this.name = name;
    this.network = network;
    this.networkTier = networkTier;
    this.portRange = portRange;
    this.ports = ports;
    this.region = region;
    this.selfLink = selfLink;
    this.subnetwork = subnetwork;
    this.target = target;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("backendService")) {
      return backendService;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("iPAddress")) {
      return iPAddress;
    }
    if (fieldName.equals("iPProtocol")) {
      return iPProtocol;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("ipVersion")) {
      return ipVersion;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("loadBalancingScheme")) {
      return loadBalancingScheme;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("network")) {
      return network;
    }
    if (fieldName.equals("networkTier")) {
      return networkTier;
    }
    if (fieldName.equals("portRange")) {
      return portRange;
    }
    if (fieldName.equals("ports")) {
      return ports;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("subnetwork")) {
      return subnetwork;
    }
    if (fieldName.equals("target")) {
      return target;
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

  public String getBackendService() {
    return backendService;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getIPAddress() {
    return iPAddress;
  }

  public String getIPProtocol() {
    return iPProtocol;
  }

  public String getId() {
    return id;
  }

  public String getIpVersion() {
    return ipVersion;
  }

  public String getKind() {
    return kind;
  }

  public String getLoadBalancingScheme() {
    return loadBalancingScheme;
  }

  public String getName() {
    return name;
  }

  public String getNetwork() {
    return network;
  }

  public String getNetworkTier() {
    return networkTier;
  }

  public String getPortRange() {
    return portRange;
  }

  public List<String> getPortsList() {
    return ports;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getSubnetwork() {
    return subnetwork;
  }

  public String getTarget() {
    return target;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ForwardingRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ForwardingRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ForwardingRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ForwardingRule();
  }

  public static class Builder {
    private String backendService;
    private String creationTimestamp;
    private String description;
    private String iPAddress;
    private String iPProtocol;
    private String id;
    private String ipVersion;
    private String kind;
    private String loadBalancingScheme;
    private String name;
    private String network;
    private String networkTier;
    private String portRange;
    private List<String> ports;
    private String region;
    private String selfLink;
    private String subnetwork;
    private String target;

    Builder() {}

    public Builder mergeFrom(ForwardingRule other) {
      if (other == ForwardingRule.getDefaultInstance()) return this;
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getIPAddress() != null) {
        this.iPAddress = other.iPAddress;
      }
      if (other.getIPProtocol() != null) {
        this.iPProtocol = other.iPProtocol;
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
      if (other.getLoadBalancingScheme() != null) {
        this.loadBalancingScheme = other.loadBalancingScheme;
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
      if (other.getPortRange() != null) {
        this.portRange = other.portRange;
      }
      if (other.getPortsList() != null) {
        this.ports = other.ports;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      return this;
    }

    Builder(ForwardingRule source) {
      this.backendService = source.backendService;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.iPAddress = source.iPAddress;
      this.iPProtocol = source.iPProtocol;
      this.id = source.id;
      this.ipVersion = source.ipVersion;
      this.kind = source.kind;
      this.loadBalancingScheme = source.loadBalancingScheme;
      this.name = source.name;
      this.network = source.network;
      this.networkTier = source.networkTier;
      this.portRange = source.portRange;
      this.ports = source.ports;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.subnetwork = source.subnetwork;
      this.target = source.target;
    }

    public String getBackendService() {
      return backendService;
    }

    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
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

    public String getIPAddress() {
      return iPAddress;
    }

    public Builder setIPAddress(String iPAddress) {
      this.iPAddress = iPAddress;
      return this;
    }

    public String getIPProtocol() {
      return iPProtocol;
    }

    public Builder setIPProtocol(String iPProtocol) {
      this.iPProtocol = iPProtocol;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getIpVersion() {
      return ipVersion;
    }

    public Builder setIpVersion(String ipVersion) {
      this.ipVersion = ipVersion;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getLoadBalancingScheme() {
      return loadBalancingScheme;
    }

    public Builder setLoadBalancingScheme(String loadBalancingScheme) {
      this.loadBalancingScheme = loadBalancingScheme;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getNetwork() {
      return network;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public String getNetworkTier() {
      return networkTier;
    }

    public Builder setNetworkTier(String networkTier) {
      this.networkTier = networkTier;
      return this;
    }

    public String getPortRange() {
      return portRange;
    }

    public Builder setPortRange(String portRange) {
      this.portRange = portRange;
      return this;
    }

    public List<String> getPortsList() {
      return ports;
    }

    public Builder addAllPorts(List<String> ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.addAll(ports);
      return this;
    }

    public Builder addPorts(String ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.add(ports);
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getSubnetwork() {
      return subnetwork;
    }

    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    public String getTarget() {
      return target;
    }

    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    public ForwardingRule build() {

      return new ForwardingRule(
          backendService,
          creationTimestamp,
          description,
          iPAddress,
          iPProtocol,
          id,
          ipVersion,
          kind,
          loadBalancingScheme,
          name,
          network,
          networkTier,
          portRange,
          ports,
          region,
          selfLink,
          subnetwork,
          target);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBackendService(this.backendService);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setIPAddress(this.iPAddress);
      newBuilder.setIPProtocol(this.iPProtocol);
      newBuilder.setId(this.id);
      newBuilder.setIpVersion(this.ipVersion);
      newBuilder.setKind(this.kind);
      newBuilder.setLoadBalancingScheme(this.loadBalancingScheme);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkTier(this.networkTier);
      newBuilder.setPortRange(this.portRange);
      newBuilder.addAllPorts(this.ports);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setTarget(this.target);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ForwardingRule{"
        + "backendService="
        + backendService
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "iPAddress="
        + iPAddress
        + ", "
        + "iPProtocol="
        + iPProtocol
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
        + "loadBalancingScheme="
        + loadBalancingScheme
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
        + "portRange="
        + portRange
        + ", "
        + "ports="
        + ports
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "subnetwork="
        + subnetwork
        + ", "
        + "target="
        + target
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ForwardingRule) {
      ForwardingRule that = (ForwardingRule) o;
      return Objects.equals(this.backendService, that.getBackendService())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.iPAddress, that.getIPAddress())
          && Objects.equals(this.iPProtocol, that.getIPProtocol())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipVersion, that.getIpVersion())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.loadBalancingScheme, that.getLoadBalancingScheme())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkTier, that.getNetworkTier())
          && Objects.equals(this.portRange, that.getPortRange())
          && Objects.equals(this.ports, that.getPortsList())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.target, that.getTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        backendService,
        creationTimestamp,
        description,
        iPAddress,
        iPProtocol,
        id,
        ipVersion,
        kind,
        loadBalancingScheme,
        name,
        network,
        networkTier,
        portRange,
        ports,
        region,
        selfLink,
        subnetwork,
        target);
  }
}
