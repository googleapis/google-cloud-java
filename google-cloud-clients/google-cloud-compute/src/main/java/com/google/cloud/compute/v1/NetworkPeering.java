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
 * A network peering attached to a network resource. The message includes the peering name, peer
 * network, peering state, and a flag indicating whether Google Compute Engine should automatically
 * create routes for the peering.
 */
public final class NetworkPeering implements ApiMessage {
  private final Boolean autoCreateRoutes;
  private final String name;
  private final String network;
  private final String state;
  private final String stateDetails;

  private NetworkPeering() {
    this.autoCreateRoutes = null;
    this.name = null;
    this.network = null;
    this.state = null;
    this.stateDetails = null;
  }

  private NetworkPeering(
      Boolean autoCreateRoutes, String name, String network, String state, String stateDetails) {
    this.autoCreateRoutes = autoCreateRoutes;
    this.name = name;
    this.network = network;
    this.state = state;
    this.stateDetails = stateDetails;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoCreateRoutes".equals(fieldName)) {
      return autoCreateRoutes;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("state".equals(fieldName)) {
      return state;
    }
    if ("stateDetails".equals(fieldName)) {
      return stateDetails;
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

  /**
   * Indicates whether full mesh connectivity is created and managed automatically. When it is set
   * to true, Google Compute Engine will automatically create and manage the routes between two
   * networks when the state is ACTIVE. Otherwise, user needs to create routes manually to route
   * packets to peer network.
   */
  public Boolean getAutoCreateRoutes() {
    return autoCreateRoutes;
  }

  /**
   * Name of this peering. Provided by the client when the peering is created. The name must comply
   * with RFC1035. Specifically, the name must be 1-63 characters long and match regular expression
   * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
   * and all the following characters must be a dash, lowercase letter, or digit, except the last
   * character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * The URL of the peer network. It can be either full URL or partial URL. The peer network may
   * belong to a different project. If the partial URL does not contain project, it is assumed that
   * the peer network is in the same project as the current network.
   */
  public String getNetwork() {
    return network;
  }

  /** [Output Only] State for the peering. */
  public String getState() {
    return state;
  }

  /** [Output Only] Details about the current state of the peering. */
  public String getStateDetails() {
    return stateDetails;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkPeering prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkPeering getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkPeering DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkPeering();
  }

  public static class Builder {
    private Boolean autoCreateRoutes;
    private String name;
    private String network;
    private String state;
    private String stateDetails;

    Builder() {}

    public Builder mergeFrom(NetworkPeering other) {
      if (other == NetworkPeering.getDefaultInstance()) return this;
      if (other.getAutoCreateRoutes() != null) {
        this.autoCreateRoutes = other.autoCreateRoutes;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getStateDetails() != null) {
        this.stateDetails = other.stateDetails;
      }
      return this;
    }

    Builder(NetworkPeering source) {
      this.autoCreateRoutes = source.autoCreateRoutes;
      this.name = source.name;
      this.network = source.network;
      this.state = source.state;
      this.stateDetails = source.stateDetails;
    }

    /**
     * Indicates whether full mesh connectivity is created and managed automatically. When it is set
     * to true, Google Compute Engine will automatically create and manage the routes between two
     * networks when the state is ACTIVE. Otherwise, user needs to create routes manually to route
     * packets to peer network.
     */
    public Boolean getAutoCreateRoutes() {
      return autoCreateRoutes;
    }

    /**
     * Indicates whether full mesh connectivity is created and managed automatically. When it is set
     * to true, Google Compute Engine will automatically create and manage the routes between two
     * networks when the state is ACTIVE. Otherwise, user needs to create routes manually to route
     * packets to peer network.
     */
    public Builder setAutoCreateRoutes(Boolean autoCreateRoutes) {
      this.autoCreateRoutes = autoCreateRoutes;
      return this;
    }

    /**
     * Name of this peering. Provided by the client when the peering is created. The name must
     * comply with RFC1035. Specifically, the name must be 1-63 characters long and match regular
     * expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a
     * lowercase letter, and all the following characters must be a dash, lowercase letter, or
     * digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of this peering. Provided by the client when the peering is created. The name must
     * comply with RFC1035. Specifically, the name must be 1-63 characters long and match regular
     * expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a
     * lowercase letter, and all the following characters must be a dash, lowercase letter, or
     * digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The URL of the peer network. It can be either full URL or partial URL. The peer network may
     * belong to a different project. If the partial URL does not contain project, it is assumed
     * that the peer network is in the same project as the current network.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * The URL of the peer network. It can be either full URL or partial URL. The peer network may
     * belong to a different project. If the partial URL does not contain project, it is assumed
     * that the peer network is in the same project as the current network.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /** [Output Only] State for the peering. */
    public String getState() {
      return state;
    }

    /** [Output Only] State for the peering. */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    /** [Output Only] Details about the current state of the peering. */
    public String getStateDetails() {
      return stateDetails;
    }

    /** [Output Only] Details about the current state of the peering. */
    public Builder setStateDetails(String stateDetails) {
      this.stateDetails = stateDetails;
      return this;
    }

    public NetworkPeering build() {

      return new NetworkPeering(autoCreateRoutes, name, network, state, stateDetails);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoCreateRoutes(this.autoCreateRoutes);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setState(this.state);
      newBuilder.setStateDetails(this.stateDetails);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkPeering{"
        + "autoCreateRoutes="
        + autoCreateRoutes
        + ", "
        + "name="
        + name
        + ", "
        + "network="
        + network
        + ", "
        + "state="
        + state
        + ", "
        + "stateDetails="
        + stateDetails
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkPeering) {
      NetworkPeering that = (NetworkPeering) o;
      return Objects.equals(this.autoCreateRoutes, that.getAutoCreateRoutes())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.state, that.getState())
          && Objects.equals(this.stateDetails, that.getStateDetails());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoCreateRoutes, name, network, state, stateDetails);
  }
}
