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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    this.status = status;
    this.statusMessage = statusMessage;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("nodeAffinityLabels")) {
      return nodeAffinityLabels;
    }
    if (fieldName.equals("nodeType")) {
      return nodeType;
    }
    if (fieldName.equals("nodeTypeFlexibility")) {
      return nodeTypeFlexibility;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("status")) {
      return status;
    }
    if (fieldName.equals("statusMessage")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getNodeAffinityLabelsMap() {
    return nodeAffinityLabels;
  }

  public String getNodeType() {
    return nodeType;
  }

  public NodeTemplateNodeTypeFlexibility getNodeTypeFlexibility() {
    return nodeTypeFlexibility;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getStatus() {
    return status;
  }

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
      this.status = source.status;
      this.statusMessage = source.statusMessage;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Map<String, String> getNodeAffinityLabelsMap() {
      return nodeAffinityLabels;
    }

    public Builder putAllNodeAffinityLabels(Map<String, String> nodeAffinityLabels) {
      this.nodeAffinityLabels = nodeAffinityLabels;
      return this;
    }

    public String getNodeType() {
      return nodeType;
    }

    public Builder setNodeType(String nodeType) {
      this.nodeType = nodeType;
      return this;
    }

    public NodeTemplateNodeTypeFlexibility getNodeTypeFlexibility() {
      return nodeTypeFlexibility;
    }

    public Builder setNodeTypeFlexibility(NodeTemplateNodeTypeFlexibility nodeTypeFlexibility) {
      this.nodeTypeFlexibility = nodeTypeFlexibility;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getStatusMessage() {
      return statusMessage;
    }

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
        status,
        statusMessage);
  }
}
