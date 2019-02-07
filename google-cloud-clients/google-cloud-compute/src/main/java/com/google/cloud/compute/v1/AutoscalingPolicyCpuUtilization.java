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
/** CPU utilization policy. */
public final class AutoscalingPolicyCpuUtilization implements ApiMessage {
  private final Double utilizationTarget;

  private AutoscalingPolicyCpuUtilization() {
    this.utilizationTarget = null;
  }

  private AutoscalingPolicyCpuUtilization(Double utilizationTarget) {
    this.utilizationTarget = utilizationTarget;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("utilizationTarget".equals(fieldName)) {
      return utilizationTarget;
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

  /**
   * The target CPU utilization that the autoscaler should maintain. Must be a float value in the
   * range (0, 1]. If not specified, the default is 0.6.
   *
   * <p>If the CPU level is below the target utilization, the autoscaler scales down the number of
   * instances until it reaches the minimum number of instances you specified or until the average
   * CPU of your instances reaches the target utilization.
   *
   * <p>If the average CPU is above the target utilization, the autoscaler scales up until it
   * reaches the maximum number of instances you specified or until the average utilization reaches
   * the target utilization.
   */
  public Double getUtilizationTarget() {
    return utilizationTarget;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalingPolicyCpuUtilization prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalingPolicyCpuUtilization getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalingPolicyCpuUtilization DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalingPolicyCpuUtilization();
  }

  public static class Builder {
    private Double utilizationTarget;

    Builder() {}

    public Builder mergeFrom(AutoscalingPolicyCpuUtilization other) {
      if (other == AutoscalingPolicyCpuUtilization.getDefaultInstance()) return this;
      if (other.getUtilizationTarget() != null) {
        this.utilizationTarget = other.utilizationTarget;
      }
      return this;
    }

    Builder(AutoscalingPolicyCpuUtilization source) {
      this.utilizationTarget = source.utilizationTarget;
    }

    /**
     * The target CPU utilization that the autoscaler should maintain. Must be a float value in the
     * range (0, 1]. If not specified, the default is 0.6.
     *
     * <p>If the CPU level is below the target utilization, the autoscaler scales down the number of
     * instances until it reaches the minimum number of instances you specified or until the average
     * CPU of your instances reaches the target utilization.
     *
     * <p>If the average CPU is above the target utilization, the autoscaler scales up until it
     * reaches the maximum number of instances you specified or until the average utilization
     * reaches the target utilization.
     */
    public Double getUtilizationTarget() {
      return utilizationTarget;
    }

    /**
     * The target CPU utilization that the autoscaler should maintain. Must be a float value in the
     * range (0, 1]. If not specified, the default is 0.6.
     *
     * <p>If the CPU level is below the target utilization, the autoscaler scales down the number of
     * instances until it reaches the minimum number of instances you specified or until the average
     * CPU of your instances reaches the target utilization.
     *
     * <p>If the average CPU is above the target utilization, the autoscaler scales up until it
     * reaches the maximum number of instances you specified or until the average utilization
     * reaches the target utilization.
     */
    public Builder setUtilizationTarget(Double utilizationTarget) {
      this.utilizationTarget = utilizationTarget;
      return this;
    }

    public AutoscalingPolicyCpuUtilization build() {
      return new AutoscalingPolicyCpuUtilization(utilizationTarget);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setUtilizationTarget(this.utilizationTarget);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalingPolicyCpuUtilization{" + "utilizationTarget=" + utilizationTarget + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalingPolicyCpuUtilization) {
      AutoscalingPolicyCpuUtilization that = (AutoscalingPolicyCpuUtilization) o;
      return Objects.equals(this.utilizationTarget, that.getUtilizationTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(utilizationTarget);
  }
}
