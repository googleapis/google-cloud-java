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
public final class NetworkEndpointGroupsDetachEndpointsRequest implements ApiMessage {
  private final List<NetworkEndpoint> networkEndpoints;

  private NetworkEndpointGroupsDetachEndpointsRequest() {
    this.networkEndpoints = null;
  }

  private NetworkEndpointGroupsDetachEndpointsRequest(List<NetworkEndpoint> networkEndpoints) {
    this.networkEndpoints = networkEndpoints;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("networkEndpoints".equals(fieldName)) {
      return networkEndpoints;
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

  /** The list of network endpoints to be detached. */
  public List<NetworkEndpoint> getNetworkEndpointsList() {
    return networkEndpoints;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupsDetachEndpointsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupsDetachEndpointsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupsDetachEndpointsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupsDetachEndpointsRequest();
  }

  public static class Builder {
    private List<NetworkEndpoint> networkEndpoints;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupsDetachEndpointsRequest other) {
      if (other == NetworkEndpointGroupsDetachEndpointsRequest.getDefaultInstance()) return this;
      if (other.getNetworkEndpointsList() != null) {
        this.networkEndpoints = other.networkEndpoints;
      }
      return this;
    }

    Builder(NetworkEndpointGroupsDetachEndpointsRequest source) {
      this.networkEndpoints = source.networkEndpoints;
    }

    /** The list of network endpoints to be detached. */
    public List<NetworkEndpoint> getNetworkEndpointsList() {
      return networkEndpoints;
    }

    /** The list of network endpoints to be detached. */
    public Builder addAllNetworkEndpoints(List<NetworkEndpoint> networkEndpoints) {
      if (this.networkEndpoints == null) {
        this.networkEndpoints = new LinkedList<>();
      }
      this.networkEndpoints.addAll(networkEndpoints);
      return this;
    }

    /** The list of network endpoints to be detached. */
    public Builder addNetworkEndpoints(NetworkEndpoint networkEndpoints) {
      if (this.networkEndpoints == null) {
        this.networkEndpoints = new LinkedList<>();
      }
      this.networkEndpoints.add(networkEndpoints);
      return this;
    }

    public NetworkEndpointGroupsDetachEndpointsRequest build() {
      return new NetworkEndpointGroupsDetachEndpointsRequest(networkEndpoints);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNetworkEndpoints(this.networkEndpoints);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupsDetachEndpointsRequest{"
        + "networkEndpoints="
        + networkEndpoints
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroupsDetachEndpointsRequest) {
      NetworkEndpointGroupsDetachEndpointsRequest that =
          (NetworkEndpointGroupsDetachEndpointsRequest) o;
      return Objects.equals(this.networkEndpoints, that.getNetworkEndpointsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkEndpoints);
  }
}
