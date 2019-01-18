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
public final class VpnTunnelsScopedList implements ApiMessage {
  private final List<VpnTunnel> vpnTunnels;
  private final Warning warning;

  private VpnTunnelsScopedList() {
    this.vpnTunnels = null;
    this.warning = null;
  }

  private VpnTunnelsScopedList(List<VpnTunnel> vpnTunnels, Warning warning) {
    this.vpnTunnels = vpnTunnels;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("vpnTunnels".equals(fieldName)) {
      return vpnTunnels;
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<VpnTunnel> getVpnTunnelsList() {
    return vpnTunnels;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnTunnelsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnTunnelsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnTunnelsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnTunnelsScopedList();
  }

  public static class Builder {
    private List<VpnTunnel> vpnTunnels;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(VpnTunnelsScopedList other) {
      if (other == VpnTunnelsScopedList.getDefaultInstance()) return this;
      if (other.getVpnTunnelsList() != null) {
        this.vpnTunnels = other.vpnTunnels;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(VpnTunnelsScopedList source) {
      this.vpnTunnels = source.vpnTunnels;
      this.warning = source.warning;
    }

    public List<VpnTunnel> getVpnTunnelsList() {
      return vpnTunnels;
    }

    public Builder addAllVpnTunnels(List<VpnTunnel> vpnTunnels) {
      if (this.vpnTunnels == null) {
        this.vpnTunnels = new LinkedList<>();
      }
      this.vpnTunnels.addAll(vpnTunnels);
      return this;
    }

    public Builder addVpnTunnels(VpnTunnel vpnTunnels) {
      if (this.vpnTunnels == null) {
        this.vpnTunnels = new LinkedList<>();
      }
      this.vpnTunnels.add(vpnTunnels);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public VpnTunnelsScopedList build() {

      return new VpnTunnelsScopedList(vpnTunnels, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllVpnTunnels(this.vpnTunnels);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnTunnelsScopedList{" + "vpnTunnels=" + vpnTunnels + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnTunnelsScopedList) {
      VpnTunnelsScopedList that = (VpnTunnelsScopedList) o;
      return Objects.equals(this.vpnTunnels, that.getVpnTunnelsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(vpnTunnels, warning);
  }
}
