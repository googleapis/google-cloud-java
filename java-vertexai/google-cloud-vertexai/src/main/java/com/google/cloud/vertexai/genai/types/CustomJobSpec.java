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
import com.google.genai.types.GcsDestination;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a job that runs custom workloads such as a Docker container or a Python package. */
@AutoValue
@JsonDeserialize(builder = CustomJobSpec.Builder.class)
public abstract class CustomJobSpec extends JsonSerializable {
  /**
   * The Cloud Storage location to store the output of this CustomJob or HyperparameterTuningJob.
   * For HyperparameterTuningJob, the baseOutputDirectory of each child CustomJob backing a Trial is
   * set to a subdirectory of name id under its parent HyperparameterTuningJob's
   * baseOutputDirectory. The following Vertex AI environment variables will be passed to containers
   * or python modules when this field is set: For CustomJob: * AIP_MODEL_DIR = `/model/` *
   * AIP_CHECKPOINT_DIR = `/checkpoints/` * AIP_TENSORBOARD_LOG_DIR = `/logs/` For CustomJob backing
   * a Trial of HyperparameterTuningJob: * AIP_MODEL_DIR = `//model/` * AIP_CHECKPOINT_DIR =
   * `//checkpoints/` * AIP_TENSORBOARD_LOG_DIR = `//logs/`
   */
  @JsonProperty("baseOutputDirectory")
  public abstract Optional<GcsDestination> baseOutputDirectory();

  /**
   * Optional. Whether you want Vertex AI to enable access to the customized dashboard in training
   * chief container. If set to `true`, you can access the dashboard at the URIs given by
   * CustomJob.web_access_uris or Trial.web_access_uris (within HyperparameterTuningJob.trials).
   */
  @JsonProperty("enableDashboardAccess")
  public abstract Optional<Boolean> enableDashboardAccess();

  /**
   * Optional. Whether you want Vertex AI to enable [interactive shell
   * access](https://cloud.google.com/vertex-ai/docs/training/monitor-debug-interactive-shell) to
   * training containers. If set to `true`, you can access interactive shells at the URIs given by
   * CustomJob.web_access_uris or Trial.web_access_uris (within HyperparameterTuningJob.trials).
   */
  @JsonProperty("enableWebAccess")
  public abstract Optional<Boolean> enableWebAccess();

  /**
   * Optional. The Experiment associated with this job. Format:
   * `projects/{project}/locations/{location}/metadataStores/{metadataStores}/contexts/{experiment-name}`
   */
  @JsonProperty("experiment")
  public abstract Optional<String> experiment();

  /**
   * Optional. The Experiment Run associated with this job. Format:
   * `projects/{project}/locations/{location}/metadataStores/{metadataStores}/contexts/{experiment-name}-{experiment-run-name}`
   */
  @JsonProperty("experimentRun")
  public abstract Optional<String> experimentRun();

  /**
   * Optional. The name of the Model resources for which to generate a mapping to artifact URIs.
   * Applicable only to some of the Google-provided custom jobs. Format:
   * `projects/{project}/locations/{location}/models/{model}` In order to retrieve a specific
   * version of the model, also provide the version ID or version alias. Example:
   * `projects/{project}/locations/{location}/models/{model}@2` or
   * `projects/{project}/locations/{location}/models/{model}@golden` If no version ID or alias is
   * specified, the "default" version will be returned. The "default" version alias is created for
   * the first version of the model, and can be moved to other versions later on. There will be
   * exactly one default version.
   */
  @JsonProperty("models")
  public abstract Optional<List<String>> models();

  /**
   * Optional. The full name of the Compute Engine
   * [network](/compute/docs/networks-and-firewalls#networks) to which the Job should be peered. For
   * example, `projects/12345/global/networks/myVPC`.
   * [Format](/compute/docs/reference/rest/v1/networks/insert) is of the form
   * `projects/{project}/global/networks/{network}`. Where {project} is a project number, as in
   * `12345`, and {network} is a network name. To specify this field, you must have already
   * [configured VPC Network Peering for Vertex
   * AI](https://cloud.google.com/vertex-ai/docs/general/vpc-peering). If this field is left
   * unspecified, the job is not peered with any network.
   */
  @JsonProperty("network")
  public abstract Optional<String> network();

  /**
   * Optional. The ID of the PersistentResource in the same Project and Location which to run If
   * this is specified, the job will be run on existing machines held by the PersistentResource
   * instead of on-demand short-live machines. The network and CMEK configs on the job should be
   * consistent with those on the PersistentResource, otherwise, the job will be rejected.
   */
  @JsonProperty("persistentResourceId")
  public abstract Optional<String> persistentResourceId();

  /**
   * The ID of the location to store protected artifacts. e.g. us-central1. Populate only when the
   * location is different than CustomJob location. List of supported locations:
   * https://cloud.google.com/vertex-ai/docs/general/locations
   */
  @JsonProperty("protectedArtifactLocationId")
  public abstract Optional<String> protectedArtifactLocationId();

  /** Optional. Configuration for PSC-I for CustomJob. */
  @JsonProperty("pscInterfaceConfig")
  public abstract Optional<PscInterfaceConfig> pscInterfaceConfig();

  /**
   * Optional. A list of names for the reserved ip ranges under the VPC network that can be used for
   * this job. If set, we will deploy the job within the provided ip ranges. Otherwise, the job will
   * be deployed to any ip ranges under the provided VPC network. Example: ['vertex-ai-ip-range'].
   */
  @JsonProperty("reservedIpRanges")
  public abstract Optional<List<String>> reservedIpRanges();

  /** Scheduling options for a CustomJob. */
  @JsonProperty("scheduling")
  public abstract Optional<Scheduling> scheduling();

  /**
   * Specifies the service account for workload run-as account. Users submitting jobs must have
   * act-as permission on this run-as account. If unspecified, the [Vertex AI Custom Code Service
   * Agent](https://cloud.google.com/vertex-ai/docs/general/access-control#service-agents) for the
   * CustomJob's project is used.
   */
  @JsonProperty("serviceAccount")
  public abstract Optional<String> serviceAccount();

  /**
   * Optional. The name of a Vertex AI Tensorboard resource to which this CustomJob will upload
   * Tensorboard logs. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
   */
  @JsonProperty("tensorboard")
  public abstract Optional<String> tensorboard();

  /**
   * Required. The spec of the worker pools including machine type and Docker image. All worker
   * pools except the first one are optional and can be skipped by providing an empty value.
   */
  @JsonProperty("workerPoolSpecs")
  public abstract Optional<List<WorkerPoolSpec>> workerPoolSpecs();

  /** Instantiates a builder for CustomJobSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CustomJobSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CustomJobSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CustomJobSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CustomJobSpec.Builder();
    }

    /**
     * Setter for baseOutputDirectory.
     *
     * <p>baseOutputDirectory: The Cloud Storage location to store the output of this CustomJob or
     * HyperparameterTuningJob. For HyperparameterTuningJob, the baseOutputDirectory of each child
     * CustomJob backing a Trial is set to a subdirectory of name id under its parent
     * HyperparameterTuningJob's baseOutputDirectory. The following Vertex AI environment variables
     * will be passed to containers or python modules when this field is set: For CustomJob: *
     * AIP_MODEL_DIR = `/model/` * AIP_CHECKPOINT_DIR = `/checkpoints/` * AIP_TENSORBOARD_LOG_DIR =
     * `/logs/` For CustomJob backing a Trial of HyperparameterTuningJob: * AIP_MODEL_DIR =
     * `//model/` * AIP_CHECKPOINT_DIR = `//checkpoints/` * AIP_TENSORBOARD_LOG_DIR = `//logs/`
     */
    @JsonProperty("baseOutputDirectory")
    public abstract Builder baseOutputDirectory(GcsDestination baseOutputDirectory);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder baseOutputDirectory(Optional<GcsDestination> baseOutputDirectory);

    /** Clears the value of baseOutputDirectory field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBaseOutputDirectory() {
      return baseOutputDirectory(Optional.empty());
    }

    /**
     * Setter for enableDashboardAccess.
     *
     * <p>enableDashboardAccess: Optional. Whether you want Vertex AI to enable access to the
     * customized dashboard in training chief container. If set to `true`, you can access the
     * dashboard at the URIs given by CustomJob.web_access_uris or Trial.web_access_uris (within
     * HyperparameterTuningJob.trials).
     */
    @JsonProperty("enableDashboardAccess")
    public abstract Builder enableDashboardAccess(boolean enableDashboardAccess);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder enableDashboardAccess(Optional<Boolean> enableDashboardAccess);

    /** Clears the value of enableDashboardAccess field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnableDashboardAccess() {
      return enableDashboardAccess(Optional.empty());
    }

    /**
     * Setter for enableWebAccess.
     *
     * <p>enableWebAccess: Optional. Whether you want Vertex AI to enable [interactive shell
     * access](https://cloud.google.com/vertex-ai/docs/training/monitor-debug-interactive-shell) to
     * training containers. If set to `true`, you can access interactive shells at the URIs given by
     * CustomJob.web_access_uris or Trial.web_access_uris (within HyperparameterTuningJob.trials).
     */
    @JsonProperty("enableWebAccess")
    public abstract Builder enableWebAccess(boolean enableWebAccess);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder enableWebAccess(Optional<Boolean> enableWebAccess);

    /** Clears the value of enableWebAccess field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnableWebAccess() {
      return enableWebAccess(Optional.empty());
    }

    /**
     * Setter for experiment.
     *
     * <p>experiment: Optional. The Experiment associated with this job. Format:
     * `projects/{project}/locations/{location}/metadataStores/{metadataStores}/contexts/{experiment-name}`
     */
    @JsonProperty("experiment")
    public abstract Builder experiment(String experiment);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder experiment(Optional<String> experiment);

    /** Clears the value of experiment field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExperiment() {
      return experiment(Optional.empty());
    }

    /**
     * Setter for experimentRun.
     *
     * <p>experimentRun: Optional. The Experiment Run associated with this job. Format:
     * `projects/{project}/locations/{location}/metadataStores/{metadataStores}/contexts/{experiment-name}-{experiment-run-name}`
     */
    @JsonProperty("experimentRun")
    public abstract Builder experimentRun(String experimentRun);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder experimentRun(Optional<String> experimentRun);

    /** Clears the value of experimentRun field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExperimentRun() {
      return experimentRun(Optional.empty());
    }

    /**
     * Setter for models.
     *
     * <p>models: Optional. The name of the Model resources for which to generate a mapping to
     * artifact URIs. Applicable only to some of the Google-provided custom jobs. Format:
     * `projects/{project}/locations/{location}/models/{model}` In order to retrieve a specific
     * version of the model, also provide the version ID or version alias. Example:
     * `projects/{project}/locations/{location}/models/{model}@2` or
     * `projects/{project}/locations/{location}/models/{model}@golden` If no version ID or alias is
     * specified, the "default" version will be returned. The "default" version alias is created for
     * the first version of the model, and can be moved to other versions later on. There will be
     * exactly one default version.
     */
    @JsonProperty("models")
    public abstract Builder models(List<String> models);

    /**
     * Setter for models.
     *
     * <p>models: Optional. The name of the Model resources for which to generate a mapping to
     * artifact URIs. Applicable only to some of the Google-provided custom jobs. Format:
     * `projects/{project}/locations/{location}/models/{model}` In order to retrieve a specific
     * version of the model, also provide the version ID or version alias. Example:
     * `projects/{project}/locations/{location}/models/{model}@2` or
     * `projects/{project}/locations/{location}/models/{model}@golden` If no version ID or alias is
     * specified, the "default" version will be returned. The "default" version alias is created for
     * the first version of the model, and can be moved to other versions later on. There will be
     * exactly one default version.
     */
    @CanIgnoreReturnValue
    public Builder models(String... models) {
      return models(Arrays.asList(models));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder models(Optional<List<String>> models);

    /** Clears the value of models field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearModels() {
      return models(Optional.empty());
    }

    /**
     * Setter for network.
     *
     * <p>network: Optional. The full name of the Compute Engine
     * [network](/compute/docs/networks-and-firewalls#networks) to which the Job should be peered.
     * For example, `projects/12345/global/networks/myVPC`.
     * [Format](/compute/docs/reference/rest/v1/networks/insert) is of the form
     * `projects/{project}/global/networks/{network}`. Where {project} is a project number, as in
     * `12345`, and {network} is a network name. To specify this field, you must have already
     * [configured VPC Network Peering for Vertex
     * AI](https://cloud.google.com/vertex-ai/docs/general/vpc-peering). If this field is left
     * unspecified, the job is not peered with any network.
     */
    @JsonProperty("network")
    public abstract Builder network(String network);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder network(Optional<String> network);

    /** Clears the value of network field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNetwork() {
      return network(Optional.empty());
    }

    /**
     * Setter for persistentResourceId.
     *
     * <p>persistentResourceId: Optional. The ID of the PersistentResource in the same Project and
     * Location which to run If this is specified, the job will be run on existing machines held by
     * the PersistentResource instead of on-demand short-live machines. The network and CMEK configs
     * on the job should be consistent with those on the PersistentResource, otherwise, the job will
     * be rejected.
     */
    @JsonProperty("persistentResourceId")
    public abstract Builder persistentResourceId(String persistentResourceId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder persistentResourceId(Optional<String> persistentResourceId);

    /** Clears the value of persistentResourceId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPersistentResourceId() {
      return persistentResourceId(Optional.empty());
    }

    /**
     * Setter for protectedArtifactLocationId.
     *
     * <p>protectedArtifactLocationId: The ID of the location to store protected artifacts. e.g.
     * us-central1. Populate only when the location is different than CustomJob location. List of
     * supported locations: https://cloud.google.com/vertex-ai/docs/general/locations
     */
    @JsonProperty("protectedArtifactLocationId")
    public abstract Builder protectedArtifactLocationId(String protectedArtifactLocationId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder protectedArtifactLocationId(Optional<String> protectedArtifactLocationId);

    /** Clears the value of protectedArtifactLocationId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearProtectedArtifactLocationId() {
      return protectedArtifactLocationId(Optional.empty());
    }

    /**
     * Setter for pscInterfaceConfig.
     *
     * <p>pscInterfaceConfig: Optional. Configuration for PSC-I for CustomJob.
     */
    @JsonProperty("pscInterfaceConfig")
    public abstract Builder pscInterfaceConfig(PscInterfaceConfig pscInterfaceConfig);

    /**
     * Setter for pscInterfaceConfig builder.
     *
     * <p>pscInterfaceConfig: Optional. Configuration for PSC-I for CustomJob.
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
     * Setter for reservedIpRanges.
     *
     * <p>reservedIpRanges: Optional. A list of names for the reserved ip ranges under the VPC
     * network that can be used for this job. If set, we will deploy the job within the provided ip
     * ranges. Otherwise, the job will be deployed to any ip ranges under the provided VPC network.
     * Example: ['vertex-ai-ip-range'].
     */
    @JsonProperty("reservedIpRanges")
    public abstract Builder reservedIpRanges(List<String> reservedIpRanges);

    /**
     * Setter for reservedIpRanges.
     *
     * <p>reservedIpRanges: Optional. A list of names for the reserved ip ranges under the VPC
     * network that can be used for this job. If set, we will deploy the job within the provided ip
     * ranges. Otherwise, the job will be deployed to any ip ranges under the provided VPC network.
     * Example: ['vertex-ai-ip-range'].
     */
    @CanIgnoreReturnValue
    public Builder reservedIpRanges(String... reservedIpRanges) {
      return reservedIpRanges(Arrays.asList(reservedIpRanges));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reservedIpRanges(Optional<List<String>> reservedIpRanges);

    /** Clears the value of reservedIpRanges field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReservedIpRanges() {
      return reservedIpRanges(Optional.empty());
    }

    /**
     * Setter for scheduling.
     *
     * <p>scheduling: Scheduling options for a CustomJob.
     */
    @JsonProperty("scheduling")
    public abstract Builder scheduling(Scheduling scheduling);

    /**
     * Setter for scheduling builder.
     *
     * <p>scheduling: Scheduling options for a CustomJob.
     */
    @CanIgnoreReturnValue
    public Builder scheduling(Scheduling.Builder schedulingBuilder) {
      return scheduling(schedulingBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder scheduling(Optional<Scheduling> scheduling);

    /** Clears the value of scheduling field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScheduling() {
      return scheduling(Optional.empty());
    }

    /**
     * Setter for serviceAccount.
     *
     * <p>serviceAccount: Specifies the service account for workload run-as account. Users
     * submitting jobs must have act-as permission on this run-as account. If unspecified, the
     * [Vertex AI Custom Code Service
     * Agent](https://cloud.google.com/vertex-ai/docs/general/access-control#service-agents) for the
     * CustomJob's project is used.
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
     * Setter for tensorboard.
     *
     * <p>tensorboard: Optional. The name of a Vertex AI Tensorboard resource to which this
     * CustomJob will upload Tensorboard logs. Format:
     * `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
     */
    @JsonProperty("tensorboard")
    public abstract Builder tensorboard(String tensorboard);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tensorboard(Optional<String> tensorboard);

    /** Clears the value of tensorboard field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTensorboard() {
      return tensorboard(Optional.empty());
    }

    /**
     * Setter for workerPoolSpecs.
     *
     * <p>workerPoolSpecs: Required. The spec of the worker pools including machine type and Docker
     * image. All worker pools except the first one are optional and can be skipped by providing an
     * empty value.
     */
    @JsonProperty("workerPoolSpecs")
    public abstract Builder workerPoolSpecs(List<WorkerPoolSpec> workerPoolSpecs);

    /**
     * Setter for workerPoolSpecs.
     *
     * <p>workerPoolSpecs: Required. The spec of the worker pools including machine type and Docker
     * image. All worker pools except the first one are optional and can be skipped by providing an
     * empty value.
     */
    @CanIgnoreReturnValue
    public Builder workerPoolSpecs(WorkerPoolSpec... workerPoolSpecs) {
      return workerPoolSpecs(Arrays.asList(workerPoolSpecs));
    }

    /**
     * Setter for workerPoolSpecs builder.
     *
     * <p>workerPoolSpecs: Required. The spec of the worker pools including machine type and Docker
     * image. All worker pools except the first one are optional and can be skipped by providing an
     * empty value.
     */
    @CanIgnoreReturnValue
    public Builder workerPoolSpecs(WorkerPoolSpec.Builder... workerPoolSpecsBuilders) {
      return workerPoolSpecs(
          Arrays.asList(workerPoolSpecsBuilders).stream()
              .map(WorkerPoolSpec.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder workerPoolSpecs(Optional<List<WorkerPoolSpec>> workerPoolSpecs);

    /** Clears the value of workerPoolSpecs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWorkerPoolSpecs() {
      return workerPoolSpecs(Optional.empty());
    }

    public abstract CustomJobSpec build();
  }

  /** Deserializes a JSON string to a CustomJobSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static CustomJobSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CustomJobSpec.class);
  }
}
