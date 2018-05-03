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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class BackendServiceGroupHealth implements ApiMessage {
  private final List<HealthStatus> healthStatus;
  private final String kind;

  private BackendServiceGroupHealth() {
    this.healthStatus = null;
    this.kind = null;
  }

  private BackendServiceGroupHealth(List<HealthStatus> healthStatus, String kind) {
    this.healthStatus = healthStatus;
    this.kind = kind;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("healthStatus")) {
      return healthStatus;
    }
    if (fieldName.equals("kind")) {
      return kind;
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

  public List<HealthStatus> getHealthStatusList() {
    return healthStatus;
  }

  public String getKind() {
    return kind;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServiceGroupHealth prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServiceGroupHealth getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServiceGroupHealth DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServiceGroupHealth();
  }

  public static class Builder {
    private List<HealthStatus> healthStatus;
    private String kind;

    Builder() {}

    public Builder mergeFrom(BackendServiceGroupHealth other) {
      if (other == BackendServiceGroupHealth.getDefaultInstance()) return this;
      if (other.getHealthStatusList() != null) {
        this.healthStatus = other.healthStatus;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      return this;
    }

    Builder(BackendServiceGroupHealth source) {
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

    public BackendServiceGroupHealth build() {

      return new BackendServiceGroupHealth(healthStatus, kind);
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
    return "BackendServiceGroupHealth{"
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
    if (o instanceof BackendServiceGroupHealth) {
      BackendServiceGroupHealth that = (BackendServiceGroupHealth) o;
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
