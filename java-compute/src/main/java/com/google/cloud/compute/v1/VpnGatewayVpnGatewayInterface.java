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
/** A VPN gateway interface. */
public final class VpnGatewayVpnGatewayInterface implements ApiMessage {
  private final Integer id;
  private final String ipAddress;

  private VpnGatewayVpnGatewayInterface() {
    this.id = null;
    this.ipAddress = null;
  }

  private VpnGatewayVpnGatewayInterface(Integer id, String ipAddress) {
    this.id = id;
    this.ipAddress = ipAddress;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("ipAddress".equals(fieldName)) {
      return ipAddress;
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

  /** The numeric ID of this VPN gateway interface. */
  public Integer getId() {
    return id;
  }

  /** The external IP address for this VPN gateway interface. */
  public String getIpAddress() {
    return ipAddress;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewayVpnGatewayInterface prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewayVpnGatewayInterface getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewayVpnGatewayInterface DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewayVpnGatewayInterface();
  }

  public static class Builder {
    private Integer id;
    private String ipAddress;

    Builder() {}

    public Builder mergeFrom(VpnGatewayVpnGatewayInterface other) {
      if (other == VpnGatewayVpnGatewayInterface.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      return this;
    }

    Builder(VpnGatewayVpnGatewayInterface source) {
      this.id = source.id;
      this.ipAddress = source.ipAddress;
    }

    /** The numeric ID of this VPN gateway interface. */
    public Integer getId() {
      return id;
    }

    /** The numeric ID of this VPN gateway interface. */
    public Builder setId(Integer id) {
      this.id = id;
      return this;
    }

    /** The external IP address for this VPN gateway interface. */
    public String getIpAddress() {
      return ipAddress;
    }

    /** The external IP address for this VPN gateway interface. */
    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public VpnGatewayVpnGatewayInterface build() {

      return new VpnGatewayVpnGatewayInterface(id, ipAddress);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setId(this.id);
      newBuilder.setIpAddress(this.ipAddress);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewayVpnGatewayInterface{" + "id=" + id + ", " + "ipAddress=" + ipAddress + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewayVpnGatewayInterface) {
      VpnGatewayVpnGatewayInterface that = (VpnGatewayVpnGatewayInterface) o;
      return Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipAddress, that.getIpAddress());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ipAddress);
  }
}
