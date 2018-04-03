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
public final class Commitment implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String endTimestamp;
  private final String id;
  private final String kind;
  private final String name;
  private final String plan;
  private final String region;
  private final List<ResourceCommitment> resources;
  private final String selfLink;
  private final String startTimestamp;
  private final String status;
  private final String statusMessage;

  private Commitment() {
    this.creationTimestamp = null;
    this.description = null;
    this.endTimestamp = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.plan = null;
    this.region = null;
    this.resources = null;
    this.selfLink = null;
    this.startTimestamp = null;
    this.status = null;
    this.statusMessage = null;
  }


  private Commitment(
      String creationTimestamp,
      String description,
      String endTimestamp,
      String id,
      String kind,
      String name,
      String plan,
      String region,
      List<ResourceCommitment> resources,
      String selfLink,
      String startTimestamp,
      String status,
      String statusMessage
      ) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.endTimestamp = endTimestamp;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.plan = plan;
    this.region = region;
    this.resources = resources;
    this.selfLink = selfLink;
    this.startTimestamp = startTimestamp;
    this.status = status;
    this.statusMessage = statusMessage;
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
    if (fieldNames.contains("endTimestamp") && endTimestamp != null) {
      fieldMap.put("endTimestamp", Collections.singletonList(String.valueOf(endTimestamp)));
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
    if (fieldNames.contains("plan") && plan != null) {
      fieldMap.put("plan", Collections.singletonList(String.valueOf(plan)));
    }
    if (fieldNames.contains("region") && region != null) {
      fieldMap.put("region", Collections.singletonList(String.valueOf(region)));
    }
    if (fieldNames.contains("resources") && resources != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (ResourceCommitment item : resources) {
        stringList.add(item.toString());
      }
      fieldMap.put("resources", stringList.build());
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("startTimestamp") && startTimestamp != null) {
      fieldMap.put("startTimestamp", Collections.singletonList(String.valueOf(startTimestamp)));
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    if (fieldNames.contains("statusMessage") && statusMessage != null) {
      fieldMap.put("statusMessage", Collections.singletonList(String.valueOf(statusMessage)));
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
    if (fieldName.equals("endTimestamp")) {
      return String.valueOf(endTimestamp);
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
    if (fieldName.equals("plan")) {
      return String.valueOf(plan);
    }
    if (fieldName.equals("region")) {
      return String.valueOf(region);
    }
    if (fieldName.equals("resources")) {
      return String.valueOf(resources);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("startTimestamp")) {
      return String.valueOf(startTimestamp);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    if (fieldName.equals("statusMessage")) {
      return String.valueOf(statusMessage);
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

  public String getEndTimestamp() {
    return endTimestamp;
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

  public String getPlan() {
    return plan;
  }

  public String getRegion() {
    return region;
  }

  public List<ResourceCommitment> getResourcesList() {
    return resources;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getStartTimestamp() {
    return startTimestamp;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Commitment prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Commitment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final Commitment DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Commitment();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String endTimestamp;
    private String id;
    private String kind;
    private String name;
    private String plan;
    private String region;
    private List<ResourceCommitment> resources;
    private String selfLink;
    private String startTimestamp;
    private String status;
    private String statusMessage;

    Builder() {}

    public Builder mergeFrom(Commitment other) {
      if (other == Commitment.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEndTimestamp() != null) {
        this.endTimestamp = other.endTimestamp;
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
      if (other.getPlan() != null) {
        this.plan = other.plan;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getResourcesList() != null) {
        this.resources = other.resources;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStartTimestamp() != null) {
        this.startTimestamp = other.startTimestamp;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusMessage() != null) {
        this.statusMessage = other.statusMessage;
      }
      return this;
    }

    Builder(Commitment source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.endTimestamp = source.endTimestamp;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.plan = source.plan;
      this.region = source.region;
      this.resources = source.resources;
      this.selfLink = source.selfLink;
      this.startTimestamp = source.startTimestamp;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
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

    public String getEndTimestamp() {
      return endTimestamp;
    }

    public Builder setEndTimestamp(String endTimestamp) {
      this.endTimestamp = endTimestamp;
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

    public String getPlan() {
      return plan;
    }

    public Builder setPlan(String plan) {
      this.plan = plan;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public List<ResourceCommitment> getResourcesList() {
      return resources;
    }

    public Builder addAllResources(List<ResourceCommitment> resources) {
      if (this.resources == null) {
        this.resources = new ArrayList<>(resources.size());
      }
      this.resources.addAll(resources);
      return this;
    }

    public Builder addResources(ResourceCommitment resources) {
      this.resources.add(resources);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getStartTimestamp() {
      return startTimestamp;
    }

    public Builder setStartTimestamp(String startTimestamp) {
      this.startTimestamp = startTimestamp;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getStatusMessage() {
      return statusMessage;
    }

    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }


    public Commitment build() {












      return new Commitment(
        creationTimestamp,
        description,
        endTimestamp,
        id,
        kind,
        name,
        plan,
        region,
        resources,
        selfLink,
        startTimestamp,
        status,
        statusMessage
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEndTimestamp(this.endTimestamp);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setPlan(this.plan);
      newBuilder.setRegion(this.region);
      newBuilder.addAllResources(this.resources);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStartTimestamp(this.startTimestamp);
      newBuilder.setStatus(this.status);
      newBuilder.setStatusMessage(this.statusMessage);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Commitment{"
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "endTimestamp=" + endTimestamp + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "plan=" + plan + ", "
        + "region=" + region + ", "
        + "resources=" + resources + ", "
        + "selfLink=" + selfLink + ", "
        + "startTimestamp=" + startTimestamp + ", "
        + "status=" + status + ", "
        + "statusMessage=" + statusMessage
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Commitment) {
      Commitment that = (Commitment) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.endTimestamp, that.getEndTimestamp()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.plan, that.getPlan()) &&
          Objects.equals(this.region, that.getRegion()) &&
          Objects.equals(this.resources, that.getResourcesList()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.startTimestamp, that.getStartTimestamp()) &&
          Objects.equals(this.status, that.getStatus()) &&
          Objects.equals(this.statusMessage, that.getStatusMessage())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      creationTimestamp,
      description,
      endTimestamp,
      id,
      kind,
      name,
      plan,
      region,
      resources,
      selfLink,
      startTimestamp,
      status,
      statusMessage
    );
  }
}
