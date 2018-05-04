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
public final class TargetPoolInstanceHealth implements ApiMessage {
  private final List<HealthStatus> healthStatus;
  private final String kind;

  private TargetPoolInstanceHealth() {
    this.healthStatus = null;
    this.kind = null;
  }

  private TargetPoolInstanceHealth(List<HealthStatus> healthStatus, String kind) {
    this.healthStatus = healthStatus;
    this.kind = kind;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("healthStatus") && healthStatus != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (HealthStatus item : healthStatus) {
        stringList.add(item.toString());
      }
      fieldMap.put("healthStatus", stringList.build());
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("healthStatus")) {
      return String.valueOf(healthStatus);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public List<HealthStatus> getHealthStatusList() {
    return healthStatus;
  }

  public String getKind() {
    return kind;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetPoolInstanceHealth prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetPoolInstanceHealth getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetPoolInstanceHealth DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetPoolInstanceHealth();
  }

  public static class Builder {
    private List<HealthStatus> healthStatus;
    private String kind;

    Builder() {}

    public Builder mergeFrom(TargetPoolInstanceHealth other) {
      if (other == TargetPoolInstanceHealth.getDefaultInstance()) return this;
      if (other.getHealthStatusList() != null) {
        this.healthStatus = other.healthStatus;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      return this;
    }

    Builder(TargetPoolInstanceHealth source) {
      this.healthStatus = source.healthStatus;
      this.kind = source.kind;
    }

    public List<HealthStatus> getHealthStatusList() {
      return healthStatus;
    }

    public Builder addAllHealthStatus(List<HealthStatus> healthStatus) {
      if (this.healthStatus == null) {
        this.healthStatus = new ArrayList<>(healthStatus.size());
      }
      this.healthStatus.addAll(healthStatus);
      return this;
    }

    public Builder addHealthStatus(HealthStatus healthStatus) {
      this.healthStatus.add(healthStatus);
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public TargetPoolInstanceHealth build() {

      return new TargetPoolInstanceHealth(healthStatus, kind);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllHealthStatus(this.healthStatus);
      newBuilder.setKind(this.kind);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetPoolInstanceHealth{"
        + "healthStatus="
        + healthStatus
        + ", "
        + "kind="
        + kind
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetPoolInstanceHealth) {
      TargetPoolInstanceHealth that = (TargetPoolInstanceHealth) o;
      return Objects.equals(this.healthStatus, that.getHealthStatusList())
          && Objects.equals(this.kind, that.getKind());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthStatus, kind);
  }
}
