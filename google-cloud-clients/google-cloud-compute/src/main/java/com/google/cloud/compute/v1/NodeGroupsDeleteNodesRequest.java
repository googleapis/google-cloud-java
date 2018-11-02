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
public final class NodeGroupsDeleteNodesRequest implements ApiMessage {
  private final List<String> nodes;

  private NodeGroupsDeleteNodesRequest() {
    this.nodes = null;
  }

  private NodeGroupsDeleteNodesRequest(List<String> nodes) {
    this.nodes = nodes;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("nodes")) {
      return nodes;
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

  public List<String> getNodesList() {
    return nodes;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupsDeleteNodesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupsDeleteNodesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupsDeleteNodesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupsDeleteNodesRequest();
  }

  public static class Builder {
    private List<String> nodes;

    Builder() {}

    public Builder mergeFrom(NodeGroupsDeleteNodesRequest other) {
      if (other == NodeGroupsDeleteNodesRequest.getDefaultInstance()) return this;
      if (other.getNodesList() != null) {
        this.nodes = other.nodes;
      }
      return this;
    }

    Builder(NodeGroupsDeleteNodesRequest source) {
      this.nodes = source.nodes;
    }

    public List<String> getNodesList() {
      return nodes;
    }

    public Builder addAllNodes(List<String> nodes) {
      if (this.nodes == null) {
        this.nodes = new LinkedList<>();
      }
      this.nodes.addAll(nodes);
      return this;
    }

    public Builder addNodes(String nodes) {
      if (this.nodes == null) {
        this.nodes = new LinkedList<>();
      }
      this.nodes.add(nodes);
      return this;
    }

    public NodeGroupsDeleteNodesRequest build() {
      return new NodeGroupsDeleteNodesRequest(nodes);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNodes(this.nodes);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupsDeleteNodesRequest{" + "nodes=" + nodes + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupsDeleteNodesRequest) {
      NodeGroupsDeleteNodesRequest that = (NodeGroupsDeleteNodesRequest) o;
      return Objects.equals(this.nodes, that.getNodesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes);
  }
}
