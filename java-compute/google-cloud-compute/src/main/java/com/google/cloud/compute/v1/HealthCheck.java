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
 * An HealthCheck resource. This resource defines a template for how individual virtual machines
 * should be checked for health, via one of the supported protocols.
 */
public final class HealthCheck implements ApiMessage {
  private final Integer checkIntervalSec;
  private final String creationTimestamp;
  private final String description;
  private final Integer healthyThreshold;
  private final Http2HealthCheck http2HealthCheck;
  private final HttpHealthCheck httpHealthCheck;
  private final HttpSHealthCheck httpsHealthCheck;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;
  private final SSLHealthCheck sslHealthCheck;
  private final TCPHealthCheck tcpHealthCheck;
  private final Integer timeoutSec;
  private final String type;
  private final Integer unhealthyThreshold;

  private HealthCheck() {
    this.checkIntervalSec = null;
    this.creationTimestamp = null;
    this.description = null;
    this.healthyThreshold = null;
    this.http2HealthCheck = null;
    this.httpHealthCheck = null;
    this.httpsHealthCheck = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
    this.sslHealthCheck = null;
    this.tcpHealthCheck = null;
    this.timeoutSec = null;
    this.type = null;
    this.unhealthyThreshold = null;
  }

  private HealthCheck(
      Integer checkIntervalSec,
      String creationTimestamp,
      String description,
      Integer healthyThreshold,
      Http2HealthCheck http2HealthCheck,
      HttpHealthCheck httpHealthCheck,
      HttpSHealthCheck httpsHealthCheck,
      String id,
      String kind,
      String name,
      String selfLink,
      SSLHealthCheck sslHealthCheck,
      TCPHealthCheck tcpHealthCheck,
      Integer timeoutSec,
      String type,
      Integer unhealthyThreshold) {
    this.checkIntervalSec = checkIntervalSec;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.healthyThreshold = healthyThreshold;
    this.http2HealthCheck = http2HealthCheck;
    this.httpHealthCheck = httpHealthCheck;
    this.httpsHealthCheck = httpsHealthCheck;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
    this.sslHealthCheck = sslHealthCheck;
    this.tcpHealthCheck = tcpHealthCheck;
    this.timeoutSec = timeoutSec;
    this.type = type;
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
    if ("http2HealthCheck".equals(fieldName)) {
      return http2HealthCheck;
    }
    if ("httpHealthCheck".equals(fieldName)) {
      return httpHealthCheck;
    }
    if ("httpsHealthCheck".equals(fieldName)) {
      return httpsHealthCheck;
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
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sslHealthCheck".equals(fieldName)) {
      return sslHealthCheck;
    }
    if ("tcpHealthCheck".equals(fieldName)) {
      return tcpHealthCheck;
    }
    if ("timeoutSec".equals(fieldName)) {
      return timeoutSec;
    }
    if ("type".equals(fieldName)) {
      return type;
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

  /** [Output Only] Creation timestamp in 3339 text format. */
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

  public Http2HealthCheck getHttp2HealthCheck() {
    return http2HealthCheck;
  }

  public HttpHealthCheck getHttpHealthCheck() {
    return httpHealthCheck;
  }

  public HttpSHealthCheck getHttpsHealthCheck() {
    return httpsHealthCheck;
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

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public SSLHealthCheck getSslHealthCheck() {
    return sslHealthCheck;
  }

  public TCPHealthCheck getTcpHealthCheck() {
    return tcpHealthCheck;
  }

  /**
   * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
   * invalid for timeoutSec to have greater value than checkIntervalSec.
   */
  public Integer getTimeoutSec() {
    return timeoutSec;
  }

  /**
   * Specifies the type of the healthCheck, either TCP, SSL, HTTP or HTTPS. If not specified, the
   * default is TCP. Exactly one of the protocol-specific health check field must be specified,
   * which must match type field.
   */
  public String getType() {
    return type;
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

  public static Builder newBuilder(HealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthCheck();
  }

  public static class Builder {
    private Integer checkIntervalSec;
    private String creationTimestamp;
    private String description;
    private Integer healthyThreshold;
    private Http2HealthCheck http2HealthCheck;
    private HttpHealthCheck httpHealthCheck;
    private HttpSHealthCheck httpsHealthCheck;
    private String id;
    private String kind;
    private String name;
    private String selfLink;
    private SSLHealthCheck sslHealthCheck;
    private TCPHealthCheck tcpHealthCheck;
    private Integer timeoutSec;
    private String type;
    private Integer unhealthyThreshold;

    Builder() {}

    public Builder mergeFrom(HealthCheck other) {
      if (other == HealthCheck.getDefaultInstance()) return this;
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
      if (other.getHttp2HealthCheck() != null) {
        this.http2HealthCheck = other.http2HealthCheck;
      }
      if (other.getHttpHealthCheck() != null) {
        this.httpHealthCheck = other.httpHealthCheck;
      }
      if (other.getHttpsHealthCheck() != null) {
        this.httpsHealthCheck = other.httpsHealthCheck;
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
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSslHealthCheck() != null) {
        this.sslHealthCheck = other.sslHealthCheck;
      }
      if (other.getTcpHealthCheck() != null) {
        this.tcpHealthCheck = other.tcpHealthCheck;
      }
      if (other.getTimeoutSec() != null) {
        this.timeoutSec = other.timeoutSec;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      if (other.getUnhealthyThreshold() != null) {
        this.unhealthyThreshold = other.unhealthyThreshold;
      }
      return this;
    }

    Builder(HealthCheck source) {
      this.checkIntervalSec = source.checkIntervalSec;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.healthyThreshold = source.healthyThreshold;
      this.http2HealthCheck = source.http2HealthCheck;
      this.httpHealthCheck = source.httpHealthCheck;
      this.httpsHealthCheck = source.httpsHealthCheck;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.sslHealthCheck = source.sslHealthCheck;
      this.tcpHealthCheck = source.tcpHealthCheck;
      this.timeoutSec = source.timeoutSec;
      this.type = source.type;
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

    /** [Output Only] Creation timestamp in 3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in 3339 text format. */
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

    public Http2HealthCheck getHttp2HealthCheck() {
      return http2HealthCheck;
    }

    public Builder setHttp2HealthCheck(Http2HealthCheck http2HealthCheck) {
      this.http2HealthCheck = http2HealthCheck;
      return this;
    }

    public HttpHealthCheck getHttpHealthCheck() {
      return httpHealthCheck;
    }

    public Builder setHttpHealthCheck(HttpHealthCheck httpHealthCheck) {
      this.httpHealthCheck = httpHealthCheck;
      return this;
    }

    public HttpSHealthCheck getHttpsHealthCheck() {
      return httpsHealthCheck;
    }

    public Builder setHttpsHealthCheck(HttpSHealthCheck httpsHealthCheck) {
      this.httpsHealthCheck = httpsHealthCheck;
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

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public SSLHealthCheck getSslHealthCheck() {
      return sslHealthCheck;
    }

    public Builder setSslHealthCheck(SSLHealthCheck sslHealthCheck) {
      this.sslHealthCheck = sslHealthCheck;
      return this;
    }

    public TCPHealthCheck getTcpHealthCheck() {
      return tcpHealthCheck;
    }

    public Builder setTcpHealthCheck(TCPHealthCheck tcpHealthCheck) {
      this.tcpHealthCheck = tcpHealthCheck;
      return this;
    }

    /**
     * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
     * invalid for timeoutSec to have greater value than checkIntervalSec.
     */
    public Integer getTimeoutSec() {
      return timeoutSec;
    }

    /**
     * How long (in seconds) to wait before claiming failure. The default value is 5 seconds. It is
     * invalid for timeoutSec to have greater value than checkIntervalSec.
     */
    public Builder setTimeoutSec(Integer timeoutSec) {
      this.timeoutSec = timeoutSec;
      return this;
    }

    /**
     * Specifies the type of the healthCheck, either TCP, SSL, HTTP or HTTPS. If not specified, the
     * default is TCP. Exactly one of the protocol-specific health check field must be specified,
     * which must match type field.
     */
    public String getType() {
      return type;
    }

    /**
     * Specifies the type of the healthCheck, either TCP, SSL, HTTP or HTTPS. If not specified, the
     * default is TCP. Exactly one of the protocol-specific health check field must be specified,
     * which must match type field.
     */
    public Builder setType(String type) {
      this.type = type;
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

    public HealthCheck build() {

      return new HealthCheck(
          checkIntervalSec,
          creationTimestamp,
          description,
          healthyThreshold,
          http2HealthCheck,
          httpHealthCheck,
          httpsHealthCheck,
          id,
          kind,
          name,
          selfLink,
          sslHealthCheck,
          tcpHealthCheck,
          timeoutSec,
          type,
          unhealthyThreshold);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCheckIntervalSec(this.checkIntervalSec);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setHealthyThreshold(this.healthyThreshold);
      newBuilder.setHttp2HealthCheck(this.http2HealthCheck);
      newBuilder.setHttpHealthCheck(this.httpHealthCheck);
      newBuilder.setHttpsHealthCheck(this.httpsHealthCheck);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSslHealthCheck(this.sslHealthCheck);
      newBuilder.setTcpHealthCheck(this.tcpHealthCheck);
      newBuilder.setTimeoutSec(this.timeoutSec);
      newBuilder.setType(this.type);
      newBuilder.setUnhealthyThreshold(this.unhealthyThreshold);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthCheck{"
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
        + "http2HealthCheck="
        + http2HealthCheck
        + ", "
        + "httpHealthCheck="
        + httpHealthCheck
        + ", "
        + "httpsHealthCheck="
        + httpsHealthCheck
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
        + "selfLink="
        + selfLink
        + ", "
        + "sslHealthCheck="
        + sslHealthCheck
        + ", "
        + "tcpHealthCheck="
        + tcpHealthCheck
        + ", "
        + "timeoutSec="
        + timeoutSec
        + ", "
        + "type="
        + type
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
    if (o instanceof HealthCheck) {
      HealthCheck that = (HealthCheck) o;
      return Objects.equals(this.checkIntervalSec, that.getCheckIntervalSec())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.healthyThreshold, that.getHealthyThreshold())
          && Objects.equals(this.http2HealthCheck, that.getHttp2HealthCheck())
          && Objects.equals(this.httpHealthCheck, that.getHttpHealthCheck())
          && Objects.equals(this.httpsHealthCheck, that.getHttpsHealthCheck())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sslHealthCheck, that.getSslHealthCheck())
          && Objects.equals(this.tcpHealthCheck, that.getTcpHealthCheck())
          && Objects.equals(this.timeoutSec, that.getTimeoutSec())
          && Objects.equals(this.type, that.getType())
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
        http2HealthCheck,
        httpHealthCheck,
        httpsHealthCheck,
        id,
        kind,
        name,
        selfLink,
        sslHealthCheck,
        tcpHealthCheck,
        timeoutSec,
        type,
        unhealthyThreshold);
  }
}
