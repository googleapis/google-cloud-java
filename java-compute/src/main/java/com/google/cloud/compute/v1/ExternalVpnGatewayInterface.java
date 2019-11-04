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
/** The interface for the external VPN gateway. */
public final class ExternalVpnGatewayInterface implements ApiMessage {
  private final Integer id;
  private final String ipAddress;

  private ExternalVpnGatewayInterface() {
    this.id = null;
    this.ipAddress = null;
  }

  private ExternalVpnGatewayInterface(Integer id, String ipAddress) {
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

  /**
   * The numeric ID of this interface. The allowed input values for this id for different redundancy
   * types of external VPN gateway: SINGLE_IP_INTERNALLY_REDUNDANT - 0 TWO_IPS_REDUNDANCY - 0, 1
   * FOUR_IPS_REDUNDANCY - 0, 1, 2, 3
   */
  public Integer getId() {
    return id;
  }

  /**
   * IP address of the interface in the external VPN gateway. Only IPv4 is supported. This IP
   * address can be either from your on-premise gateway or another Cloud provider?s VPN gateway, it
   * cannot be an IP address from Google Compute Engine.
   */
  public String getIpAddress() {
    return ipAddress;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ExternalVpnGatewayInterface prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ExternalVpnGatewayInterface getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ExternalVpnGatewayInterface DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ExternalVpnGatewayInterface();
  }

  public static class Builder {
    private Integer id;
    private String ipAddress;

    Builder() {}

    public Builder mergeFrom(ExternalVpnGatewayInterface other) {
      if (other == ExternalVpnGatewayInterface.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      return this;
    }

    Builder(ExternalVpnGatewayInterface source) {
      this.id = source.id;
      this.ipAddress = source.ipAddress;
    }

    /**
     * The numeric ID of this interface. The allowed input values for this id for different
     * redundancy types of external VPN gateway: SINGLE_IP_INTERNALLY_REDUNDANT - 0
     * TWO_IPS_REDUNDANCY - 0, 1 FOUR_IPS_REDUNDANCY - 0, 1, 2, 3
     */
    public Integer getId() {
      return id;
    }

    /**
     * The numeric ID of this interface. The allowed input values for this id for different
     * redundancy types of external VPN gateway: SINGLE_IP_INTERNALLY_REDUNDANT - 0
     * TWO_IPS_REDUNDANCY - 0, 1 FOUR_IPS_REDUNDANCY - 0, 1, 2, 3
     */
    public Builder setId(Integer id) {
      this.id = id;
      return this;
    }

    /**
     * IP address of the interface in the external VPN gateway. Only IPv4 is supported. This IP
     * address can be either from your on-premise gateway or another Cloud provider?s VPN gateway,
     * it cannot be an IP address from Google Compute Engine.
     */
    public String getIpAddress() {
      return ipAddress;
    }

    /**
     * IP address of the interface in the external VPN gateway. Only IPv4 is supported. This IP
     * address can be either from your on-premise gateway or another Cloud provider?s VPN gateway,
     * it cannot be an IP address from Google Compute Engine.
     */
    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public ExternalVpnGatewayInterface build() {

      return new ExternalVpnGatewayInterface(id, ipAddress);
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
    return "ExternalVpnGatewayInterface{" + "id=" + id + ", " + "ipAddress=" + ipAddress + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExternalVpnGatewayInterface) {
      ExternalVpnGatewayInterface that = (ExternalVpnGatewayInterface) o;
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
