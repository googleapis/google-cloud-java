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

package com.google.cloud.financialservices.v1;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

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
import com.google.cloud.financialservices.v1.stub.AMLStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AMLClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (financialservices.googleapis.com) and default port (443) are
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
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AMLSettings.Builder aMLSettingsBuilder = AMLSettings.newBuilder();
 * aMLSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         aMLSettingsBuilder
 *             .getInstanceSettings()
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
 * AMLSettings aMLSettings = aMLSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AMLSettings.Builder aMLSettingsBuilder = AMLSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * aMLSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AMLSettings extends ClientSettings<AMLSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((AMLStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((AMLStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((AMLStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((AMLStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to importRegisteredParties. */
  public UnaryCallSettings<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesSettings() {
    return ((AMLStubSettings) getStubSettings()).importRegisteredPartiesSettings();
  }

  /** Returns the object with the settings used for calls to importRegisteredParties. */
  public OperationCallSettings<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).importRegisteredPartiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportRegisteredParties. */
  public UnaryCallSettings<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesSettings() {
    return ((AMLStubSettings) getStubSettings()).exportRegisteredPartiesSettings();
  }

  /** Returns the object with the settings used for calls to exportRegisteredParties. */
  public OperationCallSettings<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).exportRegisteredPartiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((AMLStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((AMLStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings() {
    return ((AMLStubSettings) getStubSettings()).createDatasetSettings();
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public OperationCallSettings<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings() {
    return ((AMLStubSettings) getStubSettings()).updateDatasetSettings();
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public OperationCallSettings<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updateDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public OperationCallSettings<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return ((AMLStubSettings) getStubSettings()).listModelsSettings();
  }

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return ((AMLStubSettings) getStubSettings()).getModelSettings();
  }

  /** Returns the object with the settings used for calls to createModel. */
  public UnaryCallSettings<CreateModelRequest, Operation> createModelSettings() {
    return ((AMLStubSettings) getStubSettings()).createModelSettings();
  }

  /** Returns the object with the settings used for calls to createModel. */
  public OperationCallSettings<CreateModelRequest, Model, OperationMetadata>
      createModelOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Operation> updateModelSettings() {
    return ((AMLStubSettings) getStubSettings()).updateModelSettings();
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public OperationCallSettings<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updateModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportModelMetadata. */
  public UnaryCallSettings<ExportModelMetadataRequest, Operation> exportModelMetadataSettings() {
    return ((AMLStubSettings) getStubSettings()).exportModelMetadataSettings();
  }

  /** Returns the object with the settings used for calls to exportModelMetadata. */
  public OperationCallSettings<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).exportModelMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public OperationCallSettings<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEngineConfigs. */
  public PagedCallSettings<
          ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
      listEngineConfigsSettings() {
    return ((AMLStubSettings) getStubSettings()).listEngineConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getEngineConfig. */
  public UnaryCallSettings<GetEngineConfigRequest, EngineConfig> getEngineConfigSettings() {
    return ((AMLStubSettings) getStubSettings()).getEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to createEngineConfig. */
  public UnaryCallSettings<CreateEngineConfigRequest, Operation> createEngineConfigSettings() {
    return ((AMLStubSettings) getStubSettings()).createEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to createEngineConfig. */
  public OperationCallSettings<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createEngineConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEngineConfig. */
  public UnaryCallSettings<UpdateEngineConfigRequest, Operation> updateEngineConfigSettings() {
    return ((AMLStubSettings) getStubSettings()).updateEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateEngineConfig. */
  public OperationCallSettings<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updateEngineConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportEngineConfigMetadata. */
  public UnaryCallSettings<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataSettings() {
    return ((AMLStubSettings) getStubSettings()).exportEngineConfigMetadataSettings();
  }

  /** Returns the object with the settings used for calls to exportEngineConfigMetadata. */
  public OperationCallSettings<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).exportEngineConfigMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEngineConfig. */
  public UnaryCallSettings<DeleteEngineConfigRequest, Operation> deleteEngineConfigSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteEngineConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteEngineConfig. */
  public OperationCallSettings<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteEngineConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getEngineVersion. */
  public UnaryCallSettings<GetEngineVersionRequest, EngineVersion> getEngineVersionSettings() {
    return ((AMLStubSettings) getStubSettings()).getEngineVersionSettings();
  }

  /** Returns the object with the settings used for calls to listEngineVersions. */
  public PagedCallSettings<
          ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
      listEngineVersionsSettings() {
    return ((AMLStubSettings) getStubSettings()).listEngineVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listPredictionResults. */
  public PagedCallSettings<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          ListPredictionResultsPagedResponse>
      listPredictionResultsSettings() {
    return ((AMLStubSettings) getStubSettings()).listPredictionResultsSettings();
  }

  /** Returns the object with the settings used for calls to getPredictionResult. */
  public UnaryCallSettings<GetPredictionResultRequest, PredictionResult>
      getPredictionResultSettings() {
    return ((AMLStubSettings) getStubSettings()).getPredictionResultSettings();
  }

  /** Returns the object with the settings used for calls to createPredictionResult. */
  public UnaryCallSettings<CreatePredictionResultRequest, Operation>
      createPredictionResultSettings() {
    return ((AMLStubSettings) getStubSettings()).createPredictionResultSettings();
  }

  /** Returns the object with the settings used for calls to createPredictionResult. */
  public OperationCallSettings<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createPredictionResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePredictionResult. */
  public UnaryCallSettings<UpdatePredictionResultRequest, Operation>
      updatePredictionResultSettings() {
    return ((AMLStubSettings) getStubSettings()).updatePredictionResultSettings();
  }

  /** Returns the object with the settings used for calls to updatePredictionResult. */
  public OperationCallSettings<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updatePredictionResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportPredictionResultMetadata. */
  public UnaryCallSettings<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataSettings() {
    return ((AMLStubSettings) getStubSettings()).exportPredictionResultMetadataSettings();
  }

  /** Returns the object with the settings used for calls to exportPredictionResultMetadata. */
  public OperationCallSettings<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).exportPredictionResultMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePredictionResult. */
  public UnaryCallSettings<DeletePredictionResultRequest, Operation>
      deletePredictionResultSettings() {
    return ((AMLStubSettings) getStubSettings()).deletePredictionResultSettings();
  }

  /** Returns the object with the settings used for calls to deletePredictionResult. */
  public OperationCallSettings<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deletePredictionResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBacktestResults. */
  public PagedCallSettings<
          ListBacktestResultsRequest, ListBacktestResultsResponse, ListBacktestResultsPagedResponse>
      listBacktestResultsSettings() {
    return ((AMLStubSettings) getStubSettings()).listBacktestResultsSettings();
  }

  /** Returns the object with the settings used for calls to getBacktestResult. */
  public UnaryCallSettings<GetBacktestResultRequest, BacktestResult> getBacktestResultSettings() {
    return ((AMLStubSettings) getStubSettings()).getBacktestResultSettings();
  }

  /** Returns the object with the settings used for calls to createBacktestResult. */
  public UnaryCallSettings<CreateBacktestResultRequest, Operation> createBacktestResultSettings() {
    return ((AMLStubSettings) getStubSettings()).createBacktestResultSettings();
  }

  /** Returns the object with the settings used for calls to createBacktestResult. */
  public OperationCallSettings<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).createBacktestResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBacktestResult. */
  public UnaryCallSettings<UpdateBacktestResultRequest, Operation> updateBacktestResultSettings() {
    return ((AMLStubSettings) getStubSettings()).updateBacktestResultSettings();
  }

  /** Returns the object with the settings used for calls to updateBacktestResult. */
  public OperationCallSettings<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).updateBacktestResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportBacktestResultMetadata. */
  public UnaryCallSettings<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataSettings() {
    return ((AMLStubSettings) getStubSettings()).exportBacktestResultMetadataSettings();
  }

  /** Returns the object with the settings used for calls to exportBacktestResultMetadata. */
  public OperationCallSettings<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).exportBacktestResultMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBacktestResult. */
  public UnaryCallSettings<DeleteBacktestResultRequest, Operation> deleteBacktestResultSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteBacktestResultSettings();
  }

  /** Returns the object with the settings used for calls to deleteBacktestResult. */
  public OperationCallSettings<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationSettings() {
    return ((AMLStubSettings) getStubSettings()).deleteBacktestResultOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AMLStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AMLStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AMLSettings create(AMLStubSettings stub) throws IOException {
    return new AMLSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AMLStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AMLStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AMLStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AMLStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AMLStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AMLStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AMLStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AMLStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AMLSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AMLSettings. */
  public static class Builder extends ClientSettings.Builder<AMLSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AMLStubSettings.newBuilder(clientContext));
    }

    protected Builder(AMLSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AMLStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AMLStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AMLStubSettings.newHttpJsonBuilder());
    }

    public AMLStubSettings.Builder getStubSettingsBuilder() {
      return ((AMLStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importRegisteredParties. */
    public UnaryCallSettings.Builder<ImportRegisteredPartiesRequest, Operation>
        importRegisteredPartiesSettings() {
      return getStubSettingsBuilder().importRegisteredPartiesSettings();
    }

    /** Returns the builder for the settings used for calls to importRegisteredParties. */
    public OperationCallSettings.Builder<
            ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
        importRegisteredPartiesOperationSettings() {
      return getStubSettingsBuilder().importRegisteredPartiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportRegisteredParties. */
    public UnaryCallSettings.Builder<ExportRegisteredPartiesRequest, Operation>
        exportRegisteredPartiesSettings() {
      return getStubSettingsBuilder().exportRegisteredPartiesSettings();
    }

    /** Returns the builder for the settings used for calls to exportRegisteredParties. */
    public OperationCallSettings.Builder<
            ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
        exportRegisteredPartiesOperationSettings() {
      return getStubSettingsBuilder().exportRegisteredPartiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return getStubSettingsBuilder().listDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getStubSettingsBuilder().getDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings() {
      return getStubSettingsBuilder().createDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public OperationCallSettings.Builder<CreateDatasetRequest, Dataset, OperationMetadata>
        createDatasetOperationSettings() {
      return getStubSettingsBuilder().createDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings() {
      return getStubSettingsBuilder().updateDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public OperationCallSettings.Builder<UpdateDatasetRequest, Dataset, OperationMetadata>
        updateDatasetOperationSettings() {
      return getStubSettingsBuilder().updateDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
      return getStubSettingsBuilder().deleteDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public OperationCallSettings.Builder<DeleteDatasetRequest, Empty, OperationMetadata>
        deleteDatasetOperationSettings() {
      return getStubSettingsBuilder().deleteDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return getStubSettingsBuilder().listModelsSettings();
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getStubSettingsBuilder().getModelSettings();
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings() {
      return getStubSettingsBuilder().createModelSettings();
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public OperationCallSettings.Builder<CreateModelRequest, Model, OperationMetadata>
        createModelOperationSettings() {
      return getStubSettingsBuilder().createModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Operation> updateModelSettings() {
      return getStubSettingsBuilder().updateModelSettings();
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public OperationCallSettings.Builder<UpdateModelRequest, Model, OperationMetadata>
        updateModelOperationSettings() {
      return getStubSettingsBuilder().updateModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportModelMetadata. */
    public UnaryCallSettings.Builder<ExportModelMetadataRequest, Operation>
        exportModelMetadataSettings() {
      return getStubSettingsBuilder().exportModelMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to exportModelMetadata. */
    public OperationCallSettings.Builder<
            ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
        exportModelMetadataOperationSettings() {
      return getStubSettingsBuilder().exportModelMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings() {
      return getStubSettingsBuilder().deleteModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public OperationCallSettings.Builder<DeleteModelRequest, Empty, OperationMetadata>
        deleteModelOperationSettings() {
      return getStubSettingsBuilder().deleteModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEngineConfigs. */
    public PagedCallSettings.Builder<
            ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
        listEngineConfigsSettings() {
      return getStubSettingsBuilder().listEngineConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getEngineConfig. */
    public UnaryCallSettings.Builder<GetEngineConfigRequest, EngineConfig>
        getEngineConfigSettings() {
      return getStubSettingsBuilder().getEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createEngineConfig. */
    public UnaryCallSettings.Builder<CreateEngineConfigRequest, Operation>
        createEngineConfigSettings() {
      return getStubSettingsBuilder().createEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createEngineConfig. */
    public OperationCallSettings.Builder<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
        createEngineConfigOperationSettings() {
      return getStubSettingsBuilder().createEngineConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEngineConfig. */
    public UnaryCallSettings.Builder<UpdateEngineConfigRequest, Operation>
        updateEngineConfigSettings() {
      return getStubSettingsBuilder().updateEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateEngineConfig. */
    public OperationCallSettings.Builder<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
        updateEngineConfigOperationSettings() {
      return getStubSettingsBuilder().updateEngineConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportEngineConfigMetadata. */
    public UnaryCallSettings.Builder<ExportEngineConfigMetadataRequest, Operation>
        exportEngineConfigMetadataSettings() {
      return getStubSettingsBuilder().exportEngineConfigMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to exportEngineConfigMetadata. */
    public OperationCallSettings.Builder<
            ExportEngineConfigMetadataRequest,
            ExportEngineConfigMetadataResponse,
            OperationMetadata>
        exportEngineConfigMetadataOperationSettings() {
      return getStubSettingsBuilder().exportEngineConfigMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEngineConfig. */
    public UnaryCallSettings.Builder<DeleteEngineConfigRequest, Operation>
        deleteEngineConfigSettings() {
      return getStubSettingsBuilder().deleteEngineConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEngineConfig. */
    public OperationCallSettings.Builder<DeleteEngineConfigRequest, Empty, OperationMetadata>
        deleteEngineConfigOperationSettings() {
      return getStubSettingsBuilder().deleteEngineConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getEngineVersion. */
    public UnaryCallSettings.Builder<GetEngineVersionRequest, EngineVersion>
        getEngineVersionSettings() {
      return getStubSettingsBuilder().getEngineVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listEngineVersions. */
    public PagedCallSettings.Builder<
            ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
        listEngineVersionsSettings() {
      return getStubSettingsBuilder().listEngineVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listPredictionResults. */
    public PagedCallSettings.Builder<
            ListPredictionResultsRequest,
            ListPredictionResultsResponse,
            ListPredictionResultsPagedResponse>
        listPredictionResultsSettings() {
      return getStubSettingsBuilder().listPredictionResultsSettings();
    }

    /** Returns the builder for the settings used for calls to getPredictionResult. */
    public UnaryCallSettings.Builder<GetPredictionResultRequest, PredictionResult>
        getPredictionResultSettings() {
      return getStubSettingsBuilder().getPredictionResultSettings();
    }

    /** Returns the builder for the settings used for calls to createPredictionResult. */
    public UnaryCallSettings.Builder<CreatePredictionResultRequest, Operation>
        createPredictionResultSettings() {
      return getStubSettingsBuilder().createPredictionResultSettings();
    }

    /** Returns the builder for the settings used for calls to createPredictionResult. */
    public OperationCallSettings.Builder<
            CreatePredictionResultRequest, PredictionResult, OperationMetadata>
        createPredictionResultOperationSettings() {
      return getStubSettingsBuilder().createPredictionResultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePredictionResult. */
    public UnaryCallSettings.Builder<UpdatePredictionResultRequest, Operation>
        updatePredictionResultSettings() {
      return getStubSettingsBuilder().updatePredictionResultSettings();
    }

    /** Returns the builder for the settings used for calls to updatePredictionResult. */
    public OperationCallSettings.Builder<
            UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
        updatePredictionResultOperationSettings() {
      return getStubSettingsBuilder().updatePredictionResultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportPredictionResultMetadata. */
    public UnaryCallSettings.Builder<ExportPredictionResultMetadataRequest, Operation>
        exportPredictionResultMetadataSettings() {
      return getStubSettingsBuilder().exportPredictionResultMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to exportPredictionResultMetadata. */
    public OperationCallSettings.Builder<
            ExportPredictionResultMetadataRequest,
            ExportPredictionResultMetadataResponse,
            OperationMetadata>
        exportPredictionResultMetadataOperationSettings() {
      return getStubSettingsBuilder().exportPredictionResultMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePredictionResult. */
    public UnaryCallSettings.Builder<DeletePredictionResultRequest, Operation>
        deletePredictionResultSettings() {
      return getStubSettingsBuilder().deletePredictionResultSettings();
    }

    /** Returns the builder for the settings used for calls to deletePredictionResult. */
    public OperationCallSettings.Builder<DeletePredictionResultRequest, Empty, OperationMetadata>
        deletePredictionResultOperationSettings() {
      return getStubSettingsBuilder().deletePredictionResultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBacktestResults. */
    public PagedCallSettings.Builder<
            ListBacktestResultsRequest,
            ListBacktestResultsResponse,
            ListBacktestResultsPagedResponse>
        listBacktestResultsSettings() {
      return getStubSettingsBuilder().listBacktestResultsSettings();
    }

    /** Returns the builder for the settings used for calls to getBacktestResult. */
    public UnaryCallSettings.Builder<GetBacktestResultRequest, BacktestResult>
        getBacktestResultSettings() {
      return getStubSettingsBuilder().getBacktestResultSettings();
    }

    /** Returns the builder for the settings used for calls to createBacktestResult. */
    public UnaryCallSettings.Builder<CreateBacktestResultRequest, Operation>
        createBacktestResultSettings() {
      return getStubSettingsBuilder().createBacktestResultSettings();
    }

    /** Returns the builder for the settings used for calls to createBacktestResult. */
    public OperationCallSettings.Builder<
            CreateBacktestResultRequest, BacktestResult, OperationMetadata>
        createBacktestResultOperationSettings() {
      return getStubSettingsBuilder().createBacktestResultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBacktestResult. */
    public UnaryCallSettings.Builder<UpdateBacktestResultRequest, Operation>
        updateBacktestResultSettings() {
      return getStubSettingsBuilder().updateBacktestResultSettings();
    }

    /** Returns the builder for the settings used for calls to updateBacktestResult. */
    public OperationCallSettings.Builder<
            UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
        updateBacktestResultOperationSettings() {
      return getStubSettingsBuilder().updateBacktestResultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportBacktestResultMetadata. */
    public UnaryCallSettings.Builder<ExportBacktestResultMetadataRequest, Operation>
        exportBacktestResultMetadataSettings() {
      return getStubSettingsBuilder().exportBacktestResultMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to exportBacktestResultMetadata. */
    public OperationCallSettings.Builder<
            ExportBacktestResultMetadataRequest,
            ExportBacktestResultMetadataResponse,
            OperationMetadata>
        exportBacktestResultMetadataOperationSettings() {
      return getStubSettingsBuilder().exportBacktestResultMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBacktestResult. */
    public UnaryCallSettings.Builder<DeleteBacktestResultRequest, Operation>
        deleteBacktestResultSettings() {
      return getStubSettingsBuilder().deleteBacktestResultSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBacktestResult. */
    public OperationCallSettings.Builder<DeleteBacktestResultRequest, Empty, OperationMetadata>
        deleteBacktestResultOperationSettings() {
      return getStubSettingsBuilder().deleteBacktestResultOperationSettings();
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
    public AMLSettings build() throws IOException {
      return new AMLSettings(this);
    }
  }
}
