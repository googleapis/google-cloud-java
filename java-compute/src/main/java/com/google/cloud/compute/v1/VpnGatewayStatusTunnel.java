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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Contains some information about a VPN tunnel. */
public final class VpnGatewayStatusTunnel implements ApiMessage {
  private final Integer localGatewayInterface;
  private final Integer peerGatewayInterface;
  private final String tunnelUrl;

  private VpnGatewayStatusTunnel() {
    this.localGatewayInterface = null;
    this.peerGatewayInterface = null;
    this.tunnelUrl = null;
  }

  private VpnGatewayStatusTunnel(
      Integer localGatewayInterface, Integer peerGatewayInterface, String tunnelUrl) {
    this.localGatewayInterface = localGatewayInterface;
    this.peerGatewayInterface = peerGatewayInterface;
    this.tunnelUrl = tunnelUrl;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("localGatewayInterface".equals(fieldName)) {
      return localGatewayInterface;
    }
    if ("peerGatewayInterface".equals(fieldName)) {
      return peerGatewayInterface;
    }
    if ("tunnelUrl".equals(fieldName)) {
      return tunnelUrl;
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

  /** The VPN gateway interface this VPN tunnel is associated with. */
  public Integer getLocalGatewayInterface() {
    return localGatewayInterface;
  }

  /**
   * The peer gateway interface this VPN tunnel is connected to, the peer gateway could either be an
   * external VPN gateway or GCP VPN gateway.
   */
  public Integer getPeerGatewayInterface() {
    return peerGatewayInterface;
  }

  /** URL reference to the VPN tunnel. */
  public String getTunnelUrl() {
    return tunnelUrl;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewayStatusTunnel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewayStatusTunnel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewayStatusTunnel DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewayStatusTunnel();
  }

  public static class Builder {
    private Integer localGatewayInterface;
    private Integer peerGatewayInterface;
    private String tunnelUrl;

    Builder() {}

    public Builder mergeFrom(VpnGatewayStatusTunnel other) {
      if (other == VpnGatewayStatusTunnel.getDefaultInstance()) return this;
      if (other.getLocalGatewayInterface() != null) {
        this.localGatewayInterface = other.localGatewayInterface;
      }
      if (other.getPeerGatewayInterface() != null) {
        this.peerGatewayInterface = other.peerGatewayInterface;
      }
      if (other.getTunnelUrl() != null) {
        this.tunnelUrl = other.tunnelUrl;
      }
      return this;
    }

    Builder(VpnGatewayStatusTunnel source) {
      this.localGatewayInterface = source.localGatewayInterface;
      this.peerGatewayInterface = source.peerGatewayInterface;
      this.tunnelUrl = source.tunnelUrl;
    }

    /** The VPN gateway interface this VPN tunnel is associated with. */
    public Integer getLocalGatewayInterface() {
      return localGatewayInterface;
    }

    /** The VPN gateway interface this VPN tunnel is associated with. */
    public Builder setLocalGatewayInterface(Integer localGatewayInterface) {
      this.localGatewayInterface = localGatewayInterface;
      return this;
    }

    /**
     * The peer gateway interface this VPN tunnel is connected to, the peer gateway could either be
     * an external VPN gateway or GCP VPN gateway.
     */
    public Integer getPeerGatewayInterface() {
      return peerGatewayInterface;
    }

    /**
     * The peer gateway interface this VPN tunnel is connected to, the peer gateway could either be
     * an external VPN gateway or GCP VPN gateway.
     */
    public Builder setPeerGatewayInterface(Integer peerGatewayInterface) {
      this.peerGatewayInterface = peerGatewayInterface;
      return this;
    }

    /** URL reference to the VPN tunnel. */
    public String getTunnelUrl() {
      return tunnelUrl;
    }

    /** URL reference to the VPN tunnel. */
    public Builder setTunnelUrl(String tunnelUrl) {
      this.tunnelUrl = tunnelUrl;
      return this;
    }

    public VpnGatewayStatusTunnel build() {

      return new VpnGatewayStatusTunnel(localGatewayInterface, peerGatewayInterface, tunnelUrl);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setLocalGatewayInterface(this.localGatewayInterface);
      newBuilder.setPeerGatewayInterface(this.peerGatewayInterface);
      newBuilder.setTunnelUrl(this.tunnelUrl);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewayStatusTunnel{"
        + "localGatewayInterface="
        + localGatewayInterface
        + ", "
        + "peerGatewayInterface="
        + peerGatewayInterface
        + ", "
        + "tunnelUrl="
        + tunnelUrl
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewayStatusTunnel) {
      VpnGatewayStatusTunnel that = (VpnGatewayStatusTunnel) o;
      return Objects.equals(this.localGatewayInterface, that.getLocalGatewayInterface())
          && Objects.equals(this.peerGatewayInterface, that.getPeerGatewayInterface())
          && Objects.equals(this.tunnelUrl, that.getTunnelUrl());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(localGatewayInterface, peerGatewayInterface, tunnelUrl);
  }
}
