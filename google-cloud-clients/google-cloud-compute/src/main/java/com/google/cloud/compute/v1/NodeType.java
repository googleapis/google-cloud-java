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
/** A Node Type resource. */
public final class NodeType implements ApiMessage {
  private final String cpuPlatform;
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final Integer guestCpus;
  private final String id;
  private final String kind;
  private final Integer localSsdGb;
  private final Integer memoryMb;
  private final String name;
  private final String selfLink;
  private final String zone;

  private NodeType() {
    this.cpuPlatform = null;
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.guestCpus = null;
    this.id = null;
    this.kind = null;
    this.localSsdGb = null;
    this.memoryMb = null;
    this.name = null;
    this.selfLink = null;
    this.zone = null;
  }

  private NodeType(
      String cpuPlatform,
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      Integer guestCpus,
      String id,
      String kind,
      Integer localSsdGb,
      Integer memoryMb,
      String name,
      String selfLink,
      String zone) {
    this.cpuPlatform = cpuPlatform;
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.guestCpus = guestCpus;
    this.id = id;
    this.kind = kind;
    this.localSsdGb = localSsdGb;
    this.memoryMb = memoryMb;
    this.name = name;
    this.selfLink = selfLink;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("cpuPlatform".equals(fieldName)) {
      return cpuPlatform;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("guestCpus".equals(fieldName)) {
      return guestCpus;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("localSsdGb".equals(fieldName)) {
      return localSsdGb;
    }
    if ("memoryMb".equals(fieldName)) {
      return memoryMb;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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

  /** [Output Only] The CPU platform used by this node type. */
  public String getCpuPlatform() {
    return cpuPlatform;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] The deprecation status associated with this node type. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /** [Output Only] An optional textual description of the resource. */
  public String getDescription() {
    return description;
  }

  /** [Output Only] The number of virtual CPUs that are available to the node type. */
  public Integer getGuestCpus() {
    return guestCpus;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] The type of the resource. Always compute#nodeType for node types. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Local SSD available to the node type, defined in GB. */
  public Integer getLocalSsdGb() {
    return localSsdGb;
  }

  /** [Output Only] The amount of physical memory available to the node type, defined in MB. */
  public Integer getMemoryMb() {
    return memoryMb;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] The name of the zone where the node type resides, such as us-central1-a. */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NodeType prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NodeType getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NodeType DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NodeType();
  }

  public static class Builder {
    private String cpuPlatform;
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private Integer guestCpus;
    private String id;
    private String kind;
    private Integer localSsdGb;
    private Integer memoryMb;
    private String name;
    private String selfLink;
    private String zone;

    Builder() {}

    public Builder mergeFrom(NodeType other) {
      if (other == NodeType.getDefaultInstance()) return this;
      if (other.getCpuPlatform() != null) {
        this.cpuPlatform = other.cpuPlatform;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGuestCpus() != null) {
        this.guestCpus = other.guestCpus;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLocalSsdGb() != null) {
        this.localSsdGb = other.localSsdGb;
      }
      if (other.getMemoryMb() != null) {
        this.memoryMb = other.memoryMb;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(NodeType source) {
      this.cpuPlatform = source.cpuPlatform;
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.guestCpus = source.guestCpus;
      this.id = source.id;
      this.kind = source.kind;
      this.localSsdGb = source.localSsdGb;
      this.memoryMb = source.memoryMb;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.zone = source.zone;
    }

    /** [Output Only] The CPU platform used by this node type. */
    public String getCpuPlatform() {
      return cpuPlatform;
    }

    /** [Output Only] The CPU platform used by this node type. */
    public Builder setCpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
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

    /** [Output Only] The deprecation status associated with this node type. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this node type. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /** [Output Only] An optional textual description of the resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] An optional textual description of the resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** [Output Only] The number of virtual CPUs that are available to the node type. */
    public Integer getGuestCpus() {
      return guestCpus;
    }

    /** [Output Only] The number of virtual CPUs that are available to the node type. */
    public Builder setGuestCpus(Integer guestCpus) {
      this.guestCpus = guestCpus;
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

    /** [Output Only] The type of the resource. Always compute#nodeType for node types. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] The type of the resource. Always compute#nodeType for node types. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Local SSD available to the node type, defined in GB. */
    public Integer getLocalSsdGb() {
      return localSsdGb;
    }

    /** [Output Only] Local SSD available to the node type, defined in GB. */
    public Builder setLocalSsdGb(Integer localSsdGb) {
      this.localSsdGb = localSsdGb;
      return this;
    }

    /** [Output Only] The amount of physical memory available to the node type, defined in MB. */
    public Integer getMemoryMb() {
      return memoryMb;
    }

    /** [Output Only] The amount of physical memory available to the node type, defined in MB. */
    public Builder setMemoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    /** [Output Only] Name of the resource. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the resource. */
    public Builder setName(String name) {
      this.name = name;
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

    /** [Output Only] The name of the zone where the node type resides, such as us-central1-a. */
    public String getZone() {
      return zone;
    }

    /** [Output Only] The name of the zone where the node type resides, such as us-central1-a. */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public NodeType build() {

      return new NodeType(
          cpuPlatform,
          creationTimestamp,
          deprecated,
          description,
          guestCpus,
          id,
          kind,
          localSsdGb,
          memoryMb,
          name,
          selfLink,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCpuPlatform(this.cpuPlatform);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setGuestCpus(this.guestCpus);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLocalSsdGb(this.localSsdGb);
      newBuilder.setMemoryMb(this.memoryMb);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NodeType{"
        + "cpuPlatform="
        + cpuPlatform
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "description="
        + description
        + ", "
        + "guestCpus="
        + guestCpus
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "localSsdGb="
        + localSsdGb
        + ", "
        + "memoryMb="
        + memoryMb
        + ", "
        + "name="
        + name
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeType) {
      NodeType that = (NodeType) o;
      return Objects.equals(this.cpuPlatform, that.getCpuPlatform())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.guestCpus, that.getGuestCpus())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.localSsdGb, that.getLocalSsdGb())
          && Objects.equals(this.memoryMb, that.getMemoryMb())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cpuPlatform,
        creationTimestamp,
        deprecated,
        description,
        guestCpus,
        id,
        kind,
        localSsdGb,
        memoryMb,
        name,
        selfLink,
        zone);
  }
}
