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
/**
 * A VPN connection contains all VPN tunnels connected from this VpnGateway to the same peer
 * gateway. The peer gateway could either be a external VPN gateway or GCP VPN gateway.
 */
public final class VpnGatewayStatusVpnConnection implements ApiMessage {
  private final String peerExternalGateway;
  private final String peerGcpGateway;
  private final VpnGatewayStatusHighAvailabilityRequirementState state;
  private final List<VpnGatewayStatusTunnel> tunnels;

  private VpnGatewayStatusVpnConnection() {
    this.peerExternalGateway = null;
    this.peerGcpGateway = null;
    this.state = null;
    this.tunnels = null;
  }

  private VpnGatewayStatusVpnConnection(
      String peerExternalGateway,
      String peerGcpGateway,
      VpnGatewayStatusHighAvailabilityRequirementState state,
      List<VpnGatewayStatusTunnel> tunnels) {
    this.peerExternalGateway = peerExternalGateway;
    this.peerGcpGateway = peerGcpGateway;
    this.state = state;
    this.tunnels = tunnels;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("peerExternalGateway".equals(fieldName)) {
      return peerExternalGateway;
    }
    if ("peerGcpGateway".equals(fieldName)) {
      return peerGcpGateway;
    }
    if ("state".equals(fieldName)) {
      return state;
    }
    if ("tunnels".equals(fieldName)) {
      return tunnels;
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

  /**
   * URL reference to the peer external VPN gateways to which the VPN tunnels in this VPN connection
   * are connected. This field is mutually exclusive with peer_gcp_gateway.
   */
  public String getPeerExternalGateway() {
    return peerExternalGateway;
  }

  /**
   * URL reference to the peer side VPN gateways to which the VPN tunnels in this VPN connection are
   * connected. This field is mutually exclusive with peer_gcp_gateway.
   */
  public String getPeerGcpGateway() {
    return peerGcpGateway;
  }

  /** HighAvailabilityRequirementState for the VPN connection. */
  public VpnGatewayStatusHighAvailabilityRequirementState getState() {
    return state;
  }

  /** List of VPN tunnels that are in this VPN connection. */
  public List<VpnGatewayStatusTunnel> getTunnelsList() {
    return tunnels;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewayStatusVpnConnection prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewayStatusVpnConnection getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewayStatusVpnConnection DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewayStatusVpnConnection();
  }

  public static class Builder {
    private String peerExternalGateway;
    private String peerGcpGateway;
    private VpnGatewayStatusHighAvailabilityRequirementState state;
    private List<VpnGatewayStatusTunnel> tunnels;

    Builder() {}

    public Builder mergeFrom(VpnGatewayStatusVpnConnection other) {
      if (other == VpnGatewayStatusVpnConnection.getDefaultInstance()) return this;
      if (other.getPeerExternalGateway() != null) {
        this.peerExternalGateway = other.peerExternalGateway;
      }
      if (other.getPeerGcpGateway() != null) {
        this.peerGcpGateway = other.peerGcpGateway;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getTunnelsList() != null) {
        this.tunnels = other.tunnels;
      }
      return this;
    }

    Builder(VpnGatewayStatusVpnConnection source) {
      this.peerExternalGateway = source.peerExternalGateway;
      this.peerGcpGateway = source.peerGcpGateway;
      this.state = source.state;
      this.tunnels = source.tunnels;
    }

    /**
     * URL reference to the peer external VPN gateways to which the VPN tunnels in this VPN
     * connection are connected. This field is mutually exclusive with peer_gcp_gateway.
     */
    public String getPeerExternalGateway() {
      return peerExternalGateway;
    }

    /**
     * URL reference to the peer external VPN gateways to which the VPN tunnels in this VPN
     * connection are connected. This field is mutually exclusive with peer_gcp_gateway.
     */
    public Builder setPeerExternalGateway(String peerExternalGateway) {
      this.peerExternalGateway = peerExternalGateway;
      return this;
    }

    /**
     * URL reference to the peer side VPN gateways to which the VPN tunnels in this VPN connection
     * are connected. This field is mutually exclusive with peer_gcp_gateway.
     */
    public String getPeerGcpGateway() {
      return peerGcpGateway;
    }

    /**
     * URL reference to the peer side VPN gateways to which the VPN tunnels in this VPN connection
     * are connected. This field is mutually exclusive with peer_gcp_gateway.
     */
    public Builder setPeerGcpGateway(String peerGcpGateway) {
      this.peerGcpGateway = peerGcpGateway;
      return this;
    }

    /** HighAvailabilityRequirementState for the VPN connection. */
    public VpnGatewayStatusHighAvailabilityRequirementState getState() {
      return state;
    }

    /** HighAvailabilityRequirementState for the VPN connection. */
    public Builder setState(VpnGatewayStatusHighAvailabilityRequirementState state) {
      this.state = state;
      return this;
    }

    /** List of VPN tunnels that are in this VPN connection. */
    public List<VpnGatewayStatusTunnel> getTunnelsList() {
      return tunnels;
    }

    /** List of VPN tunnels that are in this VPN connection. */
    public Builder addAllTunnels(List<VpnGatewayStatusTunnel> tunnels) {
      if (this.tunnels == null) {
        this.tunnels = new LinkedList<>();
      }
      this.tunnels.addAll(tunnels);
      return this;
    }

    /** List of VPN tunnels that are in this VPN connection. */
    public Builder addTunnels(VpnGatewayStatusTunnel tunnels) {
      if (this.tunnels == null) {
        this.tunnels = new LinkedList<>();
      }
      this.tunnels.add(tunnels);
      return this;
    }

    public VpnGatewayStatusVpnConnection build() {

      return new VpnGatewayStatusVpnConnection(peerExternalGateway, peerGcpGateway, state, tunnels);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPeerExternalGateway(this.peerExternalGateway);
      newBuilder.setPeerGcpGateway(this.peerGcpGateway);
      newBuilder.setState(this.state);
      newBuilder.addAllTunnels(this.tunnels);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewayStatusVpnConnection{"
        + "peerExternalGateway="
        + peerExternalGateway
        + ", "
        + "peerGcpGateway="
        + peerGcpGateway
        + ", "
        + "state="
        + state
        + ", "
        + "tunnels="
        + tunnels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewayStatusVpnConnection) {
      VpnGatewayStatusVpnConnection that = (VpnGatewayStatusVpnConnection) o;
      return Objects.equals(this.peerExternalGateway, that.getPeerExternalGateway())
          && Objects.equals(this.peerGcpGateway, that.getPeerGcpGateway())
          && Objects.equals(this.state, that.getState())
          && Objects.equals(this.tunnels, that.getTunnelsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(peerExternalGateway, peerGcpGateway, state, tunnels);
  }
}
