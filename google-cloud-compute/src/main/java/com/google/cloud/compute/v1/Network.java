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
public final class Network implements ApiMessage {
  private final Boolean autoCreateSubnetworks;
  private final String creationTimestamp;
  private final String description;
  private final String gatewayIPv4;
  private final String iPv4Range;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;
  private final List<String> subnetworks;

  private Network() {
    this.autoCreateSubnetworks = null;
    this.creationTimestamp = null;
    this.description = null;
    this.gatewayIPv4 = null;
    this.iPv4Range = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
    this.subnetworks = null;
  }


  private Network(
      Boolean autoCreateSubnetworks,
      String creationTimestamp,
      String description,
      String gatewayIPv4,
      String iPv4Range,
      String id,
      String kind,
      String name,
      String selfLink,
      List<String> subnetworks
      ) {
    this.autoCreateSubnetworks = autoCreateSubnetworks;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.gatewayIPv4 = gatewayIPv4;
    this.iPv4Range = iPv4Range;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
    this.subnetworks = subnetworks;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("autoCreateSubnetworks") && autoCreateSubnetworks != null) {
      fieldMap.put("autoCreateSubnetworks", Collections.singletonList(String.valueOf(autoCreateSubnetworks)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("gatewayIPv4") && gatewayIPv4 != null) {
      fieldMap.put("gatewayIPv4", Collections.singletonList(String.valueOf(gatewayIPv4)));
    }
    if (fieldNames.contains("iPv4Range") && iPv4Range != null) {
      fieldMap.put("iPv4Range", Collections.singletonList(String.valueOf(iPv4Range)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("subnetworks") && subnetworks != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : subnetworks) {
        stringList.add(item.toString());
      }
      fieldMap.put("subnetworks", stringList.build());
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("autoCreateSubnetworks")) {
      return String.valueOf(autoCreateSubnetworks);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("gatewayIPv4")) {
      return String.valueOf(gatewayIPv4);
    }
    if (fieldName.equals("iPv4Range")) {
      return String.valueOf(iPv4Range);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("subnetworks")) {
      return String.valueOf(subnetworks);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public Boolean getAutoCreateSubnetworks() {
    return autoCreateSubnetworks;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getGatewayIPv4() {
    return gatewayIPv4;
  }

  public String getIPv4Range() {
    return iPv4Range;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public List<String> getSubnetworksList() {
    return subnetworks;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Network prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Network getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final Network DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Network();
  }

  public static class Builder {
    private Boolean autoCreateSubnetworks;
    private String creationTimestamp;
    private String description;
    private String gatewayIPv4;
    private String iPv4Range;
    private String id;
    private String kind;
    private String name;
    private String selfLink;
    private List<String> subnetworks;

    Builder() {}

    public Builder mergeFrom(Network other) {
      if (other == Network.getDefaultInstance()) return this;
      if (other.getAutoCreateSubnetworks() != null) {
        this.autoCreateSubnetworks = other.autoCreateSubnetworks;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGatewayIPv4() != null) {
        this.gatewayIPv4 = other.gatewayIPv4;
      }
      if (other.getIPv4Range() != null) {
        this.iPv4Range = other.iPv4Range;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSubnetworksList() != null) {
        this.subnetworks = other.subnetworks;
      }
      return this;
    }

    Builder(Network source) {
      this.autoCreateSubnetworks = source.autoCreateSubnetworks;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.gatewayIPv4 = source.gatewayIPv4;
      this.iPv4Range = source.iPv4Range;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.subnetworks = source.subnetworks;
    }

    public Boolean getAutoCreateSubnetworks() {
      return autoCreateSubnetworks;
    }

    public Builder setAutoCreateSubnetworks(Boolean autoCreateSubnetworks) {
      this.autoCreateSubnetworks = autoCreateSubnetworks;
      return this;
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

    public String getGatewayIPv4() {
      return gatewayIPv4;
    }

    public Builder setGatewayIPv4(String gatewayIPv4) {
      this.gatewayIPv4 = gatewayIPv4;
      return this;
    }

    public String getIPv4Range() {
      return iPv4Range;
    }

    public Builder setIPv4Range(String iPv4Range) {
      this.iPv4Range = iPv4Range;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
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

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<String> getSubnetworksList() {
      return subnetworks;
    }

    public Builder addAllSubnetworks(List<String> subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new ArrayList<>(subnetworks.size());
      }
      this.subnetworks.addAll(subnetworks);
      return this;
    }

    public Builder addSubnetworks(String subnetworks) {
      this.subnetworks.add(subnetworks);
      return this;
    }


    public Network build() {









      return new Network(
        autoCreateSubnetworks,
        creationTimestamp,
        description,
        gatewayIPv4,
        iPv4Range,
        id,
        kind,
        name,
        selfLink,
        subnetworks
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoCreateSubnetworks(this.autoCreateSubnetworks);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setGatewayIPv4(this.gatewayIPv4);
      newBuilder.setIPv4Range(this.iPv4Range);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSubnetworks(this.subnetworks);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Network{"
        + "autoCreateSubnetworks=" + autoCreateSubnetworks + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "gatewayIPv4=" + gatewayIPv4 + ", "
        + "iPv4Range=" + iPv4Range + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "selfLink=" + selfLink + ", "
        + "subnetworks=" + subnetworks
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Network) {
      Network that = (Network) o;
      return
          Objects.equals(this.autoCreateSubnetworks, that.getAutoCreateSubnetworks()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.gatewayIPv4, that.getGatewayIPv4()) &&
          Objects.equals(this.iPv4Range, that.getIPv4Range()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.subnetworks, that.getSubnetworksList())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      autoCreateSubnetworks,
      creationTimestamp,
      description,
      gatewayIPv4,
      iPv4Range,
      id,
      kind,
      name,
      selfLink,
      subnetworks
    );
  }
}
