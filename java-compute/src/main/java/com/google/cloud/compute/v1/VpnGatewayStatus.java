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
public final class VpnGatewayStatus implements ApiMessage {
  private final List<VpnGatewayStatusVpnConnection> vpnConnections;

  private VpnGatewayStatus() {
    this.vpnConnections = null;
  }

  private VpnGatewayStatus(List<VpnGatewayStatusVpnConnection> vpnConnections) {
    this.vpnConnections = vpnConnections;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("vpnConnections".equals(fieldName)) {
      return vpnConnections;
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

  /** List of VPN connection for this VpnGateway. */
  public List<VpnGatewayStatusVpnConnection> getVpnConnectionsList() {
    return vpnConnections;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewayStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewayStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewayStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewayStatus();
  }

  public static class Builder {
    private List<VpnGatewayStatusVpnConnection> vpnConnections;

    Builder() {}

    public Builder mergeFrom(VpnGatewayStatus other) {
      if (other == VpnGatewayStatus.getDefaultInstance()) return this;
      if (other.getVpnConnectionsList() != null) {
        this.vpnConnections = other.vpnConnections;
      }
      return this;
    }

    Builder(VpnGatewayStatus source) {
      this.vpnConnections = source.vpnConnections;
    }

    /** List of VPN connection for this VpnGateway. */
    public List<VpnGatewayStatusVpnConnection> getVpnConnectionsList() {
      return vpnConnections;
    }

    /** List of VPN connection for this VpnGateway. */
    public Builder addAllVpnConnections(List<VpnGatewayStatusVpnConnection> vpnConnections) {
      if (this.vpnConnections == null) {
        this.vpnConnections = new LinkedList<>();
      }
      this.vpnConnections.addAll(vpnConnections);
      return this;
    }

    /** List of VPN connection for this VpnGateway. */
    public Builder addVpnConnections(VpnGatewayStatusVpnConnection vpnConnections) {
      if (this.vpnConnections == null) {
        this.vpnConnections = new LinkedList<>();
      }
      this.vpnConnections.add(vpnConnections);
      return this;
    }

    public VpnGatewayStatus build() {
      return new VpnGatewayStatus(vpnConnections);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllVpnConnections(this.vpnConnections);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewayStatus{" + "vpnConnections=" + vpnConnections + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewayStatus) {
      VpnGatewayStatus that = (VpnGatewayStatus) o;
      return Objects.equals(this.vpnConnections, that.getVpnConnectionsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(vpnConnections);
  }
}
