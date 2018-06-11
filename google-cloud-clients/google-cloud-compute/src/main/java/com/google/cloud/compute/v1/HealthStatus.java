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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class HealthStatus implements ApiMessage {
  private final String healthState;
  private final String instance;
  private final String ipAddress;
  private final Integer port;

  private HealthStatus() {
    this.healthState = null;
    this.instance = null;
    this.ipAddress = null;
    this.port = null;
  }

  private HealthStatus(String healthState, String instance, String ipAddress, Integer port) {
    this.healthState = healthState;
    this.instance = instance;
    this.ipAddress = ipAddress;
    this.port = port;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("healthState")) {
      return healthState;
    }
    if (fieldName.equals("instance")) {
      return instance;
    }
    if (fieldName.equals("ipAddress")) {
      return ipAddress;
    }
    if (fieldName.equals("port")) {
      return port;
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

  public String getHealthState() {
    return healthState;
  }

  public String getInstance() {
    return instance;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public Integer getPort() {
    return port;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HealthStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthStatus();
  }

  public static class Builder {
    private String healthState;
    private String instance;
    private String ipAddress;
    private Integer port;

    Builder() {}

    public Builder mergeFrom(HealthStatus other) {
      if (other == HealthStatus.getDefaultInstance()) return this;
      if (other.getHealthState() != null) {
        this.healthState = other.healthState;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      return this;
    }

    Builder(HealthStatus source) {
      this.healthState = source.healthState;
      this.instance = source.instance;
      this.ipAddress = source.ipAddress;
      this.port = source.port;
    }

    public String getHealthState() {
      return healthState;
    }

    public Builder setHealthState(String healthState) {
      this.healthState = healthState;
      return this;
    }

    public String getInstance() {
      return instance;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public String getIpAddress() {
      return ipAddress;
    }

    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public Integer getPort() {
      return port;
    }

    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public HealthStatus build() {

      return new HealthStatus(healthState, instance, ipAddress, port);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHealthState(this.healthState);
      newBuilder.setInstance(this.instance);
      newBuilder.setIpAddress(this.ipAddress);
      newBuilder.setPort(this.port);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthStatus{"
        + "healthState="
        + healthState
        + ", "
        + "instance="
        + instance
        + ", "
        + "ipAddress="
        + ipAddress
        + ", "
        + "port="
        + port
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthStatus) {
      HealthStatus that = (HealthStatus) o;
      return Objects.equals(this.healthState, that.getHealthState())
          && Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.ipAddress, that.getIpAddress())
          && Objects.equals(this.port, that.getPort());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthState, instance, ipAddress, port);
  }
}
