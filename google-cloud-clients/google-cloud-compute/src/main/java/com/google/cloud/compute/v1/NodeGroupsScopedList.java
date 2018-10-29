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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class NodeGroupsScopedList implements ApiMessage {
  private final List<NodeGroup> nodeGroups;
  private final Warning warning;

  private NodeGroupsScopedList() {
    this.nodeGroups = null;
    this.warning = null;
  }

  private NodeGroupsScopedList(List<NodeGroup> nodeGroups, Warning warning) {
    this.nodeGroups = nodeGroups;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("nodeGroups")) {
      return nodeGroups;
    }
    if (fieldName.equals("warning")) {
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

  public List<NodeGroup> getNodeGroupsList() {
    return nodeGroups;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupsScopedList();
  }

  public static class Builder {
    private List<NodeGroup> nodeGroups;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(NodeGroupsScopedList other) {
      if (other == NodeGroupsScopedList.getDefaultInstance()) return this;
      if (other.getNodeGroupsList() != null) {
        this.nodeGroups = other.nodeGroups;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(NodeGroupsScopedList source) {
      this.nodeGroups = source.nodeGroups;
      this.warning = source.warning;
    }

    public List<NodeGroup> getNodeGroupsList() {
      return nodeGroups;
    }

    public Builder addAllNodeGroups(List<NodeGroup> nodeGroups) {
      if (this.nodeGroups == null) {
        this.nodeGroups = new LinkedList<>();
      }
      this.nodeGroups.addAll(nodeGroups);
      return this;
    }

    public Builder addNodeGroups(NodeGroup nodeGroups) {
      if (this.nodeGroups == null) {
        this.nodeGroups = new LinkedList<>();
      }
      this.nodeGroups.add(nodeGroups);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public NodeGroupsScopedList build() {

      return new NodeGroupsScopedList(nodeGroups, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNodeGroups(this.nodeGroups);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupsScopedList{" + "nodeGroups=" + nodeGroups + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupsScopedList) {
      NodeGroupsScopedList that = (NodeGroupsScopedList) o;
      return Objects.equals(this.nodeGroups, that.getNodeGroupsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeGroups, warning);
  }
}
