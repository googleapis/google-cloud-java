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
public final class NodeTypesScopedList implements ApiMessage {
  private final List<NodeType> nodeTypes;
  private final Warning warning;

  private NodeTypesScopedList() {
    this.nodeTypes = null;
    this.warning = null;
  }

  private NodeTypesScopedList(List<NodeType> nodeTypes, Warning warning) {
    this.nodeTypes = nodeTypes;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("nodeTypes".equals(fieldName)) {
      return nodeTypes;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  public List<NodeType> getNodeTypesList() {
    return nodeTypes;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeTypesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeTypesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeTypesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeTypesScopedList();
  }

  public static class Builder {
    private List<NodeType> nodeTypes;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(NodeTypesScopedList other) {
      if (other == NodeTypesScopedList.getDefaultInstance()) return this;
      if (other.getNodeTypesList() != null) {
        this.nodeTypes = other.nodeTypes;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(NodeTypesScopedList source) {
      this.nodeTypes = source.nodeTypes;
      this.warning = source.warning;
    }

    public List<NodeType> getNodeTypesList() {
      return nodeTypes;
    }

    public Builder addAllNodeTypes(List<NodeType> nodeTypes) {
      if (this.nodeTypes == null) {
        this.nodeTypes = new LinkedList<>();
      }
      this.nodeTypes.addAll(nodeTypes);
      return this;
    }

    public Builder addNodeTypes(NodeType nodeTypes) {
      if (this.nodeTypes == null) {
        this.nodeTypes = new LinkedList<>();
      }
      this.nodeTypes.add(nodeTypes);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public NodeTypesScopedList build() {

      return new NodeTypesScopedList(nodeTypes, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNodeTypes(this.nodeTypes);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeTypesScopedList{" + "nodeTypes=" + nodeTypes + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeTypesScopedList) {
      NodeTypesScopedList that = (NodeTypesScopedList) o;
      return Objects.equals(this.nodeTypes, that.getNodeTypesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeTypes, warning);
  }
}
