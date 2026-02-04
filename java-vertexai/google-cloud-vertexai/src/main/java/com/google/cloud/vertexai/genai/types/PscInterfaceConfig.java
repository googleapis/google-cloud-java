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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** The PSC interface config. */
@AutoValue
@JsonDeserialize(builder = PscInterfaceConfig.Builder.class)
public abstract class PscInterfaceConfig extends JsonSerializable {
  /**
   * Optional. DNS peering configurations. When specified, Vertex AI will attempt to configure DNS
   * peering zones in the tenant project VPC to resolve the specified domains using the target
   * network's Cloud DNS. The user must grant the dns.peer role to the Vertex AI Service Agent on
   * the target project.
   */
  @JsonProperty("dnsPeeringConfigs")
  public abstract Optional<List<DnsPeeringConfig>> dnsPeeringConfigs();

  /**
   * Optional. The name of the Compute Engine [network
   * attachment](https://cloud.google.com/vpc/docs/about-network-attachments) to attach to the
   * resource within the region and user project. To specify this field, you must have already
   * [created a network attachment]
   * (https://cloud.google.com/vpc/docs/create-manage-network-attachments#create-network-attachments).
   * This field is only used for resources using PSC-I.
   */
  @JsonProperty("networkAttachment")
  public abstract Optional<String> networkAttachment();

  /** Instantiates a builder for PscInterfaceConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PscInterfaceConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PscInterfaceConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PscInterfaceConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PscInterfaceConfig.Builder();
    }

    /**
     * Setter for dnsPeeringConfigs.
     *
     * <p>dnsPeeringConfigs: Optional. DNS peering configurations. When specified, Vertex AI will
     * attempt to configure DNS peering zones in the tenant project VPC to resolve the specified
     * domains using the target network's Cloud DNS. The user must grant the dns.peer role to the
     * Vertex AI Service Agent on the target project.
     */
    @JsonProperty("dnsPeeringConfigs")
    public abstract Builder dnsPeeringConfigs(List<DnsPeeringConfig> dnsPeeringConfigs);

    /**
     * Setter for dnsPeeringConfigs.
     *
     * <p>dnsPeeringConfigs: Optional. DNS peering configurations. When specified, Vertex AI will
     * attempt to configure DNS peering zones in the tenant project VPC to resolve the specified
     * domains using the target network's Cloud DNS. The user must grant the dns.peer role to the
     * Vertex AI Service Agent on the target project.
     */
    @CanIgnoreReturnValue
    public Builder dnsPeeringConfigs(DnsPeeringConfig... dnsPeeringConfigs) {
      return dnsPeeringConfigs(Arrays.asList(dnsPeeringConfigs));
    }

    /**
     * Setter for dnsPeeringConfigs builder.
     *
     * <p>dnsPeeringConfigs: Optional. DNS peering configurations. When specified, Vertex AI will
     * attempt to configure DNS peering zones in the tenant project VPC to resolve the specified
     * domains using the target network's Cloud DNS. The user must grant the dns.peer role to the
     * Vertex AI Service Agent on the target project.
     */
    @CanIgnoreReturnValue
    public Builder dnsPeeringConfigs(DnsPeeringConfig.Builder... dnsPeeringConfigsBuilders) {
      return dnsPeeringConfigs(
          Arrays.asList(dnsPeeringConfigsBuilders).stream()
              .map(DnsPeeringConfig.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dnsPeeringConfigs(Optional<List<DnsPeeringConfig>> dnsPeeringConfigs);

    /** Clears the value of dnsPeeringConfigs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDnsPeeringConfigs() {
      return dnsPeeringConfigs(Optional.empty());
    }

    /**
     * Setter for networkAttachment.
     *
     * <p>networkAttachment: Optional. The name of the Compute Engine [network
     * attachment](https://cloud.google.com/vpc/docs/about-network-attachments) to attach to the
     * resource within the region and user project. To specify this field, you must have already
     * [created a network attachment]
     * (https://cloud.google.com/vpc/docs/create-manage-network-attachments#create-network-attachments).
     * This field is only used for resources using PSC-I.
     */
    @JsonProperty("networkAttachment")
    public abstract Builder networkAttachment(String networkAttachment);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder networkAttachment(Optional<String> networkAttachment);

    /** Clears the value of networkAttachment field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNetworkAttachment() {
      return networkAttachment(Optional.empty());
    }

    public abstract PscInterfaceConfig build();
  }

  /** Deserializes a JSON string to a PscInterfaceConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static PscInterfaceConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PscInterfaceConfig.class);
  }
}
