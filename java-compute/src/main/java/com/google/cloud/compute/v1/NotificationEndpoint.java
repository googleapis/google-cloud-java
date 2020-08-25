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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a notification endpoint.
 *
 * <p>A notification endpoint resource defines an endpoint to receive notifications when there are
 * status changes detected by the associated health check service.
 *
 * <p>For more information, see Health checks overview. (== resource_for
 * {$api_version}.notificationEndpoint ==) (== resource_for
 * {$api_version}.regionNotificationEndpoints ==)
 */
public final class NotificationEndpoint implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final NotificationEndpointGrpcSettings grpcSettings;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;

  private NotificationEndpoint() {
    this.creationTimestamp = null;
    this.description = null;
    this.grpcSettings = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
  }

  private NotificationEndpoint(
      String creationTimestamp,
      String description,
      NotificationEndpointGrpcSettings grpcSettings,
      String id,
      String kind,
      String name,
      String region,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.grpcSettings = grpcSettings;
    this.id = id;
    this.kind = kind;
    this.name = name;
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
    if ("grpcSettings".equals(fieldName)) {
      return grpcSettings;
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
   * Settings of the gRPC notification endpoint including the endpoint URL and the retry duration.
   */
  public NotificationEndpointGrpcSettings getGrpcSettings() {
    return grpcSettings;
  }

  /**
   * [Output Only] A unique identifier for this resource type. The server generates this identifier.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] Type of the resource. Always compute#notificationEndpoint for notification
   * endpoints.
   */
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
   * [Output Only] URL of the region where the notification endpoint resides. This field applies
   * only to the regional resource. You must specify this field as part of the HTTP request URL. It
   * is not settable as a field in the request body.
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

  public static Builder newBuilder(NotificationEndpoint prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NotificationEndpoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NotificationEndpoint DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NotificationEndpoint();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private NotificationEndpointGrpcSettings grpcSettings;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(NotificationEndpoint other) {
      if (other == NotificationEndpoint.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGrpcSettings() != null) {
        this.grpcSettings = other.grpcSettings;
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
      return this;
    }

    Builder(NotificationEndpoint source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.grpcSettings = source.grpcSettings;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
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
     * Settings of the gRPC notification endpoint including the endpoint URL and the retry duration.
     */
    public NotificationEndpointGrpcSettings getGrpcSettings() {
      return grpcSettings;
    }

    /**
     * Settings of the gRPC notification endpoint including the endpoint URL and the retry duration.
     */
    public Builder setGrpcSettings(NotificationEndpointGrpcSettings grpcSettings) {
      this.grpcSettings = grpcSettings;
      return this;
    }

    /**
     * [Output Only] A unique identifier for this resource type. The server generates this
     * identifier.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] A unique identifier for this resource type. The server generates this
     * identifier.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#notificationEndpoint for notification
     * endpoints.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#notificationEndpoint for notification
     * endpoints.
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
     * [Output Only] URL of the region where the notification endpoint resides. This field applies
     * only to the regional resource. You must specify this field as part of the HTTP request URL.
     * It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the notification endpoint resides. This field applies
     * only to the regional resource. You must specify this field as part of the HTTP request URL.
     * It is not settable as a field in the request body.
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

    public NotificationEndpoint build() {

      return new NotificationEndpoint(
          creationTimestamp, description, grpcSettings, id, kind, name, region, selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setGrpcSettings(this.grpcSettings);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NotificationEndpoint{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "grpcSettings="
        + grpcSettings
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
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NotificationEndpoint) {
      NotificationEndpoint that = (NotificationEndpoint) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.grpcSettings, that.getGrpcSettings())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp, description, grpcSettings, id, kind, name, region, selfLink);
  }
}
