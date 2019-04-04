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
/** Message containing information of one individual backend. */
public final class Backend implements ApiMessage {
  private final String balancingMode;
  private final Float capacityScaler;
  private final String description;
  private final String group;
  private final Integer maxConnections;
  private final Integer maxConnectionsPerEndpoint;
  private final Integer maxConnectionsPerInstance;
  private final Integer maxRate;
  private final Float maxRatePerEndpoint;
  private final Float maxRatePerInstance;
  private final Float maxUtilization;

  private Backend() {
    this.balancingMode = null;
    this.capacityScaler = null;
    this.description = null;
    this.group = null;
    this.maxConnections = null;
    this.maxConnectionsPerEndpoint = null;
    this.maxConnectionsPerInstance = null;
    this.maxRate = null;
    this.maxRatePerEndpoint = null;
    this.maxRatePerInstance = null;
    this.maxUtilization = null;
  }

  private Backend(
      String balancingMode,
      Float capacityScaler,
      String description,
      String group,
      Integer maxConnections,
      Integer maxConnectionsPerEndpoint,
      Integer maxConnectionsPerInstance,
      Integer maxRate,
      Float maxRatePerEndpoint,
      Float maxRatePerInstance,
      Float maxUtilization) {
    this.balancingMode = balancingMode;
    this.capacityScaler = capacityScaler;
    this.description = description;
    this.group = group;
    this.maxConnections = maxConnections;
    this.maxConnectionsPerEndpoint = maxConnectionsPerEndpoint;
    this.maxConnectionsPerInstance = maxConnectionsPerInstance;
    this.maxRate = maxRate;
    this.maxRatePerEndpoint = maxRatePerEndpoint;
    this.maxRatePerInstance = maxRatePerInstance;
    this.maxUtilization = maxUtilization;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("balancingMode".equals(fieldName)) {
      return balancingMode;
    }
    if ("capacityScaler".equals(fieldName)) {
      return capacityScaler;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("group".equals(fieldName)) {
      return group;
    }
    if ("maxConnections".equals(fieldName)) {
      return maxConnections;
    }
    if ("maxConnectionsPerEndpoint".equals(fieldName)) {
      return maxConnectionsPerEndpoint;
    }
    if ("maxConnectionsPerInstance".equals(fieldName)) {
      return maxConnectionsPerInstance;
    }
    if ("maxRate".equals(fieldName)) {
      return maxRate;
    }
    if ("maxRatePerEndpoint".equals(fieldName)) {
      return maxRatePerEndpoint;
    }
    if ("maxRatePerInstance".equals(fieldName)) {
      return maxRatePerInstance;
    }
    if ("maxUtilization".equals(fieldName)) {
      return maxUtilization;
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
   * Specifies the balancing mode for this backend. For global HTTP(S) or TCP/SSL load balancing,
   * the default is UTILIZATION. Valid values are UTILIZATION, RATE (for HTTP(S)) and CONNECTION
   * (for TCP/SSL).
   *
   * <p>For Internal Load Balancing, the default and only supported mode is CONNECTION.
   */
  public String getBalancingMode() {
    return balancingMode;
  }

  /**
   * A multiplier applied to the group's maximum servicing capacity (based on UTILIZATION, RATE or
   * CONNECTION). Default value is 1, which means the group will serve up to 100% of its configured
   * capacity (depending on balancingMode). A setting of 0 means the group is completely drained,
   * offering 0% of its available Capacity. Valid range is [0.0,1.0].
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Float getCapacityScaler() {
    return capacityScaler;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The fully-qualified URL of an Instance Group or Network Endpoint Group resource. In case of
   * instance group this defines the list of instances that serve traffic. Member virtual machine
   * instances from each instance group must live in the same zone as the instance group itself. No
   * two backends in a backend service are allowed to use same Instance Group resource.
   *
   * <p>For Network Endpoint Groups this defines list of endpoints. All endpoints of Network
   * Endpoint Group must be hosted on instances located in the same zone as the Network Endpoint
   * Group.
   *
   * <p>Backend service can not contain mix of Instance Group and Network Endpoint Group backends.
   *
   * <p>Note that you must specify an Instance Group or Network Endpoint Group resource using the
   * fully-qualified URL, rather than a partial URL.
   *
   * <p>When the BackendService has load balancing scheme INTERNAL, the instance group must be
   * within the same region as the BackendService. Network Endpoint Groups are not supported for
   * INTERNAL load balancing scheme.
   */
  public String getGroup() {
    return group;
  }

  /**
   * The max number of simultaneous connections for the group. Can be used with either CONNECTION or
   * UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
   * maxConnectionsPerInstance must be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Integer getMaxConnections() {
    return maxConnections;
  }

  /**
   * The max number of simultaneous connections that a single backend network endpoint can handle.
   * This is used to calculate the capacity of the group. Can be used in either CONNECTION or
   * UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
   * maxConnectionsPerEndpoint must be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Integer getMaxConnectionsPerEndpoint() {
    return maxConnectionsPerEndpoint;
  }

  /**
   * The max number of simultaneous connections that a single backend instance can handle. This is
   * used to calculate the capacity of the group. Can be used in either CONNECTION or UTILIZATION
   * balancing modes. For CONNECTION mode, either maxConnections or maxConnectionsPerInstance must
   * be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Integer getMaxConnectionsPerInstance() {
    return maxConnectionsPerInstance;
  }

  /**
   * The max requests per second (RPS) of the group. Can be used with either RATE or UTILIZATION
   * balancing modes, but required if RATE mode. For RATE mode, either maxRate or maxRatePerInstance
   * must be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Integer getMaxRate() {
    return maxRate;
  }

  /**
   * The max requests per second (RPS) that a single backend network endpoint can handle. This is
   * used to calculate the capacity of the group. Can be used in either balancing mode. For RATE
   * mode, either maxRate or maxRatePerEndpoint must be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Float getMaxRatePerEndpoint() {
    return maxRatePerEndpoint;
  }

  /**
   * The max requests per second (RPS) that a single backend instance can handle. This is used to
   * calculate the capacity of the group. Can be used in either balancing mode. For RATE mode,
   * either maxRate or maxRatePerInstance must be set.
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Float getMaxRatePerInstance() {
    return maxRatePerInstance;
  }

  /**
   * Used when balancingMode is UTILIZATION. This ratio defines the CPU utilization target for the
   * group. The default is 0.8. Valid range is [0.0, 1.0].
   *
   * <p>This cannot be used for internal load balancing.
   */
  public Float getMaxUtilization() {
    return maxUtilization;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Backend prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Backend getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Backend DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Backend();
  }

  public static class Builder {
    private String balancingMode;
    private Float capacityScaler;
    private String description;
    private String group;
    private Integer maxConnections;
    private Integer maxConnectionsPerEndpoint;
    private Integer maxConnectionsPerInstance;
    private Integer maxRate;
    private Float maxRatePerEndpoint;
    private Float maxRatePerInstance;
    private Float maxUtilization;

    Builder() {}

    public Builder mergeFrom(Backend other) {
      if (other == Backend.getDefaultInstance()) return this;
      if (other.getBalancingMode() != null) {
        this.balancingMode = other.balancingMode;
      }
      if (other.getCapacityScaler() != null) {
        this.capacityScaler = other.capacityScaler;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGroup() != null) {
        this.group = other.group;
      }
      if (other.getMaxConnections() != null) {
        this.maxConnections = other.maxConnections;
      }
      if (other.getMaxConnectionsPerEndpoint() != null) {
        this.maxConnectionsPerEndpoint = other.maxConnectionsPerEndpoint;
      }
      if (other.getMaxConnectionsPerInstance() != null) {
        this.maxConnectionsPerInstance = other.maxConnectionsPerInstance;
      }
      if (other.getMaxRate() != null) {
        this.maxRate = other.maxRate;
      }
      if (other.getMaxRatePerEndpoint() != null) {
        this.maxRatePerEndpoint = other.maxRatePerEndpoint;
      }
      if (other.getMaxRatePerInstance() != null) {
        this.maxRatePerInstance = other.maxRatePerInstance;
      }
      if (other.getMaxUtilization() != null) {
        this.maxUtilization = other.maxUtilization;
      }
      return this;
    }

    Builder(Backend source) {
      this.balancingMode = source.balancingMode;
      this.capacityScaler = source.capacityScaler;
      this.description = source.description;
      this.group = source.group;
      this.maxConnections = source.maxConnections;
      this.maxConnectionsPerEndpoint = source.maxConnectionsPerEndpoint;
      this.maxConnectionsPerInstance = source.maxConnectionsPerInstance;
      this.maxRate = source.maxRate;
      this.maxRatePerEndpoint = source.maxRatePerEndpoint;
      this.maxRatePerInstance = source.maxRatePerInstance;
      this.maxUtilization = source.maxUtilization;
    }

    /**
     * Specifies the balancing mode for this backend. For global HTTP(S) or TCP/SSL load balancing,
     * the default is UTILIZATION. Valid values are UTILIZATION, RATE (for HTTP(S)) and CONNECTION
     * (for TCP/SSL).
     *
     * <p>For Internal Load Balancing, the default and only supported mode is CONNECTION.
     */
    public String getBalancingMode() {
      return balancingMode;
    }

    /**
     * Specifies the balancing mode for this backend. For global HTTP(S) or TCP/SSL load balancing,
     * the default is UTILIZATION. Valid values are UTILIZATION, RATE (for HTTP(S)) and CONNECTION
     * (for TCP/SSL).
     *
     * <p>For Internal Load Balancing, the default and only supported mode is CONNECTION.
     */
    public Builder setBalancingMode(String balancingMode) {
      this.balancingMode = balancingMode;
      return this;
    }

    /**
     * A multiplier applied to the group's maximum servicing capacity (based on UTILIZATION, RATE or
     * CONNECTION). Default value is 1, which means the group will serve up to 100% of its
     * configured capacity (depending on balancingMode). A setting of 0 means the group is
     * completely drained, offering 0% of its available Capacity. Valid range is [0.0,1.0].
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Float getCapacityScaler() {
      return capacityScaler;
    }

    /**
     * A multiplier applied to the group's maximum servicing capacity (based on UTILIZATION, RATE or
     * CONNECTION). Default value is 1, which means the group will serve up to 100% of its
     * configured capacity (depending on balancingMode). A setting of 0 means the group is
     * completely drained, offering 0% of its available Capacity. Valid range is [0.0,1.0].
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setCapacityScaler(Float capacityScaler) {
      this.capacityScaler = capacityScaler;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * The fully-qualified URL of an Instance Group or Network Endpoint Group resource. In case of
     * instance group this defines the list of instances that serve traffic. Member virtual machine
     * instances from each instance group must live in the same zone as the instance group itself.
     * No two backends in a backend service are allowed to use same Instance Group resource.
     *
     * <p>For Network Endpoint Groups this defines list of endpoints. All endpoints of Network
     * Endpoint Group must be hosted on instances located in the same zone as the Network Endpoint
     * Group.
     *
     * <p>Backend service can not contain mix of Instance Group and Network Endpoint Group backends.
     *
     * <p>Note that you must specify an Instance Group or Network Endpoint Group resource using the
     * fully-qualified URL, rather than a partial URL.
     *
     * <p>When the BackendService has load balancing scheme INTERNAL, the instance group must be
     * within the same region as the BackendService. Network Endpoint Groups are not supported for
     * INTERNAL load balancing scheme.
     */
    public String getGroup() {
      return group;
    }

    /**
     * The fully-qualified URL of an Instance Group or Network Endpoint Group resource. In case of
     * instance group this defines the list of instances that serve traffic. Member virtual machine
     * instances from each instance group must live in the same zone as the instance group itself.
     * No two backends in a backend service are allowed to use same Instance Group resource.
     *
     * <p>For Network Endpoint Groups this defines list of endpoints. All endpoints of Network
     * Endpoint Group must be hosted on instances located in the same zone as the Network Endpoint
     * Group.
     *
     * <p>Backend service can not contain mix of Instance Group and Network Endpoint Group backends.
     *
     * <p>Note that you must specify an Instance Group or Network Endpoint Group resource using the
     * fully-qualified URL, rather than a partial URL.
     *
     * <p>When the BackendService has load balancing scheme INTERNAL, the instance group must be
     * within the same region as the BackendService. Network Endpoint Groups are not supported for
     * INTERNAL load balancing scheme.
     */
    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    /**
     * The max number of simultaneous connections for the group. Can be used with either CONNECTION
     * or UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
     * maxConnectionsPerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Integer getMaxConnections() {
      return maxConnections;
    }

    /**
     * The max number of simultaneous connections for the group. Can be used with either CONNECTION
     * or UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
     * maxConnectionsPerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxConnections(Integer maxConnections) {
      this.maxConnections = maxConnections;
      return this;
    }

    /**
     * The max number of simultaneous connections that a single backend network endpoint can handle.
     * This is used to calculate the capacity of the group. Can be used in either CONNECTION or
     * UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
     * maxConnectionsPerEndpoint must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Integer getMaxConnectionsPerEndpoint() {
      return maxConnectionsPerEndpoint;
    }

    /**
     * The max number of simultaneous connections that a single backend network endpoint can handle.
     * This is used to calculate the capacity of the group. Can be used in either CONNECTION or
     * UTILIZATION balancing modes. For CONNECTION mode, either maxConnections or
     * maxConnectionsPerEndpoint must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxConnectionsPerEndpoint(Integer maxConnectionsPerEndpoint) {
      this.maxConnectionsPerEndpoint = maxConnectionsPerEndpoint;
      return this;
    }

    /**
     * The max number of simultaneous connections that a single backend instance can handle. This is
     * used to calculate the capacity of the group. Can be used in either CONNECTION or UTILIZATION
     * balancing modes. For CONNECTION mode, either maxConnections or maxConnectionsPerInstance must
     * be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Integer getMaxConnectionsPerInstance() {
      return maxConnectionsPerInstance;
    }

    /**
     * The max number of simultaneous connections that a single backend instance can handle. This is
     * used to calculate the capacity of the group. Can be used in either CONNECTION or UTILIZATION
     * balancing modes. For CONNECTION mode, either maxConnections or maxConnectionsPerInstance must
     * be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxConnectionsPerInstance(Integer maxConnectionsPerInstance) {
      this.maxConnectionsPerInstance = maxConnectionsPerInstance;
      return this;
    }

    /**
     * The max requests per second (RPS) of the group. Can be used with either RATE or UTILIZATION
     * balancing modes, but required if RATE mode. For RATE mode, either maxRate or
     * maxRatePerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Integer getMaxRate() {
      return maxRate;
    }

    /**
     * The max requests per second (RPS) of the group. Can be used with either RATE or UTILIZATION
     * balancing modes, but required if RATE mode. For RATE mode, either maxRate or
     * maxRatePerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxRate(Integer maxRate) {
      this.maxRate = maxRate;
      return this;
    }

    /**
     * The max requests per second (RPS) that a single backend network endpoint can handle. This is
     * used to calculate the capacity of the group. Can be used in either balancing mode. For RATE
     * mode, either maxRate or maxRatePerEndpoint must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Float getMaxRatePerEndpoint() {
      return maxRatePerEndpoint;
    }

    /**
     * The max requests per second (RPS) that a single backend network endpoint can handle. This is
     * used to calculate the capacity of the group. Can be used in either balancing mode. For RATE
     * mode, either maxRate or maxRatePerEndpoint must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxRatePerEndpoint(Float maxRatePerEndpoint) {
      this.maxRatePerEndpoint = maxRatePerEndpoint;
      return this;
    }

    /**
     * The max requests per second (RPS) that a single backend instance can handle. This is used to
     * calculate the capacity of the group. Can be used in either balancing mode. For RATE mode,
     * either maxRate or maxRatePerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Float getMaxRatePerInstance() {
      return maxRatePerInstance;
    }

    /**
     * The max requests per second (RPS) that a single backend instance can handle. This is used to
     * calculate the capacity of the group. Can be used in either balancing mode. For RATE mode,
     * either maxRate or maxRatePerInstance must be set.
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxRatePerInstance(Float maxRatePerInstance) {
      this.maxRatePerInstance = maxRatePerInstance;
      return this;
    }

    /**
     * Used when balancingMode is UTILIZATION. This ratio defines the CPU utilization target for the
     * group. The default is 0.8. Valid range is [0.0, 1.0].
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Float getMaxUtilization() {
      return maxUtilization;
    }

    /**
     * Used when balancingMode is UTILIZATION. This ratio defines the CPU utilization target for the
     * group. The default is 0.8. Valid range is [0.0, 1.0].
     *
     * <p>This cannot be used for internal load balancing.
     */
    public Builder setMaxUtilization(Float maxUtilization) {
      this.maxUtilization = maxUtilization;
      return this;
    }

    public Backend build() {

      return new Backend(
          balancingMode,
          capacityScaler,
          description,
          group,
          maxConnections,
          maxConnectionsPerEndpoint,
          maxConnectionsPerInstance,
          maxRate,
          maxRatePerEndpoint,
          maxRatePerInstance,
          maxUtilization);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBalancingMode(this.balancingMode);
      newBuilder.setCapacityScaler(this.capacityScaler);
      newBuilder.setDescription(this.description);
      newBuilder.setGroup(this.group);
      newBuilder.setMaxConnections(this.maxConnections);
      newBuilder.setMaxConnectionsPerEndpoint(this.maxConnectionsPerEndpoint);
      newBuilder.setMaxConnectionsPerInstance(this.maxConnectionsPerInstance);
      newBuilder.setMaxRate(this.maxRate);
      newBuilder.setMaxRatePerEndpoint(this.maxRatePerEndpoint);
      newBuilder.setMaxRatePerInstance(this.maxRatePerInstance);
      newBuilder.setMaxUtilization(this.maxUtilization);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Backend{"
        + "balancingMode="
        + balancingMode
        + ", "
        + "capacityScaler="
        + capacityScaler
        + ", "
        + "description="
        + description
        + ", "
        + "group="
        + group
        + ", "
        + "maxConnections="
        + maxConnections
        + ", "
        + "maxConnectionsPerEndpoint="
        + maxConnectionsPerEndpoint
        + ", "
        + "maxConnectionsPerInstance="
        + maxConnectionsPerInstance
        + ", "
        + "maxRate="
        + maxRate
        + ", "
        + "maxRatePerEndpoint="
        + maxRatePerEndpoint
        + ", "
        + "maxRatePerInstance="
        + maxRatePerInstance
        + ", "
        + "maxUtilization="
        + maxUtilization
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Backend) {
      Backend that = (Backend) o;
      return Objects.equals(this.balancingMode, that.getBalancingMode())
          && Objects.equals(this.capacityScaler, that.getCapacityScaler())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.group, that.getGroup())
          && Objects.equals(this.maxConnections, that.getMaxConnections())
          && Objects.equals(this.maxConnectionsPerEndpoint, that.getMaxConnectionsPerEndpoint())
          && Objects.equals(this.maxConnectionsPerInstance, that.getMaxConnectionsPerInstance())
          && Objects.equals(this.maxRate, that.getMaxRate())
          && Objects.equals(this.maxRatePerEndpoint, that.getMaxRatePerEndpoint())
          && Objects.equals(this.maxRatePerInstance, that.getMaxRatePerInstance())
          && Objects.equals(this.maxUtilization, that.getMaxUtilization());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        balancingMode,
        capacityScaler,
        description,
        group,
        maxConnections,
        maxConnectionsPerEndpoint,
        maxConnectionsPerInstance,
        maxRate,
        maxRatePerEndpoint,
        maxRatePerInstance,
        maxUtilization);
  }
}
