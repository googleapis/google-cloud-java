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
public final class NetworkEndpointGroupsListEndpointsRequest implements ApiMessage {
  private final String healthStatus;

  private NetworkEndpointGroupsListEndpointsRequest() {
    this.healthStatus = null;
  }

  private NetworkEndpointGroupsListEndpointsRequest(String healthStatus) {
    this.healthStatus = healthStatus;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("healthStatus".equals(fieldName)) {
      return healthStatus;
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
   * Optional query parameter for showing the health status of each network endpoint. Valid options
   * are SKIP or SHOW. If you don't specifiy this parameter, the health status of network endpoints
   * will not be provided.
   */
  public String getHealthStatus() {
    return healthStatus;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupsListEndpointsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupsListEndpointsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupsListEndpointsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupsListEndpointsRequest();
  }

  public static class Builder {
    private String healthStatus;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupsListEndpointsRequest other) {
      if (other == NetworkEndpointGroupsListEndpointsRequest.getDefaultInstance()) return this;
      if (other.getHealthStatus() != null) {
        this.healthStatus = other.healthStatus;
      }
      return this;
    }

    Builder(NetworkEndpointGroupsListEndpointsRequest source) {
      this.healthStatus = source.healthStatus;
    }

    /**
     * Optional query parameter for showing the health status of each network endpoint. Valid
     * options are SKIP or SHOW. If you don't specifiy this parameter, the health status of network
     * endpoints will not be provided.
     */
    public String getHealthStatus() {
      return healthStatus;
    }

    /**
     * Optional query parameter for showing the health status of each network endpoint. Valid
     * options are SKIP or SHOW. If you don't specifiy this parameter, the health status of network
     * endpoints will not be provided.
     */
    public Builder setHealthStatus(String healthStatus) {
      this.healthStatus = healthStatus;
      return this;
    }

    public NetworkEndpointGroupsListEndpointsRequest build() {
      return new NetworkEndpointGroupsListEndpointsRequest(healthStatus);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHealthStatus(this.healthStatus);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupsListEndpointsRequest{" + "healthStatus=" + healthStatus + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroupsListEndpointsRequest) {
      NetworkEndpointGroupsListEndpointsRequest that =
          (NetworkEndpointGroupsListEndpointsRequest) o;
      return Objects.equals(this.healthStatus, that.getHealthStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthStatus);
  }
}
