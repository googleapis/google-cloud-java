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
public final class NetworksUpdatePeeringRequest implements ApiMessage {
  private final NetworkPeering networkPeering;

  private NetworksUpdatePeeringRequest() {
    this.networkPeering = null;
  }

  private NetworksUpdatePeeringRequest(NetworkPeering networkPeering) {
    this.networkPeering = networkPeering;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("networkPeering".equals(fieldName)) {
      return networkPeering;
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

  public NetworkPeering getNetworkPeering() {
    return networkPeering;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworksUpdatePeeringRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworksUpdatePeeringRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworksUpdatePeeringRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworksUpdatePeeringRequest();
  }

  public static class Builder {
    private NetworkPeering networkPeering;

    Builder() {}

    public Builder mergeFrom(NetworksUpdatePeeringRequest other) {
      if (other == NetworksUpdatePeeringRequest.getDefaultInstance()) return this;
      if (other.getNetworkPeering() != null) {
        this.networkPeering = other.networkPeering;
      }
      return this;
    }

    Builder(NetworksUpdatePeeringRequest source) {
      this.networkPeering = source.networkPeering;
    }

    public NetworkPeering getNetworkPeering() {
      return networkPeering;
    }

    public Builder setNetworkPeering(NetworkPeering networkPeering) {
      this.networkPeering = networkPeering;
      return this;
    }

    public NetworksUpdatePeeringRequest build() {
      return new NetworksUpdatePeeringRequest(networkPeering);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setNetworkPeering(this.networkPeering);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworksUpdatePeeringRequest{" + "networkPeering=" + networkPeering + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworksUpdatePeeringRequest) {
      NetworksUpdatePeeringRequest that = (NetworksUpdatePeeringRequest) o;
      return Objects.equals(this.networkPeering, that.getNetworkPeering());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkPeering);
  }
}
