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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class RouterBgpPeer implements ApiMessage {
  private final Integer advertisedRoutePriority;
  private final String interfaceName;
  private final String ipAddress;
  private final String name;
  private final Integer peerAsn;
  private final String peerIpAddress;

  private RouterBgpPeer() {
    this.advertisedRoutePriority = null;
    this.interfaceName = null;
    this.ipAddress = null;
    this.name = null;
    this.peerAsn = null;
    this.peerIpAddress = null;
  }


  private RouterBgpPeer(
      Integer advertisedRoutePriority,
      String interfaceName,
      String ipAddress,
      String name,
      Integer peerAsn,
      String peerIpAddress
      ) {
    this.advertisedRoutePriority = advertisedRoutePriority;
    this.interfaceName = interfaceName;
    this.ipAddress = ipAddress;
    this.name = name;
    this.peerAsn = peerAsn;
    this.peerIpAddress = peerIpAddress;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("advertisedRoutePriority") && advertisedRoutePriority != null) {
      fieldMap.put("advertisedRoutePriority", Collections.singletonList(String.valueOf(advertisedRoutePriority)));
    }
    if (fieldNames.contains("interfaceName") && interfaceName != null) {
      fieldMap.put("interfaceName", Collections.singletonList(String.valueOf(interfaceName)));
    }
    if (fieldNames.contains("ipAddress") && ipAddress != null) {
      fieldMap.put("ipAddress", Collections.singletonList(String.valueOf(ipAddress)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("peerAsn") && peerAsn != null) {
      fieldMap.put("peerAsn", Collections.singletonList(String.valueOf(peerAsn)));
    }
    if (fieldNames.contains("peerIpAddress") && peerIpAddress != null) {
      fieldMap.put("peerIpAddress", Collections.singletonList(String.valueOf(peerIpAddress)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("advertisedRoutePriority")) {
      return String.valueOf(advertisedRoutePriority);
    }
    if (fieldName.equals("interfaceName")) {
      return String.valueOf(interfaceName);
    }
    if (fieldName.equals("ipAddress")) {
      return String.valueOf(ipAddress);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("peerAsn")) {
      return String.valueOf(peerAsn);
    }
    if (fieldName.equals("peerIpAddress")) {
      return String.valueOf(peerIpAddress);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterBgpPeer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final RouterBgpPeer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RouterBgpPeer();
  }

  public static class Builder {
    private Integer advertisedRoutePriority;
    private String interfaceName;
    private String ipAddress;
    private String name;
    private Integer peerAsn;
    private String peerIpAddress;

    Builder() {}

    public Builder mergeFrom(RouterBgpPeer other) {
      if (other == RouterBgpPeer.getDefaultInstance()) return this;
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
      this.advertisedRoutePriority = source.advertisedRoutePriority;
      this.interfaceName = source.interfaceName;
      this.ipAddress = source.ipAddress;
      this.name = source.name;
      this.peerAsn = source.peerAsn;
      this.peerIpAddress = source.peerIpAddress;
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
        advertisedRoutePriority,
        interfaceName,
        ipAddress,
        name,
        peerAsn,
        peerIpAddress
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
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
        + "advertisedRoutePriority=" + advertisedRoutePriority + ", "
        + "interfaceName=" + interfaceName + ", "
        + "ipAddress=" + ipAddress + ", "
        + "name=" + name + ", "
        + "peerAsn=" + peerAsn + ", "
        + "peerIpAddress=" + peerIpAddress
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterBgpPeer) {
      RouterBgpPeer that = (RouterBgpPeer) o;
      return
          Objects.equals(this.advertisedRoutePriority, that.getAdvertisedRoutePriority()) &&
          Objects.equals(this.interfaceName, that.getInterfaceName()) &&
          Objects.equals(this.ipAddress, that.getIpAddress()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.peerAsn, that.getPeerAsn()) &&
          Objects.equals(this.peerIpAddress, that.getPeerIpAddress())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      advertisedRoutePriority,
      interfaceName,
      ipAddress,
      name,
      peerAsn,
      peerIpAddress
    );
  }
}
