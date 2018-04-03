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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
      Boolean autoCreateRoutes,
      String name,
      String network,
      String state,
      String stateDetails
      ) {
    this.autoCreateRoutes = autoCreateRoutes;
    this.name = name;
    this.network = network;
    this.state = state;
    this.stateDetails = stateDetails;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("autoCreateRoutes") && autoCreateRoutes != null) {
      fieldMap.put("autoCreateRoutes", Collections.singletonList(String.valueOf(autoCreateRoutes)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("network") && network != null) {
      fieldMap.put("network", Collections.singletonList(String.valueOf(network)));
    }
    if (fieldNames.contains("state") && state != null) {
      fieldMap.put("state", Collections.singletonList(String.valueOf(state)));
    }
    if (fieldNames.contains("stateDetails") && stateDetails != null) {
      fieldMap.put("stateDetails", Collections.singletonList(String.valueOf(stateDetails)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("autoCreateRoutes")) {
      return String.valueOf(autoCreateRoutes);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("network")) {
      return String.valueOf(network);
    }
    if (fieldName.equals("state")) {
      return String.valueOf(state);
    }
    if (fieldName.equals("stateDetails")) {
      return String.valueOf(stateDetails);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public Boolean getAutoCreateRoutes() {
    return autoCreateRoutes;
  }

  public String getName() {
    return name;
  }

  public String getNetwork() {
    return network;
  }

  public String getState() {
    return state;
  }

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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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

    public String getNetwork() {
      return network;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public String getStateDetails() {
      return stateDetails;
    }

    public Builder setStateDetails(String stateDetails) {
      this.stateDetails = stateDetails;
      return this;
    }


    public NetworkPeering build() {




      return new NetworkPeering(
        autoCreateRoutes,
        name,
        network,
        state,
        stateDetails
      );
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
        + "autoCreateRoutes=" + autoCreateRoutes + ", "
        + "name=" + name + ", "
        + "network=" + network + ", "
        + "state=" + state + ", "
        + "stateDetails=" + stateDetails
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkPeering) {
      NetworkPeering that = (NetworkPeering) o;
      return
          Objects.equals(this.autoCreateRoutes, that.getAutoCreateRoutes()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.network, that.getNetwork()) &&
          Objects.equals(this.state, that.getState()) &&
          Objects.equals(this.stateDetails, that.getStateDetails())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      autoCreateRoutes,
      name,
      network,
      state,
      stateDetails
    );
  }
}
