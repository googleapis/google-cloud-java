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
public final class AcceleratorType implements ApiMessage {
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final String id;
  private final String kind;
  private final Integer maximumCardsPerInstance;
  private final String name;
  private final String selfLink;
  private final String zone;

  private AcceleratorType() {
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.maximumCardsPerInstance = null;
    this.name = null;
    this.selfLink = null;
    this.zone = null;
  }


  private AcceleratorType(
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      String id,
      String kind,
      Integer maximumCardsPerInstance,
      String name,
      String selfLink,
      String zone
      ) {
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.maximumCardsPerInstance = maximumCardsPerInstance;
    this.name = name;
    this.selfLink = selfLink;
    this.zone = zone;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("deprecated") && deprecated != null) {
      fieldMap.put("deprecated", Collections.singletonList(String.valueOf(deprecated)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("maximumCardsPerInstance") && maximumCardsPerInstance != null) {
      fieldMap.put("maximumCardsPerInstance", Collections.singletonList(String.valueOf(maximumCardsPerInstance)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("zone") && zone != null) {
      fieldMap.put("zone", Collections.singletonList(String.valueOf(zone)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("deprecated")) {
      return String.valueOf(deprecated);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("maximumCardsPerInstance")) {
      return String.valueOf(maximumCardsPerInstance);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("zone")) {
      return String.valueOf(zone);
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

  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public Integer getMaximumCardsPerInstance() {
    return maximumCardsPerInstance;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getZone() {
    return zone;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AcceleratorType prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AcceleratorType getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final AcceleratorType DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AcceleratorType();
  }

  public static class Builder {
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private String id;
    private String kind;
    private Integer maximumCardsPerInstance;
    private String name;
    private String selfLink;
    private String zone;

    Builder() {}

    public Builder mergeFrom(AcceleratorType other) {
      if (other == AcceleratorType.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getMaximumCardsPerInstance() != null) {
        this.maximumCardsPerInstance = other.maximumCardsPerInstance;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(AcceleratorType source) {
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.maximumCardsPerInstance = source.maximumCardsPerInstance;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.zone = source.zone;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
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

    public Integer getMaximumCardsPerInstance() {
      return maximumCardsPerInstance;
    }

    public Builder setMaximumCardsPerInstance(Integer maximumCardsPerInstance) {
      this.maximumCardsPerInstance = maximumCardsPerInstance;
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

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }


    public AcceleratorType build() {








      return new AcceleratorType(
        creationTimestamp,
        deprecated,
        description,
        id,
        kind,
        maximumCardsPerInstance,
        name,
        selfLink,
        zone
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setMaximumCardsPerInstance(this.maximumCardsPerInstance);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AcceleratorType{"
        + "creationTimestamp=" + creationTimestamp + ", "
        + "deprecated=" + deprecated + ", "
        + "description=" + description + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "maximumCardsPerInstance=" + maximumCardsPerInstance + ", "
        + "name=" + name + ", "
        + "selfLink=" + selfLink + ", "
        + "zone=" + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AcceleratorType) {
      AcceleratorType that = (AcceleratorType) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.deprecated, that.getDeprecated()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.maximumCardsPerInstance, that.getMaximumCardsPerInstance()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.zone, that.getZone())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      creationTimestamp,
      deprecated,
      description,
      id,
      kind,
      maximumCardsPerInstance,
      name,
      selfLink,
      zone
    );
  }
}
