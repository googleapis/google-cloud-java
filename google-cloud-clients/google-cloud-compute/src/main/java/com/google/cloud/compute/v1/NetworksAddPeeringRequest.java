/*
 * Copyright 2018 Google LLC
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
public final class NetworksAddPeeringRequest implements ApiMessage {
  private final Boolean autoCreateRoutes;
  private final String name;
  private final String peerNetwork;

  private NetworksAddPeeringRequest() {
    this.autoCreateRoutes = null;
    this.name = null;
    this.peerNetwork = null;
  }

  private NetworksAddPeeringRequest(Boolean autoCreateRoutes, String name, String peerNetwork) {
    this.autoCreateRoutes = autoCreateRoutes;
    this.name = name;
    this.peerNetwork = peerNetwork;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("autoCreateRoutes")) {
      return autoCreateRoutes;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("peerNetwork")) {
      return peerNetwork;
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

  public Boolean getAutoCreateRoutes() {
    return autoCreateRoutes;
  }

  public String getName() {
    return name;
  }

  public String getPeerNetwork() {
    return peerNetwork;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworksAddPeeringRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworksAddPeeringRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworksAddPeeringRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworksAddPeeringRequest();
  }

  public static class Builder {
    private Boolean autoCreateRoutes;
    private String name;
    private String peerNetwork;

    Builder() {}

    public Builder mergeFrom(NetworksAddPeeringRequest other) {
      if (other == NetworksAddPeeringRequest.getDefaultInstance()) return this;
      if (other.getAutoCreateRoutes() != null) {
        this.autoCreateRoutes = other.autoCreateRoutes;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPeerNetwork() != null) {
        this.peerNetwork = other.peerNetwork;
      }
      return this;
    }

    Builder(NetworksAddPeeringRequest source) {
      this.autoCreateRoutes = source.autoCreateRoutes;
      this.name = source.name;
      this.peerNetwork = source.peerNetwork;
    }

    public Boolean getAutoCreateRoutes() {
      return autoCreateRoutes;
    }

    public Builder setAutoCreateRoutes(Boolean autoCreateRoutes) {
      this.autoCreateRoutes = autoCreateRoutes;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getPeerNetwork() {
      return peerNetwork;
    }

    public Builder setPeerNetwork(String peerNetwork) {
      this.peerNetwork = peerNetwork;
      return this;
    }

    public NetworksAddPeeringRequest build() {

      return new NetworksAddPeeringRequest(autoCreateRoutes, name, peerNetwork);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoCreateRoutes(this.autoCreateRoutes);
      newBuilder.setName(this.name);
      newBuilder.setPeerNetwork(this.peerNetwork);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworksAddPeeringRequest{"
        + "autoCreateRoutes="
        + autoCreateRoutes
        + ", "
        + "name="
        + name
        + ", "
        + "peerNetwork="
        + peerNetwork
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworksAddPeeringRequest) {
      NetworksAddPeeringRequest that = (NetworksAddPeeringRequest) o;
      return Objects.equals(this.autoCreateRoutes, that.getAutoCreateRoutes())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerNetwork, that.getPeerNetwork());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoCreateRoutes, name, peerNetwork);
  }
}
