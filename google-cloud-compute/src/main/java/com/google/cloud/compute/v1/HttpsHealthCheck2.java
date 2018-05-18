/*
 * Copyright 2018 Google LLC
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
    if (fieldName.equals("checkIntervalSec")) {
      return checkIntervalSec;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("healthyThreshold")) {
      return healthyThreshold;
    }
    if (fieldName.equals("host")) {
      return host;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("port")) {
      return port;
    }
    if (fieldName.equals("requestPath")) {
      return requestPath;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("timeoutSec")) {
      return timeoutSec;
    }
    if (fieldName.equals("unhealthyThreshold")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public Integer getCheckIntervalSec() {
    return checkIntervalSec;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public Integer getHealthyThreshold() {
    return healthyThreshold;
  }

  public String getHost() {
    return host;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public Integer getPort() {
    return port;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public Integer getTimeoutSec() {
    return timeoutSec;
  }

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

    public Integer getCheckIntervalSec() {
      return checkIntervalSec;
    }

    public Builder setCheckIntervalSec(Integer checkIntervalSec) {
      this.checkIntervalSec = checkIntervalSec;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

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

    public Integer getHealthyThreshold() {
      return healthyThreshold;
    }

    public Builder setHealthyThreshold(Integer healthyThreshold) {
      this.healthyThreshold = healthyThreshold;
      return this;
    }

    public String getHost() {
      return host;
    }

    public Builder setHost(String host) {
      this.host = host;
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

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getPort() {
      return port;
    }

    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public String getRequestPath() {
      return requestPath;
    }

    public Builder setRequestPath(String requestPath) {
      this.requestPath = requestPath;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Integer getTimeoutSec() {
      return timeoutSec;
    }

    public Builder setTimeoutSec(Integer timeoutSec) {
      this.timeoutSec = timeoutSec;
      return this;
    }

    public Integer getUnhealthyThreshold() {
      return unhealthyThreshold;
    }

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
