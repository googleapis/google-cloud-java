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
/** The available logging options for this subnetwork. */
public final class SubnetworkLogConfig implements ApiMessage {
  private final String aggregationInterval;
  private final Boolean enable;
  private final Float flowSampling;
  private final String metadata;

  private SubnetworkLogConfig() {
    this.aggregationInterval = null;
    this.enable = null;
    this.flowSampling = null;
    this.metadata = null;
  }

  private SubnetworkLogConfig(
      String aggregationInterval, Boolean enable, Float flowSampling, String metadata) {
    this.aggregationInterval = aggregationInterval;
    this.enable = enable;
    this.flowSampling = flowSampling;
    this.metadata = metadata;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("aggregationInterval".equals(fieldName)) {
      return aggregationInterval;
    }
    if ("enable".equals(fieldName)) {
      return enable;
    }
    if ("flowSampling".equals(fieldName)) {
      return flowSampling;
    }
    if ("metadata".equals(fieldName)) {
      return metadata;
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
   * Can only be specified if VPC flow logging for this subnetwork is enabled. Toggles the
   * aggregation interval for collecting flow logs. Increasing the interval time will reduce the
   * amount of generated flow logs for long lasting connections. Default is an interval of 5 seconds
   * per connection.
   */
  public String getAggregationInterval() {
    return aggregationInterval;
  }

  /**
   * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
   * will not appear in get listings. If not set the default behavior is to disable flow logging.
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * Can only be specified if VPC flow logging for this subnetwork is enabled. The value of the
   * field must be in [0, 1]. Set the sampling rate of VPC flow logs within the subnetwork where 1.0
   * means all collected logs are reported and 0.0 means no logs are reported. Default is 0.5, which
   * means half of all collected logs are reported.
   */
  public Float getFlowSampling() {
    return flowSampling;
  }

  /**
   * Can only be specified if VPC flow logs for this subnetwork is enabled. Configures whether all,
   * none or a subset of metadata fields should be added to the reported VPC flow logs. Default is
   * INCLUDE_ALL_METADATA.
   */
  public String getMetadata() {
    return metadata;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SubnetworkLogConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SubnetworkLogConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SubnetworkLogConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SubnetworkLogConfig();
  }

  public static class Builder {
    private String aggregationInterval;
    private Boolean enable;
    private Float flowSampling;
    private String metadata;

    Builder() {}

    public Builder mergeFrom(SubnetworkLogConfig other) {
      if (other == SubnetworkLogConfig.getDefaultInstance()) return this;
      if (other.getAggregationInterval() != null) {
        this.aggregationInterval = other.aggregationInterval;
      }
      if (other.getEnable() != null) {
        this.enable = other.enable;
      }
      if (other.getFlowSampling() != null) {
        this.flowSampling = other.flowSampling;
      }
      if (other.getMetadata() != null) {
        this.metadata = other.metadata;
      }
      return this;
    }

    Builder(SubnetworkLogConfig source) {
      this.aggregationInterval = source.aggregationInterval;
      this.enable = source.enable;
      this.flowSampling = source.flowSampling;
      this.metadata = source.metadata;
    }

    /**
     * Can only be specified if VPC flow logging for this subnetwork is enabled. Toggles the
     * aggregation interval for collecting flow logs. Increasing the interval time will reduce the
     * amount of generated flow logs for long lasting connections. Default is an interval of 5
     * seconds per connection.
     */
    public String getAggregationInterval() {
      return aggregationInterval;
    }

    /**
     * Can only be specified if VPC flow logging for this subnetwork is enabled. Toggles the
     * aggregation interval for collecting flow logs. Increasing the interval time will reduce the
     * amount of generated flow logs for long lasting connections. Default is an interval of 5
     * seconds per connection.
     */
    public Builder setAggregationInterval(String aggregationInterval) {
      this.aggregationInterval = aggregationInterval;
      return this;
    }

    /**
     * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
     * will not appear in get listings. If not set the default behavior is to disable flow logging.
     */
    public Boolean getEnable() {
      return enable;
    }

    /**
     * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
     * will not appear in get listings. If not set the default behavior is to disable flow logging.
     */
    public Builder setEnable(Boolean enable) {
      this.enable = enable;
      return this;
    }

    /**
     * Can only be specified if VPC flow logging for this subnetwork is enabled. The value of the
     * field must be in [0, 1]. Set the sampling rate of VPC flow logs within the subnetwork where
     * 1.0 means all collected logs are reported and 0.0 means no logs are reported. Default is 0.5,
     * which means half of all collected logs are reported.
     */
    public Float getFlowSampling() {
      return flowSampling;
    }

    /**
     * Can only be specified if VPC flow logging for this subnetwork is enabled. The value of the
     * field must be in [0, 1]. Set the sampling rate of VPC flow logs within the subnetwork where
     * 1.0 means all collected logs are reported and 0.0 means no logs are reported. Default is 0.5,
     * which means half of all collected logs are reported.
     */
    public Builder setFlowSampling(Float flowSampling) {
      this.flowSampling = flowSampling;
      return this;
    }

    /**
     * Can only be specified if VPC flow logs for this subnetwork is enabled. Configures whether
     * all, none or a subset of metadata fields should be added to the reported VPC flow logs.
     * Default is INCLUDE_ALL_METADATA.
     */
    public String getMetadata() {
      return metadata;
    }

    /**
     * Can only be specified if VPC flow logs for this subnetwork is enabled. Configures whether
     * all, none or a subset of metadata fields should be added to the reported VPC flow logs.
     * Default is INCLUDE_ALL_METADATA.
     */
    public Builder setMetadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    public SubnetworkLogConfig build() {

      return new SubnetworkLogConfig(aggregationInterval, enable, flowSampling, metadata);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAggregationInterval(this.aggregationInterval);
      newBuilder.setEnable(this.enable);
      newBuilder.setFlowSampling(this.flowSampling);
      newBuilder.setMetadata(this.metadata);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SubnetworkLogConfig{"
        + "aggregationInterval="
        + aggregationInterval
        + ", "
        + "enable="
        + enable
        + ", "
        + "flowSampling="
        + flowSampling
        + ", "
        + "metadata="
        + metadata
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SubnetworkLogConfig) {
      SubnetworkLogConfig that = (SubnetworkLogConfig) o;
      return Objects.equals(this.aggregationInterval, that.getAggregationInterval())
          && Objects.equals(this.enable, that.getEnable())
          && Objects.equals(this.flowSampling, that.getFlowSampling())
          && Objects.equals(this.metadata, that.getMetadata());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregationInterval, enable, flowSampling, metadata);
  }
}
