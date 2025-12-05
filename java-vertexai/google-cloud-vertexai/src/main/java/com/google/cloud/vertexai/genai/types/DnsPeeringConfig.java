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

/**
 * DNS peering configuration. These configurations are used to create DNS peering zones in the
 * Vertex tenant project VPC, enabling resolution of records within the specified domain hosted in
 * the target network's Cloud DNS.
 */
@AutoValue
@JsonDeserialize(builder = DnsPeeringConfig.Builder.class)
public abstract class DnsPeeringConfig extends JsonSerializable {
  /**
   * Required. The DNS name suffix of the zone being peered to, e.g., "my-internal-domain.corp.".
   * Must end with a dot.
   */
  @JsonProperty("domain")
  public abstract Optional<String> domain();

  /**
   * Required. The VPC network name in the target_project where the DNS zone specified by 'domain'
   * is visible.
   */
  @JsonProperty("targetNetwork")
  public abstract Optional<String> targetNetwork();

  /**
   * Required. The project ID hosting the Cloud DNS managed zone that contains the 'domain'. The
   * Vertex AI Service Agent requires the dns.peer role on this project.
   */
  @JsonProperty("targetProject")
  public abstract Optional<String> targetProject();

  /** Instantiates a builder for DnsPeeringConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_DnsPeeringConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for DnsPeeringConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `DnsPeeringConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_DnsPeeringConfig.Builder();
    }

    /**
     * Setter for domain.
     *
     * <p>domain: Required. The DNS name suffix of the zone being peered to, e.g.,
     * "my-internal-domain.corp.". Must end with a dot.
     */
    @JsonProperty("domain")
    public abstract Builder domain(String domain);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder domain(Optional<String> domain);

    /** Clears the value of domain field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDomain() {
      return domain(Optional.empty());
    }

    /**
     * Setter for targetNetwork.
     *
     * <p>targetNetwork: Required. The VPC network name in the target_project where the DNS zone
     * specified by 'domain' is visible.
     */
    @JsonProperty("targetNetwork")
    public abstract Builder targetNetwork(String targetNetwork);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder targetNetwork(Optional<String> targetNetwork);

    /** Clears the value of targetNetwork field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTargetNetwork() {
      return targetNetwork(Optional.empty());
    }

    /**
     * Setter for targetProject.
     *
     * <p>targetProject: Required. The project ID hosting the Cloud DNS managed zone that contains
     * the 'domain'. The Vertex AI Service Agent requires the dns.peer role on this project.
     */
    @JsonProperty("targetProject")
    public abstract Builder targetProject(String targetProject);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder targetProject(Optional<String> targetProject);

    /** Clears the value of targetProject field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTargetProject() {
      return targetProject(Optional.empty());
    }

    public abstract DnsPeeringConfig build();
  }

  /** Deserializes a JSON string to a DnsPeeringConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static DnsPeeringConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, DnsPeeringConfig.class);
  }
}
