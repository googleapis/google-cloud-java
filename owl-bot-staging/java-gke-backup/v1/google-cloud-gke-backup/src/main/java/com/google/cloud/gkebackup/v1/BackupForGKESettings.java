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

package com.google.cloud.gkebackup.v1;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

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
import com.google.cloud.gkebackup.v1.stub.BackupForGKEStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackupForGKEClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkebackup.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBackupPlan to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupForGKESettings.Builder backupForGKESettingsBuilder = BackupForGKESettings.newBuilder();
 * backupForGKESettingsBuilder
 *     .getBackupPlanSettings()
 *     .setRetrySettings(
 *         backupForGKESettingsBuilder
 *             .getBackupPlanSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BackupForGKESettings backupForGKESettings = backupForGKESettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackupForGKESettings extends ClientSettings<BackupForGKESettings> {

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createBackupPlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackupPlans. */
  public PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listBackupPlansSettings();
  }

  /** Returns the object with the settings used for calls to getBackupPlan. */
  public UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupPlan. */
  public UnaryCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupPlan. */
  public OperationCallSettings<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateBackupPlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public UnaryCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteBackupPlanSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public OperationCallSettings<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteBackupPlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVolumeBackups. */
  public PagedCallSettings<
          ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
      listVolumeBackupsSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listVolumeBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getVolumeBackup. */
  public UnaryCallSettings<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getVolumeBackupSettings();
  }

  /** Returns the object with the settings used for calls to createRestorePlan. */
  public UnaryCallSettings<CreateRestorePlanRequest, Operation> createRestorePlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createRestorePlanSettings();
  }

  /** Returns the object with the settings used for calls to createRestorePlan. */
  public OperationCallSettings<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createRestorePlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRestorePlans. */
  public PagedCallSettings<
          ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
      listRestorePlansSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listRestorePlansSettings();
  }

  /** Returns the object with the settings used for calls to getRestorePlan. */
  public UnaryCallSettings<GetRestorePlanRequest, RestorePlan> getRestorePlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getRestorePlanSettings();
  }

  /** Returns the object with the settings used for calls to updateRestorePlan. */
  public UnaryCallSettings<UpdateRestorePlanRequest, Operation> updateRestorePlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateRestorePlanSettings();
  }

  /** Returns the object with the settings used for calls to updateRestorePlan. */
  public OperationCallSettings<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateRestorePlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRestorePlan. */
  public UnaryCallSettings<DeleteRestorePlanRequest, Operation> deleteRestorePlanSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteRestorePlanSettings();
  }

  /** Returns the object with the settings used for calls to deleteRestorePlan. */
  public OperationCallSettings<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteRestorePlanOperationSettings();
  }

  /** Returns the object with the settings used for calls to createRestore. */
  public UnaryCallSettings<CreateRestoreRequest, Operation> createRestoreSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createRestoreSettings();
  }

  /** Returns the object with the settings used for calls to createRestore. */
  public OperationCallSettings<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).createRestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRestores. */
  public PagedCallSettings<ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
      listRestoresSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listRestoresSettings();
  }

  /** Returns the object with the settings used for calls to getRestore. */
  public UnaryCallSettings<GetRestoreRequest, Restore> getRestoreSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getRestoreSettings();
  }

  /** Returns the object with the settings used for calls to updateRestore. */
  public UnaryCallSettings<UpdateRestoreRequest, Operation> updateRestoreSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateRestoreSettings();
  }

  /** Returns the object with the settings used for calls to updateRestore. */
  public OperationCallSettings<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).updateRestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRestore. */
  public UnaryCallSettings<DeleteRestoreRequest, Operation> deleteRestoreSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteRestoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteRestore. */
  public OperationCallSettings<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).deleteRestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVolumeRestores. */
  public PagedCallSettings<
          ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
      listVolumeRestoresSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).listVolumeRestoresSettings();
  }

  /** Returns the object with the settings used for calls to getVolumeRestore. */
  public UnaryCallSettings<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreSettings() {
    return ((BackupForGKEStubSettings) getStubSettings()).getVolumeRestoreSettings();
  }

  public static final BackupForGKESettings create(BackupForGKEStubSettings stub)
      throws IOException {
    return new BackupForGKESettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BackupForGKEStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BackupForGKEStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BackupForGKEStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BackupForGKEStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BackupForGKEStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BackupForGKEStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BackupForGKEStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackupForGKEStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BackupForGKESettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BackupForGKESettings. */
  public static class Builder extends ClientSettings.Builder<BackupForGKESettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BackupForGKEStubSettings.newBuilder(clientContext));
    }

    protected Builder(BackupForGKESettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BackupForGKEStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BackupForGKEStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(BackupForGKEStubSettings.newHttpJsonBuilder());
    }

    public BackupForGKEStubSettings.Builder getStubSettingsBuilder() {
      return ((BackupForGKEStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listBackupPlans. */
    public PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings() {
      return getStubSettingsBuilder().listBackupPlansSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupPlan. */
    public UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
      return getStubSettingsBuilder().getBackupPlanSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupPlan. */
    public UnaryCallSettings.Builder<UpdateBackupPlanRequest, Operation>
        updateBackupPlanSettings() {
      return getStubSettingsBuilder().updateBackupPlanSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupPlan. */
    public OperationCallSettings.Builder<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
        updateBackupPlanOperationSettings() {
      return getStubSettingsBuilder().updateBackupPlanOperationSettings();
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

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return getStubSettingsBuilder().createBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return getStubSettingsBuilder().createBackupOperationSettings();
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
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return getStubSettingsBuilder().deleteBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVolumeBackups. */
    public PagedCallSettings.Builder<
            ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
        listVolumeBackupsSettings() {
      return getStubSettingsBuilder().listVolumeBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to getVolumeBackup. */
    public UnaryCallSettings.Builder<GetVolumeBackupRequest, VolumeBackup>
        getVolumeBackupSettings() {
      return getStubSettingsBuilder().getVolumeBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createRestorePlan. */
    public UnaryCallSettings.Builder<CreateRestorePlanRequest, Operation>
        createRestorePlanSettings() {
      return getStubSettingsBuilder().createRestorePlanSettings();
    }

    /** Returns the builder for the settings used for calls to createRestorePlan. */
    public OperationCallSettings.Builder<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
        createRestorePlanOperationSettings() {
      return getStubSettingsBuilder().createRestorePlanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRestorePlans. */
    public PagedCallSettings.Builder<
            ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
        listRestorePlansSettings() {
      return getStubSettingsBuilder().listRestorePlansSettings();
    }

    /** Returns the builder for the settings used for calls to getRestorePlan. */
    public UnaryCallSettings.Builder<GetRestorePlanRequest, RestorePlan> getRestorePlanSettings() {
      return getStubSettingsBuilder().getRestorePlanSettings();
    }

    /** Returns the builder for the settings used for calls to updateRestorePlan. */
    public UnaryCallSettings.Builder<UpdateRestorePlanRequest, Operation>
        updateRestorePlanSettings() {
      return getStubSettingsBuilder().updateRestorePlanSettings();
    }

    /** Returns the builder for the settings used for calls to updateRestorePlan. */
    public OperationCallSettings.Builder<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
        updateRestorePlanOperationSettings() {
      return getStubSettingsBuilder().updateRestorePlanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRestorePlan. */
    public UnaryCallSettings.Builder<DeleteRestorePlanRequest, Operation>
        deleteRestorePlanSettings() {
      return getStubSettingsBuilder().deleteRestorePlanSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRestorePlan. */
    public OperationCallSettings.Builder<DeleteRestorePlanRequest, Empty, OperationMetadata>
        deleteRestorePlanOperationSettings() {
      return getStubSettingsBuilder().deleteRestorePlanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createRestore. */
    public UnaryCallSettings.Builder<CreateRestoreRequest, Operation> createRestoreSettings() {
      return getStubSettingsBuilder().createRestoreSettings();
    }

    /** Returns the builder for the settings used for calls to createRestore. */
    public OperationCallSettings.Builder<CreateRestoreRequest, Restore, OperationMetadata>
        createRestoreOperationSettings() {
      return getStubSettingsBuilder().createRestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRestores. */
    public PagedCallSettings.Builder<
            ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
        listRestoresSettings() {
      return getStubSettingsBuilder().listRestoresSettings();
    }

    /** Returns the builder for the settings used for calls to getRestore. */
    public UnaryCallSettings.Builder<GetRestoreRequest, Restore> getRestoreSettings() {
      return getStubSettingsBuilder().getRestoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateRestore. */
    public UnaryCallSettings.Builder<UpdateRestoreRequest, Operation> updateRestoreSettings() {
      return getStubSettingsBuilder().updateRestoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateRestore. */
    public OperationCallSettings.Builder<UpdateRestoreRequest, Restore, OperationMetadata>
        updateRestoreOperationSettings() {
      return getStubSettingsBuilder().updateRestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRestore. */
    public UnaryCallSettings.Builder<DeleteRestoreRequest, Operation> deleteRestoreSettings() {
      return getStubSettingsBuilder().deleteRestoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRestore. */
    public OperationCallSettings.Builder<DeleteRestoreRequest, Empty, OperationMetadata>
        deleteRestoreOperationSettings() {
      return getStubSettingsBuilder().deleteRestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVolumeRestores. */
    public PagedCallSettings.Builder<
            ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
        listVolumeRestoresSettings() {
      return getStubSettingsBuilder().listVolumeRestoresSettings();
    }

    /** Returns the builder for the settings used for calls to getVolumeRestore. */
    public UnaryCallSettings.Builder<GetVolumeRestoreRequest, VolumeRestore>
        getVolumeRestoreSettings() {
      return getStubSettingsBuilder().getVolumeRestoreSettings();
    }

    @Override
    public BackupForGKESettings build() throws IOException {
      return new BackupForGKESettings(this);
    }
  }
}
