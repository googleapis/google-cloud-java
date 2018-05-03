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
public final class NetworkInterface implements ApiMessage {
  private final List<AccessConfig> accessConfigs;
  private final List<AliasIpRange> aliasIpRanges;
  private final String fingerprint;
  private final String kind;
  private final String name;
  private final String network;
  private final String networkIP;
  private final String subnetwork;

  private NetworkInterface() {
    this.accessConfigs = null;
    this.aliasIpRanges = null;
    this.fingerprint = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.networkIP = null;
    this.subnetwork = null;
  }

  private NetworkInterface(
      List<AccessConfig> accessConfigs,
      List<AliasIpRange> aliasIpRanges,
      String fingerprint,
      String kind,
      String name,
      String network,
      String networkIP,
      String subnetwork) {
    this.accessConfigs = accessConfigs;
    this.aliasIpRanges = aliasIpRanges;
    this.fingerprint = fingerprint;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.networkIP = networkIP;
    this.subnetwork = subnetwork;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("accessConfigs")) {
      return accessConfigs;
    }
    if (fieldName.equals("aliasIpRanges")) {
      return aliasIpRanges;
    }
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
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
    if (fieldName.equals("networkIP")) {
      return networkIP;
    }
    if (fieldName.equals("subnetwork")) {
      return subnetwork;
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

  public List<AccessConfig> getAccessConfigsList() {
    return accessConfigs;
  }

  public List<AliasIpRange> getAliasIpRangesList() {
    return aliasIpRanges;
  }

  public String getFingerprint() {
    return fingerprint;
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

  public String getNetworkIP() {
    return networkIP;
  }

  public String getSubnetwork() {
    return subnetwork;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkInterface prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkInterface getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkInterface DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkInterface();
  }

  public static class Builder {
    private List<AccessConfig> accessConfigs;
    private List<AliasIpRange> aliasIpRanges;
    private String fingerprint;
    private String kind;
    private String name;
    private String network;
    private String networkIP;
    private String subnetwork;

    Builder() {}

    public Builder mergeFrom(NetworkInterface other) {
      if (other == NetworkInterface.getDefaultInstance()) return this;
      if (other.getAccessConfigsList() != null) {
        this.accessConfigs = other.accessConfigs;
      }
      if (other.getAliasIpRangesList() != null) {
        this.aliasIpRanges = other.aliasIpRanges;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
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
      if (other.getNetworkIP() != null) {
        this.networkIP = other.networkIP;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      return this;
    }

    Builder(NetworkInterface source) {
      this.accessConfigs = source.accessConfigs;
      this.aliasIpRanges = source.aliasIpRanges;
      this.fingerprint = source.fingerprint;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.networkIP = source.networkIP;
      this.subnetwork = source.subnetwork;
    }

    public List<AccessConfig> getAccessConfigsList() {
      return accessConfigs;
    }

    public Builder addAllAccessConfigs(List<AccessConfig> accessConfigs) {
      if (this.accessConfigs == null) {
        this.accessConfigs = new ArrayList<>(accessConfigs.size());
      }
      this.accessConfigs.addAll(accessConfigs);
      return this;
    }

    public Builder addAccessConfigs(AccessConfig accessConfigs) {
      this.accessConfigs.add(accessConfigs);
      return this;
    }

    public List<AliasIpRange> getAliasIpRangesList() {
      return aliasIpRanges;
    }

    public Builder addAllAliasIpRanges(List<AliasIpRange> aliasIpRanges) {
      if (this.aliasIpRanges == null) {
        this.aliasIpRanges = new ArrayList<>(aliasIpRanges.size());
      }
      this.aliasIpRanges.addAll(aliasIpRanges);
      return this;
    }

    public Builder addAliasIpRanges(AliasIpRange aliasIpRanges) {
      this.aliasIpRanges.add(aliasIpRanges);
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
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

    public String getNetworkIP() {
      return networkIP;
    }

    public Builder setNetworkIP(String networkIP) {
      this.networkIP = networkIP;
      return this;
    }

    public String getSubnetwork() {
      return subnetwork;
    }

    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    public NetworkInterface build() {

      return new NetworkInterface(
          accessConfigs, aliasIpRanges, fingerprint, kind, name, network, networkIP, subnetwork);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAccessConfigs(this.accessConfigs);
      newBuilder.addAllAliasIpRanges(this.aliasIpRanges);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkIP(this.networkIP);
      newBuilder.setSubnetwork(this.subnetwork);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkInterface{"
        + "accessConfigs="
        + accessConfigs
        + ", "
        + "aliasIpRanges="
        + aliasIpRanges
        + ", "
        + "fingerprint="
        + fingerprint
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
        + "networkIP="
        + networkIP
        + ", "
        + "subnetwork="
        + subnetwork
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkInterface) {
      NetworkInterface that = (NetworkInterface) o;
      return Objects.equals(this.accessConfigs, that.getAccessConfigsList())
          && Objects.equals(this.aliasIpRanges, that.getAliasIpRangesList())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkIP, that.getNetworkIP())
          && Objects.equals(this.subnetwork, that.getSubnetwork());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accessConfigs, aliasIpRanges, fingerprint, kind, name, network, networkIP, subnetwork);
  }
}
