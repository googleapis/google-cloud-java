/*
 * Copyright 2020 Google LLC
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
public final class NodeGroupAutoscalingPolicy implements ApiMessage {
  private final Integer maxNodes;
  private final Integer minNodes;
  private final String mode;

  private NodeGroupAutoscalingPolicy() {
    this.maxNodes = null;
    this.minNodes = null;
    this.mode = null;
  }

  private NodeGroupAutoscalingPolicy(Integer maxNodes, Integer minNodes, String mode) {
    this.maxNodes = maxNodes;
    this.minNodes = minNodes;
    this.mode = mode;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("maxNodes".equals(fieldName)) {
      return maxNodes;
    }
    if ("minNodes".equals(fieldName)) {
      return minNodes;
    }
    if ("mode".equals(fieldName)) {
      return mode;
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

  /** The maximum number of nodes that the group should have. */
  public Integer getMaxNodes() {
    return maxNodes;
  }

  /** The minimum number of nodes that the group should have. */
  public Integer getMinNodes() {
    return minNodes;
  }

  /** The autoscaling mode. */
  public String getMode() {
    return mode;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupAutoscalingPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupAutoscalingPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupAutoscalingPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupAutoscalingPolicy();
  }

  public static class Builder {
    private Integer maxNodes;
    private Integer minNodes;
    private String mode;

    Builder() {}

    public Builder mergeFrom(NodeGroupAutoscalingPolicy other) {
      if (other == NodeGroupAutoscalingPolicy.getDefaultInstance()) return this;
      if (other.getMaxNodes() != null) {
        this.maxNodes = other.maxNodes;
      }
      if (other.getMinNodes() != null) {
        this.minNodes = other.minNodes;
      }
      if (other.getMode() != null) {
        this.mode = other.mode;
      }
      return this;
    }

    Builder(NodeGroupAutoscalingPolicy source) {
      this.maxNodes = source.maxNodes;
      this.minNodes = source.minNodes;
      this.mode = source.mode;
    }

    /** The maximum number of nodes that the group should have. */
    public Integer getMaxNodes() {
      return maxNodes;
    }

    /** The maximum number of nodes that the group should have. */
    public Builder setMaxNodes(Integer maxNodes) {
      this.maxNodes = maxNodes;
      return this;
    }

    /** The minimum number of nodes that the group should have. */
    public Integer getMinNodes() {
      return minNodes;
    }

    /** The minimum number of nodes that the group should have. */
    public Builder setMinNodes(Integer minNodes) {
      this.minNodes = minNodes;
      return this;
    }

    /** The autoscaling mode. */
    public String getMode() {
      return mode;
    }

    /** The autoscaling mode. */
    public Builder setMode(String mode) {
      this.mode = mode;
      return this;
    }

    public NodeGroupAutoscalingPolicy build() {

      return new NodeGroupAutoscalingPolicy(maxNodes, minNodes, mode);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMaxNodes(this.maxNodes);
      newBuilder.setMinNodes(this.minNodes);
      newBuilder.setMode(this.mode);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupAutoscalingPolicy{"
        + "maxNodes="
        + maxNodes
        + ", "
        + "minNodes="
        + minNodes
        + ", "
        + "mode="
        + mode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupAutoscalingPolicy) {
      NodeGroupAutoscalingPolicy that = (NodeGroupAutoscalingPolicy) o;
      return Objects.equals(this.maxNodes, that.getMaxNodes())
          && Objects.equals(this.minNodes, that.getMinNodes())
          && Objects.equals(this.mode, that.getMode());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxNodes, minNodes, mode);
  }
}
