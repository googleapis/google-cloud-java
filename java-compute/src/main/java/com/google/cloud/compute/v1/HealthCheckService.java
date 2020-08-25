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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Health-Check as a Service resource.
 *
 * <p>(== resource_for {$api_version}.regionHealthCheckServices ==)
 */
public final class HealthCheckService implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String fingerprint;
  private final List<String> healthChecks;
  private final String healthStatusAggregationPolicy;
  private final String id;
  private final String kind;
  private final String name;
  private final List<String> networkEndpointGroups;
  private final List<String> notificationEndpoints;
  private final String region;
  private final String selfLink;

  private HealthCheckService() {
    this.creationTimestamp = null;
    this.description = null;
    this.fingerprint = null;
    this.healthChecks = null;
    this.healthStatusAggregationPolicy = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.networkEndpointGroups = null;
    this.notificationEndpoints = null;
    this.region = null;
    this.selfLink = null;
  }

  private HealthCheckService(
      String creationTimestamp,
      String description,
      String fingerprint,
      List<String> healthChecks,
      String healthStatusAggregationPolicy,
      String id,
      String kind,
      String name,
      List<String> networkEndpointGroups,
      List<String> notificationEndpoints,
      String region,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.fingerprint = fingerprint;
    this.healthChecks = healthChecks;
    this.healthStatusAggregationPolicy = healthStatusAggregationPolicy;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.networkEndpointGroups = networkEndpointGroups;
    this.notificationEndpoints = notificationEndpoints;
    this.region = region;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("healthChecks".equals(fieldName)) {
      return healthChecks;
    }
    if ("healthStatusAggregationPolicy".equals(fieldName)) {
      return healthStatusAggregationPolicy;
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
    if ("networkEndpointGroups".equals(fieldName)) {
      return networkEndpointGroups;
    }
    if ("notificationEndpoints".equals(fieldName)) {
      return notificationEndpoints;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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
   * Fingerprint of this resource. A hash of the contents stored in this object. This field is used
   * in optimistic locking. This field will be ignored when inserting a HealthCheckService. An
   * up-to-date fingerprint must be provided in order to patch/update the HealthCheckService;
   * Otherwise, the request will fail with error 412 conditionNotMet. To see the latest fingerprint,
   * make a get() request to retrieve the HealthCheckService.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * List of URLs to the HealthCheck resources. Must have at least one HealthCheck, and not more
   * than 10. HealthCheck resources must have portSpecification=USE_SERVING_PORT. For regional
   * HealthCheckService, the HealthCheck must be regional and in the same region. For global
   * HealthCheckService, HealthCheck must be global. Mix of regional and global HealthChecks is not
   * supported. Multiple regional HealthChecks must belong to the same region. Regional
   * HealthChecks&lt;/code? must belong to the same region as zones of NEGs.
   */
  public List<String> getHealthChecksList() {
    return healthChecks;
  }

  /**
   * Optional. Policy for how the results from multiple health checks for the same endpoint are
   * aggregated. Defaults to NO_AGGREGATION if unspecified. - NO_AGGREGATION. An EndpointHealth
   * message is returned for each backend in the health check service. - AND. If any backend's
   * health check reports UNHEALTHY, then UNHEALTHY is the HealthState of the entire health check
   * service. If all backend's are healthy, the HealthState of the health check service is HEALTHY.
   * .
   */
  public String getHealthStatusAggregationPolicy() {
    return healthStatusAggregationPolicy;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output only] Type of the resource. Always compute#healthCheckServicefor health check services.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
   * Specifically, the name must be 1-63 characters long and match the regular expression
   * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
   * and all following characters must be a dash, lowercase letter, or digit, except the last
   * character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * List of URLs to the NetworkEndpointGroup resources. Must not have more than 100. For regional
   * HealthCheckService, NEGs must be in zones in the region of the HealthCheckService.
   */
  public List<String> getNetworkEndpointGroupsList() {
    return networkEndpointGroups;
  }

  /**
   * List of URLs to the NotificationEndpoint resources. Must not have more than 10. A list of
   * endpoints for receiving notifications of change in health status. For regional
   * HealthCheckService, NotificationEndpoint must be regional and in the same region. For global
   * HealthCheckService, NotificationEndpoint must be global.
   */
  public List<String> getNotificationEndpointsList() {
    return notificationEndpoints;
  }

  /**
   * [Output Only] URL of the region where the health check service resides. This field is not
   * applicable to global health check services. You must specify this field as part of the HTTP
   * request URL. It is not settable as a field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HealthCheckService prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthCheckService getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthCheckService DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthCheckService();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String fingerprint;
    private List<String> healthChecks;
    private String healthStatusAggregationPolicy;
    private String id;
    private String kind;
    private String name;
    private List<String> networkEndpointGroups;
    private List<String> notificationEndpoints;
    private String region;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(HealthCheckService other) {
      if (other == HealthCheckService.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getHealthChecksList() != null) {
        this.healthChecks = other.healthChecks;
      }
      if (other.getHealthStatusAggregationPolicy() != null) {
        this.healthStatusAggregationPolicy = other.healthStatusAggregationPolicy;
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
      if (other.getNetworkEndpointGroupsList() != null) {
        this.networkEndpointGroups = other.networkEndpointGroups;
      }
      if (other.getNotificationEndpointsList() != null) {
        this.notificationEndpoints = other.notificationEndpoints;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(HealthCheckService source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.fingerprint = source.fingerprint;
      this.healthChecks = source.healthChecks;
      this.healthStatusAggregationPolicy = source.healthStatusAggregationPolicy;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.networkEndpointGroups = source.networkEndpointGroups;
      this.notificationEndpoints = source.notificationEndpoints;
      this.region = source.region;
      this.selfLink = source.selfLink;
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
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a HealthCheckService.
     * An up-to-date fingerprint must be provided in order to patch/update the HealthCheckService;
     * Otherwise, the request will fail with error 412 conditionNotMet. To see the latest
     * fingerprint, make a get() request to retrieve the HealthCheckService.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a HealthCheckService.
     * An up-to-date fingerprint must be provided in order to patch/update the HealthCheckService;
     * Otherwise, the request will fail with error 412 conditionNotMet. To see the latest
     * fingerprint, make a get() request to retrieve the HealthCheckService.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * List of URLs to the HealthCheck resources. Must have at least one HealthCheck, and not more
     * than 10. HealthCheck resources must have portSpecification=USE_SERVING_PORT. For regional
     * HealthCheckService, the HealthCheck must be regional and in the same region. For global
     * HealthCheckService, HealthCheck must be global. Mix of regional and global HealthChecks is
     * not supported. Multiple regional HealthChecks must belong to the same region. Regional
     * HealthChecks&lt;/code? must belong to the same region as zones of NEGs.
     */
    public List<String> getHealthChecksList() {
      return healthChecks;
    }

    /**
     * List of URLs to the HealthCheck resources. Must have at least one HealthCheck, and not more
     * than 10. HealthCheck resources must have portSpecification=USE_SERVING_PORT. For regional
     * HealthCheckService, the HealthCheck must be regional and in the same region. For global
     * HealthCheckService, HealthCheck must be global. Mix of regional and global HealthChecks is
     * not supported. Multiple regional HealthChecks must belong to the same region. Regional
     * HealthChecks&lt;/code? must belong to the same region as zones of NEGs.
     */
    public Builder addAllHealthChecks(List<String> healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.addAll(healthChecks);
      return this;
    }

    /**
     * List of URLs to the HealthCheck resources. Must have at least one HealthCheck, and not more
     * than 10. HealthCheck resources must have portSpecification=USE_SERVING_PORT. For regional
     * HealthCheckService, the HealthCheck must be regional and in the same region. For global
     * HealthCheckService, HealthCheck must be global. Mix of regional and global HealthChecks is
     * not supported. Multiple regional HealthChecks must belong to the same region. Regional
     * HealthChecks&lt;/code? must belong to the same region as zones of NEGs.
     */
    public Builder addHealthChecks(String healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.add(healthChecks);
      return this;
    }

    /**
     * Optional. Policy for how the results from multiple health checks for the same endpoint are
     * aggregated. Defaults to NO_AGGREGATION if unspecified. - NO_AGGREGATION. An EndpointHealth
     * message is returned for each backend in the health check service. - AND. If any backend's
     * health check reports UNHEALTHY, then UNHEALTHY is the HealthState of the entire health check
     * service. If all backend's are healthy, the HealthState of the health check service is
     * HEALTHY. .
     */
    public String getHealthStatusAggregationPolicy() {
      return healthStatusAggregationPolicy;
    }

    /**
     * Optional. Policy for how the results from multiple health checks for the same endpoint are
     * aggregated. Defaults to NO_AGGREGATION if unspecified. - NO_AGGREGATION. An EndpointHealth
     * message is returned for each backend in the health check service. - AND. If any backend's
     * health check reports UNHEALTHY, then UNHEALTHY is the HealthState of the entire health check
     * service. If all backend's are healthy, the HealthState of the health check service is
     * HEALTHY. .
     */
    public Builder setHealthStatusAggregationPolicy(String healthStatusAggregationPolicy) {
      this.healthStatusAggregationPolicy = healthStatusAggregationPolicy;
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
     * [Output only] Type of the resource. Always compute#healthCheckServicefor health check
     * services.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output only] Type of the resource. Always compute#healthCheckServicefor health check
     * services.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
     * Specifically, the name must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
     * Specifically, the name must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * List of URLs to the NetworkEndpointGroup resources. Must not have more than 100. For regional
     * HealthCheckService, NEGs must be in zones in the region of the HealthCheckService.
     */
    public List<String> getNetworkEndpointGroupsList() {
      return networkEndpointGroups;
    }

    /**
     * List of URLs to the NetworkEndpointGroup resources. Must not have more than 100. For regional
     * HealthCheckService, NEGs must be in zones in the region of the HealthCheckService.
     */
    public Builder addAllNetworkEndpointGroups(List<String> networkEndpointGroups) {
      if (this.networkEndpointGroups == null) {
        this.networkEndpointGroups = new LinkedList<>();
      }
      this.networkEndpointGroups.addAll(networkEndpointGroups);
      return this;
    }

    /**
     * List of URLs to the NetworkEndpointGroup resources. Must not have more than 100. For regional
     * HealthCheckService, NEGs must be in zones in the region of the HealthCheckService.
     */
    public Builder addNetworkEndpointGroups(String networkEndpointGroups) {
      if (this.networkEndpointGroups == null) {
        this.networkEndpointGroups = new LinkedList<>();
      }
      this.networkEndpointGroups.add(networkEndpointGroups);
      return this;
    }

    /**
     * List of URLs to the NotificationEndpoint resources. Must not have more than 10. A list of
     * endpoints for receiving notifications of change in health status. For regional
     * HealthCheckService, NotificationEndpoint must be regional and in the same region. For global
     * HealthCheckService, NotificationEndpoint must be global.
     */
    public List<String> getNotificationEndpointsList() {
      return notificationEndpoints;
    }

    /**
     * List of URLs to the NotificationEndpoint resources. Must not have more than 10. A list of
     * endpoints for receiving notifications of change in health status. For regional
     * HealthCheckService, NotificationEndpoint must be regional and in the same region. For global
     * HealthCheckService, NotificationEndpoint must be global.
     */
    public Builder addAllNotificationEndpoints(List<String> notificationEndpoints) {
      if (this.notificationEndpoints == null) {
        this.notificationEndpoints = new LinkedList<>();
      }
      this.notificationEndpoints.addAll(notificationEndpoints);
      return this;
    }

    /**
     * List of URLs to the NotificationEndpoint resources. Must not have more than 10. A list of
     * endpoints for receiving notifications of change in health status. For regional
     * HealthCheckService, NotificationEndpoint must be regional and in the same region. For global
     * HealthCheckService, NotificationEndpoint must be global.
     */
    public Builder addNotificationEndpoints(String notificationEndpoints) {
      if (this.notificationEndpoints == null) {
        this.notificationEndpoints = new LinkedList<>();
      }
      this.notificationEndpoints.add(notificationEndpoints);
      return this;
    }

    /**
     * [Output Only] URL of the region where the health check service resides. This field is not
     * applicable to global health check services. You must specify this field as part of the HTTP
     * request URL. It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the health check service resides. This field is not
     * applicable to global health check services. You must specify this field as part of the HTTP
     * request URL. It is not settable as a field in the request body.
     */
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

    public HealthCheckService build() {

      return new HealthCheckService(
          creationTimestamp,
          description,
          fingerprint,
          healthChecks,
          healthStatusAggregationPolicy,
          id,
          kind,
          name,
          networkEndpointGroups,
          notificationEndpoints,
          region,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllHealthChecks(this.healthChecks);
      newBuilder.setHealthStatusAggregationPolicy(this.healthStatusAggregationPolicy);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllNetworkEndpointGroups(this.networkEndpointGroups);
      newBuilder.addAllNotificationEndpoints(this.notificationEndpoints);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthCheckService{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "healthChecks="
        + healthChecks
        + ", "
        + "healthStatusAggregationPolicy="
        + healthStatusAggregationPolicy
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
        + "networkEndpointGroups="
        + networkEndpointGroups
        + ", "
        + "notificationEndpoints="
        + notificationEndpoints
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthCheckService) {
      HealthCheckService that = (HealthCheckService) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.healthChecks, that.getHealthChecksList())
          && Objects.equals(
              this.healthStatusAggregationPolicy, that.getHealthStatusAggregationPolicy())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.networkEndpointGroups, that.getNetworkEndpointGroupsList())
          && Objects.equals(this.notificationEndpoints, that.getNotificationEndpointsList())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        fingerprint,
        healthChecks,
        healthStatusAggregationPolicy,
        id,
        kind,
        name,
        networkEndpointGroups,
        notificationEndpoints,
        region,
        selfLink);
  }
}
