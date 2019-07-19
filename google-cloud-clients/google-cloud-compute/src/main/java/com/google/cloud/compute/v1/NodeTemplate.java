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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represent a sole-tenant Node Template resource.
 *
 * <p>You can use a template to define properties for nodes in a node group. For more information,
 * read Creating node groups and instances. (== resource_for beta.nodeTemplates ==) (== resource_for
 * v1.nodeTemplates ==) (== NextID: 16 ==)
 */
public final class NodeTemplate implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final Map<String, String> nodeAffinityLabels;
  private final String nodeType;
  private final NodeTemplateNodeTypeFlexibility nodeTypeFlexibility;
  private final String region;
  private final String selfLink;
  private final ServerBinding serverBinding;
  private final String status;
  private final String statusMessage;

  private NodeTemplate() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.nodeAffinityLabels = null;
    this.nodeType = null;
    this.nodeTypeFlexibility = null;
    this.region = null;
    this.selfLink = null;
    this.serverBinding = null;
    this.status = null;
    this.statusMessage = null;
  }

  private NodeTemplate(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      Map<String, String> nodeAffinityLabels,
      String nodeType,
      NodeTemplateNodeTypeFlexibility nodeTypeFlexibility,
      String region,
      String selfLink,
      ServerBinding serverBinding,
      String status,
      String statusMessage) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.nodeAffinityLabels = nodeAffinityLabels;
    this.nodeType = nodeType;
    this.nodeTypeFlexibility = nodeTypeFlexibility;
    this.region = region;
    this.selfLink = selfLink;
    this.serverBinding = serverBinding;
    this.status = status;
    this.statusMessage = statusMessage;
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
    if ("nodeAffinityLabels".equals(fieldName)) {
      return nodeAffinityLabels;
    }
    if ("nodeType".equals(fieldName)) {
      return nodeType;
    }
    if ("nodeTypeFlexibility".equals(fieldName)) {
      return nodeTypeFlexibility;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("serverBinding".equals(fieldName)) {
      return serverBinding;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusMessage".equals(fieldName)) {
      return statusMessage;
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

  /** [Output Only] The type of the resource. Always compute#nodeTemplate for node templates. */
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

  /** Labels to use for node affinity, which will be used in instance scheduling. */
  public Map<String, String> getNodeAffinityLabelsMap() {
    return nodeAffinityLabels;
  }

  /** The node type to use for nodes group that are created from this template. */
  public String getNodeType() {
    return nodeType;
  }

  /**
   * The flexible properties of the desired node type. Node groups that use this node template will
   * create nodes of a type that matches these properties.
   *
   * <p>This field is mutually exclusive with the node_type property; you can only define one or the
   * other, but not both.
   */
  public NodeTemplateNodeTypeFlexibility getNodeTypeFlexibility() {
    return nodeTypeFlexibility;
  }

  /** [Output Only] The name of the region where the node template resides, such as us-central1. */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Sets the binding properties for the physical server. Valid values include: - [Default]
   * RESTART_NODE_ON_ANY_SERVER: Restarts VMs on any available physical server -
   * RESTART_NODE_ON_MINIMAL_SERVER: Restarts VMs on the same physical server whenever possible
   *
   * <p>See Sole-tenant node options for more information.
   */
  public ServerBinding getServerBinding() {
    return serverBinding;
  }

  /**
   * [Output Only] The status of the node template. One of the following values: CREATING, READY,
   * and DELETING.
   */
  public String getStatus() {
    return status;
  }

  /** [Output Only] An optional, human-readable explanation of the status. */
  public String getStatusMessage() {
    return statusMessage;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeTemplate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeTemplate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeTemplate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeTemplate();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private Map<String, String> nodeAffinityLabels;
    private String nodeType;
    private NodeTemplateNodeTypeFlexibility nodeTypeFlexibility;
    private String region;
    private String selfLink;
    private ServerBinding serverBinding;
    private String status;
    private String statusMessage;

    Builder() {}

    public Builder mergeFrom(NodeTemplate other) {
      if (other == NodeTemplate.getDefaultInstance()) return this;
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
      if (other.getNodeAffinityLabelsMap() != null) {
        this.nodeAffinityLabels = other.nodeAffinityLabels;
      }
      if (other.getNodeType() != null) {
        this.nodeType = other.nodeType;
      }
      if (other.getNodeTypeFlexibility() != null) {
        this.nodeTypeFlexibility = other.nodeTypeFlexibility;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getServerBinding() != null) {
        this.serverBinding = other.serverBinding;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusMessage() != null) {
        this.statusMessage = other.statusMessage;
      }
      return this;
    }

    Builder(NodeTemplate source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.nodeAffinityLabels = source.nodeAffinityLabels;
      this.nodeType = source.nodeType;
      this.nodeTypeFlexibility = source.nodeTypeFlexibility;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.serverBinding = source.serverBinding;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
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

    /** [Output Only] The type of the resource. Always compute#nodeTemplate for node templates. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] The type of the resource. Always compute#nodeTemplate for node templates. */
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

    /** Labels to use for node affinity, which will be used in instance scheduling. */
    public Map<String, String> getNodeAffinityLabelsMap() {
      return nodeAffinityLabels;
    }

    /** Labels to use for node affinity, which will be used in instance scheduling. */
    public Builder putAllNodeAffinityLabels(Map<String, String> nodeAffinityLabels) {
      this.nodeAffinityLabels = nodeAffinityLabels;
      return this;
    }

    /** The node type to use for nodes group that are created from this template. */
    public String getNodeType() {
      return nodeType;
    }

    /** The node type to use for nodes group that are created from this template. */
    public Builder setNodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    /**
     * The flexible properties of the desired node type. Node groups that use this node template
     * will create nodes of a type that matches these properties.
     *
     * <p>This field is mutually exclusive with the node_type property; you can only define one or
     * the other, but not both.
     */
    public NodeTemplateNodeTypeFlexibility getNodeTypeFlexibility() {
      return nodeTypeFlexibility;
    }

    /**
     * The flexible properties of the desired node type. Node groups that use this node template
     * will create nodes of a type that matches these properties.
     *
     * <p>This field is mutually exclusive with the node_type property; you can only define one or
     * the other, but not both.
     */
    public Builder setNodeTypeFlexibility(NodeTemplateNodeTypeFlexibility nodeTypeFlexibility) {
      this.nodeTypeFlexibility = nodeTypeFlexibility;
      return this;
    }

    /**
     * [Output Only] The name of the region where the node template resides, such as us-central1.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] The name of the region where the node template resides, such as us-central1.
     */
    public Builder setRegion(String region) {
      this.region = region;
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

    /**
     * Sets the binding properties for the physical server. Valid values include: - [Default]
     * RESTART_NODE_ON_ANY_SERVER: Restarts VMs on any available physical server -
     * RESTART_NODE_ON_MINIMAL_SERVER: Restarts VMs on the same physical server whenever possible
     *
     * <p>See Sole-tenant node options for more information.
     */
    public ServerBinding getServerBinding() {
      return serverBinding;
    }

    /**
     * Sets the binding properties for the physical server. Valid values include: - [Default]
     * RESTART_NODE_ON_ANY_SERVER: Restarts VMs on any available physical server -
     * RESTART_NODE_ON_MINIMAL_SERVER: Restarts VMs on the same physical server whenever possible
     *
     * <p>See Sole-tenant node options for more information.
     */
    public Builder setServerBinding(ServerBinding serverBinding) {
      this.serverBinding = serverBinding;
      return this;
    }

    /**
     * [Output Only] The status of the node template. One of the following values: CREATING, READY,
     * and DELETING.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the node template. One of the following values: CREATING, READY,
     * and DELETING.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public String getStatusMessage() {
      return statusMessage;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    public NodeTemplate build() {

      return new NodeTemplate(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          nodeAffinityLabels,
          nodeType,
          nodeTypeFlexibility,
          region,
          selfLink,
          serverBinding,
          status,
          statusMessage);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.putAllNodeAffinityLabels(this.nodeAffinityLabels);
      newBuilder.setNodeType(this.nodeType);
      newBuilder.setNodeTypeFlexibility(this.nodeTypeFlexibility);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setServerBinding(this.serverBinding);
      newBuilder.setStatus(this.status);
      newBuilder.setStatusMessage(this.statusMessage);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeTemplate{"
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
        + "nodeAffinityLabels="
        + nodeAffinityLabels
        + ", "
        + "nodeType="
        + nodeType
        + ", "
        + "nodeTypeFlexibility="
        + nodeTypeFlexibility
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "serverBinding="
        + serverBinding
        + ", "
        + "status="
        + status
        + ", "
        + "statusMessage="
        + statusMessage
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeTemplate) {
      NodeTemplate that = (NodeTemplate) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.nodeAffinityLabels, that.getNodeAffinityLabelsMap())
          && Objects.equals(this.nodeType, that.getNodeType())
          && Objects.equals(this.nodeTypeFlexibility, that.getNodeTypeFlexibility())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.serverBinding, that.getServerBinding())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.statusMessage, that.getStatusMessage());
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
        nodeAffinityLabels,
        nodeType,
        nodeTypeFlexibility,
        region,
        selfLink,
        serverBinding,
        status,
        statusMessage);
  }
}
