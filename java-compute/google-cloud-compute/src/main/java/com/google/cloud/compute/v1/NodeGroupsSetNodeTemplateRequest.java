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
public final class NodeGroupsSetNodeTemplateRequest implements ApiMessage {
  private final String nodeTemplate;

  private NodeGroupsSetNodeTemplateRequest() {
    this.nodeTemplate = null;
  }

  private NodeGroupsSetNodeTemplateRequest(String nodeTemplate) {
    this.nodeTemplate = nodeTemplate;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("nodeTemplate".equals(fieldName)) {
      return nodeTemplate;
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

  public String getNodeTemplate() {
    return nodeTemplate;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeGroupsSetNodeTemplateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeGroupsSetNodeTemplateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeGroupsSetNodeTemplateRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeGroupsSetNodeTemplateRequest();
  }

  public static class Builder {
    private String nodeTemplate;

    Builder() {}

    public Builder mergeFrom(NodeGroupsSetNodeTemplateRequest other) {
      if (other == NodeGroupsSetNodeTemplateRequest.getDefaultInstance()) return this;
      if (other.getNodeTemplate() != null) {
        this.nodeTemplate = other.nodeTemplate;
      }
      return this;
    }

    Builder(NodeGroupsSetNodeTemplateRequest source) {
      this.nodeTemplate = source.nodeTemplate;
    }

    public String getNodeTemplate() {
      return nodeTemplate;
    }

    public Builder setNodeTemplate(String nodeTemplate) {
      this.nodeTemplate = nodeTemplate;
      return this;
    }

    public NodeGroupsSetNodeTemplateRequest build() {
      return new NodeGroupsSetNodeTemplateRequest(nodeTemplate);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setNodeTemplate(this.nodeTemplate);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeGroupsSetNodeTemplateRequest{" + "nodeTemplate=" + nodeTemplate + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeGroupsSetNodeTemplateRequest) {
      NodeGroupsSetNodeTemplateRequest that = (NodeGroupsSetNodeTemplateRequest) o;
      return Objects.equals(this.nodeTemplate, that.getNodeTemplate());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeTemplate);
  }
}
