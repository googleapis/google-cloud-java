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
public final class NodeTemplatesScopedList implements ApiMessage {
  private final List<NodeTemplate> nodeTemplates;
  private final Warning warning;

  private NodeTemplatesScopedList() {
    this.nodeTemplates = null;
    this.warning = null;
  }

  private NodeTemplatesScopedList(List<NodeTemplate> nodeTemplates, Warning warning) {
    this.nodeTemplates = nodeTemplates;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("nodeTemplates".equals(fieldName)) {
      return nodeTemplates;
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

  public List<NodeTemplate> getNodeTemplatesList() {
    return nodeTemplates;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeTemplatesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeTemplatesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeTemplatesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeTemplatesScopedList();
  }

  public static class Builder {
    private List<NodeTemplate> nodeTemplates;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(NodeTemplatesScopedList other) {
      if (other == NodeTemplatesScopedList.getDefaultInstance()) return this;
      if (other.getNodeTemplatesList() != null) {
        this.nodeTemplates = other.nodeTemplates;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(NodeTemplatesScopedList source) {
      this.nodeTemplates = source.nodeTemplates;
      this.warning = source.warning;
    }

    public List<NodeTemplate> getNodeTemplatesList() {
      return nodeTemplates;
    }

    public Builder addAllNodeTemplates(List<NodeTemplate> nodeTemplates) {
      if (this.nodeTemplates == null) {
        this.nodeTemplates = new LinkedList<>();
      }
      this.nodeTemplates.addAll(nodeTemplates);
      return this;
    }

    public Builder addNodeTemplates(NodeTemplate nodeTemplates) {
      if (this.nodeTemplates == null) {
        this.nodeTemplates = new LinkedList<>();
      }
      this.nodeTemplates.add(nodeTemplates);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public NodeTemplatesScopedList build() {

      return new NodeTemplatesScopedList(nodeTemplates, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNodeTemplates(this.nodeTemplates);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeTemplatesScopedList{"
        + "nodeTemplates="
        + nodeTemplates
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeTemplatesScopedList) {
      NodeTemplatesScopedList that = (NodeTemplatesScopedList) o;
      return Objects.equals(this.nodeTemplates, that.getNodeTemplatesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeTemplates, warning);
  }
}
