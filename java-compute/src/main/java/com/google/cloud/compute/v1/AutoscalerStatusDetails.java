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
public final class AutoscalerStatusDetails implements ApiMessage {
  private final String message;
  private final String type;

  private AutoscalerStatusDetails() {
    this.message = null;
    this.type = null;
  }

  private AutoscalerStatusDetails(String message, String type) {
    this.message = message;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("message".equals(fieldName)) {
      return message;
    }
    if ("type".equals(fieldName)) {
      return type;
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

  /** The status message. */
  public String getMessage() {
    return message;
  }

  /**
   * The type of error, warning, or notice returned. Current set of possible values: -
   * ALL_INSTANCES_UNHEALTHY (WARNING): All instances in the instance group are unhealthy (not in
   * RUNNING state). - BACKEND_SERVICE_DOES_NOT_EXIST (ERROR): There is no backend service attached
   * to the instance group. - CAPPED_AT_MAX_NUM_REPLICAS (WARNING): Autoscaler recommends a size
   * greater than maxNumReplicas. - CUSTOM_METRIC_DATA_POINTS_TOO_SPARSE (WARNING): The custom
   * metric samples are not exported often enough to be a credible base for autoscaling. -
   * CUSTOM_METRIC_INVALID (ERROR): The custom metric that was specified does not exist or does not
   * have the necessary labels. - MIN_EQUALS_MAX (WARNING): The minNumReplicas is equal to
   * maxNumReplicas. This means the autoscaler cannot add or remove instances from the instance
   * group. - MISSING_CUSTOM_METRIC_DATA_POINTS (WARNING): The autoscaler did not receive any data
   * from the custom metric configured for autoscaling. - MISSING_LOAD_BALANCING_DATA_POINTS
   * (WARNING): The autoscaler is configured to scale based on a load balancing signal but the
   * instance group has not received any requests from the load balancer. - MODE_OFF (WARNING):
   * Autoscaling is turned off. The number of instances in the group won't change automatically. The
   * autoscaling configuration is preserved. - MODE_ONLY_UP (WARNING): Autoscaling is in the
   * "Autoscale only up" mode. The autoscaler can add instances but not remove any. -
   * MORE_THAN_ONE_BACKEND_SERVICE (ERROR): The instance group cannot be autoscaled because it has
   * more than one backend service attached to it. - NOT_ENOUGH_QUOTA_AVAILABLE (ERROR): There is
   * insufficient quota for the necessary resources, such as CPU or number of instances. -
   * REGION_RESOURCE_STOCKOUT (ERROR): Shown only for regional autoscalers: there is a resource
   * stockout in the chosen region. - SCALING_TARGET_DOES_NOT_EXIST (ERROR): The target to be scaled
   * does not exist. - UNSUPPORTED_MAX_RATE_LOAD_BALANCING_CONFIGURATION (ERROR): Autoscaling does
   * not work with an HTTP/S load balancer that has been configured for maxRate. -
   * ZONE_RESOURCE_STOCKOUT (ERROR): For zonal autoscalers: there is a resource stockout in the
   * chosen zone. For regional autoscalers: in at least one of the zones you're using there is a
   * resource stockout. New values might be added in the future. Some of the values might not be
   * available in all API versions.
   */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalerStatusDetails prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalerStatusDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalerStatusDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalerStatusDetails();
  }

  public static class Builder {
    private String message;
    private String type;

    Builder() {}

    public Builder mergeFrom(AutoscalerStatusDetails other) {
      if (other == AutoscalerStatusDetails.getDefaultInstance()) return this;
      if (other.getMessage() != null) {
        this.message = other.message;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(AutoscalerStatusDetails source) {
      this.message = source.message;
      this.type = source.type;
    }

    /** The status message. */
    public String getMessage() {
      return message;
    }

    /** The status message. */
    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    /**
     * The type of error, warning, or notice returned. Current set of possible values: -
     * ALL_INSTANCES_UNHEALTHY (WARNING): All instances in the instance group are unhealthy (not in
     * RUNNING state). - BACKEND_SERVICE_DOES_NOT_EXIST (ERROR): There is no backend service
     * attached to the instance group. - CAPPED_AT_MAX_NUM_REPLICAS (WARNING): Autoscaler recommends
     * a size greater than maxNumReplicas. - CUSTOM_METRIC_DATA_POINTS_TOO_SPARSE (WARNING): The
     * custom metric samples are not exported often enough to be a credible base for autoscaling. -
     * CUSTOM_METRIC_INVALID (ERROR): The custom metric that was specified does not exist or does
     * not have the necessary labels. - MIN_EQUALS_MAX (WARNING): The minNumReplicas is equal to
     * maxNumReplicas. This means the autoscaler cannot add or remove instances from the instance
     * group. - MISSING_CUSTOM_METRIC_DATA_POINTS (WARNING): The autoscaler did not receive any data
     * from the custom metric configured for autoscaling. - MISSING_LOAD_BALANCING_DATA_POINTS
     * (WARNING): The autoscaler is configured to scale based on a load balancing signal but the
     * instance group has not received any requests from the load balancer. - MODE_OFF (WARNING):
     * Autoscaling is turned off. The number of instances in the group won't change automatically.
     * The autoscaling configuration is preserved. - MODE_ONLY_UP (WARNING): Autoscaling is in the
     * "Autoscale only up" mode. The autoscaler can add instances but not remove any. -
     * MORE_THAN_ONE_BACKEND_SERVICE (ERROR): The instance group cannot be autoscaled because it has
     * more than one backend service attached to it. - NOT_ENOUGH_QUOTA_AVAILABLE (ERROR): There is
     * insufficient quota for the necessary resources, such as CPU or number of instances. -
     * REGION_RESOURCE_STOCKOUT (ERROR): Shown only for regional autoscalers: there is a resource
     * stockout in the chosen region. - SCALING_TARGET_DOES_NOT_EXIST (ERROR): The target to be
     * scaled does not exist. - UNSUPPORTED_MAX_RATE_LOAD_BALANCING_CONFIGURATION (ERROR):
     * Autoscaling does not work with an HTTP/S load balancer that has been configured for maxRate.
     * - ZONE_RESOURCE_STOCKOUT (ERROR): For zonal autoscalers: there is a resource stockout in the
     * chosen zone. For regional autoscalers: in at least one of the zones you're using there is a
     * resource stockout. New values might be added in the future. Some of the values might not be
     * available in all API versions.
     */
    public String getType() {
      return type;
    }

    /**
     * The type of error, warning, or notice returned. Current set of possible values: -
     * ALL_INSTANCES_UNHEALTHY (WARNING): All instances in the instance group are unhealthy (not in
     * RUNNING state). - BACKEND_SERVICE_DOES_NOT_EXIST (ERROR): There is no backend service
     * attached to the instance group. - CAPPED_AT_MAX_NUM_REPLICAS (WARNING): Autoscaler recommends
     * a size greater than maxNumReplicas. - CUSTOM_METRIC_DATA_POINTS_TOO_SPARSE (WARNING): The
     * custom metric samples are not exported often enough to be a credible base for autoscaling. -
     * CUSTOM_METRIC_INVALID (ERROR): The custom metric that was specified does not exist or does
     * not have the necessary labels. - MIN_EQUALS_MAX (WARNING): The minNumReplicas is equal to
     * maxNumReplicas. This means the autoscaler cannot add or remove instances from the instance
     * group. - MISSING_CUSTOM_METRIC_DATA_POINTS (WARNING): The autoscaler did not receive any data
     * from the custom metric configured for autoscaling. - MISSING_LOAD_BALANCING_DATA_POINTS
     * (WARNING): The autoscaler is configured to scale based on a load balancing signal but the
     * instance group has not received any requests from the load balancer. - MODE_OFF (WARNING):
     * Autoscaling is turned off. The number of instances in the group won't change automatically.
     * The autoscaling configuration is preserved. - MODE_ONLY_UP (WARNING): Autoscaling is in the
     * "Autoscale only up" mode. The autoscaler can add instances but not remove any. -
     * MORE_THAN_ONE_BACKEND_SERVICE (ERROR): The instance group cannot be autoscaled because it has
     * more than one backend service attached to it. - NOT_ENOUGH_QUOTA_AVAILABLE (ERROR): There is
     * insufficient quota for the necessary resources, such as CPU or number of instances. -
     * REGION_RESOURCE_STOCKOUT (ERROR): Shown only for regional autoscalers: there is a resource
     * stockout in the chosen region. - SCALING_TARGET_DOES_NOT_EXIST (ERROR): The target to be
     * scaled does not exist. - UNSUPPORTED_MAX_RATE_LOAD_BALANCING_CONFIGURATION (ERROR):
     * Autoscaling does not work with an HTTP/S load balancer that has been configured for maxRate.
     * - ZONE_RESOURCE_STOCKOUT (ERROR): For zonal autoscalers: there is a resource stockout in the
     * chosen zone. For regional autoscalers: in at least one of the zones you're using there is a
     * resource stockout. New values might be added in the future. Some of the values might not be
     * available in all API versions.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public AutoscalerStatusDetails build() {

      return new AutoscalerStatusDetails(message, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMessage(this.message);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalerStatusDetails{" + "message=" + message + ", " + "type=" + type + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalerStatusDetails) {
      AutoscalerStatusDetails that = (AutoscalerStatusDetails) o;
      return Objects.equals(this.message, that.getMessage())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, type);
  }
}
