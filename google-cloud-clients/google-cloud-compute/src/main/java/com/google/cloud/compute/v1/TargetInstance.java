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
public final class TargetInstance implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String instance;
  private final String kind;
  private final String name;
  private final String natPolicy;
  private final String selfLink;
  private final String zone;

  private TargetInstance() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.instance = null;
    this.kind = null;
    this.name = null;
    this.natPolicy = null;
    this.selfLink = null;
    this.zone = null;
  }

  private TargetInstance(
      String creationTimestamp,
      String description,
      String id,
      String instance,
      String kind,
      String name,
      String natPolicy,
      String selfLink,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.instance = instance;
    this.kind = kind;
    this.name = name;
    this.natPolicy = natPolicy;
    this.selfLink = selfLink;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("instance".equals(fieldName)) {
      return instance;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("natPolicy".equals(fieldName)) {
      return natPolicy;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getInstance() {
    return instance;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getNatPolicy() {
    return natPolicy;
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

  public static Builder newBuilder(TargetInstance prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetInstance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetInstance DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetInstance();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String instance;
    private String kind;
    private String name;
    private String natPolicy;
    private String selfLink;
    private String zone;

    Builder() {}

    public Builder mergeFrom(TargetInstance other) {
      if (other == TargetInstance.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNatPolicy() != null) {
        this.natPolicy = other.natPolicy;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(TargetInstance source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.instance = source.instance;
      this.kind = source.kind;
      this.name = source.name;
      this.natPolicy = source.natPolicy;
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

    public String getInstance() {
      return instance;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
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

    public String getNatPolicy() {
      return natPolicy;
    }

    public Builder setNatPolicy(String natPolicy) {
      this.natPolicy = natPolicy;
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

    public TargetInstance build() {

      return new TargetInstance(
          creationTimestamp, description, id, instance, kind, name, natPolicy, selfLink, zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setInstance(this.instance);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNatPolicy(this.natPolicy);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetInstance{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "instance="
        + instance
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "natPolicy="
        + natPolicy
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetInstance) {
      TargetInstance that = (TargetInstance) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.natPolicy, that.getNatPolicy())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp, description, id, instance, kind, name, natPolicy, selfLink, zone);
  }
}
