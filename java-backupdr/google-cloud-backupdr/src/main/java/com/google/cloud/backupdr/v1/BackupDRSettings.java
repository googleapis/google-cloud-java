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

package com.google.cloud.backupdr.v1;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

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
import com.google.cloud.backupdr.v1.stub.BackupDRStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackupDRClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (backupdr.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getManagementServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupDRSettings.Builder backupDRSettingsBuilder = BackupDRSettings.newBuilder();
 * backupDRSettingsBuilder
 *     .getManagementServerSettings()
 *     .setRetrySettings(
 *         backupDRSettingsBuilder
 *             .getManagementServerSettings()
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
 * BackupDRSettings backupDRSettings = backupDRSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createManagementServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupDRSettings.Builder backupDRSettingsBuilder = BackupDRSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * backupDRSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackupDRSettings extends ClientSettings<BackupDRSettings> {

  /** Returns the object with the settings used for calls to listManagementServers. */
  public PagedCallSettings<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ListManagementServersPagedResponse>
      listManagementServersSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listManagementServersSettings();
  }

  /** Returns the object with the settings used for calls to getManagementServer. */
  public UnaryCallSettings<GetManagementServerRequest, ManagementServer>
      getManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public UnaryCallSettings<CreateManagementServerRequest, Operation>
      createManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public OperationCallSettings<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createManagementServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public UnaryCallSettings<DeleteManagementServerRequest, Operation>
      deleteManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public OperationCallSettings<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteManagementServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackupVaults. */
  public PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listBackupVaultsSettings();
  }

  /** Returns the object with the settings used for calls to fetchUsableBackupVaults. */
  public PagedCallSettings<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).fetchUsableBackupVaultsSettings();
  }

  /** Returns the object with the settings used for calls to getBackupVault. */
  public UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDataSources. */
  public PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listDataSourcesSettings();
  }

  /** Returns the object with the settings used for calls to getDataSource. */
  public UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public UnaryCallSettings<UpdateDataSourceRequest, Operation> updateDataSourceSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public OperationCallSettings<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateDataSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).updateBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public UnaryCallSettings<RestoreBackupRequest, Operation> restoreBackupSettings() {
    return ((BackupDRStubSettings) getStubSettings()).restoreBackupSettings();
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public OperationCallSettings<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).restoreBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createBackupPlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackupPlan. */
  public UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to listBackupPlans. */
  public PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listBackupPlansSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public UnaryCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public OperationCallSettings<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupPlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPlanAssociation. */
  public UnaryCallSettings<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createBackupPlanAssociationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPlanAssociation. */
  public OperationCallSettings<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings())
        .createBackupPlanAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackupPlanAssociation. */
  public UnaryCallSettings<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getBackupPlanAssociationSettings();
  }

  /** Returns the object with the settings used for calls to listBackupPlanAssociations. */
  public PagedCallSettings<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listBackupPlanAssociationsSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlanAssociation. */
  public UnaryCallSettings<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteBackupPlanAssociationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlanAssociation. */
  public OperationCallSettings<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings())
        .deleteBackupPlanAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to triggerBackup. */
  public UnaryCallSettings<TriggerBackupRequest, Operation> triggerBackupSettings() {
    return ((BackupDRStubSettings) getStubSettings()).triggerBackupSettings();
  }

  /** Returns the object with the settings used for calls to triggerBackup. */
  public OperationCallSettings<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).triggerBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to initializeService. */
  public UnaryCallSettings<InitializeServiceRequest, Operation> initializeServiceSettings() {
    return ((BackupDRStubSettings) getStubSettings()).initializeServiceSettings();
  }

  /** Returns the object with the settings used for calls to initializeService. */
  public OperationCallSettings<
          InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).initializeServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((BackupDRStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((BackupDRStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final BackupDRSettings create(BackupDRStubSettings stub) throws IOException {
    return new BackupDRSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BackupDRStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BackupDRStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BackupDRStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BackupDRStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BackupDRStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BackupDRStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BackupDRStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackupDRStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BackupDRSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BackupDRSettings. */
  public static class Builder extends ClientSettings.Builder<BackupDRSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BackupDRStubSettings.newBuilder(clientContext));
    }

    protected Builder(BackupDRSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BackupDRStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BackupDRStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(BackupDRStubSettings.newHttpJsonBuilder());
    }

    public BackupDRStubSettings.Builder getStubSettingsBuilder() {
      return ((BackupDRStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listManagementServers. */
    public PagedCallSettings.Builder<
            ListManagementServersRequest,
            ListManagementServersResponse,
            ListManagementServersPagedResponse>
        listManagementServersSettings() {
      return getStubSettingsBuilder().listManagementServersSettings();
    }

    /** Returns the builder for the settings used for calls to getManagementServer. */
    public UnaryCallSettings.Builder<GetManagementServerRequest, ManagementServer>
        getManagementServerSettings() {
      return getStubSettingsBuilder().getManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public UnaryCallSettings.Builder<CreateManagementServerRequest, Operation>
        createManagementServerSettings() {
      return getStubSettingsBuilder().createManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public OperationCallSettings.Builder<
            CreateManagementServerRequest, ManagementServer, OperationMetadata>
        createManagementServerOperationSettings() {
      return getStubSettingsBuilder().createManagementServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public UnaryCallSettings.Builder<DeleteManagementServerRequest, Operation>
        deleteManagementServerSettings() {
      return getStubSettingsBuilder().deleteManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public OperationCallSettings.Builder<DeleteManagementServerRequest, Empty, OperationMetadata>
        deleteManagementServerOperationSettings() {
      return getStubSettingsBuilder().deleteManagementServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings() {
      return getStubSettingsBuilder().createBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public OperationCallSettings.Builder<CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings() {
      return getStubSettingsBuilder().createBackupVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupVaults. */
    public PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings() {
      return getStubSettingsBuilder().listBackupVaultsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchUsableBackupVaults. */
    public PagedCallSettings.Builder<
            FetchUsableBackupVaultsRequest,
            FetchUsableBackupVaultsResponse,
            FetchUsableBackupVaultsPagedResponse>
        fetchUsableBackupVaultsSettings() {
      return getStubSettingsBuilder().fetchUsableBackupVaultsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupVault. */
    public UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
      return getStubSettingsBuilder().getBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings() {
      return getStubSettingsBuilder().updateBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public OperationCallSettings.Builder<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings() {
      return getStubSettingsBuilder().updateBackupVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings() {
      return getStubSettingsBuilder().deleteBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings() {
      return getStubSettingsBuilder().deleteBackupVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDataSources. */
    public PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings() {
      return getStubSettingsBuilder().listDataSourcesSettings();
    }

    /** Returns the builder for the settings used for calls to getDataSource. */
    public UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings() {
      return getStubSettingsBuilder().getDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public UnaryCallSettings.Builder<UpdateDataSourceRequest, Operation>
        updateDataSourceSettings() {
      return getStubSettingsBuilder().updateDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public OperationCallSettings.Builder<UpdateDataSourceRequest, DataSource, OperationMetadata>
        updateDataSourceOperationSettings() {
      return getStubSettingsBuilder().updateDataSourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings() {
      return getStubSettingsBuilder().updateBackupSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings() {
      return getStubSettingsBuilder().updateBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Backup, OperationMetadata>
        deleteBackupOperationSettings() {
      return getStubSettingsBuilder().deleteBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public UnaryCallSettings.Builder<RestoreBackupRequest, Operation> restoreBackupSettings() {
      return getStubSettingsBuilder().restoreBackupSettings();
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public OperationCallSettings.Builder<
            RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
        restoreBackupOperationSettings() {
      return getStubSettingsBuilder().restoreBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPlan. */
    public UnaryCallSettings.Builder<CreateBackupPlanRequest, Operation>
        createBackupPlanSettings() {
      return getStubSettingsBuilder().createBackupPlanSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPlan. */
    public OperationCallSettings.Builder<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
        createBackupPlanOperationSettings() {
      return getStubSettingsBuilder().createBackupPlanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupPlan. */
    public UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
      return getStubSettingsBuilder().getBackupPlanSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupPlans. */
    public PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings() {
      return getStubSettingsBuilder().listBackupPlansSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlan. */
    public UnaryCallSettings.Builder<DeleteBackupPlanRequest, Operation>
        deleteBackupPlanSettings() {
      return getStubSettingsBuilder().deleteBackupPlanSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlan. */
    public OperationCallSettings.Builder<DeleteBackupPlanRequest, Empty, OperationMetadata>
        deleteBackupPlanOperationSettings() {
      return getStubSettingsBuilder().deleteBackupPlanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPlanAssociation. */
    public UnaryCallSettings.Builder<CreateBackupPlanAssociationRequest, Operation>
        createBackupPlanAssociationSettings() {
      return getStubSettingsBuilder().createBackupPlanAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPlanAssociation. */
    public OperationCallSettings.Builder<
            CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
        createBackupPlanAssociationOperationSettings() {
      return getStubSettingsBuilder().createBackupPlanAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupPlanAssociation. */
    public UnaryCallSettings.Builder<GetBackupPlanAssociationRequest, BackupPlanAssociation>
        getBackupPlanAssociationSettings() {
      return getStubSettingsBuilder().getBackupPlanAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupPlanAssociations. */
    public PagedCallSettings.Builder<
            ListBackupPlanAssociationsRequest,
            ListBackupPlanAssociationsResponse,
            ListBackupPlanAssociationsPagedResponse>
        listBackupPlanAssociationsSettings() {
      return getStubSettingsBuilder().listBackupPlanAssociationsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlanAssociation. */
    public UnaryCallSettings.Builder<DeleteBackupPlanAssociationRequest, Operation>
        deleteBackupPlanAssociationSettings() {
      return getStubSettingsBuilder().deleteBackupPlanAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlanAssociation. */
    public OperationCallSettings.Builder<
            DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
        deleteBackupPlanAssociationOperationSettings() {
      return getStubSettingsBuilder().deleteBackupPlanAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to triggerBackup. */
    public UnaryCallSettings.Builder<TriggerBackupRequest, Operation> triggerBackupSettings() {
      return getStubSettingsBuilder().triggerBackupSettings();
    }

    /** Returns the builder for the settings used for calls to triggerBackup. */
    public OperationCallSettings.Builder<
            TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
        triggerBackupOperationSettings() {
      return getStubSettingsBuilder().triggerBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to initializeService. */
    public UnaryCallSettings.Builder<InitializeServiceRequest, Operation>
        initializeServiceSettings() {
      return getStubSettingsBuilder().initializeServiceSettings();
    }

    /** Returns the builder for the settings used for calls to initializeService. */
    public OperationCallSettings.Builder<
            InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
        initializeServiceOperationSettings() {
      return getStubSettingsBuilder().initializeServiceOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public BackupDRSettings build() throws IOException {
      return new BackupDRSettings(this);
    }
  }
}
