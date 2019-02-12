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
/**
 * A TargetPool resource. This resource defines a pool of instances, an associated HttpHealthCheck
 * resource, and the fallback target pool. (== resource_for beta.targetPools ==) (== resource_for
 * v1.targetPools ==)
 */
public final class TargetPool implements ApiMessage {
  private final String backupPool;
  private final String creationTimestamp;
  private final String description;
  private final Float failoverRatio;
  private final List<String> healthChecks;
  private final String id;
  private final List<String> instances;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String sessionAffinity;

  private TargetPool() {
    this.backupPool = null;
    this.creationTimestamp = null;
    this.description = null;
    this.failoverRatio = null;
    this.healthChecks = null;
    this.id = null;
    this.instances = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.sessionAffinity = null;
  }

  private TargetPool(
      String backupPool,
      String creationTimestamp,
      String description,
      Float failoverRatio,
      List<String> healthChecks,
      String id,
      List<String> instances,
      String kind,
      String name,
      String region,
      String selfLink,
      String sessionAffinity) {
    this.backupPool = backupPool;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.failoverRatio = failoverRatio;
    this.healthChecks = healthChecks;
    this.id = id;
    this.instances = instances;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.sessionAffinity = sessionAffinity;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("backupPool".equals(fieldName)) {
      return backupPool;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("failoverRatio".equals(fieldName)) {
      return failoverRatio;
    }
    if ("healthChecks".equals(fieldName)) {
      return healthChecks;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("instances".equals(fieldName)) {
      return instances;
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
    if ("sessionAffinity".equals(fieldName)) {
      return sessionAffinity;
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

  /**
   * This field is applicable only when the containing target pool is serving a forwarding rule as
   * the primary pool, and its failoverRatio field is properly set to a value between [0, 1].
   *
   * <p>backupPool and failoverRatio together define the fallback behavior of the primary target
   * pool: if the ratio of the healthy instances in the primary pool is at or below failoverRatio,
   * traffic arriving at the load-balanced IP will be directed to the backup pool.
   *
   * <p>In case where failoverRatio and backupPool are not set, or all the instances in the backup
   * pool are unhealthy, the traffic will be directed back to the primary pool in the "force" mode,
   * where traffic will be spread to the healthy instances with the best effort, or to all instances
   * when no instance is healthy.
   */
  public String getBackupPool() {
    return backupPool;
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
   * This field is applicable only when the containing target pool is serving a forwarding rule as
   * the primary pool (i.e., not as a backup pool to some other target pool). The value of the field
   * must be in [0, 1].
   *
   * <p>If set, backupPool must also be set. They together define the fallback behavior of the
   * primary target pool: if the ratio of the healthy instances in the primary pool is at or below
   * this number, traffic arriving at the load-balanced IP will be directed to the backup pool.
   *
   * <p>In case where failoverRatio is not set or all the instances in the backup pool are
   * unhealthy, the traffic will be directed back to the primary pool in the "force" mode, where
   * traffic will be spread to the healthy instances with the best effort, or to all instances when
   * no instance is healthy.
   */
  public Float getFailoverRatio() {
    return failoverRatio;
  }

  /**
   * The URL of the HttpHealthCheck resource. A member instance in this pool is considered healthy
   * if and only if the health checks pass. An empty list means all member instances will be
   * considered healthy at all times. Only HttpHealthChecks are supported. Only one health check may
   * be specified.
   */
  public List<String> getHealthChecksList() {
    return healthChecks;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * A list of resource URLs to the virtual machine instances serving this pool. They must live in
   * zones contained in the same region as this pool.
   */
  public List<String> getInstancesList() {
    return instances;
  }

  /** [Output Only] Type of the resource. Always compute#targetPool for target pools. */
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

  /** [Output Only] URL of the region where the target pool resides. */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Session affinity option, must be one of the following values: NONE: Connections from the same
   * client IP may go to any instance in the pool. CLIENT_IP: Connections from the same client IP
   * will go to the same instance in the pool while that instance remains healthy. CLIENT_IP_PROTO:
   * Connections from the same client IP with the same IP protocol will go to the same instance in
   * the pool while that instance remains healthy.
   */
  public String getSessionAffinity() {
    return sessionAffinity;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetPool prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetPool getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetPool DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetPool();
  }

  public static class Builder {
    private String backupPool;
    private String creationTimestamp;
    private String description;
    private Float failoverRatio;
    private List<String> healthChecks;
    private String id;
    private List<String> instances;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String sessionAffinity;

    Builder() {}

    public Builder mergeFrom(TargetPool other) {
      if (other == TargetPool.getDefaultInstance()) return this;
      if (other.getBackupPool() != null) {
        this.backupPool = other.backupPool;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFailoverRatio() != null) {
        this.failoverRatio = other.failoverRatio;
      }
      if (other.getHealthChecksList() != null) {
        this.healthChecks = other.healthChecks;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
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
      if (other.getSessionAffinity() != null) {
        this.sessionAffinity = other.sessionAffinity;
      }
      return this;
    }

    Builder(TargetPool source) {
      this.backupPool = source.backupPool;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.failoverRatio = source.failoverRatio;
      this.healthChecks = source.healthChecks;
      this.id = source.id;
      this.instances = source.instances;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.sessionAffinity = source.sessionAffinity;
    }

    /**
     * This field is applicable only when the containing target pool is serving a forwarding rule as
     * the primary pool, and its failoverRatio field is properly set to a value between [0, 1].
     *
     * <p>backupPool and failoverRatio together define the fallback behavior of the primary target
     * pool: if the ratio of the healthy instances in the primary pool is at or below failoverRatio,
     * traffic arriving at the load-balanced IP will be directed to the backup pool.
     *
     * <p>In case where failoverRatio and backupPool are not set, or all the instances in the backup
     * pool are unhealthy, the traffic will be directed back to the primary pool in the "force"
     * mode, where traffic will be spread to the healthy instances with the best effort, or to all
     * instances when no instance is healthy.
     */
    public String getBackupPool() {
      return backupPool;
    }

    /**
     * This field is applicable only when the containing target pool is serving a forwarding rule as
     * the primary pool, and its failoverRatio field is properly set to a value between [0, 1].
     *
     * <p>backupPool and failoverRatio together define the fallback behavior of the primary target
     * pool: if the ratio of the healthy instances in the primary pool is at or below failoverRatio,
     * traffic arriving at the load-balanced IP will be directed to the backup pool.
     *
     * <p>In case where failoverRatio and backupPool are not set, or all the instances in the backup
     * pool are unhealthy, the traffic will be directed back to the primary pool in the "force"
     * mode, where traffic will be spread to the healthy instances with the best effort, or to all
     * instances when no instance is healthy.
     */
    public Builder setBackupPool(String backupPool) {
      this.backupPool = backupPool;
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
     * This field is applicable only when the containing target pool is serving a forwarding rule as
     * the primary pool (i.e., not as a backup pool to some other target pool). The value of the
     * field must be in [0, 1].
     *
     * <p>If set, backupPool must also be set. They together define the fallback behavior of the
     * primary target pool: if the ratio of the healthy instances in the primary pool is at or below
     * this number, traffic arriving at the load-balanced IP will be directed to the backup pool.
     *
     * <p>In case where failoverRatio is not set or all the instances in the backup pool are
     * unhealthy, the traffic will be directed back to the primary pool in the "force" mode, where
     * traffic will be spread to the healthy instances with the best effort, or to all instances
     * when no instance is healthy.
     */
    public Float getFailoverRatio() {
      return failoverRatio;
    }

    /**
     * This field is applicable only when the containing target pool is serving a forwarding rule as
     * the primary pool (i.e., not as a backup pool to some other target pool). The value of the
     * field must be in [0, 1].
     *
     * <p>If set, backupPool must also be set. They together define the fallback behavior of the
     * primary target pool: if the ratio of the healthy instances in the primary pool is at or below
     * this number, traffic arriving at the load-balanced IP will be directed to the backup pool.
     *
     * <p>In case where failoverRatio is not set or all the instances in the backup pool are
     * unhealthy, the traffic will be directed back to the primary pool in the "force" mode, where
     * traffic will be spread to the healthy instances with the best effort, or to all instances
     * when no instance is healthy.
     */
    public Builder setFailoverRatio(Float failoverRatio) {
      this.failoverRatio = failoverRatio;
      return this;
    }

    /**
     * The URL of the HttpHealthCheck resource. A member instance in this pool is considered healthy
     * if and only if the health checks pass. An empty list means all member instances will be
     * considered healthy at all times. Only HttpHealthChecks are supported. Only one health check
     * may be specified.
     */
    public List<String> getHealthChecksList() {
      return healthChecks;
    }

    /**
     * The URL of the HttpHealthCheck resource. A member instance in this pool is considered healthy
     * if and only if the health checks pass. An empty list means all member instances will be
     * considered healthy at all times. Only HttpHealthChecks are supported. Only one health check
     * may be specified.
     */
    public Builder addAllHealthChecks(List<String> healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.addAll(healthChecks);
      return this;
    }

    /**
     * The URL of the HttpHealthCheck resource. A member instance in this pool is considered healthy
     * if and only if the health checks pass. An empty list means all member instances will be
     * considered healthy at all times. Only HttpHealthChecks are supported. Only one health check
     * may be specified.
     */
    public Builder addHealthChecks(String healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.add(healthChecks);
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
     * A list of resource URLs to the virtual machine instances serving this pool. They must live in
     * zones contained in the same region as this pool.
     */
    public List<String> getInstancesList() {
      return instances;
    }

    /**
     * A list of resource URLs to the virtual machine instances serving this pool. They must live in
     * zones contained in the same region as this pool.
     */
    public Builder addAllInstances(List<String> instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.addAll(instances);
      return this;
    }

    /**
     * A list of resource URLs to the virtual machine instances serving this pool. They must live in
     * zones contained in the same region as this pool.
     */
    public Builder addInstances(String instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.add(instances);
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#targetPool for target pools. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#targetPool for target pools. */
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

    /** [Output Only] URL of the region where the target pool resides. */
    public String getRegion() {
      return region;
    }

    /** [Output Only] URL of the region where the target pool resides. */
    public Builder setRegion(String region) {
      this.region = region;
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
     * Session affinity option, must be one of the following values: NONE: Connections from the same
     * client IP may go to any instance in the pool. CLIENT_IP: Connections from the same client IP
     * will go to the same instance in the pool while that instance remains healthy.
     * CLIENT_IP_PROTO: Connections from the same client IP with the same IP protocol will go to the
     * same instance in the pool while that instance remains healthy.
     */
    public String getSessionAffinity() {
      return sessionAffinity;
    }

    /**
     * Session affinity option, must be one of the following values: NONE: Connections from the same
     * client IP may go to any instance in the pool. CLIENT_IP: Connections from the same client IP
     * will go to the same instance in the pool while that instance remains healthy.
     * CLIENT_IP_PROTO: Connections from the same client IP with the same IP protocol will go to the
     * same instance in the pool while that instance remains healthy.
     */
    public Builder setSessionAffinity(String sessionAffinity) {
      this.sessionAffinity = sessionAffinity;
      return this;
    }

    public TargetPool build() {

      return new TargetPool(
          backupPool,
          creationTimestamp,
          description,
          failoverRatio,
          healthChecks,
          id,
          instances,
          kind,
          name,
          region,
          selfLink,
          sessionAffinity);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBackupPool(this.backupPool);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setFailoverRatio(this.failoverRatio);
      newBuilder.addAllHealthChecks(this.healthChecks);
      newBuilder.setId(this.id);
      newBuilder.addAllInstances(this.instances);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSessionAffinity(this.sessionAffinity);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetPool{"
        + "backupPool="
        + backupPool
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "failoverRatio="
        + failoverRatio
        + ", "
        + "healthChecks="
        + healthChecks
        + ", "
        + "id="
        + id
        + ", "
        + "instances="
        + instances
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
        + "sessionAffinity="
        + sessionAffinity
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetPool) {
      TargetPool that = (TargetPool) o;
      return Objects.equals(this.backupPool, that.getBackupPool())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.failoverRatio, that.getFailoverRatio())
          && Objects.equals(this.healthChecks, that.getHealthChecksList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.instances, that.getInstancesList())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sessionAffinity, that.getSessionAffinity());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        backupPool,
        creationTimestamp,
        description,
        failoverRatio,
        healthChecks,
        id,
        instances,
        kind,
        name,
        region,
        selfLink,
        sessionAffinity);
  }
}
