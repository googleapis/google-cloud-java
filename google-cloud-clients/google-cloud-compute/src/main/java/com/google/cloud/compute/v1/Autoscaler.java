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
 * Represents an Autoscaler resource. Autoscalers allow you to automatically scale virtual machine
 * instances in managed instance groups according to an autoscaling policy that you define. For more
 * information, read Autoscaling Groups of Instances. (== resource_for beta.autoscalers ==) (==
 * resource_for v1.autoscalers ==) (== resource_for beta.regionAutoscalers ==) (== resource_for
 * v1.regionAutoscalers ==)
 */
public final class Autoscaler implements ApiMessage {
  private final AutoscalingPolicy autoscalingPolicy;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String status;
  private final List<AutoscalerStatusDetails> statusDetails;
  private final String target;
  private final String zone;

  private Autoscaler() {
    this.autoscalingPolicy = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
    this.statusDetails = null;
    this.target = null;
    this.zone = null;
  }

  private Autoscaler(
      AutoscalingPolicy autoscalingPolicy,
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String region,
      String selfLink,
      String status,
      List<AutoscalerStatusDetails> statusDetails,
      String target,
      String zone) {
    this.autoscalingPolicy = autoscalingPolicy;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.statusDetails = statusDetails;
    this.target = target;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoscalingPolicy".equals(fieldName)) {
      return autoscalingPolicy;
    }
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
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusDetails".equals(fieldName)) {
      return statusDetails;
    }
    if ("target".equals(fieldName)) {
      return target;
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

  /**
   * The configuration parameters for the autoscaling algorithm. You can define one or more of the
   * policies for an autoscaler: cpuUtilization, customMetricUtilizations, and
   * loadBalancingUtilization.
   *
   * <p>If none of these are specified, the default will be to autoscale based on cpuUtilization to
   * 0.6 or 60%.
   */
  public AutoscalingPolicy getAutoscalingPolicy() {
    return autoscalingPolicy;
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

  /** [Output Only] Type of the resource. Always compute#autoscaler for autoscalers. */
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
   * [Output Only] URL of the region where the instance group resides (for autoscalers living in
   * regional scope).
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] The status of the autoscaler configuration. */
  public String getStatus() {
    return status;
  }

  /**
   * [Output Only] Human-readable details about the current state of the autoscaler. Read the
   * documentation for Commonly returned status messages for examples of status messages you might
   * encounter.
   */
  public List<AutoscalerStatusDetails> getStatusDetailsList() {
    return statusDetails;
  }

  /** URL of the managed instance group that this autoscaler will scale. */
  public String getTarget() {
    return target;
  }

  /**
   * [Output Only] URL of the zone where the instance group resides (for autoscalers living in zonal
   * scope).
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Autoscaler prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Autoscaler getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Autoscaler DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Autoscaler();
  }

  public static class Builder {
    private AutoscalingPolicy autoscalingPolicy;
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String status;
    private List<AutoscalerStatusDetails> statusDetails;
    private String target;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Autoscaler other) {
      if (other == Autoscaler.getDefaultInstance()) return this;
      if (other.getAutoscalingPolicy() != null) {
        this.autoscalingPolicy = other.autoscalingPolicy;
      }
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
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusDetailsList() != null) {
        this.statusDetails = other.statusDetails;
      }
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Autoscaler source) {
      this.autoscalingPolicy = source.autoscalingPolicy;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.statusDetails = source.statusDetails;
      this.target = source.target;
      this.zone = source.zone;
    }

    /**
     * The configuration parameters for the autoscaling algorithm. You can define one or more of the
     * policies for an autoscaler: cpuUtilization, customMetricUtilizations, and
     * loadBalancingUtilization.
     *
     * <p>If none of these are specified, the default will be to autoscale based on cpuUtilization
     * to 0.6 or 60%.
     */
    public AutoscalingPolicy getAutoscalingPolicy() {
      return autoscalingPolicy;
    }

    /**
     * The configuration parameters for the autoscaling algorithm. You can define one or more of the
     * policies for an autoscaler: cpuUtilization, customMetricUtilizations, and
     * loadBalancingUtilization.
     *
     * <p>If none of these are specified, the default will be to autoscale based on cpuUtilization
     * to 0.6 or 60%.
     */
    public Builder setAutoscalingPolicy(AutoscalingPolicy autoscalingPolicy) {
      this.autoscalingPolicy = autoscalingPolicy;
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

    /** [Output Only] Type of the resource. Always compute#autoscaler for autoscalers. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#autoscaler for autoscalers. */
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
     * [Output Only] URL of the region where the instance group resides (for autoscalers living in
     * regional scope).
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the instance group resides (for autoscalers living in
     * regional scope).
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

    /** [Output Only] The status of the autoscaler configuration. */
    public String getStatus() {
      return status;
    }

    /** [Output Only] The status of the autoscaler configuration. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * [Output Only] Human-readable details about the current state of the autoscaler. Read the
     * documentation for Commonly returned status messages for examples of status messages you might
     * encounter.
     */
    public List<AutoscalerStatusDetails> getStatusDetailsList() {
      return statusDetails;
    }

    /**
     * [Output Only] Human-readable details about the current state of the autoscaler. Read the
     * documentation for Commonly returned status messages for examples of status messages you might
     * encounter.
     */
    public Builder addAllStatusDetails(List<AutoscalerStatusDetails> statusDetails) {
      if (this.statusDetails == null) {
        this.statusDetails = new LinkedList<>();
      }
      this.statusDetails.addAll(statusDetails);
      return this;
    }

    /**
     * [Output Only] Human-readable details about the current state of the autoscaler. Read the
     * documentation for Commonly returned status messages for examples of status messages you might
     * encounter.
     */
    public Builder addStatusDetails(AutoscalerStatusDetails statusDetails) {
      if (this.statusDetails == null) {
        this.statusDetails = new LinkedList<>();
      }
      this.statusDetails.add(statusDetails);
      return this;
    }

    /** URL of the managed instance group that this autoscaler will scale. */
    public String getTarget() {
      return target;
    }

    /** URL of the managed instance group that this autoscaler will scale. */
    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    /**
     * [Output Only] URL of the zone where the instance group resides (for autoscalers living in
     * zonal scope).
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] URL of the zone where the instance group resides (for autoscalers living in
     * zonal scope).
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Autoscaler build() {

      return new Autoscaler(
          autoscalingPolicy,
          creationTimestamp,
          description,
          id,
          kind,
          name,
          region,
          selfLink,
          status,
          statusDetails,
          target,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoscalingPolicy(this.autoscalingPolicy);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.addAllStatusDetails(this.statusDetails);
      newBuilder.setTarget(this.target);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Autoscaler{"
        + "autoscalingPolicy="
        + autoscalingPolicy
        + ", "
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
        + "status="
        + status
        + ", "
        + "statusDetails="
        + statusDetails
        + ", "
        + "target="
        + target
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
    if (o instanceof Autoscaler) {
      Autoscaler that = (Autoscaler) o;
      return Objects.equals(this.autoscalingPolicy, that.getAutoscalingPolicy())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.statusDetails, that.getStatusDetailsList())
          && Objects.equals(this.target, that.getTarget())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoscalingPolicy,
        creationTimestamp,
        description,
        id,
        kind,
        name,
        region,
        selfLink,
        status,
        statusDetails,
        target,
        zone);
  }
}
