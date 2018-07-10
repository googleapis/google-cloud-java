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
public final class RouterStatusBgpPeerStatus implements ApiMessage {
  private final List<Route> advertisedRoutes;
  private final String ipAddress;
  private final String linkedVpnTunnel;
  private final String name;
  private final Integer numLearnedRoutes;
  private final String peerIpAddress;
  private final String state;
  private final String status;
  private final String uptime;
  private final String uptimeSeconds;

  private RouterStatusBgpPeerStatus() {
    this.advertisedRoutes = null;
    this.ipAddress = null;
    this.linkedVpnTunnel = null;
    this.name = null;
    this.numLearnedRoutes = null;
    this.peerIpAddress = null;
    this.state = null;
    this.status = null;
    this.uptime = null;
    this.uptimeSeconds = null;
  }

  private RouterStatusBgpPeerStatus(
      List<Route> advertisedRoutes,
      String ipAddress,
      String linkedVpnTunnel,
      String name,
      Integer numLearnedRoutes,
      String peerIpAddress,
      String state,
      String status,
      String uptime,
      String uptimeSeconds) {
    this.advertisedRoutes = advertisedRoutes;
    this.ipAddress = ipAddress;
    this.linkedVpnTunnel = linkedVpnTunnel;
    this.name = name;
    this.numLearnedRoutes = numLearnedRoutes;
    this.peerIpAddress = peerIpAddress;
    this.state = state;
    this.status = status;
    this.uptime = uptime;
    this.uptimeSeconds = uptimeSeconds;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("advertisedRoutes")) {
      return advertisedRoutes;
    }
    if (fieldName.equals("ipAddress")) {
      return ipAddress;
    }
    if (fieldName.equals("linkedVpnTunnel")) {
      return linkedVpnTunnel;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("numLearnedRoutes")) {
      return numLearnedRoutes;
    }
    if (fieldName.equals("peerIpAddress")) {
      return peerIpAddress;
    }
    if (fieldName.equals("state")) {
      return state;
    }
    if (fieldName.equals("status")) {
      return status;
    }
    if (fieldName.equals("uptime")) {
      return uptime;
    }
    if (fieldName.equals("uptimeSeconds")) {
      return uptimeSeconds;
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

  public List<Route> getAdvertisedRoutesList() {
    return advertisedRoutes;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public String getLinkedVpnTunnel() {
    return linkedVpnTunnel;
  }

  public String getName() {
    return name;
  }

  public Integer getNumLearnedRoutes() {
    return numLearnedRoutes;
  }

  public String getPeerIpAddress() {
    return peerIpAddress;
  }

  public String getState() {
    return state;
  }

  public String getStatus() {
    return status;
  }

  public String getUptime() {
    return uptime;
  }

  public String getUptimeSeconds() {
    return uptimeSeconds;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterStatusBgpPeerStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterStatusBgpPeerStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterStatusBgpPeerStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterStatusBgpPeerStatus();
  }

  public static class Builder {
    private List<Route> advertisedRoutes;
    private String ipAddress;
    private String linkedVpnTunnel;
    private String name;
    private Integer numLearnedRoutes;
    private String peerIpAddress;
    private String state;
    private String status;
    private String uptime;
    private String uptimeSeconds;

    Builder() {}

    public Builder mergeFrom(RouterStatusBgpPeerStatus other) {
      if (other == RouterStatusBgpPeerStatus.getDefaultInstance()) return this;
      if (other.getAdvertisedRoutesList() != null) {
        this.advertisedRoutes = other.advertisedRoutes;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      if (other.getLinkedVpnTunnel() != null) {
        this.linkedVpnTunnel = other.linkedVpnTunnel;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNumLearnedRoutes() != null) {
        this.numLearnedRoutes = other.numLearnedRoutes;
      }
      if (other.getPeerIpAddress() != null) {
        this.peerIpAddress = other.peerIpAddress;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getUptime() != null) {
        this.uptime = other.uptime;
      }
      if (other.getUptimeSeconds() != null) {
        this.uptimeSeconds = other.uptimeSeconds;
      }
      return this;
    }

    Builder(RouterStatusBgpPeerStatus source) {
      this.advertisedRoutes = source.advertisedRoutes;
      this.ipAddress = source.ipAddress;
      this.linkedVpnTunnel = source.linkedVpnTunnel;
      this.name = source.name;
      this.numLearnedRoutes = source.numLearnedRoutes;
      this.peerIpAddress = source.peerIpAddress;
      this.state = source.state;
      this.status = source.status;
      this.uptime = source.uptime;
      this.uptimeSeconds = source.uptimeSeconds;
    }

    public List<Route> getAdvertisedRoutesList() {
      return advertisedRoutes;
    }

    public Builder addAllAdvertisedRoutes(List<Route> advertisedRoutes) {
      if (this.advertisedRoutes == null) {
        this.advertisedRoutes = new LinkedList<>();
      }
      this.advertisedRoutes.addAll(advertisedRoutes);
      return this;
    }

    public Builder addAdvertisedRoutes(Route advertisedRoutes) {
      if (this.advertisedRoutes == null) {
        this.advertisedRoutes = new LinkedList<>();
      }
      this.advertisedRoutes.add(advertisedRoutes);
      return this;
    }

    public String getIpAddress() {
      return ipAddress;
    }

    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public String getLinkedVpnTunnel() {
      return linkedVpnTunnel;
    }

    public Builder setLinkedVpnTunnel(String linkedVpnTunnel) {
      this.linkedVpnTunnel = linkedVpnTunnel;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getNumLearnedRoutes() {
      return numLearnedRoutes;
    }

    public Builder setNumLearnedRoutes(Integer numLearnedRoutes) {
      this.numLearnedRoutes = numLearnedRoutes;
      return this;
    }

    public String getPeerIpAddress() {
      return peerIpAddress;
    }

    public Builder setPeerIpAddress(String peerIpAddress) {
      this.peerIpAddress = peerIpAddress;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getUptime() {
      return uptime;
    }

    public Builder setUptime(String uptime) {
      this.uptime = uptime;
      return this;
    }

    public String getUptimeSeconds() {
      return uptimeSeconds;
    }

    public Builder setUptimeSeconds(String uptimeSeconds) {
      this.uptimeSeconds = uptimeSeconds;
      return this;
    }

    public RouterStatusBgpPeerStatus build() {

      return new RouterStatusBgpPeerStatus(
          advertisedRoutes,
          ipAddress,
          linkedVpnTunnel,
          name,
          numLearnedRoutes,
          peerIpAddress,
          state,
          status,
          uptime,
          uptimeSeconds);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAdvertisedRoutes(this.advertisedRoutes);
      newBuilder.setIpAddress(this.ipAddress);
      newBuilder.setLinkedVpnTunnel(this.linkedVpnTunnel);
      newBuilder.setName(this.name);
      newBuilder.setNumLearnedRoutes(this.numLearnedRoutes);
      newBuilder.setPeerIpAddress(this.peerIpAddress);
      newBuilder.setState(this.state);
      newBuilder.setStatus(this.status);
      newBuilder.setUptime(this.uptime);
      newBuilder.setUptimeSeconds(this.uptimeSeconds);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterStatusBgpPeerStatus{"
        + "advertisedRoutes="
        + advertisedRoutes
        + ", "
        + "ipAddress="
        + ipAddress
        + ", "
        + "linkedVpnTunnel="
        + linkedVpnTunnel
        + ", "
        + "name="
        + name
        + ", "
        + "numLearnedRoutes="
        + numLearnedRoutes
        + ", "
        + "peerIpAddress="
        + peerIpAddress
        + ", "
        + "state="
        + state
        + ", "
        + "status="
        + status
        + ", "
        + "uptime="
        + uptime
        + ", "
        + "uptimeSeconds="
        + uptimeSeconds
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterStatusBgpPeerStatus) {
      RouterStatusBgpPeerStatus that = (RouterStatusBgpPeerStatus) o;
      return Objects.equals(this.advertisedRoutes, that.getAdvertisedRoutesList())
          && Objects.equals(this.ipAddress, that.getIpAddress())
          && Objects.equals(this.linkedVpnTunnel, that.getLinkedVpnTunnel())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.numLearnedRoutes, that.getNumLearnedRoutes())
          && Objects.equals(this.peerIpAddress, that.getPeerIpAddress())
          && Objects.equals(this.state, that.getState())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.uptime, that.getUptime())
          && Objects.equals(this.uptimeSeconds, that.getUptimeSeconds());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        advertisedRoutes,
        ipAddress,
        linkedVpnTunnel,
        name,
        numLearnedRoutes,
        peerIpAddress,
        state,
        status,
        uptime,
        uptimeSeconds);
  }
}
