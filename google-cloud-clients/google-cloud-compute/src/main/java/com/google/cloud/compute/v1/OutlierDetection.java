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
/** Settings controlling eviction of unhealthy hosts from the load balancing pool. */
public final class OutlierDetection implements ApiMessage {
  private final Duration baseEjectionTime;
  private final Integer consecutiveErrors;
  private final Integer consecutiveGatewayFailure;
  private final Integer enforcingConsecutiveErrors;
  private final Integer enforcingConsecutiveGatewayFailure;
  private final Integer enforcingSuccessRate;
  private final Duration interval;
  private final Integer maxEjectionPercent;
  private final Integer successRateMinimumHosts;
  private final Integer successRateRequestVolume;
  private final Integer successRateStdevFactor;

  private OutlierDetection() {
    this.baseEjectionTime = null;
    this.consecutiveErrors = null;
    this.consecutiveGatewayFailure = null;
    this.enforcingConsecutiveErrors = null;
    this.enforcingConsecutiveGatewayFailure = null;
    this.enforcingSuccessRate = null;
    this.interval = null;
    this.maxEjectionPercent = null;
    this.successRateMinimumHosts = null;
    this.successRateRequestVolume = null;
    this.successRateStdevFactor = null;
  }

  private OutlierDetection(
      Duration baseEjectionTime,
      Integer consecutiveErrors,
      Integer consecutiveGatewayFailure,
      Integer enforcingConsecutiveErrors,
      Integer enforcingConsecutiveGatewayFailure,
      Integer enforcingSuccessRate,
      Duration interval,
      Integer maxEjectionPercent,
      Integer successRateMinimumHosts,
      Integer successRateRequestVolume,
      Integer successRateStdevFactor) {
    this.baseEjectionTime = baseEjectionTime;
    this.consecutiveErrors = consecutiveErrors;
    this.consecutiveGatewayFailure = consecutiveGatewayFailure;
    this.enforcingConsecutiveErrors = enforcingConsecutiveErrors;
    this.enforcingConsecutiveGatewayFailure = enforcingConsecutiveGatewayFailure;
    this.enforcingSuccessRate = enforcingSuccessRate;
    this.interval = interval;
    this.maxEjectionPercent = maxEjectionPercent;
    this.successRateMinimumHosts = successRateMinimumHosts;
    this.successRateRequestVolume = successRateRequestVolume;
    this.successRateStdevFactor = successRateStdevFactor;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("baseEjectionTime".equals(fieldName)) {
      return baseEjectionTime;
    }
    if ("consecutiveErrors".equals(fieldName)) {
      return consecutiveErrors;
    }
    if ("consecutiveGatewayFailure".equals(fieldName)) {
      return consecutiveGatewayFailure;
    }
    if ("enforcingConsecutiveErrors".equals(fieldName)) {
      return enforcingConsecutiveErrors;
    }
    if ("enforcingConsecutiveGatewayFailure".equals(fieldName)) {
      return enforcingConsecutiveGatewayFailure;
    }
    if ("enforcingSuccessRate".equals(fieldName)) {
      return enforcingSuccessRate;
    }
    if ("interval".equals(fieldName)) {
      return interval;
    }
    if ("maxEjectionPercent".equals(fieldName)) {
      return maxEjectionPercent;
    }
    if ("successRateMinimumHosts".equals(fieldName)) {
      return successRateMinimumHosts;
    }
    if ("successRateRequestVolume".equals(fieldName)) {
      return successRateRequestVolume;
    }
    if ("successRateStdevFactor".equals(fieldName)) {
      return successRateStdevFactor;
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
   * The base time that a host is ejected for. The real time is equal to the base time multiplied by
   * the number of times the host has been ejected. Defaults to 30000ms or 30s.
   */
  public Duration getBaseEjectionTime() {
    return baseEjectionTime;
  }

  /**
   * Number of errors before a host is ejected from the connection pool. When the backend host is
   * accessed over HTTP, a 5xx return code qualifies as an error. Defaults to 5.
   */
  public Integer getConsecutiveErrors() {
    return consecutiveErrors;
  }

  /**
   * The number of consecutive gateway failures (502, 503, 504 status or connection errors that are
   * mapped to one of those status codes) before a consecutive gateway failure ejection occurs.
   * Defaults to 5.
   */
  public Integer getConsecutiveGatewayFailure() {
    return consecutiveGatewayFailure;
  }

  /**
   * The percentage chance that a host will be actually ejected when an outlier status is detected
   * through consecutive 5xx. This setting can be used to disable ejection or to ramp it up slowly.
   * Defaults to 100.
   */
  public Integer getEnforcingConsecutiveErrors() {
    return enforcingConsecutiveErrors;
  }

  /**
   * The percentage chance that a host will be actually ejected when an outlier status is detected
   * through consecutive gateway failures. This setting can be used to disable ejection or to ramp
   * it up slowly. Defaults to 0.
   */
  public Integer getEnforcingConsecutiveGatewayFailure() {
    return enforcingConsecutiveGatewayFailure;
  }

  /**
   * The percentage chance that a host will be actually ejected when an outlier status is detected
   * through success rate statistics. This setting can be used to disable ejection or to ramp it up
   * slowly. Defaults to 100.
   */
  public Integer getEnforcingSuccessRate() {
    return enforcingSuccessRate;
  }

  /**
   * Time interval between ejection sweep analysis. This can result in both new ejections as well as
   * hosts being returned to service. Defaults to 10 seconds.
   */
  public Duration getInterval() {
    return interval;
  }

  /**
   * Maximum percentage of hosts in the load balancing pool for the backend service that can be
   * ejected. Defaults to 10%.
   */
  public Integer getMaxEjectionPercent() {
    return maxEjectionPercent;
  }

  /**
   * The number of hosts in a cluster that must have enough request volume to detect success rate
   * outliers. If the number of hosts is less than this setting, outlier detection via success rate
   * statistics is not performed for any host in the cluster. Defaults to 5.
   */
  public Integer getSuccessRateMinimumHosts() {
    return successRateMinimumHosts;
  }

  /**
   * The minimum number of total requests that must be collected in one interval (as defined by the
   * interval duration above) to include this host in success rate based outlier detection. If the
   * volume is lower than this setting, outlier detection via success rate statistics is not
   * performed for that host. Defaults to 100.
   */
  public Integer getSuccessRateRequestVolume() {
    return successRateRequestVolume;
  }

  /**
   * This factor is used to determine the ejection threshold for success rate outlier ejection. The
   * ejection threshold is the difference between the mean success rate, and the product of this
   * factor and the standard deviation of the mean success rate: mean - (stdev &#42;
   * success_rate_stdev_factor). This factor is divided by a thousand to get a double. That is, if
   * the desired factor is 1.9, the runtime value should be 1900. Defaults to 1900.
   */
  public Integer getSuccessRateStdevFactor() {
    return successRateStdevFactor;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(OutlierDetection prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static OutlierDetection getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final OutlierDetection DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new OutlierDetection();
  }

  public static class Builder {
    private Duration baseEjectionTime;
    private Integer consecutiveErrors;
    private Integer consecutiveGatewayFailure;
    private Integer enforcingConsecutiveErrors;
    private Integer enforcingConsecutiveGatewayFailure;
    private Integer enforcingSuccessRate;
    private Duration interval;
    private Integer maxEjectionPercent;
    private Integer successRateMinimumHosts;
    private Integer successRateRequestVolume;
    private Integer successRateStdevFactor;

    Builder() {}

    public Builder mergeFrom(OutlierDetection other) {
      if (other == OutlierDetection.getDefaultInstance()) return this;
      if (other.getBaseEjectionTime() != null) {
        this.baseEjectionTime = other.baseEjectionTime;
      }
      if (other.getConsecutiveErrors() != null) {
        this.consecutiveErrors = other.consecutiveErrors;
      }
      if (other.getConsecutiveGatewayFailure() != null) {
        this.consecutiveGatewayFailure = other.consecutiveGatewayFailure;
      }
      if (other.getEnforcingConsecutiveErrors() != null) {
        this.enforcingConsecutiveErrors = other.enforcingConsecutiveErrors;
      }
      if (other.getEnforcingConsecutiveGatewayFailure() != null) {
        this.enforcingConsecutiveGatewayFailure = other.enforcingConsecutiveGatewayFailure;
      }
      if (other.getEnforcingSuccessRate() != null) {
        this.enforcingSuccessRate = other.enforcingSuccessRate;
      }
      if (other.getInterval() != null) {
        this.interval = other.interval;
      }
      if (other.getMaxEjectionPercent() != null) {
        this.maxEjectionPercent = other.maxEjectionPercent;
      }
      if (other.getSuccessRateMinimumHosts() != null) {
        this.successRateMinimumHosts = other.successRateMinimumHosts;
      }
      if (other.getSuccessRateRequestVolume() != null) {
        this.successRateRequestVolume = other.successRateRequestVolume;
      }
      if (other.getSuccessRateStdevFactor() != null) {
        this.successRateStdevFactor = other.successRateStdevFactor;
      }
      return this;
    }

    Builder(OutlierDetection source) {
      this.baseEjectionTime = source.baseEjectionTime;
      this.consecutiveErrors = source.consecutiveErrors;
      this.consecutiveGatewayFailure = source.consecutiveGatewayFailure;
      this.enforcingConsecutiveErrors = source.enforcingConsecutiveErrors;
      this.enforcingConsecutiveGatewayFailure = source.enforcingConsecutiveGatewayFailure;
      this.enforcingSuccessRate = source.enforcingSuccessRate;
      this.interval = source.interval;
      this.maxEjectionPercent = source.maxEjectionPercent;
      this.successRateMinimumHosts = source.successRateMinimumHosts;
      this.successRateRequestVolume = source.successRateRequestVolume;
      this.successRateStdevFactor = source.successRateStdevFactor;
    }

    /**
     * The base time that a host is ejected for. The real time is equal to the base time multiplied
     * by the number of times the host has been ejected. Defaults to 30000ms or 30s.
     */
    public Duration getBaseEjectionTime() {
      return baseEjectionTime;
    }

    /**
     * The base time that a host is ejected for. The real time is equal to the base time multiplied
     * by the number of times the host has been ejected. Defaults to 30000ms or 30s.
     */
    public Builder setBaseEjectionTime(Duration baseEjectionTime) {
      this.baseEjectionTime = baseEjectionTime;
      return this;
    }

    /**
     * Number of errors before a host is ejected from the connection pool. When the backend host is
     * accessed over HTTP, a 5xx return code qualifies as an error. Defaults to 5.
     */
    public Integer getConsecutiveErrors() {
      return consecutiveErrors;
    }

    /**
     * Number of errors before a host is ejected from the connection pool. When the backend host is
     * accessed over HTTP, a 5xx return code qualifies as an error. Defaults to 5.
     */
    public Builder setConsecutiveErrors(Integer consecutiveErrors) {
      this.consecutiveErrors = consecutiveErrors;
      return this;
    }

    /**
     * The number of consecutive gateway failures (502, 503, 504 status or connection errors that
     * are mapped to one of those status codes) before a consecutive gateway failure ejection
     * occurs. Defaults to 5.
     */
    public Integer getConsecutiveGatewayFailure() {
      return consecutiveGatewayFailure;
    }

    /**
     * The number of consecutive gateway failures (502, 503, 504 status or connection errors that
     * are mapped to one of those status codes) before a consecutive gateway failure ejection
     * occurs. Defaults to 5.
     */
    public Builder setConsecutiveGatewayFailure(Integer consecutiveGatewayFailure) {
      this.consecutiveGatewayFailure = consecutiveGatewayFailure;
      return this;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through consecutive 5xx. This setting can be used to disable ejection or to ramp it up
     * slowly. Defaults to 100.
     */
    public Integer getEnforcingConsecutiveErrors() {
      return enforcingConsecutiveErrors;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through consecutive 5xx. This setting can be used to disable ejection or to ramp it up
     * slowly. Defaults to 100.
     */
    public Builder setEnforcingConsecutiveErrors(Integer enforcingConsecutiveErrors) {
      this.enforcingConsecutiveErrors = enforcingConsecutiveErrors;
      return this;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through consecutive gateway failures. This setting can be used to disable ejection or to ramp
     * it up slowly. Defaults to 0.
     */
    public Integer getEnforcingConsecutiveGatewayFailure() {
      return enforcingConsecutiveGatewayFailure;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through consecutive gateway failures. This setting can be used to disable ejection or to ramp
     * it up slowly. Defaults to 0.
     */
    public Builder setEnforcingConsecutiveGatewayFailure(
        Integer enforcingConsecutiveGatewayFailure) {
      this.enforcingConsecutiveGatewayFailure = enforcingConsecutiveGatewayFailure;
      return this;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through success rate statistics. This setting can be used to disable ejection or to ramp it
     * up slowly. Defaults to 100.
     */
    public Integer getEnforcingSuccessRate() {
      return enforcingSuccessRate;
    }

    /**
     * The percentage chance that a host will be actually ejected when an outlier status is detected
     * through success rate statistics. This setting can be used to disable ejection or to ramp it
     * up slowly. Defaults to 100.
     */
    public Builder setEnforcingSuccessRate(Integer enforcingSuccessRate) {
      this.enforcingSuccessRate = enforcingSuccessRate;
      return this;
    }

    /**
     * Time interval between ejection sweep analysis. This can result in both new ejections as well
     * as hosts being returned to service. Defaults to 10 seconds.
     */
    public Duration getInterval() {
      return interval;
    }

    /**
     * Time interval between ejection sweep analysis. This can result in both new ejections as well
     * as hosts being returned to service. Defaults to 10 seconds.
     */
    public Builder setInterval(Duration interval) {
      this.interval = interval;
      return this;
    }

    /**
     * Maximum percentage of hosts in the load balancing pool for the backend service that can be
     * ejected. Defaults to 10%.
     */
    public Integer getMaxEjectionPercent() {
      return maxEjectionPercent;
    }

    /**
     * Maximum percentage of hosts in the load balancing pool for the backend service that can be
     * ejected. Defaults to 10%.
     */
    public Builder setMaxEjectionPercent(Integer maxEjectionPercent) {
      this.maxEjectionPercent = maxEjectionPercent;
      return this;
    }

    /**
     * The number of hosts in a cluster that must have enough request volume to detect success rate
     * outliers. If the number of hosts is less than this setting, outlier detection via success
     * rate statistics is not performed for any host in the cluster. Defaults to 5.
     */
    public Integer getSuccessRateMinimumHosts() {
      return successRateMinimumHosts;
    }

    /**
     * The number of hosts in a cluster that must have enough request volume to detect success rate
     * outliers. If the number of hosts is less than this setting, outlier detection via success
     * rate statistics is not performed for any host in the cluster. Defaults to 5.
     */
    public Builder setSuccessRateMinimumHosts(Integer successRateMinimumHosts) {
      this.successRateMinimumHosts = successRateMinimumHosts;
      return this;
    }

    /**
     * The minimum number of total requests that must be collected in one interval (as defined by
     * the interval duration above) to include this host in success rate based outlier detection. If
     * the volume is lower than this setting, outlier detection via success rate statistics is not
     * performed for that host. Defaults to 100.
     */
    public Integer getSuccessRateRequestVolume() {
      return successRateRequestVolume;
    }

    /**
     * The minimum number of total requests that must be collected in one interval (as defined by
     * the interval duration above) to include this host in success rate based outlier detection. If
     * the volume is lower than this setting, outlier detection via success rate statistics is not
     * performed for that host. Defaults to 100.
     */
    public Builder setSuccessRateRequestVolume(Integer successRateRequestVolume) {
      this.successRateRequestVolume = successRateRequestVolume;
      return this;
    }

    /**
     * This factor is used to determine the ejection threshold for success rate outlier ejection.
     * The ejection threshold is the difference between the mean success rate, and the product of
     * this factor and the standard deviation of the mean success rate: mean - (stdev &#42;
     * success_rate_stdev_factor). This factor is divided by a thousand to get a double. That is, if
     * the desired factor is 1.9, the runtime value should be 1900. Defaults to 1900.
     */
    public Integer getSuccessRateStdevFactor() {
      return successRateStdevFactor;
    }

    /**
     * This factor is used to determine the ejection threshold for success rate outlier ejection.
     * The ejection threshold is the difference between the mean success rate, and the product of
     * this factor and the standard deviation of the mean success rate: mean - (stdev &#42;
     * success_rate_stdev_factor). This factor is divided by a thousand to get a double. That is, if
     * the desired factor is 1.9, the runtime value should be 1900. Defaults to 1900.
     */
    public Builder setSuccessRateStdevFactor(Integer successRateStdevFactor) {
      this.successRateStdevFactor = successRateStdevFactor;
      return this;
    }

    public OutlierDetection build() {

      return new OutlierDetection(
          baseEjectionTime,
          consecutiveErrors,
          consecutiveGatewayFailure,
          enforcingConsecutiveErrors,
          enforcingConsecutiveGatewayFailure,
          enforcingSuccessRate,
          interval,
          maxEjectionPercent,
          successRateMinimumHosts,
          successRateRequestVolume,
          successRateStdevFactor);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBaseEjectionTime(this.baseEjectionTime);
      newBuilder.setConsecutiveErrors(this.consecutiveErrors);
      newBuilder.setConsecutiveGatewayFailure(this.consecutiveGatewayFailure);
      newBuilder.setEnforcingConsecutiveErrors(this.enforcingConsecutiveErrors);
      newBuilder.setEnforcingConsecutiveGatewayFailure(this.enforcingConsecutiveGatewayFailure);
      newBuilder.setEnforcingSuccessRate(this.enforcingSuccessRate);
      newBuilder.setInterval(this.interval);
      newBuilder.setMaxEjectionPercent(this.maxEjectionPercent);
      newBuilder.setSuccessRateMinimumHosts(this.successRateMinimumHosts);
      newBuilder.setSuccessRateRequestVolume(this.successRateRequestVolume);
      newBuilder.setSuccessRateStdevFactor(this.successRateStdevFactor);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "OutlierDetection{"
        + "baseEjectionTime="
        + baseEjectionTime
        + ", "
        + "consecutiveErrors="
        + consecutiveErrors
        + ", "
        + "consecutiveGatewayFailure="
        + consecutiveGatewayFailure
        + ", "
        + "enforcingConsecutiveErrors="
        + enforcingConsecutiveErrors
        + ", "
        + "enforcingConsecutiveGatewayFailure="
        + enforcingConsecutiveGatewayFailure
        + ", "
        + "enforcingSuccessRate="
        + enforcingSuccessRate
        + ", "
        + "interval="
        + interval
        + ", "
        + "maxEjectionPercent="
        + maxEjectionPercent
        + ", "
        + "successRateMinimumHosts="
        + successRateMinimumHosts
        + ", "
        + "successRateRequestVolume="
        + successRateRequestVolume
        + ", "
        + "successRateStdevFactor="
        + successRateStdevFactor
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OutlierDetection) {
      OutlierDetection that = (OutlierDetection) o;
      return Objects.equals(this.baseEjectionTime, that.getBaseEjectionTime())
          && Objects.equals(this.consecutiveErrors, that.getConsecutiveErrors())
          && Objects.equals(this.consecutiveGatewayFailure, that.getConsecutiveGatewayFailure())
          && Objects.equals(this.enforcingConsecutiveErrors, that.getEnforcingConsecutiveErrors())
          && Objects.equals(
              this.enforcingConsecutiveGatewayFailure, that.getEnforcingConsecutiveGatewayFailure())
          && Objects.equals(this.enforcingSuccessRate, that.getEnforcingSuccessRate())
          && Objects.equals(this.interval, that.getInterval())
          && Objects.equals(this.maxEjectionPercent, that.getMaxEjectionPercent())
          && Objects.equals(this.successRateMinimumHosts, that.getSuccessRateMinimumHosts())
          && Objects.equals(this.successRateRequestVolume, that.getSuccessRateRequestVolume())
          && Objects.equals(this.successRateStdevFactor, that.getSuccessRateStdevFactor());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        baseEjectionTime,
        consecutiveErrors,
        consecutiveGatewayFailure,
        enforcingConsecutiveErrors,
        enforcingConsecutiveGatewayFailure,
        enforcingSuccessRate,
        interval,
        maxEjectionPercent,
        successRateMinimumHosts,
        successRateRequestVolume,
        successRateStdevFactor);
  }
}
