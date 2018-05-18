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
public final class RouterBgpPeer implements ApiMessage {
  private final String advertiseMode;
  private final List<String> advertisedGroups;
  private final List<RouterAdvertisedIpRange> advertisedIpRanges;
  private final Integer advertisedRoutePriority;
  private final String interfaceName;
  private final String ipAddress;
  private final String name;
  private final Integer peerAsn;
  private final String peerIpAddress;

  private RouterBgpPeer() {
    this.advertiseMode = null;
    this.advertisedGroups = null;
    this.advertisedIpRanges = null;
    this.advertisedRoutePriority = null;
    this.interfaceName = null;
    this.ipAddress = null;
    this.name = null;
    this.peerAsn = null;
    this.peerIpAddress = null;
  }

  private RouterBgpPeer(
      String advertiseMode,
      List<String> advertisedGroups,
      List<RouterAdvertisedIpRange> advertisedIpRanges,
      Integer advertisedRoutePriority,
      String interfaceName,
      String ipAddress,
      String name,
      Integer peerAsn,
      String peerIpAddress) {
    this.advertiseMode = advertiseMode;
    this.advertisedGroups = advertisedGroups;
    this.advertisedIpRanges = advertisedIpRanges;
    this.advertisedRoutePriority = advertisedRoutePriority;
    this.interfaceName = interfaceName;
    this.ipAddress = ipAddress;
    this.name = name;
    this.peerAsn = peerAsn;
    this.peerIpAddress = peerIpAddress;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("advertiseMode")) {
      return advertiseMode;
    }
    if (fieldName.equals("advertisedGroups")) {
      return advertisedGroups;
    }
    if (fieldName.equals("advertisedIpRanges")) {
      return advertisedIpRanges;
    }
    if (fieldName.equals("advertisedRoutePriority")) {
      return advertisedRoutePriority;
    }
    if (fieldName.equals("interfaceName")) {
      return interfaceName;
    }
    if (fieldName.equals("ipAddress")) {
      return ipAddress;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("peerAsn")) {
      return peerAsn;
    }
    if (fieldName.equals("peerIpAddress")) {
      return peerIpAddress;
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

  public String getAdvertiseMode() {
    return advertiseMode;
  }

  public List<String> getAdvertisedGroupsList() {
    return advertisedGroups;
  }

  public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
    return advertisedIpRanges;
  }

  public Integer getAdvertisedRoutePriority() {
    return advertisedRoutePriority;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public String getName() {
    return name;
  }

  public Integer getPeerAsn() {
    return peerAsn;
  }

  public String getPeerIpAddress() {
    return peerIpAddress;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterBgpPeer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterBgpPeer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterBgpPeer DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterBgpPeer();
  }

  public static class Builder {
    private String advertiseMode;
    private List<String> advertisedGroups;
    private List<RouterAdvertisedIpRange> advertisedIpRanges;
    private Integer advertisedRoutePriority;
    private String interfaceName;
    private String ipAddress;
    private String name;
    private Integer peerAsn;
    private String peerIpAddress;

    Builder() {}

    public Builder mergeFrom(RouterBgpPeer other) {
      if (other == RouterBgpPeer.getDefaultInstance()) return this;
      if (other.getAdvertiseMode() != null) {
        this.advertiseMode = other.advertiseMode;
      }
      if (other.getAdvertisedGroupsList() != null) {
        this.advertisedGroups = other.advertisedGroups;
      }
      if (other.getAdvertisedIpRangesList() != null) {
        this.advertisedIpRanges = other.advertisedIpRanges;
      }
      if (other.getAdvertisedRoutePriority() != null) {
        this.advertisedRoutePriority = other.advertisedRoutePriority;
      }
      if (other.getInterfaceName() != null) {
        this.interfaceName = other.interfaceName;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPeerAsn() != null) {
        this.peerAsn = other.peerAsn;
      }
      if (other.getPeerIpAddress() != null) {
        this.peerIpAddress = other.peerIpAddress;
      }
      return this;
    }

    Builder(RouterBgpPeer source) {
      this.advertiseMode = source.advertiseMode;
      this.advertisedGroups = source.advertisedGroups;
      this.advertisedIpRanges = source.advertisedIpRanges;
      this.advertisedRoutePriority = source.advertisedRoutePriority;
      this.interfaceName = source.interfaceName;
      this.ipAddress = source.ipAddress;
      this.name = source.name;
      this.peerAsn = source.peerAsn;
      this.peerIpAddress = source.peerIpAddress;
    }

    public String getAdvertiseMode() {
      return advertiseMode;
    }

    public Builder setAdvertiseMode(String advertiseMode) {
      this.advertiseMode = advertiseMode;
      return this;
    }

    public List<String> getAdvertisedGroupsList() {
      return advertisedGroups;
    }

    public Builder addAllAdvertisedGroups(List<String> advertisedGroups) {
      if (this.advertisedGroups == null) {
        this.advertisedGroups = new ArrayList<>(advertisedGroups.size());
      }
      this.advertisedGroups.addAll(advertisedGroups);
      return this;
    }

    public Builder addAdvertisedGroups(String advertisedGroups) {
      this.advertisedGroups.add(advertisedGroups);
      return this;
    }

    public List<RouterAdvertisedIpRange> getAdvertisedIpRangesList() {
      return advertisedIpRanges;
    }

    public Builder addAllAdvertisedIpRanges(List<RouterAdvertisedIpRange> advertisedIpRanges) {
      if (this.advertisedIpRanges == null) {
        this.advertisedIpRanges = new ArrayList<>(advertisedIpRanges.size());
      }
      this.advertisedIpRanges.addAll(advertisedIpRanges);
      return this;
    }

    public Builder addAdvertisedIpRanges(RouterAdvertisedIpRange advertisedIpRanges) {
      this.advertisedIpRanges.add(advertisedIpRanges);
      return this;
    }

    public Integer getAdvertisedRoutePriority() {
      return advertisedRoutePriority;
    }

    public Builder setAdvertisedRoutePriority(Integer advertisedRoutePriority) {
      this.advertisedRoutePriority = advertisedRoutePriority;
      return this;
    }

    public String getInterfaceName() {
      return interfaceName;
    }

    public Builder setInterfaceName(String interfaceName) {
      this.interfaceName = interfaceName;
      return this;
    }

    public String getIpAddress() {
      return ipAddress;
    }

    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getPeerAsn() {
      return peerAsn;
    }

    public Builder setPeerAsn(Integer peerAsn) {
      this.peerAsn = peerAsn;
      return this;
    }

    public String getPeerIpAddress() {
      return peerIpAddress;
    }

    public Builder setPeerIpAddress(String peerIpAddress) {
      this.peerIpAddress = peerIpAddress;
      return this;
    }

    public RouterBgpPeer build() {

      return new RouterBgpPeer(
          advertiseMode,
          advertisedGroups,
          advertisedIpRanges,
          advertisedRoutePriority,
          interfaceName,
          ipAddress,
          name,
          peerAsn,
          peerIpAddress);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdvertiseMode(this.advertiseMode);
      newBuilder.addAllAdvertisedGroups(this.advertisedGroups);
      newBuilder.addAllAdvertisedIpRanges(this.advertisedIpRanges);
      newBuilder.setAdvertisedRoutePriority(this.advertisedRoutePriority);
      newBuilder.setInterfaceName(this.interfaceName);
      newBuilder.setIpAddress(this.ipAddress);
      newBuilder.setName(this.name);
      newBuilder.setPeerAsn(this.peerAsn);
      newBuilder.setPeerIpAddress(this.peerIpAddress);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterBgpPeer{"
        + "advertiseMode="
        + advertiseMode
        + ", "
        + "advertisedGroups="
        + advertisedGroups
        + ", "
        + "advertisedIpRanges="
        + advertisedIpRanges
        + ", "
        + "advertisedRoutePriority="
        + advertisedRoutePriority
        + ", "
        + "interfaceName="
        + interfaceName
        + ", "
        + "ipAddress="
        + ipAddress
        + ", "
        + "name="
        + name
        + ", "
        + "peerAsn="
        + peerAsn
        + ", "
        + "peerIpAddress="
        + peerIpAddress
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterBgpPeer) {
      RouterBgpPeer that = (RouterBgpPeer) o;
      return Objects.equals(this.advertiseMode, that.getAdvertiseMode())
          && Objects.equals(this.advertisedGroups, that.getAdvertisedGroupsList())
          && Objects.equals(this.advertisedIpRanges, that.getAdvertisedIpRangesList())
          && Objects.equals(this.advertisedRoutePriority, that.getAdvertisedRoutePriority())
          && Objects.equals(this.interfaceName, that.getInterfaceName())
          && Objects.equals(this.ipAddress, that.getIpAddress())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerAsn, that.getPeerAsn())
          && Objects.equals(this.peerIpAddress, that.getPeerIpAddress());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        advertiseMode,
        advertisedGroups,
        advertisedIpRanges,
        advertisedRoutePriority,
        interfaceName,
        ipAddress,
        name,
        peerAsn,
        peerIpAddress);
  }
}
