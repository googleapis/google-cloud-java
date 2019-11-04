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
/**
 * Describes the high availability requirement state for the VPN connection between this Cloud VPN
 * gateway and a peer gateway.
 */
public final class VpnGatewayStatusHighAvailabilityRequirementState implements ApiMessage {
  private final String state;
  private final String unsatisfiedReason;

  private VpnGatewayStatusHighAvailabilityRequirementState() {
    this.state = null;
    this.unsatisfiedReason = null;
  }

  private VpnGatewayStatusHighAvailabilityRequirementState(String state, String unsatisfiedReason) {
    this.state = state;
    this.unsatisfiedReason = unsatisfiedReason;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("state".equals(fieldName)) {
      return state;
    }
    if ("unsatisfiedReason".equals(fieldName)) {
      return unsatisfiedReason;
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
   * Indicates the high availability requirement state for the VPN connection. Valid values are
   * CONNECTION_REDUNDANCY_MET, CONNECTION_REDUNDANCY_NOT_MET.
   */
  public String getState() {
    return state;
  }

  /**
   * Indicates the reason why the VPN connection does not meet the high availability redundancy
   * criteria/requirement. Valid values is INCOMPLETE_TUNNELS_COVERAGE.
   */
  public String getUnsatisfiedReason() {
    return unsatisfiedReason;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnGatewayStatusHighAvailabilityRequirementState prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnGatewayStatusHighAvailabilityRequirementState getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnGatewayStatusHighAvailabilityRequirementState DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnGatewayStatusHighAvailabilityRequirementState();
  }

  public static class Builder {
    private String state;
    private String unsatisfiedReason;

    Builder() {}

    public Builder mergeFrom(VpnGatewayStatusHighAvailabilityRequirementState other) {
      if (other == VpnGatewayStatusHighAvailabilityRequirementState.getDefaultInstance())
        return this;
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getUnsatisfiedReason() != null) {
        this.unsatisfiedReason = other.unsatisfiedReason;
      }
      return this;
    }

    Builder(VpnGatewayStatusHighAvailabilityRequirementState source) {
      this.state = source.state;
      this.unsatisfiedReason = source.unsatisfiedReason;
    }

    /**
     * Indicates the high availability requirement state for the VPN connection. Valid values are
     * CONNECTION_REDUNDANCY_MET, CONNECTION_REDUNDANCY_NOT_MET.
     */
    public String getState() {
      return state;
    }

    /**
     * Indicates the high availability requirement state for the VPN connection. Valid values are
     * CONNECTION_REDUNDANCY_MET, CONNECTION_REDUNDANCY_NOT_MET.
     */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    /**
     * Indicates the reason why the VPN connection does not meet the high availability redundancy
     * criteria/requirement. Valid values is INCOMPLETE_TUNNELS_COVERAGE.
     */
    public String getUnsatisfiedReason() {
      return unsatisfiedReason;
    }

    /**
     * Indicates the reason why the VPN connection does not meet the high availability redundancy
     * criteria/requirement. Valid values is INCOMPLETE_TUNNELS_COVERAGE.
     */
    public Builder setUnsatisfiedReason(String unsatisfiedReason) {
      this.unsatisfiedReason = unsatisfiedReason;
      return this;
    }

    public VpnGatewayStatusHighAvailabilityRequirementState build() {

      return new VpnGatewayStatusHighAvailabilityRequirementState(state, unsatisfiedReason);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setState(this.state);
      newBuilder.setUnsatisfiedReason(this.unsatisfiedReason);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnGatewayStatusHighAvailabilityRequirementState{"
        + "state="
        + state
        + ", "
        + "unsatisfiedReason="
        + unsatisfiedReason
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnGatewayStatusHighAvailabilityRequirementState) {
      VpnGatewayStatusHighAvailabilityRequirementState that =
          (VpnGatewayStatusHighAvailabilityRequirementState) o;
      return Objects.equals(this.state, that.getState())
          && Objects.equals(this.unsatisfiedReason, that.getUnsatisfiedReason());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, unsatisfiedReason);
  }
}
