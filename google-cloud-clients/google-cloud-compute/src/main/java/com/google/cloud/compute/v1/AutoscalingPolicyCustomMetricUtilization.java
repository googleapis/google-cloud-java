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
/** Custom utilization metric policy. */
public final class AutoscalingPolicyCustomMetricUtilization implements ApiMessage {
  private final String metric;
  private final Double utilizationTarget;
  private final String utilizationTargetType;

  private AutoscalingPolicyCustomMetricUtilization() {
    this.metric = null;
    this.utilizationTarget = null;
    this.utilizationTargetType = null;
  }

  private AutoscalingPolicyCustomMetricUtilization(
      String metric, Double utilizationTarget, String utilizationTargetType) {
    this.metric = metric;
    this.utilizationTarget = utilizationTarget;
    this.utilizationTargetType = utilizationTargetType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("metric".equals(fieldName)) {
      return metric;
    }
    if ("utilizationTarget".equals(fieldName)) {
      return utilizationTarget;
    }
    if ("utilizationTargetType".equals(fieldName)) {
      return utilizationTargetType;
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

  /**
   * The identifier (type) of the Stackdriver Monitoring metric. The metric cannot have negative
   * values.
   *
   * <p>The metric must have a value type of INT64 or DOUBLE.
   */
  public String getMetric() {
    return metric;
  }

  /**
   * The target value of the metric that autoscaler should maintain. This must be a positive value.
   * A utilization metric scales number of virtual machines handling requests to increase or
   * decrease proportionally to the metric.
   *
   * <p>For example, a good metric to use as a utilization_target is
   * compute.googleapis.com/instance/network/received_bytes_count. The autoscaler will work to keep
   * this value constant for each of the instances.
   */
  public Double getUtilizationTarget() {
    return utilizationTarget;
  }

  /**
   * Defines how target utilization value is expressed for a Stackdriver Monitoring metric. Either
   * GAUGE, DELTA_PER_SECOND, or DELTA_PER_MINUTE.
   */
  public String getUtilizationTargetType() {
    return utilizationTargetType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalingPolicyCustomMetricUtilization prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalingPolicyCustomMetricUtilization getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalingPolicyCustomMetricUtilization DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalingPolicyCustomMetricUtilization();
  }

  public static class Builder {
    private String metric;
    private Double utilizationTarget;
    private String utilizationTargetType;

    Builder() {}

    public Builder mergeFrom(AutoscalingPolicyCustomMetricUtilization other) {
      if (other == AutoscalingPolicyCustomMetricUtilization.getDefaultInstance()) return this;
      if (other.getMetric() != null) {
        this.metric = other.metric;
      }
      if (other.getUtilizationTarget() != null) {
        this.utilizationTarget = other.utilizationTarget;
      }
      if (other.getUtilizationTargetType() != null) {
        this.utilizationTargetType = other.utilizationTargetType;
      }
      return this;
    }

    Builder(AutoscalingPolicyCustomMetricUtilization source) {
      this.metric = source.metric;
      this.utilizationTarget = source.utilizationTarget;
      this.utilizationTargetType = source.utilizationTargetType;
    }

    /**
     * The identifier (type) of the Stackdriver Monitoring metric. The metric cannot have negative
     * values.
     *
     * <p>The metric must have a value type of INT64 or DOUBLE.
     */
    public String getMetric() {
      return metric;
    }

    /**
     * The identifier (type) of the Stackdriver Monitoring metric. The metric cannot have negative
     * values.
     *
     * <p>The metric must have a value type of INT64 or DOUBLE.
     */
    public Builder setMetric(String metric) {
      this.metric = metric;
      return this;
    }

    /**
     * The target value of the metric that autoscaler should maintain. This must be a positive
     * value. A utilization metric scales number of virtual machines handling requests to increase
     * or decrease proportionally to the metric.
     *
     * <p>For example, a good metric to use as a utilization_target is
     * compute.googleapis.com/instance/network/received_bytes_count. The autoscaler will work to
     * keep this value constant for each of the instances.
     */
    public Double getUtilizationTarget() {
      return utilizationTarget;
    }

    /**
     * The target value of the metric that autoscaler should maintain. This must be a positive
     * value. A utilization metric scales number of virtual machines handling requests to increase
     * or decrease proportionally to the metric.
     *
     * <p>For example, a good metric to use as a utilization_target is
     * compute.googleapis.com/instance/network/received_bytes_count. The autoscaler will work to
     * keep this value constant for each of the instances.
     */
    public Builder setUtilizationTarget(Double utilizationTarget) {
      this.utilizationTarget = utilizationTarget;
      return this;
    }

    /**
     * Defines how target utilization value is expressed for a Stackdriver Monitoring metric. Either
     * GAUGE, DELTA_PER_SECOND, or DELTA_PER_MINUTE.
     */
    public String getUtilizationTargetType() {
      return utilizationTargetType;
    }

    /**
     * Defines how target utilization value is expressed for a Stackdriver Monitoring metric. Either
     * GAUGE, DELTA_PER_SECOND, or DELTA_PER_MINUTE.
     */
    public Builder setUtilizationTargetType(String utilizationTargetType) {
      this.utilizationTargetType = utilizationTargetType;
      return this;
    }

    public AutoscalingPolicyCustomMetricUtilization build() {

      return new AutoscalingPolicyCustomMetricUtilization(
          metric, utilizationTarget, utilizationTargetType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMetric(this.metric);
      newBuilder.setUtilizationTarget(this.utilizationTarget);
      newBuilder.setUtilizationTargetType(this.utilizationTargetType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalingPolicyCustomMetricUtilization{"
        + "metric="
        + metric
        + ", "
        + "utilizationTarget="
        + utilizationTarget
        + ", "
        + "utilizationTargetType="
        + utilizationTargetType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalingPolicyCustomMetricUtilization) {
      AutoscalingPolicyCustomMetricUtilization that = (AutoscalingPolicyCustomMetricUtilization) o;
      return Objects.equals(this.metric, that.getMetric())
          && Objects.equals(this.utilizationTarget, that.getUtilizationTarget())
          && Objects.equals(this.utilizationTargetType, that.getUtilizationTargetType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(metric, utilizationTarget, utilizationTargetType);
  }
}
