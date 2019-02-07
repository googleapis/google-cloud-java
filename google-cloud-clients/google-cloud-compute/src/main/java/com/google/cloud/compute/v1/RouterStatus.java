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
public final class RouterStatus implements ApiMessage {
  private final List<Route> bestRoutes;
  private final List<Route> bestRoutesForRouter;
  private final List<RouterStatusBgpPeerStatus> bgpPeerStatus;
  private final List<RouterStatusNatStatus> natStatus;
  private final String network;

  private RouterStatus() {
    this.bestRoutes = null;
    this.bestRoutesForRouter = null;
    this.bgpPeerStatus = null;
    this.natStatus = null;
    this.network = null;
  }

  private RouterStatus(
      List<Route> bestRoutes,
      List<Route> bestRoutesForRouter,
      List<RouterStatusBgpPeerStatus> bgpPeerStatus,
      List<RouterStatusNatStatus> natStatus,
      String network) {
    this.bestRoutes = bestRoutes;
    this.bestRoutesForRouter = bestRoutesForRouter;
    this.bgpPeerStatus = bgpPeerStatus;
    this.natStatus = natStatus;
    this.network = network;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("bestRoutes".equals(fieldName)) {
      return bestRoutes;
    }
    if ("bestRoutesForRouter".equals(fieldName)) {
      return bestRoutesForRouter;
    }
    if ("bgpPeerStatus".equals(fieldName)) {
      return bgpPeerStatus;
    }
    if ("natStatus".equals(fieldName)) {
      return natStatus;
    }
    if ("network".equals(fieldName)) {
      return network;
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

  /** Best routes for this router's network. */
  public List<Route> getBestRoutesList() {
    return bestRoutes;
  }

  /** Best routes learned by this router. */
  public List<Route> getBestRoutesForRouterList() {
    return bestRoutesForRouter;
  }

  public List<RouterStatusBgpPeerStatus> getBgpPeerStatusList() {
    return bgpPeerStatus;
  }

  public List<RouterStatusNatStatus> getNatStatusList() {
    return natStatus;
  }

  /** URI of the network to which this router belongs. */
  public String getNetwork() {
    return network;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterStatus();
  }

  public static class Builder {
    private List<Route> bestRoutes;
    private List<Route> bestRoutesForRouter;
    private List<RouterStatusBgpPeerStatus> bgpPeerStatus;
    private List<RouterStatusNatStatus> natStatus;
    private String network;

    Builder() {}

    public Builder mergeFrom(RouterStatus other) {
      if (other == RouterStatus.getDefaultInstance()) return this;
      if (other.getBestRoutesList() != null) {
        this.bestRoutes = other.bestRoutes;
      }
      if (other.getBestRoutesForRouterList() != null) {
        this.bestRoutesForRouter = other.bestRoutesForRouter;
      }
      if (other.getBgpPeerStatusList() != null) {
        this.bgpPeerStatus = other.bgpPeerStatus;
      }
      if (other.getNatStatusList() != null) {
        this.natStatus = other.natStatus;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      return this;
    }

    Builder(RouterStatus source) {
      this.bestRoutes = source.bestRoutes;
      this.bestRoutesForRouter = source.bestRoutesForRouter;
      this.bgpPeerStatus = source.bgpPeerStatus;
      this.natStatus = source.natStatus;
      this.network = source.network;
    }

    /** Best routes for this router's network. */
    public List<Route> getBestRoutesList() {
      return bestRoutes;
    }

    /** Best routes for this router's network. */
    public Builder addAllBestRoutes(List<Route> bestRoutes) {
      if (this.bestRoutes == null) {
        this.bestRoutes = new LinkedList<>();
      }
      this.bestRoutes.addAll(bestRoutes);
      return this;
    }

    /** Best routes for this router's network. */
    public Builder addBestRoutes(Route bestRoutes) {
      if (this.bestRoutes == null) {
        this.bestRoutes = new LinkedList<>();
      }
      this.bestRoutes.add(bestRoutes);
      return this;
    }

    /** Best routes learned by this router. */
    public List<Route> getBestRoutesForRouterList() {
      return bestRoutesForRouter;
    }

    /** Best routes learned by this router. */
    public Builder addAllBestRoutesForRouter(List<Route> bestRoutesForRouter) {
      if (this.bestRoutesForRouter == null) {
        this.bestRoutesForRouter = new LinkedList<>();
      }
      this.bestRoutesForRouter.addAll(bestRoutesForRouter);
      return this;
    }

    /** Best routes learned by this router. */
    public Builder addBestRoutesForRouter(Route bestRoutesForRouter) {
      if (this.bestRoutesForRouter == null) {
        this.bestRoutesForRouter = new LinkedList<>();
      }
      this.bestRoutesForRouter.add(bestRoutesForRouter);
      return this;
    }

    public List<RouterStatusBgpPeerStatus> getBgpPeerStatusList() {
      return bgpPeerStatus;
    }

    public Builder addAllBgpPeerStatus(List<RouterStatusBgpPeerStatus> bgpPeerStatus) {
      if (this.bgpPeerStatus == null) {
        this.bgpPeerStatus = new LinkedList<>();
      }
      this.bgpPeerStatus.addAll(bgpPeerStatus);
      return this;
    }

    public Builder addBgpPeerStatus(RouterStatusBgpPeerStatus bgpPeerStatus) {
      if (this.bgpPeerStatus == null) {
        this.bgpPeerStatus = new LinkedList<>();
      }
      this.bgpPeerStatus.add(bgpPeerStatus);
      return this;
    }

    public List<RouterStatusNatStatus> getNatStatusList() {
      return natStatus;
    }

    public Builder addAllNatStatus(List<RouterStatusNatStatus> natStatus) {
      if (this.natStatus == null) {
        this.natStatus = new LinkedList<>();
      }
      this.natStatus.addAll(natStatus);
      return this;
    }

    public Builder addNatStatus(RouterStatusNatStatus natStatus) {
      if (this.natStatus == null) {
        this.natStatus = new LinkedList<>();
      }
      this.natStatus.add(natStatus);
      return this;
    }

    /** URI of the network to which this router belongs. */
    public String getNetwork() {
      return network;
    }

    /** URI of the network to which this router belongs. */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public RouterStatus build() {

      return new RouterStatus(bestRoutes, bestRoutesForRouter, bgpPeerStatus, natStatus, network);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllBestRoutes(this.bestRoutes);
      newBuilder.addAllBestRoutesForRouter(this.bestRoutesForRouter);
      newBuilder.addAllBgpPeerStatus(this.bgpPeerStatus);
      newBuilder.addAllNatStatus(this.natStatus);
      newBuilder.setNetwork(this.network);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterStatus{"
        + "bestRoutes="
        + bestRoutes
        + ", "
        + "bestRoutesForRouter="
        + bestRoutesForRouter
        + ", "
        + "bgpPeerStatus="
        + bgpPeerStatus
        + ", "
        + "natStatus="
        + natStatus
        + ", "
        + "network="
        + network
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterStatus) {
      RouterStatus that = (RouterStatus) o;
      return Objects.equals(this.bestRoutes, that.getBestRoutesList())
          && Objects.equals(this.bestRoutesForRouter, that.getBestRoutesForRouterList())
          && Objects.equals(this.bgpPeerStatus, that.getBgpPeerStatusList())
          && Objects.equals(this.natStatus, that.getNatStatusList())
          && Objects.equals(this.network, that.getNetwork());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bestRoutes, bestRoutesForRouter, bgpPeerStatus, natStatus, network);
  }
}
