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
public final class InstanceTemplate implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final InstanceProperties properties;
  private final String selfLink;

  private InstanceTemplate() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.properties = null;
    this.selfLink = null;
  }

  private InstanceTemplate(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      InstanceProperties properties,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.properties = properties;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("properties")) {
      return properties;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
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

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public InstanceProperties getProperties() {
    return properties;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceTemplate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceTemplate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceTemplate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceTemplate();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private InstanceProperties properties;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(InstanceTemplate other) {
      if (other == InstanceTemplate.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
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
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getProperties() != null) {
        this.properties = other.properties;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(InstanceTemplate source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.properties = source.properties;
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

    public InstanceProperties getProperties() {
      return properties;
    }

    public Builder setProperties(InstanceProperties properties) {
      this.properties = properties;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public InstanceTemplate build() {

      return new InstanceTemplate(
          creationTimestamp, description, id, kind, name, properties, selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setProperties(this.properties);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceTemplate{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "properties="
        + properties
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceTemplate) {
      InstanceTemplate that = (InstanceTemplate) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.properties, that.getProperties())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTimestamp, description, id, kind, name, properties, selfLink);
  }
}
