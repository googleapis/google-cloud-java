/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakeActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakesPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListSessionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListTasksPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZoneActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZonesPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataplex.v1.stub.DataplexServiceStubSettings;
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
 * Settings class to configure an instance of {@link DataplexServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLake to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataplexServiceSettings.Builder dataplexServiceSettingsBuilder =
 *     DataplexServiceSettings.newBuilder();
 * dataplexServiceSettingsBuilder
 *     .getLakeSettings()
 *     .setRetrySettings(
 *         dataplexServiceSettingsBuilder
 *             .getLakeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataplexServiceSettings dataplexServiceSettings = dataplexServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataplexServiceSettings extends ClientSettings<DataplexServiceSettings> {

  /** Returns the object with the settings used for calls to createLake. */
  public UnaryCallSettings<CreateLakeRequest, Operation> createLakeSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createLakeSettings();
  }

  /** Returns the object with the settings used for calls to createLake. */
  public OperationCallSettings<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createLakeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLake. */
  public UnaryCallSettings<UpdateLakeRequest, Operation> updateLakeSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateLakeSettings();
  }

  /** Returns the object with the settings used for calls to updateLake. */
  public OperationCallSettings<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateLakeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLake. */
  public UnaryCallSettings<DeleteLakeRequest, Operation> deleteLakeSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteLakeSettings();
  }

  /** Returns the object with the settings used for calls to deleteLake. */
  public OperationCallSettings<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteLakeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLakes. */
  public PagedCallSettings<ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
      listLakesSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listLakesSettings();
  }

  /** Returns the object with the settings used for calls to getLake. */
  public UnaryCallSettings<GetLakeRequest, Lake> getLakeSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getLakeSettings();
  }

  /** Returns the object with the settings used for calls to listLakeActions. */
  public PagedCallSettings<
          ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
      listLakeActionsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listLakeActionsSettings();
  }

  /** Returns the object with the settings used for calls to createZone. */
  public UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createZoneSettings();
  }

  /** Returns the object with the settings used for calls to createZone. */
  public OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateZoneSettings();
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteZoneSettings();
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteZoneOperationSettings();
  }

  /** Returns the object with the settings used for calls to listZones. */
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listZonesSettings();
  }

  /** Returns the object with the settings used for calls to getZone. */
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getZoneSettings();
  }

  /** Returns the object with the settings used for calls to listZoneActions. */
  public PagedCallSettings<
          ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
      listZoneActionsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listZoneActionsSettings();
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public UnaryCallSettings<CreateAssetRequest, Operation> createAssetSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createAssetSettings();
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public OperationCallSettings<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Operation> updateAssetSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateAssetSettings();
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public OperationCallSettings<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteAssetSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public OperationCallSettings<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listAssetsSettings();
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getAssetSettings();
  }

  /** Returns the object with the settings used for calls to listAssetActions. */
  public PagedCallSettings<
          ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
      listAssetActionsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listAssetActionsSettings();
  }

  /** Returns the object with the settings used for calls to createTask. */
  public UnaryCallSettings<CreateTaskRequest, Operation> createTaskSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createTaskSettings();
  }

  /** Returns the object with the settings used for calls to createTask. */
  public OperationCallSettings<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createTaskOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public UnaryCallSettings<UpdateTaskRequest, Operation> updateTaskSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateTaskSettings();
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public OperationCallSettings<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateTaskOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTask. */
  public UnaryCallSettings<DeleteTaskRequest, Operation> deleteTaskSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteTaskSettings();
  }

  /** Returns the object with the settings used for calls to deleteTask. */
  public OperationCallSettings<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteTaskOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listTasksSettings();
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getTaskSettings();
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listJobsSettings();
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getJobSettings();
  }

  /** Returns the object with the settings used for calls to cancelJob. */
  public UnaryCallSettings<CancelJobRequest, Empty> cancelJobSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).cancelJobSettings();
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).createEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).updateEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).deleteEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listEnvironmentsSettings();
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listSessionsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataplexServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DataplexServiceSettings create(DataplexServiceStubSettings stub)
      throws IOException {
    return new DataplexServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataplexServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataplexServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataplexServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataplexServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataplexServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataplexServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataplexServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataplexServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DataplexServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataplexServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataplexServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataplexServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataplexServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataplexServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataplexServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataplexServiceStubSettings.newHttpJsonBuilder());
    }

    public DataplexServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataplexServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createLake. */
    public UnaryCallSettings.Builder<CreateLakeRequest, Operation> createLakeSettings() {
      return getStubSettingsBuilder().createLakeSettings();
    }

    /** Returns the builder for the settings used for calls to createLake. */
    public OperationCallSettings.Builder<CreateLakeRequest, Lake, OperationMetadata>
        createLakeOperationSettings() {
      return getStubSettingsBuilder().createLakeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLake. */
    public UnaryCallSettings.Builder<UpdateLakeRequest, Operation> updateLakeSettings() {
      return getStubSettingsBuilder().updateLakeSettings();
    }

    /** Returns the builder for the settings used for calls to updateLake. */
    public OperationCallSettings.Builder<UpdateLakeRequest, Lake, OperationMetadata>
        updateLakeOperationSettings() {
      return getStubSettingsBuilder().updateLakeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLake. */
    public UnaryCallSettings.Builder<DeleteLakeRequest, Operation> deleteLakeSettings() {
      return getStubSettingsBuilder().deleteLakeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLake. */
    public OperationCallSettings.Builder<DeleteLakeRequest, Empty, OperationMetadata>
        deleteLakeOperationSettings() {
      return getStubSettingsBuilder().deleteLakeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLakes. */
    public PagedCallSettings.Builder<ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
        listLakesSettings() {
      return getStubSettingsBuilder().listLakesSettings();
    }

    /** Returns the builder for the settings used for calls to getLake. */
    public UnaryCallSettings.Builder<GetLakeRequest, Lake> getLakeSettings() {
      return getStubSettingsBuilder().getLakeSettings();
    }

    /** Returns the builder for the settings used for calls to listLakeActions. */
    public PagedCallSettings.Builder<
            ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
        listLakeActionsSettings() {
      return getStubSettingsBuilder().listLakeActionsSettings();
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings() {
      return getStubSettingsBuilder().createZoneSettings();
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings() {
      return getStubSettingsBuilder().createZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings() {
      return getStubSettingsBuilder().updateZoneSettings();
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings() {
      return getStubSettingsBuilder().updateZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings() {
      return getStubSettingsBuilder().deleteZoneSettings();
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings() {
      return getStubSettingsBuilder().deleteZoneOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listZones. */
    public PagedCallSettings.Builder<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings() {
      return getStubSettingsBuilder().listZonesSettings();
    }

    /** Returns the builder for the settings used for calls to getZone. */
    public UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings() {
      return getStubSettingsBuilder().getZoneSettings();
    }

    /** Returns the builder for the settings used for calls to listZoneActions. */
    public PagedCallSettings.Builder<
            ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
        listZoneActionsSettings() {
      return getStubSettingsBuilder().listZoneActionsSettings();
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public UnaryCallSettings.Builder<CreateAssetRequest, Operation> createAssetSettings() {
      return getStubSettingsBuilder().createAssetSettings();
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public OperationCallSettings.Builder<CreateAssetRequest, Asset, OperationMetadata>
        createAssetOperationSettings() {
      return getStubSettingsBuilder().createAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Operation> updateAssetSettings() {
      return getStubSettingsBuilder().updateAssetSettings();
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public OperationCallSettings.Builder<UpdateAssetRequest, Asset, OperationMetadata>
        updateAssetOperationSettings() {
      return getStubSettingsBuilder().updateAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings() {
      return getStubSettingsBuilder().deleteAssetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public OperationCallSettings.Builder<DeleteAssetRequest, Empty, OperationMetadata>
        deleteAssetOperationSettings() {
      return getStubSettingsBuilder().deleteAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return getStubSettingsBuilder().listAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getStubSettingsBuilder().getAssetSettings();
    }

    /** Returns the builder for the settings used for calls to listAssetActions. */
    public PagedCallSettings.Builder<
            ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
        listAssetActionsSettings() {
      return getStubSettingsBuilder().listAssetActionsSettings();
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public UnaryCallSettings.Builder<CreateTaskRequest, Operation> createTaskSettings() {
      return getStubSettingsBuilder().createTaskSettings();
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public OperationCallSettings.Builder<CreateTaskRequest, Task, OperationMetadata>
        createTaskOperationSettings() {
      return getStubSettingsBuilder().createTaskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    public UnaryCallSettings.Builder<UpdateTaskRequest, Operation> updateTaskSettings() {
      return getStubSettingsBuilder().updateTaskSettings();
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    public OperationCallSettings.Builder<UpdateTaskRequest, Task, OperationMetadata>
        updateTaskOperationSettings() {
      return getStubSettingsBuilder().updateTaskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTask. */
    public UnaryCallSettings.Builder<DeleteTaskRequest, Operation> deleteTaskSettings() {
      return getStubSettingsBuilder().deleteTaskSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTask. */
    public OperationCallSettings.Builder<DeleteTaskRequest, Empty, OperationMetadata>
        deleteTaskOperationSettings() {
      return getStubSettingsBuilder().deleteTaskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return getStubSettingsBuilder().listTasksSettings();
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getStubSettingsBuilder().getTaskSettings();
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return getStubSettingsBuilder().listJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getStubSettingsBuilder().getJobSettings();
    }

    /** Returns the builder for the settings used for calls to cancelJob. */
    public UnaryCallSettings.Builder<CancelJobRequest, Empty> cancelJobSettings() {
      return getStubSettingsBuilder().cancelJobSettings();
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return getStubSettingsBuilder().createEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return getStubSettingsBuilder().createEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings() {
      return getStubSettingsBuilder().updateEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings() {
      return getStubSettingsBuilder().updateEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return getStubSettingsBuilder().deleteEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return getStubSettingsBuilder().deleteEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return getStubSettingsBuilder().listEnvironmentsSettings();
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getStubSettingsBuilder().getEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return getStubSettingsBuilder().listSessionsSettings();
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
    public DataplexServiceSettings build() throws IOException {
      return new DataplexServiceSettings(this);
    }
  }
}
