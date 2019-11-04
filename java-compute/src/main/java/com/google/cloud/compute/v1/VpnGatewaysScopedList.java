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
public final class VpnGatewaysScopedList implements ApiMessage {
  private final List<VpnGateway> vpnGateways;
  private final Warning warning;

  private VpnGatewaysScopedList() {
    this.vpnGateways = null;
    this.warning = null;
  }

  private VpnGatewaysScopedList(List<VpnGateway> vpnGateways, Warning warning) {
    this.vpnGateways = vpnGateways;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("vpnGateways".equals(fieldName)) {
      return vpnGateways;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** [Output Only] A list of VPN gateways contained in this scope. */
  public List<VpnGateway> getVpnGatewaysList() {
    return vpnGateways;
  }

  /**
   * [Output Only] Informational warning which replaces the list of addresses when the list is
   * empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewaysScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewaysScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewaysScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewaysScopedList();
  }

  public static class Builder {
    private List<VpnGateway> vpnGateways;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(VpnGatewaysScopedList other) {
      if (other == VpnGatewaysScopedList.getDefaultInstance()) return this;
      if (other.getVpnGatewaysList() != null) {
        this.vpnGateways = other.vpnGateways;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(VpnGatewaysScopedList source) {
      this.vpnGateways = source.vpnGateways;
      this.warning = source.warning;
    }

    /** [Output Only] A list of VPN gateways contained in this scope. */
    public List<VpnGateway> getVpnGatewaysList() {
      return vpnGateways;
    }

    /** [Output Only] A list of VPN gateways contained in this scope. */
    public Builder addAllVpnGateways(List<VpnGateway> vpnGateways) {
      if (this.vpnGateways == null) {
        this.vpnGateways = new LinkedList<>();
      }
      this.vpnGateways.addAll(vpnGateways);
      return this;
    }

    /** [Output Only] A list of VPN gateways contained in this scope. */
    public Builder addVpnGateways(VpnGateway vpnGateways) {
      if (this.vpnGateways == null) {
        this.vpnGateways = new LinkedList<>();
      }
      this.vpnGateways.add(vpnGateways);
      return this;
    }

    /**
     * [Output Only] Informational warning which replaces the list of addresses when the list is
     * empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] Informational warning which replaces the list of addresses when the list is
     * empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public VpnGatewaysScopedList build() {

      return new VpnGatewaysScopedList(vpnGateways, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllVpnGateways(this.vpnGateways);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewaysScopedList{"
        + "vpnGateways="
        + vpnGateways
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewaysScopedList) {
      VpnGatewaysScopedList that = (VpnGatewaysScopedList) o;
      return Objects.equals(this.vpnGateways, that.getVpnGatewaysList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(vpnGateways, warning);
  }
}
