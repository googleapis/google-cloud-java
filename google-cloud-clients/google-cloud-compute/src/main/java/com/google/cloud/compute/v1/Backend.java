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
   * Specifies the balancing mode for the backend.
   *
   * <p>When choosing a balancing mode, you need to consider the loadBalancingScheme, and protocol
   * for the backend service, as well as the type of backend (instance group or NEG).
   *
   * <p>- If the load balancing mode is CONNECTION, then the load is spread based on how many
   * concurrent connections the backend can handle. You can use the CONNECTION balancing mode if the
   * protocol for the backend service is SSL, TCP, or UDP.
   *
   * <p>If the loadBalancingScheme for the backend service is EXTERNAL (SSL Proxy and TCP Proxy load
   * balancers), you must also specify exactly one of the following parameters: maxConnections,
   * maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
   *
   * <p>If the loadBalancingScheme for the backend service is INTERNAL (internal TCP/UDP load
   * balancers), you cannot specify any additional parameters.
   *
   * <p>- If the load balancing mode is RATE, the load is spread based on the rate of HTTP requests
   * per second (RPS). You can use the RATE balancing mode if the protocol for the backend service
   * is HTTP or HTTPS. You must specify exactly one of the following parameters: maxRate,
   * maxRatePerInstance, or maxRatePerEndpoint.
   *
   * <p>- If the load balancing mode is UTILIZATION, the load is spread based on the CPU utilization
   * of instances in an instance group. You can use the UTILIZATION balancing mode if the
   * loadBalancingScheme of the backend service is EXTERNAL, INTERNAL_SELF_MANAGED, or
   * INTERNAL_MANAGED and the backends are instance groups. There are no restrictions on the backend
   * service protocol.
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
   * The fully-qualified URL of an instance group or network endpoint group (NEG) resource. The type
   * of backend that a backend service supports depends on the backend service's
   * loadBalancingScheme.
   *
   * <p>- When the loadBalancingScheme for the backend service is EXTERNAL, INTERNAL_SELF_MANAGED,
   * or INTERNAL_MANAGED, the backend can be either an instance group or a NEG. The backends on the
   * backend service must be either all instance groups or all NEGs. You cannot mix instance group
   * and NEG backends on the same backend service.
   *
   * <p>- When the loadBalancingScheme for the backend service is INTERNAL, the backend must be an
   * instance group in the same region as the backend service. NEGs are not supported.
   *
   * <p>You must use the fully-qualified URL (starting with https://www.googleapis.com/) to specify
   * the instance group or NEG. Partial URLs are not supported.
   */
  public String getGroup() {
    return group;
  }

  /**
   * Defines a maximum target for simultaneous connections for the entire backend (instance group or
   * NEG). If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
   * backend's balancingMode is CONNECTION, and backend is attached to a backend service whose
   * loadBalancingScheme is EXTERNAL, you must specify either this parameter,
   * maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
   *
   * <p>Not available if the backend's balancingMode is RATE. If the loadBalancingScheme is
   * INTERNAL, then maxConnections is not supported, even though the backend requires a balancing
   * mode of CONNECTION.
   */
  public Integer getMaxConnections() {
    return maxConnections;
  }

  /**
   * Defines a maximum target for simultaneous connections for an endpoint of a NEG. This is
   * multiplied by the number of endpoints in the NEG to implicitly calculate a maximum number of
   * target maximum simultaneous connections for the NEG. If the backend's balancingMode is
   * CONNECTION, and the backend is attached to a backend service whose loadBalancingScheme is
   * EXTERNAL, you must specify either this parameter, maxConnections, or maxConnectionsPerInstance.
   *
   * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
   * not support setting maxConnectionsPerEndpoint even though its backends require a balancing mode
   * of CONNECTION.
   */
  public Integer getMaxConnectionsPerEndpoint() {
    return maxConnectionsPerEndpoint;
  }

  /**
   * Defines a maximum target for simultaneous connections for a single VM in a backend instance
   * group. This is multiplied by the number of instances in the instance group to implicitly
   * calculate a target maximum number of simultaneous connections for the whole instance group. If
   * the backend's balancingMode is UTILIZATION, this is an optional parameter. If the backend's
   * balancingMode is CONNECTION, and backend is attached to a backend service whose
   * loadBalancingScheme is EXTERNAL, you must specify either this parameter, maxConnections, or
   * maxConnectionsPerEndpoint.
   *
   * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
   * not support setting maxConnectionsPerInstance even though its backends require a balancing mode
   * of CONNECTION.
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
   * Defines a maximum target for requests per second (RPS) for an endpoint of a NEG. This is
   * multiplied by the number of endpoints in the NEG to implicitly calculate a target maximum rate
   * for the NEG.
   *
   * <p>If the backend's balancingMode is RATE, you must specify either this parameter, maxRate, or
   * maxRatePerInstance.
   *
   * <p>Not available if the backend's balancingMode is CONNECTION.
   */
  public Float getMaxRatePerEndpoint() {
    return maxRatePerEndpoint;
  }

  /**
   * Defines a maximum target for requests per second (RPS) for a single VM in a backend instance
   * group. This is multiplied by the number of instances in the instance group to implicitly
   * calculate a target maximum rate for the whole instance group.
   *
   * <p>If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
   * backend's balancingMode is RATE, you must specify either this parameter, maxRate, or
   * maxRatePerEndpoint.
   *
   * <p>Not available if the backend's balancingMode is CONNECTION.
   */
  public Float getMaxRatePerInstance() {
    return maxRatePerInstance;
  }

  /**
   * Defines the maximum average CPU utilization of a backend VM in an instance group. The valid
   * range is [0.0, 1.0]. This is an optional parameter if the backend's balancingMode is
   * UTILIZATION.
   *
   * <p>This parameter can be used in conjunction with maxRate, maxRatePerInstance, maxConnections,
   * or maxConnectionsPerInstance.
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
     * Specifies the balancing mode for the backend.
     *
     * <p>When choosing a balancing mode, you need to consider the loadBalancingScheme, and protocol
     * for the backend service, as well as the type of backend (instance group or NEG).
     *
     * <p>- If the load balancing mode is CONNECTION, then the load is spread based on how many
     * concurrent connections the backend can handle. You can use the CONNECTION balancing mode if
     * the protocol for the backend service is SSL, TCP, or UDP.
     *
     * <p>If the loadBalancingScheme for the backend service is EXTERNAL (SSL Proxy and TCP Proxy
     * load balancers), you must also specify exactly one of the following parameters:
     * maxConnections, maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
     *
     * <p>If the loadBalancingScheme for the backend service is INTERNAL (internal TCP/UDP load
     * balancers), you cannot specify any additional parameters.
     *
     * <p>- If the load balancing mode is RATE, the load is spread based on the rate of HTTP
     * requests per second (RPS). You can use the RATE balancing mode if the protocol for the
     * backend service is HTTP or HTTPS. You must specify exactly one of the following parameters:
     * maxRate, maxRatePerInstance, or maxRatePerEndpoint.
     *
     * <p>- If the load balancing mode is UTILIZATION, the load is spread based on the CPU
     * utilization of instances in an instance group. You can use the UTILIZATION balancing mode if
     * the loadBalancingScheme of the backend service is EXTERNAL, INTERNAL_SELF_MANAGED, or
     * INTERNAL_MANAGED and the backends are instance groups. There are no restrictions on the
     * backend service protocol.
     */
    public String getBalancingMode() {
      return balancingMode;
    }

    /**
     * Specifies the balancing mode for the backend.
     *
     * <p>When choosing a balancing mode, you need to consider the loadBalancingScheme, and protocol
     * for the backend service, as well as the type of backend (instance group or NEG).
     *
     * <p>- If the load balancing mode is CONNECTION, then the load is spread based on how many
     * concurrent connections the backend can handle. You can use the CONNECTION balancing mode if
     * the protocol for the backend service is SSL, TCP, or UDP.
     *
     * <p>If the loadBalancingScheme for the backend service is EXTERNAL (SSL Proxy and TCP Proxy
     * load balancers), you must also specify exactly one of the following parameters:
     * maxConnections, maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
     *
     * <p>If the loadBalancingScheme for the backend service is INTERNAL (internal TCP/UDP load
     * balancers), you cannot specify any additional parameters.
     *
     * <p>- If the load balancing mode is RATE, the load is spread based on the rate of HTTP
     * requests per second (RPS). You can use the RATE balancing mode if the protocol for the
     * backend service is HTTP or HTTPS. You must specify exactly one of the following parameters:
     * maxRate, maxRatePerInstance, or maxRatePerEndpoint.
     *
     * <p>- If the load balancing mode is UTILIZATION, the load is spread based on the CPU
     * utilization of instances in an instance group. You can use the UTILIZATION balancing mode if
     * the loadBalancingScheme of the backend service is EXTERNAL, INTERNAL_SELF_MANAGED, or
     * INTERNAL_MANAGED and the backends are instance groups. There are no restrictions on the
     * backend service protocol.
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
     * The fully-qualified URL of an instance group or network endpoint group (NEG) resource. The
     * type of backend that a backend service supports depends on the backend service's
     * loadBalancingScheme.
     *
     * <p>- When the loadBalancingScheme for the backend service is EXTERNAL, INTERNAL_SELF_MANAGED,
     * or INTERNAL_MANAGED, the backend can be either an instance group or a NEG. The backends on
     * the backend service must be either all instance groups or all NEGs. You cannot mix instance
     * group and NEG backends on the same backend service.
     *
     * <p>- When the loadBalancingScheme for the backend service is INTERNAL, the backend must be an
     * instance group in the same region as the backend service. NEGs are not supported.
     *
     * <p>You must use the fully-qualified URL (starting with https://www.googleapis.com/) to
     * specify the instance group or NEG. Partial URLs are not supported.
     */
    public String getGroup() {
      return group;
    }

    /**
     * The fully-qualified URL of an instance group or network endpoint group (NEG) resource. The
     * type of backend that a backend service supports depends on the backend service's
     * loadBalancingScheme.
     *
     * <p>- When the loadBalancingScheme for the backend service is EXTERNAL, INTERNAL_SELF_MANAGED,
     * or INTERNAL_MANAGED, the backend can be either an instance group or a NEG. The backends on
     * the backend service must be either all instance groups or all NEGs. You cannot mix instance
     * group and NEG backends on the same backend service.
     *
     * <p>- When the loadBalancingScheme for the backend service is INTERNAL, the backend must be an
     * instance group in the same region as the backend service. NEGs are not supported.
     *
     * <p>You must use the fully-qualified URL (starting with https://www.googleapis.com/) to
     * specify the instance group or NEG. Partial URLs are not supported.
     */
    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    /**
     * Defines a maximum target for simultaneous connections for the entire backend (instance group
     * or NEG). If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is CONNECTION, and backend is attached to a backend service whose
     * loadBalancingScheme is EXTERNAL, you must specify either this parameter,
     * maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is RATE. If the loadBalancingScheme is
     * INTERNAL, then maxConnections is not supported, even though the backend requires a balancing
     * mode of CONNECTION.
     */
    public Integer getMaxConnections() {
      return maxConnections;
    }

    /**
     * Defines a maximum target for simultaneous connections for the entire backend (instance group
     * or NEG). If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is CONNECTION, and backend is attached to a backend service whose
     * loadBalancingScheme is EXTERNAL, you must specify either this parameter,
     * maxConnectionsPerInstance, or maxConnectionsPerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is RATE. If the loadBalancingScheme is
     * INTERNAL, then maxConnections is not supported, even though the backend requires a balancing
     * mode of CONNECTION.
     */
    public Builder setMaxConnections(Integer maxConnections) {
      this.maxConnections = maxConnections;
      return this;
    }

    /**
     * Defines a maximum target for simultaneous connections for an endpoint of a NEG. This is
     * multiplied by the number of endpoints in the NEG to implicitly calculate a maximum number of
     * target maximum simultaneous connections for the NEG. If the backend's balancingMode is
     * CONNECTION, and the backend is attached to a backend service whose loadBalancingScheme is
     * EXTERNAL, you must specify either this parameter, maxConnections, or
     * maxConnectionsPerInstance.
     *
     * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
     * not support setting maxConnectionsPerEndpoint even though its backends require a balancing
     * mode of CONNECTION.
     */
    public Integer getMaxConnectionsPerEndpoint() {
      return maxConnectionsPerEndpoint;
    }

    /**
     * Defines a maximum target for simultaneous connections for an endpoint of a NEG. This is
     * multiplied by the number of endpoints in the NEG to implicitly calculate a maximum number of
     * target maximum simultaneous connections for the NEG. If the backend's balancingMode is
     * CONNECTION, and the backend is attached to a backend service whose loadBalancingScheme is
     * EXTERNAL, you must specify either this parameter, maxConnections, or
     * maxConnectionsPerInstance.
     *
     * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
     * not support setting maxConnectionsPerEndpoint even though its backends require a balancing
     * mode of CONNECTION.
     */
    public Builder setMaxConnectionsPerEndpoint(Integer maxConnectionsPerEndpoint) {
      this.maxConnectionsPerEndpoint = maxConnectionsPerEndpoint;
      return this;
    }

    /**
     * Defines a maximum target for simultaneous connections for a single VM in a backend instance
     * group. This is multiplied by the number of instances in the instance group to implicitly
     * calculate a target maximum number of simultaneous connections for the whole instance group.
     * If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is CONNECTION, and backend is attached to a backend service whose
     * loadBalancingScheme is EXTERNAL, you must specify either this parameter, maxConnections, or
     * maxConnectionsPerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
     * not support setting maxConnectionsPerInstance even though its backends require a balancing
     * mode of CONNECTION.
     */
    public Integer getMaxConnectionsPerInstance() {
      return maxConnectionsPerInstance;
    }

    /**
     * Defines a maximum target for simultaneous connections for a single VM in a backend instance
     * group. This is multiplied by the number of instances in the instance group to implicitly
     * calculate a target maximum number of simultaneous connections for the whole instance group.
     * If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is CONNECTION, and backend is attached to a backend service whose
     * loadBalancingScheme is EXTERNAL, you must specify either this parameter, maxConnections, or
     * maxConnectionsPerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is RATE. Internal TCP/UDP load balancing does
     * not support setting maxConnectionsPerInstance even though its backends require a balancing
     * mode of CONNECTION.
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
     * Defines a maximum target for requests per second (RPS) for an endpoint of a NEG. This is
     * multiplied by the number of endpoints in the NEG to implicitly calculate a target maximum
     * rate for the NEG.
     *
     * <p>If the backend's balancingMode is RATE, you must specify either this parameter, maxRate,
     * or maxRatePerInstance.
     *
     * <p>Not available if the backend's balancingMode is CONNECTION.
     */
    public Float getMaxRatePerEndpoint() {
      return maxRatePerEndpoint;
    }

    /**
     * Defines a maximum target for requests per second (RPS) for an endpoint of a NEG. This is
     * multiplied by the number of endpoints in the NEG to implicitly calculate a target maximum
     * rate for the NEG.
     *
     * <p>If the backend's balancingMode is RATE, you must specify either this parameter, maxRate,
     * or maxRatePerInstance.
     *
     * <p>Not available if the backend's balancingMode is CONNECTION.
     */
    public Builder setMaxRatePerEndpoint(Float maxRatePerEndpoint) {
      this.maxRatePerEndpoint = maxRatePerEndpoint;
      return this;
    }

    /**
     * Defines a maximum target for requests per second (RPS) for a single VM in a backend instance
     * group. This is multiplied by the number of instances in the instance group to implicitly
     * calculate a target maximum rate for the whole instance group.
     *
     * <p>If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is RATE, you must specify either this parameter, maxRate, or
     * maxRatePerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is CONNECTION.
     */
    public Float getMaxRatePerInstance() {
      return maxRatePerInstance;
    }

    /**
     * Defines a maximum target for requests per second (RPS) for a single VM in a backend instance
     * group. This is multiplied by the number of instances in the instance group to implicitly
     * calculate a target maximum rate for the whole instance group.
     *
     * <p>If the backend's balancingMode is UTILIZATION, this is an optional parameter. If the
     * backend's balancingMode is RATE, you must specify either this parameter, maxRate, or
     * maxRatePerEndpoint.
     *
     * <p>Not available if the backend's balancingMode is CONNECTION.
     */
    public Builder setMaxRatePerInstance(Float maxRatePerInstance) {
      this.maxRatePerInstance = maxRatePerInstance;
      return this;
    }

    /**
     * Defines the maximum average CPU utilization of a backend VM in an instance group. The valid
     * range is [0.0, 1.0]. This is an optional parameter if the backend's balancingMode is
     * UTILIZATION.
     *
     * <p>This parameter can be used in conjunction with maxRate, maxRatePerInstance,
     * maxConnections, or maxConnectionsPerInstance.
     */
    public Float getMaxUtilization() {
      return maxUtilization;
    }

    /**
     * Defines the maximum average CPU utilization of a backend VM in an instance group. The valid
     * range is [0.0, 1.0]. This is an optional parameter if the backend's balancingMode is
     * UTILIZATION.
     *
     * <p>This parameter can be used in conjunction with maxRate, maxRatePerInstance,
     * maxConnections, or maxConnectionsPerInstance.
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
