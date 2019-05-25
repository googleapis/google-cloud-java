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
/**
 * A TargetInstance resource. This resource defines an endpoint instance that terminates traffic of
 * certain protocols. (== resource_for beta.targetInstances ==) (== resource_for v1.targetInstances
 * ==)
 */
public final class TargetInstance implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String instance;
  private final String kind;
  private final String name;
  private final String natPolicy;
  private final String selfLink;
  private final String zone;

  private TargetInstance() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.instance = null;
    this.kind = null;
    this.name = null;
    this.natPolicy = null;
    this.selfLink = null;
    this.zone = null;
  }

  private TargetInstance(
      String creationTimestamp,
      String description,
      String id,
      String instance,
      String kind,
      String name,
      String natPolicy,
      String selfLink,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.instance = instance;
    this.kind = kind;
    this.name = name;
    this.natPolicy = natPolicy;
    this.selfLink = selfLink;
    this.zone = zone;
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
    if ("instance".equals(fieldName)) {
      return instance;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("natPolicy".equals(fieldName)) {
      return natPolicy;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * A URL to the virtual machine instance that handles traffic for this target instance. When
   * creating a target instance, you can provide the fully-qualified URL or a valid partial URL to
   * the desired virtual machine. For example, the following are all valid URLs: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
   * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
   */
  public String getInstance() {
    return instance;
  }

  /** [Output Only] The type of the resource. Always compute#targetInstance for target instances. */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * NAT option controlling how IPs are NAT'ed to the instance. Currently only NO_NAT (default
   * value) is supported.
   */
  public String getNatPolicy() {
    return natPolicy;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] URL of the zone where the target instance resides. You must specify this field as
   * part of the HTTP request URL. It is not settable as a field in the request body.
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetInstance prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetInstance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetInstance DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetInstance();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String instance;
    private String kind;
    private String name;
    private String natPolicy;
    private String selfLink;
    private String zone;

    Builder() {}

    public Builder mergeFrom(TargetInstance other) {
      if (other == TargetInstance.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNatPolicy() != null) {
        this.natPolicy = other.natPolicy;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(TargetInstance source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.instance = source.instance;
      this.kind = source.kind;
      this.name = source.name;
      this.natPolicy = source.natPolicy;
      this.selfLink = source.selfLink;
      this.zone = source.zone;
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

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
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
     * A URL to the virtual machine instance that handles traffic for this target instance. When
     * creating a target instance, you can provide the fully-qualified URL or a valid partial URL to
     * the desired virtual machine. For example, the following are all valid URLs: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
     */
    public String getInstance() {
      return instance;
    }

    /**
     * A URL to the virtual machine instance that handles traffic for this target instance. When
     * creating a target instance, you can provide the fully-qualified URL or a valid partial URL to
     * the desired virtual machine. For example, the following are all valid URLs: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance -
     * projects/project/zones/zone/instances/instance - zones/zone/instances/instance
     */
    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    /**
     * [Output Only] The type of the resource. Always compute#targetInstance for target instances.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] The type of the resource. Always compute#targetInstance for target instances.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * NAT option controlling how IPs are NAT'ed to the instance. Currently only NO_NAT (default
     * value) is supported.
     */
    public String getNatPolicy() {
      return natPolicy;
    }

    /**
     * NAT option controlling how IPs are NAT'ed to the instance. Currently only NO_NAT (default
     * value) is supported.
     */
    public Builder setNatPolicy(String natPolicy) {
      this.natPolicy = natPolicy;
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

    /**
     * [Output Only] URL of the zone where the target instance resides. You must specify this field
     * as part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] URL of the zone where the target instance resides. You must specify this field
     * as part of the HTTP request URL. It is not settable as a field in the request body.
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public TargetInstance build() {

      return new TargetInstance(
          creationTimestamp, description, id, instance, kind, name, natPolicy, selfLink, zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setInstance(this.instance);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNatPolicy(this.natPolicy);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetInstance{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "instance="
        + instance
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "natPolicy="
        + natPolicy
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
    if (o instanceof TargetInstance) {
      TargetInstance that = (TargetInstance) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.natPolicy, that.getNatPolicy())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp, description, id, instance, kind, name, natPolicy, selfLink, zone);
  }
}
