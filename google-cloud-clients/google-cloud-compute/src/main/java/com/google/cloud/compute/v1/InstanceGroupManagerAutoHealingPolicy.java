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
public final class InstanceGroupManagerAutoHealingPolicy implements ApiMessage {
  private final String healthCheck;
  private final Integer initialDelaySec;

  private InstanceGroupManagerAutoHealingPolicy() {
    this.healthCheck = null;
    this.initialDelaySec = null;
  }

  private InstanceGroupManagerAutoHealingPolicy(String healthCheck, Integer initialDelaySec) {
    this.healthCheck = healthCheck;
    this.initialDelaySec = initialDelaySec;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("healthCheck".equals(fieldName)) {
      return healthCheck;
    }
    if ("initialDelaySec".equals(fieldName)) {
      return initialDelaySec;
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

  /** The URL for the health check that signals autohealing. */
  public String getHealthCheck() {
    return healthCheck;
  }

  /**
   * The number of seconds that the managed instance group waits before it applies autohealing
   * policies to new instances or recently recreated instances. This initial delay allows instances
   * to initialize and run their startup scripts before the instance group determines that they are
   * UNHEALTHY. This prevents the managed instance group from recreating its instances prematurely.
   * This value must be from range [0, 3600].
   */
  public Integer getInitialDelaySec() {
    return initialDelaySec;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerAutoHealingPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerAutoHealingPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerAutoHealingPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerAutoHealingPolicy();
  }

  public static class Builder {
    private String healthCheck;
    private Integer initialDelaySec;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerAutoHealingPolicy other) {
      if (other == InstanceGroupManagerAutoHealingPolicy.getDefaultInstance()) return this;
      if (other.getHealthCheck() != null) {
        this.healthCheck = other.healthCheck;
      }
      if (other.getInitialDelaySec() != null) {
        this.initialDelaySec = other.initialDelaySec;
      }
      return this;
    }

    Builder(InstanceGroupManagerAutoHealingPolicy source) {
      this.healthCheck = source.healthCheck;
      this.initialDelaySec = source.initialDelaySec;
    }

    /** The URL for the health check that signals autohealing. */
    public String getHealthCheck() {
      return healthCheck;
    }

    /** The URL for the health check that signals autohealing. */
    public Builder setHealthCheck(String healthCheck) {
      this.healthCheck = healthCheck;
      return this;
    }

    /**
     * The number of seconds that the managed instance group waits before it applies autohealing
     * policies to new instances or recently recreated instances. This initial delay allows
     * instances to initialize and run their startup scripts before the instance group determines
     * that they are UNHEALTHY. This prevents the managed instance group from recreating its
     * instances prematurely. This value must be from range [0, 3600].
     */
    public Integer getInitialDelaySec() {
      return initialDelaySec;
    }

    /**
     * The number of seconds that the managed instance group waits before it applies autohealing
     * policies to new instances or recently recreated instances. This initial delay allows
     * instances to initialize and run their startup scripts before the instance group determines
     * that they are UNHEALTHY. This prevents the managed instance group from recreating its
     * instances prematurely. This value must be from range [0, 3600].
     */
    public Builder setInitialDelaySec(Integer initialDelaySec) {
      this.initialDelaySec = initialDelaySec;
      return this;
    }

    public InstanceGroupManagerAutoHealingPolicy build() {

      return new InstanceGroupManagerAutoHealingPolicy(healthCheck, initialDelaySec);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHealthCheck(this.healthCheck);
      newBuilder.setInitialDelaySec(this.initialDelaySec);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerAutoHealingPolicy{"
        + "healthCheck="
        + healthCheck
        + ", "
        + "initialDelaySec="
        + initialDelaySec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerAutoHealingPolicy) {
      InstanceGroupManagerAutoHealingPolicy that = (InstanceGroupManagerAutoHealingPolicy) o;
      return Objects.equals(this.healthCheck, that.getHealthCheck())
          && Objects.equals(this.initialDelaySec, that.getInitialDelaySec());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthCheck, initialDelaySec);
  }
}
