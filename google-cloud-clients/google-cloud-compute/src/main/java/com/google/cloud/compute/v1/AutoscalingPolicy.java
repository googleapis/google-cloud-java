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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Cloud Autoscaler policy. */
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
    if ("coolDownPeriodSec".equals(fieldName)) {
      return coolDownPeriodSec;
    }
    if ("cpuUtilization".equals(fieldName)) {
      return cpuUtilization;
    }
    if ("customMetricUtilizations".equals(fieldName)) {
      return customMetricUtilizations;
    }
    if ("loadBalancingUtilization".equals(fieldName)) {
      return loadBalancingUtilization;
    }
    if ("maxNumReplicas".equals(fieldName)) {
      return maxNumReplicas;
    }
    if ("minNumReplicas".equals(fieldName)) {
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

  /**
   * The number of seconds that the autoscaler should wait before it starts collecting information
   * from a new instance. This prevents the autoscaler from collecting information when the instance
   * is initializing, during which the collected usage would not be reliable. The default time
   * autoscaler waits is 60 seconds.
   *
   * <p>Virtual machine initialization times might vary because of numerous factors. We recommend
   * that you test how long an instance may take to initialize. To do this, create an instance and
   * time the startup process.
   */
  public Integer getCoolDownPeriodSec() {
    return coolDownPeriodSec;
  }

  /**
   * Defines the CPU utilization policy that allows the autoscaler to scale based on the average CPU
   * utilization of a managed instance group.
   */
  public AutoscalingPolicyCpuUtilization getCpuUtilization() {
    return cpuUtilization;
  }

  /** Configuration parameters of autoscaling based on a custom metric. */
  public List<AutoscalingPolicyCustomMetricUtilization> getCustomMetricUtilizationsList() {
    return customMetricUtilizations;
  }

  /** Configuration parameters of autoscaling based on load balancer. */
  public AutoscalingPolicyLoadBalancingUtilization getLoadBalancingUtilization() {
    return loadBalancingUtilization;
  }

  /**
   * The maximum number of instances that the autoscaler can scale up to. This is required when
   * creating or updating an autoscaler. The maximum number of replicas should not be lower than
   * minimal number of replicas.
   */
  public Integer getMaxNumReplicas() {
    return maxNumReplicas;
  }

  /**
   * The minimum number of replicas that the autoscaler can scale down to. This cannot be less than
   * 0. If not provided, autoscaler will choose a default value depending on maximum number of
   * instances allowed.
   */
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

    /**
     * The number of seconds that the autoscaler should wait before it starts collecting information
     * from a new instance. This prevents the autoscaler from collecting information when the
     * instance is initializing, during which the collected usage would not be reliable. The default
     * time autoscaler waits is 60 seconds.
     *
     * <p>Virtual machine initialization times might vary because of numerous factors. We recommend
     * that you test how long an instance may take to initialize. To do this, create an instance and
     * time the startup process.
     */
    public Integer getCoolDownPeriodSec() {
      return coolDownPeriodSec;
    }

    /**
     * The number of seconds that the autoscaler should wait before it starts collecting information
     * from a new instance. This prevents the autoscaler from collecting information when the
     * instance is initializing, during which the collected usage would not be reliable. The default
     * time autoscaler waits is 60 seconds.
     *
     * <p>Virtual machine initialization times might vary because of numerous factors. We recommend
     * that you test how long an instance may take to initialize. To do this, create an instance and
     * time the startup process.
     */
    public Builder setCoolDownPeriodSec(Integer coolDownPeriodSec) {
      this.coolDownPeriodSec = coolDownPeriodSec;
      return this;
    }

    /**
     * Defines the CPU utilization policy that allows the autoscaler to scale based on the average
     * CPU utilization of a managed instance group.
     */
    public AutoscalingPolicyCpuUtilization getCpuUtilization() {
      return cpuUtilization;
    }

    /**
     * Defines the CPU utilization policy that allows the autoscaler to scale based on the average
     * CPU utilization of a managed instance group.
     */
    public Builder setCpuUtilization(AutoscalingPolicyCpuUtilization cpuUtilization) {
      this.cpuUtilization = cpuUtilization;
      return this;
    }

    /** Configuration parameters of autoscaling based on a custom metric. */
    public List<AutoscalingPolicyCustomMetricUtilization> getCustomMetricUtilizationsList() {
      return customMetricUtilizations;
    }

    /** Configuration parameters of autoscaling based on a custom metric. */
    public Builder addAllCustomMetricUtilizations(
        List<AutoscalingPolicyCustomMetricUtilization> customMetricUtilizations) {
      if (this.customMetricUtilizations == null) {
        this.customMetricUtilizations = new LinkedList<>();
      }
      this.customMetricUtilizations.addAll(customMetricUtilizations);
      return this;
    }

    /** Configuration parameters of autoscaling based on a custom metric. */
    public Builder addCustomMetricUtilizations(
        AutoscalingPolicyCustomMetricUtilization customMetricUtilizations) {
      if (this.customMetricUtilizations == null) {
        this.customMetricUtilizations = new LinkedList<>();
      }
      this.customMetricUtilizations.add(customMetricUtilizations);
      return this;
    }

    /** Configuration parameters of autoscaling based on load balancer. */
    public AutoscalingPolicyLoadBalancingUtilization getLoadBalancingUtilization() {
      return loadBalancingUtilization;
    }

    /** Configuration parameters of autoscaling based on load balancer. */
    public Builder setLoadBalancingUtilization(
        AutoscalingPolicyLoadBalancingUtilization loadBalancingUtilization) {
      this.loadBalancingUtilization = loadBalancingUtilization;
      return this;
    }

    /**
     * The maximum number of instances that the autoscaler can scale up to. This is required when
     * creating or updating an autoscaler. The maximum number of replicas should not be lower than
     * minimal number of replicas.
     */
    public Integer getMaxNumReplicas() {
      return maxNumReplicas;
    }

    /**
     * The maximum number of instances that the autoscaler can scale up to. This is required when
     * creating or updating an autoscaler. The maximum number of replicas should not be lower than
     * minimal number of replicas.
     */
    public Builder setMaxNumReplicas(Integer maxNumReplicas) {
      this.maxNumReplicas = maxNumReplicas;
      return this;
    }

    /**
     * The minimum number of replicas that the autoscaler can scale down to. This cannot be less
     * than 0. If not provided, autoscaler will choose a default value depending on maximum number
     * of instances allowed.
     */
    public Integer getMinNumReplicas() {
      return minNumReplicas;
    }

    /**
     * The minimum number of replicas that the autoscaler can scale down to. This cannot be less
     * than 0. If not provided, autoscaler will choose a default value depending on maximum number
     * of instances allowed.
     */
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
