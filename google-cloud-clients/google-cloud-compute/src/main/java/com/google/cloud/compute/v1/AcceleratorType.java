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
 * An Accelerator Type resource. (== resource_for beta.acceleratorTypes ==) (== resource_for
 * v1.acceleratorTypes ==)
 */
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
      String zone) {
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
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("maximumCardsPerInstance".equals(fieldName)) {
      return maximumCardsPerInstance;
    }
    if ("name".equals(fieldName)) {
      return name;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] The deprecation status associated with this accelerator type. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /** [Output Only] An optional textual description of the resource. */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] The type of the resource. Always compute#acceleratorType for accelerator types.
   */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Maximum accelerator cards allowed per instance. */
  public Integer getMaximumCardsPerInstance() {
    return maximumCardsPerInstance;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] Server-defined fully-qualified URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The name of the zone where the accelerator type resides, such as us-central1-a.
   * You must specify this field as part of the HTTP request URL. It is not settable as a field in
   * the request body.
   */
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
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
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

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /** [Output Only] The deprecation status associated with this accelerator type. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this accelerator type. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /** [Output Only] An optional textual description of the resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] An optional textual description of the resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] The type of the resource. Always compute#acceleratorType for accelerator types.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] The type of the resource. Always compute#acceleratorType for accelerator types.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Maximum accelerator cards allowed per instance. */
    public Integer getMaximumCardsPerInstance() {
      return maximumCardsPerInstance;
    }

    /** [Output Only] Maximum accelerator cards allowed per instance. */
    public Builder setMaximumCardsPerInstance(Integer maximumCardsPerInstance) {
      this.maximumCardsPerInstance = maximumCardsPerInstance;
      return this;
    }

    /** [Output Only] Name of the resource. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the resource. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * [Output Only] The name of the zone where the accelerator type resides, such as us-central1-a.
     * You must specify this field as part of the HTTP request URL. It is not settable as a field in
     * the request body.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] The name of the zone where the accelerator type resides, such as us-central1-a.
     * You must specify this field as part of the HTTP request URL. It is not settable as a field in
     * the request body.
     */
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
          zone);
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
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "deprecated="
        + deprecated
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
        + "maximumCardsPerInstance="
        + maximumCardsPerInstance
        + ", "
        + "name="
        + name
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
    if (o instanceof AcceleratorType) {
      AcceleratorType that = (AcceleratorType) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.maximumCardsPerInstance, that.getMaximumCardsPerInstance())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.zone, that.getZone());
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
        zone);
  }
}
