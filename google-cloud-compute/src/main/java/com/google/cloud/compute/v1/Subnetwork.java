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
public final class Subnetwork implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String gatewayAddress;
  private final String id;
  private final String ipCidrRange;
  private final String kind;
  private final String name;
  private final String network;
  private final String region;
  private final String selfLink;

  private Subnetwork() {
    this.creationTimestamp = null;
    this.description = null;
    this.gatewayAddress = null;
    this.id = null;
    this.ipCidrRange = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.region = null;
    this.selfLink = null;
  }


  private Subnetwork(
      String creationTimestamp,
      String description,
      String gatewayAddress,
      String id,
      String ipCidrRange,
      String kind,
      String name,
      String network,
      String region,
      String selfLink
      ) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.gatewayAddress = gatewayAddress;
    this.id = id;
    this.ipCidrRange = ipCidrRange;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.region = region;
    this.selfLink = selfLink;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("gatewayAddress") && gatewayAddress != null) {
      fieldMap.put("gatewayAddress", Collections.singletonList(String.valueOf(gatewayAddress)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("ipCidrRange") && ipCidrRange != null) {
      fieldMap.put("ipCidrRange", Collections.singletonList(String.valueOf(ipCidrRange)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("network") && network != null) {
      fieldMap.put("network", Collections.singletonList(String.valueOf(network)));
    }
    if (fieldNames.contains("region") && region != null) {
      fieldMap.put("region", Collections.singletonList(String.valueOf(region)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("gatewayAddress")) {
      return String.valueOf(gatewayAddress);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("ipCidrRange")) {
      return String.valueOf(ipCidrRange);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("network")) {
      return String.valueOf(network);
    }
    if (fieldName.equals("region")) {
      return String.valueOf(region);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getGatewayAddress() {
    return gatewayAddress;
  }

  public String getId() {
    return id;
  }

  public String getIpCidrRange() {
    return ipCidrRange;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getNetwork() {
    return network;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Subnetwork prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Subnetwork getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final Subnetwork DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Subnetwork();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String gatewayAddress;
    private String id;
    private String ipCidrRange;
    private String kind;
    private String name;
    private String network;
    private String region;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(Subnetwork other) {
      if (other == Subnetwork.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGatewayAddress() != null) {
        this.gatewayAddress = other.gatewayAddress;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpCidrRange() != null) {
        this.ipCidrRange = other.ipCidrRange;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(Subnetwork source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.gatewayAddress = source.gatewayAddress;
      this.id = source.id;
      this.ipCidrRange = source.ipCidrRange;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.region = source.region;
      this.selfLink = source.selfLink;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getGatewayAddress() {
      return gatewayAddress;
    }

    public Builder setGatewayAddress(String gatewayAddress) {
      this.gatewayAddress = gatewayAddress;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getIpCidrRange() {
      return ipCidrRange;
    }

    public Builder setIpCidrRange(String ipCidrRange) {
      this.ipCidrRange = ipCidrRange;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
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

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }


    public Subnetwork build() {









      return new Subnetwork(
        creationTimestamp,
        description,
        gatewayAddress,
        id,
        ipCidrRange,
        kind,
        name,
        network,
        region,
        selfLink
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setGatewayAddress(this.gatewayAddress);
      newBuilder.setId(this.id);
      newBuilder.setIpCidrRange(this.ipCidrRange);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Subnetwork{"
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "gatewayAddress=" + gatewayAddress + ", "
        + "id=" + id + ", "
        + "ipCidrRange=" + ipCidrRange + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "network=" + network + ", "
        + "region=" + region + ", "
        + "selfLink=" + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Subnetwork) {
      Subnetwork that = (Subnetwork) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.gatewayAddress, that.getGatewayAddress()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.ipCidrRange, that.getIpCidrRange()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.network, that.getNetwork()) &&
          Objects.equals(this.region, that.getRegion()) &&
          Objects.equals(this.selfLink, that.getSelfLink())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      creationTimestamp,
      description,
      gatewayAddress,
      id,
      ipCidrRange,
      kind,
      name,
      network,
      region,
      selfLink
    );
  }
}
