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
import java.util.Map;
import java.util.Optional;

/** The specification of a Reasoning Engine deployment. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecDeploymentSpec.Builder.class)
public abstract class ReasoningEngineSpecDeploymentSpec extends JsonSerializable {
  /** The agent server mode. */
  @JsonProperty("agentServerMode")
  public abstract Optional<AgentServerMode> agentServerMode();

  /**
   * Optional. The maximum number of concurrent requests that can be handled by the application.
   * Defaults to 8.
   */
  @JsonProperty("containerConcurrency")
  public abstract Optional<Integer> containerConcurrency();

  /**
   * Optional. Environment variables to be set with the Reasoning Engine deployment. The environment
   * variables can be updated through the UpdateReasoningEngine API.
   */
  @JsonProperty("env")
  public abstract Optional<List<EnvVar>> env();

  /**
   * Optional. The maximum number of application instances that can be launched to handle increased
   * traffic. Defaults to 100. Range: [1, 1000]. If VPC-SC or PSC-I is enabled, the acceptable range
   * is [1, 100].
   */
  @JsonProperty("maxInstances")
  public abstract Optional<Integer> maxInstances();

  /**
   * Optional. The minimum number of application instances that will be kept running at all times.
   * Defaults to 1.
   */
  @JsonProperty("minInstances")
  public abstract Optional<Integer> minInstances();

  /** Optional. Configuration for PSC-I. */
  @JsonProperty("pscInterfaceConfig")
  public abstract Optional<PscInterfaceConfig> pscInterfaceConfig();

  /**
   * Optional. Resource limits for each container. Only 'cpu' and 'memory' keys are supported.
   * Defaults to {"cpu": "4", "memory": "4Gi"}. * The only supported values for CPU are '1', '2',
   * '4', and '8'. For more information, go to https://cloud.google.com/run/docs/configuring/cpu. *
   * For supported 'memory' values and syntax, go to
   * https://cloud.google.com/run/docs/configuring/memory-limits
   */
  @JsonProperty("resourceLimits")
  public abstract Optional<Map<String, String>> resourceLimits();

  /**
   * Optional. Environment variables where the value is a secret in Cloud Secret Manager. To use
   * this feature, add 'Secret Manager Secret Accessor' role (roles/secretmanager.secretAccessor) to
   * AI Platform Reasoning Engine Service Agent.
   */
  @JsonProperty("secretEnv")
  public abstract Optional<List<SecretEnvVar>> secretEnv();

  /** Instantiates a builder for ReasoningEngineSpecDeploymentSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecDeploymentSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecDeploymentSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineSpecDeploymentSpec.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecDeploymentSpec.Builder();
    }

    /**
     * Setter for agentServerMode.
     *
     * <p>agentServerMode: The agent server mode.
     */
    @JsonProperty("agentServerMode")
    public abstract Builder agentServerMode(AgentServerMode agentServerMode);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentServerMode(Optional<AgentServerMode> agentServerMode);

    /** Clears the value of agentServerMode field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentServerMode() {
      return agentServerMode(Optional.empty());
    }

    /**
     * Setter for agentServerMode given a known enum.
     *
     * <p>agentServerMode: The agent server mode.
     */
    @CanIgnoreReturnValue
    public Builder agentServerMode(AgentServerMode.Known knownType) {
      return agentServerMode(new AgentServerMode(knownType));
    }

    /**
     * Setter for agentServerMode given a string.
     *
     * <p>agentServerMode: The agent server mode.
     */
    @CanIgnoreReturnValue
    public Builder agentServerMode(String agentServerMode) {
      return agentServerMode(new AgentServerMode(agentServerMode));
    }

    /**
     * Setter for containerConcurrency.
     *
     * <p>containerConcurrency: Optional. The maximum number of concurrent requests that can be
     * handled by the application. Defaults to 8.
     */
    @JsonProperty("containerConcurrency")
    public abstract Builder containerConcurrency(Integer containerConcurrency);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder containerConcurrency(Optional<Integer> containerConcurrency);

    /** Clears the value of containerConcurrency field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContainerConcurrency() {
      return containerConcurrency(Optional.empty());
    }

    /**
     * Setter for env.
     *
     * <p>env: Optional. Environment variables to be set with the Reasoning Engine deployment. The
     * environment variables can be updated through the UpdateReasoningEngine API.
     */
    @JsonProperty("env")
    public abstract Builder env(List<EnvVar> env);

    /**
     * Setter for env.
     *
     * <p>env: Optional. Environment variables to be set with the Reasoning Engine deployment. The
     * environment variables can be updated through the UpdateReasoningEngine API.
     */
    @CanIgnoreReturnValue
    public Builder env(EnvVar... env) {
      return env(Arrays.asList(env));
    }

    /**
     * Setter for env builder.
     *
     * <p>env: Optional. Environment variables to be set with the Reasoning Engine deployment. The
     * environment variables can be updated through the UpdateReasoningEngine API.
     */
    @CanIgnoreReturnValue
    public Builder env(EnvVar.Builder... envBuilders) {
      return env(
          Arrays.asList(envBuilders).stream()
              .map(EnvVar.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder env(Optional<List<EnvVar>> env);

    /** Clears the value of env field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnv() {
      return env(Optional.empty());
    }

    /**
     * Setter for maxInstances.
     *
     * <p>maxInstances: Optional. The maximum number of application instances that can be launched
     * to handle increased traffic. Defaults to 100. Range: [1, 1000]. If VPC-SC or PSC-I is
     * enabled, the acceptable range is [1, 100].
     */
    @JsonProperty("maxInstances")
    public abstract Builder maxInstances(Integer maxInstances);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder maxInstances(Optional<Integer> maxInstances);

    /** Clears the value of maxInstances field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMaxInstances() {
      return maxInstances(Optional.empty());
    }

    /**
     * Setter for minInstances.
     *
     * <p>minInstances: Optional. The minimum number of application instances that will be kept
     * running at all times. Defaults to 1.
     */
    @JsonProperty("minInstances")
    public abstract Builder minInstances(Integer minInstances);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder minInstances(Optional<Integer> minInstances);

    /** Clears the value of minInstances field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMinInstances() {
      return minInstances(Optional.empty());
    }

    /**
     * Setter for pscInterfaceConfig.
     *
     * <p>pscInterfaceConfig: Optional. Configuration for PSC-I.
     */
    @JsonProperty("pscInterfaceConfig")
    public abstract Builder pscInterfaceConfig(PscInterfaceConfig pscInterfaceConfig);

    /**
     * Setter for pscInterfaceConfig builder.
     *
     * <p>pscInterfaceConfig: Optional. Configuration for PSC-I.
     */
    @CanIgnoreReturnValue
    public Builder pscInterfaceConfig(PscInterfaceConfig.Builder pscInterfaceConfigBuilder) {
      return pscInterfaceConfig(pscInterfaceConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pscInterfaceConfig(Optional<PscInterfaceConfig> pscInterfaceConfig);

    /** Clears the value of pscInterfaceConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPscInterfaceConfig() {
      return pscInterfaceConfig(Optional.empty());
    }

    /**
     * Setter for resourceLimits.
     *
     * <p>resourceLimits: Optional. Resource limits for each container. Only 'cpu' and 'memory' keys
     * are supported. Defaults to {"cpu": "4", "memory": "4Gi"}. * The only supported values for CPU
     * are '1', '2', '4', and '8'. For more information, go to
     * https://cloud.google.com/run/docs/configuring/cpu. * For supported 'memory' values and
     * syntax, go to https://cloud.google.com/run/docs/configuring/memory-limits
     */
    @JsonProperty("resourceLimits")
    public abstract Builder resourceLimits(Map<String, String> resourceLimits);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder resourceLimits(Optional<Map<String, String>> resourceLimits);

    /** Clears the value of resourceLimits field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResourceLimits() {
      return resourceLimits(Optional.empty());
    }

    /**
     * Setter for secretEnv.
     *
     * <p>secretEnv: Optional. Environment variables where the value is a secret in Cloud Secret
     * Manager. To use this feature, add 'Secret Manager Secret Accessor' role
     * (roles/secretmanager.secretAccessor) to AI Platform Reasoning Engine Service Agent.
     */
    @JsonProperty("secretEnv")
    public abstract Builder secretEnv(List<SecretEnvVar> secretEnv);

    /**
     * Setter for secretEnv.
     *
     * <p>secretEnv: Optional. Environment variables where the value is a secret in Cloud Secret
     * Manager. To use this feature, add 'Secret Manager Secret Accessor' role
     * (roles/secretmanager.secretAccessor) to AI Platform Reasoning Engine Service Agent.
     */
    @CanIgnoreReturnValue
    public Builder secretEnv(SecretEnvVar... secretEnv) {
      return secretEnv(Arrays.asList(secretEnv));
    }

    /**
     * Setter for secretEnv builder.
     *
     * <p>secretEnv: Optional. Environment variables where the value is a secret in Cloud Secret
     * Manager. To use this feature, add 'Secret Manager Secret Accessor' role
     * (roles/secretmanager.secretAccessor) to AI Platform Reasoning Engine Service Agent.
     */
    @CanIgnoreReturnValue
    public Builder secretEnv(SecretEnvVar.Builder... secretEnvBuilders) {
      return secretEnv(
          Arrays.asList(secretEnvBuilders).stream()
              .map(SecretEnvVar.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder secretEnv(Optional<List<SecretEnvVar>> secretEnv);

    /** Clears the value of secretEnv field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSecretEnv() {
      return secretEnv(Optional.empty());
    }

    public abstract ReasoningEngineSpecDeploymentSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpecDeploymentSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecDeploymentSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngineSpecDeploymentSpec.class);
  }
}
