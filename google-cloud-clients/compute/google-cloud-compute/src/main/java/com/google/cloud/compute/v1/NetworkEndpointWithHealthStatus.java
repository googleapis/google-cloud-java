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
public final class NetworkEndpointWithHealthStatus implements ApiMessage {
  private final List<HealthStatusForNetworkEndpoint> healths;
  private final NetworkEndpoint networkEndpoint;

  private NetworkEndpointWithHealthStatus() {
    this.healths = null;
    this.networkEndpoint = null;
  }

  private NetworkEndpointWithHealthStatus(
      List<HealthStatusForNetworkEndpoint> healths, NetworkEndpoint networkEndpoint) {
    this.healths = healths;
    this.networkEndpoint = networkEndpoint;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("healths".equals(fieldName)) {
      return healths;
    }
    if ("networkEndpoint".equals(fieldName)) {
      return networkEndpoint;
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

  /** [Output only] The health status of network endpoint; */
  public List<HealthStatusForNetworkEndpoint> getHealthsList() {
    return healths;
  }

  /** [Output only] The network endpoint; */
  public NetworkEndpoint getNetworkEndpoint() {
    return networkEndpoint;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointWithHealthStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointWithHealthStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointWithHealthStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointWithHealthStatus();
  }

  public static class Builder {
    private List<HealthStatusForNetworkEndpoint> healths;
    private NetworkEndpoint networkEndpoint;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointWithHealthStatus other) {
      if (other == NetworkEndpointWithHealthStatus.getDefaultInstance()) return this;
      if (other.getHealthsList() != null) {
        this.healths = other.healths;
      }
      if (other.getNetworkEndpoint() != null) {
        this.networkEndpoint = other.networkEndpoint;
      }
      return this;
    }

    Builder(NetworkEndpointWithHealthStatus source) {
      this.healths = source.healths;
      this.networkEndpoint = source.networkEndpoint;
    }

    /** [Output only] The health status of network endpoint; */
    public List<HealthStatusForNetworkEndpoint> getHealthsList() {
      return healths;
    }

    /** [Output only] The health status of network endpoint; */
    public Builder addAllHealths(List<HealthStatusForNetworkEndpoint> healths) {
      if (this.healths == null) {
        this.healths = new LinkedList<>();
      }
      this.healths.addAll(healths);
      return this;
    }

    /** [Output only] The health status of network endpoint; */
    public Builder addHealths(HealthStatusForNetworkEndpoint healths) {
      if (this.healths == null) {
        this.healths = new LinkedList<>();
      }
      this.healths.add(healths);
      return this;
    }

    /** [Output only] The network endpoint; */
    public NetworkEndpoint getNetworkEndpoint() {
      return networkEndpoint;
    }

    /** [Output only] The network endpoint; */
    public Builder setNetworkEndpoint(NetworkEndpoint networkEndpoint) {
      this.networkEndpoint = networkEndpoint;
      return this;
    }

    public NetworkEndpointWithHealthStatus build() {

      return new NetworkEndpointWithHealthStatus(healths, networkEndpoint);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllHealths(this.healths);
      newBuilder.setNetworkEndpoint(this.networkEndpoint);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointWithHealthStatus{"
        + "healths="
        + healths
        + ", "
        + "networkEndpoint="
        + networkEndpoint
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointWithHealthStatus) {
      NetworkEndpointWithHealthStatus that = (NetworkEndpointWithHealthStatus) o;
      return Objects.equals(this.healths, that.getHealthsList())
          && Objects.equals(this.networkEndpoint, that.getNetworkEndpoint());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healths, networkEndpoint);
  }
}
