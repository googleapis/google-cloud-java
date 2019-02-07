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
/** A NodeGroup resource. */
public final class NodeGroup implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String nodeTemplate;
  private final String selfLink;
  private final Integer size;
  private final String status;
  private final String zone;

  private NodeGroup() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.nodeTemplate = null;
    this.selfLink = null;
    this.size = null;
    this.status = null;
    this.zone = null;
  }

  private NodeGroup(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String nodeTemplate,
      String selfLink,
      Integer size,
      String status,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.nodeTemplate = nodeTemplate;
    this.selfLink = selfLink;
    this.size = size;
    this.status = status;
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
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("nodeTemplate".equals(fieldName)) {
      return nodeTemplate;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("size".equals(fieldName)) {
      return size;
    }
    if ("status".equals(fieldName)) {
      return status;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
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
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] The type of the resource. Always compute#nodeGroup for node group. */
  public String getKind() {
    return kind;
  }

  /**
   * The name of the resource, provided by the client when initially creating the resource. The
   * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
   * must be 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** The URL of the node template to which this node group belongs. */
  public String getNodeTemplate() {
    return nodeTemplate;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] The total number of nodes in the node group. */
  public Integer getSize() {
    return size;
  }

  public String getStatus() {
    return status;
  }

  /** [Output Only] The name of the zone where the node group resides, such as us-central1-a. */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroup prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroup getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroup DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroup();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String nodeTemplate;
    private String selfLink;
    private Integer size;
    private String status;
    private String zone;

    Builder() {}

    public Builder mergeFrom(NodeGroup other) {
      if (other == NodeGroup.getDefaultInstance()) return this;
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
      if (other.getNodeTemplate() != null) {
        this.nodeTemplate = other.nodeTemplate;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSize() != null) {
        this.size = other.size;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(NodeGroup source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.nodeTemplate = source.nodeTemplate;
      this.selfLink = source.selfLink;
      this.size = source.size;
      this.status = source.status;
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

    /** [Output Only] The type of the resource. Always compute#nodeGroup for node group. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] The type of the resource. Always compute#nodeGroup for node group. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** The URL of the node template to which this node group belongs. */
    public String getNodeTemplate() {
      return nodeTemplate;
    }

    /** The URL of the node template to which this node group belongs. */
    public Builder setNodeTemplate(String nodeTemplate) {
      this.nodeTemplate = nodeTemplate;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] The total number of nodes in the node group. */
    public Integer getSize() {
      return size;
    }

    /** [Output Only] The total number of nodes in the node group. */
    public Builder setSize(Integer size) {
      this.size = size;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] The name of the zone where the node group resides, such as us-central1-a. */
    public String getZone() {
      return zone;
    }

    /** [Output Only] The name of the zone where the node group resides, such as us-central1-a. */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public NodeGroup build() {

      return new NodeGroup(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          nodeTemplate,
          selfLink,
          size,
          status,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNodeTemplate(this.nodeTemplate);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSize(this.size);
      newBuilder.setStatus(this.status);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroup{"
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
        + "nodeTemplate="
        + nodeTemplate
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "size="
        + size
        + ", "
        + "status="
        + status
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
    if (o instanceof NodeGroup) {
      NodeGroup that = (NodeGroup) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.nodeTemplate, that.getNodeTemplate())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.size, that.getSize())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp, description, id, kind, name, nodeTemplate, selfLink, size, status, zone);
  }
}
