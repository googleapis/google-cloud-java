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
public final class UsableSubnetwork implements ApiMessage {
  private final String ipCidrRange;
  private final String network;
  private final List<UsableSubnetworkSecondaryRange> secondaryIpRanges;
  private final String subnetwork;

  private UsableSubnetwork() {
    this.ipCidrRange = null;
    this.network = null;
    this.secondaryIpRanges = null;
    this.subnetwork = null;
  }

  private UsableSubnetwork(
      String ipCidrRange,
      String network,
      List<UsableSubnetworkSecondaryRange> secondaryIpRanges,
      String subnetwork) {
    this.ipCidrRange = ipCidrRange;
    this.network = network;
    this.secondaryIpRanges = secondaryIpRanges;
    this.subnetwork = subnetwork;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("ipCidrRange")) {
      return ipCidrRange;
    }
    if (fieldName.equals("network")) {
      return network;
    }
    if (fieldName.equals("secondaryIpRanges")) {
      return secondaryIpRanges;
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

  public String getIpCidrRange() {
    return ipCidrRange;
  }

  public String getNetwork() {
    return network;
  }

  public List<UsableSubnetworkSecondaryRange> getSecondaryIpRangesList() {
    return secondaryIpRanges;
  }

  public String getSubnetwork() {
    return subnetwork;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UsableSubnetwork prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UsableSubnetwork getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UsableSubnetwork DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UsableSubnetwork();
  }

  public static class Builder {
    private String ipCidrRange;
    private String network;
    private List<UsableSubnetworkSecondaryRange> secondaryIpRanges;
    private String subnetwork;

    Builder() {}

    public Builder mergeFrom(UsableSubnetwork other) {
      if (other == UsableSubnetwork.getDefaultInstance()) return this;
      if (other.getIpCidrRange() != null) {
        this.ipCidrRange = other.ipCidrRange;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getSecondaryIpRangesList() != null) {
        this.secondaryIpRanges = other.secondaryIpRanges;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      return this;
    }

    Builder(UsableSubnetwork source) {
      this.ipCidrRange = source.ipCidrRange;
      this.network = source.network;
      this.secondaryIpRanges = source.secondaryIpRanges;
      this.subnetwork = source.subnetwork;
    }

    public String getIpCidrRange() {
      return ipCidrRange;
    }

    public Builder setIpCidrRange(String ipCidrRange) {
      this.ipCidrRange = ipCidrRange;
      return this;
    }

    public String getNetwork() {
      return network;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public List<UsableSubnetworkSecondaryRange> getSecondaryIpRangesList() {
      return secondaryIpRanges;
    }

    public Builder addAllSecondaryIpRanges(List<UsableSubnetworkSecondaryRange> secondaryIpRanges) {
      if (this.secondaryIpRanges == null) {
        this.secondaryIpRanges = new LinkedList<>();
      }
      this.secondaryIpRanges.addAll(secondaryIpRanges);
      return this;
    }

    public Builder addSecondaryIpRanges(UsableSubnetworkSecondaryRange secondaryIpRanges) {
      if (this.secondaryIpRanges == null) {
        this.secondaryIpRanges = new LinkedList<>();
      }
      this.secondaryIpRanges.add(secondaryIpRanges);
      return this;
    }

    public String getSubnetwork() {
      return subnetwork;
    }

    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    public UsableSubnetwork build() {

      return new UsableSubnetwork(ipCidrRange, network, secondaryIpRanges, subnetwork);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIpCidrRange(this.ipCidrRange);
      newBuilder.setNetwork(this.network);
      newBuilder.addAllSecondaryIpRanges(this.secondaryIpRanges);
      newBuilder.setSubnetwork(this.subnetwork);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UsableSubnetwork{"
        + "ipCidrRange="
        + ipCidrRange
        + ", "
        + "network="
        + network
        + ", "
        + "secondaryIpRanges="
        + secondaryIpRanges
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
    if (o instanceof UsableSubnetwork) {
      UsableSubnetwork that = (UsableSubnetwork) o;
      return Objects.equals(this.ipCidrRange, that.getIpCidrRange())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.secondaryIpRanges, that.getSecondaryIpRangesList())
          && Objects.equals(this.subnetwork, that.getSubnetwork());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipCidrRange, network, secondaryIpRanges, subnetwork);
  }
}
