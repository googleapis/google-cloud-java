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
 * Represents a legacy HTTPS Health Check resource.
 *
 * <p>Legacy health checks are required by network load balancers. For more information, read Health
 * Check Concepts.
 */
public final class HttpsHealthCheck2 implements ApiMessage {
  private final Integer checkIntervalSec;
  private final String creationTimestamp;
  private final String description;
  private final Integer healthyThreshold;
  private final String host;
  private final String id;
  private final String kind;
  private final String name;
  private final Integer port;
  private final String requestPath;
  private final String selfLink;
  private final Integer timeoutSec;
  private final Integer unhealthyThreshold;

  private HttpsHealthCheck2() {
    this.checkIntervalSec = null;
    this.creationTimestamp = null;
    this.description = null;
    this.healthyThreshold = null;
    this.host = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.port = null;
    this.requestPath = null;
    this.selfLink = null;
    this.timeoutSec = null;
    this.unhealthyThreshold = null;
  }

  private HttpsHealthCheck2(
      Integer checkIntervalSec,
      String creationTimestamp,
      String description,
      Integer healthyThreshold,
      String host,
      String id,
      String kind,
      String name,
      Integer port,
      String requestPath,
      String selfLink,
      Integer timeoutSec,
      Integer unhealthyThreshold) {
    this.checkIntervalSec = checkIntervalSec;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.healthyThreshold = healthyThreshold;
    this.host = host;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.port = port;
    this.requestPath = requestPath;
    this.selfLink = selfLink;
    this.timeoutSec = timeoutSec;
    this.unhealthyThreshold = unhealthyThreshold;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("checkIntervalSec".equals(fieldName)) {
      return checkIntervalSec;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("healthyThreshold".equals(fieldName)) {
      return healthyThreshold;
    }
    if ("host".equals(fieldName)) {
      return host;
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
    if ("port".equals(fieldName)) {
      return port;
    }
    if ("requestPath".equals(fieldName)) {
      return requestPath;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("timeoutSec".equals(fieldName)) {
      return timeoutSec;
    }
    if ("unhealthyThreshold".equals(fieldName)) {
      return unhealthyThreshold;
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

  /** How often (in seconds) to send a health check. The default value is 5 seconds. */
  public Integer getCheckIntervalSec() {
    return checkIntervalSec;
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
   * A so-far unhealthy instance will be marked healthy after this many consecutive successes. The
   * default value is 2.
   */
  public Integer getHealthyThreshold() {
    return healthyThreshold;
  }

  /**
   * The value of the host header in the HTTPS health check request. If left empty (default value),
   * the public IP on behalf of which this health check is performed will be used.
   */
  public String getHost() {
    return host;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** Type of the resource. */
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

  /** The TCP port number for the HTTPS health check request. The default value is 443. */
  public Integer getPort() {
    return port;
  }

  /** The request path of the HTTPS health check request. The default value is "/". */
  public String getRequestPath() {
    return requestPath;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
   * invalid for timeoutSec to have a greater value than checkIntervalSec.
   */
  public Integer getTimeoutSec() {
    return timeoutSec;
  }

  /**
   * A so-far healthy instance will be marked unhealthy after this many consecutive failures. The
   * default value is 2.
   */
  public Integer getUnhealthyThreshold() {
    return unhealthyThreshold;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpsHealthCheck2 prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpsHealthCheck2 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpsHealthCheck2 DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpsHealthCheck2();
  }

  public static class Builder {
    private Integer checkIntervalSec;
    private String creationTimestamp;
    private String description;
    private Integer healthyThreshold;
    private String host;
    private String id;
    private String kind;
    private String name;
    private Integer port;
    private String requestPath;
    private String selfLink;
    private Integer timeoutSec;
    private Integer unhealthyThreshold;

    Builder() {}

    public Builder mergeFrom(HttpsHealthCheck2 other) {
      if (other == HttpsHealthCheck2.getDefaultInstance()) return this;
      if (other.getCheckIntervalSec() != null) {
        this.checkIntervalSec = other.checkIntervalSec;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getHealthyThreshold() != null) {
        this.healthyThreshold = other.healthyThreshold;
      }
      if (other.getHost() != null) {
        this.host = other.host;
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
      if (other.getPort() != null) {
        this.port = other.port;
      }
      if (other.getRequestPath() != null) {
        this.requestPath = other.requestPath;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getTimeoutSec() != null) {
        this.timeoutSec = other.timeoutSec;
      }
      if (other.getUnhealthyThreshold() != null) {
        this.unhealthyThreshold = other.unhealthyThreshold;
      }
      return this;
    }

    Builder(HttpsHealthCheck2 source) {
      this.checkIntervalSec = source.checkIntervalSec;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.healthyThreshold = source.healthyThreshold;
      this.host = source.host;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.port = source.port;
      this.requestPath = source.requestPath;
      this.selfLink = source.selfLink;
      this.timeoutSec = source.timeoutSec;
      this.unhealthyThreshold = source.unhealthyThreshold;
    }

    /** How often (in seconds) to send a health check. The default value is 5 seconds. */
    public Integer getCheckIntervalSec() {
      return checkIntervalSec;
    }

    /** How often (in seconds) to send a health check. The default value is 5 seconds. */
    public Builder setCheckIntervalSec(Integer checkIntervalSec) {
      this.checkIntervalSec = checkIntervalSec;
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
     * A so-far unhealthy instance will be marked healthy after this many consecutive successes. The
     * default value is 2.
     */
    public Integer getHealthyThreshold() {
      return healthyThreshold;
    }

    /**
     * A so-far unhealthy instance will be marked healthy after this many consecutive successes. The
     * default value is 2.
     */
    public Builder setHealthyThreshold(Integer healthyThreshold) {
      this.healthyThreshold = healthyThreshold;
      return this;
    }

    /**
     * The value of the host header in the HTTPS health check request. If left empty (default
     * value), the public IP on behalf of which this health check is performed will be used.
     */
    public String getHost() {
      return host;
    }

    /**
     * The value of the host header in the HTTPS health check request. If left empty (default
     * value), the public IP on behalf of which this health check is performed will be used.
     */
    public Builder setHost(String host) {
      this.host = host;
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

    /** Type of the resource. */
    public String getKind() {
      return kind;
    }

    /** Type of the resource. */
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

    /** The TCP port number for the HTTPS health check request. The default value is 443. */
    public Integer getPort() {
      return port;
    }

    /** The TCP port number for the HTTPS health check request. The default value is 443. */
    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    /** The request path of the HTTPS health check request. The default value is "/". */
    public String getRequestPath() {
      return requestPath;
    }

    /** The request path of the HTTPS health check request. The default value is "/". */
    public Builder setRequestPath(String requestPath) {
      this.requestPath = requestPath;
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
     * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
     * invalid for timeoutSec to have a greater value than checkIntervalSec.
     */
    public Integer getTimeoutSec() {
      return timeoutSec;
    }

    /**
     * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
     * invalid for timeoutSec to have a greater value than checkIntervalSec.
     */
    public Builder setTimeoutSec(Integer timeoutSec) {
      this.timeoutSec = timeoutSec;
      return this;
    }

    /**
     * A so-far healthy instance will be marked unhealthy after this many consecutive failures. The
     * default value is 2.
     */
    public Integer getUnhealthyThreshold() {
      return unhealthyThreshold;
    }

    /**
     * A so-far healthy instance will be marked unhealthy after this many consecutive failures. The
     * default value is 2.
     */
    public Builder setUnhealthyThreshold(Integer unhealthyThreshold) {
      this.unhealthyThreshold = unhealthyThreshold;
      return this;
    }

    public HttpsHealthCheck2 build() {

      return new HttpsHealthCheck2(
          checkIntervalSec,
          creationTimestamp,
          description,
          healthyThreshold,
          host,
          id,
          kind,
          name,
          port,
          requestPath,
          selfLink,
          timeoutSec,
          unhealthyThreshold);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCheckIntervalSec(this.checkIntervalSec);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setHealthyThreshold(this.healthyThreshold);
      newBuilder.setHost(this.host);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setPort(this.port);
      newBuilder.setRequestPath(this.requestPath);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setTimeoutSec(this.timeoutSec);
      newBuilder.setUnhealthyThreshold(this.unhealthyThreshold);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpsHealthCheck2{"
        + "checkIntervalSec="
        + checkIntervalSec
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "healthyThreshold="
        + healthyThreshold
        + ", "
        + "host="
        + host
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
        + "port="
        + port
        + ", "
        + "requestPath="
        + requestPath
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "timeoutSec="
        + timeoutSec
        + ", "
        + "unhealthyThreshold="
        + unhealthyThreshold
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpsHealthCheck2) {
      HttpsHealthCheck2 that = (HttpsHealthCheck2) o;
      return Objects.equals(this.checkIntervalSec, that.getCheckIntervalSec())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.healthyThreshold, that.getHealthyThreshold())
          && Objects.equals(this.host, that.getHost())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.port, that.getPort())
          && Objects.equals(this.requestPath, that.getRequestPath())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.timeoutSec, that.getTimeoutSec())
          && Objects.equals(this.unhealthyThreshold, that.getUnhealthyThreshold());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        checkIntervalSec,
        creationTimestamp,
        description,
        healthyThreshold,
        host,
        id,
        kind,
        name,
        port,
        requestPath,
        selfLink,
        timeoutSec,
        unhealthyThreshold);
  }
}
