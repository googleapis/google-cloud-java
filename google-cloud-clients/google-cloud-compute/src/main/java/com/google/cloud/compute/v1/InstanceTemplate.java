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
 * An Instance Template resource. (== resource_for beta.instanceTemplates ==) (== resource_for
 * v1.instanceTemplates ==)
 */
public final class InstanceTemplate implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final InstanceProperties properties;
  private final String selfLink;
  private final String sourceInstance;
  private final SourceInstanceParams sourceInstanceParams;

  private InstanceTemplate() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.properties = null;
    this.selfLink = null;
    this.sourceInstance = null;
    this.sourceInstanceParams = null;
  }

  private InstanceTemplate(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      InstanceProperties properties,
      String selfLink,
      String sourceInstance,
      SourceInstanceParams sourceInstanceParams) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.properties = properties;
    this.selfLink = selfLink;
    this.sourceInstance = sourceInstance;
    this.sourceInstanceParams = sourceInstanceParams;
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
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("properties".equals(fieldName)) {
      return properties;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sourceInstance".equals(fieldName)) {
      return sourceInstance;
    }
    if ("sourceInstanceParams".equals(fieldName)) {
      return sourceInstanceParams;
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

  /** [Output Only] The creation timestamp for this instance template in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] A unique identifier for this instance template. The server defines this
   * identifier.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] The resource type, which is always compute#instanceTemplate for instance
   * templates.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource; provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** The instance properties for this instance template. */
  public InstanceProperties getProperties() {
    return properties;
  }

  /** [Output Only] The URL for this instance template. The server defines this URL. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * The source instance used to create the template. You can provide this as a partial or full URL
   * to the resource. For example, the following are valid values: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
   * projects/project/zones/zone/instances/instance
   */
  public String getSourceInstance() {
    return sourceInstance;
  }

  /** The source instance params to use to create this instance template. */
  public SourceInstanceParams getSourceInstanceParams() {
    return sourceInstanceParams;
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
    private String sourceInstance;
    private SourceInstanceParams sourceInstanceParams;

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
      if (other.getSourceInstance() != null) {
        this.sourceInstance = other.sourceInstance;
      }
      if (other.getSourceInstanceParams() != null) {
        this.sourceInstanceParams = other.sourceInstanceParams;
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
      this.sourceInstance = source.sourceInstance;
      this.sourceInstanceParams = source.sourceInstanceParams;
    }

    /** [Output Only] The creation timestamp for this instance template in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] The creation timestamp for this instance template in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Output Only] A unique identifier for this instance template. The server defines this
     * identifier.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] A unique identifier for this instance template. The server defines this
     * identifier.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceTemplate for instance
     * templates.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceTemplate for instance
     * templates.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** The instance properties for this instance template. */
    public InstanceProperties getProperties() {
      return properties;
    }

    /** The instance properties for this instance template. */
    public Builder setProperties(InstanceProperties properties) {
      this.properties = properties;
      return this;
    }

    /** [Output Only] The URL for this instance template. The server defines this URL. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] The URL for this instance template. The server defines this URL. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * The source instance used to create the template. You can provide this as a partial or full
     * URL to the resource. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance
     */
    public String getSourceInstance() {
      return sourceInstance;
    }

    /**
     * The source instance used to create the template. You can provide this as a partial or full
     * URL to the resource. For example, the following are valid values: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance
     */
    public Builder setSourceInstance(String sourceInstance) {
      this.sourceInstance = sourceInstance;
      return this;
    }

    /** The source instance params to use to create this instance template. */
    public SourceInstanceParams getSourceInstanceParams() {
      return sourceInstanceParams;
    }

    /** The source instance params to use to create this instance template. */
    public Builder setSourceInstanceParams(SourceInstanceParams sourceInstanceParams) {
      this.sourceInstanceParams = sourceInstanceParams;
      return this;
    }

    public InstanceTemplate build() {

      return new InstanceTemplate(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          properties,
          selfLink,
          sourceInstance,
          sourceInstanceParams);
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
      newBuilder.setSourceInstance(this.sourceInstance);
      newBuilder.setSourceInstanceParams(this.sourceInstanceParams);
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
        + ", "
        + "sourceInstance="
        + sourceInstance
        + ", "
        + "sourceInstanceParams="
        + sourceInstanceParams
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
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sourceInstance, that.getSourceInstance())
          && Objects.equals(this.sourceInstanceParams, that.getSourceInstanceParams());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        id,
        kind,
        name,
        properties,
        selfLink,
        sourceInstance,
        sourceInstanceParams);
  }
}
