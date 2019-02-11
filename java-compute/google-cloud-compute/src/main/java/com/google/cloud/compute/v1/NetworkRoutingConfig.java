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
/**
 * A routing configuration attached to a network resource. The message includes the list of routers
 * associated with the network, and a flag indicating the type of routing behavior to enforce
 * network-wide.
 */
public final class NetworkRoutingConfig implements ApiMessage {
  private final String routingMode;

  private NetworkRoutingConfig() {
    this.routingMode = null;
  }

  private NetworkRoutingConfig(String routingMode) {
    this.routingMode = routingMode;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("routingMode".equals(fieldName)) {
      return routingMode;
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
   * The network-wide routing mode to use. If set to REGIONAL, this network's cloud routers will
   * only advertise routes with subnets of this network in the same region as the router. If set to
   * GLOBAL, this network's cloud routers will advertise routes with all subnets of this network,
   * across regions.
   */
  public String getRoutingMode() {
    return routingMode;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkRoutingConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkRoutingConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkRoutingConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkRoutingConfig();
  }

  public static class Builder {
    private String routingMode;

    Builder() {}

    public Builder mergeFrom(NetworkRoutingConfig other) {
      if (other == NetworkRoutingConfig.getDefaultInstance()) return this;
      if (other.getRoutingMode() != null) {
        this.routingMode = other.routingMode;
      }
      return this;
    }

    Builder(NetworkRoutingConfig source) {
      this.routingMode = source.routingMode;
    }

    /**
     * The network-wide routing mode to use. If set to REGIONAL, this network's cloud routers will
     * only advertise routes with subnets of this network in the same region as the router. If set
     * to GLOBAL, this network's cloud routers will advertise routes with all subnets of this
     * network, across regions.
     */
    public String getRoutingMode() {
      return routingMode;
    }

    /**
     * The network-wide routing mode to use. If set to REGIONAL, this network's cloud routers will
     * only advertise routes with subnets of this network in the same region as the router. If set
     * to GLOBAL, this network's cloud routers will advertise routes with all subnets of this
     * network, across regions.
     */
    public Builder setRoutingMode(String routingMode) {
      this.routingMode = routingMode;
      return this;
    }

    public NetworkRoutingConfig build() {
      return new NetworkRoutingConfig(routingMode);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setRoutingMode(this.routingMode);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkRoutingConfig{" + "routingMode=" + routingMode + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkRoutingConfig) {
      NetworkRoutingConfig that = (NetworkRoutingConfig) o;
      return Objects.equals(this.routingMode, that.getRoutingMode());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(routingMode);
  }
}
