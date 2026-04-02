/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadmanager.v1;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.stub.WorkloadManagerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkloadManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workloadmanager.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadManagerSettings.Builder workloadManagerSettingsBuilder =
 *     WorkloadManagerSettings.newBuilder();
 * workloadManagerSettingsBuilder
 *     .getEvaluationSettings()
 *     .setRetrySettings(
 *         workloadManagerSettingsBuilder
 *             .getEvaluationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * WorkloadManagerSettings workloadManagerSettings = workloadManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadManagerSettings.Builder workloadManagerSettingsBuilder =
 *     WorkloadManagerSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * workloadManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkloadManagerSettings extends ClientSettings<WorkloadManagerSettings> {

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).getEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public UnaryCallSettings<CreateEvaluationRequest, Operation> createEvaluationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).createEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public OperationCallSettings<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).createEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public UnaryCallSettings<UpdateEvaluationRequest, Operation> updateEvaluationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).updateEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public OperationCallSettings<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).updateEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public UnaryCallSettings<DeleteEvaluationRequest, Operation> deleteEvaluationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).deleteEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public OperationCallSettings<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).deleteEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExecutions. */
  public PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listExecutionsSettings();
  }

  /** Returns the object with the settings used for calls to getExecution. */
  public UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).getExecutionSettings();
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).runEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public OperationCallSettings<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).runEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).deleteExecutionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public OperationCallSettings<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).deleteExecutionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExecutionResults. */
  public PagedCallSettings<
          ListExecutionResultsRequest,
          ListExecutionResultsResponse,
          ListExecutionResultsPagedResponse>
      listExecutionResultsSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listExecutionResultsSettings();
  }

  /** Returns the object with the settings used for calls to listRules. */
  public UnaryCallSettings<ListRulesRequest, ListRulesResponse> listRulesSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listRulesSettings();
  }

  /** Returns the object with the settings used for calls to listScannedResources. */
  public PagedCallSettings<
          ListScannedResourcesRequest,
          ListScannedResourcesResponse,
          ListScannedResourcesPagedResponse>
      listScannedResourcesSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listScannedResourcesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((WorkloadManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final WorkloadManagerSettings create(WorkloadManagerStubSettings stub)
      throws IOException {
    return new WorkloadManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkloadManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkloadManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkloadManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkloadManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkloadManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return WorkloadManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkloadManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkloadManagerStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected WorkloadManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkloadManagerSettings. */
  public static class Builder extends ClientSettings.Builder<WorkloadManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkloadManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkloadManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkloadManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkloadManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(WorkloadManagerStubSettings.newHttpJsonBuilder());
    }

    public WorkloadManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkloadManagerStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return getStubSettingsBuilder().listEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getStubSettingsBuilder().getEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public UnaryCallSettings.Builder<CreateEvaluationRequest, Operation>
        createEvaluationSettings() {
      return getStubSettingsBuilder().createEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public OperationCallSettings.Builder<CreateEvaluationRequest, Evaluation, OperationMetadata>
        createEvaluationOperationSettings() {
      return getStubSettingsBuilder().createEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public UnaryCallSettings.Builder<UpdateEvaluationRequest, Operation>
        updateEvaluationSettings() {
      return getStubSettingsBuilder().updateEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public OperationCallSettings.Builder<UpdateEvaluationRequest, Evaluation, OperationMetadata>
        updateEvaluationOperationSettings() {
      return getStubSettingsBuilder().updateEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public UnaryCallSettings.Builder<DeleteEvaluationRequest, Operation>
        deleteEvaluationSettings() {
      return getStubSettingsBuilder().deleteEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public OperationCallSettings.Builder<DeleteEvaluationRequest, Empty, OperationMetadata>
        deleteEvaluationOperationSettings() {
      return getStubSettingsBuilder().deleteEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExecutions. */
    public PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings() {
      return getStubSettingsBuilder().listExecutionsSettings();
    }

    /** Returns the builder for the settings used for calls to getExecution. */
    public UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings() {
      return getStubSettingsBuilder().getExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings() {
      return getStubSettingsBuilder().runEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public OperationCallSettings.Builder<RunEvaluationRequest, Execution, OperationMetadata>
        runEvaluationOperationSettings() {
      return getStubSettingsBuilder().runEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public UnaryCallSettings.Builder<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
      return getStubSettingsBuilder().deleteExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public OperationCallSettings.Builder<DeleteExecutionRequest, Empty, OperationMetadata>
        deleteExecutionOperationSettings() {
      return getStubSettingsBuilder().deleteExecutionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExecutionResults. */
    public PagedCallSettings.Builder<
            ListExecutionResultsRequest,
            ListExecutionResultsResponse,
            ListExecutionResultsPagedResponse>
        listExecutionResultsSettings() {
      return getStubSettingsBuilder().listExecutionResultsSettings();
    }

    /** Returns the builder for the settings used for calls to listRules. */
    public UnaryCallSettings.Builder<ListRulesRequest, ListRulesResponse> listRulesSettings() {
      return getStubSettingsBuilder().listRulesSettings();
    }

    /** Returns the builder for the settings used for calls to listScannedResources. */
    public PagedCallSettings.Builder<
            ListScannedResourcesRequest,
            ListScannedResourcesResponse,
            ListScannedResourcesPagedResponse>
        listScannedResourcesSettings() {
      return getStubSettingsBuilder().listScannedResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public WorkloadManagerSettings build() throws IOException {
      return new WorkloadManagerSettings(this);
    }
  }
}
