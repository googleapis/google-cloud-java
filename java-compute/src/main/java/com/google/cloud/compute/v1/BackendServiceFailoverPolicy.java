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
/**
 * Applicable only to Failover for Internal TCP/UDP Load Balancing. On failover or failback, this
 * field indicates whether connection draining will be honored. GCP has a fixed connection draining
 * timeout of 10 minutes. A setting of true terminates existing TCP connections to the active pool
 * during failover and failback, immediately draining traffic. A setting of false allows existing
 * TCP connections to persist, even on VMs no longer in the active pool, for up to the duration of
 * the connection draining timeout (10 minutes).
 */
public final class BackendServiceFailoverPolicy implements ApiMessage {
  private final Boolean disableConnectionDrainOnFailover;
  private final Boolean dropTrafficIfUnhealthy;
  private final Float failoverRatio;

  private BackendServiceFailoverPolicy() {
    this.disableConnectionDrainOnFailover = null;
    this.dropTrafficIfUnhealthy = null;
    this.failoverRatio = null;
  }

  private BackendServiceFailoverPolicy(
      Boolean disableConnectionDrainOnFailover,
      Boolean dropTrafficIfUnhealthy,
      Float failoverRatio) {
    this.disableConnectionDrainOnFailover = disableConnectionDrainOnFailover;
    this.dropTrafficIfUnhealthy = dropTrafficIfUnhealthy;
    this.failoverRatio = failoverRatio;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("disableConnectionDrainOnFailover".equals(fieldName)) {
      return disableConnectionDrainOnFailover;
    }
    if ("dropTrafficIfUnhealthy".equals(fieldName)) {
      return dropTrafficIfUnhealthy;
    }
    if ("failoverRatio".equals(fieldName)) {
      return failoverRatio;
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
   * This can be set to true only if the protocol is TCP.
   *
   * <p>The default is false.
   */
  public Boolean getDisableConnectionDrainOnFailover() {
    return disableConnectionDrainOnFailover;
  }

  /**
   * Applicable only to Failover for Internal TCP/UDP Load Balancing. If set to true, connections to
   * the load balancer are dropped when all primary and all backup backend VMs are unhealthy. If set
   * to false, connections are distributed among all primary VMs when all primary and all backup
   * backend VMs are unhealthy.
   *
   * <p>The default is false.
   */
  public Boolean getDropTrafficIfUnhealthy() {
    return dropTrafficIfUnhealthy;
  }

  /**
   * Applicable only to Failover for Internal TCP/UDP Load Balancing. The value of the field must be
   * in the range [0, 1]. If the value is 0, the load balancer performs a failover when the number
   * of healthy primary VMs equals zero. For all other values, the load balancer performs a failover
   * when the total number of healthy primary VMs is less than this ratio.
   */
  public Float getFailoverRatio() {
    return failoverRatio;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServiceFailoverPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServiceFailoverPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServiceFailoverPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServiceFailoverPolicy();
  }

  public static class Builder {
    private Boolean disableConnectionDrainOnFailover;
    private Boolean dropTrafficIfUnhealthy;
    private Float failoverRatio;

    Builder() {}

    public Builder mergeFrom(BackendServiceFailoverPolicy other) {
      if (other == BackendServiceFailoverPolicy.getDefaultInstance()) return this;
      if (other.getDisableConnectionDrainOnFailover() != null) {
        this.disableConnectionDrainOnFailover = other.disableConnectionDrainOnFailover;
      }
      if (other.getDropTrafficIfUnhealthy() != null) {
        this.dropTrafficIfUnhealthy = other.dropTrafficIfUnhealthy;
      }
      if (other.getFailoverRatio() != null) {
        this.failoverRatio = other.failoverRatio;
      }
      return this;
    }

    Builder(BackendServiceFailoverPolicy source) {
      this.disableConnectionDrainOnFailover = source.disableConnectionDrainOnFailover;
      this.dropTrafficIfUnhealthy = source.dropTrafficIfUnhealthy;
      this.failoverRatio = source.failoverRatio;
    }

    /**
     * This can be set to true only if the protocol is TCP.
     *
     * <p>The default is false.
     */
    public Boolean getDisableConnectionDrainOnFailover() {
      return disableConnectionDrainOnFailover;
    }

    /**
     * This can be set to true only if the protocol is TCP.
     *
     * <p>The default is false.
     */
    public Builder setDisableConnectionDrainOnFailover(Boolean disableConnectionDrainOnFailover) {
      this.disableConnectionDrainOnFailover = disableConnectionDrainOnFailover;
      return this;
    }

    /**
     * Applicable only to Failover for Internal TCP/UDP Load Balancing. If set to true, connections
     * to the load balancer are dropped when all primary and all backup backend VMs are unhealthy.
     * If set to false, connections are distributed among all primary VMs when all primary and all
     * backup backend VMs are unhealthy.
     *
     * <p>The default is false.
     */
    public Boolean getDropTrafficIfUnhealthy() {
      return dropTrafficIfUnhealthy;
    }

    /**
     * Applicable only to Failover for Internal TCP/UDP Load Balancing. If set to true, connections
     * to the load balancer are dropped when all primary and all backup backend VMs are unhealthy.
     * If set to false, connections are distributed among all primary VMs when all primary and all
     * backup backend VMs are unhealthy.
     *
     * <p>The default is false.
     */
    public Builder setDropTrafficIfUnhealthy(Boolean dropTrafficIfUnhealthy) {
      this.dropTrafficIfUnhealthy = dropTrafficIfUnhealthy;
      return this;
    }

    /**
     * Applicable only to Failover for Internal TCP/UDP Load Balancing. The value of the field must
     * be in the range [0, 1]. If the value is 0, the load balancer performs a failover when the
     * number of healthy primary VMs equals zero. For all other values, the load balancer performs a
     * failover when the total number of healthy primary VMs is less than this ratio.
     */
    public Float getFailoverRatio() {
      return failoverRatio;
    }

    /**
     * Applicable only to Failover for Internal TCP/UDP Load Balancing. The value of the field must
     * be in the range [0, 1]. If the value is 0, the load balancer performs a failover when the
     * number of healthy primary VMs equals zero. For all other values, the load balancer performs a
     * failover when the total number of healthy primary VMs is less than this ratio.
     */
    public Builder setFailoverRatio(Float failoverRatio) {
      this.failoverRatio = failoverRatio;
      return this;
    }

    public BackendServiceFailoverPolicy build() {

      return new BackendServiceFailoverPolicy(
          disableConnectionDrainOnFailover, dropTrafficIfUnhealthy, failoverRatio);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDisableConnectionDrainOnFailover(this.disableConnectionDrainOnFailover);
      newBuilder.setDropTrafficIfUnhealthy(this.dropTrafficIfUnhealthy);
      newBuilder.setFailoverRatio(this.failoverRatio);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendServiceFailoverPolicy{"
        + "disableConnectionDrainOnFailover="
        + disableConnectionDrainOnFailover
        + ", "
        + "dropTrafficIfUnhealthy="
        + dropTrafficIfUnhealthy
        + ", "
        + "failoverRatio="
        + failoverRatio
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendServiceFailoverPolicy) {
      BackendServiceFailoverPolicy that = (BackendServiceFailoverPolicy) o;
      return Objects.equals(
              this.disableConnectionDrainOnFailover, that.getDisableConnectionDrainOnFailover())
          && Objects.equals(this.dropTrafficIfUnhealthy, that.getDropTrafficIfUnhealthy())
          && Objects.equals(this.failoverRatio, that.getFailoverRatio());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(disableConnectionDrainOnFailover, dropTrafficIfUnhealthy, failoverRatio);
  }
}
