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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class HealthCheck implements ApiMessage {
  private final Integer checkIntervalSec;
  private final String creationTimestamp;
  private final String description;
  private final Integer healthyThreshold;
  private final HTTPHealthCheck httpHealthCheck;
  private final HTTPSHealthCheck httpsHealthCheck;
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
      HTTPHealthCheck httpHealthCheck,
      HTTPSHealthCheck httpsHealthCheck,
      String id,
      String kind,
      String name,
      String selfLink,
      SSLHealthCheck sslHealthCheck,
      TCPHealthCheck tcpHealthCheck,
      Integer timeoutSec,
      String type,
      Integer unhealthyThreshold
      ) {
    this.checkIntervalSec = checkIntervalSec;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.healthyThreshold = healthyThreshold;
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("checkIntervalSec") && checkIntervalSec != null) {
      fieldMap.put("checkIntervalSec", Collections.singletonList(String.valueOf(checkIntervalSec)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("healthyThreshold") && healthyThreshold != null) {
      fieldMap.put("healthyThreshold", Collections.singletonList(String.valueOf(healthyThreshold)));
    }
    if (fieldNames.contains("httpHealthCheck") && httpHealthCheck != null) {
      fieldMap.put("httpHealthCheck", Collections.singletonList(String.valueOf(httpHealthCheck)));
    }
    if (fieldNames.contains("httpsHealthCheck") && httpsHealthCheck != null) {
      fieldMap.put("httpsHealthCheck", Collections.singletonList(String.valueOf(httpsHealthCheck)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("sslHealthCheck") && sslHealthCheck != null) {
      fieldMap.put("sslHealthCheck", Collections.singletonList(String.valueOf(sslHealthCheck)));
    }
    if (fieldNames.contains("tcpHealthCheck") && tcpHealthCheck != null) {
      fieldMap.put("tcpHealthCheck", Collections.singletonList(String.valueOf(tcpHealthCheck)));
    }
    if (fieldNames.contains("timeoutSec") && timeoutSec != null) {
      fieldMap.put("timeoutSec", Collections.singletonList(String.valueOf(timeoutSec)));
    }
    if (fieldNames.contains("type") && type != null) {
      fieldMap.put("type", Collections.singletonList(String.valueOf(type)));
    }
    if (fieldNames.contains("unhealthyThreshold") && unhealthyThreshold != null) {
      fieldMap.put("unhealthyThreshold", Collections.singletonList(String.valueOf(unhealthyThreshold)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("checkIntervalSec")) {
      return String.valueOf(checkIntervalSec);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("healthyThreshold")) {
      return String.valueOf(healthyThreshold);
    }
    if (fieldName.equals("httpHealthCheck")) {
      return String.valueOf(httpHealthCheck);
    }
    if (fieldName.equals("httpsHealthCheck")) {
      return String.valueOf(httpsHealthCheck);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("sslHealthCheck")) {
      return String.valueOf(sslHealthCheck);
    }
    if (fieldName.equals("tcpHealthCheck")) {
      return String.valueOf(tcpHealthCheck);
    }
    if (fieldName.equals("timeoutSec")) {
      return String.valueOf(timeoutSec);
    }
    if (fieldName.equals("type")) {
      return String.valueOf(type);
    }
    if (fieldName.equals("unhealthyThreshold")) {
      return String.valueOf(unhealthyThreshold);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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

  public HTTPHealthCheck getHttpHealthCheck() {
    return httpHealthCheck;
  }

  public HTTPSHealthCheck getHttpsHealthCheck() {
    return httpsHealthCheck;
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

  public String getSelfLink() {
    return selfLink;
  }

  public SSLHealthCheck getSslHealthCheck() {
    return sslHealthCheck;
  }

  public TCPHealthCheck getTcpHealthCheck() {
    return tcpHealthCheck;
  }

  public Integer getTimeoutSec() {
    return timeoutSec;
  }

  public String getType() {
    return type;
  }

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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
    private HTTPHealthCheck httpHealthCheck;
    private HTTPSHealthCheck httpsHealthCheck;
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

    public HTTPHealthCheck getHttpHealthCheck() {
      return httpHealthCheck;
    }

    public Builder setHttpHealthCheck(HTTPHealthCheck httpHealthCheck) {
      this.httpHealthCheck = httpHealthCheck;
      return this;
    }

    public HTTPSHealthCheck getHttpsHealthCheck() {
      return httpsHealthCheck;
    }

    public Builder setHttpsHealthCheck(HTTPSHealthCheck httpsHealthCheck) {
      this.httpsHealthCheck = httpsHealthCheck;
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

    public String getSelfLink() {
      return selfLink;
    }

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

    public Integer getTimeoutSec() {
      return timeoutSec;
    }

    public Builder setTimeoutSec(Integer timeoutSec) {
      this.timeoutSec = timeoutSec;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public Integer getUnhealthyThreshold() {
      return unhealthyThreshold;
    }

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
        unhealthyThreshold
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCheckIntervalSec(this.checkIntervalSec);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setHealthyThreshold(this.healthyThreshold);
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
        + "checkIntervalSec=" + checkIntervalSec + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "healthyThreshold=" + healthyThreshold + ", "
        + "httpHealthCheck=" + httpHealthCheck + ", "
        + "httpsHealthCheck=" + httpsHealthCheck + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "selfLink=" + selfLink + ", "
        + "sslHealthCheck=" + sslHealthCheck + ", "
        + "tcpHealthCheck=" + tcpHealthCheck + ", "
        + "timeoutSec=" + timeoutSec + ", "
        + "type=" + type + ", "
        + "unhealthyThreshold=" + unhealthyThreshold
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthCheck) {
      HealthCheck that = (HealthCheck) o;
      return
          Objects.equals(this.checkIntervalSec, that.getCheckIntervalSec()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.healthyThreshold, that.getHealthyThreshold()) &&
          Objects.equals(this.httpHealthCheck, that.getHttpHealthCheck()) &&
          Objects.equals(this.httpsHealthCheck, that.getHttpsHealthCheck()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.sslHealthCheck, that.getSslHealthCheck()) &&
          Objects.equals(this.tcpHealthCheck, that.getTcpHealthCheck()) &&
          Objects.equals(this.timeoutSec, that.getTimeoutSec()) &&
          Objects.equals(this.type, that.getType()) &&
          Objects.equals(this.unhealthyThreshold, that.getUnhealthyThreshold())
          ;
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
      unhealthyThreshold
    );
  }
}
