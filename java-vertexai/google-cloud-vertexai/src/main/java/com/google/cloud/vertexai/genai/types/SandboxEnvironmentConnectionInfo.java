/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** The connection information of the SandboxEnvironment. */
@AutoValue
@JsonDeserialize(builder = SandboxEnvironmentConnectionInfo.Builder.class)
public abstract class SandboxEnvironmentConnectionInfo extends JsonSerializable {
  /** Output only. The hostname of the load balancer. */
  @JsonProperty("loadBalancerHostname")
  public abstract Optional<String> loadBalancerHostname();

  /** Output only. The IP address of the load balancer. */
  @JsonProperty("loadBalancerIp")
  public abstract Optional<String> loadBalancerIp();

  /** Output only. The internal IP address of the SandboxEnvironment. */
  @JsonProperty("sandboxInternalIp")
  public abstract Optional<String> sandboxInternalIp();

  /** Instantiates a builder for SandboxEnvironmentConnectionInfo. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SandboxEnvironmentConnectionInfo.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SandboxEnvironmentConnectionInfo. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SandboxEnvironmentConnectionInfo.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SandboxEnvironmentConnectionInfo.Builder();
    }

    /**
     * Setter for loadBalancerHostname.
     *
     * <p>loadBalancerHostname: Output only. The hostname of the load balancer.
     */
    @JsonProperty("loadBalancerHostname")
    public abstract Builder loadBalancerHostname(String loadBalancerHostname);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder loadBalancerHostname(Optional<String> loadBalancerHostname);

    /** Clears the value of loadBalancerHostname field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLoadBalancerHostname() {
      return loadBalancerHostname(Optional.empty());
    }

    /**
     * Setter for loadBalancerIp.
     *
     * <p>loadBalancerIp: Output only. The IP address of the load balancer.
     */
    @JsonProperty("loadBalancerIp")
    public abstract Builder loadBalancerIp(String loadBalancerIp);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder loadBalancerIp(Optional<String> loadBalancerIp);

    /** Clears the value of loadBalancerIp field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLoadBalancerIp() {
      return loadBalancerIp(Optional.empty());
    }

    /**
     * Setter for sandboxInternalIp.
     *
     * <p>sandboxInternalIp: Output only. The internal IP address of the SandboxEnvironment.
     */
    @JsonProperty("sandboxInternalIp")
    public abstract Builder sandboxInternalIp(String sandboxInternalIp);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sandboxInternalIp(Optional<String> sandboxInternalIp);

    /** Clears the value of sandboxInternalIp field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSandboxInternalIp() {
      return sandboxInternalIp(Optional.empty());
    }

    public abstract SandboxEnvironmentConnectionInfo build();
  }

  /** Deserializes a JSON string to a SandboxEnvironmentConnectionInfo object. */
  @ExcludeFromGeneratedCoverageReport
  public static SandboxEnvironmentConnectionInfo fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SandboxEnvironmentConnectionInfo.class);
  }
}
