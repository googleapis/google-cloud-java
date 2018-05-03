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
public final class AutoscalingPolicy implements ApiMessage {
  private final Integer coolDownPeriodSec;
  private final AutoscalingPolicyCpuUtilization cpuUtilization;
  private final List<AutoscalingPolicyCustomMetricUtilization> customMetricUtilizations;
  private final AutoscalingPolicyLoadBalancingUtilization loadBalancingUtilization;
  private final Integer maxNumReplicas;
  private final Integer minNumReplicas;

  private AutoscalingPolicy() {
    this.coolDownPeriodSec = null;
    this.cpuUtilization = null;
    this.customMetricUtilizations = null;
    this.loadBalancingUtilization = null;
    this.maxNumReplicas = null;
    this.minNumReplicas = null;
  }

  private AutoscalingPolicy(
      Integer coolDownPeriodSec,
      AutoscalingPolicyCpuUtilization cpuUtilization,
      List<AutoscalingPolicyCustomMetricUtilization> customMetricUtilizations,
      AutoscalingPolicyLoadBalancingUtilization loadBalancingUtilization,
      Integer maxNumReplicas,
      Integer minNumReplicas) {
    this.coolDownPeriodSec = coolDownPeriodSec;
    this.cpuUtilization = cpuUtilization;
    this.customMetricUtilizations = customMetricUtilizations;
    this.loadBalancingUtilization = loadBalancingUtilization;
    this.maxNumReplicas = maxNumReplicas;
    this.minNumReplicas = minNumReplicas;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("coolDownPeriodSec")) {
      return coolDownPeriodSec;
    }
    if (fieldName.equals("cpuUtilization")) {
      return cpuUtilization;
    }
    if (fieldName.equals("customMetricUtilizations")) {
      return customMetricUtilizations;
    }
    if (fieldName.equals("loadBalancingUtilization")) {
      return loadBalancingUtilization;
    }
    if (fieldName.equals("maxNumReplicas")) {
      return maxNumReplicas;
    }
    if (fieldName.equals("minNumReplicas")) {
      return minNumReplicas;
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

  public Integer getCoolDownPeriodSec() {
    return coolDownPeriodSec;
  }

  public AutoscalingPolicyCpuUtilization getCpuUtilization() {
    return cpuUtilization;
  }

  public List<AutoscalingPolicyCustomMetricUtilization> getCustomMetricUtilizationsList() {
    return customMetricUtilizations;
  }

  public AutoscalingPolicyLoadBalancingUtilization getLoadBalancingUtilization() {
    return loadBalancingUtilization;
  }

  public Integer getMaxNumReplicas() {
    return maxNumReplicas;
  }

  public Integer getMinNumReplicas() {
    return minNumReplicas;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalingPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalingPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalingPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalingPolicy();
  }

  public static class Builder {
    private Integer coolDownPeriodSec;
    private AutoscalingPolicyCpuUtilization cpuUtilization;
    private List<AutoscalingPolicyCustomMetricUtilization> customMetricUtilizations;
    private AutoscalingPolicyLoadBalancingUtilization loadBalancingUtilization;
    private Integer maxNumReplicas;
    private Integer minNumReplicas;

    Builder() {}

    public Builder mergeFrom(AutoscalingPolicy other) {
      if (other == AutoscalingPolicy.getDefaultInstance()) return this;
      if (other.getCoolDownPeriodSec() != null) {
        this.coolDownPeriodSec = other.coolDownPeriodSec;
      }
      if (other.getCpuUtilization() != null) {
        this.cpuUtilization = other.cpuUtilization;
      }
      if (other.getCustomMetricUtilizationsList() != null) {
        this.customMetricUtilizations = other.customMetricUtilizations;
      }
      if (other.getLoadBalancingUtilization() != null) {
        this.loadBalancingUtilization = other.loadBalancingUtilization;
      }
      if (other.getMaxNumReplicas() != null) {
        this.maxNumReplicas = other.maxNumReplicas;
      }
      if (other.getMinNumReplicas() != null) {
        this.minNumReplicas = other.minNumReplicas;
      }
      return this;
    }

    Builder(AutoscalingPolicy source) {
      this.coolDownPeriodSec = source.coolDownPeriodSec;
      this.cpuUtilization = source.cpuUtilization;
      this.customMetricUtilizations = source.customMetricUtilizations;
      this.loadBalancingUtilization = source.loadBalancingUtilization;
      this.maxNumReplicas = source.maxNumReplicas;
      this.minNumReplicas = source.minNumReplicas;
    }

    public Integer getCoolDownPeriodSec() {
      return coolDownPeriodSec;
    }

    public Builder setCoolDownPeriodSec(Integer coolDownPeriodSec) {
      this.coolDownPeriodSec = coolDownPeriodSec;
      return this;
    }

    public AutoscalingPolicyCpuUtilization getCpuUtilization() {
      return cpuUtilization;
    }

    public Builder setCpuUtilization(AutoscalingPolicyCpuUtilization cpuUtilization) {
      this.cpuUtilization = cpuUtilization;
      return this;
    }

    public List<AutoscalingPolicyCustomMetricUtilization> getCustomMetricUtilizationsList() {
      return customMetricUtilizations;
    }

    public Builder addAllCustomMetricUtilizations(
        List<AutoscalingPolicyCustomMetricUtilization> customMetricUtilizations) {
      if (this.customMetricUtilizations == null) {
        this.customMetricUtilizations = new ArrayList<>(customMetricUtilizations.size());
      }
      this.customMetricUtilizations.addAll(customMetricUtilizations);
      return this;
    }

    public Builder addCustomMetricUtilizations(
        AutoscalingPolicyCustomMetricUtilization customMetricUtilizations) {
      this.customMetricUtilizations.add(customMetricUtilizations);
      return this;
    }

    public AutoscalingPolicyLoadBalancingUtilization getLoadBalancingUtilization() {
      return loadBalancingUtilization;
    }

    public Builder setLoadBalancingUtilization(
        AutoscalingPolicyLoadBalancingUtilization loadBalancingUtilization) {
      this.loadBalancingUtilization = loadBalancingUtilization;
      return this;
    }

    public Integer getMaxNumReplicas() {
      return maxNumReplicas;
    }

    public Builder setMaxNumReplicas(Integer maxNumReplicas) {
      this.maxNumReplicas = maxNumReplicas;
      return this;
    }

    public Integer getMinNumReplicas() {
      return minNumReplicas;
    }

    public Builder setMinNumReplicas(Integer minNumReplicas) {
      this.minNumReplicas = minNumReplicas;
      return this;
    }

    public AutoscalingPolicy build() {

      return new AutoscalingPolicy(
          coolDownPeriodSec,
          cpuUtilization,
          customMetricUtilizations,
          loadBalancingUtilization,
          maxNumReplicas,
          minNumReplicas);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCoolDownPeriodSec(this.coolDownPeriodSec);
      newBuilder.setCpuUtilization(this.cpuUtilization);
      newBuilder.addAllCustomMetricUtilizations(this.customMetricUtilizations);
      newBuilder.setLoadBalancingUtilization(this.loadBalancingUtilization);
      newBuilder.setMaxNumReplicas(this.maxNumReplicas);
      newBuilder.setMinNumReplicas(this.minNumReplicas);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalingPolicy{"
        + "coolDownPeriodSec="
        + coolDownPeriodSec
        + ", "
        + "cpuUtilization="
        + cpuUtilization
        + ", "
        + "customMetricUtilizations="
        + customMetricUtilizations
        + ", "
        + "loadBalancingUtilization="
        + loadBalancingUtilization
        + ", "
        + "maxNumReplicas="
        + maxNumReplicas
        + ", "
        + "minNumReplicas="
        + minNumReplicas
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalingPolicy) {
      AutoscalingPolicy that = (AutoscalingPolicy) o;
      return Objects.equals(this.coolDownPeriodSec, that.getCoolDownPeriodSec())
          && Objects.equals(this.cpuUtilization, that.getCpuUtilization())
          && Objects.equals(this.customMetricUtilizations, that.getCustomMetricUtilizationsList())
          && Objects.equals(this.loadBalancingUtilization, that.getLoadBalancingUtilization())
          && Objects.equals(this.maxNumReplicas, that.getMaxNumReplicas())
          && Objects.equals(this.minNumReplicas, that.getMinNumReplicas());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        coolDownPeriodSec,
        cpuUtilization,
        customMetricUtilizations,
        loadBalancingUtilization,
        maxNumReplicas,
        minNumReplicas);
  }
}
