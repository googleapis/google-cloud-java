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
 * Represents a Commitment resource. Creating a Commitment resource means that you are purchasing a
 * committed use contract with an explicit start and end time. You can create commitments based on
 * vCPUs and memory usage and receive discounted rates. For full details, read Signing Up for
 * Committed Use Discounts.
 *
 * <p>Committed use discounts are subject to Google Cloud Platform's Service Specific Terms. By
 * purchasing a committed use discount, you agree to these terms. Committed use discounts will not
 * renew, so you must purchase a new commitment to continue receiving discounts. (== resource_for
 * beta.commitments ==) (== resource_for v1.commitments ==)
 */
public final class Commitment implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String endTimestamp;
  private final String id;
  private final String kind;
  private final String name;
  private final String plan;
  private final String region;
  private final List<ResourceCommitment> resources;
  private final String selfLink;
  private final String startTimestamp;
  private final String status;
  private final String statusMessage;

  private Commitment() {
    this.creationTimestamp = null;
    this.description = null;
    this.endTimestamp = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.plan = null;
    this.region = null;
    this.resources = null;
    this.selfLink = null;
    this.startTimestamp = null;
    this.status = null;
    this.statusMessage = null;
  }

  private Commitment(
      String creationTimestamp,
      String description,
      String endTimestamp,
      String id,
      String kind,
      String name,
      String plan,
      String region,
      List<ResourceCommitment> resources,
      String selfLink,
      String startTimestamp,
      String status,
      String statusMessage) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.endTimestamp = endTimestamp;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.plan = plan;
    this.region = region;
    this.resources = resources;
    this.selfLink = selfLink;
    this.startTimestamp = startTimestamp;
    this.status = status;
    this.statusMessage = statusMessage;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("endTimestamp".equals(fieldName)) {
      return endTimestamp;
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
    if ("plan".equals(fieldName)) {
      return plan;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("resources".equals(fieldName)) {
      return resources;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("startTimestamp".equals(fieldName)) {
      return startTimestamp;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusMessage".equals(fieldName)) {
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

  /** [Output Only] Commitment end time in RFC3339 text format. */
  public String getEndTimestamp() {
    return endTimestamp;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#commitment for commitments. */
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
   * The plan for this commitment, which determines duration and discount rate. The currently
   * supported plans are TWELVE_MONTH (1 year), and THIRTY_SIX_MONTH (3 years).
   */
  public String getPlan() {
    return plan;
  }

  /** [Output Only] URL of the region where this commitment may be used. */
  public String getRegion() {
    return region;
  }

  /**
   * A list of commitment amounts for particular resources. Note that VCPU and MEMORY resource
   * commitments must occur together.
   */
  public List<ResourceCommitment> getResourcesList() {
    return resources;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Commitment start time in RFC3339 text format. */
  public String getStartTimestamp() {
    return startTimestamp;
  }

  /**
   * [Output Only] Status of the commitment with regards to eventual expiration (each commitment has
   * an end date defined). One of the following values: NOT_YET_ACTIVE, ACTIVE, EXPIRED.
   */
  public String getStatus() {
    return status;
  }

  /** [Output Only] An optional, human-readable explanation of the status. */
  public String getStatusMessage() {
    return statusMessage;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Commitment prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Commitment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Commitment DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Commitment();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String endTimestamp;
    private String id;
    private String kind;
    private String name;
    private String plan;
    private String region;
    private List<ResourceCommitment> resources;
    private String selfLink;
    private String startTimestamp;
    private String status;
    private String statusMessage;

    Builder() {}

    public Builder mergeFrom(Commitment other) {
      if (other == Commitment.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEndTimestamp() != null) {
        this.endTimestamp = other.endTimestamp;
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
      if (other.getPlan() != null) {
        this.plan = other.plan;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getResourcesList() != null) {
        this.resources = other.resources;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStartTimestamp() != null) {
        this.startTimestamp = other.startTimestamp;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusMessage() != null) {
        this.statusMessage = other.statusMessage;
      }
      return this;
    }

    Builder(Commitment source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.endTimestamp = source.endTimestamp;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.plan = source.plan;
      this.region = source.region;
      this.resources = source.resources;
      this.selfLink = source.selfLink;
      this.startTimestamp = source.startTimestamp;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
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

    /** [Output Only] Commitment end time in RFC3339 text format. */
    public String getEndTimestamp() {
      return endTimestamp;
    }

    /** [Output Only] Commitment end time in RFC3339 text format. */
    public Builder setEndTimestamp(String endTimestamp) {
      this.endTimestamp = endTimestamp;
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

    /** [Output Only] Type of the resource. Always compute#commitment for commitments. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#commitment for commitments. */
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
     * The plan for this commitment, which determines duration and discount rate. The currently
     * supported plans are TWELVE_MONTH (1 year), and THIRTY_SIX_MONTH (3 years).
     */
    public String getPlan() {
      return plan;
    }

    /**
     * The plan for this commitment, which determines duration and discount rate. The currently
     * supported plans are TWELVE_MONTH (1 year), and THIRTY_SIX_MONTH (3 years).
     */
    public Builder setPlan(String plan) {
      this.plan = plan;
      return this;
    }

    /** [Output Only] URL of the region where this commitment may be used. */
    public String getRegion() {
      return region;
    }

    /** [Output Only] URL of the region where this commitment may be used. */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /**
     * A list of commitment amounts for particular resources. Note that VCPU and MEMORY resource
     * commitments must occur together.
     */
    public List<ResourceCommitment> getResourcesList() {
      return resources;
    }

    /**
     * A list of commitment amounts for particular resources. Note that VCPU and MEMORY resource
     * commitments must occur together.
     */
    public Builder addAllResources(List<ResourceCommitment> resources) {
      if (this.resources == null) {
        this.resources = new LinkedList<>();
      }
      this.resources.addAll(resources);
      return this;
    }

    /**
     * A list of commitment amounts for particular resources. Note that VCPU and MEMORY resource
     * commitments must occur together.
     */
    public Builder addResources(ResourceCommitment resources) {
      if (this.resources == null) {
        this.resources = new LinkedList<>();
      }
      this.resources.add(resources);
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

    /** [Output Only] Commitment start time in RFC3339 text format. */
    public String getStartTimestamp() {
      return startTimestamp;
    }

    /** [Output Only] Commitment start time in RFC3339 text format. */
    public Builder setStartTimestamp(String startTimestamp) {
      this.startTimestamp = startTimestamp;
      return this;
    }

    /**
     * [Output Only] Status of the commitment with regards to eventual expiration (each commitment
     * has an end date defined). One of the following values: NOT_YET_ACTIVE, ACTIVE, EXPIRED.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] Status of the commitment with regards to eventual expiration (each commitment
     * has an end date defined). One of the following values: NOT_YET_ACTIVE, ACTIVE, EXPIRED.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public String getStatusMessage() {
      return statusMessage;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    public Commitment build() {

      return new Commitment(
          creationTimestamp,
          description,
          endTimestamp,
          id,
          kind,
          name,
          plan,
          region,
          resources,
          selfLink,
          startTimestamp,
          status,
          statusMessage);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEndTimestamp(this.endTimestamp);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setPlan(this.plan);
      newBuilder.setRegion(this.region);
      newBuilder.addAllResources(this.resources);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStartTimestamp(this.startTimestamp);
      newBuilder.setStatus(this.status);
      newBuilder.setStatusMessage(this.statusMessage);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Commitment{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "endTimestamp="
        + endTimestamp
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
        + "plan="
        + plan
        + ", "
        + "region="
        + region
        + ", "
        + "resources="
        + resources
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "startTimestamp="
        + startTimestamp
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
    if (o instanceof Commitment) {
      Commitment that = (Commitment) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.endTimestamp, that.getEndTimestamp())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.plan, that.getPlan())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.resources, that.getResourcesList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.startTimestamp, that.getStartTimestamp())
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
        endTimestamp,
        id,
        kind,
        name,
        plan,
        region,
        resources,
        selfLink,
        startTimestamp,
        status,
        statusMessage);
  }
}
