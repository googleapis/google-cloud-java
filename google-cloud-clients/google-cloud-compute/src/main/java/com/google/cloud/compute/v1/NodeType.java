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
  public List<String> getFieldMask() {
    return null;
  }

  public String getCpuPlatform() {
    return cpuPlatform;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  public String getDescription() {
    return description;
  }

  public Integer getGuestCpus() {
    return guestCpus;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public Integer getLocalSsdGb() {
    return localSsdGb;
  }

  public Integer getMemoryMb() {
    return memoryMb;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }

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

    public String getCpuPlatform() {
      return cpuPlatform;
    }

    public Builder setCpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Integer getGuestCpus() {
      return guestCpus;
    }

    public Builder setGuestCpus(Integer guestCpus) {
      this.guestCpus = guestCpus;
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

    public Integer getLocalSsdGb() {
      return localSsdGb;
    }

    public Builder setLocalSsdGb(Integer localSsdGb) {
      this.localSsdGb = localSsdGb;
      return this;
    }

    public Integer getMemoryMb() {
      return memoryMb;
    }

    public Builder setMemoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getZone() {
      return zone;
    }

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
