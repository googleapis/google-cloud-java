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
public final class ManagedInstanceInstanceHealth implements ApiMessage {
  private final String detailedHealthState;
  private final String healthCheck;

  private ManagedInstanceInstanceHealth() {
    this.detailedHealthState = null;
    this.healthCheck = null;
  }

  private ManagedInstanceInstanceHealth(String detailedHealthState, String healthCheck) {
    this.detailedHealthState = detailedHealthState;
    this.healthCheck = healthCheck;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("detailedHealthState".equals(fieldName)) {
      return detailedHealthState;
    }
    if ("healthCheck".equals(fieldName)) {
      return healthCheck;
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

  /** [Output Only] The current detailed instance health state. */
  public String getDetailedHealthState() {
    return detailedHealthState;
  }

  /** [Output Only] The URL for the health check that verifies whether the instance is healthy. */
  public String getHealthCheck() {
    return healthCheck;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ManagedInstanceInstanceHealth prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ManagedInstanceInstanceHealth getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ManagedInstanceInstanceHealth DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ManagedInstanceInstanceHealth();
  }

  public static class Builder {
    private String detailedHealthState;
    private String healthCheck;

    Builder() {}

    public Builder mergeFrom(ManagedInstanceInstanceHealth other) {
      if (other == ManagedInstanceInstanceHealth.getDefaultInstance()) return this;
      if (other.getDetailedHealthState() != null) {
        this.detailedHealthState = other.detailedHealthState;
      }
      if (other.getHealthCheck() != null) {
        this.healthCheck = other.healthCheck;
      }
      return this;
    }

    Builder(ManagedInstanceInstanceHealth source) {
      this.detailedHealthState = source.detailedHealthState;
      this.healthCheck = source.healthCheck;
    }

    /** [Output Only] The current detailed instance health state. */
    public String getDetailedHealthState() {
      return detailedHealthState;
    }

    /** [Output Only] The current detailed instance health state. */
    public Builder setDetailedHealthState(String detailedHealthState) {
      this.detailedHealthState = detailedHealthState;
      return this;
    }

    /** [Output Only] The URL for the health check that verifies whether the instance is healthy. */
    public String getHealthCheck() {
      return healthCheck;
    }

    /** [Output Only] The URL for the health check that verifies whether the instance is healthy. */
    public Builder setHealthCheck(String healthCheck) {
      this.healthCheck = healthCheck;
      return this;
    }

    public ManagedInstanceInstanceHealth build() {

      return new ManagedInstanceInstanceHealth(detailedHealthState, healthCheck);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDetailedHealthState(this.detailedHealthState);
      newBuilder.setHealthCheck(this.healthCheck);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ManagedInstanceInstanceHealth{"
        + "detailedHealthState="
        + detailedHealthState
        + ", "
        + "healthCheck="
        + healthCheck
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ManagedInstanceInstanceHealth) {
      ManagedInstanceInstanceHealth that = (ManagedInstanceInstanceHealth) o;
      return Objects.equals(this.detailedHealthState, that.getDetailedHealthState())
          && Objects.equals(this.healthCheck, that.getHealthCheck());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailedHealthState, healthCheck);
  }
}
