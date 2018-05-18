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
public final class Subnetwork implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final Boolean enableFlowLogs;
  private final String fingerprint;
  private final String gatewayAddress;
  private final String id;
  private final String ipCidrRange;
  private final String kind;
  private final String name;
  private final String network;
  private final Boolean privateIpGoogleAccess;
  private final String region;
  private final List<SubnetworkSecondaryRange> secondaryIpRanges;
  private final String selfLink;

  private Subnetwork() {
    this.creationTimestamp = null;
    this.description = null;
    this.enableFlowLogs = null;
    this.fingerprint = null;
    this.gatewayAddress = null;
    this.id = null;
    this.ipCidrRange = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.privateIpGoogleAccess = null;
    this.region = null;
    this.secondaryIpRanges = null;
    this.selfLink = null;
  }

  private Subnetwork(
      String creationTimestamp,
      String description,
      Boolean enableFlowLogs,
      String fingerprint,
      String gatewayAddress,
      String id,
      String ipCidrRange,
      String kind,
      String name,
      String network,
      Boolean privateIpGoogleAccess,
      String region,
      List<SubnetworkSecondaryRange> secondaryIpRanges,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.enableFlowLogs = enableFlowLogs;
    this.fingerprint = fingerprint;
    this.gatewayAddress = gatewayAddress;
    this.id = id;
    this.ipCidrRange = ipCidrRange;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.privateIpGoogleAccess = privateIpGoogleAccess;
    this.region = region;
    this.secondaryIpRanges = secondaryIpRanges;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("enableFlowLogs")) {
      return enableFlowLogs;
    }
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
    }
    if (fieldName.equals("gatewayAddress")) {
      return gatewayAddress;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("ipCidrRange")) {
      return ipCidrRange;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("network")) {
      return network;
    }
    if (fieldName.equals("privateIpGoogleAccess")) {
      return privateIpGoogleAccess;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("secondaryIpRanges")) {
      return secondaryIpRanges;
    }
    if (fieldName.equals("selfLink")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public Boolean getEnableFlowLogs() {
    return enableFlowLogs;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public String getGatewayAddress() {
    return gatewayAddress;
  }

  public String getId() {
    return id;
  }

  public String getIpCidrRange() {
    return ipCidrRange;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getNetwork() {
    return network;
  }

  public Boolean getPrivateIpGoogleAccess() {
    return privateIpGoogleAccess;
  }

  public String getRegion() {
    return region;
  }

  public List<SubnetworkSecondaryRange> getSecondaryIpRangesList() {
    return secondaryIpRanges;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Subnetwork prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Subnetwork getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Subnetwork DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Subnetwork();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private Boolean enableFlowLogs;
    private String fingerprint;
    private String gatewayAddress;
    private String id;
    private String ipCidrRange;
    private String kind;
    private String name;
    private String network;
    private Boolean privateIpGoogleAccess;
    private String region;
    private List<SubnetworkSecondaryRange> secondaryIpRanges;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(Subnetwork other) {
      if (other == Subnetwork.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnableFlowLogs() != null) {
        this.enableFlowLogs = other.enableFlowLogs;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getGatewayAddress() != null) {
        this.gatewayAddress = other.gatewayAddress;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpCidrRange() != null) {
        this.ipCidrRange = other.ipCidrRange;
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
      if (other.getPrivateIpGoogleAccess() != null) {
        this.privateIpGoogleAccess = other.privateIpGoogleAccess;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSecondaryIpRangesList() != null) {
        this.secondaryIpRanges = other.secondaryIpRanges;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(Subnetwork source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.enableFlowLogs = source.enableFlowLogs;
      this.fingerprint = source.fingerprint;
      this.gatewayAddress = source.gatewayAddress;
      this.id = source.id;
      this.ipCidrRange = source.ipCidrRange;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.privateIpGoogleAccess = source.privateIpGoogleAccess;
      this.region = source.region;
      this.secondaryIpRanges = source.secondaryIpRanges;
      this.selfLink = source.selfLink;
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

    public Boolean getEnableFlowLogs() {
      return enableFlowLogs;
    }

    public Builder setEnableFlowLogs(Boolean enableFlowLogs) {
      this.enableFlowLogs = enableFlowLogs;
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public String getGatewayAddress() {
      return gatewayAddress;
    }

    public Builder setGatewayAddress(String gatewayAddress) {
      this.gatewayAddress = gatewayAddress;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getIpCidrRange() {
      return ipCidrRange;
    }

    public Builder setIpCidrRange(String ipCidrRange) {
      this.ipCidrRange = ipCidrRange;
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

    public String getNetwork() {
      return network;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public Boolean getPrivateIpGoogleAccess() {
      return privateIpGoogleAccess;
    }

    public Builder setPrivateIpGoogleAccess(Boolean privateIpGoogleAccess) {
      this.privateIpGoogleAccess = privateIpGoogleAccess;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public List<SubnetworkSecondaryRange> getSecondaryIpRangesList() {
      return secondaryIpRanges;
    }

    public Builder addAllSecondaryIpRanges(List<SubnetworkSecondaryRange> secondaryIpRanges) {
      if (this.secondaryIpRanges == null) {
        this.secondaryIpRanges = new ArrayList<>(secondaryIpRanges.size());
      }
      this.secondaryIpRanges.addAll(secondaryIpRanges);
      return this;
    }

    public Builder addSecondaryIpRanges(SubnetworkSecondaryRange secondaryIpRanges) {
      this.secondaryIpRanges.add(secondaryIpRanges);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Subnetwork build() {

      return new Subnetwork(
          creationTimestamp,
          description,
          enableFlowLogs,
          fingerprint,
          gatewayAddress,
          id,
          ipCidrRange,
          kind,
          name,
          network,
          privateIpGoogleAccess,
          region,
          secondaryIpRanges,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEnableFlowLogs(this.enableFlowLogs);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setGatewayAddress(this.gatewayAddress);
      newBuilder.setId(this.id);
      newBuilder.setIpCidrRange(this.ipCidrRange);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setPrivateIpGoogleAccess(this.privateIpGoogleAccess);
      newBuilder.setRegion(this.region);
      newBuilder.addAllSecondaryIpRanges(this.secondaryIpRanges);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Subnetwork{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "enableFlowLogs="
        + enableFlowLogs
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "gatewayAddress="
        + gatewayAddress
        + ", "
        + "id="
        + id
        + ", "
        + "ipCidrRange="
        + ipCidrRange
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
        + "privateIpGoogleAccess="
        + privateIpGoogleAccess
        + ", "
        + "region="
        + region
        + ", "
        + "secondaryIpRanges="
        + secondaryIpRanges
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
    if (o instanceof Subnetwork) {
      Subnetwork that = (Subnetwork) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enableFlowLogs, that.getEnableFlowLogs())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.gatewayAddress, that.getGatewayAddress())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipCidrRange, that.getIpCidrRange())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.privateIpGoogleAccess, that.getPrivateIpGoogleAccess())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.secondaryIpRanges, that.getSecondaryIpRangesList())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        enableFlowLogs,
        fingerprint,
        gatewayAddress,
        id,
        ipCidrRange,
        kind,
        name,
        network,
        privateIpGoogleAccess,
        region,
        secondaryIpRanges,
        selfLink);
  }
}
