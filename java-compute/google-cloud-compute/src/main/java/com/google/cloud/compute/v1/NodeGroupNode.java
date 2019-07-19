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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class NodeGroupNode implements ApiMessage {
  private final List<String> instances;
  private final String name;
  private final String nodeType;
  private final ServerBinding serverBinding;
  private final String status;

  private NodeGroupNode() {
    this.instances = null;
    this.name = null;
    this.nodeType = null;
    this.serverBinding = null;
    this.status = null;
  }

  private NodeGroupNode(
      List<String> instances,
      String name,
      String nodeType,
      ServerBinding serverBinding,
      String status) {
    this.instances = instances;
    this.name = name;
    this.nodeType = nodeType;
    this.serverBinding = serverBinding;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instances".equals(fieldName)) {
      return instances;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("nodeType".equals(fieldName)) {
      return nodeType;
    }
    if ("serverBinding".equals(fieldName)) {
      return serverBinding;
    }
    if ("status".equals(fieldName)) {
      return status;
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

  /** Instances scheduled on this node. */
  public List<String> getInstancesList() {
    return instances;
  }

  /** The name of the node. */
  public String getName() {
    return name;
  }

  /** The type of this node. */
  public String getNodeType() {
    return nodeType;
  }

  /** Binding properties for the physical server. */
  public ServerBinding getServerBinding() {
    return serverBinding;
  }

  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupNode prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupNode DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupNode();
  }

  public static class Builder {
    private List<String> instances;
    private String name;
    private String nodeType;
    private ServerBinding serverBinding;
    private String status;

    Builder() {}

    public Builder mergeFrom(NodeGroupNode other) {
      if (other == NodeGroupNode.getDefaultInstance()) return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNodeType() != null) {
        this.nodeType = other.nodeType;
      }
      if (other.getServerBinding() != null) {
        this.serverBinding = other.serverBinding;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(NodeGroupNode source) {
      this.instances = source.instances;
      this.name = source.name;
      this.nodeType = source.nodeType;
      this.serverBinding = source.serverBinding;
      this.status = source.status;
    }

    /** Instances scheduled on this node. */
    public List<String> getInstancesList() {
      return instances;
    }

    /** Instances scheduled on this node. */
    public Builder addAllInstances(List<String> instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.addAll(instances);
      return this;
    }

    /** Instances scheduled on this node. */
    public Builder addInstances(String instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.add(instances);
      return this;
    }

    /** The name of the node. */
    public String getName() {
      return name;
    }

    /** The name of the node. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** The type of this node. */
    public String getNodeType() {
      return nodeType;
    }

    /** The type of this node. */
    public Builder setNodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    /** Binding properties for the physical server. */
    public ServerBinding getServerBinding() {
      return serverBinding;
    }

    /** Binding properties for the physical server. */
    public Builder setServerBinding(ServerBinding serverBinding) {
      this.serverBinding = serverBinding;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public NodeGroupNode build() {

      return new NodeGroupNode(instances, name, nodeType, serverBinding, status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      newBuilder.setName(this.name);
      newBuilder.setNodeType(this.nodeType);
      newBuilder.setServerBinding(this.serverBinding);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupNode{"
        + "instances="
        + instances
        + ", "
        + "name="
        + name
        + ", "
        + "nodeType="
        + nodeType
        + ", "
        + "serverBinding="
        + serverBinding
        + ", "
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupNode) {
      NodeGroupNode that = (NodeGroupNode) o;
      return Objects.equals(this.instances, that.getInstancesList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.nodeType, that.getNodeType())
          && Objects.equals(this.serverBinding, that.getServerBinding())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances, name, nodeType, serverBinding, status);
  }
}
