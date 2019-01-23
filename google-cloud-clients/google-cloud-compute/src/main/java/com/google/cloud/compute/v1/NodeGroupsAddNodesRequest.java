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
public final class NodeGroupsAddNodesRequest implements ApiMessage {
  private final Integer additionalNodeCount;

  private NodeGroupsAddNodesRequest() {
    this.additionalNodeCount = null;
  }

  private NodeGroupsAddNodesRequest(Integer additionalNodeCount) {
    this.additionalNodeCount = additionalNodeCount;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("additionalNodeCount".equals(fieldName)) {
      return additionalNodeCount;
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

  public Integer getAdditionalNodeCount() {
    return additionalNodeCount;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupsAddNodesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupsAddNodesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupsAddNodesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupsAddNodesRequest();
  }

  public static class Builder {
    private Integer additionalNodeCount;

    Builder() {}

    public Builder mergeFrom(NodeGroupsAddNodesRequest other) {
      if (other == NodeGroupsAddNodesRequest.getDefaultInstance()) return this;
      if (other.getAdditionalNodeCount() != null) {
        this.additionalNodeCount = other.additionalNodeCount;
      }
      return this;
    }

    Builder(NodeGroupsAddNodesRequest source) {
      this.additionalNodeCount = source.additionalNodeCount;
    }

    public Integer getAdditionalNodeCount() {
      return additionalNodeCount;
    }

    public Builder setAdditionalNodeCount(Integer additionalNodeCount) {
      this.additionalNodeCount = additionalNodeCount;
      return this;
    }

    public NodeGroupsAddNodesRequest build() {
      return new NodeGroupsAddNodesRequest(additionalNodeCount);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdditionalNodeCount(this.additionalNodeCount);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupsAddNodesRequest{" + "additionalNodeCount=" + additionalNodeCount + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupsAddNodesRequest) {
      NodeGroupsAddNodesRequest that = (NodeGroupsAddNodesRequest) o;
      return Objects.equals(this.additionalNodeCount, that.getAdditionalNodeCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalNodeCount);
  }
}
