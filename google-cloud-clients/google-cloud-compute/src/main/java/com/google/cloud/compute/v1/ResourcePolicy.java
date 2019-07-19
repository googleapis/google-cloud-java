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
public final class ResourcePolicy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final ResourcePolicySnapshotSchedulePolicy snapshotSchedulePolicy;
  private final String status;

  private ResourcePolicy() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.snapshotSchedulePolicy = null;
    this.status = null;
  }

  private ResourcePolicy(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String region,
      String selfLink,
      ResourcePolicySnapshotSchedulePolicy snapshotSchedulePolicy,
      String status) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.snapshotSchedulePolicy = snapshotSchedulePolicy;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("snapshotSchedulePolicy".equals(fieldName)) {
      return snapshotSchedulePolicy;
    }
    if ("status".equals(fieldName)) {
      return status;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#resource_policies for resource policies. */
  public String getKind() {
    return kind;
  }

  /**
   * The name of the resource, provided by the client when initially creating the resource. The
   * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
   * must be 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined fully-qualified URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** Resource policy for persistent disks for creating snapshots. */
  public ResourcePolicySnapshotSchedulePolicy getSnapshotSchedulePolicy() {
    return snapshotSchedulePolicy;
  }

  /** [Output Only] The status of resource policy creation. */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private ResourcePolicySnapshotSchedulePolicy snapshotSchedulePolicy;
    private String status;

    Builder() {}

    public Builder mergeFrom(ResourcePolicy other) {
      if (other == ResourcePolicy.getDefaultInstance()) return this;
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
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSnapshotSchedulePolicy() != null) {
        this.snapshotSchedulePolicy = other.snapshotSchedulePolicy;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(ResourcePolicy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.snapshotSchedulePolicy = source.snapshotSchedulePolicy;
      this.status = source.status;
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

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
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

    /**
     * [Output Only] Type of the resource. Always compute#resource_policies for resource policies.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#resource_policies for resource policies.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined fully-qualified URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** Resource policy for persistent disks for creating snapshots. */
    public ResourcePolicySnapshotSchedulePolicy getSnapshotSchedulePolicy() {
      return snapshotSchedulePolicy;
    }

    /** Resource policy for persistent disks for creating snapshots. */
    public Builder setSnapshotSchedulePolicy(
        ResourcePolicySnapshotSchedulePolicy snapshotSchedulePolicy) {
      this.snapshotSchedulePolicy = snapshotSchedulePolicy;
      return this;
    }

    /** [Output Only] The status of resource policy creation. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] The status of resource policy creation. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public ResourcePolicy build() {

      return new ResourcePolicy(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          region,
          selfLink,
          snapshotSchedulePolicy,
          status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSnapshotSchedulePolicy(this.snapshotSchedulePolicy);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicy{"
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
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "snapshotSchedulePolicy="
        + snapshotSchedulePolicy
        + ", "
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicy) {
      ResourcePolicy that = (ResourcePolicy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.snapshotSchedulePolicy, that.getSnapshotSchedulePolicy())
          && Objects.equals(this.status, that.getStatus());
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
        region,
        selfLink,
        snapshotSchedulePolicy,
        status);
  }
}
