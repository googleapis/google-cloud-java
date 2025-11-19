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
import com.google.genai.types.EncryptionSpec;
import com.google.genai.types.HttpOptions;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Config for agent engine methods. */
@AutoValue
@JsonDeserialize(builder = AgentEngineConfig.Builder.class)
public abstract class AgentEngineConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The GCS bucket to use for staging the artifacts needed.
   *
   * <p>It must be a valid GCS bucket name, e.g. "gs://bucket-name". It is required if
   * `agent_engine` is specified.
   */
  @JsonProperty("stagingBucket")
  public abstract Optional<String> stagingBucket();

  /**
   * The set of PyPI dependencies needed.
   *
   * <p>It can either be the path to a single file (requirements.txt), or an ordered list of strings
   * corresponding to each line of the requirements file.
   */
  @JsonProperty("requirements")
  public abstract Optional<Object> requirements();

  /**
   * The user-defined name of the Agent Engine.
   *
   * <p>The name can be up to 128 characters long and can comprise any UTF-8 character.
   */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The description of the Agent Engine. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** The GCS bucket directory under `staging_bucket` to use for staging the artifacts needed. */
  @JsonProperty("gcsDirName")
  public abstract Optional<String> gcsDirName();

  /** The set of extra user-provided packages (if any). */
  @JsonProperty("extraPackages")
  public abstract Optional<List<String>> extraPackages();

  /**
   * The environment variables to be set when running the Agent Engine.
   *
   * <p>If it is a dictionary, the keys are the environment variable names, and the values are the
   * corresponding values.
   */
  @JsonProperty("envVars")
  public abstract Optional<Object> envVars();

  /**
   * The service account to be used for the Agent Engine.
   *
   * <p>If not specified, the default Reasoning Engine P6SA service agent will be used.
   */
  @JsonProperty("serviceAccount")
  public abstract Optional<String> serviceAccount();

  /** The identity type to use for the Agent Engine. */
  @JsonProperty("identityType")
  public abstract Optional<IdentityType> identityType();

  /** The context spec to be used for the Agent Engine. */
  @JsonProperty("contextSpec")
  public abstract Optional<ReasoningEngineContextSpec> contextSpec();

  /** The PSC interface config for PSC-I to be used for the Agent Engine. */
  @JsonProperty("pscInterfaceConfig")
  public abstract Optional<PscInterfaceConfig> pscInterfaceConfig();

  /** The minimum number of instances to run for the Agent Engine. Defaults to 1. Range: [0, 10]. */
  @JsonProperty("minInstances")
  public abstract Optional<Integer> minInstances();

  /**
   * The maximum number of instances to run for the Agent Engine. Defaults to 100. Range: [1, 1000].
   * If VPC-SC or PSC-I is enabled, the acceptable range is [1, 100].
   */
  @JsonProperty("maxInstances")
  public abstract Optional<Integer> maxInstances();

  /**
   * The resource limits to be applied to the Agent Engine. Required keys: 'cpu' and 'memory'.
   * Supported values for 'cpu': '1', '2', '4', '6', '8'. Supported values for 'memory': '1Gi',
   * '2Gi', ..., '32Gi'.
   */
  @JsonProperty("resourceLimits")
  public abstract Optional<Map<String, String>> resourceLimits();

  /**
   * The container concurrency to be used for the Agent Engine. Recommended value: 2 * cpu + 1.
   * Defaults to 9.
   */
  @JsonProperty("containerConcurrency")
  public abstract Optional<Integer> containerConcurrency();

  /** The encryption spec to be used for the Agent Engine. */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** The labels to be used for the Agent Engine. */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** The agent server mode to use for deployment. */
  @JsonProperty("agentServerMode")
  public abstract Optional<AgentServerMode> agentServerMode();

  /**
   * The class methods to be used for the Agent Engine. If specified, they'll override the class
   * methods that are autogenerated by default. By default, methods are generated by inspecting the
   * agent object and generating a corresponding method for each method defined on the agent class.
   */
  @JsonProperty("classMethods")
  public abstract Optional<List<Map<String, Object>>> classMethods();

  /**
   * The user-provided paths to the source packages (if any). If specified, the files in the source
   * packages will be packed into a a tarball file, uploaded to Agent Engine's API, and deployed to
   * the Agent Engine. The following fields will be ignored: - agent - extra_packages -
   * staging_bucket - requirements The following fields will be used to install and use the agent
   * from the source packages: - entrypoint_module (required) - entrypoint_object (required) -
   * requirements_file (optional) - class_methods (required)
   */
  @JsonProperty("sourcePackages")
  public abstract Optional<List<String>> sourcePackages();

  /**
   * The entrypoint module to be used for the Agent Engine This field only used when source_packages
   * is specified.
   */
  @JsonProperty("entrypointModule")
  public abstract Optional<String> entrypointModule();

  /**
   * The entrypoint object to be used for the Agent Engine. This field only used when
   * source_packages is specified.
   */
  @JsonProperty("entrypointObject")
  public abstract Optional<String> entrypointObject();

  /**
   * The user-provided path to the requirements file (if any). This field is only used when
   * source_packages is specified. If not specified, agent engine will find and use the
   * `requirements.txt` in the source package.
   */
  @JsonProperty("requirementsFile")
  public abstract Optional<String> requirementsFile();

  /**
   * The agent framework to be used for the Agent Engine. The OSS agent framework used to develop
   * the agent. Currently supported values: "google-adk", "langchain", "langgraph", "ag2",
   * "llama-index", "custom". If not specified: - If `agent` is specified, the agent framework will
   * be auto-detected. - If `source_packages` is specified, the agent framework will default to
   * "custom".
   */
  @JsonProperty("agentFramework")
  public abstract Optional<AgentFramework> agentFramework();

  /**
   * The Python version to be used for the Agent Engine. If not specified, it will use the current
   * Python version of the environment. Supported versions: "3.9", "3.10", "3.11", "3.12", "3.13".
   */
  @JsonProperty("pythonVersion")
  public abstract Optional<PythonVersion> pythonVersion();

  /**
   * The build options for the Agent Engine. The following keys are supported: -
   * installation_scripts: Optional. The paths to the installation scripts to be executed in the
   * Docker image. The scripts must be located in the `installation_scripts` subdirectory and the
   * path must be added to `extra_packages`.
   */
  @JsonProperty("buildOptions")
  public abstract Optional<Map<String, List<String>>> buildOptions();

  /** Instantiates a builder for AgentEngineConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentEngineConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentEngineConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AgentEngineConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentEngineConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for stagingBucket.
     *
     * <p>stagingBucket: The GCS bucket to use for staging the artifacts needed.
     *
     * <p>It must be a valid GCS bucket name, e.g. "gs://bucket-name". It is required if
     * `agent_engine` is specified.
     */
    @JsonProperty("stagingBucket")
    public abstract Builder stagingBucket(String stagingBucket);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder stagingBucket(Optional<String> stagingBucket);

    /** Clears the value of stagingBucket field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStagingBucket() {
      return stagingBucket(Optional.empty());
    }

    /**
     * Setter for requirements.
     *
     * <p>requirements: The set of PyPI dependencies needed.
     *
     * <p>It can either be the path to a single file (requirements.txt), or an ordered list of
     * strings corresponding to each line of the requirements file.
     */
    @JsonProperty("requirements")
    public abstract Builder requirements(Object requirements);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder requirements(Optional<Object> requirements);

    /** Clears the value of requirements field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRequirements() {
      return requirements(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: The user-defined name of the Agent Engine.
     *
     * <p>The name can be up to 128 characters long and can comprise any UTF-8 character.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: The description of the Agent Engine.
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    /**
     * Setter for gcsDirName.
     *
     * <p>gcsDirName: The GCS bucket directory under `staging_bucket` to use for staging the
     * artifacts needed.
     */
    @JsonProperty("gcsDirName")
    public abstract Builder gcsDirName(String gcsDirName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsDirName(Optional<String> gcsDirName);

    /** Clears the value of gcsDirName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsDirName() {
      return gcsDirName(Optional.empty());
    }

    /**
     * Setter for extraPackages.
     *
     * <p>extraPackages: The set of extra user-provided packages (if any).
     */
    @JsonProperty("extraPackages")
    public abstract Builder extraPackages(List<String> extraPackages);

    /**
     * Setter for extraPackages.
     *
     * <p>extraPackages: The set of extra user-provided packages (if any).
     */
    @CanIgnoreReturnValue
    public Builder extraPackages(String... extraPackages) {
      return extraPackages(Arrays.asList(extraPackages));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder extraPackages(Optional<List<String>> extraPackages);

    /** Clears the value of extraPackages field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExtraPackages() {
      return extraPackages(Optional.empty());
    }

    /**
     * Setter for envVars.
     *
     * <p>envVars: The environment variables to be set when running the Agent Engine.
     *
     * <p>If it is a dictionary, the keys are the environment variable names, and the values are the
     * corresponding values.
     */
    @JsonProperty("envVars")
    public abstract Builder envVars(Object envVars);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder envVars(Optional<Object> envVars);

    /** Clears the value of envVars field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnvVars() {
      return envVars(Optional.empty());
    }

    /**
     * Setter for serviceAccount.
     *
     * <p>serviceAccount: The service account to be used for the Agent Engine.
     *
     * <p>If not specified, the default Reasoning Engine P6SA service agent will be used.
     */
    @JsonProperty("serviceAccount")
    public abstract Builder serviceAccount(String serviceAccount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder serviceAccount(Optional<String> serviceAccount);

    /** Clears the value of serviceAccount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearServiceAccount() {
      return serviceAccount(Optional.empty());
    }

    /**
     * Setter for identityType.
     *
     * <p>identityType: The identity type to use for the Agent Engine.
     */
    @JsonProperty("identityType")
    public abstract Builder identityType(IdentityType identityType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder identityType(Optional<IdentityType> identityType);

    /** Clears the value of identityType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearIdentityType() {
      return identityType(Optional.empty());
    }

    /**
     * Setter for identityType given a known enum.
     *
     * <p>identityType: The identity type to use for the Agent Engine.
     */
    @CanIgnoreReturnValue
    public Builder identityType(IdentityType.Known knownType) {
      return identityType(new IdentityType(knownType));
    }

    /**
     * Setter for identityType given a string.
     *
     * <p>identityType: The identity type to use for the Agent Engine.
     */
    @CanIgnoreReturnValue
    public Builder identityType(String identityType) {
      return identityType(new IdentityType(identityType));
    }

    /**
     * Setter for contextSpec.
     *
     * <p>contextSpec: The context spec to be used for the Agent Engine.
     */
    @JsonProperty("contextSpec")
    public abstract Builder contextSpec(ReasoningEngineContextSpec contextSpec);

    /**
     * Setter for contextSpec builder.
     *
     * <p>contextSpec: The context spec to be used for the Agent Engine.
     */
    @CanIgnoreReturnValue
    public Builder contextSpec(ReasoningEngineContextSpec.Builder contextSpecBuilder) {
      return contextSpec(contextSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contextSpec(Optional<ReasoningEngineContextSpec> contextSpec);

    /** Clears the value of contextSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContextSpec() {
      return contextSpec(Optional.empty());
    }

    /**
     * Setter for pscInterfaceConfig.
     *
     * <p>pscInterfaceConfig: The PSC interface config for PSC-I to be used for the Agent Engine.
     */
    @JsonProperty("pscInterfaceConfig")
    public abstract Builder pscInterfaceConfig(PscInterfaceConfig pscInterfaceConfig);

    /**
     * Setter for pscInterfaceConfig builder.
     *
     * <p>pscInterfaceConfig: The PSC interface config for PSC-I to be used for the Agent Engine.
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
     * Setter for minInstances.
     *
     * <p>minInstances: The minimum number of instances to run for the Agent Engine. Defaults to 1.
     * Range: [0, 10].
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
     * Setter for maxInstances.
     *
     * <p>maxInstances: The maximum number of instances to run for the Agent Engine. Defaults to
     * 100. Range: [1, 1000]. If VPC-SC or PSC-I is enabled, the acceptable range is [1, 100].
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
     * Setter for resourceLimits.
     *
     * <p>resourceLimits: The resource limits to be applied to the Agent Engine. Required keys:
     * 'cpu' and 'memory'. Supported values for 'cpu': '1', '2', '4', '6', '8'. Supported values for
     * 'memory': '1Gi', '2Gi', ..., '32Gi'.
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
     * Setter for containerConcurrency.
     *
     * <p>containerConcurrency: The container concurrency to be used for the Agent Engine.
     * Recommended value: 2 * cpu + 1. Defaults to 9.
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
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec: The encryption spec to be used for the Agent Engine.
     */
    @JsonProperty("encryptionSpec")
    public abstract Builder encryptionSpec(EncryptionSpec encryptionSpec);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder encryptionSpec(Optional<EncryptionSpec> encryptionSpec);

    /** Clears the value of encryptionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEncryptionSpec() {
      return encryptionSpec(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: The labels to be used for the Agent Engine.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for agentServerMode.
     *
     * <p>agentServerMode: The agent server mode to use for deployment.
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
     * <p>agentServerMode: The agent server mode to use for deployment.
     */
    @CanIgnoreReturnValue
    public Builder agentServerMode(AgentServerMode.Known knownType) {
      return agentServerMode(new AgentServerMode(knownType));
    }

    /**
     * Setter for agentServerMode given a string.
     *
     * <p>agentServerMode: The agent server mode to use for deployment.
     */
    @CanIgnoreReturnValue
    public Builder agentServerMode(String agentServerMode) {
      return agentServerMode(new AgentServerMode(agentServerMode));
    }

    /**
     * Setter for classMethods.
     *
     * <p>classMethods: The class methods to be used for the Agent Engine. If specified, they'll
     * override the class methods that are autogenerated by default. By default, methods are
     * generated by inspecting the agent object and generating a corresponding method for each
     * method defined on the agent class.
     */
    @JsonProperty("classMethods")
    public abstract Builder classMethods(List<Map<String, Object>> classMethods);

    /**
     * Setter for classMethods.
     *
     * <p>classMethods: The class methods to be used for the Agent Engine. If specified, they'll
     * override the class methods that are autogenerated by default. By default, methods are
     * generated by inspecting the agent object and generating a corresponding method for each
     * method defined on the agent class.
     */
    @CanIgnoreReturnValue
    public Builder classMethods(Map<String, Object>... classMethods) {
      return classMethods(Arrays.asList(classMethods));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder classMethods(Optional<List<Map<String, Object>>> classMethods);

    /** Clears the value of classMethods field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearClassMethods() {
      return classMethods(Optional.empty());
    }

    /**
     * Setter for sourcePackages.
     *
     * <p>sourcePackages: The user-provided paths to the source packages (if any). If specified, the
     * files in the source packages will be packed into a a tarball file, uploaded to Agent Engine's
     * API, and deployed to the Agent Engine. The following fields will be ignored: - agent -
     * extra_packages - staging_bucket - requirements The following fields will be used to install
     * and use the agent from the source packages: - entrypoint_module (required) -
     * entrypoint_object (required) - requirements_file (optional) - class_methods (required)
     */
    @JsonProperty("sourcePackages")
    public abstract Builder sourcePackages(List<String> sourcePackages);

    /**
     * Setter for sourcePackages.
     *
     * <p>sourcePackages: The user-provided paths to the source packages (if any). If specified, the
     * files in the source packages will be packed into a a tarball file, uploaded to Agent Engine's
     * API, and deployed to the Agent Engine. The following fields will be ignored: - agent -
     * extra_packages - staging_bucket - requirements The following fields will be used to install
     * and use the agent from the source packages: - entrypoint_module (required) -
     * entrypoint_object (required) - requirements_file (optional) - class_methods (required)
     */
    @CanIgnoreReturnValue
    public Builder sourcePackages(String... sourcePackages) {
      return sourcePackages(Arrays.asList(sourcePackages));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sourcePackages(Optional<List<String>> sourcePackages);

    /** Clears the value of sourcePackages field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSourcePackages() {
      return sourcePackages(Optional.empty());
    }

    /**
     * Setter for entrypointModule.
     *
     * <p>entrypointModule: The entrypoint module to be used for the Agent Engine This field only
     * used when source_packages is specified.
     */
    @JsonProperty("entrypointModule")
    public abstract Builder entrypointModule(String entrypointModule);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder entrypointModule(Optional<String> entrypointModule);

    /** Clears the value of entrypointModule field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEntrypointModule() {
      return entrypointModule(Optional.empty());
    }

    /**
     * Setter for entrypointObject.
     *
     * <p>entrypointObject: The entrypoint object to be used for the Agent Engine. This field only
     * used when source_packages is specified.
     */
    @JsonProperty("entrypointObject")
    public abstract Builder entrypointObject(String entrypointObject);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder entrypointObject(Optional<String> entrypointObject);

    /** Clears the value of entrypointObject field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEntrypointObject() {
      return entrypointObject(Optional.empty());
    }

    /**
     * Setter for requirementsFile.
     *
     * <p>requirementsFile: The user-provided path to the requirements file (if any). This field is
     * only used when source_packages is specified. If not specified, agent engine will find and use
     * the `requirements.txt` in the source package.
     */
    @JsonProperty("requirementsFile")
    public abstract Builder requirementsFile(String requirementsFile);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder requirementsFile(Optional<String> requirementsFile);

    /** Clears the value of requirementsFile field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRequirementsFile() {
      return requirementsFile(Optional.empty());
    }

    /**
     * Setter for agentFramework.
     *
     * <p>agentFramework: The agent framework to be used for the Agent Engine. The OSS agent
     * framework used to develop the agent. Currently supported values: "google-adk", "langchain",
     * "langgraph", "ag2", "llama-index", "custom". If not specified: - If `agent` is specified, the
     * agent framework will be auto-detected. - If `source_packages` is specified, the agent
     * framework will default to "custom".
     */
    @JsonProperty("agentFramework")
    public abstract Builder agentFramework(AgentFramework agentFramework);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentFramework(Optional<AgentFramework> agentFramework);

    /** Clears the value of agentFramework field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentFramework() {
      return agentFramework(Optional.empty());
    }

    /**
     * Setter for agentFramework given a known enum.
     *
     * <p>agentFramework: The agent framework to be used for the Agent Engine. The OSS agent
     * framework used to develop the agent. Currently supported values: "google-adk", "langchain",
     * "langgraph", "ag2", "llama-index", "custom". If not specified: - If `agent` is specified, the
     * agent framework will be auto-detected. - If `source_packages` is specified, the agent
     * framework will default to "custom".
     */
    @CanIgnoreReturnValue
    public Builder agentFramework(AgentFramework.Known knownType) {
      return agentFramework(new AgentFramework(knownType));
    }

    /**
     * Setter for agentFramework given a string.
     *
     * <p>agentFramework: The agent framework to be used for the Agent Engine. The OSS agent
     * framework used to develop the agent. Currently supported values: "google-adk", "langchain",
     * "langgraph", "ag2", "llama-index", "custom". If not specified: - If `agent` is specified, the
     * agent framework will be auto-detected. - If `source_packages` is specified, the agent
     * framework will default to "custom".
     */
    @CanIgnoreReturnValue
    public Builder agentFramework(String agentFramework) {
      return agentFramework(new AgentFramework(agentFramework));
    }

    /**
     * Setter for pythonVersion.
     *
     * <p>pythonVersion: The Python version to be used for the Agent Engine. If not specified, it
     * will use the current Python version of the environment. Supported versions: "3.9", "3.10",
     * "3.11", "3.12", "3.13".
     */
    @JsonProperty("pythonVersion")
    public abstract Builder pythonVersion(PythonVersion pythonVersion);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pythonVersion(Optional<PythonVersion> pythonVersion);

    /** Clears the value of pythonVersion field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPythonVersion() {
      return pythonVersion(Optional.empty());
    }

    /**
     * Setter for pythonVersion given a known enum.
     *
     * <p>pythonVersion: The Python version to be used for the Agent Engine. If not specified, it
     * will use the current Python version of the environment. Supported versions: "3.9", "3.10",
     * "3.11", "3.12", "3.13".
     */
    @CanIgnoreReturnValue
    public Builder pythonVersion(PythonVersion.Known knownType) {
      return pythonVersion(new PythonVersion(knownType));
    }

    /**
     * Setter for pythonVersion given a string.
     *
     * <p>pythonVersion: The Python version to be used for the Agent Engine. If not specified, it
     * will use the current Python version of the environment. Supported versions: "3.9", "3.10",
     * "3.11", "3.12", "3.13".
     */
    @CanIgnoreReturnValue
    public Builder pythonVersion(String pythonVersion) {
      return pythonVersion(new PythonVersion(pythonVersion));
    }

    /**
     * Setter for buildOptions.
     *
     * <p>buildOptions: The build options for the Agent Engine. The following keys are supported: -
     * installation_scripts: Optional. The paths to the installation scripts to be executed in the
     * Docker image. The scripts must be located in the `installation_scripts` subdirectory and the
     * path must be added to `extra_packages`.
     */
    @JsonProperty("buildOptions")
    public abstract Builder buildOptions(Map<String, List<String>> buildOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder buildOptions(Optional<Map<String, List<String>>> buildOptions);

    /** Clears the value of buildOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBuildOptions() {
      return buildOptions(Optional.empty());
    }

    public abstract AgentEngineConfig build();
  }

  /** Deserializes a JSON string to a AgentEngineConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentEngineConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentEngineConfig.class);
  }
}
