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
public final class HealthStatusForNetworkEndpoint implements ApiMessage {
  private final BackendServiceReference backendService;
  private final ForwardingRuleReference forwardingRule;
  private final HealthCheckReference healthCheck;
  private final String healthState;

  private HealthStatusForNetworkEndpoint() {
    this.backendService = null;
    this.forwardingRule = null;
    this.healthCheck = null;
    this.healthState = null;
  }

  private HealthStatusForNetworkEndpoint(
      BackendServiceReference backendService,
      ForwardingRuleReference forwardingRule,
      HealthCheckReference healthCheck,
      String healthState) {
    this.backendService = backendService;
    this.forwardingRule = forwardingRule;
    this.healthCheck = healthCheck;
    this.healthState = healthState;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("backendService".equals(fieldName)) {
      return backendService;
    }
    if ("forwardingRule".equals(fieldName)) {
      return forwardingRule;
    }
    if ("healthCheck".equals(fieldName)) {
      return healthCheck;
    }
    if ("healthState".equals(fieldName)) {
      return healthState;
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

  /** URL of the backend service associated with the health state of the network endpoint. */
  public BackendServiceReference getBackendService() {
    return backendService;
  }

  /** URL of the forwarding rule associated with the health state of the network endpoint. */
  public ForwardingRuleReference getForwardingRule() {
    return forwardingRule;
  }

  /** URL of the health check associated with the health state of the network endpoint. */
  public HealthCheckReference getHealthCheck() {
    return healthCheck;
  }

  /** Health state of the network endpoint determined based on the health checks configured. */
  public String getHealthState() {
    return healthState;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HealthStatusForNetworkEndpoint prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthStatusForNetworkEndpoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthStatusForNetworkEndpoint DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthStatusForNetworkEndpoint();
  }

  public static class Builder {
    private BackendServiceReference backendService;
    private ForwardingRuleReference forwardingRule;
    private HealthCheckReference healthCheck;
    private String healthState;

    Builder() {}

    public Builder mergeFrom(HealthStatusForNetworkEndpoint other) {
      if (other == HealthStatusForNetworkEndpoint.getDefaultInstance()) return this;
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
      }
      if (other.getForwardingRule() != null) {
        this.forwardingRule = other.forwardingRule;
      }
      if (other.getHealthCheck() != null) {
        this.healthCheck = other.healthCheck;
      }
      if (other.getHealthState() != null) {
        this.healthState = other.healthState;
      }
      return this;
    }

    Builder(HealthStatusForNetworkEndpoint source) {
      this.backendService = source.backendService;
      this.forwardingRule = source.forwardingRule;
      this.healthCheck = source.healthCheck;
      this.healthState = source.healthState;
    }

    /** URL of the backend service associated with the health state of the network endpoint. */
    public BackendServiceReference getBackendService() {
      return backendService;
    }

    /** URL of the backend service associated with the health state of the network endpoint. */
    public Builder setBackendService(BackendServiceReference backendService) {
      this.backendService = backendService;
      return this;
    }

    /** URL of the forwarding rule associated with the health state of the network endpoint. */
    public ForwardingRuleReference getForwardingRule() {
      return forwardingRule;
    }

    /** URL of the forwarding rule associated with the health state of the network endpoint. */
    public Builder setForwardingRule(ForwardingRuleReference forwardingRule) {
      this.forwardingRule = forwardingRule;
      return this;
    }

    /** URL of the health check associated with the health state of the network endpoint. */
    public HealthCheckReference getHealthCheck() {
      return healthCheck;
    }

    /** URL of the health check associated with the health state of the network endpoint. */
    public Builder setHealthCheck(HealthCheckReference healthCheck) {
      this.healthCheck = healthCheck;
      return this;
    }

    /** Health state of the network endpoint determined based on the health checks configured. */
    public String getHealthState() {
      return healthState;
    }

    /** Health state of the network endpoint determined based on the health checks configured. */
    public Builder setHealthState(String healthState) {
      this.healthState = healthState;
      return this;
    }

    public HealthStatusForNetworkEndpoint build() {

      return new HealthStatusForNetworkEndpoint(
          backendService, forwardingRule, healthCheck, healthState);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBackendService(this.backendService);
      newBuilder.setForwardingRule(this.forwardingRule);
      newBuilder.setHealthCheck(this.healthCheck);
      newBuilder.setHealthState(this.healthState);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthStatusForNetworkEndpoint{"
        + "backendService="
        + backendService
        + ", "
        + "forwardingRule="
        + forwardingRule
        + ", "
        + "healthCheck="
        + healthCheck
        + ", "
        + "healthState="
        + healthState
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthStatusForNetworkEndpoint) {
      HealthStatusForNetworkEndpoint that = (HealthStatusForNetworkEndpoint) o;
      return Objects.equals(this.backendService, that.getBackendService())
          && Objects.equals(this.forwardingRule, that.getForwardingRule())
          && Objects.equals(this.healthCheck, that.getHealthCheck())
          && Objects.equals(this.healthState, that.getHealthState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendService, forwardingRule, healthCheck, healthState);
  }
}
